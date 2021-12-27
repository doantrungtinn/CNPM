/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.DichVuTKDAO;
import DTO.DichVuDTO;
import java.util.ArrayList;

/**
 *
 * @author lenovo-x220i
 */
public class DichVuTKBUS {
    public static ArrayList <DichVuDTO> dsdv;
    public DichVuTKBUS(){}
    public void docDSDV() {
        DichVuTKDAO data = new DichVuTKDAO();
        if (dsdv == null) {
            dsdv = new ArrayList<DichVuDTO>();            
        }
        dsdv = data.docdsdichvu();
    }

    public void docdsdichvu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
