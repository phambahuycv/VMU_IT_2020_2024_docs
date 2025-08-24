--cau 1_5,8create database De_5_8_BDV
use De_5_8_BDV
create table SinhVien(
MaSV nvarchar(20) primary key,
TenSV nvarchar(50),
NS datetime,
MaLop nvarchar(20),
NamVT int
)

create table GiaoVien(
MaGV int primary key,
TenGV nvarchar(50),
DC nvarchar(250),
NgayVao datetime,
SoDT int
)

create table DeTai(
MaDT int primary key,
TenDT nvarchar(1000),
NgayBD datetime,
NgayKT datetime,
NoiTT nvarchar(150),
MaGV int foreign key (MaGV) references GiaoVien(MaGV)
)

create table SV_DT(
ID int primary key,
MaSV nvarchar(20) foreign key (MaSV) references SinhVien(MaSV),
MaDT int foreign key (MaDT) references DeTai(MaDT),
KQ nvarchar(10),
GhiChu nvarchar(50)
)


--cau 2_5
go
create view v_DeTai
as
select MaDT,TenDT,NgayBD,NgayKT from DeTai 
inner join GiaoVien on DeTai.MaGV=GiaoVien.MaGV
where DC=N'Khoa CNTT'
--cau 3_5
go
create trigger capnhat1
on DeTai for insert,update,delete
as
begin
update GiaoVien
set SoDT=SoDT+1
from GiaoVien inner join inserted on GiaoVien.MaGV=inserted.MaGV
update GiaoVien
set SoDT=SoDT-1
from GiaoVien inner join deleted on GiaoVien.MaGV=deleted.MaGV
end
go
-- cau2_de8,cau3 de8 same de 5
insert into GiaoVien values('1',N'Chiu Chơi',N'Ca to lắm','10/10/2018','8')
update GiaoVien set DC='Khoa CNTT' where MaGV='1'
insert into DeTai values('100',N'Đi phá game','01/03/2021','01/03/2022',N'Không có','1')
insert into SinhVien values(N'sv100',N'Mất điện','01/03/2002',N'LopN','2019')
insert into SinhVien values(N'sv101',N'Mất Chộm','01/03/2002',N'LopN','2019')
insert into SinhVien values(N'sv102',N'Mất tiền','01/03/2002',N'LopN','2019')
insert into SinhVien values(N'sv103',N'Mất bút','01/03/2002',N'LopN','2019')
insert into SinhVien values(N'sv104',N'Mất dép','01/03/2002',N'LopN','2019')
select * from v_DeTai
select * from GiaoVien
insert into DeTai values('102',N'Đi phá Thoii','01/03/2021','01/03/2022',N'Không có','1')
delete from DeTai where MaDT='102'