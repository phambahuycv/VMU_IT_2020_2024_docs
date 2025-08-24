package com.example.ki2_2022_2023;

public class SanPham0410 {
    private Integer maSanPham;
    private String tenSanPham;
    private String mauSac;
    public SanPham0410(Integer maSanPham, String tenSanPham, String mauSac) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.mauSac = mauSac;
    }

    public Integer getMaSanPham() {
        return maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public String getMauSac() {
        return mauSac;
    }
}
