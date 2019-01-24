package com.controller.jbzxApi;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.model.zxjb;
import com.model.jbapi.apikchistory;
import com.model.jbapi.jbzxapihistory;
import com.model.jbapi.jbzxapiuser;
import com.service.zx.apikchistoryService;
import com.service.zx.jbzxService;
import com.service.zx.jbzxapiuserService;
import com.service.zx.jbzxhistoryService;
import com.util.creditutil;
import com.util.sublistutil;
import com.util.duoying.MD5;

@Controller
public class apiuserController {

	@Autowired
	private jbzxapiuserService jbzxapiuserservice;
	
	@Autowired
	private jbzxService jbzxservice;
	@Autowired
	private jbzxhistoryService jbzxhistoryservice;
	@RequestMapping(value="apiuserlist.do",produces="text/html;charset=UTF-8")
	public String apiuserlist(HttpServletRequest request){		
	    String pageNow = request.getParameter("pagenow");
    	String pagesize = request.getParameter("pagesize");		    	
	    	int nid;
			if(pageNow!=null){
				nid=Integer.parseInt(pageNow);
		        }else{
		        nid=1;
		        }	
			int size;
			if(pagesize!=null){
				size=Integer.parseInt(pagesize);
		        }else{
		        size=10;
		        }
			List<jbzxapiuser> list=new ArrayList<jbzxapiuser>();
			List<jbzxapiuser> apiuserlist=jbzxapiuserservice.apiuserlist();
			request.setAttribute("apiuserlist", "apiuserlist");
			list=sublistutil.fy(apiuserlist,size,nid);	    	
			int q=apiuserlist.size()%size;
	    	int w=0;//总页数
	    	if(q==0){
	    		w=apiuserlist.size()/size;	    		
	    	}else{
	    		w=apiuserlist.size()/size+1;
	    	} 
	    	request.setAttribute("totalall",w);//总页数
	    	request.setAttribute("pagenow",nid);//当前页数
	    	request.setAttribute("size",size);//每页显示条数
	    	request.setAttribute("apiuser",list);
			request.setAttribute("totalCount",apiuserlist.size());//总条数   
		    return "jsp/jbzxapi/jbzxusertable";
	}
	
	
	
	@RequestMapping(value="/jsp/jbzxapi/saveapiuser.do",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String saveapiuser(
			String api_name,
			String api_tel,
			String api_card,
			String  api_companyname,
			String api_companyaddress,
			String api_type
			){
		jbzxapiuser jau=new jbzxapiuser();
		jau.setApi_addtime(creditutil.time());
		jau.setApi_card(api_card);
		jau.setApi_companyaddress(api_companyaddress);
		jau.setApi_companyname(api_companyname);
		jau.setApi_money("0");
		jau.setApi_name(api_name);
		jau.setApi_tel(api_tel);
		jau.setApi_type(Integer.parseInt(api_type));
		jau.setApi_uptime(creditutil.time());
		jau.setAppkey(MD5.sign(
				api_name+
				api_card+
				api_tel+
				creditutil.timefiles(),"UTF-8"));
		jbzxapiuserservice.addapiuser(jau);
		JSONObject result=new JSONObject();
		result.put("appKey",jau.getAppkey());
		result.put("msg", "成功");
		result.put("resultcode", "0");
		return result.toString();		
	}
	@Autowired
	private apikchistoryService apikchistoryService;
	
	@RequestMapping(value="upapiuser.do",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String upapiuser(
			String api_name,
			String api_tel,
			String api_card,
			String api_companyname,
			String api_companyaddress,
			String api_type,
			String id,
			String api_money,
			String api_money1
			){
		jbzxapiuser jau=new jbzxapiuser();
		//jau.setApi_addtime(creditutil.time());
		jau.setApi_card(api_card);
		jau.setApi_companyaddress(api_companyaddress);
		jau.setApi_companyname(api_companyname);
		//jau.setApi_money("0");
		jau.setApi_name(api_name);
		jau.setApi_tel(api_tel);
		jau.setApi_type(Integer.parseInt(api_type));
		jau.setApi_uptime(creditutil.time());	
		jau.setId(Integer.parseInt(id));					
		if(
				api_money1!=null
				&&!api_money1.equals("")
				
				){
			System.out.println(api_money+"---------");
			BigDecimal b1 = new BigDecimal(api_money.replace("元",""));
			BigDecimal b2 = new BigDecimal(api_money1);	
			jau.setApi_money(b1.add(b2).toString());
			apikchistory akh=new apikchistory();
			akh.setAddtime(creditutil.time());
			akh.setUptime(creditutil.time());
			akh.setJauid(Integer.parseInt(id));
			akh.setPrice(api_money1);
			apikchistoryService.addapikchistory(akh);
		}
		jbzxapiuserservice.upjbzxapiuser(jau);
		return "1";		
	}
	@RequestMapping(value="apiuserup.do",produces="text/html;charset=UTF-8")
	public String apiuserup(
			HttpServletRequest request,
			int id){
		jbzxapiuser jau=jbzxapiuserservice.findapiuserbyid(id);
		List<apikchistory> al=apikchistoryService.findapikchistory(id);
		request.setAttribute("al", al);
		request.setAttribute("jau", jau);
		
		
		return "jsp/jbzxapi/upapiuser";

	}
	
	
	@RequestMapping(value="/jbzxlist.do",produces = "text/html;charset=UTF-8")
	public String jbzxlist(
			HttpServletRequest request
			){		
	    String pageNow = request.getParameter("pagenow");
    	String pagesize = request.getParameter("pagesize");	
   	        List<zxjb> list=new ArrayList<zxjb>();		    	
	    	int nid;
			if(pageNow!=null){
				nid=Integer.parseInt(pageNow);
		        }else{
		        nid=1;
		        }	
			int size;
			if(pagesize!=null){
				size=Integer.parseInt(pagesize);
		        }else{
		        size=10;
		        }
			List<zxjb> zl= jbzxservice.jbzxlist();
			List<zxjb> zl1=new ArrayList<zxjb>();
			if(zl!=null&&zl.size()>0){
			for(int i=0;i<zl.size();i++){
			zxjb zxjb=zl.get(i);			  
			jbzxapiuser jau=jbzxapiuserservice.findapiuserbyid(zxjb.getGems_fs_id());
			if(jau!=null){
				zxjb.setGname(jau.getApi_companyname());
				zxjb.setPname(jau.getApi_name());
				zl1.add(zxjb);	
			}
			}				
			}
			list=sublistutil.fy(zl1,size,nid);	    	
			int q=zl1.size()%size;
	    	int w=0;//总页数
	    	if(q==0){
	    		w=zl1.size()/size;	    		
	    	}else{
	    		w=zl1.size()/size+1;
	    	} 
	    	request.setAttribute("totalall",w);//总页数
	    	request.setAttribute("pagenow",nid);//当前页数
	    	request.setAttribute("size",size);//每页显示条数
	    	request.setAttribute("zl",list);
			request.setAttribute("totalCount",zl1.size());//总条数      			
		return "jsp/jbzxapi/jbzx";		
	} 
	
	@RequestMapping(value="/jbzxsh.do",produces = "text/html;charset=UTF-8")
	public String jbzxsh(
			HttpServletRequest request
			){
		String id = request.getParameter("id");		
		zxjb z=jbzxservice.findjbzxbyid(Integer.parseInt(id));
		jbzxapiuser jau=jbzxapiuserservice.findapiuserbyid(z.getGems_fs_id());
		request.setAttribute("gname",jau.getApi_companyname());
		request.setAttribute("pname",jau.getApi_name());		
		request.setAttribute("jbzx",z);
		List<jbzxapihistory> jl=jbzxhistoryservice.jbzxapihistorylist(Integer.parseInt(id));
		request.setAttribute("jbzxhistory",jl);		
		return "jsp/jbzxapi/jbzxsh";			
	}
}
