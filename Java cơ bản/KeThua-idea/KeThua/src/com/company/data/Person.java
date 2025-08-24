package com.company.data;

import java.util.Locale;

public class Person implements IInfo {
    String id;
    String hoTen;
    final String gioiTinh;

    public Person(String id, String hoTen, String gt) {
        setId(id);
        setHoTen(hoTen);
        this.gioiTinh = gt;
    }

    // Getter của id;
    public String getId() {
        return id;
    }

    // Setter cảu id;
    public void setId(String id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen.toUpperCase(Locale.ROOT);
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    @Override
    public void info() {
        System.out.printf("ID: %s\n", id);
        System.out.printf("Họ và tên: %s\n", hoTen);
        System.out.printf("Giới tính: %s\n", gioiTinh);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Person) {
            Person r = (Person) o;
            if (id.equals(r.id)
                && hoTen.equals(r.hoTen)
                    && gioiTinh.equals(r.gioiTinh)
            ) {
                return true;
            }
        }
        return false;
    }
}
