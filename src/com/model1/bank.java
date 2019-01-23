package com.model1;

public class bank {
	
	private int id;//数据编号
	private String code;//代码
	private String name;//银行名
	private int tag;//
	private int deltag;//删除标志
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTag() {
		return tag;
	}
	public void setTag(int tag) {
		this.tag = tag;
	}
	public int getDeltag() {
		return deltag;
	}
	public void setDeltag(int deltag) {
		this.deltag = deltag;
	}


}
