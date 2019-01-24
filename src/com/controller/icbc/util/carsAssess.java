package com.controller.icbc.util;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public class carsAssess {
	private String mileage;//表显里程			
	private String ckey;
    private String orderid;
    private String querytype;//查询类型           
    private String oncarddate;//上牌时间
    private String vin;//vin 
    //private MultipartFile[] imgs;
    private String oredit;
    private String carcolor;
    private String brand_id;
    private String series_id;
    private String model_id;
    private String province;
    private String city;
    private List<String> imgs;
	public String getMileage() {
		return mileage;
	}
	public void setMileage(String mileage) {
		this.mileage = mileage;
	}
	public String getCkey() {
		return ckey;
	}
	public void setCkey(String ckey) {
		this.ckey = ckey;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getQuerytype() {
		return querytype;
	}
	public void setQuerytype(String querytype) {
		this.querytype = querytype;
	}
	public String getOncarddate() {
		return oncarddate;
	}
	public void setOncarddate(String oncarddate) {
		this.oncarddate = oncarddate;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getOredit() {
		return oredit;
	}
	public void setOredit(String oredit) {
		this.oredit = oredit;
	}
	public String getCarcolor() {
		return carcolor;
	}
	public void setCarcolor(String carcolor) {
		this.carcolor = carcolor;
	}
	public String getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(String brand_id) {
		this.brand_id = brand_id;
	}
	public String getSeries_id() {
		return series_id;
	}
	public void setSeries_id(String series_id) {
		this.series_id = series_id;
	}
	public String getModel_id() {
		return model_id;
	}
	public void setModel_id(String model_id) {
		this.model_id = model_id;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public List<String> getImgs() {
		return imgs;
	}
	public void setImgs(List<String> imgs) {
		this.imgs = imgs;
	}
    
}
