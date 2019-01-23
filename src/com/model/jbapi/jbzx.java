package com.model.jbapi;


public class jbzx {
	private int id; 	//int(11) 	否  	  	 
	private int mid_add; 	//int(11) 	否  	  	 
	private int mid_edit; 	//int(11) 	否  	  	 
	private String dt_add; 	//datetime 	否  	  	 
	private String dt_edit; 	//datetime 	否  	  	 
	private String loginname; 	//varchar(32) 	否  	  	登录用户名 
	private String api_resultcode; 	//int(4) 	否  	  	接口返回代码 
	private String api_resultmsg; 	//varchar(255) 	否  	  	接口返回信息 
	private String bc_status; 	//tinyint(4) 	否  	  	订单状态 
	private int gems_id;	//int(11) 	否  	  	 
	private int gems_fs_id; 	//int(11) 	否  	  	 
	private String gems_code; 	//varchar(20) 	否  	  	订单编码 
	private String smscode; 	//varchar(10) 	否  	  	短信验证码 
	private int query_type;//	tinyint(4) 	否  	0  	类型，暂时一种，为0 
	private String c_name; 	//varchar(20) 	否  	  	姓名 
	private String c_tel; 	//varchar(15) 	否  	  	手机号码 
	private String c_cardno; 	//varchar(32) 	否  	  	身份证 
	private String api_result; 	//longtext 	否  	  	API完整返回数据包 
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
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getApi_resultcode() {
		return api_resultcode;
	}
	public void setApi_resultcode(String api_resultcode) {
		this.api_resultcode = api_resultcode;
	}
	public String getApi_resultmsg() {
		return api_resultmsg;
	}
	public void setApi_resultmsg(String api_resultmsg) {
		this.api_resultmsg = api_resultmsg;
	}
	public String getBc_status() {
		return bc_status;
	}
	public void setBc_status(String bc_status) {
		this.bc_status = bc_status;
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
	public String getGems_code() {
		return gems_code;
	}
	public void setGems_code(String gems_code) {
		this.gems_code = gems_code;
	}
	public String getSmscode() {
		return smscode;
	}
	public void setSmscode(String smscode) {
		this.smscode = smscode;
	}
	public int getQuery_type() {
		return query_type;
	}
	public void setQuery_type(int query_type) {
		this.query_type = query_type;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_tel() {
		return c_tel;
	}
	public void setC_tel(String c_tel) {
		this.c_tel = c_tel;
	}
	public String getC_cardno() {
		return c_cardno;
	}
	public void setC_cardno(String c_cardno) {
		this.c_cardno = c_cardno;
	}
	public String getApi_result() {
		return api_result;
	}
	public void setApi_result(String api_result) {
		this.api_result = api_result;
	}



  
  
}
