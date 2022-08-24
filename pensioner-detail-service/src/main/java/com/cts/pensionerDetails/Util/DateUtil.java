package com.cts.pensionerDetails.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  @author Ujjwal Sinha
 *  @author 857152
 * 
 *         This is the DateUtil class which consist of parseDate method which
 *         used to convert the string into the Date Type
 *
 */

public class DateUtil {

	private DateUtil() {
	}

	public static Date parseDate(String date) throws ParseException {
		return new SimpleDateFormat("dd-MM-yyyy").parse(date);
	}

}
