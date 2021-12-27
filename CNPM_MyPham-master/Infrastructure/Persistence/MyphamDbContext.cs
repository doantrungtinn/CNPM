using Domain.Entities;
using Microsoft.EntityFrameworkCore;

namespace Infrastructure.Persistence
{
    public class MyphamDbContext : DbContext
    {
        public MyphamDbContext(DbContextOptions<MyphamDbContext> options) : base(options){

        }

        public DbSet<KhachHang> KhachHangs{get; set;}

        public DbSet<LoaiSanPham> LoaiSanPhams {get; set;}

        public DbSet<SanPham> SanPhams {get; set;}

        public DbSet<ThuongHieu> ThuongHieus {get; set;}
        
        public DbSet<Quyen> Quyens { get; set;}

        public DbSet<NhanVien> NhanViens { get; set;}
        public DbSet<NCC> NCCs { get; set;}
        public DbSet<HoaDon> HoaDons { get; set;}
        public DbSet<ChiTietHoaDon> ChiTietHoaDons { get; set;}

        // public DbSet<ThuongHieuAndSanPham> ThuongHieuAndSanPhams {get; set;}

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            // modelBuilder.Entity<ThuongHieuAndSanPham>()
            //     .HasKey(o => new { o.brand_id, o.product_id });
            modelBuilder.Entity<ChiTietHoaDon>()
                .HasKey(o => new { o.bill_id, o.product_id });
        }
    }
}