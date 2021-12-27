using System.ComponentModel.DataAnnotations;
namespace Application.DTOs
{
    public class PassDto
    {
        [Required(ErrorMessage = "Mật khẩu là bắt buộc")]
        [StringLength(maximumLength:25, MinimumLength = 4, ErrorMessage = "Mật khẩu từ 4 đến 25 kí tự")]
        public string oldpass {get; set;}

        [Required(ErrorMessage = "Mật khẩu mới là bắt buộc")]
        [StringLength(maximumLength:25, MinimumLength = 4, ErrorMessage = "Mật khẩu mới từ 4 đến 25 kí tự")]
        public string newpass { get; set;} 
        
        [Compare(otherProperty:"newpass", ErrorMessage ="Nhập lại mật khẩu không khớp với mật khẩu mới đã nhập")]
        public string repass { get; set;}
    }
}