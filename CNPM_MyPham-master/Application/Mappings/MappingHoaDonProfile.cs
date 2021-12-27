using System.Collections.Generic;
using Application.DTOs;
using Domain.Entities;

namespace Application.Mappings
{
    public static class MappingHoaDonProfile
    {
        public static HoaDonDto MappingHoaDonDto(this HoaDon hd){
            return new HoaDonDto{
                bill_id = hd.bill_id,
                user_kh = hd.user_kh,
                user_nv = hd.user_nv,
                phone = hd.phone,
                address = hd.address,
                date_receice = hd.date_receice,
                date_order = hd.date_order,
                total = hd.total,
                status = hd.status
            };
        }

        public static HoaDon MappingHoaDon(this HoaDonDto hddto){
            return new HoaDon{
                bill_id = hddto.bill_id,
                user_kh = hddto.user_kh,
                user_nv = hddto.user_nv,
                phone = hddto.phone,
                address = hddto.address,
                date_receice = hddto.date_receice,
                date_order = hddto.date_order,
                total = hddto.total,
                status = hddto.status
            };
        }

        public static void MappingHoaDon(this HoaDonDto hddto, HoaDon hd){
            // hd.bill_id = hddto.bill_id;
            hd.user_kh = hddto.user_kh;
            hd.user_nv = hddto.user_nv;
            hd.phone = hddto.phone;
            hd.address = hddto.address;
            hd.date_receice = hddto.date_receice;
            hd.date_order = hddto.date_order;
            hd.total = hddto.total;
            hd.status = hddto.status;
        }

        public static IEnumerable<HoaDonDto> MappingHoaDonDtos(this IEnumerable<HoaDon> hds){
            foreach(var hd in hds){
                yield return hd.MappingHoaDonDto();
            }
        }
    }
}