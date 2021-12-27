using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Application.DTOs;
using Application.DTOs.CurrentUserDTO;
using Application.Services;
using CNPM_MyPham.Models;
using Microsoft.AspNetCore.Mvc;

namespace CNPM_MyPham.Controllers
{
    public class DetailBillController : Controller
    {
        private readonly LoaiSanPhamService LSPservice;
        private readonly HoaDonService HDservice;
        private readonly ChiTietHoaDonService CTHDservice;
        public DetailBillController(HoaDonService HDservice, ChiTietHoaDonService CTHDservice, LoaiSanPhamService LSPservice){
            this.HDservice = HDservice;
            this.CTHDservice = CTHDservice;
            this.LSPservice = LSPservice;
        }
        public IActionResult Index(int bill_id)
        {
            View_Chung();
            if(ViewBag.CurrentUser == null){
                return Redirect("/Login/Index");
            }
            // nếu bill_id == null thì bill_id = -1
            if(bill_id == null){
                return View();
            }
            // Kiểm tra bill_id có phải của tài khoản này ko
            HoaDonDto hd = HDservice.HoaDon_GetByUserAndID(ViewBag.CurrentUser.KhachHangDto.user, bill_id);
            if(hd == null){
                return View();
            }
            var cthds = CTHDservice.ChiTietHoaDon_GetByBillId(hd.bill_id);
            ViewBag.MaHD = hd.bill_id;      
            return View(cthds);
        }
        public void View_Chung(){
            // Lấy session User hiện hành
            ViewBag.CurrentUser = SessionHelper.GetObjectFromJson<CurrentUserDto>(HttpContext.Session, "CurrentUser");

            // Lấy session Don Hang
            ViewBag.DonHang = SessionHelper.GetObjectFromJson<DonHangDto>(HttpContext.Session, "DonHang");

            // Lấy danh sách loại sản phẩm cho danh mục
            ViewBag.Danhmuc = LSPservice.LoaiSanPham_GetAll();
        }
    }
}
