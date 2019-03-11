package com.controller.htpdf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//拷贝工具
public class CopyFile {

	  /**
     * @param oldPath
     * @param newPath
     * @param map
     * @Description: 递归拷贝
     * @param name
     * @return 
     */
    public static void copyDir(File oldPath, File newPath){
        File[] filePath = oldPath.listFiles();
        if (!newPath.exists()) {
        	newPath.mkdir();
        }
        for (int i = 0; i < filePath.length; i++) {
        	//如果是目录
            if ((new File(oldPath+"/"+ filePath[i])).isDirectory()) {
            	copyDir(filePath[i],new File(newPath+"/"+ filePath[i]));
            }
            //如果是文件
            if (new File(oldPath+"/"+ filePath[i]).isFile()) {
                try {
					copyFile(filePath[i],new File(newPath+"/"+ filePath[i]));
				} catch (IOException e) {
					throw new RuntimeException("拷贝失败");
				}
            }
        }
    }
    //文件拷贝
	public static void copyFile(File oldFile,File file) throws IOException {
        FileInputStream in = new FileInputStream(oldFile);
        FileOutputStream out = new FileOutputStream(file);;
        byte[] buffer=new byte[1024];
        while((in.read(buffer)) != -1){
            out.write(buffer);
        } 
    }

}
