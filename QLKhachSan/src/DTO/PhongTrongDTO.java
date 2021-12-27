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
public class PhongTrongDTO {
   private String maphong, maloai,mota;
   private int tang, gia;
   
   
   public PhongTrongDTO()
   {
       
   }
   
   public PhongTrongDTO(String maphong, String maloai, String mota, int tang, int gia)
   {
       this.maphong=maphong;
       this.maloai=maloai;
       this.mota=mota;
       this.tang=tang;
       this.gia=gia;
   }

    public String getMaphong() {
        return maphong;
    }

    public void setMaphong(String maphong) {
        this.maphong = maphong;
    }

    public String getMaloai() {
        return maloai;
    }

    public void setMaloai(String maloai) {
        this.maloai = maloai;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getTang() {
        return tang;
    }

    public void setTang(int tang) {
        this.tang = tang;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
   
   
}
