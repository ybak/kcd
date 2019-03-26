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
import com.service1.loan.ClientPaymentService;
import com.service1.loan.LoanOverdueService;
import com.util.limitutil;

/**
 * 客户电催控制器
 * 
 * @author 三十画生
 * 2019-3-22
 */
@Controller
@RequestMapping("/loan")
public class LoanPhoneController {
	@Autowired
	private LoanOverdueService loanOverdueService;
	@Autowired
	private ClientPaymentService clientPaymentService;
	
	//查询客户电催名单
	@RequestMapping("/selectPhoneList.do")
	public String select(
			String qn,
			String cn,
			String type,
			String dn,	
			int pagesize,
			int pagenow,
			String param,
			int type_id,
			int type_status,
			HttpServletRequest request){
		//获取当前操作人信息
		PageData pdsession= (PageData)request.getSession().getAttribute("pd");
		List<PageData> newpdList=new ArrayList<>();
		PageData pd=new PageData();
		pd.put("param",param);
		System.err.println(pdsession.get("icbc_erp_fsid")+"--99999999");
		pd.put("gems_fs_id",pdsession.get("icbc_erp_fsid"));
		pd.put("type_id",type_id); // 查询贷后大类型  1逾期，2电催，3拖车，4诉讼，5拍卖，6结清
		pd.put("type_status",type_status); // 查询贷后大类型下的小状态  详情见src/com/controller/erp_icbc/loanAfter/AddResult.java
		List<PageData> pdList=loanOverdueService.selectPhoneList(pd);
		newpdList = limitutil.fy(pdList,pagesize,pagenow);
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
	
	//点击电催客户进入详情
	@RequestMapping("/selectPhoneForm.do")
	public String selectPhoneForm(
			String qn,
			String cn,
			String type,
			String dn,	
			String param,
			int id,
			HttpServletRequest request){
		//获取当前操作人信息
		PageData pdsession= (PageData)request.getSession().getAttribute("pd");
		List<PageData> newpdList=new ArrayList<>();
		PageData pd=new PageData();
		pd.put("id",id);
		//查询 客户信息+车辆信息+贷款方案
		PageData CCL = loanOverdueService.selectPhoneClientCarLoanInfo(pd);
		//查询还款计划
		List<PageData> paySchedule = clientPaymentService.selectPaySchedule(CCL.get("icbc_id").toString());
		//查询操作记录
		List<PageData> results = loanOverdueService.selectResults(pd);
		//查询此条逾期名单  用于添加操作记录时使用 type_id、type_status等信息
		PageData pdOne = loanOverdueService.selectOverdueOne(pd);
		request.setAttribute("dn", dn);
		request.setAttribute("cn", cn);
		request.setAttribute("qn", qn);
		request.setAttribute("type",type);	
		request.setAttribute("CCL",CCL);
		request.setAttribute("paySchedule",paySchedule);
		request.setAttribute("results",results);
		request.setAttribute("pdOne",pdOne);
		return "kjs_icbc/index";
	}
	
	
	//申请拖车或者申请诉讼
	@RequestMapping("/updatePhoneStatusToCarOrLitigation.do")
	@ResponseBody
	public String updateOverdueStatus(
			String result_msg,
			int type_id,
			int type_status,
			int icbc_id,
			int lolId,
			HttpServletRequest request){
		PageData pdsession= (PageData)request.getSession().getAttribute("pd");//获取当前操作人信息
		//修改客户逾期状态-手动点击进入电催
		PageData updateStatus = new PageData();
		updateStatus.put("id",lolId);
		updateStatus.put("type_id",type_id); // 进入拖车
		updateStatus.put("type_status",type_status); // 进入拖车未处理
		updateStatus.put("mid_edit",pdsession.get("id")); // 修改操作人
		System.err.println(pdsession.get("id")+"-----------");
		int a = loanOverdueService.updateOverdueStatus(updateStatus); // a == 1,修改成功
		String reuslt = "failure";
		if(a>0){
			reuslt = "successful!";
		}
		//添加操作记录 start
		PageData addResult=new PageData();
		addResult.put("qryid",lolId);
		addResult.put("mid_add",pdsession.get("id"));
		addResult.put("mid_edit",pdsession.get("id"));
		addResult.put("icbc_id",icbc_id);
		addResult.put("type_id",type_id);
		addResult.put("type_status",type_status);
		addResult.put("result_msg",result_msg);
		addResult.put("remark",result_msg);
		int b = loanOverdueService.addOperationResult(addResult);//添加记录
		//添加操作记录 end
		return reuslt;
	}
}
