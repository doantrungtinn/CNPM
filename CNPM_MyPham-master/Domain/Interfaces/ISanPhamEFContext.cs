using System.Collections.Generic;
using Domain.Entities;

namespace Domain.Interfaces
{
    public interface ISanPhamEFContext
    {
        List<SanPham> SanPham_GetAll();
        List<SanPham> SanPham_Shop_GetAll();
        SanPham SanPham_GetById(int id);
        void SanPham_Add(SanPham SP);
        void SanPham_Update(SanPham SP);
        void SanPham_Remove(SanPham SP);
        void SanPham_RemoveBy_Product_Type_Id(int product_type_id);
        void SanPham_RemoveBy_Brand_Id(int brand_id);
        List<SanPham> SanPham_Filter(string Type, string Brand, string SearchString, string sort, int pageIndex, int pageSize, out int count, out decimal pricemax, string price);
        List<SanPham> SanPhams_AdminTimKiem(string type, string input);
        List<SanPham> TenSPChay();
        List<SanPham> TenSPNoi();
    }
}