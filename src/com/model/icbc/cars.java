package com.model.icbc;

import java.math.BigDecimal;
import java.sql.Date;


public class cars {
	private int id ;	//int(11) 	否  	  	 
	private String cn ;	//enum('cars', 'checks', 'auction') 	是  	cars  	 
	private int deltag ;	//tinyint(4) 	是  	0  	 
	private int showtag ;	//tinyint(1) 	是  	1  	 
	private int sort 	;//int(11) 	是  	NULL  	 
	private int mid_add ;	//int(11) 	是  	NULL  	 
	private String dt_add ;	//datetime 	是  	NULL  	 
	private int mid_edit ;	//int(11) 	是  	NULL  	 
	private int dt_edit ;	//datetime 	是  	NULL  	 
	private int toptag ;	//int(11) 	是  	0  	 
	private int icon_chk ;	//int(1) 	是  	0  	认证图标 
	private int icon_people ;	//int(1) 	是  	0  	个人图标 
	private int icon_shop 	;//int(1) 	是  	0  	商家图标 
	private int cus_id 	;//int(11) 	是  	0  	 
	private String cus_tel ;	//varchar(255) 	是  	NULL  	 
	private String cus_name ;	//varchar(255) 	是  	NULL  	 
	private int brpid ;	//int(11) 	是  	NULL  	 
	private int brid ;	//int(11) 	是  	NULL  	 
	private int sepid; 	//int(11) 	是  	NULL  	 
	private int seid ;	//int(11) 	是  	NULL  	 
	private int cid 	;//int(11) 	是  	NULL  	 
	private int stateid ;//	int(11) 	是  	NULL  	 
	private int cityid ;	//int(11) 	是  	NULL  	 
	private String title ;	//varchar(255) 	是  	NULL  	 
	private String imgurl ;	//varchar(255) 	是  	NULL  	 
	private String imgs ;	//text 	是  	NULL  	 
	private int carstp ;	//int(11) 	是  	NULL  	车辆类型 
	private float price ;	//float(11,2) 	是  	NULL  	报价 
	private float price_new ;	//float(11,2) 	是  	NULL  	新车报价 
	private String cyear ;	//year(4) 	是  	NULL  	年份 
	private int cmonth ; //int(11) 	是  	NULL  	月份 
	private float clong ;	//float(11,2) 	是  	NULL  	里程 
	private int amtp ;	//int(11) 	是  	NULL  	自动或手动 
	private float pailiang ;	//float(11,1) 	是  	NULL  	排量 
	private int pfbz ;	//int(11) 	是  	NULL  	排放标准 
	private String yanse ;	//varchar(50) 	是  	NULL  	颜色 
	private int jiegou ;	//int(11) 	是  	NULL  	车身结构 
	private String nianjian ;	//varchar(50) 	是  	NULL  	年检时间 
	private String jiaoqx 	;//varchar(50) 	是  	NULL  	交强险时间 
	private String shangyx ;	//varchar(50) 	是  	NULL  	商业险时间 
	private int guohu 	;//int(11) 	是  	0  	过户次数 
	private String note ;	//longtext 	是  	NULL  	 
	private String chker ;	//int(11) 	是  	NULL  	鉴定人 
	private Date chk_dt ;	//date 	是  	NULL  	鉴定时间 
	private int chk_score ;	//int(11) 	是  	NULL  	鉴定分数 
	private String chk_note ;	//varchar(255) 	是  	NULL  	 
	private int chk_aq ;	//int(11) 	是  	NULL  	安全检测得分 
	private int chk_ck ;	//int(11) 	是  	NULL  	操控检测得分 
	private int chk_sg; 	//int(11) 	是  	NULL  	事故检测得分 
	private int chk_qm ;	//int(11) 	是  	NULL  	漆面检测得分 
	private String chk_pz; 	//text 	是  	NULL  	配置检测JSON 
	private String chk_cs ;	//text 	是  	NULL  	参数检测JSON 
	private int identify_id ;	//int(11) 	是  	0  	 
	private String auction_dtb; 	//datetime 	是  	NULL  	 
	private String auction_dte ;	//datetime 	是  	NULL  	 
	private String carnum 	;//varchar(255) 	是  	NULL  	车牌 
	private int loantag ;	//int(11) 	否  	0  	是否显示在理财通 
	private String fpay ;	//varchar(255) 	是  	NULL  	首付 
	private String mpay ;	//varchar(255) 	是  	NULL  	月供 
	private String periods; 	//varchar(255) 	是  	NULL  	期数 
	private BigDecimal auction_deposit; 	//decimal(10,2) 	是  	0.00  	保证金 
	private String c_tel ;	//varchar(255) 	是  	NULL  	商家电话 
	private String c_name; 	//varchar(255) 	是  	NULL  	商家明晨 
	private BigDecimal auction_deposit_end; 	//decimal(10,2) 	是  	NULL  	最高保证金 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCn() {
		return cn;
	}
	public void setCn(String cn) {
		this.cn = cn;
	}
	public int getDeltag() {
		return deltag;
	}
	public void setDeltag(int deltag) {
		this.deltag = deltag;
	}
	public int getShowtag() {
		return showtag;
	}
	public void setShowtag(int showtag) {
		this.showtag = showtag;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public int getMid_add() {
		return mid_add;
	}
	public void setMid_add(int mid_add) {
		this.mid_add = mid_add;
	}
	public String getDt_add() {
		return dt_add;
	}
	public void setDt_add(String dt_add) {
		this.dt_add = dt_add;
	}
	public int getMid_edit() {
		return mid_edit;
	}
	public void setMid_edit(int mid_edit) {
		this.mid_edit = mid_edit;
	}
	public int getDt_edit() {
		return dt_edit;
	}
	public void setDt_edit(int dt_edit) {
		this.dt_edit = dt_edit;
	}
	public int getToptag() {
		return toptag;
	}
	public void setToptag(int toptag) {
		this.toptag = toptag;
	}
	public int getIcon_chk() {
		return icon_chk;
	}
	public void setIcon_chk(int icon_chk) {
		this.icon_chk = icon_chk;
	}
	public int getIcon_people() {
		return icon_people;
	}
	public void setIcon_people(int icon_people) {
		this.icon_people = icon_people;
	}
	public int getIcon_shop() {
		return icon_shop;
	}
	public void setIcon_shop(int icon_shop) {
		this.icon_shop = icon_shop;
	}
	public int getCus_id() {
		return cus_id;
	}
	public void setCus_id(int cus_id) {
		this.cus_id = cus_id;
	}
	public String getCus_tel() {
		return cus_tel;
	}
	public void setCus_tel(String cus_tel) {
		this.cus_tel = cus_tel;
	}
	public String getCus_name() {
		return cus_name;
	}
	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
	}
	public int getBrpid() {
		return brpid;
	}
	public void setBrpid(int brpid) {
		this.brpid = brpid;
	}
	public int getBrid() {
		return brid;
	}
	public void setBrid(int brid) {
		this.brid = brid;
	}
	public int getSepid() {
		return sepid;
	}
	public void setSepid(int sepid) {
		this.sepid = sepid;
	}
	public int getSeid() {
		return seid;
	}
	public void setSeid(int seid) {
		this.seid = seid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getStateid() {
		return stateid;
	}
	public void setStateid(int stateid) {
		this.stateid = stateid;
	}
	public int getCityid() {
		return cityid;
	}
	public void setCityid(int cityid) {
		this.cityid = cityid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getImgs() {
		return imgs;
	}
	public void setImgs(String imgs) {
		this.imgs = imgs;
	}
	public int getCarstp() {
		return carstp;
	}
	public void setCarstp(int carstp) {
		this.carstp = carstp;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getPrice_new() {
		return price_new;
	}
	public void setPrice_new(float price_new) {
		this.price_new = price_new;
	}
	public String getCyear() {
		return cyear;
	}
	public void setCyear(String cyear) {
		this.cyear = cyear;
	}
	public int getCmonth() {
		return cmonth;
	}
	public void setCmonth(int cmonth) {
		this.cmonth = cmonth;
	}
	public float getClong() {
		return clong;
	}
	public void setClong(float clong) {
		this.clong = clong;
	}
	public int getAmtp() {
		return amtp;
	}
	public void setAmtp(int amtp) {
		this.amtp = amtp;
	}
	public float getPailiang() {
		return pailiang;
	}
	public void setPailiang(float pailiang) {
		this.pailiang = pailiang;
	}
	public int getPfbz() {
		return pfbz;
	}
	public void setPfbz(int pfbz) {
		this.pfbz = pfbz;
	}
	public String getYanse() {
		return yanse;
	}
	public void setYanse(String yanse) {
		this.yanse = yanse;
	}
	public int getJiegou() {
		return jiegou;
	}
	public void setJiegou(int jiegou) {
		this.jiegou = jiegou;
	}
	public String getNianjian() {
		return nianjian;
	}
	public void setNianjian(String nianjian) {
		this.nianjian = nianjian;
	}
	public String getJiaoqx() {
		return jiaoqx;
	}
	public void setJiaoqx(String jiaoqx) {
		this.jiaoqx = jiaoqx;
	}
	public String getShangyx() {
		return shangyx;
	}
	public void setShangyx(String shangyx) {
		this.shangyx = shangyx;
	}
	public int getGuohu() {
		return guohu;
	}
	public void setGuohu(int guohu) {
		this.guohu = guohu;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getChker() {
		return chker;
	}
	public void setChker(String chker) {
		this.chker = chker;
	}
	public Date getChk_dt() {
		return chk_dt;
	}
	public void setChk_dt(Date chk_dt) {
		this.chk_dt = chk_dt;
	}
	public int getChk_score() {
		return chk_score;
	}
	public void setChk_score(int chk_score) {
		this.chk_score = chk_score;
	}
	public String getChk_note() {
		return chk_note;
	}
	public void setChk_note(String chk_note) {
		this.chk_note = chk_note;
	}
	public int getChk_aq() {
		return chk_aq;
	}
	public void setChk_aq(int chk_aq) {
		this.chk_aq = chk_aq;
	}
	public int getChk_ck() {
		return chk_ck;
	}
	public void setChk_ck(int chk_ck) {
		this.chk_ck = chk_ck;
	}
	public int getChk_sg() {
		return chk_sg;
	}
	public void setChk_sg(int chk_sg) {
		this.chk_sg = chk_sg;
	}
	public int getChk_qm() {
		return chk_qm;
	}
	public void setChk_qm(int chk_qm) {
		this.chk_qm = chk_qm;
	}
	public String getChk_pz() {
		return chk_pz;
	}
	public void setChk_pz(String chk_pz) {
		this.chk_pz = chk_pz;
	}
	public String getChk_cs() {
		return chk_cs;
	}
	public void setChk_cs(String chk_cs) {
		this.chk_cs = chk_cs;
	}
	public int getIdentify_id() {
		return identify_id;
	}
	public void setIdentify_id(int identify_id) {
		this.identify_id = identify_id;
	}
	public String getAuction_dtb() {
		return auction_dtb;
	}
	public void setAuction_dtb(String auction_dtb) {
		this.auction_dtb = auction_dtb;
	}
	public String getAuction_dte() {
		return auction_dte;
	}
	public void setAuction_dte(String auction_dte) {
		this.auction_dte = auction_dte;
	}
	public String getCarnum() {
		return carnum;
	}
	public void setCarnum(String carnum) {
		this.carnum = carnum;
	}
	public int getLoantag() {
		return loantag;
	}
	public void setLoantag(int loantag) {
		this.loantag = loantag;
	}
	public String getFpay() {
		return fpay;
	}
	public void setFpay(String fpay) {
		this.fpay = fpay;
	}
	public String getMpay() {
		return mpay;
	}
	public void setMpay(String mpay) {
		this.mpay = mpay;
	}
	public String getPeriods() {
		return periods;
	}
	public void setPeriods(String periods) {
		this.periods = periods;
	}
	public BigDecimal getAuction_deposit() {
		return auction_deposit;
	}
	public void setAuction_deposit(BigDecimal auction_deposit) {
		this.auction_deposit = auction_deposit;
	}
	public String getC_tel() {
		return c_tel;
	}
	public void setC_tel(String c_tel) {
		this.c_tel = c_tel;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public BigDecimal getAuction_deposit_end() {
		return auction_deposit_end;
	}
	public void setAuction_deposit_end(BigDecimal auction_deposit_end) {
		this.auction_deposit_end = auction_deposit_end;
	}


}
