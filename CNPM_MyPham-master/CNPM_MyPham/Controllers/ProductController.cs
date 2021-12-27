using Domain.Entities;
using Infrastructure.Persistence;
using CNPM_MyPham.Models;
using Microsoft.AspNetCore.Mvc;
using Domain.Interfaces;
using Application.Services;
using Application.DTOs;
using System;
using Application.DTOs.CurrentUserDTO;

namespace CNPM_MyPham.Controllers
{
    public class ProductController : Controller
    {
        private readonly SanPhamService SPservice;
        private readonly ThuongHieuService THservice;

        private readonly LoaiSanPhamService LSPservice;

        public ProductController(SanPhamService SPservice, ThuongHieuService THservice, LoaiSanPhamService LSPservice){
            this.SPservice = SPservice;
            this.THservice = THservice;
            this.LSPservice = LSPservice;
        }

        [HttpGet]
        [Route("Product/Index/{id?}")]
        public IActionResult Index(int id){
            View_Chung();
            SanPhamDto SP = SPservice.SanPham_GetById(id);
            // Console.WriteLine(SP.product_id + " " + SP.name);
            ViewBag.TH = THservice.ThuongHieu_GetById(SP.brand_id).name;
            // Console.WriteLine(ViewBag.TH);
            ViewBag.LSP = LSPservice.LoaiSanPham_GetById(SP.product_type_id).name;
            // Console.WriteLine(ViewBag.LSP);
            return View(SP);
        }

        [HttpPost]
        public int LoadSLSP(int idsp, int slsp){
            var sp = SPservice.SanPham_GetById(idsp);
            if(slsp > sp.amount){
                // Nếu số lượng sản phẩm lớn hơn số lượng sản phẩm cần mua return số lượng sản phẩm
                return sp.amount;
            }
            // Nếu số lượng sản phẩm lớn hơn số lượng sản phẩm cần mua return -1
            return -1;
        }

        public string ThemSPAjax(int idsp, int slsp){
            var sp = SPservice.SanPham_GetById(idsp);
            var spfordonhang = new SPForDonHangDto(sp, slsp);
            var currentuser = SessionHelper.GetObjectFromJson<CurrentUserDto>(HttpContext.Session, "CurrentUser");
            if(currentuser != null){
                var t = currentuser.DonHangDto.search(idsp, slsp);
                if(t == 1){
                    return "Sản phẩm đã có trong giỏ hàng";
                }
                if(t == 0){
                    currentuser.DonHangDto.thaydoisoluongforsanpham(idsp, slsp);
                }
                else{
                    currentuser.DonHangDto.ListSP.Add(spfordonhang);
                }
                SessionHelper.SetObjectAsJson(HttpContext.Session, "CurrentUser", currentuser);
                return "Thêm sản phẩm thành công";
            }
            var donhang = SessionHelper.GetObjectFromJson<DonHangDto>(HttpContext.Session, "DonHang");
            if(donhang == null){
                donhang = new DonHangDto();
            }
            var tdh = donhang.search(idsp, slsp);
            if(tdh == 1){
                return "Sản phẩm đã có trong giỏ hàng";
            }
            if(tdh == 0){
                donhang.thaydoisoluongforsanpham(idsp, slsp);
            }
            else{
                donhang.ListSP.Add(spfordonhang);
            }
            SessionHelper.SetObjectAsJson(HttpContext.Session, "DonHang", donhang);
            return "Thêm sản phẩm thành công";
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