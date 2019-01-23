package com.controller.newAdd;
import java.io.IOException;
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
import com.service.newAdd.BmsClientService;
import com.service.newAdd.BmsUserService;

import com.util.creditutil;
import com.util.jsonutil;
import com.util.newAdd.jsonToOther;
@Controller
public class BmsTeamController {
	@Autowired
	private BmsUserService bmsUserService;
	@Autowired
	private BmsClientService bmsClientService;
	HttpServletRequest request;
	HttpServletResponse response;
	
	
	//删除用户
	@RequestMapping(value="/deleteManagerUserByUid.do",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	public String deleteManagerUserByUid(HttpServletRequest request,HttpServletResponse response,
			int uid,
			int upid
			){
		bmsUserService.deleteUserByUid(uid); // 通过 uid 唯一主键，删除注定一个用户
		return selectLoginUserTeam(request,response,upid);
	}
	
	//点击团队下成员名字显示该成员下所有的客户信息
	@RequestMapping(value="/selectOtherUserClient.do",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	public String selectOtherUserClient(HttpServletRequest request,HttpServletResponse response,String ucid){
		System.err.println(ucid+"-----------------");
		ArrayList list = bmsClientService.selectLoginUserClient(ucid); // 查询登陆用户下的团队
		request.setAttribute("list", list); // 被查询对象的全部信息
		return "wangye0119/user_list";
	}
	
	//查询登陆用户的团队人员
	@RequestMapping(value="/selectLoginUserTeam.do",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	public String selectLoginUserTeam(HttpServletRequest request,HttpServletResponse response,int upid){
		//int upid = (int) request.getSession().getAttribute("bms_id");
		ArrayList list = bmsUserService.selectLoginUserTeam(upid); // 查询登陆用户下的团队
		ArrayList managerList = bmsUserService.selectOtherUser(20); //查询经理
		int managerSum = managerList.size();
		request.setAttribute("list", list); // 被查询对象的全部信息
		request.setAttribute("managerList", managerList); // 被查询的业务经理
		request.setAttribute("managerSum", managerSum); // 被查询的业务经理的总数
		request.setAttribute("upid", upid); // 业务经理团队编号
		return "wangye0119/Shop_list";
	}
}


