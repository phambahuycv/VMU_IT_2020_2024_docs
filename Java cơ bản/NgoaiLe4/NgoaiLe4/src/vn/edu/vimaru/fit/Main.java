package vn.edu.vimaru.fit;

import java.util.Scanner;

public class Main {

    public static int chia(int a, int b) throws Chia0, PhepChia00 {
        if (b == 0) {
            if (a == 0) {
                PhepChia00 th = new PhepChia00();
                throw th;
            }
            throw new Chia0();
        }
        return a / b;
    }

    public static void main(String[] args) {
	    // write your code here
        Scanner sc = new Scanner(System.in);

        for (;;) {
            System.out.print("Nhập vào 2 số nguyên: ");
            int a = sc.nextInt();
            int b = sc.nextInt();

            try {
                int kq = chia(a, b);
                System.out.printf("chia(%d, %d) -> %d\n", a, b, kq);
                if (kq == 1) {
                    break;
                }
                if (kq == 2) {
                    continue;
                }
            } catch (Chia0 ex) {
                System.out.println("Có lỗi khi gọi phương thức chia()");
                System.out.println(ex.getMessage());
            } catch (PhepChia00 ex) {
                System.out.println("Lỗi 0/0");
                System.out.println(ex);
            } finally {
                System.out.println("Khối finally!");
            }
            System.out.println("Đã xử lý xong phép chia");
        }
        System.out.println("Kết thúc chương trình");
    }
}
