package vn.edu.vimaru.fit;

import java.util.Date;

public class Person {
    static int soLuongNguoi = 0;
    String hoVaTen;
    Date ngaySinh;
    int gioiTinh; // 1 = nam, 2 = nu
    String congViec;
    private String matKhau;

    public Person() {
        soLuongNguoi++;
    }

    public boolean dangNhap(String mk) {
        return matKhau.equals(mk);
    }

    public void doiMatKhau(String mk) {
        matKhau = mk;
    }

    public void thayDoiCongViec(String cv) {
        this.congViec = cv;
    }
}
