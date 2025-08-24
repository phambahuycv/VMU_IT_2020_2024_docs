package vn.edu.vimaru.fit;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        ArrayList<Integer> list = new ArrayList<>();

        try {
            FileReader fr = new FileReader("data.txt");
            Scanner sc = new Scanner(fr);
            while (sc.hasNextInt()) {
                Integer v = sc.nextInt();
                list.add(v);
            }

            System.out.printf(
                    "Mảng vừa đọc gồm có %d phần tử.\n",
                    list.size());
            for (Integer v: list) {
                System.out.printf("%d ", v);
            }
            System.out.println();
            System.out.printf("Phần tử đầu tiên là %d\n", list.get(0));
            ArrayList<Integer> sx = (ArrayList<Integer>) list.clone();
            // Sắp xếp giảm dần
            // Sử dụng anonymous class
            /*
            sx.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
             */
            // Sử dụng toán tử lambda
            sx.sort((Integer o1, Integer o2) -> {
                return o2 - o1;
            });
            System.out.println("Mảng được sắp xếp giảm dần.");
            for (int i = 0; i < sx.size(); i++) {
                int v = sx.get(i);
                System.out.printf("%d ", v);
            }
            System.out.println();
            // Xóa phần tử đầu tiên.
            sx.remove(0);
            // Xoá toàn bộ các phần tử.
            sx.clear();
        } catch (IOException ex) {
            System.out.println("Có lỗi khi xử lý tệp tin");
            System.out.println(ex.getMessage());
        }
    }
}
