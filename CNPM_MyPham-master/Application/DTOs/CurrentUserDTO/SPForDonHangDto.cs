namespace Application.DTOs.CurrentUserDTO
{
    public class SPForDonHangDto
    {
        public SanPhamDto SP{ get; set;}
        public int soluong { get; set;}
        public SPForDonHangDto(){}
        public SPForDonHangDto(SanPhamDto SP, int soluong){
            this.SP = SP;
            this.soluong = soluong;
        }

        public void setSoluong(int soluong){
            this.soluong = soluong;
        }
    }
}