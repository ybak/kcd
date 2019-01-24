package com.controller.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.hmd;
import com.service.gsrykhService;
import com.service.hmdService;
import com.util.sublistutil;

@Controller
public class hmdController {
	@Autowired
    private hmdService hmdservice;
	@Autowired
    private gsrykhService gsrykhservice;
	//通讯录查询
		@RequestMapping(value="/hmdcx.do",produces="text/html;charset=UTF-8")
		public String hmdcx(HttpServletRequest request){
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
			List<hmd> hlist=new ArrayList<>();
			List<hmd> hmdlist=new ArrayList<>();	
			hlist=hmdservice.hmdlist();
			if(hlist.size()>0&&hlist!=null){

			for(int i=0;i<hlist.size();i++){
				hmd h=new hmd();
				h=hlist.get(i);
				Map gm=gsrykhservice.fkhbyid(h.getKhid());
				if(gm!=null&&!gm.equals("")){
					if(gm.get("khgsname")!=null&&!gm.get("khgsname").equals("")){
						h.setGsname(gm.get("khgsname").toString());
					}
					if(gm.get("khrname")!=null&&!gm.get("khrname").equals("")){
						h.setRyname(gm.get("khrname").toString());
					}
				
				hmdlist.add(h);
				}
			}
			
		}
			List list=new ArrayList<>();
			list=sublistutil.fy(hmdlist,size,now);
			int q=hmdlist.size()%size;
	    	int w=0;
	    	if(q==0){
	    		w=hmdlist.size()/size;	    		
	    	}else{
	    		w=hmdlist.size()/size+1;
	    	}  
	    	request.setAttribute("w",w);//总页数
	    	request.setAttribute("pagenow",now);//当前页数
	    	request.setAttribute("size",size);//每页显示条数
			request.setAttribute("totalCount",hmdlist.size());//总条数      
			request.setAttribute("clist",list);		
			return "hmdAPItable";
			
			
			
		}
	
}
