using System.Collections.Generic;
using System.Linq;
using Domain.Entities;
using Domain.Interfaces;

namespace Infrastructure.Persistence
{
    public class HoaDonEFContext : IHoaDonEFContext
    {
        private readonly MyphamDbContext context;
        public HoaDonEFContext(MyphamDbContext context){
            this.context = context;
        }
        public void HoaDon_Add(HoaDon U)
        {
            context.HoaDons.Add(U);
            context.SaveChanges();
        }

        public List<HoaDon> HoaDon_GetAll()
        {
            return context.HoaDons.ToList();
        }

        public IEnumerable<HoaDon> HoaDon_GetByUser(string user)
        {
            var query = context.HoaDons.AsQueryable();
            query = query.Where(m => m.user_kh == user);
            query = query.OrderByDescending(m => m.date_order);
            return query.ToList();
        }

        public HoaDon HoaDon_GetById(int id)
        {
            return context.HoaDons.Find(id);
        }

        public void HoaDon_Remove(HoaDon U)
        {
            context.HoaDons.Remove(U);
            context.SaveChanges();
        }

        public void HoaDon_Update(HoaDon U)
        {
            context.HoaDons.Update(U);
            context.SaveChanges();
        }
        public int HoaDon_GetMaxId(){
            return context.HoaDons.Max(m => m.bill_id);
        }
        // Kiểm tra có tồn tại hóa đơn theo id và user_kh ko
        public HoaDon HoaDon_GetByUserAndID(string user, int id){
            var hd = HoaDon_GetById(id);
            if(hd.user_kh == user) return hd;
            return null;
        }

        public List<HoaDon> HoaDon_AdminTimKiem(string type, string input, int status){
            var query = context.HoaDons.AsQueryable();
            switch(type){
                case "all": {
                    if (!string.IsNullOrEmpty(input)) {
                        input = input.Trim().ToLower();
                    }
                    else
                    {
                        if (status == 0)
                        {
                            return HoaDon_GetAll();
                        }
                        else
                        {
                            query = query.Where(m => m.status == status);
                            return query.ToList();
                        }
                    }
                    int ip; bool success = int.TryParse(input,out ip);
                    if(success){
                        if(status == 0){
                            query = query.Where(m => m.bill_id == ip || m.user_kh.ToLower().Contains(input) || 
                            m.user_nv.ToLower().Contains(input));
                        }
                        else{
                            query = query.Where(m => (m.bill_id == ip || m.user_kh.ToLower().Contains(input) || 
                            m.user_nv.ToLower().Contains(input)) && m.status == status);
                            return query.ToList();
                        }
                    }
                    else{
                        if(status == 0){
                            query = query.Where(m => m.user_kh.ToLower().Contains(input) || 
                            m.user_nv.ToLower().Contains(input));
                        }
                        else{
                            query = query.Where(m => (m.user_kh.ToLower().Contains(input) || 
                            m.user_nv.ToLower().Contains(input)) && m.status == status);
                            return query.ToList();
                        }
                    }
                    break;
                }
                case "bill_id": {
                    int ip; bool success = int.TryParse(input,out ip);
                    if(success){
                        if(status == 0){
                            query = query.Where(m => m.bill_id == ip);
                        }
                        else{
                            query = query.Where(m => m.bill_id == ip && m.status == status);
                        }
                    }
                    else{
                        return new List<HoaDon>();
                    }
                    break;
                }
                case "user_kh": {
                    input = input.Trim().ToLower();
                    if(status == 0){
                        query = query.Where(m => m.user_kh.ToLower().Contains(input));
                    }
                    else{
                        query = query.Where(m => m.user_kh.ToLower().Contains(input) && m.status == status);
                    }
                    break;
                }
                case "user_nv":{
                    input = input.Trim().ToLower();
                    if(status == 0){
                        query = query.Where(m => m.user_nv.ToLower().Contains(input));
                    }
                    else{
                        query = query.Where(m => m.user_nv.ToLower().Contains(input) && m.status == status);
                    }
                    break;
                }
                default: break;
            }
            return query.ToList();
        }
    }
}