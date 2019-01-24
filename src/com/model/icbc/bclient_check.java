package com.model.icbc;

public class bclient_check {
	private int id; 	//int(11) 	·ñ  	  	 
	private int assessid; 	//int(11) 	·ñ  	  	ÆÀ¹À³µ¼ÇÂ¼id 
	private int status ;	//tinyint(4) 	·ñ  	1  	Ä¿Ç°×´Ì¬ 
	private String dt_add; 	//datetime 	·ñ  	  	 
	private String dt_edit; 	//datetime 	·ñ  	  	 
	private int mid_add ;	//int(11) 	·ñ  	0  	 
	private int del_tag ;	//tinyint(4) 	·ñ  	0  	 
	private int mid_edit ;	//int(11) 	·ñ  	0  	±à¼­ÈËÔ± 
	private String remark; 	//varchar(255) 	·ñ  	  	±¸×¢ 
	private String statusremark; 	//varchar(255) 	·ñ  	  	±¸×¢ 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAssessid() {
		return assessid;
	}
	public void setAssessid(int assessid) {
		this.assessid = assessid;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
	public int getMid_add() {
		return mid_add;
	}
	public void setMid_add(int mid_add) {
		this.mid_add = mid_add;
	}
	public int getDel_tag() {
		return del_tag;
	}
	public void setDel_tag(int del_tag) {
		this.del_tag = del_tag;
	}
	public int getMid_edit() {
		return mid_edit;
	}
	public void setMid_edit(int mid_edit) {
		this.mid_edit = mid_edit;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getStatusremark() {
		return statusremark;
	}
	public void setStatusremark(String statusremark) {
		this.statusremark = statusremark;
	}
	
	
}
