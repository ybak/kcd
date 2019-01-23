package com.util;

import java.io.File;

import javax.activation.MimetypesFileTypeMap;

public class ImageCheck {
  
	private static  MimetypesFileTypeMap mtftp;

    public ImageCheck(){
        mtftp = new MimetypesFileTypeMap();
        /* 不添加下面的类型会造成误判 详见：http://stackoverflow.com/questions/4855627/java-mimetypesfiletypemap-always-returning-application-octet-stream-on-android-e*/
        mtftp.addMimeTypes("image png tif jpg jpeg bmp");
    }
    public static  boolean isImage(File file){
        String mimetype= mtftp.getContentType(file);
        System.out.println(mimetype);
        String type = mimetype.split("/")[0];
        return type.equals("image");
    }

    
    public static void main(String[] args) {
		
    	System.out.println(isImage(new File("C:/Users/Administrator/Desktop/3m》图片.txt")));
    	
	}
	
}
