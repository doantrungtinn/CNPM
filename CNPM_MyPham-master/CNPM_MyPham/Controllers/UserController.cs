using Domain.Entities;
using Infrastructure.Persistence;
using CNPM_MyPham.Models;
using Microsoft.AspNetCore.Mvc;
using Domain.Interfaces;
using Application.Services;
using Application.DTOs;
using System;
using Application.DTOs.UserDtos;
using Application.DTOs.CurrentUserDTO;

namespace CNPM_MyPham.Controllers
{
    public class UserController : Controller
    {
        private readonly LoaiSanPhamService LSPservice;
        private readonly KhachHangService KHservice;
        private readonly HoaDonService HDservice;

        public UserController(LoaiSanPhamService LSPservice, KhachHangService KHservice, HoaDonService HDservice)
        {
            this.LSPservice = LSPservice;
            this.KHservice = KHservice;
            this.HDservice = HDservice;
        }
        [HttpGet]
        public IActionResult Index(){
            View_Chung();
            if(ViewBag.CurrentUser == null){
                return Redirect("/Login/Index");
            }
            return View();
        }
        [HttpGet]
        public IActionResult Detail(){
            View_Chung();
            if(ViewBag.CurrentUser == null){
                return Redirect("/Login/Index");
            }
            // Lấy ID khách hàng
            var user = SessionHelper.GetObjectFromJson<CurrentUserDto>(HttpContext.Session, "CurrentUser").KhachHangDto.user;
            // Lấy thông tin khách hàng
            var kh = KHservice.KhachHang_GetByUser(user);
            // Lấy các mục cần hiện trên View
            var edituserdto = new EditUserDto(kh);
            return View(edituserdto);
        }
        [HttpGet]
        public IActionResult Edit(){
            View_Chung();
            if(ViewBag.CurrentUser == null){
                return Redirect("/Login/Index");
            }
            // Lấy ID khách hàng
            var user = SessionHelper.GetObjectFromJson<CurrentUserDto>(HttpContext.Session, "CurrentUser").KhachHangDto.user;
            // Lấy thông tin khách hàng
            var kh = KHservice.KhachHang_GetByUser(user);
            // Lấy các mục cần hiện trên View
            var edituserdto = new EditUserDto(kh);
            return View(edituserdto);
        }
        [HttpPost]
        public IActionResult Edit(EditUserDto edituserdto){
            var currentuser = SessionHelper.GetObjectFromJson<CurrentUserDto>(HttpContext.Session, "CurrentUser");
            // Lấy thông tin còn thiếu
            // Update Khách hàng cho database
            
            if(ModelState.IsValid){
                KhachHangDto kh = KHservice.KhachHang_GetByUser(edituserdto.user);
                KhachHangDto khedit = new KhachHangDto(edituserdto);
                // Thêm thông tin mật khẩu để update
                khedit.pass = kh.pass;
                khedit.repass = kh.repass;
                khedit.status = kh.status;

                KHservice.KhachHang_Update(khedit);
                // Update currentuseredit cho session
                khedit.pass = "";
                khedit.repass = "";
                currentuser.KhachHangDto = khedit;
                SessionHelper.SetObjectAsJson(HttpContext.Session, "CurrentUser", currentuser);
                // Console.WriteLine("Đã sửa thông tin khách hàng");
            }
            View_Chung();
            if(ViewBag.CurrentUser == null){
                return Redirect("/Login/Index");
            }
            return View(edituserdto);
        }

        [HttpGet]
        public IActionResult EditPass(){
            View_Chung();
            if(ViewBag.CurrentUser == null){
                return Redirect("/Login/Index");
            }
            var editpassdto = new EditPassDto();
            editpassdto.user = SessionHelper.GetObjectFromJson<CurrentUserDto>(HttpContext.Session, "CurrentUser").KhachHangDto.user;
            return View(editpassdto);
        }
        [HttpPost]
        public IActionResult EditPass(EditPassDto editpassdto){
            if(ModelState.IsValid){
                var khdto = KHservice.KhachHang_GetByUser(editpassdto.user);
                if(khdto == null){
                    ModelState.AddModelError("", "Không tìm thấy mã khách hàng cần sửa!");
                    return View(editpassdto);
                }
                if(khdto.pass != editpassdto.oldpass){
                    ModelState.AddModelError("", "Mật khẩu cũ không đúng!");
                    return View(editpassdto);
                }
                
                khdto.EditPassDto(editpassdto);
                KHservice.KhachHang_Update(khdto);
                ViewBag.EditPassMessage = "Sửa mật khẩu thành công!";
            }
            View_Chung();
            if(ViewBag.CurrentUser == null){
                return Redirect("/Login/Index");
            }
            return View(editpassdto);
        }
        [HttpGet]
        public IActionResult MyOrder(){
            View_Chung();
            if(ViewBag.CurrentUser == null){
                return Redirect("/Login/Index");
            }
            var currentuser = SessionHelper.GetObjectFromJson<CurrentUserDto>(HttpContext.Session, "CurrentUser");
            var ListHD = HDservice.HoaDon_GetByUser(currentuser.KhachHangDto.user);
            return View(ListHD);
        }

        public IActionResult LogOut(){
            SessionHelper.SetObjectAsJson(HttpContext.Session, "CurrentUser", null);
            View_Chung();
            if(ViewBag.CurrentUser == null){
                return Redirect("/Login/Index");
            }
            return RedirectToAction("Index");
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