package com.model;

import com.util.creditutil;

public class grywls {
   
	private int id;
	private String czr;
	private String cxyw;
	private String sxkd;
	private String time=creditutil.time();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCzr() {
		return czr;
	}
	public void setCzr(String czr) {
		this.czr = czr;
	}
	public String getCxyw() {
		return cxyw;
	}
	public void setCxyw(String cxyw) {
		this.cxyw = cxyw;
	}
	public String getSxkd() {
		return sxkd;
	}
	public void setSxkd(String sxkd) {
		this.sxkd = sxkd;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
	
	
}
