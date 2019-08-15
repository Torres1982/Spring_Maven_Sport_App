package com.torres.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @see https://docs.oracle.com/javase/tutorial/i18n/format/simpleDateFormat.html
 * @author AR20068603
 * @version 1.1
 * @since 15-08-2019
 */
public class DateUtility {   
    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    
    // Convert String to Date
    public static Date convertStringToDateByString(String stringDate) throws ParseException {
    	return formatter.parse(stringDate);      
    }
    
    // Convert Date to String
    public static String convertDateToStringByDate(Date date) {           
    	return date != null ? formatter.format(date) : null;
    }
}
