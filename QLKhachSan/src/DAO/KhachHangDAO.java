
package DAO;

import DTO.KhachHangDTO;
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



public class KhachHangDAO {
    public static List<KhachHangDTO> DSKH() {
        List<KhachHangDTO> DSKhachHang = new ArrayList<>();
        MySQLConnect connect = new MySQLConnect();
       
        Statement statement = null;
        
        try {                                           
            String sql = "SELECT * FROM `khachhang`";
            statement = connect.conn.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            
            while (rs.next()) {                
                KhachHangDTO std = new KhachHangDTO(rs.getString("makh"), 
                        rs.getString("hotenkh"), rs.getString("ngaysinh"), 
                        rs.getString("sdt"), rs.getString("email"), rs.getString("diachi"));                
                DSKhachHang.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
            
        connect.MySQLDisconnect();                        
        return DSKhachHang;
    }
     
    
    
    public static void themKH(KhachHangDTO km) {
        MySQLConnect connect = new MySQLConnect();
        try{
           String sql = "insert into khachhang value('";
           sql += km.getMaKH()+"','"+km.getTenKH()+"','"+km.getNgaysinh()+"','"+km.getSDT()+"','"+km.getEmail()+"','"+km.getDiachi()+"')";
           connect.st = (com.mysql.jdbc.Statement) connect.conn.createStatement();
           connect.st.executeUpdate(sql);        
        }catch(SQLException ex){
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);  
        }   
        connect.MySQLDisconnect();
    }
        
    
    
    public static void suaKH(KhachHangDTO km) {
        MySQLConnect connect = new MySQLConnect();
         
        try {
            String sql="update khachhang set "; 
        
        sql+= "makh='"+km.getMaKH()+"'";
        sql+=",hotenkh='"+km.getTenKH()+"'";
        sql+=",ngaysinh='"+km.getNgaysinh()+"'";
        sql+=",sdt='"+km.getSDT()+"'";
        sql+=",email='"+km.getEmail()+"'";
        sql+=",diachi='"+km.getDiachi()+"'";
        sql+=" where makh='"+km.getMaKH()+"'";
          
            connect.st = connect.conn.createStatement();
            connect.st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void xoaKH(String makh) {
        MySQLConnect connect = new MySQLConnect();
          try{
            String sql= "delete from khachhang where makh='"+makh+"'";
                  
            connect.st = connect.conn.createStatement();
            connect.st.executeUpdate(sql);
            
          }catch(SQLException ex){
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
          }       
    }   
    
    public static List<KhachHangDTO> timkiemKH(String makh) {
        List<KhachHangDTO> DSKhachHang = new ArrayList<>();       
        MySQLConnect connect = new MySQLConnect();
        PreparedStatement statement = null;
        
        try {
                                         
            String sql = "SELECT * FROM `khachhang` WHERE khachhang.makh=? ";
            statement = connect.conn.prepareCall(sql);
            statement.setString(1, makh);
            
            ResultSet rs = statement.executeQuery();
            
            while (rs.next()) {                
                KhachHangDTO std = new KhachHangDTO(rs.getString("makh"), 
                        rs.getString("hotenkh"), rs.getString("ngaysinh"), 
                        rs.getString("sdt"), rs.getString("email"), rs.getString("diachi"));                
                DSKhachHang.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        connect.MySQLDisconnect();          
        return DSKhachHang;
    }
    
    
}
