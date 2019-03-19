package com.controller.erp_icbc.loanAfter;

import java.util.HashMap;
import java.util.Map;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

public class LoanModel{
	public static Map<Object,String> LoanTypeModel(){
		 Map<Object,String> loanTypeModel=new HashMap<>();
		 //逾期模块
		 loanTypeModel.put("1", "逾期");
		 loanTypeModel.put("11", "初级逾期");
		 loanTypeModel.put("12", "中级逾期");
		 loanTypeModel.put("13", "高级逾期");
		 loanTypeModel.put("2", "电催");
		 loanTypeModel.put("3", "拖车");
		 loanTypeModel.put("4", "诉讼");
		 loanTypeModel.put("5", "拍卖");
		 loanTypeModel.put("6", "结清");
		 return loanTypeModel;	
	}
	
	public static void main(String[] args) {
		String a = LoanModel.LoanTypeModel().get("1");
		System.out.println(a);
	}

}
