/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.KhachDAO;
import DTO.KhachDTO;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class KhachBUS {
    public static ArrayList<KhachDTO> dskh;
    
    public KhachBUS()
    {
        
    }
    
    public void docDSKH()
    {
        KhachDAO data = new KhachDAO();
        if(dskh==null)
            dskh= new ArrayList<KhachDTO>();
        dskh=data.docDSKhach();        
    }
    
    
}
