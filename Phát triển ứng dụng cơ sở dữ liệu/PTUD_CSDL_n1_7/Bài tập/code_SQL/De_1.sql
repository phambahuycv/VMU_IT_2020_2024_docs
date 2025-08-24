create database De_1_1
use De_1_1
create table Lop(
MaLop char(10) primary key,
TenLop nvarchar(20),
SiSo int,
GhiChu nvarchar(50)
)
insert into Lop values('lop3120001',N'Lớp 12A1','56',N'Nam với nữ ngang nhau') 
insert into Lop values('lop3120002',N'Lớp 12A2','56',N'Nam với nữ ngang nhau') 
create table HocSinh(
MaHS char(10) primary key,
TenHS nvarchar(20),
MaLop char(10) foreign key (MaLop) references Lop(MaLop),
GioiTinh nvarchar(5),
NgaySinh datetime,
TenPH nvarchar(20)
)

insert into HocSinh values('hs12345678',N'Trần Tê Tái','lop3120001',N'Nam','02/01/2002',N'Trần Chưa Chín') 
insert into HocSinh values('hs12345679',N'Phạm Tê Tái','lop3120002',N'Nam','03/01/2002',N'Phạm Chưa Chín') 
insert into HocSinh values('hs12345680',N'Nguyễn Tê Tái','lop3120002',N'Nam','04/01/2002',N'Nguyễn Chưa Chín') 
insert into HocSinh values('hs12345681',N'Lê Tê Tái','lop3120001',N'Nam','05/01/2002',N'Lê Chưa Chín') 
insert into HocSinh values('hs12345682',N'Vũ Tê Tái','lop3120002',N'Nam','06/01/2002',N'Vũ Chưa Chín') 

create table KhoanThu(
MaKT char(10) primary key,
TenKT nvarchar(20),
Ki int,
Namhoc int,
DonGia float
)

create table CTThu(
ID int primary key,
MaKT char(10) foreign key (MaKT) references KhoanThu(MaKT),
MaHS char(10) foreign key (MaHS) references HocSinh(MaHS),
Ngaynop datetime,
SoTienThu float,
Ghichu nvarchar(50)
)


create function tienno(@ma char(10))
returns table as
	return (select sum(KhoanThu.DonGia) - sum(CTThu.SoTienThu) as 'Tien no' from HocSinh 
	inner join CTThu on HocSinh.MaHS = CTThu.MaHS inner join KhoanThu on CTThu.MaKT = KhoanThu.MaKT
	group by HocSinh.MaHS
	having HocSinh.MaHS = @ma)


select * from tienno('hs12345679')



create trigger trigger_Update_Insert
on dbo.HocSinh
for  insert
as
begin
	update t1 set t1.SiSo  = t1.SiSo + t2.Dem
	from Lop t1 inner join (select MaLop, count(*) as Dem from inserted group by MaLop ) t2
	on t1.MaLop = t2.MaLop
end;

create trigger trigger_Update_Delete
on dbo.HocSinh
for  delete
as
begin
	update t1 set t1.SiSo  = t1.SiSo - t2.Dem
	from Lop t1 inner join (select MaLop, count(*) as Dem from deleted group by MaLop ) t2
	on t1.MaLop = t2.MaLop
end;

create trigger trigger_Update_Update
on dbo.HocSinh
for  update
as
begin
	update t1 set t1.SiSo  = t1.SiSo - t2.Dem
	from Lop t1 inner join (select MaLop, count(*) as Dem from deleted group by MaLop ) t2
	on t1.MaLop = t2.MaLop
	update t1 set t1.SiSo  = t1.SiSo + t2.Dem
	from Lop t1 inner join (select MaLop, count(*) as Dem from inserted group by MaLop ) t2
	on t1.Malop = t2.MaLop
end;



--	Create trigger inHS on HocSinh 
--	After  insert, update, delete
--	Begin
--		If((select count(*) from inserted)>0)
--			Update Lớp set siso=+1
--		If (select count(*) from deleted)>0)
--			Update Lóp set siso=-1
--	End

--	create database dangkylophoc
--go



--create table khoa (
--makhoa nvarchar(50),
--tenkhoa nvarchar(50),
--diachi nvarchar(50),
--constraint pk_makhoa primary key (makhoa)
--)


--create table hocvien (
--mahocvien nvarchar(50),
--makhoa nvarchar(50),
--tenhv nvarchar(50),
--ngaysinh datetime,
--gioitinh nvarchar(50),
--dienthoat int,
--constraint pk_hocvien primary key (mahocvien),
--constraint fk_khoa foreign key (makhoa) references khoa(makhoa)
--)


--create table lop (
--malop nvarchar(50),
--tenlop nvarchar(50),
--ngaylap datetime,
--noidunghoc nvarchar(50)
--constraint pk_malop primary key (malop)
--)


--create table dangky (
--madk nvarchar(50),
--mahocvien nvarchar(50),
--malop nvarchar(50),
--hocphi int,
--ngaydk datetime,
--constraint pk_madk primary key (madk),
--constraint fk_mahocvien foreign key (mahocvien) references hocvien(mahocvien)
--)
--ngaykt vao bang lop biet ngayketthuc = ngaylap + case when malop = (km,knc) là 20 , thdc = 10 , ta = 25 còn lại là 5 ngày
--alter table lop
--add ngayketthuc date

--alter trigger trg_themngayketthuc
--on lop
--after insert , update , delete
--as
--begin
--	declare @malop nvarchar(50) 
--	set @malop = (select malop from inserted) 
--	if(@malop is not null) 
--	begin
--		update l set l.ngayketthuc = case 
--		when l.malop = 'KM' or l.malop = 'knc' then dateadd(day,20,l.ngaylap) 
--		when l.malop = 'THDC' then dateadd(day,10,l.ngaylap) 
--		when l.malop = 'TA' then dateadd(day,25,l.ngaylap) 
--		else dateadd(day,5,l.ngaylap) 
--		end from lop l where l.malop = @malop 
--	end
--	set @malop = (select malop from deleted)
--	if(@malop is not null)
--	begin
--		update l set l.ngayketthuc = case 
--		when l.malop = 'KM' or l.malop = 'knc' then dateadd(day,20,l.ngaylap) 
--		when l.malop = 'THDC' then dateadd(day,10,l.ngaylap) 
--		when l.malop = 'TA' then dateadd(day,25,l.ngaylap) 
--		else dateadd(day,5,l.ngaylap) 
--		end from lop l where l.malop = @malop 
--	end
--end 
--go