
package MainFrame;


import NVKinhDoanhGUI.DichVuGUI;
import NVKinhDoanhGUI.KhachHangGUI;
import NVKinhDoanhGUI.KhuyenMaiGUI;
import NVKinhDoanhGUI.PhongGUI;
import NVKinhDoanhGUI.TKDichVuGUI;
import NVKinhDoanhGUI.TKDoanhThuGUI;
import NVKinhDoanhGUI.TKLoaiPhongGUI;
import NVKinhDoanhGUI.TKLuongGUI;
import java.awt.*;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NVKinhDoanhFrame extends JFrame {

    DefaultTableModel model;
    JPanel pn1, pntop, pnleft, pnsanpham;
    JPanel pncontent;
    //lbhome, lbkhach, lbkhuyenmai, lbdichvu, lbtkloaiphong, lbtkdichvu, lbtkluong, lbtkdoanhthu
    //c1, c2, c3, c4, c5, c6, c7, c8
    JLabel lbhome, lbkhach, lbkhuyenmai, lbdichvu, lbtkloaiphong, lbtkdichvu, lbtkluong, lbtkdoanhthu, lbphong,
            lbthoat, lbsetting,lbsetting_hid,lbabc, lbdangxuat, patt;
    JLabel hinhhome, hinhsp, hinhkh, hinhhd, hinhbh, hinhpnh,hinhluong, hinhdoanhthu, hinhphong; 
    JLabel  hinhdangxuat,hinhtheme, hinhqltk,hinhsetting,hinhsetting_hid,ba_cham/*, kmthuong, kmdip*/;
    JPanel c1, c2, c3, c4, c5, c6, c7, c8, c9;
    JPanel c10, c11;
    JButton exit;
    Color color_background =new Color(31,73,91);
    Color color_font_hover=new Color(179, 179, 179);
    Color color_font_no_hover=new Color(255, 255, 255);
    Color color_part=new Color(30, 215, 96); //maudo

    Border border = BorderFactory.createLineBorder(color_background);
    Border nullborder = BorderFactory.createLineBorder(null);
    Image bg;
    Font font= new Font("Segoe UI", Font.BOLD, 20);
    Font font1 = new Font("Segoe UI", Font.BOLD, 25);
    public NVKinhDoanhFrame() {
        ImageIcon img = new ImageIcon("src/HinhAnh/employee.png");
        this.setIconImage(img.getImage());
        this.setUndecorated(true);
        //this.setSize(1600, 945);
        this.setSize(1200,700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
        this.setResizable(false);
    }

    public void ShowBang() {
        // Panel left
        pnleft = new JPanel();        
        pnleft.setBounds(0, 0, 250, 700);
        pnleft.setBackground(color_background); //18,18,18( tím)
        pnleft.setLayout(null);

        ImageIcon imghome = new ImageIcon(getClass().getResource("/HinhAnh/hinhhome.png"));
        ImageIcon imghomef = new ImageIcon(getClass().getResource("/HinhAnh/hinhhomef.png"));
        ImageIcon imgsp = new ImageIcon(getClass().getResource("/HinhAnh/sanpham.png"));
        ImageIcon imgspf = new ImageIcon(getClass().getResource("/HinhAnh/sanphamf.png"));
        ImageIcon imgkh = new ImageIcon(getClass().getResource("/HinhAnh/khachhang.png"));
        ImageIcon imgkhf = new ImageIcon(getClass().getResource("/HinhAnh/khachhangf.png"));
        ImageIcon imghoadon = new ImageIcon(getClass().getResource("/HinhAnh/hoadon.png"));
        ImageIcon imghoadonf = new ImageIcon(getClass().getResource("/HinhAnh/hoadonf.png"));
        ImageIcon imgbaohanh = new ImageIcon(getClass().getResource("/HinhAnh/baohanh.png"));
        ImageIcon imgbaohanhf = new ImageIcon(getClass().getResource("/HinhAnh/baohanhf.png"));
        ImageIcon imgpnh = new ImageIcon(getClass().getResource("/HinhAnh/pnh.png"));
        ImageIcon imgpnhf = new ImageIcon(getClass().getResource("/HinhAnh/pnhf.png"));
        ImageIcon imgkm = new ImageIcon(getClass().getResource("/HinhAnh/km.png"));
        ImageIcon imgkmf = new ImageIcon(getClass().getResource("/HinhAnh/kmf.png"));
        ImageIcon imgnhanvien = new ImageIcon(getClass().getResource("/HinhAnh/nhanvien.png"));
        ImageIcon imgnhanvienf = new ImageIcon(getClass().getResource("/HinhAnh/nhanvienf.png"));
        ImageIcon imgthongke = new ImageIcon(getClass().getResource("/HinhAnh/thongke.png"));
        ImageIcon imgthongkef = new ImageIcon(getClass().getResource("/HinhAnh/thongkef.png"));
        ImageIcon imgdangxuat = new ImageIcon(getClass().getResource("/HinhAnh/dangxuat.png"));
        ImageIcon imgdangxuatf = new ImageIcon(getClass().getResource("/HinhAnh/dangxuatf.png"));
        ImageIcon imgqltk = new ImageIcon(getClass().getResource("/HinhAnh/qltk.png"));
        ImageIcon imgqltkf = new ImageIcon(getClass().getResource("/HinhAnh/qltkf.png"));
        ImageIcon imgsetting = new ImageIcon(getClass().getResource("/HinhAnh/setting.png"));
        ImageIcon imgsettingf = new ImageIcon(getClass().getResource("/HinhAnh/settingf.png"));   
        ImageIcon imgtheme = new ImageIcon(getClass().getResource("/HinhAnh/theme.png")); 
        ImageIcon imgthemef = new ImageIcon(getClass().getResource("/HinhAnh/themef.png")); 
        ImageIcon hinh3dot = new ImageIcon(getClass().getResource("/HinhAnh/3dot.png"));

        
        pntop = new JPanel();
        pntop.setBounds(250,0, 950, 65);
        pntop.setOpaque(true);
        pntop.setLayout(null);
        
     
        lbthoat = new JLabel();
        lbthoat.setBackground(new Color(33,33,33));
        lbthoat.setBackground(Color.CYAN);
        lbthoat.setBounds(770, 0, 180, 35);
        
        ImageIcon hinhexit = new ImageIcon(getClass().getResource("/HinhAnh/thoat.png"));
        exit = new JButton();
        exit.setBounds(120, 0, 60, 35);
        exit.setBackground(new Color(30, 30, 30));
        exit.setIcon(hinhexit);
        exit.setBorder(null);
        exit.setFocusPainted(false);
        exit.setHorizontalTextPosition(SwingConstants.LEFT);
        exit.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                exit.setBackground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exit.setBackground(new Color(30, 30, 30));
            }

        });

        lbthoat.add(exit);
        pntop.add(lbthoat);
    
        hinhtheme = new JLabel();
        hinhtheme.setBounds(20,780, 40, 40);
        hinhtheme.setBackground(color_background);
        hinhtheme.setIcon(imgtheme);
        hinhtheme.setOpaque(true);
        hinhtheme.setVisible(false);
        
        hinhqltk = new JLabel();
        hinhqltk.setBounds(20,730, 40, 40);
        hinhqltk.setBackground(color_background);
        hinhqltk.setIcon(imgqltk);
        hinhqltk.setOpaque(true);
        hinhqltk.setVisible(false);
        
        hinhdangxuat = new JLabel();
        hinhdangxuat.setBounds(20, 830, 40, 40);
        hinhdangxuat.setIcon(imgdangxuat);
        hinhdangxuat.setBackground(color_background);
        hinhdangxuat.setOpaque(true);
        hinhdangxuat.setVisible(false);
        
        lbdangxuat = new JLabel("Đăng Xuất");
        lbdangxuat.setFont(font);
        lbdangxuat.setForeground(color_font_no_hover);
        lbdangxuat.setBounds(73, 600, 200, 40);
        lbdangxuat.setVisible(false);

        pnleft.add(hinhtheme);
        pnleft.add(hinhqltk);
        pnleft.add(hinhdangxuat);
        pnleft.add(lbdangxuat);
       
        c11 = new JPanel(); // cái | xanh xanh bên rìa trái ở menu       
        c11.setBounds(0, 650, 10, 40);
        c11.setBackground(color_background);
        hinhsetting_hid = new JLabel();
        hinhsetting_hid.setIcon(imgsetting);       
        hinhsetting_hid.setBounds(20, 650, 40, 40);
        lbsetting_hid = new JLabel("Cài đặt");
        lbsetting_hid.setForeground(color_font_no_hover);
        lbsetting_hid.setBackground(color_background);
        lbsetting_hid.setFont(new Font("Segoe UI", Font.BOLD, 20));        
        lbsetting_hid.setBounds(73, 650, 200, 40);
        lbsetting_hid.setCursor(new Cursor(HAND_CURSOR));
        lbsetting_hid.setOpaque(true);
        lbsetting_hid.setVisible(true);
        lbsetting_hid.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                lbsetting_hid.setVisible(false);
                lbsetting.setVisible(true);
                hinhqltk.setVisible(false);
                //lbqltk.setVisible(false);
                hinhtheme.setVisible(false);
                //lbtheme.setVisible(false);
                hinhdangxuat.setVisible(false);
                lbdangxuat.setVisible(false);
                hinhsetting.setIcon(imgsetting);
                hinhqltk.setIcon(imgqltk);
                hinhdangxuat.setIcon(imgdangxuat);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
               
            }

            @Override
            public void mouseExited(MouseEvent e) {
            
            }

        });
      
        
        ba_cham = new JLabel(" ABC Hotel");
        ba_cham.setBounds(30, 25, 200, 30);
        ba_cham.setFont(new Font("Segoe UI", Font.BOLD, 20));
        ba_cham.setForeground(new Color(255, 255, 255));
        ba_cham.setIcon(hinh3dot);
        this.add(ba_cham);

        c1 = new JPanel();
        c1.setBounds(0, 75, 10, 40);
        c1.setBackground(color_background);
        lbhome = new JLabel("Trang chủ");
        lbhome.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lbhome.setForeground(color_font_no_hover);
        lbhome.setBackground(color_background);
        hinhhome = new JLabel();
        hinhhome.setIcon(imghome);
        hinhhome.setBounds(20, 75, 40, 40);
        lbhome.setBounds(73, 75, 200, 40);
        lbhome.setCursor(new Cursor(HAND_CURSOR));
        lbhome.setOpaque(true);
        lbhome.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pncontent.removeAll();        
                pncontent.setBounds(250, 0, 950, 700);
                //pncontent.add(new AdminHomeGUI());
                pncontent.setLayout(null);
                pncontent.setBorder(null);                
             
                c1.setBackground(color_part);
                c9.setBackground(color_background);
                c8.setBackground(color_background);
                c7.setBackground(color_background);
                c3.setBackground(color_background);
                c4.setBackground(color_background);
                c5.setBackground(color_background);
                c6.setBackground(color_background);
                c2.setBackground(color_background);

                hinhphong.setIcon(imghome);
                hinhdoanhthu.setIcon(imgthongke);
                hinhluong.setIcon(imgpnh);
                hinhpnh.setIcon(imgpnh);
                hinhsp.setIcon(imgkh);
                hinhkh.setIcon(imgkm);
                hinhhd.setIcon(imghoadon);
                hinhbh.setIcon(imgbaohanh);
                hinhhome.setIcon(imghomef);
 
                lbhome.setForeground(color_font_hover);
                lbkhach.setForeground(color_font_no_hover);
                lbkhuyenmai.setForeground(color_font_no_hover);
                lbdichvu.setForeground(color_font_no_hover);
                lbtkloaiphong.setForeground(color_font_no_hover);
                lbtkdichvu.setForeground(color_font_no_hover);
                lbtkluong.setForeground(color_font_no_hover);
                lbtkdoanhthu.setForeground(color_font_no_hover);
                lbphong.setForeground(color_font_no_hover);
            
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lbhome.setForeground(color_font_hover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbhome.setForeground(color_font_no_hover);
            }

        });

        c2 = new JPanel();
        c2.setBounds(0, 125, 10, 40);
        c2.setBackground(color_background);
        hinhsp = new JLabel();
        hinhsp.setIcon(imgkh);
        hinhsp.setBounds(20, 125, 40, 40);
        lbkhach = new JLabel("Khách hàng");
        lbkhach.setForeground(color_font_no_hover);
        lbkhach.setBackground(color_background);
        lbkhach.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lbkhach.setBounds(73, 125, 200, 40);
        lbkhach.setCursor(new Cursor(HAND_CURSOR));
        lbkhach.setOpaque(true);
        lbkhach.addMouseListener(new MouseListener() {
            // KHÁCH HÀNG GUI
            @Override
            public void mouseClicked(MouseEvent e) {

                KhachHangGUI khachhangGUI = new KhachHangGUI();
                pncontent.removeAll();                
                pncontent.add(khachhangGUI);               
                pncontent.setBounds(250, 0, 950, 700);
                pncontent.repaint();
                khachhangGUI.revalidate();
                khachhangGUI.repaint();
                
      
                c2.setBackground(color_part);
                c9.setBackground(color_background);
                c8.setBackground(color_background);
                c7.setBackground(color_background);
                c3.setBackground(color_background);
                c4.setBackground(color_background);
                c5.setBackground(color_background);
                c6.setBackground(color_background);
                c1.setBackground(color_background);

                hinhphong.setIcon(imghome);
                hinhdoanhthu.setIcon(imgthongke);
                hinhluong.setIcon(imgpnh);
                hinhpnh.setIcon(imgpnh);
                hinhsp.setIcon(imgkhf);
                hinhkh.setIcon(imgkm);
                hinhhd.setIcon(imghoadon);
                hinhbh.setIcon(imgbaohanh);
                hinhhome.setIcon(imghome);
 
                lbhome.setForeground(color_font_no_hover);
                lbkhach.setForeground(color_font_hover);
                lbkhuyenmai.setForeground(color_font_no_hover);
                lbdichvu.setForeground(color_font_no_hover);
                lbtkloaiphong.setForeground(color_font_no_hover);
                lbtkdichvu.setForeground(color_font_no_hover);
                lbtkluong.setForeground(color_font_no_hover);
                lbtkdoanhthu.setForeground(color_font_no_hover);
                lbphong.setForeground(color_font_no_hover);
            
               
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lbkhach.setForeground(color_font_hover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbkhach.setForeground(color_font_no_hover);
            }

        });

        c3 = new JPanel();
        c3.setBounds(0, 175, 10, 40);
        c3.setBackground(color_background);
        hinhkh = new JLabel();
        hinhkh.setIcon(imgkm);
        hinhkh.setBounds(20, 175, 40, 40);
        lbkhuyenmai = new JLabel("Khuyến mãi");
        lbkhuyenmai.setForeground(color_font_no_hover);
        lbkhuyenmai.setBackground(color_background);
        lbkhuyenmai.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lbkhuyenmai.setBounds(73, 175, 200, 40);
        lbkhuyenmai.setCursor(new Cursor(HAND_CURSOR));
        lbkhuyenmai.setOpaque(true);
        lbkhuyenmai.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                KhuyenMaiGUI kmGUI = new KhuyenMaiGUI();
                pncontent.removeAll();
                pncontent.add(kmGUI);
                pncontent.setBounds(250, 0, 1350, 945);
                pncontent.repaint();
                kmGUI.revalidate();
                kmGUI.repaint();

               
                
                c3.setBackground(color_part);
                c9.setBackground(color_background);
                c8.setBackground(color_background);
                c7.setBackground(color_background);
                c2.setBackground(color_background);
                c4.setBackground(color_background);
                c5.setBackground(color_background);
                c6.setBackground(color_background);
                c1.setBackground(color_background);

                hinhphong.setIcon(imghome);
                hinhdoanhthu.setIcon(imgthongke);
                hinhluong.setIcon(imgpnh);
                hinhpnh.setIcon(imgpnh);
                hinhsp.setIcon(imgkh);
                hinhkh.setIcon(imgkmf);
                hinhhd.setIcon(imghoadon);
                hinhbh.setIcon(imgbaohanh);
                hinhhome.setIcon(imghome);
 
                lbhome.setForeground(color_font_no_hover);
                lbkhach.setForeground(color_font_no_hover);
                lbkhuyenmai.setForeground(color_font_hover);
                lbdichvu.setForeground(color_font_no_hover);
                lbtkloaiphong.setForeground(color_font_no_hover);
                lbtkdichvu.setForeground(color_font_no_hover);
                lbtkluong.setForeground(color_font_no_hover);
                lbtkdoanhthu.setForeground(color_font_no_hover);
                lbphong.setForeground(color_font_no_hover);
              
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lbkhuyenmai.setForeground(color_font_hover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbkhuyenmai.setForeground(color_font_no_hover);
            }
        });
        
        
        c4 = new JPanel();
        c4.setBounds(0, 225, 10, 40);
        c4.setBackground(color_background);
        hinhhd = new JLabel();
        hinhhd.setIcon(imghoadon);
        hinhhd.setBounds(20, 225, 40, 40);
        lbdichvu = new JLabel("Dịch vụ");
        lbdichvu.setForeground(color_font_no_hover);
        lbdichvu.setBackground(color_background);
        lbdichvu.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lbdichvu.setBounds(73, 225, 200, 40);
        lbdichvu.setCursor(new Cursor(HAND_CURSOR));
        lbdichvu.setOpaque(true);
        lbdichvu.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                DichVuGUI dichvuGUI = new DichVuGUI();
                pncontent.removeAll();
                pncontent.add(dichvuGUI);
                pncontent.setBounds(250, 0, 1350, 945);
                pncontent.repaint();
                dichvuGUI.revalidate();
                dichvuGUI.repaint();
               
                
                c4.setBackground(color_part);
                c9.setBackground(color_background);
                c8.setBackground(color_background);
                c7.setBackground(color_background);
                c2.setBackground(color_background);
                c3.setBackground(color_background);
                c5.setBackground(color_background);
                c6.setBackground(color_background);
                c1.setBackground(color_background);

                hinhhome.setIcon(imghome);
                hinhdoanhthu.setIcon(imgthongke);
                hinhluong.setIcon(imgpnh);
                hinhpnh.setIcon(imgpnh);
                hinhsp.setIcon(imgkh);
                hinhkh.setIcon(imgkm);
                hinhhd.setIcon(imghoadonf);
                hinhbh.setIcon(imgbaohanh);
                hinhhome.setIcon(imghome);
 
                lbhome.setForeground(color_font_no_hover);
                lbkhach.setForeground(color_font_no_hover);
                lbkhuyenmai.setForeground(color_font_no_hover);
                lbdichvu.setForeground(color_font_hover);
                lbtkloaiphong.setForeground(color_font_no_hover);
                lbtkdichvu.setForeground(color_font_no_hover);
                lbtkluong.setForeground(color_font_no_hover);
                lbtkdoanhthu.setForeground(color_font_no_hover);
                lbphong.setForeground(color_font_no_hover);
           
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lbdichvu.setForeground(color_font_hover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbdichvu.setForeground(color_font_no_hover);
            }
        });

        c5 = new JPanel();
        c5.setBounds(0, 275, 10, 40);
        c5.setBackground(color_background);
        hinhbh = new JLabel();
        hinhbh.setIcon(imgbaohanh);
        hinhbh.setBounds(20, 275, 40, 40);
        lbtkloaiphong = new JLabel("TK Loại phòng");
        lbtkloaiphong.setForeground(color_font_no_hover);
        lbtkloaiphong.setBackground(color_background);
        lbtkloaiphong.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lbtkloaiphong.setBounds(73, 275, 200, 40);
        lbtkloaiphong.setCursor(new Cursor(HAND_CURSOR));
        lbtkloaiphong.setOpaque(true);
        lbtkloaiphong.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                
                TKLoaiPhongGUI tkloaiphongGUI = new TKLoaiPhongGUI();    
                pncontent.removeAll();
                pncontent.add(tkloaiphongGUI);
                pncontent.setBounds(250, 0, 1350, 945);
                pncontent.repaint();
                tkloaiphongGUI.revalidate();
                tkloaiphongGUI.repaint();
               
         
                c5.setBackground(color_part);
                c9.setBackground(color_background);
                c8.setBackground(color_background);
                c7.setBackground(color_background);
                c2.setBackground(color_background);
                c3.setBackground(color_background);
                c4.setBackground(color_background);
                c6.setBackground(color_background);
                c1.setBackground(color_background);

                hinhhome.setIcon(imghome);               
                hinhdoanhthu.setIcon(imgthongke);
                hinhluong.setIcon(imgpnh);
                hinhpnh.setIcon(imgpnh);
                hinhsp.setIcon(imgkh);
                hinhkh.setIcon(imgkm);
                hinhhd.setIcon(imghoadon);
                hinhbh.setIcon(imgbaohanhf);
                hinhhome.setIcon(imghome);
 
                lbhome.setForeground(color_font_no_hover);
                lbkhach.setForeground(color_font_no_hover);
                lbkhuyenmai.setForeground(color_font_no_hover);
                lbdichvu.setForeground(color_font_no_hover);
                lbtkloaiphong.setForeground(color_font_hover);
                lbtkdichvu.setForeground(color_font_no_hover);
                lbtkluong.setForeground(color_font_no_hover);
                lbtkdoanhthu.setForeground(color_font_no_hover);
                lbphong.setForeground(color_font_no_hover);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lbtkloaiphong.setForeground(color_font_hover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbtkloaiphong.setForeground(color_font_no_hover);
            }
        });

        c6 = new JPanel();
        c6.setBounds(0, 325, 10, 40);
        c6.setBackground(color_background);
        hinhpnh = new JLabel();
        hinhpnh.setIcon(imgpnh);
        hinhpnh.setBounds(20, 325, 40, 40);
        lbtkdichvu = new JLabel("TK Dịch vụ");
        lbtkdichvu.setForeground(color_font_no_hover);
        lbtkdichvu.setBackground(color_background);
        lbtkdichvu.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lbtkdichvu.setBounds(73, 325, 200, 40);
        lbtkdichvu.setCursor(new Cursor(HAND_CURSOR));
        lbtkdichvu.setOpaque(true);
        lbtkdichvu.addMouseListener(new MouseListener() {
            // DỊCH VỤ GUI
            @Override
            public void mouseClicked(MouseEvent e) {
                TKDichVuGUI tkdichvuGUI = new TKDichVuGUI();
                pncontent.removeAll();
                pncontent.add(tkdichvuGUI);
                pncontent.setBounds(250, 0, 1350, 945);
                pncontent.repaint();
                tkdichvuGUI.revalidate();
                tkdichvuGUI.repaint();
                
               

                c6.setBackground(color_part);
                c9.setBackground(color_background);
                c8.setBackground(color_background);
                c7.setBackground(color_background);
                c2.setBackground(color_background);
                c3.setBackground(color_background);
                c4.setBackground(color_background);
                c5.setBackground(color_background);
                c1.setBackground(color_background);

                hinhphong.setIcon(imghome);
                hinhdoanhthu.setIcon(imgthongke);
                hinhluong.setIcon(imgpnh);
                hinhpnh.setIcon(imgpnhf);
                hinhsp.setIcon(imgkh);
                hinhkh.setIcon(imgkm);
                hinhhd.setIcon(imghoadon);
                hinhbh.setIcon(imgbaohanh);
                hinhhome.setIcon(imghome);
 
                lbhome.setForeground(color_font_no_hover);
                lbkhach.setForeground(color_font_no_hover);
                lbkhuyenmai.setForeground(color_font_no_hover);
                lbdichvu.setForeground(color_font_no_hover);
                lbtkloaiphong.setForeground(color_font_no_hover);
                lbtkdichvu.setForeground(color_font_hover);
                lbtkluong.setForeground(color_font_no_hover);
                lbtkdoanhthu.setForeground(color_font_no_hover);
                lbphong.setForeground(color_font_no_hover);

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lbtkdichvu.setForeground(color_font_hover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbtkdichvu.setForeground(color_font_no_hover);
            }
        });
        
        c7 = new JPanel();
        c7.setBounds(0, 375, 10, 40);
        c7.setBackground(color_background);
        hinhluong = new JLabel();
        hinhluong.setIcon(imgpnh);
        hinhluong.setBounds(20, 375, 40, 40);
        lbtkluong = new JLabel("TK Lương");
        lbtkluong.setForeground(color_font_no_hover);
        lbtkluong.setBackground(color_background);
        lbtkluong.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lbtkluong.setBounds(73, 375, 200, 40);
        lbtkluong.setCursor(new Cursor(HAND_CURSOR));
        lbtkluong.setOpaque(true);
        lbtkluong.addMouseListener(new MouseListener() {
            // DỊCH VỤ GUI
            @Override
            public void mouseClicked(MouseEvent e) {
                TKLuongGUI tkluongGUI = new TKLuongGUI();
                pncontent.removeAll();
                pncontent.add(tkluongGUI);
                pncontent.setBounds(250, 0, 1350, 945);
                pncontent.repaint();
                tkluongGUI.revalidate();
                tkluongGUI.repaint();
                
                
                 
                c7.setBackground(color_part);
                c9.setBackground(color_background);
                c8.setBackground(color_background);
                c6.setBackground(color_background);
                c2.setBackground(color_background);
                c3.setBackground(color_background);
                c4.setBackground(color_background);
                c5.setBackground(color_background);
                c1.setBackground(color_background);

                hinhphong.setIcon(imghome);
                hinhdoanhthu.setIcon(imgthongke);
                hinhluong.setIcon(imgpnhf);
                hinhpnh.setIcon(imgpnh);
                hinhsp.setIcon(imgkh);
                hinhkh.setIcon(imgkm);
                hinhhd.setIcon(imghoadon);
                hinhbh.setIcon(imgbaohanh);
                hinhhome.setIcon(imghome);
 
                lbhome.setForeground(color_font_no_hover);
                lbkhach.setForeground(color_font_no_hover);
                lbkhuyenmai.setForeground(color_font_no_hover);
                lbdichvu.setForeground(color_font_no_hover);
                lbtkloaiphong.setForeground(color_font_no_hover);
                lbtkdichvu.setForeground(color_font_no_hover);
                lbtkluong.setForeground(color_font_no_hover);
                lbtkdoanhthu.setForeground(color_font_hover);
                lbphong.setForeground(color_font_no_hover);
                
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lbtkluong.setForeground(color_font_hover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbtkluong.setForeground(color_font_no_hover);
            }
        });
        
        c8 = new JPanel();
        c8.setBounds(0, 425, 10, 40);
        c8.setBackground(color_background);
        hinhdoanhthu = new JLabel();
        hinhdoanhthu.setIcon(imgthongke);
        hinhdoanhthu.setBounds(20, 425, 40, 40);
        lbtkdoanhthu = new JLabel("TK Doanh thu");
        lbtkdoanhthu.setForeground(color_font_no_hover);
        lbtkdoanhthu.setBackground(color_background);
        lbtkdoanhthu.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lbtkdoanhthu.setBounds(73, 425, 200, 40);
        lbtkdoanhthu.setCursor(new Cursor(HAND_CURSOR));
        lbtkdoanhthu.setOpaque(true);
        lbtkdoanhthu.addMouseListener(new MouseListener() {
            // DỊCH VỤ GUI
            @Override
            public void mouseClicked(MouseEvent e) {
                TKDoanhThuGUI thanhtoanGUI = new TKDoanhThuGUI();
                pncontent.removeAll();
                pncontent.add(thanhtoanGUI);
                pncontent.setBounds(250, 0, 1350, 945);
                pncontent.repaint();
                thanhtoanGUI.revalidate();
                thanhtoanGUI.repaint();
                
                              
                c8.setBackground(color_part);
                c9.setBackground(color_background);
                c7.setBackground(color_background);
                c6.setBackground(color_background);
                c2.setBackground(color_background);
                c3.setBackground(color_background);
                c4.setBackground(color_background);
                c5.setBackground(color_background);
                c1.setBackground(color_background);

                hinhdoanhthu.setIcon(imgthongkef);
                hinhphong.setIcon(imghome);
                hinhluong.setIcon(imgpnh);
                hinhpnh.setIcon(imgpnh);
                hinhsp.setIcon(imgkh);
                hinhkh.setIcon(imgkm);
                hinhhd.setIcon(imghoadon);
                hinhbh.setIcon(imgbaohanh);
                hinhhome.setIcon(imghome);
 
                lbhome.setForeground(color_font_no_hover);
                lbkhach.setForeground(color_font_no_hover);
                lbkhuyenmai.setForeground(color_font_no_hover);
                lbdichvu.setForeground(color_font_no_hover);
                lbtkloaiphong.setForeground(color_font_no_hover);
                lbtkdichvu.setForeground(color_font_no_hover);
                lbtkluong.setForeground(color_font_no_hover);
                lbtkdoanhthu.setForeground(color_font_hover);
                lbphong.setForeground(color_font_no_hover);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lbtkdoanhthu.setForeground(color_font_hover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbtkdoanhthu.setForeground(color_font_no_hover);
            }
        });
        
        
        c9 = new JPanel();
        c9.setBounds(0, 475, 10, 40);
        c9.setBackground(color_background);
        hinhphong = new JLabel();
        hinhphong.setIcon(imghome);
        hinhphong.setBounds(20, 475, 40, 40);
        lbphong = new JLabel("Phòng");
        lbphong.setForeground(color_font_no_hover);
        lbphong.setBackground(color_background);
        lbphong.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lbphong.setBounds(73, 475, 200, 40);
        lbphong.setCursor(new Cursor(HAND_CURSOR));
        lbphong.setOpaque(true);
        lbphong.addMouseListener(new MouseListener() {
            // PhÒNG GUI
            @Override
            public void mouseClicked(MouseEvent e) {
                PhongGUI phongGUI = new PhongGUI();
                pncontent.removeAll();
                pncontent.add(phongGUI);
                pncontent.setBounds(250, 0, 1350, 945);
                pncontent.repaint();
                phongGUI.revalidate();
                phongGUI.repaint();
                
                              
                c9.setBackground(color_part); 
                c8.setBackground(color_background);
                c7.setBackground(color_background);
                c6.setBackground(color_background);
                c2.setBackground(color_background);
                c3.setBackground(color_background);
                c4.setBackground(color_background);
                c5.setBackground(color_background);
                c1.setBackground(color_background);

                hinhphong.setIcon(imghomef);
                hinhdoanhthu.setIcon(imgthongke);
                hinhluong.setIcon(imgpnh);
                hinhpnh.setIcon(imgpnh);
                hinhsp.setIcon(imgkh);
                hinhkh.setIcon(imgkm);
                hinhhd.setIcon(imghoadon);
                hinhbh.setIcon(imgbaohanh);
                hinhhome.setIcon(imghome);
 
                lbhome.setForeground(color_font_no_hover);
                lbkhach.setForeground(color_font_no_hover);
                lbkhuyenmai.setForeground(color_font_no_hover);
                lbdichvu.setForeground(color_font_no_hover);
                lbtkloaiphong.setForeground(color_font_no_hover);
                lbtkdichvu.setForeground(color_font_no_hover);
                lbtkluong.setForeground(color_font_no_hover);
                lbtkdoanhthu.setForeground(color_font_no_hover);
                lbphong.setForeground(color_font_hover);
                
                
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lbtkdoanhthu.setForeground(color_font_hover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbtkdoanhthu.setForeground(color_font_no_hover);
            }
        });

        c10 = new JPanel();
        c10.setBounds(0, 890, 10, 40);
        c10.setBackground(color_background);
        hinhsetting = new JLabel();
        hinhsetting.setIcon(imgsetting);
        hinhsetting.setBounds(20, 650, 40, 40);
        lbsetting = new JLabel("Cài đặt");
        lbsetting.setForeground(color_font_no_hover);
        lbsetting.setBackground(color_background);
        lbsetting.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lbsetting.setBounds(73, 650, 200, 40);
        lbsetting.setCursor(new Cursor(HAND_CURSOR));
        lbsetting.setOpaque(true);
        lbsetting.setVisible(true);   
        lbsetting.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lbsetting.setVisible(false);
                lbsetting_hid.setVisible(true);
                hinhqltk.setVisible(true);
                //lbqltk.setVisible(true);
                hinhtheme.setVisible(true);
                hinhdangxuat.setVisible(true);
                lbdangxuat.setVisible(true);
                hinhsetting.setIcon(imgsettingf);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
               lbsetting.setForeground(color_font_hover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbsetting.setForeground(color_font_no_hover);
            }

        });
        
        lbdangxuat.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                hinhqltk.setIcon(imgqltk);
                hinhdangxuat.setIcon(imgdangxuatf);
                Dangxuat();

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lbdangxuat.setForeground(color_font_hover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbdangxuat.setForeground(color_font_no_hover);
            }
        });
        
        pnleft.add(hinhhome);
        pnleft.add(c1);
        pnleft.add(hinhsp);
        pnleft.add(c2);
        pnleft.add(hinhkh);
        pnleft.add(c3);
        pnleft.add(hinhhd);
        pnleft.add(c4);
        pnleft.add(hinhbh);
        pnleft.add(c5);
        pnleft.add(hinhpnh);
        pnleft.add(c6);
        pnleft.add(hinhluong);
        pnleft.add(c7);
        pnleft.add(hinhdoanhthu);
        pnleft.add(c8);
        pnleft.add(hinhphong);
        pnleft.add(c9);
        pnleft.add(c10);
        pnleft.add(hinhsetting);

        pnleft.add(lbhome);
        pnleft.add(lbkhach);
        pnleft.add(lbkhuyenmai);
        pnleft.add(lbdichvu);
        pnleft.add(lbtkloaiphong);
        pnleft.add(lbtkdichvu);
        pnleft.add(lbtkluong);
        pnleft.add(lbtkdoanhthu);
        pnleft.add(lbphong);
        pnleft.add(lbsetting);
        pnleft.add(lbsetting_hid);
        this.add(pnleft);

        pncontent = new JPanel();
        pncontent.setBounds(250, 0, 950, 700);
        pncontent.setLayout(null);
        pncontent.setBorder(null);
        //pncontent.add(new AdminHomeGUI()); // Giao diện chứa thông tin chung của nhân viên
        this.add(pncontent);
        this.repaint();
        this.setVisible(true);
        
             
    }
    
    public void Dangxuat()
    {
        LoginFrame temp = new LoginFrame();
                temp.ShowBang();
                this.setVisible(false);
    }
    
    public static void main(String[] args) {

        NVKinhDoanhFrame test = new NVKinhDoanhFrame();
            test.ShowBang();
    }
}

