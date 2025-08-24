package com.example.ki2_2022_2023;

import java.util.Date;

public class SinhVien {
    private int maSinhVien;
    private String hoTen;
    private Date ngaySinh;
    public SinhVien(int maSinhVien, String hoTen, Date ngaySinh) {
        this.maSinhVien = maSinhVien;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
    }

    public int getMaSinhVien() {
        return maSinhVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
}
