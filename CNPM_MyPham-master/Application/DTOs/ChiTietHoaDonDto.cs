using System.ComponentModel.DataAnnotations;

namespace Application.DTOs
{
    public class ChiTietHoaDonDto
    {
        [Key]
        [Required(ErrorMessage = "Mã hóa đơn là bắt buộc")]
        public int bill_id{get; set;}

        [Key]
        [Required(ErrorMessage = "Mã sản phẩm là bắt buộc")]
        public int product_id{get; set;}

        [Required(ErrorMessage = "Tên sản phẩm là bắt buộc")]
        public string name {get; set;}

        [Required(ErrorMessage = "Số lượng sản phẩm là bắt buộc")]
        public int amount { get; set;}

        [Required(ErrorMessage = "Đơn giá là bắt buộc")]
        public long price { get; set;}
        
        [Required(ErrorMessage = "Hình ảnh là bắt buộc")]
        public string img {get; set;}
    }
}