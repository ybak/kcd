package com.controller.GetVerifyToken;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.cloudauth.model.v20171117.GetVerifyTokenRequest;
import com.aliyuncs.cloudauth.model.v20171117.GetVerifyTokenResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

@Controller
public class GetVerifyTokenController {

	
    //获取车牌类型
	 public static String gettokenhttp(
			 String Action,
			 String RegionId,
			 String Biz,
			 String TicketId
			 ){
	        HttpResponse<String> jsonResponse = null;
	        try {
	            jsonResponse = Unirest.get("https://cloudauth.aliyuncs.com")
	            		.header("method", "get")
	            		//.header("accept", "application/json")
	            		//.header("Content-Type","text/html;charset=UTF-8")
	                    //.header("ckey",cKey)
	                    //.routeParam("method", "get")
	                    .queryString("Action",Action)//
	                    .queryString("RegionId",RegionId)//
	                    .queryString("Biz",Biz)//
	                    .queryString("TicketId",TicketId)//
                        .asString();
	            //Unirest.shutdown();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        //System.out.println(jsonResponse.getBody());
	        return jsonResponse.getBody().toString();
	    }
	
	public static void main(String[] args) {
		 String Action="GetVerifyToken";
		 String RegionId="cn-hangzhou";
		 String Biz="RPBasic";
		 String TicketId=UUID.randomUUID().toString();
		 String str= gettokenhttp(Action, RegionId, Biz, TicketId);
		
		System.out.println(str);
	}
	/**
	 * 服务端发起认证请求 获取阿里云token
	 * @return
	 */
	@RequestMapping(value="srrz_gettoken.do",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String srrz_gettoken(
//			String action,
//          String regionId,
//			String biz,
//			String ticketId,
//			String binding,
//			String userData,
//			String AccessKeyID,
//			String AccessKeySecret
			){
		
		// 创建DefaultAcsClient实例并初始化
		DefaultProfile profile = DefaultProfile.getProfile(
		        "cn-hangzhou",             // 默认
		        "LTAIki5jBefeIL2M",         // 您的Access Key ID
		        "EMyHlo5ytQr9B06sjkDZsTHt5HQhlD"
		        );    // 您的Access Key Secret
		IAcsClient client = new DefaultAcsClient(profile);
		String biz = "bizqy"; // 您在控制台上创建的、采用RPBasic认证方案的认证场景标识, 创建方法：https://help.aliyun.com/document_detail/59975.html
		String ticketId = UUID.randomUUID().toString(); // 认证ID, 由使用方指定, 发起不同的认证任务需要更换不同的认证ID
		String token = null; // 认证token, 用来串联认证请求中的各个接口
		//int statusCode = -1; // -1 未认证, 0 认证中, 1 认证通过, 2 认证不通过
		// 1. 服务端发起认证请求, 获取到token
		// GetVerifyToken接口文档：https://help.aliyun.com/document_detail/57050.html
		GetVerifyTokenRequest getVerifyTokenReques=new GetVerifyTokenRequest();
		getVerifyTokenReques.setBiz(biz);
		getVerifyTokenReques.setTicketId(ticketId);
		
		try {
		    GetVerifyTokenResponse response = client.getAcsResponse(getVerifyTokenReques);
		    token = response.getData().getVerifyToken().getToken();
		} catch (ServerException e) {
		    e.printStackTrace();
		} catch (ClientException e) {
		    e.printStackTrace();
		}						
	    return token;
	}
	
	
}
