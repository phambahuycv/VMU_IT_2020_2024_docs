package vn.edu.vimaru.fit;

public class Main {

    public static void gc() {
        LopTruuTuong tt;
        tt = new LopThuong();
        tt.phuongThuc();
        tt.phuongThucTruuTuong();
    }

    public static void main(String[] args) {
	    // write your code here
        // Gọi việc khởi tạo đối tượng từ một phương thức
        gc();
        System.gc();
        System.out.println("------------------------------");
        // Khởi tạo đối tượng trong hàm main
        LopTruuTuong tt;
        tt = new LopThuong();
        tt.phuongThuc();
        tt.phuongThucTruuTuong();
    }
}
