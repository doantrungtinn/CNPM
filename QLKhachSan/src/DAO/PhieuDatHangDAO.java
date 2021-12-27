/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.PhieuDatHangDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Truong Thuy Doanh
 */
public class PhieuDatHangDAO {
    public ArrayList docDSPDH()
    {
        MySQLConnect ConnectData = new MySQLConnect();
        ArrayList <PhieuDatHangDTO> dspdat = new ArrayList<>();
        try
        {
            String query = "select * from phieudathang";
            ConnectData.st = ConnectData.conn.createStatement();
            ConnectData.rs = ConnectData.st.executeQuery(query);  
            while(ConnectData.rs.next())
            {
                PhieuDatHangDTO pdh = new PhieuDatHangDTO();

                pdh.setMapdh(ConnectData.rs.getString(1));
                pdh.setManv(ConnectData.rs.getString(2));
                pdh.setTongsl(ConnectData.rs.getInt(3));
                pdh.setTongtien(ConnectData.rs.getInt(4));
                pdh.setTennhacc(ConnectData.rs.getString(5));
                pdh.setThoigiangiao(ConnectData.rs.getString(6));
                dspdat.add(pdh);
            }
        }
        catch(SQLException e)
                {
                    System.out.println(e);
                }
        ConnectData.MySQLDisconnect();
        return dspdat;
    }
    
    public void them(PhieuDatHangDTO pd)
    {
        MySQLConnect ConnectData = new MySQLConnect();
        
        try
        {
            String query="insert into phieudathang values('";
            query+=pd.getMapdh()+"','"+pd.getManv()+"','"+pd.getTongsl()+"','";          
            query+=pd.getTongtien()+"','"+pd.getTennhacc()+"','"+pd.getThoigiangiao()+"')";
            ConnectData.st = ConnectData.conn.createStatement();
            ConnectData.st.executeUpdate(query);
        }        
       catch(Exception e)
               {
                   System.out.println(e);
               }
        ConnectData.MySQLDisconnect();
    }
    
    public void sua(String madat, String thoigian)
    {
        MySQLConnect Connect = new MySQLConnect();
        try
        {
            String query="update phieudathang set thoigian='"+thoigian+"' where mapdh='"+madat+"'";
            Connect.st= Connect.conn.createStatement();
            Connect.st.executeUpdate(query);
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        Connect.MySQLDisconnect();
    }
}
