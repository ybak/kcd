package com.controller.icbc;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
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

import com.alibaba.fastjson.JSONObject;
import com.model.icbc.assess_cars;
import com.model.icbc.assess_cars_item;
import com.model.icbc.bclient_check;
import com.model.icbc.icbc;
import com.model.jbapi.jbzxapiuser;
import com.model1.gems;
import com.model1.money.moneyfs;
import com.model1.money.moneyfs_1;
import com.service.zx.jbzxapiuserService;
import com.service1.car.icbc_carsService;
import com.service1.car.icbc_cars_resultService;
import com.service1.car.newassess_cars_itemService;
import com.service1.car.newassess_cars_itemServiceImpl;
import com.service1.kjs_icbc.newicbcService;
import com.util.creditutil;

@Controller
public class icbc_carsController {

	   @Autowired
	   private jbzxapiuserService jbzxapiuserService;
	   @Autowired
	   private icbc_cars_resultService icbc_cars_resultService;
	   @Autowired
	   private icbc_carsService icbc_carsService;
	   @Autowired
	   private newassess_cars_itemService newassess_cars_itemService;
	   @Autowired
	   private newicbcService newicbcService;
	   @Autowired
	   private com.service1.gemsService gemsService;
	   @Autowired
	   private com.service1.money.moneyfsService moneyfsService;
	   @Autowired
	   private com.service1.money.moneyfs_1Service moneyfs_1Service;
	   
		@RequestMapping(value="/icbc_cars_assess_result.do",produces ="text/html;charset=UTF-8")	
		@ResponseBody
	    public String icbc_cars_assess_result(String appkey,
		    	   String orderid
	    		){
			    gems gems=gemsService.find_api(appkey);
		        icbc icbc=newicbcService.findicbcbyorderid(orderid);
		        if(gems!=null&&!gems.equals("")){        	        
		        if(icbc!=null&&!icbc.equals("")){
		        	assess_cars assess_cars=icbc_carsService.findicbc_cars1(icbc.getId());
		        	if(assess_cars!=null&&!assess_cars.equals("")){
		        		JSONObject result=new JSONObject();
		        		JSONObject result1=new JSONObject();
		        		bclient_check bclient_check=icbc_cars_resultService.lastfindicbc_cars(assess_cars.getId());
		        		if(bclient_check!=null&&!bclient_check.equals("")){
		        		result1.put("remark",bclient_check.getRemark());
		        		}
		        		result1.put("status",assess_cars.getBc_status());
		        		result1.put("price_result",assess_cars.getPrice_result());
		        		result1.put("orderid",orderid);
		        		result1.put("assess_orderid",assess_cars.getGems_code());
		        		result.put("result",result1);		    					    			
		        		result.put("msg","成功");
		    			result.put("code","200");
		    			return result.toString();		        				        		
		        	}else{
		        		JSONObject result=new JSONObject();
		    			result.put("result",orderid);
		    			result.put("msg","无汽车评估信息");
		    			result.put("code","213");
		    			return result.toString();
		        	}
		        }else{
		        	JSONObject result=new JSONObject();
					result.put("result","");
					result.put("msg","订单编号错误");
					result.put("code","212");
					return result.toString();
		        }
		        }else{
		        	JSONObject result=new JSONObject();
					result.put("result","");
					result.put("msg","appkey错误");
					result.put("code","211");
					return result.toString();	
				}
		}
		@RequestMapping(value="/icbc_cars_assess.do",produces ="text/html;charset=UTF-8")	
		@ResponseBody
	    public String icbc_cars_assess(
	    	   String appkey,
	    	   String orderid,
	    	   int source_id,//1国产/2进口
	    	   int property_id,//使用性质 1营运/2非营运
        	   int gear_box_id,//1自动/2手动
	    	   int car_status,//车辆状况 1优秀 2良好 3一般
			   int color_id,
			   int brid,	
			   int seid,	
			   int carid,
			   int mem_states,
			   int mem_citys,
			   int car_km_icbc,//行驶里程(公里)
			   String c_carno,
			   String vincode,//车架号
			   String cardt1,//初次登记日期
			   String cardt2,//出厂日期
			   String icbc_pricecs,//预期价格
			   String oredit,
			   @RequestParam("files")MultipartFile[] files, 
			   HttpServletRequest request,
			   HttpServletResponse response	    		
			   ) throws IOException, ParseException{
		bclient_check bCheck=new bclient_check();
		bCheck.setDt_add(creditutil.time());
		bCheck.setDt_edit(creditutil.time());
		bCheck.setStatus(2);
		assess_cars assess_cars=new assess_cars();
		assess_cars.setDt_edit(creditutil.time());
		assess_cars.setMem_citys(mem_citys);
		assess_cars.setMem_states(mem_states);
		assess_cars.setColor_id(color_id);		
		assess_cars.setCar_km_icbc(car_km_icbc);
		assess_cars.setSource_id(source_id);
		assess_cars.setProperty_id(property_id);
		assess_cars.setGear_box_id(gear_box_id);
		assess_cars.setCar_status(car_status);
		assess_cars.setCardt1(cardt1);
		assess_cars.setCardt2(cardt2);
		assess_cars.setVincode(vincode);
		assess_cars.setC_carno(c_carno);
		assess_cars.setBrid(brid);
		assess_cars.setSeid(seid);
		assess_cars.setCarid(carid);
		float pFloat =(float)0;
		if(icbc_pricecs!=null&&!icbc_pricecs.equals("")){
		pFloat=Float.valueOf(icbc_pricecs);		
	    }
		assess_cars.setIcbc_pricecs(pFloat);
		Date date = new Date(); 
        String filePath = "/KCDIMG/assess/upload/"+new SimpleDateFormat("yyyy/MM/dd/").format(date);
        String imgpath="assess/upload/"+new SimpleDateFormat("yyyy/MM/dd/").format(date);
        File f = new File(imgpath);
        if(!f.exists()){  
            f.mkdirs();   
        }    
        assess_cars.setBc_status(2);
        gems gems=gemsService.find_api(appkey);
        icbc icbc=newicbcService.findicbcbyorderid(orderid);
        if(gems!=null&&!gems.equals("")){       
        	 assess_cars.setMem_id(0);
        	 assess_cars.setGems_id(gems.getId());
        	 assess_cars.setGems_fs_id(gems.getFsid());       	
        if(icbc!=null&&!icbc.equals("")){
        assess_cars assess_cars2=icbc_carsService.findicbc_cars1(icbc.getId());        
		if(oredit!=null&&!oredit.equals("")&&oredit.equals("1")){				
			if(assess_cars2!=null&&!assess_cars2.equals("")){
				List<assess_cars_item> aCars_itemlist=newassess_cars_itemService.findicbc_carsimg(assess_cars2.getId());
				 if (files!=null&&files.length>0) {  
			        	String pString ="";
			        	List l=new ArrayList<>();
			        	for(int i=0;i<files.length;i++){
			        		MultipartFile file=files[i];
			        		if(file.getSize()>0){
			        		String filename = file.getOriginalFilename();
			        	    String prefix=filename.substring(filename.lastIndexOf(".")+1);
			        	    UUID uuid = UUID.randomUUID();
			        	    String uuidname=uuid.toString().replaceAll("-","")+"."+prefix;        	
			                byte[] file36Byte =file.getBytes();
			                FileUtils.writeByteArrayToFile(new File(filePath+uuidname),file36Byte);
			                assess_cars_item aci=new assess_cars_item();
			                aci.setCars_id(assess_cars2.getId()); 
		                    aci.setPoints_id(i+1);
			                aci.setBcimg(imgpath+uuidname);
			                if(i+1<=aCars_itemlist.size()){
			                newassess_cars_itemService.upcarsitem(aci);
			                }else{
			                newassess_cars_itemService.addcarsitem(aci);	
			                }
			        		}
			        	}  
			        	
			     }  
				assess_cars.setId(assess_cars2.getId());
				icbc_carsService.upcodebyid(assess_cars);
				bCheck.setAssessid(assess_cars2.getId());
				bCheck.setRemark("重新编辑汽车评估信息");
				icbc_cars_resultService.addbclient_check(bCheck);
				JSONObject result=new JSONObject();
				JSONObject result1=new JSONObject();
				result1.put("orderid",orderid);
				result1.put("assess_orderid",assess_cars2.getGems_code());
    			result.put("result",result1);
    			result.put("msg","编辑成功");
    			result.put("code","200");
    			return result.toString();
			}else{
				JSONObject result=new JSONObject();
    			result.put("result",orderid);
    			result.put("msg","无可编辑汽车评估信息");
    			result.put("code","213");
    			return result.toString();				
			}
		}else{
			if(assess_cars2!=null&&!assess_cars2.equals("")) {
				JSONObject result=new JSONObject();
				JSONObject result1=new JSONObject();
				result1.put("orderid",orderid);
				result1.put("assess_orderid",assess_cars2.getGems_code());
    			result.put("result",result1);
    			result.put("msg","已有汽车评估订单信息");
    			result.put("code","214");
    			return result.toString();
			}
			
			assess_cars ac=icbc_carsService.findlastid();
			int max=ac.getId()+1;
			String ordercode="PGAPI"+testStringBuilder(8-String.valueOf(max).length())+max; 
			String jdcode="JDKCD"+testStringBuilder(8-String.valueOf(max).length())+max;
			assess_cars.setCode(ordercode);
			assess_cars.setDt_add(creditutil.time());		
			assess_cars.setGems_code(jdcode);
			assess_cars.setBc_status(2);
			assess_cars.setBc_type(2);		
			assess_cars.setIcbc_id(icbc.getId()); 
			assess_cars.setXsource(0);
			icbc_carsService.addassess_cars(assess_cars);
			if (files!=null&&files.length>0) {  
	        	String pString ="";
	        	List l=new ArrayList<>();
	        	for(int i=0;i<files.length;i++){
	        		MultipartFile file=files[i];
	        		if(file.getSize()>0){
	        		String filename = file.getOriginalFilename();
	        	    String prefix=filename.substring(filename.lastIndexOf(".")+1);
	        	    UUID uuid = UUID.randomUUID();
	        	    String uuidname=uuid.toString().replaceAll("-","")+"."+prefix;        	
	                byte[] file36Byte =file.getBytes();
	                FileUtils.writeByteArrayToFile(new File(filePath+uuidname),file36Byte);
	                assess_cars_item aci=new assess_cars_item();
	                aci.setBcimg(imgpath+uuidname);
                    aci.setCars_id(assess_cars.getId()); 
                    aci.setPoints_id(i+1);
	                newassess_cars_itemService.addcarsitem(aci);
	        		}
	        	}  	
	        } 
			bCheck.setAssessid(assess_cars.getId());
			bCheck.setRemark("提交汽车评估信息");
			icbc_cars_resultService.addbclient_check(bCheck);
			moneyfs moneyfs=new moneyfs();			
			moneyfs.setAmount(-300);
			moneyfs.setBintype(0);
			moneyfs.setDt_add(creditutil.time());
			moneyfs.setDt_edit(creditutil.time());
			moneyfs.setFctype(0);
			moneyfs.setFsid(assess_cars.getGems_fs_id());
			moneyfs.setGemsid(assess_cars.getGems_id());
			moneyfs.setMid(assess_cars.getGems_fs_id());
			moneyfs.setMid_add(gems.getAdmin_id());
			moneyfs.setMid_edit(gems.getAdmin_id());
			moneyfs.setOrderid(assess_cars.getId());
			moneyfs.setOtherid(0);
			moneyfs.setRemark("工行车贷接口-汽车评估");
			moneyfs.setStatus(1);
			moneyfs.setType(29);
			moneyfsService.addmoneyfs(moneyfs);
			moneyfs_1 moneyfs1=new moneyfs_1();			
			moneyfs1.setAmount(-300);
			moneyfs1.setBintype(0);
			moneyfs1.setDt_add(creditutil.time());
			moneyfs1.setDt_edit(creditutil.time());
			moneyfs1.setFsid(assess_cars.getGems_fs_id());
			moneyfs1.setGemsid(assess_cars.getGems_id());
			moneyfs1.setMid(assess_cars.getGems_fs_id());
			moneyfs1.setRemark("工行车贷接口-汽车评估");
			moneyfs1.setStatus(1);
			moneyfs1.setMoneyid(moneyfs.getId());
			moneyfs1.setBc_type(0);
			moneyfs1.setOrderid(assess_cars.getId());
			moneyfs1.setType(29);
            moneyfs_1Service.addmoneyfs_2(moneyfs1);  
			JSONObject result=new JSONObject();
			JSONObject result1=new JSONObject();
			result1.put("orderid",orderid);
			result1.put("assess_orderid",assess_cars.getGems_code());
 			result.put("result",result1);
 			result.put("msg","成功");
 			result.put("code","200");
 			return result.toString();
		}
    	
        }else{
        	JSONObject result=new JSONObject();
			result.put("result","");
			result.put("msg","订单编号错误");
			result.put("code","212");
			return result.toString();
        }
        }else{
        	JSONObject result=new JSONObject();
			result.put("result","");
			result.put("msg","appkey错误");
			result.put("code","211");
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
