package com.controller.erp_icbc;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.model1.icbc.erp.PageData;
import com.service1.fsService;
import com.service1.erp_icbc.erp_fiveModelService;
import com.service1.erp_icbc.erp_wdrwService;
import com.service1.kjs_icbc.icbc_result1Service;
import com.service1.kjs_icbc.newicbcService;
import com.service1.kjs_icbc.newicbc_kkService;
import com.service1.send.admin_msgService;

@Controller
public class erp_wdrw_2Controller {

	private static final String appKey = "7e21faf06524b22f0ee1414c";
	private static final String masterSecret = "c87361ae4d7d91067b3ea01a";

	@Autowired
	private erp_wdrwService erp_wdrwService;
	@Autowired
	private newicbcService newicbcService;
	@Autowired
	private newicbc_kkService newicbc_kkService;
	@Autowired
	private icbc_result1Service icbc_result1Service;
	@Autowired
	private com.service1.kjs_icbc.icbc_dkService icbc_dkService;
	@Autowired
	private fsService fService;
	@Autowired
	private com.service1.adminService adminService;
	@Autowired
	private admin_msgService admin_msgService;
	@Autowired
	private erp_fiveModelService erp_fiveModelService;

	// 通过HashSet踢除重复元素
	public static List removeDuplicate(List list) {
		HashSet h = new HashSet(list);
		list.clear();
		list.addAll(h);
		return list;
	}

	@RequestMapping(value = "erp/wdrw_list.do", produces = "text/html;charset=UTF-8")
	public String wdrw_list_up(Integer pagesize, Integer pagenow, String dn,
			String qn, String cn, String type, String fsid, String ywlx_id,
			Integer yw_id, String c_name, HttpServletRequest request)
			throws UnsupportedEncodingException {
		List<PageData> newpdList = new ArrayList<>();
		PageData pd1 = new PageData();
		PageData pd1_count = new PageData();// 数量传参
		PageData pd1_count_map = new PageData();// 数量输出
		PageData pdsession = (PageData) request.getSession().getAttribute("pd");// 获取session信息
		System.out.println("session:" + pdsession);
		System.out.println("erp业务节点ID:" + yw_id);
		// 点击取消审核标记
		PageData pdsh = new PageData();
		pdsh.put("operate_id", 0);
		pdsh.put("id", yw_id);
		pdsh.put("dn", "icbc_erp_kj_icbc");
		erp_wdrwService.update(pdsh);
		int ps = 0;
		int pn = 0;
		if (pagesize != null && !pagesize.equals("")) {
			ps = pagesize;
		} else {
			ps = 10;
		}
		if (pagenow != null && !pagenow.equals("")) {
			pn = pagenow;
		} else {
			pn = 1;
		}
		List<PageData> pdList = new ArrayList<>();
		List<PageData> pdList1 = new ArrayList<>();
		List<PageData> pdList2 = new ArrayList<>();
		List<Integer> status_ids = new ArrayList<>();
		pd1.put("cn", cn);
		pd1_count.put("cn", cn);
		// 根据业务类型查询
		if (ywlx_id != null && !ywlx_id.equals("")) {
			pd1.put("ywlx_id", ywlx_id);
			pd1_count.put("ywlx_id", ywlx_id);
			request.setAttribute("type_id", ywlx_id);
		}
		// 根据客户名字查询
		if (c_name != null && !c_name.equals("")) {
			pd1.put("c_name",
					new String(c_name.getBytes("ISO-8859-1"), "UTF-8"));
			pd1_count.put("c_name", new String(c_name.getBytes("ISO-8859-1"),
					"UTF-8"));
			System.out.println("客户姓名:"
					+ new String(c_name.getBytes("ISO-8859-1"), "UTF-8"));
			request.setAttribute("c_name",
					new String(c_name.getBytes("ISO-8859-1"), "UTF-8"));
		}
		int icbc_erp_tag = 0;
		if (pdsession.get("erp_tag") != null
				&& !pdsession.get("erp_tag").equals("")) {
			icbc_erp_tag = Integer
					.parseInt(pdsession.get("erp_tag").toString());
		}
		if (cn.equals("w2")) {
			pd1.put("dn", "wdcy");
			pd1_count.put("dn", "wdcy_count");
			pd1.put("admin_id", pdsession.get("id"));
			pd1_count.put("admin_id", pdsession.get("id"));
			pd1.put("pagenow", (pn - 1) * ps);
			pd1.put("pagesize", ps);
			System.out.println("用户ID：" + pdsession.get("id"));
			pd1_count_map = erp_wdrwService.icbc_form(pd1_count);
			pdList = erp_wdrwService.icbc_list(pd1);
		} else if (cn.equals("w0")) {
			List<PageData> pageDatas = new ArrayList<>();
			List<Integer> pIntegers = new ArrayList<>();
			if (pdsession.get("qx_type") != null
					&& !pdsession.get("qx_type").equals("")) {
				int qx_type = Integer.parseInt(pdsession.get("qx_type")
						.toString());
				if (qx_type == 1) {
					PageData dls_id = new PageData();
					dls_id.put("dn", "dls_cp1");
					dls_id.put("id", pdsession.get("gemsid"));
					pageDatas = erp_wdrwService.icbc_list(dls_id);
					for (PageData pdData : pageDatas) {
						if (pdData.get("id") != null
								&& !pdData.get("id").equals("")) {
							pIntegers.add(Integer.parseInt(pdData.get("id")
									.toString()));
						}
					}
					pd1.put("status_id", pIntegers);
					pd1_count.put("status_id", pIntegers);
				}
				if (icbc_erp_tag != 1) {
					if (qx_type == 2) {
						PageData dls_id = new PageData();
						dls_id.put("dn", "dls_cp2");
						dls_id.put("fsid", pdsession.get("fs_id"));
						pageDatas = erp_wdrwService.icbc_list(dls_id);
						for (PageData pdData : pageDatas) {
							if (pdData.get("id") != null
									&& !pdData.get("id").equals("")) {
								pIntegers.add(Integer.parseInt(pdData.get("id")
										.toString()));
							}
						}
						pd1.put("status_id", pIntegers);
						pd1_count.put("status_id", pIntegers);
					}
				}
			}
			pd1.put("dn", dn);
			pd1_count.put("dn", dn + "_count");
			pd1.put("pagenow", (pn - 1) * ps);
			pd1.put("pagesize", ps);
			pd1_count_map = erp_wdrwService.icbc_form(pd1_count);
			pdList = erp_wdrwService.icbc_list(pd1);
		} else if (cn.equals("w3")) {
			pd1.put("admin_id", pdsession.get("id"));
			pd1_count.put("admin_id", pdsession.get("id"));
			dn = "wdcy";
			if (pdsession.get("purview_map") != null
					&& !pdsession.get("purview_map").equals("")) {
				String qxs = pdsession.get("purview_map").toString();
				String[] sl = qxs.split(",");
				for (int i = 0; i < sl.length; i++) {
					// System.out.println("数组："+sl[i]);
					if (sl[i].indexOf("_") > 0) {
						int status = Integer.parseInt(sl[i].substring(
								sl[i].lastIndexOf("_") + 1, sl[i].length()));
						status_ids.add(status);

					}
				}
				pd1.put("status_id", status_ids);
				pd1_count.put("status_id", status_ids);
			}
			System.out.println("权限数组：" + pd1.get("status_id"));
			if (status_ids.size() == 0) {
				pd1.put("status_id", null);
				pd1_count.put("status_id", null);
			}
			pd1.put("pagenow", (pn - 1) * ps);
			pd1.put("pagesize", ps);
			pd1_count_map = erp_wdrwService.icbc_form(pd1_count);
			pdList = erp_wdrwService.icbc_list(pd1);
			if (status_ids.size() == 0) {
				System.out.println("空值：" + pdList.size());
				pdList = new ArrayList<>();
			}
			System.out.println("数据总数：" + pdList.size());
		} else {
			List<PageData> pageDatas = new ArrayList<>();
			List<Integer> pIntegers = new ArrayList<>();
			if (pdsession.get("qx_type") != null
					&& !pdsession.get("qx_type").equals("")) {
				int qx_type = Integer.parseInt(pdsession.get("qx_type")
						.toString());
				if (qx_type == 1) {
					PageData dls_id = new PageData();
					dls_id.put("dn", "dls_cp1");
					dls_id.put("id", pdsession.get("gemsid"));
					pageDatas = erp_wdrwService.icbc_list(dls_id);
					for (PageData pdData : pageDatas) {
						if (pdData.get("id") != null
								&& !pdData.get("id").equals("")) {
							pIntegers.add(Integer.parseInt(pdData.get("id")
									.toString()));
						}
					}
					pd1.put("status_id", pIntegers);
					pd1_count.put("status_id", pIntegers);
				}
				if (icbc_erp_tag != 1) {
					if (qx_type == 2) {
						PageData dls_id = new PageData();
						dls_id.put("dn", "dls_cp2");
						dls_id.put("fsid", pdsession.get("fs_id"));
						pageDatas = erp_wdrwService.icbc_list(dls_id);
						for (PageData pdData : pageDatas) {
							if (pdData.get("id") != null
									&& !pdData.get("id").equals("")) {
								pIntegers.add(Integer.parseInt(pdData.get("id")
										.toString()));
							}
						}
						pd1.put("status_id", pIntegers);
						pd1_count.put("status_id", pIntegers);
					}
				}
			}
			pd1.put("pagenow", (pn - 1) * ps);
			pd1.put("pagesize", ps);
			pd1.put("dn", dn);
			pd1.put("cn", "w1");
			pd1_count.put("dn", dn + "_count");
			pd1_count.put("cn", "w1");

			// 权限内状态 变更
			List<Integer> erp_statuslist = new ArrayList<>();// 变更后权限集合
			System.out.println("权限map:" + pdsession.get("purview_map"));
			if (pdsession.get("purview_map") != null
					&& !pdsession.get("purview_map").equals("")) {
				String qxs = pdsession.get("purview_map").toString();
				String[] sl = qxs.split(",");
				for (int i = 0; i < sl.length; i++) {
					// System.out.println("数组："+sl[i]);
					if (sl[i].indexOf("_") > 0) {
						// System.out.println("权限对应数字："+sl[i].substring(sl[i].lastIndexOf("_")+1,
						// sl[i].length()));
						String status = sl[i].substring(
								sl[i].lastIndexOf("_") + 1, sl[i].length());
						// System.out.println("权限对应状态："+status);
						if (status != null && !status.equals("")) {
							switch (status.toString()) {
							case "2":
								erp_statuslist.add(1);
								erp_statuslist.add(3);
								break;
							case "3":
								erp_statuslist.add(2);
								break;
							// case "4":
							// erp_statuslist.add(4);
							// break;
							case "5":
								erp_statuslist.add(7);
								break;
							case "6":
								erp_statuslist.add(5);
								break;
							case "7":
								erp_statuslist.add(6);
								break;
							case "8":
								erp_statuslist.add(7);
								// erp_statuslist.add(8);
								break;
							case "10":
								erp_statuslist.add(9);
								erp_statuslist.add(11);
								break;
							case "11":
								erp_statuslist.add(10);
								break;
							case "12":
								erp_statuslist.add(11);
								// erp_statuslist.add(12);
								break;
							case "14":
								erp_statuslist.add(13);
								erp_statuslist.add(15);
								break;
							case "15":
								erp_statuslist.add(14);
								break;
							case "16":
								erp_statuslist.add(15);
								// erp_statuslist.add(16);
								break;
							case "18":
								erp_statuslist.add(17);
								erp_statuslist.add(19);
								erp_statuslist.add(20);
								break;
							case "19":
								erp_statuslist.add(18);
								break;
							case "20":
								erp_statuslist.add(19);
								break;
							case "21":
								erp_statuslist.add(20);
								// erp_statuslist.add(21);
								break;
							case "23":
								erp_statuslist.add(22);
								erp_statuslist.add(24);
								break;
							case "24":
								erp_statuslist.add(23);
								break;
							case "25":
								erp_statuslist.add(24);
								// erp_statuslist.add(25);
								break;
							case "98":
								erp_statuslist.add(26);
								erp_statuslist.add(27);
								erp_statuslist.add(29);
								break;
							case "27":
								erp_statuslist.add(98);
								break;
							case "29":
								erp_statuslist.add(27);
								break;
							case "30":
								erp_statuslist.add(27);
								erp_statuslist.add(29);
								// erp_statuslist.add(30);
								break;
							case "32":
								erp_statuslist.add(31);
								break;
							case "33":
								erp_statuslist.add(32);
								break;
							case "40":
								erp_statuslist.add(33);
								erp_statuslist.add(37);
								erp_statuslist.add(39);
								// erp_statuslist.add(40);
								break;
							case "31":
								erp_statuslist.add(33);
								erp_statuslist.add(37);
								erp_statuslist.add(39);
								break;
							case "34":
								erp_statuslist.add(33);
								break;
							case "35":
								erp_statuslist.add(34);
								erp_statuslist.add(35);

								break;
							case "37":
								erp_statuslist.add(36);

								break;
							case "38":
								erp_statuslist.add(37);
								break;
							case "39":
								erp_statuslist.add(38);
								break;
							case "42":
								erp_statuslist.add(41);
								break;
							case "43":
								erp_statuslist.add(42);
								break;
							case "44":
								erp_statuslist.add(43);
								break;
							case "45":
								erp_statuslist.add(44);
								break;
							case "46":
								erp_statuslist.add(45);
								// erp_statuslist.add(46);

								break;
							case "48":
								erp_statuslist.add(47);
								erp_statuslist.add(52);
								break;
							case "49":
								erp_statuslist.add(47);
								erp_statuslist.add(99);
								erp_statuslist.add(51);
								erp_statuslist.add(52);
								break;
							case "52":
								erp_statuslist.add(48);
								break;
							case "99":
								erp_statuslist.add(49);
								break;
							case "50":
								erp_statuslist.add(99);
								erp_statuslist.add(51);
								erp_statuslist.add(54);
								break;
							case "51":
								erp_statuslist.add(50);

								break;
							case "55":
								erp_statuslist.add(51);
								// erp_statuslist.add(55);
								break;
							case "54":
								erp_statuslist.add(51);
								break;
							case "57":
								erp_statuslist.add(56);
								erp_statuslist.add(58);
								erp_statuslist.add(63);
								break;
							case "58":
								erp_statuslist.add(57);
								erp_statuslist.add(59);
								break;
							case "59":
								erp_statuslist.add(58);
								break;
							case "60":
								erp_statuslist.add(60);
								erp_statuslist.add(59);
								erp_statuslist.add(61);
								break;
							case "61":
								erp_statuslist.add(60);
								erp_statuslist.add(62);
								break;
							case "65":
								erp_statuslist.add(60);
								erp_statuslist.add(62);
								// erp_statuslist.add(65);
								break;
							case "63":
								erp_statuslist.add(60);
								erp_statuslist.add(63);
								break;
							case "62":
								erp_statuslist.add(61);
								break;
							case "64":
								erp_statuslist.add(64);
								break;
							case "67":
								erp_statuslist.add(66);
								erp_statuslist.add(69);
								erp_statuslist.add(70);
								break;
							case "68":
								erp_statuslist.add(67);
								break;
							case "69":
								erp_statuslist.add(67);
								break;
							case "70":
								erp_statuslist.add(68);
								break;
							case "71":
								erp_statuslist.add(70);
								// erp_statuslist.add(71);
								break;
							case "73":
								erp_statuslist.add(72);
								break;
							case "74":
								erp_statuslist.add(73);
								erp_statuslist.add(75);
								break;
							case "75":
								erp_statuslist.add(74);
								erp_statuslist.add(76);
								break;
							case "76":
								erp_statuslist.add(75);
								break;
							case "77":
								erp_statuslist.add(78);
								erp_statuslist.add(76);
								break;
							case "78":
								erp_statuslist.add(77);
								break;
							case "79":
								erp_statuslist.add(78);
								erp_statuslist.add(80);
								break;
							case "80":
								erp_statuslist.add(79);
								erp_statuslist.add(81);
								break;
							case "81":
								erp_statuslist.add(80);
								break;
							case "82":
								erp_statuslist.add(81);
								// erp_statuslist.add(82);
								break;
							case "96":
								erp_statuslist.add(83);
								break;
							case "84":
								erp_statuslist.add(96);
								break;
							case "85":
								erp_statuslist.add(84);
								break;
							case "86":
								erp_statuslist.add(84);
								erp_statuslist.add(85);
								// erp_statuslist.add(86);
								break;
							case "97":
								erp_statuslist.add(87);
								break;
							case "88":
								erp_statuslist.add(97);
								erp_statuslist.add(89);
								break;
							case "90":
								erp_statuslist.add(88);
								break;
							case "89":
								erp_statuslist.add(88);
								erp_statuslist.add(90);
								break;
							case "91":
								erp_statuslist.add(90);
								erp_statuslist.add(92);
								break;
							case "93":
								erp_statuslist.add(90);
								erp_statuslist.add(92);
								erp_statuslist.add(94);
								break;
							case "95":
								erp_statuslist.add(90);
								erp_statuslist.add(92);
								erp_statuslist.add(94);
								// erp_statuslist.add(95);
								break;
							case "92":
								erp_statuslist.add(91);
								break;
							case "94":
								erp_statuslist.add(93);
								break;
							case "101":
								erp_statuslist.add(100);
								break;
							case "102":
								erp_statuslist.add(101);
								erp_statuslist.add(103);
								break;
							case "104":
								erp_statuslist.add(101);
								erp_statuslist.add(103);
								break;
							case "103":
								erp_statuslist.add(102);
								break;
							}
						}
					}
				}
				System.out.println("去重前数据:" + erp_statuslist);
				System.out.println("去重后数据:" + removeDuplicate(erp_statuslist));
				pd1.put("erp_status", removeDuplicate(erp_statuslist));
				pd1_count.put("erp_status", removeDuplicate(erp_statuslist));
			}
			pd1_count_map = erp_wdrwService.icbc_form(pd1_count);
			pdList2 = erp_wdrwService.icbc_list(pd1);
			System.out.println("未分配权限前总数：" + pdList2.size());
			// 贷款本金
			int dkbj = 0;
			// 垫资类型
			int dz_type = 0;
			String knname = "";
			for (int i = 0; i < pdList2.size(); i++) {
				int erp_status = 0;
				PageData pData = pdList2.get(i);
				if (pData.get("kk_dk_price") != null
						&& !pData.get("kk_dk_price").equals("")) {
					dkbj = Integer
							.parseInt(pData.get("kk_dk_price").toString());
				}
				if (pData.get("kk_dz_type") != null
						&& !pData.get("kk_dz_type").equals("")) {
					dz_type = Integer.parseInt(pData.get("kk_dz_type")
							.toString());
				}
				if (pData.get("status") != null
						&& !pData.get("status").equals("")) {
					switch (pData.get("status").toString()) {
					case "1":
						pData.put("erp_status", 2);
						break;
					case "2":
						pData.put("erp_status", 3);
						break;
					case "3":
						if (pData.get("kir_code").toString().equals("1")
								|| pData.get("kir_code").toString().equals("2")) {
							pData.put("erp_status", 4);
						}
						if (pData.get("kir_code").toString().equals("3")) {
							pData.put("erp_status", 2);

						}
						break;
					case "4":
						pData.put("erp_status", 4);
						break;
					case "5":

						pData.put("erp_status", 6);
						break;
					case "6":

						pData.put("erp_status", 7);
						break;
					case "7":
						if (pData.get("kir_code").toString().equals("1")
								|| pData.get("kir_code").toString().equals("2")) {

							pData.put("erp_status", 8);
						}
						if (pData.get("kir_code").toString().equals("3")) {

							pData.put("erp_status", 5);
						}
						break;
					case "8":
						pData.put("erp_status", 8);
						break;
					case "9":
						pData.put("erp_status", 10);
						break;
					case "10":
						pData.put("erp_status", 11);
						break;
					case "11":
						if (pData.get("kir_code").toString().equals("1")
								|| pData.get("kir_code").toString().equals("2")) {
							pData.put("erp_status", 12);
						}
						if (pData.get("kir_code").toString().equals("3")) {
							pData.put("erp_status", 10);
						}

						break;
					case "12":
						pData.put("erp_status", 12);
						break;
					case "13":
						pData.put("erp_status", 14);
						break;
					case "14":
						pData.put("erp_status", 15);
						break;
					case "15":
						if (pData.get("kir_code").toString().equals("1")) {
							pData.put("erp_status", 16);
						} else if (pData.get("kir_code").toString().equals("3")) {
							pData.put("erp_status", 14);
						}

						break;
					case "16":
						pData.put("erp_status", 16);
						break;
					case "17":
						pData.put("erp_status", 18);
						break;
					case "18":
						pData.put("erp_status", 19);
						break;
					case "19":
						if (pData.get("kir_code").toString().equals("1")
								|| pData.get("kir_code").toString().equals("2")) {

							pData.put("erp_status", 20);
						} else if (pData.get("kir_code").toString().equals("3")) {

							pData.put("erp_status", 18);
						}
						break;
					case "20":
						if (pData.get("kir_code").toString().equals("1")
								|| pData.get("kir_code").toString().equals("2")) {
							pData.put("erp_status", 21);
						} else if (pData.get("kir_code").toString().equals("3")) {
							pData.put("erp_status", 18);
						}

						break;
					case "21":
						pData.put("erp_status", 21);
						break;
					case "22":
						pData.put("erp_status", 23);
						break;
					case "23":
						pData.put("erp_status", 24);
						break;
					case "24":
						if (pData.get("kir_code").toString().equals("1")) {
							pData.put("erp_status", 25);
						} else if (pData.get("kir_code").toString().equals("3")) {
							pData.put("erp_status", 23);
						}
						break;
					case "25":
						pData.put("erp_status", 25);
						break;
					case "26":
						pData.put("erp_status", 98);
						break;
					case "98":
						pData.put("erp_status", 27);
						break;
					case "27":

						// result_1_code 字段 1-通过 2-不通过 3-驳回
						if (pData.get("kir_code").toString().equals("1")) {
							pData.put("erp_status", 29);
						} else if (pData.get("kir_code").toString().equals("2")) {
							pData.put("erp_status", 30);
						} else if (pData.get("kir_code").toString().equals("3")) {
							pData.put("erp_status", 98);
						}
						break;
					/*
					 * case "28": pData.put("erp_status",27); break;
					 */
					case "29":
						if (pData.get("kir_code").toString().equals("1")) {
							pData.put("erp_status", 30);
						} else if (pData.get("kir_code").toString().equals("2")) {
							pData.put("erp_status", 30);
						} else if (pData.get("kir_code").toString().equals("3")) {
							pData.put("erp_status", 98);
						}
						break;
					case "30":
						pData.put("erp_status", 30);
						break;
					case "31":
						pData.put("erp_status", 32);
						break;
					case "32":
						pData.put("erp_status", 33);
						break;
					case "33":
						if (dkbj < 150000) {
							if (pData.get("kir_code").toString().equals("1")) {
								pData.put("erp_status", 40);
							} else if (pData.get("kir_code").toString()
									.equals("3")
									|| pData.get("kir_code").toString()
											.equals("2")) {
								pData.put("erp_status", 31);
							}
						} else {
							if (pData.get("kir_code").toString().equals("1")
									|| pData.get("kir_code").toString()
											.equals("2")) {
								pData.put("erp_status", 34);
							} else if (pData.get("kir_code").toString()
									.equals("3")) {
								pData.put("erp_status", 31);
							}
						}
						break;
					case "34":
						pData.put("erp_status", 35);
						break;
					case "35":
						if (dkbj < 300000) {
							if (pData.get("kir_code").toString().equals("1")) {
								pData.put("erp_status", 40);
							} else if (pData.get("kir_code").toString()
									.equals("3")
									|| pData.get("kir_code").toString()
											.equals("2")) {
								pData.put("erp_status", 31);
							}
						} else {
							if (pData.get("kir_code").toString().equals("1")
									|| pData.get("kir_code").toString()
											.equals("2")) {
								pData.put("erp_status", 36);

							} else if (pData.get("kir_code").toString()
									.equals("3")) {
								pData.put("erp_status", 31);
							}
						}
						break;
					case "36":
						pData.put("erp_status", 37);
						break;
					case "37":
						if (dkbj < 600000) {
							if (pData.get("kir_code").toString().equals("1")) {
								pData.put("erp_status", 40);
							} else if (pData.get("kir_code").toString()
									.equals("3")
									|| pData.get("kir_code").toString()
											.equals("2")) {
								pData.put("erp_status", 31);
							}
						} else {
							if (pData.get("kir_code").toString().equals("1")
									|| pData.get("kir_code").toString()
											.equals("2")) {
								pData.put("erp_status", 38);

							} else if (pData.get("kir_code").toString()
									.equals("3")) {
								pData.put("erp_status", 31);
							}
						}
						break;
					case "38":
						pData.put("erp_status", 39);
						break;
					case "39":
						if (pData.get("kir_code").toString().equals("1")) {

							pData.put("erp_status", 40);
						} else if (pData.get("kir_code").toString().equals("3")
								|| pData.get("kir_code").toString().equals("2")) {

							pData.put("erp_status", 31);
						}
						break;
					case "40":
						pData.put("erp_status", 40);
						break;
					case "41":
						pData.put("erp_status", 42);
						break;
					case "42":
						pData.put("erp_status", 43);
						break;
					case "43":
						pData.put("erp_status", 44);
						break;
					case "44":
						pData.put("erp_status", 45);
						break;
					case "45":
						pData.put("erp_status", 46);
						break;
					case "46":
						pData.put("erp_status", 46);
						break;
					case "47":
						if (dz_type == 2) {
							pData.put("erp_status", 48);
						} else {

							pData.put("erp_status", 49);
						}
						break;
					case "48":
						pData.put("erp_status", 52);
						break;
					case "49":
						pData.put("erp_status", 99);
						break;
					case "99":
						if (pData.get("kir_code").toString().equals("1")) {
							pData.put("erp_status", 50);
						} else {
							pData.put("erp_status", 49);
						}
						break;
					case "50":
						pData.put("erp_status", 51);

						break;
					case "51":
						if (pData.get("kir_code").toString().equals("1")) {

							pData.put("erp_status", 55);
						} else if (pData.get("kir_code").toString().equals("2")) {
							PageData pData3 = new PageData();
							pData3.put("dn", "yhds_tocode2");
							pData3.put("type_id", pData.get("type_id"));
							pData3.put("status", 51);
							pData3.put("icbc_id", pData.get("icbc_id"));
							PageData pData4 = erp_wdrwService.icbc_form(pData3);
							System.out.println("id对比：" + pData4.get("id")
									+ "--" + pData.get("id"));
							if (pData4.get("id").equals(pData.get("id"))) {
								pData.put("erp_status", 54);
							} else {
								pData.put("erp_status", 50);
							}
						} else if (pData.get("kir_code").toString().equals("3")) {
							pData.put("erp_status", 49);
						}
						break;
					case "52":
						if (pData.get("kir_code").toString().equals("2")) {
							pData.put("erp_status", 49);
						} else if (pData.get("kir_code").toString().equals("1")
								|| pData.get("kir_code").toString().equals("3")) {
							pData.put("erp_status", 48);
						}

						break;
					/*
					 * case "53": erp_status =54; break;
					 */
					case "54":
						pData.put("erp_status", 50);
						break;
					case "55":
						pData.put("erp_status", 55);
						break;
					case "56":
						pData.put("erp_status", 57);
						break;
					case "57":
						pData.put("erp_status", 58);
						break;
					case "58":
						JSONObject json = (JSONObject) JSON.parse(pData.get(
								"kir_value").toString());
						if (pData.get("kir_code").toString().equals("1")
								&& json.get("58_msg").toString().equals("已收到")) {
							pData.put("erp_status", 59);
						} else {
							pData.put("erp_status", 57);
						}
						break;
					case "59":
						JSONObject json2 = (JSONObject) JSON.parse(pData.get(
								"kir_value").toString());
						if (pData.get("kir_code").toString().equals("1")
								&& json2.get("58_msg").toString().equals("已收到")) {
							pData.put("erp_status", 60);
						} else {
							pData.put("erp_status", 58);
						}
						break;
					case "60":
						// 1、通过：往银行放款结果（放款结果中点击“失败”返回上一级）
						// 2、不通过：结束
						// 3、附条件：跳到“补充材料确认”-“材料不完整，需要机构补充”-“补充材料”提交-“补充材料确认”-“完整”-跳回第一步寄送材料
						// 4、先抵押后放贷：选择这个界面暂时不往下级走，等“抵押归档”模块完成开启“银行放款结果”
						if (pData.get("kir_code").toString().equals("1")) {
							pData.put("erp_status", 61);
						} else if (pData.get("kir_code").toString().equals("2")) {
							pData.put("erp_status", 65);
						} else if (pData.get("kir_code").toString().equals("3")) {
							pData.put("erp_status", 63);
						} else if (pData.get("kir_code").toString().equals("4")) {
							// 先抵押后放贷：选择这个界面暂时不往下级走，等“抵押归档”模块完成开启“银行放款结果”
							// 得到 抵押归档完成-小状态
							PageData get_status = new PageData();
							get_status.put("dn",
									"selectListStatus_icbc_erp_kj_icbc_result");
							get_status.put("icbc_id", pData.get("icbc_id"));
							get_status.put("type_id", 13); // 抵押归档-板块
							get_status.put("status", 82); // 抵押归档完成-小状态
							List<PageData> pErpIcbc_82 = new ArrayList<>();
							pErpIcbc_82 = erp_fiveModelService
									.findtolist(get_status);
							if (pErpIcbc_82.size() > 0) {
								// “抵押归档”模块完成 , 开启“银行放款结果”
								pData.put("erp_status", 61);
							} else {
								// “抵押归档”模块 未完成 ,暂时不往下级走
								pData.put("erp_status", 60);
							}
						}
						break;
					case "61":
						if (pData.get("kir_code").toString().equals("1")) {
							pData.put("erp_status", 62);
						} else if (pData.get("kir_code").toString().equals("2")) {
							pData.put("erp_status", 60);
						}
						break;
					case "62":
						if (pData.get("kir_code").toString().equals("1")) {
							pData.put("erp_status", 65);
						} else {
							pData.put("erp_status", 61);
						}
						break;
					case "63":
						if (pData.get("kir_code").toString().equals("1")) {
							pData.put("erp_status", 57);
						} else if (pData.get("kir_code").toString().equals("2")) {
							pData.put("erp_status", 63);
						}
						break;
					case "64":
						pData.put("erp_status", 64);
						break;
					case "65":
						pData.put("erp_status", 65);
						break;
					case "66":
						pData.put("erp_status", 67);
						break;
					case "67":
						if (pData.get("kir_code").toString().equals("1")) {
							pData.put("erp_status", 68);
						} else if (pData.get("kir_code").toString().equals("2")) {
							pData.put("erp_status", 69);
						}
						break;
					case "68":
						pData.put("erp_status", 70);
						break;
					case "69":
						pData.put("erp_status", 67);
						break;
					case "70":
						if (pData.get("kir_code").toString().equals("1")) {
							pData.put("erp_status", 71);
						} else if (pData.get("kir_code").toString().equals("2")) {
							pData.put("erp_status", 67);
						}
						break;
					case "71":
						pData.put("erp_status", 71);
						break;
					case "72":
						pData.put("erp_status", 73);
						break;
					case "73":
						pData.put("erp_status", 74);
						break;
					case "74":
						pData.put("erp_status", 75);
						break;
					case "75":
						JSONObject jsonObject = JSONObject.parseObject(pData
								.get("kir_value").toString());
						if (jsonObject.get("75_clfh").equals("不通过")
								|| jsonObject.get("75_sjqr").equals("未收到")) {
							pData.put("erp_status", 74);
						} else {
							pData.put("erp_status", 76);
						}
						break;
					case "76":
						JSONObject jsonObject1 = JSONObject.parseObject(pData
								.get("kir_value").toString());
						if (jsonObject1 != null) {
							if (jsonObject1.get("76_cyqk") != null
									&& !jsonObject1.get("76_cyqk").equals("")) {
								if (jsonObject1.get("76_cyqk").equals("不通过")) {
									pData.put("erp_status", 75);
								} else {
									pData.put("erp_status", 77);
								}
							}
						}
						break;
					case "77":
						pData.put("erp_status", 78);
						break;
					case "78":
						JSONObject jsonObject2 = JSONObject.parseObject(pData
								.get("kir_value").toString());
						if (jsonObject2.get("78_clfh").equals("不通过")
								|| jsonObject2.get("78_sjqr").equals("未收到")) {
							pData.put("erp_status", 77);
						} else {
							pData.put("erp_status", 79);
						}
						break;
					case "79":
						pData.put("erp_status", 80);
						break;
					case "80":
						JSONObject jsonObject3 = JSONObject.parseObject(pData
								.get("kir_value").toString());
						if (jsonObject3.get("80_clfh").equals("不通过")
								|| jsonObject3.get("80_sjqr").equals("未收到")) {
							pData.put("erp_status", 79);
						} else {
							pData.put("erp_status", 81);
						}

						break;
					case "81":
						JSONObject jsonObject4 = JSONObject.parseObject(pData
								.get("kir_value").toString());
						if (jsonObject4.get("81_cyqk").equals("不通过")) {
							pData.put("erp_status", 80);
						} else {
							pData.put("erp_status", 82);
						}
						break;
					case "82":
						pData.put("erp_status", 82);
						break;
					case "83":
						pData.put("erp_status", 96);
						break;
					case "96":
						pData.put("erp_status", 84);
						break;
					case "84":
						if (pData.get("kir_code").toString().equals("1")) {
							pData.put("erp_status", 85);
						} else if (pData.get("kir_code").toString().equals("2")) {
							pData.put("erp_status", 86);
						}
						break;
					case "85":
						pData.put("erp_status", 86);
						break;
					case "86":
						pData.put("erp_status", 86);
						break;
					case "87":
						pData.put("erp_status", 97);
						break;
					case "97":
						pData.put("erp_status", 88);
						break;
					case "88":
						if (pData.get("kir_code").toString().equals("1")) {
							pData.put("erp_status", 90);
						} else if (pData.get("kir_code").toString().equals("2")) {
							pData.put("erp_status", 89);
						}
						break;
					case "89":
						pData.put("erp_status", 88);
						break;
					case "90":
						// 得到是否 出账
						PageData pdd_status = new PageData();
						pdd_status.put("dn",
								"selectListStatus_icbc_erp_kj_icbc_result");
						pdd_status.put("icbc_id", pData.get("icbc_id"));
						pdd_status.put("type_id", 10); // 资金分配-板块
						pdd_status.put("status", 50); // 出账-小状态
						List<PageData> pErpIcbc_50 = new ArrayList<>();
						pErpIcbc_50 = erp_fiveModelService
								.findtolist(pdd_status);
						// 得到 集团收件确认 的结果
						PageData pdd_s = new PageData();
						pdd_s.put("dn",
								"selectListStatus_icbc_erp_kj_icbc_result");
						pdd_s.put("icbc_id", pData.get("icbc_id"));
						pdd_s.put("type_id", 11); // 汽车贷款-板块
						pdd_s.put("status", 58); // 集团收件确认-小状态
						List<PageData> pErpIcbc_58 = new ArrayList<>();
						pErpIcbc_58 = erp_fiveModelService.findtolist(pdd_s);
						// 得到最后一条数据
						PageData get_max58 = pErpIcbc_58
								.get(pErpIcbc_58.size() - 1);
						JSONObject json3 = (JSONObject) JSON.parse(pData.get(
								"kir_value").toString());
						if (pData.get("kir_code").toString().equals("1")) { // 通过
							if (pErpIcbc_50.size() > 0) { // 打钱啦
								// 通过-垫资 跳到91
								pData.put("erp_status", 91);
							} else {
								if (json3 != null) {
									if (json3.get("58_msg").toString()
											.equals("已收到")) {
										// 通过-未垫资-已收件 跳到93
										pData.put("erp_status", 93);
									} else if (json3.get("58_msg").toString()
											.equals("未收到")) {
										// 通过-未垫资-未收件 跳到95完成
										pData.put("erp_status", 95);
									}
								}
							}
						} else if (pData.get("kir_code").toString().equals("2")) {
							// 不通过
							pData.put("erp_status", 89);
						}
						break;
					case "91":
						pData.put("erp_status", 92);
						break;
					case "92":
						// 1到账、确认无误（已垫资已收件） 跳到93
						// 2已垫资未收件 跳到95
						// 3金额不符/未到账 跳到91
						if (pData.get("kir_code").toString().equals("1")) {
							pData.put("erp_status", 93);
						} else if (pData.get("kir_code").toString().equals("2")) {
							pData.put("erp_status", 95);
						} else if (pData.get("kir_code").toString().equals("3")) {
							pData.put("erp_status", 91);
						}
						break;
					case "93":
						pData.put("erp_status", 94);
						break;
					case "94":
						if (pData.get("kir_code").toString().equals("1")) {
							pData.put("erp_status", 95);
						} else if (pData.get("kir_code").toString().equals("2")) {
							pData.put("erp_status", 93);
						}
						break;
					case "95":
						pData.put("erp_status", 95);
						break;
					case "100":
						pData.put("erp_status", 101);
						break;
					case "101":
						if (pData.get("kir_code").toString().equals("1")) {
							pData.put("erp_status", 102);
						}
						if (pData.get("kir_code").toString().equals("2")) {
							pData.put("erp_status", 104);
						}
						break;
					case "102":
						pData.put("erp_status", 103);
						break;
					case "103":
						if (pData.get("kir_code").toString().equals("1")) {
							pData.put("erp_status", 104);
						}
						if (pData.get("kir_code").toString().equals("2")) {
							pData.put("erp_status", 102);
						}
						break;
					default:
						break;
					}
					PageData pData2 = new PageData();
					pData2.put("dn", "commtasknametoname");
					pData2.put("status", pData.get("erp_status"));
					PageData pd_names = erp_wdrwService.icbc_form(pData2);
					if (pd_names != null && !pd_names.equals("")) {
						pData.put("knname", pd_names.get("name"));
					}
					pdList.add(pData);
				}
			}
			System.out.println("判断状态后总数：" + pdList.size());
			// System.out.println("判断状态后json："+jsonutil.toJSONArray(pdList1));
			// 获取权限 里面的对应审核状态
			// if(pdsession.get("purview_map")!=null&&!pdsession.get("purview_map").equals("")){
			// String qxs=pdsession.get("purview_map").toString();
			// String[] sl=qxs.split(",");
			// for(int i=0;i<sl.length;i++){
			// //System.out.println("数组："+sl[i]);
			// if(sl[i].indexOf("_")>0){
			// //System.out.println("权限对应数字："+sl[i].substring(sl[i].lastIndexOf("_")+1,
			// sl[i].length()));
			// String status=sl[i].substring(sl[i].lastIndexOf("_")+1,
			// sl[i].length());
			// for(int j=0;j<pdList1.size();j++){
			// PageData pageData=pdList1.get(j);
			// //System.out.println("权限对应状态："+pageData.get("erp_status")+"--"+status);
			// if(pageData.get("erp_status")!=null&&!pageData.get("erp_status").equals("")){
			// if(status.equals(pageData.get("erp_status").toString())){
			// //System.out.println("相等的状态权限："+pageData.get("erp_status")+"--"+status);
			// pdList.add(pageData);
			// }
			// }
			// }
			// }
			// }
			// }
			// System.out.println("分配权限后总数："+pdList.size());
		}
		// 排序
		// Collections.sort(pdList,new Comparator<PageData>() {
		// /*
		// * int compare(PageData o1, PageData o2) 返回一个基本类型的整型，
		// * 返回负数表示：o1 小于o2，
		// * 返回0 表示：o1和o2相等，
		// * 返回正数表示：o1大于o2
		// */
		// @Override
		// public int compare(PageData o1, PageData o2) {
		// SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// Date sd1 = null;
		// Date sd2 = null;
		// try {
		// sd1=df.parse(o1.get("dt_edit").toString());
		// sd2=df.parse(o2.get("dt_edit").toString());
		// } catch (ParseException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// Integer i=sd1.compareTo(sd2);
		// //按照时间进行降序序排列
		// if(i<0){
		// return 1;
		// }
		// if(i==0){
		// return 0;
		// }
		// return -1;
		// }
		// });

		// newpdList = limitutil.fy(pdList, ps, pn);

		int totalpage = 0;// 总页数
		int totalsize = 0; // 总数量
		if (pd1_count_map != null && !pd1_count_map.equals("")) {
			if (pd1_count_map.get("totalsize") != null
					&& !pd1_count_map.get("totalsize").equals("")) {
				totalsize = Integer.parseInt(pd1_count_map.get("totalsize")
						.toString());
			}
		}
		int q = totalsize % ps;
		if (q == 0) {
			totalpage = totalsize / ps;
		} else {
			totalpage = totalsize / ps + 1;
		}
		System.out.println("当前页：" + pn + ",每页数量：" + ps + ",总数量：" + totalsize
				+ ",总页数：" + totalpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("totalsize", totalsize);
		request.setAttribute("newpdList", pdList);
		request.setAttribute("pagesize", ps);
		request.setAttribute("pagenow", pn);
		request.setAttribute("dn", dn);
		request.setAttribute("cn", cn);
		request.setAttribute("qn", qn);
		request.setAttribute("type", type);
		request.setAttribute("yw_id", yw_id);
		return "kjs_icbc/index";

	}
}
