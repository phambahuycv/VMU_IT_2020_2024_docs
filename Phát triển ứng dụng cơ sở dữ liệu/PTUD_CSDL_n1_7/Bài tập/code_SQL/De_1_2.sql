create database De_1_2
use De_1_2


create table LoaiGiay(
MaLoai char(5) primary key,
TenLoai nvarchar(20),
GhiChu nvarchar(50)
)

create table Giay(
MaGiay char(5) primary key,
TenGiay nvarchar(20),
MaLoai char(5) foreign key (MaLoai) references LoaiGiay(MaLoai),
NuocSX nvarchar(20),
ThongSoKT nvarchar(50),
GiaThanh float
)


create table DaiLy(
MaDL char(5) primary key,
TenDL nvarchar(20),
SDT int,
DiaChi nvarchar(50),
Email nvarchar(30),
TruongDL nvarchar(20)
)

create table PhieuNhap(
MaPhieu char(5) primary key,
MaDL char(5) foreign key (MaDL) references DaiLy(MaDL),
NgayNhap datetime,
DatCoc float,
GhiChu nvarchar(50)
)
create table CTPN(
ID char(5) primary key,
MaPhieu char(5) foreign key (MaPhieu) references PhieuNhap(MaPhieu),
MaGiay char(5) foreign key (MaGiay) references Giay(MaGiay),
SoLuong int,
DonGia float,
ThanhTien float
)

insert into LoaiGiay values('gd123',N'Giày da','real')
insert into LoaiGiay values('gv123',N'Giày vải','real')
insert into LoaiGiay values('gn123',N'Giày nhựa','real')
insert into LoaiGiay values('gg123',N'Giày gỗ','real')



insert into Giay values('g0010',N'Giày da con heo','gd123',N'Hà Lan','s40','1000000')
insert into Giay values('g0011',N'Giày vải thiều','gv123',N'Đức','s39','200000')
go
--cau 2
create view Vieww_dl
as
select TenDL,SDT,DiaChi,Email from DaiLy dl join PhieuNhap pn on dl.MaDL=pn.MaDL 
 join CTPN ct on pn.MaPhieu=ct.MaPhieu
where ct.SoLuong=(select max(SoLuong) from CTPN)
go
-- cau 3
alter table PhieuNhap
add TongTien float

Go
create trigger capnhat
on CTPN for insert,update,delete
as
Begin
Update PhieuNhap
set TongTien = TongTien+1
from PhieuNhap inner join inserted on PhieuNhap.MaPhieu=inserted.MaPhieu
Update PhieuNhap
set TongTien = TongTien-1
from PhieuNhap inner join inserted on PhieuNhap.MaPhieu=inserted.MaPhieu
end
go