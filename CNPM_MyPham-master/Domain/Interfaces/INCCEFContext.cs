using System.Collections.Generic;
using Domain.Entities;

namespace Domain.Interfaces
{
    public interface INCCEFContext
    {
        List<NCC> NCC_GetAll();
        NCC NCC_GetById(int id);
        void NCC_Add(NCC ncc);
        void NCC_Update(NCC ncc);
        void NCC_Remove(NCC ncc);
        List<NCC> NCC_AdminTimKiem(string type, string input);
        int NCC_GetMaxId();
    }
}