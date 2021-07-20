package com.FrameworkHelpers;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ListThrusday {
	
	private static final DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public String nextDayOfWeek(int dow) {

	       Calendar date = Calendar.getInstance();
	        int diff = dow - date.get(Calendar.DAY_OF_WEEK);
	        if (diff <= 0) {
	            diff += 7;
	        }

	        System.out.println(date.get(Calendar.DAY_OF_WEEK));
	        date.add(Calendar.DAY_OF_MONTH, diff);
	      
	        String newDate=sdf.format(date.getTime());
	        return newDate;

	    }

}



