package vn.edu.vimaru.fit;

public class DiemThi {
    float x, y;
    String msv;

    public DiemThi() {}

    public DiemThi(String msv, float x, float y) {
        this.msv = msv;
        this.x = x;
        this.y = y;
    }

    public void fromCsv(String row) {
        String[] cells = row.split(",");
        if (cells.length >= 3) {
            msv = cells[0].trim();
            x = Float.valueOf(cells[1].trim());
            y = Float.valueOf(cells[2].trim());
        } else {
            System.out.println("Dữ liệu không đúng định dạng");
        }
    }

    public String toCsv() {
        StringBuffer sb = new StringBuffer();
        sb.append(msv);
        sb.append(", ");
        sb.append(x);
        sb.append(", ");
        sb.append(y);
        sb.append(", ");
        sb.append(getZ());
        sb.append(", ");
        sb.append(getMark());
        return sb.toString();
    }

    public float getZ() {
        if (x >= 4 && y >= 4) {
            return (x + y) / 2;
        } else {
            return 0;
        }
    }

    public String getMark() {
        float z = getZ();
        if (z < 4) {
            return "F";
        } else if (z < 5) {
            return "D";
        } else if (z < 5.5) {
            return "D+";
        } else if (z < 6.5) {
            return "C";
        } else if (z < 7) {
            return "C+";
        } else if (z < 8) {
            return "B";
        } else if (z < 8.5) {
            return "B+";
        } else if (z < 9.5) {
            return "A";
        } else {
            return "A+";
        }
    }
}
