/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Truong Thuy Doanh
 */
public class ThongKeHangHoaDTO {
    public String manv, ngaytk, ngaybd, ngaykt;
    
    public ThongKeHangHoaDTO(){
        
    }
    
    public ThongKeHangHoaDTO(String manv, String ngaytk, String ngaybd, String ngaykt){
        this.manv=manv;
        this.ngaytk=ngaytk;
        this.ngaybd=ngaybd;
        this.ngaykt=ngaykt;
        
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getNgaytk() {
        return ngaytk;
    }

    public void setNgaytk(String ngaytk) {
        this.ngaytk = ngaytk;
    }

    public String getNgaybd() {
        return ngaybd;
    }

    public void setNgaybd(String ngaybd) {
        this.ngaybd = ngaybd;
    }

    public String getNgaykt() {
        return ngaykt;
    }

    public void setNgaykt(String ngaykt) {
        this.ngaykt = ngaykt;
    }
    
    
}
