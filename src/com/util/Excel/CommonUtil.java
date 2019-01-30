package com.util.Excel;

import java.util.UUID;

public class CommonUtil {

	/**
	 * 获取UUID的值
	 * @return UUID字符串
	 */
	public static String getUUID(){
		
		return UUID.randomUUID().toString();
	}
}
