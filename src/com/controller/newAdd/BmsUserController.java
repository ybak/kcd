package com.controller.newAdd;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.apache.jasper.tagplugins.jstl.core.Out;
import org.json.JSONObject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.model.newAdd.BmsUser;
import com.service.newAdd.BmsUserService;
import com.util.creditutil;
import com.util.jsonutil;
import com.util.newAdd.jsonToOther;
@Controller
public class BmsUserController {
	@Autowired
	private BmsUserService bmsUserService;
	HttpServletRequest request;
	HttpServletResponse response;
	
	// 修改用户级别（权限）
	@RequestMapping(value="/updateUserDeptno.do",produces="text/html;charset=UTF-8")
	public String updateUserDeptno(HttpServletRequest request,HttpServletResponse response,
			int deptno,
			int uid){
		System.err.println(deptno+"--uid:"+uid);
		bmsUserService.updateUserDeptno(deptno, uid); // 通过 uid 唯一主键，修改用户deptno(权限编号)
		//return "wangye0119/administrator";
		return selectAllUser(request,response);
	}
	
	//模糊查询
	@RequestMapping(value="/selectUserLike.do",produces="text/html;charset=UTF-8")
	public String selectUserLike(
			HttpServletRequest request
			,HttpServletResponse response
			){
		String uname = "";
		try {
			uname = new String(request.getParameter("uname").getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("模糊查询："+uname+"-----");
		ArrayList list = bmsUserService.selectUserLike("%"+uname+"%");
		int userSum = list.size(); // 被查询对象的总数
		request.setAttribute("userSum", userSum);   // 被查询对象的总数
		request.setAttribute("list", list); // 被查询对象的全部信息
		return "wangye0119/administrator";
	}
	
	//删除用户
	@RequestMapping(value="/deleteUserByUid.do",produces="text/html;charset=UTF-8")
	public String deleteUserByUid(HttpServletRequest request,HttpServletResponse response,int uid){
		bmsUserService.deleteUserByUid(uid); // 通过 uid 唯一主键，删除注定一个用户
		return selectAllUser(request, response);
	}
	
	//修改用户  是否可用
	@RequestMapping(value="/updateUserStatus.do",produces="text/html;charset=UTF-8")
	public String updateUserStatus(HttpServletRequest request,HttpServletResponse response,
			int status,
			int uid){
		if(status == 1){  // 1可用      0不可用         如果用户可用，则修改为不可用  
			int a = bmsUserService.updateUserStatus(0,uid);
		}else if(status == 0){
			bmsUserService.updateUserStatus(1,uid);
		}
		return selectAllUser(request, response);
	}

	//添加用户时查询是否重复
	@RequestMapping(value="/addUserBySelectRepeat.do",produces="text/html;charset=UTF-8")
	public void addUserBySelectRepeat(HttpServletRequest request,HttpServletResponse response){
		String username = request.getParameter("username");
		BmsUser addUser = bmsUserService.addUserBySelect(username);
		response.setCharacterEncoding("UTF-8");
		if(addUser != null){
			try { //该账号已存在，不可再注册
				response.getWriter().println(1);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{ // 该账号可以注册!
			try {
				response.getWriter().println(0);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//添加系统用户							 
	@RequestMapping(value="/addBMSUser.do",method=RequestMethod.POST,produces="multipart/form-data;charset=UTF-8")
	public String addBMSUser(HttpServletRequest request,HttpServletResponse response,
			String userName,
			String newpassword2,
			String trueName,
			String userTel,
			int adminRole
			){
//		try {
//			request.setCharacterEncoding("UTF-8");
//			response.setCharacterEncoding("UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
		BmsUser bu = new BmsUser();
		bu.setUsername(userName);
		bu.setPassword(newpassword2);
		bu.setUname(trueName);
		bu.setRegTime(creditutil.time().toString());
		bu.setUpdateTime(creditutil.time().toString());
		bu.setUserPhone(userTel);
		bu.setDeptno(adminRole);
		bu.setStatus(1);  // 1启用    0未启用
		int a = bmsUserService.addBMSUser(bu);
		if(a>0){
			System.out.println("添加系统用户成功!");
		}else{
			System.out.println("添加系统用户失败!");
		}
		return selectAllUser(request,response);
	}
	
	//三级分别查询
	@RequestMapping(value="/selectOtherUser.do",produces="text/html;charset=UTF-8")
	public String selectOtherUser(HttpServletRequest request,HttpServletResponse response,int deptno){
		ArrayList listOtherUser = bmsUserService.selectOtherUser(deptno);
		ArrayList listt = bmsUserService.selectAllUser();
		int userSum = listt.size(); // 用户总数
		int userSupervisorCounts = 0;  // 主管总数
		int userManagerCounts = 0; // 业务经理总数
		int userSalesmanCounts = 0;    // 业务员总数
		List<Map<String,Object>> list = jsonToOther.stringToListMap(jsonutil.toJSONString(listt));
		for(int i=0;i<list.size();i++){
			Map map = list.get(i);
			double deptnoo = (double) map.get("deptno");
			if(deptnoo == 10){
				userSupervisorCounts++;
				userSupervisorCounts = userSupervisorCounts;
			}else if(deptnoo == 20){
				userManagerCounts++;
				userManagerCounts = userManagerCounts;
			}else if(deptnoo == 30){
				userSalesmanCounts++;
				userSalesmanCounts = userSalesmanCounts;
			}
		}
		request.setAttribute("userSum", userSum);
		request.setAttribute("userSupervisorCounts", userSupervisorCounts);
		request.setAttribute("userManagerCounts", userManagerCounts);
		request.setAttribute("userSalesmanCounts", userSalesmanCounts);
		request.setAttribute("list", listOtherUser); // 部分用户全部信息
		return "wangye0119/administrator";
	}
	
	//查询本系统所有的用户-以及-不同级别用户的个数
	@RequestMapping(value="/selectAllUser.do",produces="text/html;charset=UTF-8")
	public String selectAllUser(HttpServletRequest request,HttpServletResponse response){
		ArrayList listUser = bmsUserService.selectAllUser();
		int userSum = listUser.size(); // 用户总数
		int userSupervisorCounts = 0;  // 主管总数
		int userManagerCounts = 0; // 业务经理总数
		int userSalesmanCounts = 0;    // 业务员总数
//		System.err.println(listUser); // [{uid=1, username=18637815946, ucid=1, s
//		System.err.println(jsonutil.toJSONString(listUser)); // [{"uid":1,"username":"18637815946","ucid":1,
//		System.err.println(jsonToOther.stringToListMap(jsonutil.toJSONString(listUser))); //[{uid=1.0, username=18637815946, ucid=1.0, status=1.0, upid=1.0
		List<Map<String,Object>> list = jsonToOther.stringToListMap(jsonutil.toJSONString(listUser));
		for(int i=0;i<list.size();i++){
			Map map = list.get(i);
			double deptno = (double) map.get("deptno");
			if(deptno == 10){
				userSupervisorCounts++;
				userSupervisorCounts = userSupervisorCounts;
			}else if(deptno == 20){
				userManagerCounts++;
				userManagerCounts = userManagerCounts;
			}else if(deptno == 30){
				userSalesmanCounts++;
				userSalesmanCounts = userSalesmanCounts;
			}
		}
		request.setAttribute("list", listUser); // 用户全部信息
		request.setAttribute("userSum", userSum);
		request.setAttribute("userSupervisorCounts", userSupervisorCounts);
		request.setAttribute("userManagerCounts", userManagerCounts);
		request.setAttribute("userSalesmanCounts", userSalesmanCounts);
		return "wangye0119/administrator";
	}
	
	//登陆
	@RequestMapping(value="/bmsLogin.do",produces="text/html;charset=UTF-8")
	public String bmsLogin(HttpServletRequest request,HttpServletResponse response,
			String username,
			String password
			){
		System.err.println(username+"-----"+password);
		Map bmsAdminMap = null;
		bmsAdminMap = bmsUserService.checkUser(username, password);
		BmsUser buAdmin= jsonutil.toBean(bmsAdminMap,BmsUser.class);
		if(bmsAdminMap!=null){
			int status = buAdmin.getStatus();
			System.err.println("---status---"+status);
			if(status==1){
				System.out.println("登陆成功");
				request.getSession().setAttribute("buAdmin", buAdmin);  
				request.getSession().setAttribute("bms_AdminMap",bmsAdminMap);         	
				request.getSession().setAttribute("bms_username",bmsAdminMap.get("username"));  // 账号
				request.getSession().setAttribute("bms_password",bmsAdminMap.get("password")); // 密码
				request.getSession().setAttribute("bms_uname",bmsAdminMap.get("uname"));      // 姓名
				request.getSession().setAttribute("bms_id",bmsAdminMap.get("uid"));			 // id
				request.getSession().setAttribute("bms_deptno",bmsAdminMap.get("deptno"));  // 部门编号
				request.getSession().setAttribute("bms_ucid",bmsAdminMap.get("ucid"));     // ucid 用户和公司连接
				int deptno = buAdmin.getDeptno();
				if(deptno == 40){ //超级管理员
					return "wangye0119/index";
				}
				if(deptno == 10){  // 主管
					return "wangye0119/index1"; 
				}
				if(deptno == 20){ // 业务经理
					return "wangye0119/index2";
				}
				if(deptno == 30){ // 业务员
					return "wangye0119/index3";
				}
			}else{
				System.out.println("登陆失败!");
				return "wangye0119/login";
			}
		}else{  // 不可用
			System.out.println("登陆失败!");
			return "wangye0119/login";
		}
		return "wangye0119/login";
	}      
	//退出
	@RequestMapping(value="/bmsLoginOut.do",produces="text/html;charset=UTF-8")
	public String bmsLoginOut(HttpSession session,HttpServletRequest request,String username,String password){
		 //清除Session 
		 session.invalidate();
		 return "wangye0119/login";					
	}
}


