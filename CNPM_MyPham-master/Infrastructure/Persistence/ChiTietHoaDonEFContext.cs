using System.Collections.Generic;
using System.Linq;
using Domain.Entities;
using Domain.Interfaces;

namespace Infrastructure.Persistence
{
    public class ChiTietHoaDonEFContext : IChiTietHoaDonEFContext
    {
        private readonly MyphamDbContext context;
        public ChiTietHoaDonEFContext(MyphamDbContext context){
            this.context = context;
        }
        public void ChiTietHoaDon_Add(ChiTietHoaDon U)
        {
            context.ChiTietHoaDons.Add(U);
            context.SaveChanges();
        }
        public void ChiTietHoaDon_AddRange(IEnumerable<ChiTietHoaDon> Listcthd)
        {
            context.ChiTietHoaDons.AddRange(Listcthd);
            context.SaveChanges();
        }

        public List<ChiTietHoaDon> ChiTietHoaDon_GetAll()
        {
            return context.ChiTietHoaDons.ToList();
        }

        public List<ChiTietHoaDon> ChiTietHoaDon_GetByBillId(int bill_id)
        {
            var query = context.ChiTietHoaDons.AsQueryable();
            query = query.Where(m => m.bill_id == bill_id);
            return query.ToList();
        }

        public ChiTietHoaDon ChiTietHoaDon_GetById(int bill_id, int product_id)
        {
            var query = context.ChiTietHoaDons.AsQueryable();
            query = query.Where(m => m.product_id == product_id && m.bill_id == bill_id);
            return (ChiTietHoaDon)query;
        }

        public List<ChiTietHoaDon> ChiTietHoaDon_GetByProductId(int product_id)
        {
            var query = context.ChiTietHoaDons.AsQueryable();
            query = query.Where(m => m.product_id == product_id);
            return query.ToList();
        }

        public void ChiTietHoaDon_Remove(ChiTietHoaDon U)
        {
            context.ChiTietHoaDons.Remove(U);
            context.SaveChanges();
        }

        public void ChiTietHoaDon_Update(ChiTietHoaDon U)
        {
            context.ChiTietHoaDons.Update(U);
            context.SaveChanges();
        }
    }
}