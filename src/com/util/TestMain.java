package com.util;



import java.util.HashMap;  
import java.util.Map;  
//对接口进行测试  
public class TestMain {  
  //private String url ="";  
  private String charset = "utf-8";  
  private HttpClientUtil httpClientUtil = null;  
     
  public TestMain(){  
    httpClientUtil = new HttpClientUtil();  
  }  
     
  public Map test(//String zt,
		          //String ly,
		          //  String pdfname,
		           String orderid,
		           String pdfurl,
		           String addtime,
		           String url){  
    String httpOrgCreateTest =url;  
    Map<String,String> createMap = new HashMap<String,String>();
    Map<String,String> result = new HashMap<String,String>();
    //createMap.put("zt",zt);  
    //createMap.put("ly",ly);  
    //createMap.put("pdfname",pdfname);
    createMap.put("pdfurl",pdfurl);
    createMap.put("orderid",orderid); 
    createMap.put("addtime",addtime);
   
    //createMap.put("url",url); 
    String httpOrgCreateTestRtn = httpClientUtil.doPost(httpOrgCreateTest,createMap,charset);  
    result.put("httpOrgCreateTestRtn", httpOrgCreateTestRtn);
    //System.out.println("result:"+createMap.toString()+"===="+httpOrgCreateTestRtn);
	return createMap;  
  
  }  
     
  public static void main(String[] args){  
    TestMain main = new TestMain();  
   Map m=  main.test("1", 
	 "你好", 
	 "pdfurl" ,
	 "http://localhost:8080/kcd/upfile.do"
	);  
   System.out.println(m);
  }  
}
