using System.Collections.Generic;
using Application.DTOs;

namespace CNPM_MyPham.Areas.Admin.Models
{
    public class IndexViewHoaDonModel
    {
        public IEnumerable<HoaDonDto> ListHD { get; set; }
        public HoaDonDto HD { get; set; }
        public QuyenDto QUser {get;set;}
    }
}