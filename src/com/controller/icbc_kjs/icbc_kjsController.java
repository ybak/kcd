/**
 * 
 */
/**
 * @author Administrator
 *
 */
package com.controller.icbc_kjs;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.controller.icbc.jsp.icbcmodel;
import com.model.icbc.assess_cars;
import com.model.icbc.icbc;
import com.model.icbc.icbc_kk;
import com.model1.fs;
import com.model1.icbc.icbc_dk;
import com.model1.icbc.icbc_mq;
import com.service1.fsService;
import com.service1.car.icbc_carsService;
import com.service1.kjs_icbc.icbc_dkService;
import com.service1.kjs_icbc.icbc_mqService;
import com.service1.kjs_icbc.newicbcService;
import com.service1.kjs_icbc.newicbc_kkService;
import com.util.limitutil;

@Controller
public class icbc_kjsController{
	
	@Autowired
	private newicbcService newicbcService;
	@Autowired
	private fsService fService;
	@Autowired
	private icbc_carsService icbc_carsService;
	@Autowired
	private newicbc_kkService newicbc_kkService;
	
	
	@RequestMapping(value="/kjs_zx.do",produces = "text/html;charset=UTF-8")  
	public String kjs_zx(
			String size,//每页数量
 			String pagenow,//当前页数
 			String querytype,
 			String status,
 			String out,
 			String id,
 			String apg,
 			HttpServletRequest request
			){
		if(out!=null&&
	    		!out.equals("")
	    		&&out.equals("1")
	    		&&id!=null
	    		&&!id.equals("")
	    		){
	    	icbc ig=new icbc();
	    	ig.setId(Integer.parseInt(id));
	    	ig.setAdminop_tag(0);
	    	newicbcService.upicbc_tag(ig);
	    }
		int now;//当前页数
		if(pagenow!=null&&!pagenow.equals("")){
			now=Integer.parseInt(pagenow);
	        }else{
	        now=1;
	        }	
		int size1;//每页数量
		if(size!=null&&!size.equals("")){
			size1=Integer.parseInt(size);
	        }else{
	        size1=15;
	        }		
	int state=0;
	int qt=0;
	if( status!=null&&!status.equals("")){
		state=Integer.parseInt(status.replace("?v=4.0", ""));			
	}
	if(querytype!=null&&!querytype.equals("")){
		qt=Integer.parseInt(querytype.replace("?v=4.0", ""));
	}
	List list=new ArrayList<>();
	List<icbc> il=newicbcService.kjs_zx(state);
	List<icbc> icbcall=new ArrayList<>();
	if(il.size()>0){
		for(int i=0;i<il.size();i++){
			icbc icbc=il.get(i);
			
			Map map=icbcmodel.zx_status();
			if(icbc.getBc_status()==5){
				if(icbc.getTr_status()==1){
					icbc.setStatusname(map.get(7).toString());
				}else if(icbc.getTr_status()==2){
					icbc.setStatusname(map.get(8).toString());
				}else if(icbc.getTr_status()==3){
					icbc.setStatusname(map.get(9).toString());
				}else{
					icbc.setStatusname(map.get(5).toString());
				}
			}else{
				icbc.setStatusname(map.get(icbc.getBc_status()).toString());
			}
			icbcall.add(icbc);	
		}
		}
	list= limitutil.fy(icbcall,size1,now);	
	int q=icbcall.size()%size1;
	int totalpage=0;//总页数
	if(q==0){
		totalpage=icbcall.size()/size1;	    		
	}else{
		totalpage=icbcall.size()/size1+1;
	} 
	List<fs> fs=fService.findbypy();
	request.setAttribute("fs",fs);//商户店名称
	request.setAttribute("totalpage",totalpage);//总页数
	request.setAttribute("size",size1);//每页数量
	request.setAttribute("pagenow",now);//当前页
	request.setAttribute("totalno",icbcall.size());//总数量
	request.setAttribute("list",list);// 
	request.setAttribute("status",status);//
	request.setAttribute("querytype",querytype);//
	request.setAttribute("pagenow",now);//
	request.setAttribute("outid",id);//
	request.setAttribute("apg",apg);//
	return "cskjs_wzb/kjs_icbc_zx";
	}
	
	
	
	@RequestMapping(value="/kjs_pg.do",produces = "text/html;charset=UTF-8")  
	public String kjs_pg(
			String size,//每页数量
 			String pagenow,//当前页数
 			String querytype,
 			String status,
 			String out,
 			String id,
 			String apg,
 			HttpServletRequest request
			){
		if(out!=null&&
	    		!out.equals("")
	    		&&out.equals("1")
	    		&&id!=null
	    		&&!id.equals("")
	    		){
	    	icbc ig=new icbc();
	    	ig.setId(Integer.parseInt(id));
	    	ig.setAdminop_tag(0);
	    	newicbcService.upicbc_tag(ig);
	    }
		int now;//当前页数
		if(pagenow!=null&&!pagenow.equals("")){
			now=Integer.parseInt(pagenow);
	        }else{
	        now=1;
	        }	
		int size1;//每页数量
		if(size!=null&&!size.equals("")){
			size1=Integer.parseInt(size);
	        }else{
	        size1=15;
	        }		
	int state=0;
	int qt=0;
	if( status!=null&&!status.equals("")){
		state=Integer.parseInt(status.replace("?v=4.0", ""));			
	}
	if(querytype!=null&&!querytype.equals("")){
		qt=Integer.parseInt(querytype.replace("?v=4.0", ""));
	}
	List list=new ArrayList<>();
	List<assess_cars> il=icbc_carsService.kjs_pg(state);
	List<assess_cars> icbcall=new ArrayList<>();
	if(il.size()>0){
		for(int i=0;i<il.size();i++){
			assess_cars assess_cars=il.get(i);			
			Map map=icbcmodel.pg_status();
			assess_cars.setStatusname(map.get(assess_cars.getBc_status()).toString());
			icbcall.add(assess_cars);	
		}
		}
	list= limitutil.fy(icbcall,size1,now);	
	int q=icbcall.size()%size1;
	int totalpage=0;//总页数
	if(q==0){
		totalpage=icbcall.size()/size1;	    		
	}else{
		totalpage=icbcall.size()/size1+1;
	} 
	List<fs> fs=fService.findbypy();
	request.setAttribute("fs",fs);//商户店名称
	request.setAttribute("totalpage",totalpage);//总页数
	request.setAttribute("size",size1);//每页数量
	request.setAttribute("pagenow",now);//当前页
	request.setAttribute("totalno",icbcall.size());//总数量
	request.setAttribute("list",list);// 
	request.setAttribute("status",status);//
	request.setAttribute("querytype",querytype);//
	request.setAttribute("pagenow",now);//
	request.setAttribute("outid",id);//
	request.setAttribute("apg",apg);//
	return "cskjs_wzb/kjs_icbc_pg";
	}
	
	//开卡
	@RequestMapping(value="/kjs_kk.do",produces = "text/html;charset=UTF-8")  
	public String kjs_kk(
			String size,//每页数量
 			String pagenow,//当前页数
 			String querytype,
 			String status,
 			String out,
 			String id,
 			String apg,
 			HttpServletRequest request
			){
		if(out!=null&&
	    		!out.equals("")
	    		&&out.equals("1")
	    		&&id!=null
	    		&&!id.equals("")
	    		){
	    	icbc ig=new icbc();
	    	ig.setId(Integer.parseInt(id));
	    	ig.setAdminop_tag(0);
	    	newicbcService.upicbc_tag(ig);
	    }
		int now;//当前页数
		if(pagenow!=null&&!pagenow.equals("")){
			now=Integer.parseInt(pagenow);
	        }else{
	        now=1;
	        }	
		int size1;//每页数量
		if(size!=null&&!size.equals("")){
			size1=Integer.parseInt(size);
	        }else{
	        size1=15;
	        }		
	int state=0;
	int qt=0;
	if( status!=null&&!status.equals("")){
		state=Integer.parseInt(status.replace("?v=4.0", ""));			
	}
	if(querytype!=null&&!querytype.equals("")){
		qt=Integer.parseInt(querytype.replace("?v=4.0", ""));
	}
	List list=new ArrayList<>();
	List<icbc_kk> il=newicbc_kkService.kjs_kk(state);
	List<icbc_kk> icbcall=new ArrayList<>();
	if(il.size()>0){
		for(int i=0;i<il.size();i++){
			icbc_kk icbc_kk=il.get(i);			
			Map map=icbcmodel.kk_status();
			icbc_kk.setStatusname(map.get(icbc_kk.getBc_status()).toString());
			icbcall.add(icbc_kk);	
		}
		}
	list= limitutil.fy(icbcall,size1,now);	
	int q=icbcall.size()%size1;
	int totalpage=0;//总页数
	if(q==0){
		totalpage=icbcall.size()/size1;	    		
	}else{
		totalpage=icbcall.size()/size1+1;
	} 
	List<fs> fs=fService.findbypy();
	request.setAttribute("fs",fs);//商户店名称
	request.setAttribute("totalpage",totalpage);//总页数
	request.setAttribute("size",size1);//每页数量
	request.setAttribute("pagenow",now);//当前页
	request.setAttribute("totalno",icbcall.size());//总数量
	request.setAttribute("list",list);// 
	request.setAttribute("status",status);//
	request.setAttribute("querytype",querytype);//
	request.setAttribute("pagenow",now);//
	request.setAttribute("outid",id);//
	request.setAttribute("apg",apg);//
	return "cskjs_wzb/kjs_icbc_kk";
	}
	
	@Autowired
	private  icbc_dkService icbc_dkService; 
	    //贷款
		@RequestMapping(value="/kjs_dk.do",produces = "text/html;charset=UTF-8")  
		public String kjs_dk(
				String size,//每页数量
	 			String pagenow,//当前页数
	 			String querytype,
	 			String status,
	 			String out,
	 			String id,
	 			String apg,
	 			HttpServletRequest request
				){
			if(out!=null&&
		    		!out.equals("")
		    		&&out.equals("1")
		    		&&id!=null
		    		&&!id.equals("")
		    		){
		    	icbc ig=new icbc();
		    	ig.setId(Integer.parseInt(id));
		    	ig.setAdminop_tag(0);
		    	newicbcService.upicbc_tag(ig);
		    }
			int now;//当前页数
			if(pagenow!=null&&!pagenow.equals("")){
				now=Integer.parseInt(pagenow);
		        }else{
		        now=1;
		        }	
			int size1;//每页数量
			if(size!=null&&!size.equals("")){
				size1=Integer.parseInt(size);
		        }else{
		        size1=15;
		        }		
		int state=0;
		int qt=0;
		if( status!=null&&!status.equals("")){
			state=Integer.parseInt(status.replace("?v=4.0", ""));			
		}
		if(querytype!=null&&!querytype.equals("")){
			qt=Integer.parseInt(querytype.replace("?v=4.0", ""));
		}
		List list=new ArrayList<>();
		List<icbc_dk> il=icbc_dkService.kjs_dk(state);
		List<icbc_dk> icbcall=new ArrayList<>();
		if(il.size()>0){
			for(int i=0;i<il.size();i++){
				icbc_dk icbc_dk=il.get(i);			
				Map map=icbcmodel.qcdk_status();
				icbc_dk.setStatusname(map.get(icbc_dk.getBc_status()).toString());
				icbcall.add(icbc_dk);	
			}
			}
		list= limitutil.fy(icbcall,size1,now);	
		int q=icbcall.size()%size1;
		int totalpage=0;//总页数
		if(q==0){
			totalpage=icbcall.size()/size1;	    		
		}else{
			totalpage=icbcall.size()/size1+1;
		} 
		List<fs> fs=fService.findbypy();
		request.setAttribute("fs",fs);//商户店名称
		request.setAttribute("totalpage",totalpage);//总页数
		request.setAttribute("size",size1);//每页数量
		request.setAttribute("pagenow",now);//当前页
		request.setAttribute("totalno",icbcall.size());//总数量
		request.setAttribute("list",list);// 
		request.setAttribute("status",status);//
		request.setAttribute("querytype",querytype);//
		request.setAttribute("pagenow",now);//
		request.setAttribute("outid",id);//
		request.setAttribute("apg",apg);//
		return "cskjs_wzb/kjs_icbc_dk";
		}
		@Autowired
		private  icbc_mqService icbc_mqService; 
		
	    //面签
		@RequestMapping(value="/kjs_mq.do",produces = "text/html;charset=UTF-8")  
		public String kjs_mq(
				String size,//每页数量
	 			String pagenow,//当前页数
	 			String querytype,
	 			String status,
	 			String out,
	 			String id,
	 			String apg,
	 			HttpServletRequest request
				){
			if(out!=null&&
		    		!out.equals("")
		    		&&out.equals("1")
		    		&&id!=null
		    		&&!id.equals("")
		    		){
		    	icbc ig=new icbc();
		    	ig.setId(Integer.parseInt(id));
		    	ig.setAdminop_tag(0);
		    	newicbcService.upicbc_tag(ig);
		    }
			int now;//当前页数
			if(pagenow!=null&&!pagenow.equals("")){
				now=Integer.parseInt(pagenow);
		        }else{
		        now=1;
		        }	
			int size1;//每页数量
			if(size!=null&&!size.equals("")){
				size1=Integer.parseInt(size);
		        }else{
		        size1=15;
		        }		
		int state=0;
		int qt=0;
		if( status!=null&&!status.equals("")){
			state=Integer.parseInt(status.replace("?v=4.0", ""));			
		}
		if(querytype!=null&&!querytype.equals("")){
			qt=Integer.parseInt(querytype.replace("?v=4.0", ""));
		}
		List list=new ArrayList<>();
		List<icbc_mq> il=icbc_mqService.kjs_mq(state);
		List<icbc_mq> icbcall=new ArrayList<>();
		if(il.size()>0){
			for(int i=0;i<il.size();i++){
				icbc_mq icbc_mq=il.get(i);			
				Map map=icbcmodel.mq_status();
				icbc_mq.setStatusname(map.get(icbc_mq.getBc_status()).toString());
				icbcall.add(icbc_mq);	
			}
			}
		list= limitutil.fy(icbcall,size1,now);	
		int q=icbcall.size()%size1;
		int totalpage=0;//总页数
		if(q==0){
			totalpage=icbcall.size()/size1;	    		
		}else{
			totalpage=icbcall.size()/size1+1;
		} 
		List<fs> fs=fService.findbypy();
		request.setAttribute("fs",fs);//商户店名称
		request.setAttribute("totalpage",totalpage);//总页数
		request.setAttribute("size",size1);//每页数量
		request.setAttribute("pagenow",now);//当前页
		request.setAttribute("totalno",icbcall.size());//总数量
		request.setAttribute("list",list);// 
		request.setAttribute("status",status);//
		request.setAttribute("querytype",querytype);//
		request.setAttribute("pagenow",now);//
		request.setAttribute("outid",id);//
		request.setAttribute("apg",apg);//
		return "cskjs_wzb/kjs_icbc_mq";
		}
		
		//待审数量
		@RequestMapping(value="/kjs_count.do")  
		@ResponseBody
		public int kjs_count(){
			int count= newicbcService.kjs_zx_count();
			System.out.println(count);
			return count;
		} 
		//待审数量
				@RequestMapping(value="/kjs_cars_count.do")  
				@ResponseBody
				public int kjs_cars_count(){
					int count=icbc_carsService.kjs_pg_count();
					return count;
				} 
				//待审数量
				@RequestMapping(value="/kjs_mq_count.do")  
				@ResponseBody
				public int kjs_mq_count(){
					int count= icbc_mqService.kjs_mq_count();
					return count;
				} 
				//待审数量
				@RequestMapping(value="/kjs_kk_count.do")  
				@ResponseBody
				public int kjs_kk_count(){
					int count= newicbc_kkService.kjs_kk_count();
					return count;
				} 
				//待审数量
				@RequestMapping(value="/kjs_dk_count.do")  
				@ResponseBody
				public int kjs_dk_count(){
					int count= icbc_dkService.kjs_dk_count();
					return count;
				} 
}