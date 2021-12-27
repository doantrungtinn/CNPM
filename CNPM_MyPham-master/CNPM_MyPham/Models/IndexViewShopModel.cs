using Application.DTOs;
using Domain.Entities;
using Infrastructure;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace CNPM_MyPham.Models
{
    public class IndexViewShopModel
    {
        public PaginatedList<SanPhamDto> ListSP { get; set; }
        public IEnumerable<ThuongHieuDto> ListTH { get; set; }
        public IEnumerable<LoaiSanPhamDto> ListLSP { get; set; }
        public string Type { get; set; }
        public string NameType { get; set;}
        public string Brand { get; set; }
        public string SearchString { get; set; }
        public string sort { get; set;}
        public decimal pricemax { get; set;}
        public string price{ get; set; }
        // Kích thước của 1 trang có bao nhiêu sản phẩm
        public int pageSize { get; set; }
        public int count { get; set; }
        // Số phân trang cần hiện
        public int Range {get; set;}
    }
}
