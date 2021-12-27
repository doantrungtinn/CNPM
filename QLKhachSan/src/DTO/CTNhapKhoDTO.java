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
public class CTNhapKhoDTO {
    String mapnk, mahang;
    int slchungtu, slthucnhap,thanhtien;
    
    public CTNhapKhoDTO(){
        mapnk =null;
        mahang = null;
        slchungtu=0;
        slthucnhap=0;
        thanhtien=0;
    }
    
    public CTNhapKhoDTO(String mapnk, String mahang, int slchungtu, int slthucnhap, int thanhtien){
        this.mapnk=mapnk;
        this.mahang=mahang;
        this.slchungtu=slchungtu;
        this.slthucnhap=slthucnhap;
        this.thanhtien=thanhtien;
    }

    public String getMapnk() {
        return mapnk;
    }

    public void setMapnk(String mapnk) {
        this.mapnk = mapnk;
    }

    public String getMahang() {
        return mahang;
    }

    public void setMahang(String mahang) {
        this.mahang = mahang;
    }


    public int getSlchungtu() {
        return slchungtu;
    }

    public void setSlchungtu(int slchungtu) {
        this.slchungtu = slchungtu;
    }

    public int getSlthucnhap() {
        return slthucnhap;
    }

    public void setSlthucnhap(int slthucnhap) {
        this.slthucnhap = slthucnhap;
    }

    public int getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(int thanhtien) {
        this.thanhtien = thanhtien;
    }
    
    
    
}
