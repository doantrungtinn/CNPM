/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Trang
 */
public class NhanVienBUS {
  public static ArrayList<NhanVienDTO> dsnv;  
   public NhanVienBUS() {
    }

    public void docDSNV() {
        NhanVienDAO data = new NhanVienDAO();
        if (dsnv == null) {
            dsnv = new ArrayList<NhanVienDTO>();           
        }
        dsnv = data.docdsnhanvien();
    }
    
    public boolean Them(NhanVienDTO nv) {
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
        if(nv.getManhanvien().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Vui lòng nhập mã nhân viên");
            return false;
        }
        if(nv.getMachucvu().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Vui lòng nhập mã chức vụ");
            return false;
        }
         
        
        NhanVienDAO data = new NhanVienDAO();
        data.Them(nv);
        JOptionPane.showMessageDialog(null, "Thêm thành công");
        dsnv.add(nv);
        return true;
    }
    
   public boolean Sua(NhanVienDTO nv) {
       int index = -1;
       for (NhanVienDTO tempnv : NhanVienBUS.dsnv) {
           index++;
           if(tempnv.getManhanvien().equals(nv.getManhanvien()))
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
      
        dsnv.set(index,nv);
       NhanVienDAO data = new NhanVienDAO();
        data.Sua(nv);
        JOptionPane.showMessageDialog(null, "Sửa thành công");
       /* dsnv.add(nv);*/
        return true;
     
    }
   
   public boolean Xoa(String manv){
       int index = -1;
       for (NhanVienDTO temp : dsnv) {
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
      NhanVienDAO data = new NhanVienDAO();
        data.Xoa(manv);
        JOptionPane.showMessageDialog(null, "Xóa thành công");
        
        return true;
    
      
     
       
   }
    public static ArrayList<NhanVienDTO> TimkiemChung(String TimCaiGi, String noidung) {
        NhanVienDAO data = new NhanVienDAO();
        
        ArrayList<NhanVienDTO> list = data.docdsnhanvien();
        ArrayList<NhanVienDTO> list_tam = new ArrayList<NhanVienDTO>();

       
        if (TimCaiGi.equals("Tên nhân viên")) { // tìm kiếm gần giống với mã nhân viên
            for (NhanVienDTO nhanvienDTO : list) {
                String a = "" + nhanvienDTO.getTennhanvien();
                if (a.contains(noidung)) {

                    list_tam.add(nhanvienDTO);
                }
            }
            return list_tam;
        }

        //Tìm kiếm gần giống theo mã nhân viên
        if (TimCaiGi.equals("Mã nhân viên")) { // tìm kiếm gần giống với mã nhân viên
            for (NhanVienDTO nhanvienDTO : list) {
                String a = "" + nhanvienDTO.getManhanvien();
                if (a.contains(noidung)) {

                    list_tam.add(nhanvienDTO);
                }
            }
            return list_tam;
        }
        //Tìm kiếm gần giống với số điện thoại
        if (TimCaiGi.equals("Số điện thoại")) { // tìm kiếm gần giống với mã nhân viên
            for (NhanVienDTO nhanvienDTO : list) {
                String a = "" + nhanvienDTO.getSodienthoai();
                if (a.contains(noidung)) {

                    list_tam.add(nhanvienDTO);
                }
            }
            return list_tam;
        }
        return null;
    }
         public NhanVienDTO getInfoRow(String Ma) {
        NhanVienDTO nv= new NhanVienDTO();
        docDSNV();
        for (NhanVienDTO tempnv : NhanVienBUS.dsnv) {
            if (tempnv.getManhanvien().equals(Ma)) {
                nv = tempnv;
                break;
            }
        }
        return nv;
         }

}


