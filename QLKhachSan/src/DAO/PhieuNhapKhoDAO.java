/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.PhieuNhapKhoDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Truong Thuy Doanh
 */
public class PhieuNhapKhoDAO {
    public ArrayList docdsphieunhapkho ()
    {
         MySQLConnect ConnectData = new MySQLConnect();
         ArrayList <PhieuNhapKhoDTO> dspnk = new ArrayList <PhieuNhapKhoDTO> (); 
          try
          {
              String qry = "select * from phieunhapkho";
            ConnectData.st = ConnectData.conn.createStatement();
            ConnectData.rs = ConnectData.st.executeQuery(qry);
              
             while(ConnectData.rs.next())
              {
                  PhieuNhapKhoDTO phieunhapkho = new PhieuNhapKhoDTO();
                  phieunhapkho.setMapnk(ConnectData.rs.getString(1));
                  phieunhapkho.setMakho(ConnectData.rs.getString(2));
                  phieunhapkho.setManv(ConnectData.rs.getString(3));
                  phieunhapkho.setNgaynhapkho(ConnectData.rs.getString(4));
                  phieunhapkho.setTongsltrenchungtu(ConnectData.rs.getInt(5));
                  phieunhapkho.setTongslthucnhap(ConnectData.rs.getInt(6));
                  phieunhapkho.setTongtien(ConnectData.rs.getInt(7));
                  phieunhapkho.setTennguoigiao(ConnectData.rs.getString(8));
                  phieunhapkho.setGhichu(ConnectData.rs.getString(9));
                  dspnk.add(phieunhapkho);
             }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
        ConnectData.MySQLDisconnect();
        return dspnk;
    }
     
     public void Them(PhieuNhapKhoDTO phieunhapkho)
    {
        MySQLConnect ConnectData = new MySQLConnect();
        try {          
            String qry = "insert into phieunhapkho value('";
            qry += phieunhapkho.getMapnk() +"','";
            qry += phieunhapkho.getMakho()+"','";
            qry += phieunhapkho.getManv()+"',";
            qry += phieunhapkho.getNgaynhapkho()+",'";
            qry += phieunhapkho.getTongsltrenchungtu() +"',";
            qry += phieunhapkho.getTongslthucnhap()+"',";
            qry += phieunhapkho.getTongtien()+",'";
            qry += phieunhapkho.getTennguoigiao() +"',";
            qry += phieunhapkho.getGhichu()+")";
           
            ConnectData.st = ConnectData.conn.createStatement();
            ConnectData.st.executeUpdate(qry);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        ConnectData.MySQLDisconnect();
    }
     
    public void Sua(PhieuNhapKhoDTO phieunhapkho){
        MySQLConnect ConnectData = new MySQLConnect();
        try {
            String qry = "update phieunhapkho set mapnk = '" + phieunhapkho.getMapnk() + "', makho = '" +phieunhapkho.getMakho()+"', manv ='"+phieunhapkho.getManv()+"', ngaynhapkho = '"+phieunhapkho.getNgaynhapkho()+"', tongslchungtu = '";
            qry += phieunhapkho.getTongsltrenchungtu()+"', tongslthucnhap ='" +phieunhapkho.getTongslthucnhap() + "', tongtien= '" +phieunhapkho.getTongtien() +"', tennguoigiao ='" +phieunhapkho.getTennguoigiao()+"', ghichu='"+phieunhapkho.getGhichu() +"'";
            ConnectData.st = ConnectData.conn.createStatement();
                ConnectData.st.executeUpdate(qry);
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        ConnectData.MySQLDisconnect();
    }
}
