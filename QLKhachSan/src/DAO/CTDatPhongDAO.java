/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.CTDatPhongDTO;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class CTDatPhongDAO {
    public ArrayList docDSCTDPtheoMa(String madat)
    {
        MySQLConnect ConnectData = new MySQLConnect();
        ArrayList<CTDatPhongDTO> dsctdatphong = new ArrayList<CTDatPhongDTO>();
        try
        {
            String query ="select * from ctdat where madat='"+madat+"'";
            ConnectData.st=ConnectData.conn.createStatement();
            ConnectData.rs=ConnectData.st.executeQuery(query);
            
            while(ConnectData.rs.next())
            {
                CTDatPhongDTO ctdatphong = new CTDatPhongDTO();
                ctdatphong.setMadat(ConnectData.rs.getString(1));
                ctdatphong.setMaphong(ConnectData.rs.getString(2));
                ctdatphong.setDongia(ConnectData.rs.getInt(3));
                dsctdatphong.add(ctdatphong);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        ConnectData.MySQLDisconnect();
        return dsctdatphong;
    }
    
    public void them(CTDatPhongDTO ctdp)
    {
        MySQLConnect Connect = new MySQLConnect();
        
        try
        {
          //INSERT INTO `ctdat` (`madat`, `maphong`, `dongia`) VALUES ('PD9', '310', '');
            String query="insert into ctdat values('";
            query+=ctdp.getMadat()+"','"+ctdp.getMaphong()+"','"+ctdp.getDongia()+"')";
            
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