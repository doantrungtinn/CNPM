/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Trang
 */
public class NhanVienDTO {
     public String manv, macv, tennv, ngaysinh, diachi, sdt, gioitinh;

     
    
   
public NhanVienDTO(){}

    public NhanVienDTO(String manv, String macv, String tennv, String ngaysinh, String gioitinh, String diachi, String sdt) {
        this.manv = manv;
        this.macv = macv;
        this.tennv= tennv;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.sdt = sdt;
        this.diachi = diachi;
       
    }

    public String getManhanvien() {
        return manv;
    }

    public void setManhanvien(String manv) {
        this.manv= manv;
    }

    public String getMachucvu() {
        return macv;
    }

    public void setMachucvu(String macv) {
        this.macv = macv;
    }

    public String getTennhanvien() {
        return tennv;
    }

    public void setTennhanvien(String tennv) {
        this.tennv = tennv;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh= gioitinh;
    }

    public  String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
   
    public String getSodienthoai(){
        return sdt;
    }
    public void setSodienthoai(String sdt){
        this.sdt=sdt;
    }
   
}
