/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupportGUI;

import BUS.TKBUS;

import DTO.TKDTO;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
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
public class DanhSachTKGUI extends JFrame {
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

    public DanhSachTKGUI() {
        
       this.setUndecorated(true);
        this.setSize(900, 700);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        
        
    }
     public void setView(String id) {
        
            lbltieude = new JLabel("DANH SÁCH TÀI KHOẢN");
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
        header.add("Tên tài khoản");
        header.add("Mật khẩu");
        //header.add("Tên");
        header.add("Mã nhân viên");
        header.add("Trạng thái");
       
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
       
        table.getTableHeader().setForeground(new Color(255, 255, 255));
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD,18));
        table.getTableHeader().setBackground(new Color(31,73,91));
        table.getTableHeader().setBorder(border);
        table.setRowHeight(25);
        JScrollPane bangds = new JScrollPane(table);
        bangds.setBounds(20, 130, 860, 350);
        bangds.getVerticalScrollBar().setBackground(new Color(255,255,255));
        
        
        
        
        TKBUS bus = new TKBUS();
            bus.docDSTK();
            
        for (TKDTO dsto : TKBUS.dstk) {
            Vector row = new Vector();
            row.add(dsto.getTentaikhoan());
            row.add(dsto.getMatkhau());
            row.add(dsto.getManhanvien());
           // row.add(sp.getMa());
            row.add(dsto.getTrangthai());
            
            //row.add(Chuyentien(String.valueOf(sp.getDongia())));
           

            model.addRow(row);
        }
        table.setModel(model);
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
       @Override
     public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    if(row%2 != 0){
    this.setBackground(Color.WHITE);
     }else{
     this.setBackground(Color.BLUE);
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
