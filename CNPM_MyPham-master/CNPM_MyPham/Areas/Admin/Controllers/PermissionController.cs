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
    public class PermissionController : Controller
    {
        private readonly QuyenService Qservice;
        public PermissionController(QuyenService Qservice){
            this.Qservice = Qservice;
        }
        public IActionResult Index()
        {
            if(!ViewChung()){
                return Redirect("/Admin/Login/Index");
            }
            var IndexQuyen = new IndexViewQuyenModel();
            IndexQuyen.ListQ = Qservice.Quyen_GetAll();
            IndexQuyen.QUser = Qservice.Quyen_GetById(ViewBag.CurrentUserAdmin.permission_id);

            if(!IndexQuyen.QUser.details.Contains("Quyen")){
                return Redirect("/Admin/User/Index");
            }
            return View(IndexQuyen);
        }
        [HttpPost]
        public IActionResult TimKiem(string type, string input){
            if(String.IsNullOrEmpty(input)){
                input = "";
            }
            IEnumerable<QuyenDto> qs = Qservice.Quyen_AdminTimKiem(type, input);
            if(qs != null){
                return new JsonResult(qs);
            }
            return new JsonResult(-1);
        }
        [HttpPost]
        public IActionResult EditQuyen(int permission_id)
        {
            var Quyen = Qservice.Quyen_GetById(permission_id);
            if(Quyen == null)
            {
                return new JsonResult(-1);
            }
            return new JsonResult(Quyen);
        }

        [HttpPost]
        public IActionResult SubmitEditQuyen(int permission_id, string name, string details)
        {
            var Q = new QuyenDto(permission_id, name, details);
            Qservice.Quyen_Update(Q);
            return new JsonResult(1);
        }
        [HttpPost]
        public IActionResult MaxPermission_ID(){
            return new JsonResult(Qservice.Quyen_GetMaxId() + 1);
        }

        [HttpPost]
        public IActionResult SubmitThemQuyen(int permission_id, string name, string details)
        {
            var Q = new QuyenDto(permission_id, name, details);
            Qservice.Quyen_Add(Q);
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
