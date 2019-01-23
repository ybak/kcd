package com.controller.PFmodel;
public  class Customer {
	private String sex="0"; // 性别
	private String age="0"; // 年龄
	private String  h_address;//户口所在地
	private String is_marital_status="0";//婚否 0无 1已
	private String education;//教育程度
	private String nature_of_Business;//公司性质
	private String bank_usage;//银行使用情况

	private String is_surety;//是否有担保人
	private String is_credit="0";//是否失信人 0否(默认) 1是
	private String court_execution="0";//法院被执行情况 默认是没有被执行过1已结案 2未结案
	
	private String seven_days="0";
	private String one_month="0";
	private String three_month="0";
	private String six_month="0";
	private String twelve_month="0";//十二
	
	private String uncleared_number="0";//未结清贷款笔数  多个维度相加 目前准确
	private String uncleared_monty="0";//未结清贷款金额 多维度相加
	private String  highest_overdue="0";//单月最高逾期金额 多维度最大
	private String max_credit="0";//信用卡最高额度
	private String count_credit="0";//	信用卡数量
	private String high_profile;//高端人士(职业)(B)
	private String work_day; //工作年限(B)
	private String is_two_house;//是否有第二套房产(B)
	private String is_two_car;//是否有第二辆车子(B)
	private String is_ife_insurance;//是否有人寿保险(B)
	private String is_w_blacklist;//是否在网贷黑名单
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getH_address() {
		return h_address;
	}
	public void setH_address(String h_address) {
		this.h_address = h_address;
	}
	public String getIs_marital_status() {
		return is_marital_status;
	}
	public void setIs_marital_status(String is_marital_status) {
		this.is_marital_status = is_marital_status;
	}
	
	public String getUncleared_number() {
		return uncleared_number;
	}
	public void setUncleared_number(String uncleared_number) {
		this.uncleared_number = uncleared_number;
	}
	public String getUncleared_monty() {
		return uncleared_monty;
	}
	public void setUncleared_monty(String uncleared_monty) {
		this.uncleared_monty = uncleared_monty;
	}
	public String getHighest_overdue() {
		return highest_overdue;
	}
	public void setHighest_overdue(String highest_overdue) {
		this.highest_overdue = highest_overdue;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getNature_of_Business() {
		return nature_of_Business;
	}
	public void setNature_of_Business(String nature_of_Business) {
		this.nature_of_Business = nature_of_Business;
	}
	public String getBank_usage() {
		return bank_usage;
	}
	public void setBank_usage(String bank_usage) {
		this.bank_usage = bank_usage;
	}
	public String getMax_credit() {
		return max_credit;
	}
	public void setMax_credit(String max_credit) {
		this.max_credit = max_credit;
	}
	public String getIs_surety() {
		return is_surety;
	}
	public void setIs_surety(String is_surety) {
		this.is_surety = is_surety;
	}
	public String getIs_credit() {
		return is_credit;
	}
	public void setIs_credit(String is_credit) {
		this.is_credit = is_credit;
	}
	public String getCourt_execution() {
		return court_execution;
	}
	public void setCourt_execution(String court_execution) {
		this.court_execution = court_execution;
	}
	public String getSeven_days() {
		return seven_days;
	}
	public void setSeven_days(String seven_days) {
		this.seven_days = seven_days;
	}
	public String getOne_month() {
		return one_month;
	}
	public void setOne_month(String one_month) {
		this.one_month = one_month;
	}
	public String getThree_month() {
		return three_month;
	}
	public void setThree_month(String three_month) {
		this.three_month = three_month;
	}
	public String getSix_month() {
		return six_month;
	}
	public void setSix_month(String six_month) {
		this.six_month = six_month;
	}
	public String getTwelve_month() {
		return twelve_month;
	}
	public void setTwelve_month(String twelve_month) {
		this.twelve_month = twelve_month;
	}
	public String getCount_credit() {
		return count_credit;
	}
	public void setCount_credit(String count_credit) {
		this.count_credit = count_credit;
	}
	public String getHigh_profile() {
		return high_profile;
	}
	public void setHigh_profile(String high_profile) {
		this.high_profile = high_profile;
	}
	public String getWork_day() {
		return work_day;
	}
	public void setWork_day(String work_day) {
		this.work_day = work_day;
	}
	public String getIs_two_house() {
		return is_two_house;
	}
	public void setIs_two_house(String is_two_house) {
		this.is_two_house = is_two_house;
	}
	public String getIs_two_car() {
		return is_two_car;
	}
	public void setIs_two_car(String is_two_car) {
		this.is_two_car = is_two_car;
	}
	public String getIs_ife_insurance() {
		return is_ife_insurance;
	}
	public void setIs_ife_insurance(String is_ife_insurance) {
		this.is_ife_insurance = is_ife_insurance;
	}
	public String getIs_w_blacklist() {
		return is_w_blacklist;
	}
	public void setIs_w_blacklist(String is_w_blacklist) {
		this.is_w_blacklist = is_w_blacklist;
	}
/*	
	public String toString() {
		Customer c=new Customer();
		return "性别："+c.getSex()+",年龄:"+c.getAge()+",户口所在地："+c.getH_address()+",婚否："+c.getIs_marital_status()+",教育程度："+c.getEducation()+
				",公司性质："+c.nature_of_Business+",银行使用情况："+c.bank_usage+",是否有担保人："+c.is_surety+",是否失信人："+c.is_credit+",法院被执行情况："+c.court_execution+",未结清贷款笔数："+c.uncleared_number+",未结清贷款金额"
				+c.uncleared_monty+",单月最高逾期金额："+c.highest_overdue+",信用卡数量："+c.count_credit+",职业："+c.high_profile+",工作年限："+c.work_day
				+",是否有第二套房产"+c.is_two_house+",是否有第二辆车子"+c.is_two_car+",是否有人寿保险："+c.is_ife_insurance+",是否在网贷黑名单"+c.is_w_blacklist;
	}*/
}
