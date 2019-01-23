package com.model.newAdd;

import java.util.List;

public class pdfdownload {
	private int PDFdownload_id;   //1 主键      
	private String PDFcode;  //2 下载pdf编号   
	private String downloadCompany;  //3 下载公司
	private int downloadNum;  //4 下载数量
	private String downloadCzr;  //5 下载人员
	private int status; //6 状态  1代表'已回收', 0代表'未回收'
	private String PDFurl;  //7 下载链接
	private String downloadTime; //8 下载时间
	private String updateTime; //9 已回收--修改时间
	private int addtype;	
	public String getPDFcode() {
		return PDFcode;
	}
	public void setPDFcode(String pDFcode) {
		PDFcode = pDFcode;
	}
	public String getDownloadTime() {
		return downloadTime;
	}
	public void setDownloadTime(String downloadTime) {
		this.downloadTime = downloadTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getPDFurl() {
		return PDFurl;
	}
	public void setPDFurl(String pDFurl) {
		PDFurl = pDFurl;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getPDFdownload_id() {
		return PDFdownload_id;
	}
	public void setPDFdownload_id(int pDFdownload_id) {
		PDFdownload_id = pDFdownload_id;
	}
	public String getDownloadCompany() {
		return downloadCompany;
	}
	public void setDownloadCompany(String downloadCompany) {
		this.downloadCompany = downloadCompany;
	}
	public int getDownloadNum() {
		return downloadNum;
	}
	public void setDownloadNum(int downloadNum) {
		this.downloadNum = downloadNum;
	}
	public String getDownloadCzr() {
		return downloadCzr;
	}
	public void setDownloadCzr(String downloadCzr) {
		this.downloadCzr = downloadCzr;
	}
	public int getAddtype() {
		return addtype;
	}
	public void setAddtype(int addtype) {
		this.addtype = addtype;
	}
	
}
