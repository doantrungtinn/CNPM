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
    public class CustomerController : Controller
    {
        private readonly KhachHangService KHservice;
        private readonly QuyenService Qservice;
        public CustomerController(KhachHangService KHservice, QuyenService Qservice){
            this.KHservice = KHservice;
            this.Qservice = Qservice;
        }
        public IActionResult Index()
        {
            if(!ViewChung()){
                return Redirect("/Admin/Login/Index");
            }
            var IndexView = new IndexViewKhachHangModel();
            IndexView.ListKH = KHservice.KhachHang_GetAll();
            IndexView.QUser = Qservice.Quyen_GetById(ViewBag.CurrentUserAdmin.permission_id);

            if(!IndexView.QUser.details.Contains("KhachHang")){
                return Redirect("/Admin/User/Index");
            }
            return View(IndexView);
        }
        [HttpPost]
        public IActionResult TimKiem(string type, string input){
            if(String.IsNullOrEmpty(input)){
                input = "";
            }
            IEnumerable<KhachHangDto> khs = KHservice.KhachHang_AdminTimKiem(type, input);
            if(khs != null){
                return new JsonResult(khs);
            }
            return new JsonResult(-1);
        }

        [HttpPost]
        public IActionResult EditKH(string user)
        {
            var KH = KHservice.KhachHang_GetByUser(user);
            if(KH == null)
            {
                return new JsonResult(-1);
            }
            return new JsonResult(KH);
        }
        [HttpPost]
        public IActionResult SubmitEditKH(string user, string pass, string repass, string full_name, string phone, string mail,
        string address, string sex, DateTime dateborn)
        {
            if(pass != repass){
                return new JsonResult(-1);
            }
            int status = KHservice.KhachHang_GetByUser(user).status;
            var KH = new KhachHangDto(user, pass, repass, full_name, phone, mail, address, sex, dateborn, status);
            KHservice.KhachHang_Update(KH);
            return new JsonResult(1);
        }

        [HttpPost]
        public IActionResult RemoveKH(string user)
        {
            var KH = KHservice.KhachHang_GetByUser(user);
            KH.status = 0;
            KHservice.KhachHang_Update(KH);
            return new JsonResult("ok");
        }

        [HttpPost]
        public IActionResult BackKH(string user)
        {
            var KH = KHservice.KhachHang_GetByUser(user);
            KH.status = 1;
            KHservice.KhachHang_Update(KH);
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
