/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyGUI;

import BUS.NhanVienBUS;
import DTO.NhanVienDTO;
import SupportGUI.DanhSachGUI;
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import java.io.IOException;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.event.MouseInputListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class NhanVienGUI extends JPanel {
 //setbounds(x,y,width,length)
    int choice = 0;
    

    public static DefaultTableModel modelHD, modelCTHD;
    JLabel lbtimkiem, lbtop, lbexit;
    JLabel lblquanly, lblmanhanvien, lblmachucvu, lbltennhanvien, lblngaysinh, lblgioitinh, lblsodienthoai, lbldiachi, lblnhomnhanvien;
    JTextField txtimkiem;
    public static JTextField txtmanhanvien, txttennhanvien, txtngaysinh, txtsodienthoai, txtchucvu, txtdiachi, txtgioitinh;
    JButton them, xoa, sua, ds;
    JComboBox chonmachucvu, chonquyen;
    JButton timkiem, thunho, exit, reset;
    
    DatePicker pickngaysinh;
    JComboBox chontimkiem, chongt;
   
    


    Font font = new Font("Segoe UI", Font.BOLD, 18);
    Border border = BorderFactory.createLineBorder(new Color(33, 33, 33));
    Border bordernull = BorderFactory.createEmptyBorder();
    Border borderinput = BorderFactory.createLineBorder(new Color(30, 210, 96), 4);
    
     JTable table;
    DefaultTableModel model;


    

    public NhanVienGUI(String id) {

        this.setSize(1350, 945);
        this.setLayout(null);
        this.setBorder(border);
        this.setBackground(new Color(237,241,255));
       


        lbtop = new JLabel();
        lbtop.setBounds(0, 0, 950, 65);
        lbtop.setBackground(new Color(134, 174, 195));
        lbtop.setOpaque(true);
        
        txtimkiem = new JTextField(18);
        txtimkiem.setFont(font);
        txtimkiem.setBounds(70, 18, 250, 30);
        txtimkiem.setBorder(border);
       
       /* ImageIcon hinhtimkiem = new ImageIcon(getClass().getResource("/HinhAnh/timkiem.png"));       
        timkiem = new JButton();
        timkiem.setBounds(380, 15, 80, 40);       
        timkiem.setBackground(new Color(31,73,91));
        timkiem.setIcon(hinhtimkiem);
        timkiem.setFont(font);
        timkiem.setBorder(bordernull);
        timkiem.setFocusPainted(false);
        timkiem.setCursor(new Cursor(HAND_CURSOR));      
        timkiem.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                
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
        });*/
         


        lbexit = new JLabel();
        lbexit.setBackground(new Color(33, 33, 33));
        lbexit.setBounds(770, 0, 180, 35);
        

       
       
        ImageIcon hinhexit = new ImageIcon(getClass().getResource("/HinhAnh/thoat.png"));
        exit = new JButton();
        exit.setBounds(120, 0, 60, 35);
        exit.setBackground(new Color(30, 30, 30));
        exit.setIcon(hinhexit);
        exit.setBorder(bordernull);
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
              //  exit.setBackground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
              //  exit.setBackground(new Color(30, 30, 30));
            }

        });   
         String chon[] = {"Theo Mã nhân viên", "Theo Mã chức vụ", "Theo Tên nhân viên"};
         chontimkiem = new JComboBox(chon);
        chontimkiem.setBounds(340, 18, 200, 32);
        chontimkiem.setFont(new Font("Segoe UI", Font.BOLD, 16));
        chontimkiem.setBorder(border);
        chontimkiem.setBackground(new Color(255, 255, 255));
        
  
        lbexit.add(exit);      
        lbtop.add(lbexit);
        lbtop.add(chontimkiem);
        lbtop.add(txtimkiem);
        
      /*  lbtop.add(timkiem);*/
        
        
        //code tiếp giao diện ở đây
// Khởi tạo các label
        lblquanly = new JLabel("THÔNG TIN NHÂN VIÊN");
        lblquanly.setBounds(30, 80, 500, 60);
        lblquanly.setFont(new Font("Segoe UI", Font.BOLD, 30));
        //lbinfosp.setForeground(new Color(30, 215, 96));
        lblquanly.setForeground(new Color(31,73,91));
        
        
        
       

       
        
        
        lblmanhanvien= new JLabel("Mã nhân viên",JLabel.LEFT);
        lblmanhanvien.setBounds(30, 160, 500, 20);
        lblmanhanvien.setFont(font);
        lblmanhanvien.setForeground(new Color(33,33,33));
        txtmanhanvien = new JTextField(18);
        txtmanhanvien.setFont(font);
        txtmanhanvien.setBounds(160, 160, 250, 30);     
        txtmanhanvien.setBorder(border);
        
        lblmachucvu= new JLabel("Mã chức vụ",JLabel.LEFT);
        lblmachucvu.setBounds(435, 145, 100, 50);
        lblmachucvu.setFont(font);
        lblmachucvu.setForeground(new Color(33,33,33));
        
        // combobox
         String choose[] = {"----","LT", "KD","BV","GX","BP","QL","TV","TK","KT"};
        chonmachucvu = new JComboBox(choose);
        //chonmakho.setBounds(340, 18, 130, 32);
        chonmachucvu.setFont(new Font("Segoe UI", Font.BOLD, 16));
        chonmachucvu.setBorder(border);
        chonmachucvu.setBounds(545, 160, 118, 30);
        chonmachucvu.setForeground(new Color(255, 255, 255));
        chonmachucvu.setBackground(new Color(134, 174, 195));
        
        lbltennhanvien= new JLabel("Họ tên ",JLabel.LEFT);
        lbltennhanvien.setBounds(30, 200, 150, 50);
        lbltennhanvien.setFont(font);
        lbltennhanvien.setForeground(new Color(33,33,33));
        txttennhanvien = new JTextField(18);
        txttennhanvien.setFont(font);
        txttennhanvien.setBounds(160, 210, 250, 30);     
        txttennhanvien.setBorder(border);
        
        
        lblngaysinh = new JLabel ("Ngày sinh",JLabel.LEFT);
        lblngaysinh.setBounds(435, 185, 150,80);
        lblngaysinh.setFont(font);
        lblngaysinh.setForeground(new Color(33,33,33));
        txtngaysinh= new JTextField(18);
        txtngaysinh.setFont(font);
        txtngaysinh.setBounds(545, 210, 95, 30);     
        txtngaysinh.setBorder(border);
        // radnam = new JRadioButton("nam");
        // radnam.setBounds(500,270,170,50);
         //radnu = new JRadioButton("nữ");
        // radnu.setBounds(700, 270, 180,50);
       // ButtonGroup group = new ButtonGroup();
       
        
            DatePickerSettings pickerSettings = new DatePickerSettings();
        pickerSettings.setColor(DatePickerSettings.DateArea.TextClearLabel, new Color(30, 210, 96));
        pickerSettings.setColor(DatePickerSettings.DateArea.CalendarBackgroundNormalDates, new Color(255, 255, 255));
        pickerSettings.setColor(DatePickerSettings.DateArea.BackgroundMonthAndYearNavigationButtons, new Color(30, 210, 96));
        pickerSettings.setColor(DatePickerSettings.DateArea.TextTodayLabel, new Color(249, 6, 59));
       
        
        pickerSettings.setSizeDatePanelMinimumHeight(300);
        pickerSettings.setSizeDatePanelMinimumWidth(300);
        pickerSettings.setVisibleDateTextField(false);
        pickngaysinh = new DatePicker(pickerSettings);
        pickngaysinh.setBounds(635,210, 30, 30);
        pickngaysinh.setCursor(new Cursor(HAND_CURSOR));
        pickngaysinh.addDateChangeListener((dce) -> {
            txtngaysinh.setText(pickngaysinh.getDateStringOrEmptyString());
        });
        
        lblsodienthoai = new JLabel ("Số điện thoại",JLabel.LEFT);
        lblsodienthoai.setBounds(675, 145, 150, 50);
        lblsodienthoai.setFont(font);
        lblsodienthoai.setForeground(new Color(33,33,33));
        txtsodienthoai= new JTextField(18);
        txtsodienthoai.setFont(font);
        txtsodienthoai.setBounds(800, 157, 120, 30);     
        txtsodienthoai.setBorder(border);
        
        lbldiachi = new JLabel ("Địa chỉ",JLabel.LEFT);
        lbldiachi.setBounds(30, 260, 100, 50);
        lbldiachi.setFont(font);
        lbldiachi.setForeground(new Color(33,33,33));
        txtdiachi= new JTextField(18);
        txtdiachi.setFont(font);
        txtdiachi.setBounds(160,270,250,30);     
        txtdiachi.setBorder(border);
        
        lblgioitinh = new JLabel ("Giới tính",JLabel.LEFT);
        lblgioitinh.setBounds(435, 270, 100, 30);
        lblgioitinh.setFont(font);
        lblgioitinh.setForeground(new Color(33,33,33));
        txtgioitinh= new JTextField(18);
        txtgioitinh.setFont(font);
        txtgioitinh.setBounds(530,270,60,30);     
        txtgioitinh.setBorder(border);
        
        lblnhomnhanvien= new JLabel("Nhóm nhân viên",JLabel.LEFT);
        lblnhomnhanvien.setBounds(290, 300, 100, 50);
        lblnhomnhanvien.setFont(font);
        lblnhomnhanvien.setForeground(new Color(33,33,33));
        
        // combobox
         String option[] = {"----","Nam", "Nữ"};
        chongt = new JComboBox(option);
        //chonmakho.setBounds(340, 18, 130, 32);
        chongt.setFont(new Font("Segoe UI", Font.BOLD, 16));
        chongt.setBorder(border);
        chongt.setBounds(545, 264, 118, 30);
        chongt.setForeground(new Color(255, 255, 255));
        chongt.setBackground(new Color(134, 174, 195));
        
        
        
        
        
        
         ImageIcon hinhthem = new ImageIcon(getClass().getResource("/HinhAnh/them.png"));
        ImageIcon hinhthem1 = new ImageIcon(getClass().getResource("/HinhAnh/them1.png"));
        them = new JButton();
        them.setBounds(145, 320, 130, 70);
       them.setBackground(new Color(33, 33, 33));
        them.setBorder(bordernull);
       them.setIcon(hinhthem);
        them.setFocusPainted(false);
        them.setContentAreaFilled(false);
        them.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm nhân viên", "Thêm", dialogButton);
            if(dialogResult == 0)
                try{
                NhanVienDTO nv = new NhanVienDTO(); // nho cai nay
                nv.setManhanvien(txtmanhanvien.getText());
                nv.setMachucvu(chonmachucvu.getSelectedItem().toString());
                nv.setTennhanvien(txttennhanvien.getText());
                nv.setNgaysinh(txtngaysinh.getText());
                nv.setGioitinh(chongt.getSelectedItem().toString());
                nv.setDiachi(txtdiachi.getText());
                nv.setSodienthoai(txtsodienthoai.getText());
               
               
                
                NhanVienBUS bus = new NhanVienBUS();
                if (null == NhanVienBUS.dsnv) 
                {
                    bus.docDSNV();
                }
                if (bus.Them(nv)) 
                {
                    Vector row = new Vector();                  
                    row.add(nv.getManhanvien());
                    row.add(nv.getMachucvu());
                    row.add(nv.getTennhanvien());
                    row.add(nv.getNgaysinh());
                    row.add(nv.getGioitinh());
                    row.add(nv.getDiachi());
                    row.add(nv.getSodienthoai());
                    
                    model.addRow(row);
                    table.setModel(model);
                    
                    //txmakho.setText("");
                    chonmachucvu.setSelectedIndex(0);
                    txtmanhanvien.setText("");
                    txttennhanvien.setText("");
                    txtngaysinh.setText("");
                     chongt.setSelectedIndex(0);
                    txtdiachi.setText("");
                    txtsodienthoai.setText("");
                } 
                 } catch (NumberFormatException ex) {
               // JOptionPane.showMessageDialog(null, "Số lượng và giá tiền phải là kiểu số");
            }
            }
            
             @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
             them.setIcon(hinhthem1);
            }

            @Override
            public void mouseExited(MouseEvent e) {
               them.setIcon(hinhthem);
            }

        });
        
        
        
          ImageIcon t = new ImageIcon(getClass().getResource("/HinhAnh/reset.png"));
        ImageIcon t1 = new ImageIcon(getClass().getResource("/HinhAnh/reset1.png"));
        reset = new JButton();
        reset.setBounds(520, 320, 130, 70);
       reset.setBackground(new Color(33, 33, 33));
        reset.setBorder(bordernull);
       reset.setIcon(t);
        reset.setFocusPainted(false);
       reset.setContentAreaFilled(false);
        reset.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
               
                    //txmakho.setText("");
                    chonmachucvu.setSelectedIndex(0);
                    txtmanhanvien.setText("");
                    txttennhanvien.setText("");
                    txtngaysinh.setText("");
                     chongt.setSelectedIndex(0);
                    txtdiachi.setText("");
                
            }
            
             @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
             reset.setIcon(t1);
            }

            @Override
            public void mouseExited(MouseEvent e) {
               reset.setIcon(t);
            }

        });
        
        
        
        
        
         // button
//        ImageIcon ht = new ImageIcon(getClass().getResource("/HinhAnh/them.png"));
   //     ImageIcon ht1 = new ImageIcon(getClass().getResource("/HinhAnh/them1.png"));
        ds = new JButton("DANH SÁCH");
        ds.setEnabled(true);
        ds.setBounds(750, 250, 130, 50);
     
        ds.setForeground(Color.RED);
        ds.setBorder(bordernull);
      //  ds.setIcon(hinhthem);
        ds.setFocusPainted(true);
        ds.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                ThemHDGUI test = new ThemHDGUI();
//                test.setView("Manager");
                DanhSachGUI dsg = new DanhSachGUI();
                dsg.setView(id);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
            //    them.setIcon(hinhthem1);
            }

            @Override
            public void mouseExited(MouseEvent e) {
              //  them.setIcon(hinhthem);
            }

        });
        
      ImageIcon hinhxoa = new ImageIcon(getClass().getResource("/HinhAnh/xoa.png"));
       ImageIcon hinhxoa1 = new ImageIcon(getClass().getResource("/HinhAnh/xoa1.png"));
        xoa = new JButton();
        xoa.setBounds( 400,320, 130, 70);
        xoa.setBackground(new Color(33, 33, 33));
        xoa.setBorder(bordernull);
       xoa.setIcon(hinhxoa);
        xoa.setFocusPainted(false);
        xoa.setContentAreaFilled(false);
        xoa.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int[] clickxoa = table.getSelectedRows();
                if (clickxoa.length==0) 
               {
                    JOptionPane.showMessageDialog(null, "Chọn nhân viên cần xóa");
                } else 
                {
                    
                    int output = JOptionPane.showConfirmDialog(null, "Có chắc muốn xóa nhân viên này", "XÓA", JOptionPane.YES_NO_OPTION);
                   if(output == 0)
                        try{
                                NhanVienDTO nv = new NhanVienDTO(); // nho cai nay
                                nv.setManhanvien(txtmanhanvien.getText());
                                nv.setMachucvu(chonmachucvu.getSelectedItem().toString());
                                nv.setTennhanvien(txttennhanvien.getText());
                                nv.setNgaysinh(txtngaysinh.getText());
                            /*    if(radnam.isSelected()){
                    nv.setGioitinh(true);
                } 
                else {
                    nv.setGioitinh(false);*/
                
                                 nv.setGioitinh(chongt.getSelectedItem().toString());
                                nv.setDiachi(txtdiachi.getText());
                                nv.setSodienthoai(txtsodienthoai.getText());
                                
                                
                                  NhanVienBUS bus = new NhanVienBUS();
                if (null == NhanVienBUS.dsnv) 
                {
                    bus.docDSNV();
                }
                if (bus.Xoa(nv.getManhanvien())) 
                {
                
                
            int  i=table.getSelectedRow();
        if (i>=0)
        {
            model.removeRow(i);
            table.setModel(model);
        }
                    
                    //txmakho.setText("");
                    chonmachucvu.setSelectedIndex(0);
                    txtmanhanvien.setText("");
                    txttennhanvien.setText("");
                    txtngaysinh.setText("");
                    chongt.setSelectedIndex(0);
                    txtdiachi.setText("");
                    txtsodienthoai.setText("");
                } 
                 } catch (NumberFormatException ex) {
               // JOptionPane.showMessageDialog(null, "Số lượng và giá tiền phải là kiểu số");
            
                 }
            } 

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
             xoa.setIcon(hinhxoa1);
            }

            @Override
            public void mouseExited(MouseEvent e) {
               xoa.setIcon(hinhxoa);
            }

        });

   ImageIcon hinhsua = new ImageIcon(getClass().getResource("/HinhAnh/sua.png"));
       ImageIcon hinhsua1 = new ImageIcon(getClass().getResource("/HinhAnh/sua1.png"));
        sua = new JButton();
        sua.setBounds(270, 320, 130, 70);
        sua.setBackground(new Color(33, 33, 33));
        sua.setBorder(bordernull);
       sua.setIcon(hinhsua);
        sua.setFocusPainted(false);
        sua.setContentAreaFilled(false);
        
        sua.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
               int[] clickxoa = table.getSelectedRows();
                if (clickxoa.length==0) 
               {
                    JOptionPane.showMessageDialog(null, "Chọn nhân viên cần sửa");
                } else 
                {
                    
                    int output = JOptionPane.showConfirmDialog(null, "Có chắc muốn sửa nhân viên này", "XÓA", JOptionPane.YES_NO_OPTION);
                   if(output == 0)
                try{
                NhanVienDTO nv = new NhanVienDTO(); // nho cai nay
                nv.setManhanvien(txtmanhanvien.getText());
                nv.setMachucvu(chonmachucvu.getSelectedItem().toString());
                nv.setTennhanvien(txttennhanvien.getText());
                nv.setNgaysinh(txtngaysinh.getText());
              /*  if(radnam.isSelected()){
                    nv.setGioitinh(true);
                } 
                else {
                    nv.setGioitinh(false);
                }*/
              nv.setGioitinh(chongt.getSelectedItem().toString());
                nv.setDiachi(txtdiachi.getText());
                nv.setSodienthoai(txtsodienthoai.getText());
                
                 NhanVienBUS bus = new NhanVienBUS();
                if (null == NhanVienBUS.dsnv) 
                {
                    bus.docDSNV();
                }
                if (bus.Sua(nv)) 
                {
                  int  i=table.getSelectedRow();
                if (i>=0)
                {
            model.setValueAt(txtmanhanvien.getText(), i, 0);
            model.setValueAt(chonmachucvu.getSelectedItem().toString(), i, 1);
            model.setValueAt(txttennhanvien.getText(), i, 2);
            model.setValueAt(txtngaysinh.getText(), i, 3);
            model.setValueAt(chongt.getSelectedItem().toString(), i, 4);
            model.setValueAt(txtdiachi.getText(), i, 5);
            model.setValueAt(txtsodienthoai.getText(), i, 6);
            
            table.setModel(model);
        }
                    
                    //txmakho.setText("");
                    chonmachucvu.setSelectedIndex(0);
                    txtmanhanvien.setText("");
                    txttennhanvien.setText("");
                    txtngaysinh.setText("");
                    chongt.setSelectedIndex(0);
                    txtdiachi.setText("");
                    txtsodienthoai.setText("");
                } 
                 } catch (NumberFormatException ex) {
               // JOptionPane.showMessageDialog(null, "Số lượng và giá tiền phải là kiểu số");
            
                 }
            }
            }
                    
                
            

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
              sua.setIcon(hinhsua1);
            }

            @Override
            public void mouseExited(MouseEvent e) {
             sua.setIcon(hinhsua);
            }

        });
        them.setContentAreaFilled(false);
        xoa.setContentAreaFilled(false);
        sua.setContentAreaFilled(false);
        
         Vector header = new Vector();       
        header.add("Mã nhân viên");
        header.add("Mã chức vụ");
        header.add("Tên nhân viên");
        header.add("Ngày sinh");
        header.add("Giới tính");
        header.add("Địa chỉ");
        header.add("Số điện thoại");
        
        model = new DefaultTableModel(header,0){
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 1:
                        return Integer.class;
                    default:
                        return String.class;
                }
            }
        };
        table = new JTable();
        table.setModel(model);
        table.setFillsViewportHeight(true);
        table.setBorder(border);
        table.setBackground(new Color(255, 255, 255));
        table.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        table.getColumnModel().getColumn(0).setPreferredWidth(25);
        table.getColumnModel().getColumn(1).setPreferredWidth(25);
        table.getColumnModel().getColumn(2).setPreferredWidth(50);
        table.getColumnModel().getColumn(3).setPreferredWidth(25);
        table.getColumnModel().getColumn(4).setPreferredWidth(25);
        table.getColumnModel().getColumn(5).setPreferredWidth(60);
        table.getColumnModel().getColumn(6).setPreferredWidth(50);
        
        table.getTableHeader().setForeground(new Color(255, 255, 255));
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 20));
        table.getTableHeader().setBackground(new Color(31,73,91));
        table.getTableHeader().setBorder(border);
        table.setRowHeight(25);
        
        JScrollPane bangnv = new JScrollPane(table);
        bangnv.setBounds(10, 400, 930, 280);
        bangnv.getVerticalScrollBar().setBackground(new Color(255,255,255));
        
        NhanVienBUS bus = new NhanVienBUS();
            bus.docDSNV();
            
        for (NhanVienDTO nv : NhanVienBUS.dsnv) {
            Vector row = new Vector();
            row.add(nv.getManhanvien());
            row.add(nv.getMachucvu());
            row.add(nv.getTennhanvien());
           // row.add(sp.getMa());
            row.add(nv.getNgaysinh());
            row.add(nv.getGioitinh());
            //row.add(Chuyentien(String.valueOf(sp.getDongia())));
            row.add(nv.getDiachi());
            row.add(nv.getSodienthoai());

            model.addRow(row);
        }
        table.setModel(model);
        
        table.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                int i = table.getSelectedRow();
                if (i >= 0) {
                    String Ma = table.getValueAt(i, 0).toString();

                    NhanVienBUS bus = new NhanVienBUS();
                    NhanVienDTO nv = bus.getInfoRow(Ma);
                    txtmanhanvien.setText(nv.getManhanvien());
                  if (nv.getMachucvu().equals("LT")) 
                    {
                        chonmachucvu.setSelectedIndex(1);
                    }
                    else {
                        chonmachucvu.setSelectedIndex(2);
                    }
                    
                    
                    txttennhanvien.setText(nv.getTennhanvien());
                      if (nv.getGioitinh().equals("Nam")) 
                    {
                        chongt.setSelectedIndex(1);
                    }
                    else {
                        chongt.setSelectedIndex(2);
                    }
                    
                    txtngaysinh.setText(nv.getNgaysinh());
                   /* if(radnam.isSelected()){\
                    nv.setGioitinh(true);
                } 
                else {
                    nv.setGioitinh(false);
                }*/
                    txtdiachi.setText(nv.getDiachi());
                    txtsodienthoai.setText(nv.getSodienthoai());
                    
                    txtmanhanvien.setEditable(false);
               }
                
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
      
        
        

        
        
    //----------**** add các thành phần giao diện ở dưới này ***--------
        this.add(lbtop);
        this.add(lblquanly);
        this.add(lblmanhanvien);
        this.add(txtmanhanvien);
        this.add(lblmachucvu);
        //this.add(txtmachucvu)
        this.add(lbltennhanvien);
        this.add(txttennhanvien);
        this.add(lblngaysinh);
        this.add(txtngaysinh);
        this.add(lblgioitinh);
        //this.add(txtgioitinh);
        this.add(lbldiachi);
        this.add(txtdiachi);
        this.add(lblsodienthoai);
        this.add(txtsodienthoai);
        this.add(them);
        this.add(xoa);
        this.add(sua);
        this.add(ds);
        this.add(bangnv);
        this.add(chonmachucvu);
        this.add(pickngaysinh);
        this.add(chongt);
        this.add(reset);
        
      
    
        
  chontimkiem.addActionListener((ActionEvent e) -> {
            choice = chontimkiem.getSelectedIndex();
            System.out.println(choice);
        });

        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);

        txtimkiem.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                 String text = txtimkiem.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text + ".*", choice));
                }
                
                


//                try {
//                    String text = txtimkiem.getText();
//                    if (choice == 2) {
//                        if (text.trim().length() == 0) {
//                            rowSorter.setRowFilter(null);
//                        } else {
//                           // rowSorter.setRowFilter(RowFilter.regexFilter(Chuyentien(text), choice));
//                           rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, choice));
//                        }
//                    }
//
//                    if (choice != 7 && choice != 6) {
//                        if (text.trim().length() == 0) {
//                            rowSorter.setRowFilter(null);
//                        } else {
//                            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, choice));
//                        }
//                    }
//                } catch (NumberFormatException ex) {
//                    JOptionPane.showMessageDialog(null, "Khi tìm kiếm theo giá buộc phải nhập số");
//                }

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                 String text = txtimkiem.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)^" + text + ".*", choice));
                }
 //               try {
 //                   String text = txtimkiem.getText();
//                    if (choice == 7) {
//                        if (text.trim().length() == 0) {
//                            rowSorter.setRowFilter(null);
//                        } else {
//                            rowSorter.setRowFilter(RowFilter.regexFilter(Chuyentien(text), choice));
//                        }
//                    }
//                    if (choice == 6) {
//                        if (text.trim().length() == 0) {
//                            rowSorter.setRowFilter(null);
//                        } else {
//                            rowSorter.setRowFilter(RowFilter.regexFilter(Chuyentien(text), choice));
//                        }
//                    }
//                    if (choice != 7 && choice != 6) {
//                        if (text.trim().length() == 0) {
//                            rowSorter.setRowFilter(null);
//                        } else {
//                            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)^" + text + ".*", choice));
//                        }
//                    }
//                } catch (NumberFormatException ex) {
//                    JOptionPane.showMessageDialog(null, "Khi tìm kiếm theo giá buộc phải nhập số");
//                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
       
    }
                

     public static void main(String[] args) {
        NhanVienGUI a=new NhanVienGUI("LT1");
            JFrame f=new JFrame();
            f.setSize(1500,800);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.add(a);
            f.setVisible(true);
    }

    public NhanVienGUI() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}



