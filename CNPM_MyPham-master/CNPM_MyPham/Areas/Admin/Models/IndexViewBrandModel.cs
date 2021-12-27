using System.Collections.Generic;
using Application.DTOs;

namespace CNPM_MyPham.Areas.Admin.Models
{
    public class IndexViewBrandModel
    {
        public IEnumerable<ThuongHieuDto> ListTH { get; set; }
        public ThuongHieuDto TH { get; set; }
        public QuyenDto QUser {get;set;}
    }
}