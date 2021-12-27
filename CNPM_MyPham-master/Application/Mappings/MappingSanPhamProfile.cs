using System.Collections.Generic;
using Application.DTOs;
using Domain.Entities;

namespace Application.Mappings
{
    public static class MappingSanPhamProfile
    {
        public static SanPhamDto MappingSanPhamDto(this SanPham sp){
            return new SanPhamDto{
                product_id = sp.product_id,
                product_type_id = sp.product_type_id,
                brand_id = sp.brand_id,
                name = sp.name,
                amount = sp.amount,
                price = sp.price,
                description = sp.description,
                use = sp.use,
                img = sp.img,
                status = sp.status
            };
        }

        public static SanPham MappingSanPham(this SanPhamDto spdto){
            return new SanPham{
                product_id = spdto.product_id,
                product_type_id = spdto.product_type_id,
                brand_id = spdto.brand_id,
                name = spdto.name,
                amount = spdto.amount,
                price = spdto.price,
                description = spdto.description,
                use = spdto.use,
                img = spdto.img,
                status = spdto.status
            };
        }

        public static void MappingSanPham(this SanPhamDto spdto, SanPham sp){
            // sp.product_id = spdto.product_id;
            sp.product_type_id = spdto.product_type_id;
            sp.brand_id = spdto.brand_id;
            sp.name = spdto.name;
            sp.amount = spdto.amount;
            sp.price = spdto.price;
            sp.description = spdto.description;
            sp.use = spdto.use;
            sp.img = spdto.img;
            sp.status = spdto.status;
        }

        public static IEnumerable<SanPhamDto> MappingSanPhamDtos(this IEnumerable<SanPham> sps){
            foreach(var sp in sps){
                yield return sp.MappingSanPhamDto();
            }
        }

        public static IEnumerable<SanPham> MappingSanPhams(this IEnumerable<SanPhamDto> spdtos)
        {
            foreach (var sp in spdtos)
            {
                yield return sp.MappingSanPham();
            }
        }
    }
}