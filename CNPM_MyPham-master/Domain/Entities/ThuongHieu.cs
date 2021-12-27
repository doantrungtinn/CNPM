using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Domain.Entities
{
    public class ThuongHieu
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        [Required]
        public int brand_id {get; set;}

        [Required(ErrorMessage = "Tên thương hiệu là bắt buộc")]
        public string name {get; set;}

        public ICollection<SanPham> SanPhams {get; set;}

        public ThuongHieu(){
            this.SanPhams = new HashSet<SanPham>();
        }
    }
}