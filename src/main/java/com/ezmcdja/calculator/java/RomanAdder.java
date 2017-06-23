package com.ezmcdja.calculator.java;

public class RomanAdder {
	private Integer result;
	
	public RomanAdder(String... input) {
		
	}
	
    public static String[] romanAdd(final String[] input) {
        final NumberConverter converter = new NumberConverter();
        Integer decimalResult = 0;
        final StringBuilder decimalOperands = new StringBuilder();
        for (final String operand : input) {
            final Integer decimal = converter.parseToDecimal(operand);
            decimalOperands.append(decimal + " + ");
            decimalResult += decimal;
        }
        decimalOperands.delete(decimalOperands.length() - 3, decimalOperands.length());
        return new String[] { decimalOperands.toString(), decimalResult.toString(), converter.convertToRoman(decimalResult) };
    }
}
