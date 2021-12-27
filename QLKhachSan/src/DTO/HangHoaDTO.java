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
public class HangHoaDTO {
    public String mahang,makho,tenhang,donvitinh;
    public int gia,soluong;
public HangHoaDTO(){}

    public HangHoaDTO(String mahang, String makho, String tenhang, String donvitinh, int gia, int soluong) {
        this.mahang = mahang;
        this.makho = makho;
        this.tenhang = tenhang;
        this.donvitinh = donvitinh;
        this.gia = gia;
        this.soluong = soluong;
    }

    public String getMahang() {
        return mahang;
    }

    public void setMahang(String mahang) {
        this.mahang = mahang;
    }

    public String getMakho() {
        return makho;
    }

    public void setMakho(String makho) {
        this.makho = makho;
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

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
    
}
