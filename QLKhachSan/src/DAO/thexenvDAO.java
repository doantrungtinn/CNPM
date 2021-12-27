/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import DTO.thexenvDTO;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author TRAN VAN BO
 */
public class thexenvDAO {

    public ArrayList docdsthexenv() throws SQLException{
        MySQLConnect ConnectData =new MySQLConnect();
        ArrayList <thexenvDTO> dstxnv =new ArrayList<thexenvDTO> ();
      
        try 
        {
            String qry ="select txnv.mathe,nv.manv,txnv.soxe,txnv.loaixe,txnv.trangthai,ql.maxe,ql.thoigianvao,ql.thoigianra\n"
                    +" from qlxe as ql,  nhanvien as nv , thexenv as txnv\n" + "where ql.maxe=txnv.maxe  and nv.manv=txnv.manv";
            ConnectData.st = ConnectData.conn.createStatement();
            ConnectData.rs = ConnectData.st.executeQuery(qry);
            while (ConnectData.rs.next()){
                thexenvDTO nx =new thexenvDTO();
                
                nx.setMathe(ConnectData.rs.getString(1));
                nx.setMaxe(ConnectData.rs.getString(2));
                nx.setManv("cinvfd");
                nx.setTennv("cxz");
                nx.setThoigianvao(LocalDateTime.MIN);
                nx.setThoigianra(LocalDateTime.MIN);
                nx.setLoaixe(ConnectData.rs.getString(5));
                nx.setSoxe(ConnectData.rs.getString(6));
                nx.setTrangthai(ConnectData.rs.getString(7));
       
              dstxnv.add(nx);
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
        ConnectData.MySQLDisconnect();
        return dstxnv;
    }
    
}
