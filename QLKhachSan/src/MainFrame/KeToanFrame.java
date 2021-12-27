/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainFrame;

import KeToanGUI.TinhLuongGUI;
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
public class KeToanFrame extends JFrame {

    DefaultTableModel model;
    JPanel pn1, pntop, pnleft, pnsanpham;
    JPanel pncontent;
    //lbhome, lbkhach, lbkhuyenmai, lbdichvu, lbtkloaiphong, lbtkdichvu, lbtkluong, lbtkdoanhthu
    //c1, c2, c3, c4, c5, c6, c7, c8
    JLabel lbhome, lbkhach, /*, lbkhuyenmai, lbdichvu, lbtkloaiphong, lbtkdichvu, lbtkluong, lbtkdoanhthu, lbphong,*/
            lbthoat, lbsetting,lbsetting_hid,lbabc, lbdangxuat, patt;
    JLabel hinhhome, hinhsp, hinhkh, hinhhd, hinhbh, hinhpnh,hinhluong, hinhdoanhthu, hinhphong; 
    JLabel hinhdangxuat,hinhtheme, hinhqltk,hinhsetting,hinhsetting_hid,ba_cham/*, kmthuong, kmdip*/;
    JPanel c1, c2; /*c3, c4, c5, c6, c7, c8, c9;*/
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
    public KeToanFrame() {
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
                c2.setBackground(color_background);


                hinhsp.setIcon(imgkh);
                hinhhome.setIcon(imghomef);
 
                lbhome.setForeground(color_font_hover);
                lbkhach.setForeground(color_font_no_hover);
                
            
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
        lbkhach = new JLabel("Tính lương");
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

                TinhLuongGUI tinhluongGUI = new TinhLuongGUI();
                pncontent.removeAll();                
                pncontent.add(tinhluongGUI);               
                pncontent.setBounds(250, 0, 950, 700);
                pncontent.repaint();
                tinhluongGUI.revalidate();
                tinhluongGUI.repaint();
                
                
                
                PhongGUI phongGUI = new PhongGUI();
                pncontent.removeAll();
                pncontent.add(phongGUI);
                pncontent.setBounds(250, 0, 1350, 945);
                pncontent.repaint();
                phongGUI.revalidate();
                phongGUI.repaint();
                      
                c2.setBackground(color_part);               
                c1.setBackground(color_background);

                lbhome.setForeground(color_font_no_hover);
                lbkhach.setForeground(color_font_hover);
                
                hinhsp.setIcon(imgkhf);
                hinhhome.setIcon(imghome);
 
                lbhome.setForeground(color_font_no_hover);
                lbkhach.setForeground(color_font_hover);            
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
        pnleft.add(c10);
        pnleft.add(hinhsetting);

        pnleft.add(lbhome);
        pnleft.add(lbkhach);       
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
//        try {
//            UIManager.setLookAndFeel( "com.seaglasslookandfeel.SeaGlassLookAndFeel" );
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(GiaoDienManager.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            Logger.getLogger(GiaoDienManager.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            Logger.getLogger(GiaoDienManager.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (UnsupportedLookAndFeelException ex) {
//            Logger.getLogger(GiaoDienManager.class.getName()).log(Level.SEVERE, null, ex);
//        }
        KeToanFrame test = new KeToanFrame();
            test.ShowBang();
    }
}


