
package NVKinhDoanhGUI;


import BUS.ThongKePhieuDVBUS;
import DTO.ThongKePhieuDVDTO;
import Report.ExcelReport;
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
import java.time.LocalDate;
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

public class TKDichVuGUI extends JPanel {
 //setbounds(x,y,width,length)
    int choice = 0;

    public static DefaultTableModel modelHD, modelCTHD;
    JLabel lbtimkiem, lbtop, lbexit,lbtitle;
    JTextField txtimkiem;
    JButton timkiem, thunho, exit;


    Font font1 = new Font("Segoe UI", Font.BOLD, 25);
    Font font = new Font("Segoe UI", Font.BOLD, 18);
    Border border = BorderFactory.createLineBorder(new Color(33, 33, 33));
    Border bordernull = BorderFactory.createEmptyBorder();
    Border borderinput = BorderFactory.createLineBorder(new Color(30, 210, 96), 4);
    JLabel lbngaybd, lbngaykt ;
    JTextField txngaybd ,txngaykt  ;
    JTable table;
    DefaultTableModel model;
    DatePicker pickDayBegin,pickDayEnd;
    JButton in;
    

    public TKDichVuGUI() {

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
        
  
        lbexit.add(exit);      
        lbtop.add(lbexit);
        //lbtop.add(txtimkiem);
        //lbtop.add(timkiem);
        
        
        //code tiếp giao diện ở đây
        lbtitle = new JLabel("Thống kê theo loại dịch vụ");
        lbtitle.setBounds(30, 80, 800, 60);
        lbtitle.setFont(new Font("Segoe UI", Font.BOLD, 30));
        lbtitle.setForeground(new Color(31,73,91));
        

         lbngaybd = new JLabel("Từ ngày: ", JLabel.LEFT);
         lbngaybd.setBounds(30, 160, 140, 50);
        lbngaybd.setFont(font1);
        lbngaybd.setForeground(new Color(31,73,91));
        
        txngaybd = new JTextField();
        txngaybd.setFont(font);
        //txngaybd.setBounds(550, 40, 100, 30);
        txngaybd.setBounds(190, 170, 150, 30);      
        txngaybd.setBorder(border);
        
        lbngaykt = new JLabel("Đến ngày: ", JLabel.LEFT);
        //lbngaykt.setBounds(730, 35, 140, 50);
        lbngaykt.setBounds(30,230,140, 50);
        lbngaykt.setFont(font1);
        lbngaykt.setForeground(new Color(31,73,91));
        
        txngaykt = new JTextField();
        txngaykt.setFont(font);
        //txngaykt.setBounds(870, 40, 100, 30);
        txngaykt.setBounds(190,240, 150, 30);
        txngaykt.setBorder(border);
          LocalDate a=java.time.LocalDate.now();
        txngaykt.setText(a.toString());
        
        DatePickerSettings pickerSettings = new DatePickerSettings();
        pickerSettings.setColor(DatePickerSettings.DateArea.TextClearLabel, new Color(30, 210, 96));
        pickerSettings.setColor(DatePickerSettings.DateArea.CalendarBackgroundNormalDates, new Color(255, 255, 255));
        pickerSettings.setColor(DatePickerSettings.DateArea.TextTodayLabel, new Color(249, 6, 59));
        pickerSettings.setColor(DatePickerSettings.DateArea.BackgroundMonthAndYearNavigationButtons, new Color(31,73,91));
        pickerSettings.setColor(DatePickerSettings.DateArea.TextMonthAndYearNavigationButtons,new Color(255,255,255));
       
        
        pickerSettings.setSizeDatePanelMinimumHeight(300);
        pickerSettings.setSizeDatePanelMinimumWidth(300);
        pickerSettings.setVisibleDateTextField(false);
        pickDayBegin = new DatePicker(pickerSettings);
        pickDayBegin.setBounds(360,170, 30, 30);
        pickDayBegin.setCursor(new Cursor(HAND_CURSOR));
        pickDayBegin.addDateChangeListener((dce) -> {
            txngaybd.setText(pickDayBegin.getDateStringOrEmptyString());
        });
        
        DatePickerSettings pickerSettings0 = new DatePickerSettings();
       pickerSettings0.setColor(DatePickerSettings.DateArea.TextClearLabel, new Color(30, 210, 96));
       pickerSettings0.setColor(DatePickerSettings.DateArea.CalendarBackgroundNormalDates, new Color(255, 255, 255));
       pickerSettings0.setColor(DatePickerSettings.DateArea.BackgroundMonthAndYearNavigationButtons, new Color(31,73,91));
       pickerSettings0.setColor(DatePickerSettings.DateArea.TextMonthAndYearNavigationButtons,new Color(255,255,255));
       pickerSettings0.setColor(DatePickerSettings.DateArea.TextTodayLabel, new Color(249, 6, 59));
        
        pickerSettings0.setSizeDatePanelMinimumHeight(300);
        pickerSettings0.setSizeDatePanelMinimumWidth(300);
        pickerSettings0.setVisibleDateTextField(false);
        pickDayEnd = new DatePicker(pickerSettings0);
        pickDayEnd.setBounds(360,240, 30, 30);
        pickDayEnd.setCursor(new Cursor(HAND_CURSOR));
        pickDayEnd.addDateChangeListener((dce) -> {
            txngaykt.setText(pickDayEnd.getDateStringOrEmptyString());
        });
        
        Vector header=new Vector();
        header.add("Loại dịch vụ");
        header.add("Tên dịch vụ");
        header.add("Tổng số lượt đặt");
         model = new DefaultTableModel(header, 0) {
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
//                    case 0:
//                        return String.class;
                    case 2:
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
        table.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        table.getTableHeader().setForeground(new Color(255, 255, 255));
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 20));
        table.getTableHeader().setBackground(new Color(31,73,91));
        table.getTableHeader().setBorder(border);
        table.setRowHeight(40);
        JScrollPane bangtk = new JScrollPane(table);
        bangtk.setBounds(10, 330, 900, 300);
        

        ImageIcon hinhxuat1 = new ImageIcon(getClass().getResource("/HinhAnh/in4.png"));
        ImageIcon hinhxuat_h = new ImageIcon(getClass().getResource("/HinhAnh/in42.png"));
        in = new JButton();
        in.setIcon(hinhxuat1);
        in.setBounds(770, 630, 170, 70);
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
        
        
        ImageIcon hinhtimkiem = new ImageIcon(getClass().getResource("/HinhAnh/timkiem.png"));       
        timkiem = new JButton();
        timkiem.setBounds(440,240, 80, 40);       
        timkiem.setBackground(new Color(31,73,91));
        timkiem.setIcon(hinhtimkiem);
        timkiem.setFont(font);
        timkiem.setBorder(bordernull);
        timkiem.setFocusPainted(false);
        timkiem.setCursor(new Cursor(HAND_CURSOR));      
        timkiem.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                 txngaykt.removeAll();
            txngaybd.removeAll();
            model.setRowCount(0);
            table.setModel(model);
             ThongKePhieuDVBUS bustk = new ThongKePhieuDVBUS();
              bustk.docDSDVngay(String.valueOf(txngaybd.getText()), String.valueOf(txngaykt.getText()));
              
              for (ThongKePhieuDVDTO tkdvtn : ThongKePhieuDVBUS.dstkdvtheongay) {
            Vector row = new Vector();
            row.add(tkdvtn.getLoaidichvu());
            row.add(tkdvtn.getTendichvu());
            row.add(tkdvtn.getSoluotdat());
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
        
        
        
    //----------**** add các thành phần giao diện ở dưới này ***--------
        this.add(lbtop);  
        this.add(lbtitle);
        this.add(txngaybd);
        this.add(lbngaybd);
        this.add(lbngaykt);
        this.add(txngaykt);
        this.add(pickDayBegin);
        this.add(pickDayEnd);
        this.add(timkiem);
        this.add(in);
        this.add(bangtk);
        
        this.repaint();
        this.revalidate();
        setEvent();
    }

    public void setEvent(){
        ThongKePhieuDVBUS bustkdv = new ThongKePhieuDVBUS();
        if (ThongKePhieuDVBUS.dstkdv == null) {
            bustkdv.docDSTKPDV();
        }
        
        for (ThongKePhieuDVDTO tkpdv : ThongKePhieuDVBUS.dstkdv) {
            Vector row = new Vector();
            row.add(tkpdv.getLoaidichvu());
            row.add(tkpdv.getTendichvu());
            row.add(tkpdv.getSoluotdat());
            model.addRow(row); 
            table.setModel(model);
        }
    }
 public static void main(String[] args) {
        TKDichVuGUI a=new TKDichVuGUI();
            JFrame f=new JFrame();
            f.setSize(1500,800);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.add(a);
            f.setVisible(true);
    }
}


