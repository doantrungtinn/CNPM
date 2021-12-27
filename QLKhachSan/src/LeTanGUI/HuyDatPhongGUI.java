/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeTanGUI;


import BUS.PDatPhongBUS;
import BUS.PHuyBUS;
import DTO.PDatPhongDTO;
import DTO.PHuyDTO;
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

public class HuyDatPhongGUI extends JPanel {
 //setbounds(x,y,width,length)
    int choice = 0;

     // thang ngang tìm kiểm 
    JLabel lbtimkiem, lbtop, lbexit;   
    JTextField txtimkiem;
    JButton timkiem, thunho, exit;
    
    //form điền thông tin hủy đặt phòng
    JLabel lbmahuy, lbmadat, lbmanv, lbngayhuy, lblydo;
    JTextField txmahuy, txmadat, txmanv, txngayhuy, txlydo;
    
    //các nút
    JButton btnHuy, btnReset;
    
    //bảng phiếu đặt phòng, phiếu hủy đặt phòng
    JPanel pd, ph;
    JTable tablePD, tablePH;
    public static DefaultTableModel modelPD, modelPH;
    


    Font font = new Font("Segoe UI", Font.BOLD, 18);
    Font fontinput = new Font("Segoe UI", Font.PLAIN, 17);
    Border border = BorderFactory.createLineBorder(new Color(33, 33, 33));
    Border bordernull = BorderFactory.createEmptyBorder();
    Border borderinput = BorderFactory.createLineBorder(new Color(30, 210, 96), 4);

    

    public HuyDatPhongGUI(String id) {

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
       
        ImageIcon hinhtimkiem = new ImageIcon(getClass().getResource("/HinhAnh/timkiem.png"));       
        timkiem = new JButton();
        timkiem.setBounds(380, 15, 80, 40);       
        timkiem.setBackground(new Color(31,73,91));
        timkiem.setIcon(hinhtimkiem);
        timkiem.setFont(font);
        timkiem.setBorder(bordernull);
        timkiem.setFocusPainted(false);
        timkiem.setCursor(new Cursor(HAND_CURSOR));      
        timkiem.addMouseListener(new MouseListener() {
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
               
            }

            @Override
            public void mouseExited(MouseEvent e) {                   
            }
        });

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
        lbtop.add(timkiem);
        
        lbmahuy = new JLabel("Mã hủy : ");
        lbmahuy.setBounds(30, 80, 150, 50);
        lbmahuy.setFont(font);
        txmahuy = new JTextField();
        txmahuy.setEditable(false);
        txmahuy.setBounds(180, 85, 100, 30);
        txmahuy.setFont(fontinput);
        PHuyBUS phuybus = new PHuyBUS();
        phuybus.docDSHuy();
        txmahuy.setText(phuybus.nextPD());
               
        lbmanv = new JLabel("Mã NV : ");
        lbmanv.setBounds(30, 130, 150, 50);
        lbmanv.setFont(font);
        txmanv = new JTextField();
        txmanv.setEditable(false);
        txmanv.setBounds(180, 135, 100, 30);
        txmanv.setFont(fontinput);
        txmanv.setEditable(false);
        txmanv.setText(id);
        
        lbngayhuy = new JLabel("Ngày hủy : ");
        lbngayhuy.setBounds(30, 180, 150, 50);
        lbngayhuy.setFont(font);
        txngayhuy = new JTextField();
        txngayhuy.setEditable(false);
        txngayhuy.setBounds(180, 185, 100, 30);
        txngayhuy.setFont(fontinput);
        Date date = new Date();
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
        txngayhuy.setText(fm.format(date));
        
        lbmadat = new JLabel("Mã đặt phòng : ");
        lbmadat.setBounds(30, 230, 150, 50);
        lbmadat.setFont(font);
        txmadat = new JTextField();
        txmadat.setEditable(false);
        txmadat.setBounds(180, 235, 100, 30);
        txmadat.setFont(fontinput);
        
        lblydo = new JLabel("Lý do hủy : ");
        lblydo.setBounds(30, 280, 150, 50);
        lblydo.setFont(font);
        txlydo = new JTextField();
        txlydo.setBounds(180, 285, 200, 30);
        txlydo.setFont(fontinput);
        
        btnHuy = new JButton("Hủy đặt phòng");
        btnHuy.setBounds(30, 335, 180, 50);
        btnHuy.setBackground(new Color(31,73,91));
        btnHuy.setForeground(new Color(235, 235, 235));
        btnHuy.setFont(font);
        btnHuy.setBorder(bordernull);
        btnHuy.setFocusPainted(false);
       
        
        //danh sách phiếu đặt phòng        
        pd = new JPanel();
        pd.setLayout(null);
        pd.setBounds(30, 400, 910, 320);
        pd.setBackground(new Color(237,241,255));
       //hd.setBackground(Color.RED);
        TitledBorder TTborder1 = new TitledBorder("Phiếu Đặt Phòng");
        TTborder1.setTitleJustification(TitledBorder.LEFT);
        TTborder1.setTitlePosition(TitledBorder.TOP);
        TTborder1.setTitleColor(new Color(33,33,33));
        //TTborder1.setTitleColor(Color.red);
        TTborder1.setTitleFont(font);
        pd.setBorder(TTborder1);
        
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
        
        modelPD = new DefaultTableModel(header, 0);
        tablePD = new JTable();
        tablePD.setModel(modelPD);
        tablePD.setFillsViewportHeight(true);
        
        tablePD.setBorder(border);
        tablePD.setFillsViewportHeight(true);
        
        tablePD.setBackground(new Color(255, 255, 255));
        tablePD.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        tablePD.getTableHeader().setForeground(new Color(255, 255, 255));
        tablePD.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        tablePD.getTableHeader().setBackground(new Color(31,73,91));
        tablePD.getTableHeader().setBorder(border);
        tablePD.setRowHeight(30);

        JScrollPane bangPD = new JScrollPane(tablePD);
        bangPD.setBounds(10, 30, 890, 300);
        pd.add(bangPD);
        
        PDatPhongBUS pdphongbus = new PDatPhongBUS();
        pdphongbus.docDSPDPhong();
//        if (PDatPhongBUS.dspdphong == null) {
//            pdphongbus.docDSPDPhong();
//        }
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
                      
            modelPD.addRow(row);       
            }
        }
        
        tablePD.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {             
                int i = tablePD.getSelectedRow();
                if (i >= 0) 
                {
                    String ma = tablePD.getValueAt(i, 0).toString();    //Lấy mã phieu đặt phòng
                    txmadat.setText(ma);                  
                }

            }
        });
            
            //Danh sách phiếu hủy đặt phòng       
        ph = new JPanel();
        ph.setLayout(null);
        ph.setBounds(450, 80, 480, 300);
        ph.setBackground(new Color(237,241,255));
        TitledBorder TTborder2 = new TitledBorder("Phiếu Hủy");
        TTborder2.setTitleJustification(TitledBorder.LEFT);
        TTborder2.setTitlePosition(TitledBorder.TOP);
        TTborder2.setTitleColor(new Color(33,33,33));
        //TTborder1.setTitleColor(Color.red);
        TTborder2.setTitleFont(font);
        ph.setBorder(TTborder2);
        
        Vector headerPH = new Vector();        
        headerPH.add("Mã Hủy");
        headerPH.add("Mã Đặt");
        headerPH.add("Mã NV");
        headerPH.add("Ngày Hủy");
        headerPH.add("Lý do hủy");
        
        modelPH = new DefaultTableModel(headerPH, 0);
        tablePH = new JTable();
        tablePH.setModel(modelPH);
        tablePH.setFillsViewportHeight(true);
        
        tablePH.setBorder(border);
        tablePH.setFillsViewportHeight(true);
        
        tablePH.setBackground(new Color(255, 255, 255));
        tablePH.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        tablePH.getTableHeader().setForeground(new Color(255, 255, 255));
        tablePH.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        tablePH.getTableHeader().setBackground(new Color(31,73,91));
        tablePH.getTableHeader().setBorder(border);
        tablePH.setRowHeight(30);

        JScrollPane bangPH = new JScrollPane(tablePH);
        bangPH.setBounds(10, 30, 460, 200);
        ph.add(bangPH);
        
        PHuyBUS phbus = new PHuyBUS();
        phbus.docDSHuy();
//        if (PDatPhongBUS.dspdphong == null) {
//            pdphong.docDSPDPhong();
//        }
        for (PHuyDTO phuy : PHuyBUS.dsphuy) {  
            
            Vector row = new Vector();           
            row.add(phuy.getMahuy());
            row.add(phuy.getMadp());
            row.add(phuy.getManv());
            row.add(phuy.getNgayhuy());
            row.add(phuy.getLydo());
                     
            modelPH.addRow(row);  
            
            
            
        }
        
         btnHuy.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if("".equals(txmadat.getText()))
                {
                     JOptionPane.showMessageDialog(lbtimkiem, "Chọn phiếu đặt phòng !!!");
                     return;
                }
                else
                if("".equals(txlydo.getText()))
                {
                    JOptionPane.showMessageDialog(lbtimkiem, "Điền lý do hủy đặt phòng");
                    return ;
                }
                else
                {
                    PHuyDTO phuy = new PHuyDTO();
                    phuy.setMahuy(txmahuy.getText());
                    phuy.setMadp(txmadat.getText());
                    phuy.setManv(txmanv.getText());
                    phuy.setNgayhuy(txngayhuy.getText());
                    phuy.setLydo(txlydo.getText());
                    
                    PHuyBUS phuybus = new PHuyBUS();
                    phuybus.them(null);
                    PDatPhongBUS pdbus = new PDatPhongBUS();
                    pdbus.capnhatTrangThai(txmadat.getText(),"Đã hủy");
                    
                    Vector row = new Vector();
                    row.add(phuy.getMahuy());
                    row.add(phuy.getMadp());
                    row.add(phuy.getManv());
                    row.add(phuy.getNgayhuy());
                    row.add(phuy.getLydo());
                    modelPH.addRow(row);
                    tablePH.setModel(modelPH);
                    
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
        
  
        
        
        
        
        //code tiếp giao diện ở đây

        

        
        
    //----------**** add các thành phần giao diện ở dưới này ***--------
        this.add(lbtop);
        this.add(lbmahuy);
        this.add(txmahuy);
        this.add(lbmanv);
        this.add(txmanv);
        this.add(lbngayhuy);
        this.add(txngayhuy);
        this.add(lbmadat);
        this.add(txmadat);
        this.add(lblydo);
        this.add(txlydo);
        
        this.add(btnHuy);
        
        this.add(pd);
        this.add(ph);
        
    }
    
//     public static void main(String args[])
//    {
//        HuyDatPhongGUI dp = new HuyDatPhongGUI("LT1");
//        JFrame f = new JFrame();
//        f.setSize(1355, 950);
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f.add(dp);
//        f.setVisible(true);
//    }


}


