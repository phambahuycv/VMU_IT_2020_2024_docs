public class AlphabetValidator implements Validator {
    private final String pattern = "^[a-zA-Z0-9]+$";

    @Override
    public boolean validate(String input) {
        return input.matches(pattern);
    }
}
