package vn.edu.vimaru.fit;

public abstract class LopGiaoDien implements GiaoDien {
    public void info() {
        System.out.println("Đây là lớp kế thừa GiaoDien!");
    }

    @Override
    public void nhap() {
        System.out.println("Triển khai phương thưc nhập");
    }
}
