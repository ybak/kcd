package com.controller.duoying;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.http.duoying.syncjkrxxHttp;
import com.mapper1.zjf.zjfhistoryMapper;
import com.mashape.unirest.http.JsonNode;
import com.model1.fsdy;
import com.model1.zjf.zjfhistory;
import com.service1.duoying.bankService;
import com.service1.duoying.carmodelService;
import com.service1.duoying.mgcarService;
import com.service1.duoying.ylqyService;
import com.service1.zjf.zjfhistoryService;
import com.util.creditutil;
import com.util.jsonutil;
import com.util.md5util;
import com.util.duoying.MD5;
import com.util.duoying.syncutil;
import com.util.jsy.WriteStringToTxt;
import com.service1.duoying.fsdyService;

@Controller
public class addCategory4_4Controller{	
	
	@Autowired
	private mgcarService mgcarService;
	@Autowired
	private com.service1.duoying.mgcertService mgcertservice;
	
	@Autowired
	private bankService bankService;
	
	@Autowired
	private zjfhistoryService zjfhistoryservice;
	
	@Autowired
	private ylqyService ylqyService;
	
	@Autowired
	private carmodelService carmodelService;
	
	@Autowired
	private fsdyService fsdyService;
	

    /**
     * 以post方式访问
     * 
     * @param url
     *            接口url地址
     * @param xmlBody
     *            xml格式的字符串
     * @return
     */
   
    private static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCU41GfwgaxN4b5HjL5BcbTPbkBTjhqalo45yXSUaz1jI29Wg1kvG7SEsBJvNGbPJrD5O/0G9nYddaqUo72jcFyiCtMycIvWdFes62Tc/ulezYD6Wyo5lsVPkGmNg/QitwVpcrKFam/GEiErduae9pwfB8zhyfrCA3iiSPVCGP7ywIDAQAB";

    private static String privatekey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJTjUZ/CBrE3hvkeMvkFxtM9uQFOOGpqWjjnJdJRrPWMjb1aDWS8btISwEm80Zs8msPk7/Qb2dh11qpSjvaNwXKIK0zJwi9Z0V6zrZNz+6V7NgPpbKjmWxU+QaY2D9CK3BWlysoVqb8YSISt25p72nB8HzOHJ+sIDeKJI9UIY/vLAgMBAAECgYEAim5IyCdYnZEpN5qyfgK2+FVdHC+kGJ1Fwb541fIGxE+owbNm3JCu4Td5/ZVHtfRFWXoU+HyksbPuoXIdZnQqtWuInNhdPVpiir6/yXSvP5LLfQN6lqkCzapgtuhuz3Cayp58qb0k4ujZ2l5pegNN7a8plqHUSZNoE3VFHMNNTZECQQDYyRm7U+gliPlnO8bpnnU6ciFbiAeXbWS4z+HY2hLHWqFO7U2grBKueJ1yMYDNL8PCGbbyO0bUxDIu07t5KYg1AkEAr9IEzgIYwbCBujRgJ3rj7r5bXsggzTiHLypj+Uvsq0niI2TvHmiYczP0m9lSHmuvZwhcdhd0bufA81Zigi/z/wJBAIcVAGC3Dw/cgzQtjmviXj/WAC0t3TUhaEK03pEmic8JDTzGJ7n3nwhyhgEzEYRJwByBs3rLLv7DZlXBf68nDwUCQHe4mND2mIj7ebqjg34eriqZsHn/6GYVweeaA+1zh7qzWqsjRbf9HSIFFOEywDo6tXuBNAStv/jtEnQgNH/Vy10CQBzWF7XlU9oXiLwoVoe+7JAe7cnfAfG+2nwiuzc0x9oHB1p7rET3u0AMIR6LfC0K2FWheQRYcqsAWyQviIjWa8I=";

//    private static JSONObject createHead() {
//        JSONObject obj = new JSONObject();
//        obj.put("ver", "1.0");// 版本
//        obj.put("curTime", new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
//        obj.put("nonce", new Random().nextInt(10000));// 一个随机数
//        obj.put("sign", md5util.getMD5(privatekey + obj.getString("nonce") + obj.getString("curTime")+da));// 签名
//        obj.put("signType", "MD5");// 签名类型
//        obj.put("appKey", "KCD");// 多盈提供的APPKEY
//        return obj;
//    }

    

  

    private static JSONObject addOne() {
        JSONObject one = new JSONObject();

        one.put("categoryId","SHNJDL");//gems_fs_id
        one.put("categoryName","上海南京东路商铺");   
        one.put("categoryParentId","0");   
        one.put("level","0");   
        


        return one;
    }

    static ExecutorService cachedThreadPool = Executors.newFixedThreadPool(5);


    /**
     * 4.4添加分类信息
     * @return
     */
    
    @RequestMapping(value="findfsdy.do",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String category(){		    	    
    	List<fsdy> fsdy = new ArrayList<fsdy>();
    	fsdy = fsdyService.findfsdy();
    	fsdy fs = new fsdy();
    	List<Map<String,Object>> maplist=new ArrayList<Map<String,Object>>();
    	System.out.println("4.4添加分类信息开始同步");
    	String res = null;
        for(int i=0;i<fsdy.size();i++){        	
        	fs = fsdy.get(i);
        	Map<String,Object> m=new HashMap<String,Object>();
        	m.put("categoryId",fs.getId());
        	m.put("categoryName",fs.getName());  
            m.put("categoryParentId","0");   
            m.put("level","0");
        	maplist.add(m);
        	//System.out.println("第"+i+"次"+m);
        }	

        if(null!=maplist&&maplist.size()>0){
          
	    	int pointsDataLimit =1;//限制条数
	    	Integer size = maplist.size();
	    	//判断是否有必要分批
	    	if(pointsDataLimit<size){
	    	int part = size/pointsDataLimit;//分批数
	    	System.out.println("共有 ： "+size+"条，！"+" 分为 ："+part+"批");
	    	//
	    	for (int i = 0; i < part; i++) {	    		
	    	//100条
	        List<Map<String, Object>> listPage = maplist.subList(0,pointsDataLimit);
//	    	System.out.println(listPage);
	        JSONObject data = new JSONObject();
	        data.put("categoryList",listPage); 
	        JSONObject obj=syncutil.createHead(data);
	        //System.out.println("md5:"+MD5.sign(data.toString(), "UTF-8"));
	        obj.put("data", data);
	        String s=syncjkrxxHttp.dyhttp("http://abs.51duoying.com:8082/ws/services/rest/sys/addCategory", obj.toString());				    	
	        res=res+s.toString();
	        zjfhistory  zh=new zjfhistory();
	        zh.setAddtime(creditutil.time());
	        zh.setUptime(creditutil.time());
	        zh.setCountnum(listPage.size());
            zh.setReturnmsg("");
            zh.setSynpath("http://abs.51duoying.com:8082/ws/services/rest/sys/addCategory");
            zh.setZjfname("多盈");
            zh.setSynrecording(obj.toString());
            zjfhistoryservice.addsynhistory(zh);
	        maplist.subList(0,pointsDataLimit).clear();  
	      // return data.toString();		
	       
	      }
	    if(!maplist.isEmpty()){
	        JSONObject data = new JSONObject();
	        data.put("categoryList",maplist); 
	        JSONObject obj=syncutil.createHead(data);
	        //System.out.println("md5:"+MD5.sign(data.toString(), "UTF-8"));
	        obj.put("data", data);
	        String s=syncjkrxxHttp.dyhttp("http://abs.51duoying.com:8082/ws/services/rest/sys/addCategory", obj.toString());				    		       
	    	res=res+s.toString();
	        zjfhistory  zh=new zjfhistory();
	        zh.setAddtime(creditutil.time());
	        zh.setUptime(creditutil.time());
	        zh.setCountnum(maplist.size());
            zh.setReturnmsg("");
            zh.setSynpath("http://abs.51duoying.com:8082/ws/services/rest/sys/addCategory");
            zh.setZjfname("多盈");
            zh.setSynrecording(obj.toString());
            zjfhistoryservice.addsynhistory(zh);
	    }
	   }else{
	        JSONObject data = new JSONObject();
	        data.put("categoryList",maplist); 
	        JSONObject obj=syncutil.createHead(data);
	        //System.out.println("md5:"+MD5.sign(data.toString(), "UTF-8"));
	        obj.put("data", data);
	        String s=syncjkrxxHttp.dyhttp("http://abs.51duoying.com:8082/ws/services/rest/sys/addCategory", obj.toString());				    		       
	    	res=s.toString();
	        zjfhistory  zh=new zjfhistory();
	        zh.setAddtime(creditutil.time());
	        zh.setUptime(creditutil.time());
	        zh.setCountnum(maplist.size());
            zh.setReturnmsg("");
            zh.setSynpath("http://abs.51duoying.com:8082/ws/services/rest/sys/addCategory");
            zh.setZjfname("多盈");
            zh.setSynrecording(obj.toString());
	   }
	   }else{
	     System.out.println("没有数据!!!");
	     zjfhistory  zh=new zjfhistory();
	     zh.setAddtime(creditutil.time());
	     zh.setUptime(creditutil.time());
	     zh.setCountnum(0);
	     //zh.setReturnmsg(s);
         zh.setSynpath("http://abs.51duoying.com:8082/ws/services/rest/sys/addCategory");
         zh.setZjfname("多盈");
         zh.setSynrecording("没有数据!!!");
         zjfhistoryservice.addsynhistory(zh);
	   }
          return res;

    }

}
