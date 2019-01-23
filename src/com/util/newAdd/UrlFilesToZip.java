package com.util.newAdd;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.catalina.connector.Response;

public class UrlFilesToZip {
	 //根据文件链接把文件下载下来并且转成字节码
public byte[] getImageFromURL(String urlPath) {
	  byte[] data = null;
	  InputStream is = null;
	  HttpURLConnection conn = null;
	  try {
	   URL url = new URL(urlPath);
	   System.out.println(url);
	   conn = (HttpURLConnection) url.openConnection();
	   conn.setDoInput(true);
	   conn.setRequestMethod("GET");
	   conn.setConnectTimeout(6000);
	   System.out.println();
	   if (conn.getResponseCode() == 200) {
		is = conn.getInputStream();
	    data = readInputStream(is);
	   } else {
	    data = null;
	   }
	  } catch (MalformedURLException e) {
		  e.printStackTrace();
	  } catch (IOException e) {
		  e.printStackTrace();
	  } finally {
	   try {
	    if (is != null) {
	     is.close();
	    }
	   } catch (IOException e) {
		 e.printStackTrace();
	   }
	   conn.disconnect();
	  }
	  return data;
	 }
	 public byte[] readInputStream(InputStream is) {
	  ByteArrayOutputStream baos = new ByteArrayOutputStream();
	  byte[] buffer = new byte[1024];
	  int length = -1;
	  try {
	   while ((length = is.read(buffer)) != -1) {
	    baos.write(buffer, 0, length);
	   }
	   baos.flush();
	  } catch (IOException e) {
		  e.printStackTrace();
	  }
	  byte[] data = baos.toByteArray();
	  try {
	   is.close();
	   baos.close();
	  } catch (IOException e) {
		  e.printStackTrace();
	  }
	  return data;
	 }
	 public static void main(String[] args) {
		 Response response = null;
		 try {
			   String filename = new String("xx.zip".getBytes("UTF-8"), "ISO8859-1");//控制文件名编码
			   ByteArrayOutputStream bos = new ByteArrayOutputStream();
			   ZipOutputStream zos = new ZipOutputStream(bos);
			   UrlFilesToZip s = new UrlFilesToZip();
			   int idx = 1;
			   String[] urls = null;
			for (String oneFile:urls) {
			    zos.putNextEntry(new ZipEntry("profile" + idx+".pdf"));
			    byte[] bytes = s.getImageFromURL(oneFile);
			    zos.write(bytes, 0, bytes.length);
			    zos.closeEntry();
			    idx++;
			   }
			   zos.close();
			   response.setContentType("application/force-download");// 设置强制下载不打开
			   response.addHeader("Content-Disposition", "attachment;fileName=" + filename);// 设置文件名
			   OutputStream os = response.getOutputStream();
			   os.write(bos.toByteArray());
			   os.close();
			  } catch (FileNotFoundException ex) {
			   ex.printStackTrace();
			  } catch (Exception ex) {
				  ex.printStackTrace();
		}
	}
}
