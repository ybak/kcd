package com.model;

import com.util.creditutil;

public class company {
  private int cid;
  private String company;
  private String beans;
  private String pusername;
  private String ppassword;
  private String login_time=creditutil.time();
  private String ckey;
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getCompany() {
	return company;
}
public void setCompany(String company) {
	this.company = company;
}
public String getBeans() {
	return beans;
}
public void setBeans(String beans) {
	this.beans = beans;
}
public String getPusername() {
	return pusername;
}
public void setPusername(String pusername) {
	this.pusername = pusername;
}
public String getPpassword() {
	return ppassword;
}
public void setPpassword(String ppassword) {
	this.ppassword = ppassword;
}
public String getLogin_time() {
	return login_time;
}
public void setLogin_time(String login_time) {
	this.login_time = login_time;
}
public String getCkey() {
	return ckey;
}
public void setCkey(String ckey) {
	this.ckey = ckey;
}

  
  
}
