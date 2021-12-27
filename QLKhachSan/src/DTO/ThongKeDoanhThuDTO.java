/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

/**
 *
 * @author lenovo-x220i
 */
public class ThongKeDoanhThuDTO {
    private Long tongdoanhthu;
    private Date thang;
    public ThongKeDoanhThuDTO(){}

    public ThongKeDoanhThuDTO(Long tongdoanhthu, Date thang) {
        this.tongdoanhthu = tongdoanhthu;
        this.thang = thang;
      
    }

    public Long getTongdoanhthu() {
        return tongdoanhthu;
    }

    public void setTongdoanhthu(Long tongdoanhthu) {
        this.tongdoanhthu = tongdoanhthu;
    }

    public Date getThang() {
        return thang;
    }

    public void setThang(Date thang) {
        this.thang = thang;
    }
    
}
