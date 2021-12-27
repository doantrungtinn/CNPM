using Application.DTOs;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace CNPM_MyPham.Areas.Admin.Models
{
    public class IndexViewQuyenModel
    {
        public IEnumerable<QuyenDto> ListQ { get; set; }
        public QuyenDto Quyen { get; set; }
        public QuyenDto QUser {get;set;}
    }
}
