package com.controller.assess;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.http.hmdhttp;
import com.model.bb;
import com.model.company;
import com.model.credit;
import com.model.gskh;
import com.model.history;
import com.model.hmd;
import com.model.img;
import com.model.gsrykh;
import com.model.pdfover;
import com.model.yw;
import com.model.index.zxmodel;
import com.service.bbService;
import com.service.creditService;
import com.service.gskhService;
import com.service.historyService;
import com.service.hmdService;
import com.service.imgService;
import com.service.gsrykhService;
import com.service.mdxxService;
import com.service.pdfoverService;
import com.service.ywService;
import com.util.Base64Test;
import com.util.creditutil;
import com.util.jsonutil;

@Controller
public class tyhttpController {

	
	 @Autowired
	 private bbService bbservice;
	 @Autowired
     private pdfoverService pdfoverservice;
	 @Autowired
	 private historyService historyservice;
	 @Autowired
	 private creditService creditservice;
	 @Autowired
     private imgService imgservice;
	 @Autowired
	 private ywService ywservice;
	 @Autowired
	 private gsrykhService khgsservice;
	 @Autowired
	 private mdxxService mdxxservice;
	 @Autowired
	 private gskhService gskhservice;
	 @Autowired
	 private hmdService hmdservice;
	 //json 工具类
	 jsonutil ju=new jsonutil();
	
	 Base64Test basetest=new Base64Test();

	 
	@RequestMapping(value="/cshttp.do",method=RequestMethod.POST ,produces="text/html;charset=UTF-8")
    @ResponseBody
    public String cshttp(
    		String csstr,
    		String id
    		){	
		
		
		
		return "测试数据："+csstr+"----"+id;
		
		
	}
	 /**
	  * 征信报告查询接口(通用)
	  * @param request
	  * @param orderNo
	  * @param ckey
	  * @return
	  */
	@RequestMapping(value="/findresult.do",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String findpdf(HttpServletRequest request,
   		 String orderNo,
   		 String ckey
   		 ){			
		System.out.println(orderNo+"-------------"+ckey);
		 Map result=new HashMap();
		 pdfover po=new pdfover();
   	 //history ht=new history();
		 Map m=new HashMap();
		 Map m1=new HashMap();
		 Map m2=new HashMap();
	 	 // m=hts.findhistory(uid);
		 Map mkey=new HashMap();
		 mkey=khgsservice.fgsrykh(ckey);
		 System.out.println("-----------"+mkey);
		 if(mkey!=null&&!mkey.equals("")&&mkey.size()>0){			
   	     m1=pdfoverservice.findbyid(orderNo);
   	     m2=creditservice.findcreditbyid(Integer.parseInt(orderNo));
		if(m2!=null&&!m2.equals("")){
	    if(m2.get("sum_bit").equals("6")||m2.get("sum_bit").equals("7")){	
		 result.put("errcode","16");
	   	 result.put("errmsg","订单已回退或撤销"); 
		 //result.put("result",errorutil.error012());
	     return jsonutil.toJSONString(result).replace("[", "").replace("]",""); 								
	     }
	    if(m2.get("sum_bit").equals("1")){	
			 result.put("errcode","18");
		   	 result.put("errmsg","草稿箱"); 
			 //result.put("result",errorutil.error012());
		     return jsonutil.toJSONString(result).replace("[", "").replace("]",""); 								
		 }
	    if(m2.get("sum_bit").equals("2")){	
			 result.put("errcode","19");
		   	 result.put("errmsg","申请模板"); 
			 //result.put("result",errorutil.error012());
		     return jsonutil.toJSONString(result).replace("[", "").replace("]",""); 								
		 }
	    if(m2.get("sum_bit").equals("3")){	
			 result.put("errcode","20");
		   	 result.put("errmsg","等待上传"); 
			 //result.put("result",errorutil.error012());
		     return jsonutil.toJSONString(result).replace("[", "").replace("]",""); 								
		 }
	     if(m2.get("sum_bit").equals("4")){	
	    	 if(m2.get("shzt").equals("1")){
	    		 result.put("errcode","21");
			   	 result.put("errmsg","初审完成");
			   	return jsonutil.toJSONString(result).replace("[", "").replace("]","");
	    	 }
			 result.put("errcode","17");
		   	 result.put("errmsg","正在查询"); 
			 //result.put("result",errorutil.error012());
		     return jsonutil.toJSONString(result).replace("[", "").replace("]",""); 								
		 }
       	 if(m2.get("sum_bit").equals("5")){
//   	 m1.get("pdftime").toString();
//   	 m1.put("pdftime", m1.get("pdftime").toString());
//   	 m1.put("pdfuptime", m1.get("pdfuptime").toString());
//   	 m2=cds.findbysfz(uid);
//   	 m1.put("ztcode",m2.get("sum_bit"));
       		 if(m1.get("pdfurl")!=null&&!m1.get("pdfurl").equals("")){
       		     m.put("pdfurl","http://apitest.kcway.net/image/upload/"+creditutil.timetofile(m1.get("pdfuptime").toString()));	   
        	     m.put("pdfname",m1.get("pdfname").toString());
        	     m.put("orderNo",orderNo);
        	     m.put("pdftime",m1.get("pdftime").toString().replace(".0",""));
        	     result.put("result",m);
        	     result.put("errcode","1");
        	     result.put("errmsg","查询成功");   	   
         	     return jsonutil.toJSONString(result).replace("[", "").replace("]","");    
       		 }else{
       			 result.put("errcode","11");
       	         result.put("errmsg","无PDF结果");   	   
        	     return jsonutil.toJSONString(result).replace("[", "").replace("]","");    
       		 }	
  	  
	      }	
		}else{			
			 result.put("errcode","12");
		   	 result.put("errmsg","订单编号错误"); 
			 //result.put("result",errorutil.error012());
		     return jsonutil.toJSONString(result).replace("[", "").replace("]",""); 	
		}
		 }else{			
			 result.put("errcode","2");
		   	 result.put("errmsg","用户验证失败"); 
			 //result.put("result",errorutil.error02());
		     return jsonutil.toJSONString(result).replace("[", "").replace("]",""); 			
		}
		return "";
    } 
	 //添加 查询  sum_bit 为 1 为提交查询 为 0 存草稿
	    @RequestMapping(value="/zxsave.do",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	    @ResponseBody
	    public String zxsave(
	    		 MultipartFile fronttobase,
	    		 MultipartFile oppositetobase,
	    		 MultipartFile applytobase,
	    		 MultipartFile authorizetobase,
	    		 MultipartFile hztobase,
	    		String ckey,
	    	    String name,
	    		String IDcard_num,
	    		String phone_num,
	    		String authorize_num,
	    		String sum_bit,
	    		String ly,
	    		HttpServletRequest request){
	    	company ccompany=new company();
	        credit credit=new credit();
	        bb bb=new bb();
	        yw yw=new yw();
	        history h=new history();
	        pdfover p=new pdfover();
	        img imgmodel=new img(); 
	    	 String frontname = null,oppositename = null,applyname = null,authorizename = null,hzname = null;
             String type=null;// 文件类型
             Map result=new HashMap();
             Map khgs=khgsservice.fgsrykh(ckey);
  	       if(khgs!=null&&!khgs.equals("")&&khgs.size()>0){
  	       if(Integer.parseInt(khgs.get("kd").toString())>0&&khgs.get("kd")!=null&&!khgs.get("kd").equals("")){
  	    	   int kd=Integer.parseInt(khgs.get("kd").toString());	
  	    	   if(kd>100){
  	    		 if(!name.equals("")&&name!=null
    	    			 &&!IDcard_num.equals("")&&IDcard_num!=null
    	    			 &&!phone_num.equals("")&&phone_num!=null
    	    			 &&!authorize_num.equals("")&&authorize_num!=null
    	    			 &&!sum_bit.equals("")&&sum_bit!=null
  	    				 ){			     	    		   
	    	 MultipartFile[] files={fronttobase,oppositetobase,applytobase,authorizetobase,hztobase};
	    	 String realPath =request.getSession().getServletContext().getRealPath("/image/upload");
	    	 File dir = new File(realPath+"/img/"+creditutil.timefile());
			 if(!dir.exists()){
			 dir.mkdirs();
			 }
			 for(int is=0;is<files.length;is++){	 	   			 	 	   			 	 	   			
 	 	    	//通过MultipartFile 对象获取文件的原文件名 
 	 	       	 String fileName = files[is].getOriginalFilename(); 	 	 
 	 	       	    UUID randomUUID = UUID.randomUUID(); 	 	   		
 	 	   		    int i = fileName.lastIndexOf("."); 
 	 	            if(i==-1){
 	 	               result.put("errcode", "16");
 	 			       result.put("errmsg", "文件格式错误或字段为空");
 	 			       //result.put("orderNo",errorutil.error04());
 	 			       return jsonutil.toJSONString(result).replace("[", "").replace("]","");
 	 	            }
 	 	   		    //获取文件的后缀名
 	 	            type=fileName.substring(i);
 	 	   			String uuidName = randomUUID.toString().replaceAll("-","")+type;    				
 		 	   		//获取一个文件的保存路径
 		 	   		String path = realPath+"/img/"+creditutil.timefile()+"/"+uuidName;
 		 	   		 
 		 	   	if(is==0){
 		 	   	frontname=uuidName;
	 	   		}else if (is==1) {
	 	   		oppositename=uuidName;
	 			} else if (is==2) {
	 			applyname=uuidName;
	 			} else if (is==3) {
	 			authorizename=uuidName;
	 			} else if (is==4) {
	 			hzname=uuidName;
	 			} 	
 		 	   	System.out.println("第"+is+"张图片:"+uuidName);
 		 	   		 // 为文件这服务器中开辟一给新的空间,*没有数据
 		 	   		 // File newFile = new File(path); 		
 		 	   		 //System.err.println("-----服务器的路径地址为：:"+realPath);
 		 	   		 //System.err.println("-----图片名称为：:"+fileName);
 		 	   		// System.err.println("-----图片新名称为：:"+uuidName);	   		   			    		    		    
 		 	   		// System.err.println("-----图片新路径为：:"+path);
 					 try {
 						 File spath= new File(path);
 						 spath.setWritable(true,false);
 			    		 files[is].transferTo(spath);
 			    		 }catch (IOException e) { 			   
 			    		 
 			    		 }
 		 	    		
 		 	    	}
			   credit.setIDcard_num(IDcard_num);
	   	       credit.setSum_bit(sum_bit);
	   	       credit.setName(name);
	   	       credit.setPhone_num(phone_num);
	       	   credit.setAdd_time(creditutil.time().toString());
	       	   credit.setAuthorize_num(authorize_num);
	       	   credit.setMdid(khgs.get("khid").toString());
	       	   credit.setUp_time(creditutil.time());
	       	   credit.setShzt("4");	       	   
			   imgmodel.setAddtime(creditutil.time().toString());
	   	       imgmodel.setFrontimg(frontname);
	   	       imgmodel.setOppositeimg(oppositename);
	   	       imgmodel.setApplyimg(applyname);
	   	       imgmodel.setAuthorizeimg(authorizename);
	   	       imgmodel.setHzimg(hzname);
	   	       imgmodel.setUptime(creditutil.time());              
	   	       creditservice.save(credit);
	   	 gsrykh mdkd=new gsrykh();
         kd=kd-100;
         mdkd.setKd(kd);
         mdkd.setCkey(ckey);
         khgsservice.upkd(mdkd);   		                       
         imgmodel.setHttppath("http://apitest.kcway.net/image/upload/img/"+creditutil.timefile().toString());
         //imgmodel.setImgpath(realPath);   	   
            h.setZt(sum_bit);      
            if(!ly.equals("")&&ly!=null){
         	   h.setLy(ly);
         	   bb.setBb(ly);
            }
	   h.setUid(String.valueOf(credit.getId()));  
   	   p.setUid(String.valueOf(credit.getId()));
   	   p.setPdfuptime(creditutil.time());
   	   imgmodel.setUid(credit.getId());
   	   bb.setKhxm(name);
   	   bb.setSfzbh(IDcard_num);
   	   bb.setSqsbh(authorize_num);
   	   bb.setMd(khgs.get("khgsname").toString());
   	   bb.setOrderid(String.valueOf(credit.getId()));
   	   bb.setCxr(khgs.get("khrname").toString());    		     	        	      		     	        	 
   	   bb.setOnecxtime(creditutil.time().toString());
       imgservice.addimg(imgmodel);   		     	    		   
   	   historyservice.hsava(h);    		     		    	   
   	   pdfoverservice.addpdf(p);
   	   bbservice.addbb(bb);
   	   result.put("errcode", "1");
       result.put("errmsg", "提交成功");
       result.put("orderNo",credit.getId());
       
  	    		 }else {						
		    	   result.put("errcode", "3");
 			       result.put("errmsg", "提交的字段不完整");
 			      // result.put("orderNo",errorutil.error04());
 			       return jsonutil.toJSONString(result).replace("[", "").replace("]","");   
		    	   
			}
  	    	   }else {						
		    	   result.put("errcode", "4");
 			       result.put("errmsg", "余额不足");
 			       //result.put("orderNo",errorutil.error04());
 			       return jsonutil.toJSONString(result).replace("[", "").replace("]","");   
		    	   
			}
  	       }
  	       }else {		
	 	       result.put("errcode", "2");
		       result.put("errmsg", "用户验证失败");
		       //result.put("orderNo",errorutil.error02());
		       return jsonutil.toJSONString(result).replace("[", "").replace("]","");    	   
		}
		return jsonutil.toJSONString(result).replace("[", "").replace("]","");

	    	    }
	    
	    //添加 查询  sum_bit 为 1 为提交查询 为 0 存草稿
	    @RequestMapping(value="/tobase64img.do",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	    @ResponseBody
	    public String tobase64img(String fronttobase,
	    		String oppositetobase,
	    		String applytobase,
	    		String authorizetobase,
	    		String hztobase,
	    		HttpServletRequest request){
					
	    	Map m=new HashMap();
	    	m.put("1", fronttobase);
	    	m.put("2", oppositetobase);
	    	m.put("3", applytobase);
	    	m.put("4", authorizetobase);
	    	m.put("5", hztobase);
	    	
	    	return jsonutil.toJSONString(m);   
	    	
	    	
	    }	    
	    @RequestMapping(value="/to_query_zx.do",produces = "application/json;charset=UTF-8")
	    @ResponseBody
	    public String to_query_zx(@RequestBody zxmodel zx){    	    
	        Map result=new HashMap();
	        Map path=new HashMap();
	        Map file=new HashMap();
	        company ccompany=new company();
	        credit credit=new credit();
	        bb bb=new bb();
	        yw yw=new yw();
	        history h=new history();
	        pdfover p=new pdfover();
    	    img imgmodel=new img();    	    
       System.out.println("获取验证码name:"+zx.getName()+"获取验证码ckey:"+zx.getCkey());	    
       Map mdxx=khgsservice.fgsrykh(zx.getCkey());	       
       if(mdxx!=null&&!mdxx.equals("")&&mdxx.size()>0){
       Map gsmap=gskhservice.fgsbyid(Integer.parseInt(mdxx.get("gsid").toString()));   				    			
       if(gsmap.get("kd")!=null&&!gsmap.get("kd").equals("")&&Integer.parseInt(gsmap.get("kd").toString())>0){
    	   int kd=Integer.parseInt(gsmap.get("kd").toString());
    	   if(kd>100){	    		   
    		     //String realPath =request.getSession().getServletContext().getRealPath("/image/upload");
    		     String path1="/opt/javaimg/image/upload/img/"+creditutil.timefile();
    		 	 File dir = new File(path1);
    		 	 if(!dir.exists()){
    		 		 dir.mkdirs();
    		 	 }					
    		   if(zx.getName()!=null&&
    				  zx.getIdcard_num()!=null&&
    				  zx.getPhone_num()!=null&&
    				  zx.getAuthorize_num()!=null&&
    				  zx.getSum_bit()!=null&&
    				  zx.getHztobase()!=null&&
    				  zx.getAuthorizetobase()!=null&&
    				  zx.getApplytobase()!=null&&
    				  zx.getOppositetobase()!=null&&
    				  zx.getFronttobase()!=null&&
    				  !zx.getFronttobase().equals("")&&
    		   		  !zx.getOppositetobase().equals("")&&
    		   		  !zx.getApplytobase().equals("")&&
    		   		  !zx.getAuthorizetobase().equals("")&&
    		   		  !zx.getHztobase().equals("")&&
    		       	  !zx.getName().equals("")&& 
    		          !zx.getIdcard_num().equals("")&& 
    		       	  !zx.getPhone_num().equals("")&& 
    		       	  !zx.getAuthorize_num().equals("")&& 
    		          !zx.getSum_bit().equals("")
    		          ){    		 	    		   
    		       	   String add_time=creditutil.time();
    		   	       credit.setIDcard_num(zx.getIdcard_num());
    		   	       credit.setSum_bit(zx.getSum_bit());
    		   	       credit.setName(zx.getName());
    		   	       credit.setPhone_num(zx.getPhone_num());
    		       	   credit.setAdd_time(add_time);
    		       	   credit.setAuthorize_num(zx.getAuthorize_num());
    		       	   credit.setMdid(mdxx.get("khid").toString());
    		       	   credit.setUp_time(creditutil.time());
    		       	   credit.setShzt("4");
//    		       	   credit.setImgbase_1(zx.getFronttobase());
//    		       	   credit.setImgbase_2(zx.getOppositetobase());
//    		           credit.setImgbase_3(zx.getApplytobase());
//    		       	   credit.setImgbase_4(zx.getAuthorizetobase());
//    		       	   credit.setImgbase_5(zx.getHztobase());
    		       	   
    		         try {
//    		       	   String frontname=basetest.GenerateImage(fronttobase, realPath.toString());
//    		   	       String oppositename=basetest.GenerateImage(oppositetobase, realPath.toString());
//    		   	       String applyname=basetest.GenerateImage(applytobase, realPath.toString());
//    		   	       String authorizename=basetest.GenerateImage(authorizetobase, realPath.toString());
//    		   	       String hzname=basetest.GenerateImage(hztobase, realPath.toString());
    		       	   UUID randomUUID1 = UUID.randomUUID();
    		       	   UUID randomUUID2 = UUID.randomUUID();
    		       	   UUID randomUUID3 = UUID.randomUUID();
    		       	   UUID randomUUID4 = UUID.randomUUID();
    		       	   UUID randomUUID5 = UUID.randomUUID();
//    		       	   fronttobase=basetest.GetImageStr(fronttobase);
//    		       	   oppositetobase=basetest.GetImageStr(oppositetobase);
//    		       	   applytobase=basetest.GetImageStr(applytobase);
//    		       	   authorizetobase=basetest.GetImageStr(authorizetobase);
//    		           hztobase=basetest.GetImageStr(hztobase);	  	 
    		       	   String  frontname =randomUUID1.toString().replace("-","")+creditutil.timefile()+".jpg";
    		       	   String  oppositename =randomUUID2.toString().replace("-","")+creditutil.timefile()+".jpg";
    		       	   String  applyname =randomUUID3.toString().replace("-","")+creditutil.timefile()+".jpg";
    		       	   String  authorizename =randomUUID4.toString().replace("-","")+creditutil.timefile()+".jpg";
    		       	   String  hzname =randomUUID5.toString().replace("-","")+creditutil.timefile()+".jpg";   		       			   
	    		   	       Base64Test.decodeBase64ToImage(zx.getFronttobase().toString(),path1.toString(),frontname);
	    		   	       Base64Test.decodeBase64ToImage(zx.getOppositetobase(),path1.toString(),oppositename);
	    		   	       Base64Test.decodeBase64ToImage(zx.getApplytobase().toString(),path1.toString(),applyname);
	    		   	       Base64Test.decodeBase64ToImage(zx.getAuthorizetobase().toString(),path1.toString(),authorizename);
	    		   	       Base64Test.decodeBase64ToImage(zx.getHztobase().toString(),path1.toString(),hzname);    		   	    
	    		   	       imgmodel.setAddtime(creditutil.time().toString());
	    		   	       imgmodel.setFrontimg(frontname);
	    		   	       imgmodel.setOppositeimg(oppositename);
	    		   	       imgmodel.setApplyimg(applyname);
	    		   	       imgmodel.setAuthorizeimg(authorizename);
	    		   	       imgmodel.setHzimg(hzname);
	    		   	       imgmodel.setUptime(creditutil.time()); 
    		         } catch (Exception e) {
    		       	//解析编码错误
    		       	result.put("errcode","14");
    		       	result.put("errmsg","解析错误");
    		       	//result.put("result",errorutil.error014());
    		   		return jsonutil.toJSONString(result).replace("[", "").replace("]","");
    		   		
    		   		
    		   	} 	      	
    		                       creditservice.save(credit);
    		                       gskh gskh=new gskh();
    					  		   gskh.setKd(kd-100);
    					  		   gskh.setId(Integer.parseInt(gsmap.get("id").toString()));
    					  		   gskhservice.upgskhkd(gskh);		                       
    		                       imgmodel.setHttppath("http://apitest.kcway.net/image/upload/img/"+creditutil.timefile().toString());
    		                       //imgmodel.setImgpath(realPath);   	   
    		   	                   h.setZt(zx.getSum_bit());      
    		   	                   h.setLy(zx.getLy());
    		   	                   bb.setBb(zx.getLy());
    		     	    		   h.setUid(String.valueOf(credit.getId()));
    		     	        	   p.setUid(String.valueOf(credit.getId()));
    		     	        	   p.setPdfuptime(creditutil.time());
    		     	        	   imgmodel.setUid(credit.getId());
    		     	        	   bb.setKhxm(zx.getName());
    		     	        	   bb.setSfzbh(zx.getIdcard_num());
    		     	        	   bb.setSqsbh(zx.getAuthorize_num());
    		     	        	   bb.setMd(mdxx.get("khgsname").toString());
    		     	        	   bb.setOrderid(String.valueOf(credit.getId()));
    		     	        	   bb.setCxr(mdxx.get("khrname").toString());    		     	        	      		     	        	 
    		     	        	   bb.setOnecxtime(creditutil.time().toString());	    		     	        	     		     	        	   
    		     	    		   imgservice.addimg(imgmodel);   		     	    		   
    		     		    	   historyservice.hsava(h);    		     		    	   
    		     		    	   pdfoverservice.addpdf(p);
    		     		    	   bbservice.addbb(bb);   		    	   
    		           		       //ywservice.saveyw(yw);	    		           		   	    		           		      	    		           		  
    		           		       result.put("errcode", "1");
    		     			       result.put("errmsg", "提交成功");
    		     			       result.put("orderNo",String.valueOf(credit.getId()));
    		     			       return jsonutil.toJSONString(result).replace("[", "").replace("]","");
    		   	           	 	        	   	        	   
    		           	   }else {    							
    	    		    	   result.put("errcode", "3");
    	     			       result.put("errmsg", "提交的字段不完整");
    	     			       //result.put("orderNo",errorutil.error03());
    	     			       return jsonutil.toJSONString(result).replace("[", "").replace("]","");   
    	    		    	   
    					}
    		       }else {						
    		    	   result.put("errcode", "4");
     			       result.put("errmsg", "余额不足");
     			       //result.put("orderNo",errorutil.error04());
     			       return jsonutil.toJSONString(result).replace("[", "").replace("]","");   
    		    	   
				}
    	   
    	   
    		       }else{
    		    	   result.put("errcode", "4");
     			       result.put("errmsg", "余额不足");
     			       //result.put("orderNo",errorutil.error04());
     			       return jsonutil.toJSONString(result).replace("[", "").replace("]","");
    		       }
   
    }else {		
 	       result.put("errcode", "2");
	       result.put("errmsg", "用户验证失败");
	       //result.put("orderNo",errorutil.error02());
	       return jsonutil.toJSONString(result).replace("[", "").replace("]","");    	   
	}

       
	    }
	    
	    /**
	     * 人行征信查询接口（通用版）
	     * @param fronttobase
	     * @param oppositetobase
	     * @param applytobase
	     * @param authorizetobase
	     * @param hztobase
	     * @param ckey
	     * @param name
	     * @param IDcard_num
	     * @param phone_num
	     * @param authorize_num
	     * @param sum_bit
	     * @param ly
	     * @param request
	     * @return
	     */
	    @RequestMapping(value="/tofindzx.do",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
	    @ResponseBody
	    public String tofindzx(String fronttobase,
  		 String oppositetobase,
  		 String applytobase,
  		 String authorizetobase,
  		 String hztobase,
  		 String ckey,
  		 String name,
  		 String idcard_num,
  		 String phone_num,
  		 String authorize_num,
  		 String sum_bit,
  		 String ly,
	     HttpServletRequest request,HttpServletResponse respones){    
	  
		        Map result=new HashMap();
		        Map path=new HashMap();
		        Map file=new HashMap();
		        company ccompany=new company();
		        credit credit=new credit();
		        bb bb=new bb();
		        yw yw=new yw();
		        history h=new history();
		        pdfover p=new pdfover();
	    	    img imgmodel=new img();
	    	    
	       System.out.println("获取验证码name:"+name+"获取验证码ckey:"+ckey);	    
	       Map mdxx=khgsservice.fgsrykh(ckey);	       
	       if(mdxx!=null&&!mdxx.equals("")&&mdxx.size()>0){
	       Map gsmap=gskhservice.fgsbyid(Integer.parseInt(mdxx.get("gsid").toString()));   				    			
	       if(gsmap.get("kd")!=null&&!gsmap.get("kd").equals("")&&Integer.parseInt(gsmap.get("kd").toString())>0){
	    	   int kd=Integer.parseInt(gsmap.get("kd").toString());
	    	   if(kd>100){	    		   
	    		     //String realPath =request.getSession().getServletContext().getRealPath("/image/upload");
	    		     String path1="/opt/javaimg/image/upload/img/"+creditutil.timefile();
	    		 	 File dir = new File(path1);
	    		 	 if(!dir.exists()){
	    		 		 dir.mkdirs();
	    		 	 }					
	    		   if(!fronttobase.equals("")&&
	    		   		  !oppositetobase.equals("")&&
	    		   		  !applytobase.equals("")&&
	    		   		  !authorizetobase.equals("")&&
	    		   		  !hztobase.equals("")&&
	    		       	  !name.equals("")&& 
	    		             !idcard_num.equals("")&& 
	    		       	  !phone_num.equals("")&& 
	    		       	  !authorize_num.equals("")&& 
	    		             !sum_bit.equals("")
	    		          ){    		 	    		   
	    		       	   String add_time=creditutil.time();
	    		   	       credit.setIDcard_num(idcard_num);
	    		   	       credit.setSum_bit(sum_bit);
	    		   	       credit.setName(name);
	    		   	       credit.setPhone_num(phone_num);
	    		       	   credit.setAdd_time(add_time);
	    		       	   credit.setAuthorize_num(authorize_num);
	    		       	   credit.setMdid(mdxx.get("khid").toString());
	    		       	   credit.setUp_time(creditutil.time());
	    		       	   credit.setShzt("4");
//	    		       	   credit.setImgbase_1(fronttobase);
//	    		       	   credit.setImgbase_2(oppositetobase);
//	    		           credit.setImgbase_3(applytobase);
//	    		       	   credit.setImgbase_4(authorizetobase);
//	    		       	   credit.setImgbase_5(hztobase);
	    		       	  
	    		         try {
//	    		       	   String frontname=basetest.GenerateImage(fronttobase, realPath.toString());
//	    		   	       String oppositename=basetest.GenerateImage(oppositetobase, realPath.toString());
//	    		   	       String applyname=basetest.GenerateImage(applytobase, realPath.toString());
//	    		   	       String authorizename=basetest.GenerateImage(authorizetobase, realPath.toString());
//	    		   	       String hzname=basetest.GenerateImage(hztobase, realPath.toString());
	    		       	   UUID randomUUID1 = UUID.randomUUID();
	    		       	   UUID randomUUID2 = UUID.randomUUID();
	    		       	   UUID randomUUID3 = UUID.randomUUID();
	    		       	   UUID randomUUID4 = UUID.randomUUID();
	    		       	   UUID randomUUID5 = UUID.randomUUID();
//	    		       	   fronttobase=basetest.GetImageStr(fronttobase);
//	    		       	   oppositetobase=basetest.GetImageStr(oppositetobase);
//	    		       	   applytobase=basetest.GetImageStr(applytobase);
//	    		       	   authorizetobase=basetest.GetImageStr(authorizetobase);
//	    		           hztobase=basetest.GetImageStr(hztobase);	  	 
	    		       	   String  frontname =randomUUID1.toString().replace("-","")+creditutil.timefile()+".jpg";
	    		       	   String  oppositename =randomUUID2.toString().replace("-","")+creditutil.timefile()+".jpg";
	    		       	   String  applyname =randomUUID3.toString().replace("-","")+creditutil.timefile()+".jpg";
	    		       	   String  authorizename =randomUUID4.toString().replace("-","")+creditutil.timefile()+".jpg";
	    		       	   String  hzname =randomUUID5.toString().replace("-","")+creditutil.timefile()+".jpg";    		       			   
		    		   	       Base64Test.decodeBase64ToImage(fronttobase.toString(),path1.toString(),frontname);
		    		   	       Base64Test.decodeBase64ToImage(oppositetobase.toString(),path1.toString(),oppositename);
		    		   	       Base64Test.decodeBase64ToImage(applytobase.toString(),path1.toString(),applyname);
		    		   	       Base64Test.decodeBase64ToImage(authorizetobase.toString(),path1.toString(),authorizename);
		    		   	       Base64Test.decodeBase64ToImage(hztobase.toString(),path1.toString(),hzname);    		   	    
		    		   	       imgmodel.setAddtime(creditutil.time().toString());
		    		   	       imgmodel.setFrontimg(frontname);
		    		   	       imgmodel.setOppositeimg(oppositename);
		    		   	       imgmodel.setApplyimg(applyname);
		    		   	       imgmodel.setAuthorizeimg(authorizename);
		    		   	       imgmodel.setHzimg(hzname);
		    		   	       imgmodel.setUptime(creditutil.time()); 
	    		         } catch (Exception e) {
	    		       	//解析编码错误
	    		       	result.put("errcode","14");
	    		       	result.put("errmsg","解析错误");
	    		       	//result.put("result",errorutil.error014());
	    		   		return jsonutil.toJSONString(result).replace("[", "").replace("]","");
	    		   		
	    		   		
	    		   	} 	      	
	    		                       creditservice.save(credit);
	    		                       gskh gskh=new gskh();
	    					  		   gskh.setKd(kd-100);
	    					  		   gskh.setId(Integer.parseInt(gsmap.get("id").toString()));
	    					  		   gskhservice.upgskhkd(gskh);		                       
	    		                       imgmodel.setHttppath("http://apitest.kcway.net/image/upload/img/"+creditutil.timefile().toString());
	    		                       //imgmodel.setImgpath(realPath);   	   
	    		   	                   h.setZt(sum_bit);      
	    		   	                   if(!ly.equals("")&&ly!=null){
	    		   	                	   h.setLy(ly);
	    		   	                	   bb.setBb(ly);
	    		   	                   }
	    		     	    		   h.setUid(String.valueOf(credit.getId()));
	    		     	        	   p.setUid(String.valueOf(credit.getId()));
	    		     	        	   p.setPdfuptime(creditutil.time());
	    		     	        	   imgmodel.setUid(credit.getId());
	    		     	        	   bb.setKhxm(name);
	    		     	        	   bb.setSfzbh(idcard_num);
	    		     	        	   bb.setSqsbh(authorize_num);
	    		     	        	   bb.setMd(mdxx.get("khgsname").toString());
	    		     	        	   bb.setOrderid(String.valueOf(credit.getId()));
	    		     	        	   bb.setCxr(mdxx.get("khrname").toString());    		     	        	      		     	        	 
	    		     	        	   bb.setOnecxtime(creditutil.time().toString());	    		     	        	     		     	        	   
	    		     	    		   imgservice.addimg(imgmodel);   		     	    		   
	    		     		    	   historyservice.hsava(h);    		     		    	   
	    		     		    	   pdfoverservice.addpdf(p);
	    		     		    	   bbservice.addbb(bb);   		    	   
	    		           		       //ywservice.saveyw(yw);	    		           		   	    		           		      	    		           		  
	    		           		       result.put("errcode", "1");
	    		     			       result.put("errmsg", "提交成功");
	    		     			       result.put("orderNo",String.valueOf(credit.getId()));
	    		     			       return jsonutil.toJSONString(result).replace("[", "").replace("]","");
	    		   	           	 	        	   	        	   
	    		           	   }else {
	    							
	    	    		    	   result.put("errcode", "3");
	    	     			       result.put("errmsg", "提交的字段不完整");
	    	     			       //result.put("orderNo",errorutil.error03());
	    	     			       return jsonutil.toJSONString(result).replace("[", "").replace("]","");   
	    	    		    	   
	    					}
	    		       }else {						
	    		    	   result.put("errcode", "4");
	     			       result.put("errmsg", "余额不足");
	     			       //result.put("orderNo",errorutil.error04());
	     			       return jsonutil.toJSONString(result).replace("[", "").replace("]","");   
	    		    	   
					}
	    	   
	    	   
	    		       }else{
	    		    	   result.put("errcode", "4");
	     			       result.put("errmsg", "余额不足");
	     			       //result.put("orderNo",errorutil.error04());
	     			       return jsonutil.toJSONString(result).replace("[", "").replace("]","");
	    		       }
	   
	    }else {		
	 	       result.put("errcode", "2");
		       result.put("errmsg", "用户验证失败");
		       //result.put("orderNo",errorutil.error02());
		       return jsonutil.toJSONString(result).replace("[", "").replace("]","");    	   
		}
	
	       }
	   
	    @RequestMapping(value="/to_up_zx.do",produces = "application/json;charset=UTF-8")
	    @ResponseBody
	    public String to_up_zx(@RequestBody zxmodel zx){
	    	String fronttobase=zx.getFronttobase();
    		String oppositetobase=zx.getOppositetobase();
    		String applytobase=zx.getApplytobase();
    		String authorizetobase=zx.getAuthorizetobase();
    		String hztobase=zx.getHztobase();
    		String ckey=zx.getCkey();
    		String name=zx.getName();
    		String IDcard_num=zx.getIdcard_num();
    		String phone_num=zx.getPhone_num();
    		String authorize_num=zx.getAuthorize_num();
    		String sum_bit=zx.getSum_bit();
    		String orderid=zx.getOrderid();
	    	   Map result=new HashMap();
	    	   Map km= khgsservice.fgsrykh(ckey);
	    	   img img=new img();
	    	   credit credit=new credit();
	    	   Map imgmap=new HashMap();
	    	 if(km!=null&&!km.equals("")&&km.size()>0){
	    		 //System.out.println(Integer.parseInt(orderid));
	    		 Map cm=creditservice.findcreditbyid(Integer.parseInt(orderid));	    		    
	             //System.out.println(cm); 
	             //System.out.println(cm.get("sum_bit"));
	    		 if(cm!=null&&!cm.equals("")&&cm.size()>0){
	               if(cm.get("sum_bit")!="5"&&!cm.get("sum_bit").equals("5")){		    		    
	    		   imgmap=imgservice.fimg(orderid);	    		   
	    		   //String realPath =request.getSession().getServletContext().getRealPath("/image/upload");	    		   
	    		    String path1="/opt/javaimg/image/upload/img/"+creditutil.timetofile(imgmap.get("addtime").toString().replace(".0",""));
	    		    System.out.println(path1);
	    		 	 File dir = new File(path1);
	    		 	 if(!dir.exists()){
	    		 		 dir.mkdirs();
	    		 	 }
	    		 	 if(!fronttobase.equals("")){
	    		 		UUID randomUUID1 = UUID.randomUUID();
	    		 		//fronttobase=basetest.GetImageStr(fronttobase);
	    		 		String  frontname =randomUUID1.toString().replace("-","")+creditutil.timefile()+".jpg";
	    		 		Base64Test.decodeBase64ToImage(fronttobase.toString(),path1.toString(),frontname);
	    		 		img.setFrontimg(frontname);
	    		 	 }
	    			 if(!oppositetobase.equals("")){
	    				 UUID randomUUID2 = UUID.randomUUID();
	    				 //oppositetobase=basetest.GetImageStr(oppositetobase);
	    				 String  oppositename =randomUUID2.toString().replace("-","")+creditutil.timefile()+".jpg";
	    				 Base64Test.decodeBase64ToImage(oppositetobase.toString(),path1.toString(),oppositename);
	    				 img.setOppositeimg(oppositename);
		    		 	 }
	    			 
	    			 if(!applytobase.equals("")){
	    				 UUID randomUUID3 = UUID.randomUUID();
	    				 //applytobase=basetest.GetImageStr(applytobase);
	    				 String  applyname =randomUUID3.toString().replace("-","")+creditutil.timefile()+".jpg";
	    			     Base64Test.decodeBase64ToImage(applytobase.toString(),path1.toString(),applyname);
	    			     img.setApplyimg(applyname);
		    		 	 }
	    			 
	    			 if(!authorizetobase.equals("")){
	    				 UUID randomUUID4 = UUID.randomUUID();
	    				  //authorizetobase=basetest.GetImageStr(authorizetobase);
	    				  String  authorizename =randomUUID4.toString().replace("-","")+creditutil.timefile()+".jpg";
	    				  Base64Test.decodeBase64ToImage(authorizetobase.toString(),path1.toString(),authorizename);
	    				  img.setAuthorizeimg(authorizename);
		    		 	 }
	    			 
	    			 if(!hztobase.equals("")){
	    				 UUID randomUUID5 = UUID.randomUUID();
	    				 //hztobase=basetest.GetImageStr(hztobase);	
	    				 String  hzname =randomUUID5.toString().replace("-","")+creditutil.timefile()+".jpg";
	    			     Base64Test.decodeBase64ToImage(hztobase.toString(),path1.toString(),hzname);
	    			     img.setHzimg(hzname);
		    		 	 }       	    		 
	    		 img.setUptime(creditutil.time());
	    		 img.setUid(Integer.parseInt(orderid));
	    		 //img.setHttppath("http://apitest.kcway.net/image/upload/img/"+creditutil.timetofile(imgmap.get("addtime").toString().replace(".0",""));
	    		 imgservice.upimg(img);
	    		 if(!IDcard_num.equals("")&&IDcard_num!=null){
	    			 credit.setIDcard_num(IDcard_num);
	    		 }
	    		 if(!authorize_num.equals("")&&authorize_num!=null){
	    			 credit.setAuthorize_num(authorize_num);		 
	    			    		 }
	    		 if(!name.equals("")&&name!=null){
	    			 credit.setName(name);
	    		 }
	    		 if(!sum_bit.equals("")&&sum_bit!=null){
	    			 credit.setSum_bit(sum_bit);
	    		 }
	    		 if(!phone_num.equals("")&&phone_num!=null){
	    			 credit.setPhone_num(phone_num); 
	    		 } 
	    		 credit.setUp_time(creditutil.time());
	    		 credit.setId(Integer.parseInt(orderid));
	    		 creditservice.upcredit(credit);	    	
	    		 result.put("errcode","1");
	    		 result.put("errmsg","更新完成");
	    		 result.put("time", creditutil.time().toString());
	                }else{
		    		    	JSONObject result1=new JSONObject();
		    		    	result1.put("errcode","4");
		    		    	result1.put("errmsg","查询成功订单不可编辑");
		    		    	result1.put("time",creditutil.time());
		    		    	return result1.toString();
		    		  }
	         }else{
	        	 result.put("errcode","3");
	    		 result.put("errmsg","未找到订单编号");
	    		 result.put("time", creditutil.time().toString());
	             }
	                	
	    		 
	    	 }else{
	    		 result.put("errcode","2");
	    		 result.put("errmsg","用户验证失败");
	    		 result.put("time", creditutil.time().toString());
	    	 }
	    	
			return jsonutil.toJSONString(result).replace("[", "").replace("]","");    	  
	
	    }  
	
	    /**
	     * 征信重新编辑接口(通用)
	     * @param fronttobase
	     * @param oppositetobase
	     * @param applytobase
	     * @param authorizetobase
	     * @param hztobase
	     * @param ckey
	     * @param name
	     * @param IDcard_num
	     * @param phone_num
	     * @param authorize_num
	     * @param sum_bit
	     * @param orderid
	     * @param request
	     * @return
	     */
	    @RequestMapping(value="/toup.do",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
	    @ResponseBody
	    public String toup(@RequestParam("fronttobase") String fronttobase,
	    		@RequestParam("oppositetobase") String oppositetobase,
	    		@RequestParam("applytobase") String applytobase,
	    		@RequestParam("authorizetobase") String authorizetobase,
	    		@RequestParam("hztobase") String hztobase,
	    		@RequestParam("ckey") String ckey,
	    		@RequestParam("name") String name,
	    		@RequestParam("idcard_num") String idcard_num,
	    		@RequestParam("phone_num") String phone_num,
	    		@RequestParam("authorize_num") String authorize_num,
	    		@RequestParam("sum_bit") String sum_bit,
	    		@RequestParam("orderid") String orderid,
	    		HttpServletRequest request){
	    	   Map result=new HashMap();
	    	   Map km= khgsservice.fgsrykh(ckey);
	    	   img img=new img();
	    	   credit credit=new credit();
	    	   Map imgmap=new HashMap();
	    	 if(km!=null&&!km.equals("")&&km.size()>0){
	    		 Map cm=creditservice.findcreditbyid(Integer.parseInt(orderid) );
	                if(cm!=null&&!cm.equals("")&&cm.size()>0){	                		               
	    		   imgmap=imgservice.fimg(orderid);	    		   
	    		   //String realPath =request.getSession().getServletContext().getRealPath("/image/upload");	    		   
	    		   String path1="/opt/javaimg/image/upload/img/"+creditutil.timetofile(imgmap.get("addtime").toString().replace(".0",""));
	    		    System.out.println(path1);
	    		 	 File dir = new File(path1);
	    		 	 if(!dir.exists()){
	    		 		 dir.mkdirs();
	    		 	 }
	    		 	 if(!fronttobase.equals("")){
	    		 		UUID randomUUID1 = UUID.randomUUID();
	    		 		//fronttobase=basetest.GetImageStr(fronttobase);
	    		 		String  frontname =randomUUID1.toString().replace("-","")+creditutil.timefile()+".jpg";
	    		 		Base64Test.decodeBase64ToImage(fronttobase.toString(),path1.toString(),frontname);
	    		 		img.setFrontimg(frontname);
	    		 	 }
	    			 if(!oppositetobase.equals("")){
	    				 UUID randomUUID2 = UUID.randomUUID();
	    				 //oppositetobase=basetest.GetImageStr(oppositetobase);
	    				 String  oppositename =randomUUID2.toString().replace("-","")+creditutil.timefile()+".jpg";
	    				 Base64Test.decodeBase64ToImage(oppositetobase.toString(),path1.toString(),oppositename);
	    				 img.setOppositeimg(oppositename);
		    		 	 }
	    			 
	    			 if(!applytobase.equals("")){
	    				 UUID randomUUID3 = UUID.randomUUID();
	    				 //applytobase=basetest.GetImageStr(applytobase);
	    				 String  applyname =randomUUID3.toString().replace("-","")+creditutil.timefile()+".jpg";
	    			     Base64Test.decodeBase64ToImage(applytobase.toString(),path1.toString(),applyname);
	    			     img.setApplyimg(applyname);
		    		 	 }
	    			 
	    			 if(!authorizetobase.equals("")){
	    				 UUID randomUUID4 = UUID.randomUUID();
	    				  //authorizetobase=basetest.GetImageStr(authorizetobase);
	    				  String  authorizename =randomUUID4.toString().replace("-","")+creditutil.timefile()+".jpg";
	    				  Base64Test.decodeBase64ToImage(authorizetobase.toString(),path1.toString(),authorizename);
	    				  img.setAuthorizeimg(authorizename);
		    		 	 }
	    			 
	    			 if(!hztobase.equals("")){
	    				 UUID randomUUID5 = UUID.randomUUID();
	    				 //hztobase=basetest.GetImageStr(hztobase);	
	    				 String  hzname =randomUUID5.toString().replace("-","")+creditutil.timefile()+".jpg";
	    			     Base64Test.decodeBase64ToImage(hztobase.toString(),path1.toString(),hzname);
	    			     img.setHzimg(hzname);
		    		 	 }       	    		 
	    		 img.setUptime(creditutil.time());
	    		 img.setUid(Integer.parseInt(orderid));
	    		 //img.setHttppath("http://apitest.kcway.net/image/upload/img/"+creditutil.timetofile(imgmap.get("addtime").toString().replace(".0",""));
	    		 imgservice.upimg(img);
	    		 if(!idcard_num.equals("")&&idcard_num!=null){
	    			 credit.setIDcard_num(idcard_num);
	    		 }
	    		 if(!authorize_num.equals("")&&authorize_num!=null){
	    			 credit.setAuthorize_num(authorize_num);		 
	    			    		 }
	    		 if(!name.equals("")&&name!=null){
	    			 credit.setName(name);
	    		 }
	    		 if(!sum_bit.equals("")&&sum_bit!=null){
	    			 credit.setSum_bit(sum_bit);
	    		 }
	    		 if(!phone_num.equals("")&&phone_num!=null){
	    			 credit.setPhone_num(phone_num); 
	    		 } 
	    		 credit.setUp_time(creditutil.time());
	    		 credit.setId(Integer.parseInt(orderid));
	    		 creditservice.upcredit(credit);	    	
	    		 result.put("errcode","1");
	    		 result.put("errmsg","更新完成");
	    		 result.put("time", creditutil.time().toString());
	         }else{
	        	 result.put("errcode","3");
	    		 result.put("errmsg","未找到订单编号");
	    		 result.put("time", creditutil.time().toString());
	             }
	    	 }else{
	    		 result.put("errcode","2");
	    		 result.put("errmsg","用户验证失败");
	    		 result.put("time", creditutil.time().toString());
	    	 }
	    	
			return jsonutil.toJSONString(result).replace("[", "").replace("]","");    	  
		       
		

	       }
	
	    //黑名单查询
	    @RequestMapping(value="/blacktbl.do",produces = "text/html;charset=UTF-8")
	    @ResponseBody
	    public String blacktbl(HttpServletRequest request,String ckey,int sync,String idCardNo,String name,String phoneNo,String callbackUrl){	    	
	    	hmdhttp bh=new hmdhttp();
	    	String result = null;
	    	Map resultmap=new HashMap();
	    	gsrykh khgs=new gsrykh();
	    	if(!ckey.equals("")&&ckey!=null){	    		
	    		Map khgsmap=khgsservice.fgsrykh(ckey);
	    		if(khgsmap!=null&&!khgsmap.equals("")&&khgsmap.size()>0){
	    			Map gsmap=gskhservice.fgsbyid(Integer.parseInt(khgsmap.get("gsid").toString()));
	    			int kd=Integer.parseInt(gsmap.get("kd").toString());	    			
	    			if(kd>3){
	    				try {	    					
				  			result=hmdhttp.hmd(sync,idCardNo,name,phoneNo,callbackUrl);	
				  			 gskh gskh=new gskh();
				  			 gskh.setKd(kd-3);
				  			 gskh.setId(Integer.parseInt(gsmap.get("id").toString()));
				  			 gskhservice.upgskhkd(gskh);
				  			 hmd hmd=new hmd();
				  			 hmd.setAddtime(creditutil.time().toString());
				  			 hmd.setIdcard(idCardNo);
				  			 hmd.setKhid(Integer.parseInt(khgsmap.get("khid").toString()));
				  			 hmd.setLx("黑名单API查询");
				  			 hmd.setName(name);
				  			 hmd.setPhonenum(phoneNo);
				  			 hmd.setUptime(creditutil.time().toString());
				  			 hmdservice.addhmd(hmd);
	    				} catch (NoSuchAlgorithmException e) {				  				
				  				//e.printStackTrace();
				  				resultmap.put("code","general_3");
					    		resultmap.put("message","系统异常，请稍后再试");
					    		resultmap.put("taskStatus","fail");
					    		return jsonutil.toJSONString(resultmap).replace("[","").replace("]","");
				  			} catch (ClientProtocolException e) {				  				
				  				//e.printStackTrace();
				  				resultmap.put("code","general_3");
					    		resultmap.put("message","系统异常，请稍后再试");
					    		resultmap.put("taskStatus","fail");
					    		return jsonutil.toJSONString(resultmap).replace("[","").replace("]","");
				  			} catch (IOException e) {				  				
				  				//e.printStackTrace();
				  				resultmap.put("code","general_3");
					    		resultmap.put("message","系统异常，请稍后再试");
					    		resultmap.put("taskStatus","fail");
					    		return jsonutil.toJSONString(resultmap).replace("[","").replace("]","");
				  			}
	    				   
				  	    	return result;
	    			}else{
	    				resultmap.put("code","general_4");
			    		resultmap.put("message","余额不足，请充值");
			    		resultmap.put("taskStatus","fail");
			    		return jsonutil.toJSONString(resultmap).replace("[","").replace("]","");	
	    			}
		  	    	
	    		}else{
	    			resultmap.put("code","general_7");
		    		resultmap.put("message","账号不存在，请联系商务处理");
		    		resultmap.put("taskStatus","fail");
		    		return jsonutil.toJSONString(resultmap).replace("[","").replace("]","");		    			    			
	    		}
	    		

	    	}else{
	    		resultmap.put("code","general_1");
	    		resultmap.put("message","参数错误（ckey不能为空）");
	    		resultmap.put("taskStatus","fail");
	    		return jsonutil.toJSONString(resultmap).replace("[","").replace("]","");
	    	}
	     
	    		    	
				    		    		    	  	
	    }
	
}
