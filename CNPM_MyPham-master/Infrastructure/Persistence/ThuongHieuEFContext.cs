using System.Collections.Generic;
using System.Linq;
using Domain.Entities;
using Domain.Interfaces;

namespace Infrastructure.Persistence
{
    public class ThuongHieuEFContext : IThuongHieuEFContext
    {
        private readonly MyphamDbContext context;

        public ThuongHieuEFContext(MyphamDbContext context){
            this.context = context;
        }

        public List<ThuongHieu> ThuongHieu_GetAll(){
            return context.ThuongHieus.ToList();
        }

        public ThuongHieu ThuongHieu_GetById(int id){
            return context.ThuongHieus.Find(id);
        }

        public void ThuongHieu_Add(ThuongHieu TH){
            context.ThuongHieus.Add(TH);
            context.SaveChanges();
        }

        public void ThuongHieu_Update(ThuongHieu TH){
            context.ThuongHieus.Update(TH);
            context.SaveChanges();
        }

        public void ThuongHieu_Remove(ThuongHieu TH){
            context.ThuongHieus.Remove(TH);
            context.SaveChanges();
        }
        public int ThuongHieu_GetMaxId(){
            return context.ThuongHieus.Max(m => m.brand_id);
        }
        public List<ThuongHieu> ThuongHieu_AdminTimKiem(string type, string input){
            var query = context.ThuongHieus.AsQueryable();
            switch(type){
                case "all": {
                    input = input.Trim().ToLower();
                    if(input == ""){
                        return ThuongHieu_GetAll();
                    }
                    int ip; bool success = int.TryParse(input,out ip);
                    if(success){
                        query = query.Where(m => m.brand_id == ip || m.name.ToLower().Contains(input));
                    }
                    else{
                        query = query.Where(m => m.name.ToLower().Contains(input));
                    }
                    break;
                }
                case "brand_id": {
                    int ip; bool success = int.TryParse(input,out ip);
                    if(success){
                        query = query.Where(m => m.brand_id == ip);
                    }
                    else{
                        return new List<ThuongHieu>();
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