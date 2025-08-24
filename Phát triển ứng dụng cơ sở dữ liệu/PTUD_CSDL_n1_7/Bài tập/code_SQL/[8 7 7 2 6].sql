create database [8 7 7 2 6]
use [8 7 7 2 6]
create table Lop(
MaLop int primary key,
TenLop nvarchar(50)
)
create table SinhVien(
MaSV int primary key,
TenSV nvarchar(50),
GioiTinh nvarchar(5),
NgaySinh datetime,
SDT int,
MaLop int foreign key (MaLop) references Lop(MaLop)
)
create table HocPhan(
MaHP int primary key,
TenHP nvarchar(50),
STC int,
TenGV nvarchar(50)
)
create table DangKy(
MaDK int primary key,
MaSV int foreign key (MaSV) references SinhVien(MaSV),
MaHP int foreign key (MaHP) references HocPhan(MaHP),
HocKy int,
NamHoc int
)
create table DiemHP(
ID int primary key,
MaDK int foreign key (MaDK) references DangKy(MaDK),
DiemCC float,
DiemTX float,
DiemThi float,
GhiChu nvarchar(50)
)
-- cau 2
go
create procedure Cau2(@ma int)
as
begin
select * from HocPhan inner join DangKy on HocPhan.MaHP=DangKy.MaHP
						inner join SinhVien on DangKy.MaSV=SinhVien.MaSV
where @ma=SinhVien.MaSV
end
--cau 3
alter table SinhVien
add SoHPDK int
go
create trigger CapNhat
on DangKy for insert, update,delete
as
begin
update SinhVien
set SoHPDK=SoHPDK+1
from SinhVien inner join inserted on SinhVien.MaSV=inserted.MaSV
update SinhVien
set SoHPDK=SoHPDK-1
from SinhVien inner join deleted on SinhVien.MaSV=deleted.MaSV
end
insert into Lop values('12',N'Lớp 12A1')
insert into Lop values('122',N'Lớp 12A2')
insert into SinhVien values('81100',N'Trần Thanh Long',N'Nam','01/02/2002','982365823','12','5')
insert into SinhVien values('81102',N'Trần Thanh Lan',N'Nữ','01/02/2002','34535823','12','5')
insert into SinhVien values('81104',N'Trần Thanh Lâm',N'Nam','01/02/2002','924365823','12','5')
insert into SinhVien values('81105',N'Trần Thanh Tâm',N'Nữ','01/02/2002','932425223','12','5')
insert into SinhVien values('81107',N'Trần Thanh Toàn',N'Nam','01/02/2002','1241365823','12','5')
insert into HocPhan values('90',N'Toán cao cấp','4',N'Phạm Thanh Tùng')
insert into DangKy values('6','81100','90','1','2023')
insert into DiemHP values('99','6','9.5','9.0','10.0',N'Học Sinh Hư')