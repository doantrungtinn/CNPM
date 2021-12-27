/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.CTXuatKhoDTO;
import java.util.ArrayList;

/**
 *
 * @author Truong Thuy Doanh
 */
public class CTXuatKhoDAO {
    public ArrayList docDSCTXKtheoMa(String mapxk)
    {
        MySQLConnect ConnectData = new MySQLConnect();
        ArrayList<CTXuatKhoDTO> dsctxuat = new ArrayList<CTXuatKhoDTO>();
        try
        {
            String query ="select * from ctxuatkho where mapxk='"+mapxk+"'";
            ConnectData.st=ConnectData.conn.createStatement();
            ConnectData.rs=ConnectData.st.executeQuery(query);
            
            while(ConnectData.rs.next())
            {
                CTXuatKhoDTO ctxuat = new CTXuatKhoDTO();
                ctxuat.setMapxk(ConnectData.rs.getString(1));
                ctxuat.setMahang(ConnectData.rs.getString(2));
                ctxuat.setSlyeucau(ConnectData.rs.getInt(3));
                ctxuat.setSlthucxuat(ConnectData.rs.getInt(4));
                ctxuat.setThanhtien(ConnectData.rs.getInt(5));
                dsctxuat.add(ctxuat);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        ConnectData.MySQLDisconnect();
        return dsctxuat;
    }
    
    public void them(CTXuatKhoDTO ctxuat)
    {
        MySQLConnect Connect = new MySQLConnect();
        
        try
        {
            String query="insert into ctxuatkho values('";
            query+=ctxuat.getMapxk()+"','"+ctxuat.getMahang()+"','"+ctxuat.getSlyeucau()+"','"+ctxuat.getSlthucxuat()+"','"+ctxuat.getThanhtien()+"')";
            Connect.st = Connect.conn.createStatement();
            Connect.st.executeUpdate(query);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        Connect.MySQLDisconnect();
    }
}
