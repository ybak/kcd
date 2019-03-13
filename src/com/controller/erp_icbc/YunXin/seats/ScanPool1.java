package com.controller.erp_icbc.YunXin.seats;
/** 
 * 扫描池 
 * @author:LiWang
 */
public class ScanPool1 extends SP{
	private String Id;
	//当前时间-开始占用的时间 =被占用的时间长度
	private Long createTime=0L;
	private Integer delmark;
	//银行id
	private String bankId;
	//单次通话的最大的占用时间 
	private int validtime=900000;//15分钟=900000
	//在线的有效时间 客户端轮训时间一定要比这个小,保证这个在线处于激活状态
	private int onlinetime=300000;//5分钟=300000
	//客户
	private  String clientAccid;
	private  String clientToken;
	//审核
	private String auditAccid;
	private String auditToken;
	//这里预留扩展，针对不同银行的视频面前时长可能不同的情况
	public ScanPool1(int onlinetime,int validtime){
		this.onlinetime=onlinetime;
		this.validtime=validtime;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public Integer getDelmark() {
		return delmark;
	}

	public void setDelmark(Integer delmark) {
		this.delmark = delmark;
	}

	public ScanPool1(){};
	
	public Long getCreateTime(){
		return createTime;
	}
	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public void setCreateTime(Long createTime){
		this.createTime = createTime;
	}
	public String getClientAccid() {
		return clientAccid;
	}
	public void setClientAccid(String clientAccid) {
		this.clientAccid = clientAccid;
	}
	public String getClientToken() {
		return clientToken;
	}
	public void setClientToken(String clientToken) {
		this.clientToken = clientToken;
	}
	public String getAuditAccid() {
		return auditAccid;
	}
	public void setAuditAccid(String auditAccid) {
		this.auditAccid = auditAccid;
	}
	public String getAuditToken() {
		return auditToken;
	}
	public void setAuditToken(String auditToken) {
		this.auditToken = auditToken;
	}

	public int getValidtime() {
		return validtime;
	}
	public void setValidtime(int validtime) {
		this.validtime = validtime;
	}
	public int getOnlinetime() {
		return onlinetime;
	}
	public void setOnlinetime(int onlinetime) {
		this.onlinetime = onlinetime;
	}

	@Override
	public String toString() {
		return "ScanPool1 [mark=" + super.mark + ", createTime=" + createTime + ", delmark=" + delmark + ", bankId=" + bankId + ", validtime="
				+ validtime + ", onlinetime=" + onlinetime + ", clientAccid=" + clientAccid + ", clientToken="
				+ clientToken + ", auditAccid=" + auditAccid + ", auditToken=" + auditToken + "]";
	}
	
}
