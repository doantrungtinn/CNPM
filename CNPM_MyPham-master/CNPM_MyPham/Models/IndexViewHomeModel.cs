using System.Collections.Generic;
using Application.DTOs;

namespace CNPM_MyPham.Models
{
    public class IndexViewHomeModel
    {
        public IEnumerable<SanPhamDto> ListSPChay { get; set;}
        public IEnumerable<SanPhamDto> ListSPNoi { get; set;}
        public IEnumerable<ThuongHieuDto> ListTH { get; set; }
    }
}