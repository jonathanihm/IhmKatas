package romannumerals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by jonat on 4/29/2016.
 */
public enum NumeralEnum {
    I("I", 1),
    V("V", 5),
    X("X", 10),
    L("L", 50),
    C("C", 100),
    D("D", 500),
    M("M", 1000);

    private String key;
    private int value;


    private NumeralEnum(String key, int value) {
        this.key= key;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }

    public NumeralEnum prev() {
        NumeralEnum[] enums = NumeralEnum.class.getEnumConstants();
        if (this.ordinal() == enums.length) {
            return null;
        }
        return enums[(this.ordinal() - 1) % enums.length];
    }

    public NumeralEnum next() {
        NumeralEnum[] enums = NumeralEnum.class.getEnumConstants();
        if (this.ordinal() == enums.length) {
            return null;
        }
        return enums[(this.ordinal() + 1) % enums.length];
    }

    // static operations
    public static String convertToRoman(int number) {
        if (number < 0) {
            throw new UnsupportedOperationException("Negative numbers not supported");
        } else if (number >= 4000) {
            throw new UnsupportedOperationException("Number too large to express for this application");
        }
        return convertArabicGroup(number);
    }

    private static String convertArabicGroup(int num) {
        StringBuilder builder = new StringBuilder("");
        if (num == 0) {
            return builder.toString();
        }
        NumeralEnum e = getLargestNumeral(num);
        if (startsWithOne(e)) {
            int bound = 4 * e.getValue();
            if (num >= bound) {
                builder.append(e.getKey()).append(e.next().getKey());
                builder.append(convertArabicGroup(num - bound));
            } else {
                int repeatNumeral = num / e.getValue();
                for (int i = 0; i < repeatNumeral; i++) {
                    builder.append(e.getKey());
                }
                builder.append(convertArabicGroup(num % e.getValue()));
            }
        } else {
            int bound = 9 * e.prev().getValue();
            if (num >= bound) {
                builder.append(e.prev().getKey()).append(e.next().getKey());
                builder.append(convertArabicGroup(num - bound));
            } else {
                builder.append(e.getKey());
                builder.append(convertArabicGroup(num - e.getValue()));
            }
        }
        return builder.toString();
    }

    public static int convertToArabic(String roman) {
        int sum = 0;
        for (int i = 0; i < roman.length(); i++){
            NumeralEnum current = NumeralEnum.get(roman.substring(i, i + 1));
            if (startsWithOne(current)) {
                if (i < roman.length() - 1) {
                    NumeralEnum peek = NumeralEnum.get(roman.substring(i + 1, i + 2));
                    if (!startsWithOne(peek) && peek.getValue() > current.getValue()) {
                        sum += (peek.getValue() - current.getValue());
                        i++;
                    } else if (current.next().next() == peek) {
                        sum += (peek.getValue() - current.getValue());
                        i++;
                    } else {
                        sum += current.getValue();
                    }
                } else {
                    sum += current.getValue();
                }
            } else {
                sum += current.getValue();
            }
        }
        return sum;
    }


    public static NumeralEnum getLargestNumeral(int num) {
        List<NumeralEnum> enums = Arrays.asList(NumeralEnum.class.getEnumConstants());
        Collections.reverse(enums);
        for (NumeralEnum numeral :enums) {
            if (num >= numeral.getValue()) {
                return numeral;
            }
        }
        return I;
    }

    public static boolean startsWithOne(NumeralEnum e) {
        return e == I || e == X || e == C || e == M;
    }

    public static NumeralEnum get(String val) {
        for (NumeralEnum e : NumeralEnum.class.getEnumConstants()) {
            if (e.getKey().equals(val)) {
                return e;
            }
        }
        return null;
    }
}
