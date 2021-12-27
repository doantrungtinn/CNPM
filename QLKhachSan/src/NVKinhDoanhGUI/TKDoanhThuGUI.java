
package NVKinhDoanhGUI;



import BUS.ThongKeDoanhThuBUS;
import BUS.ThongKePhieuDVBUS;
import DTO.ThongKeDoanhThuDTO;
import DTO.ThongKePhieuDVDTO;
import Report.ExcelReport;
import com.github.lgooddatepicker.components.DatePickerSettings;
import java.awt.BorderLayout;
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
import static java.lang.System.in;
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

public class TKDoanhThuGUI extends JPanel {
 //setbounds(x,y,width,length)
    int choice = 0;

    public static DefaultTableModel modelHD, modelCTHD;
    JLabel lbbtnthongke, lbtop, lbexit, lbtuthang,lbdenthang, lbtunam, lbdennam;
    JPanel pntop, pncenter, pncenter1,pncenter2,pncenter0, pnbot;
    JTextField txbtnthongke;
    JButton btnthongke, thunho, exit;
    JComboBox cbxtuthang, cbxdenthang;
    JTable table;
    DefaultTableModel model;
 
    Font font = new Font("Segoe UI", Font.BOLD, 18);
    Font fonttitle = new Font("Segoe UI", Font.BOLD, 28);
    Border border = BorderFactory.createLineBorder(new Color(33, 33, 33));
    Border bordernull = BorderFactory.createEmptyBorder();
    Border borderinput = BorderFactory.createLineBorder(new Color(30, 210, 96), 4);

    

    public TKDoanhThuGUI() {

        this.setSize(1350, 945);
        this.setLayout(null);
        this.setBorder(border);
        this.setBackground(new Color(237,241,255));


        lbtop = new JLabel("Thống kê doanh thu", SwingConstants.CENTER);
        lbtop.setFont(fonttitle);
        lbtop.setBounds(0, 0, 950, 65);
        lbtop.setBackground(new Color(134, 174, 195));
        lbtop.setOpaque(true);
        
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
        
        
        pncenter = new JPanel();
        pncenter.setBounds(0, 50, 950, 880);
        pncenter.setLayout(null);
        
        pncenter1 = new JPanel();
        pncenter1.setBounds(0, 0, 950, 880);
        pncenter1.setLayout(null);
        
        Font font2 = new Font("Segoe UI", Font.BOLD, 25);
        lbtuthang = new JLabel("Từ tháng:");
        lbtuthang.setFont(font2);
        lbtuthang.setBackground(new Color(31,73,91));
        lbtuthang.setBounds(220, 40, 200, 30);
        
        String thang[] = {"1","2","3","4","5","6","7","8","9","10","11","12"};
 
        cbxtuthang = new JComboBox(thang);
        cbxtuthang.setBounds(350, 40, 100, 30);
        lbdenthang = new JLabel("Đến tháng:");
        lbdenthang.setFont(font2);
        lbdenthang.setBackground(new Color(31,73,91));
        lbdenthang.setBounds(520, 40, 200, 30);
        
        cbxdenthang = new JComboBox(thang);
        cbxdenthang.setBounds(680, 40, 100, 30);
        
        Font font3 = new Font("Segoe UI", Font.BOLD, 20); 
        JButton btnthongke = new JButton("Thống kê");
        btnthongke.setFont(font3);
        btnthongke.setBounds(630,100,150,40);
        btnthongke.setForeground(new Color(255, 255, 255));
        btnthongke.setBackground(new Color(31,73,91));
        btnthongke.setCursor(new Cursor(HAND_CURSOR));      
        btnthongke.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
//            txngaykt.removeAll();
//            txngaybd.removeAll();
            model.setRowCount(0);
                 ThongKeDoanhThuBUS bustkdv = new ThongKeDoanhThuBUS();
        if (ThongKeDoanhThuBUS.dshd == null) {
            bustkdv.docDSHD();
        }
        int i=1;
        for (ThongKeDoanhThuDTO dshd : ThongKeDoanhThuBUS.dshd) {
            Vector row = new Vector();
            row.add(i);
            i++;
            row.add(dshd.getThang());
            row.add(dshd.getTongdoanhthu());
            model.addRow(row); 
            table.setModel(model);
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
        
        Vector header=new Vector();
        header.add("STT");
        header.add("Tháng");
        header.add("Tổng lương");
         model = new DefaultTableModel(header, 0) {
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Integer.class;
                    case 1:
                        return Integer.class;
                    default:
                        return Long.class;
                }
            }
        };
        table = new JTable();
        table.setModel(model);
        table.setFillsViewportHeight(true);
        table.setBorder(border);
        table.setBackground(new Color(255, 255, 255));
        table.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        table.getTableHeader().setForeground(new Color(255, 255, 255));
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 20));
        table.getTableHeader().setBackground(new Color(31,73,91));
        table.getTableHeader().setBorder(border);
        table.setRowHeight(40);
        JScrollPane bangtk = new JScrollPane(table);
        bangtk.setBounds(10, 170, 900, 300);
        
        ImageIcon hinhxuat1 = new ImageIcon(getClass().getResource("/HinhAnh/in4.png"));
        ImageIcon hinhxuat_h = new ImageIcon(getClass().getResource("/HinhAnh/in42.png"));
        
        JButton in = new JButton();
        in.setIcon(hinhxuat1);
        in.setBounds(770, 500, 170, 70);
        in.setBorder(bordernull);
        in.setBackground(new Color(33, 33, 33));
        in.setFocusPainted(false);
        in.addMouseListener(new MouseListener()
                {

            @Override
            public void mouseClicked(MouseEvent e) {
                 ExcelReport excel = new ExcelReport();
            excel.ExportExcel("DSThongKeLoaiPhong", table);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                in.setIcon(hinhxuat_h);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                in.setIcon(hinhxuat1);
            }
                    
                });
        in.setContentAreaFilled(false);
        
        pncenter1.add(lbtuthang);
        pncenter1.add(cbxtuthang);
        pncenter1.add(cbxdenthang);
        pncenter1.add(lbdenthang);
        pncenter1.add(btnthongke);
        pncenter1.add(bangtk);
        pncenter1.add(in);
        
        
    
        
        
//        txbtnthongke = new JTextField(18);
//        txbtnthongke.setFont(font);
//        txbtnthongke.setBounds(70, 18, 250, 30);
//        txbtnthongke.setBorder(border);
       
//        ImageIcon hinhbtnthongke = new ImageIcon(getClass().getResource("/HinhAnh/btnthongke.png"));       
//        btnthongke = new JButton();
//        btnthongke.setBounds(380, 15, 80, 40);       
//        btnthongke.setBackground(new Color(31,73,91));
//        btnthongke.setIcon(hinhbtnthongke);
//        btnthongke.setFont(font);
//        btnthongke.setBorder(bordernull);
//        btnthongke.setFocusPainted(false);
//        btnthongke.setCursor(new Cursor(HAND_CURSOR));      
//        btnthongke.addMouseListener(new MouseListener() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                
//            }
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//               
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {                   
//            }
//        });

       
  
        lbexit.add(exit);      
        lbtop.add(lbexit);
        
        pncenter.add(pncenter1);

        
        
    //----------**** add các thành phần giao diện ở dưới này ***--------
        this.add(lbtop);  
        this.add(pncenter);
       
    }

 public void setEvent(){
        ThongKeDoanhThuBUS bustkdv = new ThongKeDoanhThuBUS();
        if (ThongKeDoanhThuBUS.dshd == null) {
            bustkdv.docDSHD();
        }
        int i=1;
        for (ThongKeDoanhThuDTO dshd : ThongKeDoanhThuBUS.dshd) {
            Vector row = new Vector();
            row.add(i);
            i++;
            row.add(dshd.getThang());
            row.add(dshd.getTongdoanhthu());
            model.addRow(row); 
            table.setModel(model);
        }
    }
        }



