package vn.edu.vimaru.fit;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class XuLyDiemThi {
    ArrayList<DiemThi> ds = new ArrayList<>();


    public DiemThi parseRow(String row) {
        // MSV, X, Y, Z, Mark
        String[] cells = row.split(",");
        if (cells.length > 2) {
            String msv = cells[0].trim();
            String xStr = cells[1].trim();
            String yStr = cells[2].trim();
            float x = Float.valueOf(xStr);
            float y = Float.valueOf(yStr);
            DiemThi dt = new DiemThi(msv, x, y);
            return  dt;
        } else {
            // Không đủ số cột
            return null;
        }
    }

    public void docDuLieu(String filename) {
        try {
            FileReader fr = new FileReader(filename);
            Scanner fc = new Scanner(fr);
            // Đọc một dòng
            String line = fc.nextLine();

            while (fc.hasNextLine()) {
                String row = fc.nextLine().trim();
                DiemThi dt = parseRow(row);
                ds.add(dt);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void xuatDuLieu(String filename) {
        try {
            FileWriter fw = new FileWriter(filename);
            fw.write("MSV, X, Y, Z, Mark\n");
            for (DiemThi dt: ds) {
                StringBuffer buff = new StringBuffer();
                buff.append(dt.getMsv());
                buff.append(", ");
                buff.append(dt.getX());
                buff.append(", ");
                buff.append(dt.getY());
                buff.append(", ");
                buff.append(dt.getZ());
                buff.append(", ");
                buff.append(dt.getMark());
                buff.append("\n");
                fw.write(buff.toString());
            }
            fw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void thongKe() {
        HashMap<String, Integer> pdf = new HashMap<>();
        pdf.put("A", 0);
        pdf.put("A+", 0);
        pdf.put("B", 0);
        pdf.put("B+", 0);
        pdf.put("C", 0);
        pdf.put("C+", 0);
        pdf.put("D", 0);
        pdf.put("D+", 0);
        pdf.put("F", 0);
        for (DiemThi dt: ds) {
            String mark = dt.getMark();
            Integer v = pdf.get(mark);
            pdf.put(mark, v + 1);
        }

        System.out.println("Tần suất các điểm:");
        for (String k: pdf.keySet()) {
            Integer v = pdf.get(k);
            System.out.printf("%s: %d\n", k, v);
        }
    }
}
