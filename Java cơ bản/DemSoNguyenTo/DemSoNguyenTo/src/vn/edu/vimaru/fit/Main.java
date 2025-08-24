package vn.edu.vimaru.fit;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static boolean kiemTraSoNguyenTo(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
	    // write your code here
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhập tên tệp tin: ");
            String filename = sc.nextLine().trim();
            FileReader fr = new FileReader(filename);
            Scanner fc = new Scanner(fr);
            int nNguyenTo = 0;
            while (fc.hasNextInt()) {
                int num = fc.nextInt();
                if (kiemTraSoNguyenTo(num)) {
                    nNguyenTo++;
                }
            }
            System.out.printf("Số lượng số nguyên tố: %d\n", nNguyenTo);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
