create database De_6
use De_6

create table PhongBan(
MaPB char(20) primary key,
TenPB nvarchar(100),
Chucnang nvarchar(100)
)

create table NhanVien(
MaNV char(20) primary key,
TenNV nvarchar(100),
NgaySinh datetime,
Phai nchar(10),
QueQuan nvarchar(100),
SDT char(20),
MaPB char(20) foreign key (MaPB) references PhongBan(MaPB)
)

create table CongTrinh(
MaCT char(10) primary key,
TenCT nvarchar(100),
DiaDiem nvarchar(100)
)

create table PhanCong(
ID int identity(1,1) primary key,
MaCT char(10),
MaNV char(20) foreign key (MaNV) references NhanVien(MaNV),
NgayPhanCong datetime,
NgayHoanThanh datetime
)

insert into PhongBan values('mapb1',N'Phòng tài chính 1',N'Tính Tiền')
insert into PhongBan values('mapb2',N'Phòng tài chính 2',N'Tính Tiền')

insert into NhanVien values('nv001',N'Phạm Văn Sa','10/10/2002',N'kagsf',N'Hải Phòng','298327362','mapb1')
insert into NhanVien values('nv002',N'Phạm Văn Sc','10/10/2002',N'kagsf',N'Hải Phòng','298327366','mapb2')
insert into NhanVien values('nv003',N'Phạm Văn Sx','10/10/2002',N'kagsf',N'Hải Phòng','298327361','mapb1')
insert into NhanVien values('nv004',N'Phạm Văn Sz','10/10/2002',N'kagsf',N'Hải Phòng','298327363','mapb2')
insert into NhanVien values('nv005',N'Phạm Văn Sn','10/10/2002',N'kagsf',N'Hải Phòng','298327364','mapb1')
