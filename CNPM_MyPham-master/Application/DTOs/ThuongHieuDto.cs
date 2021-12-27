using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Application.DTOs
{
    public class ThuongHieuDto
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        [Required]
        public int brand_id {get; set;}

        [Required(ErrorMessage = "Tên thương hiệu là bắt buộc")]
        public string name {get; set;}

        public ICollection<SanPhamDto> SanPhamdtos {get; set;}

        public ThuongHieuDto(){
            this.SanPhamdtos = new HashSet<SanPhamDto>();
        }
        public ThuongHieuDto(int brand_id, string name){
            this.brand_id = brand_id;
            this.name = name;
        }
    }
}