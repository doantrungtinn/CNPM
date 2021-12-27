/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyGUI;


import BUS.TaiKhoanBUS;
import DTO.TaiKhoanDTO;
import SupportGUI.DanhSachTKGUI;
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

public class TaiKhoanGUI extends JPanel {
    
    int choice = 0;
    

   
 //setbounds(x,y,width,length)

    public static DefaultTableModel modelHD, modelCTHD;
    JLabel lbtimkiem, lbtop, lbexit;
    JTextField txtimkiem;
    JButton timkiem, thunho, exit;
    JLabel lblmanhanvien, lbltentaikhoan, lblmatkhau, lbltrangthai,lblquanly;
    JTextField txtmanhanvien, txttentaikhoan;
    JPasswordField pfmatkhau;
    JButton btnthem, btnsua, btnxoa, btnxem, reset,ds;
    JTable table;
    JComboBox chontrangthai, chontimkiem;
    DefaultTableModel model;
    
    


    Font font = new Font("Segoe UI", Font.BOLD, 18);
    Border border = BorderFactory.createLineBorder(new Color(33, 33, 33));
    Border bordernull = BorderFactory.createEmptyBorder();
    Border borderinput = BorderFactory.createLineBorder(new Color(30, 210, 96), 4);

    

    public TaiKhoanGUI(String id) {

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
        
        
       
      /*  ImageIcon hinhtimkiem = new ImageIcon(getClass().getResource("/HinhAnh/timkiem.png"));       
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
                exit.setBackground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exit.setBackground(new Color(30, 30, 30));
            }

        });    
        
        
        String chon[] = {"Theo Mã nhân viên", "Theo Tên tài khoản"};
         chontimkiem = new JComboBox(chon);
        chontimkiem.setBounds(330, 19, 190, 30);
        chontimkiem.setFont(new Font("Segoe UI", Font.BOLD, 16));
        chontimkiem.setBorder(border);
        chontimkiem.setBackground(new Color(255, 255, 255));
        
          lbexit.add(exit);      
        lbtop.add(lbexit);
        lbtop.add(txtimkiem);
      //  lbtop.add(timkiem);
        lbtop.add(chontimkiem);
        
        
        
        //code tiếp giao diện ở đây
        lblquanly = new JLabel("THÔNG TIN TÀI KHOẢN");
        lblquanly.setBounds(270,70,500,60);
        lblquanly.setFont(new Font("Segoe UI", Font.BOLD, 30));
        lblquanly.setForeground(new Color(31,73,91));
         
     
        lblmanhanvien = new JLabel("Mã nhân viên",JLabel.LEFT);
        lblmanhanvien.setBounds(250,140,150,60);
        lblmanhanvien.setFont(font);
        lblmanhanvien.setForeground(new Color(33,33,33));
        txtmanhanvien = new JTextField(18);
        txtmanhanvien.setFont(font);
        txtmanhanvien.setBounds(400,155, 250, 30);
        txtmanhanvien.setBorder(border);
        
        
        lbltentaikhoan = new JLabel("Tên tài khoản",JLabel.LEFT);
        lbltentaikhoan.setBounds(250,200,150,60);
        lbltentaikhoan.setFont(font);
        lbltentaikhoan.setForeground(new Color(33,33,33));
        txttentaikhoan = new JTextField(20);
        txttentaikhoan.setFont(font);
        txttentaikhoan.setBounds(400,210,250,30);
        txttentaikhoan.setBorder(border);
        
        
        lblmatkhau = new JLabel("Mật khẩu",JLabel.LEFT);
        lblmatkhau.setBounds(250,260,150,60);
        lblmatkhau.setFont(font);
        lblmatkhau.setForeground(new Color(33,33,33));
        pfmatkhau = new JPasswordField();
        pfmatkhau.setBounds(400,279,250,30);
        pfmatkhau.setForeground(new Color(33,33,33));
        pfmatkhau.setFont(font);
        
        
        
        lbltrangthai = new JLabel("Trạng thái",JLabel.LEFT);
        lbltrangthai.setBounds(250,330,150,60);
        lbltrangthai.setFont(font);
        lbltrangthai.setForeground(new Color(33,33,33));
        // combobox
         String choose[] = {"----","Hoạt động", "Khóa"};
        chontrangthai = new JComboBox(choose);
        //chonmakho.setBounds(340, 18, 130, 32);
        chontrangthai.setFont(new Font("Segoe UI", Font.BOLD, 16));
        chontrangthai.setBorder(border);
        chontrangthai.setBounds(400, 350, 250, 30);
        chontrangthai.setForeground(new Color(255, 255, 255));
        chontrangthai.setBackground(new Color(134, 174, 195));
        
        
        
        ImageIcon hinhthem = new ImageIcon(getClass().getResource("/HinhAnh/them.png"));
        ImageIcon hinhthem1 = new ImageIcon(getClass().getResource("/HinhAnh/them1.png"));
        btnthem = new JButton();
        btnthem.setBounds(50, 140, 130, 70);
        btnthem.setBackground(new Color(33, 33, 33));
        btnthem.setBorder(bordernull);
        btnthem.setIcon(hinhthem);
        btnthem.setFocusPainted(false);
        btnthem.setContentAreaFilled(false);
        btnthem.addMouseListener(new MouseListener() {
           @Override
            public void mouseClicked(MouseEvent e) {
                int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm tài khoản", "Thêm", dialogButton);
            if(dialogResult == 0)
                try{
                TaiKhoanDTO tk = new TaiKhoanDTO(); // nho cai nay
                tk.setTentaikhoan(txttentaikhoan.getText());
                tk.setMatkhau(pfmatkhau.getText());
                tk.setManhanvien(txtmanhanvien.getText());
                tk.setTrangthai(chontrangthai.getSelectedItem().toString());
                
               
               
                
                TaiKhoanBUS bus = new TaiKhoanBUS();
                if (null == TaiKhoanBUS.dstk) 
                {
                    bus.docDSTK();
                }
                if (bus.Them(tk)) 
                {
                    Vector row = new Vector();                  
                    row.add(tk.getTentaikhoan());
                    row.add(tk.getMatkhau());
                    row.add(tk.getManhanvien());
                    row.add(tk.getTrangthai());
                   
                    
                    model.addRow(row);
                    table.setModel(model);
                    
                    //txmakho.setText("");
                    chontrangthai.setSelectedIndex(0);
                    txtmanhanvien.setText("");
                    txttentaikhoan.setText("");
                    pfmatkhau.setText("");
                    
                    txtmanhanvien.setText("");
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
                btnthem.setIcon(hinhthem1);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnthem.setIcon(hinhthem);
            }

            
            });
         ImageIcon hinhsua = new ImageIcon(getClass().getResource("/HinhAnh/sua.png"));
        ImageIcon hinhsua1 = new ImageIcon(getClass().getResource("/HinhAnh/sua1.png"));
        btnsua = new JButton();
        btnsua.setBounds(50, 197, 130, 70);
        btnsua.setBackground(new Color(33, 33, 33));
        btnsua.setBorder(bordernull);
        btnsua.setIcon(hinhsua);
        btnsua.setFocusPainted(false);
        btnsua.setContentAreaFilled(false);
        
        btnsua.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
               int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có muốn sửa tài khoản", "Sửa", dialogButton);
            if(dialogResult == 0)
                try{
                TaiKhoanDTO tk = new TaiKhoanDTO(); // nho cai nay
                tk.setTentaikhoan(txttentaikhoan.getText());
                tk.setMatkhau(pfmatkhau.getText());
                tk.setManhanvien(txtmanhanvien.getText());
                tk.setTrangthai(chontrangthai.getSelectedItem().toString());
              
             
                 TaiKhoanBUS bus = new TaiKhoanBUS();
                if (null == TaiKhoanBUS.dstk) 
                {
                    bus.docDSTK();
                }
                if (bus.Sua(tk)) 
                {
                  int  i=table.getSelectedRow();
                if (i>=0)
                {
            model.setValueAt(txttentaikhoan.getText(), i, 0);
            model.setValueAt(pfmatkhau.getText(), i, 1);
            model.setValueAt(txtmanhanvien.getText(), i, 2);
            model.setValueAt(chontrangthai.getSelectedItem().toString(), i, 3);
           
            table.setModel(model);
        }
                    
                    //txmakho.setText("");
                    chontrangthai.setSelectedIndex(0);
                    txttentaikhoan.setText("");
                    pfmatkhau.setText("");
                    txtmanhanvien.setText("");
                    
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
                btnsua.setIcon(hinhsua1);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnsua.setIcon(hinhsua);
            }

        });
        
         
         ImageIcon h = new ImageIcon(getClass().getResource("/HinhAnh/reset.png"));
        ImageIcon h1 = new ImageIcon(getClass().getResource("/HinhAnh/xoa1.png"));
        reset = new JButton();
        reset.setBounds( 50,313, 130, 70);
        reset.setBackground(new Color(33, 33, 33));
        reset.setBorder(bordernull);
        reset.setIcon(h);
        reset.setFocusPainted(false);
        reset.setContentAreaFilled(false);
        reset.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
               
        
                    
                    //txmakho.setText("");
                    chontrangthai.setSelectedIndex(0);
                    txtmanhanvien.setText("");
                    txttentaikhoan.setText("");
                    pfmatkhau.setText("");
                   
           

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                reset.setIcon(h);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                 reset.setIcon(h);
            }

        });
        
        
         ds = new JButton("DANH SÁCH");
        ds.setEnabled(true);
        ds.setBounds(800, 380, 100, 30);
        ds.setForeground(Color.RED);
       ds.setBackground(Color.ORANGE);
        ds.setBorder(bordernull);
       // ds.setIcon(hinhthem);
     //   ds.setFocusPainted(false);
        ds.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                ThemHDGUI test = new ThemHDGUI();
//                test.setView("Manager");
                DanhSachTKGUI dsg = new DanhSachTKGUI();
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
               // them.setIcon(hinhthem1);
            }

            @Override
            public void mouseExited(MouseEvent e) {
              //  them.setIcon(hinhthem);
            }

        });
        
        
        ImageIcon hinhxoa = new ImageIcon(getClass().getResource("/HinhAnh/xoa.png"));
        ImageIcon hinhxoa1 = new ImageIcon(getClass().getResource("/HinhAnh/xoa1.png"));
        btnxoa = new JButton();
        btnxoa.setBounds( 50,254, 130, 70);
        btnxoa.setBackground(new Color(33, 33, 33));
        btnxoa.setBorder(bordernull);
        btnxoa.setIcon(hinhxoa);
        btnxoa.setFocusPainted(false);
        btnxoa.setContentAreaFilled(false);
        btnxoa.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int[] clickxoa = table.getSelectedRows();
                if (clickxoa.length==0) 
               {
                    JOptionPane.showMessageDialog(null, "Chọn tài khoản cần xóa");
                } else 
                {
                    
                    int output = JOptionPane.showConfirmDialog(null, "Có chắc muốn xóa tài khoản này", "XÓA", JOptionPane.YES_NO_OPTION);
                   if(output == 0)
                        try{
                               TaiKhoanDTO tk = new TaiKhoanDTO(); // nho cai nay
                tk.setTentaikhoan(txttentaikhoan.getText());
                tk.setMatkhau(pfmatkhau.getText());
                tk.setManhanvien(txtmanhanvien.getText());
                tk.setTrangthai(chontrangthai.getSelectedItem().toString());
              
               
                TaiKhoanBUS bus = new TaiKhoanBUS();
                if (null == TaiKhoanBUS.dstk) 
                {
                    bus.docDSTK();
                }
                if (bus.Xoa(tk.getManhanvien())) 
                {
                
                
            int  i=table.getSelectedRow();
        if (i>=0)
        {
            model.removeRow(i);
            table.setModel(model);
        }
                    
                    //txmakho.setText("");
                      chontrangthai.setSelectedIndex(0);
                    txttentaikhoan.setText("");
                    pfmatkhau.setText("");
                    txtmanhanvien.setText("");
                    
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
                btnxoa.setIcon(hinhxoa1);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnxoa.setIcon(hinhxoa);
            }

        });

        btnthem.setContentAreaFilled(false);
         btnsua.setContentAreaFilled(false);
        btnxoa.setContentAreaFilled(false);

       
        Vector header = new Vector();       
        header.add("Tên tài khoản");
        header.add("Mật khẩu");
        header.add("Mã nhân viên");
        header.add("Trạng thái");
        
        model = new DefaultTableModel(header,0);
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
        table.getTableHeader().setForeground(new Color(255, 255, 255));
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 20));
        table.getTableHeader().setBackground(new Color(31,73,91));
        table.getTableHeader().setBorder(border);
        table.setRowHeight(25);
        
        JScrollPane bangtk = new JScrollPane(table);
        bangtk.setBounds(10, 420, 930, 280);
        bangtk.getVerticalScrollBar().setBackground(new Color(255,255,255));
        
        TaiKhoanBUS bus = new TaiKhoanBUS();
            bus.docDSTK();
            
        for (TaiKhoanDTO tk : TaiKhoanBUS.dstk) {
            Vector row = new Vector();
            row.add(tk.getTentaikhoan());
            row.add(tk.getMatkhau());
            row.add(tk.getManhanvien());
           // row.add(sp.getMa());
            row.add(tk.getTrangthai());
           
            model.addRow(row);
        }
        table.setModel(model);
        
        table.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                int i = table.getSelectedRow();
                if (i >= 0) {
                    String Ten = table.getValueAt(i, 0).toString();

                    TaiKhoanBUS bus = new TaiKhoanBUS();
                    TaiKhoanDTO tk = bus.getInfoRow(Ten);
                   txttentaikhoan.setText(tk.getTentaikhoan());
                    pfmatkhau.setText(tk.getMatkhau());
                   txtmanhanvien.setText(tk.getManhanvien());
                    if (tk.getTrangthai().equals("Hoạt động")) 
                    {
                        chontrangthai.setSelectedIndex(1);
                    }
                    else {
                        chontrangthai.setSelectedIndex(2);
                    }
                    
                    
                    
                    
                 //   txtmanhanvien.setEditable(false);
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
       
    
                
        
        

        

        
        
    //----------**** add các thành phần giao diện ở dưới này ***--------
        this.add(lbtop); 
        this.add(lblmanhanvien);
        this.add(txtmanhanvien);
        this.add(lbltentaikhoan);
        this.add(txttentaikhoan);
        this.add(pfmatkhau);
        this.add(lblmatkhau);
        this.add(lbltrangthai);
        this.add(chontrangthai);
        this.add(bangtk);
        this.add(btnthem);
       this.add(btnsua);
       this.add(btnxoa);
       this.add(reset);
       this.add(ds);
       this.add(lblquanly);
       
    }
     public static void main(String[] args) {
        TaiKhoanGUI a=new TaiKhoanGUI("BV");
            JFrame f=new JFrame();
            f.setSize(1500,800);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.add(a);
            f.setVisible(true);
    }


}



