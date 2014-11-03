package com.ubs.opsit.interviews;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TimeConverterTest {

	TimeConverter timeConverter;

	@Before
	public void setUp() throws Exception {
		timeConverter = new TimeConverterImpl();
	}
	

	@Test
	public void TimeConverterImplWithValidInput() throws Exception {
		String input = "23:14:59";
		String result = timeConverter.convertTime(input);
		String assertHeader = "With valid input: ";
		String comparator = "O\nRRRR\nRRRO\nYYOOOOOOOOO\nYYYY";
		assertEquals(assertHeader+input,comparator,result);
		input = "23:52:58";
		result = timeConverter.convertTime(input);
		comparator = "Y\nRRRR\nRRRO\nYYRYYRYYRYO\nYYOO";
		assertEquals(assertHeader+input,comparator,result);
	}

	@Test
	public void TimeConverterImplWithMidnight() throws Exception {
		String input = "00:00:00";
		String result = timeConverter.convertTime(input);
		String assertHeader = "With midnight: ";
		String comparator = "Y\nOOOO\nOOOO\nOOOOOOOOOOO\nOOOO";
		assertEquals(assertHeader+input,comparator,result);
		input = "24:00:00";
		result = timeConverter.convertTime(input);
		assertHeader = "With midnight: ";
		comparator = "Y\nRRRR\nRRRR\nOOOOOOOOOOO\nOOOO";
		assertEquals(assertHeader+input,comparator,result);
	}
	
	@Test(expected=IllegalArgumentException.class) 
	public void TimeConverterImplWithInvalidInput() throws Exception {
		String invalidInput = "28:33:59";
		timeConverter.convertTime(invalidInput);
	}
	
	@Test(expected=IllegalArgumentException.class) 
	public void TimeConverterImplWithNullInput() throws Exception {
		String invalidInput = null;
		timeConverter.convertTime(invalidInput);
	}

}