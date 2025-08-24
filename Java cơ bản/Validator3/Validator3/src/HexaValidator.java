public class HexaValidator implements Validator {
    private final String pattern = "^[0-9a-fA-F]+$";
    @Override
    public boolean validate(String input) {
        return input.matches(pattern);
    }
}
