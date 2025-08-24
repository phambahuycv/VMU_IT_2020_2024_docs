package vn.edu.vimaru.fit;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Person p = new Person();
        p.hoVaTen = "Xuan";
        p.doiMatKhau("12345");
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mật khẩu: ");
        String mk = sc.nextLine();
        mk = mk.trim();
        if (p.dangNhap(mk)) {
            System.out.println("Đăng nhập thành công!");
        } else {
            System.out.println("Sai mật khẩu...");
        }
        System.out.println("Số lượng người " + Person.soLuongNguoi);
        Person pClone = new Person();
        System.out.printf("Số lượng người mới %d\n", Person.soLuongNguoi);
    }
}
