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
    public class NCCController : Controller
    {
        private readonly NCCService NCCservice;
        private readonly QuyenService Qservice;
        public NCCController(NCCService NCCservice, QuyenService Qservice)
        {
            this.NCCservice = NCCservice;
            this.Qservice = Qservice;
        }
        public IActionResult Index()
        {
            if(!ViewChung()){
                return Redirect("/Admin/Login/Index");
            }
            var IndexNCC = new IndexViewNCCModel();
            IndexNCC.ListNCC = NCCservice.NCC_GetAll();
            IndexNCC.QUser = Qservice.Quyen_GetById(ViewBag.CurrentUserAdmin.permission_id);

            if(!IndexNCC.QUser.details.Contains("NCC")){
                return Redirect("/Admin/User/Index");
            }
            return View(IndexNCC);
        }

        [HttpPost]
        public IActionResult RemoveNCC(int ncc_id){
            var ncc = NCCservice.NCC_GetById(ncc_id);
            ncc.status = 0;
            NCCservice.NCC_Update(ncc);
            return new JsonResult("ok");
        }

        [HttpPost]
        public IActionResult BackNCC(int ncc_id){
            var ncc = NCCservice.NCC_GetById(ncc_id);
            ncc.status = 1;
            NCCservice.NCC_Update(ncc);
            return new JsonResult("ok");
        }

        [HttpPost]
        public IActionResult EditNCC(int ncc_id)
        {
            var ncc = NCCservice.NCC_GetById(ncc_id);
            if(ncc == null){
                return new JsonResult(-1);
            }
            return new JsonResult(ncc);
        }

        [HttpPost]
        public IActionResult SubmitEditNCC(int ncc_id, string name)
        {
            int status = NCCservice.NCC_GetById(ncc_id).status;
            var ncc = new NCCDto(ncc_id, name, status);
            NCCservice.NCC_Update(ncc);
            return new JsonResult(1);
        }
        [HttpPost]
        public IActionResult TimKiem(string type, string input){
            if(String.IsNullOrEmpty(input)){
                input = "";
            }
            IEnumerable<NCCDto> nccs = NCCservice.NCC_AdminTimKiem(type, input);
            if(nccs != null){
                return new JsonResult(nccs);
            }
            return new JsonResult(-1);
        }

        [HttpPost]
        public IActionResult SubmitThemNCC(int ncc_id, string name)
        {
            var NCC = new NCCDto(ncc_id, name, 1);
            NCCservice.NCC_Add(NCC);
            return new JsonResult(1);
        }

        [HttpPost]
        public IActionResult MaxNCC_ID(){
            return new JsonResult(NCCservice.NCC_GetMaxId() + 1);
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
