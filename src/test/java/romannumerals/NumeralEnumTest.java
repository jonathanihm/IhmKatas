package romannumerals;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jonat on 4/29/2016.
 */
public class NumeralEnumTest {

    @Test
    public void convertArabicSmall() throws Exception {
        assertEquals("nulla", NumeralEnum.convertToRoman(0));
        assertEquals("I", NumeralEnum.convertToRoman(1));
        assertEquals("III", NumeralEnum.convertToRoman(3));
        assertEquals("VIII", NumeralEnum.convertToRoman(8));
    }

    @Test
    public void convertArabicZero() throws Exception {
        assertEquals("nulla", NumeralEnum.convertToRoman(0));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void convertArabicLessThanZero() throws Exception {
        NumeralEnum.convertToRoman(-230);
    }

    @Test
    public void convertArabicMedium() throws Exception {
        assertEquals("IX", NumeralEnum.convertToRoman(9));
        assertEquals("XI", NumeralEnum.convertToRoman(11));
        assertEquals("XXXI", NumeralEnum.convertToRoman(31));
        assertEquals("XLIX", NumeralEnum.convertToRoman(49));
        assertEquals("LXXIV", NumeralEnum.convertToRoman(74));
    }

    @Test
    public void convertArabicLarge() throws Exception {
        assertEquals("CCCII", NumeralEnum.convertToRoman(302));
        assertEquals("MLXVI", NumeralEnum.convertToRoman(1066));
        assertEquals("MCMLXXXIX", NumeralEnum.convertToRoman(1989));
    }

    @Test
    public void convertRomanSmall() throws Exception {
        assertEquals(1, NumeralEnum.convertToArabic("I"));
        assertEquals(3, NumeralEnum.convertToArabic("III"));
        assertEquals(4, NumeralEnum.convertToArabic("IV"));
        assertEquals(7, NumeralEnum.convertToArabic("VII"));
        assertEquals(9, NumeralEnum.convertToArabic("IX"));
    }

    @Test
    public void convertRomanMedium() throws Exception {
        assertEquals(13, NumeralEnum.convertToArabic("XIII"));
        assertEquals(14, NumeralEnum.convertToArabic("XIV"));
        assertEquals(19, NumeralEnum.convertToArabic("XIX"));
        assertEquals(22, NumeralEnum.convertToArabic("XXII"));
    }

    @Test
    public void convertRomanLarge() throws Exception {
        assertEquals(241, NumeralEnum.convertToArabic("CCXLI"));
        assertEquals(1066, NumeralEnum.convertToArabic("MLXVI"));
        assertEquals(1989, NumeralEnum.convertToArabic("MCMLXXXIX"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void convertTooLarge() throws Exception {
        NumeralEnum.convertToRoman(5000);
    }

    @Test
    public void getLargestNumeralTest() throws Exception {
        assertEquals(NumeralEnum.I, NumeralEnum.getLargestNumeral(1));
        assertEquals(NumeralEnum.I, NumeralEnum.getLargestNumeral(3));
        assertEquals(NumeralEnum.V, NumeralEnum.getLargestNumeral(6));
        assertEquals(NumeralEnum.X, NumeralEnum.getLargestNumeral(11));
        assertEquals(NumeralEnum.L, NumeralEnum.getLargestNumeral(51));
    }

    @Test
    public void previousAndNextNumeralEnum() throws Exception {
        assertEquals(NumeralEnum.NULLA, NumeralEnum.I.prev());
        assertEquals(NumeralEnum.NULLA, NumeralEnum.M.next());
    }
}