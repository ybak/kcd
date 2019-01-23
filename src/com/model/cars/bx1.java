package com.model.cars;

public class bx1 {
	private int id; 	//int(11) 	否  	  	 
	private int mid_add; 	//int(11) 	否  	  	 
	private int mid_edit ;	//int(11) 	否  	  	 
	private String dt_add; 	//datetime 	否  	  	 
	private String dt_edit; 	//datetime 	否  	  	 
	private String imgurl; //	varchar(255) 	否  	  	 
	private int bc_status; 	//tinyint(4) 	否  	0  	 
	private int query_type; //	tinyint(4) 	否  	0  	0为档案查询，1为维修保养查询 
	private int gems_id; 	//int(11) 	否  	  	商户端ID 
	 private int	gems_fs_id; //	int(11) 	否  	  	商户端店铺ID 
	 private String	c_carvin ;	//varchar(20) 	否  	  	VIN 
	 private String	c_carfdjh; 	//varchar(20) 	否  	  	发动机号 
	 private String	c_carno ;	//varchar(20) 	否  	  	车牌号 
	 private String	c_cardno ;	//varchar(20) 	否  	  	身份证号 
	 private String	result_imgurl1; //	varchar(255) 	否  	  	返回结果图1 
	 private String	result_imgurl2; //	varchar(255) 	否  	  	返回结果图2 
	 private String	result_imgurl3 ;//	varchar(255) 	否  	  	返回结果图3 
	 private String	gems_code; 	//varchar(64) 	否  	  	订单号 
	 private String	result_imgurl4; //	varchar(255) 	否  	  	 
	 private String	result_imgurl5 ;	//varchar(255) 	否  	  	 
	 private String	result_imgurl6 ;//	varchar(255) 	否  	  	 
	 private String	result_imgurl7 ;//	varchar(255) 	否  	  	 
	 private String	result_imgurl8 ;//	varchar(255) 	否  	  	 
	 private String	result_imgurl9 ;//	varchar(255) 	否  	  	 
	 private String	result_imgurl10; //	varchar(255) 	否  	  	 
	 private String	result_imgurl11; //	varchar(255) 	否  	  	 
	 private String	result_imgurl12; //	varchar(255) 	否  	  	 
	 private String	result_imgurl13; //	varchar(255) 	是  	NULL  	 
	 private String	result_imgurl14; //	varchar(255) 	是  	NULL  	 
	 private String	result_imgurl15;//	varchar(255) 	是  	NULL  	 
	 private String	result_imgurl16; //	varchar(255) 	是  	NULL  	 
	 private String	result_imgurl17; //	varchar(255) 	是  	NULL  	 
	 private String	result_imgurl18; //	varchar(255) 	是  	NULL  	 
	 private String	result_imgurl19; //	varchar(255) 	是  	NULL  	 
	 private String	result_imgurl20; //	varchar(255) 	是  	NULL  	 
	 private String	result_imgurl21; //	varchar(255) 	是  	NULL  	 
	 private String	result_imgurl22; //	varchar(255) 	是  	NULL  	 
	 private String	result_imgurl23; //	varchar(255) 	是  	NULL  	 
	 private String	result_imgurl24;//	varchar(255) 	是  	NULL  	 
	 private String	result_imgurl25; //	varchar(255) 	是  	NULL  	 
	 private String	result_imgurl26; //	varchar(255) 	是  	NULL  	 
	 private String	result_imgurl27; //	varchar(255) 	是  	NULL  	 
	 private String	result_imgurl28; //	varchar(255) 	是  	NULL  	 
	 private String	result_imgurl29; //	varchar(255) 	是  	NULL  	 
	 private String	result_imgurl30; //	varchar(255) 	是  	NULL  	 
	 private String	api_result; 	//longtext 	否  	  	泰融API查询保险完整返回信息 
	 private String	api_msg ;	//varchar(255) 	否  	  	API返回提示信息 
     private String	api_code ;	//varchar(20) 	否  	  	api返回代码 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMid_add() {
		return mid_add;
	}
	public void setMid_add(int mid_add) {
		this.mid_add = mid_add;
	}
	public int getMid_edit() {
		return mid_edit;
	}
	public void setMid_edit(int mid_edit) {
		this.mid_edit = mid_edit;
	}
	public String getDt_add() {
		return dt_add;
	}
	public void setDt_add(String dt_add) {
		this.dt_add = dt_add;
	}
	public String getDt_edit() {
		return dt_edit;
	}
	public void setDt_edit(String dt_edit) {
		this.dt_edit = dt_edit;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public int getBc_status() {
		return bc_status;
	}
	public void setBc_status(int bc_status) {
		this.bc_status = bc_status;
	}
	public int getQuery_type() {
		return query_type;
	}
	public void setQuery_type(int query_type) {
		this.query_type = query_type;
	}
	public int getGems_id() {
		return gems_id;
	}
	public void setGems_id(int gems_id) {
		this.gems_id = gems_id;
	}
	public int getGems_fs_id() {
		return gems_fs_id;
	}
	public void setGems_fs_id(int gems_fs_id) {
		this.gems_fs_id = gems_fs_id;
	}
	public String getC_carvin() {
		return c_carvin;
	}
	public void setC_carvin(String c_carvin) {
		this.c_carvin = c_carvin;
	}
	public String getC_carfdjh() {
		return c_carfdjh;
	}
	public void setC_carfdjh(String c_carfdjh) {
		this.c_carfdjh = c_carfdjh;
	}
	public String getC_carno() {
		return c_carno;
	}
	public void setC_carno(String c_carno) {
		this.c_carno = c_carno;
	}
	public String getC_cardno() {
		return c_cardno;
	}
	public void setC_cardno(String c_cardno) {
		this.c_cardno = c_cardno;
	}
	public String getResult_imgurl1() {
		return result_imgurl1;
	}
	public void setResult_imgurl1(String result_imgurl1) {
		this.result_imgurl1 = result_imgurl1;
	}
	public String getResult_imgurl2() {
		return result_imgurl2;
	}
	public void setResult_imgurl2(String result_imgurl2) {
		this.result_imgurl2 = result_imgurl2;
	}
	public String getResult_imgurl3() {
		return result_imgurl3;
	}
	public void setResult_imgurl3(String result_imgurl3) {
		this.result_imgurl3 = result_imgurl3;
	}
	public String getGems_code() {
		return gems_code;
	}
	public void setGems_code(String gems_code) {
		this.gems_code = gems_code;
	}
	public String getResult_imgurl4() {
		return result_imgurl4;
	}
	public void setResult_imgurl4(String result_imgurl4) {
		this.result_imgurl4 = result_imgurl4;
	}
	public String getResult_imgurl5() {
		return result_imgurl5;
	}
	public void setResult_imgurl5(String result_imgurl5) {
		this.result_imgurl5 = result_imgurl5;
	}
	public String getResult_imgurl6() {
		return result_imgurl6;
	}
	public void setResult_imgurl6(String result_imgurl6) {
		this.result_imgurl6 = result_imgurl6;
	}
	public String getResult_imgurl7() {
		return result_imgurl7;
	}
	public void setResult_imgurl7(String result_imgurl7) {
		this.result_imgurl7 = result_imgurl7;
	}
	public String getResult_imgurl8() {
		return result_imgurl8;
	}
	public void setResult_imgurl8(String result_imgurl8) {
		this.result_imgurl8 = result_imgurl8;
	}
	public String getResult_imgurl9() {
		return result_imgurl9;
	}
	public void setResult_imgurl9(String result_imgurl9) {
		this.result_imgurl9 = result_imgurl9;
	}
	public String getResult_imgurl10() {
		return result_imgurl10;
	}
	public void setResult_imgurl10(String result_imgurl10) {
		this.result_imgurl10 = result_imgurl10;
	}
	public String getResult_imgurl11() {
		return result_imgurl11;
	}
	public void setResult_imgurl11(String result_imgurl11) {
		this.result_imgurl11 = result_imgurl11;
	}
	public String getResult_imgurl12() {
		return result_imgurl12;
	}
	public void setResult_imgurl12(String result_imgurl12) {
		this.result_imgurl12 = result_imgurl12;
	}
	public String getResult_imgurl13() {
		return result_imgurl13;
	}
	public void setResult_imgurl13(String result_imgurl13) {
		this.result_imgurl13 = result_imgurl13;
	}
	public String getResult_imgurl14() {
		return result_imgurl14;
	}
	public void setResult_imgurl14(String result_imgurl14) {
		this.result_imgurl14 = result_imgurl14;
	}
	public String getResult_imgurl15() {
		return result_imgurl15;
	}
	public void setResult_imgurl15(String result_imgurl15) {
		this.result_imgurl15 = result_imgurl15;
	}
	public String getResult_imgurl16() {
		return result_imgurl16;
	}
	public void setResult_imgurl16(String result_imgurl16) {
		this.result_imgurl16 = result_imgurl16;
	}
	public String getResult_imgurl17() {
		return result_imgurl17;
	}
	public void setResult_imgurl17(String result_imgurl17) {
		this.result_imgurl17 = result_imgurl17;
	}
	public String getResult_imgurl18() {
		return result_imgurl18;
	}
	public void setResult_imgurl18(String result_imgurl18) {
		this.result_imgurl18 = result_imgurl18;
	}
	public String getResult_imgurl19() {
		return result_imgurl19;
	}
	public void setResult_imgurl19(String result_imgurl19) {
		this.result_imgurl19 = result_imgurl19;
	}
	public String getResult_imgurl20() {
		return result_imgurl20;
	}
	public void setResult_imgurl20(String result_imgurl20) {
		this.result_imgurl20 = result_imgurl20;
	}
	public String getResult_imgurl21() {
		return result_imgurl21;
	}
	public void setResult_imgurl21(String result_imgurl21) {
		this.result_imgurl21 = result_imgurl21;
	}
	public String getResult_imgurl22() {
		return result_imgurl22;
	}
	public void setResult_imgurl22(String result_imgurl22) {
		this.result_imgurl22 = result_imgurl22;
	}
	public String getResult_imgurl23() {
		return result_imgurl23;
	}
	public void setResult_imgurl23(String result_imgurl23) {
		this.result_imgurl23 = result_imgurl23;
	}
	public String getResult_imgurl24() {
		return result_imgurl24;
	}
	public void setResult_imgurl24(String result_imgurl24) {
		this.result_imgurl24 = result_imgurl24;
	}
	public String getResult_imgurl25() {
		return result_imgurl25;
	}
	public void setResult_imgurl25(String result_imgurl25) {
		this.result_imgurl25 = result_imgurl25;
	}
	public String getResult_imgurl26() {
		return result_imgurl26;
	}
	public void setResult_imgurl26(String result_imgurl26) {
		this.result_imgurl26 = result_imgurl26;
	}
	public String getResult_imgurl27() {
		return result_imgurl27;
	}
	public void setResult_imgurl27(String result_imgurl27) {
		this.result_imgurl27 = result_imgurl27;
	}
	public String getResult_imgurl28() {
		return result_imgurl28;
	}
	public void setResult_imgurl28(String result_imgurl28) {
		this.result_imgurl28 = result_imgurl28;
	}
	public String getResult_imgurl29() {
		return result_imgurl29;
	}
	public void setResult_imgurl29(String result_imgurl29) {
		this.result_imgurl29 = result_imgurl29;
	}
	public String getResult_imgurl30() {
		return result_imgurl30;
	}
	public void setResult_imgurl30(String result_imgurl30) {
		this.result_imgurl30 = result_imgurl30;
	}
	public String getApi_result() {
		return api_result;
	}
	public void setApi_result(String api_result) {
		this.api_result = api_result;
	}
	public String getApi_msg() {
		return api_msg;
	}
	public void setApi_msg(String api_msg) {
		this.api_msg = api_msg;
	}
	public String getApi_code() {
		return api_code;
	}
	public void setApi_code(String api_code) {
		this.api_code = api_code;
	}
    

}
