package vn.edu.vimaru.fit;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        DSNguoiDung ds = new DSNguoiDung();
        Scanner sc = new Scanner(System.in);

        ChucNang themNguoiDung = new ChucNang() {
            @Override
            public String moTa() {
                return "Thêm người dùng";
            }

            @Override
            public void thucThi() {
                ds.themNguoiDung();
            }
        };

        ChucNang suaNguoiDung = new ChucNang() {
            @Override
            public String moTa() {
                return "Sửa người dùng";
            }

            @Override
            public void thucThi() {
                System.out.println("Chức năng này đang được phát triển");
            }
        };

        ChucNang xoaNguoiDung = new ChucNang() {
            @Override
            public String moTa() {
                return "Xóa người dùng";
            }

            @Override
            public void thucThi() {
                System.out.println("Chức năng này đang được phát triển");
            }
        };

        ChucNang inDanhSach = new ChucNang() {
            @Override
            public String moTa() {
                return "In danh sách người dùng";
            }

            @Override
            public void thucThi() {
                ds.inDanhSach();
            }
        };

        ChucNang timKiem = new ChucNang() {
            @Override
            public String moTa() {
                return "Tìm kiếm người dùng";
            }

            @Override
            public void thucThi() {
                ds.timKiem();
            }
        };

        ChucNang ketThuc = new ChucNang() {
            @Override
            public String moTa() {
                return "Thoát chương trình";
            }

            @Override
            public void thucThi() {
                System.exit(0);
            }
        };

        ArrayList<ChucNang> menu = new ArrayList<>();
        menu.add(themNguoiDung);
        menu.add(suaNguoiDung);
        menu.add(xoaNguoiDung);
        menu.add(timKiem);
        menu.add(inDanhSach);
        menu.add(ketThuc);

        for (;;) {
            for (int i = 0; i < menu.size(); i++) {
                ChucNang cn = menu.get(i);
                System.out.printf("%d. %s\n", i, cn.moTa());
            }
            System.out.println("Lựa chọn chức năng: ");
            String chon = sc.nextLine();
            int m = Integer.valueOf(chon);
            ChucNang ch = menu.get(m);
            ch.thucThi();
        }
    }
}
