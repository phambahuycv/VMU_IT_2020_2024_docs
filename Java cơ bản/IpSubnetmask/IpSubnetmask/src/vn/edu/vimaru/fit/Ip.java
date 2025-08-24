package vn.edu.vimaru.fit;

// Lớp trừu tượng là lớp có ít nhất 1 phương thức trừu tượng
public abstract class Ip {
    public Ip() {}

    // Phương thức trừu tượng
    public abstract String toString();

    // Phương thước thông thường
    public String protocol() {
        return "IP";
    }
}
