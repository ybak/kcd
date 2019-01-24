package com.http.duoying;

import java.util.ArrayList;
import java.util.List;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.util.duoying.syncutil;
import com.util.jsy.WriteStringToTxt;

import net.sf.json.JSONObject;

public class syncjkrxxHttp {
	 public static String dy1(String SENTIMENT_URL,String text){
//		 String SENTIMENT_URL ="http://apitest.kcway.net/batchqueryzx.do";
	        //http://apitest.kcway.net  http://localhost:8080/kcd
	        String body =text;  //new JSONArray(new String[]{text}).toString();
	        //System.out.println(body);
	        HttpResponse<String> jsonResponse = null;
	        try {
	            jsonResponse = Unirest.post(SENTIMENT_URL)
	            		.header("Content-Type","application/json")
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

	 public static String dyhttp(String SENTIMENT_URL,String text){
//		 String SENTIMENT_URL ="http://apitest.kcway.net/batchqueryzx.do";
	        //http://apitest.kcway.net  http://localhost:8080/kcd
	       //String body =text;  //new JSONArray(new String[]{text}).toString();
	       //System.out.println("post前:"+body);
	        HttpResponse<String> jsonResponse = null;
	        try {
	      	
	            jsonResponse = Unirest.post(SENTIMENT_URL)
	            		.header("Content-Type","application/json")
	                    //.header("ckey",cKey)
	                    .body(text)
	                    .asString();
	            //Unirest.shutdown();	  	               
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        //System.out.println(jsonResponse.getBody());
	        return jsonResponse.getBody();
	    }
	 public static JsonNode sdds(String SENTIMENT_URL,String text){
//		 String SENTIMENT_URL ="http://apitest.kcway.net/batchqueryzx.do";
	        //http://apitest.kcway.net  http://localhost:8080/kcd
	        String body =text;  //new JSONArray(new String[]{text}).toString();
	        //System.out.println(body);
	        HttpResponse<JsonNode> jsonResponse = null;
	        try {
	            jsonResponse = Unirest.post(SENTIMENT_URL)
	            		.header("Content-Type","text/html;charset=UTF-8")
	                    //.header("ckey",cKey)
	                    .body(body)
	                    .asJson();
	            //Unirest.shutdown();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        //System.out.println(jsonResponse.getBody());
	        return jsonResponse.getBody();
	    }
	 
	 public static void main(String[] args) {		 
		  JSONObject one1 = new JSONObject();
	      one1.put("categoryId","BJRHT");//gems_fs_id
	      one1.put("categoryName","北京仁和堂");   
	      one1.put("categoryParentId","0");   
	      one1.put("level","0");   
	      JSONObject one2 = new JSONObject();
	      one2.put("categoryId","SHKJ");//gems_fs_id
	      one2.put("categoryName","上海科技");   
	      one2.put("categoryParentId","0");   
	      one2.put("level","0");  
	      JSONObject one3 = new JSONObject();
	      one3.put("categoryId","NJWY");//gems_fs_id
	      one3.put("categoryName","南京网友");   
	      one3.put("categoryParentId","0");   
	      one3.put("level","0");  
	      com.alibaba.fastjson.JSONObject data = new com.alibaba.fastjson.JSONObject();
	      List<JSONObject> list = new ArrayList<>();
	      list.add(one1);
	      list.add(one2);
	      list.add(one3);
	      data.put("categoryList", list);
	      com.alibaba.fastjson.JSONObject obj=syncutil.createHead(data);
	      obj.put("data", data);
	      String aa = obj.toString();
	      String s=syncjkrxxHttp.dyhttp("http://abs.51duoying.com:8082/abs-ws/services/rest/sys/addCategory", aa);
	      //JSONObject jsonObject = new JSONObject();
	      //jsonObject = jsonObject.fromObject(s.toString());//将String转为JSON数据
	      //String exerciseStr = jsonObject.getString("code");//获取key为"_source"的值。
	     // System.out.println(exerciseStr);
	      System.out.println("多盈url:http://abs.51duoying.com:8082/abs-ws/services/rest/sys/addCategory\n返回数据:"+s);
	      //http://apitest.kcway.net/image/upload/img/20171117/1dba03d4d2dd46aaa120e25a6749d6ae20171117.jpg.new.jpg
	      //http://apitest.kcway.net/image/upload/img/20171117/3b524389bea740b79a36313423017a7b20171117.jpg.new.jpg
	 }
}
