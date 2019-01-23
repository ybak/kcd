package com.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class creditutil {
	
	//时间   0000-00-00 0000000
		public static String datatotime1(Object object)
		{
			SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		
			Date d = null;
			String time = null;
			try {
				d = sim.parse((String) object);
				DateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");			
				time=format.format(d);				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return time;
			
		} 
		//时间   0000-00-00 0000000
		public static String datatotime2(Object object)
		{
			SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM");		
			Date d = null;
			String time = null;
			try {
				d = sim.parse((String) object);
				DateFormat format=new SimpleDateFormat("yyyyMM");			
				time=format.format(d)+"00000000";				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return time;
			
		} 
		//时间   0000-00-00 
			public static String datatotime(Object object)
			{
				SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");		
				Date d = null;
				String time = null;
				try {
					d = sim.parse((String) object);
					DateFormat format=new SimpleDateFormat("yyyyMMdd");			
					time=format.format(d)+"000000";
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return time;
				
			} 
	//时间戳  0000-00-00 
	public static String Unixtime(String str)
	{
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");		
		Date d = null;
		String time = null;
		try {
			d = sim.parse(str);
			DateFormat format=new SimpleDateFormat("yyyyMMdd");			
			time=format.format(d);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return time;
		
	} 
	
	public static String time()
	{
	Date date=new Date();
	DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String time=format.format(date);
	return time;
	} 
	public static String timefile()
	{
	Date date=new Date();
	DateFormat format=new SimpleDateFormat("yyyyMMdd");
	String time=format.format(date);
	return time;
	}
	public static String timefiles()
	{
	Date date=new Date();
	DateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
	String time=format.format(date);
	return time;
	}
	public static String timetofile(String str)
	{
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		
		Date d = null;
		String time = null;
		try {
			d = sim.parse(str);
			DateFormat format=new SimpleDateFormat("yyyyMMdd");
			time=format.format(d);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return time;
	}
	
	public static String timetostring(String date)
	{
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		
		Date d = null;
		String time = null;
		try {
			d = sim.parse(date);
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			time=format.format(d);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return time;
	}
		    //测试方法	
	public static void main(String[] args) {
		String time=time();
		System.out.println("file："+time);
		System.out.println("file："+timetofile(time));
		System.out.println("file："+timetostring(time));
	    System.out.println("时间戳："+Unixtime("2017-11-11"));
	    System.out.println("时间ss："+datatotime1("0000-00-00 00:00:00"));
	    System.out.println("时间ss："+datatotime2("2017-11"));
	}
}
