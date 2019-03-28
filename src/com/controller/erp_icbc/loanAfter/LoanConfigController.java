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
import com.util.pagedate;

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
	
	
	//添加或修改配置
	@RequestMapping("/loanConfig.do")
	@ResponseBody
	public String loanConfig(
			String overdue_one,
			String overdue_two,
			String overdue_three,
			String overdue_to_phone,	
			String overdue_money,
			HttpServletRequest request){
		//获取当前操作人信息
		PageData pdsession= (PageData)request.getSession().getAttribute("pd");
		PageData pd=new PageData();
		pd.put("gems_fs_id", pdsession.get("icbc_erp_fsid"));
		//1先查询是否有公司配置信息 ，
		//2如果有展示信息，修改提交保存
		//3如果没有填写信息，提交保存
		PageData getConfig = loanOverdueService.selectConfig(pd);
		System.err.println(getConfig+"---");
		PageData updateConfig = new PageData();
		updateConfig.put("overdue_one",overdue_one);
		updateConfig.put("overdue_two",overdue_two);
		updateConfig.put("overdue_three",overdue_three);
		updateConfig.put("overdue_to_phone",overdue_to_phone);
		updateConfig.put("overdue_money",overdue_money);
		updateConfig.put("gems_fs_id",pdsession.get("icbc_erp_fsid"));
		updateConfig.put("mid_edit",pdsession.get("icbc_erp_fsid"));
		int a = 0;
		if(getConfig==null){ //公司此条配置不存在,就添加
			updateConfig.put("company_name",pdsession.get("fsname"));
			updateConfig.put("mid_add",pdsession.get("icbc_erp_fsid"));
			a = loanOverdueService.addConfig(updateConfig);
		}else{
			a = loanOverdueService.updateConfig(updateConfig);
		}
		String result = "failure";
		if(a > 0){
			result = "successful!";
		}	
		return result;
	}
}
