using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.HttpsPolicy;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;
using Infrastructure.Persistence;
using CNPM_MyPham.Models;
using Domain.Interfaces;
using Application.Services;

namespace CNPM_MyPham
{
    public class Startup
    {
        public Startup(IConfiguration configuration)
        {
            Configuration = configuration;
        }

        public IConfiguration Configuration { get; }

        // This method gets called by the runtime. Use this method to add services to the container.
        public void ConfigureServices(IServiceCollection services)
        {
            services.AddControllersWithViews();

            // Thêm dịch vụ Session
            services.AddSession();

            services.AddDbContext<MyphamDbContext>(options => 
                options.UseSqlite(Configuration.GetConnectionString("Default")));
            
            services.AddScoped<IKhachHangEFcontext, KhachHangEFContext>();
            services.AddScoped<KhachHangService>();
            services.AddScoped<ILoaiSanPhamEFContext, LoaiSanPhamEFContext>();
            services.AddScoped<LoaiSanPhamService>();
            services.AddScoped<ISanPhamEFContext, SanPhamEFContext>();
            services.AddScoped<SanPhamService>();
            services.AddScoped<IThuongHieuEFContext, ThuongHieuEFContext>();
            services.AddScoped<ThuongHieuService>();
            services.AddScoped<IQuyenEFContext, QuyenEFContext>();
            services.AddScoped<QuyenService>();
            services.AddScoped<INhanVienEFContext, NhanVienEFContext>();
            services.AddScoped<NhanVienService>();
            services.AddScoped<INCCEFContext, NCCEFContext>();
            services.AddScoped<NCCService>();
            services.AddScoped<IHoaDonEFContext, HoaDonEFContext>();
            services.AddScoped<HoaDonService>();
            services.AddScoped<IChiTietHoaDonEFContext, ChiTietHoaDonEFContext>();
            services.AddScoped<ChiTietHoaDonService>();
        }

        // This method gets called by the runtime. Use this method to configure the HTTP request pipeline.
        public void Configure(IApplicationBuilder app, IWebHostEnvironment env)
        {
            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
            }
            else
            {
                app.UseExceptionHandler("/Home/Error");
                // The default HSTS value is 30 days. You may want to change this for production scenarios, see https://aka.ms/aspnetcore-hsts.
                app.UseHsts();
            }
            app.UseHttpsRedirection();
            app.UseStaticFiles();

            app.UseRouting();

            app.UseAuthorization();

            //  Sử dụng service Session
            app.UseSession();

            app.UseEndpoints(endpoints =>
            {
                endpoints.MapControllerRoute(
                    name: "default",
                    pattern: "{controller=Shop}/{action=Index}/{id?}"
                );
                endpoints.MapControllerRoute(
                    name: "areas",
                    pattern: "{area:exists}/{controller=Login}/{action=Index}/{id?}"
                );
            });
        }
    }
}
