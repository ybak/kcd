package com.controller.guaziiapi;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONObject;
import com.model.guazi.GuaziRecords;
import com.model.jbapi.jbzxapiuser;
import com.service.guazi.GuaZiService;
import com.service.zx.jbzxapiuserService;
import com.util.DeductFeeAmountTool;
import com.util.EncryptUtils;
import com.util.creditutil;
/**
 * @author LiWang
 * 2018年5月14日
 */
@Controller
public class GuaZiConteoller {
	private final static  String appkey="kuaijiarenzheng_on";
	private final static String appsecret="5029b62ee218549a921d86b7dd06daf3";
	@Autowired
	private GuaZiService gzs;
	@Autowired
	private jbzxapiuserService jbzxapiuserservice;
	@RequestMapping(value="/getRecords.do",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String Records(String appKey,String vin){
		JSONObject reslult=new JSONObject();//自定义返回消息 非接口返回
		jbzxapiuser ja= jbzxapiuserservice.findapiuserbyappkey(appKey);
		String messages=null;
		int s=0;
		if(ja!=null){//存在令牌 
			if(vin==null){
			  	reslult.put("code","3");
		      	reslult.put("message","vin码为空");
		      	return  reslult.toString();
			}
			//账户余额
			BigDecimal balance=new  BigDecimal(ja.getApi_money());//账户余额
			BigDecimal zero=new  BigDecimal("0");//零
			BigDecimal remain=balance.subtract(new  BigDecimal(DeductFeeAmountTool.MAINTENANCE_ENQUIRY));//减去维修保养剩下的金额
			boolean apitype=true;//api类型不等于1的时候或者金额减去8>=0的时候为true
			boolean deductionlogo=true;//扣费标识
			if(ja.getApi_type()!=1){//判断用户的类型
				deductionlogo=false; //不扣费
			}else{ //扣费
				//判断余额
				if(remain.compareTo(zero)==-1){
					//金币不足够
					apitype=false; 
				}
			}
			if(apitype){
				Map<String, Object> map = new HashMap<>();
				map.put("appkey","kuaijiarenzheng_on");
				map.put("expires",System.currentTimeMillis());
				map.put("nonce",UUID.randomUUID());
				map.put("vin",vin);  
				// LJ8F2D5D5FB023128 // LBETLBFCXFY046265 // LFBGE6063EJG25302
				String signaturn = EncryptUtils.generateSignature(map,"5029b62ee218549a921d86b7dd06daf3");
				try {
					messages=GuaZiWeiBaoUrl(map.get("appkey").toString(), map.get("expires").toString(), map.get("nonce").toString(),signaturn, map.get("vin").toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JSONObject jsonobject=(JSONObject) JSONObject.parse(messages); 
		        if(jsonobject.get("code").toString().equals("0")){//请求成功
		        	String status=jsonobject.getJSONObject("data").get("status").toString();
		        	System.out.println("status:"+status);
		        	if(status.equals("2")){
		        		s=2;
		        		if(deductionlogo){
							//更新费用
							ja.setApi_money(remain.toString());
							jbzxapiuserservice.upmoney(ja);
						}
		        	}else if(status.equals("1")){//准备中
		        		s=1;
		        	}
		        }
			}else{
				reslult.put("code","2");
		      	reslult.put("message","账户余额不足,请充值");
		      	return  reslult.toString();
			}
		}else{
	      	reslult.put("code","1");
	      	reslult.put("message","用户令牌不存在");
	      	return  reslult.toString();
		}
		//无论成功或者失败，保存数据
		GuaziRecords gr=new GuaziRecords();
		String time=creditutil.time(); 
		gr.setGzAddtime(time);
		gr.setGzUptime(time);
		gr.setGzApiuserId(ja.getId());
		gr.setGzMessage(messages);
		gr.setGzStart(s);
		gr.setGzVin(vin);
		gzs.insert(gr);
		return messages;
	}
	public static String GuaZiWeiBaoUrl(
			String appkey,
    		String expires,
    		String nonce,
    		String signature,
    		String vin) throws IOException{
		String url = "http://opendata.guazi.com/oapi/car/data/maintenance/getRecords";
        CloseableHttpClient client = HttpClients.createDefault();
        //输入参数
        HttpUriRequest requestt = RequestBuilder.get()
                .setUri(url)
                .addParameter("appkey", appkey)
                .addParameter("expires", expires)
                .addParameter("nonce", nonce) 
                .addParameter("signature", signature) 
                .addParameter("vin", vin)
                .build();
        CloseableHttpResponse response = client.execute(requestt);
        // 返回调用API结果
        return EntityUtils.toString(response.getEntity());
    }
}
