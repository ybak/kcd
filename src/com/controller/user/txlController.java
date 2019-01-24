package com.controller.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.model.txl;
import com.service.gsrykhService;
import com.service.txlService;
import com.util.sublistutil;

@Controller
public class txlController {
	@Autowired
    private txlService txlservice;
	@Autowired
    private gsrykhService gsrykhservice;
	
	//通讯录查询
	@RequestMapping(value="/txllist.do",produces="text/html;charset=UTF-8")
	public String txllist(HttpServletRequest request){
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
		List<txl> tlist=new ArrayList<>();
		List<txl> txllist=new ArrayList<>();	
		tlist=txlservice.txlcx();
		if(tlist!=null&&tlist.size()>0){
		for(int i=0;i<tlist.size();i++){
			txl t=new txl();
			t=tlist.get(i);
			Map gm=gsrykhservice.fkhbyid(t.getKhid());
			if(gm!=null&&gm.size()>0){
				if(gm.get("khgsname")!=null&&!gm.get("khgsname").equals("")){
					t.setGsname(gm.get("khgsname").toString());
				}
               if(gm.get("khrname")!=null&&!gm.get("khrname").equals("")){
            	   t.setRyname(gm.get("khrname").toString());	
				}
			}
			txllist.add(t);
		}
		
	}
		List list=new ArrayList<>();
		list=sublistutil.fy(txllist,size,now);
		int q=txllist.size()%size;
    	int w=0;
    	if(q==0){
    		w=txllist.size()/size;	    		
    	}else{
    		w=txllist.size()/size+1;
    	}  
    	request.setAttribute("w",w);//总页数
    	request.setAttribute("pagenow",now);//当前页数
    	request.setAttribute("size",size);//每页显示条数
		request.setAttribute("totalCount",txllist.size());//总条数      
		request.setAttribute("clist",list);		
		return "addressbookrecord";
		
		
		
	}
}
