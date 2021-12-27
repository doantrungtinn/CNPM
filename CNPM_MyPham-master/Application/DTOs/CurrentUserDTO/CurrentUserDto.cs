using Application.DTOs.CurrentUserDTO;
using Domain.Entities;

namespace Application.DTOs
{
    public class CurrentUserDto
    {
        public KhachHangDto KhachHangDto {get; set;}
        public DonHangDto DonHangDto {get; set;}
        public CurrentUserDto(){
            DonHangDto = new DonHangDto();
        }
    }
}