package com.controller.icbc.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service1.car.icbc_carsService;
import com.service1.kjs_icbc.icbc_dkService;
import com.service1.kjs_icbc.icbc_mqService;
import com.service1.kjs_icbc.newicbcService;
import com.service1.kjs_icbc.newicbc_kkService;

//删除操作
@Controller
public class delController {
   
	 @Autowired
	 private newicbc_kkService newicbc_kkService;//开卡
	 
	 @Autowired
	 private newicbcService newicbcService;//主订单 征信
	 
	 @Autowired
	 private icbc_mqService  icbc_mqService;//面签
	 
	 @Autowired
	 private icbc_dkService  icbc_dkService;//贷款
	 
	 @Autowired
	 private  icbc_carsService icbc_carsService;//评估
	
	@RequestMapping(value="/del_icbc.do",produces="text/html;charset=UTF-8")	
	@ResponseBody
	public void del_icbc(int icbc_id){
		//删除征信数据
		newicbcService.del_icbc(icbc_id);
		//删除开卡信息
		newicbc_kkService.del_icbc_kk(icbc_id);
		//删除面签信息
		icbc_mqService.del_icbc_mq(icbc_id);
		//删除贷款信息
		icbc_dkService.del_icbc_dk(icbc_id);
		//删除评估信息
		icbc_carsService.del_icbc_cars(icbc_id);

	}
	
}
