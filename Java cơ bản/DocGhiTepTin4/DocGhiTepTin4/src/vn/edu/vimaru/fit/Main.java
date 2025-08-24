package vn.edu.vimaru.fit;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void sapxep(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
	    // write your code here
        try {
            FileReader fr = new FileReader("data.txt");
            Scanner sc = new Scanner(fr);

            System.out.println("Nội dung tệp tin:");
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            System.out.println("-------------EOF-------------");
            sc.close();
            fr.close();
            //
            fr = new FileReader("data.txt");
            sc = new Scanner(fr);
            int length = sc.nextInt();
            int[] arr = new int[length];
            for (int i = 0; i < length; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.println("Mảng đọc được là: ");
            for (int v: arr) {
                System.out.printf("%d ", v);
            }
            System.out.println();

            //
            sapxep(arr);

            System.out.println("Mảng sau sắp xếp tăng dần:");
            for (int v: arr) {
                System.out.printf("%d ", v);
            }
            System.out.println();

            // Ghi ra tệp tin output.txt
            FileWriter fw = new FileWriter("output.txt");
            for (int i = 0; i < length; i++) {
                int v = arr[i];
                fw.write(Integer.toString(v));
                fw.write(" ");
            }
            fw.close();
        } catch (IOException ex) {
            System.out.println("Có lỗi khi xử lý tệp tin");
            System.out.println(ex.getMessage());
        }
    }
}
