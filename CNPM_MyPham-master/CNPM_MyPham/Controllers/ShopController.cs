using CNPM_MyPham.Models;
using Infrastructure.Persistence;
using Domain.Entities;
using Microsoft.AspNetCore.Mvc;
using Infrastructure;
using Domain.Interfaces;
using Application.Services;
using Application.DTOs;
using Application.DTOs.CurrentUserDTO;

namespace CNPM_MyPham.Controllers
{
    public class ShopController : Controller
    {
        private readonly LoaiSanPhamService LSPservice;
        private readonly ThuongHieuService THservice;
        private readonly SanPhamService SPservice;
        public ShopController(LoaiSanPhamService LSPservice, ThuongHieuService THservice, SanPhamService SPservice){
            this.LSPservice = LSPservice;
            this.THservice = THservice;
            this.SPservice = SPservice;
        }

        public IActionResult Index(string Type, string Brand, string SearchString, string sort, string price, int pageIndex = 1)
        {
            View_Chung();
            //var listSP = SPcontext.SanPham_GetAll();

            int pageSize = 9;
            int Range  = 9;
            int count;
            decimal pricemax;
            string NameType;
            if(!string.IsNullOrEmpty(Type)){
                NameType = LSPservice.LoaiSanPham_GetById(int.Parse(Type)).name;
                SearchString = null;
            }
            else{
                NameType = null;
            }
             
            var SanPhams = SPservice.SanPham_Filter(Type, Brand, SearchString, sort, pageIndex, pageSize, out count, out pricemax, price);
            var indexVSM = new IndexViewShopModel()
            {
                ListSP = new PaginatedList<SanPhamDto>(SanPhams, count, pageIndex, pageSize),
                ListTH = THservice.ThuongHieu_GetAll(),
                ListLSP = LSPservice.LoaiSanPham_GetAll(),
                Type = Type,
                NameType = NameType,
                Brand = Brand,
                SearchString = SearchString,
                sort = sort,
                pricemax = pricemax,
                price = price,
                pageSize = pageSize,
                count = count,
                Range = Range
            };
            return View(indexVSM);
        }

        [HttpPost]
        public IActionResult ShopThemSPAjax(int idsp){
            var sp = SPservice.SanPham_GetById(idsp);
            var spfordonhang = new SPForDonHangDto(sp, 1);
            var currentuser = SessionHelper.GetObjectFromJson<CurrentUserDto>(HttpContext.Session, "CurrentUser");
            if(currentuser != null){
                var t = currentuser.DonHangDto.searchIDSP(idsp);
                if(t){
                    currentuser.DonHangDto.addonesoluongforsanpham(idsp);
                }
                else{
                    currentuser.DonHangDto.ListSP.Add(spfordonhang);
                }
                SessionHelper.SetObjectAsJson(HttpContext.Session, "CurrentUser", currentuser);
                return new JsonResult("Đã thêm sản phẩm");
            }
            var donhang = SessionHelper.GetObjectFromJson<DonHangDto>(HttpContext.Session, "DonHang");
            if(donhang == null){
                donhang = new DonHangDto();
            }
            var tdh = donhang.searchIDSP(idsp);
            if(tdh){
                donhang.addonesoluongforsanpham(idsp);
            }
            else{
                donhang.ListSP.Add(spfordonhang);
            }
            SessionHelper.SetObjectAsJson(HttpContext.Session, "DonHang", donhang);
            if(donhang == null){
                return new JsonResult(null);
            }
            return new JsonResult("Đã thêm sản phẩm");
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