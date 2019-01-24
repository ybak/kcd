package com.model.newAdd;
public class ssm {
	private int id;  // 自动编号
	private String dt_add;  // 
	private String dt_edit;
	private int mid_add;
	private int mid_edit;
	private String name;
	private String mobile; 
	private int cp; // 权限   1主管   2经理   3业务员   
	private int upid;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getMid_edit() {
		return mid_edit;
	}
	public void setMid_edit(int mid_edit) {
		this.mid_edit = mid_edit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	public int getUpid() {
		return upid;
	}
	public void setUpid(int upid) {
		this.upid = upid;
	}
	
}
