/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.PhieuDichVuDAO;
import DTO.PhieuDichVuDTO;
import java.util.ArrayList;

/**
 *
 * @author lenovo-x220i
 */
public class PhieuDichVuTKBUS {
    public static ArrayList<PhieuDichVuDTO> dspdv;
    //public static ArrayList<PhieuDichVuDTO> dspdvtheongay;
    public void docDSPDV()
    {
        PhieuDichVuDAO data=new PhieuDichVuDAO();
        if(dspdv==null)
            dspdv=new ArrayList<PhieuDichVuDTO>();
        dspdv=data.docdsphieudichvu();
    }
//    public void docDSPngay(String ngaybd,String ngaykt)
//    {
//        PhongTKDAO data=new PhongTKDAO();
//        if(dspdvtheongay==null)
//            dspdvtheongay=new ArrayList<ThongKeLoaiPhongDTO>();
//        dstkptheongay=data.docdsphongtheongay(ngaybd,ngaykt);
//    }
}
