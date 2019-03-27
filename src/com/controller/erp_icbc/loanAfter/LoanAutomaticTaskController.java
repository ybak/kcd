package com.controller.erp_icbc.loanAfter;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.service1.loan.LoanOverdueService;
import com.util.creditutil;
/**
 * 自动任务
 * 
 * 用于每日凌晨00:00逾期列表客户逾期天数增加一天
 * 
 * @author 三十画生
 * 2019-3-27
 */
@Component
public class LoanAutomaticTaskController {
	private static Logger log = LogManager.getLogger(LoanAutomaticTaskController.class.getName());
	@Autowired
	private LoanOverdueService loanOverdueService;
	 
//	@Scheduled(cron="0/5 * *  * * ? ")   //每5秒执行一次   
	@Scheduled(cron = "0 0 1 * * ?") //每天凌晨1点执行
	public void tasktest(){	
		int counts = loanOverdueService.updateOverdueDay();
		System.out.println("自动执行:"+creditutil.time()+"---"+counts);
		log.info("自动执行:"+creditutil.time()+"---"+counts);
	};
}
