package com.controller.erp_icbc;

import java.io.File;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class upfileController {

	 private static final String SALT = "tamboo";
	  
	    /**
	     * 上传文件
	     */
	    @RequestMapping("erp/file_up_util.do")
	    @ResponseBody
	    public String file_up_util(@RequestParam("file")MultipartFile file,HttpServletRequest request){
	        String fileName ="";
	        String filrurl="";
	        Date date = new Date();
	        String filePath ="/KCDIMG/assess/upload/"+new SimpleDateFormat("yyyy/MM/dd/").format(date);
	        if(file!=null&&!file.equals("")) {
	            try {
	                fileName = file.getOriginalFilename();
	                fileName= encode(fileName)+"."+getExtensionName(fileName);
	                filePath ="/KCDIMG/assess/upload/"+new SimpleDateFormat("yyyy/MM/dd/").format(date);
	                uploadFile(file.getBytes(), filePath, fileName);
	                filrurl="upload/"+new SimpleDateFormat("yyyy/MM/dd/").format(date)+fileName;
	                System.out.println("存放路径："+filePath+fileName);
	                System.out.println("数据库路径："+filrurl);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        return filrurl;
	    }
	 
    /***
     * 上传文件工具
     * @param file
     * @param filePath
     * @param fileName
     * @throws Exception
     */
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }
    
    public static String encode(String password) {
        password = password + SALT;
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        char[] charArray = password.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }

            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    /*
     * Java文件操作 获取文件扩展名
     *
     */
    public static String getExtensionName(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot >-1) && (dot < (filename.length() - 1))) {
                return filename.substring(dot + 1);
            }
        }
        return filename;
    }
    /*
     * Java文件操作 获取不带扩展名的文件名
     *
     *
     */
    public static String getFileNameNoEx(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot >-1) && (dot < (filename.length()))) {
                return filename.substring(0, dot);
            }
        }
        return filename;
    }

	 
}
