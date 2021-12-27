using System;
using System.Collections.Generic;
using System.Linq;
using Domain.Entities;

namespace Infrastructure.Persistence
{
    public class SeedData
    {
        public static void Initialize(MyphamDbContext context){
            context.Database.EnsureCreated();
            bool temp = false;
            if(!context.HoaDons.Any()){
                temp = true;
                context.HoaDons.AddRange(new List<HoaDon>{
                    new HoaDon{
                        bill_id = 1,
                        user_kh = "thien",
                        user_nv = "bh01",
                        phone = "0364117408",
                        address = "Bình Định",
                        date_receice = new System.DateTime(2020, 5, 8, 5, 4, 6),
                        date_order = new System.DateTime(2020, 5, 18, 5, 4, 6),
                        total = 1055000,
                        status = 3
                    },
                    new HoaDon{
                        bill_id = 2,
                        user_kh = "thinh",
                        user_nv = "",
                        phone = "0364117408",
                        address = "Miền Tây",
                        date_receice = null,
                        date_order = new System.DateTime(2020, 5, 18, 5, 4, 6),
                        total = 1125000,
                        status = 2
                    },
                    new HoaDon{
                        bill_id = 3,
                        user_kh = "phat",
                        user_nv = "",
                        phone = "0364117408",
                        address = "Bình Dương",
                        date_receice = null,
                        date_order = new System.DateTime(2020, 5, 18, 5, 4, 6),
                        total = 669000,
                        status = 1
                    }
                });
            }
            if(!context.ChiTietHoaDons.Any()){
                temp = true;
                context.ChiTietHoaDons.AddRange(new List<ChiTietHoaDon>{
                    new ChiTietHoaDon{
                        bill_id = 1,
                        product_id = 1,
                        name = "Lustre Eyeshadow Base",
                        amount = 1,
                        price = 200000,
                        img = "/image/sp0.jpg"
                    },
                    new ChiTietHoaDon{
                        bill_id = 1,
                        product_id = 2,
                        name = "GOLDEN ROSE EYESHADOW PRIMER",
                        amount = 1,
                        price = 167000,
                        img = "/image/sp1.jpg"
                    },
                    new ChiTietHoaDon{
                        bill_id = 1,
                        product_id = 5,
                        name = "BH Cosmetics Solar Flare",
                        amount = 1,
                        price = 688000,
                        img = "/image/sp4.jpg"
                    },
                    new ChiTietHoaDon{
                        bill_id = 2,
                        product_id = 5,
                        name = "BH Cosmetics Solar Flare",
                        amount = 1,
                        price = 688000,
                        img = "/image/sp4.jpg"
                    },
                    new ChiTietHoaDon{
                        bill_id = 2,
                        product_id = 6,
                        name = "BH Cosmetics Mini Zodiac",
                        amount = 1,
                        price = 437000,
                        img = "/image/sp5.jpg"
                    },
                    new ChiTietHoaDon{
                        bill_id = 3,
                        product_id = 7,
                        name = "BH Cosmetics Blushing In Bali",
                        amount = 1,
                        price = 669000,
                        img = "/image/sp5.jpg"
                    }
                });
            }
            if(!context.NCCs.Any()){
                temp = true;
                context.NCCs.AddRange(new List<NCC>{
                    new NCC{
                        ncc_id = 1,
                        name = "Cty Bình Thạnh",
                        status = 1,
                    },
                    new NCC{
                        ncc_id = 2,
                        name = "Cty Thủ Đức",
                        status = 1,
                    },
                    new NCC{
                        ncc_id = 3,
                        name = "Cty Quận 5",
                        status = 1,
                    },
                    new NCC{
                        ncc_id = 4,
                        name = "Cty Quận 1",
                        status = 1
                    }
                });
            }
            if(!context.Quyens.Any()){
                temp = true;
                context.Quyens.AddRange(new List<Quyen>{
                    new Quyen{
                        permission_id = 1,
                        name = "Admin",
                        details = "qlNhapHang-qlNhanVien-qlSanPham-qlHoaDon-qlKhachHang-qlPhieuNhap-qlNCC-qlTaiKhoan-qlQuyen-qlThongKe-qlLoaiSanPham-qlThuongHieu"
                    },
                    new Quyen{
                        permission_id = 2,
                        name = "Quản lý",
                        details = "qlNhanVien-xemSanPham-xemHoaDon-qlKhachHang-xemPhieuNhap-xemNCC-qlTaiKhoan-qlThongKe-qlLoaiSanPham-qlThuongHieu"
                    },
                    new Quyen{
                        permission_id = 3,
                        name = "Nhân viên bán hàng",
                        details = "xemSanPham-qlHoaDon-xemKhachHang-qlThongKe-xemThuongHieu"
                    },
                    new Quyen{
                        permission_id = 4,
                        name = "Nhân viên nhập hàng",
                        details = "qlNhapHang-qlSanPham-qlPhieuNhap-qlNCC-qlThongKe-qlLoaiSanPham-qlThuongHieu"
                    }
                });
            }
            if(!context.NhanViens.Any()){
                temp = true;
                context.NhanViens.AddRange(new List<NhanVien>{
                    new NhanVien{
                        user = "admin",
                        pass = "admin",
                        repass = "1234",
                        full_name = "Nguyễn Ngọc Thiện",
                        phone = "0364117408",
                        mail = "tructruong.070202@gmail.com",
                        address = "Bình Định",
                        sex = "Nam",
                        dateborn = new System.DateTime(2000, 5, 8),
                        permission_id = 1,
                        status = 1
                    },
                    new NhanVien{
                        user = "ql01",
                        pass = "ql01",
                        repass = "ql01",
                        full_name = "Nguyễn Tấn Thông",
                        phone = "0364117408",
                        mail = "tanthong@gmail.com",
                        address = "Hồ Chí Minh",
                        sex = "Nam",
                        dateborn = new System.DateTime(2000, 5, 8),
                        permission_id = 2,
                        status = 1
                    },
                    new NhanVien{
                        user = "bh01",
                        pass = "bh01",
                        repass = "bh01",
                        full_name = "Cung Xương Hồng Thiên",
                        phone = "0364117408",
                        mail = "cungthien@gmail.com",
                        address = "Hồ Chí Minh",
                        sex = "Nam",
                        dateborn = new System.DateTime(2000, 5, 8),
                        permission_id = 3,
                        status = 1
                    },
                    new NhanVien{
                        user = "nh01",
                        pass = "nh01",
                        repass = "nh01",
                        full_name = "Nguyễn Tuyến Đạt",
                        phone = "0364117408",
                        mail = "tuyendat@gmail.com",
                        address = "Hồ Chí Minh",
                        sex = "Nam",
                        dateborn = new System.DateTime(2000, 5, 8),
                        permission_id = 2,
                        status = 1
                    }
                });
            }
            if(!context.KhachHangs.Any()){
                temp = true;
                context.KhachHangs.AddRange(new List<KhachHang>{
                    new KhachHang{
                        user = "thien",
                        pass = "1234",
                        repass = "1234",
                        full_name = "Nguyễn Ngọc Thiện",
                        phone = "0364117408",
                        mail = "tructruong.070202@gmail.com",
                        address = "Bình Định",
                        sex = "Nam",
                        dateborn = new System.DateTime(2000, 5, 8),
                        status = 1
                    },
                    new KhachHang{
                        user = "thinh",
                        pass = "1234",
                        repass = "1234",
                        full_name = "Nguyễn Ngọc Thịnh",
                        phone = "0364117408",
                        mail = "thinh@gmail.com",
                        address = "Miền Tây",
                        sex = "Nam",
                        dateborn = new System.DateTime(2000, 5, 8),
                        status = 1
                    },
                    new KhachHang{
                        user = "phat",
                        pass = "1234",
                        repass = "1234",
                        full_name = "Nguyễn Tấn Phát",
                        phone = "0364117408",
                        mail = "phatxam@gmail.com",
                        address = "Bình Dương",
                        sex = "Nam",
                        dateborn = new System.DateTime(2000, 5, 8),
                        status = 1
                    }
                });
            }

            if(!context.LoaiSanPhams.Any()){
                temp = true;
                context.LoaiSanPhams.AddRange(new List<LoaiSanPham>{
                    new LoaiSanPham{
                        product_type_id = 1,
                        name = "Trang điểm",
                        description = "Gồm set trang điểm mắt, mặt, môi"
                    },
                    new LoaiSanPham{
                        product_type_id = 2,
                        name = "Dưỡng da",
                        description = "Gồm bộ rửa mặt, mặt nạ, dưỡng ẩm, dưỡng môi, chống nắng"
                    },
                    new LoaiSanPham{
                        product_type_id = 3,
                        name = "Cơ thể",
                        description = "Gồm dưỡng thể, sữa tắm"
                    },
                    new LoaiSanPham{
                        product_type_id = 4,
                        name = "Dưỡng tóc",
                        description = "Gồm dầu gội, dầu xả, tạo kiểu, dưỡng tóc"
                    },
                    new LoaiSanPham{
                        product_type_id = 5,
                        name = "Cọ và phụ kiện",
                        description = "Gồm cọ và bọt biển"
                    },
                    new LoaiSanPham{
                        product_type_id = 6,
                        name = "Nước hoa",
                        description = "Gồm những loại nước hoa cao cấp tới trung bình"
                    }
                });
            }

            if(!context.SanPhams.Any()){
                temp = true;
                context.SanPhams.AddRange(new List<SanPham>{
                    new SanPham{
                        product_id = 1,
                        product_type_id = 1,
                        brand_id = 1,
                        name = "Lustre Eyeshadow Base",
                        amount = 50,
                        price = 200000,
                        description = "Sản phẩm kem lót mắt Lustre có kết cấu mỏng, nhẹ, dễ dàng tán đều trên mí mắt. Lustre Eyeshadow Base giúp giữ màu phấn mắt lên màu chuẩn và lâu trôi, đồng thời bảo vệ mắt khỏi hiện tượng bị kích ứng",
                        use = "Bôi một lớp mỏng sản phẩm lên vùng mí mắt bằng ngón tay hoặc cọ có đầu mỏng như Lustre Pro Makeup Brush E103 Eyeshadow Brush.Tán đều sản phẩm, đợi đến khi khô mới sử dụng phấn mắt",
                        img = "/image/sp0.jpg"
                    },
                    new SanPham{
                        product_id = 2,
                        product_type_id = 1,
                        brand_id = 2,
                        name = "GOLDEN ROSE EYESHADOW PRIMER",
                        amount = 50,
                        price = 167000,
                        description = "Golden Rose là một nhãn hiệu của tập đoàn Erkul Cosmetics đến từ Thổ Nhĩ Kỳ. Đây là một trong những tập đoàn mỹ phẩm lớn tại Châu Âu và nổi tiếng trên thế giới, chuyên cung cấp các loại mỹ phẩm chăm sóc mặt, mắt, môi, nails, tóc…. Erkul Cosmetics cũng nằm trong số 5 nhà sản xuất các sản phẩm sơn móng tay lớn nhất thế giới và đã vươn tầm thành công ra khỏi biên giới khi xuất khẩu sản phẩm này đến hơn 90 quốc giá trong 5 chậu lục bao gồm: Châu Mỹ, Bắc Phi, Trung Đông, Cộng Đồng Các Quốc Gia Độc Lập, Balkans và Châu Âu.",
                        use = "Sử dụng trước khi make-up mắt, tán trực tiếp lên da - Sau khi được thoa lên mắt, kem primer sẽ mau chóng khô lại tạo finish trong mờ, vì vậy bạn đừng lo ngại mí mắt sẽ trở nên trơn bóng",
                        img = "/image/sp1.jpg"
                    },
                    new SanPham{
                        product_id = 3,
                        product_type_id = 1,
                        brand_id = 3,
                        name = "Smashbox Cosmetics",
                        amount = 50,
                        price =255000 ,
                        description = "Smashbox Cosmetics là kem lót dành cho mắt thách thức mọi phong cách trang điểm mắt từ nhẹ nhàng, đơn giản đến ombre, màu khói cầu kỳ quyến rũ, sản phẩm vẫn giữ nguyên màu mắt đẹp của bạn suốt ngày dài. Kết cấu dạng kem mịn, có độ bám cao và dễ tán đều trên da.",
                        use = "Sau khi dưỡng ẩm, lấy một lượng kem vừa đủ tán đều khắp bầu mắt trước khi sử dụng phấn mắt.",
                        img = "/image/sp2.jpg"
                    },
                    new SanPham{
                        product_id = 4,
                        product_type_id = 1,
                        brand_id = 4,
                        name = "Nars Smudge Proof Eyeshadow",
                        amount = 50,
                        price = 510000,
                        description = "Thiết kế vỏ hộp là tông đen và sản phẩm có thiết kế cũng khá đơn giản với tông trắng đen chủ đạo nhưng rất dễ nhìn ra đặc trưng nhờ sự nổi bật của Logo NARS.Có nhiều tone màu lựa chọn chứa ít nhũ nhẹ. Kết cấu của kem lót khá mịn, như kiểu kem dưỡng.",
                        use = "Dùng cọ lấy lượng phấn mắt vừa đủ và đánh lên bầu mắt",
                        img = "/image/sp3.jpg"
                    },
                    new SanPham{
                        product_id = 5,
                        product_type_id = 1,
                        brand_id = 5,
                        name = "BH Cosmetics Solar Flare",
                        amount = 50,
                        price =688000 ,
                        description = "Bảng phấn mắt BH Cosmetics Solar Flare là một trong ba bảng màu mắt chủ đề Vũ trụ của BH Cosmetics. Bộ sưu tập các gam màu vũ trụ lung linh, ấm áp giúp cho đôi mắt của bạn thêm tỏa sáng rực rỡ. Bảng màu nhiều sắc thái từ màu nude lì đến những gam màu nhũ nóng bỏng tạo chiều sâu cho đôi mắt, thích hợp cho ngày đi làm nhẹ nhàng và những buổi party thật chất.",
                        use = "Dùng cọ lấy lượng phấn mắt vừa đủ và đánh lên bầu mắt. Có thể làm ẩm cọ trước khi lấy phấn để màu lên đậm hơn.Có thể pha trộn màu để tạo nên màu mắt thật khác biệt.",
                        img = "/image/sp4.jpg"
                    },
                    new SanPham{
                        product_id = 6,
                        product_type_id = 1,
                        brand_id = 5,
                        name = "BH Cosmetics Mini Zodiac",
                        amount = 50,
                        price = 437000,
                        description = "BH Cosmetics Mini Zodiac Aquarius là bảng màu mắt lấy cảm hứng từ cung Bào Bình trong 12 cung hoàng đạo. 9 tông màu khác nhau với một loạt các sắc màu như nâu, nâu đậm, xanh...đến tông màu trắng ánh bạc giúp khơi gợi nên sự quyến rũ độc đáo của riêng bạn.",
                        use = " Dùng cọ lấy lượng phấn mắt vừa đủ và đánh lên bầu mắt.Có thể làm ẩm cọ trước khi lấy phấn để màu lên đậm hơn.Có thể pha trộn màu để tạo nên màu mắt thật khác biệt.",
                        img = "/image/sp5.jpg"
                    },
                    new SanPham{
                        product_id = 7,
                        product_type_id = 1,
                        brand_id =5 ,
                        name = "BH Cosmetics Blushing In Bali",
                        amount = 50,
                        price = 669000,
                        description = "BH Cosmetics Blushing in Bali là bảng phấn má hồng và tạo khối lấy cảm hứng từ những hòn đảo đầy nắng của Bali. 6 màu phấn hồng và tạo khối của BH Cosmetic cho bạn tất cả những gam màu bạn tìm kiếm. Gồm 2 ô phấn má hồng tươi tắn dễ phối màu và 4 ô tạo khối & bắt sáng giúp tạo nét hài hoà, thanh thoát và thon gọn cho gương mặt.",
                        use = "Chỉ lấy một lượng vừa đủ bám trên bề mặt lông của cọ dùng để đánh má hồng.Bắt đầu bằng cách đặt phấn má lên điểm cao nhất của gò má. Sau đó mỉm cười và quét cọ từ đỉnh ngoài của gò má (phía gần mũi) nhẹ nhàng kéo hướng về phía thái dương. Dùng cọ tán đều phấn má hồng về hướng chân tóc.",
                        img = "/image/sp6.jpg"
                    },
                    new SanPham{
                        product_id = 8,
                        product_type_id = 1,
                        brand_id = 5,
                        name = "BH Cosmetics Zodiac Love Signs",
                        amount = 50,
                        price = 714000,
                        description = "Bảng phấn mắt BH Cosmetics Zodiac Love Signs với 25 màu bao gồm 12 màu phấn mắt lì mịn, 12 màu phấn nhũ và 1 màu highlight sáng sẽ giúp đôi mắt bạn trông rực rỡ và sống động hơn bao giờ hết. 24 màu mắt trải dài từ các gam màu nóng đến lạnh và các màu thuộc dải ngân hà như màu vàng rựa lửa của mặt trời, màu lục và tím...",
                        use = "Dùng cọ lấy lượng phấn mắt vừa đủ và đánh lên bầu mắt.Có thể làm ẩm cọ trước khi lấy phấn để màu lên đậm hơn.Có thể pha trộn màu để tạo nên màu mắt thật khác biệt.",
                        img = "/image/sp7.jpg"
                    },
                    new SanPham{
                        product_id = 9,
                        product_type_id = 1,
                        brand_id = 5,
                        name = "BH Cosmetics Foil Eyes",
                        amount = 50,
                        price = 386000,
                        description = "Bảng màu mắt BH Cosmetics Foil Eyes gồm 28 gam màu metallic (kim loại); đây là một bộ sưu tập của sự hoàn hảo; đa chiều và đa sắc tố kim loại. Nó là sự kết hợp của tone neutrals và các loại đá ngọc trai, đá thạch anh lấp lánh đến màu ánh khói đem đến cho người dùng sự choáng ngợp khi trải nghiệm với các tông màu đầy sống động.",
                        use = "Dùng cọ lấy lượng phấn mắt vừa đủ và đánh lên bầu mắt.Có thể làm ẩm cọ trước khi lấy phấn để màu lên đậm hơn.Có thể pha trộn màu để tạo nên màu mắt thật khác biệt.",
                        img = "/image/sp8.jpg"
                    },
                    new SanPham{
                        product_id = 10,
                        product_type_id = 1,
                        brand_id = 6,
                        name = "M.A.C EYE SHADOW X 15",
                        amount = 50,
                        price = 3088000,
                        description = "M.A.C EYE SHADOW X 15 là bảng màu mắt gồm các tông màu bán chạy nhất của MAC gồm 15 ô màu full size với chất phấn vô cùng mịn mượt cho khả năng lên màu chuẩn, cực dễ tán trên da và có độ bám màu lên đến 12 tiếng.Thiết kế sang trọng, các tone màu dễ sử dụng cho các phong cách trang điểm từ đơn giản hằng ngày đến các bữa tiệc cầu kì, vì thế sản phẩm này là một sản phẩm cần có đối với các cô nàng là tín đồ makeup.",
                        use = "Nên dùng kem lót mắt trước khi sử dụng phấn mắt.Tán đều nhẹ nhàng, khéo léo bằng cọ trang điểm mắt.Sử dụng các tông màu từ sáng đến đậm để tạo khối và tạo điểm nổi bật.Bảo quản nơi khô ráo, thoáng mát. Tránh ánh nắng trực tiếp và nhiệt độ cao",
                        img = "/image/sp9.jpg"
                    },
                    new SanPham{
                        product_id = 11,
                        product_type_id = 1,
                        brand_id = 7,
                        name = "MISSHA Signature Velvet Art",
                        amount = 50,
                        price = 544000,
                        description = "Phấn mắt MISSHA Signature Velvet Art với tông màu cổ điển, là sự lựa chọn tuyệt vời cho các cô nàng theo phong cách retro.Tính năng làm đẹp của loại phẩn này rất hiệu quả. Sử dụng sản phẩm để trang điểm cho đôi mắt sẽ đem lại cho bạn cảm giác mềm mại, mịn màng khi sử dụng.Màu phấn có độ bền cao, bám rất lâu và khó bị trôi. Màu phần còn chứa bột ngọc trai giúp cho đôi mắt lấp lánh tự nhiên ở mọi góc nhìn.Phấn mắt được sắp xếp một cách hợp lí, hài hòa về độ bóng và màu sắc (highlight, màu nhạt, màu đậm, viền mắt) giúp cho thao tác trang điểm mắt trở nên thuận tiện và dễ dàng.",
                        use = "Màu phấn nền được dùng đầu tiên, các bạn phủ đều phấn mắt nền lên rộng gấp 2 lần mí mắt.Màu phấn chính (nhấn) được dùng tiếp theo, loại phấn này chỉ nên vẽ khoảng môt nửa mí mắt để tạo điểm nhấn chính cho đôi mắt. Màu phấn viền thì chỉ để vẽ viền mắt theo một đường thẳng từ trong ra ngoài đuôi mắt.Màu phấn highlight sẽ được dùng cuối cùng, phủ lên toàn bộ lớp phấn trước để đôi mắt thêm long lanh.",
                        img = "/image/sp10.jpg"
                    },
                    new SanPham{
                        product_id = 12,
                        product_type_id = 1,
                        brand_id = 1,
                        name = "LUSTRE PRO Volume Waterproof",
                        amount = 50,
                        price = 240000,
                        description = "LUSTRE PRO Volume Waterproof sử dụng công nghệ đột phá Micro Fiber, giúp bao phủ từng sợi mi. Chỉ với một lần chuốt nhẹ, MLUSTRE PRO Volume Waterproof sẽ khiến hàng mi dày và cong vút tự nhiên. LUSTRE PRO Volume Waterproof không gây cảm giác nặng trĩu và cộm mắt.",
                        use = " Lăn chai giữa 2 lòng bàn tay để làm ấm Mascara (giúp Mascara ít bị vón cục khi sử dụng).Lấy cọ ra khỏi chai và lau bớt phần Mascara dư bằng khăn giấy.Chải cọ theo đường Ziczac từ chân mi đến ngọn mi.Sau khi chuốt qua một lượt, đợi khoảng 10 giây cho khô lớp đầu tiên, chuốt tiếp lớp thứ hai, đợi thêm 10 giây nữa rồi chuốt tiếp lần thứ ba",
                        img = "/image/sp11.jpg"
                    },
                    new SanPham{
                        product_id = 13,
                        product_type_id = 1,
                        brand_id = 8,
                        name = "Innisfree Skinny Longlongcar",
                        amount = 50,
                        price = 190000,
                        description = "Innisfree Skinny Longlongcar với đầu chải mi được thiết kế đặc biệt hình tam giác cực nhỏ chỉ có 2.5mm, giúp chổi chạm đến từng sợi mi nhỏ và ngắn nhất, chuốt tận được sâu trong chân mi. Nhờ thiết kế độc đáo này mà khi chuốt mi ít bị vón và dính các sợi mi lại với nhau, giúp kéo dài mi hơn, tạo cho bạn cảm giác như mới được nối mi. Đầu chải mi nhỏ dễ điều khiển cực kì phù hợp để chuốt hàng mi dưới – vốn rất ngắn và dễ bị lem nếu thao tác bằng các đầu chải mi to thông thường khác",
                        use = "Chải từ phía gốc mi theo hướng đi lên theo đường ziczac.Dựng đứng đầu chải và chải thêm phần mi ngắn ở đầu và đuôi mắt.Chải thêm phần lông mi dưới giúp mắt trông to và quyến rũ hơn",
                        img = "/image/sp12.jpg"
                    },
                    new SanPham{
                        product_id = 14,
                        product_type_id = 1,
                        brand_id = 9,
                        name = " Sisley So Intense Mascara Deep",
                        amount = 50,
                        price = 1359000,
                        description = "Sisley So Intense Mascara Deep mang đến cho bạn một hàng mi dày và dài trông thấy với hiệu quả ngay tức thì. Công thức độc đáo được bổ sung các peptide giàu vitamin giúp mi dày, dài và chắc khỏe hơn qua từng ngày. Các sắc tố màu siêu tinh khiết cung cấp một màu sắc đen tuyền và độ bền màu lâu cho hàng mi. Khả năng làm tơi mi nhanh chóng cho từng sợi mi được phủ đều mascara.",
                        use = "Nên bâm mi trước để có hàng mi cong đẹp tự nhiên. Ấn nhẹ đầu chải vào gốc lông mi và nhẹ nhàng chuốt về phía ngọn, lặp lại động tác cho đến khi có được màu mascara bạn muốn.",
                        img = "/image/sp13.jpg"
                    },
                    new SanPham{
                        product_id = 15,
                        product_type_id = 1,
                        brand_id = 10,
                        name = "Arcancil Paris Lash Hysteria",
                        amount = 50,
                        price = 395000,
                        description = "Arcancil Paris Lash Hysteria là sản phẩm trang điểm được ưa chuộng của Arcancil Paris với đầu cọ 360 độ cùng với nhiều dưỡng chất tốt giúp cho mỗi sợi lông mi đều được bao phủ bởi lớp mascara mà không bị vón cục, khô mi khi trang điểm trong thời gian dài. Bên cạnh đó còn có khả năng chống thấm nước, chống trôi tốt và hiệu quả làm dày, dài, cong mi rất tự nhiên.",
                        use = "Chải Mascara bằng cách xoay cọ từ gốc đến đầu lông mi, bắt đầu từ góc bên trong đến góc ngoài của mắt. Áp dụng nhiều lớp đến khối lượng mong muốn: một lớp kem duy nhất cho một kết quả tự nhiên, nhiều lớp kem cho khối lượng tối đa và hiệu ứng lông mi dày cực kỳ quyến rũ.",
                        img = "/image/sp14.jpg"
                    },
                    new SanPham{
                        product_id = 16,
                        product_type_id = 1,
                        brand_id = 7,
                        name = "MISSHA THE STYLE 4D MASCARA",
                        amount = 50,
                        price = 153000,
                        description = "Thành phần chủ yếu là Botanical wax giúp bạn dễ dàng có hàng mi cong, đầy quyến rũ mà không hề có cảm giác cộm, bết dính hay vón cục. Đồng thời, cung cấp các dưỡng chất giúp bảo vệ làn mi luôn khỏe mạnh.Cây chải mi được thiết kế rất đặc biệt và tinh tế với các sợi cọ đều giúp dễ dàng trong việc tạo ra một làn mi mỏng, đều và đầy ấn tượng. Ngoài ra, thiết kế nhỏ gọn kết hợp với màu đen chủ đạo mang đến cho bạn sự sang trọng và vô cùng tiện dụng khi sử dụng và mang theo sản phẩm.Có khả năng chống trôi rất tốt, có thể giữ cho làn mi luôn cong, đẹp và đầy quyến rũ trong vòng từ 8-9 giờ ngay cả khi gặp trời mưa, mồ hôi hoặc khói bụi.",
                        use = "Lăn Chải mi The Style 4D Missha giữa 2 lòng bàn tay để làm ấm mascara để mascara ít bị vón cục khi sử dụng.Kẹp mi tạo dáng mi.Dùng mascara lấy đầu chổi, chải nhẹ nhàng lớp thứ nhất để khô.Có thể tiếp tục dùng kẹp mí tạo dáng lần 2, chải mascara lần 2, lặp lại 2-3 lần bạn có bờ mi dày dài như mong muốn.",
                        img = "/image/sp15.jpg"
                    },
                    new SanPham{
                        product_id = 17,
                        product_type_id = 1,
                        brand_id = 1,
                        name = "Lustre PRO Eyelash Curler",
                        amount = 50,
                        price = 200000,
                        description = "Kẹp mi Lustre uốn cong mi mắt mà không làm gãy/rụng mi. Chất liệu thép không gỉ và cao su mềm giúp kẹp mi hoạt động lâu dài và không làm gãy mi.",
                        use = "Mở kẹp mi, đặt vào mí mắt theo đường cong tự nhiên của mí mắt sao cho lông mi nằm trên phần cao su của kẹp. Bấm nhẹ nhàng từ 2-3 lần. Bỏ kẹp mi, chuốt mascara. Lặp lại cho tới khi mi đạt độ cong mong muốn.",
                        img = "/image/sp16.jpg"
                    },
                    new SanPham{
                        product_id = 18,
                        product_type_id = 1,
                        brand_id = 11,
                        name = "Buxom Lash Mascara",
                        amount = 50,
                        price = 408000,
                        description = "Công thức giàu vitamin, giúp nuôi dưỡng từng sợi lông mi sâu tới tận gốc và chống vón cục. Thêm một điểm mạnh không thể không nhắc tới nữa là về thiết kế: Phần đầu cọ của Mascara Buxom Lash lõm vào giữa tương tự như chiếc đồng hồ cát giúp cho bạn có thể dễ dàng chuốt và bao phủ từng sợi lông mi. Chất mascara mịn và đậm màu từ chân tới ngọn.",
                        use = "Dùng đầu cọ chuốt nhẹ chuốt mi Buxom Lash lên hai hàng lông mi ở hai bên mắt. Những sợi lông mi có cấu tạo dày hơn ở phần chân lông và mỏng dần về ngọn. Vì thế bạn có thể dùng đầu cọ để chuốt dày cho phần ngọn này trước. Đợi cho phần mascara đầu tiên khô thì ta tiếp tục dùng cọ chuốt đều lớp tiếp theo. Để đạt được độ dày mong muốn thì các bạn có thể chuốt mascara thành nhiều lớp tùy ý. Bảo quản mascara ở nơi khô ráo, thoáng mát, tránh để nắng mặt trời chiếu trực tiếp vào mascara. Để tránh xa tầm tay trẻ em.",
                        img = "/image/sp17.jpg"
                    },
                    new SanPham{
                        product_id = 19,
                        product_type_id = 1,
                        brand_id = 12,
                        name = "Isehan Kiss Me Heroine Long",
                        amount = 50,
                        price = 396000,
                        description = "Mascara Isehan Heroine Kiss Me Long có khả năng làm dày và dài mi cho những bạn có lông mi dày nhưng bị thẳng, khó làm cong mi.Luôn nằm trong top đầu các sản phẩm mascara được ưa thích nhất do người tiêu dùng bình chọn tại Nhật Bản. Sản phẩm Mascara Isehan phù hợp với mọi dạng lông mi, giúp bạn tạo một hàng mi dài gấp 1,5 lần hàng mi vốn có. Khả năng chống nước và thành phần chiết xuất từ hoa cúc tác dụng giữ ẩm và dầu hoa trà làm mềm giúp bờ mi trông sẽ không bị khô hay làm cứng mi như các sản phẩm mascara thông thường khác.",
                        use = "Chải từ phía gốc mi theo hướng đi lên theo đường ziczac.Dựng đứng đầu chải và chải thêm phần mi ngắn ở đầu và đuôi mắt.Chải thêm phần lông mi dưới giúp mắt trông to và quyến rũ hơn.Cuối ngày, tẩy trang với Speedy mascara remove, dùng bông tẩy trang thấm sản phẩm sau đó nhẹ nhàng tẩy đi vùng mi mắt.",
                        img = "/image/sp18.jpg"
                    },
                    new SanPham{
                        product_id = 20,
                        product_type_id = 1,
                        brand_id = 6,
                        name = "M.A.C Brushstroke Liner",
                        amount = 50,
                        price = 669000,
                        description = "M.A.C Brushstroke Liner - Brushblack là bút kẻ mắt màu đen tuyền với đầu nhọn cực mảnh cùng khả năng giữ màu siêu đỉnh lên đến 24 giờ. Sản phẩm chứa công thức chống trôi cho bạn đôi mắt đẹp suốt ngày dài. Mặc dù chứa công thức chống trôi nhưng bạn vẫn có thể tẩy rửa dễ dàng với nước ấm.Sản phẩm đã được kiềm nghiệm nhãn khoa an toàn cho mắt, phù hợp cả với những coi nàng thường xuyên sử dụng kính áp tròng.",
                        use = "Bạn kẻ một đường từ giữa mắt đến đuôi mắt.Kẻ thêm một đường từ khóe mắt nối với đường ban đầu. Bước này giúp mắt bạn to tròn hơn.Kẻ vành trong của mắt. Bước này sẽ tạo hiệu ứng giúp lông mi dày hơn. Bạn đưa đầu bút xuống phần vành trong của mắt và kẻ một đường chạy từ đầu mi mắt tới đuôi mi mắt. Tuy nhiên với những bạn có cặp mắt hơi nhỏ thì không nên áp dụng bước này vì nó có thể làm cho mắt bạn nhỏ hơn nữa.Kẻ đường cánh. Bước này giúp bạn tạo điểm nhấn ở đuôi mắt. Từ đuôi mắt chúng ta kẻ một đường xéo đi lên. Bạn cũng có thể đi theo đường viền dưới. Mắt bạn sẽ có nét nữ tính, điệu đà và gợi cảm.",
                        img = "/image/sp19.jpg"
                    },
                    new SanPham{
                        product_id = 21,
                        product_type_id = 1,
                        brand_id = 34,
                        name = "Dior Diorshow Pro Liner Bevel",
                        amount = 50,
                        price = 775000,
                        description = "Kẻ mắt Dior Diorshow Pro Liner Bevel chính là một trong những niềm tự hào của thương hiệu Dior. Ưu điểm dễ nhận thấy nhất là phần đầu bút được thiết kế theo dạng xiên, trên nhọn dưới tù giúp cho người dùng có thể diều chỉnh động tác dễ dàng. Chúng cũng tạo nên những đường kẻ mắt sắc sảo như được vẽ bởi nghệ nhân trang điểm thực thụ. Sở hữu thành phần lành mạnh, không sử dụng paraben gây kích ứng, không có các chất sulfate gây ung thư,…hoàn toàn đảm bảo an toàn. Ngoài ra sản phẩm còn chứa công thức chống thấm nước giúp giữ nguyên đôi mắt đẹp khỏi tình trạng lem nhem gây ra bởi nước, mồ hôi,…",
                        use = "Sử dụng ngón tay căng nhẹ da phần mi mắt để kẻ dễ dàng hơn.Tay kia cầm bút kẻ một đường sát chân mi và hơi chếch lên ở phần đuôi mắt.Có thể tô thêm cho đến khi đạt được đường nét theo ý thích.Bảo quản sản phẩm ở nơi khô ráo, thoáng mát. Ta nên tránh để ánh nắng trực tiếp chiếu vào sản phẩm. Nắp bút luôn luôn phải đóng chặt.",
                        img = "/image/sp20.jpg"
                    },
                    new SanPham{
                        product_id = 22,
                        product_type_id = 1,
                        brand_id = 9,
                        name = "Sisley Phyto Khol Star Eyeliner 3",
                        amount = 50,
                        price = 1081000,
                        description = "Sisley Phyto Khol Star Eyeliner 3 là chì kẻ mắt được đúc độc đáo có thể chứa các tinh thể ngọc trai tối đa, tăng cường độ bắt sáng của sản phẩm, tô điểm cho đôi mắt thêm lung linh huyền bí. Thành phần chứa tỷ lệ cao các loại dầu và sáp cho cảm giác lướt nhẹ trên da, giúp cho việc thao tác trở nên nhanh chóng và dễ dàng.",
                        use = "Kẻ sát viền mi để có một đôi mắt sắc nét.",
                        img = "/image/sp21.jpg"
                    },
                    new SanPham{
                        product_id = 23,
                        product_type_id = 1,
                        brand_id = 9,
                        name = "Sisley Phyto-Khol Perfect Eyeliner 8",
                        amount = 50,
                        price = 1081000,
                        description = "Sisley Phyto Khol Star Eyeliner 8 là chì kẻ mắt được đúc độc đáo có thể chứa các tinh thể ngọc trai tối đa, tăng cường độ bắt sáng của sản phẩm, tô điểm cho đôi mắt thêm lung linh huyền bí. Thành phần chứa tỷ lệ cao các loại dầu và sáp cho cảm giác lướt nhẹ trên da, giúp cho việc thao tác trở nên nhanh chóng và dễ dàng.",
                        use = "Kẻ sát viền mi để có một đôi mắt sắc nét.",
                        img = "/image/sp22.jpg"
                    },
                    new SanPham{
                        product_id = 24,
                        product_type_id = 1,
                        brand_id = 13,
                        name = "MACQUEEN WATERPROOF PEN EYELINER",
                        amount = 50,
                        price = 221000,
                        description = "Bút Kẻ Mắt MACQUEEN WATERPROOF PEN EYELINER với đầu cọ bút lông dễ điều chỉnh cho các đường kẻ mắt thật mỏng tự nhiên và sắc nét cá tính, đem đến đôi mắt to tròn, sắc nét làm nổi bật khuôn mặt bạn. Sản phẩm không bị trôi khi gặp nước, hoàn hảo cho việc sử dụng ở mọi hoàn cảnh đi làm, đi chơi, đi biển. Công thức độc đáo giúp giữ màu lâu, tạo điểm nhấn cho đôi mắt thêm đẹp quyến rũ, long lanh hơn.",
                        use = "Dùng bút kẻ, đi nét viền ngoài mắt để tô lên vẻ đẹp của đôi mắt bạn. Bảo quản nơi khô ráo, thoáng mát, tránh ánh nắng trực tiếp và nhiệt độ cao",
                        img = "/image/sp23.jpg"
                    },
                    new SanPham{
                        product_id = 25,
                        product_type_id = 1,
                        brand_id = 14,
                        name = "ECLIPSE- EYELINER LIGNE DIVINE",
                        amount = 50,
                        price = 311000,
                        description = "Eclipse Colours là hãng mỹ phẩm cao cấp tại Pháp đã cho ra đời nhiều dòng mỹ phẩm trang điểm và các sản phẩm làm đẹp dành cho móng tay, móng chân... giúp tô điểm thêm vẻ đẹp của phái nữ. ECLIPSE - EYELINER LIGNE DIVINE: Bút chì kẻ mắt Eclipse chứa sáp làm mềm da tự nhiên và màu sắc bền rõ nét. Với thiết kế đầu bút nhỏ giúp bạn dễ dàng vẽ những đường kẻ sắc sảo như ý muốn.",
                        use = "Dùng bút chì kẻ mặt kẻ theo đường viền mắt. Sao cho mỏng dần về phía cuối đuôi mắt để mang lại đôi mắt tinh tế và dịu dàng. Nếu muốn mắt to hơn, hãy dùng chì kẻ mắt kẻ 2/3 mi dưới, nếu viền cả mi trên và mi dưới sẽ làm cho mắt sắc nét hơn. Bảo quản nơi khô ráo thoáng mát, tránh ánh nắng trực tiếp và nhiệt độ cao.",
                        img = "/image/sp24.jpg"
                    },
                    new SanPham{
                        product_id = 26,
                        product_type_id = 1,
                        brand_id = 1,
                        name = "Lustre Ultimate Eyeliner Professional Line",
                        amount = 50,
                        price = 208000,
                        description = "Chì kẻ mắt của Lustre với đầu bút sáp mềm, dễ dàng trượt lên da cho đường kẻ mắt rõ nét và tự nhiên, đồng thời có nhiều lựa chọn về màu sắc, cho bạn thoả sức sáng tạo.",
                        use = "Bạn kẻ một đường từ giữa mắt đến đuôi mắt.Kẻ thêm một đường từ khóe mắt nối với đường ban đầu. Bước này giúp mắt bạn to tròn hơn.Kẻ vành trong của mắt. Bước này sẽ tạo hiệu ứng giúp lông mi dày hơn. Bạn đưa chì xuống phần vành trong của mắt và kẻ một đường chạy từ đầu mi mắt tới đuôi mi mắt. Tuy nhiên với những bạn có cặp mắt hơi nhỏ thì không nên áp dụng bước này vì nó có thể làm cho mắt bạn nhỏ hơn nữa.Kẻ đường cánh. Bước này giúp bạn tạo điểm nhấn ở đuôi mắt. Từ đuôi mắt chúng ta kẻ một đường xéo đi lên. Bạn cũng có thể đi theo đường viền dưới. Mắt bạn sẽ có nét nữ tính, điệu đà và gợi cảm.Kiểu chiếc lá. Từ đuôi cánh kẻ 1 đường nối liền với giữa mắt. Kiểu chiếc lá này rất thông dụng và thích hợp với nhiều loại mắt khác nhau.Đường kẻ đôi. Ban kẻ đường đối xứng với chiếc lá tạo một chút tinh nghịch và sáng tạo cho đôi mắt, đôi mắt trong cũng rất dễ thương. Bước này dành cho bạn nào muốn thể hiện cá tính và tạo sự khác biệt.",
                        img = "/image/sp25.jpg"
                    },
                    new SanPham{
                        product_id =27 ,
                        product_type_id = 1,
                        brand_id = 1,
                        name = "Lustre Ultimate Eyeliner Professional Line Mini - Black",
                        amount =50 ,
                        price = 160000 ,
                        description = "Lustre Ultimate Eyeliner Professional Line Mini - Black - Chì kẻ mắt của Lustre với đầu bút sáp mềm, dễ dàng trượt lên da cho đường kẻ mắt rõ nét và tự nhiên.Với tông màu đen dễ dàng phối hợp cùng các kiểu makeup khác nhau sẽ tạo điểm nhấn cho đôi mắt.Ngoài tinh dầu Jojoba nuôi dưỡng mi, chất chì của Lustre rất mềm và dễ kẻ. Đặc biệt, Lustre có cả đầu chuốt đi kèm rất tiện dụng",
                        use = "Bạn kẻ một đường từ giữa mắt đến đuôi mắt.Kẻ thêm một đường từ khóe mắt nối với đường ban đầu. Bước này giúp mắt bạn to tròn hơn.Kẻ vành trong của mắt. Bước này sẽ tạo hiệu ứng giúp lông mi dày hơn. Bạn đưa chì xuống phần vành trong của mắt và kẻ một đường chạy từ đầu mi mắt tới đuôi mi mắt. Tuy nhiên với những bạn có cặp mắt hơi nhỏ thì không nên áp dụng bước này vì nó có thể làm cho mắt bạn nhỏ hơn nữa.Kẻ đường cánh. Bước này giúp bạn tạo điểm nhấn ở đuôi mắt. Từ đuôi mắt chúng ta kẻ một đường xéo đi lên. Bạn cũng có thể đi theo đường viền dưới. Mắt bạn sẽ có nét nữ tính, điệu đà và gợi cảm.",
                        img = "/image/sp26.jpg"
                    },
                    new SanPham{
                        product_id = 28,
                        product_type_id = 1,
                        brand_id = 6,
                        name = "M.A.C Great Brows Brow Kit - TAUPE",
                        amount = 50,
                        price = 1152000,
                        description = "Bột sẽ bám phủ vào lông mày cho đôi lông mày có màu sắc đẹp tự nhiên. Đường nét mềm mại, rõ ràng thay đổi toàn diện khuôn mặt.Sản phẩm có thành phần lành tính, an toàn cho da. Hạn chế gây kích ứng, bảo vệ và chăm sóc hàng chân mày hoàn hảo, thích hợp với mọi loại da.Hạn chế được tình trạng tiết bã nhờn và mồ hôi trên da. Màu sắc của phấn kẻ chân mày MAC Eyebrows Brow của rất phù hợp đối với người Châu Á. Đem đến cho bạn một diện mạo khác hẳn.Bột cũng rất hữu dụng cho các trường hợp đã trót lỡ phun, xăm chân mày. Nhưng làm đôi mắt quá sắc nét, thiếu tự nhiên hoặc màu mực đã bắt đầu xuống màu.",
                        use = "Dùng cọ kèm theo chải đều chân mày rồi lấy cọ tán màu vẽ nhạt dần theo khuôn chân mày, bạn có thể chọn dùng 1 màu, hoặc cũng có thể phối hợp cả 3 màu với nhau (chia màu cho đầu mày và đường cong đuôi mày) rồi dùng ngón tay mix lại lần nữa để tạo hiệu ứng thật tự nhiên.",
                        img = "/image/sp27.jpg"
                    },
                    new SanPham{
                        product_id = 29,
                        product_type_id = 1,
                        brand_id = 6,
                        name = "M.A.C VELUXE BROW LINER",
                        amount = 50,
                        price = 669000,
                        description = "Chì kẻ chân mày M.A.C VELUXE BROW LINER được thiết kế nhỏ gọn, rất tiện dụng để mang đi khi đi học, đi làm hay đi du lịch. Bột phấn có màu sắc nhẹ nhàng tạo nên sự tự nhiên cho khuôn mặt khi sử dụng. Mặt khác, kẻ mày MAC Veluxe Brow Liner còn cò khả năng giữ màu lâu, không trôi và không thấm nước, giúp bạn luôn tươi tắn suốt cả ngày.",
                        use = "Xác định điểm đầu, đỉnh và đuôi chân mày. Đỉnh chân mày nằm trên 1 đường thẳng với khóe mũi và đầu mắt.Đỉnh chân mày được xác đinh là vị trí ở 2/3 chiều dài chân mày tính từ điểm đầu chân mày. Đuôi chân mày nằm trên cùng đường thẳng với khóe mũi và đuôi mắt.Dùng chì kẻ mày vẽ thật nhẹ nhàng bắt đầu từ đỉnh chân mày hướng về đầu chân mày và từ đỉnh chân mày hướng về đuôi chân mày dọc theo viền mắt, hơi xếch lên ở đuôi mắt để đôi mắt trông to và rạng rỡ hơn để có đôi chân mày thật tự nhiên",
                        img = "/image/sp28.jpg"
                    },
                    new SanPham{
                        product_id = 30,
                        product_type_id = 1,
                        brand_id = 15,
                        name = "PETITE LAEL EYE BROW #EB008",
                        amount = 50,
                        price = 102000,
                        description = "Petite Lael là dòng mỹ phẩm mới toanh đến từ Hàn Quốc vừa ra mắt đã khiến bao trái tim mê làm đẹp phải đổ liêu xiêu vì vẻ ngoài vô cùng đáng yêu, khác biệt với những màu sắc và thiết kế độc đáo. Nhỏ gọn, trẻ trung, dễ thương, Petite Lael còn ghi điểm với những màu sắc độc đáo: kẻ mắt màu rượu đỏ hoặc xanh biển, mascara cam,... cho bạn thỏa sức sáng tạo những makeup look siêu cá tính.PETITE LAEL EYE BROW #EB008 là sản phẩm kẻ mày giúp bạn dễ dàng kẻ được hàng chân mày đẹp như ý với thiết kế nhỏ gọn, tiện lợi, dễ dàng mang theo bên mình.",
                        use = "Dùng đầu cọ kẻ khuôn chân mày như ý sau đó tô đều vào những khoảng trống để có hàng chân mày đẹp sắc sảo.",
                        img = "/image/sp29.jpg"
                    },
                    new SanPham{
                        product_id = 31,
                        product_type_id = 1,
                        brand_id = 1,
                        name = "Lustre Brow Pomade Professional Line - Poised Taupe",
                        amount = 50,
                        price = 184000,
                        description = "Sản phẩm Kẻ Chân Mày dạng gel pomade giúp dễ dàng tạo hình cặp chân mày cùng với khả năng chống trôi và chống lem. Công thức đặc biệt lý tưởng cho da dầu cũng như trong thời tiết nhiệt đới.Màu Poised Taupe - Nâu Tự Nhiên trẻ trung phù hợp với đa số màu tóc",
                        use = "Dùng đầu cọ Lustre Pro Makeup Brush E105 Brow Brush chấm nhẹ nhàng để lấy sản phẩm.Định hình khung chân mày và tán đều đường viền về đuôi chân mày",
                        img = "/image/sp30.jpg"
                    },
                    new SanPham{
                        product_id = 32,
                        product_type_id = 1,
                        brand_id = 16,
                        name = "The BrowGal Eyebrow Pencil - Blond",
                        amount = 50,
                        price = 621000,
                        description = "Được thiết kế và tạo hình cẩn thận để mô phỏng vẻ ngoài của tóc thật, Bút chì kẻ lông mày của BrowGal luôn trông tự nhiên và không nhúc nhích. Những cây bút chì có thể pha trộn này được làm từ gỗ tuyết tùng cho một cây chì cứng hơn mang lại hiệu ứng giống như tóc hơn. Với một loạt các sắc thái pha trộn tùy chỉnh độc đáo, có một kết hợp hoàn hảo cho mọi màu tóc.",
                        use = "Chuốt nhọn để dễ dàng phẩy sợi , tạo khuôn chân mày, kết hợp với bột tán chân màu để có hiệu quả tốt nhất.",
                        img = "/image/sp31.jpg"
                    },
                    new SanPham{
                        product_id = 33,
                        product_type_id = 1,
                        brand_id = 1 ,
                        name = "Lustre Brow Defining Professional Line - Dark Taupe",
                        amount = 50,
                        price = 208000,
                        description = "Lustre là thương hiệu xuất xứ từ Mỹ chuyên về các dòng trang điểm chuyên nghiệp với giá thành hợp lý cho những người yêu makeup. Sản xuất tại Hàn Quốc với công nghệ vượt trội, chì kẻ mày đầu tam giác của Lustre vô cùng dễ sử dụng kể cả cho những người mới bắt đầu. Cây chì cho phép bạn dễ dàng tạo dáng ngang dễ thương kiểu Hàn Quốc, hay dáng cong phương Tây quyến rũ. Màu sắc ra đều và mượt mà, cho nét mày tự nhiên",
                        use = "Dùng đầu cọ xoắn chuốt lông mày vào nếp.Dùng đầu chì phẩy từng sợi lông mày theo khuôn và hướng có sẵn. Nhẹ tay (nhạt màu) ở đầu lông mày, đậm dần về đuôi lông mày. Phẩy đuôi lông mày nhọn mảnh.",
                        img = "/image/sp32.jpg"
                    },
                    new SanPham{
                        product_id = 34,
                        product_type_id = 1,
                        brand_id = 17,
                        name = "SPRING HEART EYEBROW PENCIL",
                        amount = 50,
                        price = 225000,
                        description = "Ưu điểm của chì kẻ mày SPRING HEART EYEBROW PENCIL là bạn có thể tạo nên những đường kẻ thanh mảnh và sắc nét với chất chì mềm mịn, mà không làm tổn hại đến làn da. Ngoài ra, sản phẩm với khả năng kháng nước sẽ bảo vệ chân mày bạn không bị trôi bởi bã nhờn trên da, bụi bẩn hoặc sức nóng ngoài trời. Sản phẩm còn được kèm theo đầu chuốt để tiện lợi hơn cho bạn.",
                        use = "Xác định dáng chân mày hợp với khuôn mặt sau đó kẻ khuôn và tô đều cho chân mày.",
                        img = "/image/sp33.jpg"
                    },
                    new SanPham{
                        product_id = 35,
                        product_type_id = 1,
                        brand_id = 18,
                        name = "Muji Mild Eye Make Up Remover",
                        amount = 50,
                        price = 388000,
                        description = "Muji Mild Eye Make Up Remover nhẹ nhàng loại bỏ trang điểm mắt trên da nhạy cảm như mắt và môi mà không có cảm giác dính. Sản phẩm có thành phần chính là dầu ô liu, chiết xuất Chamomile, chiết xuất lá đào, thành phần dưỡng ẩm tự nhiên và thành phần dưỡng ẩm axit hyaluronic. Ngoài hiệu quả làm sạch sản phẩm còn bổ sung thêm các dưỡng chất để dưỡng da mềm mại. Sau khi tẩy trang bạn không hề có cảm giác khô da như các dòng sản phẩm khác. Tẩy trang dịu nhẹ không tác động quá mạnh để tránh làm da bị khô hay hư tổn.",
                        use = "Lắc đều trước khi sử dụng.Cho một lượng sản phẩm cỡ đồng xu lên cotton pad, áp trên vùng trang điểm mắt và môi trong vài giây rồi lau nhẹ nhàng.",
                        img = "/image/sp34.jpg"
                    },
                    new SanPham{
                        product_id = 36,
                        product_type_id = 1,
                        brand_id = 19,
                        name = "Lashfood Conditioning Collagen Lash Primer",
                        amount = 50,
                        price =230000 ,
                        description = "...",
                        use = "Bôi lên mặt",
                        img = "/image/sp35.jpg"
                    },
                    new SanPham{
                        product_id =37 ,
                        product_type_id = 1,
                        brand_id = 20,
                        name = "Milk Hydra Grip Primer",
                        amount = 50,
                        price = 150000 ,
                        description = "Kem lót cấp ẩm MILK MAKEUP Hydro Grip Primer là một sản phẩm kem lót không chứa silicone - thành phần dễ gây nên tắc nghẽn lỗ chân lông, kem dạng gel trong đầy dưỡng chất sẽ giúp da ẩm mịn hơn trông thấy.Kem lót đem lại cảm giác như bạn đang sử dụng một loại serum cấp ẩm nào đó chứ không phải là loại kem lót gây cảm giác nặng mặt hay quá bóng bẩy. Kem có chiết xuất từ trà xanh, nước lô hội ngọc trai để giúp làn da trở nên sáng mịn và rạng rỡ hơn.",
                        use = "Bôi lên mặt",
                        img = "/image/sp36.jpg"
                    },
                    new SanPham{
                        product_id = 38,
                        product_type_id = 1,
                        brand_id = 7,
                        name = "MISSHA VELVET FINISH CUSHION",
                        amount = 50,
                        price =261000 ,
                        description = "Khi thoa lên da, phấn có lớp mỏng nhẹ tự nhiên không bệt dính khó chịu trong quá trình dùng. Không tạo độ bóng dầu sau khi sử dụng. Tạo cho bạn sự thoải mái khí sử dụng điện thoại mà không còn dấu dính lại.MISSHA VELVET FINISH CUSHION ẽ là lớp màng bảo vệ cho làn da mỏng manh của bạn khỏi tác hại của tia UV, giảm sự tổn thương từ nhiệt độ ánh sáng mặt trời gây lên bề mặt da. Bảo vệ da lên đến 5-6 giờ đồng hồ ngoài nắng.",
                        use = "Lấy 1 lượng vừa vủ, dùng bông tẩy trang đánh đều lên bề mặt da.",
                        img = "/image/sp37.jpg"
                    },
                    new SanPham{
                        product_id = 39,
                        product_type_id = 1,
                        brand_id = 8,
                        name = "Innisfree My To Go Cushion",
                        amount = 50,
                        price = 554000,
                        description = "Chứa chiết xuất từ bột tro núi lửa đảo Jeju, hoa atiso và axit hyaluronic giúp tăng cường độ ẩm cho da.Chỉ số chống nắng cao với SPF35 PA++, mang đến cho người sử dụng cảm giác an toàn trong khi tham gia vào những hoạt động ngoài trời.Có độ che phủ tốt lấp đi khuyết điểm về sắc da xạm đen, lỗ chân lông to nhưng lớp nền lại vô cùng mỏng nhẹ và tự nhiên, thoải mái không gây cảm giác nặng mặt.",
                        use = "Ấn nút lấy sản phẩm ở rìa hộp cho đến khi lấy được lượng sản phẩm cần dùng, dùng bông cushion phân bổ đều phấn nước trên dĩa tán rồi bắt đầu dặm phấn nước lên mặt.Dặm nhẹ nhàng phấn từ phần má rồi di chuyển đến vùng trung tâm mặt.Gấp đôi bông cushion lại và bắt đầu dặm những khu vực góc cạnh như khóe mắt, khóe mũi.",
                        img = "/image/sp38.jpg"
                    },
                    new SanPham{
                        product_id = 40,
                        product_type_id = 1,
                        brand_id = 21,
                        name = "Laneige Layering Cover Cushion",
                        amount = 50,
                        price = 665000,
                        description = "Độ che phủ cao và hiệu quả bền màu.Mang lại làn da đều màu và sáng hồng tự nhiên.Có thể điều chỉnh lớp nền lì hoặc sáng bóng tùy theo sở thích của bạn.Sản phẩm mang lại cảm giác ẩm mượt, không gây cảm giác khô, căng da.Chức năng kép: Kem che khuyết điểm: Có khả năng giúp bảo vệ làn da dưới tác hại của tia UV. Phấn nước: Giúp bảo vệ làn da dưới tác hại của tia UV và có khả năng giúp dưỡng trắng da",
                        use = "Sử dụng kem che khuyết điểm để che phủ những vùng da không hoàn hảo.Giúp gương mặt trở nên tươi sáng và hồng hào hơn khi dử dụng LANEIGE Layering Cover Cushion lên toàn bộ gương mặt",
                        img = "/image/sp39.jpg"
                    },
                    new SanPham{
                        product_id = 41,
                        product_type_id = 1,
                        brand_id = 22,
                        name = "Guerlain Lingerie De Peau Liquid",
                        amount = 50,
                        price = 1729000,
                        description = "Guerlain Lingerie De Peau Liquid là kem nền có khả năng che phủ hoàn hảo với chất kem lỏng dễ dàng lướt và tán đều trên da, công thức nhẹ nhàng cho lớp che phủ trông tự nhiên như làn da thứ hai, hòa quyện hoàn hảo với làn da bạn. Sản phẩm mang trong mình những cải tiến tối ưu. Đặc biệt là độ bền cực lâu lên đến 24h. Nhờ đó, bạn vẫn có thể hoạt động cả ngày, đêm mà không lo làn da bị bí bách.",
                        use = "Trước khi dùng kem nền, bạn nên thoa một loại kem lót.Khi thoa kem nền, dùng mũi làm trọng tâm, thoa từ trong ra ngoài. Thoa vùng rộng trước, vùng hẹp sau. Sau đó, thoa thật nhẹ nhàng cho vùng mắt và môi.Nên thoa kem mỏng ở những vùng da quanh mắt và miệng. Thoa kem thật kỹ ở vùng trán và mũi, vì kem ở những vùng này dễ trôi.Khi kết thúc nên sử dụng phấn phủ màu sáng nhấn ở vùng chữ T, màu tối phủ vùng chữ U như thái dương, xương gò má, quai hàm và hai bên gò má.",
                        img = "/image/sp40.jpg"
                    },
                    new SanPham{
                        product_id =42 ,
                        product_type_id = 1,
                        brand_id =23 ,
                        name = "Flawless Finish Everyday Perfection Bouncy Makeup",
                        amount = 50,
                        price = 1270000,
                        description = "Đánh thức làn da hoàn hảo và tràn đầy sức sống với hộp phấn nén Elizabeth Arden với chất phấn nhẹ như không, nhanh chóng cung cấp năng lượng để trẻ hóa và phục hồi làn da tuổi thanh xuân của bạn. Các chất làm mát có trong sản phẩm giúp xoa dịu những làn da mệt mỏi, xỉn màu và thiếu sức sống với công thúc bouncy-gel giúp làm đều màu da, hoàn thiện kết cấu của da cho lớp phấn trông tự nhiên nhất có thể. Hãng đã sử dụng công thức nén độc đáo tạo thành kết cấu phấn đàn hồi như gel giúp bám da tốt, duy trì khả năng che phủ hoàn hảo trong nhiều giờ, mang đến cho bạn làn da sáng mịn, tự nhiên.",
                        use = "Dùng bông lấy một lượng phấn vừa đủ và nhẹ nhàng tán đều lên mặt từ giữa ra xung quanh.Có thể dặm thêm ở các vùng cần che phủ nhiều hơn.Bảo quản nơi khô ráo, thoáng mát, tránh ánh nắng trực tiếp và nhiệt độ cao",
                        img = "/image/sp41.jpg"
                    },
                    new SanPham{
                        product_id =43 ,
                        product_type_id = 1,
                        brand_id = 9,
                        name = "Sisley Phyto Teint Expert",
                        amount = 50,
                        price = 781000,
                        description = "Sisley Phyto Teint Expert là kem nền giúp da trắng sáng, đều màu, che khuyết điểm hiệu quả và giữ màu suốt 12h. Hơn nữa, sản phẩm còn có tinh chất dưỡng ẩm, chống lão hóa, mang lại làn da mềm mại, mịn màng hơn. Kem không chứa dầu, không gây nhờn dính, phù hợp cho mọi loại da, ngay cả với làn da mụn.",
                        use = "Lấy một lượng vừa đủ ra tay, thoa nhẹ lên vùng da và cổ. Sử dụng sau các bước làm sạch da",
                        img = "/image/sp42.jpg"
                    },
                    new SanPham{
                        product_id = 44,
                        product_type_id = 1,
                        brand_id = 9,
                        name = "Sisley Phyto-Fluid Foundation Oil",
                        amount = 50,
                        price = 731000,
                        description = "Sisley Phyto-Fluid Foundation Oil là loại kem nền lâu trôi giúp da trắng sáng, đều màu, che khuyết điểm hiệu quả. Hơn nữa, sản phẩm còn có tinh chất dưỡng ẩm, chống lão hóa, mang lại làn da mềm mại, mịn màng hơn. Kem không chứa dầu, không gây nhờn dính, phù hợp cho mọi loại da, ngay cả với làn da mụn. Thành phần chiết xuất cây sơn trà, cây gỗ và hoa Linden, mang lại cảm giác như làn da đang được ngậm nước đầy ẩm mượt và mềm mịn.",
                        use = "Lấy một lượng vừa đủ ra tay, thoa nhẹ lên vùng da và cổ. Sử dụng sau các bước làm sạch da",
                        img = "/image/sp43.jpg"
                    },
                    new SanPham{
                        product_id =45 ,
                        product_type_id = 1,
                        brand_id = 24,
                        name = "L'OREAL INFALLIBLE Total Cover Foundation",
                        amount = 50,
                        price = 270000,
                        description = "Sản phẩm có kết cấu dạng mouse mềm mịn, khi lên da sẽ tạo cảm giác nhẹ nhàng và vô cùng mượt mà vừa mỏng nhẹ lại thoải mái. Có khả năng che phủ và bền màu lên đến 24h, phù hợp với những người bận rộn không có thời gian dặm lại nhiều lần. Bổ sung chất dưỡng ẩm để giữ cho lớp nền bền lâu, tuy nhiên nếu là da khô thì vẫn nên lưu ý về việc dưỡng ẩm trước khi sử dụng.",
                        use = "Nhẹ nhàng tán đều kem nền lên da bằng mút hoặc cọ nền, tập trung vào vùng chữ T.",
                        img = "/image/sp44.jpg"
                    },
                    new SanPham{
                        product_id = 46,
                        product_type_id = 1,
                        brand_id = 25,
                        name = "Eglips Apple Fit Blusher",
                        amount = 50,
                        price = 171000,
                        description = "Eglips Apple Fit Blusher là phấn má hồng dạng nén khi đánh không bị vón cục cho bạn một màu má hồng thật đẹp. Hạt phấn siêu mịn có khả năng hấp thụ bã nhờn và hút mồ hôi đồng thời còn giúp che phủ khuyết điểm như lỗ chân lông to, da thiếu sức sống.., với màu sắc nổi trội bạn có thể cảm nhận được màu sắc rạng rỡ và sống động trên đôi má của mình. Eglips Apple Fit Blusher ngoài việc sử dụng làm phấn má thì còn có thể sử dụng như phấn mắt, đánh highlight và làm phấn phủ.",
                        use = "Chỉ đánh vùng tròn giữa má tạo đôi má hồng dễ thương.Đánh phấn hơi xếch lên tạo gương mặt cô gái cá tính",
                        img = "/image/sp45.jpg"
                    },
                    new SanPham{
                        product_id = 47,
                        product_type_id = 1,
                        brand_id = 25,
                        name = "Eglips Oil Cut Powder Pact",
                        amount = 50,
                        price = 289000,
                        description = "Eglips Oil Cut Powder Pact là phấn phủ dạng nén với những hạt phấn sáng lấp lánh tạo một lớp phủ mịn màng cho khuôn mặt. Sản phẩm có khả năng kiểm soát dầu nhờn hiệu quả, mang lại làn da sạch mịn và duy trì lớp nền mịn nhẹ tự nhiên suốt cả ngày. Chiết xuất các thành phần tự nhiên như hoa oải hương, hương thảo, húng tây, bạc hà,.. giúp nhẹ nhàng nuôi dưỡng làn da đồng thời giảm thiểu khả năng gây ích ứng da và làm dịu da. Màu beige natural phù hợp với mọi tông da. Hộp phấn nhỏ gọn tiện lợi giúp bạn dễ dàng mang theo bên mình, kèm theo đó là thiết kế bông phấn cao cấp siêu mềm giúp lớp phủ bám dính hoàn hảo và đều màu.",
                        use = "Sử dụng phấn nén phủ ở bước cuối cùng để hoàn tất lớp trang điểm, chú ý phủ kỹ ở những vùng bị dầu nhiều, tạo lớp trang điểm nhẹ nhàng hàng ngày.Bạn có thể xịt một lớp xịt khoáng trang điểm để lớp nền được bền màu khi hoạt động lâu ở ngoài trời.Bảo quản : Nơi khô thoáng, tránh ánh nắng trực tiếp",
                        img = "/image/sp46.jpg"
                    },
                    new SanPham{
                        product_id =48 ,
                        product_type_id = 1,
                        brand_id = 25,
                        name = "Eglips Glow Powder Pact",
                        amount = 50,
                        price = 209000 ,
                        description = "Eglips Glow Powder Pact là phấn phủ dạng nén với những hạt phấn sáng lấp lánh tạo một lớp phủ mịn màng cho khuôn mặt. Sản phẩm có khả năng kiểm soát dầu nhờn hiệu quả, mang lại làn da sạch mịn và duy trì lớp nền mịn nhẹ tự nhiên suốt cả ngày, đồng thời làm da sáng rạng rỡ, lấp lánh và đầy nổi bật. Chiết xuất các thành phần tự nhiên như hoa oải hương, hương thảo, húng tây, bạc hà,.. giúp nhẹ nhàng nuôi dưỡng làn da, giảm thiểu khả năng gây ích ứng da và làm dịu da. Màu pitch pink với các hạt phấn chứa ngọc trai làm trắng da hiệu quả, tạo độ căng bóng hồng hào cho làn da.",
                        use = "Sử dụng phấn nén phủ ở bước cuối cùng để hoàn tất lớp trang điểm, chú ý phủ kỹ ở những vùng bị dầu nhiều, tạo lớp trang điểm nhẹ nhàng hàng ngày.Bạn có thể xịt một lớp xịt khoáng trang điểm để lớp nền được bền màu khi hoạt động lâu ở ngoài trời.Bảo quản : Nơi khô thoáng, tránh ánh nắng trực tiếp.",
                        img = "/image/sp47.jpg"
                    },
                    new SanPham{
                        product_id = 49,
                        product_type_id = 1,
                        brand_id = 5,
                        name = "Eglips Blur Powder Pact",
                        amount = 50,
                        price = 209000,
                        description = "Phấn nén tự nhiên có màu, kềm dầu giúp che khuyết điểm và nhẹ nhàng làm tan biến những nỗi lo về da như nếp nhăn, lỗ chân lông to, da sần sùi, mang lại làn da láng mịn làm bạn cứ muốn chạm vào mãi. Công thức lecithin coating với độ bám dính phù hợp giúp da láng mịn một cách tự nhiên, cùng với các hạt phấn mịn giúp che phủ tốt những khuyết điểm trên da. Thành phần chứa thạch anh tím, bột ngọc trai phản xạ ánh sáng giúp da rạng rỡ tươi tắn.",
                        use = "Sử dụng phấn nén phủ ở bước cuối cùng để hoàn tất lớp trang điểm, chú ý phủ kỹ ở những vùng bị dầu nhiều, tạo lớp trang điểm nhẹ nhàng hàng ngày. Bạn có thể xịt một lớp xịt khoáng trang điểm để lớp nền được bền màu khi hoạt động lâu ở ngoài trời. Bảo quản : Nơi khô thoáng, tránh ánh nắng trực tiếp.",
                        img = "/image/sp48.jpg"
                    },
                    new SanPham{
                        product_id = 50,
                        product_type_id = 1,
                        brand_id = 8,
                        name = "Innisfree No-Sebum Blur Powder",
                        amount = 50,
                        price =153000 ,
                        description = "Phấn phủ kiềm dầu, che khuyết điểm Innisfree No-sebum Blur Powder thuộc dòng mĩ phẩm hỗ trợ việc trang điểm, được thiết kế đặc biệt dành cho da nhạy cảm, da tiết quá nhiều dầu hoặc gặp rắc rối về mụn. Hướng đến đối tượng sử dụng là những người có làn da nhạy cảm, nhiều dầu nhờn, phấn phủ kiềm dầu, che khuyết điểm Innisfree No-sebum Blur Powder được bào chế từ các thành phần tự nhiên như muối khoáng, tinh chất trà xanh, tinh chất bạc hà… nên hoàn toàn lành tính, hạn chế gây kích ứng da. Thêm vào đó, sản phẩm còn được bổ sung vitamin và khoáng chất giúp nuôi dưỡng da khỏe mạnh, bảo vệ trước tác động nguy hại từ môi trường.",
                        use = "Dùng ở bước trang điểm cuối cùng hoặc khi da bóng nhờn. Dùng bông phấn lấy lượng vừa đủ và nhẹ nhàng tán đều lên da, cho đến khi phấn bao phủ hết khuôn mặt.",
                        img = "/image/sp49.jpg"
                    } ,
                    new SanPham{
                        product_id =51 ,
                        product_type_id = 1,
                        brand_id = 26,
                        name = "SILKYGIRL MAGIC BB OIL CONTROL",
                        amount = 50,
                        price =  136000 ,
                        description = "Phấn phủ Silkygirl Magic BB Oil chứa chiết xuất cây cọ lùn và trái hồng giúp thấm hút dầu thừa và hạn chế tiết bã nhờn, cho làn da mịn màng, không còn bóng dầu đồng thời còn có khả năng chống nắng với SPF 45/PA++ giúp bảo vệ làn da dưới tác hại của ánh mặt trời. Sản phẩm không dầu, khống bóng nhờn, không mùi, không làm tắc nghẽn lỗ chân lông và không thử nghiệm trên động vật. Được sản xuất dành riêng cho làn da châu Á.",
                        use = "Dùng bông phấn đi kèm lấy một lượng phấn vừa đủ và dặm đều lên mặt. Bảo quản nơi khô ráo, thoáng mát, tránh ánh nắng trực tiếp và nhiệt độ cao",
                        img = "/image/sp50.jpg"
                    } ,
                    new SanPham{
                        product_id = 52,
                        product_type_id = 1,
                        brand_id =8,
                        name = "Innisfree No Sebum Mineral Powder",
                        amount = 50,
                        price = 171000 ,
                        description = "Phấn Phủ Bột kiềm dầu Innisfree No Sebum Mineral Powder là loại phấn khoáng dạng bột, chiết xuất 100% từ bạc hà và hạt ngọc trai, có khả năng hút dầu rất tốt. Phấn có tông màu trong suốt nên rất dễ tiệp với tất cả các tone da và không ảnh hưởng đến tông màu của các phấn trang điểm khác. Sản phẩm có màu trắng trong suốt, lên da không có màu, giúp bạn có làn da sáng nhẹ. Công thức kiểm soát dầu nhờn vượt trội, giữ được lớp makeup lâu trôi đến 24 giờ đồng hồ. Đặc biệt, sản phẩm có khả năng tạo độ ẩm cân bằng trên da giúp da thông thoáng không bị bí dầu.",
                        use = "Sau khi áp dụng lớp kem nền và hoàn thiện gương mặt bằng kem che khuyết điểm, bạn có thể sử dụng phấn phủ để kết thúc lớp nền. Dùng cọ nhúng bột phấn. Lắc nhẹ cọ cho bột phấn thừa rơi ra sau đó nhẹ nhàng phủ bầu mắt và toàn bộ gương mặt cho thật đều.",
                        img = "/image/sp51.jpg"
                    } ,
                    new SanPham{
                        product_id = 53,
                        product_type_id = 1,
                        brand_id =7 ,
                        name = "MISSHA The Style Defining Blusher",
                        amount = 50,
                        price =  240000,
                        description = "Màu sắc hợp thời trang, tạo đường nét sống động tự nhiên cho khuôn mặt. Công nghệ Air Jet Mill tạo hạt phấn mịn đều bám nhẹ nhàng và mềm mại trên làn da và giữ cho lớp trang điểm bền màu. Chứa bột màu ngọc bích cho đường nét xinh đẹp tự nhiên, kết hợp cùng với một số thành phần giàu dưỡng chất như chiết xuất xoài, bear berry, trái bí,.... giúp bổ sung độ ẩm cho lớp trang điểm mềm mịn, tự nhiên.",
                        use = "Dùng sau khi hoàn thành các bước trang điểm. Dùng bông phấn hoặc cọ chấm một lượng vừa đủ để tạo độ hồng tự nhiên",
                        img = "/image/sp52.jpg"
                    } ,
                    new SanPham{
                        product_id =54 ,
                        product_type_id = 1,
                        brand_id =1 ,
                        name = "lustre Pro Eyeshadow Magnetic Palette Case",
                        amount = 50,
                        price = 157999 ,
                        description = "Một bảng màu phấn mắt 16 khe trống, có thể đổ lại, có thể được tùy chỉnh với chảo phấn mắt yêu thích của bạn.",
                        use = "Sử dụng bảng màu để lưu trữ Luster Pro Pressed của bạn.",
                        img = "/image/sp53.jpg"
                    } ,
                    new SanPham{
                        product_id = 55,
                        product_type_id = 1,
                        brand_id = 27,
                        name = "Refillable Makeup Case",
                        amount = 50,
                        price = 245000 ,
                        description = "Tùy chỉnh hộp trang điểm của riêng bạn.",
                        use = "Tùy chỉnh hộp trang điểm của riêng bạn.",
                        img = "/image/sp54.jpg"
                    } ,
                    new SanPham{
                        product_id =56 ,
                        product_type_id = 1,
                        brand_id = 1,
                        name = "LUSTRE MAKEUP",
                        amount = 50,
                        price =  760000,
                        description = "Tùy chỉnh hộp trang điểm của riêng bạn.",
                        use = "Tùy chỉnh hộp trang điểm của riêng bạn.",
                        img = "/image/sp55.jpg"
                    } ,
                    new SanPham{
                        product_id = 57,
                        product_type_id = 1,
                        brand_id = 9 ,
                        name = "Sisley Phyto-Blush Eclat - 4 Pinky Rose",
                        amount = 50,
                        price = 250000 ,
                        description = "Siêu mịn chiết xuất thành phần từ ngọc trai, ánh nhũ lấp lánh đa năng vừa có thể làm highlight cho mặt vừa có thể làm nhũ mắt.Sử dụng trên mặt mộc để tạo hiệu ứng bắt sáng nhẹ nhàng , hoặc phủ lên lớp phấn phủ hoặc kem tạo khối yêu thích của bạn.",
                        use = "Đánh lớp phấn nền cho da trước khi sử dụng sản phẩm. Dùng miếng puff lấy phấn (hoặc dùng tay) tán lên phần xương gò má và kéo dài lên thái dương để khuôn mặt cân đối mà không cần dùng đến highlight.",
                        img = "/image/sp56.jpg"
                    } ,
                    new SanPham{
                        product_id =58 ,
                        product_type_id = 1,
                        brand_id = 28,
                        name = "Aritaum Sugar Ball Cushion Blusher - 01 Posy Pink",
                        amount = 50,
                        price = 650000 ,
                        description = "Siêu mịn chiết xuất thành phần từ ngọc trai, ánh nhũ lấp lánh đa năng vừa có thể làm highlight cho mặt vừa có thể làm nhũ mắt.Sử dụng trên mặt mộc để tạo hiệu ứng bắt sáng nhẹ nhàng , hoặc phủ lên lớp phấn phủ hoặc kem tạo khối yêu thích của bạn.",
                        use = "Đánh lớp phấn nền cho da trước khi sử dụng sản phẩm. Dùng miếng puff lấy phấn (hoặc dùng tay) tán lên phần xương gò má và kéo dài lên thái dương để khuôn mặt cân đối mà không cần dùng đến highlight.",
                        img = "/image/sp57.jpg"
                    } ,
                    new SanPham{
                        product_id =59 ,
                        product_type_id = 1,
                        brand_id = 29,
                        name = "LOVE 3CE CHEEK MAKER",
                        amount = 50,
                        price = 76000 ,
                        description = "Siêu mịn chiết xuất thành phần từ ngọc trai, ánh nhũ lấp lánh đa năng vừa có thể làm highlight cho mặt vừa có thể làm nhũ mắt.Sử dụng trên mặt mộc để tạo hiệu ứng bắt sáng nhẹ nhàng , hoặc phủ lên lớp phấn phủ hoặc kem tạo khối yêu thích của bạn.",
                        use = "Đánh lớp phấn nền cho da trước khi sử dụng sản phẩm. Dùng miếng puff lấy phấn (hoặc dùng tay) tán lên phần xương gò má và kéo dài lên thái dương để khuôn mặt cân đối mà không cần dùng đến highlight.",
                        img = "/image/sp58.jpg"
                    } ,
                    new SanPham{
                        product_id =60 ,
                        product_type_id = 1,
                        brand_id = 1,
                        name = "Lustre PRO Pressed Blush - Pink Nude",
                        amount = 50,
                        price =  279000,
                        description = "Siêu mịn chiết xuất thành phần từ ngọc trai, ánh nhũ lấp lánh đa năng vừa có thể làm highlight cho mặt vừa có thể làm nhũ mắt.Sử dụng trên mặt mộc để tạo hiệu ứng bắt sáng nhẹ nhàng , hoặc phủ lên lớp phấn phủ hoặc kem tạo khối yêu thích của bạn.",
                        use = "Đánh lớp phấn nền cho da trước khi sử dụng sản phẩm. Dùng miếng puff lấy phấn (hoặc dùng tay) tán lên phần xương gò má và kéo dài lên thái dương để khuôn mặt cân đối mà không cần dùng đến highlight.",
                        img = "/image/sp59.jpg"
                    } ,
                    new SanPham{
                        product_id =61 ,
                        product_type_id = 1,
                        brand_id = 30,
                        name = "Kaleido Cosmetics Astrolight - Electric",
                        amount = 50,
                        price =  740000,
                        description = "Siêu mịn chiết xuất thành phần từ ngọc trai, ánh nhũ lấp lánh đa năng vừa có thể làm highlight cho mặt vừa có thể làm nhũ mắt.Sử dụng trên mặt mộc để tạo hiệu ứng bắt sáng nhẹ nhàng , hoặc phủ lên lớp phấn phủ hoặc kem tạo khối yêu thích của bạn.",
                        use = "Đánh lớp phấn nền cho da trước khi sử dụng sản phẩm. Dùng miếng puff lấy phấn (hoặc dùng tay) tán lên phần xương gò má và kéo dài lên thái dương để khuôn mặt cân đối mà không cần dùng đến highlight.",
                        img = "/image/sp60.jpg"
                    } ,
                    new SanPham{
                        product_id = 62,
                        product_type_id = 1,
                        brand_id = 31,
                        name = "Stila Glitter",
                        amount = 50,
                        price = 300000 ,
                        description = "Siêu mịn chiết xuất thành phần từ ngọc trai, ánh nhũ lấp lánh đa năng vừa có thể làm highlight cho mặt vừa có thể làm nhũ mắt.Sử dụng trên mặt mộc để tạo hiệu ứng bắt sáng nhẹ nhàng , hoặc phủ lên lớp phấn phủ hoặc kem tạo khối yêu thích của bạn.",
                        use = "Đánh lớp phấn nền cho da trước khi sử dụng sản phẩm. Dùng miếng puff lấy phấn (hoặc dùng tay) tán lên phần xương gò má và kéo dài lên thái dương để khuôn mặt cân đối mà không cần dùng đến highlight.",
                        img = "/image/sp61.jpg"
                    } ,
                    new SanPham{
                        product_id =63 ,
                        product_type_id = 1,
                        brand_id = 1,
                        name = "Lustre Pro Eyeshadow Magnetic Palette Case",
                        amount = 50,
                        price = 200000 ,
                        description = "Siêu mịn chiết xuất thành phần từ ngọc trai, ánh nhũ lấp lánh đa năng vừa có thể làm highlight cho mặt vừa có thể làm nhũ mắt.Sử dụng trên mặt mộc để tạo hiệu ứng bắt sáng nhẹ nhàng , hoặc phủ lên lớp phấn phủ hoặc kem tạo khối yêu thích của bạn.",
                        use = "Đánh lớp phấn nền cho da trước khi sử dụng sản phẩm. Dùng miếng puff lấy phấn (hoặc dùng tay) tán lên phần xương gò má và kéo dài lên thái dương để khuôn mặt cân đối mà không cần dùng đến highlight.",
                        img = "/image/sp62.jpg"
                    } ,
                    new SanPham{
                        product_id = 64,
                        product_type_id = 1,
                        brand_id = 1,
                        name = "Pressed Highlighter - Sun Kissed",
                        amount = 50,
                        price = 240000 ,
                        description = "Siêu mịn chiết xuất thành phần từ ngọc trai, ánh nhũ lấp lánh đa năng vừa có thể làm highlight cho mặt vừa có thể làm nhũ mắt.Sử dụng trên mặt mộc để tạo hiệu ứng bắt sáng nhẹ nhàng , hoặc phủ lên lớp phấn phủ hoặc kem tạo khối yêu thích của bạn.",
                        use = "Đánh lớp phấn nền cho da trước khi sử dụng sản phẩm. Dùng miếng puff lấy phấn (hoặc dùng tay) tán lên phần xương gò má và kéo dài lên thái dương để khuôn mặt cân đối mà không cần dùng đến highlight.",
                        img = "/image/sp63.jpg"
                    } ,
                    new SanPham{
                        product_id =65 ,
                        product_type_id = 1,
                        brand_id =1 ,
                        name = "Pressed Bronzer - Salsa",
                        amount = 50,
                        price = 94000 ,
                        description = "Siêu mịn chiết xuất thành phần từ ngọc trai, ánh nhũ lấp lánh đa năng vừa có thể làm highlight cho mặt vừa có thể làm nhũ mắt.Sử dụng trên mặt mộc để tạo hiệu ứng bắt sáng nhẹ nhàng , hoặc phủ lên lớp phấn phủ hoặc kem tạo khối yêu thích của bạn.",
                        use = "Đánh lớp phấn nền cho da trước khi sử dụng sản phẩm. Dùng miếng puff lấy phấn (hoặc dùng tay) tán lên phần xương gò má và kéo dài lên thái dương để khuôn mặt cân đối mà không cần dùng đến highlight.",
                        img = "/image/sp64.jpg"
                    } ,
                    new SanPham{
                        product_id = 66,
                        product_type_id = 1,
                        brand_id =32 ,
                        name = "Cover FX Contour Kit - Medium",
                        amount = 50,
                        price = 349000 ,
                        description = "Siêu mịn chiết xuất thành phần từ ngọc trai, ánh nhũ lấp lánh đa năng vừa có thể làm highlight cho mặt vừa có thể làm nhũ mắt.Sử dụng trên mặt mộc để tạo hiệu ứng bắt sáng nhẹ nhàng , hoặc phủ lên lớp phấn phủ hoặc kem tạo khối yêu thích của bạn.",
                        use = "Đánh lớp phấn nền cho da trước khi sử dụng sản phẩm. Dùng miếng puff lấy phấn (hoặc dùng tay) tán lên phần xương gò má và kéo dài lên thái dương để khuôn mặt cân đối mà không cần dùng đến highlight.",
                        img = "/image/sp65.jpg"
                    },
                    new SanPham{
                        product_id =67 ,
                        product_type_id = 1,
                        brand_id = 33,
                        name = "Anastasia Beverly Hills Glow Kit - Ultimate Glow",
                        amount = 50,
                        price = 349000 ,
                        description = "Màu sắc tỏa sáng giúp đôi môi trông căng mọng, và rạng rỡ. Độ bóng cao giúp đôi môi trông tươi tắn, mềm mại. Kết cấu mềm mại sẽ giữ cho đôi môi được dưỡng ẩm và thoải mái trong nhiều giờ. Lấy cảm hứng từ 10 loại màu đá tự nhiên sẽ mang lại may mắn cho đôi môi của bạn",
                        use = "Son dưỡng môi là loại son bạn có thể dùng mỗi ngày để bảo vệ cho đôi môi luôn căng mọng, khi thời tiết bắt đầu lạnh, hanh khô hay trước khi trang điểm chính là những lúc quan trọng bạn cần sử dụng đến son dưỡng môi.Trước khi tô son dưỡng môi, việc bạn cần làm là làm sạch đôi môi, lau hết vết lớp son cũ để chắc chắn rằng không có bụi bẩn bám lại, sau đó hãy thoa một lớp son dưỡng mới. Khi môi đã thoa son, hãy nhớ rằng nên trách việc tiếp xúc với thức ăn, nước uống.Ngoài dùng son dưỡng môi, chúng ta cũng có thể đắp mặt nạ cho môi từ thiên nhiên, loại bỏ tế bào chết cho đôi môi bóng mượt. Và đừng quên rằng hãy uống thật nhiều nước.",
                        img = "/image/sp66.jpg"
                    },
                    new SanPham{
                        product_id = 68,
                        product_type_id = 1,
                        brand_id = 33,
                        name = "Anastasia Beverly Hills Contour Cream Kit",
                        amount = 50,
                        price = 349000 ,
                        description = "Màu sắc tỏa sáng giúp đôi môi trông căng mọng, và rạng rỡ. Độ bóng cao giúp đôi môi trông tươi tắn, mềm mại. Kết cấu mềm mại sẽ giữ cho đôi môi được dưỡng ẩm và thoải mái trong nhiều giờ. Lấy cảm hứng từ 10 loại màu đá tự nhiên sẽ mang lại may mắn cho đôi môi của bạn",
                        use = "Son dưỡng môi là loại son bạn có thể dùng mỗi ngày để bảo vệ cho đôi môi luôn căng mọng, khi thời tiết bắt đầu lạnh, hanh khô hay trước khi trang điểm chính là những lúc quan trọng bạn cần sử dụng đến son dưỡng môi.Trước khi tô son dưỡng môi, việc bạn cần làm là làm sạch đôi môi, lau hết vết lớp son cũ để chắc chắn rằng không có bụi bẩn bám lại, sau đó hãy thoa một lớp son dưỡng mới. Khi môi đã thoa son, hãy nhớ rằng nên trách việc tiếp xúc với thức ăn, nước uống.Ngoài dùng son dưỡng môi, chúng ta cũng có thể đắp mặt nạ cho môi từ thiên nhiên, loại bỏ tế bào chết cho đôi môi bóng mượt. Và đừng quên rằng hãy uống thật nhiều nước.",
                        img = "/image/sp67.jpg"
                    },
                    new SanPham{
                        product_id =69 ,
                        product_type_id = 1,
                        brand_id = 21,
                        name = "Laneige Stained Glasstick",
                        amount = 50,
                        price = 349000 ,
                        description = "Màu sắc tỏa sáng giúp đôi môi trông căng mọng, và rạng rỡ. Độ bóng cao giúp đôi môi trông tươi tắn, mềm mại. Kết cấu mềm mại sẽ giữ cho đôi môi được dưỡng ẩm và thoải mái trong nhiều giờ. Lấy cảm hứng từ 10 loại màu đá tự nhiên sẽ mang lại may mắn cho đôi môi của bạn",
                        use = "Son dưỡng môi là loại son bạn có thể dùng mỗi ngày để bảo vệ cho đôi môi luôn căng mọng, khi thời tiết bắt đầu lạnh, hanh khô hay trước khi trang điểm chính là những lúc quan trọng bạn cần sử dụng đến son dưỡng môi.Trước khi tô son dưỡng môi, việc bạn cần làm là làm sạch đôi môi, lau hết vết lớp son cũ để chắc chắn rằng không có bụi bẩn bám lại, sau đó hãy thoa một lớp son dưỡng mới. Khi môi đã thoa son, hãy nhớ rằng nên trách việc tiếp xúc với thức ăn, nước uống.Ngoài dùng son dưỡng môi, chúng ta cũng có thể đắp mặt nạ cho môi từ thiên nhiên, loại bỏ tế bào chết cho đôi môi bóng mượt. Và đừng quên rằng hãy uống thật nhiều nước.",
                        img = "/image/sp68.jpg"
                    },
                    new SanPham{
                        product_id = 70,
                        product_type_id = 1,
                        brand_id = 8,
                        name = "Innisfree Glow Tint Lip Balm",
                        amount = 50,
                        price = 349000 ,
                        description = "Màu sắc tỏa sáng giúp đôi môi trông căng mọng, và rạng rỡ. Độ bóng cao giúp đôi môi trông tươi tắn, mềm mại. Kết cấu mềm mại sẽ giữ cho đôi môi được dưỡng ẩm và thoải mái trong nhiều giờ. Lấy cảm hứng từ 10 loại màu đá tự nhiên sẽ mang lại may mắn cho đôi môi của bạn",
                        use = "Son dưỡng môi là loại son bạn có thể dùng mỗi ngày để bảo vệ cho đôi môi luôn căng mọng, khi thời tiết bắt đầu lạnh, hanh khô hay trước khi trang điểm chính là những lúc quan trọng bạn cần sử dụng đến son dưỡng môi.Trước khi tô son dưỡng môi, việc bạn cần làm là làm sạch đôi môi, lau hết vết lớp son cũ để chắc chắn rằng không có bụi bẩn bám lại, sau đó hãy thoa một lớp son dưỡng mới. Khi môi đã thoa son, hãy nhớ rằng nên trách việc tiếp xúc với thức ăn, nước uống.Ngoài dùng son dưỡng môi, chúng ta cũng có thể đắp mặt nạ cho môi từ thiên nhiên, loại bỏ tế bào chết cho đôi môi bóng mượt. Và đừng quên rằng hãy uống thật nhiều nước.",
                        img = "/image/sp69.jpg"
                    },
                    new SanPham{
                        product_id = 71,
                        product_type_id = 1,
                        brand_id =34 ,
                        name = "Dior Addict Lip Glow",
                        amount = 50,
                        price = 349000 ,
                        description = "Màu sắc tỏa sáng giúp đôi môi trông căng mọng, và rạng rỡ. Độ bóng cao giúp đôi môi trông tươi tắn, mềm mại. Kết cấu mềm mại sẽ giữ cho đôi môi được dưỡng ẩm và thoải mái trong nhiều giờ. Lấy cảm hứng từ 10 loại màu đá tự nhiên sẽ mang lại may mắn cho đôi môi của bạn",
                        use = "Son dưỡng môi là loại son bạn có thể dùng mỗi ngày để bảo vệ cho đôi môi luôn căng mọng, khi thời tiết bắt đầu lạnh, hanh khô hay trước khi trang điểm chính là những lúc quan trọng bạn cần sử dụng đến son dưỡng môi.Trước khi tô son dưỡng môi, việc bạn cần làm là làm sạch đôi môi, lau hết vết lớp son cũ để chắc chắn rằng không có bụi bẩn bám lại, sau đó hãy thoa một lớp son dưỡng mới. Khi môi đã thoa son, hãy nhớ rằng nên trách việc tiếp xúc với thức ăn, nước uống.Ngoài dùng son dưỡng môi, chúng ta cũng có thể đắp mặt nạ cho môi từ thiên nhiên, loại bỏ tế bào chết cho đôi môi bóng mượt. Và đừng quên rằng hãy uống thật nhiều nước.",
                        img = "/image/sp70.jpg"
                    },
                    new SanPham{
                        product_id =72 ,
                        product_type_id = 1,
                        brand_id = 21,
                        name = "Laneige Lip Sleeping Mask",
                        amount = 50,
                        price = 194000 ,
                        description = "Nhẹ nhàng loại bỏ lớp da môi bị khô, nứt nẻ, nuôi dưỡng và bảo vệ làn môi bạn bằng Vitamin E, Bơ Hạt Mỡ, các thành phần chiết xuất trong quả Lê, quả Nho, Hạt dầu Jojoba, và Sáp Copernicia Cerifera làm môi mềm mượt, tươi tắn và tràn đầy sức sống. Sản phẩm có vị ngọt từ đường nâu là sản phẩm đầu tiên của dòng son tấy tế bào chết cho môi e.l.f",
                        use = "Có thể đáNh son dưới lớp son màu để tạo độ tươi tắn và sáng cho môi. Có thể chỉ cần đánh son dưỡng mà không cần dùng gì thêm cũng đủ làm cho khuôn mặt bừng sáng.",
                        img = "/image/sp71.jpg"
                    },
                    new SanPham{
                        product_id =73 ,
                        product_type_id = 1,
                        brand_id =35 ,
                        name = "Son Tẩy Da Chết Môi E.L.F Lip Exfoliator",
                        amount = 50,
                        price = 752000 ,
                        description = "Nhẹ nhàng loại bỏ lớp da môi bị khô, nứt nẻ, nuôi dưỡng và bảo vệ làn môi bạn bằng Vitamin E, Bơ Hạt Mỡ, các thành phần chiết xuất trong quả Lê, quả Nho, Hạt dầu Jojoba, và Sáp Copernicia Cerifera làm môi mềm mượt, tươi tắn và tràn đầy sức sống. Sản phẩm có vị ngọt từ đường nâu là sản phẩm đầu tiên của dòng son tấy tế bào chết cho môi e.l.f",
                        use = "Có thể đáNh son dưới lớp son màu để tạo độ tươi tắn và sáng cho môi. Có thể chỉ cần đánh son dưỡng mà không cần dùng gì thêm cũng đủ làm cho khuôn mặt bừng sáng.",
                        img = "/image/sp72.jpg"
                    },
                    new SanPham{
                        product_id =74 ,
                        product_type_id = 1,
                        brand_id = 29,
                        name = "3CE VELVET LIP TINT",
                        amount = 50,
                        price = 927000 ,
                        description = "Nhẹ nhàng loại bỏ lớp da môi bị khô, nứt nẻ, nuôi dưỡng và bảo vệ làn môi bạn bằng Vitamin E, Bơ Hạt Mỡ, các thành phần chiết xuất trong quả Lê, quả Nho, Hạt dầu Jojoba, và Sáp Copernicia Cerifera làm môi mềm mượt, tươi tắn và tràn đầy sức sống. Sản phẩm có vị ngọt từ đường nâu là sản phẩm đầu tiên của dòng son tấy tế bào chết cho môi e.l.f",
                        use = "Có thể đáNh son dưới lớp son màu để tạo độ tươi tắn và sáng cho môi. Có thể chỉ cần đánh son dưỡng mà không cần dùng gì thêm cũng đủ làm cho khuôn mặt bừng sáng.",
                        img = "/image/sp73.jpg"
                    },
                    new SanPham{
                        product_id = 75,
                        product_type_id = 1,
                        brand_id = 36,
                        name = "YSL Vinyl Cream Lip Stain",
                        amount = 50,
                        price = 727000 ,
                        description = "Đầu cọ nhỏ nhắn, thon dài giúp dễ dàng thoa son. Son có độ lên màu rực rỡ từ lần lướt đầu tiên.Sau khi son khô lớp finish bắt dầu giảm độ bóng và trở nên mịn mượt hơn.Son cũng không gây cảm giác bết dính hay làm khô môi mà tạo cảm giác rất thoải mái.",
                        use = "Có thể đánh son dưới lớp son màu để tạo độ tươi tắn và sáng cho môi. Có thể chỉ cần đánh son dưỡng mà không cần dùng gì thêm cũng đủ làm cho khuôn mặt bừng sáng.",
                        img = "/image/sp74.jpg"
                    },
                    new SanPham{
                        product_id =76 ,
                        product_type_id = 1,
                        brand_id =37 ,
                        name = "Nars Velvet Lip Glide Le Pala",
                        amount = 50,
                        price = 127000 ,
                        description = "Đầu cọ nhỏ nhắn, thon dài giúp dễ dàng thoa son. Son có độ lên màu rực rỡ từ lần lướt đầu tiên.Sau khi son khô lớp finish bắt dầu giảm độ bóng và trở nên mịn mượt hơn.Son cũng không gây cảm giác bết dính hay làm khô môi mà tạo cảm giác rất thoải mái.",
                        use = "Có thể đánh son dưới lớp son màu để tạo độ tươi tắn và sáng cho môi. Có thể chỉ cần đánh son dưỡng mà không cần dùng gì thêm cũng đủ làm cho khuôn mặt bừng sáng.",
                        img = "/image/sp75.jpg"
                    },
                    new SanPham{
                        product_id = 77,
                        product_type_id = 1,
                        brand_id = 21,
                        name = "Laneige Tattoo Lip Tint",
                        amount = 50,
                        price = 1227000 ,
                        description = "Đầu cọ nhỏ nhắn, thon dài giúp dễ dàng thoa son. Son có độ lên màu rực rỡ từ lần lướt đầu tiên.Sau khi son khô lớp finish bắt dầu giảm độ bóng và trở nên mịn mượt hơn.Son cũng không gây cảm giác bết dính hay làm khô môi mà tạo cảm giác rất thoải mái.",
                        use = "Có thể đánh son dưới lớp son màu để tạo độ tươi tắn và sáng cho môi. Có thể chỉ cần đánh son dưỡng mà không cần dùng gì thêm cũng đủ làm cho khuôn mặt bừng sáng.",
                        img = "/image/sp76.jpg"
                    },
                    new SanPham{
                        product_id = 78,
                        product_type_id = 1,
                        brand_id =8 ,
                        name = "Innisfree Vivid Oil Tint",
                        amount = 50,
                        price = 927000 ,
                        description = "Đầu cọ nhỏ nhắn, thon dài giúp dễ dàng thoa son. Son có độ lên màu rực rỡ từ lần lướt đầu tiên.Sau khi son khô lớp finish bắt dầu giảm độ bóng và trở nên mịn mượt hơn.Son cũng không gây cảm giác bết dính hay làm khô môi mà tạo cảm giác rất thoải mái.",
                        use = "Có thể đánh son dưới lớp son màu để tạo độ tươi tắn và sáng cho môi. Có thể chỉ cần đánh son dưỡng mà không cần dùng gì thêm cũng đủ làm cho khuôn mặt bừng sáng.",
                        img = "/image/sp77.jpg"
                    },
                    new SanPham{
                        product_id =79 ,
                        product_type_id = 1,
                        brand_id = 25 ,
                        name = "Eglips Velvet Fit Tint",
                        amount = 50,
                        price = 327000 ,
                        description = "Đầu cọ nhỏ nhắn, thon dài giúp dễ dàng thoa son. Son có độ lên màu rực rỡ từ lần lướt đầu tiên.Sau khi son khô lớp finish bắt dầu giảm độ bóng và trở nên mịn mượt hơn.Son cũng không gây cảm giác bết dính hay làm khô môi mà tạo cảm giác rất thoải mái.",
                        use = "Có thể đánh son dưới lớp son màu để tạo độ tươi tắn và sáng cho môi. Có thể chỉ cần đánh son dưỡng mà không cần dùng gì thêm cũng đủ làm cho khuôn mặt bừng sáng.",
                        img = "/image/sp78.jpg"
                    },
                    new SanPham{
                        product_id = 80,
                        product_type_id = 1,
                        brand_id = 8,
                        name = "Innisfree Vivid Cotton Ink",
                        amount = 50,
                        price = 627000 ,
                        description = "Đầu cọ nhỏ nhắn, thon dài giúp dễ dàng thoa son. Son có độ lên màu rực rỡ từ lần lướt đầu tiên.Sau khi son khô lớp finish bắt dầu giảm độ bóng và trở nên mịn mượt hơn.Son cũng không gây cảm giác bết dính hay làm khô môi mà tạo cảm giác rất thoải mái.",
                        use = "Có thể đánh son dưới lớp son màu để tạo độ tươi tắn và sáng cho môi. Có thể chỉ cần đánh son dưỡng mà không cần dùng gì thêm cũng đủ làm cho khuôn mặt bừng sáng.",
                        img = "/image/sp79.jpg"
                    },
                    new SanPham{
                        product_id = 81,
                        product_type_id = 1,
                        brand_id = 6,
                        name = "M.A.C RETRO MATTE LIQUID LIPCOLOUR",
                        amount = 50,
                        price = 627000 ,
                        description = "Đầu cọ nhỏ nhắn, thon dài giúp dễ dàng thoa son. Son có độ lên màu rực rỡ từ lần lướt đầu tiên.Sau khi son khô lớp finish bắt dầu giảm độ bóng và trở nên mịn mượt hơn.Son cũng không gây cảm giác bết dính hay làm khô môi mà tạo cảm giác rất thoải mái.",
                        use = "Có thể đánh son dưới lớp son màu để tạo độ tươi tắn và sáng cho môi. Có thể chỉ cần đánh son dưỡng mà không cần dùng gì thêm cũng đủ làm cho khuôn mặt bừng sáng.",
                        img = "/image/sp80.jpg"
                    },
                    new SanPham{
                        product_id =82 ,
                        product_type_id = 1,
                        brand_id = 7,
                        name = "MISSHA M Glossy Lip Rouge SPF13 GBE01",
                        amount = 50,
                        price = 865000 ,
                        description = "Đầu cọ nhỏ nhắn, thon dài giúp dễ dàng thoa son. Son có độ lên màu rực rỡ từ lần lướt đầu tiên.Sau khi son khô lớp finish bắt dầu giảm độ bóng và trở nên mịn mượt hơn.Son cũng không gây cảm giác bết dính hay làm khô môi mà tạo cảm giác rất thoải mái.",
                        use = "Có thể đánh son dưới lớp son màu để tạo độ tươi tắn và sáng cho môi. Có thể chỉ cần đánh son dưỡng mà không cần dùng gì thêm cũng đủ làm cho khuôn mặt bừng sáng.",
                        img = "/image/sp81.jpg"
                    },
                    new SanPham{
                        product_id = 83,
                        product_type_id = 1,
                        brand_id =38 ,
                        name = "Lime Crime DIAMOND CRUSHERS - Unicorn",
                        amount = 50,
                        price = 207000 ,
                        description = "Đầu cọ nhỏ nhắn, thon dài giúp dễ dàng thoa son. Son có độ lên màu rực rỡ từ lần lướt đầu tiên.Sau khi son khô lớp finish bắt dầu giảm độ bóng và trở nên mịn mượt hơn.Son cũng không gây cảm giác bết dính hay làm khô môi mà tạo cảm giác rất thoải mái.",
                        use = "Có thể đánh son dưới lớp son màu để tạo độ tươi tắn và sáng cho môi. Có thể chỉ cần đánh son dưỡng mà không cần dùng gì thêm cũng đủ làm cho khuôn mặt bừng sáng.",
                        img = "/image/sp82.jpg"
                    },
                    new SanPham{
                        product_id =84 ,
                        product_type_id = 1,
                        brand_id = 34,
                        name = "Dior Addict Lip Glow - 004 Coral",
                        amount = 50,
                        price =920000 ,
                        description = "Đầu cọ nhỏ nhắn, thon dài giúp dễ dàng thoa son. Son có độ lên màu rực rỡ từ lần lướt đầu tiên.Sau khi son khô lớp finish bắt dầu giảm độ bóng và trở nên mịn mượt hơn.Son cũng không gây cảm giác bết dính hay làm khô môi mà tạo cảm giác rất thoải mái.",
                        use = "Có thể đánh son dưới lớp son màu để tạo độ tươi tắn và sáng cho môi. Có thể chỉ cần đánh son dưỡng mà không cần dùng gì thêm cũng đủ làm cho khuôn mặt bừng sáng.",
                        img = "/image/sp83.jpg"
                    },
                    new SanPham{
                        product_id = 85,
                        product_type_id = 1,
                        brand_id = 19,
                        name = "Julep Lip Gloss - Lively",
                        amount = 50,
                        price = 127000 ,
                        description = "Đầu cọ nhỏ nhắn, thon dài giúp dễ dàng thoa son. Son có độ lên màu rực rỡ từ lần lướt đầu tiên.Sau khi son khô lớp finish bắt dầu giảm độ bóng và trở nên mịn mượt hơn.Son cũng không gây cảm giác bết dính hay làm khô môi mà tạo cảm giác rất thoải mái.",
                        use = "Có thể đánh son dưới lớp son màu để tạo độ tươi tắn và sáng cho môi. Có thể chỉ cần đánh son dưỡng mà không cần dùng gì thêm cũng đủ làm cho khuôn mặt bừng sáng.",
                        img = "/image/sp84.jpg"
                    },
                    new SanPham{
                        product_id = 86,
                        product_type_id = 1,
                        brand_id =8 ,
                        name = "Innisfree Vivid Oil Tint - 5 Brown Cherry",
                        amount = 50,
                        price = 182000 ,
                        description = "Chất chì mềm mượt, lâu trôi giúp định hình tạo cảm giác đôi môi thêm căng mọng hơn. Thành phần chứa vitamin E và bơ hạt mỡ giúp nuôi dưỡng đôi môi trong suốt thời gian sử dụng. Gồm nhiều tone màu thời trang, dễ dàng kết hợp nhiều màu son khác nhau.",
                        use = "Kẻ đường viền quanh môi trước khi thoa son tạo màu trong lòng môi",
                        img = "/image/sp85.jpg"
                    },
                    new SanPham{
                        product_id = 87,
                        product_type_id = 1,
                        brand_id =7 ,
                        name = "MISSHA Silky Lasting Lip Pencil",
                        amount = 50,
                        price = 290000 ,
                        description = "Chất chì mềm mượt, lâu trôi giúp định hình tạo cảm giác đôi môi thêm căng mọng hơn. Thành phần chứa vitamin E và bơ hạt mỡ giúp nuôi dưỡng đôi môi trong suốt thời gian sử dụng. Gồm nhiều tone màu thời trang, dễ dàng kết hợp nhiều màu son khác nhau.",
                        use = "Kẻ đường viền quanh môi trước khi thoa son tạo màu trong lòng môi",
                        img = "/image/sp86.jpg"
                    },
                    new SanPham{
                        product_id =88 ,
                        product_type_id = 1,
                        brand_id = 26,
                        name = "SILKYGIRL LONG WEARING 05 WINE",
                        amount = 50,
                        price = 627000 ,
                        description = "Chất chì mềm mượt, lâu trôi giúp định hình tạo cảm giác đôi môi thêm căng mọng hơn. Thành phần chứa vitamin E và bơ hạt mỡ giúp nuôi dưỡng đôi môi trong suốt thời gian sử dụng. Gồm nhiều tone màu thời trang, dễ dàng kết hợp nhiều màu son khác nhau.",
                        use = "Kẻ đường viền quanh môi trước khi thoa son tạo màu trong lòng môi",
                        img = "/image/sp87.jpg"
                    },
                    new SanPham{
                        product_id = 89,
                        product_type_id = 1,
                        brand_id =9 ,
                        name = "Sisley Phyto-Levres Perfect 5 Burgundy",
                        amount = 50,
                        price =123000 ,
                        description = "Chất chì mềm mượt, lâu trôi giúp định hình tạo cảm giác đôi môi thêm căng mọng hơn. Thành phần chứa vitamin E và bơ hạt mỡ giúp nuôi dưỡng đôi môi trong suốt thời gian sử dụng. Gồm nhiều tone màu thời trang, dễ dàng kết hợp nhiều màu son khác nhau.",
                        use = "Kẻ đường viền quanh môi trước khi thoa son tạo màu trong lòng môi",
                        img = "/image/sp88.jpg"
                    },
                    new SanPham{
                        product_id = 90,
                        product_type_id = 1,
                        brand_id =39 ,
                        name = "Tarte Tarteist Lip Crayon",
                        amount = 50,
                        price = 1290000 ,
                        description = "Chất chì mềm mượt, lâu trôi giúp định hình tạo cảm giác đôi môi thêm căng mọng hơn. Thành phần chứa vitamin E và bơ hạt mỡ giúp nuôi dưỡng đôi môi trong suốt thời gian sử dụng. Gồm nhiều tone màu thời trang, dễ dàng kết hợp nhiều màu son khác nhau.",
                        use = "Kẻ đường viền quanh môi trước khi thoa son tạo màu trong lòng môi",
                        img = "/image/sp89.jpg"
                    },
                    new SanPham{
                        product_id =91 ,
                        product_type_id = 2,
                        brand_id = 38,
                        name = "Zelens Cleansing Liquid Balm",
                        amount = 50,
                        price = 1900000 ,
                        description = "Khai thác hiệu quả tuyệt vời của dầu tầm xuân giàu vitamin, sản phẩm có thể lấy đi lớp trang điểm mắt nhẹ nhàng, giúp làm dịu da để giúp giảm những dấu hiệu của sự lão hóa, đảm bảo độ ẩm và điều trị các vết đỏ . Sản phẩm nhẹ nhàng cho làn da nhạy cảm Hàm lượng cao chất chống oxy hóa và vitamin A, E, và K Giúp cải thiện sự xuất hiện của các nếp nhăn và giữ ẩm da.",
                        use = "Thoa một lượng nhỏ sữa rửa mặt để mặt ẩm ướt. Sử dụng với một miếng bông ướt để loại bỏ trang điểm mắt. Rửa sạch hoàn toàn bằng nước. Không sử dụng với những vết thương hở",
                        img = "/image/sp90.jpg"
                    },
                    new SanPham{
                        product_id =92 ,
                        product_type_id = 2,
                        brand_id = 39,
                        name = "OKAME Peat Purifying Cleansing Water",
                        amount = 50,
                        price = 297000 ,
                        description = "Khai thác hiệu quả tuyệt vời của dầu tầm xuân giàu vitamin, sản phẩm có thể lấy đi lớp trang điểm mắt nhẹ nhàng, giúp làm dịu da để giúp giảm những dấu hiệu của sự lão hóa, đảm bảo độ ẩm và điều trị các vết đỏ . Sản phẩm nhẹ nhàng cho làn da nhạy cảm Hàm lượng cao chất chống oxy hóa và vitamin A, E, và K Giúp cải thiện sự xuất hiện của các nếp nhăn và giữ ẩm da.",
                        use = "Thoa một lượng nhỏ sữa rửa mặt để mặt ẩm ướt. Sử dụng với một miếng bông ướt để loại bỏ trang điểm mắt. Rửa sạch hoàn toàn bằng nước. Không sử dụng với những vết thương hở",
                        img = "/image/sp91.jpg"
                    },
                    new SanPham{
                        product_id =93 ,
                        product_type_id = 2,
                        brand_id =40 ,
                        name = "Byphasse Solution Micellaire",
                        amount = 50,
                        price = 131000 ,
                        description = "Khai thác hiệu quả tuyệt vời của dầu tầm xuân giàu vitamin, sản phẩm có thể lấy đi lớp trang điểm mắt nhẹ nhàng, giúp làm dịu da để giúp giảm những dấu hiệu của sự lão hóa, đảm bảo độ ẩm và điều trị các vết đỏ . Sản phẩm nhẹ nhàng cho làn da nhạy cảm Hàm lượng cao chất chống oxy hóa và vitamin A, E, và K Giúp cải thiện sự xuất hiện của các nếp nhăn và giữ ẩm da.",
                        use = "Thoa một lượng nhỏ sữa rửa mặt để mặt ẩm ướt. Sử dụng với một miếng bông ướt để loại bỏ trang điểm mắt. Rửa sạch hoàn toàn bằng nước. Không sử dụng với những vết thương hở",
                        img = "/image/sp92.jpg"
                    },
                    new SanPham{
                        product_id = 94,
                        product_type_id = 2,
                        brand_id =41 ,
                        name = "Clinique Take The Day Off",
                        amount = 50,
                        price = 227000 ,
                        description = "Khai thác hiệu quả tuyệt vời của dầu tầm xuân giàu vitamin, sản phẩm có thể lấy đi lớp trang điểm mắt nhẹ nhàng, giúp làm dịu da để giúp giảm những dấu hiệu của sự lão hóa, đảm bảo độ ẩm và điều trị các vết đỏ . Sản phẩm nhẹ nhàng cho làn da nhạy cảm Hàm lượng cao chất chống oxy hóa và vitamin A, E, và K Giúp cải thiện sự xuất hiện của các nếp nhăn và giữ ẩm da.",
                        use = "Thoa một lượng nhỏ sữa rửa mặt để mặt ẩm ướt. Sử dụng với một miếng bông ướt để loại bỏ trang điểm mắt. Rửa sạch hoàn toàn bằng nước. Không sử dụng với những vết thương hở",
                        img = "/image/sp93.jpg"
                    },
                    new SanPham{
                        product_id = 95,
                        product_type_id = 2,
                        brand_id =42 ,
                        name = "Bioderma Créaline H2O 250 ML",
                        amount = 50,
                        price = 282000 ,
                        description = "Khai thác hiệu quả tuyệt vời của dầu tầm xuân giàu vitamin, sản phẩm có thể lấy đi lớp trang điểm mắt nhẹ nhàng, giúp làm dịu da để giúp giảm những dấu hiệu của sự lão hóa, đảm bảo độ ẩm và điều trị các vết đỏ . Sản phẩm nhẹ nhàng cho làn da nhạy cảm Hàm lượng cao chất chống oxy hóa và vitamin A, E, và K Giúp cải thiện sự xuất hiện của các nếp nhăn và giữ ẩm da.",
                        use = "Thoa một lượng nhỏ sữa rửa mặt để mặt ẩm ướt. Sử dụng với một miếng bông ướt để loại bỏ trang điểm mắt. Rửa sạch hoàn toàn bằng nước. Không sử dụng với những vết thương hở",
                        img = "/image/sp94.jpg"
                    },
                    new SanPham{
                        product_id = 96,
                        product_type_id = 2,
                        brand_id =42 ,
                        name = "Bioderma Créaline H2O 100 ML",
                        amount = 50,
                        price = 200000 ,
                        description = "Khai thác hiệu quả tuyệt vời của dầu tầm xuân giàu vitamin, sản phẩm có thể lấy đi lớp trang điểm mắt nhẹ nhàng, giúp làm dịu da để giúp giảm những dấu hiệu của sự lão hóa, đảm bảo độ ẩm và điều trị các vết đỏ . Sản phẩm nhẹ nhàng cho làn da nhạy cảm Hàm lượng cao chất chống oxy hóa và vitamin A, E, và K Giúp cải thiện sự xuất hiện của các nếp nhăn và giữ ẩm da.",
                        use = "Thoa một lượng nhỏ sữa rửa mặt để mặt ẩm ướt. Sử dụng với một miếng bông ướt để loại bỏ trang điểm mắt. Rửa sạch hoàn toàn bằng nước. Không sử dụng với những vết thương hở",
                        img = "/image/sp95.jpg"
                    },
                    new SanPham{
                        product_id = 97,
                        product_type_id = 2,
                        brand_id = 42,
                        name = "Bioderma Sebium H2O 100 Ml",
                        amount = 50,
                        price = 127000 ,
                        description = "Khai thác hiệu quả tuyệt vời của dầu tầm xuân giàu vitamin, sản phẩm có thể lấy đi lớp trang điểm mắt nhẹ nhàng, giúp làm dịu da để giúp giảm những dấu hiệu của sự lão hóa, đảm bảo độ ẩm và điều trị các vết đỏ . Sản phẩm nhẹ nhàng cho làn da nhạy cảm Hàm lượng cao chất chống oxy hóa và vitamin A, E, và K Giúp cải thiện sự xuất hiện của các nếp nhăn và giữ ẩm da.",
                        use = "Thoa một lượng nhỏ sữa rửa mặt để mặt ẩm ướt. Sử dụng với một miếng bông ướt để loại bỏ trang điểm mắt. Rửa sạch hoàn toàn bằng nước. Không sử dụng với những vết thương hở",
                        img = "/image/sp96.jpg"
                    },
                    new SanPham{
                        product_id = 98,
                        product_type_id = 2,
                        brand_id = 43,
                        name = "DHC Deep Cleansing Oil - 70 Ml",
                        amount = 50,
                        price = 827000 ,
                        description = "Khai thác hiệu quả tuyệt vời của dầu tầm xuân giàu vitamin, sản phẩm có thể lấy đi lớp trang điểm mắt nhẹ nhàng, giúp làm dịu da để giúp giảm những dấu hiệu của sự lão hóa, đảm bảo độ ẩm và điều trị các vết đỏ . Sản phẩm nhẹ nhàng cho làn da nhạy cảm Hàm lượng cao chất chống oxy hóa và vitamin A, E, và K Giúp cải thiện sự xuất hiện của các nếp nhăn và giữ ẩm da.",
                        use = "Thoa một lượng nhỏ sữa rửa mặt để mặt ẩm ướt. Sử dụng với một miếng bông ướt để loại bỏ trang điểm mắt. Rửa sạch hoàn toàn bằng nước. Không sử dụng với những vết thương hở",
                        img = "/image/sp97.jpg"
                    },
                    new SanPham{
                        product_id =99 ,
                        product_type_id = 2,
                        brand_id =44 ,
                        name = "Mad Hippie Exfoliating Serum 30ml",
                        amount = 50,
                        price = 627000 ,
                        description = "Khai thác hiệu quả tuyệt vời của dầu tầm xuân giàu vitamin, sản phẩm có thể lấy đi lớp trang điểm mắt nhẹ nhàng, giúp làm dịu da để giúp giảm những dấu hiệu của sự lão hóa, đảm bảo độ ẩm và điều trị các vết đỏ . Sản phẩm nhẹ nhàng cho làn da nhạy cảm Hàm lượng cao chất chống oxy hóa và vitamin A, E, và K Giúp cải thiện sự xuất hiện của các nếp nhăn và giữ ẩm da.",
                        use = "Thoa một lượng nhỏ sữa rửa mặt để mặt ẩm ướt. Sử dụng với một miếng bông ướt để loại bỏ trang điểm mắt. Rửa sạch hoàn toàn bằng nước. Không sử dụng với những vết thương hở",
                        img = "/image/sp98.jpg"
                    },
                    new SanPham{
                        product_id = 100,
                        product_type_id = 2,
                        brand_id = 45,
                        name = "Huxley Spa Routine Kit",
                        amount = 50,
                        price = 627000 ,
                        description = "Khai thác hiệu quả tuyệt vời của dầu tầm xuân giàu vitamin, sản phẩm có thể lấy đi lớp trang điểm mắt nhẹ nhàng, giúp làm dịu da để giúp giảm những dấu hiệu của sự lão hóa, đảm bảo độ ẩm và điều trị các vết đỏ . Sản phẩm nhẹ nhàng cho làn da nhạy cảm Hàm lượng cao chất chống oxy hóa và vitamin A, E, và K Giúp cải thiện sự xuất hiện của các nếp nhăn và giữ ẩm da.",
                        use = "Thoa một lượng nhỏ sữa rửa mặt để mặt ẩm ướt. Sử dụng với một miếng bông ướt để loại bỏ trang điểm mắt. Rửa sạch hoàn toàn bằng nước. Không sử dụng với những vết thương hở",
                        img = "/image/sp99.jpg"
                    },
                    new SanPham{
                        product_id = 101,
                        product_type_id = 2,
                        brand_id =46 ,
                        name = "Simple Clear Skin Oil Balancing Facial Scrub",
                        amount = 50,
                        price = 187000 ,
                        description = "Khai thác hiệu quả tuyệt vời của dầu tầm xuân giàu vitamin, sản phẩm có thể lấy đi lớp trang điểm mắt nhẹ nhàng, giúp làm dịu da để giúp giảm những dấu hiệu của sự lão hóa, đảm bảo độ ẩm và điều trị các vết đỏ . Sản phẩm nhẹ nhàng cho làn da nhạy cảm Hàm lượng cao chất chống oxy hóa và vitamin A, E, và K Giúp cải thiện sự xuất hiện của các nếp nhăn và giữ ẩm da.",
                        use = "Thoa một lượng nhỏ sữa rửa mặt để mặt ẩm ướt. Sử dụng với một miếng bông ướt để loại bỏ trang điểm mắt. Rửa sạch hoàn toàn bằng nước. Không sử dụng với những vết thương hở",
                        img = "/image/sp100.jpg"
                    },
                    new SanPham{
                        product_id = 102,
                        product_type_id = 2,
                        brand_id = 47,
                        name = "Slinky Touch Body Milk",
                        amount = 50,
                        price = 292000 ,
                        description = "Khai thác hiệu quả tuyệt vời của dầu tầm xuân giàu vitamin, sản phẩm có thể lấy đi lớp trang điểm mắt nhẹ nhàng, giúp làm dịu da để giúp giảm những dấu hiệu của sự lão hóa, đảm bảo độ ẩm và điều trị các vết đỏ . Sản phẩm nhẹ nhàng cho làn da nhạy cảm Hàm lượng cao chất chống oxy hóa và vitamin A, E, và K Giúp cải thiện sự xuất hiện của các nếp nhăn và giữ ẩm da.",
                        use = "Thoa một lượng nhỏ sữa rửa mặt để mặt ẩm ướt. Sử dụng với một miếng bông ướt để loại bỏ trang điểm mắt. Rửa sạch hoàn toàn bằng nước. Không sử dụng với những vết thương hở",
                        img = "/image/sp101.jpg"
                    },
                    new SanPham{
                        product_id =103 ,
                        product_type_id = 2,
                        brand_id = 48,
                        name = "TSURU HANA HIME – Peeling cream for your nose",
                        amount = 50,
                        price = 627000 ,
                        description = "Khai thác hiệu quả tuyệt vời của dầu tầm xuân giàu vitamin, sản phẩm có thể lấy đi lớp trang điểm mắt nhẹ nhàng, giúp làm dịu da để giúp giảm những dấu hiệu của sự lão hóa, đảm bảo độ ẩm và điều trị các vết đỏ . Sản phẩm nhẹ nhàng cho làn da nhạy cảm Hàm lượng cao chất chống oxy hóa và vitamin A, E, và K Giúp cải thiện sự xuất hiện của các nếp nhăn và giữ ẩm da.",
                        use = "Thoa một lượng nhỏ sữa rửa mặt để mặt ẩm ướt. Sử dụng với một miếng bông ướt để loại bỏ trang điểm mắt. Rửa sạch hoàn toàn bằng nước. Không sử dụng với những vết thương hở",
                        img = "/image/sp102.jpg"
                    },
                    new SanPham{
                        product_id =104 ,
                        product_type_id = 2,
                        brand_id = 43 ,
                        name = "PIXI Glow Mud Cleanser 135ml",
                        amount = 50,
                        price = 627000 ,
                        description = "Khai thác hiệu quả tuyệt vời của dầu tầm xuân giàu vitamin, sản phẩm có thể lấy đi lớp trang điểm mắt nhẹ nhàng, giúp làm dịu da để giúp giảm những dấu hiệu của sự lão hóa, đảm bảo độ ẩm và điều trị các vết đỏ . Sản phẩm nhẹ nhàng cho làn da nhạy cảm Hàm lượng cao chất chống oxy hóa và vitamin A, E, và K Giúp cải thiện sự xuất hiện của các nếp nhăn và giữ ẩm da.",
                        use = "Thoa một lượng nhỏ sữa rửa mặt để mặt ẩm ướt. Sử dụng với một miếng bông ướt để loại bỏ trang điểm mắt. Rửa sạch hoàn toàn bằng nước. Không sử dụng với những vết thương hở",
                        img = "/image/sp103.jpg"
                    },
                    new SanPham{
                        product_id = 105,
                        product_type_id = 2,
                        brand_id = 39,
                        name = "FRESH Soy Face Cleanser To Go Travel Size 50ml ",
                        amount = 50,
                        price = 227000 ,
                        description = "Khai thác hiệu quả tuyệt vời của dầu tầm xuân giàu vitamin, sản phẩm có thể lấy đi lớp trang điểm mắt nhẹ nhàng, giúp làm dịu da để giúp giảm những dấu hiệu của sự lão hóa, đảm bảo độ ẩm và điều trị các vết đỏ . Sản phẩm nhẹ nhàng cho làn da nhạy cảm Hàm lượng cao chất chống oxy hóa và vitamin A, E, và K Giúp cải thiện sự xuất hiện của các nếp nhăn và giữ ẩm da.",
                        use = "Thoa một lượng nhỏ sữa rửa mặt để mặt ẩm ướt. Sử dụng với một miếng bông ướt để loại bỏ trang điểm mắt. Rửa sạch hoàn toàn bằng nước. Không sử dụng với những vết thương hở",
                        img = "/image/sp104.jpg"
                    },
                    new SanPham{
                        product_id =106 ,
                        product_type_id = 2,
                        brand_id =42 ,
                        name = "Peter Thomas Roth Anti - Aging Cleansing Gel 18ml",
                        amount = 50,
                        price = 621000 ,
                        description = "Khai thác hiệu quả tuyệt vời của dầu tầm xuân giàu vitamin, sản phẩm có thể lấy đi lớp trang điểm mắt nhẹ nhàng, giúp làm dịu da để giúp giảm những dấu hiệu của sự lão hóa, đảm bảo độ ẩm và điều trị các vết đỏ . Sản phẩm nhẹ nhàng cho làn da nhạy cảm Hàm lượng cao chất chống oxy hóa và vitamin A, E, và K Giúp cải thiện sự xuất hiện của các nếp nhăn và giữ ẩm da.",
                        use = "Thoa một lượng nhỏ sữa rửa mặt để mặt ẩm ướt. Sử dụng với một miếng bông ướt để loại bỏ trang điểm mắt. Rửa sạch hoàn toàn bằng nước. Không sử dụng với những vết thương hở",
                        img = "/image/sp105.jpg"
                    },
                    new SanPham{
                        product_id =107 ,
                        product_type_id = 2,
                        brand_id = 40,
                        name = "INDIE LEE Rosehip Cleanser 30ml",
                        amount = 50,
                        price = 227000 ,
                        description = "Khai thác hiệu quả tuyệt vời của dầu tầm xuân giàu vitamin, sản phẩm có thể lấy đi lớp trang điểm mắt nhẹ nhàng, giúp làm dịu da để giúp giảm những dấu hiệu của sự lão hóa, đảm bảo độ ẩm và điều trị các vết đỏ . Sản phẩm nhẹ nhàng cho làn da nhạy cảm Hàm lượng cao chất chống oxy hóa và vitamin A, E, và K Giúp cải thiện sự xuất hiện của các nếp nhăn và giữ ẩm da.",
                        use = "Thoa một lượng nhỏ sữa rửa mặt để mặt ẩm ướt. Sử dụng với một miếng bông ướt để loại bỏ trang điểm mắt. Rửa sạch hoàn toàn bằng nước. Không sử dụng với những vết thương hở",
                        img = "/image/sp106.jpg"
                    },
                    new SanPham{
                        product_id = 108,
                        product_type_id = 2,
                        brand_id = 18,
                        name = "Some By Mi AHA-BHA-PHA 30 Days Miracle Acne Clear Foam 100ml",
                        amount = 50,
                        price = 877000 ,
                        description = "Khai thác hiệu quả tuyệt vời của dầu tầm xuân giàu vitamin, sản phẩm có thể lấy đi lớp trang điểm mắt nhẹ nhàng, giúp làm dịu da để giúp giảm những dấu hiệu của sự lão hóa, đảm bảo độ ẩm và điều trị các vết đỏ . Sản phẩm nhẹ nhàng cho làn da nhạy cảm Hàm lượng cao chất chống oxy hóa và vitamin A, E, và K Giúp cải thiện sự xuất hiện của các nếp nhăn và giữ ẩm da.",
                        use = "Thoa một lượng nhỏ sữa rửa mặt để mặt ẩm ướt. Sử dụng với một miếng bông ướt để loại bỏ trang điểm mắt. Rửa sạch hoàn toàn bằng nước. Không sử dụng với những vết thương hở",
                        img = "/image/sp107.jpg"
                    },
                    new SanPham{
                        product_id = 109,
                        product_type_id = 2,
                        brand_id = 19,
                        name = "Mario Badescu Botanical Facial gel - 472ml",
                        amount = 50,
                        price = 254000 ,
                        description = "Khai thác hiệu quả tuyệt vời của dầu tầm xuân giàu vitamin, sản phẩm có thể lấy đi lớp trang điểm mắt nhẹ nhàng, giúp làm dịu da để giúp giảm những dấu hiệu của sự lão hóa, đảm bảo độ ẩm và điều trị các vết đỏ . Sản phẩm nhẹ nhàng cho làn da nhạy cảm Hàm lượng cao chất chống oxy hóa và vitamin A, E, và K Giúp cải thiện sự xuất hiện của các nếp nhăn và giữ ẩm da.",
                        use = "Thoa một lượng nhỏ sữa rửa mặt để mặt ẩm ướt. Sử dụng với một miếng bông ướt để loại bỏ trang điểm mắt. Rửa sạch hoàn toàn bằng nước. Không sử dụng với những vết thương hở",
                        img = "/image/sp108.jpg"
                    },
                    new SanPham{
                        product_id =110,
                        product_type_id = 2,
                        brand_id = 19 ,
                        name = "Mario Badescu Enzyme Cleansing Gel - 236 ml",
                        amount = 50,
                        price = 68000 ,
                        description = "Khai thác hiệu quả tuyệt vời của dầu tầm xuân giàu vitamin, sản phẩm có thể lấy đi lớp trang điểm mắt nhẹ nhàng, giúp làm dịu da để giúp giảm những dấu hiệu của sự lão hóa, đảm bảo độ ẩm và điều trị các vết đỏ . Sản phẩm nhẹ nhàng cho làn da nhạy cảm Hàm lượng cao chất chống oxy hóa và vitamin A, E, và K Giúp cải thiện sự xuất hiện của các nếp nhăn và giữ ẩm da.",
                        use = "Thoa một lượng nhỏ sữa rửa mặt để mặt ẩm ướt. Sử dụng với một miếng bông ướt để loại bỏ trang điểm mắt. Rửa sạch hoàn toàn bằng nước. Không sử dụng với những vết thương hở",
                        img = "/image/sp109.jpg"
                    },
                    new SanPham{
                        product_id = 111,
                        product_type_id = 2,
                        brand_id = 39,
                        name = "Elta MD FOAMING FACIAL CLEANSER",
                        amount = 50,
                        price = 327000 ,
                        description = "Khai thác hiệu quả tuyệt vời của dầu tầm xuân giàu vitamin, sản phẩm có thể lấy đi lớp trang điểm mắt nhẹ nhàng, giúp làm dịu da để giúp giảm những dấu hiệu của sự lão hóa, đảm bảo độ ẩm và điều trị các vết đỏ . Sản phẩm nhẹ nhàng cho làn da nhạy cảm Hàm lượng cao chất chống oxy hóa và vitamin A, E, và K Giúp cải thiện sự xuất hiện của các nếp nhăn và giữ ẩm da.",
                        use = "Thoa một lượng nhỏ sữa rửa mặt để mặt ẩm ướt. Sử dụng với một miếng bông ướt để loại bỏ trang điểm mắt. Rửa sạch hoàn toàn bằng nước. Không sử dụng với những vết thương hở",
                        img = "/image/sp110.jpg"
                    },
                    new SanPham{
                        product_id =112 ,
                        product_type_id = 2,
                        brand_id =19 ,
                        name = "The Drunk Elephant Detective Game",
                        amount = 50,
                        price = 643000 ,
                        description = "Khai thác hiệu quả tuyệt vời của dầu tầm xuân giàu vitamin, sản phẩm có thể lấy đi lớp trang điểm mắt nhẹ nhàng, giúp làm dịu da để giúp giảm những dấu hiệu của sự lão hóa, đảm bảo độ ẩm và điều trị các vết đỏ . Sản phẩm nhẹ nhàng cho làn da nhạy cảm Hàm lượng cao chất chống oxy hóa và vitamin A, E, và K Giúp cải thiện sự xuất hiện của các nếp nhăn và giữ ẩm da.",
                        use = "Thoa một lượng nhỏ sữa rửa mặt để mặt ẩm ướt. Sử dụng với một miếng bông ướt để loại bỏ trang điểm mắt. Rửa sạch hoàn toàn bằng nước. Không sử dụng với những vết thương hở",
                        img = "/image/sp111.jpg"
                    },
                    new SanPham{
                        product_id = 113,
                        product_type_id = 2,
                        brand_id =39 ,
                        name = "Naruko Tea Tree Blemish Clear Makeup Removing Cleansing Mousse 150 ml",
                        amount = 50,
                        price = 60000 ,
                        description = "Khai thác hiệu quả tuyệt vời của dầu tầm xuân giàu vitamin, sản phẩm có thể lấy đi lớp trang điểm mắt nhẹ nhàng, giúp làm dịu da để giúp giảm những dấu hiệu của sự lão hóa, đảm bảo độ ẩm và điều trị các vết đỏ . Sản phẩm nhẹ nhàng cho làn da nhạy cảm Hàm lượng cao chất chống oxy hóa và vitamin A, E, và K Giúp cải thiện sự xuất hiện của các nếp nhăn và giữ ẩm da.",
                        use = "Thoa một lượng nhỏ sữa rửa mặt để mặt ẩm ướt. Sử dụng với một miếng bông ướt để loại bỏ trang điểm mắt. Rửa sạch hoàn toàn bằng nước. Không sử dụng với những vết thương hở",
                        img = "/image/sp112.jpg"
                    },
                    new SanPham{
                        product_id = 114,
                        product_type_id = 2,
                        brand_id = 39,
                        name = "Naruko Tea Tree Purifying Clay Mask and Cleanser 3 in 1 120 gr",
                        amount = 50,
                        price = 92000 ,
                        description = "Khai thác hiệu quả tuyệt vời của dầu tầm xuân giàu vitamin, sản phẩm có thể lấy đi lớp trang điểm mắt nhẹ nhàng, giúp làm dịu da để giúp giảm những dấu hiệu của sự lão hóa, đảm bảo độ ẩm và điều trị các vết đỏ . Sản phẩm nhẹ nhàng cho làn da nhạy cảm Hàm lượng cao chất chống oxy hóa và vitamin A, E, và K Giúp cải thiện sự xuất hiện của các nếp nhăn và giữ ẩm da.",
                        use = "Thoa một lượng nhỏ sữa rửa mặt để mặt ẩm ướt. Sử dụng với một miếng bông ướt để loại bỏ trang điểm mắt. Rửa sạch hoàn toàn bằng nước. Không sử dụng với những vết thương hở",
                        img = "/image/sp113.jpg"
                    },
                    new SanPham{
                        product_id = 115,
                        product_type_id = 2,
                        brand_id =8 ,
                        name = "Innisfree Green tea foam cleanser 150mL",
                        amount = 50,
                        price = 127000 ,
                        description = "Khai thác hiệu quả tuyệt vời của dầu tầm xuân giàu vitamin, sản phẩm có thể lấy đi lớp trang điểm mắt nhẹ nhàng, giúp làm dịu da để giúp giảm những dấu hiệu của sự lão hóa, đảm bảo độ ẩm và điều trị các vết đỏ . Sản phẩm nhẹ nhàng cho làn da nhạy cảm Hàm lượng cao chất chống oxy hóa và vitamin A, E, và K Giúp cải thiện sự xuất hiện của các nếp nhăn và giữ ẩm da.",
                        use = "Thoa một lượng nhỏ sữa rửa mặt để mặt ẩm ướt. Sử dụng với một miếng bông ướt để loại bỏ trang điểm mắt. Rửa sạch hoàn toàn bằng nước. Không sử dụng với những vết thương hở",
                        img = "/image/sp114.jpg"
                    },
                    new SanPham{
                        product_id =116 ,
                        product_type_id = 2,
                        brand_id = 2,
                        name = "EMMA HARDIE SKINCARE Moringa Cleansing Balm with Cleansing Cloth ",
                        amount = 50,
                        price = 622000 ,
                        description = "Khai thác hiệu quả tuyệt vời của dầu tầm xuân giàu vitamin, sản phẩm có thể lấy đi lớp trang điểm mắt nhẹ nhàng, giúp làm dịu da để giúp giảm những dấu hiệu của sự lão hóa, đảm bảo độ ẩm và điều trị các vết đỏ . Sản phẩm nhẹ nhàng cho làn da nhạy cảm Hàm lượng cao chất chống oxy hóa và vitamin A, E, và K Giúp cải thiện sự xuất hiện của các nếp nhăn và giữ ẩm da.",
                        use = "Thoa một lượng nhỏ sữa rửa mặt để mặt ẩm ướt. Sử dụng với một miếng bông ướt để loại bỏ trang điểm mắt. Rửa sạch hoàn toàn bằng nước. Không sử dụng với những vết thương hở",
                        img = "/image/sp115.jpg"
                    },
                    new SanPham{
                        product_id = 117,
                        product_type_id = 2,
                        brand_id =15 ,
                        name = "Paula's Choice Perfect Cleansing Oil",
                        amount = 50,
                        price = 27000 ,
                        description = "Khai thác hiệu quả tuyệt vời của dầu tầm xuân giàu vitamin, sản phẩm có thể lấy đi lớp trang điểm mắt nhẹ nhàng, giúp làm dịu da để giúp giảm những dấu hiệu của sự lão hóa, đảm bảo độ ẩm và điều trị các vết đỏ . Sản phẩm nhẹ nhàng cho làn da nhạy cảm Hàm lượng cao chất chống oxy hóa và vitamin A, E, và K Giúp cải thiện sự xuất hiện của các nếp nhăn và giữ ẩm da.",
                        use = "Thoa một lượng nhỏ sữa rửa mặt để mặt ẩm ướt. Sử dụng với một miếng bông ướt để loại bỏ trang điểm mắt. Rửa sạch hoàn toàn bằng nước. Không sử dụng với những vết thương hở",
                        img = "/image/sp116.jpg"
                    },
                    new SanPham{
                        product_id =118 ,
                        product_type_id = 2,
                        brand_id =9 ,
                        name = "Sisley Cleansing Milk With Sage 250ml",
                        amount = 50,
                        price = 627000 ,
                        description = "Khai thác hiệu quả tuyệt vời của dầu tầm xuân giàu vitamin, sản phẩm có thể lấy đi lớp trang điểm mắt nhẹ nhàng, giúp làm dịu da để giúp giảm những dấu hiệu của sự lão hóa, đảm bảo độ ẩm và điều trị các vết đỏ . Sản phẩm nhẹ nhàng cho làn da nhạy cảm Hàm lượng cao chất chống oxy hóa và vitamin A, E, và K Giúp cải thiện sự xuất hiện của các nếp nhăn và giữ ẩm da.",
                        use = "Thoa một lượng nhỏ sữa rửa mặt để mặt ẩm ướt. Sử dụng với một miếng bông ướt để loại bỏ trang điểm mắt. Rửa sạch hoàn toàn bằng nước. Không sử dụng với những vết thương hở",
                        img = "/image/sp117.jpg"
                    },
                    new SanPham{
                        product_id = 119,
                        product_type_id = 2,
                        brand_id = 25,
                        name = "Cosrx Low PH Good Morning Gel Cleanser 150 ml",
                        amount = 50,
                        price = 267000 ,
                        description = "Khai thác hiệu quả tuyệt vời của dầu tầm xuân giàu vitamin, sản phẩm có thể lấy đi lớp trang điểm mắt nhẹ nhàng, giúp làm dịu da để giúp giảm những dấu hiệu của sự lão hóa, đảm bảo độ ẩm và điều trị các vết đỏ . Sản phẩm nhẹ nhàng cho làn da nhạy cảm Hàm lượng cao chất chống oxy hóa và vitamin A, E, và K Giúp cải thiện sự xuất hiện của các nếp nhăn và giữ ẩm da.",
                        use = "Thoa một lượng nhỏ sữa rửa mặt để mặt ẩm ướt. Sử dụng với một miếng bông ướt để loại bỏ trang điểm mắt. Rửa sạch hoàn toàn bằng nước. Không sử dụng với những vết thương hở",
                        img = "/image/sp118.jpg"
                    },
                    new SanPham{
                        product_id = 120,
                        product_type_id = 2,
                        brand_id = 20,
                        name = "TWOSOME SET 3",
                        amount = 50,
                        price = 2911000 ,
                        description = "Khai thác hiệu quả tuyệt vời của dầu tầm xuân giàu vitamin, sản phẩm có thể lấy đi lớp trang điểm mắt nhẹ nhàng, giúp làm dịu da để giúp giảm những dấu hiệu của sự lão hóa, đảm bảo độ ẩm và điều trị các vết đỏ . Sản phẩm nhẹ nhàng cho làn da nhạy cảm Hàm lượng cao chất chống oxy hóa và vitamin A, E, và K Giúp cải thiện sự xuất hiện của các nếp nhăn và giữ ẩm da.",
                        use = "Thoa một lượng nhỏ sữa rửa mặt để mặt ẩm ướt. Sử dụng với một miếng bông ướt để loại bỏ trang điểm mắt. Rửa sạch hoàn toàn bằng nước. Không sử dụng với những vết thương hở",
                        img = "/image/sp119.jpg"
                    },
                    new SanPham{
                        product_id = 121,
                        product_type_id = 2,
                        brand_id = 39,
                        name = "Naruko RJT Supercritical CO2 Pore Minimizing and Brightening Lotion 150 ml",
                        amount = 50,
                        price = 627000 ,
                        description = "Khai thác hiệu quả tuyệt vời của dầu tầm xuân giàu vitamin, sản phẩm có thể lấy đi lớp trang điểm mắt nhẹ nhàng, giúp làm dịu da để giúp giảm những dấu hiệu của sự lão hóa, đảm bảo độ ẩm và điều trị các vết đỏ . Sản phẩm nhẹ nhàng cho làn da nhạy cảm Hàm lượng cao chất chống oxy hóa và vitamin A, E, và K Giúp cải thiện sự xuất hiện của các nếp nhăn và giữ ẩm da.",
                        use = "Thoa một lượng nhỏ sữa rửa mặt để mặt ẩm ướt. Sử dụng với một miếng bông ướt để loại bỏ trang điểm mắt. Rửa sạch hoàn toàn bằng nước. Không sử dụng với những vết thương hở",
                        img = "/image/sp120.jpg"
                    },
                    new SanPham{
                        product_id = 122,
                        product_type_id = 2,
                        brand_id =49 ,
                        name = "PIXI Rose Tonic 100 ml",
                        amount = 50,
                        price = 21000 ,
                        description = "Khai thác hiệu quả tuyệt vời của dầu tầm xuân giàu vitamin, sản phẩm có thể lấy đi lớp trang điểm mắt nhẹ nhàng, giúp làm dịu da để giúp giảm những dấu hiệu của sự lão hóa, đảm bảo độ ẩm và điều trị các vết đỏ . Sản phẩm nhẹ nhàng cho làn da nhạy cảm Hàm lượng cao chất chống oxy hóa và vitamin A, E, và K Giúp cải thiện sự xuất hiện của các nếp nhăn và giữ ẩm da.",
                        use = "Thoa một lượng nhỏ sữa rửa mặt để mặt ẩm ướt. Sử dụng với một miếng bông ướt để loại bỏ trang điểm mắt. Rửa sạch hoàn toàn bằng nước. Không sử dụng với những vết thương hở",
                        img = "/image/sp121.jpg"
                    },
                    new SanPham{
                        product_id = 123,
                        product_type_id = 2,
                        brand_id = 49,
                        name = "PIXI Retinol Tonic 100 ml",
                        amount = 50,
                        price = 87000 ,
                        description = "Khai thác hiệu quả tuyệt vời của dầu tầm xuân giàu vitamin, sản phẩm có thể lấy đi lớp trang điểm mắt nhẹ nhàng, giúp làm dịu da để giúp giảm những dấu hiệu của sự lão hóa, đảm bảo độ ẩm và điều trị các vết đỏ . Sản phẩm nhẹ nhàng cho làn da nhạy cảm Hàm lượng cao chất chống oxy hóa và vitamin A, E, và K Giúp cải thiện sự xuất hiện của các nếp nhăn và giữ ẩm da.",
                        use = "Thoa một lượng nhỏ sữa rửa mặt để mặt ẩm ướt. Sử dụng với một miếng bông ướt để loại bỏ trang điểm mắt. Rửa sạch hoàn toàn bằng nước. Không sử dụng với những vết thương hở",
                        img = "/image/sp122.jpg"
                    },
                    new SanPham{
                        product_id =124 ,
                        product_type_id = 2,
                        brand_id = 49 ,
                        name = "PIXI Vitamin C Tonic 100 ml",
                        amount = 50,
                        price = 231000 ,
                        description = "Khai thác hiệu quả tuyệt vời của dầu tầm xuân giàu vitamin, sản phẩm có thể lấy đi lớp trang điểm mắt nhẹ nhàng, giúp làm dịu da để giúp giảm những dấu hiệu của sự lão hóa, đảm bảo độ ẩm và điều trị các vết đỏ . Sản phẩm nhẹ nhàng cho làn da nhạy cảm Hàm lượng cao chất chống oxy hóa và vitamin A, E, và K Giúp cải thiện sự xuất hiện của các nếp nhăn và giữ ẩm da.",
                        use = "Thoa một lượng nhỏ sữa rửa mặt để mặt ẩm ướt. Sử dụng với một miếng bông ướt để loại bỏ trang điểm mắt. Rửa sạch hoàn toàn bằng nước. Không sử dụng với những vết thương hở",
                        img = "/image/sp123.jpg"
                    },
                    new SanPham{
                        product_id =125 ,
                        product_type_id = 2,
                        brand_id = 20,
                        name = "Mario Badescu Glycolic Acid Toner - 236ml",
                        amount = 50,
                        price = 127000 ,
                        description = "Khai thác hiệu quả tuyệt vời của dầu tầm xuân giàu vitamin, sản phẩm có thể lấy đi lớp trang điểm mắt nhẹ nhàng, giúp làm dịu da để giúp giảm những dấu hiệu của sự lão hóa, đảm bảo độ ẩm và điều trị các vết đỏ . Sản phẩm nhẹ nhàng cho làn da nhạy cảm Hàm lượng cao chất chống oxy hóa và vitamin A, E, và K Giúp cải thiện sự xuất hiện của các nếp nhăn và giữ ẩm da.",
                        use = "Thoa một lượng nhỏ sữa rửa mặt để mặt ẩm ướt. Sử dụng với một miếng bông ướt để loại bỏ trang điểm mắt. Rửa sạch hoàn toàn bằng nước. Không sử dụng với những vết thương hở",
                        img = "/image/sp124.jpg"
                    },
                    new SanPham{
                        product_id =126 ,
                        product_type_id = 2,
                        brand_id = 21,
                        name = "MAMONDE ROSE WATER TONER MINI SIZE 25ml",
                        amount = 50,
                        price = 602000 ,
                        description = "Khai thác hiệu quả tuyệt vời của dầu tầm xuân giàu vitamin, sản phẩm có thể lấy đi lớp trang điểm mắt nhẹ nhàng, giúp làm dịu da để giúp giảm những dấu hiệu của sự lão hóa, đảm bảo độ ẩm và điều trị các vết đỏ . Sản phẩm nhẹ nhàng cho làn da nhạy cảm Hàm lượng cao chất chống oxy hóa và vitamin A, E, và K Giúp cải thiện sự xuất hiện của các nếp nhăn và giữ ẩm da.",
                        use = "Thoa một lượng nhỏ sữa rửa mặt để mặt ẩm ướt. Sử dụng với một miếng bông ướt để loại bỏ trang điểm mắt. Rửa sạch hoàn toàn bằng nước. Không sử dụng với những vết thương hở",
                        img = "/image/sp125.jpg"
                    },
                    new SanPham{
                        product_id =127 ,
                        product_type_id = 2,
                        brand_id =49 ,
                        name = "PIXI Glow Tonic - 250ml",
                        amount = 50,
                        price = 145000 ,
                        description = "Khai thác hiệu quả tuyệt vời của dầu tầm xuân giàu vitamin, sản phẩm có thể lấy đi lớp trang điểm mắt nhẹ nhàng, giúp làm dịu da để giúp giảm những dấu hiệu của sự lão hóa, đảm bảo độ ẩm và điều trị các vết đỏ . Sản phẩm nhẹ nhàng cho làn da nhạy cảm Hàm lượng cao chất chống oxy hóa và vitamin A, E, và K Giúp cải thiện sự xuất hiện của các nếp nhăn và giữ ẩm da.",
                        use = "Thoa một lượng nhỏ sữa rửa mặt để mặt ẩm ướt. Sử dụng với một miếng bông ướt để loại bỏ trang điểm mắt. Rửa sạch hoàn toàn bằng nước. Không sử dụng với những vết thương hở",
                        img = "/image/sp126.jpg"
                    },
                    new SanPham{
                        product_id =128,
                        product_type_id = 2,
                        brand_id =35 ,
                        name = "Kiehl's Calendula Herbal Extract Alcohol-Free Toner 40 ml",
                        amount = 50,
                        price = 145000 ,
                        description = "Khai thác hiệu quả tuyệt vời của dầu tầm xuân giàu vitamin, sản phẩm có thể lấy đi lớp trang điểm mắt nhẹ nhàng, giúp làm dịu da để giúp giảm những dấu hiệu của sự lão hóa, đảm bảo độ ẩm và điều trị các vết đỏ . Sản phẩm nhẹ nhàng cho làn da nhạy cảm Hàm lượng cao chất chống oxy hóa và vitamin A, E, và K Giúp cải thiện sự xuất hiện của các nếp nhăn và giữ ẩm da.",
                        use = "Thoa một lượng nhỏ sữa rửa mặt để mặt ẩm ướt. Sử dụng với một miếng bông ướt để loại bỏ trang điểm mắt. Rửa sạch hoàn toàn bằng nước. Không sử dụng với những vết thương hở",
                        img = "/image/sp127.jpg"
                    },
                    new SanPham{
                        product_id = 129,
                        product_type_id = 2,
                        brand_id = 10,
                        name = "JMSOLUTION MARINE LUMINOUS PEARL DEEP BALANCING MASK 27ML",
                        amount = 50,
                        price = 427000 ,
                        description = "Bắt đầu nổi lên như một thương hiệu mỹ phẩm cao cấp với các sản phẩm chăm sóc da chứa thành phần dầu hạt cây xương rồng- thương hiệu mỹ phẩm đến tứ xứ sở kim chi Hàn Quốc là một biểu tượng đương đại, khám phá những thành phần chưa được biết đến, hoàn thiện và dẫn dắt xu hướng mới của vẻ đẹp hiện đại. Thương hiệu mỹ phẩm Huxley đã học hỏi phương pháp làm đẹp cổ xưa của những người phụ nữ Berber ở xứ sở Morocco, sử dụng tinh dầu chiết xuất từ hạt của giống xương rồng Prickly Pear, có tác dụng tốt cho làn da phải luôn đối mặt với tình trạng mất nước. Theo đuổi triết lý “Less is more” và những tiến bộ về tư duy làm đẹp hiện đại, sản phẩm ngoài sử dụng thành phần xương rồng hữu cơ và sản xuất thủ công, còn đạt tiêu chuẩn: không cồn, paraben, dầu khoáng, hương thơm tổng hợp và các chất bảo quản khác.",
                        use = "Sau khi làm sạch da mặt trải đều mặt nạ lên da rồi thư giãn 10~15 phút.  Bỏ lớp mặt nạ giấy ra rồi dùng tay vỗ nhẹ để dưỡng chất thẩm thấu tốt hơn vào da. Dùng toner và các bước dưỡng da tiếp theo mà không cần rửa lại với nước",
                        img = "/image/sp128.jpg"
                    },
                    new SanPham{
                        product_id = 130,
                        product_type_id = 2,
                        brand_id =50 ,
                        name = "Naruko RJT Pore Minimizing and Brightening Mask",
                        amount = 50,
                        price = 621000 ,
                        description = "Bắt đầu nổi lên như một thương hiệu mỹ phẩm cao cấp với các sản phẩm chăm sóc da chứa thành phần dầu hạt cây xương rồng- thương hiệu mỹ phẩm đến tứ xứ sở kim chi Hàn Quốc là một biểu tượng đương đại, khám phá những thành phần chưa được biết đến, hoàn thiện và dẫn dắt xu hướng mới của vẻ đẹp hiện đại. Thương hiệu mỹ phẩm Huxley đã học hỏi phương pháp làm đẹp cổ xưa của những người phụ nữ Berber ở xứ sở Morocco, sử dụng tinh dầu chiết xuất từ hạt của giống xương rồng Prickly Pear, có tác dụng tốt cho làn da phải luôn đối mặt với tình trạng mất nước. Theo đuổi triết lý “Less is more” và những tiến bộ về tư duy làm đẹp hiện đại, sản phẩm ngoài sử dụng thành phần xương rồng hữu cơ và sản xuất thủ công, còn đạt tiêu chuẩn: không cồn, paraben, dầu khoáng, hương thơm tổng hợp và các chất bảo quản khác.",
                        use = "Sau khi làm sạch da mặt trải đều mặt nạ lên da rồi thư giãn 10~15 phút.  Bỏ lớp mặt nạ giấy ra rồi dùng tay vỗ nhẹ để dưỡng chất thẩm thấu tốt hơn vào da. Dùng toner và các bước dưỡng da tiếp theo mà không cần rửa lại với nước",
                        img = "/image/sp129.jpg"
                    },
                    new SanPham{
                        product_id =131 ,
                        product_type_id = 2,
                        brand_id =50 ,
                        name = "Naruko Tea Tree Shine Control and Blemish Clear Mask ",
                        amount = 50,
                        price = 422000 ,
                        description = "Bắt đầu nổi lên như một thương hiệu mỹ phẩm cao cấp với các sản phẩm chăm sóc da chứa thành phần dầu hạt cây xương rồng- thương hiệu mỹ phẩm đến tứ xứ sở kim chi Hàn Quốc là một biểu tượng đương đại, khám phá những thành phần chưa được biết đến, hoàn thiện và dẫn dắt xu hướng mới của vẻ đẹp hiện đại. Thương hiệu mỹ phẩm Huxley đã học hỏi phương pháp làm đẹp cổ xưa của những người phụ nữ Berber ở xứ sở Morocco, sử dụng tinh dầu chiết xuất từ hạt của giống xương rồng Prickly Pear, có tác dụng tốt cho làn da phải luôn đối mặt với tình trạng mất nước. Theo đuổi triết lý “Less is more” và những tiến bộ về tư duy làm đẹp hiện đại, sản phẩm ngoài sử dụng thành phần xương rồng hữu cơ và sản xuất thủ công, còn đạt tiêu chuẩn: không cồn, paraben, dầu khoáng, hương thơm tổng hợp và các chất bảo quản khác.",
                        use = "Sau khi làm sạch da mặt trải đều mặt nạ lên da rồi thư giãn 10~15 phút.  Bỏ lớp mặt nạ giấy ra rồi dùng tay vỗ nhẹ để dưỡng chất thẩm thấu tốt hơn vào da. Dùng toner và các bước dưỡng da tiếp theo mà không cần rửa lại với nước",
                        img = "/image/sp130.jpg"
                    },
                    new SanPham{
                        product_id =132 ,
                        product_type_id = 2,
                        brand_id = 45,
                        name = "Huxley Spa Routine Kit",
                        amount = 50,
                        price = 132000 ,
                        description = "Bắt đầu nổi lên như một thương hiệu mỹ phẩm cao cấp với các sản phẩm chăm sóc da chứa thành phần dầu hạt cây xương rồng- thương hiệu mỹ phẩm đến tứ xứ sở kim chi Hàn Quốc là một biểu tượng đương đại, khám phá những thành phần chưa được biết đến, hoàn thiện và dẫn dắt xu hướng mới của vẻ đẹp hiện đại. Thương hiệu mỹ phẩm Huxley đã học hỏi phương pháp làm đẹp cổ xưa của những người phụ nữ Berber ở xứ sở Morocco, sử dụng tinh dầu chiết xuất từ hạt của giống xương rồng Prickly Pear, có tác dụng tốt cho làn da phải luôn đối mặt với tình trạng mất nước. Theo đuổi triết lý “Less is more” và những tiến bộ về tư duy làm đẹp hiện đại, sản phẩm ngoài sử dụng thành phần xương rồng hữu cơ và sản xuất thủ công, còn đạt tiêu chuẩn: không cồn, paraben, dầu khoáng, hương thơm tổng hợp và các chất bảo quản khác.",
                        use = "Sau khi làm sạch da mặt trải đều mặt nạ lên da rồi thư giãn 10~15 phút.  Bỏ lớp mặt nạ giấy ra rồi dùng tay vỗ nhẹ để dưỡng chất thẩm thấu tốt hơn vào da. Dùng toner và các bước dưỡng da tiếp theo mà không cần rửa lại với nước",
                        img = "/image/sp131.jpg"
                    },
                    new SanPham{
                        product_id =133 ,
                        product_type_id = 2,
                        brand_id = 25,
                        name = "Mulbit Firming Sleeping Mask",
                        amount = 50,
                        price = 421000 ,
                        description = "Bắt đầu nổi lên như một thương hiệu mỹ phẩm cao cấp với các sản phẩm chăm sóc da chứa thành phần dầu hạt cây xương rồng- thương hiệu mỹ phẩm đến tứ xứ sở kim chi Hàn Quốc là một biểu tượng đương đại, khám phá những thành phần chưa được biết đến, hoàn thiện và dẫn dắt xu hướng mới của vẻ đẹp hiện đại. Thương hiệu mỹ phẩm Huxley đã học hỏi phương pháp làm đẹp cổ xưa của những người phụ nữ Berber ở xứ sở Morocco, sử dụng tinh dầu chiết xuất từ hạt của giống xương rồng Prickly Pear, có tác dụng tốt cho làn da phải luôn đối mặt với tình trạng mất nước. Theo đuổi triết lý “Less is more” và những tiến bộ về tư duy làm đẹp hiện đại, sản phẩm ngoài sử dụng thành phần xương rồng hữu cơ và sản xuất thủ công, còn đạt tiêu chuẩn: không cồn, paraben, dầu khoáng, hương thơm tổng hợp và các chất bảo quản khác.",
                        use = "Sau khi làm sạch da mặt trải đều mặt nạ lên da rồi thư giãn 10~15 phút.  Bỏ lớp mặt nạ giấy ra rồi dùng tay vỗ nhẹ để dưỡng chất thẩm thấu tốt hơn vào da. Dùng toner và các bước dưỡng da tiếp theo mà không cần rửa lại với nước",
                        img = "/image/sp132.jpg"
                    },
                    new SanPham{
                        product_id = 134,
                        product_type_id = 2,
                        brand_id = 39,
                        name = "Mặt nạ lụa sinh học OKAME Bio - cellulose Mask - Set 5 Anti - aging Masks",
                        amount = 50,
                        price = 42000 ,
                        description = "Bắt đầu nổi lên như một thương hiệu mỹ phẩm cao cấp với các sản phẩm chăm sóc da chứa thành phần dầu hạt cây xương rồng- thương hiệu mỹ phẩm đến tứ xứ sở kim chi Hàn Quốc là một biểu tượng đương đại, khám phá những thành phần chưa được biết đến, hoàn thiện và dẫn dắt xu hướng mới của vẻ đẹp hiện đại. Thương hiệu mỹ phẩm Huxley đã học hỏi phương pháp làm đẹp cổ xưa của những người phụ nữ Berber ở xứ sở Morocco, sử dụng tinh dầu chiết xuất từ hạt của giống xương rồng Prickly Pear, có tác dụng tốt cho làn da phải luôn đối mặt với tình trạng mất nước. Theo đuổi triết lý “Less is more” và những tiến bộ về tư duy làm đẹp hiện đại, sản phẩm ngoài sử dụng thành phần xương rồng hữu cơ và sản xuất thủ công, còn đạt tiêu chuẩn: không cồn, paraben, dầu khoáng, hương thơm tổng hợp và các chất bảo quản khác.",
                        use = "Sau khi làm sạch da mặt trải đều mặt nạ lên da rồi thư giãn 10~15 phút.  Bỏ lớp mặt nạ giấy ra rồi dùng tay vỗ nhẹ để dưỡng chất thẩm thấu tốt hơn vào da. Dùng toner và các bước dưỡng da tiếp theo mà không cần rửa lại với nước",
                        img = "/image/sp133.jpg"
                    },
                    new SanPham{
                        product_id = 135,
                        product_type_id = 2,
                        brand_id = 30,
                        name = "Kiehl's Calendula & Aloe Soothing Hydration Masque 14ml",
                        amount = 50,
                        price = 124000 ,
                        description = "Bắt đầu nổi lên như một thương hiệu mỹ phẩm cao cấp với các sản phẩm chăm sóc da chứa thành phần dầu hạt cây xương rồng- thương hiệu mỹ phẩm đến tứ xứ sở kim chi Hàn Quốc là một biểu tượng đương đại, khám phá những thành phần chưa được biết đến, hoàn thiện và dẫn dắt xu hướng mới của vẻ đẹp hiện đại. Thương hiệu mỹ phẩm Huxley đã học hỏi phương pháp làm đẹp cổ xưa của những người phụ nữ Berber ở xứ sở Morocco, sử dụng tinh dầu chiết xuất từ hạt của giống xương rồng Prickly Pear, có tác dụng tốt cho làn da phải luôn đối mặt với tình trạng mất nước. Theo đuổi triết lý “Less is more” và những tiến bộ về tư duy làm đẹp hiện đại, sản phẩm ngoài sử dụng thành phần xương rồng hữu cơ và sản xuất thủ công, còn đạt tiêu chuẩn: không cồn, paraben, dầu khoáng, hương thơm tổng hợp và các chất bảo quản khác.",
                        use = "Sau khi làm sạch da mặt trải đều mặt nạ lên da rồi thư giãn 10~15 phút.  Bỏ lớp mặt nạ giấy ra rồi dùng tay vỗ nhẹ để dưỡng chất thẩm thấu tốt hơn vào da. Dùng toner và các bước dưỡng da tiếp theo mà không cần rửa lại với nước",
                        img = "/image/sp134.jpg"
                    },
                    new SanPham{
                        product_id = 136,
                        product_type_id = 2,
                        brand_id = 21,
                        name = "Laneige Water Sleeping Mask 15ml",
                        amount = 50,
                        price = 254000 ,
                        description = "Bắt đầu nổi lên như một thương hiệu mỹ phẩm cao cấp với các sản phẩm chăm sóc da chứa thành phần dầu hạt cây xương rồng- thương hiệu mỹ phẩm đến tứ xứ sở kim chi Hàn Quốc là một biểu tượng đương đại, khám phá những thành phần chưa được biết đến, hoàn thiện và dẫn dắt xu hướng mới của vẻ đẹp hiện đại. Thương hiệu mỹ phẩm Huxley đã học hỏi phương pháp làm đẹp cổ xưa của những người phụ nữ Berber ở xứ sở Morocco, sử dụng tinh dầu chiết xuất từ hạt của giống xương rồng Prickly Pear, có tác dụng tốt cho làn da phải luôn đối mặt với tình trạng mất nước. Theo đuổi triết lý “Less is more” và những tiến bộ về tư duy làm đẹp hiện đại, sản phẩm ngoài sử dụng thành phần xương rồng hữu cơ và sản xuất thủ công, còn đạt tiêu chuẩn: không cồn, paraben, dầu khoáng, hương thơm tổng hợp và các chất bảo quản khác.",
                        use = "Sau khi làm sạch da mặt trải đều mặt nạ lên da rồi thư giãn 10~15 phút.  Bỏ lớp mặt nạ giấy ra rồi dùng tay vỗ nhẹ để dưỡng chất thẩm thấu tốt hơn vào da. Dùng toner và các bước dưỡng da tiếp theo mà không cần rửa lại với nước",
                        img = "/image/sp135.jpg"
                    },
                    new SanPham{
                        product_id =137 ,
                        product_type_id = 2,
                        brand_id =19 ,
                        name = "Andalou Naturals Skin Food Mask, Avo Cocoa",
                        amount = 50,
                        price = 523000 ,
                        description = "Bắt đầu nổi lên như một thương hiệu mỹ phẩm cao cấp với các sản phẩm chăm sóc da chứa thành phần dầu hạt cây xương rồng- thương hiệu mỹ phẩm đến tứ xứ sở kim chi Hàn Quốc là một biểu tượng đương đại, khám phá những thành phần chưa được biết đến, hoàn thiện và dẫn dắt xu hướng mới của vẻ đẹp hiện đại. Thương hiệu mỹ phẩm Huxley đã học hỏi phương pháp làm đẹp cổ xưa của những người phụ nữ Berber ở xứ sở Morocco, sử dụng tinh dầu chiết xuất từ hạt của giống xương rồng Prickly Pear, có tác dụng tốt cho làn da phải luôn đối mặt với tình trạng mất nước. Theo đuổi triết lý “Less is more” và những tiến bộ về tư duy làm đẹp hiện đại, sản phẩm ngoài sử dụng thành phần xương rồng hữu cơ và sản xuất thủ công, còn đạt tiêu chuẩn: không cồn, paraben, dầu khoáng, hương thơm tổng hợp và các chất bảo quản khác.",
                        use = "Sau khi làm sạch da mặt trải đều mặt nạ lên da rồi thư giãn 10~15 phút.  Bỏ lớp mặt nạ giấy ra rồi dùng tay vỗ nhẹ để dưỡng chất thẩm thấu tốt hơn vào da. Dùng toner và các bước dưỡng da tiếp theo mà không cần rửa lại với nước",
                        img = "/image/sp136.jpg"
                    },
                    new SanPham{
                        product_id = 138,
                        product_type_id = 2,
                        brand_id = 19,
                        name = "CHARLOTTE TILBURY Charlotte's Magic Cream 30 ml",
                        amount = 50,
                        price = 245000 ,
                        description = "Là một trong những hãng có 100% thành phần chiết xuất từ thiên nhiên, giúp điều trị và xoa dịu làn da từ sâu trong lỗ chân lông. được thành lập từ những năm 2000 với chủ sở hữu thương hiệu là một nam beauty guru. như một thương hiệu mỹ phẩm cao cấp với các sản phẩm chăm sóc da chứa thành phần dầu hạt cây xương rồng Prickly Pear.",
                        use = "Sau khi làm sạch da bằng sữa rửa mặt , cân bằng da với toner  và cung cấp dưỡng chất với các sản phẩm điều trị , bạn thoa kem dưỡng kiểm soát dầu lên toàn mặt, cổ và vùng hở ngực. Sản phẩm này chỉ dùng vào buổi sáng. Thế nên, bạn nên bổ sung kem dưỡng ẩm ban đêm dành cho da dầu vào quy trình chăm sóc da buổi tối. ",
                        img = "/image/sp137.jpg"
                    },
                    new SanPham{
                        product_id = 139,
                        product_type_id = 2,
                        brand_id =39 ,
                        name = "OMOROVICZA REJUVENATING NIGHT CREAM 15ml",
                        amount = 50,
                        price =512000 ,
                        description = "Là một trong những hãng có 100% thành phần chiết xuất từ thiên nhiên, giúp điều trị và xoa dịu làn da từ sâu trong lỗ chân lông. được thành lập từ những năm 2000 với chủ sở hữu thương hiệu là một nam beauty guru. như một thương hiệu mỹ phẩm cao cấp với các sản phẩm chăm sóc da chứa thành phần dầu hạt cây xương rồng Prickly Pear.",
                        use = "Sau khi làm sạch da bằng sữa rửa mặt , cân bằng da với toner  và cung cấp dưỡng chất với các sản phẩm điều trị , bạn thoa kem dưỡng kiểm soát dầu lên toàn mặt, cổ và vùng hở ngực. Sản phẩm này chỉ dùng vào buổi sáng. Thế nên, bạn nên bổ sung kem dưỡng ẩm ban đêm dành cho da dầu vào quy trình chăm sóc da buổi tối. ",
                        img = "/image/sp138.jpg"
                    },
                    new SanPham{
                        product_id = 140,
                        product_type_id = 2,
                        brand_id =52,
                        name = "Malin + Goetz Vitamin E Face Moisturizer 30ml",
                        amount = 50,
                        price = 517000 ,
                        description = "Là một trong những hãng có 100% thành phần chiết xuất từ thiên nhiên, giúp điều trị và xoa dịu làn da từ sâu trong lỗ chân lông. được thành lập từ những năm 2000 với chủ sở hữu thương hiệu là một nam beauty guru. như một thương hiệu mỹ phẩm cao cấp với các sản phẩm chăm sóc da chứa thành phần dầu hạt cây xương rồng Prickly Pear.",
                        use = "Sau khi làm sạch da bằng sữa rửa mặt , cân bằng da với toner  và cung cấp dưỡng chất với các sản phẩm điều trị , bạn thoa kem dưỡng kiểm soát dầu lên toàn mặt, cổ và vùng hở ngực. Sản phẩm này chỉ dùng vào buổi sáng. Thế nên, bạn nên bổ sung kem dưỡng ẩm ban đêm dành cho da dầu vào quy trình chăm sóc da buổi tối. ",
                        img = "/image/sp139.jpg"
                    },
                    new SanPham{
                        product_id = 141,
                        product_type_id = 2,
                        brand_id = 43,
                        name = "AHC Capture White Solution Max Cream 50ml",
                        amount = 50,
                        price = 651000 ,
                        description = "Là một trong những hãng có 100% thành phần chiết xuất từ thiên nhiên, giúp điều trị và xoa dịu làn da từ sâu trong lỗ chân lông. được thành lập từ những năm 2000 với chủ sở hữu thương hiệu là một nam beauty guru. như một thương hiệu mỹ phẩm cao cấp với các sản phẩm chăm sóc da chứa thành phần dầu hạt cây xương rồng Prickly Pear.",
                        use = "Sau khi làm sạch da bằng sữa rửa mặt , cân bằng da với toner  và cung cấp dưỡng chất với các sản phẩm điều trị , bạn thoa kem dưỡng kiểm soát dầu lên toàn mặt, cổ và vùng hở ngực. Sản phẩm này chỉ dùng vào buổi sáng. Thế nên, bạn nên bổ sung kem dưỡng ẩm ban đêm dành cho da dầu vào quy trình chăm sóc da buổi tối. ",
                        img = "/image/sp140.jpg"
                    },
                    new SanPham{
                        product_id =142 ,
                        product_type_id = 2,
                        brand_id =46 ,
                        name = "Some By Mi AHA BHA PHA 30 Days Miracle Cream",
                        amount = 50,
                        price = 58000 ,
                        description = "Là một trong những hãng có 100% thành phần chiết xuất từ thiên nhiên, giúp điều trị và xoa dịu làn da từ sâu trong lỗ chân lông. được thành lập từ những năm 2000 với chủ sở hữu thương hiệu là một nam beauty guru. như một thương hiệu mỹ phẩm cao cấp với các sản phẩm chăm sóc da chứa thành phần dầu hạt cây xương rồng Prickly Pear.",
                        use = "Sau khi làm sạch da bằng sữa rửa mặt , cân bằng da với toner  và cung cấp dưỡng chất với các sản phẩm điều trị , bạn thoa kem dưỡng kiểm soát dầu lên toàn mặt, cổ và vùng hở ngực. Sản phẩm này chỉ dùng vào buổi sáng. Thế nên, bạn nên bổ sung kem dưỡng ẩm ban đêm dành cho da dầu vào quy trình chăm sóc da buổi tối. ",
                        img = "/image/sp141.jpg"
                    },
                    new SanPham{
                        product_id = 143,
                        product_type_id = 2,
                        brand_id = 51,
                        name = "Dermedic ANGIO PREVENTI NANO VIT C Active anti - wrinkle night cream ",
                        amount = 50,
                        price = 767000 ,
                        description = "Là một trong những hãng có 100% thành phần chiết xuất từ thiên nhiên, giúp điều trị và xoa dịu làn da từ sâu trong lỗ chân lông. được thành lập từ những năm 2000 với chủ sở hữu thương hiệu là một nam beauty guru. như một thương hiệu mỹ phẩm cao cấp với các sản phẩm chăm sóc da chứa thành phần dầu hạt cây xương rồng Prickly Pear.",
                        use = "Sau khi làm sạch da bằng sữa rửa mặt , cân bằng da với toner  và cung cấp dưỡng chất với các sản phẩm điều trị , bạn thoa kem dưỡng kiểm soát dầu lên toàn mặt, cổ và vùng hở ngực. Sản phẩm này chỉ dùng vào buổi sáng. Thế nên, bạn nên bổ sung kem dưỡng ẩm ban đêm dành cho da dầu vào quy trình chăm sóc da buổi tối. ",
                        img = "/image/sp142.jpg"
                    },
                    new SanPham{
                        product_id = 144,
                        product_type_id = 2,
                        brand_id =51 ,
                        name = "Sunday Riley Good Genes All in One Lactic Acid Treatment 50 ml",
                        amount = 50,
                        price = 863000 ,
                        description = "Là một trong những hãng có 100% thành phần chiết xuất từ thiên nhiên, giúp điều trị và xoa dịu làn da từ sâu trong lỗ chân lông. được thành lập từ những năm 2000 với chủ sở hữu thương hiệu là một nam beauty guru. như một thương hiệu mỹ phẩm cao cấp với các sản phẩm chăm sóc da chứa thành phần dầu hạt cây xương rồng Prickly Pear.",
                        use = "Sau khi làm sạch da bằng sữa rửa mặt , cân bằng da với toner  và cung cấp dưỡng chất với các sản phẩm điều trị , bạn thoa kem dưỡng kiểm soát dầu lên toàn mặt, cổ và vùng hở ngực. Sản phẩm này chỉ dùng vào buổi sáng. Thế nên, bạn nên bổ sung kem dưỡng ẩm ban đêm dành cho da dầu vào quy trình chăm sóc da buổi tối. ",
                        img = "/image/sp143.jpg"
                    },
                    new SanPham{
                        product_id =145 ,
                        product_type_id = 2,
                        brand_id = 41,
                        name = "Clinique iD™: Hydrating Jelly + Cartridge for Irritation 125ml",
                        amount = 50,
                        price = 527000 ,
                        description = "Là một trong những hãng có 100% thành phần chiết xuất từ thiên nhiên, giúp điều trị và xoa dịu làn da từ sâu trong lỗ chân lông. được thành lập từ những năm 2000 với chủ sở hữu thương hiệu là một nam beauty guru. như một thương hiệu mỹ phẩm cao cấp với các sản phẩm chăm sóc da chứa thành phần dầu hạt cây xương rồng Prickly Pear.",
                        use = "Sau khi làm sạch da bằng sữa rửa mặt , cân bằng da với toner  và cung cấp dưỡng chất với các sản phẩm điều trị , bạn thoa kem dưỡng kiểm soát dầu lên toàn mặt, cổ và vùng hở ngực. Sản phẩm này chỉ dùng vào buổi sáng. Thế nên, bạn nên bổ sung kem dưỡng ẩm ban đêm dành cho da dầu vào quy trình chăm sóc da buổi tối. ",
                        img = "/image/sp144.jpg"
                    },
                    new SanPham{
                        product_id = 146,
                        product_type_id = 2,
                        brand_id =41 ,
                        name = "Clinique iD™: Hydrating Jelly + Cartridge for Fatigue 125ml",
                        amount = 50,
                        price = 727000 ,
                        description = "Là một trong những hãng có 100% thành phần chiết xuất từ thiên nhiên, giúp điều trị và xoa dịu làn da từ sâu trong lỗ chân lông. được thành lập từ những năm 2000 với chủ sở hữu thương hiệu là một nam beauty guru. như một thương hiệu mỹ phẩm cao cấp với các sản phẩm chăm sóc da chứa thành phần dầu hạt cây xương rồng Prickly Pear.",
                        use = "Sau khi làm sạch da bằng sữa rửa mặt , cân bằng da với toner  và cung cấp dưỡng chất với các sản phẩm điều trị , bạn thoa kem dưỡng kiểm soát dầu lên toàn mặt, cổ và vùng hở ngực. Sản phẩm này chỉ dùng vào buổi sáng. Thế nên, bạn nên bổ sung kem dưỡng ẩm ban đêm dành cho da dầu vào quy trình chăm sóc da buổi tối. ",
                        img = "/image/sp145.jpg"
                    },
                    new SanPham{
                        product_id =147 ,
                        product_type_id = 2,
                        brand_id = 41,
                        name = "Clinique iD™: Oil - Control Gel + Cartridge for Pores & Uneven Texture 125ml",
                        amount = 50,
                        price = 627000 ,
                        description = "Là một trong những hãng có 100% thành phần chiết xuất từ thiên nhiên, giúp điều trị và xoa dịu làn da từ sâu trong lỗ chân lông. được thành lập từ những năm 2000 với chủ sở hữu thương hiệu là một nam beauty guru. như một thương hiệu mỹ phẩm cao cấp với các sản phẩm chăm sóc da chứa thành phần dầu hạt cây xương rồng Prickly Pear.",
                        use = "Sau khi làm sạch da bằng sữa rửa mặt , cân bằng da với toner  và cung cấp dưỡng chất với các sản phẩm điều trị , bạn thoa kem dưỡng kiểm soát dầu lên toàn mặt, cổ và vùng hở ngực. Sản phẩm này chỉ dùng vào buổi sáng. Thế nên, bạn nên bổ sung kem dưỡng ẩm ban đêm dành cho da dầu vào quy trình chăm sóc da buổi tối. ",
                        img = "/image/sp146.jpg"
                    },
                    new SanPham{
                        product_id = 148,
                        product_type_id = 2,
                        brand_id =10 ,
                        name = "Oribe Matte Waves Texture Lotion 15ml",
                        amount = 50,
                        price = 327000 ,
                        description = "Là một trong những hãng có 100% thành phần chiết xuất từ thiên nhiên, giúp điều trị và xoa dịu làn da từ sâu trong lỗ chân lông. được thành lập từ những năm 2000 với chủ sở hữu thương hiệu là một nam beauty guru. như một thương hiệu mỹ phẩm cao cấp với các sản phẩm chăm sóc da chứa thành phần dầu hạt cây xương rồng Prickly Pear.",
                        use = "Sau khi làm sạch da bằng sữa rửa mặt , cân bằng da với toner  và cung cấp dưỡng chất với các sản phẩm điều trị , bạn thoa kem dưỡng kiểm soát dầu lên toàn mặt, cổ và vùng hở ngực. Sản phẩm này chỉ dùng vào buổi sáng. Thế nên, bạn nên bổ sung kem dưỡng ẩm ban đêm dành cho da dầu vào quy trình chăm sóc da buổi tối. ",
                        img = "/image/sp147.jpg"
                    },
                    new SanPham{
                        product_id =149 ,
                        product_type_id = 2,
                        brand_id = 10,
                        name = "Dr.Dennis Gross Alpha Beta® Exfoliating Moisturizer(4 ml)",
                        amount = 50,
                        price = 67000 ,
                        description = "Là một trong những hãng có 100% thành phần chiết xuất từ thiên nhiên, giúp điều trị và xoa dịu làn da từ sâu trong lỗ chân lông. được thành lập từ những năm 2000 với chủ sở hữu thương hiệu là một nam beauty guru. như một thương hiệu mỹ phẩm cao cấp với các sản phẩm chăm sóc da chứa thành phần dầu hạt cây xương rồng Prickly Pear.",
                        use = "Sau khi làm sạch da bằng sữa rửa mặt , cân bằng da với toner  và cung cấp dưỡng chất với các sản phẩm điều trị , bạn thoa kem dưỡng kiểm soát dầu lên toàn mặt, cổ và vùng hở ngực. Sản phẩm này chỉ dùng vào buổi sáng. Thế nên, bạn nên bổ sung kem dưỡng ẩm ban đêm dành cho da dầu vào quy trình chăm sóc da buổi tối. ",
                        img = "/image/sp148.jpg"
                    },
                    new SanPham{
                        product_id = 150,
                        product_type_id = 2,
                        brand_id = 52,
                        name = "MURAD Oil - Control Mattifier SPF 15 PA++",
                        amount = 50,
                        price = 81000 ,
                        description = "Là một trong những hãng có 100% thành phần chiết xuất từ thiên nhiên, giúp điều trị và xoa dịu làn da từ sâu trong lỗ chân lông. được thành lập từ những năm 2000 với chủ sở hữu thương hiệu là một nam beauty guru. như một thương hiệu mỹ phẩm cao cấp với các sản phẩm chăm sóc da chứa thành phần dầu hạt cây xương rồng Prickly Pear.",
                        use = "Sau khi làm sạch da bằng sữa rửa mặt , cân bằng da với toner  và cung cấp dưỡng chất với các sản phẩm điều trị , bạn thoa kem dưỡng kiểm soát dầu lên toàn mặt, cổ và vùng hở ngực. Sản phẩm này chỉ dùng vào buổi sáng. Thế nên, bạn nên bổ sung kem dưỡng ẩm ban đêm dành cho da dầu vào quy trình chăm sóc da buổi tối. ",
                        img = "/image/sp149.jpg"
                    },
                    new SanPham{
                        product_id =151 ,
                        product_type_id = 2,
                        brand_id = 45,
                        name = "Huxley Extra Moisture Duo Set",
                        amount = 50,
                        price =152000 ,
                        description = "Là một trong những hãng có 100% thành phần chiết xuất từ thiên nhiên, giúp điều trị và xoa dịu làn da từ sâu trong lỗ chân lông. được thành lập từ những năm 2000 với chủ sở hữu thương hiệu là một nam beauty guru. như một thương hiệu mỹ phẩm cao cấp với các sản phẩm chăm sóc da chứa thành phần dầu hạt cây xương rồng Prickly Pear.",
                        use = "Sau khi làm sạch da bằng sữa rửa mặt , cân bằng da với toner  và cung cấp dưỡng chất với các sản phẩm điều trị , bạn thoa kem dưỡng kiểm soát dầu lên toàn mặt, cổ và vùng hở ngực. Sản phẩm này chỉ dùng vào buổi sáng. Thế nên, bạn nên bổ sung kem dưỡng ẩm ban đêm dành cho da dầu vào quy trình chăm sóc da buổi tối. ",
                        img = "/image/sp150.jpg"
                    },
                    new SanPham{
                        product_id = 152,
                        product_type_id = 2,
                        brand_id =45 ,
                        name = "Huxley Antioxidant Duo Set",
                        amount = 50,
                        price = 182000 ,
                        description = "Là một trong những hãng có 100% thành phần chiết xuất từ thiên nhiên, giúp điều trị và xoa dịu làn da từ sâu trong lỗ chân lông. được thành lập từ những năm 2000 với chủ sở hữu thương hiệu là một nam beauty guru. như một thương hiệu mỹ phẩm cao cấp với các sản phẩm chăm sóc da chứa thành phần dầu hạt cây xương rồng Prickly Pear.",
                        use = "Sau khi làm sạch da bằng sữa rửa mặt , cân bằng da với toner  và cung cấp dưỡng chất với các sản phẩm điều trị , bạn thoa kem dưỡng kiểm soát dầu lên toàn mặt, cổ và vùng hở ngực. Sản phẩm này chỉ dùng vào buổi sáng. Thế nên, bạn nên bổ sung kem dưỡng ẩm ban đêm dành cho da dầu vào quy trình chăm sóc da buổi tối. ",
                        img = "/image/sp151.jpg"
                    },
                    new SanPham{
                        product_id =153 ,
                        product_type_id = 2,
                        brand_id =45 ,
                        name = "Huxley Cream ; More than Moist",
                        amount = 50,
                        price = 282000 ,
                        description = "Là một trong những hãng có 100% thành phần chiết xuất từ thiên nhiên, giúp điều trị và xoa dịu làn da từ sâu trong lỗ chân lông. được thành lập từ những năm 2000 với chủ sở hữu thương hiệu là một nam beauty guru. như một thương hiệu mỹ phẩm cao cấp với các sản phẩm chăm sóc da chứa thành phần dầu hạt cây xương rồng Prickly Pear.",
                        use = "Sau khi làm sạch da bằng sữa rửa mặt , cân bằng da với toner  và cung cấp dưỡng chất với các sản phẩm điều trị , bạn thoa kem dưỡng kiểm soát dầu lên toàn mặt, cổ và vùng hở ngực. Sản phẩm này chỉ dùng vào buổi sáng. Thế nên, bạn nên bổ sung kem dưỡng ẩm ban đêm dành cho da dầu vào quy trình chăm sóc da buổi tối. ",
                        img = "/image/sp152.jpg"
                    },
                    new SanPham{
                        product_id =154 ,
                        product_type_id = 2,
                        brand_id =40 ,
                        name = "Neutrogena Hydro Boost Water Gel",
                        amount = 50,
                        price = 627000 ,
                        description = "Là một trong những hãng có 100% thành phần chiết xuất từ thiên nhiên, giúp điều trị và xoa dịu làn da từ sâu trong lỗ chân lông. được thành lập từ những năm 2000 với chủ sở hữu thương hiệu là một nam beauty guru. như một thương hiệu mỹ phẩm cao cấp với các sản phẩm chăm sóc da chứa thành phần dầu hạt cây xương rồng Prickly Pear.",
                        use = "Sau khi làm sạch da bằng sữa rửa mặt , cân bằng da với toner  và cung cấp dưỡng chất với các sản phẩm điều trị , bạn thoa kem dưỡng kiểm soát dầu lên toàn mặt, cổ và vùng hở ngực. Sản phẩm này chỉ dùng vào buổi sáng. Thế nên, bạn nên bổ sung kem dưỡng ẩm ban đêm dành cho da dầu vào quy trình chăm sóc da buổi tối. ",
                        img = "/image/sp153.jpg"
                    },
                    new SanPham{
                        product_id =155 ,
                        product_type_id = 2,
                        brand_id = 41,
                        name = "Clinique Dramatically Different Moisturising Gel with pump 125 ml",
                        amount = 50,
                        price = 62500 ,
                        description = "Là một trong những hãng có 100% thành phần chiết xuất từ thiên nhiên, giúp điều trị và xoa dịu làn da từ sâu trong lỗ chân lông. được thành lập từ những năm 2000 với chủ sở hữu thương hiệu là một nam beauty guru. như một thương hiệu mỹ phẩm cao cấp với các sản phẩm chăm sóc da chứa thành phần dầu hạt cây xương rồng Prickly Pear.",
                        use = "Sau khi làm sạch da bằng sữa rửa mặt , cân bằng da với toner  và cung cấp dưỡng chất với các sản phẩm điều trị , bạn thoa kem dưỡng kiểm soát dầu lên toàn mặt, cổ và vùng hở ngực. Sản phẩm này chỉ dùng vào buổi sáng. Thế nên, bạn nên bổ sung kem dưỡng ẩm ban đêm dành cho da dầu vào quy trình chăm sóc da buổi tối. ",
                        img = "/image/sp154.jpg"
                    },
                    new SanPham{
                        product_id =156 ,
                        product_type_id = 2,
                        brand_id = 33,
                        name = "Mario Badescu Oil Free Moisturizer - 59 ml ",
                        amount = 50,
                        price = 51000 ,
                        description = "Là một trong những hãng có 100% thành phần chiết xuất từ thiên nhiên, giúp điều trị và xoa dịu làn da từ sâu trong lỗ chân lông. được thành lập từ những năm 2000 với chủ sở hữu thương hiệu là một nam beauty guru. như một thương hiệu mỹ phẩm cao cấp với các sản phẩm chăm sóc da chứa thành phần dầu hạt cây xương rồng Prickly Pear.",
                        use = "Sau khi làm sạch da bằng sữa rửa mặt , cân bằng da với toner  và cung cấp dưỡng chất với các sản phẩm điều trị , bạn thoa kem dưỡng kiểm soát dầu lên toàn mặt, cổ và vùng hở ngực. Sản phẩm này chỉ dùng vào buổi sáng. Thế nên, bạn nên bổ sung kem dưỡng ẩm ban đêm dành cho da dầu vào quy trình chăm sóc da buổi tối. ",
                        img = "/image/sp155.jpg"
                    },
                    new SanPham{
                        product_id = 157,
                        product_type_id = 2,
                        brand_id =50 ,
                        name = "Naruko Tea Tree Purifying Essential Oil 10 ml",
                        amount = 50,
                        price = 612000 ,
                        description = "Là một trong những hãng có 100% thành phần chiết xuất từ thiên nhiên, giúp điều trị và xoa dịu làn da từ sâu trong lỗ chân lông. được thành lập từ những năm 2000 với chủ sở hữu thương hiệu là một nam beauty guru. như một thương hiệu mỹ phẩm cao cấp với các sản phẩm chăm sóc da chứa thành phần dầu hạt cây xương rồng Prickly Pear.",
                        use = "Sau khi làm sạch da bằng sữa rửa mặt , cân bằng da với toner  và cung cấp dưỡng chất với các sản phẩm điều trị , bạn thoa kem dưỡng kiểm soát dầu lên toàn mặt, cổ và vùng hở ngực. Sản phẩm này chỉ dùng vào buổi sáng. Thế nên, bạn nên bổ sung kem dưỡng ẩm ban đêm dành cho da dầu vào quy trình chăm sóc da buổi tối. ",
                        img = "/image/sp156.jpg"
                    },
                    new SanPham{
                        product_id = 158,
                        product_type_id = 2,
                        brand_id =45 ,
                        name = "Huxley Extra Moisture Duo Set",
                        amount = 50,
                        price = 253000 ,
                        description = "Là một trong những hãng có 100% thành phần chiết xuất từ thiên nhiên, giúp điều trị và xoa dịu làn da từ sâu trong lỗ chân lông. được thành lập từ những năm 2000 với chủ sở hữu thương hiệu là một nam beauty guru. như một thương hiệu mỹ phẩm cao cấp với các sản phẩm chăm sóc da chứa thành phần dầu hạt cây xương rồng Prickly Pear.",
                        use = "Sau khi làm sạch da bằng sữa rửa mặt , cân bằng da với toner  và cung cấp dưỡng chất với các sản phẩm điều trị , bạn thoa kem dưỡng kiểm soát dầu lên toàn mặt, cổ và vùng hở ngực. Sản phẩm này chỉ dùng vào buổi sáng. Thế nên, bạn nên bổ sung kem dưỡng ẩm ban đêm dành cho da dầu vào quy trình chăm sóc da buổi tối. ",
                        img = "/image/sp157.jpg"
                    },
                    new SanPham{
                        product_id = 159,
                        product_type_id = 2,
                        brand_id = 2,
                        name = "Andalou Naturals Argan Oil + Omega Natural Glow 3 in 1 Treatment",
                        amount = 50,
                        price =712000 ,
                        description = "Là một trong những hãng có 100% thành phần chiết xuất từ thiên nhiên, giúp điều trị và xoa dịu làn da từ sâu trong lỗ chân lông. được thành lập từ những năm 2000 với chủ sở hữu thương hiệu là một nam beauty guru. như một thương hiệu mỹ phẩm cao cấp với các sản phẩm chăm sóc da chứa thành phần dầu hạt cây xương rồng Prickly Pear.",
                        use = "Sau khi làm sạch da bằng sữa rửa mặt , cân bằng da với toner  và cung cấp dưỡng chất với các sản phẩm điều trị , bạn thoa kem dưỡng kiểm soát dầu lên toàn mặt, cổ và vùng hở ngực. Sản phẩm này chỉ dùng vào buổi sáng. Thế nên, bạn nên bổ sung kem dưỡng ẩm ban đêm dành cho da dầu vào quy trình chăm sóc da buổi tối. ",
                        img = "/image/sp158.jpg"
                    },
                    new SanPham{
                        product_id =160,
                        product_type_id = 2,
                        brand_id =45 ,
                        name = "HUXLEY OIL ; LIGHT AND MORE",
                        amount = 50,
                        price = 832000 ,
                        description = "Là một trong những hãng có 100% thành phần chiết xuất từ thiên nhiên, giúp điều trị và xoa dịu làn da từ sâu trong lỗ chân lông. được thành lập từ những năm 2000 với chủ sở hữu thương hiệu là một nam beauty guru. như một thương hiệu mỹ phẩm cao cấp với các sản phẩm chăm sóc da chứa thành phần dầu hạt cây xương rồng Prickly Pear.",
                        use = "Sau khi làm sạch da bằng sữa rửa mặt , cân bằng da với toner  và cung cấp dưỡng chất với các sản phẩm điều trị , bạn thoa kem dưỡng kiểm soát dầu lên toàn mặt, cổ và vùng hở ngực. Sản phẩm này chỉ dùng vào buổi sáng. Thế nên, bạn nên bổ sung kem dưỡng ẩm ban đêm dành cho da dầu vào quy trình chăm sóc da buổi tối. ",
                        img = "/image/sp159.jpg"
                    },
                    new SanPham{
                        product_id =161,
                        product_type_id = 2,
                        brand_id =12 ,
                        name = "Radha Argan Oil",
                        amount = 50,
                        price = 512000 ,
                        description = "Là một trong những hãng có 100% thành phần chiết xuất từ thiên nhiên, giúp điều trị và xoa dịu làn da từ sâu trong lỗ chân lông. được thành lập từ những năm 2000 với chủ sở hữu thương hiệu là một nam beauty guru. như một thương hiệu mỹ phẩm cao cấp với các sản phẩm chăm sóc da chứa thành phần dầu hạt cây xương rồng Prickly Pear.",
                        use = "Sau khi làm sạch da bằng sữa rửa mặt , cân bằng da với toner  và cung cấp dưỡng chất với các sản phẩm điều trị , bạn thoa kem dưỡng kiểm soát dầu lên toàn mặt, cổ và vùng hở ngực. Sản phẩm này chỉ dùng vào buổi sáng. Thế nên, bạn nên bổ sung kem dưỡng ẩm ban đêm dành cho da dầu vào quy trình chăm sóc da buổi tối. ",
                        img = "/image/sp160.jpg"
                    },
                    new SanPham{
                        product_id = 162,
                        product_type_id = 2,
                        brand_id =44 ,
                        name = "Mad Hippie Face Cream 30ml",
                        amount = 50,
                        price = 722000 ,
                        description = "Là một trong những hãng có 100% thành phần chiết xuất từ thiên nhiên, giúp điều trị và xoa dịu làn da từ sâu trong lỗ chân lông. được thành lập từ những năm 2000 với chủ sở hữu thương hiệu là một nam beauty guru. như một thương hiệu mỹ phẩm cao cấp với các sản phẩm chăm sóc da chứa thành phần dầu hạt cây xương rồng Prickly Pear.",
                        use = "Sau khi làm sạch da bằng sữa rửa mặt , cân bằng da với toner  và cung cấp dưỡng chất với các sản phẩm điều trị , bạn thoa kem dưỡng kiểm soát dầu lên toàn mặt, cổ và vùng hở ngực. Sản phẩm này chỉ dùng vào buổi sáng. Thế nên, bạn nên bổ sung kem dưỡng ẩm ban đêm dành cho da dầu vào quy trình chăm sóc da buổi tối. ",
                        img = "/image/sp161.jpg"
                    },
                    new SanPham{
                        product_id =163,
                        product_type_id = 2,
                        brand_id = 52,
                        name = "Balance Active Formula Dragons Blood Eye Cream 15ml",
                        amount = 50,
                        price = 902000 ,
                        description = "Là một trong những hãng có 100% thành phần chiết xuất từ thiên nhiên, giúp điều trị và xoa dịu làn da từ sâu trong lỗ chân lông. được thành lập từ những năm 2000 với chủ sở hữu thương hiệu là một nam beauty guru. như một thương hiệu mỹ phẩm cao cấp với các sản phẩm chăm sóc da chứa thành phần dầu hạt cây xương rồng Prickly Pear.",
                        use = "-Dùng ngón áp út lấy kem và dặm nhẹ vùng trên, dọc theo hốc mắt và vùng xương chân mày từ trong ra ngoài theo 4 điểm ấn huyệt. Thoa nhẹ ở vùng dưới mắt, dọc theo hốc mắt từ trong ra ngoài theo 4 điểm ấn huyệt.",
                        img = "/image/sp162.jpg"
                    },
                    new SanPham{
                        product_id =164,
                        product_type_id = 2,
                        brand_id = 43,
                        name = "AHC ANGELESS REAL EYE CREAM FOR FACE 12ml",
                        amount = 50,
                        price = 412000 ,
                        description = "Là một trong những hãng có 100% thành phần chiết xuất từ thiên nhiên, giúp điều trị và xoa dịu làn da từ sâu trong lỗ chân lông. được thành lập từ những năm 2000 với chủ sở hữu thương hiệu là một nam beauty guru. như một thương hiệu mỹ phẩm cao cấp với các sản phẩm chăm sóc da chứa thành phần dầu hạt cây xương rồng Prickly Pear.",
                        use = "-Dùng ngón áp út lấy kem và dặm nhẹ vùng trên, dọc theo hốc mắt và vùng xương chân mày từ trong ra ngoài theo 4 điểm ấn huyệt. Thoa nhẹ ở vùng dưới mắt, dọc theo hốc mắt từ trong ra ngoài theo 4 điểm ấn huyệt.",
                        img = "/image/sp163.jpg"
                    },
                    new SanPham{
                        product_id = 165,
                        product_type_id = 2,
                        brand_id =44 ,
                        name = "Mad Hippie Eye Cream 15ml",
                        amount = 50,
                        price = 1411000 ,
                        description = "Là một trong những hãng có 100% thành phần chiết xuất từ thiên nhiên, giúp điều trị và xoa dịu làn da từ sâu trong lỗ chân lông. được thành lập từ những năm 2000 với chủ sở hữu thương hiệu là một nam beauty guru. như một thương hiệu mỹ phẩm cao cấp với các sản phẩm chăm sóc da chứa thành phần dầu hạt cây xương rồng Prickly Pear.",
                        use = "-Dùng ngón áp út lấy kem và dặm nhẹ vùng trên, dọc theo hốc mắt và vùng xương chân mày từ trong ra ngoài theo 4 điểm ấn huyệt. Thoa nhẹ ở vùng dưới mắt, dọc theo hốc mắt từ trong ra ngoài theo 4 điểm ấn huyệt.",
                        img = "/image/sp164.jpg"
                    },
                    new SanPham{
                        product_id = 166,
                        product_type_id = 2,
                        brand_id = 8,
                        name = "Innisfree Green Tea Mist 50 ml",
                        amount = 50,
                        price = 617000 ,
                        description = "là những bác sĩ da liễu từng đoạt giải Nobel đã phát triển hệ thống thương hiệu Healing Concentrate ™ để cung cấp các khoáng chất trị liệu, mang lại một làn da trẻ trung hơn. Các sản phẩm chứa khoáng chất với các hoạt chất tự nhiên khác như làm sạch bùn đất Hungary, các sản phẩm của Omorovicza đã có được sự sùng bái trên toàn thế giới nhờ các đặc tính chống lão hóa, phát sáng. Được kết hợp với các vitamin tốt nhất, tinh dầu và các thành phần tự nhiên khác có nguồn gốc từ khắp nơi trên thế giới, từ lòng hồ Heviz đến đỉnh núi Andes. Stephen và Margaret tin rằng sắc đẹp chỉ đến khi các sản phẩm chăm sóc da không chứa các thành phần có hại, gây bí bách cho da, cũng như vẻ đẹp đẹp hiện đại là sự kết hợp hoàn hảo của các thành phần truyền thống và các công thức khoa học tiên tiến. ",
                        use = "Xịt bất cứ lúc nào da cảm thấy khô và mệt mỏi. Xịt sau khi make up để lớp make up lâu trôi và bền đẹp.",
                        img = "/image/sp165.jpg"
                    },
                    new SanPham{
                        product_id =167,
                        product_type_id = 2,
                        brand_id =30,
                        name = "Mario Badescu Facial Spray with Aloe, Herbs and Rosewater",
                        amount = 50,
                        price = 1127000 ,
                        description = "là những bác sĩ da liễu từng đoạt giải Nobel đã phát triển hệ thống thương hiệu Healing Concentrate ™ để cung cấp các khoáng chất trị liệu, mang lại một làn da trẻ trung hơn. Các sản phẩm chứa khoáng chất với các hoạt chất tự nhiên khác như làm sạch bùn đất Hungary, các sản phẩm của Omorovicza đã có được sự sùng bái trên toàn thế giới nhờ các đặc tính chống lão hóa, phát sáng. Được kết hợp với các vitamin tốt nhất, tinh dầu và các thành phần tự nhiên khác có nguồn gốc từ khắp nơi trên thế giới, từ lòng hồ Heviz đến đỉnh núi Andes. Stephen và Margaret tin rằng sắc đẹp chỉ đến khi các sản phẩm chăm sóc da không chứa các thành phần có hại, gây bí bách cho da, cũng như vẻ đẹp đẹp hiện đại là sự kết hợp hoàn hảo của các thành phần truyền thống và các công thức khoa học tiên tiến. ",
                        use = "Xịt bất cứ lúc nào da cảm thấy khô và mệt mỏi. Xịt sau khi make up để lớp make up lâu trôi và bền đẹp.",
                        img = "/image/sp166.jpg"
                    },
                    new SanPham{
                        product_id = 168,
                        product_type_id = 2,
                        brand_id = 39,
                        name = "OMOROVICZA QUEEN OF HUNGARY MIST - 100 ml",
                        amount = 50,
                        price = 533000 ,
                        description = "là những bác sĩ da liễu từng đoạt giải Nobel đã phát triển hệ thống thương hiệu Healing Concentrate ™ để cung cấp các khoáng chất trị liệu, mang lại một làn da trẻ trung hơn. Các sản phẩm chứa khoáng chất với các hoạt chất tự nhiên khác như làm sạch bùn đất Hungary, các sản phẩm của Omorovicza đã có được sự sùng bái trên toàn thế giới nhờ các đặc tính chống lão hóa, phát sáng. Được kết hợp với các vitamin tốt nhất, tinh dầu và các thành phần tự nhiên khác có nguồn gốc từ khắp nơi trên thế giới, từ lòng hồ Heviz đến đỉnh núi Andes. Stephen và Margaret tin rằng sắc đẹp chỉ đến khi các sản phẩm chăm sóc da không chứa các thành phần có hại, gây bí bách cho da, cũng như vẻ đẹp đẹp hiện đại là sự kết hợp hoàn hảo của các thành phần truyền thống và các công thức khoa học tiên tiến. ",
                        use = "Xịt bất cứ lúc nào da cảm thấy khô và mệt mỏi. Xịt sau khi make up để lớp make up lâu trôi và bền đẹp.",
                        img = "/image/sp167.jpg"
                    },
                    new SanPham{
                        product_id = 169,
                        product_type_id = 2,
                        brand_id =30 ,
                        name = "Mario Badescu Facial Spray with Aloe, Cucumber and Green Tea 29ml",
                        amount = 50,
                        price = 1327000 ,
                        description = "là những bác sĩ da liễu từng đoạt giải Nobel đã phát triển hệ thống thương hiệu Healing Concentrate ™ để cung cấp các khoáng chất trị liệu, mang lại một làn da trẻ trung hơn. Các sản phẩm chứa khoáng chất với các hoạt chất tự nhiên khác như làm sạch bùn đất Hungary, các sản phẩm của Omorovicza đã có được sự sùng bái trên toàn thế giới nhờ các đặc tính chống lão hóa, phát sáng. Được kết hợp với các vitamin tốt nhất, tinh dầu và các thành phần tự nhiên khác có nguồn gốc từ khắp nơi trên thế giới, từ lòng hồ Heviz đến đỉnh núi Andes. Stephen và Margaret tin rằng sắc đẹp chỉ đến khi các sản phẩm chăm sóc da không chứa các thành phần có hại, gây bí bách cho da, cũng như vẻ đẹp đẹp hiện đại là sự kết hợp hoàn hảo của các thành phần truyền thống và các công thức khoa học tiên tiến. ",
                        use = "Xịt bất cứ lúc nào da cảm thấy khô và mệt mỏi. Xịt sau khi make up để lớp make up lâu trôi và bền đẹp.",
                        img = "/image/sp168.jpg"
                    },
                    new SanPham{
                        product_id =170,
                        product_type_id = 2,
                        brand_id = 50,
                        name = "Mario Badescu Acne Facial Cleanser - 177ml ",
                        amount = 50,
                        price = 62000 ,
                        description = "Tinh chất với những thành phần chuyên biệt giúp da săn chắc hơn, tăng độ đàn hồi đồng thời giảm thiểu sự xuất hiện của những đường nhăn, làm mờ những nếp nhăn, phục hồi sức sống cho làn da và đem nét tươi trẻ đến cho từng đường nét trên gương mặt bạn.",
                        use = "Sau khi rửa mặt và lau khô, apply serum lên đều khắp mặt, massage nhẹ nhàng trên da cho đến khi serum chuyển từ màu đỏ sang tím, không để quá 10', rồi rửa lại với nước ấm.",
                        img = "/image/sp169.jpg"
                    },
                    new SanPham{
                        product_id = 171,
                        product_type_id = 2,
                        brand_id = 14,
                        name = "Neutrogena Oil - Free Acne Wash - 269ml",
                        amount = 50,
                        price = 621000 ,
                        description = "Tinh chất với những thành phần chuyên biệt giúp da săn chắc hơn, tăng độ đàn hồi đồng thời giảm thiểu sự xuất hiện của những đường nhăn, làm mờ những nếp nhăn, phục hồi sức sống cho làn da và đem nét tươi trẻ đến cho từng đường nét trên gương mặt bạn.",
                        use = "Sau khi rửa mặt và lau khô, apply serum lên đều khắp mặt, massage nhẹ nhàng trên da cho đến khi serum chuyển từ màu đỏ sang tím, không để quá 10', rồi rửa lại với nước ấm.",
                        img = "/image/sp170.jpg"
                    },
                    new SanPham{
                        product_id =172,
                        product_type_id = 2,
                        brand_id = 35,
                        name = "AHA 7 WHITEHEAD POWER LIQUID 100ML",
                        amount = 50,
                        price = 52000 ,
                        description = "Tinh chất với những thành phần chuyên biệt giúp da săn chắc hơn, tăng độ đàn hồi đồng thời giảm thiểu sự xuất hiện của những đường nhăn, làm mờ những nếp nhăn, phục hồi sức sống cho làn da và đem nét tươi trẻ đến cho từng đường nét trên gương mặt bạn.",
                        use = "Sau khi rửa mặt và lau khô, apply serum lên đều khắp mặt, massage nhẹ nhàng trên da cho đến khi serum chuyển từ màu đỏ sang tím, không để quá 10', rồi rửa lại với nước ấm.",
                        img = "/image/sp171.jpg"
                    },
                    new SanPham{
                        product_id = 173,
                        product_type_id = 2,
                        brand_id = 46,
                        name = "SUNDAY RILEY Flash Fix Kit",
                        amount = 50,
                        price = 562000 ,
                        description = "Tinh chất với những thành phần chuyên biệt giúp da săn chắc hơn, tăng độ đàn hồi đồng thời giảm thiểu sự xuất hiện của những đường nhăn, làm mờ những nếp nhăn, phục hồi sức sống cho làn da và đem nét tươi trẻ đến cho từng đường nét trên gương mặt bạn.",
                        use = "Sau khi rửa mặt và lau khô, apply serum lên đều khắp mặt, massage nhẹ nhàng trên da cho đến khi serum chuyển từ màu đỏ sang tím, không để quá 10', rồi rửa lại với nước ấm.",
                        img = "/image/sp172.jpg"
                    },
                    new SanPham{
                        product_id = 174,
                        product_type_id = 2,
                        brand_id = 38,
                        name = "ELEMIS Papaya Enzyme Peel 15ml",
                        amount = 50,
                        price = 627000 ,
                        description = "Tinh chất với những thành phần chuyên biệt giúp da săn chắc hơn, tăng độ đàn hồi đồng thời giảm thiểu sự xuất hiện của những đường nhăn, làm mờ những nếp nhăn, phục hồi sức sống cho làn da và đem nét tươi trẻ đến cho từng đường nét trên gương mặt bạn.",
                        use = "Sau khi rửa mặt và lau khô, apply serum lên đều khắp mặt, massage nhẹ nhàng trên da cho đến khi serum chuyển từ màu đỏ sang tím, không để quá 10', rồi rửa lại với nước ấm.",
                        img = "/image/sp173.jpg"
                    },
                    new SanPham{
                        product_id = 175,
                        product_type_id = 2,
                        brand_id =52 ,
                        name = "So Natural Red Peel Tingle Serum",
                        amount = 50,
                        price = 622000 ,
                        description = "Tinh chất với những thành phần chuyên biệt giúp da săn chắc hơn, tăng độ đàn hồi đồng thời giảm thiểu sự xuất hiện của những đường nhăn, làm mờ những nếp nhăn, phục hồi sức sống cho làn da và đem nét tươi trẻ đến cho từng đường nét trên gương mặt bạn.",
                        use = "Sau khi rửa mặt và lau khô, apply serum lên đều khắp mặt, massage nhẹ nhàng trên da cho đến khi serum chuyển từ màu đỏ sang tím, không để quá 10', rồi rửa lại với nước ấm.",
                        img = "/image/sp174.jpg"
                    },
                    new SanPham{
                        product_id = 176,
                        product_type_id = 2,
                        brand_id = 41,
                        name = "Clinique iD™: Hydrating Jelly + Cartridge for Irritation 125ml",
                        amount = 50,
                        price = 921000 ,
                        description = "Tinh chất với những thành phần chuyên biệt giúp da săn chắc hơn, tăng độ đàn hồi đồng thời giảm thiểu sự xuất hiện của những đường nhăn, làm mờ những nếp nhăn, phục hồi sức sống cho làn da và đem nét tươi trẻ đến cho từng đường nét trên gương mặt bạn.",
                        use = "Sau khi rửa mặt và lau khô, apply serum lên đều khắp mặt, massage nhẹ nhàng trên da cho đến khi serum chuyển từ màu đỏ sang tím, không để quá 10', rồi rửa lại với nước ấm.",
                        img = "/image/sp175.jpg"
                    },
                    new SanPham{
                        product_id =177 ,
                        product_type_id = 2,
                        brand_id = 41,
                        name = "Clinique iD™: Hydrating Jelly + Cartridge for Fatigue 125ml",
                        amount = 50,
                        price = 757000 ,
                        description = "Tinh chất với những thành phần chuyên biệt giúp da săn chắc hơn, tăng độ đàn hồi đồng thời giảm thiểu sự xuất hiện của những đường nhăn, làm mờ những nếp nhăn, phục hồi sức sống cho làn da và đem nét tươi trẻ đến cho từng đường nét trên gương mặt bạn.",
                        use = "Sau khi rửa mặt và lau khô, apply serum lên đều khắp mặt, massage nhẹ nhàng trên da cho đến khi serum chuyển từ màu đỏ sang tím, không để quá 10', rồi rửa lại với nước ấm.",
                        img = "/image/sp176.jpg"
                    },
                    new SanPham{
                        product_id =178,
                        product_type_id = 2,
                        brand_id = 41,
                        name = "Clinique iD™: Hydrating Jelly + Cartridge for Lines & Wrinkles - Jelly 125ml",
                        amount = 50,
                        price = 743000 ,
                        description = "Tinh chất với những thành phần chuyên biệt giúp da săn chắc hơn, tăng độ đàn hồi đồng thời giảm thiểu sự xuất hiện của những đường nhăn, làm mờ những nếp nhăn, phục hồi sức sống cho làn da và đem nét tươi trẻ đến cho từng đường nét trên gương mặt bạn.",
                        use = "Sau khi rửa mặt và lau khô, apply serum lên đều khắp mặt, massage nhẹ nhàng trên da cho đến khi serum chuyển từ màu đỏ sang tím, không để quá 10', rồi rửa lại với nước ấm.",
                        img = "/image/sp177.jpg"
                    },
                    new SanPham{
                        product_id =179 ,
                        product_type_id = 2,
                        brand_id = 51,
                        name = "Balance Active Formula Dragon’s Blood Lifting Serum 30ml",
                        amount = 50,
                        price = 214000 ,
                        description = "Tinh chất với những thành phần chuyên biệt giúp da săn chắc hơn, tăng độ đàn hồi đồng thời giảm thiểu sự xuất hiện của những đường nhăn, làm mờ những nếp nhăn, phục hồi sức sống cho làn da và đem nét tươi trẻ đến cho từng đường nét trên gương mặt bạn.",
                        use = "Sau khi rửa mặt và lau khô, apply serum lên đều khắp mặt, massage nhẹ nhàng trên da cho đến khi serum chuyển từ màu đỏ sang tím, không để quá 10', rồi rửa lại với nước ấm.",
                        img = "/image/sp178.jpg"
                    },
                    new SanPham{
                        product_id =180 ,
                        product_type_id = 2,
                        brand_id = 36,
                        name = "Cosrx Galactomyces 95 Tone Balancing Essence",
                        amount = 50,
                        price = 521000 ,
                        description = "Tinh chất với những thành phần chuyên biệt giúp da săn chắc hơn, tăng độ đàn hồi đồng thời giảm thiểu sự xuất hiện của những đường nhăn, làm mờ những nếp nhăn, phục hồi sức sống cho làn da và đem nét tươi trẻ đến cho từng đường nét trên gương mặt bạn.",
                        use = "Sau khi rửa mặt và lau khô, apply serum lên đều khắp mặt, massage nhẹ nhàng trên da cho đến khi serum chuyển từ màu đỏ sang tím, không để quá 10', rồi rửa lại với nước ấm.",
                        img = "/image/sp179.jpg"
                    },
                    new SanPham{
                        product_id = 181,
                        product_type_id = 2,
                        brand_id =46 ,
                        name = "Some By Mi 30 Days Miracle Tea Tree Clear Spot Oil 10ml",
                        amount = 50,
                        price = 251000 ,
                        description = "Tinh chất với những thành phần chuyên biệt giúp da săn chắc hơn, tăng độ đàn hồi đồng thời giảm thiểu sự xuất hiện của những đường nhăn, làm mờ những nếp nhăn, phục hồi sức sống cho làn da và đem nét tươi trẻ đến cho từng đường nét trên gương mặt bạn.",
                        use = "Sau khi rửa mặt và lau khô, apply serum lên đều khắp mặt, massage nhẹ nhàng trên da cho đến khi serum chuyển từ màu đỏ sang tím, không để quá 10', rồi rửa lại với nước ấm.",
                        img = "/image/sp180.jpg"
                    },
                    new SanPham{
                        product_id =182 ,
                        product_type_id = 2,
                        brand_id =47 ,
                        name = "Epiconce Intense Defense Serum 12ml",
                        amount = 50,
                        price = 342000 ,
                        description = "Tinh chất với những thành phần chuyên biệt giúp da săn chắc hơn, tăng độ đàn hồi đồng thời giảm thiểu sự xuất hiện của những đường nhăn, làm mờ những nếp nhăn, phục hồi sức sống cho làn da và đem nét tươi trẻ đến cho từng đường nét trên gương mặt bạn.",
                        use = "Sau khi rửa mặt và lau khô, apply serum lên đều khắp mặt, massage nhẹ nhàng trên da cho đến khi serum chuyển từ màu đỏ sang tím, không để quá 10', rồi rửa lại với nước ấm.",
                        img = "/image/sp181.jpg"
                    },
                    new SanPham{
                        product_id = 183,
                        product_type_id = 2,
                        brand_id =51 ,
                        name = "Balance Active Formula Dragon’s Blood Lifting Serum 30ml",
                        amount = 50,
                        price = 1154000 ,
                        description = "Tinh chất với những thành phần chuyên biệt giúp da săn chắc hơn, tăng độ đàn hồi đồng thời giảm thiểu sự xuất hiện của những đường nhăn, làm mờ những nếp nhăn, phục hồi sức sống cho làn da và đem nét tươi trẻ đến cho từng đường nét trên gương mặt bạn.",
                        use = "Sau khi rửa mặt và lau khô, apply serum lên đều khắp mặt, massage nhẹ nhàng trên da cho đến khi serum chuyển từ màu đỏ sang tím, không để quá 10', rồi rửa lại với nước ấm.",
                        img = "/image/sp182.jpg"
                    },
                    new SanPham{
                        product_id = 184,
                        product_type_id = 2,
                        brand_id = 9,
                        name = "HYALURONIC ACID SERUM 100 % PURE 30ml",
                        amount = 50,
                        price = 742000 ,
                        description = "Tinh chất với những thành phần chuyên biệt giúp da săn chắc hơn, tăng độ đàn hồi đồng thời giảm thiểu sự xuất hiện của những đường nhăn, làm mờ những nếp nhăn, phục hồi sức sống cho làn da và đem nét tươi trẻ đến cho từng đường nét trên gương mặt bạn.",
                        use = "Sau khi rửa mặt và lau khô, apply serum lên đều khắp mặt, massage nhẹ nhàng trên da cho đến khi serum chuyển từ màu đỏ sang tím, không để quá 10', rồi rửa lại với nước ấm.",
                        img = "/image/sp183.jpg"
                    },
                    new SanPham{
                        product_id =185 ,
                        product_type_id = 2,
                        brand_id =19 ,
                        name = "Natural Red Peel Tingle Serum",
                        amount = 50,
                        price =522000 ,
                        description = "Tinh chất với những thành phần chuyên biệt giúp da săn chắc hơn, tăng độ đàn hồi đồng thời giảm thiểu sự xuất hiện của những đường nhăn, làm mờ những nếp nhăn, phục hồi sức sống cho làn da và đem nét tươi trẻ đến cho từng đường nét trên gương mặt bạn.",
                        use = "Sau khi rửa mặt và lau khô, apply serum lên đều khắp mặt, massage nhẹ nhàng trên da cho đến khi serum chuyển từ màu đỏ sang tím, không để quá 10', rồi rửa lại với nước ấm.",
                        img = "/image/sp184.jpg"
                    },
                    new SanPham{
                        product_id =186 ,
                        product_type_id = 2,
                        brand_id =51 ,
                        name = "Balance Active Formula Gold Collagen Rejuvenating Eye Serum 15ml",
                        amount = 50,
                        price = 521000 ,
                        description = "Tinh chất với những thành phần chuyên biệt giúp da săn chắc hơn, tăng độ đàn hồi đồng thời giảm thiểu sự xuất hiện của những đường nhăn, làm mờ những nếp nhăn, phục hồi sức sống cho làn da và đem nét tươi trẻ đến cho từng đường nét trên gương mặt bạn.",
                        use = "Sau khi rửa mặt và lau khô, apply serum lên đều khắp mặt, massage nhẹ nhàng trên da cho đến khi serum chuyển từ màu đỏ sang tím, không để quá 10', rồi rửa lại với nước ấm.",
                        img = "/image/sp185.jpg"
                    },
                    new SanPham{
                        product_id = 187,
                        product_type_id = 2,
                        brand_id = 51,
                        name = "Balance Active Formula Gold Collagen Rejuvenating Serum 30ml",
                        amount = 50,
                        price = 767000 ,
                        description = "Tinh chất với những thành phần chuyên biệt giúp da săn chắc hơn, tăng độ đàn hồi đồng thời giảm thiểu sự xuất hiện của những đường nhăn, làm mờ những nếp nhăn, phục hồi sức sống cho làn da và đem nét tươi trẻ đến cho từng đường nét trên gương mặt bạn.",
                        use = "Sau khi rửa mặt và lau khô, apply serum lên đều khắp mặt, massage nhẹ nhàng trên da cho đến khi serum chuyển từ màu đỏ sang tím, không để quá 10', rồi rửa lại với nước ấm.",
                        img = "/image/sp186.jpg"
                    },
                    new SanPham{
                        product_id = 188,
                        product_type_id = 2,
                        brand_id = 24,
                        name = "Dr.Dennis Gross Ferulic + Retinol Triple Corection Eye Serum 15ml",
                        amount = 50,
                        price = 627000 ,
                        description = "Tinh chất với những thành phần chuyên biệt giúp da săn chắc hơn, tăng độ đàn hồi đồng thời giảm thiểu sự xuất hiện của những đường nhăn, làm mờ những nếp nhăn, phục hồi sức sống cho làn da và đem nét tươi trẻ đến cho từng đường nét trên gương mặt bạn.",
                        use = "Sau khi rửa mặt và lau khô, apply serum lên đều khắp mặt, massage nhẹ nhàng trên da cho đến khi serum chuyển từ màu đỏ sang tím, không để quá 10', rồi rửa lại với nước ấm.",
                        img = "/image/sp187.jpg"
                    },
                    new SanPham{
                        product_id =189 ,
                        product_type_id = 2,
                        brand_id = 42,
                        name = "Bioderma Atoderm Lèvres Stick Hydratant",
                        amount = 50,
                        price = 627000 ,
                        description = "là loại son dưỡng môi dạng sáp đến từ thương hiệu cao cấp Choonee thuộc tập đoàn IKE của Hàn Quốc, là một nhãn hàng với hình tượng xuyên suốt là  Story of a girl from countryside - đem lại những sản phảm gần gũi với nguyên liệu chính từ tự nhiên. ",
                        use = "Trang điểm đôi môi trông tự nhiên bằng cách thoa lên toàn bộ môi dọc theo đường viền môi hoặc bằng cách thoa vào giữa môi.",
                        img = "/image/sp188.jpg"
                    },
                    new SanPham{
                        product_id = 190,
                        product_type_id = 2,
                        brand_id =49 ,
                        name = "Carmex Lip Balm Stick SPF 15",
                        amount = 50,
                        price = 427000 ,
                        description = "là loại son dưỡng môi dạng sáp đến từ thương hiệu cao cấp Choonee thuộc tập đoàn IKE của Hàn Quốc, là một nhãn hàng với hình tượng xuyên suốt là  Story of a girl from countryside - đem lại những sản phảm gần gũi với nguyên liệu chính từ tự nhiên. ",
                        use = "Trang điểm đôi môi trông tự nhiên bằng cách thoa lên toàn bộ môi dọc theo đường viền môi hoặc bằng cách thoa vào giữa môi.",
                        img = "/image/sp189.jpg"
                    },
                    new SanPham{
                        product_id =191 ,
                        product_type_id = 2,
                        brand_id =8 ,
                        name = "innisfree Glow tint lip balm 3.5g - 01",
                        amount = 50,
                        price =637000 ,
                        description = "là loại son dưỡng môi dạng sáp đến từ thương hiệu cao cấp Choonee thuộc tập đoàn IKE của Hàn Quốc, là một nhãn hàng với hình tượng xuyên suốt là  Story of a girl from countryside - đem lại những sản phảm gần gũi với nguyên liệu chính từ tự nhiên. ",
                        use = "Trang điểm đôi môi trông tự nhiên bằng cách thoa lên toàn bộ môi dọc theo đường viền môi hoặc bằng cách thoa vào giữa môi.",
                        img = "/image/sp190.jpg"
                    },
                    new SanPham{
                        product_id = 192,
                        product_type_id = 2,
                        brand_id = 16,
                        name = "HOONEE WATERLIP TINT BALM - PINK GUAVA",
                        amount = 50,
                        price = 874000 ,
                        description = "là loại son dưỡng môi dạng sáp đến từ thương hiệu cao cấp Choonee thuộc tập đoàn IKE của Hàn Quốc, là một nhãn hàng với hình tượng xuyên suốt là  Story of a girl from countryside - đem lại những sản phảm gần gũi với nguyên liệu chính từ tự nhiên. ",
                        use = "Trang điểm đôi môi trông tự nhiên bằng cách thoa lên toàn bộ môi dọc theo đường viền môi hoặc bằng cách thoa vào giữa môi.",
                        img = "/image/sp191.jpg"
                    },
                    new SanPham{
                        product_id =193 ,
                        product_type_id = 2,
                        brand_id =23 ,
                        name = "Elizabeth Arden Eight Hour® Cream Intensive Moisture Hand Treatment 30ml",
                        amount = 50,
                        price = 921000 ,
                        description = "là loại son dưỡng môi dạng sáp đến từ thương hiệu cao cấp Choonee thuộc tập đoàn IKE của Hàn Quốc, là một nhãn hàng với hình tượng xuyên suốt là  Story of a girl from countryside - đem lại những sản phảm gần gũi với nguyên liệu chính từ tự nhiên. ",
                        use = "Trang điểm đôi môi trông tự nhiên bằng cách thoa lên toàn bộ môi dọc theo đường viền môi hoặc bằng cách thoa vào giữa môi.",
                        img = "/image/sp192.jpg"
                    },
                    new SanPham{
                        product_id = 194,
                        product_type_id = 3,
                        brand_id =10 ,
                        name = "Dưỡng thể tẩy tế bào chết ALPHA SKINCARE - RENEWAL BODY LOTION WITH 12 % AHA, 12 OZ 340ml",
                        amount = 50,
                        price = 777000 ,
                        description = "Với sự pha trộn giữ ẩm của sáp ong, dầu đậu phộng và dầu ngô làm cho chân tay mịn màng, mềm mại và sáng bóng sau khi bôi.",
                        use = "Sau khi làm sạch da bằng sữa rửa mặt (Clarifying Cleanser), cân bằng da với toner (Clarifying Toner) và cung cấp dưỡng chất với các sản phẩm điều trị , bạn thoa kem dưỡng kiểm soát dầu Oil-Control Mattifier SPF 15 PA++ lên toàn mặt, cổ và vùng hở ngực. Sản phẩm này chỉ dùng vào buổi sáng. Thế nên, bạn nên bổ sung kem dưỡng ẩm ban đêm dành cho da dầu Skin Perfecting Lotion vào quy trình chăm sóc da buổi tối. ",
                        img = "/image/sp193.jpg"
                    },
                    new SanPham{
                        product_id = 195,
                        product_type_id = 3,
                        brand_id = 52,
                        name = "Mario Badescu summer shine body lotion 29 ml",
                        amount = 50,
                        price = 927000 ,
                        description = "Với sự pha trộn giữ ẩm của sáp ong, dầu đậu phộng và dầu ngô làm cho chân tay mịn màng, mềm mại và sáng bóng sau khi bôi.",
                        use = "Sau khi làm sạch da bằng sữa rửa mặt (Clarifying Cleanser), cân bằng da với toner (Clarifying Toner) và cung cấp dưỡng chất với các sản phẩm điều trị , bạn thoa kem dưỡng kiểm soát dầu Oil-Control Mattifier SPF 15 PA++ lên toàn mặt, cổ và vùng hở ngực. Sản phẩm này chỉ dùng vào buổi sáng. Thế nên, bạn nên bổ sung kem dưỡng ẩm ban đêm dành cho da dầu Skin Perfecting Lotion vào quy trình chăm sóc da buổi tối. ",
                        img = "/image/sp194.jpg"
                    },
                    new SanPham{
                        product_id =196 ,
                        product_type_id = 3,
                        brand_id =12 ,
                        name = "Molton Brown Bath & Shower Gel - Heavenly Gingerlily 30ml ",
                        amount = 50,
                        price = 631000 ,
                        description = "Với sự pha trộn giữ ẩm của sáp ong, dầu đậu phộng và dầu ngô làm cho chân tay mịn màng, mềm mại và sáng bóng sau khi bôi.",
                        use = "Sau khi làm sạch da bằng sữa rửa mặt (Clarifying Cleanser), cân bằng da với toner (Clarifying Toner) và cung cấp dưỡng chất với các sản phẩm điều trị , bạn thoa kem dưỡng kiểm soát dầu Oil-Control Mattifier SPF 15 PA++ lên toàn mặt, cổ và vùng hở ngực. Sản phẩm này chỉ dùng vào buổi sáng. Thế nên, bạn nên bổ sung kem dưỡng ẩm ban đêm dành cho da dầu Skin Perfecting Lotion vào quy trình chăm sóc da buổi tối. ",
                        img = "/image/sp195.jpg"
                    },
                    new SanPham{
                        product_id = 197,
                        product_type_id = 3,
                        brand_id =48 ,
                        name = "Shiro Waki Hime Underarm Exfoliating & Brightening Cream",
                        amount = 50,
                        price = 867000 ,
                        description = "Với sự pha trộn giữ ẩm của sáp ong, dầu đậu phộng và dầu ngô làm cho chân tay mịn màng, mềm mại và sáng bóng sau khi bôi.",
                        use = "Sau khi làm sạch da bằng sữa rửa mặt (Clarifying Cleanser), cân bằng da với toner (Clarifying Toner) và cung cấp dưỡng chất với các sản phẩm điều trị , bạn thoa kem dưỡng kiểm soát dầu Oil-Control Mattifier SPF 15 PA++ lên toàn mặt, cổ và vùng hở ngực. Sản phẩm này chỉ dùng vào buổi sáng. Thế nên, bạn nên bổ sung kem dưỡng ẩm ban đêm dành cho da dầu Skin Perfecting Lotion vào quy trình chăm sóc da buổi tối. ",
                        img = "/image/sp196.jpg"
                    },
                    new SanPham{
                        product_id =198 ,
                        product_type_id = 4,
                        brand_id =13 ,
                        name = "Natural World Argan Oil of Morrocco Moisture Rich Shampoo 500ml",
                        amount = 50,
                        price = 827000 ,
                        description = "Dầu Xả được chiết xuất từ tinh dầu Argan - thứ vàng lỏng quý hiếm từ Bắc Phi và một hỗn hợp cao cấp của 4 loại tinh dầu (hương thảo, xả, cam và ngọc lan tây Ylang Ylang).",
                        use = "Sau khi làm sạch da bằng sữa rửa mặt (Clarifying Cleanser), cân bằng da với toner (Clarifying Toner) và cung cấp dưỡng chất với các sản phẩm điều trị , bạn thoa kem dưỡng kiểm soát dầu Oil-Control Mattifier SPF 15 PA++ lên toàn mặt, cổ và vùng hở ngực. Sản phẩm này chỉ dùng vào buổi sáng. Thế nên, bạn nên bổ sung kem dưỡng ẩm ban đêm dành cho da dầu Skin Perfecting Lotion vào quy trình chăm sóc da buổi tối. ",
                        img = "/image/sp197.jpg"
                    },
                    new SanPham{
                        product_id =199 ,
                        product_type_id = 4,
                        brand_id =30 ,
                        name = "SACHAJUAN Colour Protect Shampoo(100ml)",
                        amount = 50,
                        price = 622000 ,
                        description = "Dầu Xả được chiết xuất từ tinh dầu Argan - thứ vàng lỏng quý hiếm từ Bắc Phi và một hỗn hợp cao cấp của 4 loại tinh dầu (hương thảo, xả, cam và ngọc lan tây Ylang Ylang).",
                        use = "Sau khi làm sạch da bằng sữa rửa mặt (Clarifying Cleanser), cân bằng da với toner (Clarifying Toner) và cung cấp dưỡng chất với các sản phẩm điều trị , bạn thoa kem dưỡng kiểm soát dầu Oil-Control Mattifier SPF 15 PA++ lên toàn mặt, cổ và vùng hở ngực. Sản phẩm này chỉ dùng vào buổi sáng. Thế nên, bạn nên bổ sung kem dưỡng ẩm ban đêm dành cho da dầu Skin Perfecting Lotion vào quy trình chăm sóc da buổi tối. ",
                        img = "/image/sp198.jpg"
                    },
                    new SanPham{
                        product_id = 200,
                        product_type_id = 4,
                        brand_id =13 ,
                        name = "Natural World Argan Oil of Morrocco Moisture Rich Conditioner 500ml",
                        amount = 50,
                        price = 252000 ,
                        description = "Dầu Xả được chiết xuất từ tinh dầu Argan - thứ vàng lỏng quý hiếm từ Bắc Phi và một hỗn hợp cao cấp của 4 loại tinh dầu (hương thảo, xả, cam và ngọc lan tây Ylang Ylang).",
                        use = "Sau khi làm sạch da bằng sữa rửa mặt (Clarifying Cleanser), cân bằng da với toner (Clarifying Toner) và cung cấp dưỡng chất với các sản phẩm điều trị , bạn thoa kem dưỡng kiểm soát dầu Oil-Control Mattifier SPF 15 PA++ lên toàn mặt, cổ và vùng hở ngực. Sản phẩm này chỉ dùng vào buổi sáng. Thế nên, bạn nên bổ sung kem dưỡng ẩm ban đêm dành cho da dầu Skin Perfecting Lotion vào quy trình chăm sóc da buổi tối. ",
                        img = "/image/sp199.jpg"
                    },
                    new SanPham{
                        product_id =201 ,
                        product_type_id = 4,
                        brand_id =12 ,
                        name = "John Masters Rosemary & Peppermint Detangler",
                        amount = 50,
                        price = 521000 ,
                        description = "Dầu Xả được chiết xuất từ tinh dầu Argan - thứ vàng lỏng quý hiếm từ Bắc Phi và một hỗn hợp cao cấp của 4 loại tinh dầu (hương thảo, xả, cam và ngọc lan tây Ylang Ylang).",
                        use = "Sau khi làm sạch da bằng sữa rửa mặt (Clarifying Cleanser), cân bằng da với toner (Clarifying Toner) và cung cấp dưỡng chất với các sản phẩm điều trị , bạn thoa kem dưỡng kiểm soát dầu Oil-Control Mattifier SPF 15 PA++ lên toàn mặt, cổ và vùng hở ngực. Sản phẩm này chỉ dùng vào buổi sáng. Thế nên, bạn nên bổ sung kem dưỡng ẩm ban đêm dành cho da dầu Skin Perfecting Lotion vào quy trình chăm sóc da buổi tối. ",
                        img = "/image/sp200.jpg"
                    },
                    new SanPham{
                        product_id = 202,
                        product_type_id = 5,
                        brand_id =4 ,
                        name = "Vasanti Eyeshadow Brush", 
                        amount = 50,
                        price = 655000 ,
                        description = "là hãng mỹ phẩm trang điểm chuyên nghiệp nổi tiếng trên thế giới với trụ sở chính đặt tại thành phố New York. Thương hiệu này được sáng lập bởi 2 người Canada là Frank Toskan và Frank Angelo. Năm 1991, công ty mở cửa hàng đầu tiên tại New York. Ban đầu thiết kế sản phẩm dành cho các chuyên viên trang điểm chuyên nghiệp, tuy nhiên, hiện nay thương hiệu đã được bán cho tất cả các khách hàng trên toàn thế giới. Mỹ phẩm nổi tiếng về độ bám màu, bảng màu sắc phong phú và đa dạng, lên hình đẹp, phù hợp cho các sàn diễn, diễn viên khi lên sân khấu, bên cạnh đó các sản phẩm của hãng được rất nhiều người phụ nữ dùng hàng ngày để làm đẹp cho bản thân.",
                        use = "Sử dụng cọ để tán phấn mắt màu sáng vào giữa bầu mắt như là 1 cách highlight cho mắt để làm mắt to hơn và sáng hơn",
                        img = "/image/sp201.jpg"
                    },
                    new SanPham{
                        product_id = 203,
                        product_type_id = 5,
                        brand_id = 19,
                        name = "Morphe E3 Precision Pointed Powder Brush",
                        amount = 50,
                        price = 541000 ,
                        description = "là hãng mỹ phẩm trang điểm chuyên nghiệp nổi tiếng trên thế giới với trụ sở chính đặt tại thành phố New York. Thương hiệu này được sáng lập bởi 2 người Canada là Frank Toskan và Frank Angelo. Năm 1991, công ty mở cửa hàng đầu tiên tại New York. Ban đầu thiết kế sản phẩm dành cho các chuyên viên trang điểm chuyên nghiệp, tuy nhiên, hiện nay thương hiệu đã được bán cho tất cả các khách hàng trên toàn thế giới. Mỹ phẩm nổi tiếng về độ bám màu, bảng màu sắc phong phú và đa dạng, lên hình đẹp, phù hợp cho các sàn diễn, diễn viên khi lên sân khấu, bên cạnh đó các sản phẩm của hãng được rất nhiều người phụ nữ dùng hàng ngày để làm đẹp cho bản thân.",
                        use = "Sử dụng cọ để tán phấn mắt màu sáng vào giữa bầu mắt như là 1 cách highlight cho mắt để làm mắt to hơn và sáng hơn",
                        img = "/image/sp202.jpg"
                    },
                    new SanPham{
                        product_id = 204,
                        product_type_id = 5,
                        brand_id = 19,
                        name = "Morphe E3 Precision Pointed Powder Brush",
                        amount = 50,
                        price = 1227000 ,
                        description = "là hãng mỹ phẩm trang điểm chuyên nghiệp nổi tiếng trên thế giới với trụ sở chính đặt tại thành phố New York. Thương hiệu này được sáng lập bởi 2 người Canada là Frank Toskan và Frank Angelo. Năm 1991, công ty mở cửa hàng đầu tiên tại New York. Ban đầu thiết kế sản phẩm dành cho các chuyên viên trang điểm chuyên nghiệp, tuy nhiên, hiện nay thương hiệu đã được bán cho tất cả các khách hàng trên toàn thế giới. Mỹ phẩm nổi tiếng về độ bám màu, bảng màu sắc phong phú và đa dạng, lên hình đẹp, phù hợp cho các sàn diễn, diễn viên khi lên sân khấu, bên cạnh đó các sản phẩm của hãng được rất nhiều người phụ nữ dùng hàng ngày để làm đẹp cho bản thân.",
                        use = "Sử dụng cọ để tán phấn mắt màu sáng vào giữa bầu mắt như là 1 cách highlight cho mắt để làm mắt to hơn và sáng hơn",
                        img = "/image/sp203.jpg"
                    },
                    new SanPham{
                        product_id =205 ,
                        product_type_id = 5,
                        brand_id =13 ,
                        name = "M.A.C 210 Precise EyeLiner Brush",
                        amount = 50,
                        price = 2427000 ,
                        description = "là hãng mỹ phẩm trang điểm chuyên nghiệp nổi tiếng trên thế giới với trụ sở chính đặt tại thành phố New York. Thương hiệu này được sáng lập bởi 2 người Canada là Frank Toskan và Frank Angelo. Năm 1991, công ty mở cửa hàng đầu tiên tại New York. Ban đầu thiết kế sản phẩm dành cho các chuyên viên trang điểm chuyên nghiệp, tuy nhiên, hiện nay thương hiệu đã được bán cho tất cả các khách hàng trên toàn thế giới. Mỹ phẩm nổi tiếng về độ bám màu, bảng màu sắc phong phú và đa dạng, lên hình đẹp, phù hợp cho các sàn diễn, diễn viên khi lên sân khấu, bên cạnh đó các sản phẩm của hãng được rất nhiều người phụ nữ dùng hàng ngày để làm đẹp cho bản thân.",
                        use = "Sử dụng cọ để tán phấn mắt màu sáng vào giữa bầu mắt như là 1 cách highlight cho mắt để làm mắt to hơn và sáng hơn",
                        img = "/image/sp204.jpg"
                    },
                    new SanPham{
                        product_id =206 ,
                        product_type_id = 5,
                        brand_id = 51,
                        name = "Lixibox Brush Net Guard Set 10 pcs",
                        amount = 50,
                        price = 427000 ,
                        description = "là hãng mỹ phẩm trang điểm chuyên nghiệp nổi tiếng trên thế giới với trụ sở chính đặt tại thành phố New York. Thương hiệu này được sáng lập bởi 2 người Canada là Frank Toskan và Frank Angelo. Năm 1991, công ty mở cửa hàng đầu tiên tại New York. Ban đầu thiết kế sản phẩm dành cho các chuyên viên trang điểm chuyên nghiệp, tuy nhiên, hiện nay thương hiệu đã được bán cho tất cả các khách hàng trên toàn thế giới. Mỹ phẩm nổi tiếng về độ bám màu, bảng màu sắc phong phú và đa dạng, lên hình đẹp, phù hợp cho các sàn diễn, diễn viên khi lên sân khấu, bên cạnh đó các sản phẩm của hãng được rất nhiều người phụ nữ dùng hàng ngày để làm đẹp cho bản thân.",
                        use = "Sử dụng cọ để tán phấn mắt màu sáng vào giữa bầu mắt như là 1 cách highlight cho mắt để làm mắt to hơn và sáng hơn",
                        img = "/image/sp205.jpg"
                    },
                    new SanPham{
                        product_id =207 ,
                        product_type_id = 5,
                        brand_id = 51,
                        name = "Cọ Chikuhodo R - P6 Powder",
                        amount = 50,
                        price = 627000 ,
                        description = "là hãng mỹ phẩm trang điểm chuyên nghiệp nổi tiếng trên thế giới với trụ sở chính đặt tại thành phố New York. Thương hiệu này được sáng lập bởi 2 người Canada là Frank Toskan và Frank Angelo. Năm 1991, công ty mở cửa hàng đầu tiên tại New York. Ban đầu thiết kế sản phẩm dành cho các chuyên viên trang điểm chuyên nghiệp, tuy nhiên, hiện nay thương hiệu đã được bán cho tất cả các khách hàng trên toàn thế giới. Mỹ phẩm nổi tiếng về độ bám màu, bảng màu sắc phong phú và đa dạng, lên hình đẹp, phù hợp cho các sàn diễn, diễn viên khi lên sân khấu, bên cạnh đó các sản phẩm của hãng được rất nhiều người phụ nữ dùng hàng ngày để làm đẹp cho bản thân.",
                        use = "Sử dụng cọ để tán phấn mắt màu sáng vào giữa bầu mắt như là 1 cách highlight cho mắt để làm mắt to hơn và sáng hơn",
                        img = "/image/sp206.jpg"
                    },
                    new SanPham{
                        product_id = 208,
                        product_type_id = 5,
                        brand_id =5 ,
                        name = "BH Cosmetics Sculpt and Blend 2 – 10 Piece Brush Set",
                        amount = 50,
                        price = 511000 ,
                        description = "là hãng mỹ phẩm trang điểm chuyên nghiệp nổi tiếng trên thế giới với trụ sở chính đặt tại thành phố New York. Thương hiệu này được sáng lập bởi 2 người Canada là Frank Toskan và Frank Angelo. Năm 1991, công ty mở cửa hàng đầu tiên tại New York. Ban đầu thiết kế sản phẩm dành cho các chuyên viên trang điểm chuyên nghiệp, tuy nhiên, hiện nay thương hiệu đã được bán cho tất cả các khách hàng trên toàn thế giới. Mỹ phẩm nổi tiếng về độ bám màu, bảng màu sắc phong phú và đa dạng, lên hình đẹp, phù hợp cho các sàn diễn, diễn viên khi lên sân khấu, bên cạnh đó các sản phẩm của hãng được rất nhiều người phụ nữ dùng hàng ngày để làm đẹp cho bản thân.",
                        use = "Sử dụng cọ để tán phấn mắt màu sáng vào giữa bầu mắt như là 1 cách highlight cho mắt để làm mắt to hơn và sáng hơn",
                        img = "/image/sp207.jpg"
                    },
                    new SanPham{
                        product_id =209 ,
                        product_type_id = 5,
                        brand_id = 51,
                        name = "Lixibox Konjac Sponge",
                        amount = 50,
                        price = 861000 ,
                        description = "là hãng mỹ phẩm trang điểm chuyên nghiệp nổi tiếng trên thế giới với trụ sở chính đặt tại thành phố New York. Thương hiệu này được sáng lập bởi 2 người Canada là Frank Toskan và Frank Angelo. Năm 1991, công ty mở cửa hàng đầu tiên tại New York. Ban đầu thiết kế sản phẩm dành cho các chuyên viên trang điểm chuyên nghiệp, tuy nhiên, hiện nay thương hiệu đã được bán cho tất cả các khách hàng trên toàn thế giới. Mỹ phẩm nổi tiếng về độ bám màu, bảng màu sắc phong phú và đa dạng, lên hình đẹp, phù hợp cho các sàn diễn, diễn viên khi lên sân khấu, bên cạnh đó các sản phẩm của hãng được rất nhiều người phụ nữ dùng hàng ngày để làm đẹp cho bản thân.",
                        use = "Sử dụng cọ để tán phấn mắt màu sáng vào giữa bầu mắt như là 1 cách highlight cho mắt để làm mắt to hơn và sáng hơn",
                        img = "/image/sp208.jpg"
                    },
                    new SanPham{
                        product_id = 210,
                        product_type_id = 5,
                        brand_id =43 ,
                        name = "Bông mút trang điểm The Duo Rain Drop",
                        amount = 50,
                        price = 468000 ,
                        description = "là hãng mỹ phẩm trang điểm chuyên nghiệp nổi tiếng trên thế giới với trụ sở chính đặt tại thành phố New York. Thương hiệu này được sáng lập bởi 2 người Canada là Frank Toskan và Frank Angelo. Năm 1991, công ty mở cửa hàng đầu tiên tại New York. Ban đầu thiết kế sản phẩm dành cho các chuyên viên trang điểm chuyên nghiệp, tuy nhiên, hiện nay thương hiệu đã được bán cho tất cả các khách hàng trên toàn thế giới. Mỹ phẩm nổi tiếng về độ bám màu, bảng màu sắc phong phú và đa dạng, lên hình đẹp, phù hợp cho các sàn diễn, diễn viên khi lên sân khấu, bên cạnh đó các sản phẩm của hãng được rất nhiều người phụ nữ dùng hàng ngày để làm đẹp cho bản thân.",
                        use = "Sử dụng cọ để tán phấn mắt màu sáng vào giữa bầu mắt như là 1 cách highlight cho mắt để làm mắt to hơn và sáng hơn",
                        img = "/image/sp209.jpg"
                    },
                    new SanPham{
                        product_id = 211,
                        product_type_id = 6,
                        brand_id =53 ,
                        name = "Foellie Inner Perfume - Bijou",
                        amount = 50,
                        price = 2227000 ,
                        description = "Một mẫu nước hoa mang mùi hương ngọt và phức tạp là một phần trong bộ sưu tập Intense Collection của  Jo Malone và đã được ra mắt vào năm 2010. Bộ sưu tập này được lấy cảm hứng từ nghi lễ thế tục ở vùng Trung Đông. Bộ sưu tập này là đứa con tinh thần của sự hợp tác giữa Christine Nagel và văn phòng thiết kế của Jo Malone, nhằm tạo ra những chai nước hoa mang hương thơm táo bạo từ những nguyên liệu nước hoa phổ biến.",
                        use = "Hướng dẫn sử dụng: Làm ẩm miếng bọt biển rồi tạo bọt bằng sửa rửa mặt. Dùng miếng bọt biển mát xa trên da mặt theo hình tròn, tránh vùng mắt. Rửa sạch mặt và miếng bọt biển. Chú ý để miếng bọt biển ở nơi khô ráo sau khi sử dụng",
                        img = "/image/sp210.jpg"
                    },
                    new SanPham{
                        product_id = 212,
                        product_type_id = 6,
                        brand_id =54 ,
                        name = "Jo Malone Oud & Bergamot Intense 9ml",
                        amount = 50,
                        price = 1754000 ,
                        description = "Một mẫu nước hoa mang mùi hương ngọt và phức tạp là một phần trong bộ sưu tập Intense Collection của  Jo Malone và đã được ra mắt vào năm 2010. Bộ sưu tập này được lấy cảm hứng từ nghi lễ thế tục ở vùng Trung Đông. Bộ sưu tập này là đứa con tinh thần của sự hợp tác giữa Christine Nagel và văn phòng thiết kế của Jo Malone, nhằm tạo ra những chai nước hoa mang hương thơm táo bạo từ những nguyên liệu nước hoa phổ biến.",
                        use = "Hướng dẫn sử dụng: Làm ẩm miếng bọt biển rồi tạo bọt bằng sửa rửa mặt. Dùng miếng bọt biển mát xa trên da mặt theo hình tròn, tránh vùng mắt. Rửa sạch mặt và miếng bọt biển. Chú ý để miếng bọt biển ở nơi khô ráo sau khi sử dụng",
                        img = "/image/sp211.jpg"
                    },
                    new SanPham{
                        product_id =213 ,
                        product_type_id = 6,
                        brand_id = 54,
                        name = "Jo Malone Dark & Amber & Ginger Lily 9ml",
                        amount = 50,
                        price = 2442000 ,
                        description = "Một mẫu nước hoa mang mùi hương ngọt và phức tạp là một phần trong bộ sưu tập Intense Collection của  Jo Malone và đã được ra mắt vào năm 2010. Bộ sưu tập này được lấy cảm hứng từ nghi lễ thế tục ở vùng Trung Đông. Bộ sưu tập này là đứa con tinh thần của sự hợp tác giữa Christine Nagel và văn phòng thiết kế của Jo Malone, nhằm tạo ra những chai nước hoa mang hương thơm táo bạo từ những nguyên liệu nước hoa phổ biến.",
                        use = "Hướng dẫn sử dụng: Làm ẩm miếng bọt biển rồi tạo bọt bằng sửa rửa mặt. Dùng miếng bọt biển mát xa trên da mặt theo hình tròn, tránh vùng mắt. Rửa sạch mặt và miếng bọt biển. Chú ý để miếng bọt biển ở nơi khô ráo sau khi sử dụng",
                        img = "/image/sp212.jpg"
                    },
                    new SanPham{
                        product_id =214 ,
                        product_type_id = 6,
                        brand_id = 54,
                        name = "Jo Malone Tuberose & Angelica 9ml",
                        amount = 50,
                        price = 1278000 ,
                        description = "Một mẫu nước hoa mang mùi hương ngọt và phức tạp là một phần trong bộ sưu tập Intense Collection của  Jo Malone và đã được ra mắt vào năm 2010. Bộ sưu tập này được lấy cảm hứng từ nghi lễ thế tục ở vùng Trung Đông. Bộ sưu tập này là đứa con tinh thần của sự hợp tác giữa Christine Nagel và văn phòng thiết kế của Jo Malone, nhằm tạo ra những chai nước hoa mang hương thơm táo bạo từ những nguyên liệu nước hoa phổ biến.",
                        use = "Hướng dẫn sử dụng: Làm ẩm miếng bọt biển rồi tạo bọt bằng sửa rửa mặt. Dùng miếng bọt biển mát xa trên da mặt theo hình tròn, tránh vùng mắt. Rửa sạch mặt và miếng bọt biển. Chú ý để miếng bọt biển ở nơi khô ráo sau khi sử dụng",
                        img = "/image/sp213.jpg"
                    },
                    new SanPham{
                        product_id =215 ,
                        product_type_id = 6,
                        brand_id = 54,
                        name = "Jo Malone London Cologne Intense - Myrrh & Tonka 9ml",
                        amount = 50,
                        price = 1422000 ,
                        description = "Một mẫu nước hoa mang mùi hương ngọt và phức tạp là một phần trong bộ sưu tập Intense Collection của  Jo Malone và đã được ra mắt vào năm 2010. Bộ sưu tập này được lấy cảm hứng từ nghi lễ thế tục ở vùng Trung Đông. Bộ sưu tập này là đứa con tinh thần của sự hợp tác giữa Christine Nagel và văn phòng thiết kế của Jo Malone, nhằm tạo ra những chai nước hoa mang hương thơm táo bạo từ những nguyên liệu nước hoa phổ biến.",
                        use = "Hướng dẫn sử dụng: Làm ẩm miếng bọt biển rồi tạo bọt bằng sửa rửa mặt. Dùng miếng bọt biển mát xa trên da mặt theo hình tròn, tránh vùng mắt. Rửa sạch mặt và miếng bọt biển. Chú ý để miếng bọt biển ở nơi khô ráo sau khi sử dụng",
                        img = "/image/sp214.jpg"
                    },
                    new SanPham{
                        product_id = 216,
                        product_type_id = 6,
                        brand_id = 55,
                        name = "Diptyque L'Ombre dans l'Eau Set",
                        amount = 50,
                        price = 5222000,
                        description = "Một mẫu nước hoa mang mùi hương ngọt và phức tạp là một phần trong bộ sưu tập Intense Collection của  Jo Malone và đã được ra mắt vào năm 2010. Bộ sưu tập này được lấy cảm hứng từ nghi lễ thế tục ở vùng Trung Đông. Bộ sưu tập này là đứa con tinh thần của sự hợp tác giữa Christine Nagel và văn phòng thiết kế của Jo Malone, nhằm tạo ra những chai nước hoa mang hương thơm táo bạo từ những nguyên liệu nước hoa phổ biến.",
                        use = "Hướng dẫn sử dụng: Làm ẩm miếng bọt biển rồi tạo bọt bằng sửa rửa mặt. Dùng miếng bọt biển mát xa trên da mặt theo hình tròn, tránh vùng mắt. Rửa sạch mặt và miếng bọt biển. Chú ý để miếng bọt biển ở nơi khô ráo sau khi sử dụng",
                        img = "/image/sp215.jpg"
                    },
                    new SanPham{
                        product_id = 217,
                        product_type_id = 6,
                        brand_id = 54,
                        name = "Jo Malone London Velvet Rose & Oud Cologne Intense",
                        amount = 50,
                        price = 522000 ,
                        description = "Một mẫu nước hoa mang mùi hương ngọt và phức tạp là một phần trong bộ sưu tập Intense Collection của  Jo Malone và đã được ra mắt vào năm 2010. Bộ sưu tập này được lấy cảm hứng từ nghi lễ thế tục ở vùng Trung Đông. Bộ sưu tập này là đứa con tinh thần của sự hợp tác giữa Christine Nagel và văn phòng thiết kế của Jo Malone, nhằm tạo ra những chai nước hoa mang hương thơm táo bạo từ những nguyên liệu nước hoa phổ biến.",
                        use = "Hướng dẫn sử dụng: Làm ẩm miếng bọt biển rồi tạo bọt bằng sửa rửa mặt. Dùng miếng bọt biển mát xa trên da mặt theo hình tròn, tránh vùng mắt. Rửa sạch mặt và miếng bọt biển. Chú ý để miếng bọt biển ở nơi khô ráo sau khi sử dụng",
                        img = "/image/sp216.jpg"
                    },
                    new SanPham{
                        product_id =218 ,
                        product_type_id = 6,
                        brand_id = 57,
                        name = "LE LABO FLEUR D'ORANGER 27 eau de parfum - 50ml",
                        amount = 50,
                        price = 2652000 ,
                        description = "Một mẫu nước hoa mang mùi hương ngọt và phức tạp là một phần trong bộ sưu tập Intense Collection của  Jo Malone và đã được ra mắt vào năm 2010. Bộ sưu tập này được lấy cảm hứng từ nghi lễ thế tục ở vùng Trung Đông. Bộ sưu tập này là đứa con tinh thần của sự hợp tác giữa Christine Nagel và văn phòng thiết kế của Jo Malone, nhằm tạo ra những chai nước hoa mang hương thơm táo bạo từ những nguyên liệu nước hoa phổ biến.",
                        use = "Hướng dẫn sử dụng: Làm ẩm miếng bọt biển rồi tạo bọt bằng sửa rửa mặt. Dùng miếng bọt biển mát xa trên da mặt theo hình tròn, tránh vùng mắt. Rửa sạch mặt và miếng bọt biển. Chú ý để miếng bọt biển ở nơi khô ráo sau khi sử dụng",
                        img = "/image/sp217.jpg"
                    },
                    new SanPham{
                        product_id =219 ,
                        product_type_id = 6,
                        brand_id = 57,
                        name = "LE LABO AMBRETTE 9 eau de parfum - 50ml",
                        amount = 50,
                        price = 532000 ,
                        description = "Một mẫu nước hoa mang mùi hương ngọt và phức tạp là một phần trong bộ sưu tập Intense Collection của  Jo Malone và đã được ra mắt vào năm 2010. Bộ sưu tập này được lấy cảm hứng từ nghi lễ thế tục ở vùng Trung Đông. Bộ sưu tập này là đứa con tinh thần của sự hợp tác giữa Christine Nagel và văn phòng thiết kế của Jo Malone, nhằm tạo ra những chai nước hoa mang hương thơm táo bạo từ những nguyên liệu nước hoa phổ biến.",
                        use = "Hướng dẫn sử dụng: Làm ẩm miếng bọt biển rồi tạo bọt bằng sửa rửa mặt. Dùng miếng bọt biển mát xa trên da mặt theo hình tròn, tránh vùng mắt. Rửa sạch mặt và miếng bọt biển. Chú ý để miếng bọt biển ở nơi khô ráo sau khi sử dụng",
                        img = "/image/sp218.jpg"
                    },
                    new SanPham{
                        product_id =220 ,
                        product_type_id = 6,
                        brand_id =55 ,
                        name = "DIPTYQUE Eau Duelle Eau de Parfum - 75ml",
                        amount = 50,
                        price = 1667000 ,
                        description = "Một mẫu nước hoa mang mùi hương ngọt và phức tạp là một phần trong bộ sưu tập Intense Collection của  Jo Malone và đã được ra mắt vào năm 2010. Bộ sưu tập này được lấy cảm hứng từ nghi lễ thế tục ở vùng Trung Đông. Bộ sưu tập này là đứa con tinh thần của sự hợp tác giữa Christine Nagel và văn phòng thiết kế của Jo Malone, nhằm tạo ra những chai nước hoa mang hương thơm táo bạo từ những nguyên liệu nước hoa phổ biến.",
                        use = "Hướng dẫn sử dụng: Làm ẩm miếng bọt biển rồi tạo bọt bằng sửa rửa mặt. Dùng miếng bọt biển mát xa trên da mặt theo hình tròn, tránh vùng mắt. Rửa sạch mặt và miếng bọt biển. Chú ý để miếng bọt biển ở nơi khô ráo sau khi sử dụng",
                        img = "/image/sp219.jpg"
                    },
                    new SanPham{
                        product_id =221 ,
                        product_type_id = 6,
                        brand_id =55 ,
                        name = "DIPTYQUE Fleur de Peau Eau de parfum - 75ml",
                        amount = 50,
                        price =5221000 ,
                        description = "Một mẫu nước hoa mang mùi hương ngọt và phức tạp là một phần trong bộ sưu tập Intense Collection của  Jo Malone và đã được ra mắt vào năm 2010. Bộ sưu tập này được lấy cảm hứng từ nghi lễ thế tục ở vùng Trung Đông. Bộ sưu tập này là đứa con tinh thần của sự hợp tác giữa Christine Nagel và văn phòng thiết kế của Jo Malone, nhằm tạo ra những chai nước hoa mang hương thơm táo bạo từ những nguyên liệu nước hoa phổ biến.",
                        use = "Hướng dẫn sử dụng: Làm ẩm miếng bọt biển rồi tạo bọt bằng sửa rửa mặt. Dùng miếng bọt biển mát xa trên da mặt theo hình tròn, tránh vùng mắt. Rửa sạch mặt và miếng bọt biển. Chú ý để miếng bọt biển ở nơi khô ráo sau khi sử dụng",
                        img = "/image/sp220.jpg"
                    },
                    new SanPham{
                        product_id = 222,
                        product_type_id = 6,
                        brand_id = 55,
                        name = "DIPTYQUE Volutes Eau de Parfum - 75ml",
                        amount = 50,
                        price = 1422000 ,
                        description = "Một mẫu nước hoa mang mùi hương ngọt và phức tạp là một phần trong bộ sưu tập Intense Collection của  Jo Malone và đã được ra mắt vào năm 2010. Bộ sưu tập này được lấy cảm hứng từ nghi lễ thế tục ở vùng Trung Đông. Bộ sưu tập này là đứa con tinh thần của sự hợp tác giữa Christine Nagel và văn phòng thiết kế của Jo Malone, nhằm tạo ra những chai nước hoa mang hương thơm táo bạo từ những nguyên liệu nước hoa phổ biến.",
                        use = "Hướng dẫn sử dụng: Làm ẩm miếng bọt biển rồi tạo bọt bằng sửa rửa mặt. Dùng miếng bọt biển mát xa trên da mặt theo hình tròn, tránh vùng mắt. Rửa sạch mặt và miếng bọt biển. Chú ý để miếng bọt biển ở nơi khô ráo sau khi sử dụng",
                        img = "/image/sp221.jpg"
                    },
                    new SanPham{
                        product_id =223 ,
                        product_type_id = 6,
                        brand_id = 55,
                        name = "DIPTYQUE Philosykos Eau de Parfum - 75ml",
                        amount = 50,
                        price = 2342000 ,
                        description = "Một mẫu nước hoa mang mùi hương ngọt và phức tạp là một phần trong bộ sưu tập Intense Collection của  Jo Malone và đã được ra mắt vào năm 2010. Bộ sưu tập này được lấy cảm hứng từ nghi lễ thế tục ở vùng Trung Đông. Bộ sưu tập này là đứa con tinh thần của sự hợp tác giữa Christine Nagel và văn phòng thiết kế của Jo Malone, nhằm tạo ra những chai nước hoa mang hương thơm táo bạo từ những nguyên liệu nước hoa phổ biến.",
                        use = "Hướng dẫn sử dụng: Làm ẩm miếng bọt biển rồi tạo bọt bằng sửa rửa mặt. Dùng miếng bọt biển mát xa trên da mặt theo hình tròn, tránh vùng mắt. Rửa sạch mặt và miếng bọt biển. Chú ý để miếng bọt biển ở nơi khô ráo sau khi sử dụng",
                        img = "/image/sp222.jpg"
                    },
                    new SanPham{
                        product_id =224 ,
                        product_type_id = 6,
                        brand_id =55 ,
                        name = "DIPTYQUE L'Ombre Dans L'Eau Eau de Parfum - 75ml",
                        amount = 50,
                        price = 4227000 ,
                        description = "Một mẫu nước hoa mang mùi hương ngọt và phức tạp là một phần trong bộ sưu tập Intense Collection của  Jo Malone và đã được ra mắt vào năm 2010. Bộ sưu tập này được lấy cảm hứng từ nghi lễ thế tục ở vùng Trung Đông. Bộ sưu tập này là đứa con tinh thần của sự hợp tác giữa Christine Nagel và văn phòng thiết kế của Jo Malone, nhằm tạo ra những chai nước hoa mang hương thơm táo bạo từ những nguyên liệu nước hoa phổ biến.",
                        use = "Hướng dẫn sử dụng: Làm ẩm miếng bọt biển rồi tạo bọt bằng sửa rửa mặt. Dùng miếng bọt biển mát xa trên da mặt theo hình tròn, tránh vùng mắt. Rửa sạch mặt và miếng bọt biển. Chú ý để miếng bọt biển ở nơi khô ráo sau khi sử dụng",
                        img = "/image/sp223.jpg"
                    },
                    new SanPham{
                        product_id = 225,
                        product_type_id = 6,
                        brand_id = 55,
                        name = "Diptyque Eau Duelle Eau de Toilette - 50 ml",
                        amount = 50,
                        price = 2242000 ,
                        description = "Một mẫu nước hoa mang mùi hương ngọt và phức tạp là một phần trong bộ sưu tập Intense Collection của  Jo Malone và đã được ra mắt vào năm 2010. Bộ sưu tập này được lấy cảm hứng từ nghi lễ thế tục ở vùng Trung Đông. Bộ sưu tập này là đứa con tinh thần của sự hợp tác giữa Christine Nagel và văn phòng thiết kế của Jo Malone, nhằm tạo ra những chai nước hoa mang hương thơm táo bạo từ những nguyên liệu nước hoa phổ biến.",
                        use = "Hướng dẫn sử dụng: Làm ẩm miếng bọt biển rồi tạo bọt bằng sửa rửa mặt. Dùng miếng bọt biển mát xa trên da mặt theo hình tròn, tránh vùng mắt. Rửa sạch mặt và miếng bọt biển. Chú ý để miếng bọt biển ở nơi khô ráo sau khi sử dụng",
                        img = "/image/sp224.jpg"
                    },
                    new SanPham{
                        product_id = 226,
                        product_type_id = 6,
                        brand_id = 56,
                        name = "ATELIER COLOGNE Iris Rebelle Cologne Absolue Pure Perfume - 10 ml",
                        amount = 50,
                        price =1225000 ,
                        description = "Một mẫu nước hoa mang mùi hương ngọt và phức tạp là một phần trong bộ sưu tập Intense Collection của  Jo Malone và đã được ra mắt vào năm 2010. Bộ sưu tập này được lấy cảm hứng từ nghi lễ thế tục ở vùng Trung Đông. Bộ sưu tập này là đứa con tinh thần của sự hợp tác giữa Christine Nagel và văn phòng thiết kế của Jo Malone, nhằm tạo ra những chai nước hoa mang hương thơm táo bạo từ những nguyên liệu nước hoa phổ biến.",
                        use = "Hướng dẫn sử dụng: Làm ẩm miếng bọt biển rồi tạo bọt bằng sửa rửa mặt. Dùng miếng bọt biển mát xa trên da mặt theo hình tròn, tránh vùng mắt. Rửa sạch mặt và miếng bọt biển. Chú ý để miếng bọt biển ở nơi khô ráo sau khi sử dụng",
                        img = "/image/sp225.jpg"
                    },
                    new SanPham{
                        product_id =227 ,
                        product_type_id = 6,
                        brand_id = 54,
                        name = "Jo Malone Lime Basil & Mandarin Cologne 30ml",
                        amount = 50,
                        price =3266000 ,
                        description = "Một mẫu nước hoa mang mùi hương ngọt và phức tạp là một phần trong bộ sưu tập Intense Collection của  Jo Malone và đã được ra mắt vào năm 2010. Bộ sưu tập này được lấy cảm hứng từ nghi lễ thế tục ở vùng Trung Đông. Bộ sưu tập này là đứa con tinh thần của sự hợp tác giữa Christine Nagel và văn phòng thiết kế của Jo Malone, nhằm tạo ra những chai nước hoa mang hương thơm táo bạo từ những nguyên liệu nước hoa phổ biến.",
                        use = "Hướng dẫn sử dụng: Làm ẩm miếng bọt biển rồi tạo bọt bằng sửa rửa mặt. Dùng miếng bọt biển mát xa trên da mặt theo hình tròn, tránh vùng mắt. Rửa sạch mặt và miếng bọt biển. Chú ý để miếng bọt biển ở nơi khô ráo sau khi sử dụng",
                        img = "/image/sp226.jpg"
                    }
                });
            }

            if(!context.ThuongHieus.Any()){
                temp = true;
                context.ThuongHieus.AddRange(new List<ThuongHieu>{
                    new ThuongHieu{
                        brand_id = 1,
                        name = "LUSTRE MAKEUP"
                    },
                    new ThuongHieu{
                        brand_id = 2,
                        name = "Golden Rose"
                    },
                    new ThuongHieu{
                        brand_id = 3,
                        name = "SmashBox"
                    },
                    new ThuongHieu{
                        brand_id = 4,
                        name = "Medium"
                    },
                    new ThuongHieu{
                        brand_id = 5,
                        name = "BH Cosmetics"
                    },
                    new ThuongHieu{
                        brand_id = 6,
                        name = "M.A.C Cosmetics"
                    },
                    new ThuongHieu{
                        brand_id = 7,
                        name = "Missha"
                    },
                    new ThuongHieu{
                        brand_id = 8,
                        name = "Innisfree"
                    },
                    new ThuongHieu{
                        brand_id = 9,
                        name = "Sisley Paris"
                    },
                    new ThuongHieu{
                        brand_id = 10,
                        name = "ARCANCIL PARIS"
                    },
                    new ThuongHieu{
                        brand_id = 11,
                        name = "Buxom Cosmetics"
                    },
                    new ThuongHieu{
                        brand_id = 12,
                        name = "Isehan"
                    },
                    new ThuongHieu{
                        brand_id = 13,
                        name = "MacQueen"
                    },
                    new ThuongHieu{
                        brand_id = 14,
                        name = "Eclipse Colours"
                    },
                    new ThuongHieu{
                        brand_id = 15,
                        name = "PETITE LAEL"
                    },
                    new ThuongHieu{
                        brand_id = 16,
                        name = "THE BROWGAL"
                    },
                    new ThuongHieu{
                        brand_id = 17,
                        name = "Dolly Wink"
                    },
                    new ThuongHieu{
                        brand_id = 18,
                        name = "Muji"
                    },
                    new ThuongHieu{
                        brand_id = 19,
                        name = "United States"
                    },
                    new ThuongHieu{
                        brand_id = 20,
                        name = "Milk"
                    },
                    new ThuongHieu{
                        brand_id = 21,
                        name = "Laneige"
                    },
                    new ThuongHieu{
                        brand_id = 22,
                        name = "Guerlain"
                    },
                    new ThuongHieu{
                        brand_id = 23,
                        name = "Elizabeth Arden"
                    },
                    new ThuongHieu{
                        brand_id = 24,
                        name = "L’oreal"
                    },
                    new ThuongHieu{
                        brand_id = 25,
                        name = "Eglips"
                    },
                    new ThuongHieu{
                        brand_id = 26,
                        name = "SILKYGIRL"
                    },
                    new ThuongHieu{
                        brand_id = 27,
                        name = "STATISFY"
                    },
                    new ThuongHieu{
                        brand_id = 28,
                        name = "Aritaum"
                    },
                    new ThuongHieu{
                        brand_id = 29,
                        name = "3CE"
                    },
                    new ThuongHieu{
                        brand_id = 30,
                        name = "Kaleido Cosmetics"
                    },
                    new ThuongHieu{
                        brand_id = 31,
                        name = "Stila Cosmetics"
                    },
                    new ThuongHieu{
                        brand_id = 32,
                        name = "Cover Fx"
                    },
                    new ThuongHieu{
                        brand_id = 33,
                        name = "Anastasia Beverly Hills"
                    },
                    new ThuongHieu{
                        brand_id = 34,
                        name = "Dior"
                    },
                    new ThuongHieu{
                        brand_id = 35,
                        name = "E.L.F"
                    },
                    new ThuongHieu{
                        brand_id = 36,
                        name = "Yves Saint Laurent"
                    },
                    new ThuongHieu{
                        brand_id = 37,
                        name = "Nars"
                    },
                    new ThuongHieu{
                        brand_id = 38,
                        name = "Lime Crime"
                    },
                    new ThuongHieu{
                        brand_id = 39,
                        name = "Tarte"
                    },
                    new ThuongHieu{
                        brand_id = 40,
                        name = "Byphasse"
                    },
                    new ThuongHieu{
                        brand_id = 41,
                        name = "Clinique"
                    },
                    new ThuongHieu{
                        brand_id = 42,
                        name = "Bioderma"
                    },
                    new ThuongHieu{
                        brand_id = 43,
                        name = "DHC"
                    },
                    new ThuongHieu{
                        brand_id = 44,
                        name = "Mad Hippie"
                    },
                    new ThuongHieu{
                        brand_id = 45,
                        name = "Huxley"
                    },
                    new ThuongHieu{
                        brand_id = 46,
                        name = "Simple"
                    },
                    new ThuongHieu{
                        brand_id = 47,
                        name = "Dinky Touch"
                    },
                    new ThuongHieu{
                        brand_id = 48,
                        name = "Shiro Waki Hime"
                    },
                    new ThuongHieu{
                        brand_id = 49,
                        name = "Pixi"
                    },
                    new ThuongHieu{
                        brand_id = 50,
                        name = "Naruko"
                    },
                    new ThuongHieu{
                        brand_id = 51,
                        name = "LIXIBOX"
                    },
                    new ThuongHieu{
                        brand_id = 52,
                        name = "UK"
                    },
                    new ThuongHieu{
                        brand_id = 53,
                        name = "Foellie"
                    },
                    new ThuongHieu{
                        brand_id = 54,
                        name = "Jo Malone London"
                    },
                    new ThuongHieu{
                        brand_id = 55,
                        name = "Diptyque"
                    },
                    new ThuongHieu{
                        brand_id = 56,
                        name = "Atelier Cologne"
                    },
                    new ThuongHieu{
                        brand_id = 57,
                        name = "LE LABON"
                    }
                });
            }

            // if(!context.ThuongHieuAndSanPhams.Any()){
            //     temp = true;
            //     context.ThuongHieuAndSanPhams.AddRange(new List<ThuongHieuAndSanPham>{
            //         new ThuongHieuAndSanPham{
            //             brand_id = 1,
            //             product_id = 1
            //         }
            //     });
            // }

            if(temp){
                context.SaveChanges();
            }

        }
    }
}