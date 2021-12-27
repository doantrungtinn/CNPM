using System.Collections.Generic;
using Domain.Entities;

namespace Domain.Interfaces
{
    public interface IChiTietHoaDonEFContext
    {
        List<ChiTietHoaDon> ChiTietHoaDon_GetAll();
        ChiTietHoaDon ChiTietHoaDon_GetById(int bill_id, int product_id);
        List<ChiTietHoaDon> ChiTietHoaDon_GetByBillId(int bill_id);
        List<ChiTietHoaDon> ChiTietHoaDon_GetByProductId(int product_id);
        void ChiTietHoaDon_Add(ChiTietHoaDon U);
        void ChiTietHoaDon_AddRange(IEnumerable<ChiTietHoaDon> Listcthd);
        void ChiTietHoaDon_Update(ChiTietHoaDon U);
        void ChiTietHoaDon_Remove(ChiTietHoaDon U);
    }
}