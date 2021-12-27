/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.DanhSachDAO;
import DTO.DanhSachDTO;
import java.util.ArrayList;

/**
 *
 * @author Trang
 */
public class DanhSachBUS {
    public static ArrayList<DanhSachDTO> dsnv;  
   public DanhSachBUS() {
    }

    public void docDSNV() {
        DanhSachDAO data = new DanhSachDAO();
        if (dsnv == null) {
            dsnv = new ArrayList<DanhSachDTO>();           
        }
        dsnv = data.docdsnhanvien();
    }
    
     public DanhSachDTO getInfoRow(String Ma) {
        DanhSachDTO nv= new DanhSachDTO();
        docDSNV();
        for (DanhSachDTO tempds : DanhSachBUS.dsnv) {
            if (tempds.getManhanvien().equals(Ma)) {
                nv = tempds;
                break;
            }
        }
        return nv;
         }
    
}
