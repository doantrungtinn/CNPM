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
public class CTDatHangDTO {
   
    String mapdh, mahang, tenhang, donvitinh;
    int sl, thanhtien;
    
    public CTDatHangDTO(){
        mapdh = null;
        sl =0;
        thanhtien=0;
    }
    
    public CTDatHangDTO(String mapdh, String mahang, String tenhang, String donvitinh){
        this.mapdh=mapdh;
        this.mahang=mahang;
        this.tenhang=tenhang;
        this.donvitinh=donvitinh;
        this.sl=sl;
        this.thanhtien=thanhtien;
    }

    public String getMapdh() {
        return mapdh;
    }

    public void setMapdh(String mapdh) {
        this.mapdh = mapdh;
    }

    public String getMahang() {
        return mahang;
    }

    public void setMahang(String mahang) {
        this.mahang = mahang;
    }

    public String getTenhang() {
        return tenhang;
    }

    public void setTenhang(String tenhang) {
        this.tenhang = tenhang;
    }

    public String getDonvitinh() {
        return donvitinh;
    }

    public void setDonvitinh(String donvitinh) {
        this.donvitinh = donvitinh;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public int getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(int thanhtien) {
        this.thanhtien = thanhtien;
    }
    
    
}
