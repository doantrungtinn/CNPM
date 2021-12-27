package DTO;


public class KhuyenMaiDTO {
    private String MaKM, TenKM, NgayBD, NgayKT;
    private int Giamgia;
    

	public KhuyenMaiDTO(String MaKM, String TenKM,  int Giamgia,String NgayBD, String NgayKT) {
		
            this.MaKM = MaKM;
            this.TenKM = TenKM;
            this.Giamgia = Giamgia;
            this.NgayBD = NgayBD;
            this.NgayKT = NgayKT;                  
	}
    public KhuyenMaiDTO() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
	public String getMaKM() {
		return MaKM;
	}
	public void setMaKM(String MaKM) {
		MaKM = MaKM;
	}

	public String getTenKM() {
		return TenKM;
	}
	public void setTenKM(String TenKM) {
		this.TenKM = TenKM;
	}
	
	public String getNgayBD() {
		return NgayBD;
	}
	public void setNgayBD(String NgayBD) {
		this.NgayBD = NgayBD;
	}
	
	public String getNgayKT() {
		return NgayKT;
	}
	public void setNgayKT(String NgayKT) {
		this.NgayKT = NgayKT;
	}

	public int getGiamgia() {
		return Giamgia;
	}
	public void setGiamgia(int Giamgia) {
		this.Giamgia = Giamgia;
	}
}
