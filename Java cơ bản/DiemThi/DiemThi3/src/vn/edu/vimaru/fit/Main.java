package vn.edu.vimaru.fit;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        XuLyDiemThi xl = new XuLyDiemThi();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên tệp tin chứa dữ liệu: ");
        String filename = sc.nextLine().trim();
        xl.docDuLieu(filename);
        System.out.print("Nhập tên tệp tin để xuất dữ liệu ra: ");
        filename = sc.nextLine().trim();
        xl.luuDuLieu(filename);
        xl.thongKe();
    }
}
