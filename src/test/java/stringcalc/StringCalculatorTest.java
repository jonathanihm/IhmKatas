package stringcalc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jonat on 4/28/2016.
 */
public class StringCalculatorTest {

    @Test
    public void addEmptyString() throws Exception {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void addOneNumber() throws Exception {
        StringCalculator calculator = new StringCalculator();
        assertEquals(5, calculator.add("5"));
    }

    @Test
    public void addTwoNumbers() throws Exception {
        StringCalculator calculator = new StringCalculator();
        assertEquals(11, calculator.add("5,6"));
    }

    @Test
    public void addMultipleNumbers() throws Exception {
        StringCalculator calculator = new StringCalculator();
        assertEquals(11, calculator.add("5,6,0"));
        assertEquals(16, calculator.add("5,6,5"));
        assertEquals(11, calculator.add("1,2,3,4,1"));
        assertEquals(55, calculator.add("5,6,44"));
    }

    @Test
    public void addDifferentDelimiter() throws Exception {
        StringCalculator calculator = new StringCalculator("\n");
        assertEquals(11, calculator.add("5\n6\n0"));
        assertEquals(16, calculator.add("5\n6\n5"));
        assertEquals(47, calculator.add("1\n2\n44"));
    }

    @Test
    public void addRuntimeDelimiter() throws Exception {
        StringCalculator calculator = new StringCalculator("\n");
        assertEquals(11, calculator.add("//;\n5;6;0"));
        assertEquals(16, calculator.add("//;\n5;11;0"));
        assertEquals(20, calculator.add("//;\n14;6;0"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addWithNegatives() throws Exception {
        StringCalculator calculator = new StringCalculator();
        calculator.add("1,2,-3,4,1");
        calculator.add("5,-6,-44");
    }

    @Test
    public void addNumbersWithThousands() throws Exception {
        StringCalculator calculator = new StringCalculator();
        assertEquals(11, calculator.add("5,6,1000"));
        assertEquals(302, calculator.add("300,1234,2"));
        assertEquals(11, calculator.add("5,6,1234"));
    }


    @Test
    public void addMultipleDelimiterVariableLength() throws Exception {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("//[***]\n1***2***3"));
        assertEquals(10, calculator.add("//[***][;]\n1***2***3;4"));
    }
}