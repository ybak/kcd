/**
 * @author zyl
 * 放款完成接口
 */

package com.controller.duoying;

import java.text.ParseException;
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
import com.model1.mgcar;
import com.model1.mgcert;
import com.model1.ylqy;
import com.service1.duoying.bankService;
import com.service1.duoying.mgcarService;
import com.service1.duoying.mgcertService;
import com.service1.duoying.ylqyService;
import com.util.md5util;
import com.util.duoying.syncutil;

@Controller
public class disbursementController {
	
	
	
	 private static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCU41GfwgaxN4b5HjL5BcbTPbkBTjhqalo45yXSUaz1jI29Wg1kvG7SEsBJvNGbPJrD5O/0G9nYddaqUo72jcFyiCtMycIvWdFes62Tc/ulezYD6Wyo5lsVPkGmNg/QitwVpcrKFam/GEiErduae9pwfB8zhyfrCA3iiSPVCGP7ywIDAQAB";

	    private static String privatekey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJTjUZ/CBrE3hvkeMvkFxtM9uQFOOGpqWjjnJdJRrPWMjb1aDWS8btISwEm80Zs8msPk7/Qb2dh11qpSjvaNwXKIK0zJwi9Z0V6zrZNz+6V7NgPpbKjmWxU+QaY2D9CK3BWlysoVqb8YSISt25p72nB8HzOHJ+sIDeKJI9UIY/vLAgMBAAECgYEAim5IyCdYnZEpN5qyfgK2+FVdHC+kGJ1Fwb541fIGxE+owbNm3JCu4Td5/ZVHtfRFWXoU+HyksbPuoXIdZnQqtWuInNhdPVpiir6/yXSvP5LLfQN6lqkCzapgtuhuz3Cayp58qb0k4ujZ2l5pegNN7a8plqHUSZNoE3VFHMNNTZECQQDYyRm7U+gliPlnO8bpnnU6ciFbiAeXbWS4z+HY2hLHWqFO7U2grBKueJ1yMYDNL8PCGbbyO0bUxDIu07t5KYg1AkEAr9IEzgIYwbCBujRgJ3rj7r5bXsggzTiHLypj+Uvsq0niI2TvHmiYczP0m9lSHmuvZwhcdhd0bufA81Zigi/z/wJBAIcVAGC3Dw/cgzQtjmviXj/WAC0t3TUhaEK03pEmic8JDTzGJ7n3nwhyhgEzEYRJwByBs3rLLv7DZlXBf68nDwUCQHe4mND2mIj7ebqjg34eriqZsHn/6GYVweeaA+1zh7qzWqsjRbf9HSIFFOEywDo6tXuBNAStv/jtEnQgNH/Vy10CQBzWF7XlU9oXiLwoVoe+7JAe7cnfAfG+2nwiuzc0x9oHB1p7rET3u0AMIR6LfC0K2FWheQRYcqsAWyQviIjWa8I=";

//	    private static JSONObject createHead() {
//	        JSONObject obj = new JSONObject();
//	        obj.put("ver", "1.0");// 版本
//	        obj.put("curTime", new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
//	        obj.put("nonce", new Random().nextInt(10000));// 一个随机数
//	        obj.put("sign", md5util.getMD5(privatekey + obj.getString("nonce") + obj.getString("curTime")));// 签名
//	        obj.put("signType", "MD5");// 签名类型
//	        obj.put("appKey", "KCD");// 多盈提供的APPKEY
//	        return obj;
//	    }

	
	
	@Autowired
	private mgcertService mgcertService;
	
	@Autowired
	private mgcarService mgcarService;
	
	@Autowired
	private ylqyService ylqyService;
	
	@Autowired
	private bankService bankService;
	
	/**
	 *  4.6放款完成接口
	 * 
	 * @return
	 */
	
	@RequestMapping(value="disbursement.do",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	@ResponseBody
	private String disbursement(){
		
		List<ylqy> ylqylist = new ArrayList<ylqy>();
	    List<mgcar> mgcarlist = new ArrayList<>();
	    List<mgcert> mgcertlist = new ArrayList<mgcert>();
	    List<bank> banklist = new ArrayList<bank>();
	    List<Map<String,Object>> maplist=new ArrayList<Map<String,Object>>();
	    mgcertlist = mgcertService.findmgcertlist();
	    mgcert mg = new mgcert();
	    for(int i=0;i<mgcertlist.size();i++){
	    	Map<String,Object> dbm=new HashMap<String,Object>();
	    	mg = mgcertlist.get(i);
	    	dbm.put("loanBaseld", mg.getGems_code());
	    	dbm.put("disbursementPayType", 2);
	    	dbm.put("disbursementAmount", mg.getC_mgprice_result());
	    	
	    	
	    	    Date currentTime = new Date();
	    	    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
	    	    SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    	    Date date;
	    		try {
	    			date = fmt.parse(mg.getDt_fk());
	    		    String dateString = formatter.format(date);			   
	    		    System.out.println(dateString);
	    		    dbm.put("disbursementDate", dateString);
	    		} catch (ParseException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
	    	
	    	
	        String ACCOUNT_NAME = "";
			ACCOUNT_NAME = mg.getC_name().toString();
			System.out.println(ACCOUNT_NAME);
			ylqylist = ylqyService.findylqybyname(ACCOUNT_NAME);
			ylqy y = new ylqy();
			for(int j =0;j<ylqylist.size();j++){
				y = ylqylist.get(j);
				Map<String,Object> oneBank=new HashMap<String,Object>();
			     oneBank.put("bankBranchName", y.getBANK_NAME());// String 分行/开户行名称 name
			     oneBank.put("accountNo", y.getACCOUNT_NO());// String 银行账号 cardunm    				 			  			   
			        String code = "";
					code = y.getBANK_CODE().toString();
					System.out.println(code);
					banklist = bankService.findbankbycode(code);
					bank b = new bank();
				    for(int a=0;a<banklist.size();a++){
					b = banklist.get(a);
					oneBank.put("bankName", b.getName());// 银行名称 bank
					
					dbm.put("disbursementBank", oneBank);
					
		        	
				    }
				    
				    
					 
			}
			maplist.add(dbm);
	  
	    }
		
	
	    
	    

		   JSONObject data = new JSONObject();
	       data.put("disbursementInfo", maplist); 
	       JSONObject obj=syncutil.createHead(data);
	        obj.put("data", data);
	        System.out.println(obj);
	        String s=syncjkrxxHttp.dyhttp("http://abs.51duoying.com:8082/ws/services/rest/loan/doDisbursement", obj.toString());				
	        return s.toString();
  	
		
	}
	
	

}
