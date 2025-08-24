package vn.edu.vimaru.fit;

import sun.misc.GC;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static class Logger {
        FileWriter fw;

        public Logger(String filename)  {
            try {
                fw = new FileWriter(filename);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

        public void log(String line) {
            if (fw != null) {
                try {
                    fw.write(line);
                    fw.append("\n");
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }

        public void close() {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }

        // Phương thức finalize sẽ được gọi khi đối tượng được
        // giải phỏng bởi trình quản lý bộ nhớ (dọn rác)
        @Override
        public void finalize() {
            System.out.println("Logger finalize...");
        }
    }

    public static class DiaChiIp {
        Logger logger;

        public DiaChiIp() {
            logger = new Logger("log.txt");
        }

        public void docDuLieu(String filename) {
            try {
                FileReader fr = new FileReader(filename);
                Scanner sc = new Scanner(fr);
                // Đọc từng dòng
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    inThongTin(line);
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

        public void inThongTin(String line) {
            String[] parts = line.split("/");
            if (parts.length == 2) {
                String ip = parts[0];
                int prefixLength = Integer.valueOf(parts[1]);
                String subnetmask = subnetmaskFromPrefixLength(prefixLength);
                System.out.printf("Địa chỉ host: %s,\tSubnetmask: %s\n", ip, subnetmask);
                logger.log("Địa chỉ host: " + ip +
                        ",\t Subnetmask: " + subnetmask);
            } else {
                System.out.println("Dữ liệu không đúng định dạng");
            }
        }

        public String subnetmaskFromPrefixLength(int prefixLength) {
            String subnetmask = "";
            int octet = prefixLength / 8;
            int mod = 8 - prefixLength % 8;
            for (int i = 0; i < octet; i++) {
                subnetmask += "255.";
            }

            if (octet < 4) {
                subnetmask += Integer.toString((0xFF << mod) & 0xFF);
                for (int i = octet + 1; i < 4; i++) {
                    subnetmask += ".0";
                }
            } else {
                subnetmask = subnetmask.substring(0, subnetmask.length() - 1);
            }
            return subnetmask;
        }

        public void close() {
            logger.close();
        }
    }

    public static void proc() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên tệp tin: ");
        String filename = sc.nextLine().trim();
        DiaChiIp p = new DiaChiIp();
        p.docDuLieu(filename);
        System.out.println("Kết thúc.");
        p.close();
    }


    public static void main(String[] args) {
	    // write your code here
        proc();
        System.out.println("Gọi trình dọn rác...");
        System.gc();
        Ip ip;
        NoParamTranformer np;
        ip = new Ipv4();
    }
}
