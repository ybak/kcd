package com.model.icbc;

public class assess_color {
private int	id ;	//int(11) 	否  	  	 
private int	brid ;	//int(11) 	是  	NULL  	 
private int	seid ;	//int(11) 	是  	NULL  	 
private int	carid ;//	int(11) 	是  	NULL  	 
private int	color ;	//int(11) 	是  	NULL  	 
private String	name ;	//varchar(45) 	是  	NULL  	 
private String	color_rgb; // 	varchar(7) 	是  	NULL  	 
private float	score ;	//float(11,1) 	是  	NULL 
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getBrid() {
	return brid;
}
public void setBrid(int brid) {
	this.brid = brid;
}
public int getSeid() {
	return seid;
}
public void setSeid(int seid) {
	this.seid = seid;
}
public int getCarid() {
	return carid;
}
public void setCarid(int carid) {
	this.carid = carid;
}
public int getColor() {
	return color;
}
public void setColor(int color) {
	this.color = color;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getColor_rgb() {
	return color_rgb;
}
public void setColor_rgb(String color_rgb) {
	this.color_rgb = color_rgb;
}
public float getScore() {
	return score;
}
public void setScore(float score) {
	this.score = score;
}


}
