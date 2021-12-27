/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author DELL
 */
public class KhachDTO {
   String makh, hoten, ngaysinh, sdt, email, diachi;
   public KhachDTO()
   {
       
   }
   
   public KhachDTO(String makh, String hoten, String ngaysinh, String sdt, String email, String diachi)
   {
       this.makh=makh;
       this.hoten=hoten;
       this.ngaysinh=ngaysinh;
       this.sdt=sdt;
       this.email=email;
       this.diachi=diachi;
   }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
     
}
