package com.model1;

public class queryzx {
 private int id;
 private String dt_add;//建单时间
 private String dt_edit;//最后更新时间 
 private String c_name;//客户姓名
 private String c_tel;//客户电话
 private String gems_code;//订单号
 private String result_pdf;//征信结果PDF 
 private String c_card_no; //被查询人身份证
 private String c_book_no;//授权书编码
 private String dt_ﬁn;//查询完成时间
 private String cs_tag;//初审状态,1为已经通过,
 private int gems_id;//商户端提交人ID,对应与assess_gems表里面 的id 
 private int gems_fs_id;//商户端公司ID,对应assess_fs表 
 private String book_status;//是否回寄 为0时,就是没收到,1,2,3是已经收到并且已经处理
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
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
public String getGems_code() {
	return gems_code;
}
public void setGems_code(String gems_code) {
	this.gems_code = gems_code;
}
public String getResult_pdf() {
	return result_pdf;
}
public void setResult_pdf(String result_pdf) {
	this.result_pdf = result_pdf;
}
public String getC_card_no() {
	return c_card_no;
}
public void setC_card_no(String c_card_no) {
	this.c_card_no = c_card_no;
}
public String getC_book_no() {
	return c_book_no;
}
public void setC_book_no(String c_book_no) {
	this.c_book_no = c_book_no;
}
public String getDt_ﬁn() {
	return dt_ﬁn;
}
public void setDt_ﬁn(String dt_ﬁn) {
	this.dt_ﬁn = dt_ﬁn;
}
public String getCs_tag() {
	return cs_tag;
}
public void setCs_tag(String cs_tag) {
	this.cs_tag = cs_tag;
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
public String getBook_status() {
	return book_status;
}
public void setBook_status(String book_status) {
	this.book_status = book_status;
}

 
 
}
