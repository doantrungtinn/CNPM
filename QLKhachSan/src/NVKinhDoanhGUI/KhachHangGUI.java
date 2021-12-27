
package NVKinhDoanhGUI;


import BUS.KhachHangBUS;
import DTO.KhachHangDTO;
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
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import java.util.List;
import java.util.ArrayList;

public class KhachHangGUI extends JPanel {
    

    public static DefaultTableModel dtm;
    List<KhachHangDTO> DSKhachHang = new ArrayList<>();
    public static JTable tblDSKH;
    JLabel lblQLKH, lblMaKH, lblHoten, lblNgaysinh, lblSDT,lblEmail, lblDiachi;
    JTextField txtMaKH, txtHoten, txtSDT, txtEmail,txtDiachi;
    JDatePickerImpl dpkNgaysinh ;
    JButton btnThem, btnXoa, btnSua, btnXem, btnTimkiem, btnExit, btnReset;
    JPanel paneltong;
    
    Font font = new Font("Segoe UI", Font.BOLD, 18);
    Font fontQLKH = new Font("Segoe UI", Font.BOLD, 30);
    Font fontbtn = new Font("Segoe UI", Font.BOLD, 18);
    Border border = BorderFactory.createLineBorder(new Color(33, 33, 33));
    Border bordernull = BorderFactory.createEmptyBorder();
    Border borderinput = BorderFactory.createLineBorder(new Color(30, 210, 96), 4);
    Color color_font_hover=new Color(179, 179, 179);
    Color color_no_font_hover=new Color(30, 30, 30);
    

    public KhachHangGUI() {

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
        
        lblQLKH = new JLabel("QUẢN LÝ KHÁCH HÀNG");
        lblQLKH.setFont(fontQLKH);
        lblQLKH.setBounds(270, 30, 450, 50);
        lblQLKH.setBackground(new Color(30, 30, 30));
        
        lblMaKH = new JLabel("Mã khách hàng(CMND)");
        lblMaKH.setFont(font);
        lblMaKH.setBounds(10, 140, 250, 30);
        lblMaKH.setBackground(new Color(30, 30, 30));
        
        lblHoten = new JLabel("Họ và tên khách hàng");
        lblHoten.setFont(font);
        lblHoten.setBounds(10, 190, 250, 30);
        lblHoten.setBackground(new Color(30, 30, 30));
        
        lblNgaysinh = new JLabel("Ngày sinh");
        lblNgaysinh.setFont(font);
        lblNgaysinh.setBounds(10, 240, 150, 30);
        lblNgaysinh.setBackground(new Color(30, 30, 30));
        
        lblSDT = new JLabel("SĐT");
        lblSDT.setFont(font);
        lblSDT.setBounds(550, 140, 100, 30);
        lblSDT.setBackground(new Color(30, 30, 30));
        
        lblEmail = new JLabel("Email");
        lblEmail.setFont(font);
        lblEmail.setBounds(550, 190, 100, 30);
        lblEmail.setBackground(new Color(30, 30, 30));
        
        lblDiachi = new JLabel("Địa chỉ");
        lblDiachi.setFont(font);
        lblDiachi.setBounds(550, 240, 100, 30);
        lblDiachi.setBackground(new Color(30, 30, 30));
        
        
        txtMaKH = new JTextField();
        txtMaKH.setBounds(220, 140, 250, 30);
        
        txtHoten = new JTextField();
        txtHoten.setBounds(220, 190, 250, 30);
        
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        dpkNgaysinh = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        dpkNgaysinh.setFont(font);
        dpkNgaysinh.setBounds(220, 240, 150, 30);
        
        txtSDT = new JTextField();
        txtSDT.setBounds(630, 140, 280, 30);
        
        txtEmail = new JTextField();
        txtEmail.setBounds(630, 190, 280, 30);
        
        txtDiachi = new JTextField();
        txtDiachi.setBounds(630, 240, 280, 30);
        

        Vector header = new Vector();
        header.add("Mã KH");
        header.add("Họ tên");
        header.add("Ngày sinh");
        header.add("SĐT");
        header.add("Email");
        header.add("Địa chỉ");


        dtm = new DefaultTableModel(header, 0);
        tblDSKH = new JTable();
        tblDSKH.setModel(dtm);
        tblDSKH.setFillsViewportHeight(true);
        
        tblDSKH.setBorder(border);
        tblDSKH.setFillsViewportHeight(true);
        
        tblDSKH.setBackground(new Color(255, 255, 255));
        tblDSKH.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        tblDSKH.getColumnModel().getColumn(0).setPreferredWidth(20);
        tblDSKH.getColumnModel().getColumn(1).setPreferredWidth(30);
        tblDSKH.getColumnModel().getColumn(2).setPreferredWidth(30);
        tblDSKH.getColumnModel().getColumn(3).setPreferredWidth(30);
        tblDSKH.getColumnModel().getColumn(4).setPreferredWidth(50);
        tblDSKH.getColumnModel().getColumn(5).setPreferredWidth(50);

        tblDSKH.getTableHeader().setForeground(new Color(255, 255, 255));
        tblDSKH.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 20));
        tblDSKH.getTableHeader().setBackground(new Color(31,73,91));
        tblDSKH.getTableHeader().setBorder(border);
        tblDSKH.setRowHeight(30);

        JScrollPane DSKH = new JScrollPane(tblDSKH);
        DSKH.setBounds(10, 300, 700, 320);
        
        TitledBorder TTborder1 = new TitledBorder("DANH SÁCH KHÁCH HÀNG");
        TTborder1.setTitleJustification(TitledBorder.CENTER);
        TTborder1.setTitlePosition(TitledBorder.TOP);
        TTborder1.setTitleColor(new Color(33,33,33));
        TTborder1.setTitleFont(font);
        DSKH.setBorder(TTborder1);
        
        tblDSKH.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedIndex = tblDSKH.getSelectedRow();
                KhachHangDTO kh = DSKhachHang.get(selectedIndex); 
                txtMaKH.setText(kh.getMaKH());
                txtHoten.setText(kh.getTenKH());                               
                dpkNgaysinh.getJFormattedTextField().setText(kh.getNgaysinh());
                txtSDT.setText(kh.getSDT()); 
                txtEmail.setText(kh.getEmail()); 
                txtDiachi.setText(kh.getDiachi()); 
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
        
        
        ImageIcon hinhtimkiem = new ImageIcon(getClass().getResource("/HinhAnh/timkiemkh.png"));
        ImageIcon hinhtimkiem_hover = new ImageIcon(getClass().getResource("/HinhAnh/timkiemkh_hover.png"));
        btnTimkiem = new JButton();
        btnTimkiem.setBounds(777, 75, 110, 40);
        btnTimkiem.setBackground(new Color(237,241,255));
        btnTimkiem.setBorder(bordernull);
        btnTimkiem.setIcon(hinhtimkiem);
        btnTimkiem.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {           
                String makh = JOptionPane.showInputDialog(this, "Nhập mã khách hàng cần tìm");

                if(makh != null && makh.length() > 0) {
                    DSKhachHang = (ArrayList<KhachHangDTO>) KhachHangBUS.timkiemKH(makh);

                    dtm.setRowCount(0);

                    DSKhachHang.forEach((KhachHangDTO) -> {
                        dtm.addRow(new Object[] {KhachHangDTO.getMaKH(), KhachHangDTO.getTenKH(), KhachHangDTO.getNgaysinh(), KhachHangDTO.getSDT(),KhachHangDTO.getEmail(),KhachHangDTO.getDiachi()});
                    });
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
                btnTimkiem.setIcon(hinhtimkiem_hover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnTimkiem.setIcon(hinhtimkiem);
            }

        });
        
        
        
        ImageIcon hinhxem = new ImageIcon(getClass().getResource("/HinhAnh/xemkh.png"));
        ImageIcon hinhxem_hover = new ImageIcon(getClass().getResource("/HinhAnh/xemkh_hover.png"));
        btnXem = new JButton();
        btnXem.setBounds(280, 630, 175, 42);
        btnXem.setBackground(new Color(237,241,255));
        btnXem.setBorder(bordernull);
        btnXem.setIcon(hinhxem);
        btnXem.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showKH();
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
        btnReset.setBounds(777, 290, 110, 40);
        btnReset.setBackground(new Color(237,241,255));
        btnReset.setBorder(bordernull);
        btnReset.setIcon(hinhreset);
        btnReset.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                txtMaKH.setText("");
                txtHoten.setText("");             
                dpkNgaysinh.getJFormattedTextField().setText("");                  
                txtSDT.setText("");
                txtEmail.setText("");
                txtDiachi.setText("");
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
                String makh = txtMaKH.getText();
                String tenkh = txtHoten.getText();               
                String ngaysinh = dpkNgaysinh.getJFormattedTextField().getText();
                String sdt = txtSDT.getText(); 
                String email = txtEmail.getText();
                String diachi = txtDiachi.getText();
                
                KhachHangDTO kh = new KhachHangDTO(makh, tenkh, ngaysinh, sdt, email, diachi);
                KhachHangBUS.themKH(kh);
                JOptionPane.showMessageDialog(null, "Thêm thành công");
                showKH(); 
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
                int selectedIndex = tblDSKH.getSelectedRow();
                if(selectedIndex >= 0) {
                    KhachHangDTO kh = DSKhachHang.get(selectedIndex);

                    int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa?");
                    if(option == 0) {
                        KhachHangBUS.xoaKH(kh.getMaKH());
                        JOptionPane.showMessageDialog(null, "Xóa thành công");
                        showKH();                              
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
                String makh = txtMaKH.getText();
                String tenkh = txtHoten.getText();               
                String ngaysinh = dpkNgaysinh.getJFormattedTextField().getText();
                String sdt = txtSDT.getText(); 
                String email = txtEmail.getText();
                String diachi = txtDiachi.getText();
                
                KhachHangDTO kh = new KhachHangDTO(makh, tenkh, ngaysinh, sdt, email, diachi);
                KhachHangBUS.suaKH(kh);
                JOptionPane.showMessageDialog(null, "Sửa thành công");
                showKH();
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

        
        
        paneltong.add(lblQLKH);
        paneltong.add(lblMaKH);
        paneltong.add(lblHoten);
        paneltong.add(lblNgaysinh);
        paneltong.add(lblSDT);
        paneltong.add(lblEmail);
        paneltong.add(lblDiachi);
        
        paneltong.add(txtMaKH);
        paneltong.add(txtHoten);
        paneltong.add(dpkNgaysinh);
        paneltong.add(txtSDT);
        paneltong.add(txtEmail);
        paneltong.add(txtDiachi);
        
        paneltong.add(DSKH);
               
        paneltong.add(btnExit);
        paneltong.add(btnReset);
        paneltong.add(btnXem);
        paneltong.add(btnThem);
        paneltong.add(btnXoa);
        paneltong.add(btnSua);
        paneltong.add(btnTimkiem);
                    
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
    
    private void showKH() {
        DSKhachHang =  KhachHangBUS.DSKH();
        
        dtm.setRowCount(0);
        
        DSKhachHang.forEach((KhachHangDTO) -> {
            dtm.addRow(new Object[] {KhachHangDTO.getMaKH(), KhachHangDTO.getTenKH(), 
                KhachHangDTO.getNgaysinh(), KhachHangDTO.getSDT(),KhachHangDTO.getEmail(),KhachHangDTO.getDiachi(),
                });
        });
    }

}



