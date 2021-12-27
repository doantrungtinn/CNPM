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
public class ThongKePhieuDVDTO {
    public String loaidichvu;
    private String tendichvu;
    private int soluotdat;
    public ThongKePhieuDVDTO(){}

    public ThongKePhieuDVDTO(String tendichvu, int soluotdat, String loaidichvu) {
        this.tendichvu = tendichvu;
        this.soluotdat = soluotdat;
        this.loaidichvu= loaidichvu;
    }

    public String getTendichvu() {
        return tendichvu;
    }

    public String getLoaidichvu() {
        return loaidichvu;
    }

    public void setLoaidichvu(String loaidichvu) {
        this.loaidichvu = loaidichvu;
    }

    public void setTendichvu(String tendichvu) {
        this.tendichvu = tendichvu;
    }

    public int getSoluotdat() {
        return soluotdat;
    }

    public void setSoluotdat(int soluotdat) {
        this.soluotdat = soluotdat;
    }
    
}
