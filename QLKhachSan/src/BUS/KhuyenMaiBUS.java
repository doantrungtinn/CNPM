
package BUS;

import DAO.KhuyenMaiDAO;
import DTO.KhuyenMaiDTO;
import java.util.List;


public class KhuyenMaiBUS {
    public static List<KhuyenMaiDTO> DSKM() {
            KhuyenMaiDAO userDAO = new KhuyenMaiDAO();
            return userDAO.DSKM();
        }      
	public static void themKM(KhuyenMaiDTO km) {
            KhuyenMaiDAO.themKM(km);
        }      
        public static void suaKM(KhuyenMaiDTO km) {          
            KhuyenMaiDAO.suaKM(km);
        }
        public static void xoaKM(String makm) {
             KhuyenMaiDAO.xoaKM(makm);
        } 

}

