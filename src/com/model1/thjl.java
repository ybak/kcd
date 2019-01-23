/**
 * 2017-10-28
 * @author zhuyilong
 * 閫氳瘽璁板綍
 */
package com.model1;

public class thjl {
	
	private int id;//数据编号
	private int mid_add;//建单人id
	private int mid_edit;//最后编辑人id
	private String dt_add;//创建时间
	private String dt_edit;//更新时间
	private int bc_status;//
	private int query_type;//0为人行查询，1为大数据查询
	private int gems_id;//商户端ID
	private int gems_fs_id;//商户端店铺ID
	private String gems_code;//订单编号
	private String c_name;//客户姓名
	private String c_tel;//客户电话
	private String c_cardno;//客户身份证号
	private String api_status;//api_status
	private String api_token;//api_token
	private String api_note;//接口返回数据
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
	public int getBc_status() {
		return bc_status;
	}
	public void setBc_status(int bc_status) {
		this.bc_status = bc_status;
	}
	public int getQuery_type() {
		return query_type;
	}
	public void setQuery_type(int query_type) {
		this.query_type = query_type;
	}
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
	public String getGems_code() {
		return gems_code;
	}
	public void setGems_code(String gems_code) {
		this.gems_code = gems_code;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_tel() {
		return c_tel;
	}
	public void setC_tel(String c_tel) {
		this.c_tel = c_tel;
	}
	public String getC_cardno() {
		return c_cardno;
	}
	public void setC_cardno(String c_cardno) {
		this.c_cardno = c_cardno;
	}
	public String getApi_status() {
		return api_status;
	}
	public void setApi_status(String api_status) {
		this.api_status = api_status;
	}
	public String getApi_token() {
		return api_token;
	}
	public void setApi_token(String api_token) {
		this.api_token = api_token;
	}
	public String getApi_note() {
		return api_note;
	}
	public void setApi_note(String api_note) {
		this.api_note = api_note;
	}
	
	
	

}
