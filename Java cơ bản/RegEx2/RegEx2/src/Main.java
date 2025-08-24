import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static final String tenNguoiDungPattern =
            "^[a-zA-Z][a-zA-Z0-9_\\.\\-]*$";

    public static void kiemTraTenNguoiDung() {
        System.out.print("Nhâp tên người dùng: ");
        Pattern regex = Pattern.compile(tenNguoiDungPattern);
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();
        Matcher m = regex.matcher(username);
        if (m.find()) {
            System.out.printf("Tên người dùng `%s` hợp lệ\n", username);
        } else {
            System.out.printf("Tên người dùng `%s` không hợp lệ!\n", username);
        }
    }

    public static void timChuoi() {
        System.out.println("Tìm chuỗi ký tự nằm giữa ( và )");
        String pattern = "\\((.+)\\)";
        Pattern regEx = Pattern.compile(pattern);
        System.out.printf("Pattern: %s\n", pattern);
        System.out.println("Nhập vào một chuỗi ký tự:");
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        System.out.println("Kết quả: ");
        Matcher m = regEx.matcher(line);
        while (m.find()) {
            String kq = m.group(1);
            String full = m.group(0);
            System.out.printf("%s -> Kết quả: %s\n", full, kq);
        }
    }

    public static void main(String[] args) {
	    // write your code here
        String pattern = "[0-9]+";
        HashMap<String, Integer> pdf = new HashMap<>();
        // Tạo đối tượng pattern.
        Pattern regEx = Pattern.compile(pattern);
        // Tạo đối tượng kết quả (matcher)
        String line = "1 + 283 = 284, có 10 con gà và 25 con vịt" +
                " và 10 quả trứng ngỗng. " +
                "Ngoài ra có 25 con mèo với 70 con mèo con";
        Matcher m = regEx.matcher(line);

        System.out.println("Pattern: " + pattern);
        System.out.println("Input String: " + line);
        System.out.println("Kết quả:");
        while (m.find()) {
            System.out.println(m.group());
            if (pdf.containsKey(m.group())) {
                Integer n = pdf.get(m.group());
                pdf.put(m.group(), n + 1);
            } else {
                pdf.put(m.group(), 1);
            }
        }

        for (String k: pdf.keySet()) {
            Integer v = pdf.get(k);
            System.out.printf("%s: %d\n", k, v);
        }

        timChuoi();
        kiemTraTenNguoiDung();
    }
}
