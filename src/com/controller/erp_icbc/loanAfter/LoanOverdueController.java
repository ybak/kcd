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
 * 客户逾期控制器
 * 
 * @author 三十画生
 * 2019-3-21
 */
@Controller
@RequestMapping("/loan")
public class LoanOverdueController {
	@Autowired
	private LoanOverdueService loanOverdueService;
	
	//查询客户逾期名单
	@RequestMapping("/selectOverdue.do")
	public String select(
			String qn,
			String cn,
			String type,
			String dn,	
			int pagesize,
			int pagenow,
			String param,
			HttpServletRequest request){
		//获取当前操作人信息
		PageData pdsession= (PageData)request.getSession().getAttribute("pd");
		List<PageData> newpdList=new ArrayList<>();
		PageData pd=new PageData();
		pd.put("param",param);
		System.err.println(pdsession.get("icbc_erp_fsid")+"--99999999");
		pd.put("gems_fs_id",pdsession.get("icbc_erp_fsid"));
		List<PageData> pdList=loanOverdueService.selectOverdueList(pd);
		newpdList = limitutil.fy(pdList,pagesize, pagenow);
		int q=pdList.size()%pagesize;
		int totalpage=0;//总页数
		if(q==0){
			totalpage=pdList.size()/pagesize;	    		
		}else{
			totalpage=pdList.size()/pagesize+1;
		} 
		
		request.setAttribute("dn", dn);
		request.setAttribute("cn", cn);
		request.setAttribute("qn", qn);
		request.setAttribute("type", type);	
		request.setAttribute("totalpage",totalpage);
		request.setAttribute("totalsize",pdList.size());
		request.setAttribute("pagesize",pagesize);
		request.setAttribute("pagenow",pagenow);
		request.setAttribute("newpdList", newpdList);
		return "kjs_icbc/index";
	}
	
	//修改客户逾期状态-手动点击进入电催
	@RequestMapping("/updateOverdueStatus.do")
	public String updateOverdueStatus(
			String qn,
			String cn,
			String type,
			String dn,	
			int pagesize,
			int pagenow,
			int id,
			HttpServletRequest request){
		//修改客户逾期状态-手动点击进入电催
		PageData updateStatus = new PageData();
		updateStatus.put("id",id);
		updateStatus.put("type_id","2"); // 进入电催(type_id=2)
		int a = loanOverdueService.updateOverdueStatus(updateStatus); // a == 1,修改成功
		//添加操作记录 start
		PageData pdOne = loanOverdueService.selectOverdueOne(updateStatus);//从loan_overdue_list逾期名单表 获取到要修改某一客户
		PageData pdsession= (PageData)request.getSession().getAttribute("pd");//获取当前操作人信息
		PageData addResult =  AddResult.addResult(pdsession,pdOne);//构造添加信息
		int b = loanOverdueService.addOperationResult(addResult);//添加记录
		//添加操作记录 end
		request.setAttribute("dn", dn);
		request.setAttribute("cn", cn);
		request.setAttribute("qn", qn);
		request.setAttribute("type", type);	
		request.setAttribute("pagesize",pagesize);
		request.setAttribute("pagenow",pagenow);
		return "redirect:/loan/selectOverdue.do?type=khyqmd&dn=loan_overdue&qn=list&pagesize="+pagesize+"&pagenow="+pagenow;
		//return select(qn, cn, type, dn, pagesize, pagenow, "", request);
	}
}
