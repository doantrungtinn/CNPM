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
public class DichVuDTO {
     public String madv,maloaidv,tendv,donvtinh,tenloaidv;
     private int dongia;
public DichVuDTO() {
       
    }

    public DichVuDTO(String madv, String maloaidv, String tendv, String donvtinh, String tenloaidv, int dongia) {
        this.madv = madv;
        this.maloaidv = maloaidv;
        this.tendv = tendv;
        this.donvtinh = donvtinh;
        this.tenloaidv = tenloaidv;
        this.dongia = dongia;
    }
    
    public String getTenloaidv() {
        return tenloaidv;
    }

    public void setTenloaidv(String tenloaidv) {
        this.tenloaidv = tenloaidv;
    }

    

    public String getMadv() {
        return madv;
    }

    public void setMadv(String madv) {
        this.madv = madv;
    }

    public String getMaloaidv() {
        return maloaidv;
    }

    public void setMaloaidv(String maloaidv) {
        this.maloaidv = maloaidv;
    }

    public String getTendv() {
        return tendv;
    }

    public void setTendv(String tendv) {
        this.tendv = tendv;
    }

    public String getDonvtinh() {
        return donvtinh;
    }

    public void setDonvtinh(String donvtinh) {
        this.donvtinh = donvtinh;
    }

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }
     
}
