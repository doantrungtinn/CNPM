using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Application.DTOs
{
    public class SanPhamDto
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        [Required(ErrorMessage = "Mã sản phẩm là bắt buộc")]
        public int product_id{get; set;}

        [Required(ErrorMessage = "Mã loại là bắt buộc")]
        public int product_type_id {get; set;}

        [Required(ErrorMessage = "Mã thương hiệu là bắt buộc")]
        public int brand_id {get; set;}

        [Required(ErrorMessage = "Tên sản phẩm là bắt buộc")]
        public string name {get; set;}

        public int amount {get; set;}

        [Required(ErrorMessage = "Giá là bắt buộc")]
        public long price {get; set;}

        [Required(ErrorMessage = "Mô tả là bắt buộc")]
        public string description {get; set;}

        [Required(ErrorMessage = "Cách sử dụng là bắt buộc")]
        public string use {get; set;}

        [Required(ErrorMessage = "Hình ảnh là bắt buộc")]
        public string img {get; set;}

        public int status {get; set;}

        public virtual LoaiSanPhamDto loaisanphamdto {get; set;}

        public virtual ThuongHieuDto thuonghieudto {get; set;}

        // public ICollection<ThuongHieuAndSanPham> ThuongHieuAndSanPhams {get; set;}

        public SanPhamDto(){
            amount = 0;
            status = 1;
            // this.ThuongHieuAndSanPhams = new HashSet<ThuongHieuAndSanPham>();
        }
    }
}