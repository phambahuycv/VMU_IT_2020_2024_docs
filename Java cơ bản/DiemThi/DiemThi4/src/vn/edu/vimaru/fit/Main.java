package vn.edu.vimaru.fit;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên tệp tin chứa dữ liệu: ");
        String inFilename = sc.nextLine().trim();
        System.out.printf("Đọc dữ liệu từ tệp tin %s\n", inFilename);
        XuLy xl = new XuLy();
        xl.docDuLieu(inFilename);
        System.out.print("Nhập tên tệp tin muốn lưu: ");
        String outFilename = sc.nextLine().trim();
        System.out.printf("Xuất dữ liệu ra tệp tin %s\n", outFilename);
        xl.xuatDuLieu(outFilename);
        xl.thongKe();
    }
}
