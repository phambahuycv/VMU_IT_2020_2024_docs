package vn.edu.vimaru.fit;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class NguoiDung {
    String hoDem;
    String ten;
    String id;
    String gioTinh;
    LocalDate ngaySinh;

    public NguoiDung() {

    }

    public NguoiDung(String id,
                     String hoDem, String ten,
                     String gioTinh,
                     LocalDate ngaySinh) {
        this.id = id;
        this.hoDem = hoDem;
        this.ten = ten;
        this.gioTinh = gioTinh;
        this.ngaySinh = ngaySinh;
    }

    public String getHoVaTen() {
        return hoDem + " " + ten;
    }

    public int getTuoi() {
        LocalDate now = LocalDate.now();
        Period t = Period.between(ngaySinh, now);
        return t.getYears();
    }

    public String getHoDem() {
        return hoDem;
    }

    public void setHoDem(String hoDem) {
        this.hoDem = hoDem;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGioTinh() {
        return gioTinh;
    }

    public void setGioTinh(String gioTinh) {
        this.gioTinh = gioTinh;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void inThongTin() {
        System.out.printf("Mã người dùng: %s\n", id);
        System.out.printf("Họ và tên: %s\n", getHoVaTen());
        System.out.printf("Giới tính: %s\n", gioTinh);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.printf("Ngày sinh: %s (%d tuổi)\n", ngaySinh.format(dtf), getTuoi());
    }
}
