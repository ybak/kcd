package com.http.zxceshi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.util.Base64Test;
import com.util.jsonutil;
import com.util.md5util;

import net.sf.json.JSONObject;

public class HttpRequest {
    /**
     * 向指定URL发送GET方法的请求
     * 
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     * 
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*;charset=UTF-8");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }    
    public static String zxup(String url,String data){
//    	, String cKey
        String SENTIMENT_URL =url;//"http://cesi3.0.zhiyujinrong.com/index.php/Api/Index/index/token/9164152B7EB0AF6EA589B1BE06073304.html";        
        //http://apitest.kcway.net
        //String body ="orderNo="+orderNo+"&errmsg="+errmsg;  //new JSONArray(new String[]{text}).toString();
        //System.out.println(body);
        HttpResponse<String> jsonResponse = null;
        try {
            jsonResponse = Unirest.post(SENTIMENT_URL)
                    .header("Content-Type","application/json;charset=UTF-8")
                    //.header("ckey",cKey)
                    .body(data)
                    .asString();
            //Unirest.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(jsonResponse.getBody());
        return jsonResponse.getBody();
    }
    public static void main(String[] args) {
    	String filebase=Base64Test.getImageStr("C:/Users/Administrator/Desktop/测试结果.jpg");
		String strURL = "http://apitest.kcway.net/to_query_zx.do";
		String fronttobase = filebase;
		String oppositetobase = filebase;
		String applytobase = filebase;
		String authorizetobase = filebase;
		String hztobase = filebase;
		String name = "愿dan快乐";
		String IDcard_num = "429001199405030283";
		String phone_num = "15010219309";
		String authorize_num = "012345";
		String sum_bit = "4";
		String ckey = "04D5C8B3257FE2A268326A4B5F0BC2D2";
		//String ly = "测试";
		String orderid="143";
        Map m=new HashMap<>();
        System.out.println(md5util.getMD5(fronttobase,"UTF-8"));
        //System.out.println(md5util.JM(md5util.getMD5(fronttobase,"UTF-8")));
        m.put("fronttobase", fronttobase);
        m.put("oppositetobase", oppositetobase);
        m.put("applytobase", applytobase);
        m.put("authorizetobase", authorizetobase);
        m.put("hztobase", hztobase);
        m.put("ckey", ckey);
        m.put("name", name);
        m.put("idcard_num", IDcard_num);
        m.put("phone_num", phone_num);
        m.put("authorize_num", authorize_num);
        m.put("sum_bit", sum_bit);
        //m.put("ly", ly);
        m.put("orderid",orderid);
        JSONObject js= jsonutil.toJSONObject(m);
        System.out.println("json大小："+js.toString().length());
    	String s=zxup(strURL, js.toString());
        // String s=appadd(url, js.toString());
    	System.out.println("返回数据："+s);
	}
}