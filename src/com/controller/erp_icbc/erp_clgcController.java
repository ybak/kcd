package com.controller.erp_icbc;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model1.icbc.erp.PageData;
import com.service1.erp_icbc.erp_wdrwService;
import com.service1.kjs_icbc.newicbc_kkService;
/**
 * erp 处理过程 进度  我的任务
 * @author Administrator
 *
 */
@Controller
public class erp_clgcController {

	
	@Autowired
	 private erp_wdrwService erp_wdrwService;
	
	@RequestMapping(value="erp/erp_clgc.do",produces = "text/html;charset=UTF-8")  
	public String erp_clgc(
			String   dn,
			String   qn,
			String   cn,
			String   type,
			String   icbc_id,
			String   type_id,
			HttpServletRequest request
			){
		
		
		
		return null;
	}
	
	
	@RequestMapping(value="erp/erp_update.do",produces = "text/html;charset=UTF-8")  
	public String erp_update(
			String   dn,
			String   qn,
			String   cn,
			String   type,
			String   icbc_id,
			String   type_id,
			HttpServletRequest request
			){
		PageData sessionpd= (PageData)request.getSession().getAttribute("pd");	
		PageData pdData=new PageData();
		pdData.put("dn",dn);
		if(dn.equals("001")){
			pdData.put("mid_edit",sessionpd.get("id"));
			pdData.put("dt_edit",new Date());
		}
		
		
		return null;
	}
	
	
}
