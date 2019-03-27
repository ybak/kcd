package com.controller.erp_icbc.loanAfter;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model1.icbc.erp.PageData;
import com.service1.Repayment.OverdueService;
import com.service1.loan.LoanOverdueService;
import com.util.limitutil;

/**
 * 客户逾期配置
 * 
 * @author 三十画生
 * 2019-3-27
 */
@Controller
@RequestMapping("/loan")
public class LoanConfigController {
	@Autowired
	private LoanOverdueService loanOverdueService;
	
	//查询客户逾期名单
	@RequestMapping("/loanConfig.do")
	@ResponseBody
	public void loanConfig(
			String overdue_one,
			String overdue_two,
			String overdue_three,
			String overdue_to_phone,	
			String overdue_money,
			HttpServletRequest request){
		//获取当前操作人信息
		PageData pdsession= (PageData)request.getSession().getAttribute("pd");
		pdsession.get("icbc_erp_fsid");
		PageData pd=new PageData();
		
		
	}
	
}
