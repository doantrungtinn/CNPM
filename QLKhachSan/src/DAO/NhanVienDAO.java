/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.NhanVienDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Trang
 */
public class NhanVienDAO {
    public ArrayList docdsnhanvien ()
    {
         MySQLConnect ConnectData = new MySQLConnect();
         ArrayList <NhanVienDTO> dsnhanvien = new ArrayList <NhanVienDTO> (); 
          try
          {
            String qry = "select * from nhanvien";
            ConnectData.st=ConnectData.conn.createStatement();
          ConnectData.rs = ConnectData.st.executeQuery(qry);
             while(ConnectData.rs.next())
              {
                  NhanVienDTO nv1 = new NhanVienDTO();
                  nv1.setManhanvien(ConnectData.rs.getString(1));
                  nv1.setMachucvu(ConnectData.rs.getString(2));
                  nv1.setTennhanvien(ConnectData.rs.getString(3));
                  nv1.setNgaysinh(ConnectData.rs.getString(4));
                  nv1.setGioitinh(ConnectData.rs.getString(5));
                  nv1.setDiachi(ConnectData.rs.getString(6));
                  nv1.setSodienthoai(ConnectData.rs.getString(7));
               
                  dsnhanvien.add(nv1);
                           
              
               
             
          }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
        ConnectData.MySQLDisconnect();
        return dsnhanvien;
    }
     
    public void Them(NhanVienDTO nv1)
    {
        MySQLConnect ConnectData = new MySQLConnect();
        try {          
           String qry = "insert into nhanvien value('";
            qry += nv1.getManhanvien()+"','"+nv1.getMachucvu()+"','"+nv1.getTennhanvien()+"','"+nv1.getNgaysinh()+"','"
            +nv1.getGioitinh() +"','"
            +nv1.getDiachi()+"','"
            +nv1.getSodienthoai()+"')";
     
           
            ConnectData.st = (com.mysql.jdbc.Statement) ConnectData.conn.createStatement();
          ConnectData.st.executeUpdate(qry);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }         
    }

 

     
      public  void Sua(NhanVienDTO nv2) {
            MySQLConnect ConnectData = new MySQLConnect();
         
        try {
             String query="UPDATE nhanvien SET "; 
         query+= "macv='"+nv2.getMachucvu()+"'";
         query+=",tennv='"+nv2.getTennhanvien()+"'";
         query+=",ngaysinh='"+nv2.getNgaysinh()+"'";
         query+=",gioitinh='"+nv2.getGioitinh()+"'";
         query+=",diachi='"+nv2.getDiachi()+"'";
         query+=",sdt='"+nv2.getSodienthoai()+"'";
         query+=" where manv='"+nv2.getManhanvien()+"'";
          
          
          /*     String query=  "Update nhanvien Set "
                + " macv='" + nv2.getMachucvu()
                + "', tennv='" + nv2.getTennhanvien()
                + "', ngaysinh='" + nv2.getNgaysinh()
                + "', diaChi='" + nv2.getDiachi()
                + "', sdt=" + nv2.getSodienthoai()
                + "' where manv='" + nv2.getManhanvien()+ "'";*/
             
             


            ConnectData.st = ConnectData.conn.createStatement();
            ConnectData.st.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e);
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, e);

            System.out.println("Loi update ");
        }
    }
     public void Xoa (String manv){
         
          MySQLConnect ConnectData = new MySQLConnect();
          try{
            String qry="Delete from nhanvien where manv='"+manv+"'";
            
            
            ConnectData.st = ConnectData.conn.createStatement();
            ConnectData.st.executeUpdate(qry);
            
          }catch(SQLException e){
              System.out.println(e);
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Loi xoa ");

          }
     }
     
          public NhanVienDTO TimNV_TheoMa(String manv){
                MySQLConnect ConnectData = new MySQLConnect();
          
              try{
                  String qry = "select * from nhanvien where manv='"+manv+"'";
                  NhanVienDTO nv1 = new NhanVienDTO();
                     ConnectData.st=ConnectData.conn.createStatement();
          ConnectData.rs = ConnectData.st.executeQuery(qry);
             while(ConnectData.rs.next())
              {
                  
                  nv1.setManhanvien(ConnectData.rs.getString(1));
                  nv1.setMachucvu(ConnectData.rs.getString(2));
                  nv1.setTennhanvien(ConnectData.rs.getString(3));
                  nv1.setNgaysinh(ConnectData.rs.getString(4));
                  nv1.setGioitinh(ConnectData.rs.getString(5));

                  nv1.setDiachi(ConnectData.rs.getString(6));
                  nv1.setSodienthoai(ConnectData.rs.getString(7));
                           
              
               
             
            }
             return nv1;
                  
              }
               catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
        ConnectData.MySQLDisconnect();
        
          return null;     
              
          }
      
      
      
      }
      
    

