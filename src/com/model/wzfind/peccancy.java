/**
 * 违章查询
 */
package com.model.wzfind;

public class peccancy {
private int id;//
private String authority;//车管局或车牌所在地
private String carprefix;//车牌前缀
private String carrest;//车牌剩余部分
private String cartype;//车辆类型 默认小车02
private String vinno;//车架号 根据管局需要输入
private String engineno;//发动机号 根据管局需要输入
private int iscity;//是否返回城市 1返回 默认0不返回 不一定100%返回结果，准确度90% town、lat、lng仅供参考
private String mobile;//手机号 浙江直连需要手机号
private int ckeyid;//连接ckey用户的id
private String orderno;//订单编号
private String resultmsg;//返回结果信息
private int orderstate;//订单状态
private String addtime;
private String uptime;
private String pname;
private String gname;
private String price;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getAuthority() {
	return authority;
}
public void setAuthority(String authority) {
	this.authority = authority;
}
public String getCarprefix() {
	return carprefix;
}
public void setCarprefix(String carprefix) {
	this.carprefix = carprefix;
}
public String getCarrest() {
	return carrest;
}
public void setCarrest(String carrest) {
	this.carrest = carrest;
}
public String getCartype() {
	return cartype;
}
public void setCartype(String cartype) {
	this.cartype = cartype;
}
public String getVinno() {
	return vinno;
}
public void setVinno(String vinno) {
	this.vinno = vinno;
}
public String getEngineno() {
	return engineno;
}
public void setEngineno(String engineno) {
	this.engineno = engineno;
}
public int getIscity() {
	return iscity;
}
public void setIscity(int iscity) {
	this.iscity = iscity;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public int getCkeyid() {
	return ckeyid;
}
public void setCkeyid(int ckeyid) {
	this.ckeyid = ckeyid;
}
public String getOrderno() {
	return orderno;
}
public void setOrderno(String orderno) {
	this.orderno = orderno;
}
public String getResultmsg() {
	return resultmsg;
}
public void setResultmsg(String resultmsg) {
	this.resultmsg = resultmsg;
}
public int getOrderstate() {
	return orderstate;
}
public void setOrderstate(int orderstate) {
	this.orderstate = orderstate;
}
public String getAddtime() {
	return addtime;
}
public void setAddtime(String addtime) {
	this.addtime = addtime;
}
public String getUptime() {
	return uptime;
}
public void setUptime(String uptime) {
	this.uptime = uptime;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public String getGname() {
	return gname;
}
public void setGname(String gname) {
	this.gname = gname;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}


}
