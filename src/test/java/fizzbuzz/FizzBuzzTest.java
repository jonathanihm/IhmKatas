package fizzbuzz;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by jonat on 4/30/2016.
 */
public class FizzBuzzTest {

    @Test
    public void getScoreNormalNumber() throws Exception {
        assertEquals("1", FizzBuzz.getScore(1));
        assertEquals("4", FizzBuzz.getScore(4));
    }

    @Test
    public void getScoreFizzNumber() throws Exception {
        assertEquals("fizz", FizzBuzz.getScore(3));
        assertEquals("fizz", FizzBuzz.getScore(9));
        assertEquals("fizz", FizzBuzz.getScore(123));
    }

    @Test
    public void getScoreBuzzNumber() throws Exception {
        assertEquals("buzz", FizzBuzz.getScore(5));
        assertEquals("buzz", FizzBuzz.getScore(20));
        assertEquals("buzz", FizzBuzz.getScore(200));
    }

    @Test
    public void getScoreFizzBuzzNumber() throws Exception {
        assertEquals("fizz buzz", FizzBuzz.getScore(15));
        assertEquals("fizz buzz", FizzBuzz.getScore(45));
        assertEquals("fizz buzz", FizzBuzz.getScore(315));
    }

    @Test
    public void getScoreFizzBuzzPopNumber() throws Exception {
        HashMap<Integer, String> fizzMap = new LinkedHashMap<>();
        fizzMap.put(3, "fizz");
        fizzMap.put(5, "buzz");
        fizzMap.put(7, "pop");
        assertEquals("pop", FizzBuzz.getScore(7, fizzMap));
        assertEquals("pop", FizzBuzz.getScore(28, fizzMap));
        assertEquals("pop", FizzBuzz.getScore(77, fizzMap));
        assertEquals("fizz pop", FizzBuzz.getScore(21, fizzMap));
        assertEquals("fizz pop", FizzBuzz.getScore(63, fizzMap));
        assertEquals("fizz pop", FizzBuzz.getScore(126, fizzMap));
        assertEquals("buzz pop", FizzBuzz.getScore(35, fizzMap));
        assertEquals("buzz pop", FizzBuzz.getScore(70, fizzMap));
        assertEquals("buzz pop", FizzBuzz.getScore(140, fizzMap));
        assertEquals("fizz buzz pop", FizzBuzz.getScore(105, fizzMap));
        assertEquals("fizz buzz pop", FizzBuzz.getScore(210, fizzMap));
        assertEquals("fizz buzz pop", FizzBuzz.getScore(315, fizzMap));
    }

    @Test
    public void getScoreCustomNumber() throws Exception {
        HashMap<Integer, String> fizzMap = new LinkedHashMap<>();
        fizzMap.put(2, "fuzz");
        assertEquals("1", FizzBuzz.getScore(1, fizzMap));
        assertEquals("fuzz", FizzBuzz.getScore(2, fizzMap));
        assertEquals("fuzz", FizzBuzz.getScore(8, fizzMap));
        fizzMap = new LinkedHashMap<>();
        fizzMap.put(2, "fuzz");
        fizzMap.put(3, "bizz");
        assertEquals("fuzz", FizzBuzz.getScore(4, fizzMap));
        assertEquals("bizz", FizzBuzz.getScore(9, fizzMap));
        assertEquals("fuzz bizz", FizzBuzz.getScore(12, fizzMap));
    }
}