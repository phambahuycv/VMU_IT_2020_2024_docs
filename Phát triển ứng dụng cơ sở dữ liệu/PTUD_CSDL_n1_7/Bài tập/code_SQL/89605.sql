create database [89605]
use [89605]
create table NhanVien(
MaNV varchar(20) primary key, 
TenNV Nvarchar(50), 
GioiTinh nvarchar(5), 
NgaySinh datetime, 
SDT int, 
DiaChi Nvarchar(50)
)

insert into NhanVien values('NV01', N'Nguyên Văn An', N'Nam', '02/10/2002', 098764532, N'Hải Phòng')
insert into NhanVien values('NV02', N'Nguyễn Thị Anh', N'Nữ', '02/01/2002', 098764521, N'Hà Nội')





create table KhachHang(
MaKhach varchar(20)  primary key, 
Tenkhach Nvarchar(50), 
GhiChu Nvarchar(50), 
)

create table MonAn(
MaMon varchar(20) primary key, 
TenMon Nvarchar(50), 
GhiChu nvarchar(50)
)


Create table DonHang(
SoDonHang VARCHAR(20) primary key, 
Ngay date, 
MaKhach VARCHAR(20) foreign key(MaKhach) references KhachHang(MaKhach), 
MaNV VARCHAR(20) foreign key(MaNV) references NhanVien(MaNV) , 
GhiChu nvarchar(50), 
)


create table CTDH(
ID int primary key, 
SoDonHang varchar(20) foreign key(SoDonHang) references DonHang(SoDonHang), 
MaMon VARCHAR(20) FOREIGN KEY(MaMon) REFERENCES MonAn(MaMon),
DonGia float, 
ThanhTien float
)
-- cau 2
Go
create function tinhtong(@ma char(5))
returns table
as
return(
select ThanhTien from CTDH inner join DonHang on CTDH.SoDonHang=DonHang.SoDonHang
	inner join KhachHang on DonHang.MaKhach=KhachHang.MaKhach
	where KhachHang.MaKhach=@ma
	)
Go
insert into KhachHang values('kh123',N'Tran aa',N'Khong co gi')
insert into DonHang values('002','01-01-2022','kh123','NV02',N'Khong co gi')
insert into MonAn values('ma01',N'Ga Quay','20000')
insert into CTDH values('1','002','ma01','20000','20000')
select * from tinhtong('kh123')
Go
-- cau 3
alter table DonHang
add SoTienDH float
Go
create trigger capnhat
on CTDH for update,insert,delete
as
Begin
update DonHang
Set SoTienDH =SoTienDH+1
from DonHang inner join inserted on DonHang.SoDonHang= inserted.SoDonHang
update DonHang
Set SoTienDH =SoTienDH-1
from DonHang inner join inserted on DonHang.SoDonHang= inserted.SoDonHang
end

go