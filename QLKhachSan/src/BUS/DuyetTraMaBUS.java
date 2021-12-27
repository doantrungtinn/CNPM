/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import javax.swing.JTable;

public class DuyetTraMaBUS {
    public DuyetTraMaBUS(){}
    public String TraMa(JTable JTb){
        int i = JTb.getSelectedRow();
        String Ma = JTb.getValueAt(i, 0).toString();
        return Ma;
    }
        
}
