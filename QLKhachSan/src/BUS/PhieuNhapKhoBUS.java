/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.PhieuNhapKhoDAO;
import DTO.PhieuNhapKhoDTO;
import java.util.ArrayList;


/**
 *
 * @author Truong Thuy Doanh
 */
public class PhieuNhapKhoBUS {
    public  static ArrayList<PhieuNhapKhoDTO> dsPNK;
    public void docCTPN(){
        PhieuNhapKhoDAO data = new PhieuNhapKhoDAO();
        if(dsPNK == null)
            dsPNK = new ArrayList<>();
        dsPNK = data.docdsphieunhapkho();
    }
    public void thempn(PhieuNhapKhoDTO pnk){
        PhieuNhapKhoDAO data = new PhieuNhapKhoDAO();
        data.Them(pnk);
        dsPNK.add(pnk);
    }
    
    
}
