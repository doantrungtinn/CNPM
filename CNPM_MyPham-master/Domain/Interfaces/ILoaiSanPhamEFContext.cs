using System.Collections.Generic;
using Domain.Entities;

namespace Domain.Interfaces
{
    public interface ILoaiSanPhamEFContext
    {
        List<LoaiSanPham> LoaiSanPham_GetAll();
        LoaiSanPham LoaiSanPham_GetById(int id);
        void LoaiSanPham_Add(LoaiSanPham LSP);
        void SanPham_Update(LoaiSanPham LSP);
        void LoaiSanPham_Remove(LoaiSanPham LSP);
        List<LoaiSanPham> LoaiSanPham_AdminTimKiem(string type, string input);
        int LoaiSanPham_GetMaxId();
    }
}