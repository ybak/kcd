package com.util;

import java.security.MessageDigest;

public class md5util {
  
    
    /** 
     * message-digest algorithm 5（信息-摘要算法） 
     *  
     * md5的长度，默认为128bit，也就是128个 0和1的 二进制串 。 
     *  
     * 128/4 = 32 换成 16进制 表示后，为32位了。 
     */  

      
        // 测试方法  
//        public static void main(String[] args) {  
//        String pwd = "工作日志样板";  
//        System.out.println("加密前： " + pwd);  
//        System.err.println("加密后： " + md5util.getMD5(pwd));  
//        }  
      
        /** 
         * 生成md5 
         *  
         * @param message 
   
         * @return 
         */  
        public static String getMD5(String message,String charset) {  
        String md5str = "";  
        try {  
            // 1 创建一个提供信息摘要算法的对象，初始化为md5算法对象  
            MessageDigest md = MessageDigest.getInstance("MD5");  
      
            // 2 将消息变成byte数组  
            byte[] input = message.getBytes(charset);  
      
            // 3 计算后获得字节数组,这就是那128位了  
            byte[] buff = md.digest(input);  
      
            // 4 把数组每一字节（一个字节占八位）换成16进制连成md5字符串  
            md5str = bytesToHex(buff);  
      
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return md5str;  
        }  
        // 加密后解密  
        public static String JM(String inStr) {  
         char[] a = inStr.toCharArray();  
         for (int i = 0; i < a.length; i++) {  
          a[i] = (char) (a[i] ^ 't');  
         }  
         String k = new String(a);  
         return k;  
        }  
        /** 
         * 二进制转十六进制 
         *  
         * @param bytes 
         * @return 
         */  
        public static String bytesToHex(byte[] bytes) {  
        StringBuffer md5str = new StringBuffer();  
        // 把数组每一字节换成16进制连成md5字符串  
        int digital;  
        for (int i = 0; i < bytes.length; i++) {  
            digital = bytes[i];  
      
            if (digital < 0) {  
            digital += 256;  
            }  
            if (digital < 16) {  
            md5str.append("0");  
            }  
            md5str.append(Integer.toHexString(digital));  
        }  
        return md5str.toString().toUpperCase();  
        }  
          
        	 // MD5加码。32位     
        	 public static String MD5(String inStr) {     
        	  MessageDigest md5 = null;     
        	  try {     
        	   md5 = MessageDigest.getInstance("MD5");     
        	  } catch (Exception e) {     
        	   System.out.println(e.toString());     
        	   e.printStackTrace();     
        	   return "";     
        	  }     
        	  char[] charArray = inStr.toCharArray();     
        	  byte[] byteArray = new byte[charArray.length];     
        	    
        	  for (int i = 0; i < charArray.length; i++)     
        	   byteArray[i] = (byte) charArray[i];     
        	    
        	  byte[] md5Bytes = md5.digest(byteArray);     
        	    
        	  StringBuffer hexValue = new StringBuffer();     
        	    
        	  for (int i = 0; i < md5Bytes.length; i++) {     
        	   int val = ((int) md5Bytes[i]) & 0xff;     
        	   if (val < 16)     
        	    hexValue.append("0");     
        	   hexValue.append(Integer.toHexString(val));     
        	  }     
        	    
        	  return hexValue.toString();     
        	 }     
        	    
        	 // 可逆的加密算法     
        	 public static String KL(String inStr) {     
        	  // String s = new String(inStr);     
        	  char[] a = inStr.toCharArray();     
        	  for (int i = 0; i < a.length; i++) {     
        	   a[i] = (char) (a[i] ^ 't');     
        	  }     
        	  String s = new String(a);     
        	  return s;     
        	 }     
        	       

        	 // 测试主函数     
        	 public static void main(String args[]) {     
        	  String s = new String("a");     
        	  System.out.println("原始：" + s);     
        	  System.out.println("MD5后：" + getMD5(s,"UTF-8"));     
        	  //System.out.println("MD5后再加密：" + KL(MD5(s)));     
        	  System.out.println("解密的：" + JM(JM(getMD5(s,"UTF-8"))));     
        	 }     

}
