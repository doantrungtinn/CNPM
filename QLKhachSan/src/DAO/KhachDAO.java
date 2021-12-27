/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.KhachDTO;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class KhachDAO {
    public ArrayList docDSKhach()
    {
        ArrayList<KhachDTO> ds = new ArrayList<KhachDTO>();
        MySQLConnect connect = new MySQLConnect();
        try
        {
            String query = "select * from khachhang";
            connect.st = connect.conn.createStatement();
            connect.rs = connect.st.executeQuery(query);
            while(connect.rs.next())
            {
                KhachDTO kh = new KhachDTO();
                kh.setMakh(connect.rs.getString(1));
                kh.setHoten(connect.rs.getString(2));
                kh.setNgaysinh(connect.rs.getString(3));
                kh.setSdt(connect.rs.getString(4));
                kh.setEmail(connect.rs.getString(5));
                kh.setDiachi(connect.rs.getString(6));
                
                ds.add(kh);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        connect.MySQLDisconnect();
        return ds;
    }
}
