package com.model.icbc;

public class assess_cars_item {
	private int cars_id ;	//int(11) 	否  	0  	 
	private int points_id ;	//int(11) 	否  	0  	 
	private int points_tp ;	//int(11) 	是  	NULL  	 
	private int items_id ;	//int(11) 	是  	NULL  	 
	private float score ;	//float(11,2) 	是  	NULL  	 
	private String imgurl ;	//varchar(255) 	是  	  	照片 
	private String bcimg ;//varchar(255) 	是  	  	商户端上传照片 
	private String imgbase64;
	private String name;
	public int getCars_id() {
		return cars_id;
	}
	public void setCars_id(int cars_id) {
		this.cars_id = cars_id;
	}
	public int getPoints_id() {
		return points_id;
	}
	public void setPoints_id(int points_id) {
		this.points_id = points_id;
	}
	public int getPoints_tp() {
		return points_tp;
	}
	public void setPoints_tp(int points_tp) {
		this.points_tp = points_tp;
	}
	public int getItems_id() {
		return items_id;
	}
	public void setItems_id(int items_id) {
		this.items_id = items_id;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getBcimg() {
		return bcimg;
	}
	public void setBcimg(String bcimg) {
		this.bcimg = bcimg;
	}
	public String getImgbase64() {
		return imgbase64;
	}
	public void setImgbase64(String imgbase64) {
		this.imgbase64 = imgbase64;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	

}
