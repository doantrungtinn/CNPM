using System;
using System.Collections.Generic;
using System.Linq;
using Domain.Entities;
using Domain.Interfaces;

namespace Infrastructure.Persistence
{
    public class QuyenEFContext : IQuyenEFContext
    {
        private readonly MyphamDbContext context;

        public QuyenEFContext(MyphamDbContext context){
            this.context = context;
        }
        public void Quyen_Add(Quyen Q)
        {
            context.Quyens.Add(Q);
            context.SaveChanges();
        }

        public List<Quyen> Quyen_GetAll()
        {
            return context.Quyens.ToList();
        }

        public Quyen Quyen_GetById(int id)
        {
            return context.Quyens.Find(id);
        }

        public void Quyen_Remove(Quyen Q)
        {
            context.Quyens.Remove(Q);
            context.SaveChanges();
        }

        public void Quyen_Update(Quyen Q)
        {
            context.Quyens.Update(Q);
            context.SaveChanges();
        }
        public int Quyen_GetMaxId(){
            return context.Quyens.Max(m => m.permission_id);
        }
        public List<Quyen> Quyen_AdminTimKiem(string type, string input){
            var query = context.Quyens.AsQueryable();
            switch(type){
                case "all": {
                    input = input.Trim().ToLower();
                    if(input == ""){
                        return Quyen_GetAll();
                    }
                    int ip; bool success = int.TryParse(input,out ip);
                    if(success){
                        query = query.Where(m => m.permission_id == ip || m.name.ToLower().Contains(input) ||
                        m.details.ToLower().Contains(input));
                    }
                    else{
                        query = query.Where(m => m.name.ToLower().Contains(input) || m.details.ToLower().Contains(input));
                    }
                    break;
                }
                case "permission_id": {
                    int ip; bool success = int.TryParse(input,out ip);
                    if(success){
                        query = query.Where(m => m.permission_id == ip);
                    }
                    else{
                        return new List<Quyen>();
                    }
                    break;
                }
                case "name": {
                    input = input.Trim().ToLower();
                    query = query.Where(m => m.name.ToLower().Contains(input));
                    break;
                }
                case "details": {
                    input = input.Trim().ToLower();
                    query = query.Where(m => m.details.ToLower().Contains(input));
                    break;
                }
                default: break;
            }
            return query.ToList();
        }
    }
}