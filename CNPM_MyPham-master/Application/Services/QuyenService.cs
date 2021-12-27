using System.Collections.Generic;
using Application.DTOs;
using Application.Mappings;
using Domain.Interfaces;

namespace Application.Services
{
    public class QuyenService
    {
        private readonly IQuyenEFContext Qcontext;
        public QuyenService(IQuyenEFContext Qcontext){
            this.Qcontext = Qcontext;
        }
        public IEnumerable<QuyenDto> Quyen_GetAll(){
            var quyens = Qcontext.Quyen_GetAll();
            return quyens.MappingQuyenDtos();
        }

        public QuyenDto Quyen_GetById(int id){
            var q = Qcontext.Quyen_GetById(id);
            if(q == null) return null;
            return q.MappingQuyenDto();
        }

        public void Quyen_Add(QuyenDto qdto){
            var q = qdto.MappingQuyen();
            Qcontext.Quyen_Add(q);
        }

        public void Quyen_Update(QuyenDto qdto){
            var q = Qcontext.Quyen_GetById(qdto.permission_id);
            if(q == null) return;
            qdto.MappingQuyen(q);
            Qcontext.Quyen_Update(q);
        }

        public void Quyen_Remove(int product_type_id){
            var q = Qcontext.Quyen_GetById(product_type_id);
            if(q == null) return;
            Qcontext.Quyen_Remove(q);
        }
        public IEnumerable<QuyenDto> Quyen_AdminTimKiem(string type, string input){
            var qs = Qcontext.Quyen_AdminTimKiem(type, input);
            return qs.MappingQuyenDtos();
        }
        public int Quyen_GetMaxId(){
            return Qcontext.Quyen_GetMaxId();
        }
    }
}