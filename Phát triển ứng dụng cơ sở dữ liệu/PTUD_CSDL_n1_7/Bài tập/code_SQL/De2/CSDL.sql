create database db_de2
use db_de2

create table SINHVIEN
(
	MaSV char(10) not null primary key,
	Hoten nvarchar(100),
	Ngaysinh datetime,
	Gioitinh bit
)

create table NXB
(
	MaNXB char(10) not null primary key,
	TenNXB nvarchar(100)
)


create table SACH
(
	Masach char(10) not null primary key,
	Tensach nvarchar(100),
	Theloai nvarchar(20),
	NamXB int,
	MaNXB char(10),
	Trangthai char(3),
	constraint fk_s_nxb foreign key(MaNXB) references NXB(MaNXB)
)

create table PHIEU_MUON
(
	Masach char(10),
	MaSV char(10),
	Ngaymuon datetime,
	Ngaytra datetime,
	constraint fk_pm_sach foreign key(Masach) references SACH(Masach),
	constraint fk_pm_sv foreign key (MaSV) references SINHVIEN(MaSV)
)

insert into SINHVIEN values('SV01', 'Nguyễn Văn A', '2/3/2001', '0'),
							('SV02', 'Nguyễn Văn B', '2/3/2001', '1'),
							('SV03', 'Nguyễn Văn C', '2/3/2001', '0')

insert into NXB values('NXB01', 'Hồng Ân'),
						('NXB02', 'DHHHVN'),
						('NXB03', 'DHQH Huế')

insert into SACH values ('S01', 'Toán cao cấp', 'Khoa học', '2001', 'NXB02', 'NO'),
					('S02', 'Toán chuyên đề', 'Khoa học', '2001', 'NXB03', 'NO'),
					('S03', 'Xác suất thống kê', 'Khoa học', '2001', 'NXB02', 'NO')

insert into PHIEU_MUON values('S01', 'SV01', '3/2/2009', '3/8/2009'),
						('S03', 'SV01', '3/2/2009', '1/1/2010'),
						('S02', 'SV01', '3/2/2009', '3/30/2009')

-- câu 2: tên sách được mượn nhiều nhất
select TenSach  from Sach inner join Phieu_Muon on Sach.MaSach = Phieu_Muon.MaSach 
group by TenSach 
having COUNT(Phieu_Muon.Masach) >= all (select COUNT(Masach) from Phieu_Muon group by Masach)
-- câu 3: Tạo trigger cập nhật lại trạng thái của sách là yes sau khi xóa một bản ghi của phiếu mượn
-- dựa vào mã sách để xác định sách cần cập nhật

create trigger tr_Update on PHIEU_MUON
for delete 
as
begin
	update SACH set Trangthai = 'Yes' from SACH, deleted where SACH.Masach = deleted.Masach
end

select * from Phieu_Muon
select * from Sach

delete Phieu_Muon where MaSach = 'S02'