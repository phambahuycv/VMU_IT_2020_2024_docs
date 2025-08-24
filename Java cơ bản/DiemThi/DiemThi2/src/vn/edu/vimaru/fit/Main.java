package vn.edu.vimaru.fit;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        XuLyDiemThi xl = new XuLyDiemThi();
        System.out.println("Đọc dữ liệu từ tệp tin input.txt");
        xl.docDuLieu("input.txt");

        System.out.println("Lưu dữ liệu vào tệp tin output.txt");
        xl.xuatDuLieu("output.txt");

        System.out.println("Thống kế");
        xl.thongKe();
    }
}
