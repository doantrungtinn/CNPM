using System.Collections.Generic;
using Application.DTOs;
using Domain.Entities;

namespace Application.Mappings
{
    public static class MappingNhanVienProfile
    {
        public static NhanVienDto MappingNhanVienDto(this NhanVien NV){
            return new NhanVienDto{
                user = NV.user,
                pass = NV.pass,
                repass = NV.repass,
                full_name = NV.full_name,
                phone = NV.phone,
                mail = NV.mail,
                address = NV.address,
                sex = NV.sex,
                dateborn = NV.dateborn,
                permission_id = NV.permission_id,
                status = NV.status
            };
        }

        public static NhanVien MappingNhanVien(this NhanVienDto NVdto){
            return new NhanVien{
                user = NVdto.user,
                pass = NVdto.pass,
                repass = NVdto.repass,
                full_name = NVdto.full_name,
                phone = NVdto.phone,
                mail = NVdto.mail,
                address = NVdto.address,
                sex = NVdto.sex,
                dateborn = NVdto.dateborn,
                permission_id = NVdto.permission_id,
                status = NVdto.status
            };
        }

        public static void MappingNhanVien(this NhanVienDto NVdto, NhanVien NV){
            NV.pass = NVdto.pass;
            NV.repass = NVdto.repass;
            NV.full_name = NVdto.full_name;
            NV.phone = NVdto.phone;
            NV.mail = NVdto.mail;
            NV.address = NVdto.address;
            NV.sex = NVdto.sex;
            NV.dateborn = NVdto.dateborn;
            NV.permission_id = NVdto.permission_id;
            NV.status = NVdto.status;
        }

        public static IEnumerable<NhanVienDto> MappingNhanVienDtos(this IEnumerable<NhanVien> NhanViens){
            foreach(var q in NhanViens){
                yield return q.MappingNhanVienDto();
            }
        }
    }
}