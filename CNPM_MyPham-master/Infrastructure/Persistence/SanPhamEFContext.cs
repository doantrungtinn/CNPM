using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Dynamic.Core;
using System.Linq.Expressions;
using Domain.Entities;
using Domain.Interfaces;

namespace Infrastructure.Persistence
{
    public class SanPhamEFContext : ISanPhamEFContext
    {
        private readonly MyphamDbContext context;

        public SanPhamEFContext(MyphamDbContext context){
            this.context = context;
        }

        public List<SanPham> SanPham_GetAll(){
            return context.SanPhams.ToList();
        }

        public List<SanPham> SanPham_Shop_GetAll()
        {
            var query = context.SanPhams.AsQueryable();
            query = query.Where(m => m.status == 1);
            return query.ToList();
        }

        public SanPham SanPham_GetById(int id){
            return context.SanPhams.Find(id);
        }

        public void SanPham_Add(SanPham SP){
            context.SanPhams.Add(SP);
            context.SaveChanges();
        }

        public void SanPham_Update(SanPham SP){
            context.SanPhams.Update(SP);
            context.SaveChanges();
        }

        public void SanPham_Remove(SanPham SP){
            context.SanPhams.Remove(SP);
            context.SaveChanges();
        }

        public void SanPham_RemoveBy_Product_Type_Id(int product_type_id)
        {
            var query = context.SanPhams.AsQueryable();
            query = query.Where(m => m.product_type_id == product_type_id);
            context.SanPhams.RemoveRange(query.ToList());
            context.SaveChanges();
        }
        public void SanPham_RemoveBy_Brand_Id(int brand_id)
        {
            var query = context.SanPhams.AsQueryable();
            query = query.Where(m => m.brand_id == brand_id);
            context.SanPhams.RemoveRange(query.ToList());
            context.SaveChanges();
        }

        public decimal SanPham_MaxPrice(){
            List<SanPham> ListSP = SanPham_GetAll();
            decimal maxprice = 0;
            foreach(var q in ListSP){
                if(maxprice <= q.price){
                    maxprice = q.price;
                }
            }
            return maxprice;
        }

        public List<SanPham> SanPhams_AdminTimKiem(string type, string input){
            var query = context.SanPhams.AsQueryable();
            switch(type){
                case "all": {
                    input = input.Trim().ToLower();
                    if(input == ""){
                        return SanPham_GetAll();
                    }
                    int ip; bool success = int.TryParse(input,out ip);
                    if(success){
                        query = query.Where(m => m.product_id == ip || m.name.ToLower().Contains(input) ||
                        m.product_type_id == ip || m.brand_id == ip || m.price == ip);
                    }
                    else{
                        query = query.Where(m => m.name.ToLower().Contains(input));
                    }
                    break;
                }
                case "product_id": {
                    int ip; bool success = int.TryParse(input,out ip);
                    if(success){
                        query = query.Where(m => m.product_id == ip);
                    }
                    else{
                        return new List<SanPham>();
                    }
                    break;
                }
                case "name": {
                    input = input.Trim().ToLower();
                    query = query.Where(m => m.name.ToLower().Contains(input));
                    break;
                }
                case "product_type_id":{
                    int ip; bool success = int.TryParse(input,out ip);
                    if(success){
                        query = query.Where(m => m.product_type_id == ip);
                    }
                    else{
                        return new List<SanPham>();
                    }
                    break;
                }
                case "brand_id":{
                    int ip; bool success = int.TryParse(input,out ip);
                    if(success){
                        query = query.Where(m => m.brand_id == ip);
                    }
                    else{
                        return new List<SanPham>();
                    }
                    break;
                }
                case "price":{
                    long ip; bool success = long.TryParse(input,out ip);
                    if(success){
                        query = query.Where(m => m.price == ip);
                    }
                    break;
                }
                default: break;
            }
            return query.ToList();
        }

        public List<SanPham> SanPham_Filter(string Type, string Brand, string SearchString, string sort, int pageIndex, int pageSize, out int count, out decimal pricemax, string price)
        {
            var query = context.SanPhams.AsQueryable();
            // Lấy dữ liệu theo thương hiệu
            if (!string.IsNullOrEmpty(Brand))
            {
                Brand = Brand.Trim('-');
                string[] arrList = Brand.Split('-');
                string s = "";
                int i = 0;
                for (i = 0; i < arrList.Length - 1; ++i)
                {
                    if (!string.IsNullOrEmpty(arrList[i])){
                        s += "m.brand_id == " + arrList[i] + " || ";
                    }
                }
                if (!string.IsNullOrEmpty(arrList[i])){
                    s += "m.brand_id == " + arrList[i];
                }
                s = "m => " + s;
                query = query.Where(@s);
            }
            // Lấy dữ liệu theo loại sản phẩm
            if (!string.IsNullOrEmpty(Type)){
                int type = int.Parse(Type);
                query = query.Where(m => m.product_type_id == type);
            }
            else{
                // Lấy dữ liệu theo từ khóa tìm kiếm
                if (!string.IsNullOrEmpty(SearchString))
                {
                    SearchString = SearchString.ToLower();
                    query = query.Where(m => m.name.ToLower().Contains(SearchString));
                }
            }
            // Lấy dữ liệu theo giá
            if(!string.IsNullOrEmpty(price)){
                string[] arrprice = price.Split('-');
                long pricefrom = long.Parse(arrprice[0]);
                long priceto = long.Parse(arrprice[1]);
                // Console.WriteLine(pricefrom.CompareTo(pricefrom));       bằng nhau xuất 0
                // Console.WriteLine(pricefrom.CompareTo(priceto));         nhỏ hơn xuất -1
                // Console.WriteLine(priceto.CompareTo(pricefrom));         lớn hơn xuất 1
                //query = query.Where(m => (m.price.CompareTo(pricefrom) == 1 || m.price.CompareTo(pricefrom) == 0)
                //    && (m.price.CompareTo(priceto) == -1 || m.price.CompareTo(priceto) == 0));
                //query = query.Where(m => 
                //        (Decimal.Round(m.price).CompareTo(Decimal.Round(pricefrom)) == 1 ||
                //        Decimal.Round(m.price).CompareTo(Decimal.Round(pricefrom)) == 0) &&
                //        (Decimal.Round(m.price).CompareTo(Decimal.Round(priceto)) == -1 ||
                //        Decimal.Round(m.price).CompareTo(Decimal.Round(priceto)) == 0)
                //        );
                query = query.Where(m => m.price >= pricefrom && m.price <= priceto);
            }
            query = query.Where(m => m.status == 1);
            count = query.Count();
            pricemax = SanPham_MaxPrice();

            if(!string.IsNullOrEmpty(sort)){
                switch(sort){
                    case "name-asc": query = query.OrderBy(m => m.name);
                                    break;
                    case "name-desc": query = query.OrderByDescending(m => m.name);
                                    break;
                    case "price-asc": query = query.OrderBy(m => (int?)m.price);
                                    break;
                    case "price-desc": query = query.OrderByDescending(m => (int?)m.price);
                                    break;
                    default: break;
                }
            }

            int TotalPages = (int)Math.Ceiling(count / (double)pageSize);
            if(pageIndex > TotalPages){
                pageIndex = TotalPages;
            }
            if(pageIndex < 1){
                pageIndex = 1;
            }

            return query.Skip((pageIndex - 1) * pageSize)
                        .Take(pageSize).ToList();
        }

        public List<SanPham> TenSPChay(){
            var query = context.SanPhams.AsQueryable();
            int pageIndex = 1;
            int pageSize = 10;
            query = query.OrderBy(m => m.amount);
            return query.Skip((pageIndex - 1) * pageSize)
                        .Take(pageSize).ToList();
        }

        public List<SanPham> TenSPNoi(){
            var query = context.SanPhams.AsQueryable();
            int pageIndex = 1;
            int pageSize = 10;
            query = query.OrderBy(m => (int?)m.price);
            return query.Skip((pageIndex - 1) * pageSize)
                        .Take(pageSize).ToList();
        }
    }
}