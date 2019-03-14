package com.controller.erp_icbc;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.controller.icbc.jsp.icbcmodel;
import com.controller.icbc.util.Jdpush;
import com.model.icbc.assess_cars;
import com.model.icbc.bclient_check;
import com.model.icbc.icbc;
import com.model1.admin;
import com.model1.icbc.icbc_mq;
import com.model1.icbc.icbc_mq_result;
import com.model1.icbc.erp.PageData;
import com.model1.send.admin_msg;
import com.service1.adminService;
import com.service1.Repayment.RepaymentService;
import com.service1.car.icbc_carsService;
import com.service1.car.icbc_cars_resultService;
import com.service1.erp_icbc.erp_fiveModelService;
import com.service1.erp_icbc.erp_wdrwService;
import com.service1.kjs_icbc.icbc_mqService;
import com.service1.kjs_icbc.icbc_mq_resultService;
import com.service1.kjs_icbc.newicbcService;
import com.service1.send.admin_msgService;
import com.util.creditutil;

@Controller
public class erp_fifteenUpController {
	private static final String appKey = "7e21faf06524b22f0ee1414c";
	private static final String masterSecret = "c87361ae4d7d91067b3ea01a";
	@Autowired
	private icbc_carsService icbc_carsService;
	@Autowired
	private adminService adminService;
	@Autowired
	private erp_fiveModelService erp_fiveModelService;
	@Autowired
	private newicbcService newicbcService;
	@Autowired
	private icbc_mqService icbc_mqService;
	@Autowired
	private icbc_mq_resultService icbc_mq_resultService;
	@Autowired
	private icbc_cars_resultService icbc_cars_resultService;
	@Autowired
	private admin_msgService admin_msgService;
	@Autowired
	private erp_wdrwService erp_wdrwService;
	@Autowired
	private RepaymentService repaymentservice;

	/*
	 * erp十五模块-跨区域业务审批-总经理审核(29) 审核
	 */
	@RequestMapping(value = "erp/erp_kqyspsh_29.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public void erp_kqyspsh_29(int adminid, String result_1_msg,
			int result_1_code, int type_id, int icbc_id,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		PageData pdsession = (PageData) request.getSession().getAttribute("pd");// 获取session信息
		int status = 29;
		String remark = "总经理审核";
		// 获取 车牌、vin、身份账号
		assess_cars aCars = icbc_carsService.findicbc_cars1(icbc_id);
		icbc icbc = newicbcService.findicbcbyid(icbc_id);
		// 保存进度之前先判断一下icbc_erp_kj_icbc表中是否有某个用户的某个板块
		PageData pdd = new PageData();
		pdd.put("dn", "selectOne_icbc_erp_kj_icbc");
		pdd.put("icbc_id", icbc_id);
		pdd.put("type_id", type_id);
		PageData pErpIcbc = erp_fiveModelService.findbyid(pdd);
		/*
		 * 操作明细记录 start/////
		 */
		// 保存 进度留言记录
		PageData pResult = new PageData();
		pResult.put("dn", "icbc_erp_kj_icbc_result");
		pResult.put("mid_add", adminid);
		pResult.put("mid_edit", adminid);
		pResult.put("dt_add", getMaxPagedate_7_9_11_12_14_15(icbc_id, type_id)
				.get("dt_edit"));
		pResult.put("dt_edit", creditutil.time());
		pResult.put("status", status);
		pResult.put("status_oldht", 0);
		pResult.put("remark", remark);
		pResult.put("result_1_msg", result_1_msg);
		pResult.put("result_1_code", result_1_code);
		pResult.put("dt_sub", creditutil.time());
		pResult.put("type_id", type_id);
		pResult.put("icbc_id", icbc_id);
		/*
		 * 操作明细记录 end/////
		 */
		if (pErpIcbc != null) {
			pResult.put("qryid", pErpIcbc.get("id"));
			erp_fiveModelService.save(pResult);
			// 更新icbc_erp_kj_icbc表中，status的最新装填
			PageData upd = new PageData();
			upd.put("dn", "update_icbc_erp_kj_icbc");
			upd.put("icbc_id", icbc_id);
			upd.put("type_id", type_id);
			upd.put("status", status);
			upd.put("mid_edit", adminid); // 修改人id
			upd.put("dt_edit", creditutil.time()); // 修改时间
			erp_fiveModelService.updatebyid(upd);
		} else {
			PageData picbc = new PageData();
			picbc.put("dn", "icbc_erp_kj_icbc");
			picbc.put("mid_add", adminid);
			picbc.put("mid_edit", adminid);
			picbc.put("dt_add", creditutil.time());
			picbc.put("dt_edit", creditutil.time());
			picbc.put("dt_sub", creditutil.time());
			picbc.put("status", status);
			picbc.put("icbc_id", icbc_id);
			picbc.put("gems_id", pdsession.get("gems_id")); // aCars.getGems_id()
															// pdsession.get("gems_id")
			picbc.put("gems_fs_id", pdsession.get("fs_id")); // aCars.getGems_fs_id()
																// pdsession.get("fs_id")
			picbc.put("type_id", type_id); // 银行申请贷款 对应 11
			if (aCars != null) {
				picbc.put("c_carno", aCars.getC_carno());
				picbc.put("c_carvin", aCars.getVincode());
			}
			if (icbc != null) {
				picbc.put("c_name", icbc.getC_name());
				picbc.put("c_cardno", icbc.getC_cardno());
			}
			erp_fiveModelService.save(picbc);
			// result添加数据
			pResult.put("qryid", picbc.get("id"));
			erp_fiveModelService.save(pResult);
		}
		// 当确认 为 "不通过"时
		// icbc表更新记录 和 result 表存一条完成记录
		if (result_1_code == 1 || result_1_code == 2) {
			// 更新icbc_erp_kj_icbc表中，status的最新装填
			PageData upd = new PageData();
			upd.put("dn", "update_icbc_erp_kj_icbc");
			upd.put("icbc_id", icbc_id);
			upd.put("type_id", 7);
			upd.put("status", 30);
			upd.put("mid_edit", adminid); // 修改人id
			upd.put("dt_edit", creditutil.time()); // 修改时间
			erp_fiveModelService.updatebyid(upd);
			PageData pResult_gsgd = new PageData();
			pResult_gsgd.put("dn", "icbc_erp_kj_icbc_result");
			pResult_gsgd.put("qryid", pErpIcbc.get("id"));
			pResult_gsgd.put("mid_add", adminid);
			pResult_gsgd.put("mid_edit", adminid);
			pResult_gsgd.put(
					"dt_add",
					getMaxPagedate_7_9_11_12_14_15(icbc_id, type_id).get(
							"dt_edit"));
			pResult_gsgd.put("dt_edit", creditutil.time());
			pResult_gsgd.put("status", 30);
			pResult_gsgd.put("status_oldht", 0);
			pResult_gsgd.put("remark", "完成");
			pResult_gsgd.put("result_1_code", 0);
			pResult_gsgd.put("dt_sub", creditutil.time());
			pResult_gsgd.put("type_id", 7);
			pResult_gsgd.put("icbc_id", icbc_id);
			erp_fiveModelService.save(pResult_gsgd); // 保存 公司归档存 icbc result表
		}
		// 推送
		String result_1_code_String = "状态";
		if (result_1_code == 1) {
			result_1_code_String = "通过";
		} else if (result_1_code == 2) {
			result_1_code_String = "不通过";
		} else if (result_1_code == 3) {
			result_1_code_String = "驳回";
		}
		Map map = erp_fifteenModel.fifteenModel();
		admin admin1 = adminService.adminbyid(pErpIcbc.getInt("mid_add"));
		if (admin1 != null && !admin1.equals("")) {
			String REGISTRATION_ID = admin1.getJgid();
			String mString = admin1.getName() + "您好!" + "客户名称为"
					+ icbc.getC_name() + "的审核已更新" + ";" + map.get(type_id)
					+ "_" + remark + "状态:" + result_1_code_String + ";留言:"
					+ result_1_msg + "时间:" + creditutil.time() + ";";
			if (REGISTRATION_ID != null && !REGISTRATION_ID.equals("")) {
				Jdpush.testSendPush(appKey, masterSecret, REGISTRATION_ID,
						mString);
			}
			admin_msg admin_msg = new admin_msg();
			admin_msg.setDt_add(creditutil.time());
			admin_msg.setDt_edit(creditutil.time());
			admin_msg.setMid_add(adminid);
			admin_msg.setMsg(mString);
			admin_msg.setReceiveid(admin1.getId());
			admin_msg.setSendid(0);
			admin_msg.setStatus(0);
			admin_msgService.addadmin_msg(admin_msg);
		}
	}

	/*
	 * erp十五模块-跨区域业务审批-主管审核(27) 审核
	 */
	@RequestMapping(value = "erp/erp_kqyspsh_27.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public void erp_kqyspsh_27(int adminid, String result_1_msg,
			int result_1_code, int type_id, int icbc_id,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		PageData pdsession = (PageData) request.getSession().getAttribute("pd");// 获取session信息
		int status = 27;
		String remark = "主管审核";
		// 获取 车牌、vin、身份账号
		assess_cars aCars = icbc_carsService.findicbc_cars1(icbc_id);
		icbc icbc = newicbcService.findicbcbyid(icbc_id);
		// 保存进度之前先判断一下icbc_erp_kj_icbc表中是否有某个用户的某个板块
		PageData pdd = new PageData();
		pdd.put("dn", "selectOne_icbc_erp_kj_icbc");
		pdd.put("icbc_id", icbc_id);
		pdd.put("type_id", type_id);
		PageData pErpIcbc = erp_fiveModelService.findbyid(pdd);
		/*
		 * 操作明细记录 start/////
		 */
		// 保存 进度留言记录
		PageData pResult = new PageData();
		pResult.put("dn", "icbc_erp_kj_icbc_result");
		pResult.put("mid_add", adminid);
		pResult.put("mid_edit", adminid);
		pResult.put("dt_add", getMaxPagedate_7_9_11_12_14_15(icbc_id, type_id)
				.get("dt_edit"));
		pResult.put("dt_edit", creditutil.time());
		pResult.put("status", status);
		pResult.put("status_oldht", 0);
		pResult.put("remark", remark);
		pResult.put("result_1_msg", result_1_msg);
		pResult.put("result_1_code", result_1_code);
		pResult.put("dt_sub", creditutil.time());
		pResult.put("type_id", type_id); // 银行申请贷款 对应 11
		pResult.put("icbc_id", icbc_id);
		/*
		 * 操作明细记录 end/////
		 */
		if (pErpIcbc != null) {
			pResult.put("qryid", pErpIcbc.get("id"));
			erp_fiveModelService.save(pResult);
			// 更新icbc_erp_kj_icbc表中，status的最新装填
			PageData upd = new PageData();
			upd.put("dn", "update_icbc_erp_kj_icbc");
			upd.put("icbc_id", icbc_id);
			upd.put("type_id", type_id); // 银行申请贷款 对应 11
			upd.put("status", status);
			upd.put("mid_edit", adminid); // 修改人id
			upd.put("dt_edit", creditutil.time()); // 修改时间
			erp_fiveModelService.updatebyid(upd);
		} else {
			PageData picbc = new PageData();
			picbc.put("dn", "icbc_erp_kj_icbc");
			picbc.put("mid_add", adminid);
			picbc.put("mid_edit", adminid);
			picbc.put("dt_add", creditutil.time());
			picbc.put("dt_edit", creditutil.time());
			picbc.put("dt_sub", creditutil.time());
			picbc.put("status", status);
			picbc.put("icbc_id", icbc_id);
			picbc.put("gems_id", pdsession.get("gems_id")); // aCars.getGems_id()
															// pdsession.get("gems_id")
			picbc.put("gems_fs_id", pdsession.get("fs_id")); // aCars.getGems_fs_id()
																// pdsession.get("fs_id")
			picbc.put("type_id", type_id); // 银行申请贷款 对应 11
			if (aCars != null) {
				picbc.put("c_carno", aCars.getC_carno());
				picbc.put("c_carvin", aCars.getVincode());
			}
			if (icbc != null) {
				picbc.put("c_name", icbc.getC_name());
				picbc.put("c_cardno", icbc.getC_cardno());
			}
			erp_fiveModelService.save(picbc);
			// result添加数据
			pResult.put("qryid", picbc.get("id"));
			erp_fiveModelService.save(pResult);
		}
		// 当确认 为 "不通过"时
		// icbc表更新记录 和 result 表存一条完成记录
		if (result_1_code == 2) {
			// 更新icbc_erp_kj_icbc表中，status的最新装填
			PageData upd = new PageData();
			upd.put("dn", "update_icbc_erp_kj_icbc");
			upd.put("icbc_id", icbc_id);
			upd.put("type_id", 7);
			upd.put("status", 30);
			upd.put("mid_edit", adminid); // 修改人id
			upd.put("dt_edit", creditutil.time()); // 修改时间
			erp_fiveModelService.updatebyid(upd);
			PageData pResult_gsgd = new PageData();
			pResult_gsgd.put("dn", "icbc_erp_kj_icbc_result");
			pResult_gsgd.put("qryid", pErpIcbc.get("id"));
			pResult_gsgd.put("mid_add", adminid);
			pResult_gsgd.put("mid_edit", adminid);
			pResult_gsgd.put("dt_add", creditutil.time());
			pResult_gsgd.put("dt_edit", creditutil.time());
			pResult_gsgd.put("status", 30);
			pResult_gsgd.put("status_oldht", 0);
			pResult_gsgd.put("remark", "完成");
			pResult_gsgd.put("result_1_code", 0);
			pResult_gsgd.put("dt_sub", creditutil.time());
			pResult_gsgd.put("type_id", 7);
			pResult_gsgd.put("icbc_id", icbc_id);
			erp_fiveModelService.save(pResult_gsgd); // 保存 公司归档存 icbc result表
		}
		// 推送
		String result_1_code_String = "状态";
		if (result_1_code == 1) {
			result_1_code_String = "通过";
		} else if (result_1_code == 2) {
			result_1_code_String = "不通过";
		} else if (result_1_code == 3) {
			result_1_code_String = "驳回";
		}
		Map map = erp_fifteenModel.fifteenModel();
		admin admin1 = adminService.adminbyid(pErpIcbc.getInt("mid_add"));
		if (admin1 != null && !admin1.equals("")) {
			String REGISTRATION_ID = admin1.getJgid();
			String mString = admin1.getName() + "您好!" + "客户名称为"
					+ icbc.getC_name() + "的审核已更新" + ";" + map.get(type_id)
					+ "_" + remark + "状态:" + result_1_code_String + ";留言:"
					+ result_1_msg + "时间:" + creditutil.time() + ";";
			if (REGISTRATION_ID != null && !REGISTRATION_ID.equals("")) {
				Jdpush.testSendPush(appKey, masterSecret, REGISTRATION_ID,
						mString);
			}
			admin_msg admin_msg = new admin_msg();
			admin_msg.setDt_add(creditutil.time());
			admin_msg.setDt_edit(creditutil.time());
			admin_msg.setMid_add(adminid);
			admin_msg.setMsg(mString);
			admin_msg.setReceiveid(admin1.getId());
			admin_msg.setSendid(0);
			admin_msg.setStatus(0);
			admin_msgService.addadmin_msg(admin_msg);
		}
	}

	/*
	 * erp十五模块-跨区域业务审批-跨区域业务申请(98) 审核
	 */
	@RequestMapping(value = "erp/erp_kqyspsh_98.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public void erp_kqyspsh_98(int adminid, String kqyspsh_98_sqspd,
			String result_1_msg, int type_id, int icbc_id,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// 添加开始
		erp_sh_add(adminid, type_id, icbc_id, request, response);
		PageData pdsession = (PageData) request.getSession().getAttribute("pd");// 获取session信息
		int status = 98;
		String remark = "跨区域业务申请";
		// 获取 车牌、vin、身份账号
		assess_cars aCars = icbc_carsService.findicbc_cars1(icbc_id);
		icbc icbc = newicbcService.findicbcbyid(icbc_id);
		// 保存进度之前先判断一下icbc_erp_kj_icbc表中是否有某个用户的某个板块
		PageData pdd = new PageData();
		pdd.put("dn", "selectOne_icbc_erp_kj_icbc");
		pdd.put("icbc_id", icbc_id);
		pdd.put("type_id", type_id);
		PageData pErpIcbc = erp_fiveModelService.findbyid(pdd);
		/*
		 * 操作明细记录 start/////
		 */
		// 保存 进度留言记录
		PageData pResult = new PageData();
		pResult.put("dn", "icbc_erp_kj_icbc_result");
		pResult.put("mid_add", adminid);
		pResult.put("mid_edit", adminid);
		pResult.put("dt_add", getMaxPagedate_7_9_11_12_14_15(icbc_id, type_id)
				.get("dt_edit"));
		pResult.put("dt_edit", creditutil.time());
		pResult.put("status", status);
		pResult.put("status_oldht", 0);
		pResult.put("remark", remark);
		JSONObject json = new JSONObject();
		json.put("98_sqspd", kqyspsh_98_sqspd);
		pResult.put("result_1_value", json.toString());
		pResult.put("result_1_msg", result_1_msg);
		pResult.put("result_1_code", 0);
		pResult.put("dt_sub", creditutil.time());
		pResult.put("type_id", type_id); // 银行申请贷款 对应 11
		pResult.put("icbc_id", icbc_id);
		/*
		 * 操作明细记录 end/////
		 */
		if (pErpIcbc != null) {
			pResult.put("qryid", pErpIcbc.get("id"));
			erp_fiveModelService.save(pResult);
			// 更新icbc_erp_kj_icbc表中，status的最新装填
			PageData upd = new PageData();
			upd.put("dn", "update_icbc_erp_kj_icbc");
			upd.put("icbc_id", icbc_id);
			upd.put("type_id", type_id); // 银行申请贷款 对应 11
			upd.put("status", status);
			upd.put("mid_edit", adminid); // 修改人id
			upd.put("dt_edit", creditutil.time()); // 修改时间
			erp_fiveModelService.updatebyid(upd);
		} else {
			PageData picbc = new PageData();
			picbc.put("dn", "icbc_erp_kj_icbc");
			picbc.put("mid_add", adminid);
			picbc.put("mid_edit", adminid);
			picbc.put("dt_add", creditutil.time());
			picbc.put("dt_edit", creditutil.time());
			picbc.put("dt_sub", creditutil.time());
			picbc.put("status", status);
			picbc.put("icbc_id", icbc_id);
			picbc.put("gems_id", pdsession.get("gems_id")); // aCars.getGems_id()
															// pdsession.get("gems_id")
			picbc.put("gems_fs_id", pdsession.get("fs_id")); // aCars.getGems_fs_id()
																// pdsession.get("fs_id")
			picbc.put("type_id", type_id); // 银行申请贷款 对应 11
			if (aCars != null) {
				picbc.put("c_carno", aCars.getC_carno());
				picbc.put("c_carvin", aCars.getVincode());
			}
			if (icbc != null) {
				picbc.put("c_name", icbc.getC_name());
				picbc.put("c_cardno", icbc.getC_cardno());
			}
			erp_fiveModelService.save(picbc);
			// result添加数据
			pResult.put("qryid", picbc.get("id"));
			erp_fiveModelService.save(pResult);
		}
		// 推送
		Map map = erp_fifteenModel.fifteenModel();
		admin admin1 = adminService.adminbyid(pErpIcbc.getInt("mid_add"));
		if (admin1 != null && !admin1.equals("")) {
			String REGISTRATION_ID = admin1.getJgid();
			String mString = admin1.getName() + "您好!" + "客户名称为"
					+ icbc.getC_name() + "的审核已更新" + ";正在进行" + remark + ";留言:"
					+ result_1_msg + "时间:" + creditutil.time() + ";";
			if (REGISTRATION_ID != null && !REGISTRATION_ID.equals("")) {
				Jdpush.testSendPush(appKey, masterSecret, REGISTRATION_ID,
						mString);
			}
			admin_msg admin_msg = new admin_msg();
			admin_msg.setDt_add(creditutil.time());
			admin_msg.setDt_edit(creditutil.time());
			admin_msg.setMid_add(adminid);
			admin_msg.setMsg(mString);
			admin_msg.setReceiveid(admin1.getId());
			admin_msg.setSendid(0);
			admin_msg.setStatus(0);
			admin_msgService.addadmin_msg(admin_msg);
		}
	}

	/*
	 * erp十五模块-银行申请贷款-机构收件确认(94) 审核
	 */
	@RequestMapping(value = "erp/erp_tdtfsh_94.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public void erp_tdtfsh_94(int adminid, String tdtfsh_94_msg,
			String tdtfsh_94_date, int result_1_code, String result_1_msg,
			int type_id, int icbc_id, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		PageData pdsession = (PageData) request.getSession().getAttribute("pd");// 获取session信息
		int status = 94;
		String remark = "机构收件确认";
		// 获取 车牌、vin、身份账号
		assess_cars aCars = icbc_carsService.findicbc_cars1(icbc_id);
		icbc icbc = newicbcService.findicbcbyid(icbc_id);
		// 保存进度之前先判断一下icbc_erp_kj_icbc表中是否有某个用户的某个板块
		PageData pdd = new PageData();
		pdd.put("dn", "selectOne_icbc_erp_kj_icbc");
		pdd.put("icbc_id", icbc_id);
		pdd.put("type_id", type_id);
		PageData pErpIcbc = erp_fiveModelService.findbyid(pdd);
		/*
		 * 操作明细记录 start/////
		 */
		// 保存 进度留言记录
		PageData pResult = new PageData();
		pResult.put("dn", "icbc_erp_kj_icbc_result");
		pResult.put("mid_add", adminid);
		pResult.put("mid_edit", adminid);
		pResult.put("dt_add", getMaxPagedate_7_9_11_12_14_15(icbc_id, type_id)
				.get("dt_edit"));
		pResult.put("dt_edit", creditutil.time());
		pResult.put("status", status);
		pResult.put("status_oldht", 0);
		pResult.put("remark", remark);
		JSONObject json = new JSONObject();
		json.put("94_msg", tdtfsh_94_msg);
		json.put("94_date", tdtfsh_94_date);
		pResult.put("result_1_value", json.toString());
		pResult.put("result_1_msg", result_1_msg);
		pResult.put("result_1_code", result_1_code);
		pResult.put("dt_sub", creditutil.time());
		pResult.put("type_id", type_id); // 银行申请贷款 对应 11
		pResult.put("icbc_id", icbc_id);
		/*
		 * 操作明细记录 end/////
		 */
		if (pErpIcbc != null) {
			pResult.put("qryid", pErpIcbc.get("id"));
			erp_fiveModelService.save(pResult);
			// 更新icbc_erp_kj_icbc表中，status的最新装填
			PageData upd = new PageData();
			upd.put("dn", "update_icbc_erp_kj_icbc");
			upd.put("icbc_id", icbc_id);
			upd.put("type_id", type_id); // 银行申请贷款 对应 11
			upd.put("status", status);
			upd.put("mid_edit", adminid); // 修改人id
			upd.put("dt_edit", creditutil.time()); // 修改时间
			erp_fiveModelService.updatebyid(upd);
		} else {
			PageData picbc = new PageData();
			picbc.put("dn", "icbc_erp_kj_icbc");
			picbc.put("mid_add", adminid);
			picbc.put("mid_edit", adminid);
			picbc.put("dt_add", creditutil.time());
			picbc.put("dt_edit", creditutil.time());
			picbc.put("dt_sub", creditutil.time());
			picbc.put("status", status);
			picbc.put("icbc_id", icbc_id);
			picbc.put("gems_id", pdsession.get("gems_id")); // aCars.getGems_id()
															// pdsession.get("gems_id")
			picbc.put("gems_fs_id", pdsession.get("fs_id")); // aCars.getGems_fs_id()
																// pdsession.get("fs_id")
			picbc.put("type_id", type_id); // 银行申请贷款 对应 11
			if (aCars != null) {
				picbc.put("c_carno", aCars.getC_carno());
				picbc.put("c_carvin", aCars.getVincode());
			}
			if (icbc != null) {
				picbc.put("c_name", icbc.getC_name());
				picbc.put("c_cardno", icbc.getC_cardno());
			}
			erp_fiveModelService.save(picbc);
			// result添加数据
			pResult.put("qryid", picbc.get("id"));
			erp_fiveModelService.save(pResult);
		}
		// 当确认 为 "通过"时
		// icbc表更新记录 和 result 表存一条完成记录
		if (result_1_code == 1) {
			// 更新icbc_erp_kj_icbc表中，status的最新装填
			PageData upd = new PageData();
			upd.put("dn", "update_icbc_erp_kj_icbc");
			upd.put("icbc_id", icbc_id);
			upd.put("type_id", 15);
			upd.put("status", 95);
			upd.put("mid_edit", adminid); // 修改人id
			upd.put("dt_edit", creditutil.time()); // 修改时间
			erp_fiveModelService.updatebyid(upd);
			PageData pResult_gsgd = new PageData();
			pResult_gsgd.put("dn", "icbc_erp_kj_icbc_result");
			pResult_gsgd.put("qryid", pErpIcbc.get("id"));
			pResult_gsgd.put("mid_add", adminid);
			pResult_gsgd.put("mid_edit", adminid);
			pResult_gsgd.put("dt_add", creditutil.time());
			pResult_gsgd.put("dt_edit", creditutil.time());
			pResult_gsgd.put("status", 95);
			pResult_gsgd.put("status_oldht", 0);
			pResult_gsgd.put("remark", "完成");
			pResult_gsgd.put("result_1_code", 0);
			pResult_gsgd.put("dt_sub", creditutil.time());
			pResult_gsgd.put("type_id", 15);
			pResult_gsgd.put("icbc_id", icbc_id);
			erp_fiveModelService.save(pResult_gsgd); // 保存 公司归档存 icbc result表
		}
		// 推送
		String result_1_code_String = "状态";
		if (result_1_code == 1) {
			result_1_code_String = "通过";
		} else if (result_1_code == 2) {
			result_1_code_String = "不通过";
		}
		Map map = erp_fifteenModel.fifteenModel();
		admin admin1 = adminService.adminbyid(pErpIcbc.getInt("mid_add"));
		if (admin1 != null && !admin1.equals("")) {
			String REGISTRATION_ID = admin1.getJgid();
			String mString = admin1.getName() + "您好!" + "客户名称为"
					+ icbc.getC_name() + "的审核已更新" + ";" + map.get(type_id)
					+ "_" + remark + "状态:" + tdtfsh_94_msg + "材料复核结果状态:"
					+ result_1_code_String + ";留言:" + result_1_msg + "时间:"
					+ creditutil.time() + ";";
			if (REGISTRATION_ID != null && !REGISTRATION_ID.equals("")) {
				Jdpush.testSendPush(appKey, masterSecret, REGISTRATION_ID,
						mString);
			}
			admin_msg admin_msg = new admin_msg();
			admin_msg.setDt_add(creditutil.time());
			admin_msg.setDt_edit(creditutil.time());
			admin_msg.setMid_add(adminid);
			admin_msg.setMsg(mString);
			admin_msg.setReceiveid(admin1.getId());
			admin_msg.setSendid(0);
			admin_msg.setStatus(0);
			admin_msgService.addadmin_msg(admin_msg);
		}
	}

	/*
	 * erp十五模块-银行申请贷款-材料寄回(93) 审核
	 */
	@RequestMapping(value = "erp/erp_tdtfsh_93.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public void erp_tdtfsh_93(int adminid, String tdtfsh_93_kdgs,
			String tdtfsh_93_kddh, String tdtfsh_93_jcrq,
			String tdtfsh_93_bcimg1, String result_1_msg, int type_id,
			int icbc_id, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		PageData pdsession = (PageData) request.getSession().getAttribute("pd");// 获取session信息
		int status = 93;
		String remark = "材料寄回";
		// 获取 车牌、vin、身份账号
		assess_cars aCars = icbc_carsService.findicbc_cars1(icbc_id);
		icbc icbc = newicbcService.findicbcbyid(icbc_id);
		// 保存进度之前先判断一下icbc_erp_kj_icbc表中是否有某个用户的某个板块
		PageData pdd = new PageData();
		pdd.put("dn", "selectOne_icbc_erp_kj_icbc");
		pdd.put("icbc_id", icbc_id);
		pdd.put("type_id", type_id); // 银行申请贷款 对应 11
		PageData pErpIcbc = erp_fiveModelService.findbyid(pdd);
		/*
		 * 操作明细记录 start/////
		 */
		// 保存 进度留言记录
		PageData pResult = new PageData();
		pResult.put("dn", "icbc_erp_kj_icbc_result");
		pResult.put("mid_add", adminid);
		pResult.put("mid_edit", adminid);
		pResult.put("dt_add", getMaxPagedate_7_9_11_12_14_15(icbc_id, type_id)
				.get("dt_edit"));
		pResult.put("dt_edit", creditutil.time());
		pResult.put("status", status);
		pResult.put("status_oldht", 0);
		pResult.put("remark", remark);
		JSONObject json = new JSONObject();
		json.put("kdgs", tdtfsh_93_kdgs);
		json.put("kddh", tdtfsh_93_kddh);
		json.put("jcrq", tdtfsh_93_jcrq);
		json.put("bcimg1", tdtfsh_93_bcimg1);
		pResult.put("result_1_value", json.toString());
		pResult.put("result_1_msg", result_1_msg);
		pResult.put("dt_sub", creditutil.time());
		pResult.put("type_id", type_id); // 银行申请贷款 对应 11
		pResult.put("icbc_id", icbc_id);
		/*
		 * 操作明细记录 end/////
		 */
		if (pErpIcbc != null) {
			pResult.put("qryid", pErpIcbc.get("id"));
			erp_fiveModelService.save(pResult);
			// 更新icbc_erp_kj_icbc表中，status的最新装填
			PageData upd = new PageData();
			upd.put("dn", "update_icbc_erp_kj_icbc");
			upd.put("icbc_id", icbc_id);
			upd.put("type_id", type_id); // 银行申请贷款 对应 11
			upd.put("status", status);
			upd.put("mid_edit", adminid); // 修改人id
			upd.put("dt_edit", creditutil.time()); // 修改时间
			erp_fiveModelService.updatebyid(upd);
		} else {
			PageData picbc = new PageData();
			picbc.put("dn", "icbc_erp_kj_icbc");
			picbc.put("mid_add", adminid);
			picbc.put("mid_edit", adminid);
			picbc.put("dt_add", creditutil.time());
			picbc.put("dt_edit", creditutil.time());
			picbc.put("dt_sub", creditutil.time());
			picbc.put("status", status);
			picbc.put("icbc_id", icbc_id);
			picbc.put("gems_id", pdsession.get("gems_id"));
			picbc.put("gems_fs_id", pdsession.get("fs_id"));
			picbc.put("type_id", type_id); // 银行申请贷款 对应 11
			if (aCars != null) {
				picbc.put("c_carno", aCars.getC_carno());
				picbc.put("c_carvin", aCars.getVincode());
			}
			if (icbc != null) {
				picbc.put("c_name", icbc.getC_name());
				picbc.put("c_cardno", icbc.getC_cardno());
			}
			erp_fiveModelService.save(picbc);
			// result添加数据
			pResult.put("qryid", picbc.get("id"));
			erp_fiveModelService.save(pResult);
		}
		// 推送
		Map map = erp_fifteenModel.fifteenModel();
		admin admin1 = adminService.adminbyid(pErpIcbc.getInt("mid_add"));
		if (admin1 != null && !admin1.equals("")) {
			String REGISTRATION_ID = admin1.getJgid();
			String mString = admin1.getName() + "您好!" + "客户名称为"
					+ icbc.getC_name() + "的审核已更新" + ";" + map.get(type_id)
					+ "_" + remark + "状态:" + "快递公司:" + tdtfsh_93_kdgs
					+ ",快递单号:" + tdtfsh_93_kddh + ",寄出日期:" + tdtfsh_93_jcrq
					+ ";留言:" + result_1_msg + "时间:" + creditutil.time() + ";";
			if (REGISTRATION_ID != null && !REGISTRATION_ID.equals("")) {
				Jdpush.testSendPush(appKey, masterSecret, REGISTRATION_ID,
						mString);
			}
			admin_msg admin_msg = new admin_msg();
			admin_msg.setDt_add(creditutil.time());
			admin_msg.setDt_edit(creditutil.time());
			admin_msg.setMid_add(adminid);
			admin_msg.setMsg(mString);
			admin_msg.setReceiveid(admin1.getId());
			admin_msg.setSendid(0);
			admin_msg.setStatus(0);
			admin_msgService.addadmin_msg(admin_msg);
		}
	}

	/*
	 * erp十五模块-退单退费-公司确认到账(92) 审核
	 */
	@RequestMapping(value = "erp/erp_tdtfsh_92.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public void erp_tdtfsh_92(int adminid, String result_1_msg,
			int result_1_code, int type_id, int icbc_id,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		PageData pdsession = (PageData) request.getSession().getAttribute("pd");// 获取session信息
		int status = 92;
		String remark = "公司确认到账";
		// 获取 车牌、vin、身份账号
		assess_cars aCars = icbc_carsService.findicbc_cars1(icbc_id);
		icbc icbc = newicbcService.findicbcbyid(icbc_id);
		// 保存进度之前先判断一下icbc_erp_kj_icbc表中是否有某个用户的某个板块
		PageData pdd = new PageData();
		pdd.put("dn", "selectOne_icbc_erp_kj_icbc");
		pdd.put("icbc_id", icbc_id);
		pdd.put("type_id", type_id);
		PageData pErpIcbc = erp_fiveModelService.findbyid(pdd);
		/*
		 * 操作明细记录 start/////
		 */
		// 保存 进度留言记录
		PageData pResult = new PageData();
		pResult.put("dn", "icbc_erp_kj_icbc_result");
		pResult.put("mid_add", adminid);
		pResult.put("mid_edit", adminid);
		pResult.put("dt_add", getMaxPagedate_7_9_11_12_14_15(icbc_id, type_id)
				.get("dt_edit"));
		pResult.put("dt_edit", creditutil.time());
		pResult.put("status", status);
		pResult.put("status_oldht", 0);
		pResult.put("remark", remark);
		pResult.put("result_1_msg", result_1_msg);
		pResult.put("result_1_code", result_1_code);
		pResult.put("result_1_value", "");
		pResult.put("dt_sub", creditutil.time());
		pResult.put("type_id", type_id);
		pResult.put("icbc_id", icbc_id);
		/*
		 * 操作明细记录 end/////
		 */
		if (pErpIcbc != null) {
			pResult.put("qryid", pErpIcbc.get("id"));
			erp_fiveModelService.save(pResult);
			// 更新icbc_erp_kj_icbc表中，status的最新装填
			PageData upd = new PageData();
			upd.put("dn", "update_icbc_erp_kj_icbc");
			upd.put("icbc_id", icbc_id);
			upd.put("type_id", type_id);
			upd.put("status", status);
			upd.put("mid_edit", adminid);
			upd.put("dt_edit", creditutil.time());
			erp_fiveModelService.updatebyid(upd);
		} else {
			PageData picbc = new PageData();
			picbc.put("dn", "icbc_erp_kj_icbc");
			picbc.put("mid_add", adminid);
			picbc.put("mid_edit", adminid);
			picbc.put("dt_add", creditutil.time());
			picbc.put("dt_edit", creditutil.time());
			picbc.put("dt_sub", creditutil.time());
			picbc.put("status", status);
			picbc.put("icbc_id", icbc_id);
			picbc.put("gems_id", pdsession.get("gems_id"));
			picbc.put("gems_fs_id", pdsession.get("fs_id"));
			picbc.put("type_id", type_id);
			if (aCars != null) {
				picbc.put("c_carno", aCars.getC_carno());
				picbc.put("c_carvin", aCars.getVincode());
			}
			if (icbc != null) {
				picbc.put("c_name", icbc.getC_name());
				picbc.put("c_cardno", icbc.getC_cardno());
			}
			erp_fiveModelService.save(picbc);
			// result添加数据
			pResult.put("qryid", picbc.get("id"));
			erp_fiveModelService.save(pResult);
		}
		// 当确认 为 "通过"时
		// icbc表更新记录 和 result 表存一条完成记录
		if (result_1_code == 2) {
			// 更新icbc_erp_kj_icbc表中，status的最新装填
			PageData upd = new PageData();
			upd.put("dn", "update_icbc_erp_kj_icbc");
			upd.put("icbc_id", icbc_id);
			upd.put("type_id", 15);
			upd.put("status", 95);
			upd.put("mid_edit", adminid); // 修改人id
			upd.put("dt_edit", creditutil.time()); // 修改时间
			erp_fiveModelService.updatebyid(upd);
			PageData pResult_gsgd = new PageData();
			pResult_gsgd.put("dn", "icbc_erp_kj_icbc_result");
			pResult_gsgd.put("qryid", pErpIcbc.get("id"));
			pResult_gsgd.put("mid_add", adminid);
			pResult_gsgd.put("mid_edit", adminid);
			pResult_gsgd.put("dt_add", creditutil.time());
			pResult_gsgd.put("dt_edit", creditutil.time());
			pResult_gsgd.put("status", 95);
			pResult_gsgd.put("status_oldht", 0);
			pResult_gsgd.put("remark", "完成");
			pResult_gsgd.put("result_1_code", 0);
			pResult_gsgd.put("dt_sub", creditutil.time());
			pResult_gsgd.put("type_id", 15);
			pResult_gsgd.put("icbc_id", icbc_id);
			erp_fiveModelService.save(pResult_gsgd); // 保存 公司归档存 icbc result表
		}
		// 推送
		String result_1_code_String = "状态";
		if (result_1_code == 1) {
			result_1_code_String = "到账、确认无误（已垫资已收件）";
		} else if (result_1_code == 2) {
			result_1_code_String = "已垫资未收件";
		} else if (result_1_code == 3) {
			result_1_code_String = "金额不符/未到账";
		}
		Map map = erp_fifteenModel.fifteenModel();
		admin admin1 = adminService.adminbyid(pErpIcbc.getInt("mid_add"));
		if (admin1 != null && !admin1.equals("")) {
			String REGISTRATION_ID = admin1.getJgid();
			String mString = admin1.getName() + "您好!" + "客户名称为"
					+ icbc.getC_name() + "的审核已更新" + ";" + map.get(type_id)
					+ "_" + remark + "状态:" + result_1_code_String + ";留言:"
					+ result_1_msg + "时间:" + creditutil.time() + ";";
			if (REGISTRATION_ID != null && !REGISTRATION_ID.equals("")) {
				Jdpush.testSendPush(appKey, masterSecret, REGISTRATION_ID,
						mString);
			}
			admin_msg admin_msg = new admin_msg();
			admin_msg.setDt_add(creditutil.time());
			admin_msg.setDt_edit(creditutil.time());
			admin_msg.setMid_add(adminid);
			admin_msg.setMsg(mString);
			admin_msg.setReceiveid(admin1.getId());
			admin_msg.setSendid(0);
			admin_msg.setStatus(0);
			admin_msgService.addadmin_msg(admin_msg);
		}
	}

	/*
	 * erp十五模块-退单退费-机构回款缴费审核(91) 审核
	 */
	@RequestMapping(value = "erp/erp_tdtfsh_91.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public void erp_tdtfsh_91(int adminid, String result_1_msg,
			String tdtfsh_91_dze, String tdtfsh_91_zjzyf, int type_id,
			int icbc_id, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		PageData pdsession = (PageData) request.getSession().getAttribute("pd");// 获取session信息
		int status = 91;
		String remark = "机构回款缴费";
		// 获取 车牌、vin、身份账号
		assess_cars aCars = icbc_carsService.findicbc_cars1(icbc_id);
		icbc icbc = newicbcService.findicbcbyid(icbc_id);
		// 保存进度之前先判断一下icbc_erp_kj_icbc表中是否有某个用户的某个板块
		PageData pdd = new PageData();
		pdd.put("dn", "selectOne_icbc_erp_kj_icbc");
		pdd.put("icbc_id", icbc_id);
		pdd.put("type_id", type_id);
		PageData pErpIcbc = erp_fiveModelService.findbyid(pdd);
		/*
		 * 操作明细记录 start/////
		 */
		// 保存 进度留言记录
		PageData pResult = new PageData();
		pResult.put("dn", "icbc_erp_kj_icbc_result");
		pResult.put("mid_add", adminid);
		pResult.put("mid_edit", adminid);
		pResult.put("dt_add", getMaxPagedate_7_9_11_12_14_15(icbc_id, type_id)
				.get("dt_edit"));
		pResult.put("dt_edit", creditutil.time());
		pResult.put("status", status);
		pResult.put("status_oldht", 0);
		pResult.put("remark", remark);
		pResult.put("result_1_msg", result_1_msg);
		pResult.put("result_1_code", 0);
		JSONObject json = new JSONObject();
		json.put("91_dze", tdtfsh_91_dze);
		json.put("91_zjzyf", tdtfsh_91_zjzyf);
		pResult.put("result_1_value", json.toString());
		pResult.put("dt_sub", creditutil.time());
		pResult.put("type_id", type_id);
		pResult.put("icbc_id", icbc_id);
		/*
		 * 操作明细记录 end/////
		 */
		if (pErpIcbc != null) {
			pResult.put("qryid", pErpIcbc.get("id"));
			erp_fiveModelService.save(pResult);
			// 更新icbc_erp_kj_icbc表中，status的最新装填
			PageData upd = new PageData();
			upd.put("dn", "update_icbc_erp_kj_icbc");
			upd.put("icbc_id", icbc_id);
			upd.put("type_id", type_id);
			upd.put("status", status);
			upd.put("mid_edit", adminid);
			upd.put("dt_edit", creditutil.time());
			erp_fiveModelService.updatebyid(upd);
		} else {
			PageData picbc = new PageData();
			picbc.put("dn", "icbc_erp_kj_icbc");
			picbc.put("mid_add", adminid);
			picbc.put("mid_edit", adminid);
			picbc.put("dt_add", creditutil.time());
			picbc.put("dt_edit", creditutil.time());
			picbc.put("dt_sub", creditutil.time());
			picbc.put("status", status);
			picbc.put("icbc_id", icbc_id);
			picbc.put("gems_id", pdsession.get("gems_id"));
			picbc.put("gems_fs_id", pdsession.get("fs_id"));
			picbc.put("type_id", type_id);
			if (aCars != null) {
				picbc.put("c_carno", aCars.getC_carno());
				picbc.put("c_carvin", aCars.getVincode());
			}
			if (icbc != null) {
				picbc.put("c_name", icbc.getC_name());
				picbc.put("c_cardno", icbc.getC_cardno());
			}
			erp_fiveModelService.save(picbc);
			// result添加数据
			pResult.put("qryid", picbc.get("id"));
			erp_fiveModelService.save(pResult);
		}
		// 推送
		Map map = erp_fifteenModel.fifteenModel();
		admin admin1 = adminService.adminbyid(pErpIcbc.getInt("mid_add"));
		if (admin1 != null && !admin1.equals("")) {
			String REGISTRATION_ID = admin1.getJgid();
			String mString = admin1.getName() + "您好!" + "客户名称为"
					+ icbc.getC_name() + "的审核已更新" + ";" + map.get(type_id)
					+ "_" + remark + "状态:垫资额:" + tdtfsh_91_dze + "资金占有费:"
					+ tdtfsh_91_zjzyf + ";留言:" + result_1_msg + "时间:"
					+ creditutil.time() + ";";
			if (REGISTRATION_ID != null && !REGISTRATION_ID.equals("")) {
				Jdpush.testSendPush(appKey, masterSecret, REGISTRATION_ID,
						mString);
			}
			admin_msg admin_msg = new admin_msg();
			admin_msg.setDt_add(creditutil.time());
			admin_msg.setDt_edit(creditutil.time());
			admin_msg.setMid_add(adminid);
			admin_msg.setMsg(mString);
			admin_msg.setReceiveid(admin1.getId());
			admin_msg.setSendid(0);
			admin_msg.setStatus(0);
			admin_msgService.addadmin_msg(admin_msg);
		}
	}

	/*
	 * erp十五模块-退单退费-审核经理退单审核(90) 审核
	 */
	@RequestMapping(value = "erp/erp_tdtfsh_90.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public void erp_tdtfsh_90(int adminid, int result_1_code,
			String result_1_msg, int type_id, int icbc_id,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		int status = 90;
		String remark = "审核经理退单审核";
		PageData pdsession = (PageData) request.getSession().getAttribute("pd");// 获取session信息
		// 获取 车牌、vin、身份账号
		assess_cars aCars = icbc_carsService.findicbc_cars1(icbc_id);
		icbc icbc = newicbcService.findicbcbyid(icbc_id);
		// 保存进度之前先判断一下icbc_erp_kj_icbc表中是否有某个用户的某个板块
		PageData pdd = new PageData();
		pdd.put("dn", "selectOne_icbc_erp_kj_icbc");
		pdd.put("icbc_id", icbc_id);
		pdd.put("type_id", type_id);
		PageData pErpIcbc = erp_fiveModelService.findbyid(pdd);
		/*
		 * 操作明细记录 start/////
		 */
		// 保存 进度留言记录
		PageData pResult = new PageData();
		pResult.put("dn", "icbc_erp_kj_icbc_result");
		pResult.put("mid_add", adminid);
		pResult.put("mid_edit", adminid);
		pResult.put("dt_add", getMaxPagedate_7_9_11_12_14_15(icbc_id, type_id)
				.get("dt_edit"));
		pResult.put("dt_edit", creditutil.time());
		pResult.put("status", status);
		pResult.put("status_oldht", 0);
		pResult.put("remark", remark);
		pResult.put("result_1_msg", result_1_msg);
		pResult.put("result_1_code", result_1_code);
		pResult.put("result_1_value", "");
		pResult.put("dt_sub", creditutil.time());
		pResult.put("type_id", type_id);
		pResult.put("icbc_id", icbc_id);
		/*
		 * 操作明细记录 end/////
		 */
		if (pErpIcbc != null) {
			pResult.put("qryid", pErpIcbc.get("id"));
			erp_fiveModelService.save(pResult);
			// 更新icbc_erp_kj_icbc表中，status的最新装填
			PageData upd = new PageData();
			upd.put("dn", "update_icbc_erp_kj_icbc");
			upd.put("icbc_id", icbc_id);
			upd.put("type_id", type_id);
			upd.put("status", status);
			upd.put("mid_edit", adminid);
			upd.put("dt_edit", creditutil.time());
			erp_fiveModelService.updatebyid(upd);
		} else {
			PageData picbc = new PageData();
			picbc.put("dn", "icbc_erp_kj_icbc");
			picbc.put("mid_add", adminid);
			picbc.put("mid_edit", adminid);
			picbc.put("dt_add", creditutil.time());
			picbc.put("dt_edit", creditutil.time());
			picbc.put("dt_sub", creditutil.time());
			picbc.put("status", status);
			picbc.put("icbc_id", icbc_id);
			picbc.put("gems_id", pdsession.get("gems_id"));
			picbc.put("gems_fs_id", pdsession.get("fs_id"));
			picbc.put("type_id", type_id);
			if (aCars != null) {
				picbc.put("c_carno", aCars.getC_carno());
				picbc.put("c_carvin", aCars.getVincode());
			}
			if (icbc != null) {
				picbc.put("c_name", icbc.getC_name());
				picbc.put("c_cardno", icbc.getC_cardno());
			}
			erp_fiveModelService.save(picbc);
			// result添加数据
			pResult.put("qryid", picbc.get("id"));
			erp_fiveModelService.save(pResult);
		}
		// 当确认 为 "通过"+"未垫资未收件"时，
		// icbc表更新记录 和 result 表存一条完成记录
		// 得到是否 出账
		PageData pdd_status = new PageData();
		pdd_status.put("dn", "selectListStatus_icbc_erp_kj_icbc_result");
		pdd_status.put("icbc_id", icbc_id);
		pdd_status.put("type_id", 10); // 资金分配-板块
		pdd_status.put("status", 50); // 出账-小状态
		List<PageData> pErpIcbc_50 = new ArrayList<>();
		pErpIcbc_50 = erp_fiveModelService.findtolist(pdd_status);
		// 得到 集团收件确认 的结果
		PageData pdd_s = new PageData();
		pdd_s.put("dn", "selectListStatus_icbc_erp_kj_icbc_result");
		pdd_s.put("icbc_id", icbc_id);
		pdd_s.put("type_id", 11); // 汽车贷款-板块
		pdd_s.put("status", 58); // 集团收件确认-小状态
		List<PageData> pErpIcbc_58 = new ArrayList<>();
		pErpIcbc_58 = erp_fiveModelService.findtolist(pdd_s);
		// 得到最后一条数据
		PageData get_max58 = pErpIcbc_58.get(pErpIcbc_58.size() - 1);
		JSONObject json = (JSONObject) JSON.parse(get_max58.get(
				"result_1_value").toString());
		if (pErpIcbc_50.size() > 0) { // 打钱啦 -垫资

		} else {
			// 未垫资
			if (json != null) {
				// 未收到
				if (json.get("58_msg").toString().equals("未收到")) {
					// 当确认 为 "通过"时
					// icbc表更新记录 和 result 表存一条完成记录
					if (result_1_code == 1) {
						// 更新icbc_erp_kj_icbc表中，status的最新装填
						PageData upd = new PageData();
						upd.put("dn", "update_icbc_erp_kj_icbc");
						upd.put("icbc_id", icbc_id);
						upd.put("type_id", 15);
						upd.put("status", 95);
						upd.put("mid_edit", adminid); // 修改人id
						upd.put("dt_edit", creditutil.time()); // 修改时间
						erp_fiveModelService.updatebyid(upd);
						PageData pResult_gsgd = new PageData();
						pResult_gsgd.put("dn", "icbc_erp_kj_icbc_result");
						pResult_gsgd.put("qryid", pErpIcbc.get("id"));
						pResult_gsgd.put("mid_add", adminid);
						pResult_gsgd.put("mid_edit", adminid);
						pResult_gsgd.put("dt_add", creditutil.time());
						pResult_gsgd.put("dt_edit", creditutil.time());
						pResult_gsgd.put("status", 95);
						pResult_gsgd.put("status_oldht", 0);
						pResult_gsgd.put("remark", "完成");
						pResult_gsgd.put("result_1_code", 0);
						pResult_gsgd.put("dt_sub", creditutil.time());
						pResult_gsgd.put("type_id", 15);
						pResult_gsgd.put("icbc_id", icbc_id);
						erp_fiveModelService.save(pResult_gsgd); // 保存 公司归档存
																	// icbc
																	// result表
					}
				}
			}
		}
		// 推送
		String result_1_code_String = "状态";
		if (result_1_code == 1) {
			result_1_code_String = "通过";
		} else if (result_1_code == 2) {
			result_1_code_String = "不通过";
		}
		Map map = erp_fifteenModel.fifteenModel();
		admin admin1 = adminService.adminbyid(pErpIcbc.getInt("mid_add"));
		if (admin1 != null && !admin1.equals("")) {
			String REGISTRATION_ID = admin1.getJgid();
			String mString = admin1.getName() + "您好!" + "客户名称为"
					+ icbc.getC_name() + "的审核已更新" + ";" + map.get(type_id)
					+ "_" + remark + "状态:" + result_1_code_String + ";留言:"
					+ result_1_msg + "时间:" + creditutil.time() + ";";
			if (REGISTRATION_ID != null && !REGISTRATION_ID.equals("")) {
				Jdpush.testSendPush(appKey, masterSecret, REGISTRATION_ID,
						mString);
			}
			admin_msg admin_msg = new admin_msg();
			admin_msg.setDt_add(creditutil.time());
			admin_msg.setDt_edit(creditutil.time());
			admin_msg.setMid_add(adminid);
			admin_msg.setMsg(mString);
			admin_msg.setReceiveid(admin1.getId());
			admin_msg.setSendid(0);
			admin_msg.setStatus(0);
			admin_msgService.addadmin_msg(admin_msg);
		}
	}

	/*
	 * erp十五模块-退单退费-退单数据修正(89) 审核
	 */
	@RequestMapping(value = "erp/erp_tdtfsh_89.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public void erp_tdtfsh_89(int adminid, String result_1_msg, int type_id,
			int icbc_id, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int status = 89;
		String remark = "退单数据修正";
		PageData pdsession = (PageData) request.getSession().getAttribute("pd");// 获取session信息
		// 获取 车牌、vin、身份账号
		assess_cars aCars = icbc_carsService.findicbc_cars1(icbc_id);
		icbc icbc = newicbcService.findicbcbyid(icbc_id);
		// 保存进度之前先判断一下icbc_erp_kj_icbc表中是否有某个用户的某个板块
		PageData pdd = new PageData();
		pdd.put("dn", "selectOne_icbc_erp_kj_icbc");
		pdd.put("icbc_id", icbc_id);
		pdd.put("type_id", type_id);
		PageData pErpIcbc = erp_fiveModelService.findbyid(pdd);
		/*
		 * 操作明细记录 start/////
		 */
		// 保存 进度留言记录
		PageData pResult = new PageData();
		pResult.put("dn", "icbc_erp_kj_icbc_result");
		pResult.put("mid_add", adminid);
		pResult.put("mid_edit", adminid);
		pResult.put("dt_add", getMaxPagedate_7_9_11_12_14_15(icbc_id, type_id)
				.get("dt_edit"));
		pResult.put("dt_edit", creditutil.time());
		pResult.put("status", status);
		pResult.put("status_oldht", 0);
		pResult.put("remark", remark);
		pResult.put("result_1_msg", result_1_msg);
		pResult.put("result_1_code", 0);
		pResult.put("result_1_value", "");
		pResult.put("dt_sub", creditutil.time());
		pResult.put("type_id", type_id);
		pResult.put("icbc_id", icbc_id);
		/*
		 * 操作明细记录 end/////
		 */
		if (pErpIcbc != null) {
			pResult.put("qryid", pErpIcbc.get("id"));
			erp_fiveModelService.save(pResult);
			// 更新icbc_erp_kj_icbc表中，status的最新装填
			PageData upd = new PageData();
			upd.put("dn", "update_icbc_erp_kj_icbc");
			upd.put("icbc_id", icbc_id);
			upd.put("type_id", type_id);
			upd.put("status", status);
			upd.put("mid_edit", adminid);
			upd.put("dt_edit", creditutil.time());
			erp_fiveModelService.updatebyid(upd);
		} else {
			PageData picbc = new PageData();
			picbc.put("dn", "icbc_erp_kj_icbc");
			picbc.put("mid_add", adminid);
			picbc.put("mid_edit", adminid);
			picbc.put("dt_add", creditutil.time());
			picbc.put("dt_edit", creditutil.time());
			picbc.put("dt_sub", creditutil.time());
			picbc.put("status", status);
			picbc.put("icbc_id", icbc_id);
			picbc.put("gems_id", pdsession.get("gems_id"));
			picbc.put("gems_fs_id", pdsession.get("fs_id"));
			picbc.put("type_id", type_id);
			if (aCars != null) {
				picbc.put("c_carno", aCars.getC_carno());
				picbc.put("c_carvin", aCars.getVincode());
			}
			if (icbc != null) {
				picbc.put("c_name", icbc.getC_name());
				picbc.put("c_cardno", icbc.getC_cardno());
			}
			erp_fiveModelService.save(picbc);
			// result添加数据
			pResult.put("qryid", picbc.get("id"));
			erp_fiveModelService.save(pResult);
		}
		// 推送
		Map map = erp_fifteenModel.fifteenModel();
		admin admin1 = adminService.adminbyid(pErpIcbc.getInt("mid_add"));
		if (admin1 != null && !admin1.equals("")) {
			String REGISTRATION_ID = admin1.getJgid();
			String mString = admin1.getName() + "您好!" + "客户名称为"
					+ icbc.getC_name() + "的审核已更新" + ";" + map.get(type_id)
					+ "_" + remark + "状态:" + "退单数据需修正" + ";留言:" + result_1_msg
					+ "时间:" + creditutil.time() + ";";
			if (REGISTRATION_ID != null && !REGISTRATION_ID.equals("")) {
				Jdpush.testSendPush(appKey, masterSecret, REGISTRATION_ID,
						mString);
			}
			admin_msg admin_msg = new admin_msg();
			admin_msg.setDt_add(creditutil.time());
			admin_msg.setDt_edit(creditutil.time());
			admin_msg.setMid_add(adminid);
			admin_msg.setMsg(mString);
			admin_msg.setReceiveid(admin1.getId());
			admin_msg.setSendid(0);
			admin_msg.setStatus(0);
			admin_msgService.addadmin_msg(admin_msg);
		}
	}

	/*
	 * erp十五模块-退单退费-审核员退单审核(88) 审核
	 */
	@RequestMapping(value = "erp/erp_tdtfsh_88.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public void erp_tdtfsh_88(int adminid, int result_1_code,
			String result_1_msg, int type_id, int icbc_id,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		int status = 88;
		String remark = "审核员退单审核";
		PageData pdsession = (PageData) request.getSession().getAttribute("pd");// 获取session信息
		// 获取 车牌、vin、身份账号
		assess_cars aCars = icbc_carsService.findicbc_cars1(icbc_id);
		icbc icbc = newicbcService.findicbcbyid(icbc_id);
		// 保存进度之前先判断一下icbc_erp_kj_icbc表中是否有某个用户的某个板块
		PageData pdd = new PageData();
		pdd.put("dn", "selectOne_icbc_erp_kj_icbc");
		pdd.put("icbc_id", icbc_id);
		pdd.put("type_id", type_id);
		PageData pErpIcbc = erp_fiveModelService.findbyid(pdd);
		/*
		 * 操作明细记录 start/////
		 */
		// 保存 进度留言记录
		PageData pResult = new PageData();
		pResult.put("dn", "icbc_erp_kj_icbc_result");
		pResult.put("mid_add", adminid);
		pResult.put("mid_edit", adminid);
		pResult.put("dt_add", getMaxPagedate_7_9_11_12_14_15(icbc_id, type_id)
				.get("dt_edit"));
		pResult.put("dt_edit", creditutil.time());
		pResult.put("status", status);
		pResult.put("status_oldht", 0);
		pResult.put("remark", remark);
		pResult.put("result_1_msg", result_1_msg);
		pResult.put("result_1_code", result_1_code);
		pResult.put("result_1_value", "");
		pResult.put("dt_sub", creditutil.time());
		pResult.put("type_id", type_id);
		pResult.put("icbc_id", icbc_id);
		/*
		 * 操作明细记录 end/////
		 */
		if (pErpIcbc != null) {
			pResult.put("qryid", pErpIcbc.get("id"));
			erp_fiveModelService.save(pResult);
			// 更新icbc_erp_kj_icbc表中，status的最新装填
			PageData upd = new PageData();
			upd.put("dn", "update_icbc_erp_kj_icbc");
			upd.put("icbc_id", icbc_id);
			upd.put("type_id", type_id);
			upd.put("status", status);
			upd.put("mid_edit", adminid);
			upd.put("dt_edit", creditutil.time());
			erp_fiveModelService.updatebyid(upd);
		} else {
			PageData picbc = new PageData();
			picbc.put("dn", "icbc_erp_kj_icbc");
			picbc.put("mid_add", adminid);
			picbc.put("mid_edit", adminid);
			picbc.put("dt_add", creditutil.time());
			picbc.put("dt_edit", creditutil.time());
			picbc.put("dt_sub", creditutil.time());
			picbc.put("status", status);
			picbc.put("icbc_id", icbc_id);
			picbc.put("gems_id", pdsession.get("gems_id"));
			picbc.put("gems_fs_id", pdsession.get("fs_id"));
			picbc.put("type_id", type_id);
			if (aCars != null) {
				picbc.put("c_carno", aCars.getC_carno());
				picbc.put("c_carvin", aCars.getVincode());
			}
			if (icbc != null) {
				picbc.put("c_name", icbc.getC_name());
				picbc.put("c_cardno", icbc.getC_cardno());
			}
			erp_fiveModelService.save(picbc);
			// result添加数据
			pResult.put("qryid", picbc.get("id"));
			erp_fiveModelService.save(pResult);
		}
		// 推送
		String result_1_code_String = "状态";
		if (result_1_code == 1) {
			result_1_code_String = "通过";
		} else if (result_1_code == 2) {
			result_1_code_String = "不通过";
		}
		Map map = erp_fifteenModel.fifteenModel();
		admin admin1 = adminService.adminbyid(pErpIcbc.getInt("mid_add"));
		if (admin1 != null && !admin1.equals("")) {
			String REGISTRATION_ID = admin1.getJgid();
			String mString = admin1.getName() + "您好!" + "客户名称为"
					+ icbc.getC_name() + "的审核已更新" + ";" + map.get(type_id)
					+ "_" + remark + "状态:" + result_1_code_String + ";留言:"
					+ result_1_msg + "时间:" + creditutil.time() + ";";
			if (REGISTRATION_ID != null && !REGISTRATION_ID.equals("")) {
				Jdpush.testSendPush(appKey, masterSecret, REGISTRATION_ID,
						mString);
			}
			admin_msg admin_msg = new admin_msg();
			admin_msg.setDt_add(creditutil.time());
			admin_msg.setDt_edit(creditutil.time());
			admin_msg.setMid_add(adminid);
			admin_msg.setMsg(mString);
			admin_msg.setReceiveid(admin1.getId());
			admin_msg.setSendid(0);
			admin_msg.setStatus(0);
			admin_msgService.addadmin_msg(admin_msg);
		}
	}

	/*
	 * erp十五模块-退单退费-退单退费申请(97) 审核
	 */
	// @RequestMapping(value="erp/erp_tdtfsh_97.do",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@RequestMapping(value = "erp/erp_tdtfsh_97.do")
	public void erp_tdtfsh_97(@RequestParam MultipartFile[] files, int adminid,
			String result_1_msg, int type_id, int icbc_id,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// 添加开始
		erp_sh_add(adminid, type_id, icbc_id, request, response);
		int status = 97;
		String remark = "退单退费申请";
		PageData pdsession = (PageData) request.getSession().getAttribute("pd");// 获取session信息
		// 获取 车牌、vin、身份账号
		assess_cars aCars = icbc_carsService.findicbc_cars1(icbc_id);
		icbc icbc = newicbcService.findicbcbyid(icbc_id);
		// 保存进度之前先判断一下icbc_erp_kj_icbc表中是否有某个用户的某个板块
		PageData pdd = new PageData();
		pdd.put("dn", "selectOne_icbc_erp_kj_icbc");
		pdd.put("icbc_id", icbc_id);
		pdd.put("type_id", type_id);
		PageData pErpIcbc = erp_fiveModelService.findbyid(pdd);
		/*
		 * 操作明细记录 start/////
		 */
		// 保存 进度留言记录
		PageData pResult = new PageData();
		pResult.put("dn", "icbc_erp_kj_icbc_result");
		pResult.put("mid_add", adminid);
		pResult.put("mid_edit", adminid);
		pResult.put("dt_add", getMaxPagedate_7_9_11_12_14_15(icbc_id, type_id)
				.get("dt_edit"));
		pResult.put("dt_edit", creditutil.time());
		pResult.put("status", status);
		pResult.put("status_oldht", 0);
		pResult.put("remark", remark);
		pResult.put("result_1_msg", result_1_msg);
		pResult.put("result_1_code", 0);
		System.err.println("111111111111166666666666666");
		System.err.println("上传图片数量:" + files.length);
		JSONObject json_result = new JSONObject();// json数据
		for (int i = 0; i < files.length; i++) {
			int bn = i + 1;
			MultipartFile file = files[i];
			int mFile = (int) files[i].getSize();
			if (file.getSize() != 0) {
				Date date = new Date();
				String filePath = "/KCDIMG/assess/upload/"
						+ new SimpleDateFormat("yyyy/MM/dd/").format(date);
				String imgpath = "upload/"
						+ new SimpleDateFormat("yyyy/MM/dd/").format(date);
				String filename = files[i].getOriginalFilename();
				String prefix = filename
						.substring(filename.lastIndexOf(".") + 1);
				UUID uuid = UUID.randomUUID();
				String uuidname = uuid.toString().replaceAll("-", "") + "."
						+ prefix;
				byte[] file36Byte = files[i].getBytes();
				FileUtils.writeByteArrayToFile(new File(filePath + uuidname),
						file36Byte);
				System.out.println("图片路径：" + filePath + uuidname);
				json_result.put("bcimg" + bn, imgpath + uuidname);
			}
		}

		pResult.put("result_1_value", json_result.toString());
		pResult.put("dt_sub", creditutil.time());
		pResult.put("type_id", type_id);
		pResult.put("icbc_id", icbc_id);
		/*
		 * 操作明细记录 end/////
		 */
		if (pErpIcbc != null) {
			pResult.put("qryid", pErpIcbc.get("id"));
			erp_fiveModelService.save(pResult);
			// 更新icbc_erp_kj_icbc表中，status的最新装填
			PageData upd = new PageData();
			upd.put("dn", "update_icbc_erp_kj_icbc");
			upd.put("icbc_id", icbc_id);
			upd.put("type_id", type_id);
			upd.put("status", status);
			upd.put("mid_edit", adminid);
			upd.put("dt_edit", creditutil.time());
			erp_fiveModelService.updatebyid(upd);
		} else {
			PageData picbc = new PageData();
			picbc.put("dn", "icbc_erp_kj_icbc");
			picbc.put("mid_add", adminid);
			picbc.put("mid_edit", adminid);
			picbc.put("dt_add", creditutil.time());
			picbc.put("dt_edit", creditutil.time());
			picbc.put("dt_sub", creditutil.time());
			picbc.put("status", status);
			picbc.put("icbc_id", icbc_id);
			picbc.put("gems_id", pdsession.get("gems_id"));
			picbc.put("gems_fs_id", pdsession.get("fs_id"));
			picbc.put("type_id", type_id);
			if (aCars != null) {
				picbc.put("c_carno", aCars.getC_carno());
				picbc.put("c_carvin", aCars.getVincode());
			}
			if (icbc != null) {
				picbc.put("c_name", icbc.getC_name());
				picbc.put("c_cardno", icbc.getC_cardno());
			}
			erp_fiveModelService.save(picbc);
			// result添加数据
			pResult.put("qryid", picbc.get("id"));
			erp_fiveModelService.save(pResult);
		}

		// 推送
		/*
		 * Map map=erp_fifteenModel.fifteenModel(); admin
		 * admin1=adminService.adminbyid(pErpIcbc.getInt("mid_add"));
		 * if(admin1!=null&&!admin1.equals("")){ String
		 * REGISTRATION_ID=admin1.getJgid(); String mString=admin1.getName()
		 * +"您好!" +"客户名称为" +icbc.getC_name()+"的审核已更新" +";正在进行"+remark
		 * +";留言:"+result_1_msg +"时间:"+creditutil.time()+";";
		 * if(REGISTRATION_ID!=null&&!REGISTRATION_ID.equals("")){
		 * Jdpush.testSendPush(appKey,masterSecret,REGISTRATION_ID,mString); }
		 * admin_msg admin_msg=new admin_msg();
		 * admin_msg.setDt_add(creditutil.time());
		 * admin_msg.setDt_edit(creditutil.time());
		 * admin_msg.setMid_add(adminid); admin_msg.setMsg(mString);
		 * admin_msg.setReceiveid(admin1.getId()); admin_msg.setSendid(0);
		 * admin_msg.setStatus(0); admin_msgService.addadmin_msg(admin_msg); }
		 */
	}

	/*
	 * erp十五模块-业务信息修改-系统运维（专员）(85) 审核
	 */
	@RequestMapping(value = "erp/erp_ywxxxgsh_85.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public void erp_ywxxxgsh_85(int adminid, String result_1_msg,
			int result_1_code, int type_id, int icbc_id,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		int status = 85;
		String remark = "系统运维（专员）";
		PageData pdsession = (PageData) request.getSession().getAttribute("pd");// 获取session信息
		// 获取 车牌、vin、身份账号
		assess_cars aCars = icbc_carsService.findicbc_cars1(icbc_id);
		icbc icbc = newicbcService.findicbcbyid(icbc_id);
		// 保存进度之前先判断一下icbc_erp_kj_icbc表中是否有某个用户的某个板块
		PageData pdd = new PageData();
		pdd.put("dn", "selectOne_icbc_erp_kj_icbc");
		pdd.put("icbc_id", icbc_id);
		pdd.put("type_id", type_id);
		PageData pErpIcbc = erp_fiveModelService.findbyid(pdd);
		/*
		 * 操作明细记录 start/////
		 */
		// 保存 进度留言记录
		PageData pResult = new PageData();
		pResult.put("dn", "icbc_erp_kj_icbc_result");
		pResult.put("mid_add", adminid);
		pResult.put("mid_edit", adminid);
		pResult.put("dt_add", getMaxPagedate_7_9_11_12_14_15(icbc_id, type_id)
				.get("dt_edit"));
		pResult.put("dt_edit", creditutil.time());
		pResult.put("status", status);
		pResult.put("status_oldht", 0);
		pResult.put("remark", remark);
		pResult.put("result_1_msg", result_1_msg);
		pResult.put("result_1_code", result_1_code);
		pResult.put("result_1_value", "");
		pResult.put("dt_sub", creditutil.time());
		pResult.put("type_id", type_id);
		pResult.put("icbc_id", icbc_id);
		/*
		 * 操作明细记录 end/////
		 */
		if (pErpIcbc != null) {
			pResult.put("qryid", pErpIcbc.get("id"));
			erp_fiveModelService.save(pResult);
			// 更新icbc_erp_kj_icbc表中，status的最新装填
			PageData upd = new PageData();
			upd.put("dn", "update_icbc_erp_kj_icbc");
			upd.put("icbc_id", icbc_id);
			upd.put("type_id", type_id);
			upd.put("status", status);
			upd.put("mid_edit", adminid);
			upd.put("dt_edit", creditutil.time());
			erp_fiveModelService.updatebyid(upd);
		} else {
			PageData picbc = new PageData();
			picbc.put("dn", "icbc_erp_kj_icbc");
			picbc.put("mid_add", adminid);
			picbc.put("mid_edit", adminid);
			picbc.put("dt_add", creditutil.time());
			picbc.put("dt_edit", creditutil.time());
			picbc.put("dt_sub", creditutil.time());
			picbc.put("status", status);
			picbc.put("icbc_id", icbc_id);
			picbc.put("gems_id", pdsession.get("gems_id"));
			picbc.put("gems_fs_id", pdsession.get("fs_id"));
			picbc.put("type_id", type_id);
			if (aCars != null) {
				picbc.put("c_carno", aCars.getC_carno());
				picbc.put("c_carvin", aCars.getVincode());
			}
			if (icbc != null) {
				picbc.put("c_name", icbc.getC_name());
				picbc.put("c_cardno", icbc.getC_cardno());
			}
			erp_fiveModelService.save(picbc);
			// result添加数据
			pResult.put("qryid", picbc.get("id"));
			erp_fiveModelService.save(pResult);
		}
		// 当确认 为 "通过"时
		// icbc表更新记录 和 result 表存一条完成记录
		if (1 == 1) {
			// 更新icbc_erp_kj_icbc表中，status的最新装填
			PageData upd = new PageData();
			upd.put("dn", "update_icbc_erp_kj_icbc");
			upd.put("icbc_id", icbc_id);
			upd.put("type_id", type_id);
			upd.put("status", 86);
			upd.put("mid_edit", adminid); // 修改人id
			upd.put("dt_edit", creditutil.time()); // 修改时间
			erp_fiveModelService.updatebyid(upd);
			PageData pResult_gsgd = new PageData();
			pResult_gsgd.put("dn", "icbc_erp_kj_icbc_result");
			pResult_gsgd.put("qryid", pErpIcbc.get("id"));
			pResult_gsgd.put("mid_add", adminid);
			pResult_gsgd.put("mid_edit", adminid);
			pResult_gsgd.put("dt_add", creditutil.time());
			pResult_gsgd.put("dt_edit", creditutil.time());
			pResult_gsgd.put("status", 86);
			pResult_gsgd.put("status_oldht", 0);
			pResult_gsgd.put("remark", "完成");
			pResult_gsgd.put("result_1_code", 0);
			pResult_gsgd.put("dt_sub", creditutil.time());
			pResult_gsgd.put("type_id", type_id);
			pResult_gsgd.put("icbc_id", icbc_id);
			erp_fiveModelService.save(pResult_gsgd); // 保存 公司归档存 icbc result表
		}
		// 推送
		String result_1_code_String = "状态";
		if (result_1_code == 1) {
			result_1_code_String = "通过";
		} else if (result_1_code == 2) {
			result_1_code_String = "不通过";
		}
		Map map = erp_fifteenModel.fifteenModel();
		admin admin1 = adminService.adminbyid(pErpIcbc.getInt("mid_add"));
		if (admin1 != null && !admin1.equals("")) {
			String REGISTRATION_ID = admin1.getJgid();
			String mString = admin1.getName() + "您好!" + "客户名称为"
					+ icbc.getC_name() + "的审核已更新" + ";" + map.get(type_id)
					+ "_" + remark + "状态:" + result_1_code_String + ";留言:"
					+ result_1_msg + "时间:" + creditutil.time() + ";";
			if (REGISTRATION_ID != null && !REGISTRATION_ID.equals("")) {
				Jdpush.testSendPush(appKey, masterSecret, REGISTRATION_ID,
						mString);
			}
			admin_msg admin_msg = new admin_msg();
			admin_msg.setDt_add(creditutil.time());
			admin_msg.setDt_edit(creditutil.time());
			admin_msg.setMid_add(adminid);
			admin_msg.setMsg(mString);
			admin_msg.setReceiveid(admin1.getId());
			admin_msg.setSendid(0);
			admin_msg.setStatus(0);
			admin_msgService.addadmin_msg(admin_msg);
		}
	}

	/*
	 * erp十五模块-业务信息修改-业务管理部(84) 审核
	 */
	@RequestMapping(value = "erp/erp_ywxxxgsh_84.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public void erp_ywxxxgsh_84(int adminid, String result_1_msg,
			int result_1_code, int type_id, int icbc_id,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		int status = 84;
		String remark = "业务管理部";
		PageData pdsession = (PageData) request.getSession().getAttribute("pd");// 获取session信息
		// 获取 车牌、vin、身份账号
		assess_cars aCars = icbc_carsService.findicbc_cars1(icbc_id);
		icbc icbc = newicbcService.findicbcbyid(icbc_id);
		// 保存进度之前先判断一下icbc_erp_kj_icbc表中是否有某个用户的某个板块
		PageData pdd = new PageData();
		pdd.put("dn", "selectOne_icbc_erp_kj_icbc");
		pdd.put("icbc_id", icbc_id);
		pdd.put("type_id", type_id);
		PageData pErpIcbc = erp_fiveModelService.findbyid(pdd);
		/*
		 * 操作明细记录 start/////
		 */
		// 保存 进度留言记录
		PageData pResult = new PageData();
		pResult.put("dn", "icbc_erp_kj_icbc_result");
		pResult.put("mid_add", adminid);
		pResult.put("mid_edit", adminid);
		pResult.put("dt_add", getMaxPagedate_7_9_11_12_14_15(icbc_id, type_id)
				.get("dt_edit"));
		pResult.put("dt_edit", creditutil.time());
		pResult.put("status", status);
		pResult.put("status_oldht", 0);
		pResult.put("remark", remark);
		pResult.put("result_1_msg", result_1_msg);
		pResult.put("result_1_code", result_1_code);
		pResult.put("result_1_value", "");
		pResult.put("dt_sub", creditutil.time());
		pResult.put("type_id", type_id);
		pResult.put("icbc_id", icbc_id);
		/*
		 * 操作明细记录 end/////
		 */
		if (pErpIcbc != null) {
			pResult.put("qryid", pErpIcbc.get("id"));
			erp_fiveModelService.save(pResult);
			// 更新icbc_erp_kj_icbc表中，status的最新装填
			PageData upd = new PageData();
			upd.put("dn", "update_icbc_erp_kj_icbc");
			upd.put("icbc_id", icbc_id);
			upd.put("type_id", type_id);
			upd.put("status", status);
			upd.put("mid_edit", adminid);
			upd.put("dt_edit", creditutil.time());
			erp_fiveModelService.updatebyid(upd);
		} else {
			PageData picbc = new PageData();
			picbc.put("dn", "icbc_erp_kj_icbc");
			picbc.put("mid_add", adminid);
			picbc.put("mid_edit", adminid);
			picbc.put("dt_add", creditutil.time());
			picbc.put("dt_edit", creditutil.time());
			picbc.put("dt_sub", creditutil.time());
			picbc.put("status", status);
			picbc.put("icbc_id", icbc_id);
			picbc.put("gems_id", pdsession.get("gems_id"));
			picbc.put("gems_fs_id", pdsession.get("fs_id"));
			picbc.put("type_id", type_id);
			if (aCars != null) {
				picbc.put("c_carno", aCars.getC_carno());
				picbc.put("c_carvin", aCars.getVincode());
			}
			if (icbc != null) {
				picbc.put("c_name", icbc.getC_name());
				picbc.put("c_cardno", icbc.getC_cardno());
			}
			erp_fiveModelService.save(picbc);
			// result添加数据
			pResult.put("qryid", picbc.get("id"));
			erp_fiveModelService.save(pResult);
		}
		// 当确认 为 "通过"时
		// icbc表更新记录 和 result 表存一条完成记录
		if (result_1_code == 2) {
			// 更新icbc_erp_kj_icbc表中，status的最新装填
			PageData upd = new PageData();
			upd.put("dn", "update_icbc_erp_kj_icbc");
			upd.put("icbc_id", icbc_id);
			upd.put("type_id", type_id);
			upd.put("status", 86);
			upd.put("mid_edit", adminid); // 修改人id
			upd.put("dt_edit", creditutil.time()); // 修改时间
			erp_fiveModelService.updatebyid(upd);
			PageData pResult_gsgd = new PageData();
			pResult_gsgd.put("dn", "icbc_erp_kj_icbc_result");
			pResult_gsgd.put("qryid", pErpIcbc.get("id"));
			pResult_gsgd.put("mid_add", adminid);
			pResult_gsgd.put("mid_edit", adminid);
			pResult_gsgd.put("dt_add", creditutil.time());
			pResult_gsgd.put("dt_edit", creditutil.time());
			pResult_gsgd.put("status", 86);
			pResult_gsgd.put("status_oldht", 0);
			pResult_gsgd.put("remark", "完成");
			pResult_gsgd.put("result_1_code", 0);
			pResult_gsgd.put("dt_sub", creditutil.time());
			pResult_gsgd.put("type_id", type_id);
			pResult_gsgd.put("icbc_id", icbc_id);
			erp_fiveModelService.save(pResult_gsgd); // 保存 公司归档存 icbc result表
		}
		// 推送
		String result_1_code_String = "状态";
		if (result_1_code == 1) {
			result_1_code_String = "通过";
		} else if (result_1_code == 2) {
			result_1_code_String = "不通过";
		}
		Map map = erp_fifteenModel.fifteenModel();
		admin admin1 = adminService.adminbyid(pErpIcbc.getInt("mid_add"));
		if (admin1 != null && !admin1.equals("")) {
			String REGISTRATION_ID = admin1.getJgid();
			String mString = admin1.getName() + "您好!" + "客户名称为"
					+ icbc.getC_name() + "的审核已更新" + ";" + map.get(type_id)
					+ "_" + remark + "状态:" + result_1_code_String + ";留言:"
					+ result_1_msg + "时间:" + creditutil.time() + ";";
			if (REGISTRATION_ID != null && !REGISTRATION_ID.equals("")) {
				Jdpush.testSendPush(appKey, masterSecret, REGISTRATION_ID,
						mString);
			}
			admin_msg admin_msg = new admin_msg();
			admin_msg.setDt_add(creditutil.time());
			admin_msg.setDt_edit(creditutil.time());
			admin_msg.setMid_add(adminid);
			admin_msg.setMsg(mString);
			admin_msg.setReceiveid(admin1.getId());
			admin_msg.setSendid(0);
			admin_msg.setStatus(0);
			admin_msgService.addadmin_msg(admin_msg);
		}
	}

	/*
	 * erp十五模块-业务信息修改-业务信息修改申请(96) 审核
	 */
	@RequestMapping(value = "erp/erp_ywxxxgsh_96.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public void erp_ywxxxgsh_96(int adminid, String result_1_msg,
			String ywxxxgsh_96_ywlx, String ywxxxgsh_96_xgbz, int type_id,
			int icbc_id, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// 添加开始
		erp_sh_add(adminid, type_id, icbc_id, request, response);
		int status = 96;
		String remark = "业务信息修改申请";
		PageData pdsession = (PageData) request.getSession().getAttribute("pd");// 获取session信息
		// 获取 车牌、vin、身份账号
		assess_cars aCars = icbc_carsService.findicbc_cars1(icbc_id);
		icbc icbc = newicbcService.findicbcbyid(icbc_id);
		// 保存进度之前先判断一下icbc_erp_kj_icbc表中是否有某个用户的某个板块
		PageData pdd = new PageData();
		pdd.put("dn", "selectOne_icbc_erp_kj_icbc");
		pdd.put("icbc_id", icbc_id);
		pdd.put("type_id", type_id);
		PageData pErpIcbc = erp_fiveModelService.findbyid(pdd);
		/*
		 * 操作明细记录 start/////
		 */
		// 保存 进度留言记录
		PageData pResult = new PageData();
		pResult.put("dn", "icbc_erp_kj_icbc_result");
		pResult.put("mid_add", adminid);
		pResult.put("mid_edit", adminid);
		pResult.put("dt_add", getMaxPagedate_7_9_11_12_14_15(icbc_id, type_id)
				.get("dt_edit"));
		pResult.put("dt_edit", creditutil.time());
		pResult.put("status", status);
		pResult.put("status_oldht", 0);
		pResult.put("remark", remark);
		pResult.put("result_1_msg", result_1_msg);
		pResult.put("result_1_code", 0);
		JSONObject json = new JSONObject();
		json.put("96_ywlx", ywxxxgsh_96_ywlx);
		json.put("96_xgbz", ywxxxgsh_96_xgbz);
		pResult.put("result_1_value", json.toString());
		pResult.put("dt_sub", creditutil.time());
		pResult.put("type_id", type_id);
		pResult.put("icbc_id", icbc_id);
		/*
		 * 操作明细记录 end/////
		 */
		if (pErpIcbc != null) {
			pResult.put("qryid", pErpIcbc.get("id"));
			erp_fiveModelService.save(pResult);
			// 更新icbc_erp_kj_icbc表中，status的最新装填
			PageData upd = new PageData();
			upd.put("dn", "update_icbc_erp_kj_icbc");
			upd.put("icbc_id", icbc_id);
			upd.put("type_id", type_id);
			upd.put("status", status);
			upd.put("mid_edit", adminid);
			upd.put("dt_edit", creditutil.time());
			erp_fiveModelService.updatebyid(upd);
		} else {
			PageData picbc = new PageData();
			picbc.put("dn", "icbc_erp_kj_icbc");
			picbc.put("mid_add", adminid);
			picbc.put("mid_edit", adminid);
			picbc.put("dt_add", creditutil.time());
			picbc.put("dt_edit", creditutil.time());
			picbc.put("dt_sub", creditutil.time());
			picbc.put("status", status);
			picbc.put("icbc_id", icbc_id);
			picbc.put("gems_id", pdsession.get("gems_id"));
			picbc.put("gems_fs_id", pdsession.get("fs_id"));
			picbc.put("type_id", type_id);
			if (aCars != null) {
				picbc.put("c_carno", aCars.getC_carno());
				picbc.put("c_carvin", aCars.getVincode());
			}
			if (icbc != null) {
				picbc.put("c_name", icbc.getC_name());
				picbc.put("c_cardno", icbc.getC_cardno());
			}
			erp_fiveModelService.save(picbc);
			// result添加数据
			pResult.put("qryid", picbc.get("id"));
			erp_fiveModelService.save(pResult);
		}
		// 推送
		/*
		 * Map map=erp_fifteenModel.fifteenModel(); admin
		 * admin1=adminService.adminbyid(pErpIcbc.getInt("mid_add"));
		 * if(admin1!=null&&!admin1.equals("")){ String
		 * REGISTRATION_ID=admin1.getJgid(); String mString=admin1.getName()
		 * +"您好!" +"客户名称为" +icbc.getC_name()+"的审核已更新" +";正在进行"+remark
		 * +";留言:"+result_1_msg +"时间:"+creditutil.time()+";";
		 * if(REGISTRATION_ID!=null&&!REGISTRATION_ID.equals("")){
		 * Jdpush.testSendPush(appKey,masterSecret,REGISTRATION_ID,mString); }
		 * admin_msg admin_msg=new admin_msg();
		 * admin_msg.setDt_add(creditutil.time());
		 * admin_msg.setDt_edit(creditutil.time());
		 * admin_msg.setMid_add(adminid); admin_msg.setMsg(mString);
		 * admin_msg.setReceiveid(admin1.getId()); admin_msg.setSendid(0);
		 * admin_msg.setStatus(0); admin_msgService.addadmin_msg(admin_msg); }
		 */
	}

	/*
	 * erp十五模块-公司归档-行政入库(70) 审核
	 */
	@RequestMapping(value = "erp/erp_gsgdsh_70.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public void erp_gsgdsh_70(int adminid, String result_1_msg,
			int result_1_code, int type_id, int icbc_id,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		int status = 70;
		String remark = "行政入库";
		PageData pdsession = (PageData) request.getSession().getAttribute("pd");// 获取session信息
		// 获取 车牌、vin、身份账号
		assess_cars aCars = icbc_carsService.findicbc_cars1(icbc_id);
		icbc icbc = newicbcService.findicbcbyid(icbc_id);
		// 保存进度之前先判断一下icbc_erp_kj_icbc表中是否有某个用户的某个板块
		PageData pdd = new PageData();
		pdd.put("dn", "selectOne_icbc_erp_kj_icbc");
		pdd.put("icbc_id", icbc_id);
		pdd.put("type_id", type_id);
		PageData pErpIcbc = erp_fiveModelService.findbyid(pdd);
		/*
		 * 操作明细记录 start/////
		 */
		// 保存 进度留言记录
		PageData pResult = new PageData();
		pResult.put("dn", "icbc_erp_kj_icbc_result");
		pResult.put("mid_add", adminid);
		pResult.put("mid_edit", adminid);
		pResult.put("dt_add", getMaxPagedate_7_9_11_12_14_15(icbc_id, type_id)
				.get("dt_edit"));
		pResult.put("dt_edit", creditutil.time());
		pResult.put("status", status);
		pResult.put("status_oldht", 0);
		pResult.put("remark", remark);
		pResult.put("result_1_msg", result_1_msg);
		pResult.put("result_1_code", result_1_code);
		pResult.put("result_1_value", "");
		pResult.put("dt_sub", creditutil.time());
		pResult.put("type_id", type_id);
		pResult.put("icbc_id", icbc_id);
		/*
		 * 操作明细记录 end/////
		 */
		if (pErpIcbc != null) {
			pResult.put("qryid", pErpIcbc.get("id"));
			erp_fiveModelService.save(pResult);
			// 更新icbc_erp_kj_icbc表中，status的最新装填
			PageData upd = new PageData();
			upd.put("dn", "update_icbc_erp_kj_icbc");
			upd.put("icbc_id", icbc_id);
			upd.put("type_id", type_id);
			upd.put("status", status);
			upd.put("mid_edit", adminid);
			upd.put("dt_edit", creditutil.time());
			erp_fiveModelService.updatebyid(upd);
		} else {
			PageData picbc = new PageData();
			picbc.put("dn", "icbc_erp_kj_icbc");
			picbc.put("mid_add", adminid);
			picbc.put("mid_edit", adminid);
			picbc.put("dt_add", creditutil.time());
			picbc.put("dt_edit", creditutil.time());
			picbc.put("dt_sub", creditutil.time());
			picbc.put("status", status);
			picbc.put("icbc_id", icbc_id);
			picbc.put("gems_id", pdsession.get("gems_id"));
			picbc.put("gems_fs_id", pdsession.get("fs_id"));
			picbc.put("type_id", type_id);
			if (aCars != null) {
				picbc.put("c_carno", aCars.getC_carno());
				picbc.put("c_carvin", aCars.getVincode());
			}
			if (icbc != null) {
				picbc.put("c_name", icbc.getC_name());
				picbc.put("c_cardno", icbc.getC_cardno());
			}
			erp_fiveModelService.save(picbc);
			// result添加数据
			pResult.put("qryid", picbc.get("id"));
			erp_fiveModelService.save(pResult);
		}
		// 当确认 为 "通过"时
		// icbc表更新记录 和 result 表存一条完成记录
		if (result_1_code == 1) {
			// 更新icbc_erp_kj_icbc表中，status的最新装填
			PageData upd = new PageData();
			upd.put("dn", "update_icbc_erp_kj_icbc");
			upd.put("icbc_id", icbc_id);
			upd.put("type_id", type_id);
			upd.put("status", 71);
			upd.put("mid_edit", adminid); // 修改人id
			upd.put("dt_edit", creditutil.time()); // 修改时间
			erp_fiveModelService.updatebyid(upd);
			PageData pResult_gsgd = new PageData();
			pResult_gsgd.put("dn", "icbc_erp_kj_icbc_result");
			pResult_gsgd.put("qryid", pErpIcbc.get("id"));
			pResult_gsgd.put("mid_add", adminid);
			pResult_gsgd.put("mid_edit", adminid);
			pResult_gsgd.put("dt_add", creditutil.time());
			pResult_gsgd.put("dt_edit", creditutil.time());
			pResult_gsgd.put("status", 71);
			pResult_gsgd.put("status_oldht", 0);
			pResult_gsgd.put("remark", "完成");
			pResult_gsgd.put("result_1_code", 0);
			pResult_gsgd.put("dt_sub", creditutil.time());
			pResult_gsgd.put("type_id", type_id);
			pResult_gsgd.put("icbc_id", icbc_id);
			erp_fiveModelService.save(pResult_gsgd); // 保存 公司归档存 icbc result表
		}
		// 推送
		String result_1_code_String = "状态";
		if (result_1_code == 1) {
			result_1_code_String = "通过";
		} else if (result_1_code == 2) {
			result_1_code_String = "不通过";
		}
		// 推送
		Map map = erp_fifteenModel.fifteenModel();
		admin admin1 = adminService.adminbyid(pErpIcbc.getInt("mid_add"));
		if (admin1 != null && !admin1.equals("")) {
			String REGISTRATION_ID = admin1.getJgid();
			String mString = admin1.getName() + "您好!" + "客户名称为"
					+ icbc.getC_name() + "的审核已更新" + ";" + map.get(type_id)
					+ "_" + remark + "状态:" + result_1_code_String + ";留言:"
					+ result_1_msg + "时间:" + creditutil.time() + ";";
			if (REGISTRATION_ID != null && !REGISTRATION_ID.equals("")) {
				Jdpush.testSendPush(appKey, masterSecret, REGISTRATION_ID,
						mString);
			}
			admin_msg admin_msg = new admin_msg();
			admin_msg.setDt_add(creditutil.time());
			admin_msg.setDt_edit(creditutil.time());
			admin_msg.setMid_add(adminid);
			admin_msg.setMsg(mString);
			admin_msg.setReceiveid(admin1.getId());
			admin_msg.setSendid(0);
			admin_msg.setStatus(0);
			admin_msgService.addadmin_msg(admin_msg);
		}
	}

	/*
	 * erp十五模块-公司归档-审核员补资料(69) 审核
	 */
	@RequestMapping(value = "erp/erp_gsgdsh_69.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public void erp_gsgdsh_69(int adminid, String result_1_msg, int type_id,
			int icbc_id, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int status = 69;
		String remark = "审核员补资料";
		PageData pdsession = (PageData) request.getSession().getAttribute("pd");// 获取session信息
		// 获取 车牌、vin、身份账号
		assess_cars aCars = icbc_carsService.findicbc_cars1(icbc_id);
		icbc icbc = newicbcService.findicbcbyid(icbc_id);
		// 保存进度之前先判断一下icbc_erp_kj_icbc表中是否有某个用户的某个板块
		PageData pdd = new PageData();
		pdd.put("dn", "selectOne_icbc_erp_kj_icbc");
		pdd.put("icbc_id", icbc_id);
		pdd.put("type_id", type_id);
		PageData pErpIcbc = erp_fiveModelService.findbyid(pdd);
		/*
		 * 操作明细记录 start/////
		 */
		// 保存 进度留言记录
		PageData pResult = new PageData();
		pResult.put("dn", "icbc_erp_kj_icbc_result");
		pResult.put("mid_add", adminid);
		pResult.put("mid_edit", adminid);
		pResult.put("dt_add", getMaxPagedate_7_9_11_12_14_15(icbc_id, type_id)
				.get("dt_edit"));
		pResult.put("dt_edit", creditutil.time());
		pResult.put("status", status);
		pResult.put("status_oldht", 0);
		pResult.put("remark", remark);
		pResult.put("result_1_msg", result_1_msg);
		pResult.put("result_1_code", 0);
		pResult.put("result_1_value", "");
		pResult.put("dt_sub", creditutil.time());
		pResult.put("type_id", type_id);
		pResult.put("icbc_id", icbc_id);
		/*
		 * 操作明细记录 end/////
		 */
		if (pErpIcbc != null) {
			pResult.put("qryid", pErpIcbc.get("id"));
			erp_fiveModelService.save(pResult);
			// 更新icbc_erp_kj_icbc表中，status的最新装填
			PageData upd = new PageData();
			upd.put("dn", "update_icbc_erp_kj_icbc");
			upd.put("icbc_id", icbc_id);
			upd.put("type_id", type_id);
			upd.put("status", status);
			upd.put("mid_edit", adminid);
			upd.put("dt_edit", creditutil.time());
			erp_fiveModelService.updatebyid(upd);
		} else {
			PageData picbc = new PageData();
			picbc.put("dn", "icbc_erp_kj_icbc");
			picbc.put("mid_add", adminid);
			picbc.put("mid_edit", adminid);
			picbc.put("dt_add", creditutil.time());
			picbc.put("dt_edit", creditutil.time());
			picbc.put("dt_sub", creditutil.time());
			picbc.put("status", status);
			picbc.put("icbc_id", icbc_id);
			picbc.put("gems_id", pdsession.get("gems_id"));
			picbc.put("gems_fs_id", pdsession.get("fs_id"));
			picbc.put("type_id", type_id);
			if (aCars != null) {
				picbc.put("c_carno", aCars.getC_carno());
				picbc.put("c_carvin", aCars.getVincode());
			}
			if (icbc != null) {
				picbc.put("c_name", icbc.getC_name());
				picbc.put("c_cardno", icbc.getC_cardno());
			}
			erp_fiveModelService.save(picbc);
			// result添加数据
			pResult.put("qryid", picbc.get("id"));
			erp_fiveModelService.save(pResult);
		}
		// 推送
		Map map = erp_fifteenModel.fifteenModel();
		admin admin1 = adminService.adminbyid(pErpIcbc.getInt("mid_add"));
		if (admin1 != null && !admin1.equals("")) {
			String REGISTRATION_ID = admin1.getJgid();
			String mString = admin1.getName() + "您好!" + "客户名称为"
					+ icbc.getC_name() + "的审核已更新" + ";正在进行" + remark + ";留言:"
					+ result_1_msg + "时间:" + creditutil.time() + ";";
			if (REGISTRATION_ID != null && !REGISTRATION_ID.equals("")) {
				Jdpush.testSendPush(appKey, masterSecret, REGISTRATION_ID,
						mString);
			}
			admin_msg admin_msg = new admin_msg();
			admin_msg.setDt_add(creditutil.time());
			admin_msg.setDt_edit(creditutil.time());
			admin_msg.setMid_add(adminid);
			admin_msg.setMsg(mString);
			admin_msg.setReceiveid(admin1.getId());
			admin_msg.setSendid(0);
			admin_msg.setStatus(0);
			admin_msgService.addadmin_msg(admin_msg);
		}
	}

	/*
	 * erp十五模块-公司归档-纸质归档(68) 审核
	 */
	@RequestMapping(value = "erp/erp_gsgdsh_68.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public void erp_gsgdsh_68(int adminid, String result_1_msg, int type_id,
			int icbc_id, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int status = 68;
		String remark = "纸质归档";
		PageData pdsession = (PageData) request.getSession().getAttribute("pd");// 获取session信息
		// 获取 车牌、vin、身份账号
		assess_cars aCars = icbc_carsService.findicbc_cars1(icbc_id);
		icbc icbc = newicbcService.findicbcbyid(icbc_id);
		// 保存进度之前先判断一下icbc_erp_kj_icbc表中是否有某个用户的某个板块
		PageData pdd = new PageData();
		pdd.put("dn", "selectOne_icbc_erp_kj_icbc");
		pdd.put("icbc_id", icbc_id);
		pdd.put("type_id", type_id);
		PageData pErpIcbc = erp_fiveModelService.findbyid(pdd);
		/*
		 * 操作明细记录 start/////
		 */
		// 保存 进度留言记录
		PageData pResult = new PageData();
		pResult.put("dn", "icbc_erp_kj_icbc_result");
		pResult.put("mid_add", adminid);
		pResult.put("mid_edit", adminid);
		pResult.put("dt_add", getMaxPagedate_7_9_11_12_14_15(icbc_id, type_id)
				.get("dt_edit"));
		pResult.put("dt_edit", creditutil.time());
		pResult.put("status", status);
		pResult.put("status_oldht", 0);
		pResult.put("remark", remark);
		pResult.put("result_1_msg", result_1_msg);
		pResult.put("result_1_code", 0);
		pResult.put("result_1_value", "");
		pResult.put("dt_sub", creditutil.time());
		pResult.put("type_id", type_id);
		pResult.put("icbc_id", icbc_id);
		/*
		 * 操作明细记录 end/////
		 */
		if (pErpIcbc != null) {
			pResult.put("qryid", pErpIcbc.get("id"));
			erp_fiveModelService.save(pResult);
			// 更新icbc_erp_kj_icbc表中，status的最新装填
			PageData upd = new PageData();
			upd.put("dn", "update_icbc_erp_kj_icbc");
			upd.put("icbc_id", icbc_id);
			upd.put("type_id", type_id);
			upd.put("status", status);
			upd.put("mid_edit", adminid);
			upd.put("dt_edit", creditutil.time());
			erp_fiveModelService.updatebyid(upd);
		} else {
			PageData picbc = new PageData();
			picbc.put("dn", "icbc_erp_kj_icbc");
			picbc.put("mid_add", adminid);
			picbc.put("mid_edit", adminid);
			picbc.put("dt_add", creditutil.time());
			picbc.put("dt_edit", creditutil.time());
			picbc.put("dt_sub", creditutil.time());
			picbc.put("status", status);
			picbc.put("icbc_id", icbc_id);
			picbc.put("gems_id", pdsession.get("gems_id"));
			picbc.put("gems_fs_id", pdsession.get("fs_id"));
			picbc.put("type_id", type_id);
			if (aCars != null) {
				picbc.put("c_carno", aCars.getC_carno());
				picbc.put("c_carvin", aCars.getVincode());
			}
			if (icbc != null) {
				picbc.put("c_name", icbc.getC_name());
				picbc.put("c_cardno", icbc.getC_cardno());
			}
			erp_fiveModelService.save(picbc);
			// result添加数据
			pResult.put("qryid", picbc.get("id"));
			erp_fiveModelService.save(pResult);
		}
		// 推送
		Map map = erp_fifteenModel.fifteenModel();
		admin admin1 = adminService.adminbyid(pErpIcbc.getInt("mid_add"));
		if (admin1 != null && !admin1.equals("")) {
			String REGISTRATION_ID = admin1.getJgid();
			String mString = admin1.getName() + "您好!" + "客户名称为"
					+ icbc.getC_name() + "的审核已更新" + ";正在进行" + remark + ";留言:"
					+ result_1_msg + "时间:" + creditutil.time() + ";";
			if (REGISTRATION_ID != null && !REGISTRATION_ID.equals("")) {
				Jdpush.testSendPush(appKey, masterSecret, REGISTRATION_ID,
						mString);
			}
			admin_msg admin_msg = new admin_msg();
			admin_msg.setDt_add(creditutil.time());
			admin_msg.setDt_edit(creditutil.time());
			admin_msg.setMid_add(adminid);
			admin_msg.setMsg(mString);
			admin_msg.setReceiveid(admin1.getId());
			admin_msg.setSendid(0);
			admin_msg.setStatus(0);
			admin_msgService.addadmin_msg(admin_msg);
		}
	}

	/*
	 * erp十五模块-公司归档-集团纸质归档(67) 审核
	 */
	@RequestMapping(value = "erp/erp_gsgdsh_67.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public void erp_gsgdsh_67(int adminid, String result_1_msg,
			int result_1_code, int type_id, int icbc_id,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		int status = 67;
		String remark = "集团纸质归档";
		PageData pdsession = (PageData) request.getSession().getAttribute("pd");// 获取session信息
		// 获取 车牌、vin、身份账号
		assess_cars aCars = icbc_carsService.findicbc_cars1(icbc_id);
		icbc icbc = newicbcService.findicbcbyid(icbc_id);
		// 保存进度之前先判断一下icbc_erp_kj_icbc表中是否有某个用户的某个板块
		PageData pdd = new PageData();
		pdd.put("dn", "selectOne_icbc_erp_kj_icbc");
		pdd.put("icbc_id", icbc_id);
		pdd.put("type_id", type_id);
		PageData pErpIcbc = erp_fiveModelService.findbyid(pdd);
		/*
		 * 操作明细记录 start/////
		 */
		// 保存 进度留言记录
		PageData pResult = new PageData();
		pResult.put("dn", "icbc_erp_kj_icbc_result");
		pResult.put("mid_add", adminid);
		pResult.put("mid_edit", adminid);
		pResult.put("dt_add", getMaxPagedate_7_9_11_12_14_15(icbc_id, type_id)
				.get("dt_edit"));
		pResult.put("dt_edit", creditutil.time());
		pResult.put("status", status);
		pResult.put("status_oldht", 0);
		pResult.put("remark", remark);
		pResult.put("result_1_msg", result_1_msg);
		pResult.put("result_1_code", result_1_code);
		pResult.put("result_1_value", "");
		pResult.put("dt_sub", creditutil.time());
		pResult.put("type_id", type_id);
		pResult.put("icbc_id", icbc_id);
		/*
		 * 操作明细记录 end/////
		 */
		if (pErpIcbc != null) {
			pResult.put("qryid", pErpIcbc.get("id"));
			erp_fiveModelService.save(pResult);
			// 更新icbc_erp_kj_icbc表中，status的最新装填
			PageData upd = new PageData();
			upd.put("dn", "update_icbc_erp_kj_icbc");
			upd.put("icbc_id", icbc_id);
			upd.put("type_id", type_id);
			upd.put("status", status);
			upd.put("mid_edit", adminid);
			upd.put("dt_edit", creditutil.time());
			erp_fiveModelService.updatebyid(upd);
		} else {
			PageData picbc = new PageData();
			picbc.put("dn", "icbc_erp_kj_icbc");
			picbc.put("mid_add", adminid);
			picbc.put("mid_edit", adminid);
			picbc.put("dt_add", creditutil.time());
			picbc.put("dt_edit", creditutil.time());
			picbc.put("dt_sub", creditutil.time());
			picbc.put("status", status);
			picbc.put("icbc_id", icbc_id);
			picbc.put("gems_id", pdsession.get("gems_id"));
			picbc.put("gems_fs_id", pdsession.get("fs_id"));
			picbc.put("type_id", type_id);
			if (aCars != null) {
				picbc.put("c_carno", aCars.getC_carno());
				picbc.put("c_carvin", aCars.getVincode());
			}
			if (icbc != null) {
				picbc.put("c_name", icbc.getC_name());
				picbc.put("c_cardno", icbc.getC_cardno());
			}
			erp_fiveModelService.save(picbc);
			// result添加数据
			pResult.put("qryid", picbc.get("id"));
			erp_fiveModelService.save(pResult);
		}
		// 推送
		String result_1_code_String = "状态";
		if (result_1_code == 1) {
			result_1_code_String = "通过";
		} else if (result_1_code == 2) {
			result_1_code_String = "不通过";
		}
		Map map = erp_fifteenModel.fifteenModel();
		admin admin1 = adminService.adminbyid(pErpIcbc.getInt("mid_add"));
		if (admin1 != null && !admin1.equals("")) {
			String REGISTRATION_ID = admin1.getJgid();
			String mString = admin1.getName() + "您好!" + "客户名称为"
					+ icbc.getC_name() + "的审核已更新" + ";" + map.get(type_id)
					+ "_" + remark + "材料审核状态:" + result_1_code_String + ";留言:"
					+ result_1_msg + "时间:" + creditutil.time() + ";";
			if (REGISTRATION_ID != null && !REGISTRATION_ID.equals("")) {
				Jdpush.testSendPush(appKey, masterSecret, REGISTRATION_ID,
						mString);
			}
			admin_msg admin_msg = new admin_msg();
			admin_msg.setDt_add(creditutil.time());
			admin_msg.setDt_edit(creditutil.time());
			admin_msg.setMid_add(adminid);
			admin_msg.setMsg(mString);
			admin_msg.setReceiveid(admin1.getId());
			admin_msg.setSendid(0);
			admin_msg.setStatus(0);
			admin_msgService.addadmin_msg(admin_msg);
		}
	}

	/*
	 * erp十五模块-内审通融-通融经理(45) 审核
	 */
	@RequestMapping(value = "erp/erp_nstrsh_45.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public void erp_nstrsh_45(int adminid, String result_1_msg, int type_id,
			int icbc_id, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int status = 45;
		String remark = "通融经理";
		PageData pdsession = (PageData) request.getSession().getAttribute("pd");// 获取session信息
		// 获取 车牌、vin、身份账号
		assess_cars aCars = icbc_carsService.findicbc_cars1(icbc_id);
		icbc icbc = newicbcService.findicbcbyid(icbc_id);
		// 保存进度之前先判断一下icbc_erp_kj_icbc表中是否有某个用户的某个板块
		PageData pdd = new PageData();
		pdd.put("dn", "selectOne_icbc_erp_kj_icbc");
		pdd.put("icbc_id", icbc_id);
		pdd.put("type_id", type_id);
		PageData pErpIcbc = erp_fiveModelService.findbyid(pdd);
		/*
		 * 操作明细记录 start/////
		 */
		// 保存 进度留言记录
		PageData pResult = new PageData();
		pResult.put("dn", "icbc_erp_kj_icbc_result");
		pResult.put("mid_add", adminid);
		pResult.put("mid_edit", adminid);
		pResult.put("dt_add", getMaxPagedate_7_9_11_12_14_15(icbc_id, type_id)
				.get("dt_edit"));
		pResult.put("dt_edit", creditutil.time());
		pResult.put("status", status);
		pResult.put("status_oldht", 0);
		pResult.put("remark", remark);
		pResult.put("result_1_msg", result_1_msg);
		pResult.put("result_1_code", 0);
		pResult.put("result_1_value", "");
		pResult.put("dt_sub", creditutil.time());
		pResult.put("type_id", type_id);
		pResult.put("icbc_id", icbc_id);
		/*
		 * 操作明细记录 end/////
		 */
		if (pErpIcbc != null) {
			pResult.put("qryid", pErpIcbc.get("id"));
			erp_fiveModelService.save(pResult);
			// 更新icbc_erp_kj_icbc表中，status的最新装填
			PageData upd = new PageData();
			upd.put("dn", "update_icbc_erp_kj_icbc");
			upd.put("icbc_id", icbc_id);
			upd.put("type_id", type_id);
			upd.put("status", status);
			upd.put("mid_edit", adminid);
			upd.put("dt_edit", creditutil.time());
			erp_fiveModelService.updatebyid(upd);
		} else {
			PageData picbc = new PageData();
			picbc.put("dn", "icbc_erp_kj_icbc");
			picbc.put("mid_add", adminid);
			picbc.put("mid_edit", adminid);
			picbc.put("dt_add", creditutil.time());
			picbc.put("dt_edit", creditutil.time());
			picbc.put("dt_sub", creditutil.time());
			picbc.put("status", status);
			picbc.put("icbc_id", icbc_id);
			picbc.put("gems_id", pdsession.get("gems_id"));
			picbc.put("gems_fs_id", pdsession.get("fs_id"));
			picbc.put("type_id", type_id);
			if (aCars != null) {
				picbc.put("c_carno", aCars.getC_carno());
				picbc.put("c_carvin", aCars.getVincode());
			}
			if (icbc != null) {
				picbc.put("c_name", icbc.getC_name());
				picbc.put("c_cardno", icbc.getC_cardno());
			}
			erp_fiveModelService.save(picbc);
			// result添加数据
			pResult.put("qryid", picbc.get("id"));
			erp_fiveModelService.save(pResult);
		}
		// 当确认 为 "通过"时
		// icbc表更新记录 和 result 表存一条完成记录
		if (1 == 1) {
			// 更新icbc_erp_kj_icbc表中，status的最新装填
			PageData upd = new PageData();
			upd.put("dn", "update_icbc_erp_kj_icbc");
			upd.put("icbc_id", icbc_id);
			upd.put("type_id", type_id);
			upd.put("status", 46);
			upd.put("mid_edit", adminid); // 修改人id
			upd.put("dt_edit", creditutil.time()); // 修改时间
			erp_fiveModelService.updatebyid(upd);
			PageData pResult_gsgd = new PageData();
			pResult_gsgd.put("dn", "icbc_erp_kj_icbc_result");
			pResult_gsgd.put("qryid", pErpIcbc.get("id"));
			pResult_gsgd.put("mid_add", adminid);
			pResult_gsgd.put("mid_edit", adminid);
			pResult_gsgd.put("dt_add", creditutil.time());
			pResult_gsgd.put("dt_edit", creditutil.time());
			pResult_gsgd.put("status", 46);
			pResult_gsgd.put("status_oldht", 0);
			pResult_gsgd.put("remark", "完成");
			pResult_gsgd.put("result_1_code", 0);
			pResult_gsgd.put("dt_sub", creditutil.time());
			pResult_gsgd.put("type_id", type_id);
			pResult_gsgd.put("icbc_id", icbc_id);
			erp_fiveModelService.save(pResult_gsgd); // 保存 公司归档存 icbc result表
		}
		// 推送
		Map map = erp_fifteenModel.fifteenModel();
		admin admin1 = adminService.adminbyid(pErpIcbc.getInt("mid_add"));
		if (admin1 != null && !admin1.equals("")) {
			String REGISTRATION_ID = admin1.getJgid();
			String mString = admin1.getName() + "您好!" + "客户名称为"
					+ icbc.getC_name() + "的审核已更新" + ";正在进行" + remark + "审核"
					+ ";留言:" + result_1_msg + "时间:" + creditutil.time() + ";";
			if (REGISTRATION_ID != null && !REGISTRATION_ID.equals("")) {
				Jdpush.testSendPush(appKey, masterSecret, REGISTRATION_ID,
						mString);
			}
			admin_msg admin_msg = new admin_msg();
			admin_msg.setDt_add(creditutil.time());
			admin_msg.setDt_edit(creditutil.time());
			admin_msg.setMid_add(adminid);
			admin_msg.setMsg(mString);
			admin_msg.setReceiveid(admin1.getId());
			admin_msg.setSendid(0);
			admin_msg.setStatus(0);
			admin_msgService.addadmin_msg(admin_msg);
		}
	}

	/*
	 * erp十五模块-内审通融-通融主管(44) 审核
	 */
	@RequestMapping(value = "erp/erp_nstrsh_44.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public void erp_nstrsh_44(int adminid, String result_1_msg, int type_id,
			int icbc_id, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int status = 44;
		String remark = "通融主管";
		PageData pdsession = (PageData) request.getSession().getAttribute("pd");// 获取session信息
		// 获取 车牌、vin、身份账号
		assess_cars aCars = icbc_carsService.findicbc_cars1(icbc_id);
		icbc icbc = newicbcService.findicbcbyid(icbc_id);
		// 保存进度之前先判断一下icbc_erp_kj_icbc表中是否有某个用户的某个板块
		PageData pdd = new PageData();
		pdd.put("dn", "selectOne_icbc_erp_kj_icbc");
		pdd.put("icbc_id", icbc_id);
		pdd.put("type_id", type_id);
		PageData pErpIcbc = erp_fiveModelService.findbyid(pdd);
		/*
		 * 操作明细记录 start/////
		 */
		// 保存 进度留言记录
		PageData pResult = new PageData();
		pResult.put("dn", "icbc_erp_kj_icbc_result");
		pResult.put("mid_add", adminid);
		pResult.put("mid_edit", adminid);
		pResult.put("dt_add", getMaxPagedate_7_9_11_12_14_15(icbc_id, type_id)
				.get("dt_edit"));
		pResult.put("dt_edit", creditutil.time());
		pResult.put("status", status);
		pResult.put("status_oldht", 0);
		pResult.put("remark", remark);
		pResult.put("result_1_msg", result_1_msg);
		pResult.put("result_1_code", 0);
		pResult.put("result_1_value", "");
		pResult.put("dt_sub", creditutil.time());
		pResult.put("type_id", type_id);
		pResult.put("icbc_id", icbc_id);
		/*
		 * 操作明细记录 end/////
		 */
		if (pErpIcbc != null) {
			pResult.put("qryid", pErpIcbc.get("id"));
			erp_fiveModelService.save(pResult);
			// 更新icbc_erp_kj_icbc表中，status的最新装填
			PageData upd = new PageData();
			upd.put("dn", "update_icbc_erp_kj_icbc");
			upd.put("icbc_id", icbc_id);
			upd.put("type_id", type_id);
			upd.put("status", status);
			upd.put("mid_edit", adminid);
			upd.put("dt_edit", creditutil.time());
			erp_fiveModelService.updatebyid(upd);
		} else {
			PageData picbc = new PageData();
			picbc.put("dn", "icbc_erp_kj_icbc");
			picbc.put("mid_add", adminid);
			picbc.put("mid_edit", adminid);
			picbc.put("dt_add", creditutil.time());
			picbc.put("dt_edit", creditutil.time());
			picbc.put("dt_sub", creditutil.time());
			picbc.put("status", status);
			picbc.put("icbc_id", icbc_id);
			picbc.put("gems_id", pdsession.get("gems_id"));
			picbc.put("gems_fs_id", pdsession.get("fs_id"));
			picbc.put("type_id", type_id);
			if (aCars != null) {
				picbc.put("c_carno", aCars.getC_carno());
				picbc.put("c_carvin", aCars.getVincode());
			}
			if (icbc != null) {
				picbc.put("c_name", icbc.getC_name());
				picbc.put("c_cardno", icbc.getC_cardno());
			}
			erp_fiveModelService.save(picbc);
			// result添加数据
			pResult.put("qryid", picbc.get("id"));
			erp_fiveModelService.save(pResult);
		}
		// 推送
		Map map = erp_fifteenModel.fifteenModel();
		admin admin1 = adminService.adminbyid(pErpIcbc.getInt("mid_add"));
		if (admin1 != null && !admin1.equals("")) {
			String REGISTRATION_ID = admin1.getJgid();
			String mString = admin1.getName() + "您好!" + "客户名称为"
					+ icbc.getC_name() + "的审核已更新" + ";正在进行" + remark + "审核"
					+ ";留言:" + result_1_msg + "时间:" + creditutil.time() + ";";
			if (REGISTRATION_ID != null && !REGISTRATION_ID.equals("")) {
				Jdpush.testSendPush(appKey, masterSecret, REGISTRATION_ID,
						mString);
			}
			admin_msg admin_msg = new admin_msg();
			admin_msg.setDt_add(creditutil.time());
			admin_msg.setDt_edit(creditutil.time());
			admin_msg.setMid_add(adminid);
			admin_msg.setMsg(mString);
			admin_msg.setReceiveid(admin1.getId());
			admin_msg.setSendid(0);
			admin_msg.setStatus(0);
			admin_msgService.addadmin_msg(admin_msg);
		}
	}

	/*
	 * erp十五模块-内审通融-审核员通融审核意见反馈(43) 审核
	 */
	@RequestMapping(value = "erp/erp_nstrsh_43.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public void erp_nstrsh_43(int adminid, String result_1_msg, int type_id,
			int icbc_id, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int status = 43;
		String remark = "审核员通融审核意见反馈";
		PageData pdsession = (PageData) request.getSession().getAttribute("pd");// 获取session信息
		// 获取 车牌、vin、身份账号
		assess_cars aCars = icbc_carsService.findicbc_cars1(icbc_id);
		icbc icbc = newicbcService.findicbcbyid(icbc_id);
		// 保存进度之前先判断一下icbc_erp_kj_icbc表中是否有某个用户的某个板块
		PageData pdd = new PageData();
		pdd.put("dn", "selectOne_icbc_erp_kj_icbc");
		pdd.put("icbc_id", icbc_id);
		pdd.put("type_id", type_id);
		PageData pErpIcbc = erp_fiveModelService.findbyid(pdd);
		/*
		 * 操作明细记录 start/////
		 */
		// 保存 进度留言记录
		PageData pResult = new PageData();
		pResult.put("dn", "icbc_erp_kj_icbc_result");
		pResult.put("mid_add", adminid);
		pResult.put("mid_edit", adminid);
		pResult.put("dt_add", getMaxPagedate_7_9_11_12_14_15(icbc_id, type_id)
				.get("dt_edit"));
		pResult.put("dt_edit", creditutil.time());
		pResult.put("status", status);
		pResult.put("status_oldht", 0);
		pResult.put("remark", remark);
		pResult.put("result_1_msg", result_1_msg);
		pResult.put("result_1_code", 0);
		pResult.put("result_1_value", "");
		pResult.put("dt_sub", creditutil.time());
		pResult.put("type_id", type_id);
		pResult.put("icbc_id", icbc_id);
		/*
		 * 操作明细记录 end/////
		 */
		if (pErpIcbc != null) {
			pResult.put("qryid", pErpIcbc.get("id"));
			erp_fiveModelService.save(pResult);
			// 更新icbc_erp_kj_icbc表中，status的最新装填
			PageData upd = new PageData();
			upd.put("dn", "update_icbc_erp_kj_icbc");
			upd.put("icbc_id", icbc_id);
			upd.put("type_id", type_id);
			upd.put("status", status);
			upd.put("mid_edit", adminid);
			upd.put("dt_edit", creditutil.time());
			erp_fiveModelService.updatebyid(upd);
		} else {
			PageData picbc = new PageData();
			picbc.put("dn", "icbc_erp_kj_icbc");
			picbc.put("mid_add", adminid);
			picbc.put("mid_edit", adminid);
			picbc.put("dt_add", creditutil.time());
			picbc.put("dt_edit", creditutil.time());
			picbc.put("dt_sub", creditutil.time());
			picbc.put("status", status);
			picbc.put("icbc_id", icbc_id);
			picbc.put("gems_id", pdsession.get("gems_id"));
			picbc.put("gems_fs_id", pdsession.get("fs_id"));
			picbc.put("type_id", type_id);
			if (aCars != null) {
				picbc.put("c_carno", aCars.getC_carno());
				picbc.put("c_carvin", aCars.getVincode());
			}
			if (icbc != null) {
				picbc.put("c_name", icbc.getC_name());
				picbc.put("c_cardno", icbc.getC_cardno());
			}
			erp_fiveModelService.save(picbc);
			// result添加数据
			pResult.put("qryid", picbc.get("id"));
			erp_fiveModelService.save(pResult);
		}
		// 推送
		Map map = erp_fifteenModel.fifteenModel();
		admin admin1 = adminService.adminbyid(pErpIcbc.getInt("mid_add"));
		if (admin1 != null && !admin1.equals("")) {
			String REGISTRATION_ID = admin1.getJgid();
			String mString = admin1.getName() + "您好!" + "客户名称为"
					+ icbc.getC_name() + "的审核已更新" + ";" + map.get(type_id)
					+ "_" + remark + ":" + result_1_msg + "时间:"
					+ creditutil.time() + ";";
			if (REGISTRATION_ID != null && !REGISTRATION_ID.equals("")) {
				Jdpush.testSendPush(appKey, masterSecret, REGISTRATION_ID,
						mString);
			}
			admin_msg admin_msg = new admin_msg();
			admin_msg.setDt_add(creditutil.time());
			admin_msg.setDt_edit(creditutil.time());
			admin_msg.setMid_add(adminid);
			admin_msg.setMsg(mString);
			admin_msg.setReceiveid(admin1.getId());
			admin_msg.setSendid(0);
			admin_msg.setStatus(0);
			admin_msgService.addadmin_msg(admin_msg);
		}
	}

	/*
	 * erp十五模块-内审通融-机构总经理申请通融(42) 审核
	 */
	@RequestMapping(value = "erp/erp_nstrsh_42.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public void erp_nstrsh_42(int adminid, String result_1_msg, int type_id,
			int icbc_id, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// 添加开始
		erp_sh_add(adminid, type_id, icbc_id, request, response);
		int status = 42;
		String remark = "机构总经理申请通融";
		PageData pdsession = (PageData) request.getSession().getAttribute("pd");// 获取session信息
		// 获取 车牌、vin、身份账号
		assess_cars aCars = icbc_carsService.findicbc_cars1(icbc_id);
		icbc icbc = newicbcService.findicbcbyid(icbc_id);
		// 保存进度之前先判断一下icbc_erp_kj_icbc表中是否有某个用户的某个板块
		PageData pdd = new PageData();
		pdd.put("dn", "selectOne_icbc_erp_kj_icbc");
		pdd.put("icbc_id", icbc_id);
		pdd.put("type_id", type_id);
		PageData pErpIcbc = erp_fiveModelService.findbyid(pdd);
		/*
		 * 操作明细记录 start/////
		 */
		// 保存 进度留言记录
		PageData pResult = new PageData();
		pResult.put("dn", "icbc_erp_kj_icbc_result");
		pResult.put("mid_add", adminid);
		pResult.put("mid_edit", adminid);
		pResult.put("dt_add", getMaxPagedate_7_9_11_12_14_15(icbc_id, type_id)
				.get("dt_edit"));
		pResult.put("dt_edit", creditutil.time());
		pResult.put("status", status);
		pResult.put("status_oldht", 0);
		pResult.put("remark", remark);
		pResult.put("result_1_msg", result_1_msg);
		pResult.put("result_1_code", 0);
		pResult.put("result_1_value", "");
		pResult.put("dt_sub", creditutil.time());
		pResult.put("type_id", type_id);
		pResult.put("icbc_id", icbc_id);
		/*
		 * 操作明细记录 end/////
		 */
		if (pErpIcbc != null) {
			pResult.put("qryid", pErpIcbc.get("id"));
			erp_fiveModelService.save(pResult);
			// 更新icbc_erp_kj_icbc表中，status的最新装填
			PageData upd = new PageData();
			upd.put("dn", "update_icbc_erp_kj_icbc");
			upd.put("icbc_id", icbc_id);
			upd.put("type_id", type_id);
			upd.put("status", status);
			upd.put("mid_edit", adminid);
			upd.put("dt_edit", creditutil.time());
			erp_fiveModelService.updatebyid(upd);
		} else {
			PageData picbc = new PageData();
			picbc.put("dn", "icbc_erp_kj_icbc");
			picbc.put("mid_add", adminid);
			picbc.put("mid_edit", adminid);
			picbc.put("dt_add", creditutil.time());
			picbc.put("dt_edit", creditutil.time());
			picbc.put("dt_sub", creditutil.time());
			picbc.put("status", status);
			picbc.put("icbc_id", icbc_id);
			picbc.put("gems_id", pdsession.get("gems_id"));
			picbc.put("gems_fs_id", pdsession.get("fs_id"));
			picbc.put("type_id", type_id);
			if (aCars != null) {
				picbc.put("c_carno", aCars.getC_carno());
				picbc.put("c_carvin", aCars.getVincode());
			}
			if (icbc != null) {
				picbc.put("c_name", icbc.getC_name());
				picbc.put("c_cardno", icbc.getC_cardno());
			}
			erp_fiveModelService.save(picbc);
			// result添加数据
			pResult.put("qryid", picbc.get("id"));
			erp_fiveModelService.save(pResult);
		}
		// 推送
		/*
		 * Map map=erp_fifteenModel.fifteenModel(); admin
		 * admin1=adminService.adminbyid(pErpIcbc.getInt("mid_add"));
		 * if(admin1!=null&&!admin1.equals("")){ String
		 * REGISTRATION_ID=admin1.getJgid(); String mString=admin1.getName()
		 * +"您好!" +"客户名称为" +icbc.getC_name()+"的审核已更新"
		 * +";正在进行"+map.get(type_id)+"_"+remark +";留言:"+result_1_msg
		 * +"时间:"+creditutil.time()+";";
		 * if(REGISTRATION_ID!=null&&!REGISTRATION_ID.equals("")){
		 * Jdpush.testSendPush(appKey,masterSecret,REGISTRATION_ID,mString); }
		 * admin_msg admin_msg=new admin_msg();
		 * admin_msg.setDt_add(creditutil.time());
		 * admin_msg.setDt_edit(creditutil.time());
		 * admin_msg.setMid_add(adminid); admin_msg.setMsg(mString);
		 * admin_msg.setReceiveid(admin1.getId()); admin_msg.setSendid(0);
		 * admin_msg.setStatus(0); admin_msgService.addadmin_msg(admin_msg); }
		 */
	}

	/*
	 * erp十五模块-add 退单退费15、业务信息修改14、内审通融9、跨区域业务审批7
	 */
	@RequestMapping(value = "erp/erp_sh_add.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public void erp_sh_add(int adminid, int type_id, int icbc_id,
			HttpServletRequest request, HttpServletResponse response) {
		PageData pdsession = (PageData) request.getSession().getAttribute("pd");// 获取session信息
		int status = 0;
		switch (type_id) {
		case 7:
			status = 26;
			break;
		case 9:
			status = 41;
			break;
		case 14:
			status = 83;
			break;
		case 15:
			status = 87;
			break;
		default:
			break;
		}
		// 获取 车牌、vin、身份账号
		assess_cars aCars = icbc_carsService.findicbc_cars1(icbc_id);
		icbc icbc = newicbcService.findicbcbyid(icbc_id);
		// 保存进度之前先判断一下icbc_erp_kj_icbc表中是否有某个用户的某个板块
		PageData pdd = new PageData();
		pdd.put("dn", "selectOne_icbc_erp_kj_icbc");
		pdd.put("icbc_id", icbc_id);
		pdd.put("type_id", type_id);
		PageData pErpIcbc = erp_fiveModelService.findbyid(pdd);

		// 判断一下icbc_erp_kj_icbc表中是否有某个用户的某个板块
		PageData pdd_status = new PageData();
		pdd_status.put("dn", "selectOneStatus_icbc_erp_kj_icbc_result");
		pdd_status.put("icbc_id", icbc_id);
		pdd_status.put("type_id", type_id);
		pdd_status.put("status", status); // 内审通融开始
		PageData pErpIcbc_status = erp_fiveModelService.findbyid(pdd_status);
		/*
		 * 操作明细记录 start/////
		 */
		// 保存 进度留言记录
		PageData pResult = new PageData();
		pResult.put("dn", "icbc_erp_kj_icbc_result");
		pResult.put("mid_add", adminid);
		pResult.put("mid_edit", adminid);
		pResult.put("dt_add", creditutil.time());
		pResult.put("dt_edit", creditutil.time());
		pResult.put("status", status);
		pResult.put("status_oldht", 0);
		pResult.put("remark", "开始");
		pResult.put("dt_sub", creditutil.time());
		pResult.put("type_id", type_id);
		pResult.put("icbc_id", icbc_id);
		/*
		 * 操作明细记录 end/////
		 */
		if (pErpIcbc != null) {
			if (pErpIcbc_status == null) {
				pResult.put("qryid", pErpIcbc.get("id"));
				erp_fiveModelService.save(pResult);
			}
		} else {
			PageData picbc = new PageData();
			picbc.put("dn", "icbc_erp_kj_icbc");
			picbc.put("mid_add", adminid);
			picbc.put("mid_edit", adminid);
			picbc.put("dt_add", creditutil.time());
			picbc.put("dt_edit", creditutil.time());
			picbc.put("dt_sub", creditutil.time());
			picbc.put("status", status);
			picbc.put("icbc_id", icbc_id);
			picbc.put("gems_id", pdsession.get("gems_id"));
			picbc.put("gems_fs_id", pdsession.get("fs_id"));
			picbc.put("type_id", type_id); // 银行申请贷款 对应 11
			if (aCars != null) {
				picbc.put("c_carno", aCars.getC_carno());
				picbc.put("c_carvin", aCars.getVincode());
			}
			if (icbc != null) {
				picbc.put("c_name", icbc.getC_name());
				picbc.put("c_cardno", icbc.getC_cardno());
			}
			erp_fiveModelService.save(picbc);
			// result添加数据
			pResult.put("qryid", picbc.get("id"));
			erp_fiveModelService.save(pResult);
		}
	}

	/*
	 * erp十五模块-银行申请贷款-补充材料确认(63) 审核
	 */
	@RequestMapping(value = "erp/erp_yhdksh_63.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public void erp_yhdksh_63(int adminid, int result_1_code,
			String result_1_msg, int type_id, int icbc_id,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		PageData pdsession = (PageData) request.getSession().getAttribute("pd");// 获取session信息
		// 获取 车牌、vin、身份账号
		assess_cars aCars = icbc_carsService.findicbc_cars1(icbc_id);
		icbc icbc = newicbcService.findicbcbyid(icbc_id);
		// 保存进度之前先判断一下icbc_erp_kj_icbc表中是否有某个用户的某个板块
		PageData pdd = new PageData();
		pdd.put("dn", "selectOne_icbc_erp_kj_icbc");
		pdd.put("icbc_id", icbc_id);
		pdd.put("type_id", type_id); // 银行申请贷款 对应 11
		PageData pErpIcbc = erp_fiveModelService.findbyid(pdd);
		/*
		 * 操作明细记录 start/////
		 */
		// 保存 进度留言记录
		PageData pResult = new PageData();
		pResult.put("dn", "icbc_erp_kj_icbc_result");
		pResult.put("mid_add", adminid);
		pResult.put("mid_edit", adminid);
		pResult.put("dt_add", getMaxPagedate_7_9_11_12_14_15(icbc_id, type_id)
				.get("dt_edit"));
		pResult.put("dt_edit", creditutil.time());
		pResult.put("status", 63);
		pResult.put("status_oldht", 0);
		pResult.put("remark", "补充材料确认");
		pResult.put("result_1_msg", result_1_msg);
		pResult.put("result_1_code", result_1_code);
		pResult.put("dt_sub", creditutil.time());
		pResult.put("type_id", type_id); // 银行申请贷款 对应 11
		pResult.put("icbc_id", icbc_id);
		/*
		 * 操作明细记录 end/////
		 */
		if (pErpIcbc != null) {
			pResult.put("qryid", pErpIcbc.get("id"));
			erp_fiveModelService.save(pResult);
			// 更新icbc_erp_kj_icbc表中，status的最新装填
			PageData upd = new PageData();
			upd.put("dn", "update_icbc_erp_kj_icbc");
			upd.put("icbc_id", icbc_id);
			upd.put("type_id", type_id); // 银行申请贷款 对应 11
			upd.put("status", 63);
			upd.put("mid_edit", adminid); // 修改人id
			upd.put("dt_edit", creditutil.time()); // 修改时间
			erp_fiveModelService.updatebyid(upd);
		} else {
			PageData picbc = new PageData();
			picbc.put("dn", "icbc_erp_kj_icbc");
			picbc.put("mid_add", adminid);
			picbc.put("mid_edit", adminid);
			picbc.put("dt_add", creditutil.time());
			picbc.put("dt_edit", creditutil.time());
			picbc.put("dt_sub", creditutil.time());
			picbc.put("status", 63);
			picbc.put("icbc_id", icbc_id);
			picbc.put("gems_id", pdsession.get("gems_id"));
			picbc.put("gems_fs_id", pdsession.get("fs_id"));
			picbc.put("type_id", type_id); // 银行申请贷款 对应 11
			if (aCars != null) {
				picbc.put("c_carno", aCars.getC_carno());
				picbc.put("c_carvin", aCars.getVincode());
			}
			if (icbc != null) {
				picbc.put("c_name", icbc.getC_name());
				picbc.put("c_cardno", icbc.getC_cardno());
			}
			erp_fiveModelService.save(picbc);
			// result添加数据
			pResult.put("qryid", picbc.get("id"));
			erp_fiveModelService.save(pResult);
		}
		// 如果为完整的话, 添加一条 56状态的数据
		if (result_1_code == 1) {
			// 更新icbc_erp_kj_icbc表中，status的最新装填
			PageData upd = new PageData();
			upd.put("dn", "update_icbc_erp_kj_icbc");
			upd.put("icbc_id", icbc_id);
			upd.put("type_id", type_id); // 银行申请贷款 对应 11
			upd.put("status", 56);
			upd.put("mid_edit", adminid); // 修改人id
			upd.put("dt_edit", creditutil.time()); // 修改时间
			erp_fiveModelService.updatebyid(upd);
			PageData pResult_gsgd = new PageData();
			pResult_gsgd.put("dn", "icbc_erp_kj_icbc_result");
			pResult_gsgd.put("qryid", pErpIcbc.get("id"));
			pResult_gsgd.put("mid_add", adminid);
			pResult_gsgd.put("mid_edit", adminid);
			pResult_gsgd.put("dt_add", creditutil.time());
			pResult_gsgd.put("dt_edit", creditutil.time());
			pResult_gsgd.put("status", 56);
			pResult_gsgd.put("status_oldht", 0);
			pResult_gsgd.put("remark", "抵押归档开始");
			pResult_gsgd.put("result_1_code", result_1_code);
			pResult_gsgd.put("dt_sub", creditutil.time());
			pResult_gsgd.put("type_id", 11); // 银行申请贷款 对应 11
			pResult_gsgd.put("icbc_id", icbc_id);
			erp_fiveModelService.save(pResult_gsgd);
		}
		// 推送
		String result_1_code_String = "状态";
		if (result_1_code == 1) {
			result_1_code_String = "材料完整";
		} else if (result_1_code == 2) {
			result_1_code_String = "材料不完整，需要机构补充";
		}
		// 推送
		Map map = erp_fifteenModel.fifteenModel();
		admin admin1 = adminService.adminbyid(pErpIcbc.getInt("mid_add"));
		if (admin1 != null && !admin1.equals("")) {
			String REGISTRATION_ID = admin1.getJgid();
			String mString = admin1.getName() + "您好!" + "客户名称为"
					+ icbc.getC_name() + "的审核已更新" + ";" + map.get(type_id)
					+ "_补充材料确认状态:" + result_1_code_String + ";留言:"
					+ result_1_msg + "时间:" + creditutil.time() + ";";
			if (REGISTRATION_ID != null && !REGISTRATION_ID.equals("")) {
				Jdpush.testSendPush(appKey, masterSecret, REGISTRATION_ID,
						mString);
			}
			admin_msg admin_msg = new admin_msg();
			admin_msg.setDt_add(creditutil.time());
			admin_msg.setDt_edit(creditutil.time());
			admin_msg.setMid_add(adminid);
			admin_msg.setMsg(mString);
			admin_msg.setReceiveid(admin1.getId());
			admin_msg.setSendid(0);
			admin_msg.setStatus(0);
			admin_msgService.addadmin_msg(admin_msg);
		}

	}

	/*
	 * erp十五模块-银行申请贷款-收款确认(62) 审核
	 */
	@RequestMapping(value = "erp/erp_yhdksh_62.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public void erp_yhdksh_62(int adminid, int result_1_code2,
			String yhdksh_62_fkrq, String yhdksh_62_fkje,
			String yhdksh_62_sqrq, String result_1_msg, String gems_id,
			String gems_fs_id, int type_id, int icbc_id,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		PageData pdsession = (PageData) request.getSession().getAttribute("pd");// 获取session信息
		// 获取 车牌、vin、身份账号
		assess_cars aCars = icbc_carsService.findicbc_cars1(icbc_id);
		icbc icbc = newicbcService.findicbcbyid(icbc_id);
		// 保存进度之前先判断一下icbc_erp_kj_icbc表中是否有某个用户的某个板块
		PageData pdd = new PageData();
		pdd.put("dn", "selectOne_icbc_erp_kj_icbc");
		pdd.put("icbc_id", icbc_id);
		pdd.put("type_id", type_id); // 银行申请贷款 对应 11
		PageData pErpIcbc = erp_fiveModelService.findbyid(pdd);
		/*
		 * 操作明细记录 start/////
		 */
		// 保存 进度留言记录
		PageData pResult = new PageData();
		pResult.put("dn", "icbc_erp_kj_icbc_result");
		pResult.put("mid_add", adminid);
		pResult.put("mid_edit", adminid);
		pResult.put("dt_add", getMaxPagedate_7_9_11_12_14_15(icbc_id, type_id)
				.get("dt_edit"));
		pResult.put("dt_edit", creditutil.time());
		pResult.put("status", 62);
		pResult.put("status_oldht", 0);
		pResult.put("remark", "收款确认");
		// 新增放款日期 金额字段
		pResult.put("fk_date", yhdksh_62_fkrq);
		pResult.put("fk_money", yhdksh_62_fkje);
		JSONObject json = new JSONObject();
		json.put("62_fkrq", yhdksh_62_fkrq);
		json.put("62_fkje", yhdksh_62_fkje);
		json.put("62_sqrq", yhdksh_62_sqrq);
		pResult.put("result_1_value", json.toString());
		pResult.put("result_1_msg", result_1_msg);
		pResult.put("result_1_code", result_1_code2);
		pResult.put("dt_sub", creditutil.time());
		pResult.put("type_id", type_id); // 银行申请贷款 对应 11
		pResult.put("icbc_id", icbc_id);

		/*
		 * 操作明细记录 end/////
		 */
		if (pErpIcbc != null) {
			pResult.put("qryid", pErpIcbc.get("id"));
			erp_fiveModelService.save(pResult);
			// 更新icbc_erp_kj_icbc表中，status的最新装填
			PageData upd = new PageData();
			upd.put("dn", "update_icbc_erp_kj_icbc");
			upd.put("icbc_id", icbc_id);
			upd.put("type_id", type_id); // 银行申请贷款 对应 11
			upd.put("status", 62);
			upd.put("mid_edit", adminid); // 修改人id
			upd.put("dt_edit", creditutil.time()); // 修改时间
			erp_fiveModelService.updatebyid(upd);
		} else {
			PageData picbc = new PageData();
			picbc.put("dn", "icbc_erp_kj_icbc");
			picbc.put("mid_add", adminid);
			picbc.put("mid_edit", adminid);
			picbc.put("dt_add", creditutil.time());
			picbc.put("dt_edit", creditutil.time());
			picbc.put("dt_sub", creditutil.time());
			picbc.put("status", 62);
			picbc.put("icbc_id", icbc_id);
			picbc.put("gems_id", pdsession.get("gems_id"));
			picbc.put("gems_fs_id", pdsession.get("fs_id"));
			picbc.put("type_id", type_id); // 银行申请贷款 对应 11
			if (aCars != null) {
				picbc.put("c_carno", aCars.getC_carno());
				picbc.put("c_carvin", aCars.getVincode());
			}
			if (icbc != null) {
				picbc.put("c_name", icbc.getC_name());
				picbc.put("c_cardno", icbc.getC_cardno());
			}
			erp_fiveModelService.save(picbc);
			// result添加数据
			pResult.put("qryid", picbc.get("id"));
			erp_fiveModelService.save(pResult);
		}
		// 当银行收件确认 为 确认收到款时,资金分配 亮起
		// 抵押归档 icbc表 和 result 表各存一条开始记录
		// 得到是否 资金分配
		PageData pdd_status = new PageData();
		pdd_status.put("dn", "selectListStatus_icbc_erp_kj_icbc_result");
		pdd_status.put("icbc_id", icbc_id);
		pdd_status.put("type_id", 10); // 资金分配-板块
		pdd_status.put("status", 47); // 资金分配开始 -小状态
		List<PageData> pErpIcbc_47 = new ArrayList<>();
		pErpIcbc_47 = erp_fiveModelService.findtolist(pdd_status);
		if (result_1_code2 == 1) {
			if (pErpIcbc_47.size() > 0) {
				// pErpIcbc_66.size()>0 说明有 公司归档开始 -小状态 小状态啦
				// 则不必再添加
			} else {
				// 否则 添加
				PageData picbc_gsgd = new PageData();
				picbc_gsgd.put("dn", "icbc_erp_kj_icbc");
				picbc_gsgd.put("mid_add", adminid);
				picbc_gsgd.put("mid_edit", adminid);
				picbc_gsgd.put("dt_add", creditutil.time());
				picbc_gsgd.put("dt_edit", creditutil.time());
				picbc_gsgd.put("dt_sub", creditutil.time());
				picbc_gsgd.put("status", 47);
				picbc_gsgd.put("icbc_id", icbc_id);
				picbc_gsgd.put("gems_id", gems_id);
				picbc_gsgd.put("gems_fs_id", gems_fs_id);
				picbc_gsgd.put("type_id", 10); // 资金分配 对应 10
				if (aCars != null) {
					picbc_gsgd.put("c_carno", aCars.getC_carno());
					picbc_gsgd.put("c_carvin", aCars.getVincode());
				}
				if (icbc != null) {
					picbc_gsgd.put("c_name", icbc.getC_name());
					picbc_gsgd.put("c_cardno", icbc.getC_cardno());
				}
				erp_fiveModelService.save(picbc_gsgd); // 保存 公司归档存 icbc表
				PageData pResult_gsgd = new PageData();
				pResult_gsgd.put("dn", "icbc_erp_kj_icbc_result");
				pResult_gsgd.put("qryid", picbc_gsgd.get("id"));
				pResult_gsgd.put("mid_add", adminid);
				pResult_gsgd.put("mid_edit", adminid);
				pResult_gsgd.put("dt_add", creditutil.time());
				pResult_gsgd.put("dt_edit", creditutil.time());
				pResult_gsgd.put("status", 47);
				pResult_gsgd.put("status_oldht", 0);
				pResult_gsgd.put("remark", "资金分配开始");
				pResult_gsgd.put("result_1_code", result_1_code2);
				pResult_gsgd.put("dt_sub", creditutil.time());
				pResult_gsgd.put("type_id", 10); // 资金分配 对应 10
				pResult_gsgd.put("icbc_id", icbc_id);
				erp_fiveModelService.save(pResult_gsgd); // 保存 公司归档存 icbc
															// result表
			}
		}
		// 当确认 为 "通过"时
		// icbc表更新记录 和 result 表存一条完成记录
		if (result_1_code2 == 1) {
			// 更新icbc_erp_kj_icbc表中，status的最新装填
			PageData upd = new PageData();
			upd.put("dn", "update_icbc_erp_kj_icbc");
			upd.put("icbc_id", icbc_id);
			upd.put("type_id", type_id);
			upd.put("status", 65);
			upd.put("mid_edit", adminid); // 修改人id
			upd.put("dt_edit", creditutil.time()); // 修改时间
			erp_fiveModelService.updatebyid(upd);
			PageData pResult_gsgd = new PageData();
			pResult_gsgd.put("dn", "icbc_erp_kj_icbc_result");
			pResult_gsgd.put("qryid", pErpIcbc.get("id"));
			pResult_gsgd.put("mid_add", adminid);
			pResult_gsgd.put("mid_edit", adminid);
			pResult_gsgd.put("dt_add", creditutil.time());
			pResult_gsgd.put("dt_edit", creditutil.time());
			pResult_gsgd.put("status", 65);
			pResult_gsgd.put("status_oldht", 0);
			pResult_gsgd.put("remark", "完成");
			pResult_gsgd.put("result_1_code", 0);
			pResult_gsgd.put("dt_sub", creditutil.time());
			pResult_gsgd.put("type_id", type_id);
			pResult_gsgd.put("icbc_id", icbc_id);
			erp_fiveModelService.save(pResult_gsgd); // 保存 公司归档存 icbc result表
		}
		// 推送
		String result_1_code_String = "状态";
		if (result_1_code2 == 1) {
			result_1_code_String = "到账确认，本单已完整";
		} else if (result_1_code2 == 2) {
			result_1_code_String = "未收到款项";
		} else if (result_1_code2 == 3) {
			result_1_code_String = "收款金额不符";
		}
		Map map = erp_fifteenModel.fifteenModel();
		admin admin1 = adminService.adminbyid(pErpIcbc.getInt("mid_add"));
		if (admin1 != null && !admin1.equals("")) {
			String REGISTRATION_ID = admin1.getJgid();
			String mString = admin1.getName() + "您好!" + "客户名称为"
					+ icbc.getC_name() + "的审核已更新" + ";" + map.get(type_id)
					+ "_" + "收款确认状态:" + result_1_code_String + ";留言:"
					+ result_1_msg + "时间:" + creditutil.time() + ";";
			if (REGISTRATION_ID != null && !REGISTRATION_ID.equals("")) {
				Jdpush.testSendPush(appKey, masterSecret, REGISTRATION_ID,
						mString);
			}
			admin_msg admin_msg = new admin_msg();
			admin_msg.setDt_add(creditutil.time());
			admin_msg.setDt_edit(creditutil.time());
			admin_msg.setMid_add(adminid);
			admin_msg.setMsg(mString);
			admin_msg.setReceiveid(admin1.getId());
			admin_msg.setSendid(0);
			admin_msg.setStatus(0);
			admin_msgService.addadmin_msg(admin_msg);
		}
	}

	/*
	 * erp十五模块-银行申请贷款-银行放款结果(61) 审核
	 */
	@RequestMapping(value = "erp/erp_yhdksh_61.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public void erp_yhdksh_61(int adminid, int result_1_code1,
			String yhdksh_61_date, String yhdksh_61_kh, String yhdksh_61_zh,
			String yhdksh_61_je, String yhdksh_61_sqhkr, String yhdksh_61_yh,
			String yhdksh_61_syhk, String yhdksh_61_fq, String result_1_msg,
			int type_id, int icbc_id, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		PageData pdsession = (PageData) request.getSession().getAttribute("pd");// 获取session信息
		// 获取 车牌、vin、身份账号
		assess_cars aCars = icbc_carsService.findicbc_cars1(icbc_id);
		icbc icbc = newicbcService.findicbcbyid(icbc_id);
		// 保存进度之前先判断一下icbc_erp_kj_icbc表中是否有某个用户的某个板块
		PageData pdd = new PageData();
		pdd.put("dn", "selectOne_icbc_erp_kj_icbc");
		pdd.put("icbc_id", icbc_id);
		pdd.put("type_id", type_id); // 银行申请贷款 对应 11
		PageData pErpIcbc = erp_fiveModelService.findbyid(pdd);
		/*
		 * 操作明细记录 start/////
		 */
		// 保存 进度留言记录
		PageData pResult = new PageData();
		pResult.put("dn", "icbc_erp_kj_icbc_result");
		pResult.put("mid_add", adminid);
		pResult.put("mid_edit", adminid);
		pResult.put("dt_add", getMaxPagedate_7_9_11_12_14_15(icbc_id, type_id)
				.get("dt_edit"));
		pResult.put("dt_edit", creditutil.time());
		pResult.put("status", 61);
		pResult.put("status_oldht", 0);
		pResult.put("remark", "银行放款结果");
		JSONObject json = new JSONObject();
		json.put("61_date", yhdksh_61_date);
		json.put("61_kh", yhdksh_61_kh);
		json.put("61_zh", yhdksh_61_zh);
		json.put("61_je", yhdksh_61_je);
		json.put("61_sqhkr", yhdksh_61_sqhkr);
		json.put("61_yh", yhdksh_61_yh);
		json.put("61_syhk", yhdksh_61_syhk);
		json.put("61_fq", yhdksh_61_fq);
		pResult.put("result_1_value", json.toString());
		pResult.put("result_1_msg", result_1_msg);
		pResult.put("result_1_code", result_1_code1);
		pResult.put("dt_sub", creditutil.time());
		pResult.put("type_id", type_id); // 银行申请贷款 对应 11
		pResult.put("icbc_id", icbc_id);
		int icbc_count = repaymentservice.selectrepay(icbc_id);
		repaymentservice.addrepay(icbc_id, yhdksh_61_je, icbc_count);
		/*
		 * 操作明细记录 end/////
		 */
		if (pErpIcbc != null) {
			pResult.put("qryid", pErpIcbc.get("id"));
			erp_fiveModelService.save(pResult);
			// 更新icbc_erp_kj_icbc表中，status的最新装填
			PageData upd = new PageData();
			upd.put("dn", "update_icbc_erp_kj_icbc");
			upd.put("icbc_id", icbc_id);
			upd.put("type_id", type_id); // 银行申请贷款 对应 11
			upd.put("status", 61);
			upd.put("mid_edit", adminid); // 修改人id
			upd.put("dt_edit", creditutil.time()); // 修改时间
			erp_fiveModelService.updatebyid(upd);
		} else {
			PageData picbc = new PageData();
			picbc.put("dn", "icbc_erp_kj_icbc");
			picbc.put("mid_add", adminid);
			picbc.put("mid_edit", adminid);
			picbc.put("dt_add", creditutil.time());
			picbc.put("dt_edit", creditutil.time());
			picbc.put("dt_sub", creditutil.time());
			picbc.put("status", 61);
			picbc.put("icbc_id", icbc_id);
			picbc.put("gems_id", pdsession.get("gems_id"));
			picbc.put("gems_fs_id", pdsession.get("fs_id"));
			picbc.put("type_id", type_id); // 银行申请贷款 对应 11
			if (aCars != null) {
				picbc.put("c_carno", aCars.getC_carno());
				picbc.put("c_carvin", aCars.getVincode());
			}
			if (icbc != null) {
				picbc.put("c_name", icbc.getC_name());
				picbc.put("c_cardno", icbc.getC_cardno());
			}
			erp_fiveModelService.save(picbc);
			// result添加数据
			pResult.put("qryid", picbc.get("id"));
			erp_fiveModelService.save(pResult);
		}
		// 推送
		String result_1_code_String = "状态";
		if (result_1_code1 == 1) {
			result_1_code_String = "成功";
		} else if (result_1_code1 == 2) {
			result_1_code_String = "失败";
		}
		Map map = erp_fifteenModel.fifteenModel();
		admin admin1 = adminService.adminbyid(pErpIcbc.getInt("mid_add"));
		if (admin1 != null && !admin1.equals("")) {
			String REGISTRATION_ID = admin1.getJgid();
			String mString = admin1.getName() + "您好!" + "客户名称为"
					+ icbc.getC_name() + "的审核已更新" + ";" + map.get(type_id)
					+ "_银行放款结果状态:" + result_1_code_String + ";留言:"
					+ result_1_msg + "时间:" + creditutil.time() + ";";
			if (REGISTRATION_ID != null && !REGISTRATION_ID.equals("")) {
				Jdpush.testSendPush(appKey, masterSecret, REGISTRATION_ID,
						mString);
			}
			admin_msg admin_msg = new admin_msg();
			admin_msg.setDt_add(creditutil.time());
			admin_msg.setDt_edit(creditutil.time());
			admin_msg.setMid_add(adminid);
			admin_msg.setMsg(mString);
			admin_msg.setReceiveid(admin1.getId());
			admin_msg.setSendid(0);
			admin_msg.setStatus(0);
			admin_msgService.addadmin_msg(admin_msg);
		}
	}

	/*
	 * erp十五模块-银行申请贷款-银行审批结果(60) 审核
	 */
	@RequestMapping(value = "erp/erp_yhdksh_60.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public void erp_yhdksh_60(int adminid, int result_1_code,
			String result_1_msg, int type_id, int icbc_id,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		PageData pdsession = (PageData) request.getSession().getAttribute("pd");// 获取session信息
		// 获取 车牌、vin、身份账号
		assess_cars aCars = icbc_carsService.findicbc_cars1(icbc_id);
		icbc icbc = newicbcService.findicbcbyid(icbc_id);
		// 保存进度之前先判断一下icbc_erp_kj_icbc表中是否有某个用户的某个板块
		PageData pdd = new PageData();
		pdd.put("dn", "selectOne_icbc_erp_kj_icbc");
		pdd.put("icbc_id", icbc_id);
		pdd.put("type_id", type_id); // 银行申请贷款 对应 11
		PageData pErpIcbc = erp_fiveModelService.findbyid(pdd);
		/*
		 * 操作明细记录 start/////
		 */
		// 保存 进度留言记录
		PageData pResult = new PageData();
		pResult.put("dn", "icbc_erp_kj_icbc_result");
		pResult.put("mid_add", adminid);
		pResult.put("mid_edit", adminid);
		pResult.put("dt_add", getMaxPagedate_7_9_11_12_14_15(icbc_id, type_id)
				.get("dt_edit"));
		pResult.put("dt_edit", creditutil.time());
		pResult.put("status", 60);
		pResult.put("status_oldht", 0);
		pResult.put("remark", "银行审批结果");
		pResult.put("result_1_msg", result_1_msg);
		pResult.put("result_1_code", result_1_code);
		pResult.put("dt_sub", creditutil.time());
		pResult.put("type_id", type_id); // 银行申请贷款 对应 11
		pResult.put("icbc_id", icbc_id);
		/*
		 * 操作明细记录 end/////
		 */
		if (pErpIcbc != null) {
			pResult.put("qryid", pErpIcbc.get("id"));
			erp_fiveModelService.save(pResult);
			// 更新icbc_erp_kj_icbc表中，status的最新装填
			PageData upd = new PageData();
			upd.put("dn", "update_icbc_erp_kj_icbc");
			upd.put("icbc_id", icbc_id);
			upd.put("type_id", type_id); // 银行申请贷款 对应 11
			upd.put("status", 60);
			upd.put("mid_edit", adminid); // 修改人id
			upd.put("dt_edit", creditutil.time()); // 修改时间
			erp_fiveModelService.updatebyid(upd);
		} else {
			PageData picbc = new PageData();
			picbc.put("dn", "icbc_erp_kj_icbc");
			picbc.put("mid_add", adminid);
			picbc.put("mid_edit", adminid);
			picbc.put("dt_add", creditutil.time());
			picbc.put("dt_edit", creditutil.time());
			picbc.put("dt_sub", creditutil.time());
			picbc.put("status", 60);
			picbc.put("icbc_id", icbc_id);
			picbc.put("gems_id", pdsession.get("gems_id"));
			picbc.put("gems_fs_id", pdsession.get("fs_id"));
			picbc.put("type_id", type_id); // 银行申请贷款 对应 11
			if (aCars != null) {
				picbc.put("c_carno", aCars.getC_carno());
				picbc.put("c_carvin", aCars.getVincode());
			}
			if (icbc != null) {
				picbc.put("c_name", icbc.getC_name());
				picbc.put("c_cardno", icbc.getC_cardno());
			}
			erp_fiveModelService.save(picbc);
			// result添加数据
			pResult.put("qryid", picbc.get("id"));
			erp_fiveModelService.save(pResult);
		}
		// 当确认 为 "通过"时
		// icbc表更新记录 和 result 表存一条完成记录
		if (result_1_code == 2) {
			// 更新icbc_erp_kj_icbc表中，status的最新装填
			PageData upd = new PageData();
			upd.put("dn", "update_icbc_erp_kj_icbc");
			upd.put("icbc_id", icbc_id);
			upd.put("type_id", type_id);
			upd.put("status", 65);
			upd.put("mid_edit", adminid); // 修改人id
			upd.put("dt_edit", creditutil.time()); // 修改时间
			erp_fiveModelService.updatebyid(upd);
			PageData pResult_gsgd = new PageData();
			pResult_gsgd.put("dn", "icbc_erp_kj_icbc_result");
			pResult_gsgd.put("qryid", pErpIcbc.get("id"));
			pResult_gsgd.put("mid_add", adminid);
			pResult_gsgd.put("mid_edit", adminid);
			pResult_gsgd.put("dt_add", creditutil.time());
			pResult_gsgd.put("dt_edit", creditutil.time());
			pResult_gsgd.put("status", 65);
			pResult_gsgd.put("status_oldht", 0);
			pResult_gsgd.put("remark", "完成");
			pResult_gsgd.put("result_1_code", 0);
			pResult_gsgd.put("dt_sub", creditutil.time());
			pResult_gsgd.put("type_id", type_id);
			pResult_gsgd.put("icbc_id", icbc_id);
			erp_fiveModelService.save(pResult_gsgd); // 保存 公司归档存 icbc result表
		}
		// 推送
		String result_1_code_String = "状态";
		if (result_1_code == 1) {
			result_1_code_String = "通过";
		} else if (result_1_code == 2) {
			result_1_code_String = "不通过";
		} else if (result_1_code == 3) {
			result_1_code_String = "附条件";
		} else if (result_1_code == 4) {
			result_1_code_String = "先抵押后放贷";
		}
		Map map = erp_fifteenModel.fifteenModel();
		admin admin1 = adminService.adminbyid(pErpIcbc.getInt("mid_add"));
		if (admin1 != null && !admin1.equals("")) {
			String REGISTRATION_ID = admin1.getJgid();
			String mString = admin1.getName() + "您好!" + "客户名称为"
					+ icbc.getC_name() + "的审核已更新" + ";" + map.get(type_id)
					+ "_银行审批结果状态:" + result_1_code_String + ";留言:"
					+ result_1_msg + "时间:" + creditutil.time() + ";";
			if (REGISTRATION_ID != null && !REGISTRATION_ID.equals("")) {
				Jdpush.testSendPush(appKey, masterSecret, REGISTRATION_ID,
						mString);
			}
			admin_msg admin_msg = new admin_msg();
			admin_msg.setDt_add(creditutil.time());
			admin_msg.setDt_edit(creditutil.time());
			admin_msg.setMid_add(adminid);
			admin_msg.setMsg(mString);
			admin_msg.setReceiveid(admin1.getId());
			admin_msg.setSendid(0);
			admin_msg.setStatus(0);
			admin_msgService.addadmin_msg(admin_msg);
		}
	}

	/*
	 * erp十五模块-银行申请贷款-银行收件确认(59) 审核
	 */
	@RequestMapping(value = "erp/erp_yhdksh_59.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public void erp_yhdksh_59(int adminid, String yhdksh_59_msg,
			String yhdksh_59_date, String yhdksh_59_jyhrq, int result_1_code,
			String result_1_msg, int type_id, int icbc_id,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		PageData pdsession = (PageData) request.getSession().getAttribute("pd");// 获取session信息
		// 获取 车牌、vin、身份账号
		assess_cars aCars = icbc_carsService.findicbc_cars1(icbc_id);
		icbc icbc = newicbcService.findicbcbyid(icbc_id);
		// 保存进度之前先判断一下icbc_erp_kj_icbc表中是否有某个用户的某个板块
		PageData pdd = new PageData();
		pdd.put("dn", "selectOne_icbc_erp_kj_icbc");
		pdd.put("icbc_id", icbc_id);
		pdd.put("type_id", type_id); // 银行申请贷款 对应 11
		PageData pErpIcbc = erp_fiveModelService.findbyid(pdd);
		/*
		 * 操作明细记录 start/////
		 */
		// 保存 进度留言记录
		PageData pResult = new PageData();
		pResult.put("dn", "icbc_erp_kj_icbc_result");
		pResult.put("mid_add", adminid);
		pResult.put("mid_edit", adminid);
		pResult.put("dt_add", getMaxPagedate_7_9_11_12_14_15(icbc_id, type_id)
				.get("dt_edit"));
		pResult.put("dt_edit", creditutil.time());
		pResult.put("status", 59);
		pResult.put("status_oldht", 0);
		pResult.put("remark", "银行收件确认");
		JSONObject json = new JSONObject();
		json.put("58_msg", yhdksh_59_msg);
		json.put("58_date", yhdksh_59_date);
		json.put("58_jyhrq", yhdksh_59_jyhrq);
		pResult.put("result_1_value", json.toString());
		pResult.put("result_1_msg", result_1_msg);
		pResult.put("result_1_code", result_1_code);
		pResult.put("dt_sub", creditutil.time());
		pResult.put("type_id", type_id); // 银行申请贷款 对应 11
		pResult.put("icbc_id", icbc_id);
		/*
		 * 操作明细记录 end/////
		 */
		if (pErpIcbc != null) {
			pResult.put("qryid", pErpIcbc.get("id"));
			erp_fiveModelService.save(pResult);
			// 更新icbc_erp_kj_icbc表中，status的最新装填
			PageData upd = new PageData();
			upd.put("dn", "update_icbc_erp_kj_icbc");
			upd.put("icbc_id", icbc_id);
			upd.put("type_id", type_id); // 银行申请贷款 对应 11
			upd.put("status", 59);
			upd.put("mid_edit", adminid); // 修改人id
			upd.put("dt_edit", creditutil.time()); // 修改时间
			erp_fiveModelService.updatebyid(upd);
		} else {
			PageData picbc = new PageData();
			picbc.put("dn", "icbc_erp_kj_icbc");
			picbc.put("mid_add", adminid);
			picbc.put("mid_edit", adminid);
			picbc.put("dt_add", creditutil.time());
			picbc.put("dt_edit", creditutil.time());
			picbc.put("dt_sub", creditutil.time());
			picbc.put("status", 59);
			picbc.put("icbc_id", icbc_id);
			picbc.put("gems_id", pdsession.get("gems_id"));
			picbc.put("gems_fs_id", pdsession.get("fs_id"));
			picbc.put("type_id", type_id); // 银行申请贷款 对应 11
			if (aCars != null) {
				picbc.put("c_carno", aCars.getC_carno());
				picbc.put("c_carvin", aCars.getVincode());
			}
			if (icbc != null) {
				picbc.put("c_name", icbc.getC_name());
				picbc.put("c_cardno", icbc.getC_cardno());
			}
			erp_fiveModelService.save(picbc);
			// result添加数据
			pResult.put("qryid", picbc.get("id"));
			erp_fiveModelService.save(pResult);
		}
		// 当银行收件确认 为 "已收到"时,抵押归档 亮起
		// 抵押归档 icbc表 和 result 表各存一条开始记录
		// 得到是否 抵押归档
		PageData pdd_status = new PageData();
		pdd_status.put("dn", "selectListStatus_icbc_erp_kj_icbc_result");
		pdd_status.put("icbc_id", icbc_id);
		pdd_status.put("type_id", 13); // 抵押归档-板块
		pdd_status.put("status", 72); // 抵押归档开始 -小状态
		List<PageData> pErpIcbc_72 = new ArrayList<>();
		pErpIcbc_72 = erp_fiveModelService.findtolist(pdd_status);
		if (yhdksh_59_msg.equals("已收到")) {
			if (pErpIcbc_72.size() > 0) {
				// pErpIcbc_72.size()>0 说明有 抵押归档开始 -小状态 小状态啦
				// 则不必再添加
			} else {
				// 否则 添加
				PageData picbc_gsgd = new PageData();
				picbc_gsgd.put("dn", "icbc_erp_kj_icbc");
				picbc_gsgd.put("mid_add", adminid);
				picbc_gsgd.put("mid_edit", adminid);
				picbc_gsgd.put("dt_add", creditutil.time());
				picbc_gsgd.put("dt_edit", creditutil.time());
				picbc_gsgd.put("dt_sub", creditutil.time());
				picbc_gsgd.put("status", 72);
				picbc_gsgd.put("icbc_id", icbc_id);
				picbc_gsgd.put("gems_id", aCars.getGems_id());
				picbc_gsgd.put("gems_fs_id", aCars.getGems_fs_id());
				picbc_gsgd.put("type_id", 13); // 抵押归档 对应 13
				if (aCars != null) {
					picbc_gsgd.put("c_carno", aCars.getC_carno());
					picbc_gsgd.put("c_carvin", aCars.getVincode());
				}
				if (icbc != null) {
					picbc_gsgd.put("c_name", icbc.getC_name());
					picbc_gsgd.put("c_cardno", icbc.getC_cardno());
				}
				erp_fiveModelService.save(picbc_gsgd); // 保存 公司归档存 icbc表
				PageData pResult_gsgd = new PageData();
				pResult_gsgd.put("dn", "icbc_erp_kj_icbc_result");
				pResult_gsgd.put("qryid", picbc_gsgd.get("id"));
				pResult_gsgd.put("mid_add", adminid);
				pResult_gsgd.put("mid_edit", adminid);
				pResult_gsgd.put("dt_add", creditutil.time());
				pResult_gsgd.put("dt_edit", creditutil.time());
				pResult_gsgd.put("status", 72);
				pResult_gsgd.put("status_oldht", 0);
				pResult_gsgd.put("remark", "抵押归档开始");
				pResult_gsgd.put("result_1_code", result_1_code);
				pResult_gsgd.put("dt_sub", creditutil.time());
				pResult_gsgd.put("type_id", 13); // 抵押归档 对应 13
				pResult_gsgd.put("icbc_id", icbc_id);
				erp_fiveModelService.save(pResult_gsgd); // 保存 公司归档存 icbc
															// result表
			}
		}
		// 推送
		String result_1_code_String = "状态";
		if (result_1_code == 1) {
			result_1_code_String = "通过";
		} else if (result_1_code == 2) {
			result_1_code_String = "不通过";
		}
		Map map = erp_fifteenModel.fifteenModel();
		admin admin1 = adminService.adminbyid(pErpIcbc.getInt("mid_add"));
		if (admin1 != null && !admin1.equals("")) {
			String REGISTRATION_ID = admin1.getJgid();
			String mString = admin1.getName() + "您好!" + "客户名称为"
					+ icbc.getC_name() + "的审核已更新" + ";" + map.get(type_id)
					+ "_银行收件确认状态:" + yhdksh_59_msg + "材料复核结果状态:"
					+ result_1_code_String + ";留言:" + result_1_msg + "时间:"
					+ creditutil.time() + ";";
			if (REGISTRATION_ID != null && !REGISTRATION_ID.equals("")) {
				Jdpush.testSendPush(appKey, masterSecret, REGISTRATION_ID,
						mString);
			}
			admin_msg admin_msg = new admin_msg();
			admin_msg.setDt_add(creditutil.time());
			admin_msg.setDt_edit(creditutil.time());
			admin_msg.setMid_add(adminid);
			admin_msg.setMsg(mString);
			admin_msg.setReceiveid(admin1.getId());
			admin_msg.setSendid(0);
			admin_msg.setStatus(0);
			admin_msgService.addadmin_msg(admin_msg);
		}
	}

	/*
	 * erp十五模块-银行申请贷款-集团收件确认(58) 审核
	 */
	@RequestMapping(value = "erp/erp_yhdksh_58.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public void erp_yhdksh_58(int adminid, String yhdksh_58_msg,
			String yhdksh_58_date, int result_1_code, String result_1_msg,
			int type_id, int icbc_id, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		PageData pdsession = (PageData) request.getSession().getAttribute("pd");// 获取session信息
		// 获取 车牌、vin、身份账号
		assess_cars aCars = icbc_carsService.findicbc_cars1(icbc_id);
		icbc icbc = newicbcService.findicbcbyid(icbc_id);
		// 保存进度之前先判断一下icbc_erp_kj_icbc表中是否有某个用户的某个板块
		PageData pdd = new PageData();
		pdd.put("dn", "selectOne_icbc_erp_kj_icbc");
		pdd.put("icbc_id", icbc_id);
		pdd.put("type_id", type_id); // 银行申请贷款 对应 11
		PageData pErpIcbc = erp_fiveModelService.findbyid(pdd);
		/*
		 * 操作明细记录 start/////
		 */
		// 保存 进度留言记录
		PageData pResult = new PageData();
		pResult.put("dn", "icbc_erp_kj_icbc_result");
		pResult.put("mid_add", adminid);
		pResult.put("mid_edit", adminid);
		pResult.put("dt_add", getMaxPagedate_7_9_11_12_14_15(icbc_id, type_id)
				.get("dt_edit"));
		pResult.put("dt_edit", creditutil.time());
		pResult.put("status", 58);
		pResult.put("status_oldht", 0);
		pResult.put("remark", "集团收件确认");
		JSONObject json = new JSONObject();
		json.put("58_msg", yhdksh_58_msg);
		json.put("58_date", yhdksh_58_date);
		pResult.put("result_1_value", json.toString());
		pResult.put("result_1_msg", result_1_msg);
		pResult.put("result_1_code", result_1_code);
		pResult.put("dt_sub", creditutil.time());
		pResult.put("type_id", type_id); // 银行申请贷款 对应 11
		pResult.put("icbc_id", icbc_id);
		/*
		 * 操作明细记录 end/////
		 */
		if (pErpIcbc != null) {
			pResult.put("qryid", pErpIcbc.get("id"));
			erp_fiveModelService.save(pResult);
			// 更新icbc_erp_kj_icbc表中，status的最新装填
			PageData upd = new PageData();
			upd.put("dn", "update_icbc_erp_kj_icbc");
			upd.put("icbc_id", icbc_id);
			upd.put("type_id", type_id); // 银行申请贷款 对应 11
			upd.put("status", 58);
			upd.put("mid_edit", adminid); // 修改人id
			upd.put("dt_edit", creditutil.time()); // 修改时间
			erp_fiveModelService.updatebyid(upd);
		} else {
			PageData picbc = new PageData();
			picbc.put("dn", "icbc_erp_kj_icbc");
			picbc.put("mid_add", adminid);
			picbc.put("mid_edit", adminid);
			picbc.put("dt_add", creditutil.time());
			picbc.put("dt_edit", creditutil.time());
			picbc.put("dt_sub", creditutil.time());
			picbc.put("status", 58);
			picbc.put("icbc_id", icbc_id);
			picbc.put("gems_id", pdsession.get("gems_id"));
			picbc.put("gems_fs_id", pdsession.get("fs_id"));
			picbc.put("type_id", type_id); // 银行申请贷款 对应 11
			if (aCars != null) {
				picbc.put("c_carno", aCars.getC_carno());
				picbc.put("c_carvin", aCars.getVincode());
			}
			if (icbc != null) {
				picbc.put("c_name", icbc.getC_name());
				picbc.put("c_cardno", icbc.getC_cardno());
			}
			erp_fiveModelService.save(picbc);
			// result添加数据
			pResult.put("qryid", picbc.get("id"));
			erp_fiveModelService.save(pResult);
		}
		// 当集团收件确认 为 "已收到"时,公司归档 亮起
		// 公司归档 icbc表 和 result 表各存一条开始记录
		// 得到是否 公司归档
		PageData pdd_status = new PageData();
		pdd_status.put("dn", "selectListStatus_icbc_erp_kj_icbc_result");
		pdd_status.put("icbc_id", icbc_id);
		pdd_status.put("type_id", 12); // 公司归档-板块
		pdd_status.put("status", 66); // 公司归档开始 -小状态
		List<PageData> pErpIcbc_66 = new ArrayList<>();
		pErpIcbc_66 = erp_fiveModelService.findtolist(pdd_status);
		if (yhdksh_58_msg.equals("已收到")) {
			if (pErpIcbc_66.size() > 0) {
				// pErpIcbc_66.size()>0 说明有 公司归档开始 -小状态 小状态啦
				// 则不必再添加
			} else {
				// 否则 添加
				PageData picbc_gsgd = new PageData();
				picbc_gsgd.put("dn", "icbc_erp_kj_icbc");
				picbc_gsgd.put("mid_add", adminid);
				picbc_gsgd.put("mid_edit", adminid);
				picbc_gsgd.put("dt_add", creditutil.time());
				picbc_gsgd.put("dt_edit", creditutil.time());
				picbc_gsgd.put("dt_sub", creditutil.time());
				picbc_gsgd.put("status", 66);
				picbc_gsgd.put("icbc_id", icbc_id);
				picbc_gsgd.put("gems_id", aCars.getGems_id());
				picbc_gsgd.put("gems_fs_id", aCars.getGems_fs_id());
				picbc_gsgd.put("type_id", 12); // 公司归档 对应 12
				if (aCars != null) {
					picbc_gsgd.put("c_carno", aCars.getC_carno());
					picbc_gsgd.put("c_carvin", aCars.getVincode());
				}
				if (icbc != null) {
					picbc_gsgd.put("c_name", icbc.getC_name());
					picbc_gsgd.put("c_cardno", icbc.getC_cardno());
				}
				erp_fiveModelService.save(picbc_gsgd); // 保存 公司归档存 icbc表
				PageData pResult_gsgd = new PageData();
				pResult_gsgd.put("dn", "icbc_erp_kj_icbc_result");
				pResult_gsgd.put("qryid", picbc_gsgd.get("id"));
				pResult_gsgd.put("mid_add", adminid);
				pResult_gsgd.put("mid_edit", adminid);
				pResult_gsgd.put("dt_add", creditutil.time());
				pResult_gsgd.put("dt_edit", creditutil.time());
				pResult_gsgd.put("status", 66);
				pResult_gsgd.put("status_oldht", 0);
				pResult_gsgd.put("remark", "公司归档开始");
				pResult_gsgd.put("result_1_code", result_1_code);
				pResult_gsgd.put("dt_sub", creditutil.time());
				pResult_gsgd.put("type_id", 12); // 公司归档 对应 12
				pResult_gsgd.put("icbc_id", icbc_id);
				erp_fiveModelService.save(pResult_gsgd); // 保存 公司归档存 icbc
															// result表
			}
		}
		// 推送
		String result_1_code_String = "状态";
		if (result_1_code == 1) {
			result_1_code_String = "通过";
		} else if (result_1_code == 2) {
			result_1_code_String = "不通过";
		}
		Map map = erp_fifteenModel.fifteenModel();
		admin admin1 = adminService.adminbyid(pErpIcbc.getInt("mid_add"));
		if (admin1 != null && !admin1.equals("")) {
			String REGISTRATION_ID = admin1.getJgid();
			String mString = admin1.getName() + "您好!" + "客户名称为"
					+ icbc.getC_name() + "的审核已更新" + ";" + map.get(type_id)
					+ "_集团收件确认状态:" + yhdksh_58_msg + "材料复核结果状态:"
					+ result_1_code_String + ";留言:" + result_1_msg + "时间:"
					+ creditutil.time() + ";";
			if (REGISTRATION_ID != null && !REGISTRATION_ID.equals("")) {
				Jdpush.testSendPush(appKey, masterSecret, REGISTRATION_ID,
						mString);
			}
			admin_msg admin_msg = new admin_msg();
			admin_msg.setDt_add(creditutil.time());
			admin_msg.setDt_edit(creditutil.time());
			admin_msg.setMid_add(adminid);
			admin_msg.setMsg(mString);
			admin_msg.setReceiveid(admin1.getId());
			admin_msg.setSendid(0);
			admin_msg.setStatus(0);
			admin_msgService.addadmin_msg(admin_msg);
		}
	}

	/*
	 * erp十五模块-银行申请贷款-机构寄送材料(57) 审核
	 */
	@RequestMapping(value = "erp/erp_yhdksh_57.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public void erp_yhdksh_57(int adminid, String yhdksh_57_kdgs,
			String yhdksh_57_kddh, String yhdksh_57_jcrq,
			String yhdksh_57_bcimg1, String result_1_msg, int type_id,
			int icbc_id, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		PageData pdsession = (PageData) request.getSession().getAttribute("pd");// 获取session信息
		// 获取 车牌、vin、身份账号
		assess_cars aCars = icbc_carsService.findicbc_cars1(icbc_id);
		icbc icbc = newicbcService.findicbcbyid(icbc_id);
		// 保存进度之前先判断一下icbc_erp_kj_icbc表中是否有某个用户的某个板块
		PageData pdd = new PageData();
		pdd.put("dn", "selectOne_icbc_erp_kj_icbc");
		pdd.put("icbc_id", icbc_id);
		pdd.put("type_id", type_id); // 银行申请贷款 对应 11
		PageData pErpIcbc = erp_fiveModelService.findbyid(pdd);
		/*
		 * 操作明细记录 start/////
		 */
		// 保存 进度留言记录
		PageData pResult = new PageData();
		pResult.put("dn", "icbc_erp_kj_icbc_result");
		pResult.put("mid_add", adminid);
		pResult.put("mid_edit", adminid);
		pResult.put("dt_add", getMaxPagedate_7_9_11_12_14_15(icbc_id, type_id)
				.get("dt_edit"));
		pResult.put("dt_edit", creditutil.time());
		pResult.put("status", 57);
		pResult.put("status_oldht", 0);
		pResult.put("remark", "机构寄送材料");
		JSONObject json = new JSONObject();
		json.put("kdgs", yhdksh_57_kdgs);
		json.put("kddh", yhdksh_57_kddh);
		json.put("jcrq", yhdksh_57_jcrq);
		json.put("bcimg1", yhdksh_57_bcimg1);
		pResult.put("result_1_value", json.toString());
		pResult.put("result_1_msg", result_1_msg);
		pResult.put("dt_sub", creditutil.time());
		pResult.put("type_id", type_id); // 银行申请贷款 对应 11
		pResult.put("icbc_id", icbc_id);
		/*
		 * 操作明细记录 end/////
		 */
		if (pErpIcbc != null) {
			pResult.put("qryid", pErpIcbc.get("id"));
			erp_fiveModelService.save(pResult);
			// 更新icbc_erp_kj_icbc表中，status的最新装填
			PageData upd = new PageData();
			upd.put("dn", "update_icbc_erp_kj_icbc");
			upd.put("icbc_id", icbc_id);
			upd.put("type_id", type_id); // 银行申请贷款 对应 11
			upd.put("status", 57);
			upd.put("mid_edit", adminid); // 修改人id
			upd.put("dt_edit", creditutil.time()); // 修改时间
			erp_fiveModelService.updatebyid(upd);
		} else {
			PageData picbc = new PageData();
			picbc.put("dn", "icbc_erp_kj_icbc");
			picbc.put("mid_add", adminid);
			picbc.put("mid_edit", adminid);
			picbc.put("dt_add", creditutil.time());
			picbc.put("dt_edit", creditutil.time());
			picbc.put("dt_sub", creditutil.time());
			picbc.put("status", 57);
			picbc.put("icbc_id", icbc_id);
			picbc.put("gems_id", pdsession.get("gems_id"));
			picbc.put("gems_fs_id", pdsession.get("fs_id"));
			picbc.put("type_id", type_id); // 银行申请贷款 对应 11
			if (aCars != null) {
				picbc.put("c_carno", aCars.getC_carno());
				picbc.put("c_carvin", aCars.getVincode());
			}
			if (icbc != null) {
				picbc.put("c_name", icbc.getC_name());
				picbc.put("c_cardno", icbc.getC_cardno());
			}
			erp_fiveModelService.save(picbc);
			// result添加数据
			pResult.put("qryid", picbc.get("id"));
			erp_fiveModelService.save(pResult);
		}
		// 推送
		Map map = erp_fifteenModel.fifteenModel();
		admin admin1 = adminService.adminbyid(pErpIcbc.getInt("mid_add"));
		if (admin1 != null && !admin1.equals("")) {
			String REGISTRATION_ID = admin1.getJgid();
			String mString = admin1.getName() + "您好!" + "客户名称为"
					+ icbc.getC_name() + "的审核已更新" + ";" + map.get(type_id)
					+ "_机构寄送材料状态:" + "快递公司:" + yhdksh_57_kdgs + ",快递单号:"
					+ yhdksh_57_kddh + ",寄出日期:" + yhdksh_57_jcrq + ";留言:"
					+ result_1_msg + "时间:" + creditutil.time() + ";";
			if (REGISTRATION_ID != null && !REGISTRATION_ID.equals("")) {
				Jdpush.testSendPush(appKey, masterSecret, REGISTRATION_ID,
						mString);
			}
			admin_msg admin_msg = new admin_msg();
			admin_msg.setDt_add(creditutil.time());
			admin_msg.setDt_edit(creditutil.time());
			admin_msg.setMid_add(adminid);
			admin_msg.setMsg(mString);
			admin_msg.setReceiveid(admin1.getId());
			admin_msg.setSendid(0);
			admin_msg.setStatus(0);
			admin_msgService.addadmin_msg(admin_msg);
		}
	}

	/*
	 * erp十五模块-银行电审 审核
	 */
	@RequestMapping(value = "erp/erp_dssh.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public void erp_dssh(int adminid, int ds_status, String ds_remark,
			String dsfqsm, int type_id, int icbc_id,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		PageData pdsession = (PageData) request.getSession().getAttribute("pd");// 获取session信息
		// 获取 车牌、vin、身份账号
		assess_cars aCars = icbc_carsService.findicbc_cars1(icbc_id);
		icbc icbc = newicbcService.findicbcbyid(icbc_id);
		// 保存进度之前先判断一下icbc_erp_kj_icbc表中是否有某个用户的某个板块
		PageData pdd = new PageData();
		pdd.put("dn", "selectOne_icbc_erp_kj_icbc");
		pdd.put("icbc_id", icbc_id);
		pdd.put("type_id", type_id); // 银行电审 对应 4
		PageData pErpIcbc = erp_fiveModelService.findbyid(pdd);
		/*
		 * 操作明细记录 start/////
		 */
		// 保存 进度留言记录
		PageData pResult = new PageData();
		pResult.put("dn", "icbc_erp_kj_icbc_result");
		pResult.put("mid_add", adminid);
		pResult.put("mid_edit", adminid);
		pResult.put("dt_add",
				getMaxPagedate_004(icbc_id, type_id).get("dt_edit"));
		pResult.put("dt_edit", creditutil.time());
		pResult.put("status", 15);
		pResult.put("status_oldht", 0);
		pResult.put("remark", "结果反馈");
		JSONObject json = new JSONObject();
		json.put("dsfqsm", dsfqsm); // 电审发起说明
		pResult.put("result_1_value", json.toString());
		pResult.put("result_1_code", ds_status);
		pResult.put("result_1_msg", ds_remark);
		pResult.put("dt_sub", creditutil.time());
		pResult.put("type_id", type_id); // 银行电审 对应 4
		pResult.put("icbc_id", icbc_id);
		/*
		 * 操作明细记录 end/////
		 */
		if (pErpIcbc != null) {
			pResult.put("qryid", pErpIcbc.get("id"));
			erp_fiveModelService.save(pResult);
			// 更新icbc_erp_kj_icbc表中，status的最新装填
			PageData upd = new PageData();
			upd.put("dn", "update_icbc_erp_kj_icbc");
			upd.put("icbc_id", icbc_id);
			upd.put("type_id", type_id); // 银行电审 对应 4
			upd.put("status", 15);
			upd.put("mid_edit", adminid); // 修改人id
			upd.put("dt_edit", creditutil.time()); // 修改时间
			erp_fiveModelService.updatebyid(upd);
		} else {
			PageData picbc = new PageData();
			picbc.put("dn", "icbc_erp_kj_icbc");
			picbc.put("mid_add", adminid);
			picbc.put("mid_edit", adminid);
			picbc.put("dt_add", creditutil.time());
			picbc.put("dt_edit", creditutil.time());
			picbc.put("dt_sub", creditutil.time());
			picbc.put("status", 15);
			picbc.put("icbc_id", icbc_id);
			picbc.put("gems_id", pdsession.get("gems_id"));
			picbc.put("gems_fs_id", pdsession.get("fs_id"));
			picbc.put("type_id", type_id); // 银行电审 对应 4
			if (aCars != null) {
				picbc.put("c_carno", aCars.getC_carno());
				picbc.put("c_carvin", aCars.getVincode());
			}
			if (icbc != null) {
				picbc.put("c_name", icbc.getC_name());
				picbc.put("c_cardno", icbc.getC_cardno());
			}
			erp_fiveModelService.save(picbc);
			// result添加数据
			pResult.put("qryid", picbc.get("id"));
			erp_fiveModelService.save(pResult);

		}
		// 当确认 为 "通过"时
		// icbc表更新记录 和 result 表存一条完成记录
		if (ds_status == 1) {
			// 更新icbc_erp_kj_icbc表中，status的最新装填
			PageData upd = new PageData();
			upd.put("dn", "update_icbc_erp_kj_icbc");
			upd.put("icbc_id", icbc_id);
			upd.put("type_id", 4);
			upd.put("status", 16);
			upd.put("mid_edit", adminid); // 修改人id
			upd.put("dt_edit", creditutil.time()); // 修改时间
			erp_fiveModelService.updatebyid(upd);
			PageData pResult_gsgd = new PageData();
			pResult_gsgd.put("dn", "icbc_erp_kj_icbc_result");
			pResult_gsgd.put("qryid", pErpIcbc.get("id"));
			pResult_gsgd.put("mid_add", adminid);
			pResult_gsgd.put("mid_edit", adminid);
			pResult_gsgd.put("dt_add", creditutil.time());
			pResult_gsgd.put("dt_edit", creditutil.time());
			pResult_gsgd.put("status", 16);
			pResult_gsgd.put("status_oldht", 0);
			pResult_gsgd.put("remark", "完成");
			pResult_gsgd.put("result_1_code", 0);
			pResult_gsgd.put("dt_sub", creditutil.time());
			pResult_gsgd.put("type_id", 4);
			pResult_gsgd.put("icbc_id", icbc_id);
			erp_fiveModelService.save(pResult_gsgd); // 保存 公司归档存 icbc result表
		}
		// 推送
		String ds_status_String = "状态";
		if (ds_status == 1) {
			ds_status_String = "通过";
		} else if (ds_status == 3) {
			ds_status_String = "回退补件";
		} else {
			ds_status_String = "不明状态";
		}
		admin admin1 = adminService.adminbyid(pErpIcbc.getInt("mid_add"));
		if (admin1 != null && !admin1.equals("")) {
			String REGISTRATION_ID = admin1.getJgid();
			String mString = admin1.getName() + "您好!" + "客户名称为"
					+ icbc.getC_name() + "的审核已更新" + ";银行电审状态:"
					+ ds_status_String + ";留言:" + ds_remark + "时间:"
					+ creditutil.time() + ";";
			if (REGISTRATION_ID != null && !REGISTRATION_ID.equals("")) {
				Jdpush.testSendPush(appKey, masterSecret, REGISTRATION_ID,
						mString);
			}
			admin_msg admin_msg = new admin_msg();
			admin_msg.setDt_add(creditutil.time());
			admin_msg.setDt_edit(creditutil.time());
			admin_msg.setMid_add(adminid);
			admin_msg.setMsg(mString);
			admin_msg.setReceiveid(admin1.getId());
			admin_msg.setSendid(0);
			admin_msg.setStatus(0);
			admin_msgService.addadmin_msg(admin_msg);
		}
	}

	/*
	 * erp十五模块-视频面签 审核
	 */
	@RequestMapping(value = "erp/erp_mqsh.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public void erp_mqsh(int adminid, int mq_status, String mq_remark,
			int type_id, int icbc_id, int mq_id, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		PageData pdsession = (PageData) request.getSession().getAttribute("pd");// 获取session信息
		int status_oldht = 0;
		switch (mq_status) {
		case 1: // 1通过
			status_oldht = 3;
			break;
		case 3: // 3回退补件
			status_oldht = 4;
			break;
		default:
			break;
		}
		assess_cars aCars = icbc_carsService.findicbc_cars1(icbc_id);
		icbc icbc = newicbcService.findicbcbyid(icbc_id);
		// 修改 kjs_icbc_mq 表
		icbc_mq iMq = new icbc_mq();
		iMq.setBc_status(status_oldht);
		iMq.setDt_edit(creditutil.time());
		iMq.setMid_edit(adminid);
		iMq.setId(mq_id);
		icbc_mqService.upmq(iMq);
		// 修改 kjs_icbc_mq_result 表
		icbc_mq_result iMq_result = new icbc_mq_result();
		iMq_result.setDt_add(creditutil.time());
		iMq_result.setDt_edit(creditutil.time());
		iMq_result.setMid_add(adminid);
		iMq_result.setMid_edit(adminid);
		iMq_result.setQryid(mq_id);
		Map map = icbcmodel.mq_status();
		if (mq_remark != null && !mq_remark.equals("")) {
			iMq_result.setRemark(mq_remark);
		} else {
			iMq_result.setRemark(map.get(status_oldht).toString());
		}
		iMq_result.setStatus(status_oldht);
		icbc_mq_resultService.addmq_result(iMq_result);
		// 保存进度之前先判断一下icbc_erp_kj_icbc表中是否有某个用户的某个板块
		PageData pdd = new PageData();
		pdd.put("dn", "selectOne_icbc_erp_kj_icbc");
		pdd.put("icbc_id", icbc_id);
		pdd.put("type_id", type_id); // 视频面签 对应 6
		PageData pErpIcbc = erp_fiveModelService.findbyid(pdd);
		/*
		 * 操作明细记录 start/////
		 */
		// 保存 进度留言记录
		PageData pResult = new PageData();
		pResult.put("dn", "icbc_erp_kj_icbc_result");
		pResult.put("mid_add", adminid);
		pResult.put("mid_edit", adminid);
		pResult.put("dt_add",
				getMaxPagedate_006(icbc_id, type_id).get("dt_edit"));
		pResult.put("dt_edit", creditutil.time());
		pResult.put("status", 24);
		pResult.put("status_oldht", status_oldht);
		pResult.put("remark", "结果反馈");
		pResult.put("result_1_code", mq_status);
		pResult.put("result_1_msg", mq_remark);
		pResult.put("dt_sub", creditutil.time());
		pResult.put("type_id", type_id); // 视频面签 对应 6
		pResult.put("icbc_id", icbc_id);
		/*
		 * 操作明细记录 end/////
		 */
		if (pErpIcbc != null) {
			pResult.put("qryid", pErpIcbc.get("id"));
			erp_fiveModelService.save(pResult);
			// 更新icbc_erp_kj_icbc表中，status的最新装填
			PageData upd = new PageData();
			upd.put("dn", "update_icbc_erp_kj_icbc");
			upd.put("icbc_id", icbc_id);
			upd.put("type_id", type_id); // 视频面签 对应 6
			upd.put("status", 24);
			upd.put("mid_edit", adminid); // 修改人id
			upd.put("dt_edit", creditutil.time()); // 修改时间
			erp_fiveModelService.updatebyid(upd);
		} else {
			PageData picbc = new PageData();
			picbc.put("dn", "icbc_erp_kj_icbc");
			picbc.put("mid_add", adminid);
			picbc.put("mid_edit", adminid);
			picbc.put("dt_add", creditutil.time());
			picbc.put("dt_edit", creditutil.time());
			picbc.put("dt_sub", creditutil.time());
			picbc.put("status", 24);
			picbc.put("icbc_id", icbc_id);
			picbc.put("gems_id", pdsession.get("gems_id"));
			picbc.put("gems_fs_id", pdsession.get("fs_id"));
			picbc.put("type_id", type_id); // 视频面签 对应 6
			if (aCars != null) {
				picbc.put("c_carno", aCars.getC_carno());
				picbc.put("c_carvin", aCars.getVincode());
			}
			if (icbc != null) {
				picbc.put("c_name", icbc.getC_name());
				picbc.put("c_cardno", icbc.getC_cardno());
			}
			erp_fiveModelService.save(picbc);
			// result添加数据
			pResult.put("qryid", picbc.get("id"));
			erp_fiveModelService.save(pResult);
		}
		// 当确认 为 "通过"时
		// icbc表更新记录 和 result 表存一条完成记录
		if (mq_status == 1) {
			// 更新icbc_erp_kj_icbc表中，status的最新装填
			PageData upd = new PageData();
			upd.put("dn", "update_icbc_erp_kj_icbc");
			upd.put("icbc_id", icbc_id);
			upd.put("type_id", 6); // 视频面签 对应 6
			upd.put("status", 25);
			upd.put("mid_edit", adminid); // 修改人id
			upd.put("dt_edit", creditutil.time()); // 修改时间
			erp_fiveModelService.updatebyid(upd);
			PageData pResult_gsgd = new PageData();
			pResult_gsgd.put("dn", "icbc_erp_kj_icbc_result");
			pResult_gsgd.put("qryid", pErpIcbc.get("id"));
			pResult_gsgd.put("mid_add", adminid);
			pResult_gsgd.put("mid_edit", adminid);
			pResult_gsgd.put("dt_add", creditutil.time());
			pResult_gsgd.put("dt_edit", creditutil.time());
			pResult_gsgd.put("status", 25);
			pResult_gsgd.put("status_oldht", 0);
			pResult_gsgd.put("remark", "完成");
			pResult_gsgd.put("result_1_code", 0);
			pResult_gsgd.put("dt_sub", creditutil.time());
			pResult_gsgd.put("type_id", 6); // 视频面签 对应 6
			pResult_gsgd.put("icbc_id", icbc_id);
			erp_fiveModelService.save(pResult_gsgd); // 保存 公司归档存 icbc result表
		}
		// 推送
		admin admin1 = adminService.adminbyid(pErpIcbc.getInt("mid_add"));
		if (admin1 != null && !admin1.equals("")) {
			String REGISTRATION_ID = admin1.getJgid();
			String mString = admin1.getName() + "您好!" + "客户名称为"
					+ icbc.getC_name() + "的审核已更新" + ";视频面签状态:"
					+ map.get(status_oldht) + ";留言:" + mq_remark + "时间:"
					+ creditutil.time() + ";";
			if (REGISTRATION_ID != null && !REGISTRATION_ID.equals("")) {
				Jdpush.testSendPush(appKey, masterSecret, REGISTRATION_ID,
						mString);
			}
			admin_msg admin_msg = new admin_msg();
			admin_msg.setDt_add(creditutil.time());
			admin_msg.setDt_edit(creditutil.time());
			admin_msg.setMid_add(adminid);
			admin_msg.setMsg(mString);
			admin_msg.setReceiveid(admin1.getId());
			admin_msg.setSendid(0);
			admin_msg.setStatus(0);
			admin_msgService.addadmin_msg(admin_msg);
		}
	}

	/*
	 * erp十五模块-汽车评估审核
	 */
	@RequestMapping(value = "erp/erp_pgsh.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public void erp_pgsh(int adminid, int result_1_code, String remark,
			int price_new, String icbc_pricecs, String price_result,
			int type_id, int icbc_id, int cars_id, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		PageData pdsession = (PageData) request.getSession().getAttribute("pd");// 获取session信息
		int status_oldht = 0;
		switch (result_1_code) {
		case 1: // 1通过
			status_oldht = 3;
			break;
		case 2: // 2拒绝
			status_oldht = 5;
			break;
		case 3: // 3回退补件
			status_oldht = 4;
			break;
		default:
			break;
		}
		assess_cars aCars = icbc_carsService.findicbc_cars1(icbc_id);
		icbc icbc = newicbcService.findicbcbyid(icbc_id);
		// 修改 assess_cars 评估表
		assess_cars assess_cars = new assess_cars();
		assess_cars.setId(aCars.getId());
		assess_cars.setIcbc_pricecs(Float.parseFloat(icbc_pricecs));
		assess_cars.setPrice_new(price_new);
		assess_cars.setMem_id(adminid);
		admin admin = adminService.adminbyid(adminid);
		assess_cars.setMem_name(admin.getName());
		assess_cars.setMem_tel(admin.getTel());
		assess_cars.setDt_edit(creditutil.time());
		int price = 0;
		if (price_result != null && !price_result.equals("")) {
			price = Integer.parseInt(price_result);
		}
		assess_cars.setPrice_result(price);
		assess_cars.setBc_status(status_oldht);
		icbc_carsService.upicbc_cars(assess_cars);
		// 修改 assess_bclient_check 表
		bclient_check bclient_check = new bclient_check();
		bclient_check.setDt_add(creditutil.time());
		bclient_check.setDt_edit(creditutil.time());
		bclient_check.setAssessid(aCars.getId());
		bclient_check.setStatus(status_oldht);
		bclient_check.setMid_add(adminid);
		bclient_check.setMid_edit(adminid);
		Map map = icbcmodel.pg_status();
		if (remark != null && !remark.equals("")) {
			bclient_check.setRemark(remark);
		} else {
			bclient_check.setRemark(map.get(status_oldht).toString());
		}
		icbc_cars_resultService.addbclient_check(bclient_check);
		// 保存进度之前先判断一下icbc_erp_kj_icbc表中是否有某个用户的某个板块
		PageData pdd = new PageData();
		pdd.put("dn", "selectOne_icbc_erp_kj_icbc");
		pdd.put("icbc_id", icbc_id);
		pdd.put("type_id", 3); // 汽车评估 对应 3
		PageData pErpIcbc = erp_fiveModelService.findbyid(pdd);
		/*
		 * 操作明细记录 start/////
		 */
		// 保存 进度留言记录
		PageData pResult = new PageData();
		pResult.put("dn", "icbc_erp_kj_icbc_result");
		pResult.put("mid_add", adminid);
		pResult.put("mid_edit", adminid);
		pResult.put("dt_add",
				getMaxPagedate_003(icbc_id, type_id).get("dt_edit"));
		pResult.put("dt_edit", creditutil.time());
		pResult.put("status", 11);
		pResult.put("status_oldht", status_oldht);
		pResult.put("remark", "结果反馈");
		pResult.put("result_1_code", result_1_code);
		pResult.put("result_1_msg", remark);
		JSONObject json = new JSONObject();
		json.put("price_new", price_new); // 裸车价格
		json.put("icbc_pricecs", Float.parseFloat(icbc_pricecs)); // 期望评估价
		json.put("price_result", price_result); // 系统评估价
		pResult.put("result_1_value", json.toString());
		pResult.put("dt_sub", creditutil.time());
		pResult.put("type_id", 3); // 汽车评估 对应 3
		pResult.put("icbc_id", icbc_id);
		/*
		 * 操作明细记录 end/////
		 */
		if (pErpIcbc != null) {
			pResult.put("qryid", pErpIcbc.get("id"));
			erp_fiveModelService.save(pResult);
			// 更新icbc_erp_kj_icbc表中，status的最新装填
			PageData upd = new PageData();
			upd.put("dn", "update_icbc_erp_kj_icbc");
			upd.put("icbc_id", icbc_id);
			upd.put("type_id", 3); // 汽车评估 对应 3
			upd.put("status", 11);
			upd.put("mid_edit", adminid); // 修改人id
			upd.put("dt_edit", creditutil.time()); // 修改时间
			erp_fiveModelService.updatebyid(upd);
		} else {
			PageData picbc = new PageData();
			picbc.put("dn", "icbc_erp_kj_icbc");
			picbc.put("mid_add", adminid);
			picbc.put("mid_edit", adminid);
			picbc.put("dt_add", creditutil.time());
			picbc.put("dt_edit", creditutil.time());
			picbc.put("dt_sub", creditutil.time());
			picbc.put("status", 11);
			picbc.put("icbc_id", icbc_id);
			picbc.put("gems_id", pdsession.get("gems_id")); // aCars.getGems_id()
															// pdsession.get("gems_id")
			picbc.put("gems_fs_id", pdsession.get("fs_id")); // aCars.getGems_fs_id()
																// pdsession.get("fs_id")
			picbc.put("type_id", 3); // 汽车评估 对应 3
			if (aCars != null) {
				picbc.put("c_carno", aCars.getC_carno());
				picbc.put("c_carvin", aCars.getVincode());
			}
			if (icbc != null) {
				picbc.put("c_name", icbc.getC_name());
				picbc.put("c_cardno", icbc.getC_cardno());
			}
			erp_fiveModelService.save(picbc);
			// result添加数据
			pResult.put("qryid", picbc.get("id"));
			erp_fiveModelService.save(pResult);
		}
		// 当确认 为 "通过"时
		// icbc表更新记录 和 result 表存一条完成记录
		if (result_1_code == 1) {
			// 更新icbc_erp_kj_icbc表中，status的最新装填
			PageData upd = new PageData();
			upd.put("dn", "update_icbc_erp_kj_icbc");
			upd.put("icbc_id", icbc_id);
			upd.put("type_id", 3); // 汽车评估 对应 3
			upd.put("status", 12);
			upd.put("mid_edit", adminid); // 修改人id
			upd.put("dt_edit", creditutil.time()); // 修改时间
			erp_fiveModelService.updatebyid(upd);
			PageData pResult_gsgd = new PageData();
			pResult_gsgd.put("dn", "icbc_erp_kj_icbc_result");
			pResult_gsgd.put("qryid", pErpIcbc.get("id"));
			pResult_gsgd.put("mid_add", adminid);
			pResult_gsgd.put("mid_edit", adminid);
			pResult_gsgd.put("dt_add", creditutil.time());
			pResult_gsgd.put("dt_edit", creditutil.time());
			pResult_gsgd.put("status", 12);
			pResult_gsgd.put("status_oldht", 0);
			pResult_gsgd.put("remark", "完成");
			pResult_gsgd.put("result_1_code", 0);
			pResult_gsgd.put("dt_sub", creditutil.time());
			pResult_gsgd.put("type_id", 3); // 抵押归档 对应 13
			pResult_gsgd.put("icbc_id", icbc_id);
			erp_fiveModelService.save(pResult_gsgd); // 保存 公司归档存 icbc result表
		}
		// 推送
		admin admin1 = adminService.adminbyid(pErpIcbc.getInt("mid_add"));
		if (admin1 != null && !admin1.equals("")) {
			String REGISTRATION_ID = admin1.getJgid();
			String mString = admin1.getName() + "您好!" + "客户名称为"
					+ icbc.getC_name() + "的审核已更新" + ";评估状态:"
					+ map.get(status_oldht) + ";留言:" + remark + "时间:"
					+ creditutil.time() + ";";
			if (REGISTRATION_ID != null && !REGISTRATION_ID.equals("")) {
				Jdpush.testSendPush(appKey, masterSecret, REGISTRATION_ID,
						mString);
			}
			admin_msg admin_msg = new admin_msg();
			admin_msg.setDt_add(creditutil.time());
			admin_msg.setDt_edit(creditutil.time());
			admin_msg.setMid_add(adminid);
			admin_msg.setMsg(mString);
			admin_msg.setReceiveid(admin1.getId());
			admin_msg.setSendid(0);
			admin_msg.setStatus(0);
			admin_msgService.addadmin_msg(admin_msg);
		}
		// request.setCharacterEncoding("UTF-8");
		// response.setContentType("text/html;charset=utf-8");
		// String msString="提交成功!";
		// PrintWriter out = response.getWriter();
		// out.print("<script language=\"javascript\">alert('"+msString+"');window.location.href='wdrw_from.do?type=wdrw&dn=wdrw&qn=form&icbc_id="+icbc_id+"&cn=w3&cn1=3&type_id="+type_id+"'</script>");
	}

	// 汽车评估最后一条数据
	public PageData getMaxPagedate_003(int icbc_id, int type_id) {
		List<PageData> erp15 = new ArrayList<>();
		PageData pd001 = new PageData();
		pd001.put("dn", "003");
		pd001.put("icbc_id", icbc_id);
		pd001.put("type_id", type_id);
		erp15 = erp_wdrwService.icbc_list(pd001);
		// 获取板块最后一条数据
		PageData pData2 = erp15.get(erp15.size() - 1);
		if (pData2 == null) {
			pData2.put("dt_edit", creditutil.time());
		}
		return pData2;
	}

	// 银行电审最后一条数据
	public PageData getMaxPagedate_004(int icbc_id, int type_id) {
		List<PageData> erp15 = new ArrayList<>();
		PageData pd004 = new PageData();
		pd004.put("dn", "004");
		pd004.put("icbc_id", icbc_id);
		pd004.put("type_id", type_id);
		erp15 = erp_wdrwService.icbc_list(pd004);
		// 获取板块最后一条数据
		PageData pData2 = erp15.get(erp15.size() - 1);
		if (pData2 == null) {
			pData2.put("dt_edit", creditutil.time());
		}
		return pData2;
	}

	// 视频面签板块最后一条数据
	public PageData getMaxPagedate_006(int icbc_id, int type_id) {
		List<PageData> erp15 = new ArrayList<>();
		PageData pd006 = new PageData();
		pd006.put("dn", "006");
		pd006.put("icbc_id", icbc_id);
		pd006.put("type_id", type_id);
		erp15 = erp_wdrwService.icbc_list(pd006);
		// 获取板块最后一条数据
		PageData pData2 = erp15.get(erp15.size() - 1);
		if (pData2 == null) {
			pData2.put("dt_edit", creditutil.time());
		}
		return pData2;
	}

	// 7跨区域业务-9内审通融板块-11银行贷款申请板块-12公司归档板块-14业务信息修改-15退单退费——最后一条数据
	public PageData getMaxPagedate_7_9_11_12_14_15(int icbc_id, int type_id) {
		List<PageData> erp15 = new ArrayList<>();
		PageData pd0011 = new PageData();
		pd0011.put("dn", "004");
		pd0011.put("icbc_id", icbc_id);
		pd0011.put("type_id", type_id);
		erp15 = erp_wdrwService.icbc_list(pd0011);
		// 获取板块最后一条数据
		PageData pData2 = erp15.get(erp15.size() - 1);
		if (pData2 == null) {
			pData2.put("dt_edit", creditutil.time());
		}
		return pData2;
	}
}
