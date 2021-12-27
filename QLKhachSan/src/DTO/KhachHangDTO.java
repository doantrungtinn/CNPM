package DTO;


public class KhachHangDTO {
    private String MaKH, TenKH, SDT, Email,Diachi, Ngaysinh;
    

	public KhachHangDTO(String MaKH, String TenKH, String Ngaysinh, String SDT,String Email,String Diachi ) {
		
            this.MaKH = MaKH;
            this.TenKH = TenKH;
            this.Ngaysinh = Ngaysinh;
            this.SDT = SDT;  
            this.Email = Email;
            this.Diachi = Diachi; 
	}
    public KhachHangDTO() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    
	public String getMaKH() {
		return MaKH;
	}
	public void setMaKH(String MaKH) {
		MaKH = MaKH;
	}

	public String getTenKH() {
		return TenKH;
	}
	public void setTenKH(String TenKH) {
		this.TenKH = TenKH;
	}
	
	public String getNgaysinh() {
		return Ngaysinh;
	}
	public void setNgaysinh(String Ngaysinh) {
		this.Ngaysinh = Ngaysinh;
	}
	
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String SDT) {
		this.SDT = SDT;
	}

	public String getEmail() {
		return Email;
	}
	public void setEmail(String Email) {
		this.Email = Email;
	}
        
        public String getDiachi() {
		return Diachi;
	}
	public void setDiachi(String Diachi) {
		this.Diachi = Diachi;
	}
}
