/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.PhieuDatHangDAO;
import DTO.PhieuDatHangDTO;
import java.util.ArrayList;

/**
 *
 * @author Truong Thuy Doanh
 */
public class PhieuDatHangBUS {
    public static ArrayList<PhieuDatHangDTO>dspdh;
    public PhieuDatHangBUS()
    {
        
    }
    
    public void docDSPDH()
    {
        PhieuDatHangDAO data = new PhieuDatHangDAO();
        if(dspdh==null)
            dspdh = new ArrayList<PhieuDatHangDTO>();
        dspdh= data.docDSPDH();
    }
}
