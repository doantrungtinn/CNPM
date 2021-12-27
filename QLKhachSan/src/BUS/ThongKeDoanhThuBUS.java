/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.DichVuTKDAO;
import DAO.ThongKeDoanhThuDAO;
import DTO.ThongKeDoanhThuDTO;
import java.util.ArrayList;

/**
 *
 * @author dell
 */
public class ThongKeDoanhThuBUS {
    public static ArrayList <ThongKeDoanhThuDTO> dshd;
    public ThongKeDoanhThuBUS(){}
    public void docDSHD() {
        ThongKeDoanhThuDAO data = new ThongKeDoanhThuDAO();
        if (dshd == null) {
            dshd = new ArrayList<ThongKeDoanhThuDTO>();            
        }
        dshd = data.dochoadon();
    }
}
