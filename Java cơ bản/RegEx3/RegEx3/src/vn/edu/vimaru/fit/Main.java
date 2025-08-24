package vn.edu.vimaru.fit;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void kiemTraBieuThuc() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào 1 biểu thức: ");
        String line = sc.nextLine();
        String pattern = "^(\\d+)\\s*([+\\-*/])\\s*(\\d+)\\s*=\\s*(\\d+)$";
        System.out.println("Kiểm tra biểu thức pattern: " + pattern);
        line = line.trim();
        Pattern regex = Pattern.compile(pattern);
        Matcher m = regex.matcher(line);
        if (m.find()) {
            int a = Integer.valueOf(m.group(1));
            String phepToan = m.group(2);
            int b = Integer.valueOf(m.group(3));
            int kq = Integer.valueOf(m.group(4));
            int kqDung = kq;
            switch (phepToan) {
                case "+":
                    kqDung = a + b;
                    break;
                case "-":
                    kqDung = a - b;
                    break;
                case "*":
                    kqDung = a * b;
                    break;
                case "/":
                    kqDung = a / b;
                    break;
            }

            System.out.printf("%d %s %d = %d", a, phepToan, b, kq);
            if (kq == kqDung) {
                System.out.println(" là đúng.");
            } else {
                System.out.println(" là sai!");
            }
        } else {
            System.out.println("Biểu thức không hợp lệ");
        }
    }

    public static void timTu() {
        String pattern = "([\\S]+ng)[?\\.!:;,'\"\\s]+";
        //String pattern = "([\\S]+g)[?\\.!:;,'\"\\s]+";
        Pattern regEx = Pattern.compile(pattern);
        HashMap<String, Integer> demTu = new HashMap<>();
        try {
            FileReader fr = new FileReader("data.txt");
            Scanner sc = new Scanner(fr);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                Matcher m = regEx.matcher(line);
                while (m.find()) {
                    String kq = m.group(1).toLowerCase();
                    System.out.println(kq);
                    if (demTu.containsKey(kq)) {
                        Integer prev = demTu.get(kq);
                        Integer next = prev + 1;
                        demTu.put(kq, next);
                    } else {
                        demTu.put(kq, 1);
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("Số lần xuất hiện các từ:");
        for (String k: demTu.keySet()) {
            int v = demTu.get(k);
            System.out.printf("%s : %d\n", k, v);
        }
    }

    public static void timKiem(String text) {
        String pattern = "`([^`]+)`";
        Pattern regEx = Pattern.compile(pattern);
        Matcher m = regEx.matcher(text);
        System.out.println("Kết quả:");
        while (m.find()) {
            System.out.printf(
                    "Group() -> %s, Group(1) -> %s\n",
                    m.group(), m.group(1));
        }
    }

    public static void main(String[] args) {
	    // write your code here
        String pattern = "pattern";
        String text = "Đây là chuỗi ký tự có chứa từ `pattern`." +
                " Từ `pattern` là mẫu cho việc tìm kiếm." +
                " Từ `example` nằm trong dấu `quote`.";
        Pattern regEx = Pattern.compile(pattern);
        Matcher m = regEx.matcher(text);
        System.out.println("Kết quả: ");
        while (m.find()) {
            System.out.println(m.group());
        }
        timKiem(text);
        timTu();
        kiemTraBieuThuc();
    }
}
