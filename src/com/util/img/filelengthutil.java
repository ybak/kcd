package com.util.img;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;



public class filelengthutil {
    /** 
     * 获取网络文件大小 
     * @param url 
     * @param type 
     * @return 
     * @throws IOException  
     */  
    public static int getFileLength(String url1) throws IOException{  
        int length=0;  
        URL url;  
        try {  
            url = new  URL(url1);  
            HttpURLConnection urlcon=(HttpURLConnection)url.openConnection();     
            //根据响应获取文件大小   
            length=urlcon.getContentLength();  
            urlcon.disconnect();  
        } catch (MalformedURLException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }     
        return length;  
    } 
    
    
    public static void main(String[] args) throws IOException {
		
      int s=filelengthutil.getFileLength("http://apitest.kcway.net/image/upload/20171118/c42414877701487b85b25a07cdb2edb8.pdf");
      System.out.println("文件大小："+s);
	}
}
