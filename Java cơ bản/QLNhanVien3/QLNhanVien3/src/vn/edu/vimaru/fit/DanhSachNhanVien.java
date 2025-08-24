package vn.edu.vimaru.fit;

import java.util.ArrayList;
import java.util.Comparator;

public class DanhSachNhanVien {
    ArrayList<NhanVien> ds = new ArrayList<>();

    public DanhSachNhanVien() {}

    public void themNhanVien(NhanVien nv) {
        ds.add(nv);
    }

    public void xoaNhanVien(NhanVien nv) {
        ds.remove(nv);
    }

    public void suaNhanVien(NhanVien cu, NhanVien moi) {
        // Sửa thông tin
        if (!moi.getHoVaTen().isEmpty()) {
            cu.setHoVaTen(moi.getHoVaTen());
        }

        if (!moi.getGioiTinh().isEmpty()) {
            cu.setGioiTinh(moi.getGioiTinh());
        }

        if (!moi.getViTri().isEmpty()) {
            cu.setViTri(moi.getViTri());
        }

        if (moi.getNgaySinh() != null) {
            cu.setNgaySinh(moi.getNgaySinh());
        }

        if (moi.getNgayTuyenDung() != null) {
            cu.setNgayTuyenDung(moi.getNgayTuyenDung());
        }
    }

    public NhanVien timKiem(String hoTen) {
        for (NhanVien nv: ds) {
            if (nv.getHoVaTen().equals(hoTen)) {
                return nv;
            }
        }

        return null;
    }

    public void inDanhSach(int tuoiNhoNhat) {
        for (NhanVien nv: ds) {
            if (nv.getTuoi() > tuoiNhoNhat) {
                System.out.println("----------------------------");
                nv.inThongTin();
            }
        }
    }

    public void luu(String filename) {}

    public void nhap(String filename) {}

    public void sapXepTheoTuoi() {
        ds.sort(new Comparator<NhanVien>() {
            @Override
            public int compare(NhanVien o1, NhanVien o2) {
                return o1.getTuoi() - o2.getTuoi();
            }
        });
    }
}
