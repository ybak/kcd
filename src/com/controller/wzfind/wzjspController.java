package com.controller.wzfind;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.mapper.wzfind.cartypename;
import com.model.jbapi.jbzxapiuser;
import com.model.wzfind.peccancy;
import com.service.wzfind.peccancyService;
import com.service.zx.jbzxapiuserService;
import com.util.jsonutil;
import com.util.limitutil;

@Controller
public class wzjspController {

	 @Autowired  
	 private peccancyService peccancyService;
	 @Autowired
	 private jbzxapiuserService jbzxapiuserService;
    //查询违章
    @RequestMapping(value="/wzlist.do",produces="text/html;charset=UTF-8")
	public String  wzlist(
			String pagesize,//每页数量
			String pagenow,//当前页数
			HttpServletRequest request){
    	int now;//当前页数
		if(pagenow!=null){
			now=Integer.parseInt(pagenow);
	        }else{
	        now=1;
	        }	
		int size;//每页数量
		if(pagesize!=null){
			size=Integer.parseInt(pagesize);
	        }else{
	        size=10;
	        }
		List<peccancy> pal=new ArrayList<peccancy>(); 
    	List<peccancy> pl= peccancyService.peccancylist();
    	if(pl.size()>0){
    		for(int i=0;i<pl.size();i++){
    		peccancy p=pl.get(i);
    		jbzxapiuser jau=jbzxapiuserService.findapiuserbyid(p.getCkeyid());	
    		if(jau!=null){
    			p.setPname(jau.getApi_name());
        		p.setGname(jau.getApi_companyname());
    		}
    		if(p.getOrderstate()==1){    		    		
			if(
					p.getCarprefix().equals("蒙")||
					p.getCarprefix().equals("川")||
					p.getCarprefix().equals("浙")
					){
		    p.setPrice("0.26");
			}else
			if(
					p.getCarprefix().equals("津")||
					p.getCarprefix().equals("陕")
			){
			p.setPrice("0.36");
			}else{
			p.setPrice("0.2");	
			}			
  		    }else{
  		    p.setPrice("0.0");		
  		    }
    		pal.add(p);
    		}
    	}
    	List list=new ArrayList<>();
    	list=limitutil.fy(pal, size, now);
		int q=pal.size()%size;
    	int totalpage=0;//总页数
    	if(q==0){
    		totalpage=pal.size()/size;	    		
    	}else{
    		totalpage=pal.size()/size+1;
    	}
    	request.setAttribute("totalpage",totalpage);//总页数
    	request.setAttribute("pagesize",size);//每页数量
    	request.setAttribute("now",now);//当前页
    	request.setAttribute("totalCount",pal.size());//总数量
    	request.setAttribute("list",list);// 
    	request.setAttribute("pagenow",now);//
    	return "jsp/wzcx/wztable";
    }
	 //审核信息
    @RequestMapping(value="/wzsh.do",produces="text/html;charset=UTF-8")
	public String  wzsh(int id,HttpServletRequest request){    	
        peccancy peccancy=peccancyService.findpeccancybyid(id);
        jbzxapiuser jau=jbzxapiuserService.findapiuserbyid(peccancy.getCkeyid());
        String carname=cartypename.cartype(peccancy.getCartype());
        if(peccancy.getResultmsg()!=null&&!peccancy.getResultmsg().equals("")){
        	JSONObject jb=JSONObject.parseObject(peccancy.getResultmsg());
        	if(jb.get("status").equals("0")){
        	
            JSONObject result=JSONObject.parseObject(jb.get("result").toString());
        	request.setAttribute("carorg",result.get("carorg"));	
        	request.setAttribute("usercarid",result.get("usercarid"));
        	request.setAttribute("count",result.get("count"));
        	request.setAttribute("totalprice",result.get("totalprice"));
        	request.setAttribute("totalscore",result.get("totalscore"));
        	if(result.get("list")!=null&&!result.get("list").equals("")){
        		List list=jsonutil.toList(result.get("list"));
            	request.setAttribute("list",list);	
        	}    
        	
        	}   
        request.setAttribute("status",jb.get("status"));
        request.setAttribute("msg",jb.get("msg"));
        
        }
        request.setAttribute("peccancy",peccancy);      
        request.setAttribute("carname",carname);  
        request.setAttribute("pname",jau.getApi_name());	
        request.setAttribute("gname",jau.getApi_companyname());	
        return "jsp/wzcx/wzsh";
    }
	
     
	
	
}
