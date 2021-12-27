using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Domain.Entities
{
    public class ThuongHieuAndSanPham
    {
        [Key]
        [Required]
        public int brand_id {get; set;}

        [Key]
        [Required]
        public int product_id {get; set;}

        public virtual ThuongHieu thuonghieu {get; set;}

        public virtual SanPham sanpham {get; set;}
    }
}