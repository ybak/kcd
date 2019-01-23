package com.util.url;

import java.io.IOException;
import java.math.BigInteger;

import com.fasterxml.jackson.core.JsonGenerator;  
import com.fasterxml.jackson.core.JsonProcessingException;  
import com.fasterxml.jackson.databind.JsonSerializer;  
import com.fasterxml.jackson.databind.ObjectMapper;  
import com.fasterxml.jackson.databind.SerializerProvider;  

/** 
* @description: 转换null对象为空字符串 
*/  
public class JsonObjectMapper extends ObjectMapper {  
   private static final long serialVersionUID = 1L;  
 
   public JsonObjectMapper() {  
       super();  
       // 空值处理为空串  
       this.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {  
           @Override  
           public void serialize(Object value, JsonGenerator jg, SerializerProvider sp) throws IOException, JsonProcessingException {  
               jg.writeString("");  
           }  
       });  
   }  
   
   
//	public static String byte2Radix(byte [] b, int radix){  
//		
//        return new BigInteger(1, b).toString(32);// 这里的1代表正数  
//    }
//	public static void main(String []args) {
//		   String userName="admin.fosun@hoperun.com";
//		   String userTime  ="20181219110825";
//	       System.out.println("1："+userName.getBytes());
//	       System.out.println("2："+userTime.getBytes());
//		   
//		   System.out.println("1："+byte2Radix(userName.getBytes(),32));   
//		   System.out.println("2："+byte2Radix(userTime.getBytes(),32));
//		   
//		   System.out.println("1："+ new BigInteger(userName.getBytes()));
//	    }
}  