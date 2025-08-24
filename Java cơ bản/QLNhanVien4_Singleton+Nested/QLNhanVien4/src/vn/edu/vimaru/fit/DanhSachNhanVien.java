package vn.edu.vimaru.fit;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Struct;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class DanhSachNhanVien {
    private static DanhSachNhanVien instance = null;

    private DanhSachNhanVien() {}

    public static DanhSachNhanVien getInstance() {
        if (instance != null) {
            return instance;
        } else {
            instance = new DanhSachNhanVien();
            return instance;
        }
    }



    public static final DateTimeFormatter DTF =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // Khai báo Nested class
    public static class NhanVien {
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

        public String toCsv() {
            StringBuffer buffer = new StringBuffer();
            buffer.append(hoTen);
            buffer.append(",");
            buffer.append(ngaySinh.format(DTF));
            buffer.append(",");
            buffer.append(gioiTinh);
            buffer.append(",");
            buffer.append(viTriViecLam);
            buffer.append(",");
            buffer.append(ngayTuyenDung.format(DTF));
            return buffer.toString();
        }

        public void fromCsv(String line) {
            String[] cols = line.split(",");
            if (cols.length == 5) {
                hoTen = cols[0];
                String ns = cols[1];
                ngaySinh = LocalDate.parse(ns, DTF);
                gioiTinh = cols[2];
                viTriViecLam = cols[3];
                String ntd = cols[4];
                ngayTuyenDung = LocalDate.parse(ntd, DTF);
            } else {
                System.out.println("Dữ liệu phải có 5 cột");
            }
        }
    }

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
        try {
            FileWriter fw = new FileWriter(filename);
            fw.write("Họ và tên,Ngày sinh,Giới tính,Vị trí việc làm,Ngày tuyển dụng\n");
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
            boolean skipHeader = true;
            while (fc.hasNextLine()) {
                String line = fc.nextLine().trim();
                if (skipHeader) {
                    skipHeader = false;
                    continue;
                }

                // Xử ý dữ liệu
                NhanVien nv = new NhanVien();
                nv.fromCsv(line);
                ds.add(nv);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void sapXepTheoTuoi() {
        ds.sort((NhanVien nv1, NhanVien nv2) -> {
            return nv1.getTuoi() - nv2.getTuoi();
        });
    }
}
