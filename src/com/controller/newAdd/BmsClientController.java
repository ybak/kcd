package com.controller.newAdd;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.newAdd.BmsCpyclient;
import com.model.newAdd.BmsUser;
import com.service.newAdd.BmsClientService;
import com.service.newAdd.BmsUserService;
import com.util.creditutil;

@Controller
public class BmsClientController {
	@Autowired
	private BmsClientService bmsClientService;
	@Autowired
	private BmsUserService bmsUserService;
	HttpServletRequest request;
	HttpServletResponse response;
	
	
	//修改某客户到管理员下面
	@RequestMapping(value="/updateClientToUserUp.do",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	public String updateClientToUserUp(HttpServletRequest request,HttpServletResponse response,
			int tid,
			String ucid){
		int a = bmsClientService.updateClientToUserUp(ucid, tid);
		/*
		if(a>0){
			System.out.println("修改成功!");
		}else{
			System.out.println("修改失败!");
		}
		*/
		return selectAllClient(request, response);
	}
	
	
	//业务经理或业务员--模糊查询
	@RequestMapping(value="/selectClientLikeManager.do",produces="text/html;charset=UTF-8")
	public String selectClientLikeManager(HttpServletRequest request,HttpServletResponse response,
			String tname){
		String ucid =  request.getSession().getAttribute("bms_id").toString();
		ArrayList list = bmsClientService.selectClientLikeManager(ucid,"%"+tname+"%");
		int clientSum = list.size();
		request.setAttribute("list", list); // 被查询对象的全部信息
		request.setAttribute("clientSum", clientSum); // 全部的用户个数
		return "wangye0119/user_list";
	}
	
	//主管权限--模糊查询
	@RequestMapping(value="/selectClientLike.do",produces="text/html;charset=UTF-8")
	public String selectClientLike(HttpServletRequest request,HttpServletResponse response){
		String tname ="";
		try {
			tname = new String(request.getParameter("tname").getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList list = bmsClientService.selectClientLike("%"+tname+"%");
		int clientSum = list.size();
		request.setAttribute("list", list); // 被查询对象的全部信息
		request.setAttribute("clientSum", clientSum); // 全部的用户个数
		return "wangye0119/user_list";
	}
	
	//添加客户 开户
	@RequestMapping(value="/addBMSClient.do",method=RequestMethod.POST,produces="multipart/form-data;charset=UTF-8")
	public String addBMSUser(HttpServletRequest request,HttpServletResponse response,
			String tname,
			int sex,
			String clientPhone,
			String cname,
			String clientAddress,
			String ta,
			int status
			){
		BmsCpyclient bc = new BmsCpyclient();
		bc.setTname(tname); 
		bc.setSex(sex);
		bc.setCname(cname);
		bc.setCaddTime(creditutil.time().toString());
		bc.setCupdateTime(creditutil.time().toString());
		bc.setClientPhone(clientPhone);
		bc.setClientAddress(clientAddress);
		bc.setTa(ta);
		bc.setStatus(status); // 1启用    0未启用
		String uid = request.getSession().getAttribute("bms_id").toString();
		bc.setUcid(uid);  // 登陆用户与添加用户关联
		int a = bmsClientService.addBMSClient(bc);
		/*
		if(a>0){
			System.out.println("添加系统用户成功!");
		}else{
			System.out.println("添加系统用户失败!");
		}
		*/
		return selectAllClient(request,response);
	}
	
	
	//修改用户  是否可用
	@RequestMapping(value="/updateClientStatus.do",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	public String updateClientStatus(HttpServletRequest request,HttpServletResponse response,
			int status,
			int tid){
		if(status == 1){  // 1可用      0不可用         如果用户可用，则修改为不可用  
			bmsClientService.updateClientStatus(0, tid);
		}else if(status == 0){
			bmsClientService.updateClientStatus(1,tid);
		}
		return selectAllClient(request, response);
	}
	
	//删除用户
	@RequestMapping(value="/deleteClientByTid.do",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	public String deleteUserByUid(HttpServletRequest request,HttpServletResponse response,int tid){
		bmsClientService.deleteClientByTid(tid); // 通过 Tid 唯一主键，删除注定一个用户
		return selectAllClient(request, response);
	}
	
	
	//修改单个用户的跟进情况
	@RequestMapping(value="/updateOneClientByTid.do",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	public String updateOneClientByTid(HttpServletRequest request,HttpServletResponse response,
			String ta,
			String tb,
			String tc,
			String td,
			int tid
			){
		BmsCpyclient oneClient = new BmsCpyclient();
		bmsClientService.updateClientInfo(ta, tb, tc, td, tid);
		return selectOneClientByTid(request,response,tid);
	}
	
	
	//查询单个用户的跟进情况
	@RequestMapping(value="/selectOneClientByTid.do",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	public String selectOneClientByTid(HttpServletRequest request,HttpServletResponse response,int tid){
		BmsCpyclient oneClient = new BmsCpyclient();
		oneClient =	bmsClientService.selectOneClientByTid(tid); // 通过 Tid 唯一主键查询
		request.setAttribute("oneClient", oneClient);
		return "wangye0119/member-show";
	}
	
	//查询所有客户
	@RequestMapping(value="/selectAllClient.do",produces="text/html;charset=UTF-8")
	public String selectAllClient(HttpServletRequest request,HttpServletResponse response){
		int deptno = (int) request.getSession().getAttribute("bms_deptno");
		/*
		 * 判断权限
		 * 根据权限显示不同的返回结果
		 * */
		// 业务经理或业务员
		if(deptno == 20 || deptno == 30){
			String ucid = request.getSession().getAttribute("bms_id").toString();
			ArrayList listClient = bmsClientService.selectLoginUserClient(ucid);
			int clientSum = listClient.size();
			request.setAttribute("clientSum", clientSum); // 全部的用户个数
			request.setAttribute("list", listClient); // 用户全部信息
		}else if(deptno == 10 || deptno == 40){
			// 主管
			ArrayList allUser = bmsUserService.selectAllUser();
			ArrayList listClient = bmsClientService.selectAllClient();
			int clientSum = listClient.size();
			request.setAttribute("allUser", allUser); // 管理员全部信息
			request.setAttribute("clientSum", clientSum); // 全部的用户个数
			request.setAttribute("list", listClient); // 客户全部信息
		}
		return "wangye0119/user_list";
	}
}
                                                                                                                                                                                                                  