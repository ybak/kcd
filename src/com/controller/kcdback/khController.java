package com.controller.kcdback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.gskh;
import com.model.gsrykh;
import com.model.khjl;
import com.service.gskhService;
import com.service.gsrykhService;
import com.service.userService;
import com.util.creditutil;
import com.util.jsonutil;
import com.util.sublistutil;

@Controller
public class khController {
	 @Autowired
	 private gskhService gskhservice;
	 @Autowired
	 private gsrykhService gsrykhservice;
	 @Autowired
	 private userService userservice;
	 
	 @RequestMapping(value="/khjl.do",produces="text/html;charset=UTF-8")
	 public String khjl(HttpServletRequest request){
		    String pageNow = request.getParameter("pagenow");
	    	String pagesize = request.getParameter("pagesize");
	    	int now;
	    	if(pageNow!=null){
	    		now=Integer.parseInt(pageNow);
	    	}else{
	    		now=1;
	    	}
	    	int size;
	    	if(pagesize!=null){
	    		size=Integer.parseInt(pagesize);
	    	}else{
	    		size=10;
	    	}
		 List<khjl> gsml=new ArrayList<khjl>();
		 List<khjl> ryml=new ArrayList<khjl>();
		 List<gskh> gslist=gskhservice.fgsname();	
		 for(int i=0;i<gslist.size();i++){
			 gskh gskh=new gskh();
			 gskh=gslist.get(i);
			 Map um=userservice.finduserbyid(gskh.getCzrid());
			 khjl khjl=new khjl();
			 khjl.setId(gskh.getId());
			 khjl.setGsname( gskh.getName());
			 khjl.setQygsname(gskh.getQyname());
			 khjl.setQyrname(gskh.getQykhname());
			 khjl.setZhdj("");
			 khjl.setKhrname(gskh.getKhrname());
			 khjl.setIdcard("");
			 khjl.setPhonenum("");
			 if(um!=null){
				 khjl.setCzr(um.get("name").toString());				 
			 }else{
				 khjl.setCzr("");
			 }	
			 khjl.setTime(gskh.getCtime().toString());		
			 khjl.setCzlx("公司(门店)开户");
			 gsml.add(khjl);
		 }		 
		 List<gsrykh> rylist=gsrykhservice.fgsrykhtogsrykh();
		 for(int i=0;i<rylist.size();i++){
			gsrykh gsry=new gsrykh();
			gsry=rylist.get(i);
			 Map um=userservice.finduserbyid(gsry.getCzrid());
			 Map gsmap=gskhservice.fgsbyid(gsry.getGsid());
			 khjl khjl=new khjl();
			 khjl.setId(gsry.getKhid());
			 if(gsmap!=null){			
			 if(gsmap.get("name")!=null){
				 khjl.setGsname(gsmap.get("name").toString());				 
			 }else{
				 khjl.setGsname("");
			 }
			 if(gsmap.get("qyname")!=null){				
				 khjl.setQygsname(gsmap.get("qyname").toString());
			 }else{
				 khjl.setQygsname("");
			 }
			 if(gsmap.get("qykhname")!=null){								
				 khjl.setQyrname(gsmap.get("qykhname").toString()); 
			 }else{
				 khjl.setQyrname(""); 
			 }
			 }else{
				 khjl.setGsname("");
				 khjl.setQygsname("");
				 khjl.setQyrname(""); 
			 }
			 khjl.setZhdj(gsry.getKhlevel());
			 khjl.setKhrname(gsry.getKhrname());
			 khjl.setIdcard(gsry.getKhsfznum());
			 khjl.setPhonenum(gsry.getKhphonenum());
			 if(um!=null){
				 khjl.setCzr(um.get("name").toString());				 
			 }else{
				 khjl.setCzr("");
			 }	
			 khjl.setTime(gsry.getKhtime());		
			 khjl.setCzlx("公司(门店)人员开户");
			 ryml.add(khjl);
		 }	
		 gsml.addAll(ryml);
		 
		 List<khjl> list=new ArrayList<>();
		 list=sublistutil.fy(gsml,size,now);
			int q=gsml.size()%size;
	    	int w=0;
	    	if(q==0){
	    		w=gsml.size()/size;	    		
	    	}else{
	    		w=gsml.size()/size+1;
	    	}  
	    	request.setAttribute("w",w);//总页数
	    	request.setAttribute("pagenow",now);//当前页数
	    	request.setAttribute("size",size);//每页显示条数
			request.setAttribute("totalCount",gsml.size());//总条数      
			request.setAttribute("clist",list);
		 return "companytable";	 
	 }
	 
	 @RequestMapping(value="/findgsname.do",produces="text/html;charset=UTF-8")
	 @ResponseBody
	 public String findgsname(){		
		 List<gskh> list=gskhservice.fgsname();		 		 		 
		 return jsonutil.toJSONString(list);	 
	 }
			 
	 
	 @RequestMapping(value="/addgs.do",produces="text/html;charset=UTF-8")
	 @ResponseBody
	 public String addgs(HttpServletRequest request,
			 String name,
			 String address,
			 String ncode,
			 String qyname,
			 String qykhname,
			 String khrname,
			 String czrid
			 ){
		 System.out.println(name);
		 String res; 
		 Map result=new HashMap<>();
		 gskh gskh=new gskh();
		 Map gsmap=gskhservice.sltgskh(name,ncode);
		 if(gsmap!=null&&gsmap.size()!=0&&!gsmap.equals("")){
			 res="公司已开户！";
			 result.put("res", res);		 
		 }else{
			 gskh.setAddress(address);
			 gskh.setCtime(creditutil.time());
			 gskh.setUtime(creditutil.time());
			 gskh.setKd(0);
			 gskh.setName(name);
			 gskh.setNcode(ncode);
			 gskh.setQyname(qyname);
			 gskh.setQykhname(qykhname);	
			 gskh.setKhrname(khrname);
			 gskh.setCzrid(Integer.parseInt(czrid));
			 gskhservice.addgskh(gskh);
			 res="开户成功！";			 
		 }
		return res;		 	 
	 }


}
