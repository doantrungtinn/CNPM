/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import DAO.CTDatPhongDAO;
import DTO.CTDatPhongDTO;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class CTDatPhongBUS {
    public static ArrayList<CTDatPhongDTO> dsctdatphong;
    
    public CTDatPhongBUS()
    {
        
    }
    
    public void docCTDPtheoMa(String ma)
    {
        CTDatPhongDAO data = new CTDatPhongDAO();
        if(dsctdatphong==null)
           dsctdatphong = new ArrayList<CTDatPhongDTO>();
        dsctdatphong = data.docDSCTDPtheoMa(ma);
    } 
    
    public void themCTDP(CTDatPhongDTO ctdp)
    {
        //dsctdatphong.add(ctdp);
        CTDatPhongDAO data = new CTDatPhongDAO();
        data.them(ctdp);
        
    }
            
}
