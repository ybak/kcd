package com.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.util.creditutil;
import com.util.jsonutil;
import com.util.pathutil;
import com.util.upload;


@Controller
public class uploadController
{
    public static String [] getFileName(String path)
    {
        File file = new File(path);
        String [] fileName = file.list();
        return fileName;
    }
    public static void getAllFileName(String path,ArrayList<String> fileName)
    {
        File file = new File(path);
        File [] files = file.listFiles();
        String [] names = file.list();
        if(names != null)
        fileName.addAll(Arrays.asList(names));
        for(File a:files)
        {
            if(a.isDirectory())
            {
                getAllFileName(a.getAbsolutePath(),fileName);
            }
        }
    }
    
    
    //复制图片
    public static void copyDir(String oldPath, String newPath) throws IOException {
        File file = new File(oldPath);
        String[] filePath = file.list();
        
        if (!(new File(newPath)).exists()) {
            (new File(newPath)).mkdir();
        }
        
        for (int i = 0; i < filePath.length; i++) {
            if ((new File(oldPath + File.separator + filePath[i])).isDirectory()) {
                copyDir(oldPath  + File.separator  + filePath[i], newPath  + File.separator + filePath[i]);
            }
            
            if (new File(oldPath  + File.separator + filePath[i]).isFile()) {
                copyFile(oldPath + File.separator + filePath[i], newPath + File.separator + filePath[i]);
            }
            
        }
    }
    public static void copyFile(String oldPath, String newPath) throws IOException {
        File oldFile = new File(oldPath);
        File file = new File(newPath);
        FileInputStream in = new FileInputStream(oldFile);
        FileOutputStream out = new FileOutputStream(file);;

        byte[] buffer=new byte[2097152];
        
        while((in.read(buffer)) != -1){
            out.write(buffer);
            System.out.println("复制成功");
        }
    
        
    }
    
    @RequestMapping(value="/upfile.do",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String upfile(HttpServletRequest request,String pdfurl,String orderid,String addtime){
    	
			
			Map result=new HashMap();
			result.put("pdfurl", pdfurl);
			result.put("orderid", orderid);
			result.put("addtime", addtime);
			System.out.println("http:"+result);
			return jsonutil.toJSONString(result);
    	
    	
    	
    }
    
    @RequestMapping(value="/dfile.do",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map dfile(HttpServletRequest request,@RequestBody String jsonpath){
    	
    		Map result=new HashMap();
    	    jsonpath=jsonpath.replace("[", "").replace("]", "");  
    	    result=jsonutil.toHashMap(jsonpath);
    	    String realPath =request.getSession().getServletContext().getRealPath("/image/upload");
    	    //System.out.println(realPath);
    	    String npath=realPath+pathutil.getPath()+creditutil.timefile();
			try {
				upload.tofile(result.get("opath").toString(),npath,result.get("fname").toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return result;
    	
    	
    	
    }
    @RequestMapping(value="/upfile1.do",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String file(
    		@RequestParam("front") MultipartFile front,
    		@RequestParam("opposite") MultipartFile opposite,
    		@RequestParam("apply") MultipartFile apply,
    		@RequestParam("authorize") MultipartFile authorize,
    		@RequestParam("hz") MultipartFile hz,HttpServletRequest request
    		){
    	MultipartFile[] files={front,opposite,apply,authorize,hz};
    	for(int is=0;is<files.length;is++){
    		
    		//通过MultipartFile 对象获取文件的原文件名 
       	 String fileName = files[is].getOriginalFilename();
       	 String realPath =request.getSession().getServletContext().getRealPath("/image/upload");
   				 //"C:/Users/tutu/workspace/Xinwen/WebContent/images/";

       	 UUID randomUUID = UUID.randomUUID();
   		 //获取文件的后缀名
   		 int i = fileName.lastIndexOf(".");
   		 String uuidName = randomUUID.toString().replaceAll("-","")+fileName.substring(i);
   		//获取一个文件的保存路径
   		 String path = realPath+"\\"+uuidName;
   		 // 为文件这服务器中开辟一给新的空间,*没有数据
   		 // File newFile = new File(path); 		
   		 //System.err.println("-----服务器的路径地址为：:"+realPath);
   		 System.err.println("-----图片名称为：:"+fileName);
   		 System.err.println("-----图片新名称为：:"+uuidName);
   		// System.err.println("-----图片新路径为：:"+path);
   		 try {
   			files[is].transferTo(new File(path));
   	    		 } catch (IllegalStateException e) {
   	    		 // TODO Auto-generated catch block
   	    		 e.printStackTrace();
   	    		 } catch (IOException e) {
   	    		 // TODO Auto-generated catch block
   	    		 e.printStackTrace();
   	    		 }
    		
    	}
    
    	
    	
    	
		return "success";  
    }
    
    
    public static void main(String[] args)
    {
//    	try {
//    		copyDir("C:/Users/tutu/PycharmProjects/untitled1/表情包","C:/Users/tutu/Desktop/img/sss");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        String [] fileName = getFileName("C:/Users/tutu/Desktop/img/二次元 性感/");
//        for(String name:fileName)
//        {
//            System.out.println(name);
//        }
//        System.out.println("--------------------------------");
//        ArrayList<String> listFileName = new ArrayList<String>(); 
//        getAllFileName("C:/Users/tutu/Desktop/img/二次元 性感/",listFileName);
//        for(String name:listFileName)
//        {     	       
//            System.out.println(name);
//        }
//    
    	
    	
    	
    }
    
}
