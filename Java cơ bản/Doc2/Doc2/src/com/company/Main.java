package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        System.out.println("Đọc dữ liệu từ bàn phím sử dụng System.in");
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào một chuỗi ký tự: ");
        String line = sc.nextLine();
        System.out.print("Chuỗi ký tự vừa nhập vào: ");
        System.out.println(line);
        System.out.print("Nhập một số nguyên: ");
        int a = sc.nextInt();
        System.out.printf("Số nguyên vừa nhập vào: %d\n", a);
        System.out.print("Nhập vào số thực: ");
        float f = sc.nextFloat();
        System.out.printf("Số vừa nhập vào: %f\n", f);
        System.out.print("Nhập vào 3 số thực: ");
        float f1 = sc.nextFloat();
        float f2 = sc.nextFloat();
        float f3 = sc.nextFloat();
        float sum = f1 + f2;
        System.out.printf("%f + %f = %f\n", f1, f2, sum);
        if (sum == f3) {
            System.out.printf("%f == %f\n", sum, f3);
        } else {
            System.out.printf("%f <> %f\n", sum, f3);
        }
        System.out.print("Nhập vào chuỗi kỹ tụ gồm các chữ số: ");
        String str = sc.nextLine();
        while (str.isEmpty()) {
            str = sc.nextLine();
        }
        System.out.printf("Chuỗi ký tự vừa nhập: %s\n", str);
        int num = Integer.valueOf(str);
        if (num % 2 == 0) {
            System.out.println("Số vừa nhập vào là số chắn");
        } else {
            System.out.println("Số vừa nhập vào là số lẻ");
        }

        String numStr = Integer.toString(num);
        System.out.printf("Số vừa nhập có %d chữ số.", numStr.length());
    }
}
