package com.controller.kcdback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.finance;
import com.model.gskh;
import com.model.gsrykh;
import com.model.mdxx;
import com.service.creditService;
import com.service.financeService;
import com.service.gskhService;
import com.service.historyService;
import com.service.mdxxService;
import com.service.gsrykhService;
import com.service.pdfoverService;
import com.util.Page;
import com.util.jsonutil;

@Controller
public class financeController {
	@Autowired
    private pdfoverService pfs;
	@Autowired
    private historyService hts;
	@Autowired
    private creditService cds;
	@Autowired
    private financeService fns;	
	@Autowired
    private gsrykhService khgsservice;
	@Autowired
	private gskhService gskhservice;	
	@Autowired
    private mdxxService mdxxservice;
	
	//json 工具类
    jsonutil ju=new jsonutil();
    
    private final Log logger = LogFactory.getLog(getClass());
    
    
    @RequestMapping(value="/addfinance.do",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public String addfinance(
    		String shgs,
    		String qygsm,
    		String  je,
    		String bz,
    		String lx,
    		String rmk,
    		String zt,
    		String num,
    		String czr
    		){
    	//logger.info("登陆成功！");
    	finance fn=new finance();
    	gskh k=new gskh();
    	Map m=new HashMap<>();
    	Map m1=new HashMap<>();
    	String rs=null;
    	int kd=0;
    	if(!shgs.equals("")&&shgs!=null    		
    					&&!je.equals("")&&je!=null
    											&&!num.equals("")&&num!=null
    													&&!czr.equals("")&&czr!=null
    			){
    	m1= gskhservice.fgsname1(shgs);
    	fn.setShgs(shgs);
    	fn.setQygsm(qygsm);
    	fn.setJe(je);
    	fn.setBz(bz);
    	fn.setLx(lx);
        fn.setRmk(rmk);
    	fn.setZt(zt);
    	fn.setCzr(czr);
    	kd=Integer.parseInt(m1.get("kd").toString()); 
    	k.setKd(kd+Integer.parseInt(num));
    	k.setId(Integer.parseInt(m1.get("id").toString()));    	
    	gskhservice.upgskhkd(k);    	    	
    	//System.out.println(m1.get("khid").toString());
    	fn.setKhid(Integer.parseInt(m1.get("id").toString()));   	    	    	
    	fns.savefinance(fn);    	 	
    	 rs="充值成功！";
    	 m.put("rs", rs);
    	}else{    		
    		 rs="字段不完整！";    	 
			 m.put("rs", rs);
    	}    		    	
        return jsonutil.toJSONString(m);
    	
    	
    	
    }
    
    @RequestMapping(value="/khgsnamelist.do",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String khgsnamelist(HttpServletRequest request){		
    	List<Map<String, String>> lgsrykh=new ArrayList<Map<String, String>>();
    	List<Map<String, String>> lmdxx=new ArrayList<Map<String, String>>();
    	List<gsrykh> klist=khgsservice.fgsrykhname();
    	//List<mdxx> mlist=mdxxservice.mdxxbyname();
    	List list=new ArrayList<>();
         for(int i=0;i<klist.size();i++){
        	 gsrykh gsrykh=klist.get(i);
        	 Map m=new HashMap<>();
        	 m.put("khgsname", gsrykh.getKhgsname());
        	 lgsrykh.add(m);
        }
//         for(int i1=0;i1<mlist.size();i1++){
//        	 mdxx mdxx=mlist.get(i1);
//        	 Map m1=new HashMap<>();
//        	 m1.put("khgsname",mdxx.getSname());
//        	 lmdxx.add(m1);
//        }
         lgsrykh.addAll(lmdxx);
        // System.out.println(jsonutil.toJSONString(lgsrykh));
    	return jsonutil.toJSONString(lgsrykh);       
    }
    
    
    @RequestMapping(value="/limitfinance.do",produces="text/html;charset=UTF-8")
    public String limitfinance(HttpServletRequest request){
		
    	String pageNow = request.getParameter("pagenow");
    	Page page=null;
    	String size = request.getParameter("size");
    	List<finance> fnlist=new ArrayList<finance>();
    	int count=fns.findfinancecount();
    	int s;
    	if(size!=null){
    		s=Integer.parseInt(size);
    	}else {
			s=10;
		}
       
    	if (pageNow!=null) {				
			//System.out.println(0);
    
			page = new Page(count, Integer.parseInt(pageNow),s);
			fnlist=this.fns.findfinancelimit(page.getStartPos(), page.getPageSize());
		
		} else {
			//System.out.println(1);
			page = new Page(count,1,s);
			//System.out.println(page.getStartPos()+"----"+page.getPageSize());
			fnlist=this.fns.findfinancelimit(page.getStartPos(), page.getPageSize());
			pageNow="1";
		}
    	
    	int q=count%s;
    	int w=0;
    	if(q==0){
    		w=count/s;
    		
    	}else{
    		w=count/s+1;
    	}    	
    	request.setAttribute("pagenow",pageNow);
    	request.setAttribute("count",count);
    	request.setAttribute("w",w);
    	request.setAttribute("fnlist",fnlist);
    	request.setAttribute("size",s);
//    	Map result=new HashMap();
//    	result.put("count", count);
//    	result.put("size", size);
//    	result.put("result",fnlist);
    	return "topuprecord";
    
    
    }
    
    @RequestMapping(value="/financelistlimit.do",produces="text/html;charset=UTF-8")
    public String financelistlimit(HttpServletRequest request){
    	String pageNow = request.getParameter("pagenow");
    	Page page=null;
    	String size = request.getParameter("size");
    	List<finance> fnlist=new ArrayList<finance>();
    	int count=fns.findfinancecount();
    	int s;
    	if(size!=null){
    		s=Integer.parseInt(size);
    	}else {
			s=10;
		}
       
    	if (pageNow!=null) {				
			//System.out.println(0);
    
			page = new Page(count, Integer.parseInt(pageNow),s);
			fnlist=this.fns.findfinancelimit(page.getStartPos(), page.getPageSize());
		
		} else {
			//System.out.println(1);
			page = new Page(count,1,s);
			//System.out.println(page.getStartPos()+"----"+page.getPageSize());
			fnlist=this.fns.findfinancelimit(page.getStartPos(), page.getPageSize());
		
		}
    	
    	int q=count%s;
    	int w=0;
    	if(q==0){
    		w=count/s;
    		
    	}else{
    		w=count/s+1;
    	}    	
    	request.setAttribute("pagenow",pageNow);
    	request.setAttribute("count",count);
    	request.setAttribute("w",w);
    	request.setAttribute("fnlist",fnlist);
    	request.setAttribute("size",s);
//    	Map result=new HashMap();
//    	result.put("count", count);
//    	result.put("size", size);
//    	result.put("result",fnlist);
    	
		return "a2";
    	
    	
    	
    	
    }
    
}
