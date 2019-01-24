package com.controller.newAdd;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.http.newAdd.CarInsuranceHttp;
import com.model.jbapi.jbzxapiuser;
import com.model.newAdd.queryBx;
import com.model1.carbrand;
import com.service.newAdd.queryBxService;
import com.service.zx.jbzxapiuserService;
import com.service1.car.brandService;
import com.util.Page;
import com.util.creditutil;
import com.util.jsonutil;
import com.util.pagedate;
/**
 * 车辆出险报告
 * @author HZJ
 * 2018年4月19日
 * http://localhost:8080/kcd/CarInsurance.do?appKey=6602e77a-c286-a0b9-13a6-287f438b3336&VIN=LFV3A24G0D3030240&platenumber=沪A632P6
 *  */
@Controller
public class CarInsuranceController {
	@Autowired
	private jbzxapiuserService jbzxapiuserservice;
	@Autowired
	private queryBxService queryBxService;
	@Autowired
	private brandService brandService;
	// 对外 接口
	@RequestMapping(value="CarInsurance.do",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String CarInsurance(
		@RequestParam("appKey") String appKey,
		@RequestParam("VIN") String VIN,
		String platenumber,   		
		HttpServletRequest request) throws IOException{
		//得到用户令牌
		jbzxapiuser ja= jbzxapiuserservice.findapiuserbyappkey(appKey);
		String str = null;
		str= CarInsuranceHttp.CarInsuranceUri(VIN, platenumber,appKey);
		System.err.println(str+"------");
	    JSONObject jb=JSONObject.parseObject(str);
	    System.err.println(appKey);
		JSONObject reslult=new JSONObject(); //自定义返回消息 非接口返回
		if(ja!=null){//存在令牌 
			//账户余额
			BigDecimal balance=new  BigDecimal(ja.getApi_money());//账户余额 
			BigDecimal zero=new  BigDecimal("0");//零
			BigDecimal remain=balance.subtract(new BigDecimal(35));//出险 减去维修保养剩下的金额
			boolean apitype=true; // api类型不等于1的时候或者金额减去35 >= 0 的时候为true
			boolean deductionlogo=true;//扣费标识
			if(ja.getApi_type()!=1){//判断用户的类型
				deductionlogo=false; //不扣费
			}else{ 
				//扣费
				//判断余额
				if(remain.compareTo(zero)==-1){
					//金币不足够
					apitype=false; 
				}
			}
			if(apitype){
				//封装类
				int id = queryBxService.getNewId("assess_querybx","kcdapitest");  // 首先得到主键ID
				queryBx bx=new queryBx();
				bx.setAppkey(appKey);
				bx.setDt_add(creditutil.time());
				bx.setDt_edit(creditutil.time());
				bx.setC_carvin(VIN);
				String sqlGems_code = String.format("BXkcd%07d",id);
				bx.setGems_code(sqlGems_code);  // 订单
				bx.setApi_result(str);  //   泰融API查询保险完整返回信息  
				bx.setApi_msg(jb.getString("resultMsg")); //   API返回提示信息  
				bx.setApi_code(jb.getString("resultCode"));//  api返回代码  
				if(jb.getString("resultCode").equals("0")){ // resultCode 0 代表调用API成功  
					// resultCode 0 代表 API成功赶返回   -- 订单购买成功 resultCode为0的时候才扣款
					if(deductionlogo){
						//更新费用
						ja.setApi_money(remain.toString());
						jbzxapiuserservice.upmoney(ja);
					}
					JSONObject resultData=jb.getJSONObject("resultData");
					JSONObject result=resultData.getJSONObject("result");
					JSONArray carClaimRecords=result.getJSONArray("carClaimRecords");
					List list=jsonutil.toList(carClaimRecords);					
					Map map=(Map) list.get(0);
					String car_name=map.get("vehicleModel").toString().substring(0, 2);
					carbrand carbrand=brandService.findbrandbyname(car_name);
					if(carbrand.getLogo()!=null&&!carbrand.getLogo().equals("")){
					jb.put("logo","http://a.kcway.net/"+carbrand.getLogo());	
					}
					// 3 代表查询完成
					bx.setBc_status(3);   
//					reslult.put("resultCode","0");
//					reslult.put("resultMsg","查询成功");
//			      	reslult.put("success",true);
			      	reslult.put("result",jb);  // 查询成功后把全部数据给对方
				}else{
					// 2 代表正在查询
					bx.setBc_status(2); 
					reslult.put("resultCode",jb.getString("resultCode"));
					reslult.put("resultMsg",jb.getString("resultMsg"));
			      	reslult.put("success",false);
				}
				queryBxService.addBX(bx);
				return reslult.toString();
			}else{
				reslult.put("resultCode","302");
		      	reslult.put("resultMsg","账户余额不足,请充值");
		      	reslult.put("success",false);
		      	return  reslult.toString();
			}
		}else{
	      	reslult.put("resultCode","303");
	      	reslult.put("resultMsg","用户令牌不存在");
	      	reslult.put("success",false);
	      	return  reslult.toString();
		}
	}
	
	// 对内 展示数据
	@RequestMapping(value="showAllBX.do",produces = "text/html;charset=UTF-8")
	public String CarInsurance(HttpServletRequest request,HttpServletResponse response){
		//分页查询
		String size=request.getParameter("size");
	    String pagenow=request.getParameter("pagenow");
	    int s;
	    if(size!=null){
	    	s=Integer.parseInt(size);
	    }else{
	    	s=10;
	    }	
	    int totalCount;
	    Page page;
  		//用于保存查询到的数据
	    List list = new ArrayList();
	    totalCount =queryBxService.BxCounts();
	    if (pagenow!=null) {				
			//System.out.println(0);
			page = new Page(totalCount, Integer.parseInt(pagenow),s);
			list = queryBxService.showBxAndKey(page.getStartPos(),page.getPageSize());	
			
		} else {
			//System.out.println(1);
			page = new Page(totalCount, 1,s);					
			list = queryBxService.showBxAndKey(page.getStartPos(),page.getPageSize());			   
			pagenow = "1";
		}				
		int q=totalCount%s;
    	int w=0;
    	if(q==0){
    		w=totalCount/s;
    	}else{
    		w=totalCount/s+1;
    	}    		
    	request.setAttribute("w",w);
    	request.setAttribute("pagenow",pagenow);
    	request.setAttribute("size",s);
		request.setAttribute("totalCount",totalCount);
		request.setAttribute("list", list);
		return "CarBx";
	}
}
