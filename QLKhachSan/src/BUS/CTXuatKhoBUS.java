/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.CTXuatKhoDAO;
import DTO.CTXuatKhoDTO;
import java.util.ArrayList;

/**
 *
 * @author Truong Thuy Doanh
 */
public class CTXuatKhoBUS {
    public static ArrayList<CTXuatKhoDTO> dsctxuat;
    
    public CTXuatKhoBUS()
    {
        
    }
    
    public void docCTXKtheoMa(String ma)
    {
        CTXuatKhoDAO data = new CTXuatKhoDAO();
        if(dsctxuat==null)
           dsctxuat = new ArrayList<CTXuatKhoDTO>();
        dsctxuat = data.docDSCTXKtheoMa(ma);
    }
}
