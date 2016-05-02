package stringsum;

/**
 * Created by jonat on 5/1/2016.
 */
public class StringSum {
    public static int sum(String num1, String num2) {
        return emptyOrInvalid(num1) + emptyOrInvalid(num2);
    }

    private static int emptyOrInvalid(String num) {
        try {
            return Integer.parseInt(num);
        } catch(NumberFormatException e) {
            return 0;
        }
    }
}
