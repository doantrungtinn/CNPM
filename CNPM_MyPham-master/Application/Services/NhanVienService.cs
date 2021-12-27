using System.Collections.Generic;
using Application.DTOs;
using Application.Mappings;
using Domain.Interfaces;

namespace Application.Services
{
    public class NhanVienService
    {
        private readonly INhanVienEFContext NVcontext;
        public NhanVienService(INhanVienEFContext NVcontext){
            this.NVcontext = NVcontext;
        }
        public IEnumerable<NhanVienDto> NhanVien_GetAll(){
            var nvs = NVcontext.NhanVien_GetAll();
            return nvs.MappingNhanVienDtos();
        }
        public NhanVienDto NhanVien_GetByUser(string user){
            var nv = NVcontext.NhanVien_GetByUser(user);
            if(nv == null) return null;
            return nv.MappingNhanVienDto();
        }
        public void NhanVien_Add(NhanVienDto U){
            var nv = U.MappingNhanVien();
            NVcontext.NhanVien_Add(nv);
        }

        public void NhanVien_Update(NhanVienDto U){
            var nv = NVcontext.NhanVien_GetByUser(U.user);
            if(nv == null) return;
            U.MappingNhanVien(nv);
            NVcontext.NhanVien_Update(nv);
        }

        public void NhanVien_Remove(string user){
            var nv = NVcontext.NhanVien_GetByUser(user);
            if(nv == null) return;
            NVcontext.NhanVien_Remove(nv);
        }
        public IEnumerable<NhanVienDto> NhanVien_AdminTimKiem(string type, string input){
            var nvs = NVcontext.NhanVien_AdminTimKiem(type, input);
            return nvs.MappingNhanVienDtos();
        }
    }
}