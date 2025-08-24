package vn.edu.vimaru.fit;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class XuLy {
    ArrayList<DiemThi> ds = new ArrayList<>();

    public void docDuLieu(String filename) {
        try {
            FileReader fr = new FileReader(filename);
            Scanner fc = new Scanner(fr);
            if (fc.hasNextLine()) {
                String header = fc.nextLine();
            }
            while (fc.hasNextLine()) {
                String line = fc.nextLine().trim();
                DiemThi dt = new DiemThi();
                dt.fromCsv(line);
                ds.add(dt);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void xuatDuLieu(String filename) {
        try {
            FileWriter fw = new FileWriter(filename);
            fw.write("MSV, X, Y, Z, Mark");
            for (DiemThi dt: ds) {
                fw.write("\n");
                fw.write(dt.toCsv());
            }
            fw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void thongKe() {
        HashMap<String, Integer> pdf = new HashMap<>();
        float tong = 0;
        for (DiemThi dt: ds) {
            String mark = dt.getMark();
            tong += dt.getZ();
            if (pdf.containsKey(mark)) {
                Integer v = pdf.get(mark);
                pdf.put(mark, v + 1);
            } else {
                pdf.put(mark, 1);
            }
        }

        System.out.println("Tần suất xuất hiện các điểm:");
        for (String mark: pdf.keySet()) {
            int count = pdf.get(mark);
            System.out.printf("%s: %d\n", mark, count);
        }
        float tb = tong / ds.size();
        System.out.printf("Điểm trung bình: %.2f\n", tb);
    }
}
