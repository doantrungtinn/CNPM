/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.PhieuDichVuDAO;
import DAO.PhongTKDAO;
import DTO.PhieuDichVuDTO;
import DTO.ThongKeLoaiPhongDTO;
import java.util.ArrayList;

/**
 *
 * @author lenovo-x220i
 */
public class ThongKeLoaiPhongBUS {
     public static ArrayList<ThongKeLoaiPhongDTO> dstkp;
     public static ArrayList<ThongKeLoaiPhongDTO> dstkptheongay;
    public void docDSP()
    {
        PhongTKDAO data=new PhongTKDAO();
        if(dstkp==null)
            dstkp=new ArrayList<ThongKeLoaiPhongDTO>();
        dstkp=data.docdsphong();
    }
    public void docDSPngay(String ngaybd,String ngaykt)
    {
        PhongTKDAO data=new PhongTKDAO();
        if(dstkptheongay==null)
            dstkptheongay=new ArrayList<ThongKeLoaiPhongDTO>();
        dstkptheongay=data.docdsphongtheongay(ngaybd,ngaykt);
    }
}
