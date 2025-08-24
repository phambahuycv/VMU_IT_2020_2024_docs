package vn.edu.vimaru.fit;

// Một lớp là lớp trừu tượng nếu kế thừa giao diện mà không triển
// khai hết các phương thức định nghĩa trong giao diện (interface).
public abstract class NoParamTranformer implements Tranformer {
    public NoParamTranformer() {}
    public String getName() {
        return "No param tranformer";
    }
}
