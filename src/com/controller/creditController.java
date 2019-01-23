package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import com.model.img;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.model.company;
import com.model.credit;
import com.model.history;
import com.model.pdfover;
import com.service.bbService;
import com.service.companyService;
import com.service.creditService;
import com.service.customerService;
import com.service.grywlsService;
import com.service.historyService;
import com.service.imgService;
import com.service.mdxxService;
import com.service.pdfoverService;
import com.service.ywService;
import com.util.Base64Test;
import com.util.creditutil;
import com.util.errorutil;
import com.util.jsonutil;
import com.util.pathutil;

@Controller
public class creditController {
	    @Autowired
	    private creditService creditService;
	    @Autowired
	    private historyService hts;
	    @Autowired
	    private pdfoverService pfs;
	    @Autowired
	    private grywlsService grs;
	    @Autowired
	    private imgService imgservice;
	    @Autowired
	    private companyService cps;
	    @Autowired
	    private customerService cs;
	    @Autowired
	    private ywService ywservice;
	    @Autowired
	    private bbService bbservice;
	    @Autowired
	    private mdxxService mdxxservice;
	    //json 工具类
	    jsonutil ju=new jsonutil();
	    
	    Base64Test basetest=new Base64Test();
	    //读取pdf文件 并存到 表kcd_pdfover 中
	    
	    
	   
	    

	    
	    //删除数据 根据id 操作
	    @RequestMapping(value="/del.do",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	    @ResponseBody
	    public String del(HttpServletRequest request){
	    	
	    	
	    	creditService.delcredit(1);
	    	
	    	
			return "删除成功！";
	    	
	    	
	    	
	    	
	    }
	    
	    
	    //测试  查询所有数据
	    @RequestMapping(value="/push.do",produces = "text/html;charset=UTF-8")
	    @ResponseBody
	    public String push(HttpServletRequest request,String orderNo,
	    	String pdfurl,String addtime)
	    {
	      String retCode;
	      String  retMsg;
	      Map result=new HashMap();
           if(pdfurl!=null&&!pdfurl.equals("")){        	   
        	   retCode="1";
        	   retMsg="成功";        	
           }else{
        	   retCode="2";
        	   retMsg="失败";        	         	           	   
           }	
               result.put("retCode",retCode);
    	       result.put("retMsg",retMsg);
	           return jsonutil.toJSONString(result) ;
	    }
	    
	    
	    
	    //更新 编辑
	    @RequestMapping(value="/update.do",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	    @ResponseBody
	    public String update(
	    		//@RequestParam("front") MultipartFile front,
	    		//@RequestParam("opposite") MultipartFile opposite,
	    		//@RequestParam("apply") MultipartFile apply,
	    		//@RequestParam("authorize") MultipartFile authorize,
	    		//@RequestParam("hz")MultipartFile hz,
	    		 @RequestParam("id")int id,
	    		 @RequestParam("name")String name,
	    		//@RequestParam("IDcard_num") String IDcard_num,
	    		//@RequestParam("phone_num") String phone_num,
	    		//@RequestParam("authorize_num") String authorize_num,
	    		//@RequestParam("sum_bit") String sum_bit,
	    		HttpServletRequest request) {	    		    		    	
	    	    credit credit=new credit();
	    	    credit.setId(id);
	    	    credit.setName(name);
	    	    String time=creditutil.time();
		    	credit.setAdd_time(time);
	    	    HashMap cm=new HashMap();	    	   
//	    	    cm.put("id", id);
//	    	    cm.put("name", name);
//	    	    cm.put("time", time);
	    	    creditService.upcredit(credit);
			
	    	    return cm.toString() ;
			

		}
	    //添加 查询  sum_bit 为 1 为提交查询 为 0 存草稿
	    @RequestMapping(value="/add.do",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	    @ResponseBody
	    public String add(
	    		@RequestParam("front") MultipartFile front,
	    		@RequestParam("opposite") MultipartFile opposite,
	    		@RequestParam("apply") MultipartFile apply,
	    		@RequestParam("authorize") MultipartFile authorize,
	    		@RequestParam("hz") MultipartFile hz,
	    		@RequestParam("name") String name,
	    		@RequestParam("IDcard_num") String IDcard_num,
	    		@RequestParam("phone_num") String phone_num,
	    		@RequestParam("authorize_num") String authorize_num,
	    		@RequestParam("sum_bit") String sum_bit,
	    		@RequestParam("company") String company,
	    		@RequestParam("username") String username,
	    		@RequestParam("url")String url,
	    		@RequestParam("ly") String ly,
	    		HttpServletRequest request){	    	
	    	    credit credit=new credit();
	    	    credit credit1=new credit();
	    	    Map ddmap=new HashMap();
	    	    Map result=new HashMap();
	    	    if(!company.equals("")&&!username.equals("")){
	    	    	// credit creditlist= creditService.findcreditbyname(name, IDcard_num, phone_num);
	    	    	 //MultipartHttpServletRequest mtpreq = (MultipartHttpServletRequest) request;
	    	 		 //通过 mtpreq 获取文件域中的文件
	    	 		// MultipartFile front = mtpreq.getFile("front");//正面照
	    	 		// MultipartFile opposite = mtpreq.getFile("opposite");//反面照
	    	 		// MultipartFile apply = mtpreq.getFile("apply");//申请书
	    	 		// MultipartFile authorize = mtpreq.getFile("authorize");//授权书
	    	 		// MultipartFile hz = mtpreq.getFile("hz");//合影
	                  String f1 = null,o1 = null,a1 = null,a2 = null,h1 = null;
	                  String type=null;// 文件类型
	    	    	 if(!front.equals("")&&front!=null
	    	    			 &&!opposite.equals("")&&opposite!=null
	    	    			 &&!apply.equals("")&&apply!=null
	    	    			 &&!authorize.equals("")&&authorize!=null
	    	    			 &&!hz.equals("")&&hz!=null
	    	    			 &&!name.equals("")
	    	    			 &&!IDcard_num.equals("")
	    	    			 &&!phone_num.equals("")
	    	    			 &&!authorize_num.equals("")
	    	    			 &&!url.equals("")
	    	    			 ){
	    	    		 //System.out.println(front+"file----------------------");
	    	 	    	 MultipartFile[] files={front,opposite,apply,authorize,hz};
	    	 	    	 String realPath =request.getSession().getServletContext().getRealPath("/image/upload");
	    	 				 //"C:/Users/tutu/workspace/Xinwen/WebContent/images/";
	    	 	    	 //将路径转化为文件夹 并 判断文件夹是否存在
	    				 File dir = new File(realPath);
	    				 if(!dir.exists()){
	    				 dir.mkdirs();
	    				 }
	    	 	   		 for(int is=0;is<files.length;is++){	 	   			 	 	   			 	 	   			
	    	 	    	//通过MultipartFile 对象获取文件的原文件名 
	    	 	       	 String fileName = files[is].getOriginalFilename();
	    	 	       	 
	    	 	       	 UUID randomUUID = UUID.randomUUID();
	    	 	   		 //获取文件的后缀名
	    	 	   		    int i = fileName.lastIndexOf(".");
	    	 	   		    if(i==-1){
	    	 	   		     result.put("errorcode","03");
		    	    	     result.put("errormsg","提交失败");
		    	    	     result.put("result",errorutil.error03());		    	    	     
		    	    	     return jsonutil.toJSONString(result);
	    	 	   		    }

	    	 	   		    type=fileName.substring(i);	    	 	   			 	   			 
	    	 	   			String uuidName = randomUUID.toString().replaceAll("-","")+type;
	    	 	   		     pathutil pu=new pathutil();
	    				     String pathtype=pathutil.getPath();	    				
	    		 	   		//获取一个文件的保存路径
	    		 	   		 String path = realPath+pathtype+uuidName;
	    		 	   		 // 为文件这服务器中开辟一给新的空间,*没有数据
	    		 	   		 // File newFile = new File(path); 		
	    		 	   		 //System.err.println("-----服务器的路径地址为：:"+realPath);
	    		 	   		 //System.err.println("-----图片名称为：:"+fileName);
	    		 	   		// System.err.println("-----图片新名称为：:"+uuidName);
	    		 	   		if(is==0){
	    		 	   			f1=uuidName;
	    		 	   		}else if (is==1) {
	    		 	   			o1=uuidName;
	    		 			} else if (is==2) {
	    		 				a1=uuidName;
	    		 			} else if (is==3) {
	    		 				a2=uuidName;
	    		 			} else if (is==4) {
	    		 				h1=uuidName;
	    		 			} 	   		   			    		    		    
	    		 	   		// System.err.println("-----图片新路径为：:"+path);
	    		 	   		 try {
	    		 	   		File spath=new File(path);
	    		 	   			spath.setWritable(true,false);
	    			    		
	    		 	   			files[is].transferTo(spath);
	    		 	   	    		 } catch (IllegalStateException e) {
	    		 	   	    		
	    		 	   	    			 
	    		 	   	    		 e.printStackTrace();
	    		 	   	    		 } catch (IOException e) {
	    		 	   	    	 
	    		 	   	    		 result.put("errorcode","05");
	    		    	    	     result.put("errormsg","提交失败");
	    		    	    	     result.put("result",errorutil.error05());		    	    	     
	    		    	    	     return jsonutil.toJSONString(result);
	    		 	   	    		 }
	    		 	    		
	    		 	    	}	 	   		
	    	 	   	    credit.setName(name);
	    		    	credit.setIDcard_num(IDcard_num);
	    		    	credit.setPhone_num(phone_num);
	    		    	credit.setAuthorize_num(authorize_num);	
	    		    	credit.setFront(f1);
	    		    	credit.setAuthorize(a2);
	    		    	credit.setApply(a1);
	    		    	credit.setHz(h1);
	    		    	credit.setOpposite(o1);
	    		    	credit.setUrl(url);
	    		    	credit.setShzt("4");
	    		    	String time=creditutil.time();
	    		    	credit.setAdd_time(time);
	    		    	//历史记录
	    		    	history hty=new history();
	    		    	if(!ly.equals("")){
	    		    	  hty.setLy(ly);
	    		    	}	    		    			    	
	    		    	hty.setUid(String.valueOf(credit.getId()));
	    		    	hty.setZt(sum_bit);
//	    		    	grywls gr=new grywls();
//	    		    	gr.setCxyw("个人征信系统");
//	    		    	gr.setCzr("操作人");
//	    		    	gr.setSxkd("100");		    			    			    	
//	    		    	grs.addgrywls(gr);//添加个人流水
                        credit.setSum_bit(sum_bit);		    		    		
	    		    	company c=new company();
	    		    	c.setCompany(company);
	    		        Map cpsm=cps.findcompany(company);
	    		        String beans= (String) cpsm.get("beans");
	    		        int kd=Integer.parseInt(beans)-100;
	    		         if(kd>0){
	    		        	 try {
	   	    		             c.setBeans(String.valueOf(kd));	    		       
	   	    		    	     creditService.save(credit);//添加查询信息		    	    		             
	   	    	 	   			 hts.hsava(hty);//添加查询记录
	   	    	 	   		     pdfover pf=new pdfover();
	   	    	 	   		     pf.setUid(String.valueOf(credit.getId()));
	   	    	 	   			 pfs.addpdf(pf);
	   	    	 	   			 if(credit.getSum_bit().equals("1")){
	   	    	 	   				cps.upcompany(c);	 	   				 
	   	    	 	   			 }	    	 	   			 	    	 	   		 
	   	    	 	   		     ddmap.put("dd",credit.getId());
	   		    	    	     ddmap.put("ddbs", "提交查询");
	   		    	    	     if(!ly.equals("")&&ly!=null){
	   		    	    	    	 ddmap.put("ly",ly); 
	   		    	    	     }
	   		    	    	    
	   		    	    	     result.put("errcode","01");
	   		    	    	     result.put("errmsg","提交成功");
	   		    	    	     credit1.setId(credit.getId());
	   		    	    	     credit1.setSum_bit("4");
	   		    	    	     creditService.upsubmit(credit1);
	   		    	    	     result.put("result", ddmap);		    	    	     
	   		    	    	     return jsonutil.toJSONString(result);
	    		        	
	    		        	 } catch (Exception e) {
	    		        		 result.put("errcode","05");
	   		    	    	     result.put("errmsg","提交失败");
	   		    	    	     result.put("result",errorutil.error05());		    	    	     
	   		    	    	     return jsonutil.toJSONString(result);
								}
	    		         }else{
	    		        	 
	    		        	 result.put("errcode","04");
		    	    	     result.put("errmsg","提交失败");
		    	    	     result.put("result",errorutil.error04());		    	    	     
		    	    	     return jsonutil.toJSONString(result);	    	 
	    		        	 
	    		         }
	    		     
	    	    	 }else{	    	    		 	    	    		     
		    	    	     result.put("errcode","03");
		    	    	     result.put("errmsg","提交失败");
		    	    	     result.put("result",errorutil.error03());		    	    	     
		    	    	     return jsonutil.toJSONString(result);	    	    		 
	    	    	 }

	    	    }else {
   	    	     result.put("errcode","02");
   	    	     result.put("errmsg","提交失败");
   	    	     result.put("result",errorutil.error02());   	    	     
   	    	     return jsonutil.toJSONString(result);
				}
				
	    	    }
	    
	    
	    
	    
	   
	    
	    //添加 查询  sum_bit 为 1 为提交查询 为 0 存草稿
	    @RequestMapping(value="/tutobase.do",produces = "text/html;charset=UTF-8")
	    //@ResponseBody
	    public String tutobase(@RequestParam("tu1") String tu1,
	    		@RequestParam("tu2") String tu2,
	    		@RequestParam("tu3") String tu3,
	    		@RequestParam("tu4") String tu4,
	    		@RequestParam("tu5") String tu5,
	    		HttpServletRequest request){
	    	Base64Test base=new Base64Test();
	    	System.out.println(tu1);
	       String t1=Base64Test.GetImageStr(tu1);
	       String t2=Base64Test.GetImageStr(tu2);
	       String t3=Base64Test.GetImageStr(tu3);
	       String t4=Base64Test.GetImageStr(tu4);
	       String t5=Base64Test.GetImageStr(tu5);	  	 
	      // String realPath =request.getSession().getServletContext().getRealPath("/image/upload");
	      // realPath=realPath.replace("\\","/").toString();
	       //System.out.println(realPath);
	       String path="/opt/javaimg/image/upload/img/"+creditutil.timefile();
	       File file=new File(path);
	       if(!file.exists()){
	    	   file.mkdirs();
	       }
	       String imgName = null;
	     
	    	   UUID randomUUID = UUID.randomUUID();
	  	       imgName=randomUUID.toString().replace("-","")+creditutil.timefile()+".jpg";
	  	     Base64Test.decodeBase64ToImage(t1,path.toString(),imgName);
	      
	  
	      
	      
	       
	    	
	    	
	    	
	    	
	    	return "image/upload/img/"+creditutil.timefile()+"/"+imgName;
	    	
	    	
	    	
	    	
	    	
	    }    
	    
	    
	    
	    //添加 查询  sum_bit 为 1 为提交查询 为 0 存草稿
	    @RequestMapping(value="/tobase64.do",produces = "text/html;charset=UTF-8")
	    @ResponseBody
	    public String tobase64(@RequestParam("fronttobase") String fronttobase,
	    		@RequestParam("oppositetobase") String oppositetobase,
	    		@RequestParam("applytobase") String applytobase,
	    		@RequestParam("authorizetobase") String authorizetobase,
	    		@RequestParam("hztobase") String hztobase,
	    		HttpServletRequest request){
	    	Base64Test base=new Base64Test();
	    	  img imgmodel=new img();
	    	  Map result=new HashMap();
	    	  String realPath =request.getSession().getServletContext().getRealPath("/image/upload");		      
	    	  if(realPath!=null&&fronttobase!=null&&
		    		   oppositetobase!=null&&
		    		   applytobase!=null&&
		    		   authorizetobase!=null&& 
		    		   hztobase!=null){
	    	   String frontname=Base64Test.GenerateImage(fronttobase, realPath);
		       String oppositename=Base64Test.GenerateImage(oppositetobase, realPath);
		       String applyname=Base64Test.GenerateImage(applytobase, realPath);
		       String authorizename=Base64Test.GenerateImage(authorizetobase, realPath);
		       String hzname=Base64Test.GenerateImage(hztobase, realPath);	      
		       
		       imgmodel.setAddtime(creditutil.time().toString());
		       imgmodel.setFrontimg(frontname);
		       imgmodel.setOppositeimg(oppositename);
		       imgmodel.setApplyimg(applyname);
		       imgmodel.setAuthorizeimg(authorizename);
		       imgmodel.setHzimg(hzname);
		       imgmodel.setHttppath("http://localhost:8080/kcd/image/upload");
		       imgmodel.setImgpath(realPath);
		       imgservice.addimg(imgmodel);
		     
		       result.put("errcode", "01");
		       result.put("errmsg", "提交成功");
		       result.put("result",imgmodel);
	    	  }
			   return jsonutil.toJSONString(result);	      			    	   				
	    	    }
	    }
	  
