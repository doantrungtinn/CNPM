using Application.DTOs;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace CNPM_MyPham.Areas.Admin.Models
{
    public class IndexViewNCCModel
    {
        public IEnumerable<NCCDto> ListNCC { get; set; }
        public NCCDto NCC { get; set; }
        public QuyenDto QUser {get;set;}
    }
}
