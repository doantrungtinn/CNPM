using System.Collections.Generic;
using Domain.Entities;

namespace Domain.Interfaces
{
    public interface IKhachHangEFcontext
    {
        List<KhachHang> KhachHang_GetAll();
        KhachHang KhachHang_GetByUser(string user);
        void KhachHang_Add(KhachHang U);
        void KhachHang_Update(KhachHang U);
        void KhachHang_Remove(KhachHang U);
        List<KhachHang> KhachHang_AdminTimKiem(string type, string input);
    }
}