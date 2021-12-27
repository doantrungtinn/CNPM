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
    public class StaffController : Controller
    {
        private readonly NhanVienService NVservice;
        private readonly QuyenService Qservice;
        public StaffController(NhanVienService NVservice, QuyenService Qservice){
            this.NVservice = NVservice;
            this.Qservice = Qservice;
        }
        public IActionResult Index()
        {
            if(!ViewChung()){
                return Redirect("/Admin/Login/Index");
            }
            var IndexView = new IndexViewNhanVienModel();
            IndexView.ListNV = NVservice.NhanVien_GetAll();
            IndexView.ListQ = Qservice.Quyen_GetAll();
            IndexView.QUser = Qservice.Quyen_GetById(ViewBag.CurrentUserAdmin.permission_id);

            if(!IndexView.QUser.details.Contains("NhanVien")){
                return Redirect("/Admin/User/Index");
            }
            return View(IndexView);
        }
        [HttpPost]
        public IActionResult TimKiem(string type, string input){
            if(String.IsNullOrEmpty(input)){
                input = "";
            }
            IEnumerable<NhanVienDto> nvs = NVservice.NhanVien_AdminTimKiem(type, input);
            if(nvs != null){
                return new JsonResult(nvs);
            }
            return new JsonResult(-1);
        }
        [HttpPost]
        public IActionResult EditNV(string user)
        {
            var NV = NVservice.NhanVien_GetByUser(user);
            if(NV == null)
            {
                return new JsonResult(-1);
            }
            return new JsonResult(NV);
        }
        [HttpPost]
        public IActionResult SubmitEditNV(string user, string pass, string repass, string full_name, string phone, string mail,
        string address, string sex, DateTime dateborn, int permission_id)
        {
            if(pass != repass){
                return new JsonResult(-1);
            }
            int status = NVservice.NhanVien_GetByUser(user).status;
            var NV = new NhanVienDto(user, pass, repass, full_name, phone, mail, address, sex, dateborn, permission_id, status);
            NVservice.NhanVien_Update(NV);
            return new JsonResult(1);
        }

        [HttpPost]
        public IActionResult SubmitThemNV(string user, string pass, string repass, string full_name, string phone, string mail,
        string address, string sex, DateTime dateborn, int permission_id)
        {
            if(pass != repass){
                return new JsonResult(-1);
            }
            var NV = new NhanVienDto(user, pass, repass, full_name, phone, mail, address, sex, dateborn, permission_id, 1);
            NVservice.NhanVien_Add(NV);
            return new JsonResult(1);
        }

        [HttpPost]
        public IActionResult RemoveNV(string user)
        {
            //NVservice.SanPham_Remove(user);
            var NV = NVservice.NhanVien_GetByUser(user);
            NV.status = 0;
            NVservice.NhanVien_Update(NV);
            return new JsonResult("ok");
        }

        [HttpPost]
        public IActionResult BackNV(string user)
        {
            //NVservice.SanPham_Remove(user);
            var NV = NVservice.NhanVien_GetByUser(user);
            NV.status = 1;
            NVservice.NhanVien_Update(NV);
            return new JsonResult("ok");
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
