/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.CTDVDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author lenovo-x220i
 */
public class CTDVDAO {
    public ArrayList docallCTDV ()
    {
       MySQLConnect connect = new MySQLConnect();
        ArrayList<CTDVDTO> dsall = new ArrayList<CTDVDTO>();
        try {
            String qry = "Select * from ctdvu";
            connect.st = (com.mysql.jdbc.Statement) connect.conn.createStatement();
            connect.rs = connect.st.executeQuery(qry);
            while (connect.rs.next()) {
                CTDVDTO ctdv = new CTDVDTO();
                ctdv.setMaphieudv(connect.rs.getString(1));
                ctdv.setMadv(connect.rs.getString(2));
                ctdv.setNgaysudungdv(connect.rs.getString(3));
                ctdv.setSoluong(connect.rs.getInt(4));
                ctdv.setThanhtien(connect.rs.getInt(5));
                
                dsall.add(ctdv);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return dsall;
    }
}
