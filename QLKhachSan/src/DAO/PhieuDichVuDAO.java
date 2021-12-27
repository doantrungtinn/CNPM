/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.PhieuDichVuDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo-x220i
 */
public class PhieuDichVuDAO {
     public ArrayList docdsphieudichvu()
    {
         MySQLConnect ConnectData = new MySQLConnect();
         ArrayList <PhieuDichVuDTO> dspdv= new ArrayList <PhieuDichVuDTO> (); 
          try
          {
              String qry = "select * from phieudvu";
            ConnectData.st = ConnectData.conn.createStatement();
            ConnectData.rs = ConnectData.st.executeQuery(qry);             
             while(ConnectData.rs.next())
              {
                  PhieuDichVuDTO pdv = new PhieuDichVuDTO();
                  pdv.setMaphieu(ConnectData.rs.getString(1));
                  pdv.setMadat(ConnectData.rs.getString(2));
                  pdv.setNgaylapphieu(ConnectData.rs.getString(3));
                  pdv.setTongtien(ConnectData.rs.getInt(4));
                  dspdv.add(pdv);
             }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
        ConnectData.MySQLDisconnect();
        return dspdv;
    }
}
