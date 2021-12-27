/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.HangHoaDAO;
import DTO.HangHoaDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo-x220i
 */
public class HangHoaBUS {
    public static ArrayList<HangHoaDTO> dssp;

    public HangHoaBUS() {
    }

    public void docDSSP() {
        HangHoaDAO data = new HangHoaDAO();
        if (dssp == null) {
            dssp = new ArrayList<HangHoaDTO>();           
        }
        dssp = data.docdshanghoa();
    }
    
    public boolean Them(HangHoaDTO sp) {
     
        if(sp.getMakho().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Điền đầy đủ mã kho");
            return false;
        }

              
        HangHoaDAO data = new HangHoaDAO();
        data.Them(sp);
        JOptionPane.showMessageDialog(null, "Thêm thành công");
        dssp.add(sp);
        return true;
    }
         public HangHoaDTO getInfoRow(String Ma) {
        HangHoaDTO sp = new HangHoaDTO();
        docDSSP();
        for (HangHoaDTO tempsp : HangHoaBUS.dssp) {
            if (tempsp.getMahang().equals(Ma)) {
                sp = tempsp;
                break;
            }
        }
        return sp;
         }
         
          public boolean Xoa(String ma) {
        int index = -1;
        if ("".equals(ma)) {
            JOptionPane.showMessageDialog(null, "Mã sản phẩm không được để trống");
            return false;
        }
        HangHoaDAO data = new HangHoaDAO();
        data.Xoa(ma);
        for (HangHoaDTO tempsp : HangHoaBUS.dssp)
        {
            index++;
            if (tempsp.getMahang().equals(ma)) {
                break;
            }
        }

        dssp.remove(index);

        JOptionPane.showMessageDialog(null, "Xóa thành công");
        return true;
    }
    
           public boolean Sua(HangHoaDTO sp)
    {
        
        int index = -1; 
        for(HangHoaDTO tempsp : HangHoaBUS.dssp)
        {
            index++;
            if((tempsp.getMahang()).equals(sp.getMahang()))
            {
                   System.out.println(index);
                break;
            }
        }
        dssp.set(index, sp);
        HangHoaDAO data = new HangHoaDAO();
        data.Sua(sp);
        JOptionPane.showMessageDialog(null, "Sửa thành công");
        return true;
    }

}
