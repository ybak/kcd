package com.controller.erp_icbc;
/**
 * 传入参数 
 * @author Administrator
 *
 */
public class body {
	  private String size;//每页数量
	  private String pagenow;//当前页数
	  private String querytype;//查询类型
	  private String bc_status;//状态
	  private String agp;//板块标注
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getPagenow() {
		return pagenow;
	}
	public void setPagenow(String pagenow) {
		this.pagenow = pagenow;
	}
	public String getQuerytype() {
		return querytype;
	}
	public void setQuerytype(String querytype) {
		this.querytype = querytype;
	}
	public String getBc_status() {
		return bc_status;
	}
	public void setBc_status(String bc_status) {
		this.bc_status = bc_status;
	}
	public String getAgp() {
		return agp;
	}
	public void setAgp(String agp) {
		this.agp = agp;
	}
	
	
	
}
