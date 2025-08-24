package vn.edu.vimaru.fit;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        DSNguoiDung ds = DSNguoiDung.getInstance();
        Scanner sc = new Scanner(System.in);

        // Tạo một đối tượng người dùng mới.
        // Inner Class
        // DSNguoiDung.NguoiDung mau = ds.new NguoiDung();

        // Nested Class
        DSNguoiDung.NguoiDung mau = new DSNguoiDung.NguoiDung();

        mau.fromCsvRow("mau01,Toàn Tuấn,Tú,Nam,22/12/1995");
        mau.inThongTin();

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

        ChucNang suaNguoiDung = new SuaNguoiDung(sc);

        ChucNang xoaNguoiDung = new ChucNang() {
            @Override
            public String moTa() {
                return "Xóa người dùng";
            }

            @Override
            public void thucThi() {
                System.out.print("Nhập họ và tên người dùng muốn xóa: ");
                String hoTen = sc.nextLine().trim();
                // Truy cập Inner class giống như truy cập thuộc tính.
                DSNguoiDung.NguoiDung nd = ds.timKiem(hoTen);
                if (nd != null) {
                    System.out.println("Xóa người dùng có thông tin:");
                    nd.inThongTin();
                    ds.xoaNguoiDung(nd);
                } else {
                    System.out.println("Không tìm thấy người dùng có tên " + hoTen);
                }
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

        ChucNang luuDuLieu = new ChucNang() {
            @Override
            public String moTa() {
                return "Lưu danh sách người dùng";
            }

            @Override
            public void thucThi() {
                System.out.println("Nhập tên tệp tinh muốn lưu: ");
                String filename = sc.nextLine().trim();
                ds.luu(filename);
            }
        };

        ChucNang nhapDuLieu = new ChucNang() {
            @Override
            public String moTa() {
                return "Nhập dữ liệu người dùng từ tệp tin";
            }

            @Override
            public void thucThi() {
                System.out.println("Nhập tên tệp tin chứa dữ liệu người dùng: ");
                String filename = sc.nextLine().trim();
                ds.nhap(filename);
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
        menu.add(luuDuLieu);
        menu.add(nhapDuLieu);
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
