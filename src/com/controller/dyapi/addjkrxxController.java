package com.controller.dyapi;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



import com.alibaba.fastjson.JSONObject;
import com.http.duoying.syncjkrxxHttp;
import com.http.dyapi.dyapihttp;
import com.mashape.unirest.http.JsonNode;
import com.model1.bank;

import com.model1.mgcert;
import com.model1.ylqy;
import com.model1.zjf.zjfhistory;
import com.service1.duoying.bankService;
import com.service1.duoying.carmodelService;

import com.service1.duoying.mgcertService;
import com.service1.duoying.ylqyService;
import com.service1.jsy.jsyylqyService;
import com.service1.zjf.zjfhistoryService;
import com.util.creditutil;
import com.util.md5util;
import com.util.stringorintutil;
import com.util.duoying.MD5;
import com.util.duoying.attachmentutil;
import com.util.duoying.syncutil;


@Controller
public class addjkrxxController {
	
	@Autowired
	private mgcertService mgcertservice;
	
	@Autowired
	private bankService bankService;
	
	@Autowired
	private ylqyService ylqyService;
	@Autowired
	private jsyylqyService jsyylqyservice;
	
	@Autowired
	private carmodelService carmodelService;
	@Autowired
	private zjfhistoryService zjfhistoryservice;
	
	attachmentutil dyutil=new attachmentutil();
	

    private static String privatekey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJTjUZ/CBrE3hvkeMvkFxtM9uQFOOGpqWjjnJdJRrPWMjb1aDWS8btISwEm80Zs8msPk7/Qb2dh11qpSjvaNwXKIK0zJwi9Z0V6zrZNz+6V7NgPpbKjmWxU+QaY2D9CK3BWlysoVqb8YSISt25p72nB8HzOHJ+sIDeKJI9UIY/vLAgMBAAECgYEAim5IyCdYnZEpN5qyfgK2+FVdHC+kGJ1Fwb541fIGxE+owbNm3JCu4Td5/ZVHtfRFWXoU+HyksbPuoXIdZnQqtWuInNhdPVpiir6/yXSvP5LLfQN6lqkCzapgtuhuz3Cayp58qb0k4ujZ2l5pegNN7a8plqHUSZNoE3VFHMNNTZECQQDYyRm7U+gliPlnO8bpnnU6ciFbiAeXbWS4z+HY2hLHWqFO7U2grBKueJ1yMYDNL8PCGbbyO0bUxDIu07t5KYg1AkEAr9IEzgIYwbCBujRgJ3rj7r5bXsggzTiHLypj+Uvsq0niI2TvHmiYczP0m9lSHmuvZwhcdhd0bufA81Zigi/z/wJBAIcVAGC3Dw/cgzQtjmviXj/WAC0t3TUhaEK03pEmic8JDTzGJ7n3nwhyhgEzEYRJwByBs3rLLv7DZlXBf68nDwUCQHe4mND2mIj7ebqjg34eriqZsHn/6GYVweeaA+1zh7qzWqsjRbf9HSIFFOEywDo6tXuBNAStv/jtEnQgNH/Vy10CQBzWF7XlU9oXiLwoVoe+7JAe7cnfAfG+2nwiuzc0x9oHB1p7rET3u0AMIR6LfC0K2FWheQRYcqsAWyQviIjWa8I=";

    /**
     * 
     *  2 添加借款人信息
     * @return
     */ 
	@SuppressWarnings("unused")
	@RequestMapping(value="kjs_dysendjkrxx.do",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String borrower(
			String id,
			String kjs_type
			){   
        //空指针判断
      if(id==null||kjs_type==null||
		   id.equals("")||kjs_type.equals("")				   
				){
			JSONObject jb=new JSONObject();
			jb.put("code","202");
			jb.put("ret","");
			jb.put("msg","有字段为空");
		    return jb.toString();
		}
    	    List<Map<Object,Object>> attachment=new ArrayList<Map<Object,Object>>();
    	    List<Map<Object,Object>> maplist = new ArrayList<Map<Object,Object>>();
    	    List<ylqy> ylqylist = new ArrayList<ylqy>();
    	    List<bank> banklist = new ArrayList<>();    	      
    		mgcert mg=new mgcert();
            if(kjs_type.equals("8")){
                mg=mgcertservice.mgcarAPI(Integer.parseInt(id));
            }
            if(kjs_type.equals("9")){
            	mg=mgcertservice.mgcertAPI(Integer.parseInt(id));     		   
            }
            if(kjs_type.equals("10")){
            	mg=mgcertservice.mgnewcarAPI(Integer.parseInt(id));
            } 
            if(kjs_type.equals("17")){
            	mg=mgcertservice.mgxcAPI(Integer.parseInt(id));
            }
//           if(mg.getZjf_type()==2){
//        	     JSONObject result=new JSONObject();
//				 result.put("code","204");
//				 result.put("ret","");
//				 result.put("msg","借款信息已同步");
//				 return result.toString();	
//            }
 	       if(mg==null){
 				 JSONObject result=new JSONObject();
 				 result.put("code","203");
 				 result.put("ret", "");
 				 result.put("msg", "未找到借款信息");
 				 return result.toString();
 	        }
    		List<JSONObject> jl= new ArrayList<JSONObject>();
    		Map<Object,Object> personalBase=new HashMap<Object,Object>();
    		//Map<Object,Object> filetype=new HashMap<Object,Object>();
    		Map<Object,Object> mgmap=new HashMap<Object,Object>();
    		//Map<Object,Object> personal=new HashMap<Object,Object>();    		    	    	    
    	    Random r=new Random();
            personalBase.put("borrowerId",mg.getC_cardno()+"|"+String.valueOf(mg.getGems_fs_id())); 
            personalBase.put("categoryId",mg.getGems_fs_id());//根据这个id连接分类
            //personalBase.put("projectUuid","cd26b0ca-ad0a-4044-95a6-b6cb1b71bbc4");
            personalBase.put("managerId",mg.getGems_id());
            personalBase.put("name",mg.getC_name());
            if(mg.getImgstep2_4()!=null&&!mg.getImgstep2_4().equals("")){
            	JSONObject j1=attachmentutil.addAttachment("行驶证","2",mg.getImgstep2_4());	
            	jl.add(j1);
            }
            if(mg.getImgstep2_5()!=null&&!mg.getImgstep2_5().equals("")){
            	JSONObject j2=attachmentutil.addAttachment("身份证正面","6",mg.getImgstep2_5());           
            	jl.add(j2);	
            }
            if(mg.getImgstep2_10()!=null&&!mg.getImgstep2_10().equals("")){
            	 JSONObject j3=attachmentutil.addAttachment("放款流水（或银行卡）","11",mg.getImgstep2_10());
            	 jl.add(j3);	
            }
            if(mg.getImgstep2_11()!=null&&!mg.getImgstep2_11().equals("")){
            	JSONObject j4=attachmentutil.addAttachment("征信报告","9",mg.getImgstep2_11());
            	jl.add(j4);	
            }
            if(mg.getImgstep4_11()!=null&&!mg.getImgstep4_11().equals("")){
            	 JSONObject j5=attachmentutil.addAttachment("行驶证背面","2",mg.getImgstep4_11()); 
            	 jl.add(j5);	
            }
            if(mg.getImgstep2_14()!=null&&!mg.getImgstep2_14().equals("")){
            	JSONObject j6=attachmentutil.addAttachment("住家位置1","5",mg.getImgstep2_14()); 
            	jl.add(j6);	
            }
            if(mg.getImgstep2_15()!=null&&!mg.getImgstep2_15().equals("")){
            	JSONObject j7=attachmentutil.addAttachment("住家位置2","5",mg.getImgstep2_15()); 
            	jl.add(j7);	
            }
            if(mg.getImgstep2_16()!=null&&!mg.getImgstep2_16().equals("")){
            	 JSONObject j8=attachmentutil.addAttachment("住家环境1","5",mg.getImgstep2_16());
            	 jl.add(j8); 	
            }
            if(mg.getImgstep2_17()!=null&&!mg.getImgstep2_17().equals("")){
            	JSONObject j9=attachmentutil.addAttachment("住家环境2","5",mg.getImgstep2_17()); 
            	jl.add(j9);	
            }
            if(mg.getImgstep2_18()!=null&&!mg.getImgstep2_18().equals("")){
            	JSONObject j10=attachmentutil.addAttachment("住家证明","5",mg.getImgstep2_18()); 
            	jl.add(j10);	
            }
            if(mg.getImgstep2_6()!=null&&!mg.getImgstep2_6().equals("")){
            	 JSONObject j11=attachmentutil.addAttachment("身份证正面","6",mg.getImgstep2_6());
            	 jl.add(j11);	
            }            
			ylqy y=jsyylqyservice.findylqybycardid(mg.getC_cardno());
			List<Map<Object,Object>> banks=new ArrayList<Map<Object,Object>>();
			  if(y!=null){							
    			 Map<Object,Object> oneBank=new HashMap<Object,Object>();    			
    			if(y.getTEL()!=null){
    				personalBase.put("mobilePhone",y.getTEL());// phone	
    			}
    			if(y.getPROVINCE()!=null&&y.getCITY()!=null){
    				 personalBase.put("cityCode",y.getPROVINCE()+y.getCITY());//	
    			}
    		 oneBank.put("bankBranchName",y.getBANK_NAME());// String 
   		     oneBank.put("accountNo",y.getACCOUNT_NO());// String   	
		      //personal.put("personalBase2",personalBase);    		   
		     bank b=bankService.bankmap(y.getBANK_CODE());
             if(b!=null){
			  oneBank.put("bankName",b.getName());// 
			  oneBank.put("remark", "开户行");
	          banks.add(oneBank);    	        				                	  
             } 
		    	}
    		personalBase.put("certificateNo",mg.getC_cardno());// parpersnum
    		personalBase.put("certificateType","1");// parperstype  y.getID_TYPE() 标记哦    		         		   			
    		mgmap.put("base",personalBase);
        	mgmap.put("attachment",jl);
        	mgmap.put("bank",banks);
        	maplist.add(mgmap);
	         JSONObject data = new JSONObject();
             data.put("personalList",maplist); 
             JSONObject obj=syncutil.createHead(data);
             obj.put("data", data);
             zjfhistory zh=new zjfhistory();
             zh.setAddtime(creditutil.time());
             zh.setUptime(creditutil.time());
             zh.setSynpath("http://abs.51duoying.com:8082/ws/services/rest/borrower/addPersonal");
             zh.setSynrecording(obj.toString());
             zh.setCountnum(maplist.size());
             zh.setZjfname("多盈借款人订单信息");
             zh.setPath_type(2);
             String s=null;
             try {
            	 mgcert m=new mgcert();
              	 m.setId(Integer.valueOf(id)); 
              	 m.setZjf_type("1");
              	 //m.setSpcount(0);
              	 System.out.println("--------------------");
                 s=syncjkrxxHttp.dyhttp("http://abs.51duoying.com:8082/ws/services/rest/borrower/addPersonal",obj.toString());				     	     	     	     
                 JSONObject result=JSONObject.parseObject(s);
 		    	if(result.getString("code").equals("200")){	
 		    		JSONObject ret=JSONObject.parseObject(result.getString("ret"));
 		    		String[] successIds=ret.getString("successIds").replace(" ","").replace("[","").replace("]","").split(",");
 		    		if(successIds[0]!=null&&!successIds[0].equals("")){
 		    			  if(kjs_type.equals("8")){
 		                 	mgcertservice.upmgcar(m);
 		                 	System.out.println("更新押车");
 		                  }
 		                  if(kjs_type.equals("9")){
 		                  	mgcertservice.upmgcert(m);
 		                  	System.out.println("更新押证");
 		                  }
 		                  if(kjs_type.equals("10")){
 		                  	mgcertservice.upmgnewcar(m); 
 		                  	System.out.println("更新押新车");
 		                  }
 		    		}
 		    	}
                 zh.setReturnmsg(s);
                 zh.setSuccessnum(1);        
                 zjfhistoryservice.addsynhistory(zh);               
                 return s.toString();   
			 } catch (Exception e) {
				 JSONObject result=new JSONObject();
				 result.put("code","201");
				 result.put("ret", "");
				 result.put("msg", "同步失败-"+e);
			     zh.setReturnmsg(result.toString());
			     zjfhistoryservice.addsynhistory(zh); 
			     return result.toString();  
			 }

            
             
}	
	 
	
	
	public static void main(String[] args) {
		String id ="188";
		String kjs_type ="9";
		String time =String.valueOf(new Date().getTime());
		String sign;
		sign=MD5.sign(id+time+"kcway","UTF-8");			
		String s = null;
		try {
	    s =dyapihttp.kjsjkrxxhttp(id,kjs_type,"http://localhost:8080/kcd/kjs_dysendjkrxx.do");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(s);
        
//		String kjs_type="9";
//		if(kjs_type.equals("8")){
//        	
//        	System.out.println("更新押车");
//         }
//         if(kjs_type.equals("9")){
//         	
//         	System.out.println("更新押证");
//         }
//         if(kjs_type.equals("10")){
//
//         	System.out.println("更新押新车");
//         }
		
		
		
		
	}

}
