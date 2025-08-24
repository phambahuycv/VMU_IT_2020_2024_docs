create database QLDA86247
use QLDA86247
create table NhanVien (
MaNV nvarchar(5) primary key,
TenNV nvarchar(50),
TongTienCong int
)


create table KhachHang (
MaKH nvarchar(5) primary key,
TenKH nvarchar(50),
DiaChi nvarchar(100)
)


create table DuAn (
MaDA nvarchar(5) primary key,
TenDA nvarchar(50),
DiaChi nvarchar(50),
MaKH nvarchar(5) foreign key (MaKH) references KhachHang(MaKH)
)


create table ThamGia(
ID nvarchar(5) primary key,
MaNV nvarchar(5) foreign key (MaNV) references NhanVien(MaNV),
MaDA nvarchar(5) foreign key (MaDA) references DuAn(MaDA),
TienCong int,
GhiChu nvarchar(50)
)

insert into KhachHang values (N'KH01',N'Đặng Thúy An',N'Hải Phòng')

insert into DuAn values(N'DA06',N'Nhà Cái Đến Từ Châu Âu',N'Hải Phòng',N'KH01')
-- cau 2
GO
create view viewDuAnTheoDiaChi
as
	select DuAn.MaDA, DuAn.TenDA, DuAn.DiaChi as N'Địa chỉ dự án', KhachHang.DiaChi as N'Địa chỉ khách hàng', KhachHang.TenKH from DuAn 
	inner join KhachHang on DuAn.MaKH = KhachHang.MaKH 
	where KhachHang.DiaChi like N'%Hải Phòng%'
GO
select * from viewDuAnTheoDiaChi
GO

-- cau 3
create trigger capnhat
on ThamGia for insert,update,delete
as
begin
update NhanVien
set TongTienCong=TongTienCong+1
from NhanVien inner join inserted on NhanVien.MaNV=inserted.MaNV
update NhanVien
set TongTienCong=TongTienCong-1
from NhanVien inner join deleted on NhanVien.MaNV=deleted.MaNV
end