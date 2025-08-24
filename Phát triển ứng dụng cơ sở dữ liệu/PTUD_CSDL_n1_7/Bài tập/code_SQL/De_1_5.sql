create database De_1_5
use De_1_5
create table KhoaHoc(
MaKH char(5) primary key,
TenKH nvarchar(20),
DonGia float
)

create table LopHoc(
MaLH char(5) primary key,
TenLH nvarchar(20),
MaKH char(5) foreign key(MaKH) references KhoaHoc(MaKH),
TuNgay datetime,
DenNgay datetime,
SoHocVien int
)
create table HocVien(
MaHV char(5) primary key,
TenHV nvarchar(20),
NgaySinh datetime,
SDT int,
NgayVao datetime,
MaLH char(5) foreign key (MaLH) references LopHoc(MaLH)
)

create table PhieuThu(
SoPhieu int primary key,
NgayThu datetime,
MaHV char(5) foreign key (MaHV) references HocVien(MaHV),
MaLH char(5) foreign key (MaLH) references LopHoc(MaLH),
HocPhi float
)

insert into KhoaHoc values('kh001',N'Học Kì 1','100000')
insert into KhoaHoc values('kh002',N'Học Kì 2','100000')

insert into LopHoc values('lh001',N'Toán Cao Cấp','kh001','01/01/2021','05/20/2022','45')
insert into LopHoc values('lh002',N'Toán Cao Cấp','kh001','01/01/2021','05/20/2022','45')
insert into LopHoc values('lh003',N'Toán Cao Cấp','kh001','01/01/2021','05/20/2022','45')
insert into LopHoc values('lh004',N'Toán Cao Cấp','kh001','01/01/2021','05/20/2022','45')
insert into LopHoc values('lh005',N'Toán Cao Cấp','kh001','01/01/2021','05/20/2022','45')

insert into HocVien values('hv001',N'Phan Thanh An','01/01/2002','091827363','10/19/2019','lh001')
insert into HocVien values('hv002',N'Phan Thanh Bình','01/05/2002','091263363','10/19/2019','lh001')
insert into HocVien values('hv003',N'Phan Thanh Chung','03/01/2002','091844363','10/19/2019','lh002')
insert into HocVien values('hv004',N'Phan Thanh Hoa','01/02/2002','0918222213','10/19/2019','lh004')
insert into HocVien values('hv005',N'Phan Thanh AnNhôm','02/01/2002','0918999363','10/19/2019','lh005')

--cau 2
GO
create function  fuHocvien(@ma char(5))
returns table
as 
	return(
	select MaHV,TenHV,NgaySinh,SDT 
	from HocVien hv inner join LopHoc lh on hv.MaLH= lh.MaLH
	where hv.MaLH=@ma
	)
GO
select * from fuHocvien('lh001')
GO
-- cau 3
create trigger capnhat
on HocVien for insert, update, delete
as
begin
update LopHoc
SET SoHocVien= SoHocVien+1
from LopHoc inner join inserted on LopHoc.MaLH=inserted.MaLH
update LopHoc
SET SoHocVien = SoHocVien-1
from LopHoc inner join deleted on LopHoc.MaLH=deleted.MaLH
end