package com.controller.dyapi;
import java.io.IOException;
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
import com.http.dyapi.dyapihttp;
import com.mashape.unirest.http.JsonNode;
import com.model.credit;
import com.model1.fsdy;
import com.model1.mgcert;
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
public class addshdxxController{	
	
	@Autowired
	private mgcarService mgcarService;
	@Autowired
	private com.service1.duoying.mgcertService mgcertservice;
	
	@Autowired
	private bankService bankService;
	
	@Autowired
	private ylqyService ylqyService;
	
	@Autowired
	private carmodelService carmodelService;
	
	@Autowired
	private fsdyService fsdyService;
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
     * 1 多盈添加分类信息
     * @return
     */
    
    @RequestMapping(value="kjs_dyflxxsend.do",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String category(String id,String kjs_type){	
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
    	List<fsdy> fsdy = new ArrayList<fsdy>();
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
        if(mg==null){
			 JSONObject result=new JSONObject();
			 result.put("code","203");
			 result.put("ret", "");
			 result.put("msg", "未找到借款信息");
			 return result.toString();
        }
    	fsdy = fsdyService.findfsdybyid(mg.getGems_fs_id());
    	fsdy fs = new fsdy();
    	List<Map<String,Object>> maplist=new ArrayList<Map<String,Object>>();
    	System.out.println("4.4添加分类信息开始同步");
    	String res=null;
    	if(fsdy!=null){
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
	}else{
		 JSONObject result=new JSONObject();
		 result.put("code","203");
		 result.put("ret", "");
		 result.put("msg", "未找到商户店");
		 return result.toString();
	 }
        JSONObject data = new JSONObject();
        data.put("categoryList",maplist); 
        JSONObject obj=syncutil.createHead(data);
        //System.out.println("md5:"+MD5.sign(data.toString(), "UTF-8"));
        obj.put("data", data);
        String s=null;
        zjfhistory zh=new zjfhistory();
        zh.setAddtime(creditutil.time());
        zh.setUptime(creditutil.time());
        zh.setSynpath("http://abs.51duoying.com:8082/ws/services/rest/sys/addCategory");
        zh.setSynrecording(obj.toString());
        zh.setCountnum(fsdy.size());
        zh.setZjfname("多盈分类");
        zh.setPath_type(1);
        try {			
        s=syncjkrxxHttp.dyhttp("http://abs.51duoying.com:8082/ws/services/rest/sys/addCategory",obj.toString());				    		             
        zh.setReturnmsg(s.toString());
        zh.setSuccessnum(1);        
        zjfhistoryservice.addsynhistory(zh);
        return s;
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
		String id ="549";
		String kjs_type ="9";
		String time =String.valueOf(new Date().getTime());
		String sign;
		sign=MD5.sign(id+time+"kcway","UTF-8");			
		String s = null;
		try {
			s =dyapihttp.kjsjkrxxhttp(id,kjs_type,"http://localhost:8080/kcd/kjs_dyflxxsend.do");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(s);
    }
}
