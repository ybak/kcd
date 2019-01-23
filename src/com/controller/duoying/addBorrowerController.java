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
import com.model1.ylqy;
import com.service1.duoying.bankService;
import com.service1.duoying.carmodelService;
import com.service1.duoying.mgcarService;
import com.service1.duoying.ylqyService;
import com.util.md5util;
import com.util.duoying.syncutil;


@Controller
public class addBorrowerController {
	
	@Autowired
	private mgcarService mgcarService;
	
	@Autowired
	private bankService bankService;
	
	@Autowired
	private ylqyService ylqyService;
	
	@Autowired
	private carmodelService carmodelService;
	
	

    private static String privatekey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJTjUZ/CBrE3hvkeMvkFxtM9uQFOOGpqWjjnJdJRrPWMjb1aDWS8btISwEm80Zs8msPk7/Qb2dh11qpSjvaNwXKIK0zJwi9Z0V6zrZNz+6V7NgPpbKjmWxU+QaY2D9CK3BWlysoVqb8YSISt25p72nB8HzOHJ+sIDeKJI9UIY/vLAgMBAAECgYEAim5IyCdYnZEpN5qyfgK2+FVdHC+kGJ1Fwb541fIGxE+owbNm3JCu4Td5/ZVHtfRFWXoU+HyksbPuoXIdZnQqtWuInNhdPVpiir6/yXSvP5LLfQN6lqkCzapgtuhuz3Cayp58qb0k4ujZ2l5pegNN7a8plqHUSZNoE3VFHMNNTZECQQDYyRm7U+gliPlnO8bpnnU6ciFbiAeXbWS4z+HY2hLHWqFO7U2grBKueJ1yMYDNL8PCGbbyO0bUxDIu07t5KYg1AkEAr9IEzgIYwbCBujRgJ3rj7r5bXsggzTiHLypj+Uvsq0niI2TvHmiYczP0m9lSHmuvZwhcdhd0bufA81Zigi/z/wJBAIcVAGC3Dw/cgzQtjmviXj/WAC0t3TUhaEK03pEmic8JDTzGJ7n3nwhyhgEzEYRJwByBs3rLLv7DZlXBf68nDwUCQHe4mND2mIj7ebqjg34eriqZsHn/6GYVweeaA+1zh7qzWqsjRbf9HSIFFOEywDo6tXuBNAStv/jtEnQgNH/Vy10CQBzWF7XlU9oXiLwoVoe+7JAe7cnfAfG+2nwiuzc0x9oHB1p7rET3u0AMIR6LfC0K2FWheQRYcqsAWyQviIjWa8I=";

//    private static JSONObject createHead() {
//    	 JSONObject obj = new JSONObject();
//         obj.put("ver", "1.0");// 版本
//         obj.put("curTime", new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
//         obj.put("nonce", new Random().nextInt(10000));// 一个随机数
//         obj.put("sign", md5util.getMD5(privatekey + obj.getString("nonce") + obj.getString("curTime")));// 签名
//         obj.put("signType", "MD5");// 签名类型
//         obj.put("appKey", "KCD");// 多盈提供的APPKEY
//         return obj;
//    }
/**
 * 
 *  押车
 * @return
 * @throws ParseException
 */
	@RequestMapping(value="addbow.do",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String borrower() throws ParseException{   
    	

    	List<Map<String,Object>> banks=new ArrayList<Map<String,Object>>();
    	List<Map<String,Object>> attachment=new ArrayList<Map<String,Object>>();
    	List<Map<String,Object>> maplist=new ArrayList<Map<String,Object>>();
    	
    	
    	    List<ylqy> ylqylist = new ArrayList<ylqy>();
    	    List<bank> banklist = new ArrayList<>();
    	    List<mgcar> mgcarlist = new ArrayList<mgcar>();
    	    mgcarlist = mgcarService.findmgcar();
    	    mgcar mg = new mgcar();
			
		
		    
    	for(int i = 0;i<mgcarlist.size();i++){
    		
    		Map<String,Object> personalBase=new HashMap<String,Object>();
    		Map<String,Object> filetype=new HashMap<String,Object>();
    		Map<String,Object> mgmap=new HashMap<String,Object>();
    		Map<String,Object> personal=new HashMap<String,Object>();
    	
    		
    	    mg = mgcarlist.get(i);
            personalBase.put("borrowerId",mg.getGems_fs_id()+mg.getC_cardno());// 借款人外部唯一ID 此ID不可重复
            //可以使用 加盟店ID+身份证做标识(36位)
            personalBase.put("categoryId",mg.getGems_fs_id());// gems_fs_id 加盟店ID //需要事先同步
            personalBase.put("projectUuid","cd26b0ca-ad0a-4044-95a6-b6cb1b71bbc4");
            personalBase.put("name", mg.getC_name());// c_name
            personalBase.put("formerName", "");//曾用名
            personalBase.put("sex", ""); //
            personalBase.put("birthDate", "");
            personalBase.put("maritalStatus", "");
            personalBase.put("supportCount", "");
            personalBase.put("familyCount", "");
            personalBase.put("educationLevel", "");
            personalBase.put("telephone", "");
            personalBase.put("instantMessaging", "");
            personalBase.put("currentAddress", "");
            personalBase.put("shippingAddress", "");
            personalBase.put("zipCode", "");
            personalBase.put("email", "");
            personalBase.put("arrivalTime", "");
            personalBase.put("householdDegisterType", "");
            //personalBase.put("certificateType", "");
            personalBase.put("certificateValidityDate", "");
            personalBase.put("driverLicense", "");
            personalBase.put("riskAssessment", "");
            personalBase.put("managerId",mg.getGems_id());
            Date currentTime = new Date();
    	    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
    	    SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	    Date date;
    		try {
    			date = fmt.parse(mg.getDt_add());
    		    String dateString = formatter.format(date);			   
    		    System.out.println(dateString);
    		    personalBase.put("assetsStatisticsDate", dateString);
    		} catch (ParseException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
//    		行驶证 imgstep2_4
//    		身份证正面 imgstep2_5
//    		身份证反面 imgstep2_6
//    		放款流水（或银行卡）imgstep2_10
//    		征信报告imgstep2_11
//    		新增行驶证背面  imgstep4_11
//    		住家位置1 imgstep2_14
//    		住家位置2 imgstep2_15
//    		住家环境1 imgstep2_16
//    		住家环境2 imgstep2_17
//    		住家证明 imgstep2_18
//    		身份证 c_cardmo
  
            personalBase.put("remark", "");
            personalBase.put("managerId","");              		    		
    		//personal.put("personalBase",personalBase);
    		 Map<String,Object> xxz=new HashMap<String,Object>();
             xxz.put("fileName", "行驶证");
             xxz.put("fileUrl", mg.getImgstep2_4());
             xxz.put("fileType", "2");
             xxz.put("fileString", "");
             xxz.put("remark", "");
             attachment.add(xxz);
             Map<String,Object> xxz2=new HashMap<String,Object>();
             xxz2.put("fileName", "身份证正面");
             xxz2.put("fileUrl", mg.getImgstep2_5());
             xxz2.put("fileType", "6");
             xxz2.put("fileString", "");
             xxz2.put("remark", "");
             attachment.add(xxz2);
             Map<String,Object> xxz3=new HashMap<String,Object>();
             xxz3.put("fileName", "身份证反面");
             xxz3.put("fileUrl", mg.getImgstep2_6());
             xxz3.put("fileType", "6");
             xxz3.put("fileString", "");
             xxz3.put("remark","");
             attachment.add(xxz3);
             Map<String,Object> xxz4=new HashMap<String,Object>();
             xxz4.put("fileName", "征信报告");
             xxz4.put("fileUrl", mg.getImgstep2_10());
             xxz4.put("fileType", "9");
             xxz4.put("fileString", "");
             xxz4.put("remark", "");
             attachment.add(xxz4);             
             Map<String,Object> xxz5=new HashMap<String,Object>();
             xxz5.put("fileName", "新增行驶证背面");
             xxz5.put("fileUrl", mg.getImgstep2_11());
             xxz5.put("fileType", "2");
             xxz5.put("fileString", "");
             xxz5.put("remark", "");
             attachment.add(xxz5);                 		
    		String ACCOUNT_NAME = "";
			ACCOUNT_NAME = mg.getC_name().toString();
			System.out.println(ACCOUNT_NAME);
			ylqylist = ylqyService.findylqybyname(ACCOUNT_NAME);
			ylqy y = new ylqy();
    		for(int j =0;j<ylqylist.size();j++){
    			y = ylqylist.get(j);
    			Map<String,Object> oneBank=new HashMap<String,Object>();    			 
    			 personalBase.put("mobilePhone", y.getTEL() );// phone
    			 personalBase.put("cityCode", y.getPROVINCE()+y.getCITY());// 所在地区 二级
    			 personalBase.put("certificateType", y.getID_TYPE());// parperstype
    			 personalBase.put("certificateNo", y.getC_cardid());// parpersnum
    		     oneBank.put("bankBranchName", y.getBANK_NAME());// String 分行/开户行名称 name
    		     oneBank.put("accountNo", y.getACCOUNT_NO());// String 银行账号 cardunm     	
    		    // personal.put("personalBase2",personalBase2);    		     
    		    // banks.add(oneBank);    		      		   
    		        String code = "";
    				code = y.getBANK_CODE().toString();
    				System.out.println(code);
    				banklist = bankService.findbankbycode(code);
    				bank b = new bank();
    			    for(int a=0;a<banklist.size();a++){
    				b = banklist.get(a);    			
    				oneBank.put("bankName", b.getName());// 银行名称 bank
    				oneBank.put("remark", "");
    	        	//banks.add(oneBank2);
    				banks.add(oneBank);    	        	
    			    }    			        			        				 
    		}
    		mgmap.put("base", personalBase);    		
        	mgmap.put("attachment", attachment);        	
        	mgmap.put("bank", banks);
        	maplist.add(mgmap);
    		}
    		System.out.println(maplist);    	
        JSONObject data = new JSONObject();
        data.put("personalList", maplist); 
    	JSONObject obj=syncutil.createHead(data);
        obj.put("data", data);
        String s=syncjkrxxHttp.dyhttp("http://abs.51duoying.com:8082/ws/services/rest/borrower/addPersonal", obj.toString());				
    	System.out.println("借款人信息:"+obj);    	    	
        return s.toString();

}
}
