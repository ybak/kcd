package com.model1;

public class carseries {
    private int id; 	//int(11) 	否  	  	 
    private int brand_id ;	//int(11) 	是  	NULL  	 
    private String name ;	//varchar(255) 	是  	NULL  	名称 
	private String alias ;	//varchar(255) 	是  	NULL  	别名 
	private String group_name ;	//varchar(255) 	是  	NULL  	车系分组（可有可无） 
	private String logo ;	//varchar(255) 	是  	NULL  	LOGO 
	private String imgurl ;//	varchar(255) 	是  	NULL  	图片 
	private int status ;//	tinyint(4) 	否  	1  	 
	private int create_time ;	//int(10) 	是  	NULL  	 
	private int update_time ;	//int(10) 	是  	NULL  	 
	private int id1;	//int(11) 	是  	NULL  	第一版ID 
	private String namepy ;	//varchar(255) 	是  	NULL  	品牌拼音 
	private String tp_title ;	//varchar(255) 	是  	  	车辆类型 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(int brand_id) {
		this.brand_id = brand_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getCreate_time() {
		return create_time;
	}
	public void setCreate_time(int create_time) {
		this.create_time = create_time;
	}
	public int getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(int update_time) {
		this.update_time = update_time;
	}
	public int getId1() {
		return id1;
	}
	public void setId1(int id1) {
		this.id1 = id1;
	}
	public String getNamepy() {
		return namepy;
	}
	public void setNamepy(String namepy) {
		this.namepy = namepy;
	}
	public String getTp_title() {
		return tp_title;
	}
	public void setTp_title(String tp_title) {
		this.tp_title = tp_title;
	}
	
	
	
}
