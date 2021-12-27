
package NVKinhDoanhGUI;


import BUS.KhuyenMaiBUS;
import DTO.KhuyenMaiDTO;
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import java.io.IOException;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.*;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.JFormattedTextField.AbstractFormatter;
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
import org.jdatepicker.DateModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import java.util.List;
import java.util.ArrayList;
import java.text.SimpleDateFormat;


public class KhuyenMaiGUI extends JPanel {
    

    public static DefaultTableModel dtm;
    List<KhuyenMaiDTO> DSKhuyenMai = new ArrayList<>();
    public static JTable tblDSKM;
    JLabel lblQLKM, lblMaKM, lblTenKM, lblGiamgia, lblNgayBD, lblNgayKT;
    JTextField txtMaKM, txtTenKM, txtGiamgia;
    JDatePickerImpl dpkNgayBD, dpkNgayKT ;
    JButton btnThem, btnXoa, btnSua, btnXem, btnExit, btnReset;
    JPanel paneltong;
    
    Font font = new Font("Segoe UI", Font.BOLD, 18);
    Font fontQLKM = new Font("Segoe UI", Font.BOLD, 30);
    Font fontbtn = new Font("Segoe UI", Font.BOLD, 18);
    Border border = BorderFactory.createLineBorder(new Color(33, 33, 33));
    Border bordernull = BorderFactory.createEmptyBorder();
    Border borderinput = BorderFactory.createLineBorder(new Color(30, 210, 96), 4);
    Color color_font_hover=new Color(179, 179, 179);
    Color color_no_font_hover=new Color(30, 30, 30);
    

    public KhuyenMaiGUI() {

        this.setSize(1350, 945);
        this.setLayout(null);
        this.setBorder(border);
        this.setBackground(new Color(237,241,255));
        
        paneltong = new JPanel();
        paneltong.setLayout(null);
        paneltong.setBounds(0, 0, 950, 700);
        paneltong.setBackground(new Color(237,241,255));
      

        ImageIcon hinhexit = new ImageIcon(getClass().getResource("/HinhAnh/thoat.png"));
        btnExit = new JButton();
        btnExit.setBounds(890, 0, 60, 35);
        btnExit.setBackground(new Color(30, 30, 30));
        btnExit.setIcon(hinhexit);
        btnExit.setBorder(bordernull);
        btnExit.setFocusPainted(false);
        btnExit.setHorizontalTextPosition(SwingConstants.LEFT);
        btnExit.addMouseListener(new MouseListener() {
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
                btnExit.setBackground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnExit.setBackground(new Color(30, 30, 30));
            }

        });         
        
        lblQLKM = new JLabel("QUẢN LÝ CHƯƠNG TRÌNH KHUYẾN MÃI");
        lblQLKM.setFont(fontQLKM);
        lblQLKM.setBounds(200, 30, 600, 50);
        lblQLKM.setBackground(new Color(30, 30, 30));
        
        lblMaKM = new JLabel("Mã khuyến mãi");
        lblMaKM.setFont(font);
        lblMaKM.setBounds(10, 140, 250, 30);
        lblMaKM.setBackground(new Color(30, 30, 30));
        
        lblTenKM = new JLabel("Tên khuyến mãi");
        lblTenKM.setFont(font);
        lblTenKM.setBounds(10, 190, 250, 30);
        lblTenKM.setBackground(new Color(30, 30, 30));
        
        lblGiamgia = new JLabel("Giảm giá");
        lblGiamgia.setFont(font);
        lblGiamgia.setBounds(10, 240, 150, 30);
        lblGiamgia.setBackground(new Color(30, 30, 30));
        
        lblNgayBD = new JLabel("Ngày bắt đầu");
        lblNgayBD.setFont(font);
        lblNgayBD.setBounds(550, 140, 150, 30);
        lblNgayBD.setBackground(new Color(30, 30, 30));
        
        lblNgayKT = new JLabel("Ngày kết thúc");
        lblNgayKT.setFont(font);
        lblNgayKT.setBounds(550, 190, 150, 30);
        lblNgayKT.setBackground(new Color(30, 30, 30));
        
        
        txtMaKM = new JTextField();
        txtMaKM.setBounds(220, 140, 250, 30);
        
        txtTenKM = new JTextField();
        txtTenKM.setBounds(220, 190, 250, 30);
        
        txtGiamgia = new JTextField();
        txtGiamgia.setBounds(220, 240, 150, 30);
        
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        dpkNgayBD = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        dpkNgayBD.setFont(font);
        dpkNgayBD.setBounds(700, 140, 150, 30);
        
        UtilDateModel model2 = new UtilDateModel();
        Properties p2 = new Properties();
        p2.put("text.today", "Today");
        p2.put("text.month", "Month");
        p2.put("text.year", "Year");
        JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, p2);
        dpkNgayKT = new JDatePickerImpl(datePanel2, new DateLabelFormatter());
        dpkNgayKT.setFont(font);
        dpkNgayKT.setBounds(700, 190, 150, 30);
        
       
        

        Vector header = new Vector();
        header.add("Mã KM");
        header.add("Tên");
        header.add("Giảm giá");
        header.add("Ngày bắt đầu");
        header.add("Ngày kết thúc");


        dtm = new DefaultTableModel(header, 0);
        tblDSKM = new JTable();
        tblDSKM.setModel(dtm);
        tblDSKM.setFillsViewportHeight(true);
        
        tblDSKM.setBorder(border);
        tblDSKM.setFillsViewportHeight(true);
        
        tblDSKM.setBackground(new Color(255, 255, 255));
        tblDSKM.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        tblDSKM.getColumnModel().getColumn(0).setPreferredWidth(20);
        tblDSKM.getColumnModel().getColumn(1).setPreferredWidth(30);
        tblDSKM.getColumnModel().getColumn(2).setPreferredWidth(30);
        tblDSKM.getColumnModel().getColumn(3).setPreferredWidth(30);
        tblDSKM.getColumnModel().getColumn(4).setPreferredWidth(50);

        tblDSKM.getTableHeader().setForeground(new Color(255, 255, 255));
        tblDSKM.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 20));
        tblDSKM.getTableHeader().setBackground(new Color(31,73,91));
        tblDSKM.getTableHeader().setBorder(border);
        tblDSKM.setRowHeight(30);

        JScrollPane DSKH = new JScrollPane(tblDSKM);
        DSKH.setBounds(10, 300, 700, 320);
        
        TitledBorder TTborder1 = new TitledBorder("DANH SÁCH KHUYẾN MÃI");
        TTborder1.setTitleJustification(TitledBorder.CENTER);
        TTborder1.setTitlePosition(TitledBorder.TOP);
        TTborder1.setTitleColor(new Color(33,33,33));
        TTborder1.setTitleFont(font);
        DSKH.setBorder(TTborder1);
        
        tblDSKM.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedIndex = tblDSKM.getSelectedRow();
                KhuyenMaiDTO km = DSKhuyenMai.get(selectedIndex); 
                txtMaKM.setText(km.getMaKM());
                txtTenKM.setText(km.getTenKM());                
                txtGiamgia.setText(Integer.toString(km.getGiamgia()));
                dpkNgayBD.getJFormattedTextField().setText(km.getNgayBD());
                dpkNgayKT.getJFormattedTextField().setText(km.getNgayKT());
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
        
             
        ImageIcon hinhxem = new ImageIcon(getClass().getResource("/HinhAnh/xemkh.png"));
        ImageIcon hinhxem_hover = new ImageIcon(getClass().getResource("/HinhAnh/xemkh_hover.png"));
        btnXem = new JButton();
        btnXem.setBounds(250, 630, 175, 42);
        btnXem.setBackground(new Color(237,241,255));
        btnXem.setBorder(bordernull);
        btnXem.setIcon(hinhxem);
        btnXem.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showKM();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnXem.setIcon(hinhxem_hover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnXem.setIcon(hinhxem);
            }

        });
               
        ImageIcon hinhreset = new ImageIcon(getClass().getResource("/HinhAnh/resetkh.png"));
        ImageIcon hinhreset_hover = new ImageIcon(getClass().getResource("/HinhAnh/resetkh_hover.png"));
        btnReset = new JButton();
        btnReset.setBounds(777, 240, 110, 40);
        btnReset.setBackground(new Color(237,241,255));
        btnReset.setBorder(bordernull);
        btnReset.setIcon(hinhreset);
        btnReset.addMouseListener(new MouseListener() {
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
                btnReset.setIcon(hinhreset_hover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnReset.setIcon(hinhreset);
            }

        });
        
        
        ImageIcon hinhthem = new ImageIcon(getClass().getResource("/HinhAnh/themkh.png"));
        ImageIcon hinhthem_hover = new ImageIcon(getClass().getResource("/HinhAnh/themkh_hover.png"));
        btnThem = new JButton();      
        btnThem.setBounds(777, 385, 110, 40);
        btnThem.setBackground(new Color(237,241,255));
        btnThem.setBorder(bordernull);
        btnThem.setIcon(hinhthem);
        btnThem.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {            
                String makm = txtMaKM.getText();
                String tenkm = txtTenKM.getText();
                int giamgia = Integer.parseInt(txtGiamgia.getText());
                String ngaybd = dpkNgayBD.getJFormattedTextField().getText();
                String ngaykt = dpkNgayKT.getJFormattedTextField().getText();

                KhuyenMaiDTO km = new KhuyenMaiDTO(makm, tenkm, giamgia, ngaybd, ngaykt);
                KhuyenMaiBUS.themKM(km);
                JOptionPane.showMessageDialog(null, "Thêm thành công");
                showKM();               
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnThem.setIcon(hinhthem_hover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnThem.setIcon(hinhthem);
            }

        });
        
        
        ImageIcon hinhxoa = new ImageIcon(getClass().getResource("/HinhAnh/xoakh.png"));
        ImageIcon hinhxoa_hover = new ImageIcon(getClass().getResource("/HinhAnh/xoakh_hover.png"));
        btnXoa = new JButton();       
        btnXoa.setBounds(777, 450, 110, 40);
        btnXoa.setBackground(new Color(237,241,255));
        btnXoa.setBorder(bordernull);
        btnXoa.setIcon(hinhxoa);
        btnXoa.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedIndex = tblDSKM.getSelectedRow();
                if(selectedIndex >= 0) {
                    KhuyenMaiDTO km = DSKhuyenMai.get(selectedIndex);

                    int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa?");
                    if(option == 0) {
                        KhuyenMaiBUS.xoaKM(km.getMaKM());
                        JOptionPane.showMessageDialog(null, "Xóa thành công");
                        showKM();                              
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
                btnXoa.setIcon(hinhxoa_hover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnXoa.setIcon(hinhxoa);
            }

        });
        
        
        ImageIcon hinhsua = new ImageIcon(getClass().getResource("/HinhAnh/suakh.png"));
        ImageIcon hinhsua_hover = new ImageIcon(getClass().getResource("/HinhAnh/suakh_hover.png"));
        btnSua = new JButton();       
        btnSua.setBounds(777, 515, 110, 40);
        btnSua.setBackground(new Color(237,241,255));
        btnSua.setBorder(bordernull);
        btnSua.setIcon(hinhsua);
        btnSua.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String makm = txtMaKM.getText();
                String tenkm = txtTenKM.getText();
                int giamgia = Integer.parseInt(txtGiamgia.getText());
                String ngaybd = dpkNgayBD.getJFormattedTextField().getText();
                String ngaykt = dpkNgayKT.getJFormattedTextField().getText();
                
                KhuyenMaiDTO km = new KhuyenMaiDTO(makm, tenkm, giamgia, ngaybd, ngaykt);
                KhuyenMaiBUS.suaKM(km);
                JOptionPane.showMessageDialog(null, "Sửa thành công");
                showKM();  
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnSua.setIcon(hinhsua_hover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnSua.setIcon(hinhsua);
            }

        });
       

        
        
        paneltong.add(lblQLKM);
        paneltong.add(lblMaKM);
        paneltong.add(lblTenKM);
        paneltong.add(lblGiamgia);
        paneltong.add(lblNgayBD);
        paneltong.add(lblNgayKT);
        
        paneltong.add(txtMaKM);
        paneltong.add(txtTenKM);
        paneltong.add(txtGiamgia);
        paneltong.add(dpkNgayBD);
        paneltong.add(dpkNgayKT);
        
        paneltong.add(DSKH);
               
        paneltong.add(btnExit);
        paneltong.add(btnReset);
        paneltong.add(btnXem);
        paneltong.add(btnThem);
        paneltong.add(btnXoa);
        paneltong.add(btnSua);
                    
        this.add(paneltong);
    }
    
    
    
    public class DateLabelFormatter extends AbstractFormatter {

        private String datePattern = "yyyy-MM-dd";
        private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

        @Override
        public Object stringToValue(String text) throws ParseException {
            return dateFormatter.parseObject(text);
        }

        @Override
        public String valueToString(Object value) throws ParseException {
            if (value != null) {
                Calendar cal = (Calendar) value;
                return dateFormatter.format(cal.getTime());
            }

            return "";
        }

    }
    private void showKM() {
        DSKhuyenMai =  KhuyenMaiBUS.DSKM();
        
        dtm.setRowCount(0);
        
        DSKhuyenMai.forEach((KhuyenMaiDTO) -> {
            dtm.addRow(new Object[] {KhuyenMaiDTO.getMaKM(), KhuyenMaiDTO.getTenKM(), 
                KhuyenMaiDTO.getGiamgia(), KhuyenMaiDTO.getNgayBD(),KhuyenMaiDTO.getNgayKT(),
                });
        });
    }

}



