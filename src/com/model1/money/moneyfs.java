package com.model1.money;

public class moneyfs {
	private int id; 	//int(11) 	否  	  	 
	private int mid; 	//int(11) 	否  	  	fsid_商户公司ID 
	private int fsid;	//int(11) 	否  	  	同上 
	private int gemsid; 	//int(11) 	否  	  	商户师id 
	private float amount; 	//float(11,2) 	否  	  	金额 
	private int type; 	//tinyint(4) 	否  	0  	类型，1充值,2车辆鉴定订单费用 
	private String dt_add; 	//datetime 	否  	  	 
	private String dt_edit; 	//datetime 	否  	  	 
	private int status; 	//tinyint(4) 	否  	0  	状态 
	private String remark; 	    //varchar(32) 	否  	  	简短备注 
	private int otherid; 	//int(11) 	否  	  	其他id字段1 
	private int orderid ;	//int(11) 	否  	  	订单ID 
	private int bintype ;	//tinyint(4) 	否  	0  	币种类，0为现金充值，1为套餐体育币 
	private int mid_add ;	//int(11) 	否  	  	 
	private int mid_edit ;	//int(11) 	否  	  	 
	private int fctype ;	//tinyint(4) 	否  	0  	财务分类用，0为正常充值，1为现金打折，2为充值折扣 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getFsid() {
		return fsid;
	}
	public void setFsid(int fsid) {
		this.fsid = fsid;
	}
	public int getGemsid() {
		return gemsid;
	}
	public void setGemsid(int gemsid) {
		this.gemsid = gemsid;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getOtherid() {
		return otherid;
	}
	public void setOtherid(int otherid) {
		this.otherid = otherid;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getBintype() {
		return bintype;
	}
	public void setBintype(int bintype) {
		this.bintype = bintype;
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
	public int getFctype() {
		return fctype;
	}
	public void setFctype(int fctype) {
		this.fctype = fctype;
	}


}
