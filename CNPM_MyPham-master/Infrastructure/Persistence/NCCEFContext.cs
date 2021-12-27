using System.Collections.Generic;
using System.Linq;
using Domain.Entities;
using Domain.Interfaces;

namespace Infrastructure.Persistence
{
    public class NCCEFContext : INCCEFContext
    {
        private readonly MyphamDbContext context;
        public NCCEFContext(MyphamDbContext context){
            this.context = context;
        }
        public void NCC_Add(NCC ncc)
        {
            context.NCCs.Add(ncc);
            context.SaveChanges();
        }

        public List<NCC> NCC_GetAll()
        {
            return context.NCCs.ToList();
        }

        public NCC NCC_GetById(int id)
        {
            return context.NCCs.Find(id);
        }

        public void NCC_Remove(NCC ncc)
        {
            context.NCCs.Remove(ncc);
            context.SaveChanges();
        }

        public void NCC_Update(NCC ncc)
        {
            context.NCCs.Update(ncc);
            context.SaveChanges();
        }
        public int NCC_GetMaxId(){
            return context.NCCs.Max(m => m.ncc_id);
        }
        public List<NCC> NCC_AdminTimKiem(string type, string input){
            var query = context.NCCs.AsQueryable();
            switch(type){
                case "all": {
                    input = input.Trim().ToLower();
                    if(input == ""){
                        return NCC_GetAll();
                    }
                    int ip; bool success = int.TryParse(input,out ip);
                    if(success){
                        query = query.Where(m => m.ncc_id == ip || m.name.ToLower().Contains(input));
                    }
                    else{
                        query = query.Where(m => m.name.ToLower().Contains(input));
                    }
                    break;
                }
                case "ncc_id": {
                    int ip; bool success = int.TryParse(input,out ip);
                    if(success){
                        query = query.Where(m => m.ncc_id == ip);
                    }
                    else{
                        return new List<NCC>();
                    }
                    break;
                }
                case "name": {
                    input = input.Trim().ToLower();
                    query = query.Where(m => m.name.ToLower().Contains(input));
                    break;
                }
                default: break;
            }
            return query.ToList();
        }
    }
}