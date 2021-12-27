/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.TaiKhoanDAO;
import java.util.ArrayList;
import DTO.TaiKhoanDTO;
import javax.swing.JOptionPane;

/**
 *
 * @author Trang
 */
public class TaiKhoanBUS {
  public static ArrayList<TaiKhoanDTO> dstk;  
   public TaiKhoanBUS() {
    }

    public void docDSTK() {
        TaiKhoanDAO data = new TaiKhoanDAO();
        if (dstk == null) {
            dstk = new ArrayList<TaiKhoanDTO>();           
        }
        dstk = data.docdstaikhoan();
    }
    
    public boolean Them(TaiKhoanDTO tk) {
//        if(sp.getMasach().equals(""))
//        {
//            JOptionPane.showMessageDialog(null, "Xin nhập mã SP");
//            return false;
//        }
//        String regex = "^[0-9]{1,}$";
//        if (sp.getMasach().matches(regex) == false) {
//            JOptionPane.showMessageDialog(null,"Mã sách không hợp lệ");
//            return false;
//        }
//        for (SachDTO x : dssp) {
//            if (x.getMasach().equals(sp.getMasach())) {
//                JOptionPane.showMessageDialog(null, "Mã sách bị trùng");
//                return false;
//            }
//        }
//        if(sp.getTensach().equals(""))
//        {
//            JOptionPane.showMessageDialog(null, "Xin nhập tên sách");
//            return false;
//        }
//        if(sp.getMaloai().equals(""))
//        {
//            JOptionPane.showMessageDialog(null, "Xin chọn mã Loại");
//            return false;
//        }
//        if(sp.getMancc().equals(""))
//        {
//            JOptionPane.showMessageDialog(null, "Xin chọn mã NCC");
//            return false;
//        }
//              
//        if(sp.getManxb().equals(""))
//        {
//            JOptionPane.showMessageDialog(null,"Xin chọn mã NXB");
//            return false;
//        }
//        
        if(tk.getManhanvien().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Vui lòng nhập mã nhân viên");
            return false;
        }
        if(tk.getTentaikhoan().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Vui lòng nhập tên tài khoản");
            return false;
        }
        
        if(tk.getMatkhau().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Vui lòng nhập mật khẩu");
            return false;
        }
        
         
        
        TaiKhoanDAO data = new TaiKhoanDAO();
        data.Them(tk);
        JOptionPane.showMessageDialog(null, "Thêm thành công");
        dstk.add(tk);
        return true;
    }
    
   public boolean Sua(TaiKhoanDTO tk) {
       int index = -1;
       for (TaiKhoanDTO temptk : TaiKhoanBUS.dstk) {
           index++;
           if(temptk.getTentaikhoan().equals(tk.getTentaikhoan()))
           {
               System.out.println(index);
           }
       }
      /*   if(nv.getManhanvien().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Vui lòng nhập mã nhân viên");
            return false;
        }
        if(nv.getMachucvu().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Vui lòng nhập mã chức vụ");
            return false;
        }*/
      
        dstk.set(index,tk);
       TaiKhoanDAO data = new TaiKhoanDAO();
        data.Sua(tk);
        JOptionPane.showMessageDialog(null, "Sửa thành công");
       /* dsnv.add(nv);*/
        return true;
     
    }
   
   public boolean Xoa(String manv){
       int index = -1;
       for (TaiKhoanDTO temp : dstk) {
           index++;
           if(temp.getManhanvien().equals(manv))
           {
               System.out.println(index);
           }
       }
      /*   if(nv.getManhanvien().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Vui lòng nhập mã nhân viên");
            return false;
        }
        if(nv.getMachucvu().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Vui lòng nhập mã chức vụ");
            return false;
        }*/
      
  /*  dsnv.set(index);*/
      TaiKhoanDAO data = new TaiKhoanDAO();
        data.Xoa(manv);
        JOptionPane.showMessageDialog(null, "Xóa thành công");
        
        return true;
    
      
     
       
   }
   
   public TaiKhoanDTO timTaikhoan(String tk, String mk) {
	   TaiKhoanDTO tk1= new TaiKhoanDTO();
	   docDSTK();
       for (TaiKhoanDTO temptk : TaiKhoanBUS.dstk) {
           if (temptk.getTentaikhoan().equals(tk) && temptk.getMatkhau().equals(mk)) {
               tk1 = temptk;
               break;
           }
       }
       return tk1;
   }
   
   
        public TaiKhoanDTO getInfoRow(String Ten) {
        TaiKhoanDTO tk1= new TaiKhoanDTO();
        docDSTK();
        for (TaiKhoanDTO temptk : TaiKhoanBUS.dstk) {
            if (temptk.getTentaikhoan().equals(Ten)) {
                tk1 = temptk;
                break;
            }
        }
        return tk1;
         }

}