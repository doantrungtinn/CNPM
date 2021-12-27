using System.Collections.Generic;
using Application.DTOs;
using Domain.Entities;

namespace Application.Mappings
{
    public static class MappingLoginModelProfile
    {
        public static LoginModelDto MappingLoginModelDto(this LoginModel lm){
            return new LoginModelDto{
                user = lm.user,
                pass = lm.pass
            };
        }

        public static LoginModel MappingLoginModel(this LoginModelDto lmdto){
            return new LoginModel{
                user = lmdto.user,
                pass = lmdto.pass
            };
        }

        public static void MappingLoginModel(this LoginModelDto lmdto, LoginModel lm){
            // lm.user = lmdto.user;
            lm.pass = lmdto.pass;
        }

        public static IEnumerable<LoginModelDto> MappingLoginModelDtos(this IEnumerable<LoginModel> lms){
            foreach(var lm in lms){
                yield return lm.MappingLoginModelDto();
            }
        }
    }
}