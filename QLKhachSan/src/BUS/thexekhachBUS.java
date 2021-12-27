/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.thexekhachDAO;
import DAO.thexenvDAO;
import DTO.thexekhachDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author TRAN VAN BO
 */
public class thexekhachBUS {
    public static ArrayList<thexekhachDTO>dstxk;
    public thexekhachBUS() {
    }
    public void docDSTXK() throws SQLException
    {
        thexekhachDAO data = new thexekhachDAO();
        if(dstxk==null)
            dstxk= new ArrayList<thexekhachDTO>();
        dstxk=data.docdsthexekhach();        
    }
}
