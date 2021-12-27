/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ThongKeLoaiPhongDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo-x220i
 */
public class PhongTKDAO {
    public ArrayList docdsphong ()
    {
         MySQLConnect ConnectData = new MySQLConnect();
         ArrayList <ThongKeLoaiPhongDTO> dsphong = new ArrayList <ThongKeLoaiPhongDTO> (); 
          
          try
          {
              String qry = "SELECT count(ctdat.maphong) as SL, loaiphong.tenloai\n" +
"from phieudatphong,ctdat,phong,loaiphong\n" +
"where phieudatphong.madat=ctdat.madat and ctdat.maphong=phong.maphong and phong.maloaiph=loaiphong.maloaiph\n" +
"group BY loaiphong.tenloai";
            ConnectData.st = ConnectData.conn.createStatement();
            ConnectData.rs = ConnectData.st.executeQuery(qry);
              
             while(ConnectData.rs.next())
              {
                  ThongKeLoaiPhongDTO p = new ThongKeLoaiPhongDTO();
                  p.setLoaiphong(ConnectData.rs.getString(2));
                  p.setSoluotdat(ConnectData.rs.getInt(1));
                  dsphong.add(p);
             }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
        ConnectData.MySQLDisconnect();
        return dsphong;
    }
    public ArrayList docdsphongtheongay (String ngaybd,String ngaykt)
    {
         MySQLConnect ConnectData = new MySQLConnect();
         ArrayList <ThongKeLoaiPhongDTO> dsphongtheongay = new ArrayList <ThongKeLoaiPhongDTO> (); 
          
          try
          {
              String qry = "SELECT count(ctdat.maphong) as SL, loaiphong.tenloai\n" +
"from phieudatphong,ctdat,phong,loaiphong\n" +
"where phieudatphong.madat=ctdat.madat and ctdat.maphong=phong.maphong and phong.maloaiph=loaiphong.maloaiph and phieudatphong.ngaydatphong BETWEEN '"+ngaybd+"' and '"+ngaykt+"'\n" +
"group BY loaiphong.tenloai";
            ConnectData.st = ConnectData.conn.createStatement();
            ConnectData.rs = ConnectData.st.executeQuery(qry);
              
             while(ConnectData.rs.next())
              {
                  ThongKeLoaiPhongDTO p = new ThongKeLoaiPhongDTO();
                  p.setLoaiphong(ConnectData.rs.getString(2));
                  p.setSoluotdat(ConnectData.rs.getInt(1));
                  dsphongtheongay.add(p);
             }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
        ConnectData.MySQLDisconnect();
        return dsphongtheongay;
    } 
}
