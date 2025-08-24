create database DongPhim
use DongPhim
Go
-- cau 1-1,2
create table DaoDien(
MaDD nvarchar(30) primary key,
TenDD nvarchar(50),
Email nvarchar(50),
Tel nvarchar(20),
GhiChu nvarchar(150)
)
insert into DaoDien values('dd1','Tahng Kuuu Man','mammm@gmail.com','856864','chuuuuu')
insert into DaoDien values(N'dd2',N'Tahng HAnn',N'matahh@gmail.com',N'23464',N'cdhuuuuu')
create table Phim(
MaPhim nvarchar(50) primary key,
TenPhim nvarchar(150),
KinhPhi numeric(18,0),
NoiDung nvarchar(150),
NgayBamMay datetime,
NgayKetThuc datetime,
MaDD nvarchar(30) foreign key (MaDD) references DaoDien(MaDD)
)
insert into Phim values(N'phimm1',N'Than Dieu',18000,N'cau truyen ve ong than bip','05/02/2000','05/02/2002',N'dd2',21000)
create table DienVien(
MaDV nvarchar(30) primary key,
TenDD nvarchar(50),
Email nvarchar(50),
Tel nvarchar(20),
TongThuLao numeric(18,0),
GhiChu nvarchar(150)
)
insert into DienVien values(N'dv1',N'Bùi Anh Tuấn',N'batuan@gmail.com',N'9676234',18000,N'Ghi')
create table DienPhim(
ID int primary key,
NgayDien datetime,
NgayKetThuc datetime,
MaDV nvarchar(30) foreign key (MaDV) references DienVien(MaDV),
MaPhim nvarchar(50) foreign key (MaPhim) references Phim(MaPhim),
ThuLao numeric(18,0),
GhiChu nvarchar(150)
)
-- cau 2-1
go
create view vw_HaAnhTuan
as
select MaPhim,TenPhim,KinhPhi,NoiDung from Phim 
 inner join DaoDien on Phim.MaDD=DaoDien.MaDD
 where TenDD='Hà Anh Tuấn'
 go
 --cau 3-1
 create trigger CapNhat
 on DienPhim for insert,update,delete
 as
 begin
 update DienVien
 set TongThuLao=TongThuLao+1
 from DienVien inner join inserted on DienVien.MaDV=inserted.MaDV
 update DienVien
 set TongThuLao=TongThuLao-1
 from DienVien inner join deleted on DienVien.MaDV=deleted.MaDV
 end
 -- cau 2-2
 go
 create view vw_nam
as
select MaPhim,TenPhim,KinhPhi,NoiDung from Phim 
 where NgayBamMay=YEAR(2019)
 go
 --cau 3-2
 alter table Phim
 add TongTienChiDaoDien numeric(18,0)
 go
 create trigger CapNhat2
 on DienPhim for insert,update,delete
 as
 begin
 update Phim
 set TongTienChiDaoDien=TongTienChiDaoDien+1
 from Phim inner join inserted on Phim.MaPhim=inserted.MaDV
 update Phim
 set TongTienChiDaoDien=TongTienChiDaoDien-1
 from Phim inner join deleted on Phim.MaPhim=deleted.MaDV
 end
 go
 -- cau 1-3
 create table ToCongNhan(
 MaTo nvarchar(20) primary key,
 TenTo nvarchar(50),
 SoCN int
 )
 insert into ToCongNhan values(N'to1',N'To mot','50')
 go
 create table CongNhan(
 MaCN nvarchar(50) primary key,
 TenCN nvarchar(50),
 NgaySinh datetime,
 NgayVao datetime,
 MaTo nvarchar(20) foreign key (MaTo) references ToCongNhan(MaTo),
 TongTienCong numeric(18,0)
 )
 insert into CongNhan values(N'cn011',N'Nguyễn Văn Tý','05/02/2000','12/03/2021',N'to1',18000)
 create table SanPham(
 MaSP nvarchar(50) primary key,
 TenSP nvarchar(50),
 DonGia numeric(18,0),
 MaTo nvarchar(20) foreign key (MaTo) references ToCongNhan(MaTo),
 TongSoSP int
 )
 insert into SanPham values(N'sp23',N'Chưn chhua',60000,N'to1','90')
  create table ChamCong(
 ID int primary key,
 Ngay datetime,
 MaCN nvarchar(50) foreign key (MaCN) references CongNhan(MaCN),
 MaSP nvarchar(50) foreign key (MaSP) references SanPham(MaSP),
 SoSP int
 )
 insert into ChamCong values('1','12/04/2018',N'cn011',N'sp23','90')
 go
 --cau 2-3
create view vw_dsCN
as
select MaCN,TenCN,NgaySinh,TenTo,TongTienCong from ToCongNhan inner join CongNhan on ToCongNhan.MaTo=CongNhan.MaTo 
 where TongTienCong>'10000000'
 go
 --cau 3-3
 create trigger CapNhat3
 on ChamCong for insert,update,delete
 as
 begin
 update SanPham
 set TongSoSP=TongSoSP+1
 from SanPham inner join inserted on SanPham.MaSP=inserted.MaSP
 update SanPham
 set TongSoSP=TongSoSP-1
 from SanPham inner join deleted on SanPham.MaSP=deleted.MaSP
 end
 go
--cau 2-6--De Loi
--cau 3-6
create trigger CapNhat6
 on CongNhan for insert,update,delete
 as
 begin
 update ToCongNhan
 set SoCN=SoCN+1
 from ToCongNhan inner join inserted on ToCongNhan.MaTo=inserted.MaTo
 update ToCongNhan
 set SoCN=SoCN-1
 from ToCongNhan inner join deleted on ToCongNhan.MaTo=deleted.MaTo
 end
 go
 -- cau 1-4
 create table KhoaHoc(
 MaKH nvarchar(25) primary key,
 TenKH nvarchar(200),
 SoBuoi int,
 HocPhi numeric(18,0)
 )
insert into KhoaHoc values(N'kh1',N'Học linh tinh','45','100000')
create table GiaoVien(
MaGV nvarchar(20) primary key,
TenGV nvarchar(50),
DiaChi nvarchar(100)
)
insert into GiaoVien values(N'gv1',N'Nguyễn Thanh An',N'Khoa CNTT')
create table LopHoc(
MaLop nvarchar(30) primary key,
TenLop nvarchar(100),
MaKH nvarchar(25) foreign key (MaKH) references KhoaHoc(MaKH),
MaGV nvarchar(20) foreign key (MaGV) references GiaoVien(MaGV),
TuNgay datetime,
DenNgay datetime
)
insert into LopHoc values(N'lh1',N'Lớp ngáo',N'kh1',N'gv1','02/12/2022','03/04/2022')
insert into LopHoc values(N'lh2',N'Lớp ngáo 2',N'kh1',N'gv1','02/12/2022','03/04/2022')
create table HocVien(
MaHV nvarchar(25) primary key,
TenHV nvarchar(50),
NgaySinh datetime,
tel varchar(50),
MaLop nvarchar(30) foreign key (MaLop) references LopHoc(MaLop),
NgayVao datetime
)
insert into HocVien values (N'hv1',N'Phạm Văn Anh','03/04/2022','62936592',N'lh1','02/12/2022')
--de 4 cau2--
--de 4 cau3
alter table LopHoc
add SoHV int
insert into LopHoc values(N'lh3',N'Lớp ngáo 3',N'kh1',N'gv1','02/12/2022','03/04/2022','2')
go
create trigger capnhat4
on HocVien for insert, update, delete
as
begin
update LopHoc
set SoHV= SoHV+1
from LopHoc inner join inserted on LopHoc.MaLop=inserted.MaLop
update LopHoc
set SoHV= SoHV-1
from LopHoc inner join deleted on LopHoc.MaLop=deleted.MaLop
end
go
insert into LopHoc values(N'lh4',N'Lớp ngáo 4',N'kh1',N'gv1','02/12/2022','03/04/2022','2')
select * from LopHoc

insert into HocVien values (N'hv2',N'Phạm Văn Bình','03/04/2022','62936592',N'lh1','02/12/2022')
insert into HocVien values (N'hv3',N'Phạm Văn Hoa','03/04/2022','62936592',N'lh3','02/12/2022')
--cau 2 de8
go
create view view_LopHoc
as
select MaLop,TenLop,MaKH,TuNgay,DenNgay from LopHoc lh 
inner join GiaoVien gv on lh.MaGV=gv.MaGV 
where DiaChi=N'Khoa CNTT'
go
select * from view_LopHoc
-- cau3 de8-- same đề 4
