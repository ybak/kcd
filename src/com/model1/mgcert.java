package com.model1;

public class mgcert {
	private int id;//数据编号 ，自动增长
	private String c_name;//姓名
	private String c_carno;//车牌
	private String c_cardno;//身份证号
	private int carid;//车型库id  要求输出为具体车型
	private String c_mgprice;//借款金额
	private int c_mgdays;//借款天数
	private int c_mgtype;//接口方式，0为先息后本，1为等额本息
	private int mid_add;//创建人ID
	private int mid_edit;//最后编辑人ID
	private String dt_add;//创建时间
	private String dt_edit;//更新时间
	private int  bc_status;//审核状态
	private int gems_fs_id;//加盟店id
	private int gems_id;//商户师id
	private String gems_code;//订单号
	private String c_mgprice_result;//审核金额
	private String ct_name;//共借人姓名
	private String ct_cardno;//共借人省份号
	private String dt_fk;//放款日
	private String q_lv;//渠道利率
	private int motorcode;//发动机号
	private String c_vin;//vin码
	private String imgstep2_1;//产权证1-2页
	private String imgstep2_2;//产权证3-4页
	private String imgstep2_3;//产权证5-6页
	private String imgstep2_4;//行驶证
	private String imgstep2_5;//身份证正面
	private String imgstep2_6;//身份证反面
	private String imgstep2_7;//申请表
	private String imgstep2_8;//快加评估报告
	private String imgstep2_9;//查档照片
	private String imgstep2_10;//保单(商业)
	private String imgstep2_11;//征信报告
	private String imgstep2_12;//共借人身份证正面
	private String imgstep2_13;//共借人身份证反面
	private String imgstep2_14;//住家位置1
	private String imgstep2_15;//住家位置2
	private String imgstep2_16;//住家环境1
	private String imgstep2_17;//住家环境2
	private String imgstep2_18;//住家证明
	private String imgstep3_1;//合同1
	private String imgstep3_2;//合同2
	private String imgstep3_3;//合同3
	private String imgstep3_4;//合同4
	private String imgstep3_5;//合同5
	private String imgstep3_6;//合同6
	private String imgstep3_7;//合同7
	private String imgstep3_8;//合同8
	private String imgstep3_9;//合同9
	private String imgstep3_10;//合同10
	private String imgstep3_11;//合同11
	private String imgstep3_12;//合同12
	private String imgstep3_13;//合同13
	private String imgstep3_14;//补充1
	private String imgstep3_15;//补充2
	private String imgstep3_16;//签约视频
	private String imgstep4_1;//车辆铭牌
	private String imgstep4_2;//车前45度
	private String imgstep4_3;//车后45度
	private String imgstep4_4;//发动机舱
	private String imgstep4_5;//后备箱
	private String imgstep4_6;//中控台
	private String imgstep4_7;//仪表台公里数
	private String imgstep4_8;//人车合影
	private String imgstep4_9;//车辆补充1
	private String imgstep4_10;//车辆补充2
	private String imgstep4_11;//2017-7-10新增行驶证背面
	private String imgstep4_12;//
	private String imgstep4_13;//
	private String imgstep4_14;//
	private String result_imgurl1;//转账图1
	private String result_imgurl2;//转账图2
	private String result_imgurl3;//转账图3
	private String result_imgurl4;//转账图4
	private String result_imgurl5;//转账图5
	private int cs_tag;//初审标志
	private int score;//分数值
	private int mz1;//1为命中，0为未命中，手动命中设置1
	private int mz2;//1为命中，0为未命中，手动命中设置2
	private int mz3;//1为命中，0为未命中，手动命中设置3
	private int mz4;//1为命中，0为未命中，手动命中设置4
	private int mz5;//1为命中，0为未命中，手动命中设置5
	private int mz6;//1为命中，0为未命中，手动命中设置6
	private int mz7;//1为命中，0为未命中，手动命中设置7
	private int mz8;//1为命中，0为未命中，手动命中设置8
	private String zjf_type;//同步信息标记
	private String spcount;//审批次数
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_carno() {
		return c_carno;
	}
	public void setC_carno(String c_carno) {
		this.c_carno = c_carno;
	}
	public String getC_cardno() {
		return c_cardno;
	}
	public void setC_cardno(String c_cardno) {
		this.c_cardno = c_cardno;
	}
	public int getCarid() {
		return carid;
	}
	public void setCarid(int carid) {
		this.carid = carid;
	}
	public String getC_mgprice() {
		return c_mgprice;
	}
	public void setC_mgprice(String c_mgprice) {
		this.c_mgprice = c_mgprice;
	}
	public int getC_mgdays() {
		return c_mgdays;
	}
	public void setC_mgdays(int c_mgdays) {
		this.c_mgdays = c_mgdays;
	}
	public int getC_mgtype() {
		return c_mgtype;
	}
	public void setC_mgtype(int c_mgtype) {
		this.c_mgtype = c_mgtype;
	}
	public int getMid_add() {
		return mid_add;
	}
	public void setMid_add(int mid_add) {
		this.mid_add = mid_add;
	}
	public int getMid_edit() {
		return mid_edit;
	}
	public void setMid_edit(int mid_edit) {
		this.mid_edit = mid_edit;
	}
	public String getDt_add() {
		return dt_add;
	}
	public void setDt_add(String dt_add) {
		this.dt_add = dt_add;
	}
	public String getDt_edit() {
		return dt_edit;
	}
	public void setDt_edit(String dt_edit) {
		this.dt_edit = dt_edit;
	}
	public int getBc_status() {
		return bc_status;
	}
	public void setBc_status(int bc_status) {
		this.bc_status = bc_status;
	}
	public int getGems_fs_id() {
		return gems_fs_id;
	}
	public void setGems_fs_id(int gems_fs_id) {
		this.gems_fs_id = gems_fs_id;
	}
	public int getGems_id() {
		return gems_id;
	}
	public void setGems_id(int gems_id) {
		this.gems_id = gems_id;
	}
	public String getGems_code() {
		return gems_code;
	}
	public void setGems_code(String gems_code) {
		this.gems_code = gems_code;
	}
	public String getC_mgprice_result() {
		return c_mgprice_result;
	}
	public void setC_mgprice_result(String c_mgprice_result) {
		this.c_mgprice_result = c_mgprice_result;
	}
	public String getCt_name() {
		return ct_name;
	}
	public void setCt_name(String ct_name) {
		this.ct_name = ct_name;
	}
	public String getCt_cardno() {
		return ct_cardno;
	}
	public void setCt_cardno(String ct_cardno) {
		this.ct_cardno = ct_cardno;
	}
	public String getDt_fk() {
		return dt_fk;
	}
	public void setDt_fk(String dt_fk) {
		this.dt_fk = dt_fk;
	}
	public String getQ_lv() {
		return q_lv;
	}
	public void setQ_lv(String q_lv) {
		this.q_lv = q_lv;
	}
	public int getMotorcode() {
		return motorcode;
	}
	public void setMotorcode(int motorcode) {
		this.motorcode = motorcode;
	}
	public String getC_vin() {
		return c_vin;
	}
	public void setC_vin(String c_vin) {
		this.c_vin = c_vin;
	}
	public String getImgstep2_1() {
		return imgstep2_1;
	}
	public void setImgstep2_1(String imgstep2_1) {
		this.imgstep2_1 = imgstep2_1;
	}
	public String getImgstep2_2() {
		return imgstep2_2;
	}
	public void setImgstep2_2(String imgstep2_2) {
		this.imgstep2_2 = imgstep2_2;
	}
	public String getImgstep2_3() {
		return imgstep2_3;
	}
	public void setImgstep2_3(String imgstep2_3) {
		this.imgstep2_3 = imgstep2_3;
	}
	public String getImgstep2_4() {
		return imgstep2_4;
	}
	public void setImgstep2_4(String imgstep2_4) {
		this.imgstep2_4 = imgstep2_4;
	}
	public String getImgstep2_5() {
		return imgstep2_5;
	}
	public void setImgstep2_5(String imgstep2_5) {
		this.imgstep2_5 = imgstep2_5;
	}
	public String getImgstep2_6() {
		return imgstep2_6;
	}
	public void setImgstep2_6(String imgstep2_6) {
		this.imgstep2_6 = imgstep2_6;
	}
	public String getImgstep2_7() {
		return imgstep2_7;
	}
	public void setImgstep2_7(String imgstep2_7) {
		this.imgstep2_7 = imgstep2_7;
	}
	public String getImgstep2_8() {
		return imgstep2_8;
	}
	public void setImgstep2_8(String imgstep2_8) {
		this.imgstep2_8 = imgstep2_8;
	}
	public String getImgstep2_9() {
		return imgstep2_9;
	}
	public void setImgstep2_9(String imgstep2_9) {
		this.imgstep2_9 = imgstep2_9;
	}
	public String getImgstep2_10() {
		return imgstep2_10;
	}
	public void setImgstep2_10(String imgstep2_10) {
		this.imgstep2_10 = imgstep2_10;
	}
	public String getImgstep2_11() {
		return imgstep2_11;
	}
	public void setImgstep2_11(String imgstep2_11) {
		this.imgstep2_11 = imgstep2_11;
	}
	public String getImgstep2_12() {
		return imgstep2_12;
	}
	public void setImgstep2_12(String imgstep2_12) {
		this.imgstep2_12 = imgstep2_12;
	}
	public String getImgstep2_13() {
		return imgstep2_13;
	}
	public void setImgstep2_13(String imgstep2_13) {
		this.imgstep2_13 = imgstep2_13;
	}
	public String getImgstep2_14() {
		return imgstep2_14;
	}
	public void setImgstep2_14(String imgstep2_14) {
		this.imgstep2_14 = imgstep2_14;
	}
	public String getImgstep2_15() {
		return imgstep2_15;
	}
	public void setImgstep2_15(String imgstep2_15) {
		this.imgstep2_15 = imgstep2_15;
	}
	public String getImgstep2_16() {
		return imgstep2_16;
	}
	public void setImgstep2_16(String imgstep2_16) {
		this.imgstep2_16 = imgstep2_16;
	}
	public String getImgstep2_17() {
		return imgstep2_17;
	}
	public void setImgstep2_17(String imgstep2_17) {
		this.imgstep2_17 = imgstep2_17;
	}
	public String getImgstep2_18() {
		return imgstep2_18;
	}
	public void setImgstep2_18(String imgstep2_18) {
		this.imgstep2_18 = imgstep2_18;
	}
	public String getImgstep3_1() {
		return imgstep3_1;
	}
	public void setImgstep3_1(String imgstep3_1) {
		this.imgstep3_1 = imgstep3_1;
	}
	public String getImgstep3_2() {
		return imgstep3_2;
	}
	public void setImgstep3_2(String imgstep3_2) {
		this.imgstep3_2 = imgstep3_2;
	}
	public String getImgstep3_3() {
		return imgstep3_3;
	}
	public void setImgstep3_3(String imgstep3_3) {
		this.imgstep3_3 = imgstep3_3;
	}
	public String getImgstep3_4() {
		return imgstep3_4;
	}
	public void setImgstep3_4(String imgstep3_4) {
		this.imgstep3_4 = imgstep3_4;
	}
	public String getImgstep3_5() {
		return imgstep3_5;
	}
	public void setImgstep3_5(String imgstep3_5) {
		this.imgstep3_5 = imgstep3_5;
	}
	public String getImgstep3_6() {
		return imgstep3_6;
	}
	public void setImgstep3_6(String imgstep3_6) {
		this.imgstep3_6 = imgstep3_6;
	}
	public String getImgstep3_7() {
		return imgstep3_7;
	}
	public void setImgstep3_7(String imgstep3_7) {
		this.imgstep3_7 = imgstep3_7;
	}
	public String getImgstep3_8() {
		return imgstep3_8;
	}
	public void setImgstep3_8(String imgstep3_8) {
		this.imgstep3_8 = imgstep3_8;
	}
	public String getImgstep3_9() {
		return imgstep3_9;
	}
	public void setImgstep3_9(String imgstep3_9) {
		this.imgstep3_9 = imgstep3_9;
	}
	public String getImgstep3_10() {
		return imgstep3_10;
	}
	public void setImgstep3_10(String imgstep3_10) {
		this.imgstep3_10 = imgstep3_10;
	}
	public String getImgstep3_11() {
		return imgstep3_11;
	}
	public void setImgstep3_11(String imgstep3_11) {
		this.imgstep3_11 = imgstep3_11;
	}
	public String getImgstep3_12() {
		return imgstep3_12;
	}
	public void setImgstep3_12(String imgstep3_12) {
		this.imgstep3_12 = imgstep3_12;
	}
	public String getImgstep3_13() {
		return imgstep3_13;
	}
	public void setImgstep3_13(String imgstep3_13) {
		this.imgstep3_13 = imgstep3_13;
	}
	public String getImgstep3_14() {
		return imgstep3_14;
	}
	public void setImgstep3_14(String imgstep3_14) {
		this.imgstep3_14 = imgstep3_14;
	}
	public String getImgstep3_15() {
		return imgstep3_15;
	}
	public void setImgstep3_15(String imgstep3_15) {
		this.imgstep3_15 = imgstep3_15;
	}
	public String getImgstep3_16() {
		return imgstep3_16;
	}
	public void setImgstep3_16(String imgstep3_16) {
		this.imgstep3_16 = imgstep3_16;
	}
	public String getImgstep4_1() {
		return imgstep4_1;
	}
	public void setImgstep4_1(String imgstep4_1) {
		this.imgstep4_1 = imgstep4_1;
	}
	public String getImgstep4_2() {
		return imgstep4_2;
	}
	public void setImgstep4_2(String imgstep4_2) {
		this.imgstep4_2 = imgstep4_2;
	}
	public String getImgstep4_3() {
		return imgstep4_3;
	}
	public void setImgstep4_3(String imgstep4_3) {
		this.imgstep4_3 = imgstep4_3;
	}
	public String getImgstep4_4() {
		return imgstep4_4;
	}
	public void setImgstep4_4(String imgstep4_4) {
		this.imgstep4_4 = imgstep4_4;
	}
	public String getImgstep4_5() {
		return imgstep4_5;
	}
	public void setImgstep4_5(String imgstep4_5) {
		this.imgstep4_5 = imgstep4_5;
	}
	public String getImgstep4_6() {
		return imgstep4_6;
	}
	public void setImgstep4_6(String imgstep4_6) {
		this.imgstep4_6 = imgstep4_6;
	}
	public String getImgstep4_7() {
		return imgstep4_7;
	}
	public void setImgstep4_7(String imgstep4_7) {
		this.imgstep4_7 = imgstep4_7;
	}
	public String getImgstep4_8() {
		return imgstep4_8;
	}
	public void setImgstep4_8(String imgstep4_8) {
		this.imgstep4_8 = imgstep4_8;
	}
	public String getImgstep4_9() {
		return imgstep4_9;
	}
	public void setImgstep4_9(String imgstep4_9) {
		this.imgstep4_9 = imgstep4_9;
	}
	public String getImgstep4_10() {
		return imgstep4_10;
	}
	public void setImgstep4_10(String imgstep4_10) {
		this.imgstep4_10 = imgstep4_10;
	}
	public String getImgstep4_11() {
		return imgstep4_11;
	}
	public void setImgstep4_11(String imgstep4_11) {
		this.imgstep4_11 = imgstep4_11;
	}
	public String getImgstep4_12() {
		return imgstep4_12;
	}
	public void setImgstep4_12(String imgstep4_12) {
		this.imgstep4_12 = imgstep4_12;
	}
	public String getImgstep4_13() {
		return imgstep4_13;
	}
	public void setImgstep4_13(String imgstep4_13) {
		this.imgstep4_13 = imgstep4_13;
	}
	public String getImgstep4_14() {
		return imgstep4_14;
	}
	public void setImgstep4_14(String imgstep4_14) {
		this.imgstep4_14 = imgstep4_14;
	}
	public String getResult_imgurl1() {
		return result_imgurl1;
	}
	public void setResult_imgurl1(String result_imgurl1) {
		this.result_imgurl1 = result_imgurl1;
	}
	public String getResult_imgurl2() {
		return result_imgurl2;
	}
	public void setResult_imgurl2(String result_imgurl2) {
		this.result_imgurl2 = result_imgurl2;
	}
	public String getResult_imgurl3() {
		return result_imgurl3;
	}
	public void setResult_imgurl3(String result_imgurl3) {
		this.result_imgurl3 = result_imgurl3;
	}
	public String getResult_imgurl4() {
		return result_imgurl4;
	}
	public void setResult_imgurl4(String result_imgurl4) {
		this.result_imgurl4 = result_imgurl4;
	}
	public String getResult_imgurl5() {
		return result_imgurl5;
	}
	public void setResult_imgurl5(String result_imgurl5) {
		this.result_imgurl5 = result_imgurl5;
	}
	public int getCs_tag() {
		return cs_tag;
	}
	public void setCs_tag(int cs_tag) {
		this.cs_tag = cs_tag;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getMz1() {
		return mz1;
	}
	public void setMz1(int mz1) {
		this.mz1 = mz1;
	}
	public int getMz2() {
		return mz2;
	}
	public void setMz2(int mz2) {
		this.mz2 = mz2;
	}
	public int getMz3() {
		return mz3;
	}
	public void setMz3(int mz3) {
		this.mz3 = mz3;
	}
	public int getMz4() {
		return mz4;
	}
	public void setMz4(int mz4) {
		this.mz4 = mz4;
	}
	public int getMz5() {
		return mz5;
	}
	public void setMz5(int mz5) {
		this.mz5 = mz5;
	}
	public int getMz6() {
		return mz6;
	}
	public void setMz6(int mz6) {
		this.mz6 = mz6;
	}
	public int getMz7() {
		return mz7;
	}
	public void setMz7(int mz7) {
		this.mz7 = mz7;
	}
	public int getMz8() {
		return mz8;
	}
	public void setMz8(int mz8) {
		this.mz8 = mz8;
	}
	public String getZjf_type() {
		return zjf_type;
	}
	public void setZjf_type(String zjf_type) {
		this.zjf_type = zjf_type;
	}
	public String getSpcount() {
		return spcount;
	}
	public void setSpcount(String spcount) {
		this.spcount = spcount;
	}

	
	
	
}
                         