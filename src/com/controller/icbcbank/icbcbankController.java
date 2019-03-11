package com.controller.icbcbank;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model1.icbc.erp.PageData;
import com.service1.icbc_banklist.icbc_banklistService;

@Controller
public class icbcbankController {

	@Autowired
	private icbc_banklistService icbc_banklistService;

	/**
	 * 获取icbc 工行银行列表
	 */
	@RequestMapping(value = "erp/geticbc_banklist.do")
	@ResponseBody
	public List<PageData> geticbc_banklist() {
		List<PageData> icbc_bankList = icbc_banklistService.geticbc_banklist();
		return icbc_bankList;
	}

}
