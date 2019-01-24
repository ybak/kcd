package com.controller.erp_icbc;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSONObject;
import com.controller.icbc.jsp.icbcmodel;
import com.controller.icbc.util.Jdpush;
import com.model.icbc.assess_cars;
import com.model.icbc.assess_cars_item;
import com.model.icbc.bclient_check;
import com.model.icbc.icbc;
import com.model.icbc.icbc_kk;
import com.model.icbc.icbc_result;
import com.model1.admin;
import com.model1.carmodel;
import com.model1.fs;
import com.model1.city.citys;
import com.model1.city.states;
import com.model1.icbc.icbc_dk;
import com.model1.icbc.icbc_mq;
import com.model1.icbc.icbc_mq_result;
import com.model1.icbc.erp.PageData;
import com.model1.money.moneyfs;
import com.model1.money.moneyfs_1;
import com.model1.send.admin_msg;
import com.service1.adminService;
import com.service1.fsService;
import com.service1.car.icbc_carsService;
import com.service1.car.icbc_cars_resultService;
import com.service1.car.newassess_cars_itemService;
import com.service1.duoying.carmodelService;
import com.service1.erp_icbc.erp_fiveModelService;
import com.service1.kjs_icbc.citysService;
import com.service1.kjs_icbc.icbc_dkService;
import com.service1.kjs_icbc.icbc_mqService;
import com.service1.kjs_icbc.icbc_mq_resultService;
import com.service1.kjs_icbc.icbc_result1Service;
import com.service1.kjs_icbc.newicbcService;
import com.service1.kjs_icbc.newicbc_kkService;
import com.service1.kjs_icbc.statesService;
import com.service1.money.moneyfsService;
import com.service1.money.moneyfs_1Service;
import com.service1.send.admin_msgService;
import com.util.creditutil;
import com.util.limitutil;

@Controller
public class erp_fiveModelController{
	private static final String appKey ="7e21faf06524b22f0ee1414c"; 
	private static final String masterSecret = "c87361ae4d7d91067b3ea01a";
	@Autowired
	private  erp_fiveModelService erp_fiveModelService;
	@Autowired
    private icbc_result1Service icbc_result1Service;
	@Autowired
	private fsService fService;
	@Autowired
	private fsService fsService;
	@Autowired
	private icbc_carsService icbc_carsService;
	@Autowired
	private newassess_cars_itemService newassess_cars_itemService;
	@Autowired
	private citysService citysService;
	@Autowired
	private statesService statesService;
	@Autowired
	private newicbcService newicbcService;
	@Autowired
	private newicbc_kkService newicbc_kkService;
	@Autowired
    private icbc_cars_resultService icbc_cars_resultService;
	@Autowired
    private carmodelService carmodelService;
	//面签
	@Autowired
	private icbc_mqService icbc_mqService;
	@Autowired
	private icbc_mq_resultService icbc_mq_resultService;
	//汽车贷款
	@Autowired
    private icbc_dkService icbc_dkService;
	// 修改征信
	@Autowired
    private moneyfs_1Service moneyfs_1Service;
	@Autowired
	private adminService adminService;
	@Autowired
	private admin_msgService admin_msgService;
	@Autowired
	private moneyfsService moneyfsService;
	
	
	//汽车评估-保存修改 OK   进度保存 1234
	@SuppressWarnings("unused")
	@RequestMapping(value="erp/icbc_cars.do",produces = "text/html;charset=UTF-8")
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
           assess_cars.setMem_id(adminid);
           admin admin=adminService.adminbyid(adminid);
           assess_cars.setMem_name(admin.getName());
           assess_cars.setMem_tel(admin.getTel());
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
			//保存进度之前先判断一下icbc_erp_kj_icbc表中是否有某个用户的某个板块
			PageData pdd=new PageData();
			pdd.put("dn","selectOne_icbc_erp_kj_icbc");
			pdd.put("icbc_id",aCars.getIcbc_id());
			pdd.put("type_id",3);  // 汽车评估 对应 3 
			PageData pErpIcbc = erp_fiveModelService.findbyid(pdd);
			// 如果有某个用户的汽车评估板块，就在 icbc_erp_kj_icbc_result 添加一条操作明细记录
				/*
				 * 操作明细记录 start/////
				 */
				int newStatus = 111;
				//保存2 进度留言记录
				PageData pResult=new PageData();
				pResult.put("dn","icbc_erp_kj_icbc_result");
				pResult.put("mid_add",adminid);
				pResult.put("mid_edit",adminid);
				pResult.put("dt_add", creditutil.time());
				pResult.put("dt_edit", creditutil.time());
				pResult.put("status_oldht",bc_status);
				if(remark!=null&&!remark.equals("")){
					pResult.put("result_1_msg", remark);
				}else{			
					 if(bc_status==1||bc_status==0){
						 pResult.put("result_1_msg",map.get(1).toString());
					 }else{
						 pResult.put("result_1_msg",map.get(bc_status).toString());
					 }
				}
				if(bc_status == 3){  // 通过
					newStatus = 11;
					pResult.put("status",11);
					pResult.put("remark","评估审核结果");
					pResult.put("result_1_code",1); // 1表示通过 （评估完成）
				}else if(bc_status == 4){ // 回退补件
					newStatus = 11;
					pResult.put("status",11);
					pResult.put("remark","评估审核结果");
					pResult.put("result_1_code",3); // 3表示回退补件
				}
				JSONObject json = new JSONObject();
//				json.put("系统评估价","");
//				json.put("期望评估价","");
//				json.put("建议评估价","");
//				json.put("最终评估价","");
				//快加后台
				json.put("price_new",price_new);  // 裸车价格
				json.put("icbc_pricecs",Float.parseFloat(icbc_pricecs));  // 期望评估价
				json.put("price_result",price_result); // 系统评估价
				pResult.put("result_1_value",json.toString()); 
				pResult.put("dt_sub",creditutil.time());
				pResult.put("type_id",3); // 汽车评估 对应 3
				pResult.put("icbc_id",aCars.getIcbc_id());
				/*
				 * 操作明细记录 end/////
				 */
			if(pErpIcbc!=null){
				pResult.put("qryid",pErpIcbc.get("id"));
				erp_fiveModelService.save(pResult);
				//更新icbc_erp_kj_icbc表中，status的最新装填
				PageData upd=new PageData();
				upd.put("dn","update_icbc_erp_kj_icbc");
				upd.put("icbc_id",aCars.getIcbc_id());
				upd.put("type_id",3); // 汽车评估 对应 3
				upd.put("status",newStatus);
				erp_fiveModelService.updatebyid(upd);
			}else{
				PageData picbc=new PageData();
				picbc.put("dn","icbc_erp_kj_icbc");
				picbc.put("mid_add",adminid);
				picbc.put("mid_edit",adminid);
				picbc.put("dt_add",creditutil.time());
				picbc.put("dt_edit",creditutil.time());
				picbc.put("dt_sub",creditutil.time());
				picbc.put("status",newStatus);
				picbc.put("icbc_id",aCars.getIcbc_id());
				picbc.put("gems_id",aCars.getGems_id());
				picbc.put("gems_fs_id",aCars.getGems_fs_id());
				picbc.put("type_id",3); // 汽车评估 对应 3
				picbc.put("c_name",icbc.getC_name());
				picbc.put("c_carno",aCars.getC_carno());
				picbc.put("c_carvin",aCars.getVincode());
				picbc.put("c_cardno",icbc.getC_cardno());
				erp_fiveModelService.save(picbc);
				//result添加数据
				pResult.put("qryid",picbc.get("id"));
				erp_fiveModelService.save(pResult);
			}
		}
	 }

	//视频面签-保存修改 OK   进度保存 1234
	@RequestMapping(value="erp/icbc_sp_up.do",produces = "text/html;charset=UTF-8")
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
			//保存进度之前先判断一下icbc_erp_kj_icbc表中是否有某个用户的某个板块
			PageData pdd=new PageData();
			pdd.put("dn","selectOne_icbc_erp_kj_icbc");
			pdd.put("icbc_id",icbc_mq.getIcbc_id());
			pdd.put("type_id",6);  // 视频面签 对应 6 
			PageData pErpIcbc = erp_fiveModelService.findbyid(pdd);
				/*
				 * 操作明细记录 start/////
				 */
				int newStatus = 111;
				//保存 进度留言记录
				PageData pResult=new PageData();
				pResult.put("dn","icbc_erp_kj_icbc_result");
				pResult.put("mid_add",adminid);
				pResult.put("mid_edit",adminid);
				pResult.put("dt_add", creditutil.time());
				pResult.put("dt_edit", creditutil.time());
				pResult.put("status_oldht",bc_status);
				if(remark!=null&&!remark.equals("")){
					pResult.put("result_1_msg", remark);
				 }else{			
					 if(bc_status==1||bc_status==0){
						 pResult.put("result_1_msg",map.get(1).toString());
					 }else{
						 pResult.put("result_1_msg",map.get(bc_status).toString());
					 }
				}
				if(bc_status == 4){  // 回退补件  == 文档中的不通过
					newStatus = 24;
					pResult.put("status",24);
					pResult.put("remark","结果反馈");
					pResult.put("result_1_code",3); // 3表示回退补件
				}else if(bc_status == 3){ // 通过 
					newStatus = 24;
					pResult.put("status",24);
					pResult.put("remark","结果反馈");
					pResult.put("result_1_code",1); // 1表示通过
				}
				pResult.put("dt_sub",creditutil.time());
				pResult.put("type_id",6); // 视频面签  对应 6
				pResult.put("icbc_id",icbc_mq.getIcbc_id());
				/*
				 * 操作明细记录 end/////
				 */
			if(pErpIcbc!=null){
				//保存 进度留言记录
				pResult.put("qryid",pErpIcbc.get("id"));
				erp_fiveModelService.save(pResult);	
				//更新icbc_erp_kj_icbc表中，status的最新装填
				PageData upd=new PageData();
				upd.put("dn","update_icbc_erp_kj_icbc");
				upd.put("icbc_id",icbc_mq.getIcbc_id());
				upd.put("type_id",6); // 视频面签  对应 6
				upd.put("status",newStatus);
				erp_fiveModelService.updatebyid(upd);
			}else{
				PageData picbc=new PageData();
				picbc.put("dn","icbc_erp_kj_icbc");
				picbc.put("mid_add",adminid);
				picbc.put("mid_edit",adminid);
				picbc.put("dt_add",creditutil.time());
				picbc.put("dt_edit",creditutil.time());
				picbc.put("dt_sub",creditutil.time());
				picbc.put("status",newStatus);
				picbc.put("icbc_id",icbc_mq.getIcbc_id());
				picbc.put("gems_id",icbc_mq.getGems_id());
				picbc.put("gems_fs_id",icbc_mq.getGems_fs_id());
				picbc.put("type_id",6); // 视频面签  对应 6
				picbc.put("c_name",icbc.getC_name());
				assess_cars aCars=icbc_carsService.findicbc_cars1(icbc_mq.getIcbc_id());
				picbc.put("c_carno",aCars.getC_carno());
				picbc.put("c_carvin",aCars.getVincode());
				picbc.put("c_cardno",icbc.getC_cardno());
				erp_fiveModelService.save(picbc);
				//result添加数据
				pResult.put("qryid",picbc.get("id"));
				erp_fiveModelService.save(pResult);
			}
		}
	 }
	
	//汽车贷款-保存修改 OK
	@RequestMapping(value="erp/dk_up.do",produces = "text/html;charset=UTF-8")
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
				//保存进度之前先判断一下icbc_erp_kj_icbc表中是否有某个用户的某个板块
				//如果这个模块存在，就保存进度到留言记录
				PageData pdd=new PageData();
				pdd.put("dn","selectOne_icbc_erp_kj_icbc");
				pdd.put("icbc_id",icbc_dk2.getIcbc_id());
				pdd.put("type_id",8);  // 汽车贷款 对应 8 
				PageData pErpIcbc = erp_fiveModelService.findbyid(pdd);
					/*
					 * 操作明细记录 start/////
					 */
					int newStatus = 111;
					//保存 进度留言记录
					PageData pResult=new PageData();
					pResult.put("dn","icbc_erp_kj_icbc_result");
					pResult.put("mid_add",adminid);
					pResult.put("mid_edit",adminid);
					pResult.put("dt_add", creditutil.time());
					pResult.put("dt_edit", creditutil.time());
					pResult.put("status_oldht",bc_status); // 老后台状态
					if(remark!=null&&!remark.equals("")){
						pResult.put("result_1_msg",remark);
					 }else{			
						 if(bc_status==1||bc_status==0){
							 pResult.put("result_1_msg",map.get(1).toString());
						 }else{
							 pResult.put("result_1_msg",map.get(bc_status).toString());
						 }
					}
					////////////////四级审核  start/////////////////////////////////
					// sh_status  1=专员审核    2=主管审核    3=经理审核    4=总监审核
					int p_code =0;
					switch(icbc_dk2.getSh_status()) {
					case 1:  //1=专员审核 
						switch (bc_status) {
						case 4: // 回退补件 
							p_code = 3; 
							break;
						case 3: // 过件
							p_code = 1; // 1表示过件（通过）
							break;
						case 8: // 过件附条件  ，跳到高一级权限人员审核
							p_code = 2; // 2表示（不通过）
							//专员审核推送给主管审核
							icbc_dk.setBc_status(2);
							icbc_dk.setSh_status(2); 
							icbc_dkService.updk(icbc_dk);
							break;
						default:
							break;
						}
						newStatus = 33;
						pResult.put("status",33);
						pResult.put("remark","专员审核结果");
						pResult.put("result_1_code",p_code); 
						break;
					case 2: // 2=主管审核 
						switch (bc_status) {
						case 4:  // 回退补件 
							p_code = 3; // 3表示回退补件
							break;
						case 3: // 过件
							p_code = 1; // 1表示过件（通过）
							break;
						case 8: // 过件附条件  ，跳到高一级权限人员审核
							p_code = 2; // 2表示（不通过）  
							//主管审核推送给经理审核
							icbc_dk.setBc_status(2);
							icbc_dk.setSh_status(3); 
							icbc_dkService.updk(icbc_dk);
							break;
						default:
							break;
						}
						newStatus = 35;
						pResult.put("status",35);
						pResult.put("remark","主管审核结果");
						pResult.put("result_1_code",p_code); 
						break;	
					case 3: // 3=经理审核 
						switch (bc_status) {
						case 4: // 回退补件 
							p_code = 3; // 3表示回退补件
							break;
						case 3: // 过件
							p_code = 1; // 1表示过件（通过）
							break;
						case 8: // 过件附条件  ，跳到高一级权限人员审核
							p_code = 2; // 2表示（不通过）  
							//经理审核推送给总监审核
							icbc_dk.setBc_status(2);
							icbc_dk.setSh_status(4); 
							icbc_dkService.updk(icbc_dk);
							break;
						default:
							break;
						}
						newStatus = 37;
						pResult.put("status",37);
						pResult.put("remark","经理审核结果");
						pResult.put("result_1_code",p_code);
						break;
					case 4:  // 4=总监审核 
						switch (bc_status) {
						case 4: // 回退补件 
							p_code = 3;  // 3表示回退补件
							break;
						case 3: // 过件
							p_code = 1;  // 1表示过件（通过）
							break;
						case 8: // 过件附条件  ，跳到高一级权限人员审核
							p_code = 2; // 2表示（不通过）  
							//总监审核推送给专员审核
							icbc_dk.setBc_status(2);
							icbc_dk.setSh_status(1); 
							icbc_dkService.updk(icbc_dk);
							break;
						default:
							break;
						}
						newStatus = 39;
						pResult.put("status",39);
						pResult.put("remark","总监审核结果");
						pResult.put("result_1_code",p_code);
						break;
					default:
						break;
					}
					//////////////////四级审核  end//////////////////////////////////
					pResult.put("dt_sub",creditutil.time());
					pResult.put("type_id",8);  // 汽车贷款 对应 8 
					pResult.put("icbc_id",icbc_dk2.getIcbc_id());
					/*
					 * 操作明细记录 end/////
					 */
				if(pErpIcbc!=null){
					//保存 进度留言记录
					pResult.put("qryid",pErpIcbc.get("id"));
					erp_fiveModelService.save(pResult);
					//更新icbc_erp_kj_icbc表中，status的最新装填
					PageData upd=new PageData();
					upd.put("dn","update_icbc_erp_kj_icbc");
					upd.put("icbc_id",icbc_dk2.getIcbc_id());
					upd.put("type_id",8);  // 汽车贷款 对应 8 
					upd.put("status",newStatus); // icbc_erp_kj_icbc表中最新的状态
					erp_fiveModelService.updatebyid(upd);
				}else{
					PageData picbc=new PageData();
					picbc.put("dn","icbc_erp_kj_icbc");
					picbc.put("mid_add",adminid);
					picbc.put("mid_edit",adminid);
					picbc.put("dt_add",creditutil.time());
					picbc.put("dt_edit",creditutil.time());
					picbc.put("dt_sub",creditutil.time());
					picbc.put("status",newStatus);
					picbc.put("icbc_id",icbc_dk2.getIcbc_id());
					picbc.put("gems_id",icbc_dk2.getGems_id());
					picbc.put("gems_fs_id",icbc_dk2.getGems_fs_id());
					picbc.put("type_id",8);  // 汽车贷款 对应 8 
					picbc.put("c_name",icbc.getC_name());
					assess_cars aCars=icbc_carsService.findicbc_cars1(icbc_dk2.getIcbc_id());
					picbc.put("c_carno",aCars.getC_carno());
					picbc.put("c_carvin",aCars.getVincode());
					picbc.put("c_cardno",icbc.getC_cardno());
					erp_fiveModelService.save(picbc);
					//result添加数据
					pResult.put("qryid",picbc.get("id"));
					erp_fiveModelService.save(pResult);
				}
		}
	}
	
	//开卡-保存修改 OK  进度保存 1234
	@RequestMapping(value="erp/kk_up.do",produces = "text/html;charset=UTF-8")
	public void kk_up(
			 int id,
			 int adminid,
			 icbc_kk icbc_kk,
			 HttpServletResponse response,
			 HttpServletRequest request
			 ) throws IOException{  
		    icbc_kk.setDt_edit(creditutil.time()); // add
		    icbc_kk.setMid_edit(adminid);
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
			//保存进度之前先判断一下icbc_erp_kj_icbc表中是否有某个用户的某个板块
			PageData pdd=new PageData();
			pdd.put("dn","selectOne_icbc_erp_kj_icbc");
			pdd.put("icbc_id",icbc_kk1.getIcbc_id());
			pdd.put("type_id",5); // 开卡申请  对应 5
			PageData pErpIcbc = erp_fiveModelService.findbyid(pdd);
				/*
				 * 操作明细记录 start/////
				 */
				int newStatus = 111;
				//保存 进度留言记录
				PageData pResult=new PageData();
				pResult.put("dn","icbc_erp_kj_icbc_result");
				pResult.put("mid_add",adminid);
				pResult.put("mid_edit",adminid);
				pResult.put("dt_add", creditutil.time());
				pResult.put("dt_edit", creditutil.time());
				pResult.put("status_oldht",icbc_kk.getBc_status());
				if(icbc_kk.getRemark()!=null&&!icbc_kk.getRemark().equals("")){
					pResult.put("result_1_msg",icbc_kk.getRemark());
				}else{
					if(icbc_kk.getBc_status()==1||icbc_kk.getBc_status()==0){
						pResult.put("result_1_msg",map.get(1).toString());	 
					}else{
						pResult.put("result_1_msg",map.get(icbc_kk.getBc_status()).toString());
				    }
				}
				if(icbc_kk.getBc_status() == 3){  //开卡审核中 还可表示 身份核查结果    
					newStatus = 19;
					pResult.put("status",19);
					pResult.put("result_1_code",1); // 1表示通过  2不通过
					pResult.put("remark","身份核查结果");
				}else if(icbc_kk.getBc_status() == 4){// 回退补件
					newStatus = 19;
					pResult.put("status",19);
					pResult.put("result_1_code",3); // 3表示回退补件
					pResult.put("remark","身份核查结果");
				}else if(icbc_kk.getBc_status() == 7){ // 通过 
					newStatus = 20;
					pResult.put("status",20);
					pResult.put("result_1_code",1); // 1表示通过  2不通过
					pResult.put("remark","反馈开卡结果");
				}else if(icbc_kk.getBc_status() == 5){  // 申请失败
					newStatus = 20;
					pResult.put("status",20);
					pResult.put("result_1_code",2); // 1表示通过  2不通过
					pResult.put("remark","反馈开卡结果");
				}
				pResult.put("dt_sub",creditutil.time());
				pResult.put("type_id",5); // 开卡申请  对应 5
				pResult.put("icbc_id",icbc_kk1.getIcbc_id());
				/*
				 * 操作明细记录 end/////
				 */
			
			if(pErpIcbc!=null){
				pResult.put("qryid",pErpIcbc.get("id"));
				erp_fiveModelService.save(pResult);
				//更新icbc_erp_kj_icbc表中，status的最新装填
				PageData upd=new PageData();
				upd.put("dn","update_icbc_erp_kj_icbc");
				upd.put("icbc_id",icbc_kk1.getIcbc_id());
				upd.put("type_id",5); // 开卡申请  对应 5
				upd.put("status",newStatus);
				erp_fiveModelService.updatebyid(upd);
			}else{
				PageData picbc=new PageData();
				picbc.put("dn","icbc_erp_kj_icbc");
				picbc.put("mid_add",adminid);
				picbc.put("mid_edit",adminid);
				picbc.put("dt_add",creditutil.time());
				picbc.put("dt_edit",creditutil.time());
				picbc.put("dt_sub",creditutil.time());
				picbc.put("status",newStatus);
				picbc.put("icbc_id",icbc_kk1.getIcbc_id());
				picbc.put("gems_id",icbc_kk1.getGems_id());
				picbc.put("gems_fs_id",icbc_kk1.getGems_fs_id());
				picbc.put("type_id",5); // 开卡申请  对应 5
				picbc.put("c_name",icbc.getC_name());
				assess_cars aCars=icbc_carsService.findicbc_cars1(icbc_kk1.getIcbc_id());
				picbc.put("c_carno",aCars.getC_carno());
				picbc.put("c_carvin",aCars.getVincode());
				picbc.put("c_cardno",icbc.getC_cardno());
				erp_fiveModelService.save(picbc);
				//result添加数据
				pResult.put("qryid",picbc.get("id"));
				erp_fiveModelService.save(pResult);
			}
		}
	 }
	
	//修改征信  （保存提交） OK   进度保存  1234
	@RequestMapping(value="erp/upicbc.do",produces = "text/html;charset=UTF-8")
	public void upicbc(icbc icbc,int adminid,HttpServletRequest request,HttpServletResponse response){
		icbc itag=new icbc();		 
		itag.setAdminop_tag(0);	 
		itag.setId(icbc.getId());
		newicbcService.upicbc_tag(itag); 
		icbc.setDt_edit(creditutil.time());
		icbc.setMid_edit(adminid);
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
		icbc_result icbc_result=new icbc_result();
		icbc_result.setDt_add(creditutil.time());
		icbc_result.setDt_edit(creditutil.time());
		icbc_result.setQryid(icbc.getId());
		if(icbc.getRemark()!=null && !icbc.getRemark().equals("")){
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
				 }else if(icbc.getTr_status()==4){
					 icbc_result.setRemark(map.get(10).toString()); 
				 }else{
					 icbc_result.setRemark(map.get(icbc.getBc_status()).toString()); 
				 }
			 }
		}
		if(icbc.getTr_status()==2){
			icbc.setBc_status(8);
			icbc_result.setStatus(8);	
		}else if(icbc.getTr_status()==3){
			icbc.setBc_status(8);
			icbc_result.setStatus(9);	
		}else{
			icbc_result.setStatus(icbc.getBc_status());	
		}	
		icbc_result.setMid_add(icbc.getAdminid());
		icbc_result.setMid_edit(icbc.getAdminid());
		newicbcService.upicbc(icbc); // 修改征信表
		icbc_result1Service.addicbc_result(icbc_result); // 修改征信 result表
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
//			request.setCharacterEncoding("UTF-8");
//			response.setContentType("text/html;charset=utf-8");			
//			String msString="提交成功!";	
//			PrintWriter out = response.getWriter();								
//			out.print("<script language=\"javascript\">alert('"+msString+"');window.location.href='user_form_.do?type=wlghd&dn=zx&qn=form&id="+icbc.getId()+"'</script>");
		} catch (Exception e) {			
			e.printStackTrace();
		}
		//保存进度之前先判断一下icbc_erp_kj_icbc表中是否有某个用户的某个板块
		PageData pdd=new PageData();
		pdd.put("dn","selectOne_icbc_erp_kj_icbc");
		pdd.put("icbc_id",icbc.getId()); 
		//对应模块
		if(icbc.getTr_status()==0){
			//征信查询模块
			pdd.put("type_id",1); // 征信查询 对应 1
		}else{
			//征信通融模块
			pdd.put("type_id",2); // 征信通融 对应 2
		}
		PageData pErpIcbc = erp_fiveModelService.findbyid(pdd);
			/*
			 * 操作明细记录 start/////
			 */
			int newStatus = 111;
			//保存2 进度留言记录
			PageData pResult=new PageData();
			pResult.put("dn","icbc_erp_kj_icbc_result");
			pResult.put("mid_add",adminid);
			pResult.put("mid_edit",adminid);
			pResult.put("dt_add", creditutil.time());
			pResult.put("dt_edit", creditutil.time());
			if(icbc.getTr_status()==2){
				pResult.put("status_oldht",8);	
			}else if(icbc.getTr_status()==3){
				pResult.put("status_oldht",9);	
			}else {
				pResult.put("status_oldht",icbc.getBc_status());	
			}
			// 留言
			if(icbc.getRemark()!=null&&!icbc.getRemark().equals("")){
				pResult.put("result_1_msg", icbc.getRemark());
			}else{
				 if(icbc.getBc_status()==1||icbc.getBc_status()==0){
					 pResult.put("result_1_msg", map.get(1).toString());	 
				 }else{
					 if(icbc.getTr_status()==1){
						 pResult.put("result_1_msg", map.get(7).toString()); 
					 }else if(icbc.getTr_status()==2){
						 pResult.put("result_1_msg",map.get(8).toString()); 
					 }else if(icbc.getTr_status()==3){
						 pResult.put("result_1_msg",map.get(9).toString()); 
					 }else if(icbc.getTr_status()==4){
						 pResult.put("result_1_msg",map.get(10).toString()); 
					 }else{
						 pResult.put("result_1_msg",map.get(icbc.getBc_status()).toString()); 
					 }
				 }
			}
			//征信查询
			if(icbc.getBc_status()==3){ // 征信通过
				newStatus = 3;
				pResult.put("status",3);
				pResult.put("remark","查询结果");
				pResult.put("result_1_code",1); // 1表示通过
			}else if(icbc.getBc_status()==4){
				newStatus = 3;
				pResult.put("status",3);
				pResult.put("remark","查询结果");
				pResult.put("result_1_code",3); // 3表示回退补件
			}else if(icbc.getBc_status()>=5){
				if(icbc.getTr_status()==0){
					newStatus = 3;
					pResult.put("status",3);
					pResult.put("remark","查询结果");
					pResult.put("result_1_code",2); // 2表示不通过
				//通融进度
				}else if(icbc.getTr_status()==2){ // 通融通过
					newStatus = 7;
					pResult.put("status",7);
					pResult.put("remark","通融结果");
					pResult.put("result_1_code",1); // 1表示通过
				}else if(icbc.getTr_status()==3){ //通融不通过
					newStatus = 7;
					pResult.put("status",7);	
					pResult.put("remark","通融结果");
					pResult.put("result_1_code",2); // 2表示不通过
				}else if(icbc.getTr_status()==4){ //附条件通融-回退补件
					newStatus = 7;
					pResult.put("status",7);	
					pResult.put("remark","通融结果");
					pResult.put("result_1_code",3); // 3表示回退补件
				}
			}
			//保存具体征信信息
			pResult.put("result_1_value",icbc.getZx_result());
			//对应模块
			int aa = 0;
			if(icbc.getTr_status()==0){
				//征信查询模块
				aa = 1;
				pResult.put("type_id",1); // 征信查询 对应 1
			}else{
				//征信通融模块
				aa = 2;
				pResult.put("type_id",2); // 征信通融 对应 2
			}
			pResult.put("dt_sub",creditutil.time());
			pResult.put("icbc_id",icbc.getId()); 
			/*
			 * 操作明细记录 end/////
			 */
		
		if(pErpIcbc!=null){
			pResult.put("qryid",pErpIcbc.get("id"));
			erp_fiveModelService.save(pResult);	
			//更新icbc_erp_kj_icbc表中，status的最新装填
			PageData upd=new PageData();
			upd.put("dn","update_icbc_erp_kj_icbc");
			upd.put("icbc_id",icbc.getId()); 
			upd.put("type_id",aa); 
			upd.put("status",newStatus);
			erp_fiveModelService.updatebyid(upd);
		}else{
			PageData picbc=new PageData();
			picbc.put("dn","icbc_erp_kj_icbc");
			picbc.put("mid_add",adminid);
			picbc.put("mid_edit",adminid);
			picbc.put("dt_add",creditutil.time());
			picbc.put("dt_edit",creditutil.time());
			picbc.put("dt_sub",creditutil.time());
			picbc.put("status",newStatus);
			picbc.put("icbc_id",icbc.getId());
			picbc.put("gems_id",icbc.getGems_id());
			picbc.put("gems_fs_id",icbc.getGems_fs_id());
			if(icbc.getTr_status()==0){
				//征信查询模块
				picbc.put("type_id",1); // 征信查询 对应 1
			}else{
				//征信通融模块
				picbc.put("type_id",2); // 征信通融 对应 2
			}
			picbc.put("c_name",icbc.getC_name());
			assess_cars aCars=icbc_carsService.findicbc_cars1(icbc.getId());
			picbc.put("c_carno",aCars.getC_carno());
			picbc.put("c_carvin",aCars.getVincode());
			picbc.put("c_cardno",icbc.getC_cardno());
			erp_fiveModelService.save(picbc);
			//result添加数据
			pResult.put("qryid",picbc.get("id"));
			erp_fiveModelService.save(pResult);
		}
	 }
	
	//模块 form 详情页
	@RequestMapping(value="erp/user_form_.do",produces = "text/html;charset=UTF-8")  
	public String user_form(
			Integer icbc_id,
			Integer  id,
			String   dn,
			String   qn,
			HttpServletRequest request
			){
		PageData pagedate=new PageData();
		pagedate.put("dn",dn);
		pagedate.put("id",id);
		PageData pd=erp_fiveModelService.findbyid(pagedate);
		//公司查询
		PageData pd1=new PageData();
		pd1.put("dn","assess_fs");
		List<PageData> pageDatas=erp_fiveModelService.findtolist(pd1);
		//征信操作
		if(dn.equals("zx")){
			List<icbc_result> iResultlist=icbc_result1Service.findresultbyqryid(id);
			  if(iResultlist!=null&&!iResultlist.equals("")){
				  for(int i=0;i<iResultlist.size();i++){
					  icbc_result icbc_result=iResultlist.get(i);
					  Map map=icbcmodel.zx_status();
					  icbc_result.setStatusremark(map.get(icbc_result.getStatus()).toString());
				  }
		    }
			List<fs> fs=fService.findbypy(); // zx 
			request.setAttribute("fs",fs);//商户店名称    zx  
			request.setAttribute("iResultlist",iResultlist); 
			request.setAttribute("icbc",pd); 
		}
		//评估操作
		if(dn.equals("pg")){
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
//		    request.setAttribute("querytype",querytype);	
//		    request.setAttribute("carmodel",carmodel);
//		    request.setAttribute("size",size);
//		    request.setAttribute("status",status);
//		    request.setAttribute("icbc_type",icbc_type);
		    request.setAttribute("id",icbc_id);
			
			request.setAttribute("assess_cars",pd);
		}
		//开卡操作
		if(dn.equals("kk")){
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
//		    request.setAttribute("querytype",querytype);	 
//		    request.setAttribute("size",size);
//		    request.setAttribute("status",status);
//		    request.setAttribute("icbc_type",icbc_type);
		    
		    request.setAttribute("id",icbc_id);
			request.setAttribute("icbc_kk",pd);
		}
		//视频面签
		if(dn.equals("mq")){
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
//		    request.setAttribute("querytype",querytype);	
//		    request.setAttribute("size",size);
//		    request.setAttribute("status",status);
//		    request.setAttribute("icbc_type",icbc_type);
		    request.setAttribute("id",icbc_id);
		    
		    request.setAttribute("icbc_mq",pd);
		}
		//贷款
		if(dn.equals("cardk")){
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
//		    request.setAttribute("querytype",querytype);	 
//		    request.setAttribute("size",size);
//		    request.setAttribute("status",status);
//		    request.setAttribute("icbc_type",icbc_type);
		    request.setAttribute("id",icbc_id);
		    request.setAttribute("icbc_dk",pd);
		}
		request.setAttribute("pageDatas",pageDatas);
		request.setAttribute("dn",dn); 
		request.setAttribute("qn",qn);
		return "kjs_icbc/index";
	}
	
	//用户遍历 列表页   
	@RequestMapping(value="erp/user_list_.do",produces = "text/html;charset=UTF-8")  
	public String user_list(
			String status,
			Integer  pagesize,
			Integer  pagenow,
			String   dn,
			String   qn,
			String   type,
 			HttpServletRequest request
 			){
		
		System.out.println(status+"**************");
		List<PageData>  newpdList=new ArrayList<>();
		PageData pd=new PageData();
		pd.put("dn",dn);
		pd.put("bc_status",status);
		//2019-1-23 newAdd start
		PageData pdLoginSession= (PageData)request.getSession().getAttribute("pd");
		System.out.println(pdLoginSession.get("icbc_erp_fsid")+"sdasdas");
		pd.put("fsid",pdLoginSession.get("icbc_erp_fsid"));
		//2019-1-23 newAdd end
		List<PageData>  pdList=erp_fiveModelService.findtolist(pd);
		newpdList=limitutil.fy(pdList,pagesize,pagenow);
		int q=pdList.size()%pagesize;
		int totalpage=0;//总页数
		if(q==0){
			totalpage=pdList.size()/pagesize;	    		
		}else{
			totalpage=pdList.size()/pagesize+1;
			
		} 
		request.setAttribute("zxmap",icbcmodel.zx_status());  // new add
		request.setAttribute("pgmap",icbcmodel.pg_status());  // new add 
		request.setAttribute("kkmap",icbcmodel.kk_status());  // new add 
		request.setAttribute("mqmap",icbcmodel.mq_status());  // new add 
		request.setAttribute("cardkmap",icbcmodel.qcdk_status());  // new add 
		request.setAttribute("totalpage",totalpage);
		request.setAttribute("totalsize",pdList.size());
		request.setAttribute("pagesize",pagesize);
		request.setAttribute("pagenow",pagenow);
		request.setAttribute("dn",dn);
		request.setAttribute("qn",qn);
		request.setAttribute("type",type);
		request.setAttribute("newpdList",newpdList);
		request.setAttribute("status",status);
		return "kjs_icbc/index";
	}
	
	//首页  控制跳转user_list_.do(列表页) 或者user_form_.do（详情页）控制器
	@RequestMapping(value="erp/index_.do",produces="text/html;charset=UTF-8")  
	public ModelAndView index(
			String status,
			Integer icbc_id,
			String  type,
			String  dn,
			String  qn,
			String  pagesize,
			String  pagenow,
			Integer id,
			assess_fs assess_fs,
 			HttpServletRequest request
 			) throws UnsupportedEncodingException{
		if(status==null||status.equals("")){
			status = "";
		}
		if(icbc_id==null||icbc_id.equals("")){
			icbc_id = 0;
		}
		if(qn==null||qn.equals("")
				||type==null||type.equals("")||
				dn==null||dn.equals("")
				){
			type="icbc";
			dn="assess_admin";
			qn="list";
		}
		int ps=0;
		int pn=0;
		if(pagesize!=null&&!pagesize.equals("")){
			ps=Integer.parseInt(pagesize);
		}else{
			ps=10;
		}
		if(pagenow!=null&&!pagenow.equals("")){
			pn=Integer.parseInt(pagenow);
		}else{
			pn=1;
		}
		request.setAttribute("type",type);
		request.setAttribute("dn",dn);
		request.setAttribute("qn",qn);
		request.setAttribute("pagesize",ps);
		request.setAttribute("pagenow",pn);
		if(qn.equals("list")){
			return new ModelAndView("redirect:user_list_.do?type="+type+"&dn="+dn+"&qn="+qn+"&pagesize="+ps+"&pagenow="+pn+"&status="+status);	
		}else if(qn.equals("form")){
			PageData pd=new PageData();
			pd.put("dn","assess_fs");
			List<PageData> pageDatas=erp_fiveModelService.findtolist(pd);
			request.setAttribute("pageDatas",pageDatas);
			
			if(id!=null&&!id.equals("")){
			return new ModelAndView("redirect:user_form_.do?type="+type+"&dn="+dn+"&qn="+qn+"&id="+id+"&icbc_id="+icbc_id);
			}else{
			return new ModelAndView("kjs_icbc/index");
			}
		}else{
			return new ModelAndView("kjs_icbc/index");
		}
	}
	
	// 工具方法--征信保存提交时用
	public static String remove(String resource,char ch){   
	     StringBuffer buffer=new StringBuffer();   
	     int position=0;   
	     char currentChar;   
	     while(position<resource.length()){   
	         currentChar=resource.charAt(position++);  
	         //如果当前字符不是要去除的字符，则将当前字符加入到StringBuffer中
	         if(currentChar!=ch) buffer.append(currentChar); 
	     } 
	     return buffer.toString();   
	 }
}

