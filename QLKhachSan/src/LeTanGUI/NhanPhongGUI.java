/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeTanGUI;

import BUS.CTDatPhongBUS;
import BUS.PDatPhongBUS;
import DTO.CTDatPhongDTO;
import DTO.PDatPhongDTO;
import SupportGUI.PhieuDat2;
import SupportGUI.PhieuDatPhongGUI;
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

public class NhanPhongGUI extends JPanel {

    int choice = 0;

    public static DefaultTableModel modelHD, modelCTHD;
    JLabel lbmahd, lbmakh, lbmanv, lbngaymua, lbtongtien, lbtimkiem, lbsoluong, lbdongia, lbmasp, lbthanhtien, lbmacthd;
    JTextField txmahd, txmakh, txmanv, txngaymua, txtongtien, txtimkiem, txsoluong, txdongia, txmasp, txthanhtien, txmacthd;
    JButton them, reset, timkiem, chonmakh, chonmanv, chonmasp, chonmakm, next, preview, thunho, exit;
    public static JTable tableHD, tableCTHD;
    //JTable tableHD, tableCTHD;
    JLabel lbhd, lbcthd, lbtop, lbexit, lbinfopbh;
    JComboBox cb;
    JPanel hd, cthd;
    Font font = new Font("Segoe UI", Font.BOLD, 18);  
    Border border = BorderFactory.createLineBorder(new Color(33, 33, 33));
    //Border border = BorderFactory.createLineBorder(Color.RED);
    Border bordernull = BorderFactory.createEmptyBorder();
    int clickxoa = -1;//Nếu clickxoa == 0 xóa là xóa hóa đơn còn nếu bằng 1 là xóa CTHD bằng -1 là chưa chọn dòng để xóa 

    JButton back, tkncoff, tknc;
    JLabel lbtknc, muiten, muiten1, muiten2;
    JTextField txgiatu, txgiaden, txsltu, txslden, txngaytu, txngayden;
    Font fonttknc = new Font("Segoe UI", Font.PLAIN, 15);
    Border borderinput = BorderFactory.createLineBorder(new Color(30, 210, 96), 4);

    public NhanPhongGUI(String id) {

        this.setSize(1350, 945);
        this.setLayout(null);
        this.setBorder(border);
        this.setBackground(new Color(237,241,255));

        ImageIcon hinhnutxuong = new ImageIcon(getClass().getResource("/HinhAnh/nutxuong.png"));
        ImageIcon hinhnutxuongf = new ImageIcon(getClass().getResource("/HinhAnh/nutxuongf.png"));
        ImageIcon hinhnutlen = new ImageIcon(getClass().getResource("/HinhAnh/nutlen.png"));
        ImageIcon hinhnutlenf = new ImageIcon(getClass().getResource("/HinhAnh/nutlenf.png"));
        ImageIcon hinhback = new ImageIcon(getClass().getResource("/HinhAnh/back.png"));
        ImageIcon hinhbackf = new ImageIcon(getClass().getResource("/HinhAnh/backf.png"));

        lbtop = new JLabel();
        lbtop.setBounds(0, 0, 950, 65);
        lbtop.setBackground(new Color(134, 174, 195));
        lbtop.setOpaque(true);

        back = new JButton();
        back.setBounds(25, 25, 20, 20);
        back.setIcon(hinhback);
        back.setFocusPainted(false);
        back.setContentAreaFilled(false);
        back.setBorder(bordernull);
        back.setBackground(new Color(33, 33, 33));
       
       
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                back.setIcon(hinhbackf);                
                txtimkiem.setText("");
                while (modelHD.getRowCount() > 0) {
                    modelHD.removeRow(0);
                }
                tableHD.setModel(modelHD);
            }
        });
        lbtop.add(back);

        ImageIcon hinhmuiten1 = new ImageIcon(getClass().getResource("/HinhAnh/muiten1.png"));
        muiten1 = new JLabel();
        muiten1.setIcon(hinhmuiten1);
        muiten1.setFont(fonttknc);
        muiten1.setBounds(180, 90, 40, 30);
        muiten1.setBorder(bordernull);
        muiten1.setFocusTraversalKeysEnabled(false);
        muiten1.setForeground(new Color(255, 255, 255));


        ImageIcon hinhmuiten2 = new ImageIcon(getClass().getResource("/HinhAnh/muiten1.png"));
        muiten2 = new JLabel();
        muiten2.setIcon(hinhmuiten1);
        muiten2.setFont(fonttknc);
        muiten2.setBounds(180, 150, 40, 30);
        muiten2.setBorder(bordernull);
        muiten2.setFocusTraversalKeysEnabled(false);
        muiten2.setForeground(new Color(255, 255, 255));


        tknc = new JButton();
        tknc.setBounds(490, 18, 30, 30);
        tknc.setIcon(hinhnutxuong);
        tknc.setBorder(bordernull);
        tknc.setFocusTraversalKeysEnabled(false);
        tknc.setBackground(new Color(33, 33, 33));
        tknc.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lbtknc.setVisible(true);
                tknc.setVisible(false);
                tkncoff.setVisible(true);
                
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

        tkncoff = new JButton();
        tkncoff.setBounds(490, 18, 30, 30);
        tkncoff.setIcon(hinhnutlenf);
        tkncoff.setBorder(bordernull);
        tkncoff.setFocusTraversalKeysEnabled(false);
        tkncoff.setBackground(new Color(33, 33, 33));
        tkncoff.setVisible(false);
        tkncoff.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lbtknc.setVisible(false);
                tknc.setVisible(true);
                tkncoff.setVisible(false);
                
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

        txtimkiem = new JTextField(18);
        txtimkiem.setFont(font);
        txtimkiem.setBounds(70, 18, 250, 32);
        txtimkiem.setBorder(border);
 
        String choose[] = {"Theo Mã đặt", "Theo Mã KH", "Theo Mã NV", "Theo Ngày đặt", "Ngày đến", "Ngày đi", "ID luu trú", "Tên lưu trú"};
        cb = new JComboBox(choose);
        cb.setBounds(340, 18, 130, 32);
        cb.setFont(new Font("Segoe UI", Font.BOLD, 16));
        cb.setBorder(border);
        cb.setBackground(new Color(255, 255, 255));

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
        lbtop.add(cb);
        lbtop.add(txtimkiem);

        // Hóa đơn
        hd = new JPanel();
        hd.setLayout(null);
        hd.setBounds(30, 100, 910, 360);
        hd.setBackground(new Color(237,241,255));
        TitledBorder TTborder1 = new TitledBorder("Phiếu Đặt Phòng");
        TTborder1.setTitleJustification(TitledBorder.LEFT);
        TTborder1.setTitlePosition(TitledBorder.TOP);
        TTborder1.setTitleColor(new Color(33,33,33));
        TTborder1.setTitleFont(font);
        hd.setBorder(TTborder1);

        Vector header = new Vector();        
        header.add("Mã Đặt");
        header.add("Mã KH");
        header.add("Mã NV");
        header.add("Ngày Lập");
        header.add("Ngày đến");
        header.add("Ngày đi");
        header.add("ID lưu trú");
        header.add("Tên lưu trú");
        header.add("Tiền phòng");
        header.add("Tiền cọc");
        header.add("Trạng thái");


        modelHD = new DefaultTableModel(header, 0);
        tableHD = new JTable();
        tableHD.setModel(modelHD);
        tableHD.setFillsViewportHeight(true);
        
        tableHD.setBorder(border);
        tableHD.setFillsViewportHeight(true);
        
        tableHD.setBackground(new Color(255, 255, 255));
        tableHD.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        tableHD.getTableHeader().setForeground(new Color(255, 255, 255));
        tableHD.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        tableHD.getTableHeader().setBackground(new Color(31,73,91));
        tableHD.getTableHeader().setBorder(border);
        tableHD.setRowHeight(30);

        JScrollPane bangHD = new JScrollPane(tableHD);
        bangHD.setBounds(10, 30, 890, 320);
        hd.add(bangHD);
        
        //Đọc danh sách phiếu đặt phòng
        PDatPhongBUS pdphongbus = new PDatPhongBUS();
        pdphongbus.docDSPDPhong();
        if (PDatPhongBUS.dspdphong == null) {
            pdphongbus.docDSPDPhong();
        }
        for (PDatPhongDTO pdatphong : PDatPhongBUS.dspdphong) {
            if("Chờ nhận phòng".equals(pdatphong.getTrangthai()))
            {
            Vector row = new Vector();
            row.add(pdatphong.getMadat());
            row.add(pdatphong.getMakhdat());
            row.add(pdatphong.getManv());
            row.add(pdatphong.getNgaydatphong());
            row.add(pdatphong.getNgayden());
            row.add(pdatphong.getNgaydi());
            row.add(pdatphong.getCmndnguoiluutru());
            row.add(pdatphong.getTennguoiluutru());
            row.add(pdatphong.getTienphong());
            row.add(pdatphong.getTiencoc());
            row.add(pdatphong.getTrangthai());
                      
            modelHD.addRow(row);
            }
        }

        //Chi tiết HĐ    
        cthd = new JPanel();
        cthd.setLayout(null);
        cthd.setBounds(30, 470, 620, 200);
        cthd.setBackground(new Color(237,241,255));
       
        TitledBorder TTborder2 = new TitledBorder("Chi Tiết Đặt Phòng");
        TTborder2.setTitleJustification(TitledBorder.LEFT);
        TTborder2.setTitlePosition(TitledBorder.TOP);
        TTborder2.setTitleColor(new Color(33,33,33));
        TTborder2.setTitleFont(font);
        cthd.setBorder(TTborder2);
        
        header = new Vector();        
        header.add("Mã Đặt");
        header.add("Mã phòng");
        header.add("Đơn giá");
 
        modelCTHD = new DefaultTableModel(header, 0);
        tableCTHD = new JTable();
        tableCTHD.setModel(modelCTHD);
        tableCTHD.setFillsViewportHeight(true);
        tableCTHD.setBorder(border);
        tableCTHD.setFillsViewportHeight(true);
        tableCTHD.setBackground(new Color(255, 255, 255));
        tableCTHD.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        tableCTHD.getTableHeader().setForeground(new Color(255, 255, 255));
        tableCTHD.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 20));
        tableCTHD.getTableHeader().setBackground(new Color(31,73,91));
        tableCTHD.getTableHeader().setBorder(border);
        tableCTHD.setRowHeight(30);

        JScrollPane bangCTHD = new JScrollPane(tableCTHD);
        //bangCTHD.setBounds(10, 30, 600, 290);
        bangCTHD.setBounds(10, 30, 600, 150);
        cthd.add(bangCTHD);

        //SỰ KIỆN CỦA 2 BẢNG
        tableHD.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {


                modelCTHD.setRowCount(0);   // Dùng để clear Table CTHD
                tableCTHD.setModel(modelCTHD);
                int i = tableHD.getSelectedRow();
                if (i >= 0) 
                {
                    String ma = tableHD.getValueAt(i, 0).toString();    //Lấy mã hd
                    clickxoa = 0; // Xóa HĐ                   
                    CTDatPhongBUS ctdatphong = new CTDatPhongBUS();
                    ctdatphong.docCTDPtheoMa(ma);
                    for (CTDatPhongDTO ctdp : CTDatPhongBUS.dsctdatphong) // Với mỗi CTDP nằm trong dsctdp của BUS
                    {
                        Vector row = new Vector();
                        row.add(ctdp.getMadat());
                        row.add(ctdp.getMaphong());
                        row.add(ctdp.getDongia());
                        modelCTHD.addRow(row);
                    }
                    tableCTHD.setModel(modelCTHD);
                }

            }

            //Lệnh xàm
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                //int i = tableHD.getSelectedRow();
                JTable table = (JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    JOptionPane.showMessageDialog(null, "Đừng có double click vô Table chứ :))");
                }
            }
        });
        
        tableCTHD.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tableHD.clearSelection();
                clickxoa = 1;
            }

            //Lệnh xàm
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                //int i = tableHD.getSelectedRow();
                JTable table = (JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    JOptionPane.showMessageDialog(null, "Đừng có double click vô Table chứ :))");
                }
            }

        });

        // button
        ImageIcon hinhthem = new ImageIcon(getClass().getResource("/HinhAnh/them.png"));
        ImageIcon hinhthem1 = new ImageIcon(getClass().getResource("/HinhAnh/them1.png"));
        them = new JButton();
        them.setEnabled(false);
        them.setBounds(680, 480, 130, 50);
        them.setBackground(new Color(237,241,255));
        them.setBorder(bordernull);
        them.setIcon(hinhthem);
        them.setFocusPainted(false);
        them.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PDatPhongBUS pdbus = new PDatPhongBUS();               
                int i = tableHD.getSelectedRow();
                if (i >= 0) 
                {
                    String ma = tableHD.getValueAt(i, 0).toString();    //Lấy mã hd

                    
                                                      
                    SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
                    Date today = new Date();                         
                    String dayfrom = tableHD.getValueAt(i,4).toString();                   
                    Date ngayden = null;
                    try {
                        ngayden = fm.parse(dayfrom);
                    } catch (ParseException ex) {
                        Logger.getLogger(NhanPhongGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    String dayto = tableHD.getValueAt(i,5).toString();
                    Date ngaydi = null;
                    try {
                        ngaydi = fm.parse(dayto);
                    } catch (ParseException ex) {
                        Logger.getLogger(NhanPhongGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    if(today.compareTo(ngayden)<0)                    
                        JOptionPane.showMessageDialog(null, "Chưa tới ngày nhận phòng");
                    else
                        if(today.compareTo(ngaydi)>0)
                        JOptionPane.showMessageDialog(null, "Đã quá hạn nhận phòng");
                            else
                        {
                                JOptionPane.showMessageDialog(null, "Được nhận phòng");
                                modelHD.removeRow(i);
                                tableHD.setModel(modelHD);                               
                                pdbus.capnhatTrangThai(ma, "Đã nhận phòng");
                        }                   
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Chọn phiếu đặt phòng để thực hiện nhận phòng");
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

                
//          hóa dơn
        this.add(hd);
//          chi tiết hđ
        this.add(cthd);      
        this.add(them);
        this.add(lbtop);

        cb.addActionListener((ActionEvent e) -> {
            choice = cb.getSelectedIndex();
            System.out.println(choice);
        });

        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tableHD.getModel());
        tableHD.setRowSorter(rowSorter);

        txtimkiem.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                 String text = txtimkiem.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text + ".*", choice));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                 String text = txtimkiem.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)^" + text + ".*", choice));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
               // this.setVisible(true);

    }

    public int Chuyenint(String fm) throws ParseException {
        Locale vietnam = new Locale("vi", "VN");
        NumberFormat fmmoney = NumberFormat.getCurrencyInstance(vietnam);
        Number d = fmmoney.parse(fm);
        BigDecimal bd = new BigDecimal(d.toString());
        int a = bd.intValue();
        return a;
    }

    public String Chuyentien(String fm) {
        Locale vietnam = new Locale("vi", "VN");
        NumberFormat fmmoney = NumberFormat.getCurrencyInstance(vietnam);
        String c = fmmoney.format(new BigDecimal(fm.toString()));
        return c;
    }

    public String ChuyenString(Date date) {
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
        String fmd = fm.format(date);
        return fmd;
    }

    public Date ChuyenDate(String fmd) throws ParseException {
        Date date = new Date();
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
        Date d = fm.parse(fmd);
        return d;
    }

    
    // TEST THỬ
//    public static void main(String args[])
//    {
//        NhanPhongGUI np = new NhanPhongGUI("LT1");
//        JFrame f = new JFrame();
//        f.setSize(1355, 950);
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f.add(np);
//        f.setVisible(true);
//    }
}



