package com.util;
  

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;  
import java.io.BufferedOutputStream;  
import java.io.File;  
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
import org.springframework.stereotype.Component;  
  
/** 
 * 下载模版工具类 
*        
* 
 */  
@Component  
public class Download {  
	
	
	
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
    //下载模版工具类  
    public static void downloadimg(HttpServletRequest request,HttpServletResponse response,String timepath,String fileName) throws Exception {       	
        response.setContentType("text/html;charset=UTF-8");     
        BufferedInputStream in = null;    
        BufferedOutputStream out = null;    
        request.setCharacterEncoding("UTF-8");    
        //String rootpath =request.getSession().getServletContext().getRealPath("/");   
        //System.out.println(rootpath);
        try {    
        	File f = new File("/opt/javaimg/image/upload/img/"+timepath+"/"+fileName);    
            response.setContentType("multipart/form-data");    
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
            	out.flush();
                out.close();    
            }    
        }    
        
    }            
    private static BufferedImage read(String imageUrl) throws IOException {  
        URL url = new URL(imageUrl);  
        BufferedImage image = ImageIO.read(url);  
        return image;  
    }  
    // 通过get请求得到读取器响应数据的数据流
    public static void getInputStreamByGet(HttpServletRequest request,HttpServletResponse response,
    		String url,String pname) throws UnsupportedEncodingException {
   	 response.setContentType("text/html;charset=UTF-8");     
     //BufferedInputStream in = null;    
     BufferedOutputStream out = null;    
     request.setCharacterEncoding("UTF-8");    
    	 try {
             URL url1 = new URL(url);
             HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
             connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.19 Safari/537.36");
             connection.setConnectTimeout(5 * 1000);
             InputStream inputStream = connection.getInputStream();
             response.setContentType("multipart/form-data");    
             response.setCharacterEncoding("UTF-8");    
             response.setHeader("Content-Disposition","attachment;filename="+new String(pname.getBytes("gbk"),"iso-8859-1"));    
             response.setHeader("Content-Length",String.valueOf(inputStream.available())); 
             
             //in = new BufferedInputStream(inputStream);    
             out = new BufferedOutputStream(response.getOutputStream());    
             byte[] data = new byte[1024];    
             int len = 0;           
             while (-1 != (len=inputStream.read(data, 0, data.length))) {    
                 out.write(data, 0, len);    
             }  
//             byte[] tmp = new byte[1024];
//             int length;
//             OutputStream outputStream = new FileOutputStream("E:" + File.separator + "eee.jpg");
//             while ((length = inputStream.read(tmp)) != -1) {
//                 outputStream.write(tmp, 0, length);
//             }
             out.flush();
             out.close();
             inputStream.close();
         } catch (Exception e) {
             e.printStackTrace();
         }
    }
        // 将服务器响应的数据流存到本地文件
    public static void saveData(String name,String time,String url) throws IOException {
    	
    	try {
            URL Url = new URL(url+time+"/"+name);
            System.out.println(url+time+"/"+name);
            HttpURLConnection connection = (HttpURLConnection)Url.openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.19 Safari/537.36");
            connection.setConnectTimeout(5 * 1000);
            InputStream inputStream = connection.getInputStream();
            byte[] tmp = new byte[1024];
            int length;
            OutputStream outputStream = new FileOutputStream("C:/"+name);
            while ((length = inputStream.read(tmp)) != -1) {
                outputStream.write(tmp, 0, length);
            }
            outputStream.flush();
            outputStream.close();            
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
//    private static HttpServletRequest request;
//    private static HttpServletResponse response;
    public static void main(String[] args) throws IOException {
//    	InputStream img=getInputStreamByGet("http://apitest.kcway.net/image/upload/img/20171111/e8eb3aefe81b47768ffd2244912dca5720171111.jpg.new.jpg");
//    	File file=new File("C:/Users/Administrator/Desktop/2/333.jpg");
//    	saveData(img,file);
    	//saveData("http://apitest.kcway.net/image/upload/img/20171111/e8eb3aefe81b47768ffd2244912dca5720171111.jpg.new.jpg","444.jpg");
	}
 
}  