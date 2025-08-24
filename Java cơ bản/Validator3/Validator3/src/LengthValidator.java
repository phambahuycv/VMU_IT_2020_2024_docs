public class LengthValidator implements Validator {
    private int m, n;

    public LengthValidator(int m, int n) {
        this.m = m;
        this.n = n;
    }

    @Override
    public boolean validate(String input) {
        if (input.length() < m) {
            return false;
        }

        if (input.length() > n) {
            return false;
        }

        return true;
    }
}
