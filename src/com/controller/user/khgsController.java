package com.controller.user;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.bb;
import com.model.company;
import com.model.credit;
import com.model.gskh;
import com.model.history;
import com.model.img;
import com.model.gsrykh;
import com.model.mdxx;
import com.model.pdfover;
import com.model.yw;
import com.service.bbService;
import com.service.creditService;
import com.service.gskhService;
import com.service.historyService;
import com.service.imgService;
import com.service.gsrykhService;
import com.service.mdxxService;
import com.service.pdfoverService;
import com.service.ywService;
import com.util.Base64Test;
import com.util.Pinyin;
import com.util.creditutil;
import com.util.errorutil;
import com.util.jsonutil;
import com.util.md5util;

@Controller
public class khgsController {
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
	 //json 工具类
	 jsonutil ju=new jsonutil();
	
	 Base64Test basetest=new Base64Test();
	
	 @RequestMapping(value="/savemdxx.do",produces="text/html;charset=UTF-8")
	 @ResponseBody
	 public String savemdxx(
			 String sname,
			 String alevel,
			 String pname,
			 String pIDcard,
			 String pcall,
			 String sign,
			 String time
			 ){
		 String ncode=Pinyin.getPinYinHeadChar(sname);
		 Map gm1=gskhservice.sltgskh(sname, ncode);
		 Map result=new HashMap<>();
		 if(sname!=null&&!sname.equals("")
				 &&alevel!=null&&!alevel.equals("")
				 &&pname!=null&&!pname.equals("")
				 &&pIDcard!=null&&!pIDcard.equals("")
				 &&pcall!=null&&!pcall.equals("")
				 ){		
	    Map gm2=khgsservice.findgsrykh(sname,alevel,pname,pIDcard,pcall);	
		 System.out.println(gm2);
		if(gm2!=null&&gm2.size()>0&&!gm2.equals("")){		
		 
	 		result.put("errcode", "016");
	 		result.put("errmsg","数据已存在");     
	 }else{
		 if(gm1!=null&&gm1.size()>0&&!gm1.equals("")){
			 gsrykh gsrykh=new gsrykh();
			 UUID randomUUID = UUID.randomUUID();
	     	 String ckey=md5util.getMD5(sname+randomUUID.toString(),"UTF-8");
			 gsrykh.setCkey(ckey);
			 gsrykh.setCzrid(Integer.parseInt(gm1.get("id").toString()));
			 gsrykh.setGsid(Integer.parseInt(gm1.get("id").toString()));
			 gsrykh.setKd(0);
			 gsrykh.setKhgsname(sname);
			 gsrykh.setKhlevel(alevel);
			 gsrykh.setKhphonenum(pcall);
			 gsrykh.setKhrname(pname);
			 gsrykh.setKhsfznum(pIDcard);
			 gsrykh.setKhtime(creditutil.time());
			 gsrykh.setUptime(creditutil.time());
			 gsrykh.setPassword(pcall);
			 gsrykh.setUsername(pIDcard);
			 khgsservice.addgsrykh(gsrykh);
		 }else{
			 gskh gskh=new gskh();
			 UUID randomUUID = UUID.randomUUID();
	     	 String ckey=md5util.getMD5(sname+randomUUID.toString(),"UTF-8");
			 gskh.setApi_ckey(ckey);
			 gskh.setCtime(creditutil.time());
			 gskh.setKd(0);			
			 gskh.setNcode(ncode);
			 gskh.setUtime(creditutil.time());
			 gskh.setName(sname);
			 gskhservice.addgskh(gskh);
			 gsrykh gsrykh=new gsrykh();
			 UUID randomUUID1 = UUID.randomUUID();
	     	 String ckey1=md5util.getMD5(sname+randomUUID1.toString(),"UTF-8");
			 gsrykh.setCkey(ckey1);
			 gsrykh.setCzrid(gskh.getId());
			 gsrykh.setGsid(gskh.getId());
			 gsrykh.setKd(0);
			 gsrykh.setKhgsname(sname);
			 gsrykh.setKhlevel(alevel);
			 gsrykh.setKhphonenum(pcall);
			 gsrykh.setKhrname(pname);
			 gsrykh.setKhsfznum(pIDcard);
			 gsrykh.setKhtime(creditutil.time());
			 gsrykh.setUptime(creditutil.time());
			 gsrykh.setPassword(pcall);
			 gsrykh.setUsername(pIDcard);
			 khgsservice.addgsrykh(gsrykh);
		 } 
		 result.put("errcode", "01");
		 result.put("errmsg", "成功");		
 	}
	    	}else{
	    		result.put("errcode", "03");
	    		result.put("errmsg", "提交的字段不完整");    		
	    	}
			return jsonutil.toJSONString(result).replace("[","").replace("]","");	 
	 }
	 
	 @RequestMapping(value="/savekhgs.do",produces="text/html;charset=UTF-8")
	 @ResponseBody
	 public String savekhgs(
			 HttpServletRequest request,
			 String khgsname,
			 String khlevel,
			 String khrname,
			 String khsfznum,
			 String khphonenum,
			 String username,
			 String password,
			 int czrid,
			 int gsid
			 ){
//		 System.out.println(khgsname);
//		 System.out.println(khlevel);
//		 System.out.println(khrname);
//		 System.out.println(khsfznum);
//		 System.out.println(khphonenum);
		 String res = null;
		Map result=new HashMap();
	if(khgsname!=null
			&&!khgsname.equals("")
			&&khlevel!=null
			&&!khlevel.equals("")
            &&khrname!=null
            &&!khrname.equals("")
			&&khsfznum!=null
			&&!khsfznum.equals("")
			&&khphonenum!=null
			&&!khphonenum.equals("")
			){
		
	Map m=khgsservice.findgsrykh(khgsname, khlevel, khrname, khsfznum, khphonenum);
		if(m!=null&&!m.equals("")&&m.size()!=0){					
			 res="客户已开户！";
			 result.put("res", res);			 
		}else{
			
			 gsrykh khgs=new gsrykh();
			 khgs.setKhgsname(khgsname);
			 khgs.setKhlevel(khlevel);
			 khgs.setKhrname(khrname);
			 khgs.setKhsfznum(khsfznum);
			 khgs.setKhtime(creditutil.time());
			 khgs.setUptime(creditutil.time());
			 UUID randomUUID = UUID.randomUUID();
	     	 String ckey=md5util.getMD5(khgsname+randomUUID.toString(),"UTF-8");
			 khgs.setCkey(ckey);
			 khgs.setKhphonenum(khphonenum);
			 khgs.setKd(0);
			 khgs.setUsername(username);
			 khgs.setPassword(password);
			 khgs.setCzrid(czrid);
			 khgs.setGsid(gsid);
			 
			 
				 
				 
				 khgsservice.addgsrykh(khgs); 
				 res="添加成功！";
				 result.put("res", res);
		
		}	 
		 }else {
			 res="字段不能为空！";
			 result.put("res", res);
			 
		}
		 
		 return jsonutil.toJSONString(result);
		 
		 
	 } 
	 
	 @RequestMapping(value="/tokhbyckey.do",produces="text/html;charset=UTF-8")
	 @ResponseBody
	 public String tokhbyckey(
			 HttpServletRequest request,
			 String khgsname,
			 String khlevel,
			 String khrname,
			 String khsfznum,
			 String khphonenum
			 ){
//		 System.out.println(khgsname);
//		 System.out.println(khlevel);
//		 System.out.println(khrname);
//		 System.out.println(khsfznum);
//		 System.out.println(khphonenum);
		 String res = null;
		Map result=new HashMap();
	      if(khgsname!=null
			&&!khgsname.equals("")
            &&khrname!=null
            &&!khrname.equals("")
			&&khsfznum!=null
			&&!khsfznum.equals("")
			&&khphonenum!=null
			&&!khphonenum.equals("")
			){		
	    String ncode=Pinyin.getPinYinHeadChar(khgsname);
	    Map m=khgsservice.findgsrykh(khgsname, khlevel, khrname, khsfznum, khphonenum);		
	    if(m!=null&&!m.equals("")&&m.size()>0){					
	    	 result.put("errcode", "9");
			 result.put("errmsg", "用户已存在");
			 result.put("ckey",m.get("ckey").toString());
		}else{			
			 gskh gskh=new gskh();
			 UUID randomUUID = UUID.randomUUID();
	     	 String ckey=md5util.getMD5(khgsname+randomUUID.toString(),"UTF-8");
			 gskh.setApi_ckey(ckey);
			 gskh.setCtime(creditutil.time());
			 gskh.setKd(0);			
			 gskh.setNcode(ncode);
			 gskh.setUtime(creditutil.time());
			 gskh.setName(khgsname);
			 gskhservice.addgskh(gskh);
			 gsrykh khgs=new gsrykh();
			 khgs.setGsid(gskh.getId());
			 khgs.setKhgsname(khgsname);
			 khgs.setKhlevel(khlevel);
			 khgs.setKhrname(khrname);
			 khgs.setKhsfznum(khsfznum);
			 khgs.setKhtime(creditutil.time());
			 khgs.setUptime(creditutil.time());
			 UUID randomUUID1 = UUID.randomUUID();
	     	 String ckey1=md5util.getMD5(khgsname+randomUUID1.toString(),"UTF-8");
			 khgs.setCkey(ckey1);
			 khgs.setKhphonenum(khphonenum);
			 khgs.setKd(0);
			 khgs.setCzrid(0);
			 khgsservice.addgsrykh(khgs); 				
			 result.put("errcode", "1");
			 result.put("errmsg", "成功");
			 result.put("ckey", ckey);			
		}	 
		 }else {			
			 result.put("errcode", "2");
			 result.put("errmsg", "字段不能为空");			 
		}		 
		 return jsonutil.toJSONString(result).replace("[", "").replace("]","");		 		 
	 } 
	    //添加 查询  sum_bit 为 1 为提交查询 为 0 存草稿
	    @RequestMapping(value="/searchzx.do",produces = "application/json;charset=UTF-8")
	    @ResponseBody
	    public Map searchzx(@RequestBody String jsonstring,@RequestHeader String ckey,
	    		HttpServletRequest request){
	    	jsonstring=jsonstring.replace("[", "").replace("]","");
	        Map jsons= jsonutil.toHashMap(jsonstring);
	    	String fronttobase=jsons.get("fronttobase").toString();	
    		String oppositetobase=jsons.get("oppositetobase").toString();	
    		String applytobase=jsons.get("applytobase").toString();	
    		String authorizetobase=jsons.get("authorizetobase").toString();	
    		String hztobase=jsons.get("hztobase").toString();	    	
    		String name=jsons.get("name").toString();	
    		String IDcard_num=jsons.get("IDcard_num").toString();	
    		String phone_num=jsons.get("phone_num").toString();	
    		String authorize_num=jsons.get("authorize_num").toString();	
    		String sum_bit=jsons.get("sum_bit").toString();
    		String ly;
    		if(!jsons.get("ly").equals("")&&jsons.get("ly")!=null){
    			ly=jsons.get("ly").toString();	 
    		}else{
    			ly="";
    		}   		   	
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
	       Map mdxx=mdxxservice.mdxxmap(ckey);
	       if(mdxx!=null&&!mdxx.equals("")&&mdxx.size()>0){
	       if(Integer.parseInt(mdxx.get("kd").toString())>0&&mdxx.get("kd")!=null&&!mdxx.get("kd").equals("")){
	    	   int kd=Integer.parseInt(mdxx.get("kd").toString());	
	    	   if(kd>100){
	    		   
	    		  // String realPath =request.getSession().getServletContext().getRealPath("/image/upload");
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
	    		             !IDcard_num.equals("")&& 
	    		       	  !phone_num.equals("")&& 
	    		       	  !authorize_num.equals("")&& 
	    		             !sum_bit.equals("")
	    		          ){    		 	    		   
	    		       	   String add_time=creditutil.time();
	    		   	       credit.setIDcard_num(IDcard_num);
	    		   	       credit.setSum_bit(sum_bit);
	    		   	       credit.setName(name);
	    		   	       credit.setPhone_num(phone_num);
	    		       	   credit.setAdd_time(add_time);
	    		       	   credit.setAuthorize_num(authorize_num);
	    		       	   credit.setShzt("4");
	    		         try {
//	    		       	  fronttobase=basetest.GenerateImage(fronttobase, realPath.toString());
//	    		   	      oppositetobase=basetest.GenerateImage(oppositetobase, realPath.toString());
//	    		   	      applytobase=basetest.GenerateImage(applytobase, realPath.toString());
//	    		   	      authorizetobase=basetest.GenerateImage(authorizetobase, realPath.toString());
//	    		   	      hztobase=basetest.GenerateImage(hztobase, realPath.toString());
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
	    		         } catch (Exception e) {
	    		       	//解析编码错误
	    		       	result.put("errcode","014");
	    		       	result.put("errmsg","提交失败");
	    		       	result.put("result",errorutil.error014());
	    		   		return result;
	    		   		
	    		   		
	    		   	} 	      	
	    		                       creditservice.save(credit);
	    		                       mdxx mdkd=new mdxx();
	    		                       kd=kd-100;
	    		                       mdkd.setKd(String.valueOf(kd));
	    		                       mdkd.setCkey(ckey);
	    		                       mdxxservice.upmdxx(mdkd);    		                       
	    		                       imgmodel.setHttppath("http://apitest.kcway.net/image/upload/img/"+creditutil.timefile().toString());
	    		                       //imgmodel.setImgpath(realPath);   	   
	    		   	                   h.setZt(sum_bit);      
	    		   	                   if(ly!=null&&!ly.equals("")){
	    		   	                	   h.setLy(ly);
	    		   	                	   bb.setBb(ly);
	    		   	                   }
	    		     	    		   h.setUid(String.valueOf(credit.getId()));
	    		     	        	   p.setUid(String.valueOf(credit.getId()));
	    		     	        	   imgmodel.setUid(credit.getId());
	    		     	        	   bb.setKhxm(name);
	    		     	        	   bb.setSfzbh(IDcard_num);
	    		     	        	   bb.setSqsbh(authorize_num);
	    		     	        	   bb.setMd(mdxx.get("sname").toString());
	    		     	        	   bb.setOrderid(String.valueOf(credit.getId()));
	    		     	        	   bb.setCxr(mdxx.get("pname").toString());    		     	        	      		     	        	 
	    		     	        	   bb.setOnecxtime(creditutil.time().toString());
	    		     	        	     		     	        	   
	    		     	    		   imgservice.addimg(imgmodel);   		     	    		   
	    		     		    	   historyservice.hsava(h);    		     		    	   
	    		     		    	   pdfoverservice.addpdf(p);
	    		     		    	   bbservice.addbb(bb);   		    	   
	    		           		       //ywservice.saveyw(yw);
	    		           		   
	    		           		      
	    		           		  
	    		           		       result.put("errcode", "01");
	    		     			       result.put("errmsg", "提交成功");
	    		     			       result.put("orderNo",credit.getId());
	    		     			       return result;
	    		   	           	 	        	   	        	   
	    		           	   }else {
	    							
	    	    		    	   result.put("errcode", "03");
	    	     			       result.put("errmsg", "提交失败");
	    	     			       result.put("orderNo",errorutil.error03());
	    	     			       return result;   
	    	    		    	   
	    					}
	    		       }else {
						
	    		    	   result.put("errcode", "04");
	     			       result.put("errmsg", "提交失败");
	     			       result.put("orderNo",errorutil.error04());
	     			       return result;   
	    		    	   
					}
	    	   
	    	   
	    		       }
	   
	    }else {		
	 	       result.put("errcode", "02");
		       result.put("errmsg", "提交失败");
		       result.put("orderNo",errorutil.error02());
		       return result;    	   
		}
		return result;

	       }
	    
	    
	
	    
	    
	    
	    
	    //添加 查询  sum_bit 为 1 为提交查询 为 0 存草稿
	    @RequestMapping(value="/toaddzx.do",produces = "text/html;charset=UTF-8")
	    @ResponseBody
	    public String toaddzx(@RequestParam("fronttobase") String fronttobase,
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
	    		HttpServletRequest request){    	  
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
	       Map mdxx=khgsservice.fgsrykh(ckey);
	       if(mdxx!=null&&!mdxx.equals("")&&mdxx.size()>0){
	       if(Integer.parseInt(mdxx.get("kd").toString())>0&&mdxx.get("kd")!=null&&!mdxx.get("kd").equals("")){
	    	   int kd=Integer.parseInt(mdxx.get("kd").toString());	
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
	    		             !IDcard_num.equals("")&& 
	    		       	  !phone_num.equals("")&& 
	    		       	  !authorize_num.equals("")&& 
	    		             !sum_bit.equals("")
	    		          ){    		 	    		   
	    		       	   String add_time=creditutil.time();
	    		   	       credit.setIDcard_num(IDcard_num);
	    		   	       credit.setSum_bit(sum_bit);
	    		   	       credit.setName(name);
	    		   	       credit.setPhone_num(phone_num);
	    		       	   credit.setAdd_time(add_time);
	    		       	   credit.setAuthorize_num(authorize_num);
	    		       	   credit.setMdid(mdxx.get("khid").toString());
	    		       	   credit.setUp_time(creditutil.time());
	    		       	   credit.setShzt("4");
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
	    		       	result.put("errcode","014");
	    		       	result.put("errmsg","解析错误");    		       
	    		   		return jsonutil.toJSONString(result).replace("[","").replace("]","");
	    		   		
	    		   		
	    		   	} 	      	
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
	    		     	        	   bb.setMd(mdxx.get("khgsname").toString());
	    		     	        	   bb.setOrderid(String.valueOf(credit.getId()));
	    		     	        	   bb.setCxr(mdxx.get("khrname").toString());    		     	        	      		     	        	 
	    		     	        	   bb.setOnecxtime(creditutil.time().toString());
	    		     	        	     		     	        	   
	    		     	    		   imgservice.addimg(imgmodel);   		     	    		   
	    		     		    	   historyservice.hsava(h);    		     		    	   
	    		     		    	   pdfoverservice.addpdf(p);
	    		     		    	   bbservice.addbb(bb);   		    	   
	    		           		       //ywservice.saveyw(yw);
	    		           		   
	    		           		      
	    		           		  
	    		           		       result.put("errcode", "01");
	    		     			       result.put("errmsg", "提交成功");
	    		     			       result.put("orderNo",credit.getId());
	    		     			       return jsonutil.toJSONString(result).replace("[","").replace("]","");
	    		   	           	 	        	   	        	   
	    		           	   }else {
	    							
	    	    		    	   result.put("errcode", "03");
	    	     			       result.put("errmsg", "提交的字段不完整");
	    	     			       return jsonutil.toJSONString(result).replace("[","").replace("]","");   
	    	    		    	   
	    					}
	    		       }else {
						
	    		    	   result.put("errcode", "04");
	     			       result.put("errmsg", "余额不足");     			      
	     			       return jsonutil.toJSONString(result).replace("[","").replace("]","");   
	    		    	   
					}
	    	   
	    	   
	    		       }
	   
	    }else {		
	 	       result.put("errcode", "02");
		       result.put("errmsg", "用户验证失败");
		       return jsonutil.toJSONString(result).replace("[","").replace("]","");    	   
		}
		return jsonutil.toJSONString(result).replace("[","").replace("]","");

	       }
	    
	    
	    
	 
	    
	    
	    
	    
}
