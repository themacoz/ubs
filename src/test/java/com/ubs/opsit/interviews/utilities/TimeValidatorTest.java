package com.ubs.opsit.interviews.utilities;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TimeValidatorTest {
	
	TimeValidator timeValidator;

	@Before
	public void setUp() throws Exception {
		timeValidator = new TimeValidator();
	}
	
	@Test
	public void TimeValidatorWithValidInputs() throws Exception {
		String assertHeader = "With valid input: ";
		String validInput = "23:59:59";
		boolean result = timeValidator.validate(validInput);
		assertTrue(assertHeader+validInput,result);
		validInput = "13:14:23";
		result = timeValidator.validate(validInput);
		assertTrue(assertHeader+validInput,result);
		validInput = "1:14:23";
		result = timeValidator.validate(validInput);
		assertTrue(assertHeader+validInput,result);
	}

	@Test
	public void TimeValidatorWithInvalidInputs() throws Exception {
		String assertHeader = "With invalid input: ";
		String invalidInput = "23:61:59";
		boolean result = timeValidator.validate(invalidInput);
		assertFalse(assertHeader+invalidInput,result);
		invalidInput = "28:14:23";
		result = timeValidator.validate(invalidInput);
		assertFalse("With invalid input: "+invalidInput,result);
		invalidInput = "13:14:62";
		result = timeValidator.validate(invalidInput);
		assertFalse("With invalid input: "+invalidInput,result);
		invalidInput = "  ";
		result = timeValidator.validate(invalidInput);
		assertFalse("With invalid input: "+invalidInput,result);
	}
}
