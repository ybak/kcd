package com.http;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.util.creditutil;
import com.util.jsonutil;
import com.util.md5util;

import net.sf.json.JSONObject;

public class zxhttp {

	
	
	
	 /** 
     * 1.2 审核信息成功结果异步推送接口 (快加-嘉银征信)
     */  
    public static String zxxxhd(String orderNo,
    		String errmsg,
    		String path,
    		String pdfurl,
    		String pdfname,
    		String pdftime
    		) {  
    	 StringBuilder sb = new StringBuilder(); // 用来存储响应数据  
        try {  
        	//"http://www.zhixiangcf.com/wx/receive"
            URL url = new URL(path);   
            // 将url 以 open方法返回的urlConnection  连接强转为HttpURLConnection连接  (标识一个url所引用的远程对象连接)  
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();// 此时cnnection只是为一个连接对象,待连接中                
            // 设置连接输出流为true,默认false (post 请求是以流的方式隐式的传递参数)  
            connection.setDoOutput(true);                
            // 设置连接输入流为true  
            connection.setDoInput(true);                
            // 设置请求方式为post  
            connection.setRequestMethod("POST");                
            // post请求缓存设为false  
            connection.setUseCaches(false);                
            // 设置该HttpURLConnection实例是否自动执行重定向  
            connection.setInstanceFollowRedirects(true);                
            // 设置请求头里面的各个属性 (以下为设置内容的类型,设置为经过urlEncoded编码过的from参数)  
            // application/x-javascript text/xml->xml数据 application/x-javascript->json对象 application/x-www-form-urlencoded->表单数据  
            // ;charset=utf-8 必须要，不然妙兜那边会出现乱码【★★★★★】  
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
           // connection.setRequestProperty("token", "9164152B7EB0AF6EA589B1BE06073304");
            // 建立连接 (请求未开始,直到connection.getInputStream()方法调用时才发起,以上各个参数设置需在此方法之前进行)  
            connection.connect();                
            // 创建输入输出流,用于往连接里面输出携带的参数,(输出内容为?后面的内容)  
            DataOutputStream dataout = new DataOutputStream(connection.getOutputStream());  
//          String name,
//    		String idCard,
//    		String phoneNo,
//    		String orderNo,
//    		String errcode,
//    		String errmsg
//          String orderNo,
//    		String errmsg
            orderNo ="orderNo="+ URLEncoder.encode(orderNo, "utf-8");        
            errmsg ="&errmsg="+ URLEncoder.encode(errmsg, "utf-8");
            if(pdfurl!=null&&pdfname!=null&&pdftime!=null
            		&&!pdfurl.equals("")
            		&&!pdfname.equals("")
            		&&!pdftime.equals("")
            		){
            	  pdfurl ="&pdfurl="+ URLEncoder.encode(pdfurl, "utf-8");        
                  pdfname ="&pdfname="+ URLEncoder.encode(pdfname, "utf-8"); 
                  pdftime ="&pdftime="+ URLEncoder.encode(pdftime, "utf-8");  	
            }
                           
            String parm;
            // 格式 parm = aaa=111&bbb=222&ccc=333&ddd=444 
            if(pdfurl!=null&&pdfname!=null&&pdftime!=null
            		&&!pdfurl.equals("")
            		&&!pdfname.equals("")
            		&&!pdftime.equals("")
            		){
            	parm =orderNo+errmsg+pdfurl+pdfname+pdftime;
            }else{
            	parm =orderNo+errmsg;
            }	
            System.out.println("参数："+parm);
            // 将参数输出到连接  
            dataout.writeBytes(parm);  
              
            // 输出完成后刷新并关闭流  
            dataout.flush();  
            dataout.close(); // 重要且易忽略步骤 (关闭流,切记!)   
              
//            System.out.println(connection.getResponseCode());  
              
            // 连接发起请求,处理服务器响应  (从连接获取到输入流并包装为bufferedReader)  
            BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));   
            String line;  
           
              
            // 循环读取流,若不到结尾处  
            while ((line = bf.readLine()) != null) {  
//                sb.append(bf.readLine());  
                sb.append(line).append(System.getProperty("line.separator"));  
            }  
            bf.close();    // 重要且易忽略步骤 (关闭流,切记!)   
            connection.disconnect(); // 销毁连接  
           // System.out.println(sb.toString());  
      
        } catch (Exception e) {  
            e.printStackTrace();  
        }
		return sb.toString();  
    } 
    
    public static String zxcf(String orderNo,String errmsg,String SENTIMENT_URL,String md){
//    	, String cKey
        //String SENTIMENT_URL ="http://www.zhixiangcf.com/wx/receive";
        //http://apitest.kcway.net
        String body ="orderNo="+orderNo+"&errmsg="+errmsg;  //new JSONArray(new String[]{text}).toString();
        System.out.println(body);
        HttpResponse<String> jsonResponse = null;
        try {
            jsonResponse = Unirest.post(SENTIMENT_URL)
                    .header("Content-Type","text/html;charset=UTF-8")
                    .header("token",md)
                    .header("Method","post")
                    .body(body)
                    .asString();
            //Unirest.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(jsonResponse.getBody());
        return jsonResponse.getBody();
    }
    public static String bgcf(String orderNo,String errmsg){
//    	, String cKey
        String SENTIMENT_URL ="http://cesi3.0.zhiyujinrong.com/index.php/Api/Index/index/token/9164152B7EB0AF6EA589B1BE06073304.html";        
        //http://apitest.kcway.net
        String body ="orderNo="+orderNo+"&errmsg="+errmsg;  //new JSONArray(new String[]{text}).toString();
        System.out.println(body);
        HttpResponse<String> jsonResponse = null;
        try {
            jsonResponse = Unirest.post(SENTIMENT_URL)
                    .header("Content-Type","text/html;charset=UTF-8")
                    //.header("ckey",cKey)
                    .body(body)
                    .asString();
            //Unirest.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(jsonResponse.getBody());
        return jsonResponse.getBody();
    }
    
    
    public static void main(String[] args) {
    	//String errmsg = null ;
    	String errmsg1="初审完成";
    	String errmsg2="正在查询";
    	String errmsg3="查询成功";
    	String errmsg4="回退";    	
    	String md5=md5util.getMD5("18019035363"+"DFADF50683890586428B480902A6FB76","UTF-8");
    	System.out.println("md5:"+md5);
    	//http://cesi3.0.zhiyujinrong.com/index.php/Api/Index/index.html
    	String url="http://cesi3.0.zhiyujinrong.com/index.php/Api/Index/index/token/"+md5+".html";
    	System.out.println(url);
    	String res=zxxxhd("228",errmsg3,url,"http://apitest.kcway.net/image/upload/20171201/dc0e3d42446742f497f2eb59d2368506.pdf","dc0e3d42446742f497f2eb59d2368506.pdf",creditutil.time().toString());
    	JSONObject jobj=jsonutil.toJSONObject(res);
    	String needStr=jobj.getString("status");
        System.out.println(needStr+"-----"+res.toString());

	}
}
