using System.Collections.Generic;
using Application.DTOs;

namespace CNPM_MyPham.Areas.Admin.Models
{
    public class IndexViewKhachHangModel
    {
        public IEnumerable<KhachHangDto> ListKH { get; set; }
        public KhachHangDto KH { get; set; }
        public QuyenDto QUser {get;set;}
    }
}