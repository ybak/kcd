package com.controller.erp_icbc;

import java.io.File;
import java.security.MessageDigest;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;

/*
 * 常用工具类,各种常用的方法，函数
 * 最后更新2018-11-23
 * */
public class Tools<K, V> {
	static final public char sp = 5;// 分割符号

	/**
	 * =================================字符串等常用处理方法==============================
	 * === map到jsong字符串的处理，需要引用阿里巴巴的开源组件fastjson在pom.xml加入以下代码 <dependency>
	 * <groupId>com.alibaba</groupId> <artifactId>fastjson</artifactId>
	 * <version>1.2.4</version> </dependency>
	 *
	 * @param mpStr
	 * @return
	 */
	public static String jsonEnCode(Map<String, String> mpStr) {
		return JSON.toJSONString(mpStr);
	}

	public static Map<String, String> jsonDeCode(String mpStr) {
		Map<String, String> mp = new HashMap<>();
		Map maps = (Map) JSON.parse(mpStr);
		for (Object map : maps.entrySet()) {
			mp.put(((Map.Entry) map).getKey().toString(), ((Map.Entry) map)
					.getValue().toString());
		}
		return mp;
	}

	public static String dirDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("/yyyy/MM/dd/");
		String dateString = formatter.format(new Date());
		return dateString;
	}

	public static String md5(String inStr) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			return "";
		}
		char[] charArray = inStr.toCharArray();
		byte[] byteArray = new byte[charArray.length];
		for (int i = 0; i < charArray.length; i++)
			byteArray[i] = (byte) charArray[i];
		byte[] md5Bytes = md5.digest(byteArray);
		StringBuffer hexValue = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16)
				hexValue.append("0");
			hexValue.append(Integer.toHexString(val));
		}

		return hexValue.toString();

	}

	public static boolean arrayIndexOf(String[] arr, String targetValue) {
		return Arrays.asList(arr).contains(targetValue);
	}

	/**
	 * 将长时间格式字符串转换为时间 yyyy-MM-dd HH:mm:ss
	 *
	 * @param strDate
	 * @return
	 */
	public static Date strToDateLong(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}

	/**
	 * 将长时间格式时间转换为字符串 yyyy-MM-dd HH:mm:ss
	 *
	 * @param dateDate
	 * @return
	 */
	public static String dateToStrLong(Date dateDate) {
		if (dateDate == null) {
			dateDate = new Date();
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(dateDate);
		return dateString;
	}

	/**
	 * 将短时间格式时间转换为字符串 yyyy-MM-dd
	 *
	 * @param dateDate
	 * @param
	 * @return
	 */
	public static String dateToStr(Date dateDate) {
		if (dateDate == null) {
			dateDate = new Date();
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(dateDate);
		return dateString;
	}

	/**
	 * 将短时间格式字符串转换为时间 yyyy-MM-dd
	 *
	 * @param strDate
	 * @return
	 */
	public static Date strToDate(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}

	public static boolean myisnull(String s) {
		if (s == null || s.equals("") || s.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 删除map中的某个key
	 */
	public static Map<String, String> deleteKeyOfMap(
			Map<String, String> paramsMap, String ID) {
		Iterator<String> iter = paramsMap.keySet().iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			if (ID.equals(key)) {
				iter.remove();
			}
		}
		return paramsMap;
	}

	/**
	 * 使用时必须修改的。获取当前登陆用户的id
	 */
	public static long mid() {
		// todo 获取当前登陆用户的id。
		try {
			return (int) ((ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes()).getRequest().getSession()
					.getAttribute("tt_mid");
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * 使用时必须修改的。获取当前登陆的用户是否是后台管理员权限
	 */
	public static boolean isadmin() {
		// todo 获取当前登陆用户是否是后台管理员，需要设置一个标志。
		/* 直接从session中获取，也可以从数据表中获取当前登陆用户的isadmin字段是否为1来判断是否管理员 */
		try {
			return (boolean) ((ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes()).getRequest().getSession()
					.getAttribute("tt_isadmin");
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean in_array_list(String str, List<String> arr) {
		return arr.contains(str);
	}

	public static String maptostring(Map<String, String> map, String fgchar) {
		if (myisnull(fgchar)) {
			fgchar = ",";
		}
		StringBuilder sb = new StringBuilder();
		Iterator<Entry<String, String>> iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Entry<String, String> entry = (Entry<String, String>) iter.next();
			sb.append(entry.getKey());
			sb.append('=').append('"');
			sb.append(entry.getValue());
			sb.append('"');
			if (iter.hasNext()) {
				sb.append(fgchar).append(' ');
			}
		}
		return sb.toString();
	}

	/**
	 * 过滤mysql 注入
	 */
	public static boolean sql_inj(String str) {
		str = str.toLowerCase();
		Map<String, String> mpNoFilters = new HashMap<>();// 常用的几个参数排除，提升过滤速度
		mpNoFilters.put("form", "1");
		mpNoFilters.put("do", "1");
		mpNoFilters.put("cn", "1");
		mpNoFilters.put("id", "1");
		mpNoFilters.put("mid_add", "1");
		mpNoFilters.put("mid_edit", "1");
		if (mpNoFilters.get(str) == "1") {
			return false;
		}
		String inj_str = "";
		// 这里的东西还可以自己添加
		String[] inj_stra = inj_str.split("\\|");
		for (int i = 0; i < inj_stra.length; i++) {
			if (str.indexOf(inj_stra[i]) >= 0) {
				System.out.println(str + "_注入__" + i);
				return false;
			}
		}
		return false;
	}

	public static Map<String, String> getpostmap(HttpServletRequest request) {
		Map<String, String> result = new HashMap<>();
		Enumeration<String> ennum = request.getParameterNames();
		while (ennum.hasMoreElements()) {
			String paramName = (String) ennum.nextElement();
			if (sql_inj(paramName) == true) {// 过滤参数名
				continue;
			}
			String[] values = request.getParameterValues(paramName);
			String value = "";
			for (int i = 0; i < values.length; i++) {
				value += values[i] + sp;
			}
			if (myisnull(value) == false) {
				value = value.substring(0, value.length() - 1);// 去掉char(5);
			}
			if (sql_inj(value) == true) {// 过滤参数值
				System.out.println("mysql注入：" + value);
			} else {
				result.put(paramName, value);
			}
		}
		System.out.println("请求参数" + JSON.toJSONString(result));
		return result;
	}

	public static boolean inarray_s(String[] arr, String targetValue) {
		return Arrays.asList(arr).contains(targetValue);
	}

	/* 返回删除指定字段后的url*,useAge urlKill("cn|id|type"); */
	public static String urlKill(String s) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		String result = "";
		Map<String, String> mpUrl = getpostmap(request);
		s = s.toLowerCase();
		String[] ss = s.split("\\|");
		for (Iterator<Map.Entry<String, String>> it = mpUrl.entrySet()
				.iterator(); it.hasNext();) {
			Map.Entry<String, String> item = it.next();
			if (inarray_s(ss, item.getKey().toLowerCase())) {
				it.remove();
			}
			// ... todo with item
		}
		for (String key : mpUrl.keySet()) {
			result = result + "&" + key + "=" + mpUrl.get(key);
		}
		if (myisnull(result) == false) {
			result = "?" + result.substring(1);
		}
		return request.getRequestURI() + result;
	}

	/**
	 * =================================文件io相关处理方法,更多功能参考FileTools.java========
	 * ========================= FileExists，检测文件/目录是否存在
	 */
	public static boolean fileExists(String strFileFullPath) {
		File file = new File(strFileFullPath);
		return file.exists();
	}

	/**
	 * 是否目录
	 *
	 * @param strFileFullPath
	 * @return
	 */
	public static boolean isDir(String strFileFullPath) {
		File file = new File(strFileFullPath);
		return file.exists() ? file.isDirectory() : false;
	}

	public static boolean createDir(String strFileFullPath) {
		File file = new File(strFileFullPath);
		file.mkdirs();
		return isDir(strFileFullPath);
	}

	/**
	 * 删除一个文件/目录，目录时必须空目录，更多功能参考FileTools.java
	 *
	 * @param strFileFullPath
	 * @return
	 */
	public static boolean delFile(String strFileFullPath) {
		File file = new File(strFileFullPath);
		if (file.exists()) {// 文件存在
			return file.delete();
		} else { // todo 不存在，直接返回真
			return true;
		}
	}

	/**
	 * 获取文件扩展名，不带.
	 *
	 * @param strFullFilePath
	 * @return
	 */
	public static String getFileExt(String strFullFilePath) {
		return strFullFilePath.substring(strFullFilePath.lastIndexOf(".") + 1);
	}

	/**
	 * 获取文件扩展名，不带.
	 *
	 * @param strFullFilePath
	 * @return
	 */
	public static String extractFileExt(String strFullFilePath) {
		return getFileExt(strFullFilePath);
	}

	/**
	 * 格式化一个文件路径字符串，处理路径分隔符斜杆和反斜杆windows下\\,linux下/的问题，格式化后变成目前部署的环境下正确的分隔符，
	 * 同时去掉重复的分隔符
	 *
	 * @param strFilePath
	 * @return
	 */
	public static String formatFilePath(String strFilePath) {
		strFilePath = strFilePath.replace("\\\\", "\\");
		strFilePath = strFilePath.replace("\\\\", "\\");
		strFilePath = strFilePath.replace("//", "/");
		strFilePath = strFilePath.replace("//", "/");
		return strFilePath.replace('/', File.separatorChar).replace('\\',
				File.separatorChar);
	}

	/**
	 * 获取一个长路径字符串的文件名
	 *
	 * @param strFullFilePath
	 * @return
	 */
	public static String extractFileName(String strFullFilePath) {
		return strFullFilePath.substring(formatFilePath(strFullFilePath)
				.lastIndexOf(File.separator) + 1);
	}

	/**
	 * 获取一个长路径串的去掉文件名后的，保留/或者\\
	 *
	 * @param strFullFilePath
	 * @return
	 */
	public static String extractFilePath(String strFullFilePath) {
		return strFullFilePath.substring(0, strFullFilePath.length()
				- extractFileName(strFullFilePath).length());
	}

	/**
	 * 给当前路径末尾加上分隔符\\或者/
	 *
	 * @param strFullFilePath
	 * @return
	 */
	public static String addSpc(String strFullFilePath) {
		if (myisnull(strFullFilePath) == false
				&& !strFullFilePath.substring(strFullFilePath.length() - 1)
						.equals(File.separator)) {
			return strFullFilePath + File.separator;
		} else {
			return strFullFilePath;
		}
	}

	/**
	 * 删除路径串末尾的/或者\\
	 *
	 * @param strFullFilePath
	 * @return
	 */
	public static String delSpc(String strFullFilePath) {
		if (myisnull(strFullFilePath) == false
				&& strFullFilePath.substring(strFullFilePath.length() - 1)
						.equals(File.separator)) {
			while (strFullFilePath.substring(strFullFilePath.length() - 1)
					.equals(File.separator)) {
				strFullFilePath = strFullFilePath.substring(0,
						strFullFilePath.length() - 1);
			}
			return strFullFilePath;
		} else {
			return strFullFilePath;
		}
	}
}
