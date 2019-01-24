package com.http.duoying;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

public class clwzhttp{
	
    public static final String APPKEY = "25f54018acb1a239";// 你的appkey
    public static final String URL = "http://api.jisuapi.com/illegal/query";
    public static final String carorg = "";// 交管局代号
    public static final String lsprefix = "京";// 车牌前缀 utf8
    public static final String lsnum = "";// 车牌
    public static final String lstype = "02";// 车辆类型
    public static final String engineno = "";// 发动机号
    public static final String frameno = "";// 车架号
	
	 public static JsonNode query(
			 String carorg,
			 String lsprefix,
			 String lsnum,
			 String lstype,
			 String engineno,
			 String frameno 
			 ){
	        HttpResponse<JsonNode> jsonResponse = null;
	        try {
	            jsonResponse = Unirest.get(URL)
	            		.header("method", "get")
	            		//.header("Content-Type","text/html;charset=UTF-8")
	                    //.header("ckey",cKey)
	                    //.routeParam("method", "get")
	                    .queryString("appkey",APPKEY)//
	                    .queryString("carorg",carorg)// 交管局代号
	                    .queryString("lsprefix",lsprefix)// 车牌前缀 utf8
	                    .queryString("lsnum",lsnum)// 车牌
	                    .queryString("lstype",lstype)// 车辆类型
	                    .queryString("engineno",engineno)// 发动机号
	                    .queryString("frameno",frameno)// 车架号
	                    .asJson();
	            //Unirest.shutdown();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        //System.out.println(jsonResponse.getBody());
	        return jsonResponse.getBody();
	    }
	 
	 public static void main(String[] args) {
		     String carorg = "";// 交管局代号
		     String lsprefix = "冀";// 车牌前缀 utf8  true
		     String lsnum = "F511AZ";// 车牌  true
		     String lstype = "02";// 车辆类型    
		     String engineno = "*932467";// 发动机号   true
		     String frameno = "*013249";// 车架号    true
		     
		// System.out.println("沪CNW006640".substring(0,1));
		 //System.out.println("沪CNW006640".substring(1,"沪CNW006640".length()));
		JsonNode s= query(carorg, lsprefix, lsnum, lstype, engineno, frameno);
		  JSONObject jb=JSONObject.parseObject(s.toString());
		     
		if(jb.get("status").equals("0")){
			JSONObject result=JSONObject.parseObject(jb.get("result").toString()); 
			JSONArray ja=JSONArray.parseArray(result.getString("list"));
			
			
			
			System.out.println("成功"+ja);
		}
//		 int i=290000/100-2704;
//		System.out.println(i);
		 
	}
	 

}