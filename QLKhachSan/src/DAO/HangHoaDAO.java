/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.HangHoaDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo-x220i
 */
public class HangHoaDAO {
     public ArrayList docdshanghoa ()
    {
         MySQLConnect ConnectData = new MySQLConnect();
         ArrayList <HangHoaDTO> dshanghoa = new ArrayList <HangHoaDTO> (); 
          try
          {
              String qry = "select * from hanghoa";
            ConnectData.st = ConnectData.conn.createStatement();
            ConnectData.rs = ConnectData.st.executeQuery(qry);
              
             while(ConnectData.rs.next())
              {
                  HangHoaDTO hang = new HangHoaDTO();
                  hang.setMahang(ConnectData.rs.getString(1));
                  hang.setMakho(ConnectData.rs.getString(2));
                  hang.setTenhang(ConnectData.rs.getString(3));
                  hang.setGia(ConnectData.rs.getInt(4));
                  hang.setDonvitinh(ConnectData.rs.getString(5));
                  hang.setSoluong(ConnectData.rs.getInt(6));
                  dshanghoa.add(hang);
             }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
        ConnectData.MySQLDisconnect();
        return dshanghoa;
    }
     
     public void Them(HangHoaDTO hang)
    {
        MySQLConnect ConnectData = new MySQLConnect();
        try {          
            String qry = "insert into hanghoa value('";
            qry += hang.getMahang() +"','";
            qry += hang.getMakho()+"','";
            qry += hang.getTenhang()+"',";
            qry += hang.getGia()+",'";
            qry += hang.getDonvitinh() +"',";
            qry += hang.getSoluong()+")";
           
            ConnectData.st = ConnectData.conn.createStatement();
            ConnectData.st.executeUpdate(qry);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }       
    }
     public void Xoa(String ma)
    {
        try {
            MySQLConnect connect = new MySQLConnect();
            String qry = "DELETE FROM hanghoa";
            qry +="  WHERE mahang='"+String.valueOf(ma)+"'";
            connect.st = connect.conn.createStatement();
            connect.st.executeUpdate(qry);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
     public void Sua (HangHoaDTO sp)
     {
         try {
            MySQLConnect connect = new MySQLConnect();
            String qry = "UPDATE hanghoa SET ";
            qry += "makho= '"+sp.getMakho()+"',";
            qry += "tenhang='"+sp.getTenhang()+"',";
            qry += "donvitinh='"+sp.getDonvitinh()+"',";
            qry += "gia="+sp.getGia()+",";
            qry +="soluong="+sp.getSoluong()+" ";
            qry +="WHERE mahang='"+sp.getMahang()+"'";
            connect.st = connect.conn.createStatement();
            connect.st.executeUpdate(qry);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
     }
}
