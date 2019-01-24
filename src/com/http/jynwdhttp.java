package com.http;
import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;


import com.util.jsonutil;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class jynwdhttp {

	  
	    /**
	     * httpPost
	     * @param url  路径
	     * @param jsonParam 参数
	     * @return
	     */
//	    public static JSONObject httpPost(String url,JSONObject jsonParam){
//	        return httpPost(url, jsonParam, false);
//	    }
//	 
	    /**
	     * post请求
	     * @param url         url地址
	     * @param jsonParam     参数
	     * @param noNeedResponse    不需要返回结果
	     * @return
	     */
	    public static String httpPost(String url,JSONObject jsonParam, boolean noNeedResponse){
	        //post请求返回结果
	        DefaultHttpClient httpClient = new DefaultHttpClient();
	        JSONObject jsonResult = null;
	        HttpPost method = new HttpPost(url);
	        try {
	            if (null != jsonParam) {
	                //解决中文乱码问题
	                StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");
	                entity.setContentEncoding("UTF-8");
	                entity.setContentType("application/json");
	                method.setEntity(entity);
	            }
	            HttpResponse result = httpClient.execute(method);
	            url = URLDecoder.decode(url, "UTF-8");
	            /**请求发送成功，并得到响应**/
	            if (result.getStatusLine().getStatusCode() == 200) {
	                String str = "";
	                try {
	                    /**读取服务器返回过来的json字符串数据**/
	                    str = EntityUtils.toString(result.getEntity());
	                    if (noNeedResponse) {
	                        return null;
	                    }
	                    /**把json字符串转换成json对象**/
	                    jsonResult = JSONObject.fromObject(str);
	                } catch (Exception e) {
	                 
	                }
	            }
	        } catch (IOException e) {
	            
	        }
	        System.out.println(jsonResult.toString());
	        return jsonResult.toString();
	    }
	    
	    
	    public static void main(String[] args) {
	    	
	    	List<Map<String, String>> ml=new ArrayList<Map<String, String>>();
//	    	Map m=new HashMap();
//	    	m.put("orderrNo", "1");
//	    	m.put("errcode", "1");
//	    	m.put("errmsg", "成功");
//	    	m.put("pdfurl",null);
//	    	m.put("addtime",creditutil.time());
//	    	m.put("sign", "1");
//	    	m.put("time", "1"); 
//	    	//System.out.println(jsonutil.toJSONString(m));
//	    	ml.add(m);
//	    	String text=jsonutil.toJSONString(ml).replace("[", "").replace("]", "");
//	    	JSONObject myJsonObject =JSONObject.fromObject(text);
//	    	System.out.println(myJsonObject);
//	    	String s=httpPost("http://test.creditplatform.jiayincredit.com/personal/kcway/receive-report",myJsonObject,false);
//	    	//System.out.println(s);
//	    	
//	    	
//	    	
	    	Map m1=new HashMap();
	       	m1.put("opAccount", "1");
	    	m1.put("opName", "1");
	    	m1.put("cuName", "1");
	    	m1.put("idCard", "1");
	    	m1.put("phoneNo", "1");
	    	m1.put("orderNo", "1");
	    	m1.put("authNo","1");
	    	m1.put("errcode", "1");
	    	m1.put("errmsg", "1");   
	    	m1.put("orderTime", "1"); 
	    	m1.put("sign", "1"); 
	    	m1.put("time", "1"); 
	    	ml.add(m1);
	    	String text1=jsonutil.toJSONString(ml).replace("[", "").replace("]", "");
	    	JSONObject myJsonObject1 =JSONObject.fromObject(text1);
	    	System.out.println(myJsonObject1);
	    	String s1=httpPost("http://test.creditplatform.jiayincredit.com/personal/kcway/receive-auditinfo",myJsonObject1,false);
	    	System.out.println(s1);
	    	
	    	
		}
}
