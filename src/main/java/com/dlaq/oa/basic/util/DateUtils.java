package com.dlaq.oa.basic.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	private final static String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * @return like 2015-10-14 13:15:40
	 */
	public static String getDateString(){
		return getDateString(new Date(),DEFAULT_PATTERN);
	}
	public static String getDateString(Date date){
		return getDateString(date,DEFAULT_PATTERN);
	}
	public static String getDateString(String pattern){
		return getDateString(new Date(),pattern);
	}
	public static String getDateString(Date date, String pattern){
		return new SimpleDateFormat(pattern).format(date);
	}
	
	
	public static void main(String[] args) {
		Date d = new Date();
		SimpleDateFormat myFmt=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		
		System.out.println(myFmt.format(d));
		
	}
}
