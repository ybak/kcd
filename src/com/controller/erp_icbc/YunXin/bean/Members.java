package com.controller.erp_icbc.YunXin.bean;
/**
 * @Description:TODO
 * @author:LiWang 
 * @time:2018年8月22日
 */
public class Members{
	private String accid;//accid为用户帐号
	private boolean caller=false;//如果是通话的发起者的话，caller字段为true，否则无caller字段
	private int duration;//持续时间
	public String getAccid() {
		return accid;
	}
	public void setAccid(String accid) {
		this.accid = accid;
	}
	public boolean isCaller() {
		return caller;
	}
	public void setCaller(boolean caller) {
		this.caller = caller;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
}