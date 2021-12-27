/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author DELL
 */
public class PDatPhongDTO {
    private String madat, makhdat, manv, ngaydatphong, ngayden, ngaydi;
    private int tienphong, tiencoc;
    private String tennguoiluutru, cmndnguoiluutru, trangthai;
    
    public PDatPhongDTO()
    {        
        tienphong=0;
        tiencoc=0;
        tennguoiluutru=null;
        cmndnguoiluutru=null;
        trangthai=null;
        
    }
    
    public PDatPhongDTO(String madat, String makhdat, String manv, String ngaydatphong, String ngayden, String ngaydi, int tienphong, int tiencoc, String tennguoiluutru, String cmndnguoiluutru, String trangthai)
    {       
        this.madat=madat;
        this.makhdat=makhdat;
        this.manv=manv;
        this.ngaydatphong=ngaydatphong;
        this.ngayden=ngayden;
        this.ngaydi=ngaydi;
        this.tienphong=tienphong;
        this.tiencoc=tiencoc;
        this.tennguoiluutru=tennguoiluutru;
        this.cmndnguoiluutru=cmndnguoiluutru;
        this.trangthai=trangthai;             
    }
    
    public String getMadat() {
        return madat;
    }

    public void setMadat(String madat) {
        this.madat = madat;
    }

    public String getMakhdat() {
        return makhdat;
    }

    public void setMakhdat(String makhdat) {
        this.makhdat = makhdat;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getNgaydatphong() {
        return ngaydatphong;
    }

    public void setNgaydatphong(String ngaydatphong) {
        this.ngaydatphong = ngaydatphong;
    }

    public String getNgayden() {
        return ngayden;
    }

    public void setNgayden(String ngayden) {
        this.ngayden = ngayden;
    }

    public String getNgaydi() {
        return ngaydi;
    }

    public void setNgaydi(String ngaydi) {
        this.ngaydi = ngaydi;
    }

    public int getTienphong() {
        return tienphong;
    }

    public void setTienphong(int tienphong) {
        this.tienphong = tienphong;
    }

    public int getTiencoc() {
        return tiencoc;
    }

    public void setTiencoc(int tiencoc) {
        this.tiencoc = tiencoc;
    }

    public String getTennguoiluutru() {
        return tennguoiluutru;
    }

    public void setTennguoiluutru(String tennguoiluutru) {
        this.tennguoiluutru = tennguoiluutru;
    }

    public String getCmndnguoiluutru() {
        return cmndnguoiluutru;
    }

    public void setCmndnguoiluutru(String cmndnguoiluutru) {
        this.cmndnguoiluutru = cmndnguoiluutru;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }
    
    public static void main(String []args)
    {
        //String madat, String makhdat, String manv, String ngaydatphong, String ngayden, String ngaydi, int tienphong, 
        //int tiencoc, String tennguoiluutru, String cmndnguoiluutru, String trangthai
//        PDatPhongDTO pd = new PDatPhongDTO("PD20","045613583","LT1","2020-11-10","2020-11-15","2020-11-20",5,4,"","","Đã nhận phòng");
//            String query="insert into phieudatphong values('";
//            query+=pd.getMadat()+"','"+pd.getMakhdat()+"','"+pd.getManv()+"','";          
//            query+=pd.getNgaydatphong()+"','"+pd.getNgayden()+"','"+pd.getNgaydi()+"','";
//            query+=pd.getTienphong()+"','"+pd.getTiencoc()+"','"+pd.getTennguoiluutru()+"','";
//            query+=pd.getCmndnguoiluutru()+"','"+pd.getTrangthai()+"')";
//            System.out.println(query
//            );
     
    }
    
}