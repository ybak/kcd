package com.controller.kcdback;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.model.credit;
import com.model.dsj;
import com.model.history;
import com.model.gsrykh;
import com.model.pdfover;
import com.service.creditService;
import com.service.dsjService;
import com.service.gskhService;
import com.service.historyService;
import com.service.imgService;
import com.service.mdxxService;
import com.service.gsrykhService;
import com.service.pdfoverService;
import com.service1.fsService;
import com.service1.gemsService;
import com.service1.queryzxService;
import com.util.Page;
import com.util.creditutil;
import com.util.pathutil;
import com.util.stringorintutil;
import com.util.sublistutil;
@Controller
public class imgController {
	 @Autowired
	 private queryzxService queryzxservice;
	 @Autowired
	 private fsService fsservice;
	 @Autowired
	 private gemsService gemsservice;
	 @Autowired
	 private imgService imgservice;
	 @Autowired
	 private creditService creditservice;
	 @Autowired
	 private pdfoverService pdfservice;
	 @Autowired
	 private historyService historyservice;
	 @Autowired
	 private dsjService dsjservice;
	 @Autowired
	 private gsrykhService khgsservice;
	 @Autowired
	 private gskhService gskhservice;
	 @Autowired
	 private mdxxService mdxxservice;
	 
	 //api查询记录
	 @RequestMapping(value="/apilist.do",produces="text/html;charset=UTF-8")
	 public String apilist(HttpServletRequest request){
		String pagenow= request.getParameter("pagenow");
		String pagesize= request.getParameter("pagesize");
		 credit credit=new credit();
	 List<credit> cl=new ArrayList<credit>();	
	   cl=creditservice.search();
	   List list=new ArrayList();	
	   List<Map<Object, Object>>  mlist=new ArrayList<Map<Object, Object>>();
		int nid;
		if(pagenow!=null){
			nid=Integer.parseInt(pagenow);
	        }else{
	        nid=1;
	        }	
		int size;
		if(pagesize!=null){
			size=Integer.parseInt(pagesize);
	        }else{
	        size=10;
	        }
		 for(int i=0;i<cl.size();i++){
			 Map rs=new HashMap();
			 credit=cl.get(i);
		     boolean t=stringorintutil.isNumeric(credit.getMdid());
		     Map m=new HashMap();
			 if(t){
				 m=khgsservice.fkhbyid(Integer.parseInt(credit.getMdid())); 
			 		
			if(m!=null&&!m.equals("")&&m.size()!=0){
				rs.put("bz","API人行征信查询");
				rs.put("jelx", "现金");
				rs.put("time",credit.getAdd_time());
				rs.put("zt",credit.getSum_bit());
				rs.put("orderid", credit.getId());
				rs.put("czr", m.get("khrname"));
				rs.put("gsname",m.get("khgsname"));
				Map m1=gskhservice.fgsname1(m.get("khgsname").toString());
				if(m1!=null){
					rs.put("qygsname",m1.get("qyname"));
				}else{
					rs.put("qygsname","");
				}				
				rs.put("je","100");
			}
			 }	
							
			if(rs!=null&&!rs.equals("")&&rs.size()>0){
			 mlist.add(rs);
             list=sublistutil.fy(mlist,size,nid);
				
			}
		 }
		    int q=mlist.size()%size;
	    	int w=0;
	    	if(q==0){
	    		w=mlist.size()/size;	    		
	    	}else{
	    		w=mlist.size()/size+1;
	    	}    		    
	    	request.setAttribute("w",w);//总页数
	    	request.setAttribute("pagenow",nid);//当前页数
	    	request.setAttribute("size",size);//每页显示条数
		    request.setAttribute("totalCount", mlist.size());
		    request.setAttribute("apilist", list);
		return "apitable";
		 
	 }
	 
	 @RequestMapping(value="/zxbybit.do",produces="text/html;charset=UTF-8")
	 public String zxbybit(HttpServletRequest request){
		    String pageNow = request.getParameter("pagenow");
	    	String pagesize = request.getParameter("pagesize");
	    	String bit=request.getParameter("bit");	    	
	    	List<Map<Object, Object>> mlist=new ArrayList<Map<Object, Object>>();
	    	if(bit!=null&&!bit.equals("")){
	    		bit=bit.substring(0, 1);	
	    	}	    	
	    	//System.out.println(bit+"----------------");
	    	List<credit> clist=new ArrayList<>();	    	
	    	clist=creditservice.zxbysum_bit(bit);
	    	for(int i=0;i<clist.size();i++){
	    		credit credit=new credit();
	    		Map kmap=new HashMap();
	    		Map mmap=new HashMap();
	    		credit=clist.get(i);
	    	
	    		Map im=imgservice.fimg(String.valueOf(credit.getId()));
	    	
	    		if(im!=null&&im.get("httppath")!=null&&im.get("applyimg")!=null&&im.get("authorizeimg")!=null){
		    		String applyimg=im.get("httppath").toString()+"/"+im.get("applyimg").toString();
		    		String authorizeimg=im.get("httppath").toString()+"/"+im.get("authorizeimg").toString();
	                credit.setApplyimg(applyimg);
		    		credit.setAuthorizeimg(authorizeimg);	
	    		}

	    		boolean t=stringorintutil.isNumeric(credit.getMdid());
	    		if(t){
	    		   Map kmap1=khgsservice.fkhbyid(Integer.parseInt(credit.getMdid()));	    		  
	    		   if(kmap1!=null){
	    			   //System.out.println(kmap1.size()+"----------");
	    			   credit.setGsname(kmap1.get("khgsname").toString());
	    			   credit.setRyname(kmap1.get("khrname").toString());
//	    			   kmap.put("gsname",kmap1.get("khgsname"));
//		    	       kmap.put("ryname",kmap1.get("khrname"));
	    		   }	    	       
	    		}else{
	    			Map mmap1=mdxxservice.mdxxmap(credit.getMdid());	    			
	    			if(mmap1!=null){
	    			   System.out.println(mmap1.size()+"==========");
	    			   credit.setGsname(mmap1.get("sname").toString());
		    		   credit.setRyname(mmap1.get("pname").toString());
//	    			   kmap.put("gsname",mmap1.get("sname"));
//	 	    		   kmap.put("ryname",mmap1.get("pname"));
	    			}
	    		   
	    		}
	    		//mlist.add(kmap);	    		
	    	}
	    	//System.out.println(clist.get(1).getApplyimg()+"------url:");
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
				list=sublistutil.fy(clist,size,nid);
		    	int q=clist.size()%size;
		    	int w=0;
		    	if(q==0){
		    		w=clist.size()/size;	    		
		    	}else{
		    		w=clist.size()/size+1;
		    	}    		    
		    	request.setAttribute("w",w);//总页数
		    	request.setAttribute("pagenow",nid);//当前页数
		    	request.setAttribute("size",size);//每页显示条数
				request.setAttribute("totalCount",clist.size());//总条数      
				request.setAttribute("clist",list);
				request.setAttribute("api","1");
				request.setAttribute("bit",bit);
				//request.setAttribute("rt",bit);
				if(bit!=null){
				request.setAttribute("name","zxbybit.do?bit="+bit);	
				}else{
				request.setAttribute("name","zxbybit.do");	
				}
	        return "rhzx";		 		 		 
	 }
	 
	 @RequestMapping(value="/tozximg.do",produces="text/html;charset=UTF-8")
	 public String tozximg(HttpServletRequest request,String id,String name){		 
		 String imgpath=request.getParameter("imgpath");		 
		 String api=request.getParameter("api");
		 Map imgmap= imgservice.fimg(id);
		 Map  mc=new HashMap();		 
	     mc=creditservice.findcreditbyid(Integer.parseInt(id));
	     Map pmap=pdfservice.findbyid(id);
		 String filetime=creditutil.timetofile(imgmap.get("addtime").toString());		
	     request.setAttribute("map",mc);
	     request.setAttribute("imgmap",imgmap);
	     request.setAttribute("tpath",filetime);
	     String ptime = null;
	     if(pmap.get("pdfuptime")!=null&&!pmap.get("pdfuptime").equals("")){
	    	ptime=creditutil.timetofile(pmap.get("pdfuptime").toString());
	     }	   
	     if(mc.get("mdid")!=null){
	    	Map km= khgsservice.fkhbyid(Integer.parseInt(mc.get("mdid").toString()));
	    	if(km.get("khgsname")!=null&&!km.get("khgsname").equals("")){
	    		request.setAttribute("gsname",km.get("khgsname"));
	    	}else{
	    		request.setAttribute("gsname",km.get(""));
	    	}
            if(km.get("khrname")!=null&&!km.get("khrname").equals("")){
            	request.setAttribute("ryname",km.get("khrname"));
	    	}else{
	    		request.setAttribute("ryname",km.get(""));
	    	}	
	     }	    
	     request.setAttribute("pmap",pmap);
	     request.setAttribute("ptime",ptime);
	     request.setAttribute("name",name);
	     if(api!=null){
	    	 request.setAttribute("api",api); 
	     }else{
	    	 request.setAttribute("api",""); 
	     }
	     if(imgpath!=null){
	    	 request.setAttribute("imgpath",imgpath); 
	     }else{
	    	 request.setAttribute("imgpath",""); 
	     }
	     return "sh";				 		 		 
	 } 
	 
	//待审核查询
		 @RequestMapping(value="/listtable.do",produces="text/html;charset=UTF-8")
		 public String listtable(HttpServletRequest request){
			String pageNow =request.getParameter("pagenow");//当前页
		    String size = request.getParameter("size");//每页显示条数
		    //String sum_bit =request.getParameter("num");//每页显示条数
		   // System.out.println(sum_bit);
		    List<credit> clist=new ArrayList<>();
		    Page page =null;
		    int totalCount;//总数
		    int s;//每页显示条数
		    int bit;
			if(size!=null){
				s=Integer.parseInt(size);
				}else {
				s=10;	
				}

		    totalCount=creditservice.countnum("4");				   
		    if (pageNow!=null) {				
				//System.out.println(0);
				page = new Page(totalCount,Integer.parseInt(pageNow),s);
				clist=this.creditservice.ztlist("4",page.getStartPos(), page.getPageSize());
			
			} else {
				System.out.println(1);
				page = new Page(totalCount,1,s);
				//System.out.println(page.getStartPos()+"----"+page.getPageSize());
				clist=this.creditservice.ztlist("4",page.getStartPos(), page.getPageSize());
			
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
	    	request.setAttribute("clist", clist);			 
			return "dshcedittable";		 		 		 		 
		 }
	 
	 //待审核查询
	 @RequestMapping(value="/dshlist.do",produces="text/html;charset=UTF-8")
	 public String dshlist(HttpServletRequest request){
		String pageNow = request.getParameter("pagenow");//当前页
	    String size = request.getParameter("size");//每页显示条数	
	    List<credit> clist=new ArrayList<>();
	    Page page =null;
	    int totalCount;//总数
	    int s;//每页显示条数
	    totalCount=creditservice.dshcount();
		if(size!=null){
			s=Integer.parseInt(size);
			}else {
			s=10;	
			}			   
	    if (pageNow!=null) {				
			//System.out.println(0);
			page = new Page(totalCount,Integer.parseInt(pageNow),s);
			 clist=this.creditservice.dshtable(page.getStartPos(), page.getPageSize());
		
		} else {
			System.out.println(1);
			page = new Page(totalCount,1,s);
			//System.out.println(page.getStartPos()+"----"+page.getPageSize());
			clist=this.creditservice.dshtable(page.getStartPos(), page.getPageSize());
		
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
    	request.setAttribute("clist", clist);
    	request.setAttribute("name","dshlist.do");
		 return "dshcedittable";		 		 		 		 
	 }
	 //回退
	 @RequestMapping(value="/htlist.do",produces="text/html;charset=UTF-8")
	 public String htlist(HttpServletRequest request){
		String pageNow = request.getParameter("pagenow");//当前页
	    String size = request.getParameter("size");//每页显示条数
	    List<credit> clist=new ArrayList<>();
	    
	    Page page =null;
	    int totalCount;//总数
	    int s;//每页显示条数
	    totalCount=creditservice.htcount();
		if(size!=null){
			s=Integer.parseInt(size);
			}else {
			s=10;	
			}
		
	   
	    if (pageNow!=null) {				
			//System.out.println(0);
			page = new Page(totalCount,Integer.parseInt(pageNow),s);
			 clist=this.creditservice.httable(page.getStartPos(), page.getPageSize());
		
			 
		} else {
			System.out.println(1);
			page = new Page(totalCount,1,s);
			//System.out.println(page.getStartPos()+"----"+page.getPageSize());
			clist=this.creditservice.httable(page.getStartPos(), page.getPageSize());
		
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
    	request.setAttribute("clist", clist);
    	request.setAttribute("name", "htlist.do");
		return "htcedittable";		 		 		 		 
	 }
	 //完成
	 @RequestMapping(value="/elist.do",produces="text/html;charset=UTF-8")
	 public String elist(HttpServletRequest request){
		String pageNow = request.getParameter("pagenow");//当前页
	    String size = request.getParameter("size");//每页显示条数
	    List<credit> clist=new ArrayList<>();
	    Page page =null;
	    int totalCount;//总数
	    int s;//每页显示条数
	    totalCount=creditservice.ecount();
		if(size!=null){
			s=Integer.parseInt(size);
			}else {
			s=10;	
			}
		
	   
	    if (pageNow!=null) {				
			//System.out.println(0);
			page = new Page(totalCount,Integer.parseInt(pageNow),s);
			 clist=this.creditservice.etable(page.getStartPos(), page.getPageSize());		
		} else {
			System.out.println(1);
			page = new Page(totalCount,1,s);
			//System.out.println(page.getStartPos()+"----"+page.getPageSize());
			clist=this.creditservice.etable(page.getStartPos(), page.getPageSize());		
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
    	request.setAttribute("clist", clist);
    	request.setAttribute("name", "elist.do");
		return "ecedittable";		 		 		 		 
	 }
	 //大数据查询记录遍历
	 @RequestMapping(value="/dsjlist.do",produces="text/html;charset=UTF-8")
	 public String dsjlist(HttpServletRequest request){
		    String pageNow = request.getParameter("pagenow");//当前页
	    	String size = request.getParameter("size");//每页显示条数
	    	//System.out.println(pageNow+"------------"+size);
			Page page =null;
		  List<dsj> dlist=new ArrayList<>();
		  List<dsj> dsjlist=new ArrayList<>();
		  int s=0;
			if(size!=null){
			s=Integer.parseInt(size);
			}else {
			s=10;	
			}
			int totalCount =dsjservice.finddsjcount();
			if (pageNow!=null) {				
				//System.out.println(0);
				page = new Page(totalCount,Integer.parseInt(pageNow),s);
				dlist=this.dsjservice.finddsj(page.getStartPos(), page.getPageSize());	
				if(dlist!=null&&dlist.size()>0){
				
				for(int i=0;i<dlist.size();i++){
					dsj dsj=new dsj();
					dsj=dlist.get(i);
					Map km=khgsservice.fkhbyid(dsj.getKhid());
					if(km!=null&&km.size()>0){
						

					if(km.get("khgsname")!=null&&!km.get("khgsname").equals("")){
						dsj.setGsname(km.get("khgsname").toString());	
					}
					if(km.get("khrname")!=null&&!km.get("khrname").equals("")){
						dsj.setRyname(km.get("khrname").toString());
					}				
					}
					dsjlist.add(dsj);
				}
				
			}
			} else {
				pageNow="1";
				System.out.println(1);
				page = new Page(totalCount,1,s);
				//System.out.println(page.getStartPos()+"----"+page.getPageSize());
				dlist=this.dsjservice.finddsj(page.getStartPos(), page.getPageSize());
				if(dlist!=null&&dlist.size()>0){
				
				for(int i=0;i<dlist.size();i++){
					dsj dsj=new dsj();
					dsj=dlist.get(i);
					Map km=khgsservice.fkhbyid(dsj.getKhid());
					if(km!=null&&km.size()>0){

					if(km.get("khgsname")!=null&&!km.get("khgsname").equals("")){
						dsj.setGsname(km.get("khgsname").toString());	
					}
					if(km.get("khrname")!=null&&!km.get("khrname").equals("")){
						dsj.setRyname(km.get("khrname").toString());	
					}
					
				}
					
					dsjlist.add(dsj);
				}
			
			}
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
	    	request.setAttribute("dsjlist",dsjlist);
		 
		 return "bigdataall";
	
	 
	 }
	 
	 //审核更新
	 @RequestMapping(value="/editzxxx.do",produces="text/html;charset=UTF-8")
	 @ResponseBody
	 public String editzxxx(HttpServletRequest request,int id,String sum_bit,String shzt,String ly){
		 credit credit=new credit();
		 credit.setShzt(shzt);
		 credit.setSum_bit(sum_bit);
		 credit.setUp_time(creditutil.time());
		 credit.setId(id);
		 creditservice.editzx(credit);
		 history ht=new history();
		 if(ly!=null&&!ly.equals("")
				 ){
			 //System.out.println("----------------");
			 ht.setLy(ly);
			 ht.setZt(sum_bit);
			 ht.setUid(String.valueOf(id));
			 historyservice.hsava(ht);		 
		 }
		 
		 return "s";			 
		}
	 //根据客户公司名称查询信息
	 @RequestMapping(value="/khgszxxx.do",produces="text/html;charset=UTF-8")
    public String khgszxxx(HttpServletRequest request){
		 String khgsname=request.getParameter("khgsname");		 
		 String pageNow = request.getParameter("pagenow");
	     String size = request.getParameter("size");
	     int totalCount;
	     Page page =null;
         int mdid1;
			List<credit> credit = new ArrayList<credit>();
			int s=0;
			if(size!=null){
			s=Integer.parseInt(size);
			}else {
			s=10;	
			}			  
			if(khgsname!=null){
				  Map khgsmap=khgsservice.fgsrykhtoid(khgsname);
				  totalCount =creditservice.findcount1(Integer.parseInt(khgsmap.get("khid").toString()) );
		         //System.out.println("总数："+totalCount+"当前页数："+pageNow);
					if (pageNow!=null) {				
						//System.out.println(0);
						page = new Page(totalCount, Integer.parseInt(pageNow),s);
						credit=this.creditservice.findcredit1(Integer.parseInt(khgsmap.get("khid").toString()),page.getStartPos(), page.getPageSize());
					
					} else {
						//System.out.println(1);
						page = new Page(totalCount, 1,s);
						//System.out.println(page.getStartPos()+"----"+page.getPageSize());
						credit=this.creditservice.findcredit1(Integer.parseInt(khgsmap.get("khid").toString()),page.getStartPos(),page.getPageSize());
					
					}
			}else{				
			totalCount =creditservice.findcount();
         //System.out.println("总数："+totalCount+"当前页数："+pageNow);
			if (pageNow!=null) {				
				//System.out.println(0);
				page = new Page(totalCount, Integer.parseInt(pageNow),s);
				credit=this.creditservice.findcredit(page.getStartPos(), page.getPageSize());
			
			} else {
				//System.out.println(1);
				page = new Page(totalCount, 1,s);
				//System.out.println(page.getStartPos()+"----"+page.getPageSize());
				credit=this.creditservice.findcredit(page.getStartPos(),page.getPageSize());
			
			}
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
	    	request.setAttribute("credit", credit);
	    	request.setAttribute("khgsname",khgsname);
	    	
	     return "creditall";		 
	}
	 //搜索
	 @RequestMapping(value="/searchzxxx.do",produces="text/html;charset=UTF-8")
    public String searchzxxx(HttpServletRequest request,int id){
		 
		 
		 
		 
		return null;			 
	}
	
	 @RequestMapping(value="/alldd.do",produces="text/html;charset=UTF-8")
	 public String alldd(HttpServletRequest request){				 
		    String pageNow = request.getParameter("pagenow");
	    	String size = request.getParameter("size");
	    	//System.out.println(pageNow+"------------"+size);
			Page page =null;
            int mdid1;
			List<credit> credit = new ArrayList<credit>();
			int s=0;
			if(size!=null){
			s=Integer.parseInt(size);
			}else {
			s=10;	
			}			     
			int totalCount =creditservice.findcount();
            //System.out.println("总数："+totalCount+"当前页数："+pageNow);
			if (pageNow!=null) {				
				//System.out.println(0);
				page = new Page(totalCount, Integer.parseInt(pageNow),s);
				credit=this.creditservice.findcredit(page.getStartPos(), page.getPageSize());
			
			} else {
				System.out.println(1);
				page = new Page(totalCount, 1,s);
				//System.out.println(page.getStartPos()+"----"+page.getPageSize());
				credit=this.creditservice.findcredit(page.getStartPos(),page.getPageSize());
			
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
	    	request.setAttribute("credit", credit);
	    	request.setAttribute("name", "alldd.do");
	     return "creditall";				 		 		 
	 } 
	 
	//征信未审核页面  分页
	    @RequestMapping(value="/limit.do",produces = "text/html;charset=UTF-8")
	     private String limit(HttpServletRequest request) {
	    	String pageNow = request.getParameter("pagenow");
	    	String size = request.getParameter("size");
	    	String khgsname = request.getParameter("khgsname");
	    	System.out.println(pageNow+"------"+khgsname+"------"+size);
			Page page =null;
			List<gsrykh> klist=new ArrayList();;
			int  mdid1;
			int totalCount = 0;
			List<credit> credit = new ArrayList<credit>();
			int s=0;
			if(size!=null){
			s=Integer.parseInt(size);
			}else {
			s=10;	
			}
			if(khgsname!=null){
				klist=khgsservice.fgsrykhtoid1(khgsname);
				for(gsrykh k : klist){					
					int totalCount1 =creditservice.findcount1(k.getKhid());
					List<credit> cl=new ArrayList();
					if (pageNow!=null) {				
						//System.out.println(0);
						
						page = new Page(totalCount1,Integer.parseInt(pageNow),s);
						cl=this.creditservice.findcredit1(k.getKhid(),page.getStartPos(), page.getPageSize());
					
					} else {
						//System.out.println(1);
						page = new Page(totalCount1,1,s);
						//System.out.println(page.getStartPos()+"----"+page.getPageSize());
						cl=this.creditservice.findcredit1(k.getKhid(),page.getStartPos(),page.getPageSize());
					   
					}
					
					totalCount=totalCount1+totalCount;
					credit.addAll(cl);
				}
				
				
				
			}else{		
			totalCount =creditservice.findcount();
            //System.out.println("总数："+totalCount+"当前页数："+pageNow);
			if (pageNow!=null) {				
				//System.out.println(0);
				page = new Page(totalCount, Integer.parseInt(pageNow),s);
				credit=this.creditservice.findcredit(page.getStartPos(), page.getPageSize());
			
			} else {
				System.out.println(1);
				page = new Page(totalCount, 1,s);
				//System.out.println(page.getStartPos()+"----"+page.getPageSize());
				credit=this.creditservice.findcredit(page.getStartPos(),page.getPageSize());
			   
			}
			}
			int q=totalCount%s;
	    	int w=0;
	    	if(q==0){
	    		w=totalCount/s;
	    		
	    	}else{
	    		w=totalCount/s+1;
	    	}    		    
	    	request.setAttribute("w",w);
	    	request.setAttribute("pagenow",pageNow);
	    	request.setAttribute("size",s);
			request.setAttribute("totalCount",totalCount);
	    	request.setAttribute("credit", credit);
	    	request.setAttribute("khgsname",khgsname);
			return "creditnotaudit";


		}
	    @RequestMapping(value="/xg.do",produces = "text/html;charset=UTF-8")
	    public String xg(HttpServletRequest request,int id){
	    	Map  mc=new HashMap();
	    	mc=creditservice.findcreditbyid(id);
	    	request.setAttribute("map",mc);
			return "creditaudit"; 	
	    }
	  
	 
	 
	    //添加pdf结果
	    @RequestMapping(value="/addPDF.do",produces="text/html;charset=UTF-8")
	    public String addPDF(HttpServletRequest request,String uid,String name){
			
	    	request.setAttribute("uid", uid);
	    	request.setAttribute("name", name);
	    	
	    	return "addPDF";	
	    }
	    //添加pdf结果
	    @RequestMapping(value="/uppdf1.do",produces="multipart/form-data;charset=UTF-8")
	    public ModelAndView uppdf1(HttpServletRequest request,
	    		MultipartFile file,
	    		String uid,
	    		String name	    		
	    		){
	    	    pdfover p=new pdfover();
	    	 //String realPath =request.getSession().getServletContext().getRealPath("/image/upload");
	    	    System.out.println(uid+"-------"+name);
			    String fileName = file.getOriginalFilename();
			    UUID randomUUID = UUID.randomUUID();
 	   		 //获取文件的后缀名
 	   		    int i = fileName.lastIndexOf(".");
 	   		    String type=fileName.substring(i);	    	 	   			 	   			 
 	   			String uuidName = randomUUID.toString().replaceAll("-","")+type;
 	   		    pathutil pu=new pathutil();
			    String pathtype=pathutil.getPath();	    				
	 	   		//获取一个文件的保存路径
	 	   		String path = "/opt/javaimg/image/upload/"+creditutil.timefile()+"/"+uuidName;	
	 	   	    //将路径转化为文件夹 并 判断文件夹是否存在
				 File dir = new File("/opt/javaimg/image/upload/"+creditutil.timefile());
				 if(!dir.exists()){
				 dir.mkdirs();
				 }
	   			try {
	   				File spath=new File(path);
		   			spath.setWritable(true,false);	    		
					file.transferTo(spath);
					p.setPdfname(uuidName);
					p.setPdfuptime(creditutil.time());
					p.setPdfurl("http://apitest.kcway.net/image/upload/"+creditutil.timefile()+"/"+uuidName);
					p.setUid(uid);
					pdfservice.uppdf(p);					
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	 	   		
	    	return new ModelAndView("redirect:/tozximg.do?id="+uid+"&name="+name);
	    
	    
	    
	    }
	 
}
