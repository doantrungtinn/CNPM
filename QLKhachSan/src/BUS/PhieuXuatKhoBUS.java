/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.PhieuXuatKhoDAO;
import DTO.PhieuXuatKhoDTO;
import java.util.ArrayList;


/**
 *
 * @author Truong Thuy Doanh
 */
public class PhieuXuatKhoBUS {
    public  static ArrayList<PhieuXuatKhoDTO> dsPXK;
    
    public void docCTPX(){
        PhieuXuatKhoDAO data = new PhieuXuatKhoDAO();
        if(dsPXK == null)
            dsPXK = new ArrayList<>();
        dsPXK = data.docdsphieuxkho();
    }
    
    public void thempn(PhieuXuatKhoDTO pxk){
        PhieuXuatKhoDAO data = new PhieuXuatKhoDAO();
        data.Them(pxk);
        dsPXK.add(pxk);
    }
}
