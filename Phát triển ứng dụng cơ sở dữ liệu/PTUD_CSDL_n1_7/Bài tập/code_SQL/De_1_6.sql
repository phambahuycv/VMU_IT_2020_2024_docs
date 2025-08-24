create database De_1_6
use De_1_6
create table DangBo(
MaDB char(5) primary key,
TenDB nvarchar(20),
DiaChi nvarchar(50),
TongSoChiBo int
)
create table ChiBo(
MaCB char(5) primary key,
TenCB nvarchar(20),
MaDB char(5) foreign key (MaDB) references DangBo(MaDB),
SoDangVien int
)
create table DangVien(
MaDV char(5) primary key,
TenDV nvarchar(20),
NgaySinh datetime,
SDT int,
NgayVao DateTime,
MaCB char(5) foreign key (MaCB) references ChiBo(MaCB)
)
create table PhieuThu(
SoPhieu int primary key,
NgayThu datetime,
DangPhi float
)

insert into DangBo values ('db001',N'Đảng Cà Khịa',N'Nhà hàng xóm','45')
insert into DangBo values ('db002',N'Đảng Cà Chớn',N'Nhà hàng kế bên','40')
insert into DangBo values ('db003',N'Đảng Cà Chua',N'Nhà hàng','47')
insert into DangBo values ('db004',N'Đảng Cà Pháo',N'Nhà xóm liều','44')
insert into DangBo values ('db005',N'Đảng Cà Rem',N'Nhà đối diện','41')


insert into ChiBo values ('cb001',N'Chi Sau','db001','500') 
insert into ChiBo values ('cb002',N'Chi Trước','db002','500') 
insert into ChiBo values ('cb003',N'Chi Dưới','db003','500') 
insert into ChiBo values ('cb004',N'Chi Trên','db004','500') 
insert into ChiBo values ('cb005',N'Chi Giữa','db005','500') 

insert into DangVien values ('dv001',N'Phạm Văn Anh','01/02/2002','293652635','03/05/2021','cb001')
insert into DangVien values ('dv002',N'Lê Văn Anh','01/05/2002','12122635','03/05/2021','cb002')
insert into DangVien values ('dv003',N'Trần Văn Anh','04/02/2002','555352635','03/05/2021','cb003')
insert into DangVien values ('dv004',N'Nguyễn Văn Anh','03/02/2002','362423635','03/05/2021','cb004')
insert into DangVien values ('dv005',N'Đỗ Văn Anh','02/02/2002','29433225','03/05/2021','cb005')