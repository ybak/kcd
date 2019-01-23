package com.controller.icbc.util;  
  
import java.io.ByteArrayOutputStream;  
import java.io.DataOutputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.net.URL;  
import java.security.KeyManagementException;  
import java.security.NoSuchAlgorithmException;  
import java.security.cert.CertificateException;  
import java.security.cert.X509Certificate;  
  
import javax.net.ssl.HostnameVerifier;  
import javax.net.ssl.HttpsURLConnection;  
import javax.net.ssl.SSLContext;  
import javax.net.ssl.SSLSession;  
import javax.net.ssl.TrustManager;  
import javax.net.ssl.X509TrustManager;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.Base64;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.util.base64;  
  
public class HttpsUtil {  
  
    private static class TrustAnyTrustManager implements X509TrustManager {  
  
        public void checkClientTrusted(X509Certificate[] chain, String authType)  
                throws CertificateException {  
        }  
  
        public void checkServerTrusted(X509Certificate[] chain, String authType)  
                throws CertificateException {  
        }  
  
        public X509Certificate[] getAcceptedIssuers() {  
            return new X509Certificate[] {};  
        }  
    }  
  
    private static class TrustAnyHostnameVerifier implements HostnameVerifier {  
        public boolean verify(String hostname, SSLSession session) {  
            return true;  
        }  
    }  
  
    
    public static JsonNode jg(String url, String content,String Authorization){
        System.out.println(content);
        HttpResponse<JsonNode> jsonResponse = null;
        try {
            jsonResponse = Unirest.post(url)
                    .header("Content-Type","application/json")
                    .header("Authorization",Authorization)
                    .body(content)
                    .asJson();
            //Unirest.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(jsonResponse.getBody());
        return jsonResponse.getBody();
    }
    /** 
     * post方式请求服务器(https协议) 
     *  
     * @param url 
     *            请求地址 
     * @param content 
     *            参数 
     * @param charset 
     *            编码 
     * @return 
     * @throws NoSuchAlgorithmException 
     * @throws KeyManagementException 
     * @throws IOException 
     */  
    public static byte[] post(String url, String content,String Authorization, String charset)  
            throws NoSuchAlgorithmException, KeyManagementException,  
            IOException {  
        SSLContext sc = SSLContext.getInstance("SSL");  
        sc.init(null, new TrustManager[] { new TrustAnyTrustManager() },  
                new java.security.SecureRandom());  
        URL console = new URL(url);  
        HttpsURLConnection conn = (HttpsURLConnection) console.openConnection();  
        conn.setRequestProperty("Authorization",Authorization);
        conn.setRequestProperty("Content-Type","application/json");
        conn.setSSLSocketFactory(sc.getSocketFactory());  
        conn.setHostnameVerifier(new TrustAnyHostnameVerifier());  
        conn.setDoOutput(true);  
        conn.connect();  
        System.out.println(conn.getContent());
        DataOutputStream out = new DataOutputStream(conn.getOutputStream());  
        out.write(content.getBytes(charset));  
        // 刷新、关闭  
        out.flush();  
        out.close();  
        InputStream is = conn.getInputStream();  
        if (is != null) {  
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
            byte[] buffer = new byte[1024];  
            int len = 0;  
            while ((len = is.read(buffer)) != -1) {  
                outStream.write(buffer, 0, len);  
            }  
            is.close();  
            return outStream.toByteArray();  
        }  
        return null;  
    }  
            public static void main(String[] args) {
            String appKey="7e21faf06524b22f0ee1414c";
            String masterSecret="c87361ae4d7d91067b3ea01a";
            String Authorization="";
            base64 cBase64=new base64();
            Authorization=cBase64.getBase64(appKey+":"+masterSecret);
            System.out.println("base64："+Authorization);
            String url="https://api.jpush.cn/v3/push";
	        String content="";
	        JSONObject con=new JSONObject();
	        JSONObject notification=new JSONObject();
	        String[] id={"121c83f76005fca8286"};
	        JSONObject registration_id=new JSONObject();
	        notification.put("alert","Hello, JPush!");
	        con.put("platform", "all");
	        con.put("audience", "registration_id:['121c83f76005fca8286']");
	        con.put("notification",notification);
	        con.put("message", "");
	        con.put("sms_message", "");
	        con.put("options", "");
	        con.put("cid", "");
	        content=con.toString();
            JsonNode string=jg(url,content,appKey+":"+masterSecret);
            System.out.println(string);
        }
} 