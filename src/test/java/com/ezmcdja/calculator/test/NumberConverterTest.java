package com.ezmcdja.calculator.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.ezmcdja.calculator.java.NumberConverter;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class NumberConverterTest {
    private NumberConverter converter;

    @Before
    public void setUp() {
        converter = new NumberConverter();
    }

    @Test
    @Parameters({"1, I", "4, IV", "5, V", "6, VI", "9, IX", "10, X",
                 "14, XIV", "15, XV", "16, XVI", "19, XIX", "20, XX", "40, XL", "44, XLIV", "49, XLIX", "50, L",
                 "54, LIV", "59, LIX", "60, LX", "70, LXX", "90, XC", "99, XCIX", "100, C",
                 "109, CIX", "140, CXL", "149, CXLIX", "150, CL", "190, CXC", "199, CXCIX", "200, CC",
                 "400, CD", "490, CDXC", "499, CDXCIX", "500, D", "540, DXL", "900, CM", "990, CMXC",
                 "999, CMXCIX", "1000, M", "1968, MCMLXVIII", "8245, MMMMMMMMCCXLV"})
    public void testDecimalToRoman(final Integer number, final String roman) {
        assertEquals(roman, converter.convertToRoman(number));
    }

    @Test
    @Parameters({"1, I", "4, IV", "5, V", "6, VI", "9, IX", "10, X",
                  "14, XIV", "15, XV", "16, XVI", "19, XIX", "20, XX", "40, XL", "44, XLIV", "49, XLIX", "50, L",
                  "54, LIV", "59, LIX", "60, LX", "70, LXX", "90, XC", "99, XCIX", "100, C",
                  "109, CIX", "140, CXL", "149, CXLIX", "150, CL", "190, CXC", "199, CXCIX", "200, CC",
                  "400, CD", "490, CDXC", "499, CDXCIX", "500, D", "540, DXL", "900, CM", "990, CMXC",
                  "999, CMXCIX", "1000, M", "1968, MCMLXVIII", "8245, MMMMMMMMCCXLV"})
    public void testRomanToDecimal(final Integer number, final String roman) {
        assertEquals(number, converter.parseToDecimal(roman));
    }

    @Test
    public void testValidation() {
        String toValidate = "";
        for (int i = 1; i <= 1000; i++) {
            toValidate = converter.convertToRoman(i);
            converter.validateRomanNumber(toValidate);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters({ "w", "F", "wibby", "WRONG NUMBER", "DCCMIIXVL", "IL", "IC", "IM" })
    public void testInvalidation(final String toValidate) {
        converter.validateRomanNumber(toValidate);
    }
}
