using System.Collections.Generic;
using Application.DTOs;
using Application.Mappings;
using Domain.Interfaces;

namespace Application.Services
{
    public class ThuongHieuService
    {
        private readonly IThuongHieuEFContext THcontext;
        public ThuongHieuService(IThuongHieuEFContext THcontext){
            this.THcontext = THcontext;
        }
        public IEnumerable<ThuongHieuDto> ThuongHieu_GetAll(){
            var ths = THcontext.ThuongHieu_GetAll();
            return ths.MappingThuongHieuDtos();
        }

        public ThuongHieuDto ThuongHieu_GetById(int id){
            var th = THcontext.ThuongHieu_GetById(id);
            if(th == null) return null;
            return th.MappingThuongHieuDto();
        }

        public void ThuongHieu_Add(ThuongHieuDto thdto){
            var th = thdto.MappingThuongHieu();
            THcontext.ThuongHieu_Add(th);
        }

        public void ThuongHieu_Update(ThuongHieuDto thdto){
            var th = THcontext.ThuongHieu_GetById(thdto.brand_id);
            if(th == null) return;
            thdto.MappingThuongHieu(th);
            THcontext.ThuongHieu_Update(th);
        }

        public void ThuongHieu_Remove(int brand_id){
            var th = THcontext.ThuongHieu_GetById(brand_id);
            if(th == null) return;
            THcontext.ThuongHieu_Remove(th);
        }
        public IEnumerable<ThuongHieuDto> ThuongHieu_AdminTimKiem(string type, string input){
            var ths = THcontext.ThuongHieu_AdminTimKiem(type, input);
            return ths.MappingThuongHieuDtos();
        }
        public int ThuongHieu_GetMaxId(){
            return THcontext.ThuongHieu_GetMaxId();
        }
    }
}