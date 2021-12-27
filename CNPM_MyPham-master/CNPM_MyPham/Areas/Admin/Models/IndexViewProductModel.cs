using Application.DTOs;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using System.ComponentModel.DataAnnotations;

namespace CNPM_MyPham.Areas.Admin.Models
{
    public class IndexViewProductModel
    {
        public IEnumerable<SanPhamDto> ListSP { get; set; }
        public SanPhamDto SP { get; set; }
        public IEnumerable<ThuongHieuDto> ListTH { get; set; }
        public IEnumerable<LoaiSanPhamDto> ListLSP { get; set; }
        
        [Required(ErrorMessage = "Hình ảnh là bắt buộc")]
        public IFormFile photo { get; set; }
        public QuyenDto QUser {get;set;}
    }
}
