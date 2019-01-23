package com.controller.icbc.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.controller.icbc.util.Jdpush;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.model.credit;
import com.model.icbc.assess_cars;
import com.model.icbc.assess_cars_item;
import com.model.icbc.bclient_check;
import com.model.icbc.icbc;
import com.model.icbc.icbc_kk;
import com.model.icbc.icbc_preaudit;
import com.model.icbc.icbc_result;
import com.model.icbc.icbc_zx;
import com.model.jbapi.jbzxapiuser;
import com.model1.admin;
import com.model1.carmodel;
import com.model1.fs;
import com.model1.city.citys;
import com.model1.city.states;
import com.model1.icbc.icbc_dk;
import com.model1.icbc.icbc_mq;
import com.model1.icbc.icbc_mq_result;
import com.model1.money.moneyfs;
import com.model1.money.moneyfs_1;
import com.model1.send.admin_msg;
import com.service.icbc.icbc_kkService;
import com.service.zx.jbzxapiuserService;
import com.service1.adminService;
import com.service1.fsService;
import com.service1.car.icbc_carsService;
import com.service1.car.icbc_cars_resultService;
import com.service1.car.newassess_cars_itemService;
import com.service1.duoying.carmodelService;
import com.service1.duoying.fsdyService;
import com.service1.kjs_icbc.citysService;
import com.service1.kjs_icbc.icbc_dkService;
import com.service1.kjs_icbc.icbc_mqService;
import com.service1.kjs_icbc.icbc_mq_resultService;
import com.service1.kjs_icbc.icbc_result1Service;
import com.service1.kjs_icbc.newicbcService;
import com.service1.kjs_icbc.newicbc_kkService;
import com.service1.kjs_icbc.newicbc_preauditService;
import com.service1.kjs_icbc.statesService;
import com.service1.money.moneyfs_1Service;
import com.service1.send.admin_msgService;
import com.service1.money.moneyfsService;
import com.util.creditutil;
import com.util.jsonutil;
import com.util.limitutil;

@Controller
public class newicbcController {
	private static final String appKey ="7e21faf06524b22f0ee1414c"; 
	private static final String masterSecret = "c87361ae4d7d91067b3ea01a";
	 @Autowired
	 private newicbcService newicbcService;
	 @Autowired
	 private jbzxapiuserService jbzxapiuserService;
	 @Autowired
	 private icbc_result1Service icbc_result1Service;
	 @Autowired
	 private moneyfs_1Service moneyfs_1Service;
	 @Autowired
	 private moneyfsService moneyfsService;
	 @Autowired
	 private fsService fsService;
	 @Autowired
	 private newicbc_preauditService newicbc_preauditService;
	 @Autowired
	 private carmodelService carmodelService;
	 @Autowired
	 private newicbc_kkService 	 newicbc_kkService;
	 @Autowired
	 private citysService citysService;
	 @Autowired
	 private statesService statesService;
	 @Autowired
	 private icbc_dkService icbc_dkService;
	 @Autowired
	 private icbc_carsService icbc_carsService;
	 @Autowired
	 private icbc_cars_resultService icbc_cars_resultService;
	 @Autowired
	 private newassess_cars_itemService newassess_cars_itemService;
	 @Autowired
	 private admin_msgService admin_msgService;
//	 $(document).ready(function(){
//			var obj=document.getElementById('carid'); 
//				  $.ajax({
//				   type: "post",
//				   dataType: "json",
//				   url: "carmodel.do",
//				   success: function(msg){
//				    var data1 =msg 
//				    str="";
//				    $.each(data1,function(index, n){
//				    	var name= data1[index].name;		    	
//				    	var id=data1[index].id;
//				    obj.options.add(new Option(name,id));	
//				    })
//				   }		    
//		});
//		});
	 @Autowired
	 private icbc_mq_resultService icbc_mq_resultService;
	 
	 @Autowired
	 private icbc_mqService icbc_mqService;
	 @RequestMapping(value="/icbc_sp_sh.do")
	 public String icbc_sp_sh(int icbc_id,
			 String querytype,
			 String size,
			 String status,
			 String icbc_type,			 
			 HttpServletResponse response,
			 HttpServletRequest request
			 ){		
		 icbc icbc=newicbcService.findicbcbyid(icbc_id);
	     icbc itag=new icbc();	 
	     if(icbc!=null&&!icbc.equals("")){
	    	 if(icbc.getAdminop_tag()!=1){
	  		   itag.setAdminop_tag(1);	 
	  		   itag.setId(icbc.getId());
	  		   newicbcService.upicbc_tag(itag); 	 
	           } 
	     }
		    icbc_mq icbc_mq=icbc_mqService.findmqbyicbc(icbc_id);
		    List<icbc_mq_result> iml = null;
		    if(icbc_mq!=null&&!icbc_mq.equals("")){
		    iml=icbc_mq_resultService.findicbc_mq_result(icbc_mq.getId());		   
		       for(int i=0;i<iml.size();i++){
		    	   icbc_mq_result iMq_result= iml.get(i);
		    	   Map map=icbcmodel.mq_status();
		    	   iMq_result.setRemarkstatus(map.get(iMq_result.getStatus()).toString());
		       }
		    }  
		    request.setAttribute("iml",iml);
		    request.setAttribute("remark",icbcmodel.mq_status());
		    request.setAttribute("icbc_mq",icbc_mq);	
		    request.setAttribute("querytype",querytype);	
		    request.setAttribute("size",size);
		    request.setAttribute("status",status);
		    request.setAttribute("icbc_type",icbc_type);
		    request.setAttribute("id",icbc_id);
			return "cskjs_wzb/kjs_icbcsh"; 
	 }
	 @RequestMapping(value="/icbc_sp_up.do",produces = "text/html;charset=UTF-8")
	 public void icbc_sp_up(int id,
			 int adminid,
			 int bc_status,
			 String remark,
			 HttpServletResponse response,
			 HttpServletRequest request
			 ){
		 icbc_mq iMq=new icbc_mq();
		 iMq.setBc_status(bc_status);
		 iMq.setDt_edit(creditutil.time());
		 iMq.setMid_edit(adminid);
		 iMq.setId(id);
		 icbc_mqService.upmq(iMq);
		 icbc_mq_result iMq_result=new icbc_mq_result();
		 iMq_result.setDt_add(creditutil.time());
		 iMq_result.setDt_edit(creditutil.time());
		 iMq_result.setMid_add(adminid);
		 iMq_result.setMid_edit(adminid);
		 iMq_result.setQryid(iMq.getId());
		 Map map=icbcmodel.mq_status();
		 if(remark!=null&&!remark.equals("")){
			 iMq_result.setRemark(remark);
			}else{			
				 
				 if(bc_status==1||bc_status==0){
					 iMq_result.setRemark(map.get(1).toString());	 
				 }else{
					 iMq_result.setRemark(map.get(bc_status).toString());
				 }
			}		
		 iMq_result.setStatus(bc_status);
		 icbc_mq_resultService.addmq_result(iMq_result);
		    icbc_mq icbc_mq=icbc_mqService.findmqbyid(id);
		    icbc icbc=newicbcService.findicbcbyid(icbc_mq.getIcbc_id());
		    //更新icbc 时间
			icbc icbc2=new icbc();
			icbc2.setId(icbc_mq.getIcbc_id());
			icbc2.setDt_edit(creditutil.time());
			newicbcService.upicbc(icbc2);
			
			admin admin1=adminService.adminbyid(icbc_mq.getMid_add());
			if(admin1!=null&&!admin1.equals("")){
			String REGISTRATION_ID=admin1.getJgid();
			String mString=admin1.getName()
			 +"您好!"
			 +"客户名称为"
			 +icbc.getC_name()+"的审核已更新"
			 +";视频面签状态:"+map.get(icbc_mq.getBc_status())
			 +";留言:"+iMq_result.getRemark()
			 +"时间:"+creditutil.time()+";";
			if(REGISTRATION_ID!=null&&!REGISTRATION_ID.equals("")){
			Jdpush.testSendPush(appKey,masterSecret,REGISTRATION_ID,mString);	
			}	
			admin_msg admin_msg=new admin_msg();
			admin_msg.setDt_add(creditutil.time());
			admin_msg.setDt_edit(creditutil.time());
			admin_msg.setMid_add(adminid);
			admin_msg.setMsg(mString);
			admin_msg.setReceiveid(admin1.getId());
			admin_msg.setSendid(0);
			admin_msg.setStatus(0);
			admin_msgService.addadmin_msg(admin_msg);
			}
	 }
	 
	 
	 @RequestMapping(value="/icbc_cars.do",produces = "text/html;charset=UTF-8")
	 public void icbc_cars(int id,
			 int adminid,
			 int bc_status,
			 String remark,
			 String price_result,
			 int color_id,
			 int mem_states,
			 int mem_citys,
			 int car_km_icbc,
			 int  source_id,
			 String vincode,
			 int property_id,
			 String cardt1,
			 String cardt2,
			 int gear_box_id,
			 int car_status,
			 String icbc_pricecs,
			 int price_new,
			 int brid,
			 int seid,
			 int carid,
			 String  carno,
			 String ppxh,
			 String motorcode,
			 HttpServletResponse response,
			 HttpServletRequest request
			 ) throws IOException{
            assess_cars assess_cars=new assess_cars();
            assess_cars.setId(id);
            assess_cars.setColor_id(color_id);
            assess_cars.setMem_states(mem_states);
            assess_cars.setMem_citys(mem_citys);
            assess_cars.setCar_km_icbc(car_km_icbc);
            assess_cars.setSource_id(source_id);
            assess_cars.setVincode(vincode);
            assess_cars.setProperty_id(property_id);
            assess_cars.setCardt1(cardt1);
            assess_cars.setCardt2(cardt2);
            assess_cars.setCar_status(car_status);
            assess_cars.setIcbc_pricecs(Float.parseFloat(icbc_pricecs));
            assess_cars.setPrice_new(price_new);
            assess_cars.setBrid(brid);
            assess_cars.setSeid(seid);
            assess_cars.setCarid(carid);
            assess_cars.setC_carno(carno);
            assess_cars.setPpxh(ppxh);
            assess_cars.setMotorcode(motorcode);
            assess_cars.setGear_box_id(gear_box_id);
            //assess_cars.setMem_id(adminid);
            admin admin=adminService.adminbyid(adminid);
            //assess_cars.setMem_name(admin.getName());
            //assess_cars.setMem_tel(admin.getTel());
            assess_cars.setDt_edit(creditutil.time());
            int price=0;
            if(price_result!=null&&!price_result.equals("")){            	
            	price=Integer.parseInt(price_result);           
            }
            assess_cars.setPrice_result(price);            
            assess_cars.setBc_status(bc_status);
            icbc_carsService.upicbc_cars(assess_cars);
            bclient_check bclient_check=new bclient_check();
            bclient_check.setDt_add(creditutil.time());
            bclient_check.setDt_edit(creditutil.time());
            bclient_check.setAssessid(id);
            Map map=icbcmodel.pg_status();
			if(remark!=null&&!remark.equals("")){
				bclient_check.setRemark(remark);
			}else{
			  
			 if(bc_status==1||bc_status==0){
				 bclient_check.setRemark(map.get(1).toString());	 
			 }else{
				 bclient_check.setRemark(map.get(bc_status).toString());
			 }
			 
			}
			bclient_check.setStatus(bc_status);
			if(bc_status==3){
				bclient_check.setMid_add(adminid);
				bclient_check.setMid_edit(adminid);
			}
			icbc_cars_resultService.addbclient_check(bclient_check);	
			assess_cars aCars=icbc_carsService.findcarsbyid(id);
			icbc icbc=newicbcService.findicbcbyid(aCars.getIcbc_id());
			//更新icbc 时间
			icbc icbc2=new icbc();
			icbc2.setId(aCars.getIcbc_id());
			icbc2.setDt_edit(creditutil.time());
			newicbcService.upicbc(icbc2);
			
			admin admin1=adminService.adminbygems_id(aCars.getGems_id());
			if(admin1!=null&&!admin1.equals("")){
			String REGISTRATION_ID=admin1.getJgid();
			String mString=admin1.getName()
			 +"您好!"
			 +"客户名称为"
			 +icbc.getC_name()+"的审核已更新"
			 +";评估状态:"+map.get(aCars.getBc_status())
			 +";留言:"+bclient_check.getRemark()
			 +"时间:"+creditutil.time()+";";
			if(REGISTRATION_ID!=null&&!REGISTRATION_ID.equals("")){
			Jdpush.testSendPush(appKey,masterSecret,REGISTRATION_ID,mString);	
			}	
			admin_msg admin_msg=new admin_msg();
			admin_msg.setDt_add(creditutil.time());
			admin_msg.setDt_edit(creditutil.time());
			admin_msg.setMid_add(adminid);
			admin_msg.setMsg(mString);
			admin_msg.setReceiveid(admin1.getId());
			admin_msg.setSendid(0);
			admin_msg.setStatus(0);
			admin_msgService.addadmin_msg(admin_msg);
			}
	 }
	 
	 @RequestMapping(value="/icbc_cars_sh.do")
	 public String icbc_cars_sh(int icbc_id,
			 String querytype,
			 String size,
			 String status,
			 String icbc_type,			 
			 HttpServletResponse response,
			 HttpServletRequest request
			 ){
		 System.out.println("ssssssssss"+icbc_id);
		 icbc icbc=newicbcService.findicbcbyid(icbc_id);
	     icbc itag=new icbc();	 
	     if(icbc!=null&&!icbc.equals("")){
	    	 if(icbc.getAdminop_tag()!=1){
	  		   itag.setAdminop_tag(1);	 
	  		   itag.setId(icbc.getId());
	  		   newicbcService.upicbc_tag(itag); 	 
	           } 
	     }
		    List<bclient_check> bList = null;
		    List<assess_cars_item> aItems = null;
		    citys citys = null;
		    states states = null;
		    assess_cars assess_cars = null;		    
		assess_cars=icbc_carsService.findicbc_cars(icbc_id);
		carmodel carmodel = null;
	    if(assess_cars!=null&&!assess_cars.equals("")){
	    	bList=icbc_cars_resultService.findicbc_cars(assess_cars.getId());
	    	
	    	aItems=newassess_cars_itemService.findicbc_carsimg(assess_cars.getId());
	    	System.out.println(aItems.size()+"----"+assess_cars.getId());
	    	if(aItems.size()>0){
	    		for(int i=0;i<aItems.size();i++){
		    		assess_cars_item aci=aItems.get(i);
		    		Map map=icbcmodel.icbcpg();
		    		if(aci.getPoints_id()<=20){
		    			aci.setName(map.get(aci.getPoints_id()).toString()); 	
		    		}
		    			    		
		    	}
	    	}
	    	for(int i1=0;i1<bList.size();i1++){
	    		bclient_check bc=bList.get(i1);
	    		Map map=icbcmodel.pg_status();	    		
	    		bc.setStatusremark(map.get(bc.getStatus()).toString()); 	
	    	}
	    	citys=citysService.findcitys(assess_cars.getMem_citys());
	    	states=statesService.findstates(assess_cars.getMem_states());
	    	carmodel=carmodelService.findcarbyid(assess_cars.getCarid());
	    }		
	    //carmodellist=carmodelService.findcarmodel();
	    //request.setAttribute("carmodellist",carmodellist);
	    request.setAttribute("icbcpg",icbcmodel.icbcpg());
	    request.setAttribute("remark",icbcmodel.pg_status());
	    request.setAttribute("citys",citys);
	    request.setAttribute("states",states);
	    request.setAttribute("bList",bList);
	    request.setAttribute("aItems",aItems); 
	    request.setAttribute("assess_cars",assess_cars);
	    request.setAttribute("querytype",querytype);	
	    request.setAttribute("carmodel",carmodel);
	    request.setAttribute("size",size);
	    request.setAttribute("status",status);
	    request.setAttribute("icbc_type",icbc_type);
	    request.setAttribute("id",icbc_id);
		return "cskjs_wzb/kjs_icbcsh"; 
	 }
	 
	 /**
	  * 
	  * @param response
	  * @param request
	  * @return
	  */
	 @RequestMapping(value="/carmodel.do",produces = "text/html;charset=UTF-8")
	 @ResponseBody
	 public String carmodel(			 
			 HttpServletResponse response,
			 HttpServletRequest request
			 ){
	  List<carmodel> carmodellist =carmodelService.findcarmodel();	 		 
	  return jsonutil.toJSONString(carmodellist);
	 }		 
	 @RequestMapping(value="/kk_up.do",produces = "text/html;charset=UTF-8")
	 public void kk_up(
			 icbc_kk icbc_kk,
			 HttpServletResponse response,
			 HttpServletRequest request
			 ) throws IOException{  
		    System.out.println("*****"+jsonutil.toJSONString(icbc_kk));
//            icbc_kk.setId(id);
//            icbc_kk.setMid_edit(adminid);
//            icbc_kk.setDt_edit(creditutil.time());
//            icbc_kk.setBc_status(bc_status);
//            icbc_kk.setKk_kh(kk_kh);
            newicbc_kkService.upkk(icbc_kk);
		    icbc_result icbc_result=new icbc_result();
			icbc_result.setDt_add(creditutil.time());
			icbc_result.setDt_edit(creditutil.time());
			icbc_result.setQryid(icbc_kk.getId());
			 Map map=icbcmodel.kk_status();
			if(icbc_kk.getRemark()!=null&&!icbc_kk.getRemark().equals("")){
			icbc_result.setRemark(icbc_kk.getRemark());
			}else{
				
				 if(icbc_kk.getBc_status()==1||icbc_kk.getBc_status()==0){
					 icbc_result.setRemark(map.get(1).toString());	 
				 }else{
					 icbc_result.setRemark(map.get(icbc_kk.getBc_status()).toString());
				 }
			}
			icbc_result.setStatus(icbc_kk.getBc_status());
			if(icbc_kk.getBc_status()==3){
			icbc_result.setMid_add(icbc_kk.getAdminid());
			icbc_result.setMid_edit(icbc_kk.getAdminid());
			}
			icbc_result1Service.addkk_result(icbc_result);
			icbc_kk icbc_kk1=newicbc_kkService.findkkbyid(icbc_kk.getId());
			icbc icbc=newicbcService.findicbcbyid(icbc_kk1.getIcbc_id());
			//更新icbc 时间
			icbc icbc2=new icbc();
			icbc2.setId(icbc_kk1.getIcbc_id());
			icbc2.setDt_edit(creditutil.time());
			newicbcService.upicbc(icbc2);
			
			admin admin=adminService.adminbyid(icbc_kk1.getMid_add());
			if(admin!=null&&!admin.equals("")){
			String REGISTRATION_ID=admin.getJgid();
			String mString=admin.getName()
			 +"您好!"
			 +"客户名称为"
			 +icbc.getC_name()+"的审核已更新"
			 +";开卡状态:"+map.get(icbc_kk1.getBc_status())
			 +";留言:"+icbc_result.getRemark()
			 +"时间:"+creditutil.time()+";";
			if(REGISTRATION_ID!=null&&!REGISTRATION_ID.equals("")){
			Jdpush.testSendPush(appKey,masterSecret,REGISTRATION_ID,mString);	
			}	
			admin_msg admin_msg=new admin_msg();
			admin_msg.setDt_add(creditutil.time());
			admin_msg.setDt_edit(creditutil.time());
			admin_msg.setMid_add(icbc_kk.getAdminid());
			admin_msg.setMsg(mString);
			admin_msg.setReceiveid(admin.getId());
			admin_msg.setSendid(0);
			admin_msg.setStatus(0);
			admin_msgService.addadmin_msg(admin_msg);
			}
	 }
	 
	 @RequestMapping(value="/kk_sh.do")
	 public String kk_sh(int icbc_id,
			 String querytype,
			 String size,
			 String status,
			 String icbc_type,			 
			 HttpServletResponse response,
			 HttpServletRequest request
			 ){
		 icbc icbc=newicbcService.findicbcbyid(icbc_id);
	     icbc itag=new icbc();	 
	     if(icbc!=null&&!icbc.equals("")){
	    	 if(icbc.getAdminop_tag()!=1){
	  		   itag.setAdminop_tag(1);	 
	  		   itag.setId(icbc.getId());
	  		   newicbcService.upicbc_tag(itag); 	 
	           } 
	     }
	    icbc_kk icbc_kk=newicbc_kkService.findicbc_kkbyid(icbc_id);
	    List<icbc_result> iResults = null;
	    citys citys1 = null;
	    citys citys2 = null;
	    states states1 = null;
	    states states2 = null;
	    if(icbc_kk!=null&&!icbc_kk.equals("")){
		   iResults=icbc_result1Service.findkkbyqryid(icbc_kk.getId());  		   
		   for(int i=0;i<iResults.size();i++){
			icbc_result iResult=iResults.get(i);
			Map map=icbcmodel.kk_status();
			iResult.setStatusremark(map.get(iResult.getStatus()).toString());   
		   }
		   citys1=citysService.findcitys(icbc_kk.getKk_car_cityid());
		   citys2=citysService.findcitys(icbc_kk.getKk_loan_cityid());
		   states1=statesService.findstates(icbc_kk.getKk_car_stateid());
		   states2=statesService.findstates(icbc_kk.getKk_loan_stateid());
		   List<Object> imgs=new ArrayList<>();		 	   
		   imgs.add(icbc_kk.getImgstep3_1());
		   imgs.add(icbc_kk.getImgstep3_2());
		   imgs.add(icbc_kk.getImgstep3_3());
		   imgs.add(icbc_kk.getImgstep3_4());
		   imgs.add(icbc_kk.getImgstep3_5());
		   imgs.add(icbc_kk.getImgstep3_6());
		   imgs.add(icbc_kk.getImgstep3_71());
		   imgs.add(icbc_kk.getImgstep3_72());
		   imgs.add(icbc_kk.getImgstep3_7());
		   String[] imgss;
			  if(icbc_kk.getImgstep3_7s()!=null&&!icbc_kk.getImgstep3_7s().equals("")){
				  imgss=icbc_kk.getImgstep3_7s().split("");
				  if(imgss.length>0){
					 for(int i=0;i<imgss.length;i++){
						 if(imgss[i]!=null&&!imgss[i].equals("")){
							 imgs.add(imgss[i]);
						 }
					 }
				  }
			  } 
		request.setAttribute("imgs",imgs);
	    }	     
	    request.setAttribute("imgname",icbcmodel.icbckk());
	    //carmodellist=carmodelService.findcarmodel();
	    //request.setAttribute("carmodellist",carmodellist);
	    request.setAttribute("citys1",citys1);
	    request.setAttribute("citys2",citys2);
	    request.setAttribute("states1",states1);
	    request.setAttribute("states2",states2);
	    request.setAttribute("iResults",iResults);
	    request.setAttribute("icbc_kk",icbc_kk);
	    request.setAttribute("querytype",querytype);	 
	    request.setAttribute("size",size);
	    request.setAttribute("status",status);
	    request.setAttribute("icbc_type",icbc_type);
	    request.setAttribute("id",icbc_id);
		return "cskjs_wzb/kjs_icbcsh"; 
	 }
	 @RequestMapping(value="/fk_up.do",produces = "text/html;charset=UTF-8")
	 public void fk_up(
			 int id,
			 int fk_status,
			 HttpServletResponse response,
			 HttpServletRequest request
			 )throws IOException{     	
	       icbc icbc=new icbc();
	       icbc.setDt_edit(creditutil.time());
	       icbc.setFk_status(fk_status);
	       icbc.setId(id);
	       newicbcService.up_fk(icbc);
	       icbc icbc1=newicbcService.findicbcbyid(id);
	        icbc icbc2=new icbc();
			icbc2.setId(id);
			icbc2.setDt_edit(creditutil.time());
			newicbcService.upicbc(icbc2);
	       admin admin=adminService.adminbyid(icbc1.getMid_add());
	       String fk="";
	       if(fk_status==1){
	    	   fk="未垫资/放款";
	       }
	       if(fk_status==2){
	    	   fk="已垫资";
	       }
	       if(fk_status==3){
	    	   fk="已放款";
	       }
			if(admin!=null&&!admin.equals("")){				
			String REGISTRATION_ID=admin.getJgid();
			String c_name="xx";
			if(icbc1.getC_name()!=null&&!icbc1.getC_name().equals("")){
				c_name=icbc1.getC_name();
			}
			String mString=admin.getName()
			 +"您好!"
			 +"客户名称为"
			 +c_name+"的审核已更新"
			 +";放款状态:"+fk
			 +";"
			 +"时间:"+creditutil.time()+";";
			if(REGISTRATION_ID!=null&&!REGISTRATION_ID.equals("")){
			Jdpush.testSendPush(appKey,masterSecret,REGISTRATION_ID,mString);	
			}
			
			}
	       
	 }
	 
	 
	 @RequestMapping(value="/dk_up.do",produces = "text/html;charset=UTF-8")
	 public void dk_up(int id,
			 int adminid,
			 int bc_status,
			 String remark,
			 String name,
			 HttpServletResponse response,
			 HttpServletRequest request
			 ) throws IOException{
            icbc_dk icbc_dk=new icbc_dk();
            icbc_dk.setId(id);
            icbc_dk.setMid_edit(adminid);
            icbc_dk.setDt_edit(creditutil.time());
            icbc_dk.setBc_status(bc_status);
            icbc_dkService.updk(icbc_dk);
		    icbc_result icbc_result=new icbc_result();
			icbc_result.setDt_add(creditutil.time());
			icbc_result.setDt_edit(creditutil.time());
			icbc_result.setQryid(id);
			Map map=icbcmodel.qcdk_status();
			if(remark!=null&&!remark.equals("")){
			icbc_result.setRemark(remark);
			}else{
				 if(bc_status==1||bc_status==0){
					 icbc_result.setRemark(map.get(1).toString());	 
				 }else{
					 icbc_result.setRemark(map.get(bc_status).toString());
				 }
			}
			icbc_result.setStatus(bc_status);
			if(bc_status==3){
			icbc_result.setMid_add(adminid);
			icbc_result.setMid_edit(adminid);
			}
			icbc_result1Service.addcardk_result(icbc_result);
			icbc_dk icbc_dk2=icbc_dkService.finddkbyid(id);
			icbc icbc=newicbcService.findicbcbyid(icbc_dk2.getIcbc_id());
			icbc icbc1=new icbc();
			icbc1.setId(icbc_dk2.getIcbc_id());
			icbc1.setDt_edit(creditutil.time());
			newicbcService.upicbc(icbc1);
			admin admin=adminService.adminbyid(icbc_dk2.getMid_add());
			if(admin!=null&&!admin.equals("")){
			String REGISTRATION_ID=admin.getJgid();
			String mString=admin.getName()
			 +"您好!"
			 +"客户名称为"
			 +icbc.getC_name()+"的审核已更新"
			 +";贷款状态:"+map.get(icbc_dk2.getBc_status())
			 +";留言:"+icbc_result.getRemark()
			 +"时间:"+creditutil.time()+";";
			if(REGISTRATION_ID!=null&&!REGISTRATION_ID.equals("")){
			Jdpush.testSendPush(appKey,masterSecret,REGISTRATION_ID,mString);	
			}
			admin_msg admin_msg=new admin_msg();
			admin_msg.setDt_add(creditutil.time());
			admin_msg.setDt_edit(creditutil.time());
			admin_msg.setMid_add(adminid);
			admin_msg.setMsg(mString);
			admin_msg.setReceiveid(admin.getId());
			admin_msg.setSendid(0);
			admin_msg.setStatus(0);
			admin_msgService.addadmin_msg(admin_msg);
			}
	 }
	 @RequestMapping(value="/dk_sh.do")
	 public String dk_sh(int icbc_id,
			 String querytype,
			 String size,
			 String status,
			 String icbc_type,			 
			 HttpServletResponse response,
			 HttpServletRequest request
			 ){
	    icbc_dk icbc_dk=icbc_dkService.finddkbyorder(icbc_id);
	     icbc icbc=newicbcService.findicbcbyid(icbc_id);
	     icbc itag=new icbc();	 
	     if(icbc!=null&&!icbc.equals("")){
	    	 if(icbc.getAdminop_tag()!=1){
	  		   itag.setAdminop_tag(1);	 
	  		   itag.setId(icbc.getId());
	  		   newicbcService.upicbc_tag(itag); 	 
	           } 
	     }	    
	    List<icbc_result> iResults = null;
	    if(icbc_dk!=null&&!icbc_dk.equals("")){
		   iResults=icbc_result1Service.findcardkbyqryid(icbc_dk.getId());  		   
	   String imgss=icbc_dk.getImgstep4_1ss()
			   +icbc_dk.getImgstep4_2ss()
			   +icbc_dk.getImgstep4_3ss()
			   +icbc_dk.getImgstep4_4ss()
			   +icbc_dk.getImgstep4_5ss();
	    String[] imgs1 = null;
		  if(imgss!=null&&!imgss.equals("")){
			  imgs1=imgss.split("");
			  if(imgs1.length>0){
				  request.setAttribute("imgs1",imgs1);
			  }
		  }
		String[] imgs2 = null; 	
		if(icbc_dk.getImgstep5_1ss()!=null&&!icbc_dk.getImgstep5_1ss().equals("")){
				  
			  imgs2=icbc_dk.getImgstep5_1ss().split("");
				  if(imgs2.length>0){
					  request.setAttribute("imgs2",imgs2);
			 }
		 }
		String[] imgs3 = null; 	
		if(icbc_dk.getImgstep6_1ss()!=null&&!icbc_dk.getImgstep6_1ss().equals("")){
				  
			  imgs3=icbc_dk.getImgstep6_1ss().split("");
				  if(imgs3.length>0){
					  request.setAttribute("imgs3",imgs3);
			 }
		 }
		String[] imgs4 = null; 	
		if(icbc_dk.getImgstep7_1ss()!=null&&!icbc_dk.getImgstep7_1ss().equals("")){				  
			  imgs4=icbc_dk.getImgstep7_1ss().split("");
				  if(imgs4.length>0){
					  request.setAttribute("imgs4",imgs4);
			 }
		 }

	    }
	    //carmodellist=carmodelService.findcarmodel();
	    //request.setAttribute("carmodellist",carmodellist);
	    request.setAttribute("iResults",iResults);
	    request.setAttribute("icbc_dk",icbc_dk);
	    request.setAttribute("querytype",querytype);	 
	    request.setAttribute("size",size);
	    request.setAttribute("status",status);
	    request.setAttribute("icbc_type",icbc_type);
	    request.setAttribute("id",icbc_id);
		return "cskjs_wzb/kjs_icbcsh"; 
	 }
	 @RequestMapping(value="/icbcno.do")
	 @ResponseBody
	 public int icbcno(){
		List<icbc> iList=newicbcService.findicbc(0,2); 
	    return iList.size(); 
	 }
	 
	 @RequestMapping(value="/upicbc.do",produces = "text/html;charset=UTF-8")
	 public void upicbc(icbc icbc,			 
			 HttpServletRequest request,HttpServletResponse response){
		 icbc itag=new icbc();		 
		 itag.setAdminop_tag(0);	 
		 itag.setId(icbc.getId());
		 newicbcService.upicbc_tag(itag); 
		//System.out.println(jsonutil.toJSONString(icbc));
//		if(icbc.getName1()!=null
//				&&icbc.getName1()!=""
//				&&icbc.getName2()!=null
//				&&icbc.getName2()!=""
//				&&icbc.getName3()!=null
//				&&icbc.getName3()!=""){
//		icbc.setC_name_mts(""+icbc.getName1()+""+icbc.getName2()+""+icbc.getName3());	
//		}
//		if(icbc.getTel1()!=null
//				&&icbc.getTel1()!=""
//				&&icbc.getTel2()!=null
//				&&icbc.getTel2()!=""
//				&&icbc.getTel3()!=null
//				&&icbc.getTel3()!=""){
//			icbc.setC_tel_mts(""+icbc.getTel1()+""+icbc.getTel2()+""+icbc.getTel3());	
//		}
//		if(icbc.getCardno1()!=null
//				&&icbc.getCardno1()!=""
//				&&icbc.getCardno2()!=null
//				&&icbc.getCardno2()!=""
//				&&icbc.getCardno3()!=null
//				&&icbc.getCardno3()!=""){
//			icbc.setC_cardno_mts(""+icbc.getCardno1()+""+icbc.getCardno2()+""+icbc.getCardno3());	
//		}				
		icbc.setDt_edit(creditutil.time());
		if(icbc.getZx_result()!=null&&!icbc.getZx_result().equals("")){
		icbc.setZx_result(remove(icbc.getZx_result(),' '));
		icbc.setDt_zxresult(creditutil.time());
		}else{
		icbc.setZx_result(icbc.getZx_result().replace(" ",""));
		}
		if(icbc.getBc_status()==3){
		icbc.setDt_fin(creditutil.time()); 
		}
		if(icbc.getBc_status()==6){			
			icbc_dk icbc_dk=icbc_dkService.finddkbyorder(icbc.getId());
			if(icbc_dk!=null&&!icbc_dk.equals("")){
				icbc_dk icbc_dk1=new icbc_dk();
				icbc_dk.setId(icbc_dk.getId());
	            icbc_dk.setMid_edit(icbc.getAdminid());
	            icbc_dk.setDt_edit(creditutil.time());
	            icbc_dk.setBc_status(6);
	            icbc_dkService.updk(icbc_dk);
			}
			assess_cars assess_cars=icbc_carsService.findicbc_cars(icbc.getId());
            if(assess_cars!=null&&!assess_cars.equals("")){
            	assess_cars assess_cars1=new assess_cars();
            	assess_cars1.setId(assess_cars.getId());
            	assess_cars1.setDt_edit(creditutil.time());
            	//assess_cars1.setGems_id(icbc.getMid_edit());
                assess_cars1.setBc_status(6);
                icbc_carsService.upicbc_cars(assess_cars1);
            }
           icbc_kk icbc_kk=newicbc_kkService.findicbc_kkbyid(icbc.getId());
           if(icbc_kk!=null&&!icbc_kk.equals("")){
        	   icbc_kk icbc_kk1=new icbc_kk();
               icbc_kk1.setId(icbc_kk.getId());
               icbc_kk1.setMid_edit(icbc.getAdminid());
               icbc_kk1.setDt_edit(creditutil.time());
               icbc_kk1.setBc_status(6);
               newicbc_kkService.upkk(icbc_kk1);
           }
           icbc_mq icbc_mq=icbc_mqService.findmqbyicbc(icbc.getId());
           if(icbc_mq!=null&&!icbc_mq.equals("")){
        	   icbc_mq icbc_mq1=new icbc_mq();
        	   icbc_mq1.setBc_status(6);
        	   icbc_mq1.setDt_edit(creditutil.time());
        	   icbc_mq1.setMid_edit(icbc.getAdminid());
        	   icbc_mq1.setId(icbc_mq.getId());
    		   icbc_mqService.upmq(icbc_mq1);
           }            
		}
		Map map=icbcmodel.zx_status();
		icbc.setDsj_result_time(creditutil.time());
		newicbcService.upicbc(icbc);
		icbc_result icbc_result=new icbc_result();
		icbc_result.setDt_add(creditutil.time());
		icbc_result.setDt_edit(creditutil.time());
		icbc_result.setQryid(icbc.getId());
		if(icbc.getRemark()!=null&&!icbc.getRemark().equals("")){
		icbc_result.setRemark(icbc.getRemark());
		}else{
			
			 if(icbc.getBc_status()==1||icbc.getBc_status()==0){
				 icbc_result.setRemark(map.get(1).toString());	 
			 }else{
				 if(icbc.getTr_status()==1){
					 icbc_result.setRemark(map.get(7).toString()); 
				 }else if(icbc.getTr_status()==2){
					 icbc_result.setRemark(map.get(8).toString()); 
				 }else if(icbc.getTr_status()==3){
					 icbc_result.setRemark(map.get(9).toString()); 
				 }else{
					 icbc_result.setRemark(map.get(icbc.getBc_status()).toString()); 
				 }
			 }
		}
//		if(icbc.getTr_status()==1){
//		icbc_result.setStatus(7);	
//		}else 
		if(icbc.getTr_status()==2){
		icbc_result.setStatus(8);	
		}else if(icbc.getTr_status()==3){
		icbc_result.setStatus(9);	
		}else {
		icbc_result.setStatus(icbc.getBc_status());	
		}		
		icbc_result.setMid_add(icbc.getAdminid());
		icbc_result.setMid_edit(icbc.getAdminid());		
		icbc_result1Service.addicbc_result(icbc_result);
		response.setCharacterEncoding("UTF-8");		
		try {
			admin admin=adminService.adminbyid(icbc.getMid_add());
			if(admin!=null&&!admin.equals("")){
			String REGISTRATION_ID=admin.getJgid();
			String mString=admin.getName()
			 +"您好!"
			 +"客户名称为"
			 +icbc.getC_name()+"的审核已更新"
			 +";征信状态:"+map.get(icbc.getBc_status())
			 +";留言:"+icbc_result.getRemark()
			 +"时间:"+creditutil.time()+";";
			if(REGISTRATION_ID!=null&&!REGISTRATION_ID.equals("")){
			Jdpush.testSendPush(appKey,masterSecret,REGISTRATION_ID,mString);	
			}	
			admin_msg admin_msg=new admin_msg();
			admin_msg.setDt_add(creditutil.time());
			admin_msg.setDt_edit(creditutil.time());
			admin_msg.setMid_add(icbc.getAdminid());
			admin_msg.setMsg(mString);
			admin_msg.setReceiveid(admin.getId());
			admin_msg.setSendid(0);
			admin_msg.setStatus(0);
			admin_msgService.addadmin_msg(admin_msg);
			}
			fs fs=fsService.findfsbyid(icbc.getGems_fs_id());
			moneyfs mf=moneyfsService.findmoneyfsbyorderid(icbc.getId());			
			if(mf==null||mf.equals("")){
				System.out.println("商户店："+fs+"---"+"退款："+mf);
			if(fs!=null&&!fs.equals("")){
			if(icbc.getBc_status()==5&&icbc.getZxok_tag()==0&&fs.getMgicbc_tag()==0){
			moneyfs moneyfs=new moneyfs();			
			moneyfs.setAmount(50);
			moneyfs.setBintype(0);
			moneyfs.setDt_add(creditutil.time());
			moneyfs.setDt_edit(creditutil.time());
			moneyfs.setFctype(5);
			moneyfs.setFsid(icbc.getGems_fs_id());
			moneyfs.setGemsid(icbc.getGems_id());
			moneyfs.setMid(icbc.getGems_fs_id());
			moneyfs.setMid_add(icbc.getAdminid());
			moneyfs.setMid_edit(icbc.getAdminid());
			moneyfs.setOrderid(icbc.getId());
			moneyfs.setOtherid(0);
			moneyfs.setRemark("工行征信不通过退款");
			moneyfs.setStatus(1);
			moneyfs.setType(1);
			moneyfsService.addmoneyfs(moneyfs);
			moneyfs_1 moneyfs1=new moneyfs_1();			
			moneyfs1.setAmount(50);
			moneyfs1.setBintype(0);
			moneyfs1.setDt_add(creditutil.time());
			moneyfs1.setDt_edit(creditutil.time());
			moneyfs1.setFctype(5);
			moneyfs1.setFsid(icbc.getGems_fs_id());
			moneyfs1.setGemsid(icbc.getGems_id());
			moneyfs1.setMid(icbc.getGems_fs_id());
			moneyfs1.setRemark("工行征信不通过退款");
			moneyfs1.setStatus(1);
			moneyfs1.setMoneyid(moneyfs.getId());
            moneyfs_1Service.addmoneyfs_1(moneyfs1);
		    }
			
		}			
		}
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=utf-8");			
			String msString="提交成功!";
			PrintWriter out = response.getWriter();			
			out.print("<script language=\"javascript\">alert('"+msString+"');window.location.href='kjs_zx.do?out=1&id="+icbc.getId()+"'</script>");
		} catch (IOException e) {			
			e.printStackTrace();
		}
	 }
	 @Autowired
	 private adminService adminService;
	 //审核人员
	 @RequestMapping(value="/editname.do",produces = "text/html;charset=UTF-8")
	 @ResponseBody
	 public String editname(int id,
			 HttpServletRequest request){	
		icbc icbc=newicbcService.findicbcbyid(id);
		admin admin=adminService.adminbyid(icbc.getMid_edit());	
		if(admin!=null&&!admin.equals("")){
		icbc.setAdminname(admin.getName());
		}
		return jsonutil.toJSONString(icbc);	 
	 }
	 	 	 	 
	 @RequestMapping(value="/newicbcsh.do",produces = "text/html;charset=UTF-8")
	 public String newicbcsh(int id,
			 String querytype,
			 String size,
			 String status,
			 String icbc_type,
			 String mid_edit,
			 HttpServletRequest request,
			 HttpServletResponse response) throws UnsupportedEncodingException{
		 request.setCharacterEncoding("UTF-8");
		 response.setContentType("text/html;charset=utf-8");
	     icbc icbc=newicbcService.findicbcbyid(id);
	     icbc itag=new icbc();	 
	     if(icbc!=null&&!icbc.equals("")){
	    	 if(icbc.getAdminop_tag()!=1){	  
	  		   itag.setAdminop_tag(1);	 
	  		   itag.setId(id);
	  		   newicbcService.upicbc_tag(itag);  	 
	           } 
	     }
		
		 if(mid_edit!=null&&!mid_edit.equals("")){
			 icbc icbc1=new icbc();
			 icbc1.setId(id);
			 icbc1.setMid_edit(Integer.parseInt(mid_edit));
			 newicbcService.upicbc(icbc1); 
		 }
		
	  List<icbc_result> iResultlist=icbc_result1Service.findresultbyqryid(id);
	  if(iResultlist!=null&&!iResultlist.equals("")){
		  for(int i=0;i<iResultlist.size();i++){
			  icbc_result icbc_result=iResultlist.get(i);
			  Map map=icbcmodel.zx_status();
			  icbc_result.setStatusremark(map.get(icbc_result.getStatus()).toString());
		  }
	  }
	  
//	  String[] names = null;
//	  if(icbc.getC_name_mts()!=null&&!icbc.getC_name_mts().equals("")){
//		  names=icbc.getC_name_mts().split("");
//		  if(names.length>0){
//			  for(int i=0;i<names.length;i++){
//				  if(names[i]!=null&&!names[i].equals("")){
//					 request.setAttribute("name"+i,names[i]);   
//				  }				   
//			  }
//		  }
//		  		  
//	  }
//	  String[] tels = null;
//	  if(icbc.getC_tel_mts()!=null&&!icbc.getC_tel_mts().equals("")){
//		  tels=icbc.getC_tel_mts().split("");
//		  if(tels.length>0){
//			  for(int i=0;i<tels.length;i++){
//				  if(tels[i]!=null&&!tels[i].equals("")){
//					 request.setAttribute("tel"+i,tels[i]);   
//				  }				   
//			  }	  
//		  }
//	  }
//	  String[] cardnos = null;
//	  if(icbc.getC_cardno_mts()!=null&&!icbc.getC_cardno_mts().equals("")){
//		  cardnos=icbc.getC_cardno_mts().split("");
//		  if(cardnos.length>0){
//			  for(int i=0;i<cardnos.length;i++){
//				  if(cardnos[i]!=null&&!cardnos[i].equals("")){
//					 request.setAttribute("cardno"+i,cardnos[i]);   
//				  }				   
//			  }	 
//		  }
//	  }
	  //补充材料
	  String[] imgs = null;
	  if(icbc.getImgstep2_5s()!=null&&!icbc.getImgstep2_5s().equals("")){
		  imgs=icbc.getImgstep2_5s().split("");
		  if(imgs.length>0){
			  request.setAttribute("imgs",imgs);
		  }
	  } 
	  //通融材料
	  String[] imgss = null;
	  if(icbc.getImgstep8_1ss()!=null&&!icbc.getImgstep8_1ss().equals("")){
		  imgss=icbc.getImgstep8_1ss().split("");
		  if(imgss.length>0){
			  request.setAttribute("imgss",imgss);
		  }
	  }
	  icbc.setZx_result(icbc.getZx_result().replace(" ",""));
	  List<fs> fs=fService.findbypy();
  	  request.setAttribute("fs",fs);//商户店名称
	  request.setAttribute("remark",icbcmodel.zx_status());
	  request.setAttribute("icbc",icbc); 	  
	  request.setAttribute("iResultlist", iResultlist); 
	  request.setAttribute("querytype", querytype); 
	  request.setAttribute("status", status); 
	  request.setAttribute("size", size); 
	  request.setAttribute("icbc_type",icbc_type); 
	  request.setAttribute("id",id);
	  return "cskjs_wzb/kjs_icbcsh";
	 }
	
	 public static void main(String[] args) {
		String s1="";
		String s2="352123198405211245";
		String[] c_name_po=s2.split("");
		//System.out.println(c_name_po.length);
		
		for(int i=0;i<c_name_po.length;i++){
			System.out.println(c_name_po[i]);
		}
//		String name ="10.2";
//		Float price=Float.parseFloat(name);
//		int s=(int) (price*10000);
//		System.out.println(s);
//		System.out.println();
	}
	 @Autowired
	 private fsService fService;

	 @RequestMapping(value="/fsname.do",produces = "text/html;charset=UTF-8")
	 @ResponseBody
	 public String fsname(HttpServletRequest request
			 ){		 
		List<fs> fs=fService.findbypy();	
		return jsonutil.toJSONString(fs);
	 }
	 
	 @RequestMapping(value="/fsname1.do",produces = "text/html;charset=UTF-8")
	 @ResponseBody
	 public String fsname1(HttpServletRequest request
			 ){		 
		List<fs> fs=fService.findbypy();	
		return jsonutil.toJSONString(fs);
	}
	 
	 @RequestMapping(value="/search_icbc.do",produces = "text/html;charset=UTF-8")
	 public String serach_icbc(HttpServletRequest request,
     		String time,
     		String querytype,
     		String bc_status,
     		String gems_fs_id, 
     		String book_status, 
     		String card_status, 
     		String icbcname,
     		String size,//每页数量
 			String pagenow,//当前页数
 			String status,
 			String out,
 			String id,
 			HttpServletResponse response
			 ) throws UnsupportedEncodingException{
		 String time1= null;
		 String time2= null;
	if(time!=null&&!time.equals("")){
		String[] strings=time.trim().split("-");
		time1=strings[0];
		time2=strings[1].trim();		 
	}	 
	 
	 int querytype1 = 0;
	 int bc_status1= 0;
	 int gems_fs_id1= 0; 
	 int book_status1= 0; 
	 int card_status1= 0;
	 
	 if(querytype!=null&&!querytype.equals("")){
		 querytype1=Integer.parseInt(querytype);
	 }
     if(bc_status!=null&&!bc_status.equals("")){
    	 bc_status1=Integer.parseInt(bc_status);
	 }
     if(gems_fs_id!=null&&!gems_fs_id.equals("")){
    	 gems_fs_id1=Integer.parseInt(gems_fs_id);
    }
     if(book_status!=null&&!book_status.equals("")){
    	 book_status1=Integer.parseInt(book_status);
    }
     if(card_status!=null&&!card_status.equals("")){
    	 card_status1=Integer.parseInt(card_status);
     }	
     if(icbcname!=null&&!icbcname.equals("")){
    	 icbcname=new String(icbcname.getBytes("iso8859-1"),"utf-8");
     }
	 List<icbc> ilist= newicbcService.searchicbc(time1,
			 time2,
			 querytype1,
			 bc_status1,
			 gems_fs_id1, 
			 book_status1, 
			 card_status1, 
			 icbcname);
    System.out.println(ilist.size());
	    if(out!=null&&!out.equals("")&&out.equals("1")){
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
	System.out.println(state);
	List<icbc> icbcall=new ArrayList<>();
		if(ilist.size()>0){
			for(int i=0;i<ilist.size();i++){
				icbc icbc=ilist.get(i);
				Map map4=icbcmodel.pg_status();
				Map map3=icbcmodel.mq_status();
				Map map2=icbcmodel.kk_status();
				Map map1=icbcmodel.qcdk_status();
				//贷款
				if(icbc.getBc_status2()!=null&&!icbc.getBc_status2().equals("")){
					icbc.setStatusname2(map1.get(Integer.parseInt(icbc.getBc_status2())).toString());
				}
				//开卡
                if(icbc.getBc_status3()!=null&&!icbc.getBc_status3().equals("")){
                	icbc.setStatusname3(map2.get(Integer.parseInt(icbc.getBc_status3())).toString());
				}
                //面签
                if(icbc.getBc_status4()!=null&&!icbc.getBc_status4().equals("")){
                	icbc.setStatusname4(map3.get(Integer.parseInt(icbc.getBc_status4())).toString());
                }
                //评估
                if(icbc.getBc_status5()!=null&&!icbc.getBc_status5().equals("")){
                	icbc.setStatusname5(map4.get(Integer.parseInt(icbc.getBc_status5())).toString());
                }
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
	List<fs> fs=fsService.findbypy();
  	request.setAttribute("fs",fs);//商户店名称
	request.setAttribute("time",time);//总页数
	request.setAttribute("bc_status",bc_status);//总页数
	request.setAttribute("gems_fs_id",gems_fs_id);//总页数
	request.setAttribute("book_status",book_status);//总页数
	request.setAttribute("card_status",card_status);//总页数
	request.setAttribute("icbcname",icbcname);//总页数		
	request.setAttribute("totalpage",totalpage);//总页数
	request.setAttribute("size",size1);//每页数量
	request.setAttribute("pagenow",now);//当前页
	request.setAttribute("totalno",ilist.size());//总数量
	request.setAttribute("list",list);// 
	request.setAttribute("status",status);//
	request.setAttribute("querytype",querytype);//
	return "cskjs_wzb/kjs_icbc_search";
	 }
	 
	 @RequestMapping(value="/newicbc.do")
	 public String newicbc(HttpServletRequest request,
     		String size,//每页数量
 			String pagenow,//当前页数
 			String querytype,
 			String status,
 			String out,
 			String id,
 			String apg
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
		List<icbc> il=newicbcService.findicbc(qt,state);
		List<icbc> icbcall=new ArrayList<>();
			if(il.size()>0){
				for(int i=0;i<il.size();i++){
					icbc icbc=il.get(i);
					Map map4=icbcmodel.pg_status();
					Map map3=icbcmodel.mq_status();
					Map map2=icbcmodel.kk_status();
					Map map1=icbcmodel.qcdk_status();
					//贷款
					if(icbc.getBc_status2()!=null&&!icbc.getBc_status2().equals("")){
						icbc.setStatusname2(map1.get(Integer.parseInt(icbc.getBc_status2())).toString());
					}
					//开卡
                    if(icbc.getBc_status3()!=null&&!icbc.getBc_status3().equals("")){
                    	icbc.setStatusname3(map2.get(Integer.parseInt(icbc.getBc_status3())).toString());
					}
                    //面签
                    if(icbc.getBc_status4()!=null&&!icbc.getBc_status4().equals("")){
                    	icbc.setStatusname4(map3.get(Integer.parseInt(icbc.getBc_status4())).toString());
                    }
                    //评估
                    if(icbc.getBc_status5()!=null&&!icbc.getBc_status5().equals("")){
                    	icbc.setStatusname5(map4.get(Integer.parseInt(icbc.getBc_status5())).toString());
                    }
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
    	request.setAttribute("outid",id);//int headid,
    	request.setAttribute("apg",apg);
		return "cskjs_wzb/kjs_icbc";
	 }
	
	 @RequestMapping(value="/shstatus.do",produces = "text/html;charset=UTF-8")
	 @ResponseBody
	 public String shstatus(){
			List<assess_cars> assess_carss=icbc_carsService.allfindicbc_cars();
			if(assess_carss!=null&&assess_carss.size()>0){
				for(int i=0;i<assess_carss.size();i++){
					assess_cars ac=assess_carss.get(i);
					Map map=icbcmodel.pg_status();
					ac.setStatusname(map.get(ac.getBc_status()).toString());
				}				
			}
		return jsonutil.toJSONString(assess_carss);
	 }
	 
	 @RequestMapping(value="/shstatus2.do",produces = "text/html;charset=UTF-8")
	 @ResponseBody
	 public String shstatus2(){
			List<icbc_kk> list=newicbc_kkService.allfindicbc_kk();
			if(list!=null&&list.size()>0){
				for(int i=0;i<list.size();i++){
					icbc_kk icbc_kk=list.get(i);
					Map map=icbcmodel.kk_status();					
					icbc_kk.setStatusname(map.get(icbc_kk.getBc_status()).toString());	
				}			
			}	 
		return jsonutil.toJSONString(list);
	 }
	 @RequestMapping(value="/shstatus3.do",produces = "text/html;charset=UTF-8")
	 @ResponseBody
	 public String shstatus3(){
			List<icbc_mq> icbc_mqs=icbc_mqService.allfindmq();
			if(icbc_mqs!=null&&icbc_mqs.size()>0){
				for(int i=0;i<icbc_mqs.size();i++){
					icbc_mq iMq=icbc_mqs.get(i);
					Map map=icbcmodel.mq_status();					
					iMq.setStatusname(map.get(iMq.getBc_status()).toString());
				}				
			}	 
		return jsonutil.toJSONString(icbc_mqs);
	 }
	 @RequestMapping(value="/shstatus4.do",produces = "text/html;charset=UTF-8")
	 @ResponseBody
	 public String shstatus4(){
			List<icbc_dk> iList=icbc_dkService.allfinddk();
			if(iList!=null&&iList.size()>0){
				for(int i=0;i<iList.size();i++){
					icbc_dk iDk=iList.get(i);
					Map map=icbcmodel.qcdk_status();					
					iDk.setStatusname(map.get(iDk.getBc_status()).toString());
				}				
			}		 
		return jsonutil.toJSONString(iList);
	 }
	 
	 public static String remove(String resource,char ch)   
	 {   
	     StringBuffer buffer=new StringBuffer();   
	     int position=0;   
	     char currentChar;   

	     while(position<resource.length())   
	     {   
	         currentChar=resource.charAt(position++);  
	         //如果当前字符不是要去除的字符，则将当前字符加入到StringBuffer中
	         if(currentChar!=ch) buffer.append(currentChar); 
	     } 
	     return buffer.toString();   
	 }
}
