/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.PDatPhongDAO;
import DTO.PDatPhongDTO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class PDatPhongBUS {
    public static ArrayList<PDatPhongDTO>dspdphong;
    public PDatPhongBUS()
    {
        
    }
    
    public void docDSPDPhong()
    {
        PDatPhongDAO data = new PDatPhongDAO();
        if(dspdphong==null)
            dspdphong = new ArrayList<PDatPhongDTO>();
        dspdphong = data.docDSPDatPhong();
    }
    
    public String nextPD()
    {
        
        return "PD"+(dspdphong.size()+1);
    }
    
    public void themPD(PDatPhongDTO pd)
    {
        dspdphong.add(pd);
        PDatPhongDAO data = new PDatPhongDAO();
        data.them(pd);
        
        
    }
    
    public Long diffdays(String date1, String date2)
    {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate d1= LocalDate.parse(date1, format);
                LocalDate d2= LocalDate.parse(date2, format);
                Long daysBetween = ChronoUnit.DAYS.between(d1, d2);
                return daysBetween;
    }
    
    public void capnhatTrangThai(String madp, String trangthai)
    {        
        PDatPhongDAO data = new PDatPhongDAO();
        data.sua(madp, trangthai);
    }
}
