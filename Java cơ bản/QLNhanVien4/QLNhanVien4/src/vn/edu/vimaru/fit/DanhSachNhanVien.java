package vn.edu.vimaru.fit;

import java.sql.Struct;
import java.util.ArrayList;

public class DanhSachNhanVien {
    ArrayList<NhanVien> ds = new ArrayList<>();

    public void themNhanVien(NhanVien nv) {
        ds.add(nv);
    }

    public void suaNhanVien(NhanVien cu, NhanVien moi) {
        if (!moi.getHoTen().isEmpty()) {
            cu.setHoTen(moi.getHoTen());
        }

        if (!moi.getGioiTinh().isEmpty()) {
            cu.setGioiTinh(moi.getGioiTinh());
        }

        if (!moi.getViTriViecLam().isEmpty()) {
            cu.setViTriViecLam(moi.getViTriViecLam());
        }

        if (moi.getNgaySinh() != null) {
            cu.setNgaySinh(moi.getNgaySinh());
        }

        if (moi.getNgayTuyenDung() != null) {
            cu.setNgayTuyenDung(moi.getNgayTuyenDung());
        }
    }

    public void xoaNhanVien(NhanVien nv) {
        ds.remove(nv);
    }

    public NhanVien timKiem(String hoTen) {
        for (NhanVien nv: ds) {
            if (nv.getHoTen().equals(hoTen)) {
                return nv;
            }
        }

        return null;
    }

    public void inDanhSach(int tuoi) {
        for (NhanVien nv: ds) {
            System.out.println("-----------------------------");
            if (nv.getTuoi() > tuoi) {
                nv.inThongTin();
            }
        }
    }

    public void luu(String filename) {
        System.out.println("Tính năng đang phát triển");
    }

    public void nhap(String filename) {
        System.out.println("Tính năng đang phát triển");
    }
}
