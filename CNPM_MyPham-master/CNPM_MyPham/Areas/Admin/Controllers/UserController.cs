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
    public class UserController : Controller
    {
        private readonly QuyenService Qservice;
        
        private readonly NhanVienService NVservice;        
        public UserController(QuyenService Qservice, NhanVienService NVservice)
        {
            this.Qservice = Qservice;
            this.NVservice = NVservice;
          }
        public IActionResult Index()
        {
            if(!ViewChung()){
                return Redirect("/Admin/Login/Index");
            }
            var IndexView = new IndexViewUserModel();
            IndexView.NV = NVservice.NhanVien_GetByUser(ViewBag.CurrentUserAdmin.user);
            IndexView.Q = Qservice.Quyen_GetById(IndexView.NV.permission_id);
            IndexView.QUser = Qservice.Quyen_GetById(ViewBag.CurrentUserAdmin.permission_id);
            return View(IndexView);
        }
        [HttpPost]
        public IActionResult Index(IndexViewUserModel IndexView){
            if(!ViewChung()){
                return Redirect("/Admin/Login/Index");
            }
            if(ModelState.IsValid){
                NhanVienDto nv = NVservice.NhanVien_GetByUser(IndexView.NV.user);
                if(nv == null){
                    NVservice.NhanVien_Update(nv);
                    SessionHelper.SetObjectAsJson(HttpContext.Session, "CurrentUserAdmin", nv);
                    var index = new IndexViewUserModel();
                    index.NV = NVservice.NhanVien_GetByUser(ViewBag.CurrentUserAdmin.user);
                    index.Q = Qservice.Quyen_GetById(index.NV.permission_id);
                    return View(index);
                }
                ModelState.AddModelError("", "Tài khoản đã tồn tại!");
            }
            IndexView.Q = Qservice.Quyen_GetById(IndexView.NV.permission_id);
            return View(IndexView);
        }
        [HttpPost]
        public IActionResult DangXuat(){
            SessionHelper.SetObjectAsJson(HttpContext.Session, "CurrentUserAdmin", null);
            return new JsonResult(1);
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
