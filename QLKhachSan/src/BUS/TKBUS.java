/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.TKDAO;
import DTO.TKDTO;
import java.util.ArrayList;

/**
 *
 * @author Trang
 */
public class TKBUS {
    public static ArrayList<TKDTO> dstk;  
   public TKBUS() {
    }

    public void docDSTK() {
        TKDAO data = new TKDAO();
        if (dstk == null) {
            dstk = new ArrayList<TKDTO>();           
        }
        dstk = data.docdstaikhoan();
    }
    
     public TKDTO getInfoRow(String Ma) {
        TKDTO nv= new TKDTO();
        docDSTK();
        for (TKDTO tempds : TKBUS.dstk) {
            if (tempds.getManhanvien().equals(Ma)) {
                nv = tempds;
                break;
            }
        }
        return nv;
         }
    
}
