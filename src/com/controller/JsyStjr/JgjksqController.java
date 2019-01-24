package com.controller.JsyStjr;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.model1.mgcert;
import com.model1.ylqy;
import com.service1.duoying.bankService;
import com.service1.duoying.carmodelService;
import com.service1.duoying.mgcertService;
import com.service1.duoying.ylqyService;
import com.service1.jsy.jsyylqyService;
import com.util.jsy.BysfFind;

@Controller
public class JgjksqController {

	@Autowired
	private mgcertService mgcertservice;
	
	@Autowired
	private bankService bankservice;
	
	@Autowired
	private jsyylqyService jsyylqyservice;
	
	@Autowired
	private carmodelService carmodelservice;
	
//	申请金额	    apply_amount	String	必须	借款申请金额
//	借款申请ID	    apply_id	String	必须	商家自定义借款申请唯一标识
//	产品名称	    product_name	String	必须	借款申请的产品名称
//	申请期限（天）	apply_limit_d	String	可选	当申请期限（月）为空时，必须有值
//	申请期限（月）	apply_limit_m	String	可选	当申请期限（天）为空时，必须有值
//	省份	        province	String	必须	借款人所在省份名称
//	借款人类型	    debtor_type	String	必须	借款人类型，01：个人用户，02：企业用户
//	借款人姓名	    debtor_name	String	可选	当借款人类型为01时，必填
//	借款人手机号	debtor_tel	String	可选	当借款人类型为01时，必填
//	借款人身份证号	debtor_idcard	String	可选	当借款人类型为01时，必填
//	借款属性集合	pros	String数组	可选	借款属性集合，集合内的key根据产品配置
//	征信信息集合	credit_info	String数组	可选	借款人征信信息集合，集合内的key根据产品配置
//	附件资料集合	files	String数组	可选	借款人附件资料集合，集合内的key根据产品配置
//	贷款信息集合	org_loan_info	String数组	可选	借款人贷款信息集合，集合内的key根据产品配置
//	合同信息集合	contracts	String数组	可选	合同信息集合，集合内的key根据产品配置

	@RequestMapping(value="/jgjk.do",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String jgjk(){
         List<mgcert> ml=mgcertservice.csmgcert();
         if(ml!=null){
        	 for(mgcert m : ml){
        		    JSONObject  jb=new JSONObject();		
        			jb.put("apply_amount",m.getC_mgprice());//借款申请金额
        			jb.put("apply_id",m.getGems_code());//商家自定义借款申请唯一标识	
        			jb.put("product_name","");//借款申请的产品名称    押车，押证，押新车
        			jb.put("apply_limit_d", "");//当申请期限（月）为空时，必须有值
        			jb.put("apply_limit_m",m.getC_mgdays());//当申请期限（天）为空时，必须有值
        			if(m.getC_cardno()!=null&&!m.getC_cardno().equals("")){
        				String szsf=BysfFind.getProvinceByIdCard(m.getC_cardno());//所在省份
            			jb.put("province",szsf);//借款人所在省份名称				
        			}
        			
        			jb.put("debtor_type", "01");//借款人类型，01：个人用户，02：企业用户
        			jb.put("debtor_name",m.getC_name());//当借款人类型为01时，必填
        		    ylqy y= jsyylqyservice.findylqybycardid(m.getC_cardno());
        		    if(y!=null&&!y.equals("")){
        		    	jb.put("debtor_tel",y.getTEL());//当借款人类型为01时，必填	
        		    }
        			jb.put("debtor_idcard",m.getC_cardno());//当借款人类型为01时，必填
        			
        		     JSONObject  pros=new JSONObject();
        		     JSONObject  credit_info=new JSONObject();
        		     JSONObject  files=new JSONObject();
        		     JSONObject  org_loan_info=new JSONObject();
        		     JSONObject  contracts=new JSONObject();
        		     pros.put("","");//借款人籍贯
        		     pros.put("","");//借款人性别
        		     pros.put("","");//借款人学历
        		     pros.put("","");//借款人所在省
        		     pros.put("","");//借款人门店名称
        		     pros.put("","");//借款人常驻/自治区/直辖市及市
        		     pros.put("","");//借款人常驻地址
        		     pros.put("","");//担保人姓名
        		     pros.put("","");//担保人联系方式
        		     pros.put("","");//担保人关系
        		     pros.put("","");//工作单位名称
        		     pros.put("","");//配偶身份证
        		     pros.put("","");//配偶联系方式
        		     pros.put("","");//申请贷款日期
        		     pros.put("","");//车辆评估价格
        		     pros.put("","");//产品名称
        		     pros.put("","");//品牌车型
        		     pros.put("","");//车辆类型
        		     pros.put("","");//VIN码
        		     pros.put("","");//发动机号
        		     pros.put("","");//借款方式
        			 jb.put("pros",pros);//借款属性集合
        			 jb.put("credit_info",credit_info);//借款属性集合，集合内的key根据产品配置
        			 jb.put("files",files);//借款属性集合，集合内的key根据产品配置
        			 jb.put("org_loan_info",org_loan_info);//借款人贷款信息集合，集合内的key根据产品配置
        			 jb.put("contracts",contracts);//合同信息集合，集合内的key根据产品配置 
        	         
        	 
        	 
        	 
        	 }
         }
		
		
		
		
		
		
		
		
		
		
		
		return null;
		
		
		
		
		
		
		
	}
	
	
	
}
