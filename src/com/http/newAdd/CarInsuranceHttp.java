package com.http.newAdd;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.util.jsonutil;

/*
 * 泰融出险理赔API
 * hzj   2018-4-17
 *  测试url  http://dev.taifinance.cn/TaiAPI/api/automobile/VehicleAccidentClaimsInfo
 *  服务url  http://taifinance.cn/TaiAPI/api/automobile/VehicleAccidentClaimsInfo
 * */
public class CarInsuranceHttp {
	public static String CarInsuranceUri(
			String VIN,
    		String platenumber,
    		String appKey) throws IOException{
		//String url="http://taifinance.cn/TaiAPI/api/automobile/VehicleAccidentClaimsInfo";
		String url="http://taifinance.cn/TaiAPI/api/automobile/VehicleAccidentClaimsInfo";
        CloseableHttpClient client = HttpClients.createDefault();
        //输入参数
        HttpUriRequest requestt = RequestBuilder.post()
                .setUri(url)
                .addParameter("VIN", VIN)////车架号
                .addParameter("platenumber", platenumber)// 车牌号码
                .addParameter("appKey","6602e77a-c286-a0b9-13a6-287f438b3336") // 验证key 值
                .build();
        CloseableHttpResponse response = client.execute(requestt);
        // 返回调用API结果
        return EntityUtils.toString(response.getEntity());
    }	
	
	public static void main(String[] args) throws IOException {
		String appKey="6602e77a-c286-a0b9-13a6-287f438b3336";
		String VIN = "LFV3A24G0D3030240";
		String platenumber ="";
		String str = CarInsuranceUri(VIN,platenumber,appKey);
		JSONObject jb=JSONObject.parseObject(str);
		JSONObject resultData=jb.getJSONObject("resultData");
		JSONObject result=resultData.getJSONObject("result");
		JSONArray carClaimRecords=result.getJSONArray("carClaimRecords");
		System.out.println(str);
		List list=jsonutil.toList(carClaimRecords);
		for(int i=0;i<list.size();i++){
			Map map=(Map) list.get(i);
			System.out.println(map.get("vehicleModel").toString().substring(0, 2));
			
		}
		
	}
	
}