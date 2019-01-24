package com.model1.icbc.erp;

import java.util.Date;
/**
 * 工行ERP角色权限表/权限组表
 * @author Administrator
 *
 */
public class admin_agp {
	private int id;
	private String name;
	private int dt_add;
	private String purview_map;
	private int showtag;
	private int mid_add;
	private int gems_fs_id;
	private int mid_edit;
	private Date dt_edit;
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
	public int getDt_add() {
		return dt_add;
	}
	public void setDt_add(int dt_add) {
		this.dt_add = dt_add;
	}
	public String getPurview_map() {
		return purview_map;
	}
	public void setPurview_map(String purview_map) {
		this.purview_map = purview_map;
	}
	public int getShowtag() {
		return showtag;
	}
	public void setShowtag(int showtag) {
		this.showtag = showtag;
	}
	public int getMid_add() {
		return mid_add;
	}
	public void setMid_add(int mid_add) {
		this.mid_add = mid_add;
	}
	public int getGems_fs_id() {
		return gems_fs_id;
	}
	public void setGems_fs_id(int gems_fs_id) {
		this.gems_fs_id = gems_fs_id;
	}
	public int getMid_edit() {
		return mid_edit;
	}
	public void setMid_edit(int mid_edit) {
		this.mid_edit = mid_edit;
	}
	public Date getDt_edit() {
		return dt_edit;
	}
	public void setDt_edit(Date dt_edit) {
		this.dt_edit = dt_edit;
	}

}
