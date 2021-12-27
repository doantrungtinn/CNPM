using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Application.DTOs
{
    public class NCCDto
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        [Required(ErrorMessage = "Mã nhà cung cấp là bắt buộc")]
        public int ncc_id { get; set; }

        [Required(ErrorMessage = "Tên nhà cung cấp là bắt buộc")]
        public string name { get; set; }

        [Required(ErrorMessage = "Trạng thái là bắt buộc")]
        public int status { get; set; }
        public NCCDto(){
        }
        public NCCDto(int ncc_id, string name, int status){
            this.ncc_id = ncc_id;
            this.name = name;
            this.status = status;
        }
    }
}