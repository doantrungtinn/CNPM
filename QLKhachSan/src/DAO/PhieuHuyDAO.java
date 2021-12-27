/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.PHuyDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class PhieuHuyDAO {
    
     public ArrayList docDSPHuy()
    {
        MySQLConnect ConnectData = new MySQLConnect();
        ArrayList <PHuyDTO> dshuydatphong = new ArrayList<PHuyDTO>();
        try
        {
            String query = "select * from phieuhuy";
            ConnectData.st = ConnectData.conn.createStatement();
            ConnectData.rs = ConnectData.st.executeQuery(query);  
            while(ConnectData.rs.next())
            {
                PHuyDTO phuy = new PHuyDTO();
                phuy.setMahuy(ConnectData.rs.getString(1));
                phuy.setMadp(ConnectData.rs.getString(2));
                phuy.setManv(ConnectData.rs.getString(3));
                phuy.setNgayhuy(ConnectData.rs.getString(4));
                phuy.setLydo(ConnectData.rs.getString(5));             
                               
                dshuydatphong.add(phuy);
            }
        }
        catch(SQLException e)
                {
                    System.out.println(e);
                }
        ConnectData.MySQLDisconnect();
        return dshuydatphong;
    }
    public void them(PHuyDTO ph)
    {
        MySQLConnect connect = new MySQLConnect();
        try
        {
            String query = "INSERT INTO phieuhuy VALUES ";
            query+= "('"+ph.getMahuy()+"','"+ph.getMadp()+"','"+ph.getManv()+"','"+ph.getNgayhuy()+"','"+ph.getLydo()+"')";
            connect.st = connect.conn.createStatement();
            connect.st.executeUpdate(query);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
            
}
