package vn.edu.vimaru.fit;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class NhanVien {
    public static final DateTimeFormatter DTF =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String hoTen;
    LocalDate ngaySinh;
    String gioiTinh;
    String viTriViecLam;
    LocalDate ngayTuyenDung;

    public NhanVien() {}
    public NhanVien(
            String hoTen,
            LocalDate ngaySinh,
            String gioiTinh,
            String viTri,
            LocalDate ngayTuyenDung
    ) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.viTriViecLam = viTri;
        this.ngayTuyenDung = ngayTuyenDung;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getViTriViecLam() {
        return viTriViecLam;
    }

    public void setViTriViecLam(String viTriViecLam) {
        this.viTriViecLam = viTriViecLam;
    }

    public LocalDate getNgayTuyenDung() {
        return ngayTuyenDung;
    }

    public void setNgayTuyenDung(LocalDate ngayTuyenDung) {
        this.ngayTuyenDung = ngayTuyenDung;
    }

    public int getTuoi() {
        LocalDate hienTai = LocalDate.now();
        Period tuoi = Period.between(ngaySinh, hienTai);
        return tuoi.getYears();
    }

    public void inThongTin() {
        System.out.printf("Họ và tên: %s\n", hoTen);
        System.out.printf("Giới tính: %s\n", gioiTinh);
        System.out.printf("Ngày sinh: %s (%d tuối)\n",
                ngaySinh.format(DTF), getTuoi());
        System.out.printf("Vị trí việc làm: %s\n", viTriViecLam);
        System.out.printf("Ngày tuyển dụng: %s\n", ngayTuyenDung.format(DTF));
    }
}
