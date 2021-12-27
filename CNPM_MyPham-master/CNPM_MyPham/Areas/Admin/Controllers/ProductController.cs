using System;
using System.Collections.Generic;
using System.IO;
using Application.DTOs;
using Application.Services;
using CNPM_MyPham.Areas.Admin.Models;
using CNPM_MyPham.Models;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace CNPM_MyPham.Areas.Admin.Controllers
{
    [Area("Admin")]
    public class ProductController : Controller
    {
        private readonly SanPhamService SPservice;
        private readonly ThuongHieuService THservice;
        private readonly LoaiSanPhamService LSPservice;
        private readonly QuyenService Qservice;
        private readonly IHostingEnvironment hostingEnvironment;
        public ProductController(SanPhamService SPservice, ThuongHieuService THservice, LoaiSanPhamService LSPservice,
        QuyenService Qservice, IHostingEnvironment hostingEnvironment)
        {
            this.SPservice = SPservice;
            this.THservice = THservice;
            this.LSPservice = LSPservice;
            this.Qservice = Qservice;
            this.hostingEnvironment = hostingEnvironment;
        }

        public IActionResult Index()
        {
            if(!ViewChung()){
                return Redirect("/Admin/Login/Index");
            }
            
            var IndexProduct = new IndexViewProductModel();
            IndexProduct.ListSP = SPservice.SanPham_GetAll();
            IndexProduct.ListTH = THservice.ThuongHieu_GetAll();
            IndexProduct.ListLSP = LSPservice.LoaiSanPham_GetAll();
            IndexProduct.QUser = Qservice.Quyen_GetById(ViewBag.CurrentUserAdmin.permission_id);

            if(!IndexProduct.QUser.details.Contains("SanPham")){
                return Redirect("/Admin/User/Index");
            }
            return View(IndexProduct);
        }

        [HttpPost]
        public IActionResult RemoveSP(int product_id)
        {
            //SPservice.SanPham_Remove(product_id);
            var SP = SPservice.SanPham_GetById(product_id);
            SP.status = 0;
            SPservice.SanPham_Update(SP);
            return new JsonResult("ok");
        }

        [HttpPost]
        public IActionResult BackSP(int product_id)
        {
            //SPservice.SanPham_Remove(product_id);
            var SP = SPservice.SanPham_GetById(product_id);
            SP.status = 1;
            SPservice.SanPham_Update(SP);
            return new JsonResult("ok");
        }
        [HttpPost]
        public IActionResult EditSP(int product_id)
        {
            var SP = SPservice.SanPham_GetById(product_id);
            if(SP == null){
                return new JsonResult(-1);
            }
            return new JsonResult(SP);
        }
        [HttpPost]
        public IActionResult TimKiem(string type, string input){
            if(String.IsNullOrEmpty(input)){
                input = "";
            }
            IEnumerable<SanPhamDto> sps = SPservice.SanPhams_AdminTimKiem(type, input);
            if(sps != null){
                return new JsonResult(sps);
            }
            return new JsonResult(-1);
        }
        [HttpPost]
        public IActionResult SubmitEditLSP(IFormFile photo){
            string uniqueFileName = null;
            if(photo != null){
                string uploadFolder = Path.Combine(hostingEnvironment.WebRootPath, "image");
                uniqueFileName = Guid.NewGuid().ToString() + "_" + photo.FileName;
                string filePath = Path.Combine(uploadFolder, uniqueFileName);
                photo.CopyTo(new FileStream(filePath, FileMode.Create));
                return new JsonResult(1);
            }
            return new JsonResult(-1);
        }
        public bool ViewChung(){
            ViewBag.CurrentUserAdmin = SessionHelper.GetObjectFromJson<NhanVienDto>(HttpContext.Session, "CurrentUserAdmin");
            
            if(ViewBag.CurrentUserAdmin == null){
                return false;
            }
            ViewBag.QuyenCurrentUserAdmin = Qservice.Quyen_GetById(ViewBag.CurrentUserAdmin.permission_id);
            return true;
        }
    }
}