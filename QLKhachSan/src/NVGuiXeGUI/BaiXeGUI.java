/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NVGuiXeGUI;



import BUS.thexekhachBUS;
import BUS.thexenvBUS;
import DTO.thexekhachDTO;
import DTO.thexenvDTO;
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
import java.sql.SQLException;
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

public class BaiXeGUI extends JPanel {
 //setbounds(x,y,width,length)
    int choice = 0;

    public static DefaultTableModel modegx;
    JLabel lbtimkiem, lbtop, lbexit,lbtk;
    JTextField txtimkiem;
    JButton timkiem, thunho, exit,them,xoa,sua,lammoi;
    JComboBox cb,cs;
    JPanel gx,chinhsua;

    Font font = new Font("Segoe UI", Font.BOLD, 18);
    Border border = BorderFactory.createLineBorder(new Color(33, 33, 33));
    Border bordernull = BorderFactory.createEmptyBorder();
    Border borderinput = BorderFactory.createLineBorder(new Color(30, 210, 96), 4);
    public static JTable tableGX;

    

    public BaiXeGUI() throws SQLException {

        this.setSize(1350, 945);
        this.setLayout(null);
        this.setBorder(border);
        this.setBackground(new Color(237,241,255));


        lbtop = new JLabel();
        lbtop.setBounds(0, 0, 950, 65);
        lbtop.setBackground(new Color(134, 174, 195));
        lbtop.setOpaque(true);
        
        lbtk = new JLabel("TÌM KIẾM ");
        lbtk.setBounds(5,18 , 120, 30);
        lbtk.setBackground(new Color(255, 255, 255));
        lbtk.setBorder(border);
        lbtk.setForeground(Color.white);
        lbtk.setHorizontalAlignment(JLabel.CENTER);
       
        
        txtimkiem = new JTextField(18);
        txtimkiem.setFont(font);
        txtimkiem.setBounds(120, 18, 250, 30);
        txtimkiem.setBorder(border);
       
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
        
         String choose[] = {" Mã thẻ xe ", "bảng số", "loại xe", "trạng thái", "xe nhân viên", "Xe khách hàng"};
        cb = new JComboBox(choose);
        cb.setBounds(400, 18, 130, 32);
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
        lbtop.add(txtimkiem);
        lbtop.add(cb);
        lbtop.add(lbtk);
        
        
        //code tiếp giao diện ở đây

        gx = new JPanel();
       
        gx.setLayout(null);
         gx.setBounds(30, 80, 920, 450);
       // hd.setBounds(100, 100, 1020, 360);
        
        gx.setBackground(new Color(237,241,255));
       //hd.setBackground(Color.RED);
        TitledBorder TTborder1 = new TitledBorder("BẢNG THÔNG TIN");
        TTborder1.setTitleJustification(TitledBorder.LEFT);
        TTborder1.setTitlePosition(TitledBorder.TOP);
        TTborder1.setTitleColor(new Color(33,33,33));
        //TTborder1.setTitleColor(Color.red);
        TTborder1.setTitleFont(font);
        gx.setBorder(TTborder1);

        Vector header = new Vector();        
        header.add("Mã thẻ xe ");
        header.add("thời gian vào");      
        header.add("Thời gian ra ");
        header.add("Bảng số ");
        header.add("Loại xe");
        header.add("Trạng thái");
        
           modegx = new DefaultTableModel(header, 0);
        tableGX = new JTable();
        tableGX.setModel(modegx);
        tableGX.setFillsViewportHeight(true);
        
        tableGX.setBorder(border);
        tableGX.setFillsViewportHeight(true);
        
        tableGX.setBackground(new Color(255, 255, 255));
        tableGX.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        tableGX.getTableHeader().setForeground(new Color(255, 255, 255));
        tableGX.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        tableGX.getTableHeader().setBackground(new Color(31,73,91));
        tableGX.getTableHeader().setBorder(border);
        tableGX.setRowHeight(30);

        JScrollPane bangGX = new JScrollPane(tableGX);
        bangGX.setBounds(10, 30, 900, 400);
        gx.add(bangGX);
        
         //Đọc danh sách thenv
//        thexenvBUS txnvbus = new thexenvBUS();
//        txnvbus.docDSTXNV();
//        if (thexenvBUS.dstxnv == null) {
//            txnvbus.docDSTXNV();
//        }
//        for (thexenvDTO txnv : thexenvBUS.dstxnv) {
//            Vector row = new Vector();
//
//            row.add(txnv.getMathe());
//            row.add(txnv.getThoigianvao());
//            row.add(txnv.getThoigianra());
//            row.add(txnv.getSoxe());
//            row.add(txnv.getLoaixe());
//            
//            row.add(txnv.getTrangthai());
//            
//                      
//            modegx.addRow(row);
//        }
        thexekhachBUS txkbus = new thexekhachBUS();
        txkbus.docDSTXK();
        if (thexekhachBUS.dstxk == null) {
            txkbus.docDSTXK();
        }
        for (thexekhachDTO txk : thexekhachBUS.dstxk) {
            Vector row = new Vector();

            row.add(txk.getMathe());
            row.add(txk.getThoigianvao());
            row.add(txk.getThoigianra());
            row.add(txk.getSoxe());
            row.add(txk.getLoaixe());           
            row.add(txk.getTrangthai());
            
                      
            modegx.addRow(row);
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
       // them.setFocusPainted(false);
//        them.addMouseListener(new MouseListener() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
////                ThemHDGUI test = new ThemHDGUI();
////                test.setView("Manager");
//               // BaiXeGUI pdat = new BaiXeGUI();
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
//                them.setIcon(hinhthem1);
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                them.setIcon(hinhthem);
//            }
//            
//
//        });
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
        lammoi =new JButton();
        lammoi.setBounds(740, 600, 130, 50);
         lammoi.setBackground(new Color(237,241,255));
        lammoi.setBorder(bordernull);
        lammoi.setIcon(hinhreset);
        
    //----------**** add các thành phần giao diện ở dưới này ***--------
        this.add(lbtop);    
        this.add(them);
        this.add(gx);
        this.add(sua);
        this.add(xoa);
        this.add(lammoi);
    }
//    public static void main(String[] args) {
//        BaiXeGUI a = new BaiXeGUI();
//        JFrame b = new JFrame("Xin chào");
//        JPanel pnDemo = new JPanel();
//        pnDemo.setBounds(0, 0, 300, 300);
//        pnDemo.setBackground(Color.red);
//        pnDemo.setVisible(true);
//        b.setBounds(0, 0, 546, 765);
//        b.add(a);
//        b.setVisible(true);
//    }
public static void main(String[] args) throws SQLException {
//        BaiXeGUI gx =new BaiXeGUI();
    }
}




