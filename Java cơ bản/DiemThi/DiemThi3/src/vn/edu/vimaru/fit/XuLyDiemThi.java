package vn.edu.vimaru.fit;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class XuLyDiemThi {
    ArrayList<DiemThi> ds = new ArrayList<>();

    public void docDuLieu(String filename) {
        try {
            FileReader fr = new FileReader(filename);
            Scanner fc = new Scanner(fr);
            String header = fc.nextLine().trim();
            while (fc.hasNextLine()) {
                String row = fc.nextLine().trim();
                DiemThi dt = new DiemThi();
                dt.fromCsv(row);
                ds.add(dt);
            }

            // Đóng tệp tin
            fc.close();
            fr.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void luuDuLieu(String filename) {
        try {
            FileWriter fw = new FileWriter(filename);
            fw.write("MSV, X, Y, Z, Mark");
            for (int i = 0; i < ds.size(); i++) {
                String row = ds.get(i).toCsv();
                fw.write("\n");
                fw.write(row);
            }
            // Đóng tệp tin lại
            fw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void thongKe() {
        HashMap<String, Integer> pdf = new HashMap<>();
        pdf.put("F", 0);
        pdf.put("D", 0);
        pdf.put("D+", 0);
        pdf.put("C", 0);
        pdf.put("C+", 0);
        pdf.put("B", 0);
        pdf.put("B+", 0);
        pdf.put("A", 0);
        pdf.put("A+", 0);

        for (DiemThi dt: ds) {
            String mark = dt.getMark();
            Integer v = pdf.get(mark);
            pdf.put(mark, v + 1);
        }

        System.out.println("Tần suất các điểm:");
        for (String key: pdf.keySet()) {
            System.out.printf("%s: %d\n", key, pdf.get(key));
        }

        // Tính điểm trung bình
        float tong = 0;
        for (DiemThi dt: ds) {
            tong += dt.getZ();
        }
        float tb = tong / ds.size();
        System.out.printf("Điể trung bình: %.3f\n", tb);
    }
}
