using System.Collections.Generic;
using Domain.Entities;

namespace Domain.Interfaces
{
    public interface IThuongHieuEFContext
    {
         List<ThuongHieu> ThuongHieu_GetAll();
         ThuongHieu ThuongHieu_GetById(int id);
         void ThuongHieu_Add(ThuongHieu TH);
         void ThuongHieu_Update(ThuongHieu TH);
         void ThuongHieu_Remove(ThuongHieu TH);
         List<ThuongHieu> ThuongHieu_AdminTimKiem(string type, string input);
         int ThuongHieu_GetMaxId();
    }
}