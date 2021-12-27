using System.Collections.Generic;
using Domain.Entities;

namespace CNPM_MyPham.Models
{
    public class DonHang
    {
        public KhachHang KH{get; set;}

        public List<SanPham> ListSP{get; set;}

        public decimal totalprice{get; set;}

        public int total{get; set;}

        public DonHang(){
            KH = null;
            ListSP = new List<SanPham>();
            totalprice = 0;
            total = 0;
        }

        public void resetTotalPrice(){
            decimal res = 0;
            foreach(SanPham q in ListSP){
                res += q.amount * q.price;
            }
            this.totalprice = res;
        }

        public bool KiemTraSP(SanPham sp){
            foreach(SanPham q in ListSP){
                if(q.product_id == sp.product_id){
                    return true;
                }
            }
            return false;
        }

        public void TangSLForSP(SanPham sp){
            foreach(SanPham q in ListSP){
                if(q.product_id == sp.product_id){
                    q.amount++;
                    resetTotalPrice();
                    break;
                }
            }
        }

        public void GiamSLForSP(SanPham sp){
            foreach(SanPham q in ListSP){
                if(q.product_id == sp.product_id){
                    q.amount--;
                    resetTotalPrice();
                    break;
                }
            }
        }

        public void UpdateSLForSP(SanPham sp, int sl){
            foreach(SanPham q in ListSP){
                if(q.product_id == sp.product_id){
                    q.amount = sl;
                    resetTotalPrice();
                    break;
                }
            }
        }
    }
}