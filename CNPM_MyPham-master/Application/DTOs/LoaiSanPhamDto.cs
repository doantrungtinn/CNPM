using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Application.DTOs
{
    public class LoaiSanPhamDto
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        [Required(ErrorMessage = "Mã loại sản phẩm là bắt buộc")]
        public int product_type_id {get; set;}

        [Required(ErrorMessage = "Tên loại sản phẩm là bắt buộc")]
        public string name {get; set;}

        [Required(ErrorMessage = "Mô tả là bắt buộc")]
        public string description {get; set;}

        public ICollection<SanPhamDto> SanPhamdtos {get; set;}

        public LoaiSanPhamDto(){
            this.SanPhamdtos = new HashSet<SanPhamDto>();
        }

        public LoaiSanPhamDto(int product_type_id, string name, string description)
        {
            this.product_type_id = product_type_id;
            this.name = name;
            this.description = description;
        }
    }
}