/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.DanhSachDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Trang
 */
public class DanhSachDAO {
      public ArrayList docdsnhanvien ()
    {
         MySQLConnect ConnectData = new MySQLConnect();
         ArrayList <DanhSachDTO> ds = new ArrayList <DanhSachDTO> (); 
          try
          {
            String qry = "select * from `nhanvien`";
            ConnectData.st=ConnectData.conn.createStatement();
          ConnectData.rs = ConnectData.st.executeQuery(qry);
             while(ConnectData.rs.next())
              {
                  DanhSachDTO nv1 = new DanhSachDTO();
                  nv1.setManhanvien(ConnectData.rs.getString(1));
                  nv1.setMachucvu(ConnectData.rs.getString(2));
                  nv1.setTennhanvien(ConnectData.rs.getString(3));
                  nv1.setNgaysinh(ConnectData.rs.getString(4));
                  nv1.setGioitinh(ConnectData.rs.getString(5));
                  nv1.setDiachi(ConnectData.rs.getString(6));
                  nv1.setSodienthoai(ConnectData.rs.getString(7));
                  ds.add(nv1);
                           
              
               
             
          }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
        ConnectData.MySQLDisconnect();
        return ds;
    }
    
}
