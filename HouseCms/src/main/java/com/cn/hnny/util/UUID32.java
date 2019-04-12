package com.cn.hnny.util;

import java.util.Calendar;
import java.util.UUID;

public class UUID32 {
	public static String getUUID32(){

		String uuid=UUID.randomUUID().toString().replace("-", "").toLowerCase();

		return uuid;

	}
	 public static String getTimeInMillis() {
	        long timeInMillis = Calendar.getInstance().getTimeInMillis();
	        return timeInMillis+"";
	    }

	 
	 
}
