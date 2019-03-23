package com.controller.api;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.controller.data.TtMap;
import com.controller.erp_icbc.Tools;
import com.model.icbc.icbc;
import com.model1.icbc.erp.PageData;
import com.service1.kjs_icbc.newicbcService;
import com.util.creditutil;

@Controller
public class icbczx_dsjController {
	public final static String merchantNo = "QDS04477";
	public final static String loginId = "kuaichedao";
	public final static String accessKey = "5D883646019F232F9E528D21C0E4C353";
	public final static String shopNumber = "QDS04477";
	public final static String url = "https://www.qhrtcb.com/hbservice/risk/bodyguard";
	@Autowired
	private newicbcService newicbcService;
	@Autowired
	private com.service1.erp_icbc.icbc_dsjService icbc_dsjService;

	/*
	 * 'merchantNo' => 'QDS00859', 'loginId' => 'jinyuanbaotest', 'accessKey' =>
	 * '30378115019385C7CA422171156073D1', 'shopNumber' => 'QDS00908',
	 * 'merchantNo' => 'QDS04477', 'loginId' => 'kuaichedao', 'accessKey' =>
	 * '5D883646019F232F9E528D21C0E4C353', 'shopNumber' => 'QDS04477',
	 */
	// $url = "http://47.101.136.207:8080/hbservice/risk/bodyguard";
	// $url = "https://www.qhrtcb.com/hbservice/risk/bodyguard";
	// 测试数据：
	// 皮晴晴
	// 13333333333
	// 330105196602220623
	public static String getdsjzxhttp(Map<String, Object> map)
			throws UnsupportedEncodingException {

		TtMap headers = new TtMap();
		headers.put("Content-Type", "application/x-www-form-urlencoded");
		map.put("merchantNo", merchantNo);
		map.put("loginId", loginId);
		map.put("accessKey", accessKey);
		map.put("shopNumber", shopNumber);
		// map.put("requestId",
		// getnewstr(UUID.randomUUID().toString().replaceAll("-", "")));
		// map.put("accountName", "皮晴晴");
		// map.put("accountMobile", "13333333333");
		// map.put("idNumber", "330105196602220623");
		String mpstr = HttpTools.httpClientPost(url, map, "UTF-8", headers);
		// mpstr = new String(mpstr.getBytes("GBK"), "ISO-8859-1");
		// mpstr = new String(mpstr.getBytes("ISO-8859-1"), "UTF-8");
		// System.out.println(mpstr);
		return mpstr;
	}

	/**
	 * 字符串去重
	 * 
	 * @param args
	 */

	public static String getnewstr(String str) {
		String s = ""; // 新建一个数组保存字符
		// String str = UUID.randomUUID().toString().replaceAll("-", "");
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i); // 取出字符串中的字符数
			if (s.indexOf(c) == -1) { // 判断新建数组中是否含有某个字符
				s += c;
			}
		}
		System.out.println(s);
		return s;
	}

	@RequestMapping(value = "erp/getxdfx_dsjzx.do", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getxdfx_dsjzx(HttpServletRequest request) {
		Map<String, String> paramemap = Tools.getpostmap(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("requestId", UUID.randomUUID().toString().replaceAll("-", ""));
		map.put("accountName", paramemap.get("name"));
		map.put("accountMobile", paramemap.get("mobileNo"));
		map.put("idNumber", paramemap.get("idCardNo"));
		icbc icbc = new icbc();
		String result = "";
		try {
			String report_id = "";
			result = getdsjzxhttp(map);
			// result = new String(result.getBytes("GBK"), "ISO-8859-1");
			// result = new String(result.getBytes("ISO-8859-1"), "UTF-8");
			JSONObject resjJsonObject = JSONObject.parseObject(result);
			if (resjJsonObject.get("status") != null
					&& !resjJsonObject.get("status").equals("")) {
				JSONObject status = JSONObject.parseObject(resjJsonObject
						.getString("status"));
				if (status.get("responseCode").equals("0000")) {
					report_id = status.getString("requestId");
				} else {
					report_id = "";
				}
			}
			PageData pd = new PageData();
			PageData dsjpd = new PageData();
			icbc.setId(Integer.parseInt(paramemap.get("id")));
			switch (paramemap.get("dsj_type")) {
			case "1":
				dsjpd.put("result1", result);
				// icbc.setDsj_result(result);
				icbc.setDsj_report_id(report_id);
				icbc.setDsj_result_time(creditutil.time());
				break;
			case "2":
				dsjpd.put("result2", result);
				icbc.setPo_dsj_report_id(report_id);
				// icbc.setPo_dsj_result(result);
				break;
			case "3":
				dsjpd.put("result3", result);
				icbc.setGjr_dsj_report_id1(report_id);
				// icbc.setGjr_dsj_result1(result);
			case "4":
				dsjpd.put("result4", result);
				icbc.setGjr_dsj_report_id2(report_id);
				// icbc.setGjr_dsj_result2(result);
				break;
			}
			newicbcService.upicbc(icbc);

			pd.put("icbc_id", Integer.parseInt(paramemap.get("id")));
			PageData dsj = icbc_dsjService.findbyid(pd);
			if (dsj != null && !dsj.equals("")) {
				dsjpd.put("dt_edit", creditutil.time());
				dsjpd.put("dt_add", creditutil.time());
				dsjpd.put("icbc_id", Integer.parseInt(paramemap.get("id")));
				dsjpd.put("id", dsj.get("id"));
				icbc_dsjService.upkjs_icbc_dsj(dsjpd);
			} else {
				dsjpd.put("dt_edit", creditutil.time());
				dsjpd.put("dt_add", creditutil.time());
				dsjpd.put("icbc_id", Integer.parseInt(paramemap.get("id")));
				icbc_dsjService.savekjs_icbc_dsj(dsjpd);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping("erp/getxdfx_dsjzx_result.do")
	public String getxdfx_dsjzx_result(HttpServletRequest request) {
		Map<String, String> paramemap = Tools.getpostmap(request);
		icbc icbc = newicbcService.findicbcbyid(Integer.parseInt(paramemap
				.get("id")));
		PageData pd = new PageData();
		pd.put("icbc_id", Integer.parseInt(paramemap.get("id")));
		PageData dsj = icbc_dsjService.findbyid(pd);
		String result = "";
		switch (paramemap.get("dsjtype")) {
		case "1":
			result = (String) dsj.get("result1");
			break;
		case "2":
			result = (String) dsj.get("result1");
			break;
		case "3":
			result = (String) dsj.get("result1");
			break;
		case "4":
			result = (String) dsj.get("result1");
			break;
		}
		if (result != null) {
			JSONObject res = JSONObject.parseObject(result);
			if (res.get("detail") != null && !res.get("detail").equals("")) {
				JSONObject detail = JSONObject.parseObject(res
						.getString("detail"));
				System.out.println("detail:" + detail);
				if (detail.get("resultDesc") != null
						&& !detail.get("resultDesc").equals("")) {
					JSONObject resultDesc = JSONObject.parseObject(detail
							.getString("resultDesc"));
					System.out.println("resultDesc:" + resultDesc);
					System.out.println("ANTIFRAUD:"
							+ resultDesc.get("ANTIFRAUD"));
					if (resultDesc.get("ANTIFRAUD") != null
							&& !resultDesc.get("ANTIFRAUD").equals("")) {
						JSONObject ANTIFRAUD = JSONObject
								.parseObject(resultDesc.getString("ANTIFRAUD"));
						request.setAttribute("ANTIFRAUD", ANTIFRAUD);
						if (ANTIFRAUD.get("risk_items") != null
								&& !ANTIFRAUD.get("risk_items").equals("")) {
							JSONArray risk_items = JSONArray
									.parseArray(ANTIFRAUD
											.getString("risk_items"));
							request.setAttribute("risk_items", risk_items);
						}
					}
				}
			}
		}
		request.setAttribute("icbc", icbc);
		request.setAttribute("dsj", dsj);
		return "kjs_icbc/content/AppraisalReport";
	}

	//
	public static void main(String[] args) throws UnsupportedEncodingException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("requestId", UUID.randomUUID().toString().replaceAll("-", ""));
		map.put("accountName", "皮晴晴");
		map.put("accountMobile", "13333333333");
		map.put("idNumber", "330105196602220623");
		String s = getdsjzxhttp(map);
		System.out.println(s);
	}
}
