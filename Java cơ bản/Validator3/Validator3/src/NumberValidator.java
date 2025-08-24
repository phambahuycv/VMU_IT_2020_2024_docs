import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberValidator implements Validator {
    private final String pattern = "^\\d+$";

    @Override
    public boolean validate(String input) {
        return input.matches(pattern);
    }
}
