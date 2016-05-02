package stringcalc;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jonat on 4/28/2016.
 */
public class StringCalculator {
    private List<String> delimiters = new ArrayList<>();

    public StringCalculator() {
    }

    public StringCalculator(String delimiter) {
        delimiters.add(delimiter);
    }

    public int add(String numbers) {
        int answer = 0;
        if (numbers != null && numbers.length() > 0) {
            if (numbers.length() > 1 && numbers.substring(0, 2).equals("//")) {
                // add 2 for the //
                int firstNewLineChar = 2 + processDelimiters(numbers.substring(2, numbers.length()));
                numbers = numbers.substring(firstNewLineChar + 1, numbers.length());
            }
            if (delimiters.size() == 0) {
                delimiters.add(",");
            }

            String[] splitNums = numbers.split(getMultipleDelimiterRegex(delimiters));
            List<Integer> negativeNumbers = new ArrayList<>();
            for (String num : splitNums) {
                int number = Integer.parseInt(num);
                if (number < 0) {
                    negativeNumbers.add(number);
                } else if (number < 1000 && negativeNumbers.size() == 0) {
                    answer += Integer.parseInt(num);
                }
            }
            if (negativeNumbers.size() > 0) {
                StringBuilder builder = new StringBuilder("Negative numbers not allowed:");
                for (int num : negativeNumbers) {
                    builder.append(" ").append(num);
                }
                throw new UnsupportedOperationException(builder.toString());
            }
        }
        return answer;
    }

    public int processDelimiters(String line) {
        if (line == null) {
            return 0;
        }
        int lastMatchIndex = 0;
        if (line != null && line.charAt(0) != '[') {
            delimiters.add(String.valueOf(line.charAt(0)));
            return 1;
        }
        Pattern p = Pattern.compile("\\[(.*?|\\s)\\]");

        Matcher matcher = p.matcher(line);
        while (matcher.find()) {
            delimiters.add(matcher.group().substring(1, matcher.group().length() - 1));
            lastMatchIndex = matcher.end();
        }
        return lastMatchIndex;
    }

    private String getMultipleDelimiterRegex(List<String> delimiters) {
        StringBuilder builder = new StringBuilder("");
        if (delimiters != null) {
            for (int i = 0; i < delimiters.size(); i++) {
                if (delimiters.get(i) != null) {
                    builder.append("\\Q").append(delimiters.get(i)).append("\\E");
                    if (i < delimiters.size() - 1) {
                        builder.append("|");
                    }
                }
            }
        }
        return builder.toString();
    }
}
