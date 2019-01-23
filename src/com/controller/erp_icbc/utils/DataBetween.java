package com.controller.erp_icbc.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/** 算出两个日期的间隔天数 用来计算逾期的天数
 * @Description:TODO
 * @author:LiWang
 * @time:2018年8月2日
 */
public class DataBetween {
	/**dayDiff("2018-02-15","2018-02-16","yyyy-MM-dd")
	 * @param date1
	 * @param date2
	 * @param format
	 * @return
	 * @Description: TODO
	 * @param name
	 * @return 
	 */
	public static long dayDiff(String date1, String date2,String format) {
		SimpleDateFormat formater = new SimpleDateFormat(format);
		long diff=0l;
		try {
			long d1 = formater.parse(date1).getTime();
			long d2 = formater.parse(date2).getTime();
			//abs取绝对值：如果参数为非负数，则返回该参数。如果参数为负数，则返回该参数的相反数。特殊情况如下：
			diff=(Math.abs(d1-d2) / (1000 * 60 * 60 * 24));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return diff;
	}
}
