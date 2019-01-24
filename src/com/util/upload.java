package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class upload{
	
	public static void tofile(String opath,String npath,String imgname) throws IOException{
        File file = new File(opath);
        if(!file.exists())
            throw new RuntimeException("文件不存在..");
        FileInputStream fis = new FileInputStream(file);
        byte[] b = new byte[1024];
        int len = 0;
//        String readpath="C:/Users/Administrator/Desktop/1/3";
        File filepath = new File(npath);
        if(!filepath.exists()){
        	filepath.mkdirs();
	 	 }
//        String filename="333.jpg";
        FileOutputStream fos = new FileOutputStream(npath+pathutil.getPath()+imgname);
        while((len=fis.read(b))!=-1){
            fos.write(b,0,len);
        }
        fos.close();
        fis.close();

	}
	
	
	public static void main(String[] args) {
		
		try {
			tofile("","","");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}