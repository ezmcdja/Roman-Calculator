package com.ezmcdja.calculator.java;

import static com.ezmcdja.calculator.java.RomanNumeral.*;

import java.util.Arrays;
import java.util.List;

public class NumberConverter {
    public Integer parseToDecimal(final String romanVersion) {
        final StringBuilder builder = new StringBuilder(romanVersion);
        Integer converted = 0;

        builder.reverse();
        while (builder.length() != 0) {
            final Character each = builder.charAt(0), next;
            final Integer parsed = RomanNumeral.parseNumeralToDecimal(new String(new char[] { each })), parsedNext;
            converted += parsed;
            if (builder.length() > 1) {
                next = builder.charAt(1);
                parsedNext = RomanNumeral.parseNumeralToDecimal(new String(new char[] { next }));
                if (parsedNext < parsed) {
                    converted -= parsedNext;
                    builder.deleteCharAt(1);
                }
            }
            builder.deleteCharAt(0);
        }
        return converted;
    }

    public String convertToRoman(final Integer decimalVersion) {
        Integer number = decimalVersion;
        final StringBuilder builder = new StringBuilder();
        while (number >= 500) {
            builder.append(D.getRoman());
            number -= 500;
        }
        while (number >= 50) {
            builder.append(L.getRoman());
            number -= 50;
        }
        while (number >= 5) {
            builder.append(V.getRoman());
            number -= 5;
        }
        while (number >= 1) {
            builder.append(I.getRoman());
            number--;
        }
        String converted = builder.toString();
        converted = tidyUpRomanNumber(converted);
        return converted;
    }

    private String collapseDs(final String toTidy) {
        String tidying = toTidy;
        while (tidying.contains("DD")) {
            tidying = tidying.replace("DD", M.getRoman());
        }
        return tidying;
    }

    private String collapseLs(final String toTidy) {
        String tidying = toTidy;
        while (tidying.contains("LL")) {
            tidying = tidying.replace("LL", C.getRoman());
        }
        return tidying;
    }

    private String collapseVs(final String toTidy) {
        String tidying = toTidy;
        while (tidying.contains("VV")) {
            tidying = tidying.replace("VV", X.getRoman());
        }
        return tidying;
    }

    private String tidyUpRomanNumber(final String toTidy) {
        String tidying = toTidy;
        tidying = collapseDs(tidying);
        tidying = collapseLs(tidying);
        tidying = collapseVs(tidying);
        tidying = tidying.replaceAll("IIII", "IV");
        tidying = tidying.replaceAll("VIV", "IX");
        tidying = tidying.replaceAll("XXXX", "XL");
        tidying = tidying.replaceAll("LXL", "XC");
        tidying = tidying.replaceAll("CCCC", "CD");
        tidying = tidying.replaceAll("DCD", "CM");
        tidying = tidying.replaceAll("DXD", "XM");
        tidying = tidying.replaceAll("DID", "IM");
        return tidying;
    }

    public void validateRomanNumber(final String aNumber) {
        final String toValidate = tidyUpRomanNumber(aNumber);
        final char[] numberCharacters = toValidate.toCharArray();
        for (int i = 0; i < numberCharacters.length; i++) {
            final char current = numberCharacters[i];
            if (i + 1 < numberCharacters.length) {
                final char next = numberCharacters[i + 1];
                final List<String> validWrongOrderCombinations = Arrays
                        .asList(new String[] { IV.getRoman(), IX.getRoman(), XL.getRoman(), XC.getRoman(), CD.getRoman(), CM.getRoman() });
                final boolean charsInOrder = (RomanNumeral.checkNumeralValidity(current) >= RomanNumeral.checkNumeralValidity(next));

                final String nextCharacterChecking = new String(new char[] { current, next });
                if (!charsInOrder && !validWrongOrderCombinations.contains(nextCharacterChecking)) {
                    throw new IllegalArgumentException("INVALID NUMBER: " + aNumber);
                }
            }
            RomanNumeral.checkNumeralValidity(current);
        }
    }
}
