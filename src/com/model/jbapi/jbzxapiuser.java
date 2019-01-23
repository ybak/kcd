package com.model.jbapi;

import java.util.List;

import com.model.CBS.CbsSuccessfulPurchaseQueryReport;

public class jbzxapiuser {
private int id;
private String appkey;
private String api_name;
private String api_tel;
private String api_card;
private String api_companyname;
private String api_companyaddress;
private String api_uptime;
private String api_addtime;
private String api_money;
private int api_type;
private List<CbsSuccessfulPurchaseQueryReport> clist;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getAppkey() {
	return appkey;
}
public void setAppkey(String appkey) {
	this.appkey = appkey;
}
public String getApi_name() {
	return api_name;
}
public void setApi_name(String api_name) {
	this.api_name = api_name;
}
public String getApi_tel() {
	return api_tel;
}
public void setApi_tel(String api_tel) {
	this.api_tel = api_tel;
}
public String getApi_card() {
	return api_card;
}
public void setApi_card(String api_card) {
	this.api_card = api_card;
}
public String getApi_companyname() {
	return api_companyname;
}
public void setApi_companyname(String api_companyname) {
	this.api_companyname = api_companyname;
}
public String getApi_companyaddress() {
	return api_companyaddress;
}
public void setApi_companyaddress(String api_companyaddress) {
	this.api_companyaddress = api_companyaddress;
}
public String getApi_uptime() {
	return api_uptime;
}
public void setApi_uptime(String api_uptime) {
	this.api_uptime = api_uptime;
}
public String getApi_addtime() {
	return api_addtime;
}
public void setApi_addtime(String api_addtime) {
	this.api_addtime = api_addtime;
}
public String getApi_money() {
	return api_money;
}
public void setApi_money(String api_money) {
	this.api_money = api_money;
}
public int getApi_type() {
	return api_type;
}
public void setApi_type(int api_type) {
	this.api_type = api_type;
}
public List<CbsSuccessfulPurchaseQueryReport> getClist() {
	return clist;
}
public void setClist(List<CbsSuccessfulPurchaseQueryReport> clist) {
	this.clist = clist;
}



}
