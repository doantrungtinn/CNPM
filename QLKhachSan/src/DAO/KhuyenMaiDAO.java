
package DAO;

import DTO.KhuyenMaiDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



public class KhuyenMaiDAO {
    
    public static List<KhuyenMaiDTO> DSKM() {
        List<KhuyenMaiDTO> studentList = new ArrayList<>();      
        MySQLConnect connect = new MySQLConnect();
        Statement statement = null;
        
        try {
                                           
            String sql = "SELECT * FROM `khuyenmai`";
            statement = connect.conn.createStatement();    
            ResultSet rs = statement.executeQuery(sql);
            
            while (rs.next()) {                
                KhuyenMaiDTO km = new KhuyenMaiDTO(rs.getString("makm"), 
                        rs.getString("tenkm"), rs.getInt("phantramkm"), 
                        rs.getString("ngaybd"), rs.getString("ngaykt"));                
                studentList.add(km);
            }
        } catch(SQLException ex){
            Logger.getLogger(KhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);   
        }   
        connect.MySQLDisconnect();
        return studentList;
    }
     
    
    
    public static void themKM(KhuyenMaiDTO km) {
        MySQLConnect connect = new MySQLConnect();
        try{
           String sql = "insert into khuyenmai value('";
           sql += km.getMaKM()+"','"+km.getTenKM()+"','"+km.getGiamgia()+"','"+km.getNgayBD()+"','"+km.getNgayKT()+"')";
           connect.st = (com.mysql.jdbc.Statement) connect.conn.createStatement();
           connect.st.executeUpdate(sql);        
        }catch(SQLException ex){
            Logger.getLogger(KhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);  
        }   
        connect.MySQLDisconnect();
    }
        
    
    
    public static void suaKM(KhuyenMaiDTO km) {
        MySQLConnect connect = new MySQLConnect();
         
        try {
            String sql="update khuyenmai set "; 
        
        sql+= "makm='"+km.getMaKM()+"'";
        sql+=",tenkm='"+km.getTenKM()+"'";
        sql+=",phantramgiam='"+km.getGiamgia()+"'";
        sql+=",ngaybd='"+km.getNgayBD()+"'";
        sql+=",ngaykt='"+km.getNgayKT()+"'";
        sql+=" where makm='"+km.getMaKM()+"'";
          
            connect.st = connect.conn.createStatement();
            connect.st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void xoaKM(String makm) {
        MySQLConnect connect = new MySQLConnect();
          try{
            String sql= "delete from khuyenmai where makm='"+makm+"'";
                  
            connect.st = connect.conn.createStatement();
            connect.st.executeUpdate(sql);
            
          }catch(SQLException ex){
            Logger.getLogger(KhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
          }       
    }   
           
}
