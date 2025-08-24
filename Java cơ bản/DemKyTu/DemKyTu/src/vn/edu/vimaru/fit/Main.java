package vn.edu.vimaru.fit;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static class DemKyTu {
        HashMap<Integer, Integer> pdf;
        public DemKyTu() {
            pdf = new HashMap<>();
        }

        public void xuLy(String line) {
            // Tách các từ
            String[] words = line.split("\\s|[\\.?,:;!\"'`{}()+*/=]");
            for (String w: words) {
                if (w.isEmpty()) {
                    continue;
                }
                System.out.println(w);
                int len = w.length();
                if (pdf.containsKey(len)) {
                    int v = pdf.get(len);
                    pdf.put(len, v + 1);
                } else {
                    pdf.put(len, 1);
                }
            }
        }

        public void inKetQua() {
            for (Integer k: pdf.keySet()) {
                Integer v = pdf.get(k);
                System.out.printf("%d -> %d\n", k, v);
            }
        }
    }

    public static void main(String[] args) {
        DemKyTu demKyTu = new DemKyTu();
	    // write your code here
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhập tên tệp tin: ");
            String filename = sc.nextLine().trim();
            FileReader fr = new FileReader(filename);
            Scanner fc = new Scanner(fr);
            while (fc.hasNextLine()) {
                String line = fc.nextLine().trim();
                demKyTu.xuLy(line);
            }
            //
            fc.close();
            fr.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("PDF:");
        demKyTu.inKetQua();
    }
}
