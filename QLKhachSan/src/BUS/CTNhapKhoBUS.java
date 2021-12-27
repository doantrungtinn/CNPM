/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.CTNhapKhoDAO;
import DTO.CTNhapKhoDTO;
import java.util.ArrayList;

/**
 *
 * @author Truong Thuy Doanh
 */
public class CTNhapKhoBUS {
    public static ArrayList<CTNhapKhoDTO> dsctnhap;
    
    public CTNhapKhoBUS()
    {
        
    }
    
    public void docCTNKtheoMa(String ma)
    {
        CTNhapKhoDAO data = new CTNhapKhoDAO();
        if(dsctnhap==null)
           dsctnhap = new ArrayList<>();
        dsctnhap = data.docDSCTNKtheoMa(ma);
    }
}
