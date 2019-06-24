/*
 * @Description: 常用功能方法汇总。包括字符串类，数据库类，日期操作类，文件类
 * @Author: tt
 * @Date: 2018-12-12 17:55:41
 * @LastEditTime: 2019-04-01 15:34:25
 * @LastEditors: tt
 */
package com.controller.tt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * TT工具类
 * 
 * @备注 TT所有工具类的封装类，纯静态的调用。
 * @包括 时间类，字符串类，文件IO类等。
 */
public class Tools {
	static final public char sp = 5;// 分割符号

	/**
	 * Map<String,Object>到Map<String,String>的转换
	 * 
	 * @param mso
	 * @return
	 */
	public static TtMap msoToMss(Map<String, Object> mso) {
		TtMap params = new TtMap();
		for (String key : mso.keySet()) {
			params.put(key, mso.get(key).toString());
		}
		return params;
	}

	/**
	 * List<Map<String,String>>到List<Map<String,Object>>的转换
	 * 
	 * @param lss
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<Map<String, Object>> lssTolso(TtList lss) {
		String lssJson = jsonEncode(lss);
		List<Map<String, Object>> lmso = new ArrayList<>();
		lmso = (List<Map<String, Object>>) JSON.parse(lssJson);
		return lmso;
	}

	/**
	 * OBJECT格式的转换到JSONG字符串
	 *
	 * @param object
	 * @return
	 */
	public static String jsonEncode(Object object) {
		return JSON.toJSONString(object, SerializerFeature.PrettyFormat,
				SerializerFeature.WriteMapNullValue,
				SerializerFeature.WriteNullStringAsEmpty,
				SerializerFeature.DisableCircularReferenceDetect,
				SerializerFeature.WriteNullListAsEmpty);
	}

	/**
	 * 返回object
	 *
	 * @param mpStr
	 * @return
	 */
	public static Object jsonDeCode(String mpStr) {
		return JSON.parse(mpStr);
	}

	/**
	 * 返回mss,先mso再转换mss
	 *
	 * @param mpStr
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static TtMap jsonDeCode_mpob(String mpStr) {
		TtMap mp = new TtMap();
		Map<String, Object> mo = JSONObject.fromObject(mpStr);
		for (String key : mo.keySet()) {
			mp.put(key, mo.get(key).toString());
		}
		return mp;
	}

	/**
	 * 转换Map格式到json格式字符串
	 *
	 * @param mpStr
	 * @return
	 */
	public static String jsonEncode(TtMap mpStr) {
		return JSON.toJSONString(mpStr);
	}

	/**
	 * JSON格式字符串到TtMap Map<String,String>的转换
	 *
	 * @param mpStr
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static TtMap jsonDeCode_mp(String mpStr) {
		TtMap mp = new TtMap();
		Map<Object, Object> maps = (Map<Object, Object>) JSON.parse(mpStr);
		for (Object map : maps.entrySet()) {
			mp.put(((Entry<Object, Object>) map).getKey().toString(),
					((Entry<Object, Object>) map).getValue().toString());
		}
		return mp;
	}

	/**
	 * 返回格式为2018/09/11这样的字符串路径（取当前日期）
	 *
	 * @return
	 */
	public static String dirDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("/yyyy/MM/dd/");
		String dateString = formatter.format(new Date());
		return dateString;
	}

	/**
	 * 取MD5值
	 *
	 * @param inStr
	 * @return
	 */
	public static String md5(String inStr) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
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

	/**
	 * 获取随机字符串
	 *
	 * @param length
	 * @return
	 */
	public static String getRandomStringByLength(int length) {
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(62);
			sb.append(str.charAt(number));
		}
		return sb.toString();
	}

	/**
	 * 字符串数组中是否包含指定值
	 *
	 * @param arr
	 * @param targetValue
	 * @return
	 */
	public static boolean arrayIndexOf(String[] arr, String targetValue) {
		return Arrays.asList(arr).contains(targetValue);
	}

	/**
	 * 字符串数组中是否包含指定值
	 *
	 * @param arr
	 * @param targetValue
	 * @return
	 */
	public static boolean inArray(String[] arr, String targetValue) {
		return Arrays.asList(arr).contains(targetValue);
	}

	/**
	 * 将长时间格式字符串转换为时间 yyyyMMddHHmmss
	 *
	 * @param strDate
	 * @return
	 */
	public static String getDatetoaa() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateString = formatter.format(new Date());
		return dateString;
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
	 * @description 计算时间戳
	 * @param 无
	 * @return 当前时间秒级别的时间戳 86400秒为一天 更多的可以参考{@link Tools#time(String, Boolean)
	 *         带参数的time()}.
	 */
	public static long time() {
		return System.currentTimeMillis() / 1000;
	}

	/**
	 * @description 计算时间戳bMills代表毫秒级
	 * @param strDate
	 *            字符串的日期，为null或者""时取当前时间
	 * @param bMillis
	 *            为true时，毫秒级返回
	 * @return time(null,true)为当前时间的毫秒级时间戳
	 */
	public static long time(String strDate, Boolean bMillis) {
		long result = myIsNull(strDate) ? new Date().getTime() : Tools
				.strToDateLong(strDate).getTime();
		result = bMillis == false ? result / 1000 : result;
		return result;
	}

	/**
	 * 将长时间格式时间转换为字符串 yyyy-MM-dd HH:mm:ss
	 *
	 * @param dateDate
	 * @return 返回示例 2019-02-12 22:33:22
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
	 * @param k
	 * @return 返回示例 2019-02-12
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
	 * @return 返回示例 Date类
	 */
	public static Date strToDate(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}

	/**
	 * @description: 判断字符串是否为空，""和null时为true
	 * @param {type}
	 * @return 返回示例myIsNull("")=true myIsNull(null)=true, s为""或者null时为true
	 */
	public static boolean myIsNull(String s) {
		return s == null || s.isEmpty();
	}

	/**
	 * MAP到String的转换
	 *
	 * @param map
	 * @param fgchar
	 * @return
	 */
	public static String mapToString(TtMap map, String fgchar) {
		if (myIsNull(fgchar)) {
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
	 * 获取request的所有参数名和值安全过滤后保存到map，包括url和post表单提交的数据
	 *
	 * @param {type}
	 * @return 完整的map型的参数值，key为参数名，value为对应的值。统一转换为String
	 */
	public static TtMap getPostMap(HttpServletRequest request) {
		return getPostMap(request, false);// url参数和post参数都一起处理，url和post表单里有重复的值时，每条值用sp连接起来
	}

	/**
	 * 获取request的所有参数名和值安全过滤后保存到map
	 *
	 * @param request
	 * @param onlyPost
	 *            是否只获取post表单里面的数据，忽略url传递的参数值
	 * @return
	 */
	public static TtMap getPostMap(HttpServletRequest request, boolean onlyPost) {
		TtMap result = new TtMap();
		Enumeration<String> ennum = request.getParameterNames();
		TtMap mpUrlFiters = null;
		if (onlyPost) {
			String urlQuerysString = request.getQueryString();
			mpUrlFiters = URLRequest(urlQuerysString); // 如果只收集post数据，url里面不考虑，就要过滤掉url里重复的值
		}
		while (ennum.hasMoreElements()) {
			String paramName = (String) ennum.nextElement();

			String[] values = request.getParameterValues(paramName);
			if (onlyPost && mpUrlFiters.containsKey(paramName)) {
				if (values.length > 1) {
					values[0] = "{****}";// 跟url里面的值重复，设置第一个（即url里面重复的字段）值无效
				} else {// 只有一个
					continue;
				}
			}
			String value = "";
			for (int i = 0; i < values.length; i++) {
				if (values[i].equals("{****}")) {// 过滤掉第一个
					continue;
				}
				value += values[i] + sp;
			}
			if (myIsNull(value) == false) {
				value = value.substring(0, value.length() - 1);// 去掉char(5);
			}

		}
		return result;
	}

	/**
	 * @description: 获取URL参数列表到map
	 * @param {type}
	 * @return:
	 */
	public static TtMap getUrlParam() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		String urlQuerysString = request.getQueryString();
		TtMap mpUrl = URLRequest(urlQuerysString);
		return mpUrl;
	}

	/**
	 * 解析出url参数中的键值对 如
	 * "cn=admin&type=demo&sdo=form&id=21"cn:admin,type:demo等存入map中
	 *
	 * @return mapRequest
	 */
	public static TtMap URLRequest(String strUrlParam) {
		TtMap mapRequest = new TtMap();

		String[] arrSplit = null;
		if (strUrlParam == null) {
			return mapRequest;
		}
		arrSplit = strUrlParam.split("[&]");
		for (String strSplit : arrSplit) {
			String[] arrSplitEqual = null;
			arrSplitEqual = strSplit.split("[=]");
			// 解析出键值
			if (arrSplitEqual.length > 1) {
				// 正确解析
				mapRequest.put(arrSplitEqual[0], arrSplitEqual[1]);

			} else {
				if (arrSplitEqual[0] != "") {
					// 只有参数没有值，不加入
					mapRequest.put(arrSplitEqual[0], "");
				}
			}
		}
		return mapRequest;
	}

	/**
	 * @description: 返回删除指定字段后的url*,useAge urlKill("cn|id|type"); 不作注入过滤验证
	 * @param {type}
	 * @return:
	 */
	public static String urlKill(String s) {
		String result = "";
		try {
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes()).getRequest();
			String urlQuerysString = request.getQueryString();
			TtMap mpUrl = URLRequest(urlQuerysString);
			s = s.toLowerCase();
			String[] ss = s.split("\\|");
			for (Iterator<Entry<String, String>> it = mpUrl.entrySet()
					.iterator(); it.hasNext();) {
				Entry<String, String> item = it.next();
				if (arrayIndexOf(ss, item.getKey().toLowerCase())) {
					it.remove();
				}
				// ... todo with item
			}
			for (String key : mpUrl.keySet()) {
				if (myIsNull(key)) {
					continue;
				}
				result = result + "&" + key + "=" + mpUrl.get(key);
			}
			if (!myIsNull(result)) {
				result = "?" + result.substring(1, result.length());// 去掉前面多余出来的&
			} else {
				result = "?";
			}
			result = request.getRequestURI() + result;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @description: 获取当前URL的基本网址，如http://kjtest.kcway.net/
	 * @param {type}
	 * @return:
	 */
	public static String getBaseUrl() {
		try {
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes()).getRequest();
			return request.getScheme()
					+ "://"
					+ request.getServerName()
					+ (request.getServerPort() == 80 ? "" : ":"
							+ request.getServerPort()) + "/";
		} catch (Exception E) {
			return "";
		}
	}

	// =================================数据库相关处理方法=================================
	/**
	 * undic获取id为nid的值
	 */
	public static String unDic(TtMap tbName, String nid) {
		return tbName.get(nid);
	}

	// =================================文件io相关处理方法,更多功能参考FileTools.java=================================
	/**
	 * FileExists，检测文件/目录是否存在
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

	/**
	 * 创建文件夹，层级创建。包括子文件夹，一直到创建完成
	 * 
	 * @param strFileFullPath
	 *            要创建的目录完整路径，如 /tt/ttxx/aaa/bbbb 或者 d:\xxx\bbb\aaa\ccc
	 * @return 如果目录存在，返回成功，否则失败
	 */
	public static boolean createDir(String strFileFullPath) {
		if (isDir(strFileFullPath)) {
			return true;
		}
		File file = new File(strFileFullPath);
		file.mkdirs();
		try {
			Runtime.getRuntime().exec("chmod 777 -R " + strFileFullPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	 * 同时去掉重复的分隔符 带http的必须用小写
	 *
	 * @param strFilePath
	 * @return
	 */
	public static String formatFilePath(String strFilePath) {
		strFilePath = strFilePath.replace("\\\\", "\\");
		strFilePath = strFilePath.replace("\\\\", "\\");// 再次，防止有\\\\格式的
		strFilePath = strFilePath.replace("//", "/");
		strFilePath = strFilePath.replace("//", "/");
		strFilePath = strFilePath.replace("http:/", "http://"); // 原来http://被变成http:/了，所以恢复http的//
		strFilePath = strFilePath.replace("https:/", "https://");
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
		String r = strFullFilePath.substring(formatFilePath(strFullFilePath)
				.lastIndexOf(File.separator) + 1);
		return r;
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
		if (myIsNull(strFullFilePath) == false
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
		if (myIsNull(strFullFilePath) == false
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

	/**
	 * 复制文件，自动创建目标文件所在文件夹，如果目标文件复制前已经存在，自动先删除
	 *
	 * @param srcFile
	 *            源文件
	 * @param toFile
	 *            目标文件
	 * @return boolean，返回成功信息
	 * @throws IOException
	 */
	public static boolean ttCopyFile(String srcFile, String toFile)
			throws IOException {
		boolean result = false;
		// System.out.println("ttCopyFile1");
		if (Tools.fileExists(srcFile) == false) {
			return result;
		}
		// System.out.println("ttCopyFile11");
		if (Tools.delFile(toFile) == false) {
			return result;
		}
		// System.out.println("ttCopyFile2");
		Tools.createDir(Tools.delSpc(Tools.extractFilePath(toFile)));
		File source = new File(srcFile);
		File dest = new File(toFile);
		FileChannel inputChannel = null;
		FileChannel outputChannel = null;
		// System.out.println("ttCopyFile3");
		try {
			// System.out.println("开始复制文件：" + srcFile);
			Tools.delFile(toFile);// 删除旧的文件
			FileInputStream fSource = new FileInputStream(source);
			FileOutputStream fDest = new FileOutputStream(dest);
			inputChannel = fSource.getChannel();
			outputChannel = fDest.getChannel();
			// System.out.println("开始transferFrom：" + toFile);
			outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
			result = true;
			inputChannel.close();
			outputChannel.close();
			fSource.close();
			fDest.close();
		} catch (Exception E) {

		} finally {
		}
		if (result) {// 复制完成，检查文件是否存在。
			result = Tools.fileExists(toFile);
		}
		return result;
	}

	/**
	 * 移动文件，复制完文件，删除源文件
	 *
	 * @param srcFile
	 * @param toFile
	 * @return
	 * @throws IOException
	 */
	public static boolean ttMoveFile(String srcFile, String toFile)
			throws IOException {
		boolean result = false;
		try {
			result = ttCopyFile(srcFile, toFile);
			if (result) {
				Tools.delFile(srcFile);
			}
		} catch (IOException ee) {

			result = false;
		}
		return result;
	}

	/**
	 * 生成文件名，根据当前毫秒时间MD5后
	 */
	public static String getTimeMd5FileName() {
		String result = String.valueOf(System.currentTimeMillis());
		return md5(result);
	}

	/**
	 * 生成文件名，根据当前时间，如20190129105438907
	 */
	public static String getNowDateFileName() {
		Date dateDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmssSSS");
		String dateString = formatter.format(dateDate);
		return dateString;
	}

	/**
	 * @description: 获取项目路径
	 * @param {type}
	 * @return:
	 */
	public static String getRootPath() {
		File directory = new File("");// 参数为空
		String author = directory.getAbsolutePath();// 绝对路径;
		return addSpc(author);
	}

	/**
	 * @description: urlEnCode的简化版，支持编码
	 * @param charSet
	 *            为UTF-8或者GBK，或者其他编码
	 * @return:
	 */
	public static String urlEncode(String s, String charSet) {
		String result = "";
		try {
			result = URLEncoder.encode(s, charSet);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @description: urlEnCode的简化版
	 * @param {type}
	 * @return:
	 */
	public static String urlEncode(String s) {
		return urlEncode(s, "UTF-8");
	}

	/**
	 * @description: urlDecode时处理%符号和+符号
	 * @param {type}
	 */
	public static String replacer(String data) {
		try {
			data = data.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
			data = data.replaceAll("\\+", "%2B");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * @description: urlDeCode的简化版
	 * @param {type}
	 * @return:
	 */
	public static String urlDeCode(String s) {
		String result = "";
		try {
			result = URLDecoder.decode(replacer(s), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 转GBK，UTF8->GBK
	 * 
	 * @param {type} {type}
	 * @return: 返回
	 */
	public static String toGbk(String s) {
		try {
			s = URLEncoder.encode(s, "GBK");
			return s;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
	}

	// 首字母大写
	public static String captureName(String name) {
		name = name.substring(0, 1).toUpperCase()
				+ name.substring(1).replace("_", "");
		return name;
	}

	/**
	 * 取字符串的右n位字符
	 * 
	 * @param {type} {type}
	 * @return: 返回
	 */
	public static String getRighStr(String s, int n) {
		return s.substring(s.length() - n);
	}

	/**
	 * 取字符串的左边n位字符
	 * 
	 * @param {type} {type}
	 * @return: 返回
	 */
	public static String getLeftStr(String s, int n) {
		return s.substring(0, n);
	}

	/**
	 * 删除字符串的右边n位字符
	 * 
	 * @param {type} {type}
	 * @return: 返回
	 */
	public static String trimRight(String s, int n) {
		return s.substring(0, s.length() - n);
	}

	/**
	 * 删除字符串的左边n个字符
	 * 
	 * @param {type} {type}
	 * @return: 返回
	 */
	public static String trimLeft(String s, int n) {
		return s.substring(n);
	}

	/* 输出日期选择框的html */
	public static String htmlDate(String fieldName, String dataFormat,
			String defValue, String width) {
		if (myIsNull(dataFormat)) {
			dataFormat = "yyyy-mm-dd";
		}
		if (Tools.myIsNull(width)) {
			width = "4";
		}
		String result = "<div style=\"padding-left:15px;\" class=\"input-group date form_datetime col-md-"
				+ width
				+ "\" data-date=\"\" data-date-format=\""
				+ dataFormat
				+ "\" data-link-field=\""
				+ fieldName
				+ "\"><input class=\"form-control\" size=\"16\" type=\"text\" value=\""
				+ defValue
				+ "\" readonly><span class=\"input-group-addon\"><span class=\"glyphicon glyphicon-remove\"></span></span><span class=\"input-group-addon\"><span class=\"glyphicon glyphicon-th\"></span></span></div><input type=\"hidden\" id=\""
				+ fieldName
				+ "\" name=\""
				+ fieldName
				+ "\" value=\"\" /><br/>";
		return result;
	}

	/*
	 * 获取精确到秒的时间戳
	 * 
	 * @param date
	 * 
	 * @return
	 */
	public static int getSecondTimestampTwo(Date date) {
		if (null == date) {
			return 0;
		}
		String timestamp = String.valueOf(date.getTime() / 1000);
		return Integer.valueOf(timestamp);
	}

	/**
	 * 金额转换
	 * 
	 * @return
	 */
	public static BigDecimal getprice(int price, int num) {
		BigDecimal bigDecimal1 = new BigDecimal(price);
		BigDecimal bigDecimal2 = new BigDecimal(num);
		BigDecimal bigDecimalDivide = bigDecimal1.divide(bigDecimal2, 2,
				BigDecimal.ROUND_HALF_UP);
		return bigDecimalDivide;
	}

	public static String getnow() {
		LocalDateTime now = LocalDateTime.now(); // 获取当前系统时间
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter
				.ofPattern("yyyy-MM-dd HH:mm:ss");// 定义时间格式
		return now.format(dateTimeFormatter);
	}

}
