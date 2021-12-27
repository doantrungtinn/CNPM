/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.DichVuDTO;
import DTO.ThongKePhieuDVDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo-x220i
 */
public class DichVuTKDAO {
    public ArrayList docdsdichvu ()
    {
         MySQLConnect ConnectData = new MySQLConnect();
         ArrayList <DichVuDTO> dsdv = new ArrayList <DichVuDTO> (); 
          
          try
          {
              String qry = "select dv.madv,dv.maloaidv,dv.tendv,dv.dongia,dv.donvitinh,loaidv.tenloaidv\n" +
"from dichvu as dv,loaidv\n" +
"WHERE dv.maloaidv=loaidv.maloaidv";
            ConnectData.st = ConnectData.conn.createStatement();
            ConnectData.rs = ConnectData.st.executeQuery(qry);
              
             while(ConnectData.rs.next())
              {
                  DichVuDTO dv = new DichVuDTO();
                 
                  dv.setMadv(ConnectData.rs.getString(1));
                  dv.setMaloaidv(ConnectData.rs.getString(2));
                  dv.setTendv(ConnectData.rs.getString(3));
                  dv.setDongia(ConnectData.rs.getInt(4));
                  dv.setDonvtinh(ConnectData.rs.getString(5));
                  dv.setTenloaidv(ConnectData.rs.getString(6));
                  dsdv.add(dv);
             }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
        ConnectData.MySQLDisconnect();
        return dsdv;
    }
    public ArrayList docdsdvtheongay (String ngaybd,String ngaykt)
    {
         MySQLConnect ConnectData = new MySQLConnect();
         ArrayList <ThongKePhieuDVDTO> dspdvtheongay = new ArrayList <ThongKePhieuDVDTO> (); 
          
          try
          {
              String qry = "select loaidv.tenloaidv, dichvu.tendv,count(ctdvu.madv) as SL\n" +
"FROM dichvu, loaidv,phieudvu,ctdvu\n" +
"WHERE dichvu.madv=ctdvu.madv and phieudvu.maphieudvu=ctdvu.maphieudvu and dichvu.maloaidv=loaidv.maloaidv and ctdvu.ngaysudungdv BETWEEN '"+ngaybd+"' and '"+ngaykt+"'\n" +
"GROUP BY loaidv.tenloaidv, dichvu.tendv";
            ConnectData.st = ConnectData.conn.createStatement();
            ConnectData.rs = ConnectData.st.executeQuery(qry);
              
             while(ConnectData.rs.next())
              {
                  ThongKePhieuDVDTO p = new ThongKePhieuDVDTO();
                  p.setLoaidichvu(ConnectData.rs.getString(1));
                  p.setTendichvu(ConnectData.rs.getString(2));
                  p.setSoluotdat(ConnectData.rs.getInt(3));
                  dspdvtheongay.add(p);
             }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
        ConnectData.MySQLDisconnect();
        return dspdvtheongay;
    } 
}
