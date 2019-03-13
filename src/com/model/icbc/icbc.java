package com.model.icbc;

/**
 * 工行 进件
 * 
 * @author Administrator
 *
 */
public class icbc {
	private int id; // int(11) 否
	private int mid_add; // int(11) 否
	private int mid_edit; // int(11) 否
	private String dt_add; // datetime 否
	private String dt_edit; // datetime 否
	private int bc_status; // tinyint(4) 否 订单状态
	private int gems_id; // int(11) 否
	private int gems_fs_id; // int(11) 否
	private String gems_code; // varchar(20) 否 订单编码
	private int query_type; // tinyint(4) 否 0 类型，暂时一种，为0
	private String c_name; // varchar(20) 否 姓名
	private String c_tel; // varchar(15) 否 手机号码
	private String c_cardno; // varchar(32) 否 身份证
	private int bank_id;// tinyint(4) 否 按揭银行id
	private int loan_tpid; // tinyint(4) 否 贷款产品id
	private int loan_level;// tinyint(4) 否 业务等级，<=10W/10万以上
	private String c_name_mts; // text 否 mt配偶姓名,共借人1，2
	private String c_tel_mts; // text 否 mt配偶电话
	private String c_cardno_mts; // text 否 mt配偶身份证号码
	private float kk_kpj; // float(11,2) 否 0.00 第3页，开卡申请，开票价，万
	private float kk_loan_amount; // float(11,2) 否 0.00 第3页，开卡申请，贷款金额，万
	private int kk_loan_amount_s; // int(11) 否 3，开卡，金融服务费，元
	private float kk_loan_amount_total; // float(11,2) 否 3,开卡，贷款总额,万
	private int kk_loan_ajms; // tinyint(4) 否 3,开卡，按揭模式
	private int kk_loan_ajqx; // tinyint(4) 否 3,开卡，按揭期限
	private int kk_loan_ajyh; // tinyint(4) 否 3,开卡，按揭银行
	private float kk_loan_rate; // float(11,2) 否 3,开卡，贷款利率%
	private int kk_car_stateid; // int(11) 否 车辆上牌省
	private int kk_car_cityid; // int(11) 否 车辆上牌市
	private int kk_loan_stateid; // int(11) 否 业务所在省
	private int kk_loan_cityid; // int(11) 否 业务所在市
	private String imgstep2_1; // varchar(255) 是 NULL 身份证正面
	private String imgstep2_2; // varchar(255) 是 NULL 身份证反面
	private String imgstep2_3; // varchar(255) 是 NULL 手持身份证授权书
	private String imgstep2_4; // varchar(255) 是 NULL 面签照
	private String imgstep2_5; // varchar(255) 是 NULL 授权书
	private String imgstep2_5s; // text 是 NULL 新增
	private String imgstep3_1; // varchar(255) 是 NULL 面签照
	private String imgstep3_2; // varchar(255) 是 NULL 信用卡申请表1
	private String imgstep3_3; // varchar(255) 是 NULL 信用卡申请表2
	private String imgstep3_4; // varchar(255) 是 NULL 身份证正面
	private String imgstep3_5; // varchar(255) 是 NULL 身份证反面
	private String imgstep3_6; // varchar(255) 是 NULL 专项分期付款业务信息表
	private String imgstep3_7; // varchar(255) 是 NULL 个人税收居民身份证申明文件
	private String imgstep2_8s; // text 是 NULL 新增
	private String imgstep4_1; // varchar(255) 是 NULL 首付证明
	private String imgstep4_2; // varchar(255) 是 NULL 专项分期付款调查审批表
	private String imgstep4_3; // varchar(255) 是 NULL 送达地址确认协议
	private String imgstep4_4; // varchar(255) 是 NULL 担保确认函
	private String imgstep4_5; // varchar(255) 是 NULL 承诺书
	private String imgstep4_6; // varchar(255) 是 NULL 委托代购服务协议1
	private String imgstep4_7; // varchar(255) 是 NULL 委托代购服务协议2
	private String imgstep4_9; // varchar(255) 是 NULL 信用卡透支分期付款申请书
	private String imgstep4_10; // varchar(255) 是 NULL 信用卡汽车分期客户告知书
	private String imgstep4_11; // varchar(255) 是 NULL 银行流水（3-6个月内）
	private String imgstep5_1s; // text 是 NULL 新增户口本照片
	private String imgstep5_2s; // text 是 NULL 新增家庭照片照片
	private String imgstep5_3s; // text 是 NULL 新增驾驶证照片
	private String imgstep5_4v; // varchar(255) 是 NULL 签约1分钟视频
	private String imgstep6_1; // varchar(255) 是 NULL 车辆发票
	private String imgstep6_2; // varchar(255) 是 NULL 车辆发票网上查询
	private String imgstep6_3; // varchar(255) 是 NULL 登记证书转产页
	private String imgstep6_4; // varchar(255) 是 NULL 分期付款/抵押合同
	private String imgstep6_5s; // text 是 NULL 新增补充材料(车辆/合同相关)
	private int c_sex; // tinyint(4) 否 1 1为男，0为女
	private String zx_result; // text 否 征信查询结果
	private String dt_zxresult; // datetime 否 征信报告更新时间
	private String dt_zxsub; // datetime 否 征信查询提交时间
	private String gname;
	private String pname;
	private int api_add;
	private int api_edit;
	private int querytype;
	private int zxok_tag;
	private String name1;
	private String name2;
	private String name3;
	private String tel1;
	private String tel2;
	private String tel3;
	private String cardno1;
	private String cardno2;
	private String cardno3;
	private String cyly;
	private String remark;
	private String dt_fin;
	private int adminop_tag;
	private String adminname;
	private int book_status;
	private int card_status;
	private String icbcname;
	private String time1;
	private String time2;
	private int adminid;
	private int tr_status;
	private int tr_tag;
	private String dsj_result;
	private String dsj_report_id;
	private String dsj_result_time;
	private String dt_backtofin;
	private String tr_msg;
	private int pc_status;
	private String statusname;
	private String statusname2;
	private String statusname3;
	private String statusname4;
	private String statusname5;
	private String bc_status2;
	private String bc_status3;
	private String bc_status4;
	private String bc_status5;
	private String dkid;
	private String acid;
	private String kkid;
	private String mqid;
	private String c_name_mt;
	private String c_tel_mt;
	private String c_cardno_mt;
	private String c_name_gj1;
	private String c_name_gj2;
	private String c_tel_gj1;
	private String c_tel_gj2;
	private String c_cardno_gj1;
	private String c_cardno_gj2;
	private String dt_sub;
	private int fromid;
	private int fk_status;
	private int gems_id_first;
	private String po_zx_result;
	private String gjr_zx_result1;
	private String gjr_zx_result2;
	private String po_dsj_report_id;
	private String gjr_dsj_report_id1;
	private String gjr_dsj_report_id2;
	private String imgstep8_1ss;
	private String po_dsj_result;
	private String gjr_dsj_result1;
	private String gjr_dsj_result2;
	private int zjlx;
	private String dygd_wcdate;
	private String dygd_djzsh;
	private String dygd_dyblry;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getGems_id() {
		return gems_id;
	}

	public void setGems_id(int gems_id) {
		this.gems_id = gems_id;
	}

	public int getGems_fs_id() {
		return gems_fs_id;
	}

	public void setGems_fs_id(int gems_fs_id) {
		this.gems_fs_id = gems_fs_id;
	}

	public String getGems_code() {
		return gems_code;
	}

	public void setGems_code(String gems_code) {
		this.gems_code = gems_code;
	}

	public int getQuery_type() {
		return query_type;
	}

	public void setQuery_type(int query_type) {
		this.query_type = query_type;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_tel() {
		return c_tel;
	}

	public void setC_tel(String c_tel) {
		this.c_tel = c_tel;
	}

	public String getC_cardno() {
		return c_cardno;
	}

	public void setC_cardno(String c_cardno) {
		this.c_cardno = c_cardno;
	}

	public int getBank_id() {
		return bank_id;
	}

	public void setBank_id(int bank_id) {
		this.bank_id = bank_id;
	}

	public int getLoan_tpid() {
		return loan_tpid;
	}

	public void setLoan_tpid(int loan_tpid) {
		this.loan_tpid = loan_tpid;
	}

	public int getLoan_level() {
		return loan_level;
	}

	public void setLoan_level(int loan_level) {
		this.loan_level = loan_level;
	}

	public String getC_name_mts() {
		return c_name_mts;
	}

	public void setC_name_mts(String c_name_mts) {
		this.c_name_mts = c_name_mts;
	}

	public String getC_tel_mts() {
		return c_tel_mts;
	}

	public void setC_tel_mts(String c_tel_mts) {
		this.c_tel_mts = c_tel_mts;
	}

	public String getC_cardno_mts() {
		return c_cardno_mts;
	}

	public void setC_cardno_mts(String c_cardno_mts) {
		this.c_cardno_mts = c_cardno_mts;
	}

	public float getKk_kpj() {
		return kk_kpj;
	}

	public void setKk_kpj(float kk_kpj) {
		this.kk_kpj = kk_kpj;
	}

	public float getKk_loan_amount() {
		return kk_loan_amount;
	}

	public void setKk_loan_amount(float kk_loan_amount) {
		this.kk_loan_amount = kk_loan_amount;
	}

	public int getKk_loan_amount_s() {
		return kk_loan_amount_s;
	}

	public void setKk_loan_amount_s(int kk_loan_amount_s) {
		this.kk_loan_amount_s = kk_loan_amount_s;
	}

	public float getKk_loan_amount_total() {
		return kk_loan_amount_total;
	}

	public void setKk_loan_amount_total(float kk_loan_amount_total) {
		this.kk_loan_amount_total = kk_loan_amount_total;
	}

	public int getKk_loan_ajms() {
		return kk_loan_ajms;
	}

	public void setKk_loan_ajms(int kk_loan_ajms) {
		this.kk_loan_ajms = kk_loan_ajms;
	}

	public int getKk_loan_ajqx() {
		return kk_loan_ajqx;
	}

	public void setKk_loan_ajqx(int kk_loan_ajqx) {
		this.kk_loan_ajqx = kk_loan_ajqx;
	}

	public int getKk_loan_ajyh() {
		return kk_loan_ajyh;
	}

	public void setKk_loan_ajyh(int kk_loan_ajyh) {
		this.kk_loan_ajyh = kk_loan_ajyh;
	}

	public float getKk_loan_rate() {
		return kk_loan_rate;
	}

	public void setKk_loan_rate(float kk_loan_rate) {
		this.kk_loan_rate = kk_loan_rate;
	}

	public int getKk_car_stateid() {
		return kk_car_stateid;
	}

	public void setKk_car_stateid(int kk_car_stateid) {
		this.kk_car_stateid = kk_car_stateid;
	}

	public int getKk_car_cityid() {
		return kk_car_cityid;
	}

	public void setKk_car_cityid(int kk_car_cityid) {
		this.kk_car_cityid = kk_car_cityid;
	}

	public int getKk_loan_stateid() {
		return kk_loan_stateid;
	}

	public void setKk_loan_stateid(int kk_loan_stateid) {
		this.kk_loan_stateid = kk_loan_stateid;
	}

	public int getKk_loan_cityid() {
		return kk_loan_cityid;
	}

	public void setKk_loan_cityid(int kk_loan_cityid) {
		this.kk_loan_cityid = kk_loan_cityid;
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

	public String getImgstep2_5s() {
		return imgstep2_5s;
	}

	public void setImgstep2_5s(String imgstep2_5s) {
		this.imgstep2_5s = imgstep2_5s;
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

	public String getImgstep2_8s() {
		return imgstep2_8s;
	}

	public void setImgstep2_8s(String imgstep2_8s) {
		this.imgstep2_8s = imgstep2_8s;
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

	public String getImgstep5_1s() {
		return imgstep5_1s;
	}

	public void setImgstep5_1s(String imgstep5_1s) {
		this.imgstep5_1s = imgstep5_1s;
	}

	public String getImgstep5_2s() {
		return imgstep5_2s;
	}

	public void setImgstep5_2s(String imgstep5_2s) {
		this.imgstep5_2s = imgstep5_2s;
	}

	public String getImgstep5_3s() {
		return imgstep5_3s;
	}

	public void setImgstep5_3s(String imgstep5_3s) {
		this.imgstep5_3s = imgstep5_3s;
	}

	public String getImgstep5_4v() {
		return imgstep5_4v;
	}

	public void setImgstep5_4v(String imgstep5_4v) {
		this.imgstep5_4v = imgstep5_4v;
	}

	public String getImgstep6_1() {
		return imgstep6_1;
	}

	public void setImgstep6_1(String imgstep6_1) {
		this.imgstep6_1 = imgstep6_1;
	}

	public String getImgstep6_2() {
		return imgstep6_2;
	}

	public void setImgstep6_2(String imgstep6_2) {
		this.imgstep6_2 = imgstep6_2;
	}

	public String getImgstep6_3() {
		return imgstep6_3;
	}

	public void setImgstep6_3(String imgstep6_3) {
		this.imgstep6_3 = imgstep6_3;
	}

	public String getImgstep6_4() {
		return imgstep6_4;
	}

	public void setImgstep6_4(String imgstep6_4) {
		this.imgstep6_4 = imgstep6_4;
	}

	public String getImgstep6_5s() {
		return imgstep6_5s;
	}

	public void setImgstep6_5s(String imgstep6_5s) {
		this.imgstep6_5s = imgstep6_5s;
	}

	public int getC_sex() {
		return c_sex;
	}

	public void setC_sex(int c_sex) {
		this.c_sex = c_sex;
	}

	public String getZx_result() {
		return zx_result;
	}

	public void setZx_result(String zx_result) {
		this.zx_result = zx_result;
	}

	public String getDt_zxresult() {
		return dt_zxresult;
	}

	public void setDt_zxresult(String dt_zxresult) {
		this.dt_zxresult = dt_zxresult;
	}

	public String getDt_zxsub() {
		return dt_zxsub;
	}

	public void setDt_zxsub(String dt_zxsub) {
		this.dt_zxsub = dt_zxsub;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getApi_add() {
		return api_add;
	}

	public void setApi_add(int api_add) {
		this.api_add = api_add;
	}

	public int getApi_edit() {
		return api_edit;
	}

	public void setApi_edit(int api_edit) {
		this.api_edit = api_edit;
	}

	public int getQuerytype() {
		return querytype;
	}

	public void setQuerytype(int querytype) {
		this.querytype = querytype;
	}

	public int getZxok_tag() {
		return zxok_tag;
	}

	public void setZxok_tag(int zxok_tag) {
		this.zxok_tag = zxok_tag;
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public String getName3() {
		return name3;
	}

	public void setName3(String name3) {
		this.name3 = name3;
	}

	public String getTel1() {
		return tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public String getTel3() {
		return tel3;
	}

	public void setTel3(String tel3) {
		this.tel3 = tel3;
	}

	public String getCardno1() {
		return cardno1;
	}

	public void setCardno1(String cardno1) {
		this.cardno1 = cardno1;
	}

	public String getCardno2() {
		return cardno2;
	}

	public void setCardno2(String cardno2) {
		this.cardno2 = cardno2;
	}

	public String getCardno3() {
		return cardno3;
	}

	public void setCardno3(String cardno3) {
		this.cardno3 = cardno3;
	}

	public String getCyly() {
		return cyly;
	}

	public void setCyly(String cyly) {
		this.cyly = cyly;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDt_fin() {
		return dt_fin;
	}

	public void setDt_fin(String dt_fin) {
		this.dt_fin = dt_fin;
	}

	public int getAdminop_tag() {
		return adminop_tag;
	}

	public void setAdminop_tag(int adminop_tag) {
		this.adminop_tag = adminop_tag;
	}

	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	public int getBook_status() {
		return book_status;
	}

	public void setBook_status(int book_status) {
		this.book_status = book_status;
	}

	public int getCard_status() {
		return card_status;
	}

	public void setCard_status(int card_status) {
		this.card_status = card_status;
	}

	public String getIcbcname() {
		return icbcname;
	}

	public void setIcbcname(String icbcname) {
		this.icbcname = icbcname;
	}

	public String getTime1() {
		return time1;
	}

	public void setTime1(String time1) {
		this.time1 = time1;
	}

	public String getTime2() {
		return time2;
	}

	public void setTime2(String time2) {
		this.time2 = time2;
	}

	public int getAdminid() {
		return adminid;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

	public int getTr_status() {
		return tr_status;
	}

	public void setTr_status(int tr_status) {
		this.tr_status = tr_status;
	}

	public int getTr_tag() {
		return tr_tag;
	}

	public void setTr_tag(int tr_tag) {
		this.tr_tag = tr_tag;
	}

	public String getDsj_result() {
		return dsj_result;
	}

	public void setDsj_result(String dsj_result) {
		this.dsj_result = dsj_result;
	}

	public String getDsj_report_id() {
		return dsj_report_id;
	}

	public void setDsj_report_id(String dsj_report_id) {
		this.dsj_report_id = dsj_report_id;
	}

	public String getDsj_result_time() {
		return dsj_result_time;
	}

	public void setDsj_result_time(String dsj_result_time) {
		this.dsj_result_time = dsj_result_time;
	}

	public String getDt_backtofin() {
		return dt_backtofin;
	}

	public void setDt_backtofin(String dt_backtofin) {
		this.dt_backtofin = dt_backtofin;
	}

	public String getTr_msg() {
		return tr_msg;
	}

	public void setTr_msg(String tr_msg) {
		this.tr_msg = tr_msg;
	}

	public int getPc_status() {
		return pc_status;
	}

	public void setPc_status(int pc_status) {
		this.pc_status = pc_status;
	}

	public String getStatusname() {
		return statusname;
	}

	public void setStatusname(String statusname) {
		this.statusname = statusname;
	}

	public String getStatusname2() {
		return statusname2;
	}

	public void setStatusname2(String statusname2) {
		this.statusname2 = statusname2;
	}

	public String getStatusname3() {
		return statusname3;
	}

	public void setStatusname3(String statusname3) {
		this.statusname3 = statusname3;
	}

	public String getStatusname4() {
		return statusname4;
	}

	public void setStatusname4(String statusname4) {
		this.statusname4 = statusname4;
	}

	public String getStatusname5() {
		return statusname5;
	}

	public void setStatusname5(String statusname5) {
		this.statusname5 = statusname5;
	}

	public String getBc_status2() {
		return bc_status2;
	}

	public void setBc_status2(String bc_status2) {
		this.bc_status2 = bc_status2;
	}

	public String getBc_status3() {
		return bc_status3;
	}

	public void setBc_status3(String bc_status3) {
		this.bc_status3 = bc_status3;
	}

	public String getBc_status4() {
		return bc_status4;
	}

	public void setBc_status4(String bc_status4) {
		this.bc_status4 = bc_status4;
	}

	public String getBc_status5() {
		return bc_status5;
	}

	public void setBc_status5(String bc_status5) {
		this.bc_status5 = bc_status5;
	}

	public String getC_name_mt() {
		return c_name_mt;
	}

	public void setC_name_mt(String c_name_mt) {
		this.c_name_mt = c_name_mt;
	}

	public String getC_tel_mt() {
		return c_tel_mt;
	}

	public void setC_tel_mt(String c_tel_mt) {
		this.c_tel_mt = c_tel_mt;
	}

	public String getC_cardno_mt() {
		return c_cardno_mt;
	}

	public void setC_cardno_mt(String c_cardno_mt) {
		this.c_cardno_mt = c_cardno_mt;
	}

	public String getC_name_gj1() {
		return c_name_gj1;
	}

	public void setC_name_gj1(String c_name_gj1) {
		this.c_name_gj1 = c_name_gj1;
	}

	public String getC_name_gj2() {
		return c_name_gj2;
	}

	public void setC_name_gj2(String c_name_gj2) {
		this.c_name_gj2 = c_name_gj2;
	}

	public String getC_tel_gj1() {
		return c_tel_gj1;
	}

	public void setC_tel_gj1(String c_tel_gj1) {
		this.c_tel_gj1 = c_tel_gj1;
	}

	public String getC_tel_gj2() {
		return c_tel_gj2;
	}

	public void setC_tel_gj2(String c_tel_gj2) {
		this.c_tel_gj2 = c_tel_gj2;
	}

	public String getC_cardno_gj1() {
		return c_cardno_gj1;
	}

	public void setC_cardno_gj1(String c_cardno_gj1) {
		this.c_cardno_gj1 = c_cardno_gj1;
	}

	public String getC_cardno_gj2() {
		return c_cardno_gj2;
	}

	public void setC_cardno_gj2(String c_cardno_gj2) {
		this.c_cardno_gj2 = c_cardno_gj2;
	}

	public String getDt_sub() {
		return dt_sub;
	}

	public void setDt_sub(String dt_sub) {
		this.dt_sub = dt_sub;
	}

	public int getFromid() {
		return fromid;
	}

	public void setFromid(int fromid) {
		this.fromid = fromid;
	}

	public int getFk_status() {
		return fk_status;
	}

	public void setFk_status(int fk_status) {
		this.fk_status = fk_status;
	}

	public int getGems_id_first() {
		return gems_id_first;
	}

	public void setGems_id_first(int gems_id_first) {
		this.gems_id_first = gems_id_first;
	}

	public String getDkid() {
		return dkid;
	}

	public void setDkid(String dkid) {
		this.dkid = dkid;
	}

	public String getAcid() {
		return acid;
	}

	public void setAcid(String acid) {
		this.acid = acid;
	}

	public String getKkid() {
		return kkid;
	}

	public void setKkid(String kkid) {
		this.kkid = kkid;
	}

	public String getMqid() {
		return mqid;
	}

	public void setMqid(String mqid) {
		this.mqid = mqid;
	}

	public String getPo_zx_result() {
		return po_zx_result;
	}

	public void setPo_zx_result(String po_zx_result) {
		this.po_zx_result = po_zx_result;
	}

	public String getGjr_zx_result1() {
		return gjr_zx_result1;
	}

	public void setGjr_zx_result1(String gjr_zx_result1) {
		this.gjr_zx_result1 = gjr_zx_result1;
	}

	public String getGjr_zx_result2() {
		return gjr_zx_result2;
	}

	public void setGjr_zx_result2(String gjr_zx_result2) {
		this.gjr_zx_result2 = gjr_zx_result2;
	}

	public String getPo_dsj_report_id() {
		return po_dsj_report_id;
	}

	public void setPo_dsj_report_id(String po_dsj_report_id) {
		this.po_dsj_report_id = po_dsj_report_id;
	}

	public String getGjr_dsj_report_id1() {
		return gjr_dsj_report_id1;
	}

	public void setGjr_dsj_report_id1(String gjr_dsj_report_id1) {
		this.gjr_dsj_report_id1 = gjr_dsj_report_id1;
	}

	public String getGjr_dsj_report_id2() {
		return gjr_dsj_report_id2;
	}

	public void setGjr_dsj_report_id2(String gjr_dsj_report_id2) {
		this.gjr_dsj_report_id2 = gjr_dsj_report_id2;
	}

	public String getImgstep8_1ss() {
		return imgstep8_1ss;
	}

	public void setImgstep8_1ss(String imgstep8_1ss) {
		this.imgstep8_1ss = imgstep8_1ss;
	}

	public int getZjlx() {
		return zjlx;
	}

	public void setZjlx(int zjlx) {
		this.zjlx = zjlx;
	}

	public String getPo_dsj_result() {
		return po_dsj_result;
	}

	public void setPo_dsj_result(String po_dsj_result) {
		this.po_dsj_result = po_dsj_result;
	}

	public String getGjr_dsj_result1() {
		return gjr_dsj_result1;
	}

	public void setGjr_dsj_result1(String gjr_dsj_result1) {
		this.gjr_dsj_result1 = gjr_dsj_result1;
	}

	public String getGjr_dsj_result2() {
		return gjr_dsj_result2;
	}

	public void setGjr_dsj_result2(String gjr_dsj_result2) {
		this.gjr_dsj_result2 = gjr_dsj_result2;
	}

	public String getDygd_wcdate() {
		return dygd_wcdate;
	}

	public void setDygd_wcdate(String dygd_wcdate) {
		this.dygd_wcdate = dygd_wcdate;
	}

	public String getDygd_djzsh() {
		return dygd_djzsh;
	}

	public void setDygd_djzsh(String dygd_djzsh) {
		this.dygd_djzsh = dygd_djzsh;
	}

	public String getDygd_dyblry() {
		return dygd_dyblry;
	}

	public void setDygd_dyblry(String dygd_dyblry) {
		this.dygd_dyblry = dygd_dyblry;
	}

}
