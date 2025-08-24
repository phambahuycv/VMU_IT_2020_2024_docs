package com.company;

public class Main {

    public static int chia(int a, int b) throws ChiaCho0, PhepChia00 {
        if (b == 0) {
            if (a == 0) {
                throw new PhepChia00();
            }

            ChiaCho0 chiaCho0 = new ChiaCho0();
            throw chiaCho0;
        }
        return a/b;
    }

    public static void main(String[] args) {
	    // write your code here
        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 3; b++) {
                try {
                    System.out.printf("Phep chia %d cho %d có kết quả: ", a, b);
                    System.out.println(chia(a, b));
                    if (a + b > 2) {
                        return;
                    }
                } catch (ChiaCho0 ex) {
                    System.out.println("Lỗi chia cho 0");
                    System.out.println(ex.getMessage());
                } catch (PhepChia00 ex) {
                    System.out.println("Lỗi phép chia 0 cho 0");
                    System.out.println(ex.getMessage());
                } finally {
                    System.out.println("Khối xử lý finally");
                }
                System.out.println("Xử lý xong phép chia");
            }
        }
    }
}
