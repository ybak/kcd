package com.util.newAdd;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpURL;
public class downLoadFile {
	//下载模版工具类  
    public static void downloadFile(HttpServletRequest request,HttpServletResponse response,String timepath,String fileName) throws Exception {   
        response.setContentType("text/html;charset=UTF-8");     
        BufferedInputStream in = null;    
        BufferedOutputStream out = null;    
        request.setCharacterEncoding("UTF-8");    
        String rootpath =request.getSession().getServletContext().getRealPath("/");    
        try {    
            File f = new File(rootpath+"image/upload/apply/"+timepath+"/"+fileName);  
            response.setContentType("application/pdf");    
            response.setCharacterEncoding("UTF-8");    
            response.setHeader("Content-Disposition", "attachment; filename="+new String(fileName.getBytes("gbk"),"iso-8859-1"));    
            response.setHeader("Content-Length",String.valueOf(f.length()));    
            in = new BufferedInputStream(new FileInputStream(f));    
            out = new BufferedOutputStream(response.getOutputStream());    
            byte[] data = new byte[1024];    
            int len = 0;    
            while (-1 != (len=in.read(data, 0, data.length))) {    
                out.write(data, 0, len);    
            }  
            System.out.println("下载成功");
        } catch (Exception e) {    
            e.printStackTrace();    
        } finally {    
            if (in != null) {    
                in.close();    
            }    
            if (out != null) {    
                out.close();    
            }    
        }    
    }  
    /** 
     * 从网络Url中下载文件 
     * @param urlStr 
     * @param fileName 
     * @param savePath 
     * @throws IOException 
     */  
    public static void  downLoadFromUrl(HttpServletResponse response,String urlStr,String fileName,String savePath) throws IOException{  
    	URL url = new URL(urlStr);    
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();    
        //设置超时间为3秒  
        conn.setConnectTimeout(3*1000);  
        //防止屏蔽程序抓取而返回403错误  
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");  
        response.setContentType("application/pdf");    
        response.setCharacterEncoding("UTF-8");    
        response.setHeader("Content-Disposition", "attachment; filename="+new String(fileName.getBytes("gbk"),"iso-8859-1")); 
        //得到输入流  
        InputStream inputStream = conn.getInputStream();    
        //获取自己数组  
        byte[] getData = readInputStream(inputStream);      
  
        //文件保存位置  
        File saveDir = new File(savePath);  
        if(!saveDir.exists()){  
            saveDir.mkdir();  
        }  
        File file = new File(saveDir+File.separator+fileName);      
        FileOutputStream fos = new FileOutputStream(file);       
        fos.write(getData);   
        if(fos!=null){  
            fos.close();    
        }  
        if(inputStream!=null){  
            inputStream.close();  
        }  
        System.err.println("info:"+url+" download success");   
    }  
    /** 
     * 从输入流中获取字节数组 
     * @param inputStream 
     * @return 
     * @throws IOException 
     */  
    public static  byte[] readInputStream(InputStream inputStream) throws IOException {    
        byte[] buffer = new byte[1024];    
        int len = 0;    
        ByteArrayOutputStream bos = new ByteArrayOutputStream();    
        while((len = inputStream.read(buffer)) != -1) {    
            bos.write(buffer, 0, len);    
        }    
        bos.close();    
        return bos.toByteArray();    
    }          
    //主方法
	public static void main(String[] args) throws Exception {  
		HttpServletResponse response = null;
		//http://101.95.48.97:8005/res/upload/interface/apptutorials/manualstypeico/6f83ce8f-0da5-49b3-bac8-fd5fc67d2725.png
		downLoadFromUrl(null, "http://pic.58pic.com/58pic/17/76/27/01u58PIC3ra_1024.jpg",    
                "qwe.jpg","F://aa"); 
	}
}
