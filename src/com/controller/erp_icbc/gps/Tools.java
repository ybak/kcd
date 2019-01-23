/*
* @Description: 常用功能方法汇总。包括字符串类，数据库类，日期操作类，文件类
* @Author: tt
* @Date: 2018-12-12 17:55:41
 * @LastEditTime: 2019-01-22 10:59:47
 * @LastEditors: tt
*/
package com.controller.erp_icbc.gps;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.io.File;
import java.security.MessageDigest;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Pattern;

public class Tools<K, V> {
    static final public char sp = 5;// 分割符号
    public static boolean showlog = true;

    /**
     * =================================字符串等常用处理方法=================================
     * map到jsong字符串的处理，需要引用阿里巴巴的开源组件fastjson在pom.xml加入以下代码 <dependency>
     * <groupId>com.alibaba</groupId> <artifactId>fastjson</artifactId>
     * <version>1.2.4</version> </dependency>
     *
     * @param mpStr
     * @return
     */
    private static void mylog(String mString) {
        if (showlog == true) {
            // mylog(this.toString() + ":" + mString);
            Log log = LogFactory.getLog(Tools.class);
            log.info(mString);
        }
    }

    /**
     * Map<String,Object>到Map<String,String>的转换
     * 
     * @param mso
     * @return
     */
    public static Map<String, String> msoToMss(Map<String, Object> mso) {
        Map<String, String> params = new HashMap<>();
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
    public static List<Map<String, Object>> lssTolso(List<Map<String, String>> lss) {
        String lssJson = jsonEnCode(lss);
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
    public static String jsonEnCode(Object object) {
        return JSON.toJSONString(object, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.DisableCircularReferenceDetect,
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
    public static Map<String, String> jsonDeCode_mpob(String mpStr) {
        Map<String, String> mp = new HashMap<>();
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
    public static String jsonEnCode(Map<String, String> mpStr) {
        return JSON.toJSONString(mpStr);
    }

    /**
     * JSON格式字符串到Map<String,String>的转换
     *
     * @param mpStr
     * @return
     */
    public static Map<String, String> jsonDeCode_mp(String mpStr) {
        Map<String, String> mp = new HashMap<>();
        Map maps = (Map) JSON.parse(mpStr);
        for (Object map : maps.entrySet()) {
            mp.put(((Map.Entry) map).getKey().toString(), ((Map.Entry) map).getValue().toString());
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
            mylog(e.toString());
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

    public static long time() {
        return System.currentTimeMillis() / 1000;
    }

    public static long time(String strDate, Boolean bMillis) {
        long result = myisnull(strDate) ? new Date().getTime() : Tools.strToDateLong(strDate).getTime();
        result = bMillis == false ? result / 1000 : result;
        return result;
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
     * @param k
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
        return (s == null || s.isEmpty());
    }

    /**
     * 删除map中的某个key
     */
    public static Map<String, String> deleteKeyOfMap(Map<String, String> paramsMap, String ID) {
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
            HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest()
                    .getSession();
            long id = (long) session.getAttribute("tt_mid");
            /*
             * String idmd5 =(String) session.getAttribute("idmd5"); Map<String, String>
             * info
             * =recinfo("select mid from sys_session where idmd5='"+idmd5+"' and outdt=0");
             * if(info.size()<=0){//如果已经被其他人登陆过了，返回未登陆状态 id = 0 ; }
             */
            return id;
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
            return (boolean) ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest()
                    .getSession().getAttribute("tt_isadmin");
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 指定的list里是否包含某个String
     *
     * @param str
     * @param arr
     * @return
     */
    public static boolean in_array_list(String str, List<String> arr) {
        return arr.contains(str);
    }

    /**
     * MAP到String的转换
     *
     * @param map
     * @param fgchar
     * @return
     */
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
        mpNoFilters.put("wxmini_car_store", "1");
        mpNoFilters.put("car_stora", "1");
        mpNoFilters.put("color", "1");
        if (mpNoFilters.get(str) == "1") {
            return false;
        }
        String inj_str = "'|and|exec|insert|select|delete|update|count|*|%|chr|mid|master|truncate|char|declare|;|or|+|,|alert";
        // 这里的东西还可以自己添加
        char af = 5;
        String[] inj_stra = inj_str.split(String.valueOf(af));
        for (int i = 0; i < inj_stra.length; i++) {
            if (str.indexOf(inj_stra[i]) >= 0) {
                System.err.println(str + "_注入__，匹配过滤关键字：" + inj_stra[i]);
                return true;
            }
        }
        return false;
    }

    /**
     * @description: js过滤替换，正则表达式方法,去掉js标签
     * @param {type}
     * @return:
     */
    public static String js_inj_replace(String str) {
        str = java.util.regex.Pattern.compile("<[^><]*script[^><]*>", Pattern.CASE_INSENSITIVE).matcher(str)
                .replaceAll("");
        return str;
    }

    public static Map<String, String> getpostmap(HttpServletRequest request) {
        return getpostmap(request, false);// url参数和post参数都一起处理，url和post表单里有重复的值时，每条值用sp连接起来
    }

    /**
     * 获取request的所有参数名和值保存到map
     *
     * @param request
     * @return
     */
    public static Map<String, String> getpostmap(HttpServletRequest request, boolean onlyPost) {
        Map<String, String> result = new HashMap<>();
        Enumeration<String> ennum = request.getParameterNames();
        Map<String, String> mpUrlFiters = null;
        if (onlyPost){
            String urlQuerysString = request.getQueryString();
            mpUrlFiters = URLRequest(urlQuerysString); //如果只收集post数据，url里面不考虑，就要过滤掉url里重复的值
        }
        while (ennum.hasMoreElements()) {
            String paramName = (String) ennum.nextElement();
            if (sql_inj(paramName) == true) {// 过滤参数名
                mylog("mysql参数名注入：" + paramName);
                continue;
            } else {

            }
            String[] values = request.getParameterValues(paramName);
            if (values.length > 0 && onlyPost && mpUrlFiters.containsKey(paramName)) {
                values[0] = "{****}";//跟url里面的值重复，设置第一个（即url里面重复的字段）值无效
            }
            String value = "";
            for (int i = 0; i < values.length; i++) {
                if (values[i].equals("{****}")) {// 过滤掉第一个
                    continue;
                }
                value += values[i] + sp;
            }
            if (myisnull(value) == false) {
                value = value.substring(0, value.length() - 1);// 去掉char(5);
            }
            if (sql_inj(value) == true) {// 过滤参数值
                mylog("mysql参数值注入：" + value);
            } else {
                result.put(js_inj_replace(paramName), js_inj_replace(value));
            }
        }
        return result;
    }

    /**
     * @description: 获取URL参数列表到
     * @param {type}
     * @return:
     */
    public static Map<String, String> getUrlParam() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        String urlQuerysString = request.getQueryString();
        mylog("getQueryString:" + urlQuerysString);
        Map<String, String> mpUrl = URLRequest(urlQuerysString);
        return mpUrl;
    }

    /**
     * 解析出url参数中的键值对 如 "cn=admin&type=demo&sdo=form&id=21"cn:admin,type:demo等存入map中
     * 
     * @return mapRequest
     */
    public static Map<String, String> URLRequest(String strUrlParam) {
        Map<String, String> mapRequest = new HashMap<String, String>();

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

    /* 返回删除指定字段后的url*,useAge urlKill("cn|id|type"); 不作注入过滤验证 */
    public static String urlKill(String s) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        String urlQuerysString = request.getQueryString();
        mylog("getQueryString:" + urlQuerysString);
        String result = "";
        Map<String, String> mpUrl = URLRequest(urlQuerysString);
        s = s.toLowerCase();
        String[] ss = s.split("\\|");
        for (Iterator<Map.Entry<String, String>> it = mpUrl.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, String> item = it.next();
            if (arrayIndexOf(ss, item.getKey().toLowerCase())) {
                it.remove();
            }
            // ... todo with item
        }
        for (String key : mpUrl.keySet()) {
            if (myisnull(key)) {
                continue;
            }
            result = result + "&" + key + "=" + mpUrl.get(key);
        }
        if (!myisnull(result)) {
            result = "?" + result.substring(1, result.length());// 去掉前面多余出来的&
        } else {
            result = "?";
        }
        result = request.getRequestURI() + result;
        return result;
    }

    /**
     * @description: 获取当前URL的基本网址，如http://kjtest.kcway.net/
     * @param {type}
     * @return:
     */
    public static String getBaseUrl() {
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                    .getRequest();
            return request.getScheme() + "://" + request.getServerName()
                    + (request.getServerPort() == 80 ? "" : ":" + request.getServerPort()) + "/";
        } catch (Exception E) {
            mylog(E.getMessage());
            return "";
        }
    }




   
   
  
    /**
     * =================================文件io相关处理方法,更多功能参考FileTools.java=================================
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

    public static boolean createDir(String strFileFullPath) {
        if (isDir(strFileFullPath)) {
            return true;
        }
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
     * 格式化一个文件路径字符串，处理路径分隔符斜杆和反斜杆windows下\\,linux下/的问题，格式化后变成目前部署的环境下正确的分隔符，同时去掉重复的分隔符
     * 带http的必须用小写
     *
     * @param strFilePath
     * @return
     */
    public static String formatFilePath(String strFilePath) {
        strFilePath = strFilePath.replace("\\\\", "\\");
        strFilePath = strFilePath.replace("\\\\", "\\");
        strFilePath = strFilePath.replace("//", "/");
        strFilePath = strFilePath.replace("//", "/");
        strFilePath = strFilePath.replace("http:/", "http://"); // 原来http://被变成http:/了，所以恢复http的//
        strFilePath = strFilePath.replace("https:/", "https://");
        return strFilePath.replace('/', File.separatorChar).replace('\\', File.separatorChar);
    }

    /**
     * 获取一个长路径字符串的文件名
     *
     * @param strFullFilePath
     * @return
     */
    public static String extractFileName(String strFullFilePath) {
        return strFullFilePath.substring(formatFilePath(strFullFilePath).lastIndexOf(File.separator) + 1);
    }

    /**
     * 获取一个长路径串的去掉文件名后的，保留/或者\\
     *
     * @param strFullFilePath
     * @return
     */
    public static String extractFilePath(String strFullFilePath) {
        return strFullFilePath.substring(0, strFullFilePath.length() - extractFileName(strFullFilePath).length());
    }

    /**
     * 给当前路径末尾加上分隔符\\或者/
     *
     * @param strFullFilePath
     * @return
     */
    public static String addSpc(String strFullFilePath) {
        if (myisnull(strFullFilePath) == false
                && !strFullFilePath.substring(strFullFilePath.length() - 1).equals(File.separator)) {
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
                && strFullFilePath.substring(strFullFilePath.length() - 1).equals(File.separator)) {
            while (strFullFilePath.substring(strFullFilePath.length() - 1).equals(File.separator)) {
                strFullFilePath = strFullFilePath.substring(0, strFullFilePath.length() - 1);
            }
            return strFullFilePath;
        } else {
            return strFullFilePath;
        }
    }

    /**
     * 生成文件名，根据当前毫秒时间
     */
    public static String getTimeMd5FileName() {
        String result = String.valueOf(System.currentTimeMillis());
        return md5(result);
    }

   

    /**
     * @description: 格式化结果
     * @param {type}
     * @return:
     */
    public static void formatResult(Map<String, String> result, boolean success, int code, String msg,
            String next_url) {
        result.put("success", success ? "true" : "false");
        result.put("errorcode", success ? "0" : String.valueOf(code));
        result.put("msg", msg);
        result.put("next_url", next_url);
    }

    /**
     * @description: 格式化结果，结果里带object
     * @param {type}
     * @return:
     */
    public static void formatResultobj(Map<String, Object> result, boolean success, int code, String msg) {
        result.put("success", success ? true : false);
        result.put("errorcode", success ? 0 : code);
        result.put("msg", msg);
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

 
}
