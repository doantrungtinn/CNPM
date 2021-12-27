/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.CTDVDAO;
import DTO.CTDVDTO;
import DTO.DichVuDTO;
import java.util.ArrayList;

/**
 *
 * @author lenovo-x220i
 */
public class CTDVTKBUS {
    public static ArrayList <CTDVDTO> dsall;
    public static ArrayList<CTDVDTO> temp;
    
    public void docallCTDV()
    {
        CTDVDAO data=new CTDVDAO();
        if(dsall==null)
            dsall=new ArrayList<>();
        dsall=data.docallCTDV();
    }
    public int SoluongdatDV(String madv, ArrayList<CTDVDTO> temp)
    {
        int sldat = 0;
        for (CTDVDTO x : temp)
        {
            if(x.getMadv().equals(madv))
            sldat++;
        }
        return sldat;
    }

}
