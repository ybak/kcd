package com.model1.icbc.erp;
/**
 * 工行ERP任务名称表
 * @author Administrator
 *
 */
public class commtaskname {
	private int id;
	private String name;
	private int erp_btype_id;
	private int status;
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
	public int getErp_btype_id() {
		return erp_btype_id;
	}
	public void setErp_btype_id(int erp_btype_id) {
		this.erp_btype_id = erp_btype_id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

}
