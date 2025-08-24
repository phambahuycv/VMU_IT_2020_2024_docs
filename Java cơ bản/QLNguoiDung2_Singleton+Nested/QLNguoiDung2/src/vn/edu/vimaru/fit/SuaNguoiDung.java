package vn.edu.vimaru.fit;

import java.util.Scanner;

public class SuaNguoiDung implements ChucNang {
    Scanner sc;

    public SuaNguoiDung(Scanner sc) {
        this.sc = sc;
    }

    @Override
    public String moTa() {
        return "Sửa người dùng";
    }

    @Override
    public void thucThi() {
        DSNguoiDung ds = DSNguoiDung.getInstance();
        System.out.print("Nhập họ và tên người dùng muốn sửa: ");
        String hoTen = sc.nextLine().trim();
        DSNguoiDung.NguoiDung nd = ds.timKiem(hoTen);
        if (nd != null) {
            ds.suaNguoiDung(nd);
        } else {
            System.out.println("Không tìm thấy người dùng có tên " + hoTen);
        }
    }
}
