using System.Collections.Generic;
using Application.DTOs;
using Domain.Entities;

namespace Application.Mappings
{
    public static class MappingNCCProfile
    {
        public static NCCDto MappingNCCDto(this NCC ncc){
            return new NCCDto{
                ncc_id = ncc.ncc_id,
                name = ncc.name,
                status = ncc.status
            };
        }

        public static NCC MappingNCC(this NCCDto nccdto){
            return new NCC{
                ncc_id = nccdto.ncc_id,
                name = nccdto.name,
                status = nccdto.status
            };
        }

        public static void MappingNCC(this NCCDto nccdto, NCC ncc){
            // ncc.ncc_id = nccdto.ncc_id;
            ncc.name = nccdto.name;
            ncc.status = nccdto.status;
        }

        public static IEnumerable<NCCDto> MappingNCCDtos(this IEnumerable<NCC> nccs){
            foreach(var ncc in nccs){
                yield return ncc.MappingNCCDto();
            }
        }
    }
}