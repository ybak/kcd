package com.controller.duoying;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



import com.alibaba.fastjson.JSONObject;
import com.http.duoying.syncjkrxxHttp;
import com.mashape.unirest.http.JsonNode;
import com.model1.bank;

import com.model1.mgcert;
import com.model1.ylqy;
import com.service1.duoying.bankService;
import com.service1.duoying.carmodelService;

import com.service1.duoying.mgcertService;
import com.service1.duoying.ylqyService;
import com.service1.jsy.jsyylqyService;
import com.util.md5util;
import com.util.duoying.attachmentutil;
import com.util.duoying.syncutil;


@Controller
public class addBorrower4_1Controller {
	
	@Autowired
	private mgcertService mgcertService;
	
	@Autowired
	private bankService bankService;
	
	@Autowired
	private ylqyService ylqyService;
	@Autowired
	private jsyylqyService jsyylqyservice;
	
	@Autowired
	private carmodelService carmodelService;
	
	
	attachmentutil dyutil=new attachmentutil();
	

    private static String privatekey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJTjUZ/CBrE3hvkeMvkFxtM9uQFOOGpqWjjnJdJRrPWMjb1aDWS8btISwEm80Zs8msPk7/Qb2dh11qpSjvaNwXKIK0zJwi9Z0V6zrZNz+6V7NgPpbKjmWxU+QaY2D9CK3BWlysoVqb8YSISt25p72nB8HzOHJ+sIDeKJI9UIY/vLAgMBAAECgYEAim5IyCdYnZEpN5qyfgK2+FVdHC+kGJ1Fwb541fIGxE+owbNm3JCu4Td5/ZVHtfRFWXoU+HyksbPuoXIdZnQqtWuInNhdPVpiir6/yXSvP5LLfQN6lqkCzapgtuhuz3Cayp58qb0k4ujZ2l5pegNN7a8plqHUSZNoE3VFHMNNTZECQQDYyRm7U+gliPlnO8bpnnU6ciFbiAeXbWS4z+HY2hLHWqFO7U2grBKueJ1yMYDNL8PCGbbyO0bUxDIu07t5KYg1AkEAr9IEzgIYwbCBujRgJ3rj7r5bXsggzTiHLypj+Uvsq0niI2TvHmiYczP0m9lSHmuvZwhcdhd0bufA81Zigi/z/wJBAIcVAGC3Dw/cgzQtjmviXj/WAC0t3TUhaEK03pEmic8JDTzGJ7n3nwhyhgEzEYRJwByBs3rLLv7DZlXBf68nDwUCQHe4mND2mIj7ebqjg34eriqZsHn/6GYVweeaA+1zh7qzWqsjRbf9HSIFFOEywDo6tXuBNAStv/jtEnQgNH/Vy10CQBzWF7XlU9oXiLwoVoe+7JAe7cnfAfG+2nwiuzc0x9oHB1p7rET3u0AMIR6LfC0K2FWheQRYcqsAWyQviIjWa8I=";

//    private static JSONObject createHead() {
//        JSONObject obj = new JSONObject();
//        obj.put("ver", "1.0");// 閻楀牊婀�
//        obj.put("curTime", new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
//        obj.put("nonce", new Random().nextInt(10000));// 娑擄拷娑擃亪娈㈤張鐑樻殶
//        obj.put("sign", md5util.getMD5(privatekey + obj.getString("nonce") + obj.getString("curTime")+data,"UTF-8"));// 缁涙儳鎮�
//        obj.put("signType", "MD5");// 缁涙儳鎮曠猾璇茬�
//        obj.put("appKey", "KCD");// 婢舵氨娉╅幓鎰返閻ㄥ嚈PPKEY
//        return obj;
//    }

    /**
     * 
     *  鎶艰瘉4.1娣诲姞鍊熸浜�涓汉)  鍘嬭瘉
     * @return
     */
    
	@SuppressWarnings("unused")
	@RequestMapping(value="addbow2.do",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String borrower(){   
    	    List<Map<Object,Object>> attachment=new ArrayList<Map<Object,Object>>();
    	    List<Map<Object,Object>> maplist = new ArrayList<Map<Object,Object>>();
    	    List<ylqy> ylqylist = new ArrayList<ylqy>();
    	    List<bank> banklist = new ArrayList<>();
    	    List<mgcert> mgcertlist1 = new ArrayList<mgcert>();
    	    List<mgcert> mgcertlist2 = new ArrayList<mgcert>();
    	    List<mgcert> mgcertlist3= new ArrayList<mgcert>(); 
    	    List<mgcert> alllist= new ArrayList<mgcert>();
    	    mgcert mg = new mgcert();	
    	    mgcertlist1 = mgcertService.Apimgcert();
    	    mgcertlist2 = mgcertService.Apimgcar();
    	    mgcertlist3 = mgcertService.Apimgnewcar();
    	    alllist.addAll(mgcertlist1);
    	    alllist.addAll(mgcertlist2);
    	    alllist.addAll(mgcertlist3);
    	    //mgcertlist3=mgcertService.Apimgcert();
    	    System.out.println("总数："+alllist.size());
//    	    if(mgcertlist3!=null){
//    	    	return String.valueOf(mgcertlist3.size());	
//    	    }
    	    
    	for(int i = 0;i<alllist.size();i++){  
         //try {
    		List<JSONObject> jl= new ArrayList<JSONObject>();
    		Map<Object,Object> personalBase=new HashMap<Object,Object>();
    		//Map<Object,Object> filetype=new HashMap<Object,Object>();
    		Map<Object,Object> mgmap=new HashMap<Object,Object>();
    		//Map<Object,Object> personal=new HashMap<Object,Object>();    		
    	    mg = alllist.get(i);    	    
    	    Random r=new Random();
            personalBase.put("borrowerId",mg.getC_cardno()+"|"+String.valueOf(mg.getGems_fs_id())); 
            personalBase.put("categoryId",mg.getGems_fs_id());//根据这个id 连接分类
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
            	 JSONObject j3=attachmentutil.addAttachment("放款流水","11",mg.getImgstep2_10());
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
            
    		//String ACCOUNT_NAME = "";
			//ACCOUNT_NAME = .toString();
			//System.out.println(ACCOUNT_NAME);
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
			  oneBank.put("remark","备注");
	          banks.add(oneBank);    	        				                	  
             }  
			  }	
    		personalBase.put("certificateNo",mg.getC_cardno());// parpersnum
    		personalBase.put("certificateType","1");// parperstype  y.getID_TYPE() 鏍囪鍝�   		         		   			
    		mgmap.put("base",personalBase);
        	mgmap.put("attachment",jl);
        	mgmap.put("bank",banks);
        	maplist.add(mgmap);
//    	    } catch (Exception e) {
//    	    	System.out.println("error:"+e.toString());
//    	    	continue;     		
//	        }
    		} 
    	String res = null;
        if(null!=maplist&&maplist.size()>0){
	    	int pointsDataLimit =100;//限制条数
	    	Integer size = maplist.size();
	    	//判断是否有必要分批
	    	if(pointsDataLimit<size){
	    	int part = size/pointsDataLimit;//分批数
	       System.out.println("共有 ： "+size+"条，！"+" 分为 ："+part+"批");
	    	//
	    	for (int i = 0; i < part; i++) {
	    		
	    	//100条
	        List<Map<Object, Object>> listPage = maplist.subList(0,pointsDataLimit);
//	    	System.out.println(listPage);
	    	 JSONObject data = new JSONObject();
	         data.put("personalList",listPage); 
	     	 JSONObject obj=syncutil.createHead(data);
	         obj.put("data", data);
	         //String s=syncjkrxxHttp.dyhttp("http://abs.51duoying.com:8082/ws/services/rest/borrower/addPersonal", obj.toString());				     	     	     	
	         res=res+obj.toString();
	    		//	剔除
	       	//System.out.println("返回参数："+s);
	     maplist.subList(0,pointsDataLimit).clear();  
	      // return data.toString();		
	      }
	     if(!maplist.isEmpty()){
	    	 JSONObject data = new JSONObject();
	         data.put("personalList",maplist); 
	     	 JSONObject obj=syncutil.createHead(data);
	         obj.put("data", data);
	     	 //String s=syncjkrxxHttp.dyhttp("http://abs.51duoying.com:8082/ws/services/rest/borrower/addPersonal", obj.toString());				     	     	     	
	         res=res+obj.toString();
	      }
	   }else{
	    	 JSONObject data = new JSONObject();
	         data.put("personalList",maplist); 
	     	 JSONObject obj=syncutil.createHead(data);
	         obj.put("data", data);
	         //String s=syncjkrxxHttp.dyhttp("http://abs.51duoying.com:8082/ws/services/rest/borrower/addPersonal", obj.toString());				     	     	     	
	         res=obj.toString();
	   }
	   }else{
	     System.out.println("没有数据!!!");
	   }
    	
   return maplist.size()+res;
         
}
	
	
	public static void main(String[] args) {
		 List l1=new ArrayList();
		 List l2=new ArrayList();
		 List l3=new ArrayList();
		 List l=new ArrayList();
		 for(int i=0;i<10;i++){
		     l1.add("押证"+i+1);
			 l2.add("押车"+i+1);
			 l3.add("押新车"+i+1);
		 }
		 l.addAll(l1);
		 l.addAll(l2);
		 l.addAll(l3);
		 for(int k=0;k<l.size();k++){
		   System.out.println("---"+l.get(0));
		 }
		 
	}
}
