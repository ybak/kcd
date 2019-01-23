package com.model;

import com.util.creditutil;

public class finance {
	
   private String fid;//id 
   private String shgs;//商户公司
   private String qygsm;//签约公司
   private String je;//金额
   private String bz;//币种
   private String lx;//类型
   private String rmk;//备注
   private String addtime=creditutil.time();//添加时间
   private String zt;//状态
   private String czr;//操作人
   private int khid;
public String getFid() {
	return fid;
}
public void setFid(String fid) {
	this.fid = fid;
}
public String getShgs() {
	return shgs;
}
public void setShgs(String shgs) {
	this.shgs = shgs;
}
public String getQygsm() {
	return qygsm;
}
public void setQygsm(String qygsm) {
	this.qygsm = qygsm;
}
public String getJe() {
	return je;
}
public void setJe(String je) {
	this.je = je;
}
public String getBz() {
	return bz;
}
public void setBz(String bz) {
	this.bz = bz;
}
public String getLx() {
	return lx;
}
public void setLx(String lx) {
	this.lx = lx;
}

public String getRmk() {
	return rmk;
}
public void setRmk(String rmk) {
	this.rmk = rmk;
}
public String getAddtime() {
	return addtime;
}
public void setAddtime(String addtime) {
	this.addtime = addtime;
}
public String getZt() {
	return zt;
}
public void setZt(String zt) {
	this.zt = zt;
}
public String getCzr() {
	return czr;
}
public void setCzr(String czr) {
	this.czr = czr;
}
public int getKhid() {
	return khid;
}
public void setKhid(int khid) {
	this.khid = khid;
}
   
	
	
}
