package com.controller.newAdd;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.model.newAdd.ssm;
import com.service.newAdd.ssmService;
import com.util.creditutil;

@Controller
public class ssmController {
	@Autowired
	private ssmService ssmService;
	// Ìí¼Ó
	@RequestMapping(value="/smmadd.do")
	@ResponseBody
	public void smmadd(HttpServletRequest request,HttpServletResponse response){
		ssm sm = new ssm();
		sm.setDt_add(creditutil.time());
		sm.setDt_edit(creditutil.time());
		sm.setCp(1);
		sm.setMobile("111111");
		sm.setName("Ð¡º«");
		sm.setUpid(0);
		sm.setMid_add(1);
		sm.setMid_edit(2);
		ssmService.addSSM(sm);
	}
}
