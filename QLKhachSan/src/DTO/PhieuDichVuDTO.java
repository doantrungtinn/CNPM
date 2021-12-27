/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author lenovo-x220i
 */
public class PhieuDichVuDTO {
    public String maphieu,madat,ngaylapphieu;
    public int tongtien;

     public PhieuDichVuDTO() {
       
    }
    public PhieuDichVuDTO(String maphieu, String madat, String ngaylapphieu, int tongtien) {
        this.maphieu = maphieu;
        this.madat = madat;
        this.ngaylapphieu = ngaylapphieu;
        this.tongtien = tongtien;
    }

   

    public String getMaphieu() {
        return maphieu;
    }

    public void setMaphieu(String maphieu) {
        this.maphieu = maphieu;
    }

    public String getMadat() {
        return madat;
    }

    public void setMadat(String madat) {
        this.madat = madat;
    }

    public String getNgaylapphieu() {
        return ngaylapphieu;
    }

    public void setNgaylapphieu(String ngaylapphieu) {
        this.ngaylapphieu = ngaylapphieu;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }
    
}
