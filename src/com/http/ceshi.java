package com.http;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import com.google.gson.GsonBuilder;

public class ceshi {
   
	
	public static void tofile() throws IOException{
        File file = new File("C:/Users/Administrator/Desktop/1/1.jpg");
        if(!file.exists())
            throw new RuntimeException("文件不存在..");
        FileInputStream fis = new FileInputStream(file);
        byte[] b = new byte[1024];
        int len = 0;
        
        FileOutputStream fos = new FileOutputStream("C:/Users/Administrator/Desktop/1/233.jpg");
        while((len=fis.read(b))!=-1){
            fos.write(b,0,len);
        }
        fos.close();
        fis.close();

	}
	
	
	
	public static void main(String[] args) throws IOException {
		   Map<String, Object> bodyMap = new LinkedHashMap<String, Object>();
	        // TODO 回调URL需要是自己服务的真实URL
//		   "sync":1,
//	        "idCardNo":"612301198805050293", //身份证号
//	        "name":"张三", //姓名
//	        "phoneNo":"18629874563" // 手机号
		    Map<String, Object> bodyMap1 = new LinkedHashMap<String, Object>();
	        bodyMap1.put("sync",1); 
	        bodyMap1.put("idCardNo","612301198805050293"); 
	        bodyMap1.put("name","张三"); 
	        bodyMap1.put("phoneNo", "18629874563"); 
	        
	        bodyMap.put("callbackUrl", "https://testapi.ibeesaas.com");
	        bodyMap.put("data",bodyMap1);		  
	        String body = new GsonBuilder().disableHtmlEscaping().serializeNulls().create().toJson(bodyMap);
		System.out.println(body);
	}
}
