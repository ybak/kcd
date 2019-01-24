package com.model1.icbc.erp;

import java.util.Date;
/**
 * 工行ERP征信模块（业征信务类型）进件详细每一步骤处理结果信息表
 * @author Administrator
 *
 */
public class erp_kj_icbc_result {
	private int id;
	private int qryid;
	private int mid_add;
	private int mid_edit;
	private Date dt_add;
	private Date dt_edit;
	private int status;
	private int status_oldht;
	private String remark;
	private int result_1_code;
	private String result_1_msg;
	private String result_1_value;
	private Date dt_sub;
	private int type_id;
	private int icbc_id;
	private String jsonAll;
	
	public String getJsonAll() {
		return jsonAll;
	}
	public void setJsonAll(String jsonAll) {
		this.jsonAll = jsonAll;
	}
	public int getStatus_oldht() {
		return status_oldht;
	}
	public void setStatus_oldht(int status_oldht) {
		this.status_oldht = status_oldht;
	}
	public int getIcbc_id() {
		return icbc_id;
	}
	public void setIcbc_id(int icbc_id) {
		this.icbc_id = icbc_id;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
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
	public Date getDt_add() {
		return dt_add;
	}
	public void setDt_add(Date dt_add) {
		this.dt_add = dt_add;
	}
	public Date getDt_edit() {
		return dt_edit;
	}
	public void setDt_edit(Date dt_edit) {
		this.dt_edit = dt_edit;
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
	public Date getDt_sub() {
		return dt_sub;
	}
	public void setDt_sub(Date dt_sub) {
		this.dt_sub = dt_sub;
	}

}
