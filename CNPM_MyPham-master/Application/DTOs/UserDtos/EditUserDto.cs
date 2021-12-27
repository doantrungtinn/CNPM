using System;
using System.ComponentModel.DataAnnotations;
namespace Application.DTOs.UserDtos
{
    public class EditUserDto
    {
        [Key]
        [Required(ErrorMessage = "Tài khoản bắt buộc")]
        [StringLength(maximumLength:25, MinimumLength = 3, ErrorMessage = "Tên đăng nhập từ 3 đến 25 kí tự")]
        [RegularExpression(pattern: @"^[a-zA-Z][\w]{1,}", ErrorMessage="Tài khoản phải bắt đầu bằng chữ")]
        public string user{get; set;}

        [Required(ErrorMessage = "Họ tên là bắt buộc")]
        [StringLength(maximumLength:100, MinimumLength = 4, ErrorMessage = "Họ tên từ 4 đến 100 kí tự")]
        public string full_name{get; set;}

        [Required(ErrorMessage = "Số điện thoại là bắt buộc")]
        [RegularExpression(pattern: "^([\\d]{10,11})", ErrorMessage="Số điện thoại phải là số và dài từ 10 đến 11")]
        public string phone{get; set;}

        [Required(ErrorMessage = "Thư điện tử là bắt buộc")]
        [EmailAddress(ErrorMessage = "Thư điện tử không phù hợp")]
        public string mail{get; set;}

        [Required(ErrorMessage = "Địa chỉ là bắt buộc")]
        public string address {get; set;}

        [Required(ErrorMessage = "Giới tính là bắt buộc")]
        public string sex{get; set;}

        [Required(ErrorMessage = "Ngày sinh là bắt buộc")]
        [DataType(DataType.Date)]
        public DateTime dateborn{get; set;}
        public EditUserDto(KhachHangDto kh){
            user = kh.user;
            full_name = kh.full_name;
            phone = kh.phone;
            mail = kh.mail;
            address = kh.address;
            sex = kh.sex;
            dateborn = kh.dateborn;
        }

        public EditUserDto(){
            
        }
    }
}