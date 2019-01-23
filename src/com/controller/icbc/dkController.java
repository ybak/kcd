package com.controller.icbc;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.model.icbc.icbc;
import com.model.icbc.icbc_cardk;
import com.model.icbc.icbc_result;
import com.model.icbc.icbc_zx;
import com.model.jbapi.jbzxapiuser;
import com.model1.gems;
import com.model1.icbc.icbc_dk;
import com.service.zx.jbzxapiuserService;
import com.service1.gemsService;
import com.service1.kjs_icbc.icbc_dkService;
import com.service1.kjs_icbc.icbc_result1Service;
import com.service1.kjs_icbc.newicbcService;
import com.util.creditutil;

@Controller
public class dkController {

	      @Autowired
	      private icbc_dkService icbc_dkService;
	      
	      @Autowired
	      private jbzxapiuserService jbzxapiuserService;
	      
	      @Autowired
	      private newicbcService newicbcService;
	      
	      @Autowired
	      private icbc_result1Service icbc_result1Service;
	      
	      @Autowired
	      private gemsService gemsService;
	      
	      
	      /**
	       * 贷款----结果查询
	       * @param appkey
	       * @param orderid
	       * @return
	       */
	  	  @RequestMapping(value="/carDk_result.do",produces="text/html;charset=UTF-8")	
		  @ResponseBody
	      public String carDk_result(
	    		  String appkey,
	  			  String orderid
	  			){
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
	          icbc icbc_zx=new icbc();
	          icbc_dk ic=new icbc_dk();
	          icbc_result ir=new icbc_result();
	  		if(orderid!=null&&!orderid.equals("")){
	          	icbc_zx=newicbcService.findicbcbyorderid(orderid);
	              if(icbc_zx==null||icbc_zx.equals("")){
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
	  		icbc_dk icbc_dk=icbc_dkService.findicbc_cardk(icbc_zx.getId());  
	  		if(icbc_dk!=null&&!icbc_dk.equals("")){
	  			JSONObject result=new JSONObject();
        		JSONObject result1=new JSONObject();  
        		icbc_result icbc_result=icbc_result1Service.dklastfindresult(icbc_dk.getId());
        		if(icbc_result!=null&&!icbc_result.equals("")){
        			result1.put("remark",icbc_result.getRemark());
        		}
        		result1.put("status",icbc_dk.getBc_status());
        		result1.put("fk_status",icbc_zx.getFk_status());
        		result1.put("orderid",orderid);   		
        		result1.put("dk_orderid",icbc_dk.getGems_code());
        		result.put("result",result1);		    					    			
        		result.put("msg","成功");
    			result.put("code","200");
    			return result.toString();
	  		}else{
        		JSONObject result=new JSONObject();
    			result.put("result",orderid);
    			result.put("msg","无贷款信息");
    			result.put("code","213");
    			return result.toString();
        	}
	      }
	      
	/**
	 * 贷款材料
	 * @param ckey
	 * @param orderid
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/carDk.do",produces="text/html;charset=UTF-8")	
	@ResponseBody
	public String carDk(
			String appkey,
			String orderid,
			String oredit,
			@RequestParam("img1_1s")MultipartFile[] img1_1s,//车辆发票
			@RequestParam("img1_2s")MultipartFile[] img1_2s,//车辆发票网上查询
			@RequestParam("img1_3s")MultipartFile[] img1_3s,//登记证书转产页
			@RequestParam("img1_4s")MultipartFile[] img1_4s,//分期付款/抵押合同			
			@RequestParam("img1_5s")MultipartFile[] img1_5s,//新增户口本照片
			@RequestParam("img2_1s")MultipartFile[] img2_1s,//新增家庭照片
			@RequestParam("img3_1s")MultipartFile[] img3_1s,//新增驾驶证
			@RequestParam("img4_1s")MultipartFile[] img4_1s,//签约一分钟视频
		HttpServletRequest request,HttpServletResponse response) throws IOException{
        Date date = new Date(); 
        String filePath = "/KCDIMG/assess/upload/"+new SimpleDateFormat("yyyy/MM/dd/").format(date);
        String imgpath="upload/"+new SimpleDateFormat("yyyy/MM/dd/").format(date);
        File f = new File(imgpath);
        if(!f.exists()){  
            f.mkdirs();   
        }
        // 响应客户端  
        response.setContentType("text/html;UTF-8"); 
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
        
        icbc icbc_zx=new icbc();
        icbc_dk ic=new icbc_dk();
        icbc_result ir=new icbc_result();
		if(orderid!=null&&!orderid.equals("")){
        	icbc_zx=newicbcService.findicbcbyorderid(orderid);
            if(icbc_zx==null||icbc_zx.equals("")){
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
		icbc_dk  icCardk=icbc_dkService.findicbc_cardk(icbc_zx.getId());
        if(oredit!=null&&!oredit.equals("")&&
        		oredit.equals("1")
        		){        	
           if(icCardk==null||icCardk.equals("")){
    		JSONObject result=new JSONObject();
			result.put("result",orderid);
			result.put("msg","无可编辑汽车贷款信息");
			result.put("code","213");
			return result.toString();
    	   }        
        
        }else{        	
           if(icCardk!=null&&!icCardk.equals("")){
        		JSONObject result=new JSONObject();
        		JSONObject result1=new JSONObject();
                result1.put("dk_orderid",icCardk.getGems_code());
                result1.put("orderid",orderid);
        		result.put("result",result1);
    			result.put("msg","已有汽车贷款订单信息");
    			result.put("code","214");
    			return result.toString();
          }
        }
        System.out.println(img1_1s.length);
	    //签约材料
		if(img1_1s!=null&&img1_1s.length>0){
			String imgs="";
        	for(int i=0;i<img1_1s.length;i++){
        		MultipartFile file=img1_1s[i];
        		if(file.getSize()>0){
        		String filename = file.getOriginalFilename();
        	    String prefix=filename.substring(filename.lastIndexOf(".")+1);
        	    UUID uuid = UUID.randomUUID();
    		    String uuidname=uuid.toString().replaceAll("-","")+"."+prefix;        	           
    			String path = filePath+uuidname;
                byte[] file36Byte = file.getBytes();
                FileUtils.writeByteArrayToFile(new File(path),file36Byte);
                // System.out.println(imgpath+"addsuppily/"+creditutil.timefile()+"/"+UUIDTool.getUUID()+i+"."+prefix);
                imgs=imgs+""+imgpath+uuidname; 
        		}
        	}  
        	ic.setImgstep4_1ss(imgs);
		}
		//签约材料
				if(img1_2s!=null&&img1_2s.length>0){
					String imgs="";
		        	for(int i=0;i<img1_2s.length;i++){
		        		MultipartFile file=img1_2s[i];
		        		if(file.getSize()>0){ 
		        		String filename = file.getOriginalFilename();
		        	    String prefix=filename.substring(filename.lastIndexOf(".")+1);
		        	    UUID uuid = UUID.randomUUID();
		    		    String uuidname=uuid.toString().replaceAll("-","")+"."+prefix;        	           
		    			String path = filePath+uuidname;
		                byte[] file36Byte = file.getBytes();
		                FileUtils.writeByteArrayToFile(new File(path),file36Byte);
		                // System.out.println(imgpath+"addsuppily/"+creditutil.timefile()+"/"+UUIDTool.getUUID()+i+"."+prefix);
		                imgs=imgs+""+imgpath+uuidname; 
		        	}  
		        	}
		        	ic.setImgstep4_2ss(imgs);
				}
				//签约材料
				if(img1_3s!=null&&img1_3s.length>0){
					String imgs="";
		        	for(int i=0;i<img1_3s.length;i++){
		        		MultipartFile file=img1_3s[i];
		        		if(file.getSize()>0){ 
		        		String filename = file.getOriginalFilename();
		        	    String prefix=filename.substring(filename.lastIndexOf(".")+1);
		        	    UUID uuid = UUID.randomUUID();
		    		    String uuidname=uuid.toString().replaceAll("-","")+"."+prefix;        	           
		    			String path = filePath+uuidname;
		                byte[] file36Byte = file.getBytes();
		                FileUtils.writeByteArrayToFile(new File(path),file36Byte);
		                // System.out.println(imgpath+"addsuppily/"+creditutil.timefile()+"/"+UUIDTool.getUUID()+i+"."+prefix);
		                imgs=imgs+""+imgpath+uuidname; 
		        	}  
		        	}
		        	ic.setImgstep4_3ss(imgs);
				}
				//签约材料
				if(img1_4s!=null&&img1_4s.length>0){
					String imgs="";
		        	for(int i=0;i<img1_4s.length;i++){
		        		MultipartFile file=img1_4s[i];
		        		if(file.getSize()>0){ 
		        		String filename = file.getOriginalFilename();
		        	    String prefix=filename.substring(filename.lastIndexOf(".")+1);
		        	    UUID uuid = UUID.randomUUID();
		    		    String uuidname=uuid.toString().replaceAll("-","")+"."+prefix;        	           
		    			String path = filePath+uuidname;
		                byte[] file36Byte = file.getBytes();
		                FileUtils.writeByteArrayToFile(new File(path),file36Byte);
		                // System.out.println(imgpath+"addsuppily/"+creditutil.timefile()+"/"+UUIDTool.getUUID()+i+"."+prefix);
		                imgs=imgs+""+imgpath+uuidname;
		        		}
		        	}  
		        	ic.setImgstep4_4ss(imgs);
				}
				//签约材料
				if(img1_5s!=null&&img1_5s.length>0){
					String imgs="";
		        	for(int i=0;i<img1_5s.length;i++){
		        		MultipartFile file=img1_5s[i];
		        		if(file.getSize()>0){ 
		        		String filename = file.getOriginalFilename();
		        	    String prefix=filename.substring(filename.lastIndexOf(".")+1);
		        	    UUID uuid = UUID.randomUUID();
		    		    String uuidname=uuid.toString().replaceAll("-","")+"."+prefix;        	           
		    			String path = filePath+uuidname;
		                byte[] file36Byte = file.getBytes();
		                FileUtils.writeByteArrayToFile(new File(path),file36Byte);
		                // System.out.println(imgpath+"addsuppily/"+creditutil.timefile()+"/"+UUIDTool.getUUID()+i+"."+prefix);
		                imgs=imgs+""+imgpath+uuidname; 
		        	}  
		        	}
		        	ic.setImgstep4_5ss(imgs);
				}
				//证明材料
				if(img2_1s!=null&&img2_1s.length>0){
					String imgs="";
		        	for(int i=0;i<img2_1s.length;i++){
		        		MultipartFile file=img2_1s[i];
		        		if(file.getSize()>0){ 
		        		String filename = file.getOriginalFilename();
		        	    String prefix=filename.substring(filename.lastIndexOf(".")+1);
		        	    UUID uuid = UUID.randomUUID();
		    		    String uuidname=uuid.toString().replaceAll("-","")+"."+prefix;        	           
		    			String path = filePath+uuidname;
		                byte[] file36Byte = file.getBytes();
		                FileUtils.writeByteArrayToFile(new File(path),file36Byte);
		                // System.out.println(imgpath+"addsuppily/"+creditutil.timefile()+"/"+UUIDTool.getUUID()+i+"."+prefix);
		                imgs=imgs+""+imgpath+uuidname; 
		        	}  }
		        	ic.setImgstep5_1ss(imgs);
				}
				//其他材料
				if(img3_1s!=null&&img3_1s.length>0){
					String imgs="";
		        	for(int i=0;i<img3_1s.length;i++){
		        		MultipartFile file=img3_1s[i];
		        		if(file.getSize()>0){ 
		        		String filename = file.getOriginalFilename();
		        	    String prefix=filename.substring(filename.lastIndexOf(".")+1);
		        	    UUID uuid = UUID.randomUUID();
		    		    String uuidname=uuid.toString().replaceAll("-","")+"."+prefix;        	           
		    			String path = filePath+uuidname;
		                byte[] file36Byte = file.getBytes();
		                FileUtils.writeByteArrayToFile(new File(path),file36Byte);
		                // System.out.println(imgpath+"addsuppily/"+creditutil.timefile()+"/"+UUIDTool.getUUID()+i+"."+prefix);
		                imgs=imgs+""+imgpath+uuidname; 
		        	}  }
		        	ic.setImgstep6_1ss(imgs);
				}
				//补充材料
				if(img4_1s!=null&&img4_1s.length>0){
					String imgs="";
		        	for(int i=0;i<img4_1s.length;i++){
		        		MultipartFile file=img4_1s[i];
		        		if(file.getSize()>0){ 
		        		String filename = file.getOriginalFilename();
		        	    String prefix=filename.substring(filename.lastIndexOf(".")+1);
		        	    UUID uuid = UUID.randomUUID();
		    		    String uuidname=uuid.toString().replaceAll("-","")+"."+prefix;        	           
		    			String path = filePath+uuidname;
		                byte[] file36Byte = file.getBytes();
		                FileUtils.writeByteArrayToFile(new File(path),file36Byte);
		                // System.out.println(imgpath+"addsuppily/"+creditutil.timefile()+"/"+UUIDTool.getUUID()+i+"."+prefix);
		                imgs=imgs+""+imgpath+uuidname; 
		        	}  }
		        	ic.setImgstep7_1ss(imgs);
				}
        ir.setDt_add(creditutil.time());       
        ir.setMid_add(0);
        ir.setMid_edit(0);               
        ir.setDt_edit(creditutil.time());        
        ir.setQryid(icbc_zx.getId());        
        if(oredit!=null&&!oredit.equals("")&&
        		oredit.equals("1")
        		){        	 
        	    ic.setMid_edit(gems.getAdmin_id());
        		ir.setStatus(icCardk.getBc_status());
        		ic.setId(icCardk.getId());
        		ic.setDt_edit(creditutil.time());
        		icbc_dkService.upicbc_cardk(ic);	
        		ir.setRemark("编辑贷款材料信息");
        		icbc_result1Service.addcardk_result(ir);
                JSONObject result=new JSONObject();
                JSONObject result1=new JSONObject();
                result1.put("dk_orderid",icCardk.getGems_code());
                result1.put("orderid",orderid);
        		result.put("result",result1);
        		result.put("msg","编辑成功");
        		result.put("code","200");
        		return result.toString();       		
        }else{     
        	ic.setMid_add(gems.getAdmin_id());
        	ic.setMid_edit(gems.getAdmin_id());
        	ic.setGems_fs_id(gems.getFsid());
        	ic.setGems_id(gems.getId());
        	ir.setStatus(2);
			ic.setBc_status(2);
			ic.setDt_add(creditutil.time());
			ic.setDt_edit(creditutil.time());			
	        ic.setIcbc_id(icbc_zx.getId());
            ic.setQuery_type(2);
            ir.setRemark("提交贷款材料信息");
            icbc_dkService.addicbc_cardk(ic);
            icbc_dk ic1=new icbc_dk();
            ic1.setId(ic.getId());
            String order="DKKCD"+testStringBuilder(7-String.valueOf(ic.getId()).length())+ic.getId();
            ic1.setGems_code(order);
            icbc_dkService.upicbc_cardk(ic1);
            icbc_result1Service.addcardk_result(ir);
            JSONObject result=new JSONObject();
            JSONObject result1=new JSONObject();
            result1.put("dk_orderid",order);
            result1.put("orderid", orderid);
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
