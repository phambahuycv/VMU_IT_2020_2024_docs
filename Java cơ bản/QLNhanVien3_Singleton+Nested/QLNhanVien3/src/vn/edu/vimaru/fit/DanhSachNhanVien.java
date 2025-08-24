package vn.edu.vimaru.fit;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class DanhSachNhanVien {
    public static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // Khai báo biến chứa đối tượng của danh sách nhân viên
    private static DanhSachNhanVien instance = null;

    public static class NhanVien {
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
            System.out.printf("Ngày sinh: %s (%d tuổi)\n", ngaySinh.format(dtf), getTuoi());
            System.out.printf("Giới tính: %s\n", gioiTinh);
            System.out.printf("Vị trí công việc: %s\n", viTri);
            System.out.printf("Ngày tuyển dụng: %s\n", ngayTuyenDung.format(dtf));
        }

        public String toCsv() {
            StringBuffer buffer = new StringBuffer();
            buffer.append(hoVaTen);
            buffer.append(",");
            buffer.append(ngaySinh.format(dtf));
            buffer.append(",");
            buffer.append(gioiTinh);
            buffer.append(",");
            buffer.append(viTri);
            buffer.append(",");
            buffer.append(ngayTuyenDung.format(dtf));
            return  buffer.toString();
        }

        public void fromCsv(String line) {
            String[] cols = line.split(",");
            if (cols.length == 5) {
                hoVaTen = cols[0];
                String ns = cols[1];
                ngaySinh = LocalDate.parse(ns, dtf);
                gioiTinh = cols[2];
                viTri = cols[3];
                String ntd = cols[4];
                ngayTuyenDung = LocalDate.parse(ntd, dtf);
            } else {
                System.out.println("Dữ liệu không đúng định dạng");
            }
        }
    }

    ArrayList<NhanVien> ds = new ArrayList<>();

    private DanhSachNhanVien() {}

    public static DanhSachNhanVien getInstance() {
        if (instance != null) {
            return instance;
        } else {
            instance = new DanhSachNhanVien();
            return instance;
        }
    }

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

    public void luu(String filename) {
        try {
            FileWriter fw = new FileWriter(filename);
            for (NhanVien p: ds) {
                fw.write(p.toCsv());
                fw.write("\n");
            }
            fw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void nhap(String filename) {
        try {
            FileReader fr = new FileReader(filename);
            Scanner fc = new Scanner(fr);
            while (fc.hasNextLine()) {
                String line = fc.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }
                NhanVien nv = new NhanVien();
                nv.fromCsv(line);
                ds.add(nv);
            }
            fc.close();
            fr.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void sapXepTheoTuoi() {
        ds.sort(new Comparator<NhanVien>() {
            @Override
            public int compare(NhanVien o1, NhanVien o2) {
                return o1.getTuoi() - o2.getTuoi();
            }
        });
    }
}
