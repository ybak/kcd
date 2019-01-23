package com.model;
public class apply {
 private int apply_id;
 private String applyurl;
 private String authorizeurl;
 private String applyname;
 private String authorizename;
 private String acode;
 private int aid;
 private String addtime;
 private String num;//需要条数
 private String uptime;
 
 private int counts;
 private int pdf_fenlei; // 用于区分是快车道文件还是典当行文件  20=>快车道，21=>典当行

 private int apply_address;//渠道商 code
 private String admin_name; 
 
public int getPdf_fenlei() {
	return pdf_fenlei;
}
public void setPdf_fenlei(int pdf_fenlei) {
	this.pdf_fenlei = pdf_fenlei;
}
public int getCounts() {
	return counts;
}
public void setCounts(int counts) {
	this.counts = counts;
}
public int getApply_id() {
	return apply_id;
}
public void setApply_id(int apply_id) {
	this.apply_id = apply_id;
}
public String getApplyurl() {
	return applyurl;
}
public void setApplyurl(String applyurl) {
	this.applyurl = applyurl;
}
public String getAuthorizeurl() {
	return authorizeurl;
}
public void setAuthorizeurl(String authorizeurl) {
	this.authorizeurl = authorizeurl;
}
public String getApplyname() {
	return applyname;
}
public void setApplyname(String applyname) {
	this.applyname = applyname;
}
public String getAuthorizename() {
	return authorizename;
}
public void setAuthorizename(String authorizename) {
	this.authorizename = authorizename;
}
public String getAcode() {
	return acode;
}
public void setAcode(String acode) {
	this.acode = acode;
}
public int getAid() {
	return aid;
}
public void setAid(int aid) {
	this.aid = aid;
}
public String getAddtime() {
	return addtime;
}
public void setAddtime(String addtime) {
	this.addtime = addtime;
}
public String getNum() {
	return num;
}
public void setNum(String num) {
	this.num = num;
}
public String getUptime() {
	return uptime;
}
public void setUptime(String uptime) {
	this.uptime = uptime;
}
public int getApply_address() {
	return apply_address;
}
public void setApply_address(int apply_address) {
	this.apply_address = apply_address;
}
public String getAdmin_name() {
	return admin_name;
}
public void setAdmin_name(String admin_name) {
	this.admin_name = admin_name;
}


 
	
	
}
