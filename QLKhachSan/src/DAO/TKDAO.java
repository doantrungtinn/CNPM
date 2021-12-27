/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.TKDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Trang
 */
public class TKDAO {
      public ArrayList docdstaikhoan ()
    {
         MySQLConnect ConnectData = new MySQLConnect();
         ArrayList <TKDTO> ds = new ArrayList <TKDTO> (); 
          try
          {
            String qry = "select * from `taikhoan`";
            ConnectData.st=ConnectData.conn.createStatement();
          ConnectData.rs = ConnectData.st.executeQuery(qry);
             while(ConnectData.rs.next())
              {
                  TKDTO tk = new TKDTO();
                  tk.setTentaikhoan(ConnectData.rs.getString(1));
                  tk.setMatkhau(ConnectData.rs.getString(2));
                  tk.setManhanvien(ConnectData.rs.getString(3));
                  tk.setTrangthai(ConnectData.rs.getString(4));
                  
                  ds.add(tk);
                           
              
               
             
          }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
        ConnectData.MySQLDisconnect();
        return ds;
    }
    
}
