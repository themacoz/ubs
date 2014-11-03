package com.ubs.opsit.interviews.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
 
public class TimeValidator {
 
	  private Pattern pattern;
	  private Matcher matcher;
 
	  private static final String TIME24_PATTERN = 
                 "([01]?[0-9]|2[0-4]):[0-5][0-9]:[0-5][0-9]";
 
	  public TimeValidator(){
		  pattern = Pattern.compile(TIME24_PATTERN);
	  }
 
	  /**
	   * Validate time in 24 hours format with regular expression
	   * @param time time address for validation
	   * @return true valid time format, false invalid time format
	   */
	  public boolean validate(final String time) {
		  
		  boolean matched = false;
		  if (!StringUtils.isBlank(time)) {
			  matcher = pattern.matcher(time);
			  matched = matcher.matches();
		  }
		  return matched;
 
	  }
}
