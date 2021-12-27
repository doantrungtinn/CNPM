/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.CTDatHangDAO;
import DTO.CTDatHangDTO;
import java.util.ArrayList;

/**
 *
 * @author Truong Thuy Doanh
 */
public class CTDatHangBUS {
    public static ArrayList<CTDatHangDTO> dsctdat;
    
    public CTDatHangBUS()
    {
        
    }
    
    public void docCTDHtheoMa(String ma)
    {
        CTDatHangDAO data = new CTDatHangDAO();
        if(dsctdat==null)
           dsctdat = new ArrayList<>();
        dsctdat = data.docDSCTDHtheoMa(ma);
    }
    
}
