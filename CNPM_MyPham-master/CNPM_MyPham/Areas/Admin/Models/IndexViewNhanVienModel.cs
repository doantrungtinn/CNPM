using System.Collections.Generic;
using Application.DTOs;

namespace CNPM_MyPham.Areas.Admin.Models
{
    public class IndexViewNhanVienModel
    {
        public IEnumerable<NhanVienDto> ListNV { get; set; }
        public IEnumerable<QuyenDto> ListQ { get; set; }
        public NhanVienDto NV { get; set; }
        public QuyenDto QUser {get;set;}
    }
}