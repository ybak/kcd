/**
 * 2017-10-28
 * @author zhuyilong
 * 银行卡流水(暂停服务)
 */
package com.model1;

public class yhkls {

	private int id;//数据编号
	private int mid_add;//建单人id
	private int mid_edit;//最后编辑人id
	private String dt_add;//创建时间
	private String dt_edit;//更新时间
	private int bc_status;//查询状态
	private int query_type;//查询类型,0为储蓄卡，1位信用卡
	private int gems_id;//商户端ID
	private int gems_fs_id;//商户端店铺ID
	private String gems_code;//订单号
	private String c_name;//客户姓名
	private String c_tel;//客户电话
	private String c_cardno;//客户身份证
	private String api_taskNo;//任务号
	private String api_resultcode;//
	private String api_status;//
	private String api_message;//返回消息
	private String api_result;//
	private int api_t1_patchCode;//补充任务1，字段1
	private String api_t1_data;//补充任务1，字段1
	private String api_t2_data_bankCode;//补充任务1，字段1
	private String api_t2_data_loginParamType;//补充任务1，字段1
	private String api_t2_data_loginEntrance;//补充任务1，字段1
	private String api_t2_data_loginTypeld;//补充任务1，字段1
	private String api_t2_data_loginFields;//补充任务1，字段1
	private int api_t2_patchCode;//api_t2_patchCode
	private String api_t2_result;//
	
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
	public String getApi_taskNo() {
		return api_taskNo;
	}
	public void setApi_taskNo(String api_taskNo) {
		this.api_taskNo = api_taskNo;
	}
	public String getApi_resultcode() {
		return api_resultcode;
	}
	public void setApi_resultcode(String api_resultcode) {
		this.api_resultcode = api_resultcode;
	}
	public String getApi_status() {
		return api_status;
	}
	public void setApi_status(String api_status) {
		this.api_status = api_status;
	}
	public String getApi_message() {
		return api_message;
	}
	public void setApi_message(String api_message) {
		this.api_message = api_message;
	}
	public String getApi_result() {
		return api_result;
	}
	public void setApi_result(String api_result) {
		this.api_result = api_result;
	}
	public int getApi_t1_patchCode() {
		return api_t1_patchCode;
	}
	public void setApi_t1_patchCode(int api_t1_patchCode) {
		this.api_t1_patchCode = api_t1_patchCode;
	}
	public String getApi_t1_data() {
		return api_t1_data;
	}
	public void setApi_t1_data(String api_t1_data) {
		this.api_t1_data = api_t1_data;
	}
	public String getApi_t2_data_bankCode() {
		return api_t2_data_bankCode;
	}
	public void setApi_t2_data_bankCode(String api_t2_data_bankCode) {
		this.api_t2_data_bankCode = api_t2_data_bankCode;
	}
	public String getApi_t2_data_loginParamType() {
		return api_t2_data_loginParamType;
	}
	public void setApi_t2_data_loginParamType(String api_t2_data_loginParamType) {
		this.api_t2_data_loginParamType = api_t2_data_loginParamType;
	}
	public String getApi_t2_data_loginEntrance() {
		return api_t2_data_loginEntrance;
	}
	public void setApi_t2_data_loginEntrance(String api_t2_data_loginEntrance) {
		this.api_t2_data_loginEntrance = api_t2_data_loginEntrance;
	}
	public String getApi_t2_data_loginTypeld() {
		return api_t2_data_loginTypeld;
	}
	public void setApi_t2_data_loginTypeld(String api_t2_data_loginTypeld) {
		this.api_t2_data_loginTypeld = api_t2_data_loginTypeld;
	}
	public String getApi_t2_data_loginFields() {
		return api_t2_data_loginFields;
	}
	public void setApi_t2_data_loginFields(String api_t2_data_loginFields) {
		this.api_t2_data_loginFields = api_t2_data_loginFields;
	}
	public int getApi_t2_patchCode() {
		return api_t2_patchCode;
	}
	public void setApi_t2_patchCode(int api_t2_patchCode) {
		this.api_t2_patchCode = api_t2_patchCode;
	}
	public String getApi_t2_result() {
		return api_t2_result;
	}
	public void setApi_t2_result(String api_t2_result) {
		this.api_t2_result = api_t2_result;
	}
	
	
	
	
	
}
