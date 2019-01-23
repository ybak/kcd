package com.controller.index;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.model.credit;
import com.model.mdxx;
import com.service.creditService;
import com.service.mdxxService;
import com.util.Page;
import com.util.sublistutil;

@Controller
public class jynwdController {

	
	 @Autowired
	 private mdxxService mdxxservice;
	 @Autowired
	 private creditService creditservice;
	 
	 @RequestMapping(value="/mdxxlist.do",produces="text/html;charset=UTF-8")
	 public String mdxxlist(HttpServletRequest request){
		    String pageNow = request.getParameter("pagenow");
	    	String size = request.getParameter("size");	    	
			Page page =null;
			List<mdxx> mdlist = new ArrayList<mdxx>();
			int s=0;
			if(size!=null){
			s=Integer.parseInt(size);
			}else {
			s=10;	
			}	
			int totalCount=mdxxservice.mdxxnum();
			if (pageNow!=null) {				
				//System.out.println(0);
				page = new Page(totalCount, Integer.parseInt(pageNow),s);
				mdlist=this.mdxxservice.mdxxlist(page.getStartPos(), page.getPageSize());			
			} else {
				System.out.println(1);
				page = new Page(totalCount, 1,s);
				//System.out.println(page.getStartPos()+"----"+page.getPageSize());
				mdlist=this.mdxxservice.mdxxlist(page.getStartPos(), page.getPageSize());			
			}
			int q=totalCount%s;
	    	int w=0;
	    	if(q==0){
	    		w=totalCount/s;	    		
	    	}else{
	    		w=totalCount/s+1;
	    	}    		    
	    	request.setAttribute("w",w);//总页数
	    	request.setAttribute("pagenow",pageNow);//当前页数
	    	request.setAttribute("size",s);//每页显示条数
			request.setAttribute("totalCount",totalCount);//总条数      
			request.setAttribute("mdlist", mdlist);
	        return "jynwdmdxx";		 		 		 
	 }
	 
	 
	 @RequestMapping(value="/nwddsh.do",produces="text/html;charset=UTF-8")
	 public String nwddsh(HttpServletRequest request){
		    String pageNow = request.getParameter("pagenow");
	    	String pagesize = request.getParameter("pagesize");
	    	String bit=request.getParameter("bit");
	    	if(bit!=null){
	    		bit=bit.substring(0, 1);	
	    	}	    	
	    	System.out.println(bit+"----------------");
	    	List<credit> mlist=new ArrayList<>();
	    	List<mdxx> ml=mdxxservice.mdxxckey();	    	
	    	for(int i=0;i<ml.size();i++){
	    		mdxx m=new mdxx();
	    		m=ml.get(i);
	    	    List<credit> cl=creditservice.findmdid(m.getCkey(),bit);
	    	    List<credit> cl1=new ArrayList<credit>();
	    	    if(bit!=null){
	    	    if(bit=="6"||bit.equals("6")){
	    	     cl1=creditservice.findmdid(m.getCkey(),"7");	    	    
	    	    }
	    	    }
	    	    if(cl!=null&&!cl.equals("")&&cl.size()>0){
	    	    	
	    	    	 mlist.addAll(cl);
	    	    	 if(cl1!=null&&!cl1.equals("")&&cl1.size()>0){
	    	    	 mlist.addAll(cl1);
	    	    	 }
	    	    	 
	    	    }	    	   
	    	}
	    	 List list=new ArrayList<>();
	    	
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
			list=sublistutil.fy(mlist,size,nid);
	    	int q=mlist.size()%size;
	    	int w=0;
	    	if(q==0){
	    		w=mlist.size()/size;	    		
	    	}else{
	    		w=mlist.size()/size+1;
	    	}    		    
	    	request.setAttribute("w",w);//总页数
	    	request.setAttribute("pagenow",pageNow);//当前页数
	    	request.setAttribute("size",size);//每页显示条数
			request.setAttribute("totalCount",mlist.size());//总条数      
			request.setAttribute("clist",list);
			request.setAttribute("bit",bit);
			request.setAttribute("api","1");
			if(bit!=null){
			request.setAttribute("name","nwddsh.do?bit="+bit);	
			}else{
			request.setAttribute("name","nwddsh.do");	
			}
		
	        return "nwddsh";		 		 		 
	 }
	 

	 
}
