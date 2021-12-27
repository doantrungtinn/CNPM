using System.Collections.Generic;
using Application.DTOs;
using Application.Mappings;
using Domain.Interfaces;

namespace Application.Services
{
    public class NCCService
    {
        private readonly INCCEFContext NCCcontext;
        public NCCService(INCCEFContext NCCcontext){
            this.NCCcontext = NCCcontext;
        }
        public IEnumerable<NCCDto> NCC_GetAll(){
            var NCCs = NCCcontext.NCC_GetAll();
            return NCCs.MappingNCCDtos();
        }

        public NCCDto NCC_GetById(int id){
            var NCC = NCCcontext.NCC_GetById(id);
            if(NCC == null) return null;
            return NCC.MappingNCCDto();
        }

        public void NCC_Add(NCCDto NCCdto){
            var NCC = NCCdto.MappingNCC();
            NCCcontext.NCC_Add(NCC);
        }

        public void NCC_Update(NCCDto NCCdto){
            var NCC = NCCcontext.NCC_GetById(NCCdto.ncc_id);
            if(NCC == null) return;
            NCCdto.MappingNCC(NCC);
            NCCcontext.NCC_Update(NCC);
        }

        public void NCC_Remove(int ncc_id){
            var NCC = NCCcontext.NCC_GetById(ncc_id);
            if(NCC == null) return;
            NCCcontext.NCC_Remove(NCC);
        }

        public IEnumerable<NCCDto> NCC_AdminTimKiem(string type, string input){
            var nccs = NCCcontext.NCC_AdminTimKiem(type, input);
            return nccs.MappingNCCDtos();
        }
        public int NCC_GetMaxId(){
            return NCCcontext.NCC_GetMaxId();
        }
    }
}