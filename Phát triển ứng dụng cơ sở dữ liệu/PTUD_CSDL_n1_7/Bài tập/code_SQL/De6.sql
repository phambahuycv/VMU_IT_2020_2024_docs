Create database QLDV87726
use QLDV87726
go
create table LienChiDoan(
MaLCD int primary key,
TenLCD nvarchar(50),
DiaChi nvarchar(100),
TongSoChiDoan int
)
create table ChiDoan(
MaCD int primary key,
TenCD nvarchar(50),
MaLCD int foreign key (MaLCD) references LienChiDoan(MaLCD),
SoDoanVien int
)
create table DoanVien(
MaDV int primary key,
TenDV nvarchar(50),
NgaySinh datetime,
SDT int,
NgayVao datetime,
MaCD int foreign key (MaCD) references ChiDoan(MaCD)
)
create table PhieuThu(
SoPhieu int primary key,
Ngay datetime,
MaDV int foreign key (MaDV) references DoanVien(MaDV),
DoanPhi int
)
--cau 2
go
create function fu_DoanVien(@macd int)
returns table
as
return(
	select MaDV,TenDV,NgaySinh,NgayVao,TenCD from DoanVien,ChiDoan
	where ChiDoan.MaCD=@macd
)
go
--select * from fu_DoanVien()
--cau 3
create trigger capnhat
on DoanVien for insert,update,delete
as
begin
update ChiDoan
set SoDoanVien=SoDoanVien+1
from ChiDoan inner join inserted on ChiDoan.MaCD= inserted.MaCD
update ChiDoan
set SoDoanVien=SoDoanVien-1
from ChiDoan inner join deleted on ChiDoan.MaCD= deleted.MaCD
end
insert into LienChiDoan values('1',N'LienA',N'Nha','4')
insert into ChiDoan values('10',N'ChiA','1','8')