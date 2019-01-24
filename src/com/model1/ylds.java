/**
 * 2017-10-31
 * @author zhuyilong
 * 閾惰仈浠ｆ敹
 */
package com.model1;

public class ylds {
	private int id;//数据编号
	private int mid_add;//创建人ID
	private int mid_edit;//最后编辑人ID
	private String dt_add;//创建时间
	private String dt_edit;//最后更新时间
	private int bc_status;//审核状态
	private int gems_fs_id;//加盟店id
	private int gems_id;//商户师id
	private String REQ_SN;//交易流水号
	private int AMOUNT;//金额,分
	private String CURRENCY;//货币类型
	private String BANK_CODE;//银行代码
	private String ACCOUNT_TYPE;//账号类型,00银行卡,01存折
	private String ACCOUNT_NO;//银行卡或存折号码
	private int bank_id;//对应签约银联卡id
	private int qryid;//订单ID
	private int type;//类型
	private String api_message;//接口返回消息
	private String gems_code;//订单号
	private String SN;//银联,记录序号
	private String api_code;//api返回代码
	private int ds_type;//收/付,0为代收,1为代付
	private String api_code_detail;//明细返回代码
	private String api_msg_detail;//明细消息
	private String api_message_last;//调用查询接口后最后返回的message
	private String yy_dt;//预约执行时间
	private int yy_runtag;//是否已经执行,预约为1时有效
	private int yy_tag;//是否预约标志
	private String yy_dtruntime;//最后执行时间
	private String api_retcode_last;//最后查询返回码
	private String c_name;
	private int checkstatus;
	private String c_cardno;
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
	public int getGems_fs_id() {
		return gems_fs_id;
	}
	public void setGems_fs_id(int gems_fs_id) {
		this.gems_fs_id = gems_fs_id;
	}
	public int getGems_id() {
		return gems_id;
	}
	public void setGems_id(int gems_id) {
		this.gems_id = gems_id;
	}
	public String getREQ_SN() {
		return REQ_SN;
	}
	public void setREQ_SN(String rEQ_SN) {
		REQ_SN = rEQ_SN;
	}
	public int getAMOUNT() {
		return AMOUNT;
	}
	public void setAMOUNT(int aMOUNT) {
		AMOUNT = aMOUNT;
	}
	public String getCURRENCY() {
		return CURRENCY;
	}
	public void setCURRENCY(String cURRENCY) {
		CURRENCY = cURRENCY;
	}
	public String getBANK_CODE() {
		return BANK_CODE;
	}
	public void setBANK_CODE(String bANK_CODE) {
		BANK_CODE = bANK_CODE;
	}
	public String getACCOUNT_TYPE() {
		return ACCOUNT_TYPE;
	}
	public void setACCOUNT_TYPE(String aCCOUNT_TYPE) {
		ACCOUNT_TYPE = aCCOUNT_TYPE;
	}
	public String getACCOUNT_NO() {
		return ACCOUNT_NO;
	}
	public void setACCOUNT_NO(String aCCOUNT_NO) {
		ACCOUNT_NO = aCCOUNT_NO;
	}
	public int getBank_id() {
		return bank_id;
	}
	public void setBank_id(int bank_id) {
		this.bank_id = bank_id;
	}
	public int getQryid() {
		return qryid;
	}
	public void setQryid(int qryid) {
		this.qryid = qryid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getApi_message() {
		return api_message;
	}
	public void setApi_message(String api_message) {
		this.api_message = api_message;
	}
	public String getGems_code() {
		return gems_code;
	}
	public void setGems_code(String gems_code) {
		this.gems_code = gems_code;
	}
	public String getSN() {
		return SN;
	}
	public void setSN(String sN) {
		SN = sN;
	}
	public String getApi_code() {
		return api_code;
	}
	public void setApi_code(String api_code) {
		this.api_code = api_code;
	}
	public int getDs_type() {
		return ds_type;
	}
	public void setDs_type(int ds_type) {
		this.ds_type = ds_type;
	}
	public String getApi_code_detail() {
		return api_code_detail;
	}
	public void setApi_code_detail(String api_code_detail) {
		this.api_code_detail = api_code_detail;
	}
	public String getApi_msg_detail() {
		return api_msg_detail;
	}
	public void setApi_msg_detail(String api_msg_detail) {
		this.api_msg_detail = api_msg_detail;
	}
	public String getApi_message_last() {
		return api_message_last;
	}
	public void setApi_message_last(String api_message_last) {
		this.api_message_last = api_message_last;
	}
	public String getYy_dt() {
		return yy_dt;
	}
	public void setYy_dt(String yy_dt) {
		this.yy_dt = yy_dt;
	}
	public int getYy_runtag() {
		return yy_runtag;
	}
	public void setYy_runtag(int yy_runtag) {
		this.yy_runtag = yy_runtag;
	}
	public int getYy_tag() {
		return yy_tag;
	}
	public void setYy_tag(int yy_tag) {
		this.yy_tag = yy_tag;
	}
	public String getYy_dtruntime() {
		return yy_dtruntime;
	}
	public void setYy_dtruntime(String yy_dtruntime) {
		this.yy_dtruntime = yy_dtruntime;
	}
	public String getApi_retcode_last() {
		return api_retcode_last;
	}
	public void setApi_retcode_last(String api_retcode_last) {
		this.api_retcode_last = api_retcode_last;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public int getCheckstatus() {
		return checkstatus;
	}
	public void setCheckstatus(int checkstatus) {
		this.checkstatus = checkstatus;
	}
	public String getC_cardno() {
		return c_cardno;
	}
	public void setC_cardno(String c_cardno) {
		this.c_cardno = c_cardno;
	}
	
	
	
}
