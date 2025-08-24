package vn.edu.vimaru.fit;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        DanhSachNhanVien ds = new DanhSachNhanVien();
        Scanner sc = new Scanner(System.in);
        ArrayList<ChucNang> menu = new ArrayList<>();

        // Nhập thêm thông tin nhân viên mới
        ChucNang themNhanVien = new ChucNang() {
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
                NhanVien nv = new NhanVien();
                nv.setHoTen(hoTen);
                nv.setGioiTinh(gioiTinh);
                nv.setViTriViecLam(viTri);
                try {
                    LocalDate ngaySinh = LocalDate.parse(ngaySinhStr, NhanVien.DTF);
                    nv.setNgaySinh(ngaySinh);
                    LocalDate ngayTuyenDung = LocalDate.parse(ngayTuyenDungStr, NhanVien.DTF);
                    nv.setNgayTuyenDung(ngayTuyenDung);
                    ds.themNhanVien(nv);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        };
        menu.add(themNhanVien);

        // Tìm kiếm
        ChucNang timKiem = new ChucNang() {
            @Override
            public String moTa() {
                return "Tìm kiếm nhân viên";
            }

            @Override
            public void thucThi() {
                System.out.print("Nhập họ tên nhân viên cần tìm kiếm: ");
                String hoTen = sc.nextLine().trim();
                NhanVien kq = ds.timKiem(hoTen);
                if (kq != null) {
                    kq.inThongTin();
                } else {
                    System.out.println("Không tìm thấy kết quả phù hợp");
                }
            }
        };
        menu.add(timKiem);

        // Chỉnh sửa
        ChucNang chinhSua = new ChucNang() {
            @Override
            public String moTa() {
                return "Chỉnh sửa thông tin nhân viên";
            }

            @Override
            public void thucThi() {
                System.out.print("Nhập họ tên nhân viên cần cập nhật thông tin: ");
                String hoTen = sc.nextLine().trim();
                NhanVien kq = ds.timKiem(hoTen);
                if (kq != null) {
                    kq.inThongTin();
                    System.out.println("Nhập thông tin cần chỉnh sửa.");
                    System.out.print("Nhập họ và tên: ");
                    String hoTenMoi = sc.nextLine().trim();
                    System.out.print("Nhập giới tính: ");
                    String gioiTinh = sc.nextLine().trim();
                    System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
                    String ngaySinhStr = sc.nextLine().trim();
                    System.out.print("Nhập vị trí việc làm: ");
                    String viTri = sc.nextLine().trim();
                    System.out.print("Nhập ngày tuyển dụng (dd/MM/yyyy): ");
                    String ngayTuyenDungStr = sc.nextLine().trim();
                    NhanVien nv = new NhanVien();
                    nv.setHoTen(hoTenMoi);
                    nv.setGioiTinh(gioiTinh);
                    nv.setViTriViecLam(viTri);
                    try {
                        if (!ngaySinhStr.isEmpty()) {
                            LocalDate ngaySinh = LocalDate.parse(ngaySinhStr, NhanVien.DTF);
                            nv.setNgaySinh(ngaySinh);
                        }

                        if (!ngayTuyenDungStr.isEmpty()) {
                            LocalDate ngayTuyenDung = LocalDate.parse(ngayTuyenDungStr, NhanVien.DTF);
                            nv.setNgayTuyenDung(ngayTuyenDung);
                        }
                        ds.suaNhanVien(kq, nv);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                } else {
                    System.out.println("Không tìm thấy kết quả phù hợp");
                }
            }
        };
        menu.add(chinhSua);

        // Xóa thông tin nhân viên
        ChucNang xoaNhanVien = new ChucNang() {
            @Override
            public String moTa() {
                return "Xóa thông tin nhân viên";
            }

            @Override
            public void thucThi() {
                System.out.print("Nhập họ tên nhân viên cần xóa: ");
                String hoTen = sc.nextLine().trim();
                NhanVien kq = ds.timKiem(hoTen);
                if (kq != null) {
                    ds.xoaNhanVien(kq);
                    System.out.println("Đã xóa nhân viên có thông tin");
                    kq.inThongTin();
                } else {
                    System.out.println("Không tìm thấy kết quả phù hợp");
                }
            }
        };
        menu.add(xoaNhanVien);

        // In danh sách nhân viên
        ChucNang inDanhSach = new ChucNang() {
            @Override
            public String moTa() {
                return "In danh sách nhân viên";
            }

            @Override
            public void thucThi() {
                ds.inDanhSach(-1);
            }
        };
        menu.add(inDanhSach);

        // Luu
        ChucNang luu = new ChucNang() {
            @Override
            public String moTa() {
                return "Lưu trữ danh sách nhân viên";
            }

            @Override
            public void thucThi() {
                System.out.println("Chức năng này đang phát triển");
            }
        };
        menu.add(luu);

        // Nhap
        ChucNang nhap = new ChucNang() {
            @Override
            public String moTa() {
                return "Nhập dữ liệu danh sách nhân viên";
            }

            @Override
            public void thucThi() {
                System.out.println("Chức năng này đang phát triển");
            }
        };
        menu.add(nhap);

        // Thoát
        menu.add(new ChucNang() {
            @Override
            public String moTa() {
                return "Thoát";
            }

            @Override
            public void thucThi() {
                System.exit(0);
            }
        });


        // In ra danh sách lựa chọn các chức năng
        for (;;) {
            System.out.println("================================");
            for (int i = 0; i < menu.size(); i++) {
                ChucNang cn = menu.get(i);
                System.out.printf("%d. %s\n", i, cn.moTa());
            }
            System.out.println("--------------------------------");
            System.out.print("Chọn chức năng: ");
            int chon = Integer.valueOf(sc.nextLine().trim());
            {
                ChucNang cn = menu.get(chon);
                System.out.println(cn.moTa());
                cn.thucThi();
            }
        }
    }
}
