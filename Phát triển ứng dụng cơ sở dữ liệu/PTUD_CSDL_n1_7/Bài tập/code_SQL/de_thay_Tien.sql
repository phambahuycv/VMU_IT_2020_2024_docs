create database QuanLyKhoa
use QuanLyKhoa
create table Khoa(
MaKhoa int primary key,
TenKhoa nvarchar(50),
SoNganh int
)

create table Nganh(
MaNganh int primary key,
TenNganh nvarchar(50),
MaKhoa int foreign key (MaKhoa) references Khoa(MaKhoa)
)

create table Lop(
MaLop int primary key,
TenLop nvarchar(50),
MaNganh int foreign key (MaNganh) references Nganh(MaNganh)
)

-- trigger
go
create trigger capnhat
on Nganh for insert, delete
as
begin
update Khoa
set SoNganh=SoNganh+1
from Khoa inner join inserted on Khoa.MaKhoa=inserted.MaKhoa
update Khoa
set SoNganh=SoNganh-1
from Khoa inner join deleted on Khoa.MaKhoa=deleted.MaKhoa
end

insert into Khoa values('1',N'Khoa Tàu','20')
insert into Nganh values('11',N'Ngành đua=','1')
insert into Lop values('1111',N'Lớp tảua lái','11')
insert into Lop values('1112',N'Lớp tảua lái 2','11')
insert into Nganh values('12',N'Ngành quậy','1')
insert into Nganh values('13',N'Ngành phá','1')
select * from Nganh
select * from Khoa
delete from Nganh where MaNganh='12'

--fu
go
alter function DemSoLop(@ma int)
returns table
as
return(
	select count(*) as SoLuong from Lop,Khoa 

	where MaLop>0 and @ma=Khoa.MaKhoa
)
go
select * from DemSoLop(1)

