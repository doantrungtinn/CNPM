using System.Collections.Generic;
using System.Linq;
using Domain.Entities;
using Domain.Interfaces;

namespace Infrastructure.Persistence
{
    public class LoaiSanPhamEFContext : ILoaiSanPhamEFContext
    {
        private readonly MyphamDbContext context;

        public LoaiSanPhamEFContext(MyphamDbContext context){
            this.context = context;
        }

        public List<LoaiSanPham> LoaiSanPham_GetAll(){
            return context.LoaiSanPhams.ToList();
        }

        public LoaiSanPham LoaiSanPham_GetById(int id){
            return context.LoaiSanPhams.Find(id);
        }

        public void LoaiSanPham_Add(LoaiSanPham LSP){
            context.LoaiSanPhams.Add(LSP);
            context.SaveChanges();
        }

        public void SanPham_Update(LoaiSanPham LSP){
            context.LoaiSanPhams.Update(LSP);
            context.SaveChanges();
        }

        public void LoaiSanPham_Remove(LoaiSanPham LSP){
            context.LoaiSanPhams.Remove(LSP);
            context.SaveChanges();
        }
        public int LoaiSanPham_GetMaxId(){
            return context.LoaiSanPhams.Max(m => m.product_type_id);
        }
        public List<LoaiSanPham> LoaiSanPham_AdminTimKiem(string type, string input){
            var query = context.LoaiSanPhams.AsQueryable();
            switch(type){
                case "all": {
                    input = input.Trim().ToLower();
                    if(input == ""){
                        return LoaiSanPham_GetAll();
                    }
                    int ip; bool success = int.TryParse(input,out ip);
                    if(success){
                        query = query.Where(m => m.product_type_id == ip || m.name.ToLower().Contains(input) ||
                        m.description.ToLower().Contains(input));
                    }
                    else{
                        query = query.Where(m => m.name.ToLower().Contains(input) ||
                        m.description.ToLower().Contains(input));
                    }
                    break;
                }
                case "product_type_id": {
                    int ip; bool success = int.TryParse(input,out ip);
                    if(success){
                        query = query.Where(m => m.product_type_id == ip);
                    }
                    else{
                        return new List<LoaiSanPham>();
                    }
                    break;
                }
                case "name": {
                    input = input.Trim().ToLower();
                    query = query.Where(m => m.name.ToLower().Contains(input));
                    break;
                }
                case "description":{
                    input = input.Trim().ToLower();
                    query = query.Where(m => m.description.ToLower().Contains(input));
                    break;
                }
                default: break;
            }
            return query.ToList();
        }
    }
}