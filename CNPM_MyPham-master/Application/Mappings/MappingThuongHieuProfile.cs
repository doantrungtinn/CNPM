using System.Collections.Generic;
using Application.DTOs;
using Domain.Entities;

namespace Application.Mappings
{
    public static class MappingThuongHieuProfile
    {
        public static ThuongHieuDto MappingThuongHieuDto(this ThuongHieu th){
            return new ThuongHieuDto{
                brand_id = th.brand_id,
                name = th.name
            };
        }

        public static ThuongHieu MappingThuongHieu(this ThuongHieuDto thdto){
            return new ThuongHieu{
                brand_id = thdto.brand_id,
                name = thdto.name
            };
        }

        public static void MappingThuongHieu(this ThuongHieuDto thdto, ThuongHieu th){
            // th.brand_id = thdto.brand_id;
            th.name = thdto.name;
        }

        public static IEnumerable<ThuongHieuDto> MappingThuongHieuDtos(this IEnumerable<ThuongHieu> ths){
            foreach(var th in ths){
                yield return th.MappingThuongHieuDto();
            }
        }
    }
}