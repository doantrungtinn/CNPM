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
    public class CartController : Controller
    {
        private readonly LoaiSanPhamService LSPservice;
        private readonly SanPhamService SPservice;
        private readonly HoaDonService HDservice;
        private readonly ChiTietHoaDonService CTHDservice;
        public CartController(LoaiSanPhamService LSPservice, SanPhamService SPservice, HoaDonService HDservice, ChiTietHoaDonService CTHDservice){
            this.LSPservice = LSPservice;
            this.SPservice = SPservice;
            this.HDservice = HDservice;
            this.CTHDservice = CTHDservice;
        }
        public IActionResult Index()
        {
            View_Chung();
            var currentuser = SessionHelper.GetObjectFromJson<CurrentUserDto>(HttpContext.Session, "CurrentUser");
            if(currentuser != null){
                return View(currentuser.DonHangDto);
            }
            var donhang = SessionHelper.GetObjectFromJson<DonHangDto>(HttpContext.Session, "DonHang");
            if(donhang != null){
                return View(donhang);
            }
            return View();
        }
        [HttpPost]
        public IActionResult TangSP(int idsp){
            var currentuser = SessionHelper.GetObjectFromJson<CurrentUserDto>(HttpContext.Session, "CurrentUser");
            if(currentuser != null){
                currentuser.DonHangDto.addonesoluongforsanpham(idsp);
                SessionHelper.SetObjectAsJson(HttpContext.Session, "CurrentUser", currentuser);
                return new JsonResult(currentuser.DonHangDto);
            }
            var donhang = SessionHelper.GetObjectFromJson<DonHangDto>(HttpContext.Session, "DonHang");
            if(donhang != null){
                donhang.addonesoluongforsanpham(idsp);
                SessionHelper.SetObjectAsJson(HttpContext.Session, "DonHang", donhang);
                return new JsonResult(donhang);
            }
            return new JsonResult(null);
        }
        [HttpPost]
        public IActionResult GiamSP(int idsp){
            var currentuser = SessionHelper.GetObjectFromJson<CurrentUserDto>(HttpContext.Session, "CurrentUser");
            if(currentuser != null){
                currentuser.DonHangDto.subtractonesoluongforsanpham(idsp);
                SessionHelper.SetObjectAsJson(HttpContext.Session, "CurrentUser", currentuser);
                return new JsonResult(currentuser.DonHangDto);
            }
            var donhang = SessionHelper.GetObjectFromJson<DonHangDto>(HttpContext.Session, "DonHang");
            if(donhang != null){
                donhang.subtractonesoluongforsanpham(idsp);
                SessionHelper.SetObjectAsJson(HttpContext.Session, "DonHang", donhang);
                return new JsonResult(donhang);
            }
            return new JsonResult(null);
        }
        [HttpPost]
        public IActionResult UpdateSP(int idsp, int slsp){
            var currentuser = SessionHelper.GetObjectFromJson<CurrentUserDto>(HttpContext.Session, "CurrentUser");
            if(currentuser != null){
                currentuser.DonHangDto.thaydoisoluongforsanpham(idsp, slsp);
                SessionHelper.SetObjectAsJson(HttpContext.Session, "CurrentUser", currentuser);
                return new JsonResult(currentuser.DonHangDto);
            }
            var donhang = SessionHelper.GetObjectFromJson<DonHangDto>(HttpContext.Session, "DonHang");
            if(donhang != null){
                donhang.thaydoisoluongforsanpham(idsp, slsp);
                SessionHelper.SetObjectAsJson(HttpContext.Session, "DonHang", donhang);
                return new JsonResult(donhang);
            }
            return new JsonResult(null);
        }
        [HttpPost]
        public IActionResult RemoveCart(int idsp){
            var currentuser = SessionHelper.GetObjectFromJson<CurrentUserDto>(HttpContext.Session, "CurrentUser");
            if(currentuser != null){
                currentuser.DonHangDto.removeSPfromID(idsp);
                SessionHelper.SetObjectAsJson(HttpContext.Session, "CurrentUser", currentuser);
                return new JsonResult(currentuser.DonHangDto);
            }
            var donhang = SessionHelper.GetObjectFromJson<DonHangDto>(HttpContext.Session, "DonHang");
            if(donhang != null){
                donhang.removeSPfromID(idsp);
                SessionHelper.SetObjectAsJson(HttpContext.Session, "DonHang", donhang);
                return new JsonResult(donhang);
            }
            return new JsonResult(null);
        }
        [HttpPost]
        public IActionResult CheckOutCart(string address){
            var MessError = "";
            long total = 0;
            var currentuser = SessionHelper.GetObjectFromJson<CurrentUserDto>(HttpContext.Session, "CurrentUser");
            if(currentuser != null){
                int amount = 0;
                // Kiểm tra số lượng sản phẩm trong kho đủ ko?
                foreach(var q in currentuser.DonHangDto.ListSP){
                    amount = SPservice.SanPham_GetById(q.SP.product_id).amount;
                    total += q.SP.price * q.soluong;
                    if(q.soluong > amount){
                        MessError += "Sản phẩm " + q.SP.name + " chỉ còn " + amount + "\n";
                    }
                }
                if(MessError == ""){
                    // Tạo hóa đơn
                    var hd = new HoaDonDto();
                    hd.bill_id = HDservice.HoaDon_GetMaxId()+1;
                    hd.user_kh = currentuser.KhachHangDto.user;
                    hd.user_nv = null;
                    hd.phone = currentuser.KhachHangDto.phone;
                    if(address == null || address == ""){
                        hd.address = currentuser.KhachHangDto.address;
                    }
                    else{
                        hd.address = address;
                    }
                    hd.date_receice = null;
                    hd.date_order = System.DateTime.Now;
                    hd.total = total;
                    hd.status = 1;
                    
                    // Tạo chi tiết hóa đơn kèm theo giảm số lượng sản phẩm trong CSDL
                    var Listcthd = new List<ChiTietHoaDonDto>();
                    foreach(var q in currentuser.DonHangDto.ListSP){
                        var ctdh = new ChiTietHoaDonDto();
                        ctdh.bill_id = hd.bill_id;
                        ctdh.product_id = q.SP.product_id;
                        ctdh.name = q.SP.name;
                        ctdh.amount = q.soluong;
                        ctdh.price = q.SP.price;
                        ctdh.img = q.SP.img;

                        // Giảm số lượng sản phẩm trong kho
                        var sp = SPservice.SanPham_GetById(q.SP.product_id);
                        sp.amount -= q.soluong;
                        SPservice.SanPham_Update(sp);
                        
                        Listcthd.Add(ctdh);
                    }

                    // Lưu vào CSDL
                    HDservice.HoaDon_Add(hd);
                    CTHDservice.ChiTietHoaDon_AddRange(Listcthd);

                    // Xóa session
                    currentuser.DonHangDto.ListSP.Clear();
                    SessionHelper.SetObjectAsJson(HttpContext.Session, "CurrentUser", currentuser);
                    return new JsonResult(1);
                }
            }
            else{
                MessError = "Bạn chưa đăng nhập tài khoản! => Không thể THANH TOÁN";
            }
            return new JsonResult(MessError);
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
