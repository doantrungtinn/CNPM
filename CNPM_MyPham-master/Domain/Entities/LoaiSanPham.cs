using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Domain.Entities
{
    public class LoaiSanPham
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        [Required(ErrorMessage = "Mã loại sản phẩm là bắt buộc")]
        public int product_type_id {get; set;}

        [Required(ErrorMessage = "Tên loại sản phẩm là bắt buộc")]
        public string name {get; set;}

        [Required(ErrorMessage = "Mô tả là bắt buộc")]
        public string description {get; set;}

        public ICollection<SanPham> SanPhams {get; set;}

        public LoaiSanPham(){
            this.SanPhams = new HashSet<SanPham>();
        }
    }
}