package com.controller.erp_icbc.TimedTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.model1.icbc.erp.PageData;
import com.service1.erp_icbc.erp_wdrwService;
import com.util.creditutil;
/**
 * 自动任务
 * @author Administrator
 *
 */

@Component
public class timedTaskController {
	@Autowired
	private erp_wdrwService erp_wdrwService;
	 
	@Scheduled(cron = "0 0 1 * * ?") //每天凌晨1点执行
	public void tasktest(){	
		PageData pData=new PageData();
		pData.put("dn", "task01");
		pData.put("operate_id",0);
		erp_wdrwService.update(pData);
		System.out.println("自动执行:"+creditutil.time());
	};
}
