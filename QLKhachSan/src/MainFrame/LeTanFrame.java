/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainFrame;

import LeTanGUI.DatPhongGUI;
import LeTanGUI.HuyDatPhongGUI;
import LeTanGUI.ThanhToanGUI;
import LeTanGUI.ThueDVGUI;
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

public class LeTanFrame extends JFrame {

    DefaultTableModel model;
    JPanel pn1, pntop, pnleft, pnsanpham;
    JPanel pncontent;
    //lbdatphong, lbhuydat, lbnhanphong, lbthuedv, lbthanhtoan
    JLabel lbdatphong, lbhuydat, lbnhanphong, lbthuedv, lbthanhtoan, lbthoat, lbhome,
            lbsetting,lbsetting_hid,lbabc, lbdangxuat, patt;
    JLabel hinhhome, hinhsp, hinhkh, hinhhd, hinhbh, hinhpnh, hinhdangxuat,hinhtheme, hinhqltk,hinhsetting,hinhsetting_hid,ba_cham/*, kmthuong, kmdip*/;
    JPanel c1, c2, c3, c4, c5, c6, /*c7,*/ c8, c9,c10,c11;
    JButton exit;
    //Color color_background =new Color(18, 18, 18);
    Color color_background =new Color(31,73,91);
    Color color_font_hover=new Color(179, 179, 179);
    Color color_font_no_hover=new Color(255, 255, 255);
    Color color_part=new Color(30, 215, 96); //maudo

    Border border = BorderFactory.createLineBorder(color_background);
    Border nullborder = BorderFactory.createLineBorder(null);
    Image bg;
    Font font= new Font("Segoe UI", Font.BOLD, 20);
    Font font1 = new Font("Segoe UI", Font.BOLD, 25);
    
    public LeTanFrame() {
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
                c3.setBackground(color_background);
                c4.setBackground(color_background);
                c5.setBackground(color_background);
                c6.setBackground(color_background);


                hinhhome.setIcon(imghomef);
                hinhsp.setIcon(imgsp);
                hinhkh.setIcon(imgkh);
                hinhhd.setIcon(imghoadon);
                hinhbh.setIcon(imgbaohanh);
                hinhpnh.setIcon(imgpnh);


                lbhome.setForeground(color_font_hover);
                lbdatphong.setForeground(color_font_no_hover);
                lbnhanphong.setForeground(color_font_no_hover);
                lbthuedv.setForeground(color_font_no_hover);
                lbhuydat.setForeground(color_font_no_hover);
                lbthanhtoan.setForeground(color_font_no_hover);
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
        hinhsp.setIcon(imgsp);
        hinhsp.setBounds(20, 125, 40, 40);
        lbdatphong = new JLabel("Đặt phòng");
        lbdatphong.setForeground(color_font_no_hover);
        lbdatphong.setBackground(color_background);
        lbdatphong.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lbdatphong.setBounds(73, 125, 200, 40);
        lbdatphong.setCursor(new Cursor(HAND_CURSOR));
        lbdatphong.setOpaque(true);
        lbdatphong.addMouseListener(new MouseListener() {
            // ĐẶT PHÒNG GUI
            @Override
            public void mouseClicked(MouseEvent e) {
//                spGUI = new SachGUI();
//                pncontent.removeAll();                
//                pncontent.add(spGUI);               
//                pncontent.setBounds(250, 0, 950, 700);
//                pncontent.repaint();
//                spGUI.revalidate();
//                spGUI.repaint();
                DatPhongGUI datphongGUI = new DatPhongGUI("LT1");
                pncontent.removeAll();                
                pncontent.add(datphongGUI);               
                pncontent.setBounds(250, 0, 950, 700);
                pncontent.repaint();
                datphongGUI.revalidate();
                datphongGUI.repaint();
                
                
                                     
                c2.setBackground(color_part);
                c1.setBackground(color_background);
                c3.setBackground(color_background);
                c4.setBackground(color_background);
                c5.setBackground(color_background);
                c6.setBackground(color_background);

                hinhhome.setIcon(imghome);
                hinhsp.setIcon(imgspf);
                hinhkh.setIcon(imgkh);
                hinhhd.setIcon(imghoadon);
                hinhbh.setIcon(imgbaohanh);
                hinhpnh.setIcon(imgpnh);


                lbdatphong.setForeground(color_font_hover);
                lbhome.setForeground(color_font_no_hover);
                lbnhanphong.setForeground(color_font_no_hover);
                lbthuedv.setForeground(color_font_no_hover);
                lbhuydat.setForeground(color_font_no_hover);
                lbthanhtoan.setForeground(color_font_no_hover);
            
               
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lbdatphong.setForeground(color_font_hover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbdatphong.setForeground(color_font_no_hover);
            }

        });

        c3 = new JPanel();
        c3.setBounds(0, 175, 10, 40);
        c3.setBackground(color_background);
        hinhkh = new JLabel();
        hinhkh.setIcon(imgkh);
        hinhkh.setBounds(20, 175, 40, 40);
        lbnhanphong = new JLabel("Nhận phòng");
        lbnhanphong.setForeground(color_font_no_hover);
        lbnhanphong.setBackground(color_background);
        lbnhanphong.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lbnhanphong.setBounds(73, 175, 200, 40);
        lbnhanphong.setCursor(new Cursor(HAND_CURSOR));
        lbnhanphong.setOpaque(true);
        lbnhanphong.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

                c3.setBackground(color_part);
                c2.setBackground(color_background);
                c1.setBackground(color_background);
                c4.setBackground(color_background);
                c5.setBackground(color_background);
                c6.setBackground(color_background);


                hinhkh.setIcon(imgkhf);
                hinhsp.setIcon(imgsp);
                hinhhome.setIcon(imghome);
                hinhhd.setIcon(imghoadon);
                hinhbh.setIcon(imgbaohanh);
                hinhpnh.setIcon(imgpnh);


                lbnhanphong.setForeground(color_font_hover);
                lbdatphong.setForeground(color_font_no_hover);
                lbhome.setForeground(color_font_no_hover);
                lbthuedv.setForeground(color_font_no_hover);
                lbhuydat.setForeground(color_font_no_hover);
                lbthanhtoan.setForeground(color_font_no_hover);
              
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lbnhanphong.setForeground(color_font_hover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbnhanphong.setForeground(color_font_no_hover);
            }
        });
        
        
        c4 = new JPanel();
        c4.setBounds(0, 225, 10, 40);
        c4.setBackground(color_background);
        hinhhd = new JLabel();
        hinhhd.setIcon(imghoadon);
        hinhhd.setBounds(20, 225, 40, 40);
        lbhuydat = new JLabel("Hủy đặt phòng");
        lbhuydat.setForeground(color_font_no_hover);
        lbhuydat.setBackground(color_background);
        lbhuydat.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lbhuydat.setBounds(73, 225, 200, 40);
        lbhuydat.setCursor(new Cursor(HAND_CURSOR));
        lbhuydat.setOpaque(true);
        lbhuydat.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                HuyDatPhongGUI huydatGUI = new HuyDatPhongGUI("LT1");
                pncontent.removeAll();
                pncontent.add(huydatGUI);
                pncontent.setBounds(250, 0, 1350, 945);
                pncontent.repaint();
                huydatGUI.revalidate();
                huydatGUI.repaint();

                c4.setBackground(color_part);
                c2.setBackground(color_background);
                c3.setBackground(color_background);
                c1.setBackground(color_background);
                c5.setBackground(color_background);
                c6.setBackground(color_background);

                hinhhd.setIcon(imghoadonf);
                hinhsp.setIcon(imgsp);
                hinhkh.setIcon(imgkh);
                hinhhome.setIcon(imghome);
                hinhbh.setIcon(imgbaohanh);
                hinhpnh.setIcon(imgpnh);


                lbhuydat.setForeground(color_font_hover);
                lbdatphong.setForeground(color_font_no_hover);
                lbnhanphong.setForeground(color_font_no_hover);
                lbthuedv.setForeground(color_font_no_hover);
                lbhome.setForeground(color_font_no_hover);
                lbthanhtoan.setForeground(color_font_no_hover);
           
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lbhuydat.setForeground(color_font_hover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbhuydat.setForeground(color_font_no_hover);
            }
        });

        c5 = new JPanel();
        c5.setBounds(0, 275, 10, 40);
        c5.setBackground(color_background);
        hinhbh = new JLabel();
        hinhbh.setIcon(imgbaohanh);
        hinhbh.setBounds(20, 275, 40, 40);
        lbthuedv = new JLabel("Thuê dịch vụ");
        lbthuedv.setForeground(color_font_no_hover);
        lbthuedv.setBackground(color_background);
        lbthuedv.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lbthuedv.setBounds(73, 275, 200, 40);
        lbthuedv.setCursor(new Cursor(HAND_CURSOR));
        lbthuedv.setOpaque(true);
        lbthuedv.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                
                ThueDVGUI thuedvGUI = new ThueDVGUI();
                pncontent.removeAll();
                pncontent.add(thuedvGUI);
                pncontent.setBounds(250, 0, 1350, 945);
                pncontent.repaint();
                thuedvGUI.revalidate();
                thuedvGUI.repaint();
               

                c5.setBackground(color_part);
                c2.setBackground(color_background);
                c3.setBackground(color_background);
                c4.setBackground(color_background);
                c1.setBackground(color_background);
                c6.setBackground(color_background);


                hinhbh.setIcon(imgbaohanhf);
                hinhsp.setIcon(imgsp);
                hinhkh.setIcon(imgkh);
                hinhhd.setIcon(imghoadon);
                hinhhome.setIcon(imghome);
                hinhpnh.setIcon(imgpnh);


                lbthuedv.setForeground(color_font_hover);
                lbdatphong.setForeground(color_font_no_hover);
                lbnhanphong.setForeground(color_font_no_hover);
                lbhome.setForeground(color_font_no_hover);
                lbhuydat.setForeground(color_font_no_hover);
                lbthanhtoan.setForeground(color_font_no_hover);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lbthuedv.setForeground(color_font_hover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbthuedv.setForeground(color_font_no_hover);
            }
        });

        c6 = new JPanel();
        c6.setBounds(0, 325, 10, 40);
        c6.setBackground(color_background);
        hinhpnh = new JLabel();
        hinhpnh.setIcon(imgpnh);
        hinhpnh.setBounds(20, 325, 40, 40);
        lbthanhtoan = new JLabel("Thanh toán");
        lbthanhtoan.setForeground(color_font_no_hover);
        lbthanhtoan.setBackground(color_background);
        lbthanhtoan.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lbthanhtoan.setBounds(73, 325, 200, 40);
        lbthanhtoan.setCursor(new Cursor(HAND_CURSOR));
        lbthanhtoan.setOpaque(true);
        lbthanhtoan.addMouseListener(new MouseListener() {
            // THANH TOÁN GUI
            @Override
            public void mouseClicked(MouseEvent e) {
                ThanhToanGUI thanhtoanGUI = new ThanhToanGUI();
                pncontent.removeAll();
                pncontent.add(thanhtoanGUI);
                pncontent.setBounds(250, 0, 1350, 945);
                pncontent.repaint();
                thanhtoanGUI.revalidate();
                thanhtoanGUI.repaint();
                
                
                c6.setBackground(color_part);
                c2.setBackground(color_background);
                c3.setBackground(color_background);
                c4.setBackground(color_background);
                c5.setBackground(color_background);
                c1.setBackground(color_background);

                hinhpnh.setIcon(imgpnhf);
                hinhsp.setIcon(imgsp);
                hinhkh.setIcon(imgkh);
                hinhhd.setIcon(imghoadon);
                hinhbh.setIcon(imgbaohanh);
                hinhhome.setIcon(imghome);

                lbthanhtoan.setForeground(color_font_hover);
                lbdatphong.setForeground(color_font_no_hover);
                lbnhanphong.setForeground(color_font_no_hover);
                lbthuedv.setForeground(color_font_no_hover);
                lbhuydat.setForeground(color_font_no_hover);
                lbhome.setForeground(color_font_no_hover);

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lbthanhtoan.setForeground(color_font_hover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbthanhtoan.setForeground(color_font_no_hover);
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
        pnleft.add(c10);
        pnleft.add(hinhsetting);

        pnleft.add(lbhome);
        pnleft.add(lbdatphong);
        pnleft.add(lbnhanphong);
        pnleft.add(lbhuydat);
        pnleft.add(lbthuedv);
        pnleft.add(lbthanhtoan);
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
        LeTanFrame test = new LeTanFrame();
            test.ShowBang();
    }
}

