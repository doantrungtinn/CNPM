
package NVKinhDoanhGUI;



import Report.ExcelReport;
import com.github.lgooddatepicker.components.DatePicker;
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

public class TKLuongGUI extends JPanel {
 //setbounds(x,y,width,length)
    int choice = 0;

    public static DefaultTableModel modelHD, modelCTHD;
    JLabel lbtimkiem, lbtop, lbexit, lbtuthang,lbdenthang, lbphongban;
    JPanel pntop, pncenter, pncenter1,pncenter2, pnbot;
    JTextField txtimkiem;
    JButton timkiem, thunho, exit, btnthongke;
    JComboBox cbxtuthang, cbxdenthang, cbxPB;
    JTable table;
    DefaultTableModel model;


    Font font = new Font("Segoe UI", Font.BOLD, 18);
    Font fonttitle = new Font("Segoe UI", Font.BOLD, 28);
    Border border = BorderFactory.createLineBorder(new Color(33, 33, 33));
    Border bordernull = BorderFactory.createEmptyBorder();
    Border borderinput = BorderFactory.createLineBorder(new Color(30, 210, 96), 4);

    

    public TKLuongGUI() {

        this.setSize(1350, 945);
        this.setLayout(null);
        this.setBorder(border);
        this.setBackground(new Color(237,241,255));


        lbtop = new JLabel("Thống kê lương", SwingConstants.CENTER);
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
        
        Font font2 = new Font("Segoe UI", Font.BOLD, 16);    
        lbtuthang = new JLabel("Từ tháng:");
        lbtuthang.setFont(font2);
        lbtuthang.setBounds(220, 40, 100, 30);
        
        String thang[] = {"1","2","3","4","5","6","7","8","9","10","11","12"};
        String phongban[] = {"Kế toán","Giữ xe","Kinh doanh","Lễ tân","Thủ kho","Quản lý","Bảo vệ","Tạp vụ"};
 
        cbxtuthang = new JComboBox(thang);
        cbxtuthang.setBounds(320, 40, 130, 30);
        
        lbdenthang = new JLabel("Đến tháng:");
        lbdenthang.setFont(font2);
        lbdenthang.setBounds(520, 40, 100, 30);
        
        cbxdenthang = new JComboBox(thang);
        cbxdenthang.setBounds(620, 40, 130, 30);
        
        lbphongban = new JLabel("Phòng ban:");
        lbphongban.setFont(font2);
        lbphongban.setBounds(220,80,120,30);
        //lbphongban.setBorder(border);
        
        cbxPB = new JComboBox(phongban);
        cbxPB.setBounds(320, 80, 130, 30);
        
        Font font3 = new Font("Segoe UI", Font.BOLD, 26); 
        btnthongke = new JButton("Thống kê");
        btnthongke.setBounds(630,130,120,40);
        
        //BẢNG
        Vector header=new Vector();
        header.add("STT");
        header.add("Phòng ban");
        header.add("Tháng");
        header.add("Tổng lương");
         model = new DefaultTableModel(header, 0) {
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Integer.class;
                    case 1:
                        return String.class;
                    case 2:
                        return Date.class;
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
        bangtk.setBounds(10, 200, 900, 300);
        
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
        pncenter1.add(cbxPB);
        pncenter1.add(lbdenthang);
        pncenter1.add(lbphongban);
        pncenter1.add(btnthongke);
        pncenter1.add(bangtk);
        pncenter1.add(in);
        
       
        
//        txtimkiem = new JTextField(18);
//        txtimkiem.setFont(font);
//        txtimkiem.setBounds(70, 18, 250, 30);
//        txtimkiem.setBorder(border);
       
//        ImageIcon hinhtimkiem = new ImageIcon(getClass().getResource("/HinhAnh/timkiem.png"));       
//        timkiem = new JButton();
//        timkiem.setBounds(380, 15, 80, 40);       
//        timkiem.setBackground(new Color(31,73,91));
//        timkiem.setIcon(hinhtimkiem);
//        timkiem.setFont(font);
//        timkiem.setBorder(bordernull);
//        timkiem.setFocusPainted(false);
//        timkiem.setCursor(new Cursor(HAND_CURSOR));      
//        timkiem.addMouseListener(new MouseListener() {
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


}



