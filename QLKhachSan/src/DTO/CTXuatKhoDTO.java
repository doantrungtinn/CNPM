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
public class CTXuatKhoDTO {
    String mapxk, mahang;
    int slyeucau, slthucxuat,thanhtien;
    
    public CTXuatKhoDTO(){
        mapxk =null;
        mahang = null;
        slyeucau=0;
        slthucxuat=0;
        thanhtien=0;
    }
    
    public CTXuatKhoDTO(String mapxk, String mahang, int slyeucau, int slthucxuat, int thanhtien){
        this.mapxk=mapxk;
        this.mahang=mahang;
        this.slyeucau=slyeucau;
        this.slthucxuat=slthucxuat;
        this.thanhtien=thanhtien;
    }

    public String getMapxk() {
        return mapxk;
    }

    public void setMapxk(String mapxk) {
        this.mapxk = mapxk;
    }

    public String getMahang() {
        return mahang;
    }

    public void setMahang(String mahang) {
        this.mahang = mahang;
    }

    public int getSlyeucau() {
        return slyeucau;
    }

    public void setSlyeucau(int slyeucau) {
        this.slyeucau = slyeucau;
    }

    public int getSlthucxuat() {
        return slthucxuat;
    }

    public void setSlthucxuat(int slthucxuat) {
        this.slthucxuat = slthucxuat;
    }

    public int getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(int thanhtien) {
        this.thanhtien = thanhtien;
    }

}
