package com.model1.icbc.erp;

/**还款表
 * @Description:TODO
 * @author:LiWang
 * @time:2018年7月29日
 */
public class HK{
	private String hid;
	private String kk_id;
	private String hk_date;
	private String hk_money;
	private String hk_periods;//还款周期
	private int u_id;
	public String getHid() {
		return hid;
	}
	public void setHid(String hid) {
		this.hid = hid;
	}
	public String getKk_id() {
		return kk_id;
	}
	public void setKk_id(String kk_id) {
		this.kk_id = kk_id;
	}
	public String getHk_date() {
		return hk_date;
	}
	public void setHk_date(String hk_date) {
		this.hk_date = hk_date;
	}
	public String getHk_money() {
		return hk_money;
	}
	public void setHk_money(String hk_money) {
		this.hk_money = hk_money;
	}
	
	public String getHk_periods() {
		return hk_periods;
	}
	public void setHk_periods(String hk_periods) {
		this.hk_periods = hk_periods;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
}
