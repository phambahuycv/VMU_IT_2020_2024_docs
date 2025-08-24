package com.company;

import java.util.Scanner;

public class Main {

    public static int chia(int a, int b) throws Chia0, PhepChia00 {
        if (b == 0) {
            if (a == 0) {
                PhepChia00 ex = new PhepChia00();
                throw ex;
            }
            throw new Chia0();
        }

        return a / b;
    }

    public static void main(String[] args) {
	    // write your code here
        // System.in
        Scanner sc = new Scanner(System.in);
        for (;;) {
            System.out.print("Nhập 2 số nguyên: ");
            int a = sc.nextInt();
            int b = sc.nextInt();
            try {
                int kq = chia(a, b);
                System.out.printf("chia(%d, %d) -> %d\n", a, b, kq);
                if (kq == 0) {
                    break;
                }
            } catch (Chia0 ex) {
                System.out.println("Có lỗi xảy ra.");
                System.out.println(ex.getMessage());
            } catch (PhepChia00 ex) {
                System.out.println("Xuất hiện lỗi 0/0");
                System.out.println(ex.getMessage());
            } finally {
                System.out.println("Xử lý xong phép chia");
            }
            System.out.println("Hoàn tất khối try-catch");
        }
    }
}
