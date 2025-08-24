package vn.edu.vimaru.fit;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class DSNguoiDung {
    public static DSNguoiDung instance = null;

    // Lớp NguoiDung được khai báo bên trong lớp DSNguoiDung
    // Inner class
    // public class NguoiDung {

    // Nested Class
    public static class NguoiDung {
        String hoDem;
        String ten;
        String id;
        String gioiTinh;
        LocalDate ngaySinh;

        public NguoiDung() {

        }

        public NguoiDung(String id,
                         String hoDem, String ten,
                         String gioiTinh,
                         LocalDate ngaySinh) {
            this.id = id;
            this.hoDem = hoDem;
            this.ten = ten;
            this.gioiTinh = gioiTinh;
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

        public String getGioiTinh() {
            return gioiTinh;
        }

        public void setGioiTinh(String gioiTinh) {
            this.gioiTinh = gioiTinh;
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
            System.out.printf("Giới tính: %s\n", gioiTinh);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            System.out.printf("Ngày sinh: %s (%d tuổi)\n", ngaySinh.format(dtf), getTuoi());
        }

        public String toCsvRow() {
            StringBuffer buffer = new StringBuffer();
            buffer.append(id);
            buffer.append(",");
            buffer.append(hoDem);
            buffer.append(",");
            buffer.append(ten);
            buffer.append(",");
            buffer.append(gioiTinh);
            buffer.append(",");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            buffer.append(ngaySinh.format(dtf));
            return buffer.toString();
        }

        public void fromCsvRow(String row) {
            String[] cell = row.split(",");
            if (cell.length > 0) {
                id = cell[0];
            }

            if (cell.length > 1) {
                hoDem = cell[1];
            }

            if (cell.length > 2) {
                ten = cell[2];
            }

            if (cell.length > 3) {
                gioiTinh = cell[3];
            }

            if (cell.length > 4) {
                String ns = cell[4];
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                try {
                    ngaySinh = LocalDate.parse(ns, dtf);
                } catch (Exception ex) {
                    System.out.println("Ngày sinh không hợp lệ");
                }
            }
        }
    }

    ArrayList<NguoiDung> ds = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    // Đảm bảo lớp người dùng không thể gọi new từ bên ngoài
    private DSNguoiDung() {
    }

    // Phương thức lấy đối tượng DSNguoiDung (Singleton Class)
    public static DSNguoiDung getInstance() {
        if (instance != null) {
            return instance;
        } else {
            instance = new DSNguoiDung();
            return instance;
        }
    }

    public void themNguoiDung() {
        System.out.println("Thêm người dùng mới: ");
        System.out.print("Nhập họ và đệm: ");
        String hoDem = sc.nextLine();
        System.out.print("Nhập tên: ");
        String ten = sc.nextLine();
        System.out.print("Nhập mã người dùng: ");
        String id = sc.nextLine();
        System.out.print("Nhập giới tính: ");
        String gioTinh = sc.nextLine();
        System.out.print("Nhập ngày tháng năm sinh (dd/mm/yyyy): ");
        String ngaySinh = sc.nextLine();

        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate ns = LocalDate.parse(ngaySinh, dtf);

            NguoiDung p = new NguoiDung(
                    id,
                    hoDem, ten,
                    gioTinh,
                    ns
            );
            ds.add(p);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void suaNguoiDung(NguoiDung p) {
        System.out.println("Sửa thông tin người dùng: ");
        System.out.print("Nhập họ và đệm: ");
        String hoDem = sc.nextLine();
        if (!hoDem.isEmpty()) {
            p.setHoDem(hoDem);
        }
        System.out.print("Nhập tên: ");
        String ten = sc.nextLine();
        if (!ten.isEmpty()) {
            p.setTen(ten);
        }
        System.out.print("Nhập mã người dùng: ");
        String id = sc.nextLine();
        if (!id.isEmpty()) {
            p.setId(id);
        }
        System.out.print("Nhập giới tính: ");
        String gioTinh = sc.nextLine();
        if (!gioTinh.isEmpty()) {
            p.setGioiTinh(gioTinh);
        }
        System.out.print("Nhập ngày tháng năm sinh (dd/mm/yyyy): ");
        String ngaySinh = sc.nextLine();
        if (!ngaySinh.isEmpty()) {
            try {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate ns = LocalDate.parse(ngaySinh, dtf);
                p.setNgaySinh(ns);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void xoaNguoiDung(NguoiDung p) {
        ds.remove(p);
    }

    public NguoiDung timKiem(String hoVaTen) {
        for (NguoiDung p: ds) {
            if (hoVaTen.equals(p.getHoVaTen())) {
                return p;
            }
        }
        return null;
    }

    public void timKiem() {
        System.out.print("Nhập họ và tên của người muốn tìm: ");
        String hoTen = sc.nextLine();
        NguoiDung p = timKiem(hoTen);
        System.out.println("Tìm kiếm thấy người dùng:");
        p.inThongTin();
    }

    public void xoaNguoiDung() {

    }

    public void inDanhSach() {
        for (NguoiDung p: ds) {
            System.out.println("----------------------");
            p.inThongTin();
        }
    }

    public void luu(String filename) {
        try {
            FileWriter fw = new FileWriter(filename);
            for (NguoiDung p: ds) {
                fw.write(p.toCsvRow());
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
                String row = fc.nextLine().trim();
                if (row.isEmpty()) {
                    continue;
                }
                NguoiDung nd = new NguoiDung();
                nd.fromCsvRow(row);
                ds.add(nd);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
