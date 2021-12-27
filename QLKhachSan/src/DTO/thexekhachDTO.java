/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.time.LocalDateTime;

/**
 *
 * @author TRAN VAN BO
 */
public class thexekhachDTO {
    public String mathe,soxe,loaixe,maxe,trangthai;
     public LocalDateTime thoigianvao,thoigianra;
    public thexekhachDTO() {
    }

    public thexekhachDTO(String mathe, String soxe, String loaixe, String maxe, String trangthai, LocalDateTime thoigianvao, LocalDateTime thoigianra) {
        this.mathe = mathe;
        this.soxe = soxe;
        this.loaixe = loaixe;
        this.maxe = maxe;
        this.trangthai = trangthai;
        this.thoigianvao = thoigianvao;
        this.thoigianra = thoigianra;
    }

    public LocalDateTime getThoigianvao() {
        return thoigianvao;
    }

    public void setThoigianvao(LocalDateTime thoigianvao) {
        this.thoigianvao = thoigianvao;
    }

    public LocalDateTime getThoigianra() {
        return thoigianra;
    }

    public void setThoigianra(LocalDateTime thoigianra) {
        this.thoigianra = thoigianra;
    }

  
    

    

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

   

    public String getMathe() {
        return mathe;
    }

    public void setMathe(String mathe) {
        this.mathe = mathe;
    }

    public String getSoxe() {
        return soxe;
    }

    public void setSoxe(String soxe) {
        this.soxe = soxe;
    }

    public String getLoaixe() {
        return loaixe;
    }

    public void setLoaixe(String loaixe) {
        this.loaixe = loaixe;
    }

    public String getMaxe() {
        return maxe;
    }

    public void setMaxe(String maxe) {
        this.maxe = maxe;
    }
    
}
