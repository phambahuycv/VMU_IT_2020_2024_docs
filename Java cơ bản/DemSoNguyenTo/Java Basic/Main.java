package vn.edu.vimaru.fit;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] mang = new int[1000];
        int soLuong = 0;
        System.out.println("Nhập số lượng phần từ: ");
        soLuong = sc.nextInt();
        for (int i = 0; i < soLuong; i++) {
            System.out.println("Nhập phần tử thứ " + i);
            mang[i] = sc.nextInt();
        }
        System.out.println("Các số nguyên tố");
        for (int i = 0; i < soLuong; i++) {
            if (soNguyenTo(mang[i])) {
                System.out.println(mang[i]);;
            }
        }
    }

    static boolean soNguyenTo(int x) {
        if (x < 2) {
            return false;
        }

        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
