package com.controller.icbc;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.controller.icbc.util.carsAssess;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.util.Base64Test;
import com.util.jsonutil;

public class bxhttp {
	private final static String cs_URL ="http://dev.taifinance.cn/TaiAPI/api/automobile/VehicleAccidentClaimsInfo";
	private final static String zs_URL ="http://taifinance.cn/TaiAPI/api/automobile/VehicleAccidentClaimsInfo";
	private final static String URL ="http://apitest.kcway.net/carsAssess_1.do";
	
	public static String getapi_bxresult(String date){		
        HttpResponse<String> jsonResponse = null;
        
        try {
            jsonResponse = Unirest.post(URL)
                    .header("Content-Type","application/json;charset=UTF-8")
                    //.header("appKey","6602e77a-c286-a0b9-13a6-287f438b3336")
                    //.header("VIN","LFV3A24G0D3030240")
                    .body(date)
                    .asString();
            //Unirest.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(jsonResponse.getBody());
        return jsonResponse.getBody();
		
	}
	
	public static void main(String[] args) {		
		carsAssess carsAssess=new carsAssess();
		String bString=Base64Test.GetImageStr("C:/Users/Administrator/Desktop/test-idcard.jpg");
		List<String> imgs=new ArrayList<>();
		imgs.add(bString);
		imgs.add(bString);
		imgs.add(bString);
		imgs.add(bString);
		carsAssess.setCkey("759448d52a6b9e07ae1ac24b545edde7");
		carsAssess.setImgs(imgs);
		carsAssess.setMileage("10");
		carsAssess.setQuerytype("0");
		String s1= jsonutil.toJSONString(carsAssess).substring(1,jsonutil.toJSONString(carsAssess).length()-1);
		//String s2= jsonutil.toJSONString(carsAssess);		
		String s= getapi_bxresult(s1);
		System.out.println(s);
	}
}
