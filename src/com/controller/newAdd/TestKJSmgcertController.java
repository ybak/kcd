package com.controller.newAdd;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.apply;
import com.model.index.index;
import com.model1.mgcert;
import com.model1.mgcert_result;
import com.model1.ylds;
import com.model1.ylqy;
import com.service1.newAdd.TestKJSmgCertResultService;
import com.service1.newAdd.TestKJSmgcertService;
import com.util.Page;
import com.util.creditutil;
import com.util.jsonutil;
import com.util.newAdd.jsonToOther;

@Controller
public class TestKJSmgcertController {
	@Autowired
	private TestKJSmgcertService testKJSmgcertService;
	@Autowired
	private TestKJSmgCertResultService testKJSmgCertResultService;
	
	
	@RequestMapping(value="weiZhang.do",produces="text/html;charset=UTF-8")
	public String weiZhang(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String fsname = new String(request.getParameter("fsname").getBytes("iso-8859-1"),"utf-8");
		String gemsname = new String(request.getParameter("gemsname").getBytes("iso-8859-1"),"utf-8");
		request.setAttribute("fsname", fsname);
		request.setAttribute("gemsname", gemsname);
		return "weiZhangSelect";
	}
	
	@RequestMapping(value="baoXian.do",produces="text/html;charset=UTF-8")
	public String baoXian(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String carno = new String(request.getParameter("carno").getBytes("iso-8859-1"),"utf-8");
		request.setAttribute("carno", carno);
		return "baoXianSelect";
	}
	
	
	
	@RequestMapping(value="mingZhongDifferent.do",produces="text/html;charset=UTF-8")
	public String mingZhongDifferent(HttpServletRequest request,HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String mzType = new String(request.getParameter("mzType").getBytes("iso-8859-1"),"utf-8");
		String khName = new String(request.getParameter("khName").getBytes("iso-8859-1"),"utf-8");
		//String khName = request.getParameter("khName");
		String khCardId = new String(request.getParameter("khCardId").getBytes("iso-8859-1"),"utf-8");
		System.err.println(mzType+"------"+khName+"-----"+khCardId);
		if(mzType.equals("renhang")){
			request.setAttribute("khName", khName);
			request.setAttribute("khCardId", khCardId);
			return "testKJScaoZuorenHangTest";
		}else if(mzType.equals("big")){
			request.setAttribute("khName", khName);
			request.setAttribute("khCardId", khCardId);
			return "testKJScaoZuoBigTest";
		}else if(mzType.equals("phone")){
			request.setAttribute("khName", khName);
			request.setAttribute("khCardId", khCardId);
			return "testKJScaoZuoPhoneTest";
		}else if(mzType.equals("weizhang")){
			return "testKJScaoZuoWeiZhangTest";
		}
		return null;
	}
	
	@RequestMapping(value="toTestKJS.do",produces="text/html;charset=UTF-8")
	public String toTestKJS(){
		return "indexTest";
	}
	//操作
	@RequestMapping(value="CaoZuo.do",produces="text/html;charset=UTF-8")
	public String CaoZuo(HttpServletRequest request,HttpServletResponse response,
		int type,
		int amid,
		String khName,
		String khCardId,
		String fsname,
		String gemsname,
		int status) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String khNamee = new String(request.getParameter("khName").getBytes("iso-8859-1"),"utf-8");
		String khCardIdd = new String(request.getParameter("khCardId").getBytes("iso-8859-1"),"utf-8");
		String fsnamee = new String(request.getParameter("fsname").getBytes("iso-8859-1"),"utf-8");
		String gemsnamee = new String(request.getParameter("gemsname").getBytes("iso-8859-1"),"utf-8");

		System.err.println(amid+"-------"+status);
		String showImg = "cache/fillw_150h_150";
		mgcert mgcar = new mgcert();
		List<mgcert_result>  mgresult = new ArrayList();
		mgcar = testKJSmgcertService.TestKJSselectCaoZuo(amid);
		mgresult = testKJSmgCertResultService.TestKJSselectCaoZuoResult(amid);
		request.setAttribute("mgcar", mgcar);
		request.setAttribute("mgresult", mgresult);
		request.setAttribute("khName", khNamee);
		request.setAttribute("khCardId", khCardIdd);
		request.setAttribute("fsname", fsnamee);
		request.setAttribute("gemsname", gemsnamee);
		request.setAttribute("type", type); // 8 押车     9押证
		request.setAttribute("status", status);  // 判断大状态
		request.setAttribute("showImg", showImg);
		return "testKJScaoZuo";
	}
	
	//银联跳转 Two
	@RequestMapping(value="goToTwo.do",produces="text/html;charset=UTF-8")
	public String goToTwo(HttpServletRequest request,HttpServletResponse response,
			int type,
			int mgcertId,
			String khName,
			String khCardId,
			String status
			) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String khNamee = new String(request.getParameter("khName").getBytes("iso-8859-1"),"utf-8");
		String khCardIdd = new String(request.getParameter("khCardId").getBytes("iso-8859-1"),"utf-8");
		System.err.println(khName+"---"+khCardId+"---"+status);
		if(type == 2){
			List<ylds> yd = new ArrayList<ylds>();
			yd = testKJSmgcertService.TestKJSselectModelTwo(mgcertId); // 代收记录
			ylds ydd = new ylds();
			if(yd!=null && yd.size()>0){
				ydd = yd.get(0);
			}
			//新建等额本息信息
			List<ylqy> ylqy = new ArrayList<ylqy>();
			ylqy =  testKJSmgcertService.TestKJSselectModelTwoByMomeny(ydd.getBank_id());
			request.setAttribute("ylqy",ylqy);
			request.setAttribute("yd",yd);
			request.setAttribute("ydd",ydd);
			request.setAttribute("khName", khNamee);
			request.setAttribute("khCardId", khCardIdd);
			request.setAttribute("status", status); // 判断 审批 状态   2进件   3通过   5拒绝
			return "yl_modalTwo_Test";
		}else if(type == 3){
			List<ylds> yd = new ArrayList<ylds>();
			yd = testKJSmgcertService.TestKJSselectModelTwo(mgcertId); // 代收记录
			ylds ydd = new ylds();
			if(yd!=null && yd.size()>0){
				ydd = yd.get(0);
			}
			//新建等额本息信息
			List<ylqy> ylqy = new ArrayList<ylqy>();
			ylqy =  testKJSmgcertService.TestKJSselectModelTwoByMomeny(ydd.getBank_id());
			request.setAttribute("yd",yd);
			request.setAttribute("ydd",ydd);
			request.setAttribute("ylqy",ylqy);
			request.setAttribute("khName", khNamee);
			request.setAttribute("khCardId", khCardIdd);
			request.setAttribute("status", status); // 判断 审批 状态   2进件   3通过   5拒绝
			return "yl_modalThree_Test";
		}else if(type == 4){
			List<ylds> yd = new ArrayList<ylds>();
			yd = testKJSmgcertService.TestKJSselectModelTwo(mgcertId); // 代收记录
			ylds ydd = new ylds();
			if(yd!=null && yd.size()>0){
				ydd = yd.get(0);
			}
			//新建等额本息信息
			List<ylqy> ylqy = new ArrayList<ylqy>();
			ylqy =  testKJSmgcertService.TestKJSselectModelTwoByMomeny(ydd.getBank_id());
			request.setAttribute("yd",yd);
			request.setAttribute("ydd",ydd);
			request.setAttribute("ylqy",ylqy);
			request.setAttribute("khName", khNamee);
			request.setAttribute("khCardId", khCardIdd);
			request.setAttribute("status", status); // 判断 审批 状态   2进件   3通过   5拒绝
			return "yl_modalFour_Test";
		}
		return null;
	}
	
	//银联跳转 One
	@RequestMapping(value="goToOne.do",produces="text/html;charset=UTF-8")
	public String goTo(HttpServletRequest request,HttpServletResponse response,
		String idcard,
		String cname) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String cnamee = new String(request.getParameter("cname").getBytes("iso-8859-1"),"utf-8");
		ylqy qy = new ylqy();  //513821198402169031
		qy = testKJSmgcertService.TestKJSselectModelOne("513821198402169031");
		request.setAttribute("cname", cnamee);
		request.setAttribute("idcard", idcard);
		request.setAttribute("qy",qy);
		return "yl_modalOne_Test";
	}

	//查询信息
	@RequestMapping(value="TKJSselectAll.do",produces="text/html;charset=UTF-8")
	public String TKJSselectAll(HttpServletRequest request) throws UnsupportedEncodingException{
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  //根据状态显示数据
	  String queryname= new String(request.getParameter("queryname").getBytes("iso8859-1"),"utf-8");
	  System.err.println(queryname);
	  int status = Integer.parseInt(request.getParameter("status").replace("?v=4.0", ""));
	  List alist = new ArrayList();
	  String size=request.getParameter("size");
  	  String pagenow=request.getParameter("pagenow");
  	  int s;
  	  if(size!=null){
  		  s=Integer.parseInt(size);
  	  }else{
  		  s=10;
  	  }	    	 
  	  int totalCount = 0;
  	  Page page;
  	  if(status == 2){
  		totalCount = 108;
  	  }else if(status == 3){
  		totalCount = 12605;
  	  }else if(status == 5){
  		totalCount = 68;
  	  }else{
  		totalCount=108+12605+68;
  	  }
	  	System.out.println("总数："+totalCount+"当前页数："+pagenow);
		if (pagenow!=null) {				
			//System.out.println(0);
			page = new Page(totalCount, Integer.parseInt(pagenow),s);
			alist=this.testKJSmgcertService.TestKJSselectAll(status,page.getStartPos(),page.getPageSize());	
			int a = alist.size();
			///////处理展示时间///////////
				if(status == 1||status == 2 || status == 3){
					if(pagenow.equals("1")){
						for(int i=0;i<10;i++){
							int[] time = {27,28,28,29,29,29,30,30,31,31};
							  Map map = (Map) alist.get(i);
							  Calendar now=Calendar.getInstance();
							  now.add(Calendar.MINUTE,-time[i]);
							  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							  String dateStr=sdf.format(now.getTimeInMillis());
							  map.put("dt_edit",dateStr);
						}
					}else if(pagenow.equals("2")){
						for(int i=0;i<10;i++){
							int[] time = {35,37,38,39,39,40,42,42,45,48};
							  Map map = (Map) alist.get(i);
							  Calendar now=Calendar.getInstance();
							  now.add(Calendar.DATE,-1);
							  now.add(Calendar.MINUTE,-time[i]);
							  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							  String dateStr=sdf.format(now.getTimeInMillis());
							  map.put("dt_edit",dateStr);
						}
					}
					
				}
			//////////////////////
		} else {
			//System.out.println(1);
			page = new Page(totalCount, 1,s);					
			alist=this.testKJSmgcertService.TestKJSselectAll(status,page.getStartPos(),page.getPageSize());	
			int b = alist.size();
			pagenow = "1";
			///////处理展示时间///////////
				if(status == 1||status == 2 || status == 3 & pagenow.equals("1")){
					for(int i=0;i<10;i++){
						int[] time = {27,29,29,32,33,34,45,48,52,55};
						  Map map = (Map) alist.get(i);
						  Calendar now=Calendar.getInstance();
						  now.add(Calendar.MINUTE,-time[i]);
						  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						  String dateStr=sdf.format(now.getTimeInMillis());
						  map.put("dt_edit",dateStr);
					}
				}
			////////////////////
		}				
		int q=totalCount%s;
		int w=0;
		if(q==0){
			w=totalCount/s;
		}else{
			w=totalCount/s+1;
		}    		    
		request.setAttribute("status", status);
		request.setAttribute("w",w);
		request.setAttribute("pagenow",pagenow);
		request.setAttribute("size",s);
		request.setAttribute("totalCount",totalCount);
		request.setAttribute("alist",alist);
		request.setAttribute("queryname",queryname);
		return "cskjs_wzb/kjs_index";
	}
	

}
