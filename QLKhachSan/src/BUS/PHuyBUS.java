/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.PhieuHuyDAO;
import DTO.PHuyDTO;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class PHuyBUS {
    public static ArrayList<PHuyDTO>dsphuy;
    public PHuyBUS()
    {
        
    }
    
    public void docDSHuy()
    {
        PhieuHuyDAO data = new PhieuHuyDAO();
        if(dsphuy==null)
            dsphuy = new ArrayList<PHuyDTO>();
        dsphuy = data.docDSPHuy();
    }
    
    public String nextPD()
    {
        
        return "PHUY"+(dsphuy.size()+1);
    }
    public void them(PHuyDTO ph)
    {
        PhieuHuyDAO data = new PhieuHuyDAO();
        data.them(ph);
    }
    
    
}
