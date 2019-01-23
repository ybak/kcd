package com.sched;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.http.duoying.syncjkrxxHttp;
import com.model1.fsdy;
import com.model1.mgcert;
import com.model1.zjf.zjferrmsg;
import com.model1.zjf.zjfhistory;
import com.service1.duoying.bankService;
import com.service1.duoying.carmodelService;
import com.service1.duoying.fsdyService;
import com.service1.duoying.mgcarService;
import com.service1.duoying.mgcertService;
import com.service1.duoying.ylqyService;
import com.service1.zjf.zjferrmsgService;
import com.service1.zjf.zjfhistoryService;
import com.util.creditutil;
import com.util.md5util;
import com.util.duoying.syncutil;

@Controller
public class duoyingJob {

	
	@Autowired
	private mgcarService mgcarService;
	
	@Autowired
	private bankService bankService;
	
	@Autowired
	private ylqyService ylqyService;
	
	@Autowired
	private carmodelService carmodelService;
	@Autowired
	private zjferrmsgService zjferrmsgservice;
	@Autowired
	private fsdyService fsdyService;
	@Autowired
	private mgcertService mgcertservice;
    @Autowired
    private zjfhistoryService zjfhistoryservice;
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

    private static JSONObject createHead() {
        JSONObject obj = new JSONObject();
        obj.put("ver", "1.0");// 版本
        obj.put("curTime", new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        obj.put("nonce", new Random().nextInt(10000));// 一个随机数
        obj.put("sign", md5util.getMD5(privatekey + obj.getString("nonce") + obj.getString("curTime"),"UTF-8"));// 签名
        obj.put("signType", "MD5");// 签名类型
        obj.put("appKey", "KCD");// 多盈提供的APPKEY
        return obj;
    }

    

  

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
	public void category(){		    	    
    	List<fsdy> fsdy = new ArrayList<fsdy>();
    	fsdy = fsdyService.findfsdy();
    	fsdy fs = new fsdy();
    	List<Map<String,Object>> maplist=new ArrayList<Map<String,Object>>();
        for(int i=0;i<fsdy.size();i++){        	
        	fs = fsdy.get(i);
        	Map<String,Object> m=new HashMap<String,Object>();
        	m.put("categoryId",fs.getId());
        	m.put("categoryName",fs.getName());  
            m.put("categoryParentId","0");   
            m.put("level","0");
        	maplist.add(m);	
        	zjfhistory zh=new zjfhistory();
        	zh.setAddtime(creditutil.time());
        	zh.setUptime(creditutil.time());
        	zh.setReturnmsg("1111111111");
        	zh.setSuccessnum(1);
        	zh.setSynrecording("sssssss");
        	zjfhistoryservice.addsynhistory(zh);
        	//System.out.println(m);                	
        }	        
		    JSONObject data = new JSONObject();
	        data.put("categoryList", maplist); 
	    	JSONObject obj=createHead();
	        obj.put("data", data);
	    	//JsonNode s=syncjkrxxHttp.dyhttp("http://abs.51duoying.com:8082/ws/services/rest/sys/addCategory", obj.toString());				    	
	        System.out.println("多盈4.4同步分类:"+obj.toString());

    }
	/**
	 * 3.10查询终审结果
	 */
	public void findzs(){
		List<String> idList=new ArrayList<>();
		List<mgcert> mglist=new ArrayList<mgcert>();
		String  kjs_type="9";
        if(kjs_type.equals("8")){
        	mglist=mgcertservice.carlist(2);
        	if(mglist!=null&&mglist.size()>0){
        	for(int i=0;i<mglist.size();i++){
        		mgcert mg=new mgcert();
        		mg=mglist.get(i);
        		idList.add(mg.getGems_code()+"|mgcar|"+mg.getSpcount());
        	}    		
    	    }
        }
        if(kjs_type.equals("9")){
        	mglist=mgcertservice.certlist(2);
        	if(mglist!=null&&mglist.size()>0){
        	for(int i=0;i<mglist.size();i++){
        		mgcert mg=new mgcert();
        		mg=mglist.get(i);
        		idList.add(mg.getGems_code()+"|mgcert|"+mg.getSpcount());
        	}    		
    	}
        }
        if(kjs_type.equals("10")){
        	mglist=mgcertservice.newcarlist(2);
        	if(mglist!=null&&mglist.size()>0){
        	for(int i=0;i<mglist.size();i++){
        		mgcert mg=new mgcert();
        		mg=mglist.get(i);
        		idList.add(mg.getGems_code()+"|mgnewcar|"+mg.getSpcount());
        	}
        	}
        }        
         JSONObject data=new JSONObject();
		 data.put("idList",idList);
		 JSONObject obj=syncutil.createHead(data);
		 obj.put("data", data);
	        zjfhistory zh=new zjfhistory();
	        zh.setAddtime(creditutil.time());
	        zh.setUptime(creditutil.time());
	        zh.setSynpath("http://abs.51duoying.com:8082/ws/services/rest/loan/doApproval");
	        zh.setSynrecording(obj.toString());
	        zh.setCountnum(idList.size());
	        zh.setZjfname("多盈终审结果");
	        zh.setPath_type(5);
		 try {
			 String s=syncjkrxxHttp.dyhttp("http://abs.51duoying.com:8082/ws/services/rest/loan/queryApprovalResult",obj.toString());  			 		    			 
	         zh.setReturnmsg(s.toString());
	         zh.setSuccessnum(1);  
			 zjfhistoryservice.addsynhistory(zh);
			 JSONObject result=JSONObject.parseObject(s);
		    	if(result.getString("code").equals("200")){			    		
		    		JSONObject ret=JSONObject.parseObject(result.getString("ret"));
		            String[] successIds=ret.getString("successIds").replace(" ","").replace("[","").replace("]","").split(",");
		    	  if(successIds[0]!=null&&!successIds[0].equals("")){
		    		  System.out.println("多盈终审查询(成功订单)");
		    		 for(int i=0;i<successIds.length;i++){		    			 
		    			 if(kjs_type.equals("8")){
			    			 mgcert mc=mgcertservice.findcar(successIds[i].substring(1,successIds[i].indexOf("|")));		    			 
			    			 if(!mc.getZjf_type().equals("3")){
			    				 mgcert c=new mgcert();
			    				 c.setZjf_type("3");
			    				 //c.setSpcount(0);
			    				 c.setId(mc.getId());
			    				 mgcertservice.upmgcar(c);
			    			System.out.println("审核成功订单id:"+successIds[i].substring(1,successIds[i].indexOf("|")));
			    			 } 
		    			 }
		    			 if(kjs_type.equals("9")){
			    			 mgcert mc=mgcertservice.findcert(successIds[i].substring(1,successIds[i].indexOf("|")));		    			 
			    			 if(!mc.getZjf_type().equals("3")){
			    				 mgcert c=new mgcert();
			    				 c.setZjf_type("3");
			    				 //c.setSpcount(0);
			    				 c.setId(mc.getId());
			    				 mgcertservice.upmgcert(c);
			    			System.out.println("审核成功订单id:"+successIds[i].substring(1,successIds[i].indexOf("|")));		 
			    			 } 
		    			 }
		    			 if(kjs_type.equals("10")){
			    			 mgcert mc=mgcertservice.findnewcar(successIds[i].substring(1,successIds[i].indexOf("|")));		    			 
			    			 if(!mc.getZjf_type().equals("3")){
			    				 mgcert c=new mgcert();
			    				 c.setZjf_type("3");
			    				 //c.setSpcount(0);
			    				 c.setId(mc.getId());
			    				 mgcertservice.upmgnewcar(c);
			    		   System.out.println("审核成功订单id:"+successIds[i].substring(1,successIds[i].indexOf("|")));	 
			    			 }
		    			 }
		    			 System.out.println("成功订单:"+successIds[i]); 
		    		}
		    	  } 
		    	  String failIds=ret.getString("failIds").replace("{","").replace("}","");
		    	  if(failIds!=null&&!failIds.equals("")){
		    		  System.out.println("多盈终审查询(失败订单):"+failIds);
		    			Map m=JSONObject.parseObject(ret.getString("failIds"));
		    			Iterator<Entry<String, String>> iter =m.entrySet().iterator();
		    			Entry<String, String> entry;
		    			while(iter.hasNext()){
		    				 entry = iter.next();
		    				 String  key = entry.getKey();
		    				 //String  value = entry.getValue();
		    				 
		    			     //System.out.println(key.substring(0,key.indexOf("|")));		    			     
		    			     //System.out.println(value); 
			    			 if(kjs_type.equals("8")){
				    			 mgcert mc=mgcertservice.findcar(key.substring(0,key.indexOf("|")));		    			 
				    				 mgcert c=new mgcert();
				    				 c.setZjf_type("4");
				    				 int spcs=Integer.parseInt(mc.getSpcount());
				    				 c.setSpcount(String.valueOf(spcs+1));
				    				 c.setId(mc.getId());
				    				 mgcertservice.upmgcar(c);
				    			System.out.println("审核成功订单id:"+key.substring(0,key.indexOf("|")));
				    			  zjferrmsg errmsg=new zjferrmsg();
				    			  errmsg.setAddtime(creditutil.time());
				    			  errmsg.setUptime(creditutil.time());
				    			  errmsg.setFailIds(key+":"+m.get(key).toString());
				    			  errmsg.setGems_code(key.substring(0,key.indexOf("|")));
				    			  errmsg.setKjs_type(8);
				    			  errmsg.setMsg(m.get(key).toString());
				    			  zjferrmsgservice.savezjferrmsg(errmsg);
			    			 }
			    			 if(kjs_type.equals("9")){
				    			 mgcert mc=mgcertservice.findcert(key.substring(0,key.indexOf("|")));		    			 
				    				 mgcert c=new mgcert();
				    				 c.setZjf_type("4");
				    				 int spcs=Integer.parseInt(mc.getSpcount());
				    				 c.setSpcount(String.valueOf(spcs+1));
				    				 c.setId(mc.getId());
				    				 mgcertservice.upmgcert(c);
				    			System.out.println("审核成功订单id:"+key.substring(0,key.indexOf("|")));		 
				    			  zjferrmsg errmsg=new zjferrmsg();
				    			  errmsg.setAddtime(creditutil.time());
				    			  errmsg.setUptime(creditutil.time());
				    			  errmsg.setFailIds(key+":"+m.get(key).toString());
				    			  errmsg.setGems_code(key.substring(0,key.indexOf("|")));
				    			  errmsg.setKjs_type(9);
				    			  errmsg.setMsg(m.get(key).toString());
				    			  zjferrmsgservice.savezjferrmsg(errmsg);
			    			 }
			    			 if(kjs_type.equals("10")){
				    			 mgcert mc=mgcertservice.findnewcar(key.substring(0,key.indexOf("|")));		    			 
				    				 mgcert c=new mgcert();
				    				 c.setZjf_type("4");
				    				 int spcs=Integer.parseInt(mc.getSpcount());
				    				 c.setSpcount(String.valueOf(spcs+1));
				    				 c.setId(mc.getId());
				    				 mgcertservice.upmgnewcar(c);
				    		    System.out.println("审核成功订单id:"+key.substring(0,key.indexOf("|")));	 
				    			  zjferrmsg errmsg=new zjferrmsg();
				    			  errmsg.setAddtime(creditutil.time());
				    			  errmsg.setUptime(creditutil.time());
				    			  errmsg.setFailIds(key+":"+m.get(key).toString());
				    			  errmsg.setGems_code(key.substring(0,key.indexOf("|")));
				    			  errmsg.setKjs_type(10);
				    			  errmsg.setMsg(m.get(key).toString());
				    			  zjferrmsgservice.savezjferrmsg(errmsg);
			    			 }
		    			}
		    	  }
		    	}			 		 
		 } catch (Exception e) {
				 JSONObject result=new JSONObject();
				 result.put("code","201");
				 result.put("ret", "");
				 result.put("msg", "同步失败-"+e);
			     zh.setReturnmsg(result.toString());
			     zjfhistoryservice.addsynhistory(zh); 		
		}		 
	}
	
	public static void main(String[] args) {
		List l1=new ArrayList<>();
		List l2=new ArrayList<>();
		List l3=new ArrayList<>();
		List lall=new ArrayList<>();
		for(int i=0;i<10;i++){
			l1.add(i+"|mgcert");
			l2.add(i+"|mgcar");
			l3.add(i+"|mgnewcar");
		}
		lall.addAll(l1);
		lall.addAll(l2);
		lall.addAll(l3);
		for(int j=0;j<lall.size();j++){
		System.out.println(lall.get(j));
		}
	}
	
}
