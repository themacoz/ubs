/**
 * 
 */
package com.ubs.opsit.interviews;

import org.apache.commons.lang.StringUtils;

import com.ubs.opsit.interviews.utilities.TimeValidator;

public final class TimeConverterImpl implements TimeConverter {

	public static final String O_STR = "O";
	public static final String R_STR = "R";
	public static final String Y_STR = "Y";
	public static final String NEW_LINE = "\n";
	
	public TimeConverterImpl() {
		timeValidator = new TimeValidator();
	}
	
	private TimeValidator timeValidator;

	@Override
	public String convertTime(String aTime) {
		
		String convertedTime = null;
		if ( !timeValidator.validate(aTime) ) {
			StringBuilder bldr = new StringBuilder("Invalid time detected: ");
			bldr.append(aTime);
			throw new IllegalArgumentException(bldr.toString());
		} else {
			convertedTime = buildConvertedtTime(aTime);
		}
		return convertedTime;
	}

	private String buildConvertedtTime(final String inTime) {
		StringBuilder bldr = new StringBuilder();

		bldr = appendTwoSecondIndicator(bldr,inTime);
		bldr = appendHourRows(bldr,inTime);
		bldr = appendMinuteRows(bldr,inTime);
		
		return bldr.toString();
	}
	
	private StringBuilder appendTwoSecondIndicator(final StringBuilder bldr, final String inTime) {
		String strSec = inTime.substring(6,8);
		int intSec = Integer.parseInt(strSec);
		if ( (intSec % 2) == 0) {
		    bldr.append(Y_STR);
		} else {
			bldr.append(O_STR);
		}
		return bldr;
	}
	
	private StringBuilder appendHourRows(final StringBuilder bldr,final String inTime) {
		String strHrs = inTime.substring(0,2);
		int intHrs = Integer.parseInt(strHrs);
		int rCount = intHrs / 5;
		bldr.append(NEW_LINE);
		bldr.append(StringUtils.repeat(R_STR, rCount));
		int oCount = 4 - rCount;
		bldr.append(StringUtils.repeat(O_STR, oCount));
		bldr.append(NEW_LINE);
		rCount = intHrs % 5;
		bldr.append(StringUtils.repeat(R_STR, rCount));
		oCount = 4 - rCount;
		bldr.append(StringUtils.repeat(O_STR, oCount));
		return bldr;
	}
	
	private StringBuilder appendMinuteRows(final StringBuilder bldr,final String inTime) {
		String strMin = inTime.substring(3,5);
		int intMin = Integer.parseInt(strMin);
		int endLoop = intMin / 5;
		bldr.append(NEW_LINE);
		for (int start=0; start<endLoop; start++) {
			if ((start+1)%3 == 0) {
				bldr.append(R_STR);
			} else {
			    bldr.append(Y_STR);
			}
		}
		int oCount = 11 - endLoop;
		bldr.append(StringUtils.repeat(O_STR, oCount));
		bldr.append(NEW_LINE);
		int yCount = intMin % 5;
		bldr.append(StringUtils.repeat(Y_STR, yCount));
		oCount = 4 - yCount;
		bldr.append(StringUtils.repeat(O_STR, oCount));
		return bldr;
	}

}