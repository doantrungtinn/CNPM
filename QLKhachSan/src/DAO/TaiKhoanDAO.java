/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.TaiKhoanDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Trang
 */
public class TaiKhoanDAO {
    public ArrayList docdstaikhoan(){
        ArrayList<TaiKhoanDTO> dstk = new ArrayList<TaiKhoanDTO>();
            MySQLConnect ConnectData = new MySQLConnect();
            try{
                String qry ="select * from `taikhoan`";
                ConnectData.st=ConnectData.conn.createStatement();
                ConnectData.rs = ConnectData.st.executeQuery(qry);
                while(ConnectData.rs.next())
                {
                    TaiKhoanDTO tk = new TaiKhoanDTO();
                   
                    tk.setTentaikhoan(ConnectData.rs.getString(1));
                    tk.setMatkhau(ConnectData.rs.getString(2));
                    tk.setManhanvien(ConnectData.rs.getString(3));
                    tk.setTrangthai(ConnectData.rs.getString(4));
                    dstk.add(tk);
                    
                }
                
                
                
            }catch(SQLException e){
                  JOptionPane.showMessageDialog(null,e.toString());
                
            }
            
        ConnectData.MySQLDisconnect();
               return dstk;
    }
     public void Them(TaiKhoanDTO tk1){
         MySQLConnect ConnectData = new MySQLConnect();
         try{
              String qry = "insert into taikhoan value('";
            qry += tk1.getTentaikhoan()+"','"+tk1.getMatkhau()+"','"+tk1.getManhanvien()+"','"
         
            +tk1.getTrangthai()+"')";
            ConnectData.st = (com.mysql.jdbc.Statement) ConnectData.conn.createStatement();
          ConnectData.st.executeUpdate(qry);        
         }catch(SQLException ex){
                System.out.println(ex.toString());

         
     }
         
     }
     
     
     public  void Sua(TaiKhoanDTO tk2) {
            MySQLConnect ConnectData = new MySQLConnect();
         
        try {
                String query="UPDATE taikhoan SET "; 
        // query+= "tentaikhoan='"+tk2.getTentaikhoan()+"'";
         query+= "matkhau='"+tk2.getMatkhau()+"'";
         query+=",manv='"+tk2.getManhanvien()+"'";
         query+=",trangthai='"+tk2.getTrangthai()+"'";
        query+=" where tentaikhoan='"+tk2.getTentaikhoan()+"'";
          
          
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
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, e);

            System.out.println("Loi update ");
        }
    }
     
     
      public void Xoa (String manv){
         
          MySQLConnect ConnectData = new MySQLConnect();
          try{
            String qry="Delete from taikhoan where manv='"+manv+"'";
            
            
            ConnectData.st = ConnectData.conn.createStatement();
            ConnectData.st.executeUpdate(qry);
            
          }catch(SQLException e){
              System.out.println(e);
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Loi xoa ");

          }
     }
      
      
     
     
}
    

