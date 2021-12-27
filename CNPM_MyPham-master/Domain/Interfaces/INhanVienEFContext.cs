using System.Collections.Generic;
using Domain.Entities;

namespace Domain.Interfaces
{
    public interface INhanVienEFContext
    {
        List<NhanVien> NhanVien_GetAll();
        NhanVien NhanVien_GetByUser(string user);
        void NhanVien_Add(NhanVien NV);
        void NhanVien_Update(NhanVien NV);
        void NhanVien_Remove(NhanVien NV);
        List<NhanVien> NhanVien_AdminTimKiem(string type, string input);
    }
}