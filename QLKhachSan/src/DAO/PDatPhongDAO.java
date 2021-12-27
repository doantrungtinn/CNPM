/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.PDatPhongDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 * 
 */
public class PDatPhongDAO {
    public ArrayList docDSPDatPhong()
    {
        MySQLConnect ConnectData = new MySQLConnect();
        ArrayList <PDatPhongDTO> dspdatphong = new ArrayList<PDatPhongDTO>();
        try
        {
            String query = "select * from phieudatphong";
            ConnectData.st = ConnectData.conn.createStatement();
            ConnectData.rs = ConnectData.st.executeQuery(query);  
            while(ConnectData.rs.next())
            {
                PDatPhongDTO pdatphong = new PDatPhongDTO();

                pdatphong.setMadat(ConnectData.rs.getString(1));
                pdatphong.setMakhdat(ConnectData.rs.getString(2));
                pdatphong.setManv(ConnectData.rs.getString(3));
                pdatphong.setNgaydatphong(ConnectData.rs.getString(4));
                pdatphong.setNgayden(ConnectData.rs.getString(5));
                pdatphong.setNgaydi(ConnectData.rs.getString(6));
                pdatphong.setTienphong(ConnectData.rs.getInt(7));
                pdatphong.setTiencoc(ConnectData.rs.getInt(8));
                pdatphong.setTennguoiluutru(ConnectData.rs.getString(9));
                pdatphong.setCmndnguoiluutru(ConnectData.rs.getString(10));
                pdatphong.setTrangthai(ConnectData.rs.getString(11));
                               
                dspdatphong.add(pdatphong);
            }
        }
        catch(SQLException e)
                {
                    System.out.println(e);
                }
        ConnectData.MySQLDisconnect();
        return dspdatphong;
    }
    
    public void them(PDatPhongDTO pd)
    {
        MySQLConnect ConnectData = new MySQLConnect();
        
        try
        {
            //INSERT INTO `phieudatphong` (`madat`, `makhdat`, `manv`, `ngaydatphong`, `ngayden`, `
            //ngaydi`, `tienphong`, `tiencoc`, `tennguoiluutru`, `cmndnguoiluutru`, `trangthai`) 
            //VALUES ('PD10', '045613583', 'LT2', '2020-11-22', '2020-11-30', '2020-12-03', '', '', '', '', '');
            //
            String query="insert into phieudatphong values('";
            query+=pd.getMadat()+"','"+pd.getMakhdat()+"','"+pd.getManv()+"','";          
            query+=pd.getNgaydatphong()+"','"+pd.getNgayden()+"','"+pd.getNgaydi()+"','";
            query+=pd.getTienphong()+"','"+pd.getTiencoc()+"','"+pd.getTennguoiluutru()+"','";
            query+=pd.getCmndnguoiluutru()+"','"+pd.getTrangthai()+"')";
            ConnectData.st = ConnectData.conn.createStatement();
            ConnectData.st.executeUpdate(query);
        }        
       catch(Exception e)
               {
                   System.out.println(e);
               }
        ConnectData.MySQLDisconnect();
    }
    
    public void sua(String madat, String trangthai)
    {
        MySQLConnect Connect = new MySQLConnect();
        try
        {
            String query="update phieudatphong set trangthai='"+trangthai+"' where madat='"+madat+"'";
            Connect.st= Connect.conn.createStatement();
            Connect.st.executeUpdate(query);
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        Connect.MySQLDisconnect();
    }
    
}
