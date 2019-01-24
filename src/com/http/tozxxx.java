package com.http;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.methods.HttpPost;
import com.util.HttpClientUtil;

public class tozxxx {	
	  private String url ="http://apitest.kcway.net/batchquery.do";  
	  private String charset = ";utf-8";
	  
	  private HttpClientUtil httpClientUtil = null;  
	     
	  public tozxxx(){  
	    httpClientUtil = new HttpClientUtil();  
	  }  
	     
	  public  String test(//String zt,
			          //String ly,
			        //   String pdfname,
			           String jsonstring,			        
			           String ckey
			         //  String url
			           ){  
	    String httpOrgCreateTest =url;  
	    Map<String,String> createMap = new HashMap<String,String>();
	    Map<String,String> result = new HashMap<String,String>();
	    //createMap.put("zt",zt);  
	    //createMap.put("ly",ly);  
	    //createMap.put("pdfname",pdfname);
	    createMap.put("jsonstring",jsonstring);
	    //createMap.put("IDcard_num",iDcard_num); 
	    createMap.put("ckey",ckey);

	    String httpOrgCreateTestRtn = httpClientUtil.doPost(httpOrgCreateTest,createMap,charset);
	 
	    result.put("httpOrgCreateTestRtn", httpOrgCreateTestRtn);
	    //System.out.println("result:"+createMap.toString()+"===="+httpOrgCreateTestRtn);
		return httpOrgCreateTestRtn;  
	  
	  }  
	  
	  public static void main(String[] args) {
		  tozxxx tozxxx=new tozxxx();
		  String jsonstring="{'name':'Âí³¬','IDcard_num':'418432199512108412'}"	;
	    	
	    String s=tozxxx.test(jsonstring,"931EC3C9818399D1BFE437D917FE123F");
	    	System.out.println(s);

//		  String s= "{'sname':'ssss','alevel':'ssss','pname':'ssss','pIDcard':'ssss','pcall':'ssss','czcode':'1'}";
//		  String s1=tozxxx.test1(s);
//		  String s2= tozxxx.test("1", "1", creditutil.time());
//		  System.out.println(s2);
	}
	
	  public String test1(//String zt,
	          //String ly,
	          //  String pdfname,
	           String mdxx
	           //String url
	           ){  
    String httpOrgCreateTest ="http://localhost:8080/kcd/addmdxx.do";  
    Map<String,String> createMap = new HashMap<String,String>();
    Map<String,String> result = new HashMap<String,String>();
//createMap.put("zt",zt);  
//createMap.put("ly",ly);  
//createMap.put("pdfname",pdfname);
    createMap.put("mdxx",mdxx);

    HttpPost httpPost = new HttpPost(httpOrgCreateTest);
    //createMap.put("url",url); 
//createMap.put("url",url); 
String httpOrgCreateTestRtn = httpClientUtil.doPost(httpOrgCreateTest,createMap,charset);  
result.put("httpOrgCreateTestRtn", httpOrgCreateTestRtn);
//System.out.println("result:"+createMap.toString()+"===="+httpOrgCreateTestRtn);
return httpOrgCreateTestRtn;  

} 
	  

}
