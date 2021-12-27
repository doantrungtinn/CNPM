using Domain.Entities;
using Infrastructure.Persistence;
using CNPM_MyPham.Models;
using Microsoft.AspNetCore.Mvc;
using Domain.Interfaces;
using Application.Services;
using Application.DTOs;
using Application.DTOs.CurrentUserDTO;
using System;

namespace CNPM_MyPham.Controllers
{
    public class RegisterController : Controller
    {
        private readonly KhachHangService KHservice;

        private readonly LoaiSanPhamService LSPservice;

        public RegisterController(KhachHangService KHservice, LoaiSanPhamService LSPservice){
            this.KHservice = KHservice;
            this.LSPservice = LSPservice;
        }

        [HttpGet]
        public IActionResult Index(){
            View_Chung();
            return View();
        }

        [HttpPost]
        public IActionResult Index(KhachHangDto U){
            if(ModelState.IsValid){
                KhachHangDto kh = KHservice.KhachHang_GetByUser(U.user);
                if(kh == null){
                    KHservice.KhachHang_Add(U);
                    CurrentUserDto currentuser = new CurrentUserDto();
                    currentuser.KhachHangDto = U;
                    // Không cho hiện mật khẩu khách hàng vào session
                    currentuser.KhachHangDto.pass = "";
                    currentuser.KhachHangDto.repass = "";
                    SessionHelper.SetObjectAsJson(HttpContext.Session, "CurrentUser", currentuser);
                    View_Chung();
                    U = null;
                    ViewBag.Message_Register = "Đăng kí thành công!";
                    return View();
                }
                ModelState.AddModelError("", "Tài khoản đã tồn tại!");
            }
            return View(U);
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