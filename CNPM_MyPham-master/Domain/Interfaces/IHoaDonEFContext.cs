using System.Collections.Generic;
using Domain.Entities;

namespace Domain.Interfaces
{
    public interface IHoaDonEFContext
    {
        List<HoaDon> HoaDon_GetAll();
        HoaDon HoaDon_GetById(int id);
        void HoaDon_Add(HoaDon U);
        void HoaDon_Update(HoaDon U);
        void HoaDon_Remove(HoaDon U);
        int HoaDon_GetMaxId();
        IEnumerable<HoaDon> HoaDon_GetByUser(string user);
        HoaDon HoaDon_GetByUserAndID(string user, int id);
        List<HoaDon> HoaDon_AdminTimKiem(string type, string input, int status);
    }
}