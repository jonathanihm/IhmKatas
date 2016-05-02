package stringsum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jonat on 5/1/2016.
 */
public class StringSumTest {

    @Test
    public void sumEmptyTest() throws Exception {
        assertEquals(0, StringSum.sum("", ""));
    }

    @Test
    public void sumInvalidTest() throws Exception {
        assertEquals(0, StringSum.sum("asd", "123f"));
        assertEquals(123, StringSum.sum("asd", "123"));
    }

    @Test
    public void sumValidTest() throws Exception {
        assertEquals(11, StringSum.sum("5", "6"));
        assertEquals(21, StringSum.sum("12", "9"));
    }
}