public class NgayThangNamValidator implements Validator {
    private final String pattern = "^[\\d+]+(?:/|-)[\\d+]+(?:/|-)[\\d+]+$";

    @Override
    public boolean validate(String input) {
        return input.matches(pattern);
    }
}
