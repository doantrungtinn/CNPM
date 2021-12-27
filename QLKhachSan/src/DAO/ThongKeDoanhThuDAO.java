/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.DichVuDTO;
import DTO.ThongKeDoanhThuDTO;
import DTO.ThongKePhieuDVDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo-x220i
 */
public class ThongKeDoanhThuDAO {
    public ArrayList dochoadon ()
    {
         MySQLConnect ConnectData = new MySQLConnect();
         ArrayList <ThongKeDoanhThuDTO> dsdt = new ArrayList <> (); 
          
          try
          {
              String qry = "select ngaylaphd, thuctra from hoadon";
            ConnectData.st = ConnectData.conn.createStatement();
            ConnectData.rs = ConnectData.st.executeQuery(qry);
              int i=1;
             while(ConnectData.rs.next())
              {
                  ThongKeDoanhThuDTO dt = new ThongKeDoanhThuDTO();

                  dt.setThang(ConnectData.rs.getDate(1));
                  dt.setTongdoanhthu(ConnectData.rs.getLong(2));
                  dsdt.add(dt);
             }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
        ConnectData.MySQLDisconnect();
        return dsdt;
    }
    
}
