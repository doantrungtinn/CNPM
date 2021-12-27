using Application.DTOs;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace CNPM_MyPham.Areas.Admin.Models
{
    public class IndexViewUserModel
    {
        public NhanVienDto NV { get; set; }
        public QuyenDto Q { get; set; }
        public QuyenDto QUser { get; set; }
    }
}
