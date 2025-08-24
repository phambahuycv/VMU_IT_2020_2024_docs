package vn.edu.vimaru.fit;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class NhanVien {
    public static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String hoVaTen;
    LocalDate ngaySinh;
    String gioiTinh;
    String viTri;
    LocalDate ngayTuyenDung;

    public NhanVien() {}
    public NhanVien(
            String hoVaTen,
            LocalDate ngaySinh,
            String gioiTinh,
            String viTri,
            LocalDate ngayTuyenDung
    ) {
        this.hoVaTen = hoVaTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.viTri = viTri;
        this.ngayTuyenDung = ngayTuyenDung;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
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

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
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
        System.out.printf("Họ và tên: %s\n", hoVaTen);
        System.out.printf("Ngày sinh: %s\n", ngaySinh.format(dtf));
        System.out.printf("Giới tính: %s\n", gioiTinh);
        System.out.printf("Vị trí công việc: %s\n", viTri);
        System.out.printf("Ngày tuyển dụng: %s\n", ngayTuyenDung.format(dtf));
    }
}
