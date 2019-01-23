package com.controller.index;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.http.niwodaihttp;
import com.http.tozxxx;
import com.model.pdfover;
import com.service.pdfoverService;
import com.util.Base64Test;
import com.util.creditutil;
import com.util.jsonutil;
import com.util.pathutil;

@Controller
public class ceshiController {
    
	@Autowired
	 private   pdfoverService pdfservice;
			
	   niwodaihttp nwd=new niwodaihttp();
	
	  @RequestMapping(value="/zxceshi.do",produces = "text/html;charset=UTF-8")
	  @ResponseBody
	  public String zxceshi(@RequestParam("fronttobase") String fronttobase,
	    		@RequestParam("oppositetobase") String oppositetobase,
	    		@RequestParam("applytobase") String applytobase,
	    		@RequestParam("authorizetobase") String authorizetobase,
	    		@RequestParam("hztobase") String hztobase,
	    		@RequestParam("ckey") String ckey,
	    		@RequestParam("name") String name,
	    		@RequestParam("IDcard_num") String IDcard_num,
	    		@RequestParam("phone_num") String phone_num,
	    		@RequestParam("authorize_num") String authorize_num,
	    		@RequestParam("sum_bit") String sum_bit,
	    		@RequestParam("ly") String ly,
	    		@RequestParam("sign") String sign,
	    		@RequestParam("time") String time,
	    		HttpServletRequest request){

          String result=niwodaihttp.zxtj(fronttobase, oppositetobase, applytobase, authorizetobase, hztobase, 
    		   ckey, name, IDcard_num, phone_num, authorize_num, sum_bit, ly);
		
					
		  return result;
}
	
	  @RequestMapping(value="/cxceshi.do",produces = "text/html;charset=UTF-8")
	  @ResponseBody
	  public String cxceshi(String ckey,String orderNo){
		  System.out.println(ckey+"----"+orderNo);
          String result=niwodaihttp.zxcx(orderNo, ckey);
		  System.out.println(result);
					
		  return result;
}
	  @RequestMapping(value="/updfile.do",produces = "text/html;charset=UTF-8")
	  @ResponseBody
	  public String  updfile(String fronttobase,HttpServletRequest request){
		   Base64Test basetest=new Base64Test();
		   UUID randomUUID1 = UUID.randomUUID();
		   String  frontname =randomUUID1.toString().replace("-","")+creditutil.timefile()+".jpg";
		   String  path ="/opt/javaimg";
		   File file=new File(frontname);
		   if(!file.exists()){
			   file.mkdirs();
		   }
		   
		   Base64Test.decodeBase64ToImage(fronttobase.toString(),path,frontname);
		   
		   return frontname ;
		  
		  
		  
	  }
	  
	  
	  @RequestMapping(value="/hqzxbg.do",produces = "text/html;charset=UTF-8")
	  @ResponseBody
	  public String  hqzxbg(String orderNo,String pdfurl,String addtime,HttpServletRequest request){
		  Map result=new HashMap();
		  if(!addtime.equals("")&&addtime!=null&&!orderNo.equals("")&&orderNo!=null&&!pdfurl.equals("")&&pdfurl!=null){
			  result.put("errcode","1");
			  result.put("errmsg","成功");			  			  
		  }else{			  
			  result.put("errcode","2");
			  result.put("errmsg","字段为空"); 
		  }
		  
		  
		  return jsonutil.toJSONString(result).replace("[","").replace("]","");
		  
		  
		  
	  }
	  
	  @RequestMapping(value="/pdfceshi.do",produces = "multipart/form-data;charset=UTF-8")
	  public String pdfceshi(MultipartFile file,String orderNo,HttpServletRequest request){
		     pathutil pu=new pathutil();
		     String pathtype=pathutil.getPath();
		     pdfover p=new pdfover();
	    	 //String realPath =request.getSession().getServletContext().getRealPath("/image/upload");
	    	 //将路径转化为文件夹 并 判断文件夹是否存在
	    	 File dir=new File("/opt/javaimg/image/upload/"+creditutil.timefile());
	    	 if(!dir.exists()){
				 dir.mkdirs();
				 }
			    String fileName = file.getOriginalFilename();
			    UUID randomUUID = UUID.randomUUID();
	   		 //获取文件的后缀名
	   		    int i = fileName.lastIndexOf(".");
	   		    String type=fileName.substring(i);	    	 	   			 	   			 
	   			String uuidName = randomUUID.toString().replaceAll("-","")+type;
	   		   
			   	    				
	 	   		//获取一个文件的保存路径
	 	   		String path ="/opt/javaimg/image/upload/"+creditutil.timefile()+pathtype+uuidName;	 	     	
	   			try {
	   				File spath=new File(path);	   					
		   			spath.setWritable(true,false);	    		
					file.transferTo(spath);
					p.setPdfname(uuidName);
					p.setPdfuptime(creditutil.time());
					p.setPdfurl("http://apitest.kcway.net/image/upload/"+creditutil.timefile());
					p.setUid(orderNo);
					pdfservice.uppdf(p);
					
					  boolean t=true;
					  tozxxx tozxxx=new tozxxx();
					 while(t){
						 int in=1;
						String s=niwodaihttp.hqzxbg(orderNo,p.getPdfurl()+"/"+p.getPdfname(),creditutil.time());  
						
						 //String s=null;
				         String sres=s.toString();  
				         System.out.println("第"+in+"次推送数据:"+sres);
				        
				         Map mapObj = JSON.parseObject(sres,Map.class);
				         request.setAttribute("errcode",mapObj.get("errcode"));
						 request.setAttribute("errmsg",mapObj.get("errmsg"));
				         try {
							Thread.sleep(5000);// 睡眠100毫秒
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						 if(Integer.parseInt(mapObj.get("errcode").toString())==1){
							System.out.println( mapObj.get("errcode"));
							 request.setAttribute("errcode",mapObj.get("errcode"));
							 request.setAttribute("errmsg",mapObj.get("errmsg"));
						   t=false;
						 } 
					   in++;
					 }
					
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		  request.setAttribute("orderNo",orderNo);
		  request.setAttribute("pdfurl",p.getPdfurl()+"/"+p.getPdfname());
		  //request.setAttribute("pdfname",p.getPdfname());
		  request.setAttribute("addtime",p.getPdfuptime());
		  return "niwodaihttp";
         }
	  
	  
	  @RequestMapping(value="/shresult.do",produces = "text/html;charset=UTF-8")
	  @ResponseBody
	  public  String  shresult(HttpServletRequest request,HttpServletResponse response,
			    String name,
	    		String idCard,
	    		String phoneNo,
	    		String orderNo){
		  String errcode="";
		  String errmsg="";
		  Map result=new HashMap();
		if(!name.equals("")&&name!=null
   			 &&!idCard.equals("")&&idCard!=null
   			 &&!phoneNo.equals("")&&phoneNo!=null
   			 &&!orderNo.equals("")&&orderNo!=null){
			errcode="1";
			errmsg="成功";
		}else{
			errcode="2";
			errmsg="失败(推送字段为空)";
		}

			 String s=niwodaihttp.shxxresult(name, idCard, phoneNo, orderNo, errcode, errmsg);
			  Map mapObj = JSON.parseObject(s,Map.class);
			  System.out.println(mapObj.get("errcode"));
			  if(Integer.parseInt(mapObj.get("errcode").toString())==1){
					//System.out.println( mapObj.get("errcode"));
				  result.put("errcode",mapObj.get("errcode"));
				  result.put("errmsg",mapObj.get("errmsg"));
			      result.put("orderNo",orderNo);
			  }else{
				 // Map result=new HashMap();
				  result.put("errcode",mapObj.get("errcode"));
				  result.put("errmsg",mapObj.get("errmsg"));
				  result.put("orderNo",orderNo);
			  } 
	  
		  return jsonutil.toJSONString(result).replace("[", "").replace("]","");
		  
		  
		  
		  
	  }
}
