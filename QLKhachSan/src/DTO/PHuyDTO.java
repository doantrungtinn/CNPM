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
public class PHuyDTO {
    String mahuy, madp, manv, ngayhuy, lydo;
    public PHuyDTO()
    {
        
    }
    
    public PHuyDTO(String mahuy, String madp, String manv, String lydo)
    {
        this.mahuy=mahuy;
        this.madp=madp;
        this.manv=manv;
        this.lydo=lydo;
    }

    public String getMahuy() {
        return mahuy;
    }

    public void setMahuy(String mahuy) {
        this.mahuy = mahuy;
    }

    public String getMadp() {
        return madp;
    }

    public void setMadp(String madp) {
        this.madp = madp;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getNgayhuy() {
        return ngayhuy;
    }

    public void setNgayhuy(String ngayhuy) {
        this.ngayhuy = ngayhuy;
    }

    public String getLydo() {
        return lydo;
    }

    public void setLydo(String lydo) {
        this.lydo = lydo;
    }
    
    
}
