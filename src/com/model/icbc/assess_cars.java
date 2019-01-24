package com.model.icbc;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

//车辆评估(快速评估/专业评估)
public class assess_cars {
	private int id; 	//int(11) 	否  	  	 
	private String code ;	//varchar(45) 	是  	NULL  	 
	private String vincode ;	//varchar(45) 	是  	NULL  	 
	private String dt_add; 	//timestamp 	是  	CURRENT_TIMESTAMP  	 
	private int mem_id ;	//int(11) 	是  	0  	 
	private String mem_name ;	//varchar(45) 	是  	NULL  	 
	private String mem_tel ;	//varchar(45) 	是  	NULL  	 
	private int mem_states; 	//int(11) 	是  	0  	 
	private int mem_citys ;	//int(11) 	是  	0  	 
	private int brid ;	//int(11) 	是  	NULL  	 
	private int seid ;	//int(11) 	是  	NULL  	 
	private int carid ;	//int(11) 	是  	NULL  	 
	private String car_days ;	//date 	是  	NULL  	 
	private int car_km ;	//int(11) 	是  	NULL  	 
	private int color_id ;	//int(11) 	是  	NULL  	 
	private int price_new ;	//int(11) 	是  	0  	 
	private float model_score ;	//float(11,1) 	是  	0.0  	 
	private float parts_score ;	//float(11,1) 	是  	0.0  	 
	private float gaso_score ;	//float(11,1) 	是  	0.0  	 
	private float color_score ;	//float(11,1) 	是  	0.0  	 
	private float items_score ;	//float(11,1) 	是  	0.0  	 
	private float hide_score ;	//float(11,1) 	是  	0.0  	 
	private float score ;	//float(11,1) 	是  	0.0  	 
	private int price_result ;	//int(11) 	是  	0  	 
	private int gems_id ;	//int(11) 	是  	0  	鉴定师ID 
	private String gems_code ;	//varchar(64) 	是  	NULL  	鉴定编号 
	private String imgurl ;	//varchar(255) 	是  	NULL  	车辆图片 
	private int gems_fs_id 	;//int(11) 	是  	0  	加盟店ID 
	private String vincode2; 	//varchar(255) 	是  	  	查询认证码 
	private int ico_1 ;	//tinyint(4) 	是  	0  	车辆配置图标1 
	private int ico_2 ;	//tinyint(4) 	是  	0  	车辆配置图标2 
	private int ico_3 ;	//tinyint(4) 	是  	0  	车辆配置图标3 
	private int ico_4 ;	//tinyint(4) 	是  	0  	车辆配置图标4 
	private int ico_5 ;	//tinyint(4) 	是  	0  	车辆配置图标5 
	private int ico_6 ;	//tinyint(4) 	是  	0  	车辆配置图标6 
	private int ico_7 ;	//tinyint(4) 	是  	0  	车辆配置图标7 
	private int ico_8 ;	//tinyint(4) 	是  	0  	车辆配置图标8 
	private int ico_9 ;	//tinyint(4) 	是  	0  	车辆配置图标9 
	private int ico_10 ;	//tinyint(4) 	是  	0  	车辆配置图标10 
	private int ico_11 ;	//tinyint(4) 	是  	0  	车辆配置图标11 
	private int ico_12; 	//tinyint(4) 	是  	0  	车辆配置图标12 
	private int ico_13 ;	//tinyint(4) 	是  	0  	车辆配置图标13 
	private int ico_14 ;	//tinyint(4) 	是  	0  	车辆配置图标14 
	private int ico_15; 	//tinyint(4) 	是  	0  	车辆配置图标15 
	private int ico_16;  //	tinyint(4) 	是  	0  	车辆配置图标16 
	private int ico_17 ;	//tinyint(4) 	是  	0  	车辆配置图标17 
	private int ico_18 ;	//tinyint(4) 	是  	0  	车辆配置图标18 
	private int ico_19 ;	//tinyint(4) 	是  	0  	车辆配置图标19 
	private int ico_20 ;	//tinyint(4) 	是  	0  	车辆配置图标20 
	private int ico_21 ;	//tinyint(4) 	是  	0  	车辆配置图标21 
	private int bc_status; 	//tinyint(4) 	是  	0  	商户端评估状态 
	private int bc_type ;	///tinyint(4) 	是  	0  	商户端评估类型,快速/专业 
	private String motorcode; 	//varchar(64) 	是  	  	发动机号 
	private String dt_edit; 	//datetime 	否  	  	 
	private String c_tel ;	//varchar(32) 	是  	NULL  	电话 
	private String c_carno ;	//varchar(10) 	是  	NULL  	车牌 
	private String cbs_orderid; 	//varchar(32) 	是  	NULL  	查博士api——orderid 
	private String cbs_result ;	//longtext 	是  	NULL  	查博士api——结果 
	private int qryid_bx ;	//int(11) 	是  	0  	对应的保险查询 
	private int qryid_by ;	//int(11) 	是  	0  	对应的保养查询 
	private int qryid_qryid ;	//int(11) 	是  	0  	对应的查档id 	
	private int orderid;//工行进件id
	private int bypj ;	//int(4) 	是  	-1  	快加认证APP，评估里的综合保养评价，0为好，1为一般，2为差 
	private int icbc_id; 	//tinyint(4) 	是  	0  	工行进件ID 
	private float icbc_pricecs ;//float(11,2) 	是  	0.00  	车商估价(万元) 
	private int xsource ;	//tinyint(4) 	否  	0  	API来源，0为查博士，1为瓜子 
	private String gname;
	private String pname;
	private int api_add;
	private int api_edit;
	private int source_id;
	private int property_id;
	private int gear_box_id;
	private int car_status;
	private String cardt1;
	private String cardt2;
	private float price_reuslt;
	private String statusname;
	private int car_km_icbc;
	private String ppxh;
	private int cars_type;//车辆类型，1为新车，2为二手车
	private String c_name; //关联征信客户名称
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getVincode() {
		return vincode;
	}
	public void setVincode(String vincode) {
		this.vincode = vincode;
	}
	public String getDt_add() {
		return dt_add;
	}
	public void setDt_add(String dt_add) {
		this.dt_add = dt_add;
	}
	public int getMem_id() {
		return mem_id;
	}
	public void setMem_id(int mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_tel() {
		return mem_tel;
	}
	public void setMem_tel(String mem_tel) {
		this.mem_tel = mem_tel;
	}
	public int getMem_states() {
		return mem_states;
	}
	public void setMem_states(int mem_states) {
		this.mem_states = mem_states;
	}
	public int getMem_citys() {
		return mem_citys;
	}
	public void setMem_citys(int mem_citys) {
		this.mem_citys = mem_citys;
	}
	public int getBrid() {
		return brid;
	}
	public void setBrid(int brid) {
		this.brid = brid;
	}
	public int getSeid() {
		return seid;
	}
	public void setSeid(int seid) {
		this.seid = seid;
	}
	public int getCarid() {
		return carid;
	}
	public void setCarid(int carid) {
		this.carid = carid;
	}
	public String getCar_days() {
		return car_days;
	}
	public void setCar_days(String car_days) {
		this.car_days = car_days;
	}
	public int getCar_km() {
		return car_km;
	}
	public void setCar_km(int car_km) {
		this.car_km = car_km;
	}
	public int getColor_id() {
		return color_id;
	}
	public void setColor_id(int color_id) {
		this.color_id = color_id;
	}
	public int getPrice_new() {
		return price_new;
	}
	public void setPrice_new(int price_new) {
		this.price_new = price_new;
	}
	public float getModel_score() {
		return model_score;
	}
	public void setModel_score(float model_score) {
		this.model_score = model_score;
	}
	public float getParts_score() {
		return parts_score;
	}
	public void setParts_score(float parts_score) {
		this.parts_score = parts_score;
	}
	public float getGaso_score() {
		return gaso_score;
	}
	public void setGaso_score(float gaso_score) {
		this.gaso_score = gaso_score;
	}
	public float getColor_score() {
		return color_score;
	}
	public void setColor_score(float color_score) {
		this.color_score = color_score;
	}
	public float getItems_score() {
		return items_score;
	}
	public void setItems_score(float items_score) {
		this.items_score = items_score;
	}
	public float getHide_score() {
		return hide_score;
	}
	public void setHide_score(float hide_score) {
		this.hide_score = hide_score;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public int getPrice_result() {
		return price_result;
	}
	public void setPrice_result(int price_result) {
		this.price_result = price_result;
	}
	public int getGems_id() {
		return gems_id;
	}
	public void setGems_id(int gems_id) {
		this.gems_id = gems_id;
	}
	public String getGems_code() {
		return gems_code;
	}
	public void setGems_code(String gems_code) {
		this.gems_code = gems_code;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public int getGems_fs_id() {
		return gems_fs_id;
	}
	public void setGems_fs_id(int gems_fs_id) {
		this.gems_fs_id = gems_fs_id;
	}
	public String getVincode2() {
		return vincode2;
	}
	public void setVincode2(String vincode2) {
		this.vincode2 = vincode2;
	}
	public int getIco_1() {
		return ico_1;
	}
	public void setIco_1(int ico_1) {
		this.ico_1 = ico_1;
	}
	public int getIco_2() {
		return ico_2;
	}
	public void setIco_2(int ico_2) {
		this.ico_2 = ico_2;
	}
	public int getIco_3() {
		return ico_3;
	}
	public void setIco_3(int ico_3) {
		this.ico_3 = ico_3;
	}
	public int getIco_4() {
		return ico_4;
	}
	public void setIco_4(int ico_4) {
		this.ico_4 = ico_4;
	}
	public int getIco_5() {
		return ico_5;
	}
	public void setIco_5(int ico_5) {
		this.ico_5 = ico_5;
	}
	public int getIco_6() {
		return ico_6;
	}
	public void setIco_6(int ico_6) {
		this.ico_6 = ico_6;
	}
	public int getIco_7() {
		return ico_7;
	}
	public void setIco_7(int ico_7) {
		this.ico_7 = ico_7;
	}
	public int getIco_8() {
		return ico_8;
	}
	public void setIco_8(int ico_8) {
		this.ico_8 = ico_8;
	}
	public int getIco_9() {
		return ico_9;
	}
	public void setIco_9(int ico_9) {
		this.ico_9 = ico_9;
	}
	public int getIco_10() {
		return ico_10;
	}
	public void setIco_10(int ico_10) {
		this.ico_10 = ico_10;
	}
	public int getIco_11() {
		return ico_11;
	}
	public void setIco_11(int ico_11) {
		this.ico_11 = ico_11;
	}
	public int getIco_12() {
		return ico_12;
	}
	public void setIco_12(int ico_12) {
		this.ico_12 = ico_12;
	}
	public int getIco_13() {
		return ico_13;
	}
	public void setIco_13(int ico_13) {
		this.ico_13 = ico_13;
	}
	public int getIco_14() {
		return ico_14;
	}
	public void setIco_14(int ico_14) {
		this.ico_14 = ico_14;
	}
	public int getIco_15() {
		return ico_15;
	}
	public void setIco_15(int ico_15) {
		this.ico_15 = ico_15;
	}
	public int getIco_16() {
		return ico_16;
	}
	public void setIco_16(int ico_16) {
		this.ico_16 = ico_16;
	}
	public int getIco_17() {
		return ico_17;
	}
	public void setIco_17(int ico_17) {
		this.ico_17 = ico_17;
	}
	public int getIco_18() {
		return ico_18;
	}
	public void setIco_18(int ico_18) {
		this.ico_18 = ico_18;
	}
	public int getIco_19() {
		return ico_19;
	}
	public void setIco_19(int ico_19) {
		this.ico_19 = ico_19;
	}
	public int getIco_20() {
		return ico_20;
	}
	public void setIco_20(int ico_20) {
		this.ico_20 = ico_20;
	}
	public int getIco_21() {
		return ico_21;
	}
	public void setIco_21(int ico_21) {
		this.ico_21 = ico_21;
	}
	public int getBc_status() {
		return bc_status;
	}
	public void setBc_status(int bc_status) {
		this.bc_status = bc_status;
	}
	public int getBc_type() {
		return bc_type;
	}
	public void setBc_type(int bc_type) {
		this.bc_type = bc_type;
	}
	public String getMotorcode() {
		return motorcode;
	}
	public void setMotorcode(String motorcode) {
		this.motorcode = motorcode;
	}
	public String getDt_edit() {
		return dt_edit;
	}
	public void setDt_edit(String dt_edit) {
		this.dt_edit = dt_edit;
	}
	public String getC_tel() {
		return c_tel;
	}
	public void setC_tel(String c_tel) {
		this.c_tel = c_tel;
	}
	public String getC_carno() {
		return c_carno;
	}
	public void setC_carno(String c_carno) {
		this.c_carno = c_carno;
	}
	public String getCbs_orderid() {
		return cbs_orderid;
	}
	public void setCbs_orderid(String cbs_orderid) {
		this.cbs_orderid = cbs_orderid;
	}
	public String getCbs_result() {
		return cbs_result;
	}
	public void setCbs_result(String cbs_result) {
		this.cbs_result = cbs_result;
	}
	public int getQryid_bx() {
		return qryid_bx;
	}
	public void setQryid_bx(int qryid_bx) {
		this.qryid_bx = qryid_bx;
	}
	public int getQryid_by() {
		return qryid_by;
	}
	public void setQryid_by(int qryid_by) {
		this.qryid_by = qryid_by;
	}
	public int getQryid_qryid() {
		return qryid_qryid;
	}
	public void setQryid_qryid(int qryid_qryid) {
		this.qryid_qryid = qryid_qryid;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getBypj() {
		return bypj;
	}
	public void setBypj(int bypj) {
		this.bypj = bypj;
	}
	public int getIcbc_id() {
		return icbc_id;
	}
	public void setIcbc_id(int icbc_id) {
		this.icbc_id = icbc_id;
	}
	public float getIcbc_pricecs() {
		return icbc_pricecs;
	}
	public void setIcbc_pricecs(float icbc_pricecs) {
		this.icbc_pricecs = icbc_pricecs;
	}
	public int getXsource() {
		return xsource;
	}
	public void setXsource(int xsource) {
		this.xsource = xsource;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getApi_add() {
		return api_add;
	}
	public void setApi_add(int api_add) {
		this.api_add = api_add;
	}
	public int getApi_edit() {
		return api_edit;
	}
	public void setApi_edit(int api_edit) {
		this.api_edit = api_edit;
	}
	public int getSource_id() {
		return source_id;
	}
	public void setSource_id(int source_id) {
		this.source_id = source_id;
	}
	public int getProperty_id() {
		return property_id;
	}
	public void setProperty_id(int property_id) {
		this.property_id = property_id;
	}
	public int getGear_box_id() {
		return gear_box_id;
	}
	public void setGear_box_id(int gear_box_id) {
		this.gear_box_id = gear_box_id;
	}
	public int getCar_status() {
		return car_status;
	}
	public void setCar_status(int car_status) {
		this.car_status = car_status;
	}
	public String getCardt1() {
		return cardt1;
	}
	public void setCardt1(String cardt1) {
		this.cardt1 = cardt1;
	}
	public String getCardt2() {
		return cardt2;
	}
	public void setCardt2(String cardt2) {
		this.cardt2 = cardt2;
	}
	public float getPrice_reuslt() {
		return price_reuslt;
	}
	public void setPrice_reuslt(float price_reuslt) {
		this.price_reuslt = price_reuslt;
	}
	public String getStatusname() {
		return statusname;
	}
	public void setStatusname(String statusname) {
		this.statusname = statusname;
	}
	public int getCar_km_icbc() {
		return car_km_icbc;
	}
	public void setCar_km_icbc(int car_km_icbc) {
		this.car_km_icbc = car_km_icbc;
	}
	public String getPpxh() {
		return ppxh;
	}
	public void setPpxh(String ppxh) {
		this.ppxh = ppxh;
	}
	public int getCars_type() {
		return cars_type;
	}
	public void setCars_type(int cars_type) {
		this.cars_type = cars_type;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}


}
