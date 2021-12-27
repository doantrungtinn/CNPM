using Application.DTOs;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace CNPM_MyPham.Areas.Admin.Models
{
    public class IndexViewTypeModel
    {
        public IEnumerable<LoaiSanPhamDto> ListLSP { get; set; }
        public LoaiSanPhamDto LSP { get; set; }
        public QuyenDto QUser {get;set;}
    }
}
