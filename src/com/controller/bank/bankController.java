package com.controller.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.controller.erp_icbc.Tools;
import com.model1.icbc.erp.PageData;
import com.service1.icbc_banklist.icbc_banklistService;
import com.util.creditutil;

/**
 * 银行相关操作
 * 
 * @author 86176
 *
 */
@Controller
public class bankController {

	@Autowired
	private icbc_banklistService icbc_banklistService;

	/**
	 * 添加银行
	 * 
	 * @param request
	 */
	@RequestMapping(value = "erp/icbc_bank.do", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String icbc_bank(HttpServletRequest request) {
		PageData pData = (PageData) request.getSession().getAttribute("pd");
		Map<String, String> paramemap = Tools.getpostmap(request);
		int fsid = Integer.parseInt(pData.get("icbc_erp_fsid").toString());
		PageData pd = new PageData();
		pd.put("name", paramemap.get("name"));
		pd.put("dt_add", creditutil.time());
		pd.put("dt_edit", creditutil.time());
		pd.put("fsid", fsid);
		pd.put("mid_add", fsid);
		pd.put("mid_edit", fsid);
		pd.put("showtag", 0);
		icbc_banklistService.saveicbc_banklist(pd);
		return "提交成功";
	}

	/**
	 * 获取银行列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "erp/geticbc_banklist.do", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public List<PageData> geticbc_banklist(String zy_bank,
			String icbc_erp_fsid, HttpServletRequest request) {
		// Map<String, String> paramemap = Tools.getpostmap(request);
		// 银行查询
		List<PageData> banklist = new ArrayList<PageData>();
		PageData bank_pd = new PageData();

		if (icbc_erp_fsid.equals("1708")) {
			banklist = icbc_banklistService.geticbc_banklist();
		} else {
			if (zy_bank != null && !zy_bank.equals("")) {
				String[] zy_banks = zy_bank.split("\u0005");
				List idlist = new ArrayList<Integer>();
				for (int i = 0; i < zy_banks.length; i++) {
					if (zy_banks[i] != null && !zy_banks[i].equals("")) {
						idlist.add(zy_banks[i]);
					}
				}
				// System.out.println(idlist + "**********");
				bank_pd.put("status_id", idlist);
				bank_pd.put("fsid", icbc_erp_fsid);
				banklist = icbc_banklistService.geticbc_banklistbyID(bank_pd);
			} else {
				banklist = icbc_banklistService.geticbc_banklist();
			}
			// banklist = icbc_banklistService.geticbc_banklist();
		}
		return banklist;
	}

	/*
	 * public static void main(String[] args) { String[] zy_bank =
	 * "123567891718192021".split("\u0005"); List<Map> idlist = new
	 * ArrayList<Map>(); for (int i = 0; i < zy_bank.length; i++) { Map m = new
	 * HashMap(); if (zy_bank[i] != null && !zy_bank[i].equals("")) {
	 * m.put("id", zy_bank[i]); } idlist.add(m); } System.out.println(idlist +
	 * "**********"); for (Map m : idlist) { System.out.println(m.get("id")); }
	 * }
	 */
}
