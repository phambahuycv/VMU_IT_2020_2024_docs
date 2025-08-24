package vn.edu.vimaru.fit;

import java.time.LocalDate;
import java.util.Scanner;

public class ChucNangThemNhanVien implements ChucNang {
    Scanner sc;

    public ChucNangThemNhanVien(Scanner sc) {
        this.sc = sc;
    }

    @Override
    public String moTa() {
        return "Thêm thông tin nhân viên";
    }

    @Override
    public void thucThi() {
        // Nhập thêm thông tin nhân viên mới
        System.out.println("Thêm thông tin nhân viên mới.");
        System.out.print("Nhập họ và tên: ");
        String hoTen = sc.nextLine().trim();
        System.out.print("Nhập giới tính: ");
        String gioiTinh = sc.nextLine().trim();
        System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
        String ngaySinhStr = sc.nextLine().trim();
        System.out.print("Nhập vị trí việc làm: ");
        String viTri = sc.nextLine().trim();
        System.out.print("Nhập ngày tuyển dụng (dd/MM/yyyy): ");
        String ngayTuyenDungStr = sc.nextLine().trim();
        DanhSachNhanVien.NhanVien nv = new DanhSachNhanVien.NhanVien();
        nv.setHoTen(hoTen);
        nv.setGioiTinh(gioiTinh);
        nv.setViTriViecLam(viTri);
        try {
            LocalDate ngaySinh = LocalDate.parse(ngaySinhStr, DanhSachNhanVien.DTF);
            nv.setNgaySinh(ngaySinh);
            LocalDate ngayTuyenDung = LocalDate.parse(ngayTuyenDungStr, DanhSachNhanVien.DTF);
            nv.setNgayTuyenDung(ngayTuyenDung);
            DanhSachNhanVien ds = DanhSachNhanVien.getInstance();
            ds.themNhanVien(nv);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
