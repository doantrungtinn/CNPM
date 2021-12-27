using System.Collections.Generic;
using Application.DTOs;
using Application.Mappings;
using Domain.Interfaces;

namespace Application.Services
{
    public class ChiTietHoaDonService
    {
        private readonly IChiTietHoaDonEFContext ctdhcontext;
        public ChiTietHoaDonService(IChiTietHoaDonEFContext ctdhcontext){
            this.ctdhcontext = ctdhcontext;
        }
        public IEnumerable<ChiTietHoaDonDto> ChiTietHoaDon_GetAll(){
            var ctdhs = ctdhcontext.ChiTietHoaDon_GetAll();
            return ctdhs.MappingChiTietHoaDonDtos();
        }
        public IEnumerable<ChiTietHoaDonDto> ChiTietHoaDon_GetByBillId(int bill_id){
            var ctdhs = ctdhcontext.ChiTietHoaDon_GetByBillId(bill_id);
            return ctdhs.MappingChiTietHoaDonDtos();
        }
        public IEnumerable<ChiTietHoaDonDto> ChiTietHoaDon_GetByProductId(int product_id){
            var ctdhs = ctdhcontext.ChiTietHoaDon_GetByProductId(product_id);
            return ctdhs.MappingChiTietHoaDonDtos();
        }
        public ChiTietHoaDonDto ChiTietHoaDon_GetById(int bill_id, int product_id){
            var ctdh = ctdhcontext.ChiTietHoaDon_GetById(bill_id, product_id);
            return ctdh.MappingChiTietHoaDonDto();
        }
        public void ChiTietHoaDon_Add(ChiTietHoaDonDto U){
            var ctdh = U.MappingChiTietHoaDon();
            ctdhcontext.ChiTietHoaDon_Add(ctdh);
        }

        public void ChiTietHoaDon_AddRange(IEnumerable<ChiTietHoaDonDto> Listcthddto){
            var Listcthd = Listcthddto.MappingChiTietHoaDon();
            ctdhcontext.ChiTietHoaDon_AddRange(Listcthd);
        }
        // Hóa đơn chưa cần sửa và xóa
        // public void ChiTietHoaDon_Update(ChiTietHoaDonDto U){
        //     var ctdh = ctdhcontext.ChiTietHoaDon_GetByUser(U.user);
        //     if(ctdh == null) return;
        //     U.MappingChiTietHoaDon(ctdh);
        //     ctdhcontext.ChiTietHoaDon_Update(ctdh);
        // }

        // public void ChiTietHoaDon_Remove(int user){
        //     var ctdh = ctdhcontext.ChiTietHoaDon_GetByUser(user);
        //     if(ctdh == null) return;
        //     ctdhcontext.ChiTietHoaDon_Remove(ctdh);
        // }
    }
}