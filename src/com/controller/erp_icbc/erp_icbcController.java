package com.controller.erp_icbc;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.controller.ManagementCenter.Management.Management;
import com.controller.erp_icbc.modal.zhqx_modal;
import com.model1.icbc.erp.PageData;
import com.model1.money.moneyfs;
import com.model1.money.moneyfs_1;
import com.service1.fsService;
import com.service1.car.icbc_carsService;
import com.service1.erp_icbc.YXService;
import com.service1.erp_icbc.erp_userrootService;
import com.service1.erp_icbc.fs_detailsService;
import com.service1.icbc_banklist.icbc_banklistService;
import com.service1.kjs_icbc.newicbcService;
import com.service1.kjs_icbc.newicbc_kkService;
import com.service1.money.moneyfsService;
import com.service1.money.moneyfs_1Service;
import com.util.creditutil;
import com.util.jsonutil;
import com.util.limitutil;
import com.util.md5util;
import com.util.duoying.MD5;

@Controller
public class erp_icbcController {

	@Autowired
	private newicbcService newicbcService;
	@Autowired
	private fsService fService;
	@Autowired
	private icbc_carsService icbc_carsService;
	@Autowired
	private newicbc_kkService newicbc_kkService;
	@Autowired
	private erp_userrootService erp_userrootService;
	@Autowired
	private fs_detailsService fs_detailsService;
	@Autowired
	private Management Management;
	@Autowired
	private YXService YXService;
	@Autowired
	private icbc_banklistService icbc_banklistService;
	@Autowired
	private moneyfsService moneyfsService;
	@Autowired
	private moneyfs_1Service moneyfs_1Service;

	/**
	 * 获取精确到秒的时间戳
	 * 
	 * @return
	 */
	public static int getSecondTimestamp(Date date) {
		if (null == date) {
			return 0;
		}
		String timestamp = String.valueOf(date.getTime());
		int length = timestamp.length();
		if (length > 3) {
			return Integer.valueOf(timestamp.substring(0, length - 3));
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {
		System.out.println(getSecondTimestamp(new Date()));
	}

	/**
	 * 主题背景
	 * 
	 * @param id
	 * @param skinsname
	 * @return
	 */
	@RequestMapping(value = "erp/skins.do", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String skins(String skinsname, HttpServletRequest request) {
		PageData pData = (PageData) request.getSession().getAttribute("pd");
		PageData pd = new PageData();
		pd.put("dn", "skins");
		pd.put("admin_id", pData.get("id"));
		PageData pdData = erp_userrootService.findbyid(pd);
		if (pdData != null && !pdData.equals("")) {
			pd.put("id", pdData.get("id"));
			pd.put("skins_name", skinsname);
			erp_userrootService.updatebyid(pd);
		} else {
			PageData pd1 = new PageData();
			pd1.put("dn", "skins");
			pd1.put("skins_name", skinsname);
			pd1.put("admin_id", pData.get("id"));
			erp_userrootService.save(pd1);
		}
		return "1";
	}

	@RequestMapping(value = "erp/skins_name.do", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String skins_name(HttpServletRequest request) {
		PageData pData = (PageData) request.getSession().getAttribute("pd");
		PageData pd = new PageData();
		pd.put("dn", "skins");
		pd.put("admin_id", pData.get("id"));
		PageData pdData = erp_userrootService.findbyid(pd);
		return pdData.getString("skins_name");
	}

	/**
	 * 开通&屏蔽
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "erp/user_pb.do", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String user_pb(String dn, Integer id, Integer showtag) {
		PageData pagedate = new PageData();
		pagedate.put("dn", "user_pb");
		pagedate.put("dbname", dn);
		pagedate.put("showtag", showtag);
		pagedate.put("id", id);
		erp_userrootService.updatebyid(pagedate);
		return "1";
	}

	/**
	 * 
	 * 公司名称验证
	 * 
	 * @return
	 */
	@RequestMapping(value = "erp/ajax_fs_name.do", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String ajax_fs_name(String name) {
		PageData pagedate = new PageData();
		pagedate.put("dn", "assess_fs_name");
		pagedate.put("name", name);
		List<PageData> pDatas = erp_userrootService.findtolist(pagedate);
		return jsonutil.toJSONArray(pDatas).toString();
	}

	// 查询返回 fs名称英文
	@RequestMapping(value = "erp/ajax_fs.do", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String ajax_fs(Integer id, String dn) {
		PageData pagedate = new PageData();
		pagedate.put("dn", dn);
		pagedate.put("id", id);
		PageData pd = erp_userrootService.findbyid(pagedate);
		return jsonutil.toJSONObject(pd).toString();
	}

	/**
	 * 根据等级cp查询公司下账户
	 * 
	 * @return
	 */
	@RequestMapping(value = "erp/assess_gems_cp.do", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String assess_gems_cp(String cp, String fsid, String id) {
		PageData pd = new PageData();
		pd.put("dn", "assess_gems_cp");
		pd.put("cp", cp);
		pd.put("fsid", fsid);
		pd.put("id", id);
		System.out.println("cp参数:" + pd);
		List<PageData> pdList = erp_userrootService.findtolist(pd);
		return jsonutil.toJSONArray(pdList).toString();
	}

	/**
	 * 验证用户名是否可用
	 * 
	 * @param username
	 * @return
	 */
	@RequestMapping(value = "erp/signusername.do", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String signusername(String username) {
		PageData pd = new PageData();
		pd.put("dn", "signusername");
		pd.put("username", username);
		PageData pageData = erp_userrootService.findbyid(pd);
		if (pageData != null && !pageData.equals("")) {
			return "1";
		} else {
			return "0";
		}
	};

	/**
	 * form表单查看
	 * 
	 * @param id
	 * @param dn
	 * @param qn
	 * @param cn
	 * @param request
	 * @return
	 */

	@RequestMapping(value = "erp/user_form.do", produces = "text/html;charset=UTF-8")
	public String user_form(Integer id, String dn, String qn, String cn,
			HttpServletRequest request) {
		PageData pData = (PageData) request.getSession().getAttribute("pd");
		PageData pagedate = new PageData();
		pagedate.put("dn", dn);
		pagedate.put("id", id);
		System.out.println(pagedate);
		PageData pd = erp_userrootService.findbyid(pagedate);
		// 公司查询
		PageData pd1 = new PageData();
		pd1.put("dn", "assess_fs");
		pd1.put("fsid", pData.get("icbc_erp_fsid"));
		pd1.put("up_id", pData.get("icbc_erp_fsid"));
		List<PageData> pageDatas1 = erp_userrootService.findtolist(pd1);
		PageData pd2 = new PageData();
		pd2.put("dn", "icbc_erp_admin_agp");
		pd2.put("showtag", 1);
		pd2.put("fsid", pData.get("icbc_erp_fsid"));
		List<PageData> pageDatas2 = erp_userrootService.findtolist(pd2);
		// 银行查询
		List<PageData> banklist = new ArrayList<PageData>();
		PageData bank_pd = new PageData();
		if (Integer.parseInt(pData.get("icbc_erp_fsid").toString()) == 1708) {
			System.out.println("进来啦吗");
			banklist = icbc_banklistService.geticbc_banklist();
		} else {
			if (pData.get("fs_zy_bank") != null
					&& !pData.get("fs_zy_bank").equals("")) {
				String[] zy_banks = ((String) pData.get("fs_zy_bank"))
						.split("\u0005");
				List idlist = new ArrayList<Integer>();
				for (int i = 0; i < zy_banks.length; i++) {
					if (zy_banks[i] != null && !zy_banks[i].equals("")) {
						idlist.add(zy_banks[i]);
					}
				}
				System.out.println(idlist + "s数组**********");
				bank_pd.put("status_id", idlist);
				bank_pd.put("fsid", pData.get("icbc_erp_fsid"));
			} else {
				bank_pd.put("fsid", "0");
			}
			banklist = icbc_banklistService.geticbc_banklistbyID(bank_pd);
		}
		System.out.println("银行列表：" + banklist);
		request.setAttribute("banklist", banklist);
		request.setAttribute("pageDatas", pageDatas1);
		request.setAttribute("pageDatas2", pageDatas2);
		// cn 1增 2删 3改 4查
		request.setAttribute("cn", cn);
		request.setAttribute("dn", dn);
		request.setAttribute("qn", qn);
		request.setAttribute("pd", pd);
		return "kjs_icbc/index";
	}

	/**
	 * 真的删除 毫无痕迹
	 * 
	 * @param dn
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "erp/deletebyid.do", produces = "text/html;charset=UTF-8")
	public ModelAndView deletebyid(String dn, Integer id, String type, String qn) {
		PageData pd = new PageData();
		pd.put("dn", dn);
		pd.put("id", id);
		erp_userrootService.deletebyid(pd);
		return new ModelAndView("redirect:user_list.do?type=" + type + "&dn="
				+ dn + "&qn=" + qn);
	}

	// 模拟删除
	@RequestMapping(value = "erp/user_del.do", produces = "text/html;charset=UTF-8")
	public ModelAndView user_del(Integer id, String dn, String qn, String type,
			HttpServletRequest request) {
		PageData pData = (PageData) request.getSession().getAttribute("pd");

		System.out.println(id + "****************" + pData.get("fs_id"));
		PageData pagedate = new PageData();
		PageData pagedate1 = new PageData();
		pagedate.put("dn", "user_del");
		pagedate.put("id", id);
		if (dn.equals("assess_gems")) {
			PageData pagedate2 = new PageData();
			pagedate2.put("dn", dn);
			pagedate2.put("id", id);
			PageData pagedate2map = erp_userrootService.findbyid(pagedate2);
			if (pagedate2map != null && !pagedate2map.equals("")) {
				System.out.println("gemsid：" + pagedate2map.get("gemsid"));
				pagedate1.put("dbname", "assess_gems");
				pagedate1.put("deltag", 1);
				pagedate1.put("dn", "user_del");
				pagedate1.put("id", pagedate2map.get("gemsid"));
				erp_userrootService.updatebyid(pagedate1);
			}
			pagedate.put("dbname", "assess_admin");
		} else {
			pagedate.put("dbname", dn);
		}
		pagedate.put("deltag", 1);
		System.out.println(pagedate + "****************");
		erp_userrootService.updatebyid(pagedate);
		request.setAttribute("dn", dn);
		request.setAttribute("qn", qn);
		request.setAttribute("type", type);
		return new ModelAndView("redirect:user_list.do?type=" + type + "&dn="
				+ dn + "&qn=" + qn + "&cn=4001&fsid=" + pData.get("fs_id"));
	}

	/**
	 * 编辑更新
	 * 
	 * @param id
	 * @param dn
	 * @param qn
	 * @param type
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "erp/user_update.do", produces = "text/html;charset=UTF-8")
	public ModelAndView user_update(Integer id, Integer userid, String dn,
			String qn, String type, String name, String name_qy,
			String showtag, String state_id, String city_id, String address,
			String code_pre, String namepy, HttpServletRequest request) {
		System.out.println(id + "****************" + name_qy);
		PageData pagedate = new PageData();
		pagedate.put("dn", dn);
		pagedate.put("id", id);
		pagedate.put("name", name);
		pagedate.put("name_qy", name_qy);
		pagedate.put("showtag", showtag);
		pagedate.put("state_id", state_id);
		pagedate.put("city_id", city_id);
		pagedate.put("address", address);
		pagedate.put("code_pre", code_pre);
		pagedate.put("namepy", namepy);
		pagedate.put("dt_edit", new Date());
		pagedate.put("mid_edit", userid);
		erp_userrootService.updatebyid(pagedate);
		request.setAttribute("dn", dn);
		request.setAttribute("qn", qn);
		request.setAttribute("type", type);
		return new ModelAndView("redirect:user_list.do?type=" + type + "&dn="
				+ dn + "&qn=" + qn);
	}

	/**
	 * 编辑更新admin&gems
	 * 
	 * @param id
	 * @param dn
	 * @param qn
	 * @param type
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "erp/admin_gems_update.do", produces = "text/html;charset=UTF-8")
	public ModelAndView admin_gems_update(Integer fsid, String name,
			String mobile, String username, String password, Integer cp,
			Integer upac_id, String idcard, String dn, String qn, String type,
			String userid, String agpid, String mid_add, String bc_title,
			String email, Integer adminid, Integer gemsid,
			@RequestParam("file") MultipartFile file, int ssbm,
			HttpServletRequest request) throws IOException {
		System.out.println("********编辑更新admin&gems********");
		PageData pagedate = new PageData();
		System.out.println("file：" + file);
		if (file != null) {
			Date date = new Date();
			String filePath = "/KCDIMG/assess/upload/"
					+ new SimpleDateFormat("yyyy/MM/dd/").format(date);
			String imgpath = "upload/"
					+ new SimpleDateFormat("yyyy/MM/dd/").format(date);
			String filename = file.getOriginalFilename();
			System.out.println("filename:" + filename);
			if (filename != null && !filename.equals("")) {
				String prefix = filename
						.substring(filename.lastIndexOf(".") + 1);
				UUID uuid = UUID.randomUUID();
				String uuidname = uuid.toString().replaceAll("-", "") + "."
						+ prefix;
				byte[] file36Byte = file.getBytes();
				FileUtils.writeByteArrayToFile(new File(filePath + uuidname),
						file36Byte);
				System.out.println("图片路径：" + filePath + uuidname);
				pagedate.put("imgurl", imgpath + uuidname);
			} else {
				pagedate.put("imgurl", "");
			}
		} else {
			pagedate.put("imgurl", "");
		}
		pagedate.put("ssbm", ssbm);
		pagedate.put("dn", "assess_gems");
		pagedate.put("name", name);
		pagedate.put("fsid", fsid);
		pagedate.put("mobile", mobile);
		pagedate.put("cp", cp);
		pagedate.put("username", username);
		pagedate.put("idcard", idcard);
		pagedate.put("update_time", getSecondTimestamp(new Date()));
		pagedate.put("upac_id", upac_id);
		pagedate.put("dt_edit", new Date());
		pagedate.put("id", gemsid);
		erp_userrootService.updatebyid(pagedate);
		PageData pd = new PageData();
		pd.put("dn", "assess_admin");
		pd.put("mid_edit", userid);
		pd.put("dt_edit", new Date());
		pd.put("username", username);
		if (password != null && !password.equals("")) {
			pd.put("userpass", MD5.sign(MD5.sign(password, "UTF-8"), "UTF-8"));
		}
		pd.put("tel", mobile);
		pd.put("email", email);
		pd.put("name", name);
		pd.put("erp_agpid", agpid);
		pd.put("agpid", 0);
		pd.put("icbc_erp_fsid", fsid);
		pd.put("bc_title", bc_title);
		pd.put("upac_id", upac_id);
		pd.put("cp", cp);
		pd.put("id", adminid);
		erp_userrootService.updatebyid(pd);
		request.setAttribute("dn", dn);
		request.setAttribute("qn", qn);
		request.setAttribute("type", type);
		System.out.println("正常执行");
		return new ModelAndView("redirect:user_list.do?type=" + type + "&dn="
				+ dn + "&qn=" + qn + "&cn=4001");
	}

	// 添加gems 人员
	@Transactional
	@RequestMapping(value = "erp/assess_gems_add.do", produces = "text/html;charset=UTF-8")
	public ModelAndView assess_gems_add(Integer fsid, String name,
			String mobile, String username, String password, Integer cp,
			Integer upac_id, String idcard, String dn, String qn, String type,
			String userid, String agpid, String mid_add, String bc_title,
			String email, @RequestParam("file") MultipartFile file, int ssbm,
			HttpServletRequest request) throws IOException {
		PageData pagedate = new PageData();
		System.out.println("file:" + file);
		if (file != null) {
			Date date = new Date();
			String filePath = "/KCDIMG/assess/upload/"
					+ new SimpleDateFormat("yyyy/MM/dd/").format(date);
			String imgpath = "upload/"
					+ new SimpleDateFormat("yyyy/MM/dd/").format(date);
			String filename = file.getOriginalFilename();
			if (filename != null && !filename.equals("")) {
				String prefix = filename
						.substring(filename.lastIndexOf(".") + 1);
				UUID uuid = UUID.randomUUID();
				String uuidname = uuid.toString().replaceAll("-", "") + "."
						+ prefix;
				byte[] file36Byte = file.getBytes();
				FileUtils.writeByteArrayToFile(new File(filePath + uuidname),
						file36Byte);
				System.out.println("图片路径：" + filePath + uuidname);
				pagedate.put("imgurl", imgpath + uuidname);
			} else {
				pagedate.put("imgurl", "");
			}
		} else {
			pagedate.put("imgurl", "");
		}
		pagedate.put("ssbm", ssbm);
		pagedate.put("dn", "assess_gems");
		pagedate.put("name", name);
		pagedate.put("fsid", fsid);
		pagedate.put("mem_id", userid);
		pagedate.put("showtag", 1);
		pagedate.put("mobile", mobile);
		pagedate.put("cp", cp);
		pagedate.put("username", username);
		pagedate.put("aid", 0);
		pagedate.put("idcard", idcard);
		pagedate.put("create_time", getSecondTimestamp(new Date()));
		pagedate.put("update_time", getSecondTimestamp(new Date()));
		pagedate.put("fs_type", 2);
		pagedate.put("upac_id", upac_id);
		pagedate.put("aid_ssm", 0);
		pagedate.put("dt_add", new Date());
		pagedate.put("dt_edit", new Date());
		pagedate.put("appkey", "");
		erp_userrootService.save(pagedate);
		PageData pd = new PageData();
		pd.put("dn", "assess_admin");
		pd.put("username", username);
		pd.put("userpass", MD5.sign(MD5.sign(password, "UTF-8"), "UTF-8"));
		pd.put("name", name);
		pd.put("tel", mobile);
		pd.put("erp_agpid", agpid);
		pd.put("agpid", 0);
		pd.put("bc_title", bc_title);
		pd.put("email", email);
		pd.put("icbc_erp_tag", 1);
		pd.put("dt_add", new Date());
		pd.put("dt_edit", new Date());
		pd.put("showtag", 1);
		pd.put("fs_type", 2);
		pd.put("mid_add", userid);
		pd.put("mid_edit", userid);
		pd.put("upac_id", upac_id);
		pd.put("cp", cp);
		pd.put("icbc_erp_fsid", fsid);
		// pd.put("deltag","");
		pd.put("isadmin", 1);
		// pd.put("issupplier","");
		// pd.put("sex","");
		// pd.put("logindt","");
		// pd.put("logincode","");
		// pd.put("limit_list","");
		// pd.put("imgurl","");
		// pd.put("stateid","");
		// pd.put("cityid","");
		// pd.put("eeid","");
		// pd.put("note","");
		// pd.put("wx_openid","");
		pd.put("gemsid", pagedate.get("id"));
		// pd.put("bc_title","");
		// pd.put("jgid","");
		pd.put("loginip", 0);
		// pd.put("ssm_id","");
		erp_userrootService.save(pd);
		request.setAttribute("dn", dn);
		request.setAttribute("qn", qn);
		request.setAttribute("type", type);
		return new ModelAndView("redirect:user_list.do?type=" + type + "&dn="
				+ dn + "&qn=" + qn + "&cn=4001");
	}

	// 添加公司
	@RequestMapping(value = "erp/assess_fs_add.do", produces = "text/html;charset=UTF-8")
	public ModelAndView assess_fs_add(
			// assess_fs assess_fs,
			HttpServletRequest request,
			@RequestParam("fileimg") MultipartFile fileimg) {
		Map<String, String> paramemap = Tools.getpostmap(request);
		// Enumeration<?> enu=request.getParameterNames();
		// while(enu.hasMoreElements()){
		// String paraName=(String)enu.nextElement();
		// //System.out.println(paraName+": "+request.getParameter(paraName));
		// paramemap.put(paraName, request.getParameter(paraName));
		// }
		System.out.println("获取参数map：" + paramemap);
		System.err.println("purview_map_kjs:"
				+ paramemap.get("purview_map_kjs"));
		System.err.println("purview_map:" + paramemap.get("purview_map"));
		PageData pData = (PageData) request.getSession().getAttribute("pd");
		PageData fs_details = new PageData();
		PageData pagedate = new PageData();
		String fileName = "";
		String filrurl = "";
		Date date = new Date();
		String filePath = "/KCDIMG/assess/upload/"
				+ new SimpleDateFormat("yyyy/MM/dd/").format(date);
		if (fileimg != null && !fileimg.equals("")) {
			try {
				fileName = fileimg.getOriginalFilename();
				fileName = md5util.encode(fileName) + "."
						+ md5util.getExtensionName(fileName);
				filePath = "/KCDIMG/assess/upload/"
						+ new SimpleDateFormat("yyyy/MM/dd/").format(date);
				if (fileimg.getSize() > 0) {
					md5util.uploadFile(fileimg.getBytes(), filePath, fileName);
					filrurl = "assess/upload/"
							+ new SimpleDateFormat("yyyy/MM/dd/").format(date)
							+ fileName;
					System.out.println("存放路径：" + filePath + fileName);
					System.out.println("数据库路径：" + filrurl);
					pagedate.put("oemimgurl", filrurl);
				} else {
					pagedate.put("oemimgurl", "");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			pagedate.put("oemimgurl", "");
		}
		pagedate.put("dn", "assess_fs");
		pagedate.put("name", paramemap.get("name"));
		pagedate.put("name_qy", paramemap.get("name_qy"));
		pagedate.put("showtag", paramemap.get("showtag"));
		if (paramemap.get("company_province") != null
				&& !paramemap.get("company_province").equals("")) {
			pagedate.put("state_id", paramemap.get("company_province"));
		} else {
			pagedate.put("state_id", 0);
		}
		if (paramemap.get("company_city") != null
				&& !paramemap.get("company_city").equals("")) {
			pagedate.put("city_id", paramemap.get("company_city"));
		} else {
			pagedate.put("city_id", 0);
		}

		if (paramemap.get("company_section") != null
				&& !paramemap.get("company_section").equals("")) {
			pagedate.put("zone_id", paramemap.get("company_section"));
		} else {
			pagedate.put("zone_id", 0);
		}
		pagedate.put("address", paramemap.get("company_address"));
		pagedate.put("code_pre", paramemap.get("code_pre"));
		pagedate.put("namepy", paramemap.get("namepy"));
		pagedate.put("create_time", getSecondTimestamp(new Date()));
		pagedate.put("update_time", getSecondTimestamp(new Date()));
		pagedate.put("fs_type", 2);
		pagedate.put("oem", "");
		pagedate.put("rec_id", 0);
		pagedate.put("support", "");
		pagedate.put("sup_tel", "");
		pagedate.put("url_apk", "");
		pagedate.put("dt_add", new Date());
		pagedate.put("dt_edit", new Date());
		String dbr_names = paramemap.get("dbr_name[]");
		System.out.println("数组字符串：" + dbr_names);

		if (paramemap.get("icbc_erp_tag") != null
				&& !paramemap.get("icbc_erp_tag").equals("")
				&& paramemap.get("icbc_erp_tag").equals("1")) {
			pagedate.put("icbc_erp_tag", 1);
		}
		System.out.println("******************" + pData.get("icbc_erp_fsid"));
		pagedate.put("mid_add", paramemap.get("userid"));
		pagedate.put("mid_edit", paramemap.get("userid"));
		pagedate.put("up_id",
				Integer.parseInt(pData.get("icbc_erp_fsid").toString()));
		pagedate.put("url_ios", "");
		pagedate.put("zx_mbg", 0);
		pagedate.put("mg_tag", 1);
		pagedate.put("deltag", 0);
		pagedate.put("super_queryarchives_tag", 0);
		// APP权限控制
		pagedate.put("purview_map", paramemap.get("purview_map"));
		pagedate.put("purview_map_kjs", paramemap.get("purview_map_kjs"));
		pagedate.put("mgicbc_tag", 0);
		erp_userrootService.save(pagedate);

		fs_details.put("dn", "assess_fs_details");
		fs_details.put("xt_name", paramemap.get("xt_name"));
		fs_details.put("mid_add", paramemap.get("userid"));
		fs_details.put("mid_edit", paramemap.get("userid"));
		fs_details.put("dt_add", new Date());
		fs_details.put("dt_edit", new Date());
		fs_details.put("company_jc", paramemap.get("name"));
		fs_details.put("qy_company", paramemap.get("name_qy"));
		fs_details.put("contract_code", paramemap.get("contract_code"));
		fs_details.put("hz_date1", paramemap.get("hz_date1"));
		fs_details.put("hz_date2", paramemap.get("hz_date2"));
		fs_details.put("fr_name", paramemap.get("fr_name"));
		fs_details.put("fr_tel", paramemap.get("fr_tel"));
		fs_details.put("fr_card", paramemap.get("fr_card"));
		fs_details.put("sjkgr", paramemap.get("sjkgr"));
		fs_details.put("sjkgr_name", paramemap.get("sjkgr_name"));
		fs_details.put("sjkgr_card", paramemap.get("sjkgr_card"));
		fs_details.put("sjkgr_tel", paramemap.get("sjkgr_tel"));
		fs_details.put("company_date", paramemap.get("company_date"));
		fs_details.put("register_capital", paramemap.get("register_capital"));
		fs_details.put("sj_capital", paramemap.get("sj_capital"));
		fs_details.put("company_num", paramemap.get("company_num"));
		fs_details.put("company_province", paramemap.get("company_province"));
		fs_details.put("company_city", paramemap.get("company_city"));
		fs_details.put("company_section", paramemap.get("company_section"));
		fs_details.put("company_address", paramemap.get("company_address"));
		fs_details.put("register_province", paramemap.get("register_province"));
		fs_details.put("register_city", paramemap.get("register_city"));
		fs_details.put("register_section", paramemap.get("register_section"));
		fs_details.put("register_address", paramemap.get("register_address"));
		fs_details.put("account_type", paramemap.get("account_type"));
		fs_details.put("account_name", paramemap.get("account_name"));
		fs_details.put("bank_account", paramemap.get("bank_account"));
		fs_details.put("open_bank", paramemap.get("open_bank"));
		// 担保人集合
		Map<String, String> dbr_map = new HashMap<String, String>();
		dbr_map.put("dbr_name", paramemap.get("dbr_name[]"));
		dbr_map.put("dbr_card", paramemap.get("dbr_card[]"));
		dbr_map.put("dbr_tel", paramemap.get("dbr_tel[]"));
		net.sf.json.JSONObject jsonObject1 = jsonutil.toJSONObject(dbr_map);
		fs_details.put("dbr_map", jsonObject1.toString());
		// 担保人配偶集合
		Map<String, String> dbrpo_map = new HashMap<String, String>();
		dbrpo_map.put("dbrpo_name", paramemap.get("dbrpo_name[]"));
		dbrpo_map.put("dbrpo_card", paramemap.get("dbrpo_card[]"));
		dbrpo_map.put("dbrpo_tel", paramemap.get("dbrpo_tel[]"));
		net.sf.json.JSONObject jsonObject2 = jsonutil.toJSONObject(dbrpo_map);
		fs_details.put("dbrpo_map", jsonObject2.toString());
		fs_details.put("yw_lxr", paramemap.get("yw_lxr"));
		fs_details.put("yw_tel", paramemap.get("yw_tel"));
		fs_details.put("yw_email", paramemap.get("yw_email"));
		fs_details.put("yw_fgdqjl", paramemap.get("yw_fgdqjl"));
		fs_details.put("showtag", paramemap.get("showtag"));
		// fs_details.put("systemtag",);
		// fs_details.put("code_pre",);
		// fs_details.put("name_py",);
		fs_details.put("money_tag", paramemap.get("money_tag"));
		fs_details.put("money_num", paramemap.get("money_num"));
		fs_details.put("money_type", paramemap.get("money_type"));
		fs_details.put("money_bz", paramemap.get("money_bz"));
		fs_details.put("zy_bank", paramemap.get("zy_bank"));
		fs_details.put("zy_province", paramemap.get("zy_province"));
		fs_details.put("zy_city", paramemap.get("zy_city"));
		fs_details.put("hz_type", paramemap.get("hz_type"));
		// System.out.println("ywhz_type:"+paramemap.get("ywhz_type"));
		fs_details.put("ywhz_type", paramemap.get("ywhz_type"));
		fs_details.put("dlspj", paramemap.get("dlspj"));
		if (paramemap.get("new_grfx_price") != null
				&& !paramemap.get("new_grfx_price").equals("")) {
			fs_details.put("new_grfx_price", paramemap.get("new_grfx_price"));
		}
		if (paramemap.get("new_carpg_price") != null
				&& !paramemap.get("new_carpg_price").equals("")) {
			fs_details.put("new_carpg_price", paramemap.get("new_carpg_price"));
		}
		if (paramemap.get("new_cardk_price") != null
				&& !paramemap.get("new_cardk_price").equals("")) {
			fs_details.put("new_cardk_price", paramemap.get("new_cardk_price"));
		}
		if (paramemap.get("new_gps_price") != null
				&& !paramemap.get("new_gps_price").equals("")) {
			fs_details.put("new_gps_price", paramemap.get("new_gps_price"));
		}
		if (paramemap.get("new_qt_price") != null
				&& !paramemap.get("new_qt_price").equals("")) {
			fs_details.put("new_qt_price", paramemap.get("new_qt_price"));
		}
		if (paramemap.get("old_grfx_price") != null
				&& !paramemap.get("old_grfx_price").equals("")) {
			fs_details.put("old_grfx_price", paramemap.get("old_grfx_price"));
		}
		if (paramemap.get("old_carpg_price") != null
				&& !paramemap.get("old_carpg_price").equals("")) {
			fs_details.put("old_carpg_price", paramemap.get("old_carpg_price"));
		}
		if (paramemap.get("old_cardk_price") != null
				&& !paramemap.get("old_cardk_price").equals("")) {
			fs_details.put("old_cardk_price", paramemap.get("old_cardk_price"));
		}
		if (paramemap.get("old_gps_price") != null
				&& !paramemap.get("old_gps_price").equals("")) {
			fs_details.put("old_gps_price", paramemap.get("old_gps_price"));
		}
		if (paramemap.get("old_qt_price") != null
				&& !paramemap.get("old_qt_price").equals("")) {
			fs_details.put("old_qt_price", paramemap.get("old_qt_price"));
		}

		// 数组
		fs_details.put("jc_bzj", paramemap.get("jc_bzj[]"));
		fs_details.put("jc_bzjdate", paramemap.get("jc_bzjdate[]"));
		fs_details.put("jc_bzjbl", paramemap.get("jc_bzjbl"));
		fs_details.put("sx_price", paramemap.get("sx_price"));
		fs_details.put("sx_yyprice", paramemap.get("sx_yyprice"));
		fs_details.put("sx_syprice", paramemap.get("sx_syprice"));
		fs_details.put("jc_jsfl", paramemap.get("jc_jsfl"));
		fs_details.put("yw_nzjfl", paramemap.get("yw_nzjfl"));
		fs_details.put("sc_maxprice", paramemap.get("sc_maxprice"));
		fs_details.put("zzxx_code", paramemap.get("zzxx_code"));
		fs_details.put("jcbzxth", paramemap.get("jcbzxth"));
		fs_details.put("jcbzjth_price", paramemap.get("jcbzjth_price"));
		fs_details.put("jcbzjth_date", paramemap.get("jcbzjth_date"));
		fs_details.put("fs_id", pagedate.get("id"));
		fs_detailsService.save(fs_details);
		// 充值扣款
		if (paramemap.get("addmoney") != null
				&& !paramemap.get("addmoney").equals("")) {
			moneyfs moneyfs = new moneyfs();
			moneyfs_1 moneyfs_1 = new moneyfs_1();
			moneyfs_1 moneyfs_2 = new moneyfs_1();

			Float amount = Float.valueOf(paramemap.get("addmoney"));
			moneyfs.setAmount(amount);
			moneyfs.setBintype(Integer.parseInt(paramemap.get("bintype")));
			moneyfs.setDt_add(creditutil.time());
			moneyfs.setDt_edit(creditutil.time());
			moneyfs.setFctype(Integer.parseInt(paramemap.get("fctype")));
			moneyfs.setFsid(Integer.parseInt(paramemap.get("id")));
			moneyfs.setGemsid(0);
			moneyfs.setMid(Integer.parseInt(pData.get("id").toString()));
			moneyfs.setMid_add(Integer.parseInt(pData.get("id").toString()));
			moneyfs.setMid_edit(Integer.parseInt(pData.get("id").toString()));
			moneyfs.setOrderid(0);
			moneyfs.setOtherid(0);
			if (paramemap.get("czremark") != null
					&& !paramemap.get("czremark").equals("")) {
				moneyfs.setRemark(paramemap.get("czremark"));
				moneyfs_1.setRemark(paramemap.get("czremark"));

			} else {
				switch (paramemap.get("fctype")) {
				case "3":
					moneyfs.setRemark("后台-退款");
					moneyfs_1.setRemark("后台-退款");
					break;
				case "4":
					moneyfs.setRemark("后台-违规扣款");
					moneyfs_1.setRemark("后台-违规扣款");
					break;
				default:
					moneyfs.setRemark("后台充值");
					moneyfs_1.setRemark("后台充值");
					break;
				}
			}
			moneyfs.setStatus(1);
			moneyfs.setType(1);

			moneyfs_1.setMid(Integer.parseInt(pData.get("id").toString()));
			moneyfs_1.setFsid(Integer.parseInt(paramemap.get("id")));
			moneyfs_1.setGemsid(0);
			moneyfs_1.setAmount(amount);
			moneyfs_1.setDt_add(creditutil.time());
			moneyfs_1.setDt_edit(creditutil.time());
			moneyfs_1.setStatus(1);
			moneyfs_1.setBintype(Integer.parseInt(paramemap.get("bintype")));
			moneyfs_1.setFctype(Integer.parseInt(paramemap.get("fctype")));
			moneyfsService.addmoneyfs(moneyfs);
			moneyfs_1.setMoneyid(moneyfs.getId());
			moneyfs_1Service.addmoneyfs_1(moneyfs_1);
			if (paramemap.get("fctype").equals("3")
					|| paramemap.get("fctype").equals("4")) {
				moneyfs_2.setMid(Integer.parseInt(pData.get("id").toString()));
				moneyfs_2.setFsid(Integer.parseInt(paramemap.get("id")));
				moneyfs_2.setGemsid(0);
				moneyfs_2.setAmount(amount);
				moneyfs_2.setDt_add(creditutil.time());
				moneyfs_2.setDt_edit(creditutil.time());
				moneyfs_2.setMoneyid(moneyfs.getId());
				moneyfs_2.setStatus(1);
				moneyfs_2.setBc_type(0);
				moneyfs_2.setOrderid(0);
				moneyfs_2.setType(0);
				if (paramemap.get("czremark") != null
						&& !paramemap.get("czremark").equals("")) {
					moneyfs_2.setRemark(paramemap.get("czremark"));
				} else {
					switch (paramemap.get("fctype")) {
					case "3":
						moneyfs_2.setRemark("后台-退款");
						break;
					case "4":
						moneyfs_2.setRemark("后台-违规扣款");
						break;
					}
				}
				moneyfs_2
						.setBintype(Integer.parseInt(paramemap.get("bintype")));
				moneyfs_1Service.addmoneyfs_2(moneyfs_2);
			}

		}
		request.setAttribute("mid_add", paramemap.get("userid"));
		request.setAttribute("dn", paramemap.get("dn"));
		request.setAttribute("qn", paramemap.get("qn"));
		request.setAttribute("type", paramemap.get("type"));
		return new ModelAndView("redirect:user_list.do?type="
				+ paramemap.get("type") + "&dn=" + paramemap.get("dn") + "&qn="
				+ paramemap.get("qn") + "&cn=4001");
	}

	// 修改公司
	@Transactional
	@RequestMapping(value = "erp/assess_fs_update.do", produces = "text/html;charset=UTF-8")
	public ModelAndView assess_fs_update(
			// assess_fs assess_fs,
			@RequestParam("fileimg") MultipartFile fileimg,
			HttpServletRequest request) {
		Map<String, String> paramemap = Tools.getpostmap(request);
		// Enumeration<?> enu=request.getParameterNames();
		// while(enu.hasMoreElements()){
		// String paraName=(String)enu.nextElement();
		// //System.out.println(paraName+": "+request.getParameter(paraName));
		// paramemap.put(paraName, request.getParameter(paraName));
		// }
		System.out.println("获取参数map：" + paramemap);
		PageData pData = (PageData) request.getSession().getAttribute("pd");
		PageData fs_details = new PageData();
		PageData pagedate = new PageData();
		System.err.println("purview_map_kjs:"
				+ paramemap.get("purview_map_kjs"));
		System.err.println("purview_map:" + paramemap.get("purview_map"));
		pagedate.put("dn", "assess_fs");
		pagedate.put("purview_map_kjs", paramemap.get("purview_map_kjs"));
		pagedate.put("purview_map", paramemap.get("purview_map"));
		String fileName = "";
		String filrurl = "";
		Date date = new Date();
		String filePath = "/KCDIMG/assess/upload/"
				+ new SimpleDateFormat("yyyy/MM/dd/").format(date);
		if (fileimg != null && !fileimg.equals("")) {
			try {
				fileName = fileimg.getOriginalFilename();
				fileName = md5util.encode(fileName) + "."
						+ md5util.getExtensionName(fileName);
				filePath = "/KCDIMG/assess/upload/"
						+ new SimpleDateFormat("yyyy/MM/dd/").format(date);
				System.out.println("图片大小：" + fileimg.getSize());
				if (fileimg.getSize() > 0) {
					md5util.uploadFile(fileimg.getBytes(), filePath, fileName);
					filrurl = "assess/upload/"
							+ new SimpleDateFormat("yyyy/MM/dd/").format(date)
							+ fileName;
					System.out.println("存放路径：" + filePath + fileName);
					System.out.println("数据库路径：" + filrurl);
					pagedate.put("oemimgurl", filrurl);
				} else {
					pagedate.put("oemimgurl", "");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			pagedate.put("oemimgurl", "");
		}
		pagedate.put("id", paramemap.get("id"));
		pagedate.put("name", paramemap.get("name"));
		pagedate.put("name_qy", paramemap.get("name_qy"));
		pagedate.put("showtag", paramemap.get("showtag"));
		if (paramemap.get("company_province") != null
				&& !paramemap.get("company_province").equals("")) {
			pagedate.put("state_id", paramemap.get("company_province"));
		} else {
			pagedate.put("state_id", 0);
		}
		if (paramemap.get("company_city") != null
				&& !paramemap.get("company_city").equals("")) {
			pagedate.put("city_id", paramemap.get("company_city"));
		} else {
			pagedate.put("city_id", 0);
		}

		if (paramemap.get("company_section") != null
				&& !paramemap.get("company_section").equals("")) {
			pagedate.put("zone_id", paramemap.get("company_section"));
		} else {
			pagedate.put("zone_id", 0);
		}
		pagedate.put("address", paramemap.get("company_address"));
		pagedate.put("code_pre", paramemap.get("code_pre"));
		pagedate.put("namepy", paramemap.get("namepy"));
		pagedate.put("update_time", getSecondTimestamp(new Date()));
		pagedate.put("dt_edit", new Date());
		String dbr_names = paramemap.get("dbr_name[]");
		System.out.println("数组字符串：" + dbr_names);
		if (paramemap.get("icbc_erp_tag") != null
				&& !paramemap.get("icbc_erp_tag").equals("")
				&& paramemap.get("icbc_erp_tag").equals("1")) {
			pagedate.put("icbc_erp_tag", 1);
		}
		System.out.println("******************" + pData.get("icbc_erp_fsid"));
		pagedate.put("mid_edit", paramemap.get("userid"));
		erp_userrootService.updatebyid(pagedate);

		fs_details.put("dn", "assess_fs_details");
		fs_details.put("xt_name", paramemap.get("xt_name"));
		fs_details.put("mid_edit", paramemap.get("userid"));
		fs_details.put("dt_edit", new Date());
		fs_details.put("company_jc", paramemap.get("name"));
		fs_details.put("qy_company", paramemap.get("name_qy"));
		fs_details.put("contract_code", paramemap.get("contract_code"));
		fs_details.put("hz_date1", paramemap.get("hz_date1"));
		fs_details.put("hz_date2", paramemap.get("hz_date2"));
		fs_details.put("fr_name", paramemap.get("fr_name"));
		fs_details.put("fr_tel", paramemap.get("fr_tel"));
		fs_details.put("fr_card", paramemap.get("fr_card"));
		fs_details.put("sjkgr", paramemap.get("sjkgr"));
		fs_details.put("sjkgr_name", paramemap.get("sjkgr_name"));
		fs_details.put("sjkgr_card", paramemap.get("sjkgr_card"));
		fs_details.put("sjkgr_tel", paramemap.get("sjkgr_tel"));
		fs_details.put("company_date", paramemap.get("company_date"));
		fs_details.put("register_capital", paramemap.get("register_capital"));
		fs_details.put("sj_capital", paramemap.get("sj_capital"));
		fs_details.put("company_num", paramemap.get("company_num"));
		fs_details.put("company_province", paramemap.get("company_province"));
		fs_details.put("company_city", paramemap.get("company_city"));
		fs_details.put("company_section", paramemap.get("company_section"));
		fs_details.put("company_address", paramemap.get("company_address"));
		fs_details.put("register_province", paramemap.get("register_province"));
		fs_details.put("register_city", paramemap.get("register_city"));
		fs_details.put("register_section", paramemap.get("register_section"));
		fs_details.put("register_address", paramemap.get("register_address"));
		fs_details.put("account_type", paramemap.get("account_type"));
		fs_details.put("account_name", paramemap.get("account_name"));
		fs_details.put("bank_account", paramemap.get("bank_account"));
		fs_details.put("open_bank", paramemap.get("open_bank"));
		// 担保人集合
		Map<String, String> dbr_map = new HashMap<String, String>();
		dbr_map.put("dbr_name", paramemap.get("dbr_name[]"));
		dbr_map.put("dbr_card", paramemap.get("dbr_card[]"));
		dbr_map.put("dbr_tel", paramemap.get("dbr_tel[]"));
		net.sf.json.JSONObject jsonObject1 = jsonutil.toJSONObject(dbr_map);
		fs_details.put("dbr_map", jsonObject1.toString());
		// 担保人配偶集合
		Map<String, String> dbrpo_map = new HashMap<String, String>();
		dbrpo_map.put("dbrpo_name", paramemap.get("dbrpo_name[]"));
		dbrpo_map.put("dbrpo_card", paramemap.get("dbrpo_card[]"));
		dbrpo_map.put("dbrpo_tel", paramemap.get("dbrpo_tel[]"));
		net.sf.json.JSONObject jsonObject2 = jsonutil.toJSONObject(dbrpo_map);
		fs_details.put("dbrpo_map", jsonObject2.toString());
		fs_details.put("yw_lxr", paramemap.get("yw_lxr"));
		fs_details.put("yw_tel", paramemap.get("yw_tel"));
		fs_details.put("yw_email", paramemap.get("yw_email"));
		fs_details.put("yw_fgdqjl", paramemap.get("yw_fgdqjl"));
		fs_details.put("showtag", paramemap.get("showtag"));
		// fs_details.put("systemtag",);
		// fs_details.put("code_pre",);
		// fs_details.put("name_py",);
		fs_details.put("money_tag", paramemap.get("money_tag"));
		fs_details.put("money_num", paramemap.get("money_num"));
		fs_details.put("money_type", paramemap.get("money_type"));
		fs_details.put("money_bz", paramemap.get("money_bz"));
		fs_details.put("zy_bank", paramemap.get("zy_bank"));
		fs_details.put("zy_province", paramemap.get("zy_province"));
		fs_details.put("zy_city", paramemap.get("zy_city"));
		fs_details.put("hz_type", paramemap.get("hz_type"));
		// System.out.println("ywhz_type:"+paramemap.get("ywhz_type"));
		fs_details.put("ywhz_type", paramemap.get("ywhz_type"));
		fs_details.put("dlspj", paramemap.get("dlspj"));
		if (paramemap.get("new_grfx_price") != null
				&& !paramemap.get("new_grfx_price").equals("")) {
			fs_details.put("new_grfx_price", paramemap.get("new_grfx_price"));
		}
		if (paramemap.get("new_carpg_price") != null
				&& !paramemap.get("new_carpg_price").equals("")) {
			fs_details.put("new_carpg_price", paramemap.get("new_carpg_price"));
		}
		if (paramemap.get("new_cardk_price") != null
				&& !paramemap.get("new_cardk_price").equals("")) {
			fs_details.put("new_cardk_price", paramemap.get("new_cardk_price"));
		}
		if (paramemap.get("new_gps_price") != null
				&& !paramemap.get("new_gps_price").equals("")) {
			fs_details.put("new_gps_price", paramemap.get("new_gps_price"));
		}
		if (paramemap.get("new_qt_price") != null
				&& !paramemap.get("new_qt_price").equals("")) {
			fs_details.put("new_qt_price", paramemap.get("new_qt_price"));
		}
		if (paramemap.get("old_grfx_price") != null
				&& !paramemap.get("old_grfx_price").equals("")) {
			fs_details.put("old_grfx_price", paramemap.get("old_grfx_price"));
		}
		if (paramemap.get("old_carpg_price") != null
				&& !paramemap.get("old_carpg_price").equals("")) {
			fs_details.put("old_carpg_price", paramemap.get("old_carpg_price"));
		}
		if (paramemap.get("old_cardk_price") != null
				&& !paramemap.get("old_cardk_price").equals("")) {
			fs_details.put("old_cardk_price", paramemap.get("old_cardk_price"));
		}
		if (paramemap.get("old_gps_price") != null
				&& !paramemap.get("old_gps_price").equals("")) {
			fs_details.put("old_gps_price", paramemap.get("old_gps_price"));
		}
		if (paramemap.get("old_qt_price") != null
				&& !paramemap.get("old_qt_price").equals("")) {
			fs_details.put("old_qt_price", paramemap.get("old_qt_price"));
		}

		// 数组
		fs_details.put("jc_bzj", paramemap.get("jc_bzj[]"));
		fs_details.put("jc_bzjdate", paramemap.get("jc_bzjdate[]"));
		fs_details.put("jc_bzjbl", paramemap.get("jc_bzjbl"));
		fs_details.put("sx_price", paramemap.get("sx_price"));
		fs_details.put("sx_yyprice", paramemap.get("sx_yyprice"));
		fs_details.put("sx_syprice", paramemap.get("sx_syprice"));
		fs_details.put("jc_jsfl", paramemap.get("jc_jsfl"));
		fs_details.put("yw_nzjfl", paramemap.get("yw_nzjfl"));
		fs_details.put("sc_maxprice", paramemap.get("sc_maxprice"));
		fs_details.put("zzxx_code", paramemap.get("zzxx_code"));
		fs_details.put("jcbzxth", paramemap.get("jcbzxth"));
		fs_details.put("jcbzjth_price", paramemap.get("jcbzjth_price"));
		fs_details.put("jcbzjth_date", paramemap.get("jcbzjth_date"));
		PageData pd_fd = new PageData();
		pd_fd.put("id", paramemap.get("fs_details_id"));
		pd_fd.put("dn", "assess_fs_details");
		PageData pd_fds = fs_detailsService.findbyid(pd_fd);
		System.out.println("验证是否有数据：" + pd_fds);
		if (pd_fds != null && !pd_fds.equals("")) {
			fs_details.put("id", paramemap.get("fs_details_id"));
			fs_detailsService.update(fs_details);
		} else {
			fs_details.put("mid_add", pData.get("id"));
			fs_details.put("dt_add", new Date());
			fs_details.put("fs_id", paramemap.get("id"));
			fs_detailsService.save(fs_details);
		}
		// 充值扣款
		if (paramemap.get("addmoney") != null
				&& !paramemap.get("addmoney").equals("")) {
			moneyfs moneyfs = new moneyfs();
			moneyfs_1 moneyfs_1 = new moneyfs_1();
			moneyfs_1 moneyfs_2 = new moneyfs_1();

			Float amount = Float.valueOf(paramemap.get("addmoney"));
			moneyfs.setAmount(amount);
			moneyfs.setBintype(Integer.parseInt(paramemap.get("bintype")));
			moneyfs.setDt_add(creditutil.time());
			moneyfs.setDt_edit(creditutil.time());
			moneyfs.setFctype(Integer.parseInt(paramemap.get("fctype")));
			moneyfs.setFsid(Integer.parseInt(paramemap.get("id")));
			moneyfs.setGemsid(0);
			moneyfs.setMid(Integer.parseInt(pData.get("id").toString()));
			moneyfs.setMid_add(Integer.parseInt(pData.get("id").toString()));
			moneyfs.setMid_edit(Integer.parseInt(pData.get("id").toString()));
			moneyfs.setOrderid(0);
			moneyfs.setOtherid(0);
			if (paramemap.get("czremark") != null
					&& !paramemap.get("czremark").equals("")) {
				moneyfs.setRemark(paramemap.get("czremark"));
				moneyfs_1.setRemark(paramemap.get("czremark"));

			} else {
				switch (paramemap.get("fctype")) {
				case "3":
					moneyfs.setRemark("后台-退款");
					moneyfs_1.setRemark("后台-退款");
					break;
				case "4":
					moneyfs.setRemark("后台-违规扣款");
					moneyfs_1.setRemark("后台-违规扣款");
					break;
				default:
					moneyfs.setRemark("后台充值");
					moneyfs_1.setRemark("后台充值");
					break;
				}
			}
			moneyfs.setStatus(1);
			moneyfs.setType(1);

			moneyfs_1.setMid(Integer.parseInt(pData.get("id").toString()));
			moneyfs_1.setFsid(Integer.parseInt(paramemap.get("id")));
			moneyfs_1.setGemsid(0);
			moneyfs_1.setAmount(amount);
			moneyfs_1.setDt_add(creditutil.time());
			moneyfs_1.setDt_edit(creditutil.time());
			moneyfs_1.setStatus(1);
			moneyfs_1.setBintype(Integer.parseInt(paramemap.get("bintype")));
			moneyfs_1.setFctype(Integer.parseInt(paramemap.get("fctype")));
			moneyfsService.addmoneyfs(moneyfs);
			moneyfs_1.setMoneyid(moneyfs.getId());
			moneyfs_1Service.addmoneyfs_1(moneyfs_1);
			if (paramemap.get("fctype").equals("3")
					|| paramemap.get("fctype").equals("4")) {
				moneyfs_2.setMid(Integer.parseInt(pData.get("id").toString()));
				moneyfs_2.setFsid(Integer.parseInt(paramemap.get("id")));
				moneyfs_2.setGemsid(0);
				moneyfs_2.setAmount(amount);
				moneyfs_2.setDt_add(creditutil.time());
				moneyfs_2.setDt_edit(creditutil.time());
				moneyfs_2.setMoneyid(moneyfs.getId());
				moneyfs_2.setStatus(1);
				moneyfs_2.setBc_type(0);
				moneyfs_2.setOrderid(0);
				moneyfs_2.setType(0);
				if (paramemap.get("czremark") != null
						&& !paramemap.get("czremark").equals("")) {
					moneyfs_2.setRemark(paramemap.get("czremark"));
				} else {
					switch (paramemap.get("fctype")) {
					case "3":
						moneyfs_2.setRemark("后台-退款");
						break;
					case "4":
						moneyfs_2.setRemark("后台-违规扣款");
						break;
					}
				}
				moneyfs_2
						.setBintype(Integer.parseInt(paramemap.get("bintype")));
				moneyfs_1Service.addmoneyfs_2(moneyfs_2);
			}

		}

		request.setAttribute("mid_add", paramemap.get("userid"));
		request.setAttribute("dn", paramemap.get("dn"));
		request.setAttribute("qn", paramemap.get("qn"));
		request.setAttribute("type", paramemap.get("type"));
		return new ModelAndView("redirect:user_list.do?type="
				+ paramemap.get("type") + "&dn=" + paramemap.get("dn") + "&qn="
				+ paramemap.get("qn") + "&cn=4001");
	}

	// 用户遍历
	@RequestMapping(value = "erp/user_list.do", produces = "text/html;charset=UTF-8")
	public String user_list(Integer pagesize, Integer pagenow, String dn,
			String qn, String cn, String type, String fsid, Integer qx_type,
			Integer assess_fs_id, String assess_fs_msg, String assess_ssgs,
			String assess_ssjg, Integer assess_cp, String date1, String date2,
			HttpServletRequest request) throws UnsupportedEncodingException {
		System.out.println("************操作:" + dn);
		PageData pData = (PageData) request.getSession().getAttribute("pd");
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
		List<PageData> newpdList = new ArrayList<>();
		PageData pd = new PageData();
		PageData pd1 = new PageData();
		pd.put("dn", dn);
		pd.put("cn", cn);
		pd1.put("dn", dn);
		pd1.put("cn", cn);
		System.out.println("cn-----" + pd.get("cn"));
		if (fsid != null && !fsid.equals("")) {
			pd.put("fsid", fsid);
			pd1.put("fsid", fsid);
		} else {
			pd.put("fsid", pData.get("icbc_erp_fsid"));
			pd1.put("fsid", pData.get("icbc_erp_fsid"));
		}
		if (assess_fs_msg != null && !assess_fs_msg.equals("")) {
			assess_fs_msg = new String(assess_fs_msg.getBytes("ISO-8859-1"),
					"UTF-8");
		}
		if (assess_ssgs != null && !assess_ssgs.equals("")) {
			assess_ssgs = new String(assess_ssgs.getBytes("ISO-8859-1"),
					"UTF-8");
		}
		if (assess_ssjg != null && !assess_ssjg.equals("")) {
			assess_ssjg = new String(assess_ssjg.getBytes("ISO-8859-1"),
					"UTF-8");
		}
		pd.put("up_id", pData.get("icbc_erp_fsid"));
		pd1.put("up_id", pData.get("icbc_erp_fsid"));
		pd.put("assess_fs_id", assess_fs_id);
		pd.put("qx_type", qx_type);
		pd.put("assess_fs_msg", assess_fs_msg);
		pd.put("assess_ssgs", assess_ssgs);
		pd.put("assess_ssjg", assess_ssjg);
		pd.put("assess_cp", assess_cp);
		pd.put("date1", date1);
		pd.put("date2", date2);
		System.out.println("权限类型：" + qx_type);
		List<PageData> pdList = erp_userrootService.findtolist(pd);

		List<PageData> pdList1 = erp_userrootService.findtolist(pd1);
		System.out.println(pdList.size());
		newpdList = limitutil.fy(pdList, ps, pn);
		int q = pdList.size() % ps;
		int totalpage = 0;// 总页数
		if (q == 0) {
			totalpage = pdList.size() / ps;
		} else {
			totalpage = pdList.size() / ps + 1;
		}
		System.out.println("搜索：" + assess_fs_msg);
		List<PageData> banklist = icbc_banklistService.geticbc_banklist();
		request.setAttribute("banklist", banklist);
		request.setAttribute("qx_type", qx_type);
		request.setAttribute("assess_fs_id", assess_fs_id);
		request.setAttribute("assess_fs_msg", assess_fs_msg);
		request.setAttribute("assess_ssgs", assess_ssgs);
		request.setAttribute("assess_ssjg", assess_ssjg);
		request.setAttribute("assess_cp", assess_cp);
		request.setAttribute("date1", date1);
		request.setAttribute("date2", date2);
		request.setAttribute("pdList1", pdList1);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("totalsize", pdList.size());
		request.setAttribute("newpdList", newpdList);
		request.setAttribute("pagesize", ps);
		request.setAttribute("pagenow", pn);
		request.setAttribute("dn", dn);
		request.setAttribute("cn", cn);
		request.setAttribute("qn", qn);
		request.setAttribute("type", type);
		request.setAttribute("fsid", fsid);
		return "kjs_icbc/index";
	}

	// 首页
	@RequestMapping(value = "erp/index.do", produces = "text/html;charset=UTF-8")
	public ModelAndView index(String type, String dn, String qn,
			String pagesize, String pagenow, Integer id, String fsid,
			assess_fs assess_fs, String cn, HttpServletRequest request)
			throws UnsupportedEncodingException {
		PageData pData = (PageData) request.getSession().getAttribute("pd");
		if (qn == null || qn.equals("")) {
			qn = "";
		}
		if (type == null || type.equals("")) {
			type = "glzx";
		}
		if (dn == null || dn.equals("")) {
			dn = "glzx";
		}
		if (cn == null || cn.equals("")) {
			cn = "0";
		}
		int ps = 0;
		int pn = 0;
		if (pagesize != null && !pagesize.equals("")) {
			ps = Integer.parseInt(pagesize);
		} else {
			ps = 10;
		}
		if (pagenow != null && !pagenow.equals("")) {
			pn = Integer.parseInt(pagenow);
		} else {
			pn = 1;
		}
		List<PageData> banklist = icbc_banklistService.geticbc_banklist();
		request.setAttribute("banklist", banklist);
		request.setAttribute("type", type);
		request.setAttribute("dn", dn);
		request.setAttribute("qn", qn);
		request.setAttribute("pagesize", ps);
		request.setAttribute("pagenow", pn);
		if (type.equals("khhkgl")) {
			return new ModelAndView("kjs_icbc/index");
		} else if (type.equals("cldy_sxx")) {
			return new ModelAndView("kjs_icbc/index");
		}
		/* 统计数据 */
		Management.management(request);
		if (qn.equals("list")) {
			if (fsid != null && !fsid.equals("")) {
				request.setAttribute("fsid", fsid);
				return new ModelAndView("redirect:user_list.do?type=" + type
						+ "&dn=" + dn + "&qn=" + qn + "&fsid=" + fsid
						+ "&pagesize=" + ps + "&pagenow=" + pn);
			} else {
				return new ModelAndView("redirect:user_list.do?type=" + type
						+ "&dn=" + dn + "&qn=" + qn + "&pagesize=" + ps
						+ "&pagenow=" + pn);
			}

		} else if (qn.equals("form")) {
			request.setAttribute("cn", cn);
			PageData pd = new PageData();
			pd.put("dn", "assess_fs");
			pd.put("fsid", pData.get("icbc_erp_fsid"));
			pd.put("up_id", pData.get("icbc_erp_fsid"));
			List<PageData> pageDatas = erp_userrootService.findtolist(pd);
			request.setAttribute("pageDatas", pageDatas);

			PageData pd2 = new PageData();
			pd2.put("dn", "icbc_erp_admin_agp");
			pd2.put("fsid", pData.get("icbc_erp_fsid"));
			pd2.put("showtag", 1);
			List<PageData> pageDatas2 = erp_userrootService.findtolist(pd2);
			request.setAttribute("pageDatas2", pageDatas2);

			if (id != null && !id.equals("")) {
				return new ModelAndView("redirect:user_form.do?type=" + type
						+ "&dn=" + dn + "&qn=" + qn + "&id=" + id + "&cn=" + cn);
			} else {

				return new ModelAndView("kjs_icbc/index");
			}
		} else if (qn.equals("cslist")) {
			request.setAttribute("qn", "list");
			return new ModelAndView("kjs_icbc/index");
		}
		// else if(qn.equals("add")){
		// return new ModelAndView("redirect:"+dn+"_"+qn+".do?name="
		// +assess_fs.getName()
		// +"&name_qy="+assess_fs.getName_qy()
		// +"&state_id="+assess_fs.getState_id()
		// +"&city_id="+assess_fs.getCity_id()
		// +"&address="+assess_fs.getName_qy()
		// +"&code_pre="+assess_fs.getCode_pre()
		// +"&namepy="+assess_fs.getNamepy()
		// +"&dn="+assess_fs.getDn()
		// +"&qn=list"
		// );
		// }
		else {
			return new ModelAndView("kjs_icbc/index");
		}
	}

	// 添加权限组
	@RequestMapping(value = "erp/icbc_erp_admin_agp_add.do", produces = "text/html;charset=UTF-8")
	public ModelAndView icbc_erp_admin_agp_add(zhqx_modal zhqx_modal,
			HttpServletRequest request) {
		PageData pData = (PageData) request.getSession().getAttribute("pd");
		/*
		 * String name= request.getParameter("name"); String glzx=
		 * request.getParameter("glzx"); String zhgl=
		 * request.getParameter("zhgl"); String gsgl=
		 * request.getParameter("zhgl/gsgl"); String tjgs=
		 * request.getParameter("zhgl/tjgs"); String rygl=
		 * request.getParameter("zhgl/rygl"); String tjry=
		 * request.getParameter("zhgl/tjry"); String zhqx=
		 * request.getParameter("zhgl/zhqx"); String wlghd=
		 * request.getParameter("wlghd"); String zx=
		 * request.getParameter("wlghd/zx"); String qcpg=
		 * request.getParameter("wlghd/qcpg"); String kk=
		 * request.getParameter("wlghd/kk"); String ssmq=
		 * request.getParameter("wlghd/ssmq"); String qcdk=
		 * request.getParameter("wlghd/qcdk");
		 */
		/*
		 * String gpurview_map=glzx+"," +zhgl+"," +gsgl+"," +gsgl+"," +tjgs+","
		 * +rygl+"," +tjry+"," +zhqx+"," +wlghd+"," +zx+"," +qcpg+"," +kk+","
		 * +ssmq+"," +qcdk+",";
		 */
		/* gpurview_map=gpurview_map.replace("null,",""); */
		System.out.println("***********" + zhqx_modal.getGpurview_map());
		PageData pd = new PageData();
		pd.put("dn", zhqx_modal.getDn());
		pd.put("name", zhqx_modal.getName());
		pd.put("purview_map", zhqx_modal.getGpurview_map());
		pd.put("showtag", 1);
		pd.put("mid_edit", pData.get("id"));
		pd.put("dt_edit", new Date());
		pd.put("qx_type", zhqx_modal.getQx_type());
		pd.put("modal_tag", zhqx_modal.getModal_tag());
		pd.put("gems_fs_id", pData.get("icbc_erp_fsid"));
		if (zhqx_modal.getCn().equals("1")) {
			pd.put("mid_add", pData.get("id"));
			pd.put("dt_add", new Date());
			erp_userrootService.save(pd);
		}
		if (zhqx_modal.getCn().equals("3")) {
			pd.put("id", zhqx_modal.getId());
			erp_userrootService.updatebyid(pd);
		}
		request.setAttribute("dn", zhqx_modal.getDn());
		request.setAttribute("qn", zhqx_modal.getQn());
		request.setAttribute("type", zhqx_modal.getType());
		return new ModelAndView("redirect:user_list.do?type="
				+ zhqx_modal.getType() + "&dn=" + zhqx_modal.getDn() + "&qn="
				+ zhqx_modal.getQn() + "&pagesize=" + 10 + "&pagenow=" + 1);
	}

	// 添加admin
	@RequestMapping(value = "erp/assess_admin_add.do", produces = "text/html;charset=UTF-8")
	public String assess_admin_add(Integer fsid, String name, String mobile,
			String username, String password, Integer cp, Integer upac_id,
			String idcard, Integer aid_ssm, String dn, String qn, String type,
			HttpServletRequest request) {
		PageData pd = new PageData();
		pd.put("username", username);
		pd.put("userpass", MD5.sign(MD5.sign(password, "UTF-8"), "UTF-8"));
		pd.put("name", name);
		pd.put("tel", mobile);
		pd.put("agpid", 0);
		pd.put("bc_title", "");
		pd.put("email", "");
		pd.put("icbc_erp_tag", 1);
		pd.put("dt_add", new Date());
		pd.put("dt_edit", new Date());
		pd.put("showtag", 1);
		pd.put("fs_type", 2);
		pd.put("mid_add", 0);
		pd.put("mid_edit", 0);
		pd.put("dn", "assess_admin");
		// pd.put("deltag","");
		// pd.put("isadmin","");
		// pd.put("issupplier","");
		// pd.put("sex","");
		// pd.put("logindt","");
		// pd.put("logincode","");
		// pd.put("limit_list","");
		// pd.put("imgurl","");
		// pd.put("stateid","");
		// pd.put("cityid","");
		// pd.put("eeid","");
		// pd.put("note","");
		// pd.put("wx_openid","");
		pd.put("gemsid", 0);
		// pd.put("bc_title","");
		// pd.put("jgid","");
		pd.put("loginip", 0);
		// pd.put("ssm_id","");
		erp_userrootService.save(pd);
		return "kjs_icbc/index";
	}

}
