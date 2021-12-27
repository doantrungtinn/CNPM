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
public class PhieuNhapKhoDTO {
    public String mapnk, makho, manv,ngaynhapkho,tennguoigiao,ghichu;
    public int tongsltrenchungtu, tongslthucnhap, tongtien;
    
    public PhieuNhapKhoDTO() {
        
    }
    
    public PhieuNhapKhoDTO(String mapnk, String makho, String manv, String ngaynhapkho, int tongsltrenchungtu, int tongslthucnhap, int tongtien, String tennguoigiao, String ghichu){
        this.mapnk=mapnk;
        this.makho=makho;
        this.manv=manv;
        this.ngaynhapkho=ngaynhapkho;
        this.tongsltrenchungtu=tongsltrenchungtu;
        this.tongslthucnhap=tongslthucnhap;
        this.tongtien=tongtien;
        this.tennguoigiao=tennguoigiao;
        this.ghichu=ghichu;
    }

    public String getMapnk() {
        return mapnk;
    }

    public void setMapnk(String mapnk) {
        this.mapnk = mapnk;
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

    public String getNgaynhapkho() {
        return ngaynhapkho;
    }

    public void setNgaynhapkho(String ngaynhapkho) {
        this.ngaynhapkho = ngaynhapkho;
    }

    public String getTennguoigiao() {
        return tennguoigiao;
    }

    public void setTennguoigiao(String tennguoigiao) {
        this.tennguoigiao = tennguoigiao;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public int getTongsltrenchungtu() {
        return tongsltrenchungtu;
    }

    public void setTongsltrenchungtu(int tongsltrenchungtu) {
        this.tongsltrenchungtu = tongsltrenchungtu;
    }

    public int getTongslthucnhap() {
        return tongslthucnhap;
    }

    public void setTongslthucnhap(int tongslthucnhap) {
        this.tongslthucnhap = tongslthucnhap;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }
    
}
