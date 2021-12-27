using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Application.DTOs;
using Application.Services;
using CNPM_MyPham.Models;
using Microsoft.AspNetCore.Mvc;

namespace CNPM_MyPham.Areas.Admin.Controllers
{
    [Area("Admin")]
    public class LoginController : Controller
    {
        private readonly NhanVienService NVservice;
        public LoginController(NhanVienService NVservice)
        {
            this.NVservice = NVservice;
            ViewBag.controller = "Login";
        }
        public IActionResult Index()
        {
            return View();
        }

        [HttpPost]
        public IActionResult Index(LoginModelDto lg){
            if(ModelState.IsValid){
                var NV = NVservice.NhanVien_GetByUser(lg.user);
                if(NV == null){
                    ModelState.AddModelError("", "Tài khoản không tồn tại!");
                    return View(lg);
                }

                if(NV.pass != lg.pass){
                    ModelState.AddModelError("", "Mật khẩu sai!");
                    return View(lg);
                }

                NV.pass = "";
                NV.repass = "";
                SessionHelper.SetObjectAsJson(HttpContext.Session, "CurrentUserAdmin", NV);
                return Redirect("/Admin/User/Index");
            }
            return View();
        }
    }
}
