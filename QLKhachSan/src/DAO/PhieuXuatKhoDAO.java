/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.PhieuXuatKhoDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Truong Thuy Doanh
 */
public class PhieuXuatKhoDAO {
    public ArrayList docdsphieuxkho ()
    {
         MySQLConnect ConnectData = new MySQLConnect();
         ArrayList <PhieuXuatKhoDTO> dspxk = new ArrayList <PhieuXuatKhoDTO> (); 
          try
          {
              String qry = "select * from phieuxuatkho";
            ConnectData.st = ConnectData.conn.createStatement();
            ConnectData.rs = ConnectData.st.executeQuery(qry);
              
             while(ConnectData.rs.next())
              {
                  PhieuXuatKhoDTO phieuxkho = new PhieuXuatKhoDTO();
                  phieuxkho.setMapxk(ConnectData.rs.getString(1));
                  phieuxkho.setMakho(ConnectData.rs.getString(2));
                  phieuxkho.setManv(ConnectData.rs.getString(3));
                  phieuxkho.setNgayxuatkho(ConnectData.rs.getString(4));
                  phieuxkho.setTongslyeucau(ConnectData.rs.getInt(5));
                  phieuxkho.setTongslthucxuat(ConnectData.rs.getInt(6));
                  phieuxkho.setTongtien(ConnectData.rs.getInt(7));
                  phieuxkho.setManv_nhanhang(ConnectData.rs.getString(8));
                  phieuxkho.setLydoxuatkho(ConnectData.rs.getString(9));
                  dspxk.add(phieuxkho);
             }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
        ConnectData.MySQLDisconnect();
        return dspxk;
    }
     
     public void Them(PhieuXuatKhoDTO phieuxkho)
    {
        MySQLConnect ConnectData = new MySQLConnect();
        try {          
            String qry = "insert into phieunhapkho value('";
            qry += phieuxkho.getMapxk() +"','";
            qry += phieuxkho.getMakho()+"','";
            qry += phieuxkho.getManv()+"',";
            qry += phieuxkho.getNgayxuatkho()+",'";
            qry += phieuxkho.getTongslyeucau() +"',";
            qry += phieuxkho.getTongslthucxuat()+"',";
            qry += phieuxkho.getTongtien()+",'";
            qry += phieuxkho.getManv_nhanhang() +"',";
            qry += phieuxkho.getLydoxuatkho()+")";
           
            ConnectData.st = ConnectData.conn.createStatement();
            ConnectData.st.executeUpdate(qry);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        ConnectData.MySQLDisconnect();
    }
     
    public void Sua(PhieuXuatKhoDTO phieuxkho){
        MySQLConnect ConnectData = new MySQLConnect();
        try {
            String qry = "update phieunhapkho set mapxk = '" + phieuxkho.getMapxk() + "', makho = '" +phieuxkho.getMakho()+"', manv ='"+phieuxkho.getManv()+"', ngayxuatkho = '"+phieuxkho.getNgayxuatkho()+"', tongslyeucau = '";
            qry += phieuxkho.getTongslyeucau()+"', tongslthucnhap ='" +phieuxkho.getTongslthucxuat()+ "', tongtien= '" +phieuxkho.tongtien +"', tennguoigiao ='" +phieuxkho.getManv_nhanhang()+"', ghichu='"+phieuxkho.getLydoxuatkho() +"'";
            ConnectData.st = ConnectData.conn.createStatement();
                ConnectData.st.executeUpdate(qry);
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        ConnectData.MySQLDisconnect();
    }
}
