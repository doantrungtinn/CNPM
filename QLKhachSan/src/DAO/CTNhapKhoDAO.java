/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.CTNhapKhoDTO;
import java.util.ArrayList;

/**
 *
 * @author Truong Thuy Doanh
 */
public class CTNhapKhoDAO {
    public ArrayList docDSCTNKtheoMa(String mapnk)
    {
        MySQLConnect ConnectData = new MySQLConnect();
        ArrayList<CTNhapKhoDTO> dsctnhap = new ArrayList<CTNhapKhoDTO>();
        try
        {
            String query ="select * from ctnhapkho where mapnk='"+mapnk+"'";
            ConnectData.st=ConnectData.conn.createStatement();
            ConnectData.rs=ConnectData.st.executeQuery(query);
            
            while(ConnectData.rs.next())
            {
                CTNhapKhoDTO ctnhap = new CTNhapKhoDTO();
                ctnhap.setMapnk(ConnectData.rs.getString(1));
                ctnhap.setMahang(ConnectData.rs.getString(2));
                ctnhap.setSlchungtu(ConnectData.rs.getInt(3));
                ctnhap.setSlthucnhap(ConnectData.rs.getInt(4));
                ctnhap.setThanhtien(ConnectData.rs.getInt(5));
                dsctnhap.add(ctnhap);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        ConnectData.MySQLDisconnect();
        return dsctnhap;
    }
    
    public void them(CTNhapKhoDTO ctnhap)
    {
        MySQLConnect Connect = new MySQLConnect();
        
        try
        {
            String query="insert into ctnhapkho values('";
            query+=ctnhap.getMapnk()+"','"+ctnhap.getMahang()+"','"+ctnhap.getSlchungtu()+"','"+ctnhap.getSlthucnhap()+"','"+ctnhap.getThanhtien()+"')";
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
