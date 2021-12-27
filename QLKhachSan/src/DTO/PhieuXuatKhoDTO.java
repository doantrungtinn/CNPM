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
public class PhieuXuatKhoDTO {
    public String mapxk, makho, manv,ngayxuatkho,manv_nhanhang,lydoxuatkho;
    public int tongslyeucau, tongslthucxuat, tongtien;
    
    public PhieuXuatKhoDTO() {
        
    }
    
    public PhieuXuatKhoDTO(String mapxk, String makho, String manv, String ngayxuatkho, int tongslyeucau, int tongslthucxuat, int tongtien, String manv_nhanhang, String lydoxuatkho){
        this.mapxk=mapxk;
        this.makho=makho;
        this.manv=manv;
        this.ngayxuatkho=ngayxuatkho;
        this.tongslyeucau=tongslyeucau;
        this.tongslthucxuat=tongslthucxuat;
        this.tongtien=tongtien;
        this.manv_nhanhang=manv_nhanhang;
        this.lydoxuatkho=lydoxuatkho;
    }

    public String getMapxk() {
        return mapxk;
    }

    public void setMapxk(String mapxk) {
        this.mapxk = mapxk;
    }

    public String getMakho() {
        return makho;
    }

    public void setMakho(String makho) {
        this.makho = makho;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getNgayxuatkho() {
        return ngayxuatkho;
    }

    public void setNgayxuatkho(String ngayxuatkho) {
        this.ngayxuatkho = ngayxuatkho;
    }

    public String getManv_nhanhang() {
        return manv_nhanhang;
    }

    public void setManv_nhanhang(String manv_nhanhang) {
        this.manv_nhanhang = manv_nhanhang;
    }

    public String getLydoxuatkho() {
        return lydoxuatkho;
    }

    public void setLydoxuatkho(String lydoxuatkho) {
        this.lydoxuatkho = lydoxuatkho;
    }

    public int getTongslyeucau() {
        return tongslyeucau;
    }

    public void setTongslyeucau(int tongslyeucau) {
        this.tongslyeucau = tongslyeucau;
    }

    public int getTongslthucxuat() {
        return tongslthucxuat;
    }

    public void setTongslthucxuat(int tongslthucxuat) {
        this.tongslthucxuat = tongslthucxuat;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }
    
    

}
