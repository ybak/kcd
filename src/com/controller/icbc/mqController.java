package com.controller.icbc;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.lowagie.text.pdf.PdfPublicKeyRecipient;
import com.model.icbc.icbc;
import com.model.icbc.icbc_result;
import com.model1.gems;
import com.model1.icbc.icbc_dk;
import com.model1.icbc.icbc_mq;
import com.model1.icbc.icbc_mq_result;
import com.service1.gemsService;
import com.service1.kjs_icbc.icbc_mqService;
import com.service1.kjs_icbc.icbc_mq_resultService;
import com.service1.kjs_icbc.newicbcService;
import com.util.creditutil;

@Controller
public class mqController {

	 @Autowired
	 private icbc_mqService icbc_mqService;
	 
	 @Autowired
	 private gemsService gemsService;
	 
	 @Autowired
	 newicbcService newicbcService;
	
	 @Autowired
	 private icbc_mq_resultService icbc_mq_resultService;
	 
		@RequestMapping(value="icbcMQ_result.do",produces="text/html;charset=UTF-8")
		@ResponseBody
		public String icbcMQ_result(			
				String appkey,
				String orderid){
			gems gems;
	        if(appkey!=null&&!appkey.equals("")){
	        	gems=gemsService.find_api(appkey);
				if(gems!=null&&!gems.equals("")){
					if(gems.getApi_tag()!=1){
						JSONObject result=new JSONObject();
						result.put("result","");
						result.put("msg","未开通API权限");
						result.put("code","211");
						return result.toString();			
					}
				}else{
					JSONObject result=new JSONObject();
					result.put("result","");
					result.put("msg","appkey错误");
					result.put("code","211");
					return result.toString();	
				}
			}else{
				JSONObject result=new JSONObject();
				result.put("result","");
				result.put("msg","appkey不能为空");
				result.put("code","210");
				return result.toString();	
			}
	        icbc icbc=new icbc();
	        icbc_mq icbc_mq=new icbc_mq();       
			if(orderid!=null&&!orderid.equals("")){
				icbc=newicbcService.findicbcbyorderid(orderid);
	            if(icbc==null||icbc.equals("")){
	            	JSONObject result=new JSONObject();
	    			result.put("result","");
	    			result.put("msg","订单编号错误");
	    			result.put("code","212");
	    			return result.toString();
	            }	
	        }else{
	        	JSONObject result=new JSONObject();
				result.put("result","");
				result.put("msg","orderid不能为空");
				result.put("code","210");
				return result.toString();
	        }			
			icbc_mq=icbc_mqService.findmqbyicbc(icbc.getId());
		    if(icbc_mq!=null&&!icbc_mq.equals("")){
		    	icbc_mq_result imr=icbc_mq_resultService.lasticbc_mq_result(icbc_mq.getId());
		    	JSONObject result=new JSONObject();
		    	JSONObject result1=new JSONObject();
		    	result1.put("orderid",orderid);
		    	result1.put("mq_orderid",icbc_mq.getGems_code());
		    	if(imr.getRemark()!=null&&!imr.getRemark().equals("")){
		    	result1.put("remark",imr.getRemark());	
		    	}
		    	result1.put("status",icbc_mq.getBc_status());
		    	result.put("result",result1);
				result.put("msg","成功");
				result.put("code","210");
				return result.toString();					
		    }else{
		    	JSONObject result=new JSONObject();
    			result.put("result",orderid);
    			result.put("msg","无面签信息");
    			result.put("code","213");
    			return result.toString();		
		    }				
		}
	 
	 
	@RequestMapping(value="icbcMQ.do",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String icbcMQ(			
			String appkey,
			String orderid,
			String oredit,
		@RequestParam("video1")MultipartFile video1,//
		@RequestParam("video2")MultipartFile video2,//
		@RequestParam("video3")MultipartFile video3,//
		@RequestParam("video4")MultipartFile video4//			
					) throws IOException{
		gems gems;
        if(appkey!=null&&!appkey.equals("")){
        	gems=gemsService.find_api(appkey);
			if(gems!=null&&!gems.equals("")){
				if(gems.getApi_tag()!=1){
					JSONObject result=new JSONObject();
					result.put("result","");
					result.put("msg","未开通API权限");
					result.put("code","211");
					return result.toString();			
				}
			}else{
				JSONObject result=new JSONObject();
				result.put("result","");
				result.put("msg","appkey错误");
				result.put("code","211");
				return result.toString();	
			}
		}else{
			JSONObject result=new JSONObject();
			result.put("result","");
			result.put("msg","appkey不能为空");
			result.put("code","210");
			return result.toString();	
		}
        icbc icbc=new icbc();
        icbc_mq icbc_mq=new icbc_mq();       
		if(orderid!=null&&!orderid.equals("")){
			icbc=newicbcService.findicbcbyorderid(orderid);
            if(icbc==null||icbc.equals("")){
            	JSONObject result=new JSONObject();
    			result.put("result","");
    			result.put("msg","订单编号错误");
    			result.put("code","212");
    			return result.toString();
            }	
        }else{
        	JSONObject result=new JSONObject();
			result.put("result","");
			result.put("msg","orderid不能为空");
			result.put("code","210");
			return result.toString();
        }	
		Date date = new Date(); 
        String filePath = "/KCDIMG/assess/upload/"+new SimpleDateFormat("yyyy/MM/dd/").format(date);
        String imgpath="upload/"+new SimpleDateFormat("yyyy/MM/dd/").format(date);
        File f = new File(imgpath);
        if(!f.exists()){  
            f.mkdirs();   
        }
        icbc_mq  icbc_mq1=icbc_mqService.findmqbyicbc(icbc.getId());
        if(oredit!=null&&!oredit.equals("")&&
        		oredit.equals("1")){
	    	if(icbc_mq1==null||icbc_mq1.equals("")){
	    		JSONObject result=new JSONObject();
    			result.put("result",orderid);
    			result.put("msg","无可编辑面签信息");
    			result.put("code","213");
    			return result.toString();
	    	}
	    }else{
	    	if(icbc_mq1!=null&&!icbc_mq1.equals("")){
	    		JSONObject result=new JSONObject();
	    		JSONObject result1=new JSONObject();
				result1.put("orderid",orderid);
				result1.put("mq_orderid",icbc_mq1.getGems_code());				
    			result.put("result",result1);
    			result.put("msg","已有面签信息");
    			result.put("code","214");
    			return result.toString();
	    	}
	    }
        //面签视频1
        if (!video1.isEmpty()&&video1.getSize()>0) {  
    	    String filename = video1.getOriginalFilename();
    	    String prefix=filename.substring(filename.lastIndexOf(".")+1);
    	    UUID uuid = UUID.randomUUID();
    	    String uuidname=uuid.toString().replaceAll("-","")+"."+prefix;        	           
    		String path = filePath+uuidname;
            byte[] file36Byte = video1.getBytes();
            FileUtils.writeByteArrayToFile(new File(path),file36Byte);
            icbc_mq.setImgstep8_1v(imgpath+uuidname);
        }else {
        	icbc_mq.setImgstep8_1v("");
		}
        //面签视频2
        if (!video2.isEmpty()&&video2.getSize()>0) {  
    	    String filename = video2.getOriginalFilename();
    	    String prefix=filename.substring(filename.lastIndexOf(".")+1);
    	    UUID uuid = UUID.randomUUID();
    	    String uuidname=uuid.toString().replaceAll("-","")+"."+prefix;        	           
    		String path = filePath+uuidname;
            byte[] file36Byte = video2.getBytes();
            FileUtils.writeByteArrayToFile(new File(path),file36Byte);
            icbc_mq.setImgstep8_2v(imgpath+uuidname);
        }else {
        	icbc_mq.setImgstep8_2v("");
		}
        //面签视频3
        if (!video3.isEmpty()&&video3.getSize()>0) {  
    	    String filename = video3.getOriginalFilename();
    	    String prefix=filename.substring(filename.lastIndexOf(".")+1);
    	    UUID uuid = UUID.randomUUID();
    	    String uuidname=uuid.toString().replaceAll("-","")+"."+prefix;        	           
    		String path = filePath+uuidname;
            byte[] file36Byte = video3.getBytes();
            FileUtils.writeByteArrayToFile(new File(path),file36Byte);
            icbc_mq.setImgstep8_3v(imgpath+uuidname);
        }else {
        	icbc_mq.setImgstep8_3v("");
		}
        //面签视频4
        if (!video4.isEmpty()&&video4.getSize()>0) {  
    	    String filename = video4.getOriginalFilename();
    	    String prefix=filename.substring(filename.lastIndexOf(".")+1);
    	    UUID uuid = UUID.randomUUID();
    	    String uuidname=uuid.toString().replaceAll("-","")+"."+prefix;        	           
    		String path = filePath+uuidname;
            byte[] file36Byte = video4.getBytes();
            FileUtils.writeByteArrayToFile(new File(path),file36Byte);
            icbc_mq.setImgstep8_4v(imgpath+uuidname);
        }else {
        	icbc_mq.setImgstep8_4v("");
		}
        icbc_mq.setBc_status(2);
        icbc_mq.setDt_edit(creditutil.time());     
	    icbc_mq_result imr=new icbc_mq_result();
	    imr.setDt_add(creditutil.time());
	    imr.setDt_edit(creditutil.time());
	    imr.setStatus(2);
	    if(oredit!=null&&!oredit.equals("")&&
        		oredit.equals("1")
        		){
	    		icbc_mq.setMid_edit(gems.getAdmin_id());
	    		icbc_mq.setId(icbc_mq1.getId());
	    		icbc_mqService.upmq(icbc_mq);
	    		imr.setQryid(icbc_mq1.getId()); 
	    		imr.setRemark("编辑视频面签信息");
	    		icbc_mq_resultService.addmq_result(imr);
		        JSONObject result=new JSONObject();
	    		JSONObject result1=new JSONObject();
				result1.put("orderid",orderid);
				result1.put("mq_orderid",icbc_mq1.getGems_code());
				result.put("result",result1);
				result.put("msg","编辑成功");
				result.put("code","200");
				return result.toString();
	    }else{
	    	icbc_mq im=icbc_mqService.findlastid();
	    	int max=im.getId()+1;
	    	String order="MQKCD"+testStringBuilder(7-String.valueOf(max).length())+max;
	    	icbc_mq.setDt_add(creditutil.time());
	    	icbc_mq.setQuery_type(2);
	        icbc_mq.setGems_code(order);
	        icbc_mq.setGems_fs_id(gems.getFsid());
	        icbc_mq.setGems_id(gems.getId());
	        icbc_mq.setMid_add(gems.getAdmin_id());  
	        icbc_mq.setMid_edit(gems.getAdmin_id());
	        icbc_mq.setIcbc_id(icbc.getId());
	        icbc_mqService.savemq(icbc_mq);
	        imr.setRemark("提交视频面签信息");
	        imr.setQryid(icbc_mq.getId()); 
	        icbc_mq_resultService.addmq_result(imr);
	        JSONObject result=new JSONObject();
    		JSONObject result1=new JSONObject();
			result1.put("orderid",orderid);
			result1.put("mq_orderid",order);
			result.put("result",result1);
			result.put("msg","成功");
			result.put("code","200");
			return result.toString();
	    }

	}
	
	 //性能最高的方法
    public static String testStringBuilder(int sl) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<sl; i++) {
            sb.append(0);
        }
        return sb.toString();        
    }
}
