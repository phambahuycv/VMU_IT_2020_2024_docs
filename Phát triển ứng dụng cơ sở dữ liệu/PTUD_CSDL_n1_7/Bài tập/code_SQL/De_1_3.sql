create database De_1_3
use De_1_3

create table Lop(
MaLop char(5) primary key,
TenLop nvarchar(10)
)

create table SinhVien(
MaSV char(5) primary key,
TenSV nvarchar(20),
GioiTinh nvarchar(5),
NgaySinh datetime,
SDT int,
MaLop char(5) foreign key (MaLop) references Lop(MaLop)
)

create table HocPhan(
MaHP char(5) primary key,
TenHP nvarchar (20),
SoTC int,
TenGV nvarchar(20)
)

create table DangKy(
MaDK char(5) primary key,
MaSV char(5) foreign key (MaSV) references SinhVien(MaSV),
MaHP char(5) foreign key (MaHP) references HocPhan(MaHP),
HocKy int,
NamHoc int
)
create table DiemHP(
MaDK char(5) primary key,
DiemCC float,
DiemTX float,
DiemThi float,
GhiChu nvarchar(50)
)

insert into Lop values('lop23',N'Lop12A3')
insert into Lop values('lop24',N'Lop12A4')
insert into Lop values('lop25',N'Lop12A5')
insert into Lop values('lop26',N'Lop12A6')
insert into Lop values('lop27',N'Lop12A7')

insert into SinhVien values('sv001',N'Nguyen Van A',N'Nam','11/11/2002','0918273645','lop23')
insert into SinhVien values('sv002',N'Nguyen Van B',N'Nam','11/11/2002','0918273635','lop24')
insert into SinhVien values('sv003',N'Nguyen Van C',N'Nam','11/11/2002','0918273625','lop25')
insert into SinhVien values('sv004',N'Nguyen Van D',N'Nam','11/11/2002','0918273615','lop26')
insert into SinhVien values('sv005',N'Nguyen Van E',N'Nam','11/11/2002','0918273605','lop27')

--Cau 2

create procedure hocphandangky (@ma char (5))
as
Begin


 select TenSV, TenHP
 from SinhVien sv inner join DangKy dk on sv.MaSV = dk.MaSV
 inner join HocPhan hp on dk.MaHP = hp.MaHP
 where dk.MaSV = @ma
End

-- Cau 3
GO
alter table SinhVien
add SoHPDK int
GO
Create trigger capnhat
on DangKy for insert,update,delete
as
begin
update SinhVien
set SoHPDK= SoHPDK+1
from SinhVien inner join inserted on SinhVien.MaSV=inserted.MaSV
update SinhVien
set SoHPDK= SoHPDK-1
from SinhVien inner join deleted on SinhVien.MaSV=deleted.MaSV
end
Go