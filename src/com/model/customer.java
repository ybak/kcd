package com.model;

import com.util.creditutil;

public class customer {
   private int id;
   private String name;
   private String account;
   private String password;
   private String level;
   private String owencompany;
   private  String login_time=creditutil.time();
   private String ckey;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAccount() {
	return account;
}
public void setAccount(String account) {
	this.account = account;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getLevel() {
	return level;
}
public void setLevel(String level) {
	this.level = level;
}
public String getOwencompany() {
	return owencompany;
}
public void setOwencompany(String owencompany) {
	this.owencompany = owencompany;
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
