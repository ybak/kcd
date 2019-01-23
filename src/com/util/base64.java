    /** 
     * @file Base64.java 
     * @date 2016年8月5日 
     * @version 3.4.1 
     * 
     * Copyright (c) 2013 Sihua Tech, Inc. All Rights Reserved. 
     */  
    package com.util;  
      

      
    import java.io.UnsupportedEncodingException;

    import Decoder.BASE64Decoder;  
    import Decoder.BASE64Encoder;  
      
    /** 
     *  
     * 
     * @author chengjian.he 
     * @version  3.4, 2016年8月5日 上午10:32:23  
     * @since   Yeexun 3.4 
     */  
      
    public class base64 {  
        // 加密  
        public String getBase64(String str) {  
            byte[] b = null;  
            String s = null;  
            try {  
                b = str.getBytes("utf-8");  
            } catch (UnsupportedEncodingException e) {  
                e.printStackTrace();  
            }  
            if (b != null) {  
                s = new BASE64Encoder().encode(b);  
            }  
            return s;  
        }  
      
        // 解密  
        public String getFromBase64(String s) {  
            byte[] b = null;  
            String result = null;  
            if (s != null) {  
                BASE64Decoder decoder = new BASE64Decoder();  
                try {  
                    b = decoder.decodeBuffer(s);  
                    result = new String(b, "utf-8");  
                } catch (Exception e) {  
                    e.printStackTrace();  
                }  
            }  
            return result;  
        }  
          
        public static void main(String args[]){  
            base64 b6 = new base64();  
            String path="C:/Users/Administrator/Desktop/1/1.jpg";
            String s= Base64Test.getImageStr(path);
           System.out.println(s.length());
          System.out.println(b6.getBase64(s).length());  
           System.out.println(b6.getFromBase64(b6.getBase64(s)).length());  
        }  
    }  
