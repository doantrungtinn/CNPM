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
    public class BrandController : Controller
    {
        private readonly ThuongHieuService THservice;
        private readonly QuyenService Qservice;
        private readonly SanPhamService SPservice;
        public BrandController(ThuongHieuService THservice, QuyenService Qservice, SanPhamService SPservice){
            this.THservice = THservice;
            this.Qservice = Qservice;
            this.SPservice = SPservice;
        }
        public IActionResult Index()
        {
            if(!ViewChung()){
                return Redirect("/Admin/Login/Index");
            }
            var indexmodel = new IndexViewBrandModel();
            indexmodel.ListTH = THservice.ThuongHieu_GetAll();
            indexmodel.QUser = Qservice.Quyen_GetById(ViewBag.CurrentUserAdmin.permission_id);

            if(!indexmodel.QUser.details.Contains("ThuongHieu")){
                return Redirect("/Admin/User/Index");
            }
            return View(indexmodel);
        }
        [HttpPost]
        public IActionResult TimKiem(string type, string input){
            if(String.IsNullOrEmpty(input)){
                input = "";
            }
            IEnumerable<ThuongHieuDto> ths = THservice.ThuongHieu_AdminTimKiem(type, input);
            if(ths != null){
                return new JsonResult(ths);
            }
            return new JsonResult(-1);
        }

        [HttpPost]
        public IActionResult EditBrand(int brand_id){
            var TH = THservice.ThuongHieu_GetById(brand_id);
            if(TH == null)
            {
                return new JsonResult(-1);
            }
            return new JsonResult(TH);
        }

        [HttpPost]
        public IActionResult SubmitEditTH(int brand_id, string name)
        {
            var TH = new ThuongHieuDto(brand_id, name);
            THservice.ThuongHieu_Update(TH);
            return new JsonResult(1);
        }
        [HttpPost]
        public IActionResult RemoveTH(int brand_id)
        {
            SPservice.SanPham_RemoveBy_Brand_Id(brand_id);
            THservice.ThuongHieu_Remove(brand_id);
            return new JsonResult("ok");
        }
        [HttpPost]
        public IActionResult SubmitThemTH(int brand_id, string name)
        {
            var TH = new ThuongHieuDto(brand_id, name);
            THservice.ThuongHieu_Add(TH);
            return new JsonResult(1);
        }
        [HttpPost]
        public IActionResult MaxBrand_ID(){
            return new JsonResult(THservice.ThuongHieu_GetMaxId() + 1);
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
