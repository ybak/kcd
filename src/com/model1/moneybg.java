/**
 * 2017-10-31
 * @author ZYL
 * 还款计划表
 */
package com.model1;

public class moneybg {

	private int id;//数据编号
	private int deltag;
	private int mid;//用户ID
	private int load_id;//标的ID
	private String amount;//金额
	private String use_long;
	private String rate;
	private int status;//交易状态:0=创建,-1=失败,1=成功
	private String remark;
	private int create_time;//成功时间
	private int update_time;//修改时间
	private int type;//类型，1为还款，2为借款
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDeltag() {
		return deltag;
	}
	public void setDeltag(int deltag) {
		this.deltag = deltag;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getLoad_id() {
		return load_id;
	}
	public void setLoad_id(int load_id) {
		this.load_id = load_id;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getUse_long() {
		return use_long;
	}
	public void setUse_long(String use_long) {
		this.use_long = use_long;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
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
	public int getCreate_time() {
		return create_time;
	}
	public void setCreate_time(int create_time) {
		this.create_time = create_time;
	}
	public int getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(int update_time) {
		this.update_time = update_time;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
	
	
}
