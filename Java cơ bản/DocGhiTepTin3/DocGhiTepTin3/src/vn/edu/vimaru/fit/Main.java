package vn.edu.vimaru.fit;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void doicho(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void sapxep(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    doicho(arr, i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
	    // write your code here
        ArrayList<Integer> list = new ArrayList<>();
        try {
            FileReader fr = new FileReader("data.txt");
            Scanner sc = new Scanner(fr);
            int length = sc.nextInt();
            int[] arr = new int[length];
            for (int i = 0; i < length; i++) {
                if (sc.hasNextInt()) {
                    int v = sc.nextInt();
                    arr[i] = v;
                    if (v % 2 == 0) {
                        list.add(v);
                    }
                } else {
                    System.out.println("Không có đủ số phần từ của mảng");
                    break;
                }
            }

            System.out.println("Mảng vừa đọc được: ");
            for (int v: arr) {
                System.out.print(v);
                System.out.print(" ");
            }
            System.out.println();

            // Sắp xếp mảng theo thứ tự tăng dần
            sapxep(arr);

            System.out.println("Mảng vừa sau khi sắp xếp tăng dần: ");
            for (int v: arr) {
                System.out.print(v);
                System.out.print(" ");
            }
            System.out.println();

            FileWriter fw = new FileWriter("output.txt");
            fw.write(Integer.toString(arr.length));
            fw.write("\n");
            for (int i = 0; i < arr.length; i++) {
                int v = arr[i];
                fw.write(Integer.toString(v));
                if (i != arr.length - 1) {
                    fw.write(" ");
                }
            }
            fw.close();

            System.out.println("Danh sách các số chẵn");
            for (Integer v: list) {
                System.out.println(v);
            }
            System.out.println("Các phần tử ở vị trí chẵn trong list");
            list.add(0, 12345);
            for (int i = 0; i < list.size(); i += 2) {
                int v = list.get(i);
                System.out.println(v);
            }
            // Sắp xếp danh sách
            ArrayList<Integer> origin;
            origin = (ArrayList<Integer>) list.clone();
            list.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            // Cách viết sử dụng toán từ lambda
            list.sort((Integer o1, Integer o2) -> {
                return o2 - o1;
            });
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i));
                System.out.print(" ");
            }
            System.out.println();
            System.out.println("Mảng ban đầu");
            for (Integer v: origin) {
                System.out.print(v);
                System.out.print(" ");
            }
            System.out.println();
        } catch (IOException ex) {
            System.out.println("Có lỗi khi đọc tệp tin");
            System.out.println(ex);
        } catch (Exception ex) {
            System.out.println("Có lỗi lạ xảy ra!");
        }
    }
}
