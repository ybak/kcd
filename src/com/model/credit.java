package com.model;

public class credit {
  private int id;
  private String name;//名字
  private String IDcard_num;//身份证号
  private String phone_num;//手机号
  private String authorize_num;//授权书编号
  private String front;//身份证正面照
  private String opposite;//身份证背面照
  private String apply;//申请书照片
  private String authorize;//授权书照片
  private String hz;//身份证 和申请书和授权书照片
  private String add_time;//添加时间
  private String sum_bit;//状态 0 草稿  1 审核  2 审核完成 3 退回 
  private String url;//回调url
  private String up_time;
  private String mdid;
  private String shzt;
  private String gsname;
  private String ryname;
  private String c_nation;//民族
  private String c_address;//地址
  private String c_card_outdate;//身份证有效期
  private String c_card_office;//身份证发证机关
  private String c_card_type;//证件类型
  private String c_sex;//性别
  private String c_bs;//查询板式
  private String c_oldname;//曾用名
  private String c_yb;//通讯地址编码
  private int return_type;//回收状态
  private String applyimg;//申请书照片
  private String authorizeimg;//授权书照片
  private String imgbase_1;
  private String imgbase_2;
  private String imgbase_3;
  private String imgbase_4;
  private String imgbase_5;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIDcard_num() {
		return IDcard_num;
	}
	public void setIDcard_num(String iDcard_num) {
		IDcard_num = iDcard_num;
	}
	public String getPhone_num() {
		return phone_num;
	}
	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}
	public String getAuthorize_num() {
		return authorize_num;
	}
	public void setAuthorize_num(String authorize_num) {
		this.authorize_num = authorize_num;
	}
	public String getFront() {
		return front;
	}
	public void setFront(String front) {
		this.front = front;
	}
	public String getOpposite() {
		return opposite;
	}
	public void setOpposite(String opposite) {
		this.opposite = opposite;
	}
	public String getApply() {
		return apply;
	}
	public void setApply(String apply) {
		this.apply = apply;
	}
	public String getAuthorize() {
		return authorize;
	}
	public void setAuthorize(String authorize) {
		this.authorize = authorize;
	}

	public String getHz() {
		return hz;
	}
	public void setHz(String hz) {
		this.hz = hz;
	}
	public String getAdd_time() {
		return add_time;
	}
	public void setAdd_time(String add_time) {
		this.add_time = add_time;
	}
	public String getSum_bit() {
		return sum_bit;
	}
	public void setSum_bit(String sum_bit) {
		this.sum_bit = sum_bit;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUp_time() {
		return up_time;
	}
	public void setUp_time(String up_time) {
		this.up_time = up_time;
	}
	public String getMdid() {
		return mdid;
	}
	public void setMdid(String mdid) {
		this.mdid = mdid;
	}
	public String getShzt() {
		return shzt;
	}
	public void setShzt(String shzt) {
		this.shzt = shzt;
	}
	public String getGsname() {
		return gsname;
	}
	public void setGsname(String gsname) {
		this.gsname = gsname;
	}
	public String getRyname() {
		return ryname;
	}
	public void setRyname(String ryname) {
		this.ryname = ryname;
	}
	public String getC_nation() {
		return c_nation;
	}
	public void setC_nation(String c_nation) {
		this.c_nation = c_nation;
	}
	public String getC_address() {
		return c_address;
	}
	public void setC_address(String c_address) {
		this.c_address = c_address;
	}
	public String getC_card_outdate() {
		return c_card_outdate;
	}
	public void setC_card_outdate(String c_card_outdate) {
		this.c_card_outdate = c_card_outdate;
	}
	public String getC_card_office() {
		return c_card_office;
	}
	public void setC_card_office(String c_card_office) {
		this.c_card_office = c_card_office;
	}
	public String getC_card_type() {
		return c_card_type;
	}
	public void setC_card_type(String c_card_type) {
		this.c_card_type = c_card_type;
	}
	public String getC_sex() {
		return c_sex;
	}
	public void setC_sex(String c_sex) {
		this.c_sex = c_sex;
	}
	public String getC_bs() {
		return c_bs;
	}
	public void setC_bs(String c_bs) {
		this.c_bs = c_bs;
	}
	public String getC_oldname() {
		return c_oldname;
	}
	public void setC_oldname(String c_oldname) {
		this.c_oldname = c_oldname;
	}
	public String getC_yb() {
		return c_yb;
	}
	public void setC_yb(String c_yb) {
		this.c_yb = c_yb;
	}
	public String getApplyimg() {
		return applyimg;
	}
	public void setApplyimg(String applyimg) {
		this.applyimg = applyimg;
	}
	public String getAuthorizeimg() {
		return authorizeimg;
	}
	public void setAuthorizeimg(String authorizeimg) {
		this.authorizeimg = authorizeimg;
	}
	public int getReturn_type() {
		return return_type;
	}
	public void setReturn_type(int return_type) {
		this.return_type = return_type;
	}
	public String getImgbase_1() {
		return imgbase_1;
	}
	public void setImgbase_1(String imgbase_1) {
		this.imgbase_1 = imgbase_1;
	}
	public String getImgbase_2() {
		return imgbase_2;
	}
	public void setImgbase_2(String imgbase_2) {
		this.imgbase_2 = imgbase_2;
	}
	public String getImgbase_3() {
		return imgbase_3;
	}
	public void setImgbase_3(String imgbase_3) {
		this.imgbase_3 = imgbase_3;
	}
	public String getImgbase_4() {
		return imgbase_4;
	}
	public void setImgbase_4(String imgbase_4) {
		this.imgbase_4 = imgbase_4;
	}
	public String getImgbase_5() {
		return imgbase_5;
	}
	public void setImgbase_5(String imgbase_5) {
		this.imgbase_5 = imgbase_5;
	}


}
