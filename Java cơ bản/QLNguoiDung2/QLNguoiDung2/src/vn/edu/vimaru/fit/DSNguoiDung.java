package vn.edu.vimaru.fit;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class DSNguoiDung {
    ArrayList<NguoiDung> ds = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public DSNguoiDung() {
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
            p.setGioTinh(gioTinh);
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
}
