/**
 * @author zyl
 * 还款接口
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
import com.model1.mgcert;
import com.model1.ylds;
import com.model1.ylqy;
import com.service1.duoying.mgcertService;
import com.service1.duoying.yldsService;
import com.service1.duoying.ylqyService;
import com.util.md5util;
import com.util.duoying.syncutil;

@Controller
public class repaymentController {
	
	
	
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
//        obj.put("sign", md5util.getMD5(privatekey + obj.getString("nonce") + obj.getString("curTime")));// 签名
//        obj.put("signType", "MD5");// 签名类型
//        obj.put("appKey", "KCD");// 多盈提供的APPKEY
//        return obj;
//    }
    

 
	@Autowired
	private mgcertService mgcertService;
	
	@Autowired
	private yldsService yldsService;
	
	@Autowired ylqyService ylqyService;
	
	/**
	 * 4.7还款接口
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value="repayment.do",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String repayment() throws ParseException{
		
		List<Map<String,Object>> maplist=new ArrayList<Map<String,Object>>();
		List<ylds> dslist = new ArrayList<ylds>();
		List<mgcert> mglist  = new ArrayList<mgcert>();
		List<ylqy> qylist = new ArrayList<ylqy>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); 
		mglist = mgcertService.findmgcertlist();
		mgcert mg = new mgcert();
		for(int i=0;i<mglist.size();i++){
			mg = mglist.get(i);
			Map<String,Object> map=new HashMap<String,Object>();	
			map.put("loanBaseId", mg.getGems_code());
			

    		String ACCOUNT_NAME = "";
			ACCOUNT_NAME = mg.getC_name().toString();
			System.out.println(ACCOUNT_NAME);
			qylist = ylqyService.findylqybyname(ACCOUNT_NAME);
			ylqy y = new ylqy();
    		for(int j =0;j<qylist.size();j++){
    			y = qylist.get(j);
			map.put("repaymentBank", y.getBANK_NAME());
			
			String ACCOUNT_NO ="";
			ACCOUNT_NO = y.getACCOUNT_NO().toString();
			dslist = yldsService.findyldsbyid(ACCOUNT_NO);
			ylds ds = new ylds();
			for(int a =0; a<dslist.size();a++){
				ds = dslist.get(a);
				int k = ds.getYy_runtag();
				if(k==1){
			    Date hksj=sdf.parse(ds.getYy_dtruntime()); 
				map.put("repaymentDate", ds.getYy_dtruntime().toString().replace(".0",""));
				map.put("repaymentPrincipal", "");
				map.put("repaymentInterest", "");
				map.put("repaymentCost", "");
				map.put("repaymentTotal",ds.getAMOUNT() );
				
				 
				  Date bt=sdf.parse(ds.getYy_dt()); 
				  System.out.println(bt);
				  Date et=sdf.parse(ds.getYy_dtruntime()); 
				  System.out.println(et);
				  if (et.before(bt)){ 
				   //表示bt小于et 
					  map.put("earlyRepay", "是");
				  }else{ 
					  map.put("earlyRepay", "否"); 
				  }
				  map.put("remark", ds.getApi_msg_detail());
				}
			}
			
    		}
			maplist.add(map);
		}
		
		
		    JSONObject data = new JSONObject();
	        data.put("repaymentInfo", maplist); 
	        JSONObject obj=syncutil.createHead(data);
	        obj.put("data", data);
	        String s=syncjkrxxHttp.dyhttp("http://abs.51duoying.com:8082/ws/services/rest/loan/doRepayment", obj.toString());				    	
	        return  s.toString();
		
		
		
	}
	
}
