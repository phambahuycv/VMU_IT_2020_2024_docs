package vn.edu.vimaru.fit;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        DanhSachNhanVien ds = DanhSachNhanVien.getInstance();
        Scanner sc = new Scanner(System.in);
        ArrayList<ChucNang> menu = new ArrayList<>();
        // Thêm nhân viên
        ChucNang themNhanVien = new ChucNangThemNhanVien(sc);
        menu.add(themNhanVien);

        // Xóa một nhân viên
        ChucNang xoaNhanVien = new ChucNang() {
            @Override
            public String moTa() {
                return "Xóa nhân viên";
            }

            @Override
            public void thuThi() {
                System.out.println("Tính năng này đang được phát triển");
            }
        };
        menu.add(xoaNhanVien);

        // Sửa thông tin nhân viên
        ChucNang suaThongTin = new ChucNang() {
            @Override
            public String moTa() {
                return "Sửa thông tin nhân viên";
            }

            @Override
            public void thuThi() {
                System.out.println("Sửa thông tin nhân viên.");
                DanhSachNhanVien.NhanVien nvCu = ds.ds.get(0);
                nvCu.inThongTin();
                System.out.print("Nhập họ và tên: ");
                String hoTen = sc.nextLine().trim();
                System.out.print("Nhập giới tính: ");
                String gioiTinh = sc.nextLine().trim();
                System.out.print("Nhập vị trí việc làm: ");
                String viTri = sc.nextLine().trim();
                System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
                String ngaySinhStr = sc.nextLine().trim();
                System.out.print("Nhập ngày tuyển dụng: ");
                String ngayTuyenDungStr = sc.nextLine().trim();
                DanhSachNhanVien.NhanVien nv =
                        new DanhSachNhanVien.NhanVien();
                nv.setHoVaTen(hoTen);
                nv.setGioiTinh(gioiTinh);
                nv.setViTri(viTri);
                try {
                    if (!ngaySinhStr.isEmpty()) {
                        LocalDate ngaySinh =
                                LocalDate.parse(ngaySinhStr, DanhSachNhanVien.dtf);
                        nv.setNgaySinh(ngaySinh);
                    }
                    if (!ngayTuyenDungStr.isEmpty()) {
                        LocalDate ngayTuyenDung =
                                LocalDate.parse(ngayTuyenDungStr, DanhSachNhanVien.dtf);

                        nv.setNgayTuyenDung(ngayTuyenDung);
                    }
                    ds.suaNhanVien(nvCu, nv);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        };
        menu.add(suaThongTin);

        // Tìm kiếm nhân viên
        ChucNang timKiem = new ChucNang() {
            @Override
            public String moTa() {
                return "Tìm kiếm nhân viên";
            }

            @Override
            public void thuThi() {
                System.out.print("Nhập vào họ tên nhân viên muốn tìm: ");
                String hoTen = sc.nextLine().trim();
                DanhSachNhanVien.NhanVien kq = ds.timKiem(hoTen);
                if (kq != null) {
                    kq.inThongTin();
                } else {
                    System.out.println("Không tìm thấy kết quả phù hợp.");
                }
            }
        };
        menu.add(timKiem);

        // In danh sách nhân viên
        ChucNang inDanhSach = new ChucNang() {
            @Override
            public String moTa() {
                return "In danh sách nhân viên";
            }

            @Override
            public void thuThi() {
                System.out.println("Nhập giá trị tuổi nhỏ nhất: ");
                String tuoiNhoNhatStr = sc.nextLine().trim();
                int tuoi = Integer.valueOf(tuoiNhoNhatStr);
                System.out.printf("Danh sách nhân viên có tuổi nhiều hơn %d\n", tuoi);
                ds.inDanhSach(tuoi);
            }
        };
        menu.add(inDanhSach);

        // Luu danh sách
        ChucNang luu = new ChucNang() {
            @Override
            public String moTa() {
                return "Lưu danh sách nhân viên";
            }

            @Override
            public void thuThi() {
                System.out.print("Nhập tên tệp tin muốn lưu: ");
                String filename = sc.nextLine().trim();
                ds.luu(filename);
            }
        };
        menu.add(luu);

        // Nhập dữ liệu
        // Lớp nạc danh (Anonymous class)
        ChucNang nhap = new ChucNang() {
            @Override
            public String moTa() {
                return "Nhập dữ liệu nhân viên";
            }

            @Override
            public void thuThi() {
                System.out.print("Nhập tên tệp tin chứa dữ liệu: ");
                String filename = sc.nextLine().trim();
                ds.nhap(filename);
            }
        };
        menu.add(nhap);

        // Sắp xếp
        ChucNang sapXep = new ChucNangSapXep(ds);
        menu.add(sapXep);

        // Thoát chương trình.
        ChucNang thoat = new ChucNang() {
            @Override
            public String moTa() {
                return "Thoát";
            }

            @Override
            public void thuThi() {
                System.exit(0);
            }
        };
        menu.add(thoat);

        // In menu
        for (;;) {
            System.out.println("====================================");
            for (int i = 0; i < menu.size(); i++) {
                ChucNang cn = menu.get(i);
                System.out.printf("%d. %s\n", i, cn.moTa());
            }
            System.out.println("------------------------------------");
            System.out.print("Lựa chọn chức năng: ");
            int chon = Integer.valueOf(sc.nextLine().trim());
            {
                ChucNang cn = menu.get(chon);
                System.out.println(cn.moTa());
                cn.thuThi();
            }
        }
    }
}
