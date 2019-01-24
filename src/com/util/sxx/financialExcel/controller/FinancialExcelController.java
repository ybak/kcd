package com.util.sxx.financialExcel.controller;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.set.SynchronizedSet;
import org.apache.log4j.chainsaw.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.mapper1.sxx.financialExcel.FinancialExcelMapper;
import com.service1.sxx.FinancialExcelService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/financialExcelController")
public class FinancialExcelController {
	
	@Autowired
	private FinancialExcelService financialExcelService;
	
	String jsonicbc = "";
	//导出字段列表
	String[] QueryField = {"订单提交时间", "订单编号", "放款银行", "产品名称", "合作机构名称", "级别", "业务所在省份", "业务所在城市", "区域经理", "客户姓名", "联系电话"
								, "身份证号码", "车辆类型", "车辆品牌型号", "上牌城市", "购车分期本金", "金融服务费分期本金", "分期本金合计", "分期期限/月", "执行银行利率"
								, "合同本息合计", "客户月还款金额", "市场费率"};
	
	/**
	 * 银行贷款
	 * @param pagesize
	 * @param pagenow
	 * @param dn
	 * @param qn
	 * @param cn
	 * @param type
	 * @param request
	 * @return
	 */
	@RequestMapping("/bankLoan")
	public String BankLoan(
			Integer pagesize,
			Integer pagenow,
			String dn,
			String qn,
			String cn,
			String type,
			HttpServletRequest request
			){
		//机构名称
		List<String> list1 = financialExcelService.FindInstitutionsNameList();
		//银行名称
		List<String> list2 = financialExcelService.FindBankNameList();
	
		request.setAttribute("Institutions", list1);
		request.setAttribute("Bank", list2);
		request.setAttribute("QueryField", QueryField);
		
		request.setAttribute("dn",dn);  
		request.setAttribute("qn",qn);
		request.setAttribute("cn",cn);
		request.setAttribute("type",type);
		
		return "kjs_icbc/index";
	}
	
	/**
	 * 实现财务管理模块银行贷款功能列表中显示具体信息的功能
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/findicbcMapbyid")
	public String FindicbcMapbyid(
			Integer id,
			String dn,
			String qn,
			String cn,
			String type,
			HttpServletRequest request){
		 Map<String, Object> map = financialExcelService.GetLoanInformationbyid(id);
		
		jsonicbc = JSON.toJSONString(map);
		
		//得到需要二次处理的数据
		//1.银行分期本金
		float a = 0;
		BigDecimal bd = null;
		if(null!=map.get("kk_loan_amount_s") && null!=map.get("kk_loan_amount")){
			a = (float)map.get("kk_loan_amount")*10000 + (int)map.get("kk_loan_amount_s");
		}
		//2.合同本息合计
		if(null!=map.get("kk_loan_rate")){
			float b = ((float)map.get("kk_loan_rate")/100 + 1);
			BigDecimal b1 = new BigDecimal(String.valueOf(b));
			BigDecimal b2 = new BigDecimal(String.valueOf(a));
			bd = b1.multiply(b2);
		}
		//3.客户月还款金额
		BigDecimal c = new BigDecimal("0");
		if ((int)map.get("kk_loan_ajqx")!=0 && null!=map.get("kk_loan_ajqx")) {
			BigDecimal c1 = new BigDecimal(String.valueOf(map.get("kk_loan_ajqx")));
			c = bd.divide(c1 , 5, RoundingMode.HALF_UP);
		}
		
		map.put("Principal", a);
		map.put("PrincipalAndInterest", bd);
		map.put("Monthlypayments", c);
		 
		request.setAttribute("icbc_map", map);
		request.setAttribute("icbc_json", jsonicbc);
		
		request.setAttribute("dn",dn);
		request.setAttribute("qn",qn);
		request.setAttribute("cn",cn);
		request.setAttribute("type",type);
		return "kjs_icbc/index";
	}
	
	/**
	 * 实现银行贷款页面导出数据到excel的功能
	 * @return map	导出的结果
	 * @throws Exception
	 */
	@RequestMapping("/financialExportExcel")
	@ResponseBody
	public Map<String, String> FinancialExportExcel(String Institutions, String Bank, String arr) throws Exception{	
		Map<String, String> map = new HashMap<>();
		System.out.println("进入导出方法");
		//导出状态
		String status = "导出成功";
		System.out.println("合作机构和银行名称:"+Institutions+"***"+Bank);//合作机构和银行名称
//		System.out.println(arr.length());			//如果用户没有选择导出字段的话 arr的值为"[]" 长度为2
		
		try {
			//当用户没有选择导出的字段时,查询所有数据并导出
			if(arr.length() == 2){
				//获取数据
				List<Map> list1 = financialExcelService.ExportBuyCarInstallmentExcel(Institutions, Bank);
				List<Map> list2 = financialExcelService.FindBuyCarInstallmentExcelByStatus();
				List<Map> list3 = financialExcelService.FindFirstPaymentDate();
				//创建表并且插入数据
				ExportOperationsExcel.CreateExcel(list1, list2, list3);
			  //当用户选择了需要导出的字段时, 只导出用户选择的字段
			} else {
				//把需要导出字段的json字符串转为list
				JSONArray json = JSONArray.fromObject(arr);
				List<String> jsonlist = json.toList(json);
				
				List<String> fieldName = new ArrayList<>();  //用来存放数据库字段名
				List<Integer> lev2MenuName = new ArrayList<>();  //用来存放用户选择的三级菜单的上级也就是二级菜单在集合中的位置
				List<Integer> lev3MenuName = new ArrayList<>();  //用来存放用户用户选择的三级菜单在集合中的位置
				
				for (int i = 0; i < jsonlist.size(); i++) {
					fieldName.add(jsonlist.get(i).substring(1, jsonlist.get(i).length()-2));  //取得数据库字段名
					lev2MenuName.add(Integer.parseInt( jsonlist.get(i).substring(0, 1) ));  //获取到用户选择的三级菜单的上级也就是二级菜单在集合中的位置
					lev3MenuName.add( Integer.parseInt(jsonlist.get(i).substring(jsonlist.get(i).length()-2, jsonlist.get(i).length())) );  //获取到用户选择的三级菜单在集合中的位置
				}
		
				List<Map> list = financialExcelService.ExportBuyCarInstallmentExcel(Institutions, Bank);
				
				ExportOperationsExcel.CreateExcel(fieldName, lev2MenuName, lev3MenuName, list);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			status = "另一个程序正在使用此文件，进程无法访问";
		} catch (Exception e) {
			e.printStackTrace();
			status = "系统错误,导出失败";
		}
		
		map.put("status", status);
		return map;
	}
	

}
