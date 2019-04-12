package com.cn.hnny.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
	public static String time(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String d=df.format(new Date());
		 return d;
	}
}
