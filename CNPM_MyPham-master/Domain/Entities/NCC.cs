using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Domain.Entities
{
    public class NCC
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        [Required(ErrorMessage = "Mã nhà cung cấp là bắt buộc")]
        public int ncc_id {get; set;}

        [Required(ErrorMessage = "Tên nhà cung cấp là bắt buộc")]
        public string name {get; set;}

        [Required(ErrorMessage = "Trạng thái là bắt buộc")]
        public int status { get; set; }
        public NCC(){
        }
    }
}