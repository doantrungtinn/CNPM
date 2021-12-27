/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyGUI;


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

public class CaLamGUI extends JPanel {
 //setbounds(x,y,width,length)
    int choice = 0;

    public static DefaultTableModel modelHD, modelCTHD;
    JLabel lbtimkiem, lbtop, lbexit, lbpanel;
    JTextField txtimkiem;
    JButton timkiem, thunho, exit;


    Font font = new Font("Segoe UI", Font.BOLD, 18);
    Border border = BorderFactory.createLineBorder(new Color(33, 33, 33));
    Border bordernull = BorderFactory.createEmptyBorder();
    Border borderinput = BorderFactory.createLineBorder(new Color(30, 210, 96), 4);

    

    public CaLamGUI() {

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
        
        
        //code tiếp giao diện ở đây
        CalamPanel cl = new CalamPanel();
        cl.setBounds(0, 0, 950, 880);
        
        CalamPanel_1 cl1 = new CalamPanel_1();
        cl1.setBounds(0, 0, 950, 880);
        
        
        
    //----------**** add các thành phần giao diện ở dưới này ***--------
        
        this.add(lbtop);
        this.add(cl1);
    }


}



