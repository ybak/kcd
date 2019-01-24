package com.model.icbc;
/**
 * ¹¤ĞĞ ÉóºË×´Ì¬¼ÇÂ¼
 * @author Administrator
 *
 */
public class icbc_result {
	private int id ;	//int(11) 	·ñ  	  	 
	private int qryid ;	//int(11) 	·ñ  	0  	²éÑ¯µÄID 
	private int mid_add ;	//int(11) 	·ñ  	  	 
	private int mid_edit ;	//int(11) 	·ñ  	  	 
	private String dt_add ;	//datetime 	·ñ  	  	 
	private String dt_edit ;//	datetime 	·ñ  	  	 
	private int status ;	//tinyint(4) 	·ñ  	0  	 
	private String remark; 	//varchar(255) 	·ñ  	  	ÃèÊö 
	private String statusremark; 	//varchar(255) 	·ñ  	  	ÃèÊö 
	
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getStatusremark() {
		return statusremark;
	}
	public void setStatusremark(String statusremark) {
		this.statusremark = statusremark;
	}
	
	
}
