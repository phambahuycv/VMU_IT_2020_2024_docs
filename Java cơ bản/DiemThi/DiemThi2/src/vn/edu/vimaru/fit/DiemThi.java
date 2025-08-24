package vn.edu.vimaru.fit;

public class DiemThi {
    float x, y;
    String msv;

    public DiemThi(String msv) {
        this(msv, 0.0f, 0.0f);
    }

    public DiemThi(String msv, float x, float y) {
        this.msv = msv;
        this.x = x;
        this.y = y;
    }

    public String getMsv() {
        return msv;
    }

    public void setMsv(String msv) {
        this.msv = msv;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        if (x >= 4 && y >= 4) {
            return (x + y)/2;
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
