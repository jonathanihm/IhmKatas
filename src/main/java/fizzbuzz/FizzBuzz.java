package fizzbuzz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by jonat on 4/30/2016.
 */
public class FizzBuzz {

    public static String getScore(int num) {
        HashMap<Integer, String> fizzMap = new LinkedHashMap<>();
        fizzMap.put(3, "fizz");
        fizzMap.put(5, "buzz");
        return getScore(num, fizzMap);
    }

    // we would like insertion order so we know which value should show up first
    public static String getScore(int num, HashMap<Integer, String> fizzMap) {
        StringBuilder builder = new StringBuilder("");
        boolean divisibleInMap = false;
        for (Map.Entry<Integer, String> o : fizzMap.entrySet()) {
            if (num % o.getKey() == 0) {
                divisibleInMap = true;
                break;
            }
        }
        if (!divisibleInMap) {
            builder.append(num);
        } else {
            Iterator i =  fizzMap.entrySet().iterator();
            getValue(num, i, builder);
        }

//        if (num % 3 != 0 && num % 5 != 0) {
//            builder.append(num);
//        } else {
//            if (num % 3 == 0) {
//                builder.append("fizz");
//                if (num % 5 == 0) {
//                    builder.append(" buzz");
//                }
//            } else if (num % 5 == 0) {
//                builder.append("buzz");
//            }
//        }
        return builder.toString();
    }

    private static void getValue(int num, Iterator i, StringBuilder builder) {
        while (i.hasNext()) {
            Map.Entry<Integer, String> o = (Map.Entry<Integer, String>) i.next();
            if (!i.hasNext()) {
                if (num % o.getKey() == 0) {
                    if (builder.toString().length() > 0) {
                        builder.append(" ");
                    }
                    builder.append(o.getValue());
                }
            } else {
                if (num % o.getKey() == 0) {
                    if (builder.toString().length() > 0) {
                        builder.append(" ");
                    }
                    builder.append(o.getValue());
                }
                getValue(num, i, builder);
            }
        }
    }
}
