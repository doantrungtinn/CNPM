
using System;
using System.Collections.Generic;
//Microsoft.EntityFrameworkCore
using System.ComponentModel.DataAnnotations;

namespace Domain.Entities
{
    public class KhachHang
    {
        [Key]
        [Required(ErrorMessage = "Tài khoản bắt buộc")]
        [StringLength(maximumLength:25, MinimumLength = 3, ErrorMessage = "Tài khoản từ 3 đến 25 kí tự")]
        [RegularExpression(pattern: @"^[a-zA-Z][\w]{1,}", ErrorMessage="Tài khoản phải bắt đầu bằng chữ")]
        public string user{get; set;}

        [Required(ErrorMessage = "Mật khẩu là bắt buộc")]
        [StringLength(maximumLength:25, MinimumLength = 4, ErrorMessage = "Mật khẩu từ 4 đến 25 kí tự")]
        public string pass{get; set;}

        [Compare(otherProperty:"pass", ErrorMessage ="Nhập lại mật khẩu không khớp với mật khẩu đã nhập")]
        public string repass{get; set;}

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

        [Required(ErrorMessage = "Trạng thái là bắt buộc")]
        [RegularExpression(pattern: "(1|0)/g", ErrorMessage="Trạng thái là 1 hoặc 0")]
        public int status{get; set;}

        public ICollection<HoaDon> hoadons {get; set;}

        public KhachHang()
        {
            status = 1;
            this.hoadons = new HashSet<HoaDon>();
        }
    }
}