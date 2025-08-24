package vn.edu.vimaru.fit;

public class LopThuong extends LopTruuTuong {
    @Override
    public void phuongThucTruuTuong() {
        System.out.println("Triển khai phương thức trừu tượng");
    }

    // Phương thức này sẽ được gọi khi trình quản lý bộ nhớ
    // (GC) của Java làm việc.
    @Override
    public void finalize() {
        System.out.println("Giải phóng LopThuong!");
    }
}
