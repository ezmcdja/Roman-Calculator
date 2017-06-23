package com.ezmcdja.calculator.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.ezmcdja.calculator.java.CalculatorWindow;
import com.ezmcdja.calculator.java.RomanAdder;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class RomanAdderTest {

	@Parameters({ "II, I, I", "IV, II, II", "III, I, I, I",
			"XXX, I, I, I, I, I, I, I, I, I, I, I, I, I, I, I, I, I, I, I, I, I, I, I, I, I, I, I, I, I, I",
			"CMLXIII, IV, LI, CCCLXXV, DXXXIII", "MMMMMMMMMMMDCCXLV, MMMDCCCLXXII, MMMMMMMDCCCLXXIII",
			"CLXVIII, XCI, LXXVII", "CDLVII, CXLIII, CCCXIV" })
	@Test
	public void testSimpleAdd(final String result, final String[] input) {
		assertEquals(result, RomanAdder.romanAdd(input)[2]);
	}

	@Test
	public void testWindow() {
		CalculatorWindow.main(new String[0]);
		new CalculatorWindow();
	}

}
