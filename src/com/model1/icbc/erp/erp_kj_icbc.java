package com.model1.icbc.erp;

import java.util.Date;

/**
 * 工行ERP征信模块（业征信务类型）进件表
 * @author Administrator
 *
 */
public class erp_kj_icbc {
	private int id;
	private int mid_add;
	private int mid_edit;
	private Date dt_add;
	private Date dt_edit;
	private Date dt_sub;
	private Date dt_fin;
	private int status;
	private int icbc_id;
	private int gems_id;
	private int gems_fs_id;
	private int type_id;
	private String c_name;
	private String c_carno;
	private String c_carvin;
	private String c_cardno;
	
	public int getGems_id() {
		return gems_id;
	}
	public void setGems_id(int gems_id) {
		this.gems_id = gems_id;
	}
	public int getGems_fs_id() {
		return gems_fs_id;
	}
	public void setGems_fs_id(int gems_fs_id) {
		this.gems_fs_id = gems_fs_id;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_carno() {
		return c_carno;
	}
	public void setC_carno(String c_carno) {
		this.c_carno = c_carno;
	}
	public String getC_carvin() {
		return c_carvin;
	}
	public void setC_carvin(String c_carvin) {
		this.c_carvin = c_carvin;
	}
	public String getC_cardno() {
		return c_cardno;
	}
	public void setC_cardno(String c_cardno) {
		this.c_cardno = c_cardno;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Date getDt_sub() {
		return dt_sub;
	}
	public void setDt_sub(Date dt_sub) {
		this.dt_sub = dt_sub;
	}
	public Date getDt_fin() {
		return dt_fin;
	}
	public void setDt_fin(Date dt_fin) {
		this.dt_fin = dt_fin;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getIcbc_id() {
		return icbc_id;
	}
	public void setIcbc_id(int icbc_id) {
		this.icbc_id = icbc_id;
	}

}
