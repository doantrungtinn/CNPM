/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.PhongTrongDAO;
import DTO.PhongTrongDTO;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class PhongTrongBUS {
    public static ArrayList<PhongTrongDTO> dsphongtrong;
    
    public PhongTrongBUS()
    {
        
    }
    
    public void readAvailableRoom(String datefrom, String dateto)
    {
        PhongTrongDAO data = new PhongTrongDAO();
        if(dsphongtrong==null)        
            dsphongtrong = new ArrayList<PhongTrongDTO>();                            
        dsphongtrong=data.docDSPhongTrong(datefrom, dateto); 
    }
    
}
