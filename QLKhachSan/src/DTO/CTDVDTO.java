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
public class CTDVDTO {
    private String maphieudv,madv,ngaysudungdv;
    private int soluong,thanhtien;
    public CTDVDTO() {       
    }

    public CTDVDTO(String maphieudv, String madv, String ngaysudungdv, int soluong, int thanhtien) {
        this.maphieudv = maphieudv;
        this.madv = madv;
        this.ngaysudungdv = ngaysudungdv;
        this.soluong = soluong;
        this.thanhtien = thanhtien;
    }

    public String getMaphieudv() {
        return maphieudv;
    }

    public void setMaphieudv(String maphieudv) {
        this.maphieudv = maphieudv;
    }

    public String getMadv() {
        return madv;
    }

    public void setMadv(String madv) {
        this.madv = madv;
    }

    public String getNgaysudungdv() {
        return ngaysudungdv;
    }

    public void setNgaysudungdv(String ngaysudungdv) {
        this.ngaysudungdv = ngaysudungdv;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(int thanhtien) {
        this.thanhtien = thanhtien;
    }
      
    
}
