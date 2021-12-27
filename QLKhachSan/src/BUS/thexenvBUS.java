/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.thexekhachDAO;
import DAO.thexenvDAO;
import DTO.thexenvDTO;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author TRAN VAN BO
 */
public class thexenvBUS {
    public static ArrayList<thexenvDTO>dstxnv;
    public thexenvBUS() {
    }
    public void docDSTXNV() throws SQLException
    {
        thexenvDAO data = new thexenvDAO();
        if(dstxnv==null)
            dstxnv= new ArrayList<thexenvDTO>();
        dstxnv=data.docdsthexenv();        
    }
}
