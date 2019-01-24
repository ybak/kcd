package com.model;

public class ykdbb {
private int yid;
private String ycode;//订单编码
private String yname;//客户姓名
private String yIDcard;//客户身份证号
private String sname;//区域查询人姓名
private String saccount;//查询人账号
private String sIDcard;//查询人身份证号
private String yfretrun;//是否回寄
private String yf_time;//回寄时间
private String search_date;//查询日期
private String success_date;//查询成功日期
public int getYid() {
	return yid;
}
public void setYid(int yid) {
	this.yid = yid;
}
public String getYcode() {
	return ycode;
}
public void setYcode(String ycode) {
	this.ycode = ycode;
}
public String getYname() {
	return yname;
}
public void setYname(String yname) {
	this.yname = yname;
}
public String getyIDcard() {
	return yIDcard;
}
public void setyIDcard(String yIDcard) {
	this.yIDcard = yIDcard;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public String getSaccount() {
	return saccount;
}
public void setSaccount(String saccount) {
	this.saccount = saccount;
}
public String getsIDcard() {
	return sIDcard;
}
public void setsIDcard(String sIDcard) {
	this.sIDcard = sIDcard;
}
public String getYfretrun() {
	return yfretrun;
}
public void setYfretrun(String yfretrun) {
	this.yfretrun = yfretrun;
}
public String getYf_time() {
	return yf_time;
}
public void setYf_time(String yf_time) {
	this.yf_time = yf_time;
}
public String getSearch_date() {
	return search_date;
}
public void setSearch_date(String search_date) {
	this.search_date = search_date;
}
public String getSuccess_date() {
	return success_date;
}
public void setSuccess_date(String success_date) {
	this.success_date = success_date;
}


	
	
}
