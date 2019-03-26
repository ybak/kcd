package com.controller.erp_icbc.loanAfter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.alibaba.fastjson.JSONObject;
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
public class LoanAddResultController {
	@Autowired
	private LoanOverdueService loanOverdueService;
	@Autowired
	private ClientPaymentService clientPaymentService;
	
	//添加电催记录+拖车未受理
	@RequestMapping("/addPhoneResult.do")
	@ResponseBody
	public String addPhoneResult(
			int type_id,
			int type_status,
			String result_msg,
			int icbc_id,
			int lolId,
			HttpServletRequest request){
		//获取当前操作人信息
		PageData pdsession= (PageData)request.getSession().getAttribute("pd");
		PageData addResult=new PageData();
		addResult.put("qryid",lolId);
		addResult.put("mid_add",pdsession.get("id"));
		addResult.put("mid_edit",pdsession.get("id"));
		addResult.put("icbc_id",icbc_id);
		addResult.put("type_id",type_id);
		addResult.put("type_status",type_status);
		addResult.put("result_msg",result_msg);
		addResult.put("result_value",addResult.toString());
		int b = loanOverdueService.addOperationResult(addResult);//添加记录
		String reuslt = "failure";
		if(b>0){
			reuslt = "successful!";
		}
		//拖车修改状态   //未处理到已处理
		if(type_id==3 && type_status==31){  
			update_wcl_to_ycl(request,lolId,type_id,32); ////修改拖车状态-未受理状态修改成已受理状态
		}
		//拖车修改状态   //失败到核销-未核销（7-71）
		if(type_id==3 && type_status==34){  
			update_wcl_to_ycl(request,lolId,7,71); ////修改拖车状态-失败到核销-未核销（7-71）
		}
		//核销修改状态   //未核销（7-71）到核销（7-72）
		if(type_id==7 && type_status==71){  
			update_wcl_to_ycl(request,lolId,7,72); 
		}
		//诉讼修改状态   //未诉讼（4-41）到诉讼（4-42）
		if(type_id==4 && type_status==41){  
			update_wcl_to_ycl(request,lolId,4,42); 
		}
		//诉讼修改状态   //诉讼（4-42）到诉讼（7-71）
		if(type_id==4 && type_status==42){  
			update_wcl_to_ycl(request,lolId,7,71); 
		}
		return reuslt;
	}
	
	
	//添加拖车已受理记录
	@RequestMapping("/addCarYslResult.do")
	@ResponseBody
	public String addCarYslResult(
			int type_id,
			int type_status,
			String result_msg,
			int icbc_id,
			int lolId,
			int coolStatus,  //拖车受理审批状态
			String coolTime, //拖车时间
			String coolAddress, //拖车地址
			String coolVideo, //拖车视频
			HttpServletRequest request) throws IllegalStateException, IOException{
//		System.err.println(type_id+"-999999999999999");
//		System.err.println(type_status+"-999999999999999");
//		System.err.println(result_msg+"-999999999999999");
//		System.err.println(icbc_id+"-999999999999999");
//		System.err.println(coolTime+"-999999999999999");
//		System.err.println(coolAddress+"-999999999999999");
//		System.err.println(coolStatus+"-999999999999999");
//		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
//		CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest.getFile("coolVideo");
		/*CommonsMultipartFile file = (CommonsMultipartFile) coolVideo;
		String relatDir1 = new SimpleDateFormat("yyyy/MM/dd/").format(new Date());
		// 文件夹不存在则创建
		File fdir = new File("/KCDIMG/assess/upload/" + relatDir1);
		if (!fdir.exists()) {
			fdir.mkdirs();
		}
		String oriName = file.getOriginalFilename();
		File tempFile = new File(fdir.getPath() + "/" + oriName);
		file.transferTo(tempFile);*/
		//获取当前操作人信息
		PageData pdsession= (PageData)request.getSession().getAttribute("pd");
		PageData addResult=new PageData();
		addResult.put("qryid",lolId);
		addResult.put("mid_add",pdsession.get("id"));
		addResult.put("mid_edit",pdsession.get("id"));
		addResult.put("icbc_id",icbc_id);
		addResult.put("type_id",type_id);
		addResult.put("type_status",type_status);
		addResult.put("result_msg",result_msg);
		addResult.put("remark", coolVideo);
		//拖车情况
		addResult.put("coolStatus", coolStatus);
		addResult.put("coolTime", coolTime);
		addResult.put("coolAddress", coolAddress);
		addResult.put("coolVideo", coolVideo);
		addResult.put("result_value",addResult.toString());
		int b = loanOverdueService.addOperationResult(addResult);//添加记录
		String reuslt = "failure";
		if(b>0){
			reuslt = "successful!";
		}
		//拖车已受理在此状态时,修改拖车状态为拖车完成(33)或失败(34)
		update_wcl_to_ycl(request,lolId,type_id,coolStatus);
		return reuslt;
	}
	
	//拖车完成提交记录
	@RequestMapping("/addCarWcResult.do")
	@ResponseBody
	public String addCarWcResult(
			int type_id,
			int type_status,
			String result_msg,
			int icbc_id,
			int lolId,
			int coolStatus,
			HttpServletRequest request){
		//获取当前操作人信息
		PageData pdsession= (PageData)request.getSession().getAttribute("pd");
		PageData addResult=new PageData();
		addResult.put("qryid",lolId);
		addResult.put("mid_add",pdsession.get("id"));
		addResult.put("mid_edit",pdsession.get("id"));
		addResult.put("icbc_id",icbc_id);
		addResult.put("type_id",type_id);
		addResult.put("type_status",type_status);
		addResult.put("result_msg",result_msg);
		//添加记录
		addResult.put("coolStatus",coolStatus);
		addResult.put("result_value",addResult.toString());
		int b = loanOverdueService.addOperationResult(addResult);//添加记录
		String reuslt = "failure";
		if(b>0){
			reuslt = "successful!";
		}
//		int UpTypeId = (type_status==51?5:6);
		int UpTypeId = 0;
		switch (coolStatus) { //前台页面选择的拖车完成-处置结果
		case 51: //拍卖-未拍卖
			UpTypeId=5;
			break;
		case 61: //正常结清
		case 62: //提前结清
		case 63: //结清-强制结清
		case 64: //亏损结清
			UpTypeId=6;
			break;
		case 71: 
			UpTypeId=7;
			break;
		case 41: 
			UpTypeId=4;
			break;
		case 53:
			UpTypeId=5;
			break;
		default:
			break;
		}
		System.err.println(UpTypeId+"---UpTypeId-999999999");
		update_wcl_to_ycl(request,lolId,UpTypeId,coolStatus); //修改拖车状态-拖车完成修改成拍卖（5-51）或者强制结清状态（6-63） 【可参考com.controller.erp_icbc.loanAfter】 
		return reuslt;
	}
	
	
	
	public void update_wcl_to_ycl(HttpServletRequest request,int id,int type_id,int type_status){
		PageData pdsession= (PageData)request.getSession().getAttribute("pd");//获取当前操作人信息
		PageData updateStatus = new PageData();
		updateStatus.put("id",id);
		updateStatus.put("type_id",type_id); // 拖车(type_id=3)
		updateStatus.put("type_status",type_status); // 进入拖车已处理32
		updateStatus.put("mid_edit",pdsession.get("id")); // 修改操作人
		System.err.println(pdsession.get("id")+"-----------");
		int a = loanOverdueService.updateOverdueStatus(updateStatus); // a == 1,修改成功
	}
}
