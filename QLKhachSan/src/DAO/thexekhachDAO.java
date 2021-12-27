/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.thexekhachDTO;
import java.sql.SQLException;
import java.time.LocalDateTime;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author TRAN VAN BO
 */
public class thexekhachDAO {
    public ArrayList docdsthexekhach() throws SQLException{
        MySQLConnect ConnectData =new MySQLConnect();
        ArrayList <thexekhachDTO> dstxk =new ArrayList<thexekhachDTO> ();
        try 
        {
            String qry ="select txk.mathe,txk.soxe,txk.loaixe,txk.maxe,ql.thoigianvao,ql.thoigianra \n"
                    +"from qlxe as ql ,thexekhach as txk\n" + "where ql.maxe=txk.maxe ";
            ConnectData.st = ConnectData.conn.createStatement();
            ConnectData.rs = ConnectData.st.executeQuery(qry);
            while (ConnectData.rs.next()){
                thexekhachDTO tx =new thexekhachDTO();
         
                tx.setMathe(ConnectData.rs.getString(1));
                tx.setMaxe(ConnectData.rs.getString(2));
                tx.setThoigianvao(LocalDateTime.MIN);
                tx.setThoigianra(LocalDateTime.MIN);  
                tx.setLoaixe(ConnectData.rs.getString(3));
                tx.setSoxe(ConnectData.rs.getString(4));
                tx.setTrangthai(ConnectData.rs.getString(5));
              dstxk.add(tx);
              
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
        ConnectData.MySQLDisconnect();
        return dstxk;
    }
}
