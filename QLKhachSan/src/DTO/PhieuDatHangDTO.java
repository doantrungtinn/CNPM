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
public class PhieuDatHangDTO {
    public String mapdh, manv,thoigiangiao,tennhacc;
    public int tongsl, tongtien;
    
    public PhieuDatHangDTO() {
        
    }
    
    public PhieuDatHangDTO(String mapdh, String manv, int tongsl, int tongtien, String tennhacc, String thoigiangiao){
        this.mapdh=mapdh;
        this.manv=manv;
        this.tongsl=tongsl;
        this.tongtien=tongtien;
        this.tennhacc=tennhacc;
        this.thoigiangiao=thoigiangiao;
    }

    public String getMapdh() {
        return mapdh;
    }

    public void setMapdh(String mapdh) {
        this.mapdh = mapdh;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getThoigiangiao() {
        return thoigiangiao;
    }

    public void setThoigiangiao(String thoigiangiao) {
        this.thoigiangiao = thoigiangiao;
    }

    public String getTennhacc() {
        return tennhacc;
    }

    public void setTennhacc(String tennhacc) {
        this.tennhacc = tennhacc;
    }

    public int getTongsl() {
        return tongsl;
    }

    public void setTongsl(int tongsl) {
        this.tongsl = tongsl;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }
    
    
}
