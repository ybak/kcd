/*
 * @Description: ���ù��ܷ������ܡ������ַ����࣬���ݿ��࣬���ڲ����࣬�ļ���
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
 * TT������
 * 
 * @��ע TT���й�����ķ�װ�࣬����̬�ĵ��á�
 * @���� ʱ���࣬�ַ����࣬�ļ�IO��ȡ�
 */
public class Tools {
	static final public char sp = 5;// �ָ����

	/**
	 * Map<String,Object>��Map<String,String>��ת��
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
	 * List<Map<String,String>>��List<Map<String,Object>>��ת��
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
	 * OBJECT��ʽ��ת����JSONG�ַ���
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
	 * ����object
	 *
	 * @param mpStr
	 * @return
	 */
	public static Object jsonDeCode(String mpStr) {
		return JSON.parse(mpStr);
	}

	/**
	 * ����mss,��mso��ת��mss
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
	 * ת��Map��ʽ��json��ʽ�ַ���
	 *
	 * @param mpStr
	 * @return
	 */
	public static String jsonEncode(TtMap mpStr) {
		return JSON.toJSONString(mpStr);
	}

	/**
	 * JSON��ʽ�ַ�����TtMap Map<String,String>��ת��
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
	 * ���ظ�ʽΪ2018/09/11�������ַ���·����ȡ��ǰ���ڣ�
	 *
	 * @return
	 */
	public static String dirDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("/yyyy/MM/dd/");
		String dateString = formatter.format(new Date());
		return dateString;
	}

	/**
	 * ȡMD5ֵ
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
	 * ��ȡ����ַ���
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
	 * �ַ����������Ƿ����ָ��ֵ
	 *
	 * @param arr
	 * @param targetValue
	 * @return
	 */
	public static boolean arrayIndexOf(String[] arr, String targetValue) {
		return Arrays.asList(arr).contains(targetValue);
	}

	/**
	 * �ַ����������Ƿ����ָ��ֵ
	 *
	 * @param arr
	 * @param targetValue
	 * @return
	 */
	public static boolean inArray(String[] arr, String targetValue) {
		return Arrays.asList(arr).contains(targetValue);
	}

	/**
	 * ����ʱ���ʽ�ַ���ת��Ϊʱ�� yyyyMMddHHmmss
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
	 * ����ʱ���ʽ�ַ���ת��Ϊʱ�� yyyy-MM-dd HH:mm:ss
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
	 * @description ����ʱ���
	 * @param ��
	 * @return ��ǰʱ���뼶���ʱ��� 86400��Ϊһ�� ����Ŀ��Բο�{@link Tools#time(String, Boolean)
	 *         ��������time()}.
	 */
	public static long time() {
		return System.currentTimeMillis() / 1000;
	}

	/**
	 * @description ����ʱ���bMills������뼶
	 * @param strDate
	 *            �ַ��������ڣ�Ϊnull����""ʱȡ��ǰʱ��
	 * @param bMillis
	 *            Ϊtrueʱ�����뼶����
	 * @return time(null,true)Ϊ��ǰʱ��ĺ��뼶ʱ���
	 */
	public static long time(String strDate, Boolean bMillis) {
		long result = myIsNull(strDate) ? new Date().getTime() : Tools
				.strToDateLong(strDate).getTime();
		result = bMillis == false ? result / 1000 : result;
		return result;
	}

	/**
	 * ����ʱ���ʽʱ��ת��Ϊ�ַ��� yyyy-MM-dd HH:mm:ss
	 *
	 * @param dateDate
	 * @return ����ʾ�� 2019-02-12 22:33:22
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
	 * ����ʱ���ʽʱ��ת��Ϊ�ַ��� yyyy-MM-dd
	 *
	 * @param dateDate
	 * @param k
	 * @return ����ʾ�� 2019-02-12
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
	 * ����ʱ���ʽ�ַ���ת��Ϊʱ�� yyyy-MM-dd
	 *
	 * @param strDate
	 * @return ����ʾ�� Date��
	 */
	public static Date strToDate(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}

	/**
	 * @description: �ж��ַ����Ƿ�Ϊ�գ�""��nullʱΪtrue
	 * @param {type}
	 * @return ����ʾ��myIsNull("")=true myIsNull(null)=true, sΪ""����nullʱΪtrue
	 */
	public static boolean myIsNull(String s) {
		return s == null || s.isEmpty();
	}

	/**
	 * MAP��String��ת��
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
	 * ��ȡrequest�����в�������ֵ��ȫ���˺󱣴浽map������url��post���ύ������
	 *
	 * @param {type}
	 * @return ������map�͵Ĳ���ֵ��keyΪ��������valueΪ��Ӧ��ֵ��ͳһת��ΪString
	 */
	public static TtMap getPostMap(HttpServletRequest request) {
		return getPostMap(request, false);// url������post������һ����url��post�������ظ���ֵʱ��ÿ��ֵ��sp��������
	}

	/**
	 * ��ȡrequest�����в�������ֵ��ȫ���˺󱣴浽map
	 *
	 * @param request
	 * @param onlyPost
	 *            �Ƿ�ֻ��ȡpost����������ݣ�����url���ݵĲ���ֵ
	 * @return
	 */
	public static TtMap getPostMap(HttpServletRequest request, boolean onlyPost) {
		TtMap result = new TtMap();
		Enumeration<String> ennum = request.getParameterNames();
		TtMap mpUrlFiters = null;
		if (onlyPost) {
			String urlQuerysString = request.getQueryString();
			mpUrlFiters = URLRequest(urlQuerysString); // ���ֻ�ռ�post���ݣ�url���治���ǣ���Ҫ���˵�url���ظ���ֵ
		}
		while (ennum.hasMoreElements()) {
			String paramName = (String) ennum.nextElement();

			String[] values = request.getParameterValues(paramName);
			if (onlyPost && mpUrlFiters.containsKey(paramName)) {
				if (values.length > 1) {
					values[0] = "{****}";// ��url�����ֵ�ظ������õ�һ������url�����ظ����ֶΣ�ֵ��Ч
				} else {// ֻ��һ��
					continue;
				}
			}
			String value = "";
			for (int i = 0; i < values.length; i++) {
				if (values[i].equals("{****}")) {// ���˵���һ��
					continue;
				}
				value += values[i] + sp;
			}
			if (myIsNull(value) == false) {
				value = value.substring(0, value.length() - 1);// ȥ��char(5);
			}

		}
		return result;
	}

	/**
	 * @description: ��ȡURL�����б�map
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
	 * ������url�����еļ�ֵ�� ��
	 * "cn=admin&type=demo&sdo=form&id=21"cn:admin,type:demo�ȴ���map��
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
			// ��������ֵ
			if (arrSplitEqual.length > 1) {
				// ��ȷ����
				mapRequest.put(arrSplitEqual[0], arrSplitEqual[1]);

			} else {
				if (arrSplitEqual[0] != "") {
					// ֻ�в���û��ֵ��������
					mapRequest.put(arrSplitEqual[0], "");
				}
			}
		}
		return mapRequest;
	}

	/**
	 * @description: ����ɾ��ָ���ֶκ��url*,useAge urlKill("cn|id|type"); ����ע�������֤
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
				result = "?" + result.substring(1, result.length());// ȥ��ǰ����������&
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
	 * @description: ��ȡ��ǰURL�Ļ�����ַ����http://kjtest.kcway.net/
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

	// =================================���ݿ���ش�����=================================
	/**
	 * undic��ȡidΪnid��ֵ
	 */
	public static String unDic(TtMap tbName, String nid) {
		return tbName.get(nid);
	}

	// =================================�ļ�io��ش�����,���๦�ܲο�FileTools.java=================================
	/**
	 * FileExists������ļ�/Ŀ¼�Ƿ����
	 */
	public static boolean fileExists(String strFileFullPath) {
		File file = new File(strFileFullPath);
		return file.exists();
	}

	/**
	 * �Ƿ�Ŀ¼
	 *
	 * @param strFileFullPath
	 * @return
	 */
	public static boolean isDir(String strFileFullPath) {
		File file = new File(strFileFullPath);
		return file.exists() ? file.isDirectory() : false;
	}

	/**
	 * �����ļ��У��㼶�������������ļ��У�һֱ���������
	 * 
	 * @param strFileFullPath
	 *            Ҫ������Ŀ¼����·������ /tt/ttxx/aaa/bbbb ���� d:\xxx\bbb\aaa\ccc
	 * @return ���Ŀ¼���ڣ����سɹ�������ʧ��
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
	 * ɾ��һ���ļ�/Ŀ¼��Ŀ¼ʱ�����Ŀ¼�����๦�ܲο�FileTools.java
	 *
	 * @param strFileFullPath
	 * @return
	 */
	public static boolean delFile(String strFileFullPath) {
		File file = new File(strFileFullPath);
		if (file.exists()) {// �ļ�����
			return file.delete();
		} else { // todo �����ڣ�ֱ�ӷ�����
			return true;
		}
	}

	/**
	 * ��ȡ�ļ���չ��������.
	 *
	 * @param strFullFilePath
	 * @return
	 */
	public static String getFileExt(String strFullFilePath) {
		return strFullFilePath.substring(strFullFilePath.lastIndexOf(".") + 1);
	}

	/**
	 * ��ȡ�ļ���չ��������.
	 *
	 * @param strFullFilePath
	 * @return
	 */
	public static String extractFileExt(String strFullFilePath) {
		return getFileExt(strFullFilePath);
	}

	/**
	 * ��ʽ��һ���ļ�·���ַ���������·���ָ���б�˺ͷ�б��windows��\\,linux��/�����⣬��ʽ������Ŀǰ����Ļ�������ȷ�ķָ�����
	 * ͬʱȥ���ظ��ķָ��� ��http�ı�����Сд
	 *
	 * @param strFilePath
	 * @return
	 */
	public static String formatFilePath(String strFilePath) {
		strFilePath = strFilePath.replace("\\\\", "\\");
		strFilePath = strFilePath.replace("\\\\", "\\");// �ٴΣ���ֹ��\\\\��ʽ��
		strFilePath = strFilePath.replace("//", "/");
		strFilePath = strFilePath.replace("//", "/");
		strFilePath = strFilePath.replace("http:/", "http://"); // ԭ��http://�����http:/�ˣ����Իָ�http��//
		strFilePath = strFilePath.replace("https:/", "https://");
		return strFilePath.replace('/', File.separatorChar).replace('\\',
				File.separatorChar);
	}

	/**
	 * ��ȡһ����·���ַ������ļ���
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
	 * ��ȡһ����·������ȥ���ļ�����ģ�����/����\\
	 *
	 * @param strFullFilePath
	 * @return
	 */
	public static String extractFilePath(String strFullFilePath) {
		return strFullFilePath.substring(0, strFullFilePath.length()
				- extractFileName(strFullFilePath).length());
	}

	/**
	 * ����ǰ·��ĩβ���Ϸָ���\\����/
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
	 * ɾ��·����ĩβ��/����\\
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
	 * �����ļ����Զ�����Ŀ���ļ������ļ��У����Ŀ���ļ�����ǰ�Ѿ����ڣ��Զ���ɾ��
	 *
	 * @param srcFile
	 *            Դ�ļ�
	 * @param toFile
	 *            Ŀ���ļ�
	 * @return boolean�����سɹ���Ϣ
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
			// System.out.println("��ʼ�����ļ���" + srcFile);
			Tools.delFile(toFile);// ɾ���ɵ��ļ�
			FileInputStream fSource = new FileInputStream(source);
			FileOutputStream fDest = new FileOutputStream(dest);
			inputChannel = fSource.getChannel();
			outputChannel = fDest.getChannel();
			// System.out.println("��ʼtransferFrom��" + toFile);
			outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
			result = true;
			inputChannel.close();
			outputChannel.close();
			fSource.close();
			fDest.close();
		} catch (Exception E) {

		} finally {
		}
		if (result) {// ������ɣ�����ļ��Ƿ���ڡ�
			result = Tools.fileExists(toFile);
		}
		return result;
	}

	/**
	 * �ƶ��ļ����������ļ���ɾ��Դ�ļ�
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
	 * �����ļ��������ݵ�ǰ����ʱ��MD5��
	 */
	public static String getTimeMd5FileName() {
		String result = String.valueOf(System.currentTimeMillis());
		return md5(result);
	}

	/**
	 * �����ļ��������ݵ�ǰʱ�䣬��20190129105438907
	 */
	public static String getNowDateFileName() {
		Date dateDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmssSSS");
		String dateString = formatter.format(dateDate);
		return dateString;
	}

	/**
	 * @description: ��ȡ��Ŀ·��
	 * @param {type}
	 * @return:
	 */
	public static String getRootPath() {
		File directory = new File("");// ����Ϊ��
		String author = directory.getAbsolutePath();// ����·��;
		return addSpc(author);
	}

	/**
	 * @description: urlEnCode�ļ򻯰棬֧�ֱ���
	 * @param charSet
	 *            ΪUTF-8����GBK��������������
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
	 * @description: urlEnCode�ļ򻯰�
	 * @param {type}
	 * @return:
	 */
	public static String urlEncode(String s) {
		return urlEncode(s, "UTF-8");
	}

	/**
	 * @description: urlDecodeʱ����%���ź�+����
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
	 * @description: urlDeCode�ļ򻯰�
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
	 * תGBK��UTF8->GBK
	 * 
	 * @param {type} {type}
	 * @return: ����
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

	// ����ĸ��д
	public static String captureName(String name) {
		name = name.substring(0, 1).toUpperCase()
				+ name.substring(1).replace("_", "");
		return name;
	}

	/**
	 * ȡ�ַ�������nλ�ַ�
	 * 
	 * @param {type} {type}
	 * @return: ����
	 */
	public static String getRighStr(String s, int n) {
		return s.substring(s.length() - n);
	}

	/**
	 * ȡ�ַ��������nλ�ַ�
	 * 
	 * @param {type} {type}
	 * @return: ����
	 */
	public static String getLeftStr(String s, int n) {
		return s.substring(0, n);
	}

	/**
	 * ɾ���ַ������ұ�nλ�ַ�
	 * 
	 * @param {type} {type}
	 * @return: ����
	 */
	public static String trimRight(String s, int n) {
		return s.substring(0, s.length() - n);
	}

	/**
	 * ɾ���ַ��������n���ַ�
	 * 
	 * @param {type} {type}
	 * @return: ����
	 */
	public static String trimLeft(String s, int n) {
		return s.substring(n);
	}

	/* �������ѡ����html */
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
	 * ��ȡ��ȷ�����ʱ���
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
	 * ���ת��
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
		LocalDateTime now = LocalDateTime.now(); // ��ȡ��ǰϵͳʱ��
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter
				.ofPattern("yyyy-MM-dd HH:mm:ss");// ����ʱ���ʽ
		return now.format(dateTimeFormatter);
	}

}
