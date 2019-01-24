package com.controller.ftp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.model.icbc.icbc;
import com.model.icbc.icbc_kk;
import com.model1.gems;
import com.model1.icbc.icbc_dk;
import com.model1.icbc.icbc_ftpzip;
import com.model1.icbc.icbc_mq;
import com.service1.gemsService;
import com.service1.kjs_icbc.ftpzipService;
import com.service1.kjs_icbc.icbc_dkService;
import com.service1.kjs_icbc.icbc_mqService;
import com.service1.kjs_icbc.newicbcService;
import com.service1.kjs_icbc.newicbc_kkService;
import com.util.creditutil;
import com.util.jsonutil;
   

@Controller
public class UnzipController {
	 
	  @Autowired
	  private gemsService gemsService;
	  @Autowired
	  private ftpzipService ftpzipService;
	  @Autowired
	  private newicbcService newicbcService;
	  @Autowired
	  private newicbc_kkService newicbc_kkService;
	  @Autowired
	  private icbc_mqService icbc_mqService;
	  @Autowired
	  private icbc_dkService icbc_dkService;
	
	 public static List<String> zipToFile(String sourceFile,String toFolder) throws Exception {  
	        String toDisk = toFolder;//接收解压后的存放路径  
	        ZipFile zfile = new ZipFile(sourceFile);//连接待解压文件  
	        System.out.println("要解压的文件是:" + zfile.getName());  
	        Enumeration zList = zfile.entries();//得到zip包里的所有元素  
	        ZipEntry ze = null;  
	        byte[] buf = new byte[1024]; 
	        List<String> list=new ArrayList<String>();
	        while (zList.hasMoreElements()) {  
	            ze = (ZipEntry) zList.nextElement();  
	            if(ze.isDirectory()){  
	                //System.out.println("打开zip文件里的文件夹:" + ze.getName());  
	                continue;  
	            }  
	            //System.out.println("zip包里的文件: " + ze.getName() + "\t" + "大小为:" 
	            //       + ze.getSize() + "KB");  
	            //以ZipEntry为参数得到一个InputStream，并写到OutputStream中  
	            OutputStream outputStream = new BufferedOutputStream(  
	                    new FileOutputStream(getRealFileName(toDisk, ze.getName())));  
	            InputStream inputStream = new BufferedInputStream(zfile  
	                    .getInputStream(ze));  
	            int readLen = 0;  
	            while ((readLen = inputStream.read(buf, 0, 1024)) != -1) {  
	                outputStream.write(buf, 0, readLen);  
	            }  
	            inputStream.close();  
	            outputStream.close();  
	            System.out.println("已经解压出:" + ze.getName());  
	            list.add(ze.getName());
	        }  
	        zfile.close();
			return list;  
	    }  
	    private static File getRealFileName(String zippath, String absFileName){  
	    	 
	        String[] dirs = absFileName.split("/", absFileName.length());  
	        File ret = new File(zippath);// 创建文件对象  
	        if (dirs.length > 1) {  
	            for (int i = 0; i < dirs.length - 1; i++) {  
	                ret = new File(ret, dirs[i]);  
	            }  
	        }  
	        if (!ret.exists()) {// 检测文件是否存在  
	            ret.mkdirs();// 创建此抽象路径名指定的目录  
	        }  
	        ret = new File(ret, dirs[dirs.length - 1]);// 根据 ret 抽象路径名和 child 路径名字符串创建一个新 File 实例  
	        return ret;  
	    }
	     private String fwqpath="/KCDIMG/assess/upload/";
		 private String localpath="C:/Users/Administrator/Desktop/";
		
		 
	   @RequestMapping(value="/unzip.do",produces="text/html;charset=UTF-8")
	   @ResponseBody
	   public String unzip(
			   String orderid,
			   String appkey,
			   String zipname,
			   String oredit,
			   HttpServletRequest request
			   ) throws UnsupportedEncodingException{
		   JSONObject result1=new JSONObject();
		   result1.put("orderid",orderid);
			
		   icbc icbc;
			if(orderid!=null&&!orderid.equals("")){
	        	icbc=newicbcService.findicbcbyorderid2(orderid);        	
	            if(icbc==null||icbc.equals("")){
	            	JSONObject result=new JSONObject();
	    			result.put("result",result1);
	    			result.put("msg","订单编号错误");
	    			result.put("code","212");
	    			return result.toString();
	            }	
	        }else{
	        	JSONObject result=new JSONObject();
				result.put("result",result1);
				result.put("msg","orderid不能为空");
				result.put("code","210");
				return result.toString();
	        }
			if(zipname!=null&&!zipname.equals("")){
				  icbc_ftpzip ftpzip=ftpzipService.findftpzipbyzip_name(zipname);
			      if(ftpzip!=null
			    		  &&!ftpzip.equals("")
			    		  &&ftpzip.getIcbc_id()!=icbc.getId()){
			    	    JSONObject result=new JSONObject();
			   			result.put("result",result1);
			   			result.put("msg","压缩包名称重复");
			   			result.put("code","210");
			   			return result.toString();
			      }
			   }else{
				    JSONObject result=new JSONObject();
		   			result.put("result",result1);
		   			result.put("msg","zipname不能为空");
		   			result.put("code","210");
		   			return result.toString();
			   }
		   gems gems;
		   if(appkey!=null&&!appkey.equals("")){
	        	gems=gemsService.find_api(appkey);
				if(gems!=null&&!gems.equals("")){
					if(gems.getApi_tag()!=1){
						JSONObject result=new JSONObject();
						result.put("result",result1);
						result.put("msg","未开通API权限");
						result.put("code","211");
						return result.toString();			
					}
				}else{
					JSONObject result=new JSONObject();
					result.put("result",result1);
					result.put("msg","appkey错误");
					result.put("code","211");
					return result.toString();
				}
			}else{
				JSONObject result=new JSONObject();
				result.put("result",result1);
				result.put("msg","ckey不能为空");
				result.put("code","210");
				return result.toString();	
			} 
		icbc_ftpzip icbc_ftpzip=new icbc_ftpzip();   
		icbc_ftpzip.setDt_edit(creditutil.time());
		icbc_ftpzip.setMid_edit(gems.getAdmin_id());
		icbc_ftpzip.setIcbc_id(icbc.getId());
		icbc_ftpzip.setZip_name(zipname);
		icbc_ftpzip.setZip_path(fwqpath+zipname);
	    icbc_ftpzip icbc_ftpzip2=ftpzipService.findftpzipbyicbc_id(icbc.getId());
	    if(oredit.equals("1")){
	    if(icbc_ftpzip2!=null&&!icbc_ftpzip2.equals("")){	
	        //解压文件
	        try {
	        	icbc_kk icbc_kk=new icbc_kk();
	        	icbc_dk icbc_dk=new icbc_dk();
	        	icbc_mq icbc_mq=new icbc_mq();
				List<String> list=zipToFile(fwqpath+zipname,fwqpath);
				System.out.println(list.size());
				String kkimg7s="";
				String dkimg1="";
				String dkimg2="";
				String dkimg3="";
				String dkimg4="";
				String dkimg5="";
				String dkimg6="";
				String dkimg7="";
				String dkimg8="";
				for(int i=0;i<list.size();i++){
					String name=list.get(i);
					String filename=name.substring(name.indexOf("/")+1, name.indexOf("."));
					String filetype=filename.substring(0, 2);
					String fileno=filename.substring(2, 3);
					if(filetype.equals("kk")){
					if(Integer.parseInt(fileno)==1){
					    icbc_kk.setImgstep3_1("upload/"+name);	
					}
					if(Integer.parseInt(fileno)==2){
						icbc_kk.setImgstep3_2("upload/"+name);	
					}
					if(Integer.parseInt(fileno)==3){
						icbc_kk.setImgstep3_3("upload/"+name);	
					}
					if(Integer.parseInt(fileno)==4){
						icbc_kk.setImgstep3_4("upload/"+name);	
					}
					if(Integer.parseInt(fileno)==5){
						icbc_kk.setImgstep3_5("upload/"+name);	
					}
					if(Integer.parseInt(fileno)==6){
						icbc_kk.setImgstep3_6("upload/"+name);	
					}
					if(Integer.parseInt(fileno)==7){
						icbc_kk.setImgstep3_7("upload/"+name);	
					}
					if(Integer.parseInt(fileno)==8){
						kkimg7s=kkimg7s+""+"upload/"+name;
					}
					}
					if(filetype.equals("dk")){
						if(Integer.parseInt(fileno)==1){
							dkimg1=dkimg1+""+"upload/"+name;
						}
						if(Integer.parseInt(fileno)==2){
							dkimg2=dkimg2+""+"upload/"+name;	
						}
						if(Integer.parseInt(fileno)==3){
							dkimg3=dkimg3+""+"upload/"+name;	
						}
						if(Integer.parseInt(fileno)==4){
							dkimg4=dkimg4+""+"upload/"+name;	
						}
						if(Integer.parseInt(fileno)==5){
							dkimg5=dkimg5+""+"upload/"+name;	
						}
						if(Integer.parseInt(fileno)==6){
							dkimg6=dkimg6+""+"upload/"+name;	
						}
						if(Integer.parseInt(fileno)==7){
							dkimg7=dkimg7+""+"upload/"+name;	
						}
						if(Integer.parseInt(fileno)==8){
							dkimg8=dkimg8+""+"upload/"+name;
						}	
					}
					if(filetype.equals("mq")){
						if(Integer.parseInt(fileno)==1){
							icbc_mq.setImgstep8_1v("upload/"+name);
						}
						if(Integer.parseInt(fileno)==2){
							icbc_mq.setImgstep8_2v("upload/"+name);	
						}
						if(Integer.parseInt(fileno)==3){
							icbc_mq.setImgstep8_3v("upload/"+name);	
						}
						if(Integer.parseInt(fileno)==4){
							icbc_mq.setImgstep8_4v("upload/"+name);	
						}
					}
				}
				icbc_kk.setImgstep3_7s(kkimg7s);
				icbc_dk.setImgstep4_1ss(dkimg1);
				icbc_dk.setImgstep4_2ss(dkimg2);
				icbc_dk.setImgstep4_3ss(dkimg3);
				icbc_dk.setImgstep4_4ss(dkimg4);
				icbc_dk.setImgstep4_5ss(dkimg5);
				icbc_dk.setImgstep5_1ss(dkimg6);
				icbc_dk.setImgstep6_1ss(dkimg7);
				icbc_dk.setImgstep7_1ss(dkimg8);
				icbc_ftpzip.setZip_tag(1);	
				icbc_kk.setId(Integer.parseInt(icbc.getKkid()));
				icbc_mq.setId(Integer.parseInt(icbc.getMqid()));
				icbc_dk.setId(Integer.parseInt(icbc.getDkid()));
				newicbc_kkService.upicbc_kk(icbc_kk);
				icbc_mqService.upmq(icbc_mq);
				icbc_dkService.upicbc_cardk(icbc_dk);
			} catch (Exception e) {
				
				icbc_ftpzip.setZip_tag(2);
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	icbc_ftpzip.setId(icbc_ftpzip2.getId());
	    	ftpzipService.upftpzip(icbc_ftpzip);	
	    	JSONObject result=new JSONObject();
			result.put("result",result1);
			result.put("msg","成功");
			result.put("code","200");
			return result.toString();
	    }else{
	    	JSONObject result=new JSONObject();
			result.put("result",result1);
			result.put("msg","未上传文件");
			result.put("code","201");
			return result.toString();
	    }
	    }else{
	    	if(icbc_ftpzip2!=null&&!icbc_ftpzip2.equals("")){	    			    		
		    	JSONObject result=new JSONObject();
				result.put("result",result1);
				result.put("msg","已上传文件,不可重复上传");
				result.put("code","201");
				return result.toString();
		    }else{
		        //解压文件
		        try {
		        	icbc_kk icbc_kk=new icbc_kk();
		        	icbc_dk icbc_dk=new icbc_dk();
		        	icbc_mq icbc_mq=new icbc_mq();
					List<String> list=zipToFile(fwqpath+zipname,fwqpath);
					System.out.println(list.size());
					String kkimg7s="";
					String dkimg1="";
					String dkimg2="";
					String dkimg3="";
					String dkimg4="";
					String dkimg5="";
					String dkimg6="";
					String dkimg7="";
					String dkimg8="";
					for(int i=0;i<list.size();i++){
						String name=list.get(i);
						String filename=name.substring(name.indexOf("/")+1, name.indexOf("."));
						String filetype=filename.substring(0, 2);
						String fileno=filename.substring(2, 3);
						if(filetype.equals("kk")){
						if(Integer.parseInt(fileno)==1){
						    icbc_kk.setImgstep3_1("upload/"+name);	
						}
						if(Integer.parseInt(fileno)==2){
							icbc_kk.setImgstep3_2("upload/"+name);	
						}
						if(Integer.parseInt(fileno)==3){
							icbc_kk.setImgstep3_3("upload/"+name);	
						}
						if(Integer.parseInt(fileno)==4){
							icbc_kk.setImgstep3_4("upload/"+name);	
						}
						if(Integer.parseInt(fileno)==5){
							icbc_kk.setImgstep3_5("upload/"+name);	
						}
						if(Integer.parseInt(fileno)==6){
							icbc_kk.setImgstep3_6("upload/"+name);	
						}
						if(Integer.parseInt(fileno)==7){
							icbc_kk.setImgstep3_7("upload/"+name);	
						}
						if(Integer.parseInt(fileno)==8){
							kkimg7s=kkimg7s+""+"upload/"+name;
						}
						}
						if(filetype.equals("dk")){
							if(Integer.parseInt(fileno)==1){
								dkimg1=dkimg1+""+"upload/"+name;
							}
							if(Integer.parseInt(fileno)==2){
								dkimg2=dkimg2+""+"upload/"+name;	
							}
							if(Integer.parseInt(fileno)==3){
								dkimg3=dkimg3+""+"upload/"+name;	
							}
							if(Integer.parseInt(fileno)==4){
								dkimg4=dkimg4+""+"upload/"+name;	
							}
							if(Integer.parseInt(fileno)==5){
								dkimg5=dkimg5+""+"upload/"+name;	
							}
							if(Integer.parseInt(fileno)==6){
								dkimg6=dkimg6+""+"upload/"+name;	
							}
							if(Integer.parseInt(fileno)==7){
								dkimg7=dkimg7+""+"upload/"+name;	
							}
							if(Integer.parseInt(fileno)==8){
								dkimg8=dkimg8+""+"upload/"+name;
							}	
						}
						if(filetype.equals("mq")){
							if(Integer.parseInt(fileno)==1){
								icbc_mq.setImgstep8_1v("upload/"+name);
							}
							if(Integer.parseInt(fileno)==2){
								icbc_mq.setImgstep8_2v("upload/"+name);	
							}
							if(Integer.parseInt(fileno)==3){
								icbc_mq.setImgstep8_3v("upload/"+name);	
							}
							if(Integer.parseInt(fileno)==4){
								icbc_mq.setImgstep8_4v("upload/"+name);	
							}
						}
					}
					icbc_kk.setImgstep3_7s(kkimg7s);
					icbc_dk.setImgstep4_1ss(dkimg1);
					icbc_dk.setImgstep4_2ss(dkimg2);
					icbc_dk.setImgstep4_3ss(dkimg3);
					icbc_dk.setImgstep4_4ss(dkimg4);
					icbc_dk.setImgstep4_5ss(dkimg5);
					icbc_dk.setImgstep5_1ss(dkimg6);
					icbc_dk.setImgstep6_1ss(dkimg7);
					icbc_dk.setImgstep7_1ss(dkimg8);
					icbc_ftpzip.setZip_tag(1);
					icbc_kk.setId(Integer.parseInt(icbc.getKkid()));
					icbc_mq.setId(Integer.parseInt(icbc.getMqid()));
					icbc_dk.setId(Integer.parseInt(icbc.getDkid()));
					newicbc_kkService.upicbc_kk(icbc_kk);
					icbc_mqService.upmq(icbc_mq);
					icbc_dkService.upicbc_cardk(icbc_dk);
				} catch (Exception e) {
					icbc_ftpzip.setZip_tag(2);
				}
		    	icbc_ftpzip.setGems_id(gems.getId());
		    	icbc_ftpzip.setGems_fs_id(gems.getFsid());
				icbc_ftpzip.setMid_add(gems.getAdmin_id());				
		    	icbc_ftpzip.setDt_add(creditutil.time());
		    	ftpzipService.addftpzip(icbc_ftpzip);	
		    	JSONObject result=new JSONObject();
				result.put("result",result1);
				result.put("msg","成功");
				result.put("code","200");
				return result.toString();
		    }
	    	
	    }
	   }	
}
