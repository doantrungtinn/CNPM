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
public class ThongKeLoaiPhongDTO {
    private String loaiphong;
    private int soluotdat;
    public ThongKeLoaiPhongDTO(){}

    public ThongKeLoaiPhongDTO(String loaiphong, int soluotdat) {
        this.loaiphong = loaiphong;
        this.soluotdat = soluotdat;
    }

    public String getLoaiphong() {
        return loaiphong;
    }

    public void setLoaiphong(String loaiphong) {
        this.loaiphong = loaiphong;
    }

    public int getSoluotdat() {
        return soluotdat;
    }

    public void setSoluotdat(int soluotdat) {
        this.soluotdat = soluotdat;
    }
    
    
}
