package com.controller.user;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.http.jynwdhttp;
import com.model.bb;
import com.model.company;
import com.model.credit;
import com.model.gskh;
import com.model.history;
import com.model.img;
import com.model.pdfover;
import com.model.yw;
import com.service.bbService;
import com.service.companyService;
import com.service.creditService;
import com.service.customerService;
import com.service.grywlsService;
import com.service.gskhService;
import com.service.gsrykhService;
import com.service.historyService;
import com.service.imgService;
import com.service.mdxxService;
import com.service.pdfoverService;
import com.service.ywService;
import com.util.Base64Test;
import com.util.creditutil;
import com.util.jsonutil;

import net.sf.json.JSONObject;

@Controller
public class nwdController {
	
    @Autowired
    private creditService creditservice;
    @Autowired
    private historyService historyservice;
    @Autowired
    private pdfoverService pdfoverservice;
    @Autowired
    private grywlsService grywlsservice;
    @Autowired
    private imgService imgservice;
    @Autowired
    private companyService companyservice;
    @Autowired
    private customerService cs;
    @Autowired
    private ywService ywservice;
    @Autowired
    private bbService bbservice;
    @Autowired
    private mdxxService mdxxservice;
    @Autowired
    private gsrykhService gsrykhservice;
    @Autowired
    private gskhService gskhservice;
    //json 工具类
    jsonutil ju=new jsonutil();
    
    Base64Test basetest=new Base64Test();
    //读取pdf文件 并存到 表kcd_pdfover 中
	
    /**
     * 征信报告结果实时推送接口
     * 快加APP查询征信报告，查询结果实时通知嘉银征信系统
     * 若报告查询失败，推送查询失败原因状态码及状态描述
     *（查询失败可能出现的原因，需要快加提供详细的状态码列表，如：报告4个工作日内已经查询过等失败原因相对应的状态码及描述）；
     *若报告查询成功，推送查询失败原因状态码、状态描述及将该报告下载地址推送给嘉银征信。
     *快加主动调用嘉银征信API，进行征信报告下载地址（PDF地址）推送，如果推送不成功，返回错误代码，
     *快加服务会不断重新推送，推送间隔后续待定。
     *嘉银征信后续会用PDF地址对征信报告进行下载。  	       	      
     * @param orderNo
     * @param errcode
     * @param errmsg
     * @param pdfurl
     * @param addtime
     * @param sign
     * @param time
     * @return
     */
    @RequestMapping(value="/ssts.do",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String ssts(HttpServletRequest request,
    		int id,
    		String api
    		){	   	
    	System.out.println(api+"-----------");
    	if(api.equals("1")){
    		System.out.println("11111111111111");
    	Map cm=creditservice.findcreditbyid(id);
    	Map pm=pdfoverservice.findbyid(String.valueOf(id));
    	Map result=new HashMap<>();    	
    	result.put("orderNo",id);
    	result.put("errcode",cm.get("sum_bit"));
    	if(cm.get("sum_bit").equals("1")){
    		result.put("errmsg","草稿箱");	
    	}
    	if(cm.get("sum_bit").equals("2")){
    		result.put("errmsg","申请模板");	
    	}  
    	if(cm.get("sum_bit").equals("3")){
    		result.put("errmsg","等待上传");	
    	}  
    	if(cm.get("sum_bit").equals("4")){
    		result.put("errmsg","正在查询");	
    	}  
    	if(cm.get("sum_bit").equals("5")){
    		result.put("errmsg","查询完成");	
    	}  
    	if(cm.get("sum_bit").equals("6")){
    		result.put("errmsg","回退");	
    	}  
    	if(cm.get("sum_bit").equals("7")){
    		result.put("errmsg","已撤销");	
    	}
    	if(pm.get("pdfurl")!=null){
    		result.put("pdfurl",pm.get("pdfurl"));
    		result.put("addtime", pm.get("pdfuptime"));
    	}else{
    		result.put("pdfurl","");
    		result.put("addtime","");
    	}        	
    	result.put("sign","0");
    	result.put("time","0");      	
    	JSONObject jsonobject=JSONObject.fromObject(result);
    	String jsonstring=jynwdhttp.httpPost("http://test.creditplatform.jiayincredit.com/personal/kcway/receive-report",jsonobject, false);    	
    	System.out.println(jsonstring);
    	}
    	return "sss";    	  	
    }
    /**
     * 
     * @param opAccount 提交材料的操作人员工号
     * @param opName 提交材料的操作人员姓名
     * @param cuName 客户姓名
     * @param idCard 客户身份证号
     * @param phoneNo 客户手机号
     * @param orderNo 快加唯一订单编号
     * @param authNo 授权书编号
     * @param errcode 材料是否匹配（“1”是，“2”否）
     * @param errmsg 原因
     * @param orderTimeyyyy-MM-dd HH:mm:ss 
     * @param sign 验签内容
     * @param time 时间戳
     * @return
     */
    @RequestMapping(value="/yhxxts.do",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public Map yhxxts(String opAccount,
    		String opName,
    		String cuName,
    		String idCard,
    		String phoneNo,//
    		String orderNo,//
    		String authNo,//
    		String errcode,//
    		String errmsg,//
    		String orderTime,//
    		String sign,//验签内容
    		String time//时间戳
    		){	  
    	Map result=new HashMap<>();    	
    	result.put("opAccount", opAccount);
    	result.put("opName", opName);
    	result.put("cuName", cuName);
    	result.put("idCard", idCard);
    	result.put("phoneNo", phoneNo);
    	result.put("orderNo", orderNo);
    	result.put("authNo", authNo);
    	result.put("errcode", errcode);
    	result.put("errmsg", errmsg);   
    	result.put("orderTime", orderTime);
    	result.put("sign", sign);
    	result.put("time", time);
    	return result;    	  	
    }
    
    
    
    
    
    
    
	 //查询征信报告
    @RequestMapping(value="/findorder.do",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String findorder(HttpServletRequest request,
    		String orderNo,
    		String ckey
    		) {
    	 //String realPath =request.getSession().getServletContext().getRealPath("/image/upload");
    	 //System.out.println("----------"+realPath);
        Map result=new HashMap();
        Map result1=new HashMap();    	
    		 Map cm=gsrykhservice.fgsrykh(ckey);  		 
    		 if(cm!=null&&cm.size()>0&&!cm.equals("")){
    			 result=pdfoverservice.findbyid(orderNo); 
    			 System.out.println(result);
    			 if(result!=null){
    				 result1.put("orderNo", orderNo);
    				 result1.put("errmsg", "成功");
    				 result1.put("errcode", "01");    				 
    			 }else{
    	    		 result1.put("errmsg", "无订单信息");
    				 result1.put("errcode", "013");
    				 //result1.put("result",errorutil.error013());
    	    	}
    			 
    		 }else{
	    		 result1.put("errmsg", "用户验证失败");
				 result1.put("errcode", "02");
				 //result1.put("result",errorutil.error02());
	    	}       	    	
				return jsonutil.toJSONString(result1).replace("[","").replace("]","");
		
    	

	}
    
   
    //添加 查询  sum_bit 为 1 为提交查询 为 0 存草稿
    @RequestMapping(value="/toadd.do",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String toadd(@RequestParam("fronttobase") String fronttobase,
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
       Map mdxx=gsrykhservice.fgsrykh(ckey);
       if(mdxx!=null&&!mdxx.equals("")&&mdxx.size()>0){
    	  int id=Integer.parseInt(mdxx.get("gsid").toString()); 
    	  Map gskd=gskhservice.fgsbyid(id);
       if(Integer.parseInt(gskd.get("kd").toString())>0&&gskd.get("kd")!=null&&!gskd.get("kd").equals("")){
    	   int kd=Integer.parseInt(gskd.get("kd").toString());	
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
    		       	   credit.setMdid(mdxx.get("ckey").toString());
    		       	   credit.setUp_time(creditutil.time());
    		       	   credit.setShzt("4");
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
    		                       gskh gskh=new gskh();
    		                       kd=kd-100;
    		                       gskh.setKd(kd);
    		                       gskh.setId(id);
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
   
  
    //审核信息失败结果异步推送接口
    @RequestMapping(value="/errcome.do",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String errcome(HttpServletRequest request,
    		String orderNo,
    		String errcode,
    		String errmsg,
    		String ckey,
    		String sign,
    		String time
    		){
    	  Map result=new HashMap();
    	  if(!orderNo.equals("")&&orderNo!=null&&!ckey.equals("")&&ckey!=null
    			  &&!errcode.equals("")&&errcode!=null
    			  &&!errmsg.equals("")&&errmsg!=null
    			  ){    
    	  Map c=gsrykhservice.fgsrykh(ckey);  
    	  if(c!=null&&!c.equals("")&&c.size()>0){    	   		  
            result.put("errcode", "01");
            result.put("errmsg", "成功");
    	  }else{
    		result.put("errcode","02");
            result.put("errmsg","用户验证失败");    		  
    	  }
    	  }else{
    		result.put("errcode","03");
            result.put("errmsg","提交的字段不完整");    		  
    	  }          	
		return jsonutil.toJSONString(result).replace("[","").replace("]","");    	    	    	    	
    }
    //审核信息成功结果异步推送接口 (快加-嘉银征信)
    @RequestMapping(value="/findingofaudit.do",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String findingofaudit(HttpServletRequest request,
    		String name,
    		String idCard,
    		String phoneNo,
    		String orderNo,
    		String errcode,
    		String errmsg
    		){
    	 Map result=new HashMap();
    	 System.out.println(name+"--"+idCard+"--"+phoneNo+"--"+orderNo);
    	 if(!name.equals("")&&name!=null
    			 &&!idCard.equals("")&&idCard!=null
    			 &&!phoneNo.equals("")&&phoneNo!=null
    			 &&!orderNo.equals("")&&orderNo!=null    			 
    			 ){
    		 result.put("errcode", "1");
             result.put("errmsg", "成功");
             result.put("orderNo",orderNo);
    	 }else{
    		 result.put("errcode","2");
             result.put("errmsg","失败(返回字段为空)");	 
             result.put("orderNo",orderNo);
    	 }
    	   		    	
		return jsonutil.toJSONString(result).replace("[","").replace("]","");    	    	    	    	
    }
	
}
