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
public class CTDatPhongDTO {
    String madat, maphong;
    int dongia;
    public CTDatPhongDTO()
    {
        madat=null;
        maphong=null;
        dongia=0;
    }
    
    public CTDatPhongDTO(String madat, String maphong, int dongia)
    {
        this.madat=madat;
        this.maphong=maphong;
        this.dongia=dongia;
    }

    public String getMadat() {
        return madat;
    }

    public void setMadat(String madat) {
        this.madat = madat;
    }

    public String getMaphong() {
        return maphong;
    }

    public void setMaphong(String maphong) {
        this.maphong = maphong;
    }

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }
       
}
