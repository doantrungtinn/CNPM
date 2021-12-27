
package BUS;

import DAO.KhachHangDAO;
import DTO.KhachHangDTO;
import java.util.List;


public class KhachHangBUS {
    public static List<KhachHangDTO> DSKH() {
            KhachHangDAO userDAO = new KhachHangDAO();
            return userDAO.DSKH();
        }      
	public static void themKH(KhachHangDTO khachhang) {
            KhachHangDAO.themKH(khachhang);
        }      
        public static void suaKH(KhachHangDTO khachhang) {          
            KhachHangDAO.suaKH(khachhang);
        }
        public static void xoaKH(String makh) {
             KhachHangDAO.xoaKH(makh);
        } 
        public static List<KhachHangDTO> timkiemKH(String makh) {
            
            return KhachHangDAO.timkiemKH(makh);
        }
 
}
