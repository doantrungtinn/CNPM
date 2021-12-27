using System.Collections.Generic;
using Application.DTOs;
using Domain.Entities;

namespace Application.Mappings
{
    public static class MappingQuyenProfile
    {
        public static QuyenDto MappingQuyenDto(this Quyen Q){
            return new QuyenDto(Q.permission_id, Q.name, Q.details);
        }

        public static Quyen MappingQuyen(this QuyenDto Qdto){
            return new Quyen{
                permission_id = Qdto.permission_id,
                name = Qdto.name,
                details = Qdto.details
            };
        }

        public static void MappingQuyen(this QuyenDto Qdto, Quyen Q){
            Q.name = Qdto.name;
            Q.details = Qdto.details;
        }

        public static IEnumerable<QuyenDto> MappingQuyenDtos(this IEnumerable<Quyen> quyens){
            foreach(var q in quyens){
                yield return q.MappingQuyenDto();
            }
        }
    }
}