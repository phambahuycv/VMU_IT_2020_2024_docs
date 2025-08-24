package vn.edu.vimaru.fit;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void tinhToan() {
        String pattern = "\\(\\s*(\\d+(\\.\\d+)?)\\s*;\\s*(\\d+(\\.\\d+)?)\\s*\\)\\s*-->\\s*\\(\\s*(\\d+(\\.\\d+)?)\\s*;\\s*(\\d+(\\.\\d+)?)\\s*\\)";
        Pattern regex = Pattern.compile(pattern);

        try {
            FileReader fr = new FileReader("input.txt");
            Scanner sc = new Scanner(fr);
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                System.out.println("Read: " + line);
                Matcher m = regex.matcher(line);
                if (m.find()) {
                    float x1 = Float.valueOf(m.group(1));
                    float y1 = Float.valueOf(m.group(3));
                    float x2 = Float.valueOf(m.group(5));
                    float y2 = Float.valueOf(m.group(7));
                    float px = x2 - x1;
                    float py = y2 - y1;
                    double d = Math.sqrt(px * px + py * py);
                    System.out.printf("(%.3f ; %.3f) --> (%.3f ; %.3f) : %.3f\n", x1, y1, x2, y2, d);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void timTu() {
        String pattern = "(\\S+c)[\\s!:;,\\.\\?]";
        Pattern regex = Pattern.compile(pattern);
        HashMap<String, Integer> demTu = new HashMap<>();
        try {
            FileReader fr = new FileReader("data.txt");
            Scanner sc = new Scanner(fr);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                Matcher m = regex.matcher(line);
                while (m.find()) {
                    System.out.println(m.group(1));

                    //
                    String word = m.group(1);
                    if (demTu.containsKey(word)) {
                        Integer prev = demTu.get(word);
                        Integer next = prev + 1;
                        demTu.put(word, next);
                    } else {
                        demTu.put(word, 1);
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("Số lượng các từ:");
        for (String k: demTu.keySet()) {
            int v = demTu.get(k);
            System.out.printf("%s: %d\n", k, v);
        }
    }

    public static void vidu() {
        String pattern = "`(\\w+)`";
        String text = "Đây là chuỗi ký tự có từ `pattern`." +
                "Từ `pattern` là mẫu cần tìm kiếm." +
                " Thêm từ đặc biệt `today` ở trong kết quả.";
        Pattern regex = Pattern.compile(pattern);
        Matcher m = regex.matcher(text);
        System.out.println("Kết quả: ");
        while (m.find()) {
            System.out.printf("group() -> %s, group(1) -> %s\n",
                    m.group(), m.group(1));
        }
    }


    public static void main(String[] args) {
	    // write your code here
        vidu();
        timTu();
        tinhToan();
    }
}
