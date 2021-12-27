using System.Collections.Generic;
using Application.DTOs;
using Application.Mappings;
using Domain.Interfaces;

namespace Application.Services
{
    public class SanPhamService
    {
        private readonly ISanPhamEFContext SPcontext;
        public SanPhamService(ISanPhamEFContext SPcontext){
            this.SPcontext = SPcontext;
        }
        public IEnumerable<SanPhamDto> SanPham_GetAll(){
            var sps = SPcontext.SanPham_GetAll();
            return sps.MappingSanPhamDtos();
        }

        public SanPhamDto SanPham_GetById(int id){
            var sp = SPcontext.SanPham_GetById(id);
            if(sp == null) return null;
            return sp.MappingSanPhamDto();
        }

        public void SanPham_Add(SanPhamDto SPdto){
            var sp = SPdto.MappingSanPham();
            SPcontext.SanPham_Add(sp);
        }

        public void SanPham_Update(SanPhamDto SPdto){
            var sp = SPcontext.SanPham_GetById(SPdto.product_id);
            if(sp == null) return;
            SPdto.MappingSanPham(sp);
            SPcontext.SanPham_Update(sp);
        }

        public void SanPham_Remove(int product_id){
            var sp = SPcontext.SanPham_GetById(product_id);
            if(sp == null) return;
            SPcontext.SanPham_Remove(sp);
        }

        public IEnumerable<SanPhamDto> SanPham_Filter(string Type, string Brand, string SearchString, string sort, int pageIndex, int pageSize, out int count, out decimal pricemax, string price)
        {
            var sps = SPcontext.SanPham_Filter(Type, Brand, SearchString, sort, pageIndex, pageSize, out count, out pricemax, price);
            return sps.MappingSanPhamDtos();
        }

        public IEnumerable<SanPhamDto> SanPhams_AdminTimKiem(string type, string input){
            var sps = SPcontext.SanPhams_AdminTimKiem(type, input);
            return sps.MappingSanPhamDtos();
        }

        public void SanPham_RemoveBy_Product_Type_Id(int product_type_id)
        {
            SPcontext.SanPham_RemoveBy_Product_Type_Id(product_type_id);
        }
        public void SanPham_RemoveBy_Brand_Id(int brand_id){
            SPcontext.SanPham_RemoveBy_Brand_Id(brand_id);
        }

        public IEnumerable<SanPhamDto> SanPham_Shop_GetAll(){
            var sps = SPcontext.SanPham_Shop_GetAll();
            return sps.MappingSanPhamDtos();
        }
        public IEnumerable<SanPhamDto> TenSPChay(){
            var sps = SPcontext.TenSPChay();
            return sps.MappingSanPhamDtos();
        }

        public IEnumerable<SanPhamDto> TenSPNoi(){
            var sps = SPcontext.TenSPNoi();
            return sps.MappingSanPhamDtos();
        }
    }
}