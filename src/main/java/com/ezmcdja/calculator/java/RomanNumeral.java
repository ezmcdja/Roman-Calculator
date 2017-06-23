package com.ezmcdja.calculator.java;

public enum RomanNumeral {
	I(1, "I"), IV(4, "IV"), V(5, "V"), IX(9, "IX"), X(10, "X"), XL(40, "XL"), L(50, "L"),
	XC(90, "XC"), C(100, "C"), CD(400, "CD"), D(500, "D"), CM(900, "CM"), M(1000, "M");

	private int decimalVersion;
	private String romanVersion;

	private RomanNumeral(final int decimalVersion, final String romanVersion) {
		this.decimalVersion = decimalVersion;
		this.romanVersion = romanVersion;
	}

	String getRoman() {
		return this.romanVersion;
	}

	static int parseNumeralToDecimal(final String numeral) {
		for (final RomanNumeral each : RomanNumeral.values()) {
			if (each.romanVersion.equals(numeral)) {
				return each.decimalVersion;
			}
		}
		return 0;
	}

	static int checkNumeralValidity(final char numeral) throws IllegalArgumentException {
		final int decimalVersion = parseNumeralToDecimal(new String(new char[] { numeral }));
		if (decimalVersion == 0) {
			throw new IllegalArgumentException("INVALID NUMBER: " + numeral);
		}
		return decimalVersion;
	}
}
