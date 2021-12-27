using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Application.DTOs;
using Application.Services;
using CNPM_MyPham.Areas.Admin.Models;
using CNPM_MyPham.Models;
using Microsoft.AspNetCore.Mvc;

namespace CNPM_MyPham.Areas.Admin.Controllers
{
    [Area("Admin")]
    public class TypeController : Controller
    {
        private readonly LoaiSanPhamService LSPservice;
        private readonly SanPhamService SPservice;
        private readonly QuyenService Qservice;
        public TypeController(LoaiSanPhamService LSPservice, SanPhamService SPservice, QuyenService Qservice)
        {
            this.LSPservice = LSPservice;
            this.SPservice = SPservice;
            this.Qservice = Qservice;
        }
        public IActionResult Index()
        {
            if(!ViewChung()){
                return Redirect("/Admin/Login/Index");
            }
            var IndexType = new IndexViewTypeModel();
            IndexType.ListLSP = LSPservice.LoaiSanPham_GetAll();
            IndexType.QUser = Qservice.Quyen_GetById(ViewBag.CurrentUserAdmin.permission_id);

            if(!IndexType.QUser.details.Contains("LoaiSanPham")){
                return Redirect("/Admin/User/Index");
            }
            return View(IndexType);
        }

        [HttpPost]
        public IActionResult EditLSP(int product_type_id)
        {
            var LSP = LSPservice.LoaiSanPham_GetById(product_type_id);
            if(LSP == null)
            {
                return new JsonResult(-1);
            }
            return new JsonResult(LSP);
        }

        [HttpPost]
        public IActionResult SubmitEditLSP(int product_type_id, string name, string description)
        {
            var LSP = new LoaiSanPhamDto(product_type_id, name, description);
            LSPservice.SanPham_Update(LSP);
            return new JsonResult(1);
        }

        [HttpPost]
        public IActionResult SubmitThemLSP(int product_type_id, string name, string description)
        {
            var LSP = new LoaiSanPhamDto(product_type_id, name, description);
            LSPservice.LoaiSanPham_Add(LSP);
            return new JsonResult(1);
        }

        [HttpPost]
        public IActionResult RemoveLSP(int product_type_id)
        {
            SPservice.SanPham_RemoveBy_Product_Type_Id(product_type_id);
            LSPservice.LoaiSanPham_Remove(product_type_id);
            return new JsonResult("ok");
        }
        [HttpPost]
        public IActionResult TimKiem(string type, string input){
            if(String.IsNullOrEmpty(input)){
                input = "";
            }
            IEnumerable<LoaiSanPhamDto> lsps = LSPservice.LoaiSanPham_AdminTimKiem(type, input);
            if(lsps != null){
                return new JsonResult(lsps);
            }
            return new JsonResult(-1);
        }
        [HttpPost]
        public IActionResult MaxProduct_Type_ID(){
            return new JsonResult(LSPservice.LoaiSanPham_GetMaxId() + 1);
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
