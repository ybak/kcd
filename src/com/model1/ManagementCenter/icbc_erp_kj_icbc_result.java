package com.model1.ManagementCenter;
//订单进度小状态表
public class icbc_erp_kj_icbc_result {
	private int id;
	private int qryid;   //查询的ID
	private int mid_add;
	private int mid_edit;
	private String dt_add;  //  新建时间
	private String dt_edit; //  最后修改时间
	private int status;     //  对应15个版块下的小模块
	private int status_oldht;   //对应老后台状态
	private String remark;      //描述
	private int result_1_code;    //对应第一步相关审核操作代码
	private String result_1_msg;   //第一步操作具体信息
	private String result_1_value;  //第一步需要保存的相关的值
	private String dt_sub;     //    提交时间
	private int type_id;      //     业务类型
	private int icbc_id;      //    对应主订单id
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQryid() {
		return qryid;
	}
	public void setQryid(int qryid) {
		this.qryid = qryid;
	}
	public int getMid_add() {
		return mid_add;
	}
	public void setMid_add(int mid_add) {
		this.mid_add = mid_add;
	}
	public int getMid_edit() {
		return mid_edit;
	}
	public void setMid_edit(int mid_edit) {
		this.mid_edit = mid_edit;
	}
	public String getDt_add() {
		return dt_add;
	}
	public void setDt_add(String dt_add) {
		this.dt_add = dt_add;
	}
	public String getDt_edit() {
		return dt_edit;
	}
	public void setDt_edit(String dt_edit) {
		this.dt_edit = dt_edit;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getStatus_oldht() {
		return status_oldht;
	}
	public void setStatus_oldht(int status_oldht) {
		this.status_oldht = status_oldht;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getResult_1_code() {
		return result_1_code;
	}
	public void setResult_1_code(int result_1_code) {
		this.result_1_code = result_1_code;
	}
	public String getResult_1_msg() {
		return result_1_msg;
	}
	public void setResult_1_msg(String result_1_msg) {
		this.result_1_msg = result_1_msg;
	}
	public String getResult_1_value() {
		return result_1_value;
	}
	public void setResult_1_value(String result_1_value) {
		this.result_1_value = result_1_value;
	}
	public String getDt_sub() {
		return dt_sub;
	}
	public void setDt_sub(String dt_sub) {
		this.dt_sub = dt_sub;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public int getIcbc_id() {
		return icbc_id;
	}
	public void setIcbc_id(int icbc_id) {
		this.icbc_id = icbc_id;
	}


}
