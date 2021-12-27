/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.DichVuTKDAO;
import DTO.DichVuDTO;
import DTO.ThongKePhieuDVDTO;
import java.util.ArrayList;

/**
 *
 * @author lenovo-x220i
 */
public class ThongKePhieuDVBUS {
    public static ArrayList <ThongKePhieuDVDTO> dstkdv;
    public static ArrayList<ThongKePhieuDVDTO> dstkdvtheongay;
    public ThongKePhieuDVBUS(){}
    public void docDSTKPDV()
    {
        DichVuTKBUS busdv = new DichVuTKBUS();
        if (DichVuTKBUS.dsdv == null) 
            busdv.docDSDV();
        
        CTDVTKBUS busctdv = new  CTDVTKBUS();
        if (CTDVTKBUS.dsall == null)
            busctdv.docallCTDV();
        
         PhieuDichVuTKBUS buspdv= new  PhieuDichVuTKBUS();
        if (PhieuDichVuTKBUS.dspdv == null) 
            buspdv.docDSPDV();
        
        if(dstkdv == null)
       {
            dstkdv = new ArrayList<>();
       }
        for (DichVuDTO dv : DichVuTKBUS.dsdv)
            {
                ThongKePhieuDVDTO tkpdv = new ThongKePhieuDVDTO();
                tkpdv.setLoaidichvu(String.valueOf(dv.getTenloaidv()));
               // tkpdv.setLoaidichvu(dv.getTenloaidv());
                tkpdv.setTendichvu(dv.getTendv());
                tkpdv.setSoluotdat(busctdv.SoluongdatDV(dv.getMadv(),CTDVTKBUS.dsall));
                dstkdv.add(tkpdv);
            }
    }
    
    public void docDSDVngay(String ngaybd,String ngaykt)
    {
        DichVuTKDAO data=new DichVuTKDAO();
        if(dstkdvtheongay==null)
            dstkdvtheongay=new ArrayList<ThongKePhieuDVDTO>();
        dstkdvtheongay=data.docdsdvtheongay(ngaybd,ngaykt);
    }
    
}
