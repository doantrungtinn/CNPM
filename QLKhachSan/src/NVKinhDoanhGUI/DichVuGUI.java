
package NVKinhDoanhGUI;

import BUS.DichVuTKBUS;
import DTO.DichVuDTO;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import java.io.IOException;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
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

public class DichVuGUI extends JPanel {
 //setbounds(x,y,width,length)
    int choice = 0;

    public static DefaultTableModel modeDV;
    JLabel lbtimkiem, lbtop, lbexit,lbtk, lbpanel;
    JTextField txtimkiem,txtmadv,txtmaloai,txttendv,txtdonggia;
    JButton timkiem, thunho, exit,them , sua,xoa,reset;
    JComboBox cb;
    JPanel cs,dv;
    public static JTable tableDV;
//    public static String array_DichVu[]={"mã dịch vụ ","mã loại","Tên dịch vụ","đồng giá ","đơn vị tính "};
//    private GUIMyTableDV table_DV;
//    private JPanel show;
//    private static JDialog themDV;
//    private static JDialog suaDV;
//    //Phần nhãn bên trong Dialog thêm sửa 
//    private JLabel label_dichvu[] = new JLabel[array_DichVu.length];
//    //Phần textfield của thêm
//    private JTextField txt_dichvu_Them[] = new JTextField[array_DichVu.length];
//    //Phần textfield của sửa
//    private JTextField txt_dichvu_Sua[] = new JTextField[array_DichVu.length];
//    
//    private int cohieu = 0;
//    private JComboBox cbDonViTinh_Them,cbDonViTinh_Sua;
//    private String array_DonViTinh[]={"phần ","giờ","kí","chai","người"};
//    private JComboBox cbLoai_Them,cbLoai_Sua;
//    private String array_Loai[]={"ăn uống ","giải trí ","dịch vụ phòng"}; 
//     DichVuTKBUS BUS = new DichVuTKBUS();
    Font font = new Font("Segoe UI", Font.BOLD, 18);
    Border border = BorderFactory.createLineBorder(new Color(33, 33, 33));
    Border bordernull = BorderFactory.createEmptyBorder();
    Border borderinput = BorderFactory.createLineBorder(new Color(30, 210, 96), 4);

    

    public DichVuGUI() {
       
        
       
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
       
       lbtk = new JLabel("TÌM KIẾM ");
        lbtk.setBounds(5,18 , 120, 30);
        lbtk.setBackground(new Color(255, 255, 255));
        lbtk.setBorder(border);
        lbtk.setForeground(Color.white);
        lbtk.setHorizontalAlignment(JLabel.CENTER);
       
        String choose[] = {" Mã Dịch vụ ", "Tên dịch vụ", "loại dịch vụ", "Đơn giá"};
        cb = new JComboBox(choose);
        cb.setBounds(400, 18, 130, 32);
        cb.setFont(new Font("Segoe UI", Font.BOLD, 16));
        cb.setBorder(border);
        cb.setBackground(new Color(255, 255, 255));
        
        txtimkiem = new JTextField(18);
        txtimkiem.setFont(font);
        txtimkiem.setBounds(120, 18, 250, 30);
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
        lbtop.add(txtimkiem);
        lbtop.add(lbtk);
        lbtop.add(cb);
        
//        DVJPanel JP =new DVJPanel();
//        JP.setBounds(0, 0, 950, 880);
//        //code tiếp giao diện ở đây
//        lbpanel = new JLabel();
//        lbpanel.setBounds(0, 0, 950, 880);
//        lbpanel.add(JP);
        
        cs =new JPanel();
        cs.setBounds(5, 80,400, 500);
        cs.setBackground(new Color(237,241,255));
        
         dv = new JPanel();
       
        dv.setLayout(null);
         dv.setBounds(30, 80, 920, 450);
       // hd.setBounds(100, 100, 1020, 360);
        
        dv.setBackground(new Color(237,241,255));
       //hd.setBackground(Color.RED);
        TitledBorder TTborder1 = new TitledBorder("BẢNG THÔNG TIN");
        TTborder1.setTitleJustification(TitledBorder.LEFT);
        TTborder1.setTitlePosition(TitledBorder.TOP);
        TTborder1.setTitleColor(new Color(33,33,33));
        //TTborder1.setTitleColor(Color.red);
        TTborder1.setTitleFont(font);
        dv.setBorder(TTborder1);

        Vector header = new Vector();        
        header.add("Mã dịch vụ  ");
        header.add("Tên Dịch Vụ");      
        header.add("Loại dịch Vụ ");
        header.add("đơn giá ");
        header.add("đơn vị tính ");
       
        
        modeDV = new DefaultTableModel(header, 0);
        tableDV = new JTable();
        tableDV.setModel(modeDV);
        tableDV.setFillsViewportHeight(true);
        
        tableDV.setBorder(border);
        tableDV.setFillsViewportHeight(true);
        
        tableDV.setBackground(new Color(255, 255, 255));
        tableDV.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        tableDV.getTableHeader().setForeground(new Color(255, 255, 255));
        tableDV.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        tableDV.getTableHeader().setBackground(new Color(31,73,91));
        tableDV.getTableHeader().setBorder(border);
        tableDV.setRowHeight(30);

        JScrollPane bangDV = new JScrollPane(tableDV);
        bangDV.setBounds(10, 30, 900, 400);
        dv.add(bangDV);
        
         DichVuTKBUS dvbus = new DichVuTKBUS();
        dvbus.docDSDV();
        if (DichVuTKBUS.dsdv == null) {
            dvbus.docDSDV();
        }
        for (DichVuDTO qldv : DichVuTKBUS.dsdv) {
            Vector row = new Vector();

            row.add(qldv.getMadv());
            row.add(qldv.getTendv());
            row.add(qldv.getTenloaidv());
            
            row.add(qldv.getDongia());
            row.add(qldv.getDonvtinh());
                      
            modeDV.addRow(row);
        }
         // button
        ImageIcon hinhthem = new ImageIcon(getClass().getResource("/HinhAnh/them.png"));
        ImageIcon hinhthem1 = new ImageIcon(getClass().getResource("/HinhAnh/them1.png"));
        them = new JButton();
       // them.setEnabled(false);
        them.setBounds(80, 600, 130, 50);
        them.setBackground(new Color(237,241,255));
        them.setBorder(bordernull);
        them.setIcon(hinhthem);
        
          ImageIcon hinhsua = new ImageIcon(getClass().getResource("/HinhAnh/sua.png"));
        sua = new JButton();
        sua.setBounds(300, 600, 130, 50);
        sua.setBackground(new Color(237,241,255));
        sua.setBorder(bordernull);
        sua.setIcon(hinhsua);
        
         ImageIcon hinhxoa = new ImageIcon(getClass().getResource("/HinhAnh/xoa.png"));
        xoa = new JButton();
        xoa.setBounds(520, 600, 130, 50);
        xoa.setBackground(new Color(237,241,255));
        xoa.setBorder(bordernull);
        xoa.setIcon(hinhxoa);
        
        ImageIcon hinhreset=new ImageIcon(getClass().getResource("/HinhAnh/reset.png"));
        reset =new JButton();
        reset.setBounds(740, 600, 130, 50);
         reset.setBackground(new Color(237,241,255));
        reset.setBorder(bordernull);
        reset.setIcon(hinhreset);
    //----------**** add các thành phần giao diện ở dưới này ***--------
        this.add(lbtop);  
//        this.add(lbpanel);
        this.add(dv);
        this.add(them);
        this.add(sua);
        this.add(xoa);
        this.add(reset);
    }
//    public JPanel Table() {
//        JPanel panel = new JPanel(null);
//        //Tạo đối tượng cho table_MonAn
//        table_DV = new GUIMyTableDV();
//        //Tạo tiêu đề bảng
//        table_DV.setHeaders(array_DichVu);
//        //Hàm đọc database
//        docDB();
//        //Set kích thước và vị trí
//        table_DV.setBounds(10, 30, 900, 400);
//        panel.add(table_DV);     
//        return panel;
//        }
//      public void docDB() {
//        //Nếu dsMonAn vẫn chưa được đọc thì chạy hàm đọc
//        if (DichVuTKBUS.dsdv == null) {
//            try {
//                BUS.docdsdichvu();
//            } catch (Exception ex) {
//                Logger.getLogger(DichVuGUI.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        
//        }

    }
 




