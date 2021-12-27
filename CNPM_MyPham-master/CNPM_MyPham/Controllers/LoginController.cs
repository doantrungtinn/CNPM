using Domain.Entities;
using Infrastructure.Persistence;
using CNPM_MyPham.Models;
using Microsoft.AspNetCore.Mvc;
using Domain.Interfaces;
using Application.Services;
using Application.DTOs;
using Application.DTOs.CurrentUserDTO;

namespace CNPM_MyPham.Controllers
{
    public class LoginController : Controller
    {
        private readonly KhachHangService KHservice;
        private readonly LoaiSanPhamService LSPservice;

        public LoginController(KhachHangService KHservice, LoaiSanPhamService LSPservice){
            this.KHservice = KHservice;
            this.LSPservice = LSPservice;
        }

        [HttpGet]
        public IActionResult Index(){
            View_Chung();
            return View();
        }

        [HttpPost]
        public IActionResult Index(LoginModelDto lg){
            if(ModelState.IsValid){
                KhachHangDto kh = KHservice.KhachHang_GetByUser(lg.user);
                if(kh == null){
                    ModelState.AddModelError("", "Tài khoản không tồn tại!");
                    return View(lg);
                }
                else if(kh.pass != lg.pass){
                    ModelState.AddModelError("", "Mật khẩu không đúng!");
                    return View(lg);
                }
                else if (kh.status != 1){
                    ModelState.AddModelError("", "Tài khoản đã bị khóa!");
                    return View(lg);
                }
                CurrentUserDto U = new CurrentUserDto();
                U.KhachHangDto = kh;
                // Không cho hiện mật khẩu khách hàng vào session
                U.KhachHangDto.pass = "";
                U.KhachHangDto.repass = "";
                
                var donhang = SessionHelper.GetObjectFromJson<DonHangDto>(HttpContext.Session, "DonHang");
                if(donhang != null){
                    U.DonHangDto = donhang;
                    donhang = null;
                    SessionHelper.SetObjectAsJson(HttpContext.Session, "DonHang", donhang);
                }
                SessionHelper.SetObjectAsJson(HttpContext.Session, "CurrentUser", U);
                ViewBag.Message_Login = "Đăng nhập thành công!";
                View_Chung();
                return View();
            }
            return View();
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