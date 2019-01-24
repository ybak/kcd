///**
// * @author zyl
// * 4.9提交初审结果
// */
//
//package com.controller.duoying;
//
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Random;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.alibaba.fastjson.JSONObject;
//import com.http.duoying.syncjkrxxHttp;
//import com.mashape.unirest.http.JsonNode;
//import com.model1.mgcert;
//import com.service1.duoying.mgcertService;
//import com.util.md5util;
//
//@Controller
//public class approvalLoanInfoController {
//	/**
//     * 以post方式访问
//     * 
//     * @param url
//     *            接口url地址
//     * @param xmlBody
//     *            xml格式的字符串
//     * @return
//     */
//   
//    private static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCU41GfwgaxN4b5HjL5BcbTPbkBTjhqalo45yXSUaz1jI29Wg1kvG7SEsBJvNGbPJrD5O/0G9nYddaqUo72jcFyiCtMycIvWdFes62Tc/ulezYD6Wyo5lsVPkGmNg/QitwVpcrKFam/GEiErduae9pwfB8zhyfrCA3iiSPVCGP7ywIDAQAB";
//
//    private static String privatekey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJTjUZ/CBrE3hvkeMvkFxtM9uQFOOGpqWjjnJdJRrPWMjb1aDWS8btISwEm80Zs8msPk7/Qb2dh11qpSjvaNwXKIK0zJwi9Z0V6zrZNz+6V7NgPpbKjmWxU+QaY2D9CK3BWlysoVqb8YSISt25p72nB8HzOHJ+sIDeKJI9UIY/vLAgMBAAECgYEAim5IyCdYnZEpN5qyfgK2+FVdHC+kGJ1Fwb541fIGxE+owbNm3JCu4Td5/ZVHtfRFWXoU+HyksbPuoXIdZnQqtWuInNhdPVpiir6/yXSvP5LLfQN6lqkCzapgtuhuz3Cayp58qb0k4ujZ2l5pegNN7a8plqHUSZNoE3VFHMNNTZECQQDYyRm7U+gliPlnO8bpnnU6ciFbiAeXbWS4z+HY2hLHWqFO7U2grBKueJ1yMYDNL8PCGbbyO0bUxDIu07t5KYg1AkEAr9IEzgIYwbCBujRgJ3rj7r5bXsggzTiHLypj+Uvsq0niI2TvHmiYczP0m9lSHmuvZwhcdhd0bufA81Zigi/z/wJBAIcVAGC3Dw/cgzQtjmviXj/WAC0t3TUhaEK03pEmic8JDTzGJ7n3nwhyhgEzEYRJwByBs3rLLv7DZlXBf68nDwUCQHe4mND2mIj7ebqjg34eriqZsHn/6GYVweeaA+1zh7qzWqsjRbf9HSIFFOEywDo6tXuBNAStv/jtEnQgNH/Vy10CQBzWF7XlU9oXiLwoVoe+7JAe7cnfAfG+2nwiuzc0x9oHB1p7rET3u0AMIR6LfC0K2FWheQRYcqsAWyQviIjWa8I=";
//
//    private static JSONObject createHead() {
//        JSONObject obj = new JSONObject();
//        obj.put("ver", "1.0");// 版本
//        obj.put("curTime", new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
//        obj.put("nonce", new Random().nextInt(10000));// 一个随机数
//       // obj.put("sign", md5util.getMD5(privatekey + obj.getString("nonce") + obj.getString("curTime")));// 签名
//        obj.put("signType", "MD5");// 签名类型
//        obj.put("appKey", "KCD");// 多盈提供的APPKEY
//        return obj;
//    }
//
//	
//	
//	
//	
//	@Autowired
//	private mgcertService mgcertService;
//	
//	
//	/**
//	 * 4.9提交初审结果
//	 * @return
//	 */
//	@RequestMapping(value="approvalLoanInfo.do",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
//	@ResponseBody
//	public String approvalLoanInfo(){
//	
//		
//    	List<Map<Object,Object>> maplist=new ArrayList<Map<Object,Object>>();
//    	List<mgcert> mgcertlist = new ArrayList<mgcert>();
//    	Map<Object, Object> LoanBase = new HashMap<Object, Object>();
//	    mgcertlist = mgcertService.findmgcertlist();
//	    mgcert mg = new mgcert();
//	    for(int i =0;i<mgcertlist.size();i++){
//	    	mg=mgcertlist.get(i);
//	    
//	    	LoanBase.put("loanBaseId", mg.getGems_code());
//	    	LoanBase.put("approvalAmount", mg.getC_mgprice_result());
//	    	LoanBase.put("approvalRate", mg.getQ_lv());
//	    	int t = mg.getBc_status();
//	    	if(t==5){
//	    	LoanBase.put("result", "1");
//	    	}else{
//	        LoanBase.put("result", "");
//	    	}
//	    	
//	    	
//	    }
//	    maplist.add(LoanBase);
//	    
//	    
//	    
//	       JSONObject data = new JSONObject();
//	        data.put("loanInfoList", maplist); 
//	    	JSONObject obj=createHead();
//	        obj.put("data", data);
//	    	JsonNode s=syncjkrxxHttp.dyhttp("http://abs.51duoying.com:8082/ws/services/rest/loan/doApproval", obj.toString());				    	
//	        return s.toString();
// 	 
//		}
//
//}
