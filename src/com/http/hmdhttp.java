package com.http;

import com.google.gson.GsonBuilder;
import org.apache.commons.codec.binary.Hex;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class hmdhttp {
	
//	//测试版的key
//		/*protected $appkey ='mur1eur6wf';// 'mur1eur6wf';	
//		protected $apiurl ="https://testapi.ibeesaas.com/daas/v1/";
//		protected $baseurl="https://testapi.ibeesaas.com";
//		protected $ak ='L3yGoULTW9s1f4OyWA13GnoxL0JvzTHP';// 'L3yGoULTW9s1f4OyWA13GnoxL0JvzTHP';
//		protected $sk ='Xej8umIR2Vg0QpUDERDPvKu74O838QC8';// 'Xej8umIR2Vg0QpUDERDPvKu74O838QC8';*/
//		
//		//下面是正式版的
//		protected $appkey ='hilw7pgpzs';// 'mur1eur6wf';
//		protected $apiurl = 'https://api.ibeesaas.com/daas/v1/';//https://testapi.ibeesaas.com/daas/v1/';
//		protected $baseurl ='https://api.ibeesaas.com';// 'https://testapi.ibeesaas.com';
//		protected $ak ='8IdRjhNejXoquTXEYslnV6PB3PuyCKyo';// 'L3yGoULTW9s1f4OyWA13GnoxL0JvzTHP';
//		protected $sk ='NnHHBkIg4hq1agdRNfTW3eCFBkZ2TQPl';// 'Xej8umIR2Vg0QpUDERDPvKu74O838QC8';

	public static String hmd(int sync,String idCardNo,String name,String phoneNo,String callbackUrl) throws NoSuchAlgorithmException, ClientProtocolException, IOException{				
		String url = "https://testapi.ibeesaas.com/daas/v1/tasks";
		String urlPath ="/daas/v1/tasks";
		String method = "POST";
		String taskType ="black";
		String appKey = "hilw7pgpzs";
		//拼接请求参数
        String queryParam = "appKey=" + appKey + "&taskType=" + taskType;
		String ak="8IdRjhNejXoquTXEYslnV6PB3PuyCKyo";// 'L3yGoULTW9s1f4OyWA13GnoxL0JvzTHP";
		String sk="NnHHBkIg4hq1agdRNfTW3eCFBkZ2TQPl";
		
		//takenutil taken=new takenutil(ak,sk);				
		  //post请求body
        Map<String, Object> bodyMap = new LinkedHashMap<String, Object>();
       
	    Map<String, Object> bodyMap1 = new LinkedHashMap<String, Object>();
        bodyMap1.put("sync",sync); 
        bodyMap1.put("idCardNo",idCardNo); 
        bodyMap1.put("name",name); 
        bodyMap1.put("phoneNo", phoneNo); 
        // TODO 回调URL需要是自己服务的真实URL
        bodyMap.put("callbackUrl",callbackUrl);
        bodyMap.put("data",bodyMap1);
      //将请求体序列
        String body = new GsonBuilder().disableHtmlEscaping().serializeNulls().create().toJson(bodyMap);
       // System.out.println("body:"+body);
        int expireTime = (int) (System.currentTimeMillis()/1000 + 1800);
       // System.out.println("expireTime:"+expireTime);
        String s= generateToken(ak,sk,urlPath, method,queryParam, body, expireTime);
        //System.out.println("taken:"+s);
        String requestUrl = url + "?appKey=" + appKey + "&taskType=" + taskType;
       // System.out.println("requestUrl:"+requestUrl);
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(requestUrl);
        post.setHeader("X-IbeeAuth-Token",s);
        StringEntity stringEntity = new StringEntity(body, "UTF-8");
        stringEntity.setContentType("application/json");
        post.setEntity(stringEntity);
        HttpResponse response = httpClient.execute(post);
        StringBuilder builder = new StringBuilder();
        if (response != null) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent(), "UTF-8"));
                String line = "";
               
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }
                //System.out.println(builder.toString());
            }
        }
		return builder.toString();
		
	}
	
	
	
	public static void main(String[] args) throws ClientProtocolException, IOException, NoSuchAlgorithmException {
		int sync=1;
		String idCardNo="411403199512108410";
		String name="张三";
		String phoneNo="18629874563";
		String callbackUrl="https://api.ibeesaas.com";
		
		String s= hmd(sync,idCardNo,name,phoneNo,callbackUrl);
		System.out.println("result:"+s);
		
//		String text="{"
//				+ "\"callbackUrl\":\"https://testapi.ibeesaas.com\","
//				+ "\"data\":{"
//				+ "\"sync\":1,"
//				+ "\"idCardNo\":\"612301198805050293\","
//				+ "\"name\":\"张三\","
//				+ "\"phoneNo\":\"18629874563\""				
//				+ "}";
//		JsonNode s=	hmd(text);
//		System.out.println(s.toString());
//		String url = "https://testapi.ibeesaas.com/daas/v1/tasks";
//		String urlPath ="/daas/v1/tasks";
//		String method = "POST";
//		String taskType ="black";
//		String appKey = "hilw7pgpzs";
//		//拼接请求参数
//        String queryParam = "appKey=" + appKey + "&taskType=" + taskType;
//		String ak="8IdRjhNejXoquTXEYslnV6PB3PuyCKyo";// 'L3yGoULTW9s1f4OyWA13GnoxL0JvzTHP";
//		String sk="NnHHBkIg4hq1agdRNfTW3eCFBkZ2TQPl";
//		
//		//takenutil taken=new takenutil(ak,sk);				
//		  //post请求body
//        Map<String, Object> bodyMap = new LinkedHashMap<String, Object>();
//       
//	    Map<String, Object> bodyMap1 = new LinkedHashMap<String, Object>();
//        bodyMap1.put("sync",1); 
//        bodyMap1.put("idCardNo","411403199512108410"); 
//        bodyMap1.put("name","张三"); 
//        bodyMap1.put("phoneNo", "18629874563"); 
//        // TODO 回调URL需要是自己服务的真实URL
//        bodyMap.put("callbackUrl", "https://api.ibeesaas.com");
//        bodyMap.put("data",bodyMap1);
//      //将请求体序列
//        String body = new GsonBuilder().disableHtmlEscaping().serializeNulls().create().toJson(bodyMap);
//        System.out.println("body:"+body);
//        int expireTime = (int) (System.currentTimeMillis()/1000 + 1800);
//        System.out.println("expireTime:"+expireTime);
//        String s= generateToken(ak,sk,urlPath, method,queryParam, body, expireTime);
//        System.out.println("taken:"+s);
//        String requestUrl = url + "?appKey=" + appKey + "&taskType=" + taskType;
//        System.out.println("requestUrl:"+requestUrl);
//        HttpClient httpClient = HttpClientBuilder.create().build();
//        HttpPost post = new HttpPost(requestUrl);
//        post.setHeader("X-IbeeAuth-Token",s);
//        StringEntity stringEntity = new StringEntity(body, "UTF-8");
//        stringEntity.setContentType("application/json");
//        post.setEntity(stringEntity);
//        HttpResponse response = httpClient.execute(post);
//        if (response != null) {
//            HttpEntity entity = response.getEntity();
//            if (entity != null) {
//                BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent(), "UTF-8"));
//                String line = "";
//                StringBuilder builder = new StringBuilder();
//                while ((line = reader.readLine()) != null) {
//                    builder.append(line);
//                }
//                System.out.println(builder.toString());
//            }
//        }
	}
	
	
	/**
     * 生成Token
      */
    private static String generateToken(String ak, String sk, String urlPath, String method, String queryParam, String body, int expireTime) throws NoSuchAlgorithmException, UnsupportedEncodingException, UnsupportedEncodingException {
        StringBuffer sbSign = new StringBuffer(String.format("|%s-%s-%d|%s|", "v2",
                ak, expireTime, sk));

        // {UrlPath}|
        sbSign.append(URLDecoder.decode(urlPath, "UTF-8")).append("|");

        // {Method}|
        sbSign.append(method).append("|");

        // {QueryParam}|
        if (queryParam!=null && queryParam.length()>0) {
            List<String> qsArray = new ArrayList<String>();
            for (String kv : queryParam.split("&")) {
                String[] t = kv.split("=");
                if (t.length > 1) {
                    qsArray.add(String.format("%s=%s", URLDecoder.decode(t[0], "UTF-8"), URLDecoder.decode(t[1], "UTF-8")));
                } else {
                    qsArray.add(String.format("%s=", URLDecoder.decode(t[0], "UTF-8")));
                }
            }

            Collections.sort(qsArray);
            boolean first = true;
            for (String s : qsArray) {
                if (first) {
                    first = false;
                } else {
                    sbSign.append("&");
                }
                sbSign.append(s);
            }
        }
        sbSign.append("|");

        // {body}|
        if (body!=null && body.length()>0) {
            sbSign.append(body);
        }
        sbSign.append("|");

        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.reset();
        md5.update(sbSign.toString().getBytes("UTF-8"));

        //  v2-{AK}-{ExpireTime}-{Signature}
        String token = String.format("%s-%s-%s-%s", "v2", ak, expireTime,
                new String(Hex.encodeHex(md5.digest())));
        return token;
    }
}
