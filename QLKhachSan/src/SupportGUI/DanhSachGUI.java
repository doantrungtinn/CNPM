/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupportGUI;

import BUS.DanhSachBUS;
import DTO.DanhSachDTO;
import static com.itextpdf.layout.layout.LayoutResult.NOTHING;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import static javafx.scene.control.ButtonType.CLOSE;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Trang
 */
public class DanhSachGUI extends JFrame {
    JLabel lbltieude,lblexit;
    JButton btnexit;
    int itsRow = 0;
    int itsColumn = 0;
    JTable table;
    DefaultTableModel model;
    Font font = new Font("Segoe UI", Font.BOLD, 18);
    Font fontBut = new Font("Segoe UI", Font.BOLD, 18);
    Font fontt = new Font("Segoe UI", Font.BOLD, 22);
    Font fontinput = new Font("Segoe UI", Font.PLAIN, 17);
    Border border = BorderFactory.createLineBorder(new Color(33, 33, 33));
    Border bordernull = BorderFactory.createEmptyBorder();

    public DanhSachGUI() {
        
       this.setUndecorated(true);
        this.setSize(900, 700);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE );
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        
        
    }
     public void setView(String id) {
        
            lbltieude = new JLabel("DANH SÁCH NHÂN VIÊN");
        lbltieude.setBounds(250, 60, 500, 60);
        lbltieude.setFont(new Font("Segoe UI", Font.BOLD, 30));
        //lbinfosp.setForeground(new Color(30, 215, 96));
        lbltieude.setForeground(new Color(31,73,91));
        
         lblexit = new JLabel();
        lblexit.setBackground(new Color(33, 33, 33));
        lblexit.setBounds(1000, 0, 180, 30);

        ImageIcon hinhexit = new ImageIcon(getClass().getResource("/HinhAnh/thoat.png"));
       btnexit = new JButton();
        btnexit.setBounds(850, 0, 60, 35);
        btnexit.setBackground(new Color(30, 30, 30));
        btnexit.setIcon(hinhexit);
        btnexit.setBorder(bordernull);
        btnexit.setFocusPainted(false);
        btnexit.setHorizontalTextPosition(SwingConstants.LEFT);
        btnexit.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
          dispose();
              //  System.exit(0);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnexit.setBackground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnexit.setBackground(new Color(30, 30, 30));
            }

        });
        
        
        
        
        
        Vector header = new Vector();
        header.add("Mã nhân viên");
        header.add("Mã chức vụ");
        //header.add("Tên");
        header.add("Tên nhân viên");
        header.add("Ngày sinh");
        header.add("Giới tính");
        header.add("Địa chỉ");
         header.add("Số điện thoại");
       model = new DefaultTableModel(header,0);
        table = new JTable();
        table.setModel(model);
        
        table.setFillsViewportHeight(true);
        table.setBorder(border);
        table.setBackground(new Color(255, 255, 255));
        table.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        table.getColumnModel().getColumn(0).setPreferredWidth(40);
        table.getColumnModel().getColumn(1).setPreferredWidth(25);
        table.getColumnModel().getColumn(2).setPreferredWidth(60);
        table.getColumnModel().getColumn(3).setPreferredWidth(25);
        table.getColumnModel().getColumn(4).setPreferredWidth(25);
        table.getColumnModel().getColumn(5).setPreferredWidth(60);
        table.getColumnModel().getColumn(6).setPreferredWidth(50);
        table.getTableHeader().setForeground(new Color(255, 255, 255));
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD,18));
        table.getTableHeader().setBackground(new Color(31,73,91));
        table.getTableHeader().setBorder(border);
        table.setRowHeight(25);
        JScrollPane bangds = new JScrollPane(table);
        bangds.setBounds(20, 130, 860, 350);
        bangds.getVerticalScrollBar().setBackground(new Color(255,255,255));
        
        
        
        
        DanhSachBUS bus = new DanhSachBUS();
            bus.docDSNV();
            
        for (DanhSachDTO ds : DanhSachBUS.dsnv) {
            Vector row = new Vector();
            row.add(ds.getManhanvien());
            row.add(ds.getMachucvu());
            row.add(ds.getTennhanvien());
           // row.add(sp.getMa());
            row.add(ds.getNgaysinh());
            row.add(ds.getGioitinh());
            //row.add(Chuyentien(String.valueOf(sp.getDongia())));
            row.add(ds.getDiachi());
            row.add(ds.getSodienthoai());

            model.addRow(row);
        }
        table.setModel(model);
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
       @Override
     public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    if(row%2 != 0){
    this.setBackground(Color.CYAN);
     }else{
     this.setBackground(Color.PINK);
     }
     this.setOpaque(true);
    this.setText(value.toString());
    return this;
    }

});
        
        
              
        
        this.add(lbltieude);
        this.add(bangds);
        this.add(lblexit);
        this.add(btnexit);



    }
  

    
    
}
