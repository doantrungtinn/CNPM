/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.CTDatHangDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Truong Thuy Doanh
 */
public class CTDatHangDAO {
    public ArrayList docDSCTDHtheoMa(String madat)
    {
        MySQLConnect ConnectData = new MySQLConnect();
        ArrayList<CTDatHangDTO> dsctdathang = new ArrayList<>();
        try
        {
            String query ="select * from ctdathang where mapdh='"+madat+"'";
            ConnectData.st=ConnectData.conn.createStatement();
            ConnectData.rs=ConnectData.st.executeQuery(query);
            
            while(ConnectData.rs.next())
            {
                CTDatHangDTO ctdathang = new CTDatHangDTO();
                ctdathang.setMapdh(ConnectData.rs.getString(1));
                ctdathang.setMahang(ConnectData.rs.getString(2));
                ctdathang.setTenhang(ConnectData.rs.getString(3));
                ctdathang.setDonvitinh(ConnectData.rs.getString(4));
                ctdathang.setSl(ConnectData.rs.getInt(5));
                ctdathang.setThanhtien(ConnectData.rs.getInt(6));
                dsctdathang.add(ctdathang);
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        
        ConnectData.MySQLDisconnect();
        return dsctdathang;
    }
    
    public void them(CTDatHangDTO ctdh)
    {
        MySQLConnect Connect = new MySQLConnect();
        
        try
        {
          
            String query="insert into ctdathang values('";
            query+=ctdh.getMapdh()+"','"+ctdh.getMahang()+"','"+ctdh.getTenhang()+"','"+ctdh.getDonvitinh()+"','"+ctdh.getSl()+"','"+ctdh.getThanhtien()+"')";
            
            Connect.st = Connect.conn.createStatement();
            Connect.st.executeUpdate(query);
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        
        Connect.MySQLDisconnect();
    }
}
