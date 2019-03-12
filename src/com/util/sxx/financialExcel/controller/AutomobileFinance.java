package com.util.sxx.financialExcel.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.model.icbc.icbc;
import com.model1.icbc.erp.PageData;
import com.service1.erp_icbc.icbc_dsjService;
import com.service1.kjs_icbc.newicbcService;
import com.util.creditutil;
import com.util.jsonutil;

@Controller
@RequestMapping("/automobileFinance")
public class AutomobileFinance {

	@Autowired
	private newicbcService newicbcService;
	@Autowired
	private icbc_dsjService icbc_dsjService;

	/**
	 * 判断字符串的编码
	 *
	 * @param str
	 * @return
	 */
	public static String getEncoding(String str) {
		String encode[] = new String[] { "UTF-8", "ISO-8859-1", "GB2312",
				"GBK", "GB18030", "Big5", "Unicode", "ASCII" };
		for (int i = 0; i < encode.length; i++) {
			try {
				if (str.equals(new String(str.getBytes(encode[i]), encode[i]))) {
					return encode[i];
				}
			} catch (Exception ex) {
			}
		}

		return "";
	}

	/**
	 * 大数据接口1
	 * 
	 * @param name
	 *            姓名
	 * @param idCardNo
	 *            身份证号
	 * @param mobileNo
	 *            手机号
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/txl_Pre_loanAssessmentReport")
	@ResponseBody
	public String txl_Pre_loanAssessmentReport(String name, String idCardNo,
			String mobileNo, HttpServletRequest req)
			throws UnsupportedEncodingException {

		System.out.println("字符串编码：" + getEncoding(name));
		// http://localhost:8080/kcd/automobileFinance/dsj_Pre_loanAssessmentReport.do?name=屠国强&idCardNo=411403199512108410&mobileNo=17612161642
		System.out.println(new String(name.getBytes("iso-8859-1"), "utf-8")
				+ "**********" + idCardNo + "***********" + mobileNo);
		// 汽车金融评估报告请求结果
		String status = "成功";
		// 汽车金融评估报告请求地址
		String autoFinancingUrl = "http://tidata.taifinance.cn:8080/api/credit/auto-financial-preloan-eval-report?name="
				+ new String(name.getBytes("iso-8859-1"), "utf-8")
				+ "&idCardNo=" + idCardNo + "&mobileNo=" + mobileNo;
		// 汽车金融评估报告接口返回值
		String result = "";
		try {
			HttpGet request = new HttpGet(autoFinancingUrl);
			request.setHeader("tfapi-key", "7yScQE0SHF5TxO65lq1BoOyNeXQfv3");
			CloseableHttpClient client = HttpClientBuilder.create().build();
			HttpResponse response = client.execute(request);

			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				result = EntityUtils.toString(response.getEntity(), "utf-8");
			}

		} catch (Exception e) {
			status = "汽车金融评估报告获取失败";
			e.printStackTrace();
		}
		System.out.println("接口返回内容：" + result);
		return result;
	}

	/**
	 * 
	 * @param name
	 * @param idCardNo
	 * @param mobileNo
	 * @param req
	 *            dsj_type 大数据类型
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/dsj_Pre_loanAssessmentReport")
	@ResponseBody
	public Map dsj_Pre_loanAssessmentReport(Integer id, Integer dsj_type,
			String name, String idCardNo, String mobileNo,
			HttpServletRequest req) throws UnsupportedEncodingException {
		Map resMsg = new HashMap();// 返回结果集合
		String status1 = "执行成功";
		String status2 = "执行成功";
		Integer code1 = 1;
		Integer code2 = 1;
		icbc icbc = newicbcService.findicbcbyid(id);
		if (icbc != null && !icbc.equals("")) {
			JSONObject resMsg2 = new JSONObject();// 返回结果集合
			System.out.println("字符串编码：" + getEncoding(name));
			// http://localhost:8080/kcd/automobileFinance/dsj_Pre_loanAssessmentReport.do?name=屠国强&idCardNo=411403199512108410&mobileNo=17612161642
			System.out.println(name + "**********" + idCardNo + "***********"
					+ mobileNo);
			// 汽车金融评估报告请求地址
			String autoFinancingUrl = "http://tidata.taifinance.cn:8080/api/credit/auto-financial-preloan-eval-report?name="
					+ name + "&idCardNo=" + idCardNo + "&mobileNo=" + mobileNo;
			// 汽车金融评估报告接口返回值
			String result = "";
			//
			String result_id1 = "";
			String result_id2 = "";
			try {
				HttpGet request = new HttpGet(autoFinancingUrl);
				request.setHeader("tfapi-key", "7yScQE0SHF5TxO65lq1BoOyNeXQfv3");
				CloseableHttpClient client = HttpClientBuilder.create().build();
				HttpResponse response = client.execute(request);

				if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
					result = EntityUtils
							.toString(response.getEntity(), "utf-8");
					JSONObject jObject = new JSONObject().parseObject(result);
					System.out.println(jObject.get("success"));
					if (jObject.get("success").toString().equals("true")) {
						resMsg2.put("result", result);
						result_id1 = jObject.get("id").toString();
					} else {
						status1 = jObject.get("resultMsg").toString();
					}
					System.out.println("接口1返回内容：" + result);
				}

			} catch (Exception e) {
				status1 = "汽车金融评估报告获取失败";
				code1 = 0;
				e.printStackTrace();
			}
			// 贷前评估请求地址
			String loanAssessment = "http://tidata.taifinance.cn:8080/api/preloan/submit";
			// 贷前评估接口返回值
			String result1 = "";
			try {
				CloseableHttpClient client = HttpClientBuilder.create().build();
				HttpPost post = new HttpPost(loanAssessment);
				post.setHeader("tfapi-key", "7yScQE0SHF5TxO65lq1BoOyNeXQfv3");
				// 封装post请求的参数
				List<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();

				BasicNameValuePair pair = new BasicNameValuePair("name", name);
				BasicNameValuePair pair1 = new BasicNameValuePair("idCardNo",
						idCardNo);
				BasicNameValuePair pair2 = new BasicNameValuePair("mobileNo",
						mobileNo);
				parameters.add(pair);
				parameters.add(pair1);
				parameters.add(pair2);

				UrlEncodedFormEntity encodedFormEntity = new UrlEncodedFormEntity(
						parameters, "utf-8");
				post.setEntity(encodedFormEntity);

				HttpResponse response = client.execute(post);

				if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
					result1 = EntityUtils.toString(response.getEntity(),
							"utf-8");
					JSONObject jObject = new JSONObject().parseObject(result1);
					System.out.println(jObject.get("success"));
					if (jObject.get("success").toString().equals("true")) {
						resMsg2.put("result1", result1);
						result_id2 = jObject.get("id").toString();
					} else {
						status2 = jObject.get("resultMsg").toString();
					}
					System.out.println("接口2返回内容：" + result1);
				}
			} catch (Exception e) {
				status2 = "贷前评估获取失败";
				code2 = 0;
				e.printStackTrace();
			}
			icbc icbc1 = new icbc();
			PageData pd = new PageData();
			PageData dsjpd = new PageData();
			System.out.println("result:" + resMsg2.toString());
			if (dsj_type == 1) {
				dsjpd.put("result1", resMsg2.toString());
				icbc1.setDsj_report_id(result_id2);
			} else if (dsj_type == 2) {
				dsjpd.put("result2", resMsg2.toString());
				icbc1.setPo_dsj_report_id(result_id2);
			} else if (dsj_type == 3) {
				dsjpd.put("result3", resMsg2.toString());
				icbc1.setGjr_dsj_report_id1(result_id2);
			} else if (dsj_type == 4) {
				dsjpd.put("result4", resMsg2.toString());
				icbc1.setGjr_dsj_report_id2(result_id2);
			}
			pd.put("icbc_id", id);
			PageData dsj = icbc_dsjService.findbyid(pd);
			if (dsj != null && !dsj.equals("")) {
				dsjpd.put("dt_edit", creditutil.time());
				dsjpd.put("dt_add", creditutil.time());
				dsjpd.put("icbc_id", id);
				dsjpd.put("id", dsj.get("id"));
				icbc_dsjService.upkjs_icbc_dsj(dsjpd);
			} else {
				dsjpd.put("dt_edit", creditutil.time());
				dsjpd.put("dt_add", creditutil.time());
				dsjpd.put("icbc_id", id);
				icbc_dsjService.savekjs_icbc_dsj(dsjpd);
			}
			icbc1.setId(id);
			newicbcService.upicbc(icbc1);
			resMsg.put("result_code", result_id2);
		} else {
			status1 = "未找到订单";
			code1 = 0;
		}
		resMsg.put("msg", status1 + "-" + status2);
		resMsg.put("code", code1 + "-" + code2);
		return resMsg;
	}

	@RequestMapping("/get_dsj_result")
	public String get_dsj_result(Integer id, Integer dsjtype,
			HttpServletRequest req) {
		PageData pd = new PageData();
		pd.put("icbc_id", id);
		PageData icbc = icbc_dsjService.findbyid(pd);
		if (icbc != null && !icbc.equals("")) {
			String result1 = "";
			String result2 = "";
			// 贷前评估请求结果
			String status = "成功";
			// 贷前评估请求结果
			String status1 = "成功";
			if (dsjtype == 1) {
				if (icbc.get("result1") != null
						&& !icbc.get("result1").equals("")) {
					JSONObject j = new JSONObject().parseObject(icbc.get(
							"result1").toString());
					if (j.get("result") != null && !j.get("result").equals("")) {
						result1 = j.getString("result");
					}
					if (j.get("result1") != null
							&& !j.get("result1").equals("")) {
						result2 = j.getString("result1");
					}
				}
			} else if (dsjtype == 2) {
				if (icbc.get("result2") != null
						&& !icbc.get("result1").equals("")) {
					JSONObject j = new JSONObject().parseObject(icbc.get(
							"result2").toString());
					if (j.get("result") != null && !j.get("result").equals("")) {
						result1 = j.getString("result");
					}
					if (j.get("result1") != null
							&& !j.get("result1").equals("")) {
						result2 = j.getString("result1");
					}
				}
			} else if (dsjtype == 3) {
				if (icbc.get("result3") != null
						&& !icbc.get("result3").equals("")) {
					JSONObject j = new JSONObject().parseObject(icbc.get(
							"result3").toString());
					if (j.get("result") != null && !j.get("result").equals("")) {
						result1 = j.getString("result");
					}
					if (j.get("result1") != null
							&& !j.get("result1").equals("")) {
						result2 = j.getString("result1");
					}
				}
			} else if (dsjtype == 4) {
				if (icbc.get("result4") != null
						&& !icbc.get("result4").equals("")) {
					JSONObject j = new JSONObject().parseObject(icbc.get(
							"result4").toString());
					if (j.get("result") != null && !j.get("result").equals("")) {
						result1 = j.getString("result");
					}
					if (j.get("result1") != null
							&& !j.get("result1").equals("")) {
						result2 = j.getString("result1");
					}

				}
			}
			Map<String, Object> map1 = null;
			if (result2 != null && !result2.equals("")) {
				// 贷前评估数据处理
				System.out.println("---" + result2);
				map1 = (Map) JSON.parse(result2);
				Map<String, Object> resultData1 = new HashMap<>();
				try {
					resultData1 = (Map) JSON.parse(map1.get("resultData")
							.toString()); // resultData
				} catch (Exception e) {
					status1 = "查询次数不足";
				}
				try {
					Map<String, Object> INFOANALYSIS = (Map) JSON
							.parse(resultData1.get("INFOANALYSIS").toString()); // resultData.INFOANALYSIS
					Map<String, Object> address_detect = (Map) JSON
							.parse(INFOANALYSIS.get("address_detect")
									.toString()); // resultData.INFOANALYSIS.address_detect
					INFOANALYSIS.put("address_detect", address_detect);
					Map<String, Object> geoip_info = (Map) JSON
							.parse(INFOANALYSIS.get("geoip_info").toString()); // resultData.INFOANALYSIS.geoip_info
					INFOANALYSIS.put("geoip_info", geoip_info);
					Map<String, Object> device_info = (Map) JSON
							.parse(INFOANALYSIS.get("device_info").toString()); // resultData.INFOANALYSIS.device_info
					INFOANALYSIS.put("device_info", device_info);
					Map<String, Object> geotrueip_info = (Map) JSON
							.parse(INFOANALYSIS.get("geotrueip_info")
									.toString()); // resultData.INFOANALYSIS.geotrueip_info
					INFOANALYSIS.put("geotrueip_info", geotrueip_info);
					resultData1.put("INFOANALYSIS", INFOANALYSIS);

					Map<String, Object> ANTIFRAUD = (Map) JSON
							.parse(resultData1.get("ANTIFRAUD").toString()); // resultData.ANTIFRAUD
					List<Map<String, Object>> risk_items = jsonutil
							.toList(ANTIFRAUD.get("risk_items"));
					for (int i = 0; i < risk_items.size(); i++) {

						List<Map<String, Object>> risk_detail = jsonutil
								.toList(risk_items.get(i).get("risk_detail"));

						if (risk_detail.size() > 0) {
							if (risk_detail.get(0).get("type")
									.equals("grey_list")) { // 判断risk_detail中的type为grey_list
								List<Map<String, Object>> grey_list_details = (List<Map<String, Object>>) risk_detail
										.get(0).get("grey_list_details");
								risk_detail.get(0).put("grey_list_details",
										grey_list_details);
								risk_items.get(0).put("risk_detail",
										risk_detail);
							}

							if (risk_detail.get(0).get("type")
									.equals("frequency_detail")) {
								List<Map<String, Object>> frequency_detail_list = (List<Map<String, Object>>) risk_detail
										.get(0).get("frequency_detail_list");
								for (int j = 0; j < frequency_detail_list
										.size(); j++) {
									if (frequency_detail_list.get(j)
											.containsKey("data")) {
										List<String> data = (List<String>) frequency_detail_list
												.get(j).get("data");
										frequency_detail_list.get(j).put(
												"data", data);
									}
								}
								risk_detail.get(0).put("frequency_detail_list",
										frequency_detail_list);
								risk_items.get(0).put("risk_detail",
										risk_detail);
							}
						}

					}
					ANTIFRAUD.put("risk_items", risk_items);
					resultData1.put("ANTIFRAUD", ANTIFRAUD);
					map1.put("resultData", resultData1);

				} catch (Exception e) {
					status1 = "数据处理失败";
					e.printStackTrace();
				}
			} else {
				status1 = "数据处理失败";
			}
			Map<String, Object> map = null;
			if (result1 != null && !result1.equals("")) {
				// 汽车金融评估报告数据处理
				map = (Map) JSON.parse(result1);
				Map<String, Object> resultData = new HashMap<>();
				try {
					resultData = (Map) JSON.parse(map.get("resultData")
							.toString()); // resultData
				} catch (Exception e) {
					status = "查询次数不足";
				}

				try {
					Map<String, Object> idVerification = (Map) JSON
							.parse(resultData.get("idVerification").toString()); // resultData.idVerification
					resultData.put("idVerification", idVerification);

					Map<String, Object> carrier = (Map) JSON.parse(resultData
							.get("carrier").toString()); // resultData.carrier
					Map<String, Object> verification = (Map) JSON.parse(carrier
							.get("verification").toString()); // carrier.verification
					carrier.put("verification", verification);
					Map<String, Object> serviceDuration = (Map) JSON
							.parse(carrier.get("serviceDuration").toString()); // carrier.serviceDuration
					carrier.put("serviceDuration", serviceDuration);
					Map<String, Object> serviceStatus = (Map) JSON
							.parse(carrier.get("serviceStatus").toString()); // carrier.serviceStatus
					carrier.put("serviceStatus", serviceStatus);
					resultData.put("carrier", carrier);

					Map<String, Object> badJudicialRecord = (Map) JSON
							.parse(resultData.get("badJudicialRecord")
									.toString()); // resultData.badJudicialRecord
					// 循环badJudicialRecord下的数据
					String[] badJudicialRecord_s = { "dishonest", "executed",
							"lawCase", "netLoanOverdue", "callLoan",
							"courtNotice", "courtAnnouncement",
							"lawCaseProcess" };
					for (int i = 0; i < badJudicialRecord.size(); i++) {
						Map<String, Object> badJudicialRecord_i = (Map) JSON
								.parse(badJudicialRecord.get(
										badJudicialRecord_s[i]).toString());
						List<Map<String, Object>> items = jsonutil
								.toList(badJudicialRecord_i.get("items"));
						badJudicialRecord_i.put("items", items);
						badJudicialRecord.put(badJudicialRecord_s[i],
								badJudicialRecord_i);
					}
					resultData.put("badJudicialRecord", badJudicialRecord);

					Map<String, Object> riskList = (Map) JSON.parse(resultData
							.get("riskList").toString()); // resultData.riskList
					List<Map<String, Object>> items = jsonutil.toList(riskList
							.get("items"));
					riskList.put("items", items);
					resultData.put("riskList", riskList);

					Map<String, Object> loan = (Map) JSON.parse(resultData.get(
							"loan").toString()); // resultData.riskList
					// 循环处理loan下的数据
					String[] loan_s = { "registration", "application",
							"approval", "rejection", "overdue" };
					for (int i = 0; i < loan.size(); i++) {
						Map<String, Object> loan_i = new HashMap<String, Object>();
						if (loan.get(loan_s[i]) != null
								&& !loan.get(loan_s[i]).equals("")) {
							loan_i = (Map) JSON.parse(loan.get(loan_s[i])
									.toString());
						}
						loan.put(loan_s[i], loan_i);
					}
					resultData.put("loan", loan);

					map.put("resultData", resultData);
				} catch (Exception e) {
					status = "数据处理失败";
					e.printStackTrace();
				}
			} else {
				status1 = "数据处理失败";
			}
			req.setAttribute("data", map);
			req.setAttribute("icbc", icbc);
			req.setAttribute("data1", map1);
			req.setAttribute("status", status);
			req.setAttribute("status1", status1);
		}
		return "kjs_icbc/content/AppraisalReport";
	}

	/**
	 * 汽车金融贷前评估报告接口
	 * 
	 * @param name
	 *            姓名
	 * @param idCardNo
	 *            身份证号
	 * @param mobileNo
	 *            手机号
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/pre_loanAssessmentReport")
	public String Pre_loanAssessmentReport(String name, String idCardNo,
			String mobileNo, HttpServletRequest req)
			throws UnsupportedEncodingException {
		System.out.println(new String(name.getBytes("ISO889-1"), "UTF-8")
				+ "**********" + idCardNo + "***********" + mobileNo);
		// 汽车金融评估报告请求结果
		String status = "成功";
		// 汽车金融评估报告请求地址
		String autoFinancingUrl = "http://tidata.taifinance.cn:8080/api/credit/auto-financial-preloan-eval-report?name="
				+ name + "&idCardNo=" + idCardNo + "&mobileNo=" + mobileNo;
		// 汽车金融评估报告接口返回值
		String result = "";
		try {
			HttpGet request = new HttpGet(autoFinancingUrl);
			request.setHeader("tfapi-key", "7yScQE0SHF5TxO65lq1BoOyNeXQfv3");
			CloseableHttpClient client = HttpClientBuilder.create().build();
			HttpResponse response = client.execute(request);

			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				result = EntityUtils.toString(response.getEntity(), "utf-8");
			}

		} catch (Exception e) {
			status = "汽车金融评估报告获取失败";
			e.printStackTrace();
		}

		// 贷前评估请求结果
		String status1 = "成功";
		// 贷前评估请求地址
		String loanAssessment = "http://tidata.taifinance.cn:8080/api/preloan/submit";
		// 贷前评估接口返回值
		String result1 = "";
		try {
			CloseableHttpClient client = HttpClientBuilder.create().build();
			HttpPost post = new HttpPost(loanAssessment);
			post.setHeader("tfapi-key", "7yScQE0SHF5TxO65lq1BoOyNeXQfv3");
			// 封装post请求的参数
			List<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();

			BasicNameValuePair pair = new BasicNameValuePair("name", name);
			BasicNameValuePair pair1 = new BasicNameValuePair("idCardNo",
					idCardNo);
			BasicNameValuePair pair2 = new BasicNameValuePair("mobileNo",
					mobileNo);
			parameters.add(pair);
			parameters.add(pair1);
			parameters.add(pair2);

			UrlEncodedFormEntity encodedFormEntity = new UrlEncodedFormEntity(
					parameters, "utf-8");
			post.setEntity(encodedFormEntity);

			HttpResponse response = client.execute(post);

			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				result1 = EntityUtils.toString(response.getEntity(), "utf-8");
			}

		} catch (Exception e) {
			status1 = "贷前评估获取失败";
			e.printStackTrace();
		}

		System.out.println(result1);

		// 贷前评估数据处理
		Map<String, Object> map1 = (Map) JSON.parse(result1);
		Map<String, Object> resultData1 = new HashMap<>();
		try {
			resultData1 = (Map) JSON.parse(map1.get("resultData").toString()); // resultData
		} catch (Exception e) {
			status1 = "查询次数不足";
		}
		try {

			Map<String, Object> INFOANALYSIS = (Map) JSON.parse(resultData1
					.get("INFOANALYSIS").toString()); // resultData.INFOANALYSIS
			Map<String, Object> address_detect = (Map) JSON.parse(INFOANALYSIS
					.get("address_detect").toString()); // resultData.INFOANALYSIS.address_detect
			INFOANALYSIS.put("address_detect", address_detect);
			Map<String, Object> geoip_info = (Map) JSON.parse(INFOANALYSIS.get(
					"geoip_info").toString()); // resultData.INFOANALYSIS.geoip_info
			INFOANALYSIS.put("geoip_info", geoip_info);
			Map<String, Object> device_info = (Map) JSON.parse(INFOANALYSIS
					.get("device_info").toString()); // resultData.INFOANALYSIS.device_info
			INFOANALYSIS.put("device_info", device_info);
			Map<String, Object> geotrueip_info = (Map) JSON.parse(INFOANALYSIS
					.get("geotrueip_info").toString()); // resultData.INFOANALYSIS.geotrueip_info
			INFOANALYSIS.put("geotrueip_info", geotrueip_info);
			resultData1.put("INFOANALYSIS", INFOANALYSIS);

			Map<String, Object> ANTIFRAUD = (Map) JSON.parse(resultData1.get(
					"ANTIFRAUD").toString()); // resultData.ANTIFRAUD
			List<Map<String, Object>> risk_items = jsonutil.toList(ANTIFRAUD
					.get("risk_items"));
			for (int i = 0; i < risk_items.size(); i++) {

				List<Map<String, Object>> risk_detail = jsonutil
						.toList(risk_items.get(i).get("risk_detail"));

				if (risk_detail.size() > 0) {
					if (risk_detail.get(0).get("type").equals("grey_list")) { // 判断risk_detail中的type为grey_list
						List<Map<String, Object>> grey_list_details = (List<Map<String, Object>>) risk_detail
								.get(0).get("grey_list_details");
						risk_detail.get(0).put("grey_list_details",
								grey_list_details);
						risk_items.get(0).put("risk_detail", risk_detail);
					}

					if (risk_detail.get(0).get("type")
							.equals("frequency_detail")) {
						List<Map<String, Object>> frequency_detail_list = (List<Map<String, Object>>) risk_detail
								.get(0).get("frequency_detail_list");
						for (int j = 0; j < frequency_detail_list.size(); j++) {
							if (frequency_detail_list.get(j)
									.containsKey("data")) {
								List<String> data = (List<String>) frequency_detail_list
										.get(j).get("data");
								frequency_detail_list.get(j).put("data", data);
							}
						}
						risk_detail.get(0).put("frequency_detail_list",
								frequency_detail_list);
						risk_items.get(0).put("risk_detail", risk_detail);
					}
				}

			}
			ANTIFRAUD.put("risk_items", risk_items);
			resultData1.put("ANTIFRAUD", ANTIFRAUD);
			map1.put("resultData", resultData1);

		} catch (Exception e) {
			status1 = "数据处理失败";
			e.printStackTrace();
		}

		// 汽车金融评估报告数据处理
		Map<String, Object> map = (Map) JSON.parse(result);
		Map<String, Object> resultData = new HashMap<>();
		try {
			resultData = (Map) JSON.parse(map.get("resultData").toString()); // resultData
		} catch (Exception e) {
			status = "查询次数不足";
		}

		try {
			Map<String, Object> idVerification = (Map) JSON.parse(resultData
					.get("idVerification").toString()); // resultData.idVerification
			resultData.put("idVerification", idVerification);

			Map<String, Object> carrier = (Map) JSON.parse(resultData.get(
					"carrier").toString()); // resultData.carrier
			Map<String, Object> verification = (Map) JSON.parse(carrier.get(
					"verification").toString()); // carrier.verification
			carrier.put("verification", verification);
			Map<String, Object> serviceDuration = (Map) JSON.parse(carrier.get(
					"serviceDuration").toString()); // carrier.serviceDuration
			carrier.put("serviceDuration", serviceDuration);
			Map<String, Object> serviceStatus = (Map) JSON.parse(carrier.get(
					"serviceStatus").toString()); // carrier.serviceStatus
			carrier.put("serviceStatus", serviceStatus);
			resultData.put("carrier", carrier);

			Map<String, Object> badJudicialRecord = (Map) JSON.parse(resultData
					.get("badJudicialRecord").toString()); // resultData.badJudicialRecord
			// 循环badJudicialRecord下的数据
			String[] badJudicialRecord_s = { "dishonest", "executed",
					"lawCase", "netLoanOverdue", "callLoan", "courtNotice",
					"courtAnnouncement", "lawCaseProcess" };
			for (int i = 0; i < badJudicialRecord.size(); i++) {
				Map<String, Object> badJudicialRecord_i = (Map) JSON
						.parse(badJudicialRecord.get(badJudicialRecord_s[i])
								.toString());
				List<Map<String, Object>> items = jsonutil
						.toList(badJudicialRecord_i.get("items"));
				badJudicialRecord_i.put("items", items);
				badJudicialRecord.put(badJudicialRecord_s[i],
						badJudicialRecord_i);
			}
			resultData.put("badJudicialRecord", badJudicialRecord);

			Map<String, Object> riskList = (Map) JSON.parse(resultData.get(
					"riskList").toString()); // resultData.riskList
			List<Map<String, Object>> items = jsonutil.toList(riskList
					.get("items"));
			riskList.put("items", items);
			resultData.put("riskList", riskList);

			Map<String, Object> loan = (Map) JSON.parse(resultData.get("loan")
					.toString()); // resultData.riskList
			// 循环处理loan下的数据
			String[] loan_s = { "registration", "application", "approval",
					"rejection", "overdue" };
			for (int i = 0; i < loan.size(); i++) {
				Map<String, Object> loan_i = (Map) JSON.parse(loan.get(
						loan_s[i]).toString());
				loan.put(loan_s[i], loan_i);
			}
			resultData.put("loan", loan);

			map.put("resultData", resultData);
		} catch (Exception e) {
			status = "数据处理失败";
			e.printStackTrace();
		}

		req.setAttribute("data", map);
		req.setAttribute("data1", map1);
		req.setAttribute("status", status);
		req.setAttribute("status1", status1);

		return "kjs_icbc/content/AppraisalReport";
	}

}
