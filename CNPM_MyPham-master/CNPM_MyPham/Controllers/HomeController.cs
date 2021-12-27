using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;
using Domain.Entities;
using Infrastructure.Persistence;
using CNPM_MyPham.Models;
using Domain.Interfaces;
using Application.Services;
using Application.DTOs;
using Application.DTOs.CurrentUserDTO;

namespace CNPM_MyPham.Controllers
{
    public class HomeController : Controller
    {
        private readonly LoaiSanPhamService LSPservice;
        private readonly SanPhamService SPservice;
        private readonly ThuongHieuService THservice;

        public HomeController(LoaiSanPhamService LSPservice, SanPhamService SPservice, ThuongHieuService THservice)
        {
            this.LSPservice = LSPservice;
            this.SPservice = SPservice;
            this.THservice = THservice;
        }

        [HttpGet]
        public IActionResult Index()
        {
            View_Chung();
            var IndexView = new IndexViewHomeModel();
            IndexView.ListSPChay = SPservice.TenSPChay();
            IndexView.ListSPNoi = SPservice.TenSPNoi();
            IndexView.ListTH = THservice.ThuongHieu_GetAll();
            return View(IndexView);
        }

        public IActionResult Privacy()
        {
            return View();
        }

        // [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        // public IActionResult Error()
        // {
        //     return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        // }
        [HttpPost]
        public IActionResult LoadCartForLayOut(){
            var currentuser = SessionHelper.GetObjectFromJson<CurrentUserDto>(HttpContext.Session, "CurrentUser");
            if(currentuser != null){
                return new JsonResult(currentuser.DonHangDto.ListSP);
            }
            var donhang = SessionHelper.GetObjectFromJson<DonHangDto>(HttpContext.Session, "DonHang");
            if(donhang != null){
                return new JsonResult(donhang.ListSP);
            }
            return new JsonResult(null);
        }

        [HttpPost]
        public IActionResult AjaxRemoveSP(int idsp){
            var currentuser = SessionHelper.GetObjectFromJson<CurrentUserDto>(HttpContext.Session, "CurrentUser");
            if(currentuser != null){
                currentuser.DonHangDto.removeSPfromID(idsp);
                SessionHelper.SetObjectAsJson(HttpContext.Session, "CurrentUser", currentuser);
                return new JsonResult(currentuser.DonHangDto.ListSP);
            }
            else{
                var donhang = SessionHelper.GetObjectFromJson<DonHangDto>(HttpContext.Session, "DonHang");
                if(donhang != null){
                    donhang.removeSPfromID(idsp);
                    SessionHelper.SetObjectAsJson(HttpContext.Session, "DonHang", donhang);
                    return new JsonResult(donhang.ListSP);
                }
            }
            return new JsonResult(null);
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
