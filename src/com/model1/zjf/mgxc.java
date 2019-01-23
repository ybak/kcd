package com.model1.zjf;

public class mgxc {
	private int id; 
	private String	c_name;
	private String	c_carno; //车牌	
	private int	carid; //车型库id	
	private String	c_mgprice ;//借款金额（万）	
	private int	c_mgdays; //借款天数	
	private int	c_mgtype ;//接口方式，0为先息后本，1为等额本息	
	private int	mid_add ;	
	private int	mid_edit ;	
	private String	dt_add ;	
	private String	dt_edit; 	
	private int	bc_status; //审核状态	
	private int	gems_fs_id ;//加盟店id	
	private int	gems_id ;//商户师id	
	private String	gems_code; //订单号	
	private String	c_mgprice_result; //审批金额，万元	
	private String	c_cardno; //身份证号码	
	private String	ct_name; //共借人姓名	
	private String	ct_cardno; //共借人身份证号码	
	private String	c_vin; //vin	
	private String	dt_fk; //放款时间	
	private String	q_lv; //渠道利率	
	private int	cs_tag; //初审标志	
	private int	score; //分数值	
	private int	mz1; //1为命中，0为未命中，手动命中设置1
	private int	mz2; //1为命中，0为未命中，手动命中设置2	
	private int	mz3; //1为命中，0为未命中，手动命中设置3	
	private int	mz4; //1为命中，0为未命中，手动命中设置4
	private int	mz5; //1为命中，0为未命中，手动命中设置5	
	private int	mz6; //1为命中，0为未命中，手动命中设置6	
	private int	mz7; //1为命中，0为未命中，手动命中设置7
	private int	mz8; //1为命中，0为未命中，手动命中设置8	
	private int	status2;// 终审状态,0未开始终审，1未终审中，2为终审中，3为回退补件	
	private int	status_fk ;//放款状态,0未开始处理，1为放款中，2为付款完成	
	private int	id_capital; //资金方	
	private int	capital_tag; //资金方审核状态，0为未提交，1为提交中，等待返回结果，2-125，接口方定义 	
	private String	images1; //二手车资料	
	private String	images2; //申请书类	
	private String	images3; //身份类	
	private String	images4; //征信授权确认单	
	private String	images5; //户籍类	
	private String	images6; //婚姻类	
	private String	images7; //驾驶证类	
	private String	images8; //房产或居住类	
	private String	images9; //工作及收入类	
	private String	images10; //担保人资料	
	private String	images11; //其他	
	private String	images12 ;//辅助材料	
	private int	sfbl; //首付比例%为单位	
	private String	imagesbj; //补件图片	
	private int	hkyh; //还款银行代码	
	private String	khyh; //开户银行	
	private String	yhkh; //银行卡号	
	private String images13;//GPS材料	
	private String video1; //签约视频
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
	public String getC_cardno() {
		return c_cardno;
	}
	public void setC_cardno(String c_cardno) {
		this.c_cardno = c_cardno;
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
	public String getC_vin() {
		return c_vin;
	}
	public void setC_vin(String c_vin) {
		this.c_vin = c_vin;
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
	public int getStatus2() {
		return status2;
	}
	public void setStatus2(int status2) {
		this.status2 = status2;
	}
	public int getStatus_fk() {
		return status_fk;
	}
	public void setStatus_fk(int status_fk) {
		this.status_fk = status_fk;
	}
	public int getId_capital() {
		return id_capital;
	}
	public void setId_capital(int id_capital) {
		this.id_capital = id_capital;
	}
	public int getCapital_tag() {
		return capital_tag;
	}
	public void setCapital_tag(int capital_tag) {
		this.capital_tag = capital_tag;
	}
	public String getImages1() {
		return images1;
	}
	public void setImages1(String images1) {
		this.images1 = images1;
	}
	public String getImages2() {
		return images2;
	}
	public void setImages2(String images2) {
		this.images2 = images2;
	}
	public String getImages3() {
		return images3;
	}
	public void setImages3(String images3) {
		this.images3 = images3;
	}
	public String getImages4() {
		return images4;
	}
	public void setImages4(String images4) {
		this.images4 = images4;
	}
	public String getImages5() {
		return images5;
	}
	public void setImages5(String images5) {
		this.images5 = images5;
	}
	public String getImages6() {
		return images6;
	}
	public void setImages6(String images6) {
		this.images6 = images6;
	}
	public String getImages7() {
		return images7;
	}
	public void setImages7(String images7) {
		this.images7 = images7;
	}
	public String getImages8() {
		return images8;
	}
	public void setImages8(String images8) {
		this.images8 = images8;
	}
	public String getImages9() {
		return images9;
	}
	public void setImages9(String images9) {
		this.images9 = images9;
	}
	public String getImages10() {
		return images10;
	}
	public void setImages10(String images10) {
		this.images10 = images10;
	}
	public String getImages11() {
		return images11;
	}
	public void setImages11(String images11) {
		this.images11 = images11;
	}
	public String getImages12() {
		return images12;
	}
	public void setImages12(String images12) {
		this.images12 = images12;
	}
	public int getSfbl() {
		return sfbl;
	}
	public void setSfbl(int sfbl) {
		this.sfbl = sfbl;
	}
	public String getImagesbj() {
		return imagesbj;
	}
	public void setImagesbj(String imagesbj) {
		this.imagesbj = imagesbj;
	}
	public int getHkyh() {
		return hkyh;
	}
	public void setHkyh(int hkyh) {
		this.hkyh = hkyh;
	}
	public String getKhyh() {
		return khyh;
	}
	public void setKhyh(String khyh) {
		this.khyh = khyh;
	}
	public String getYhkh() {
		return yhkh;
	}
	public void setYhkh(String yhkh) {
		this.yhkh = yhkh;
	}
	public String getImages13() {
		return images13;
	}
	public void setImages13(String images13) {
		this.images13 = images13;
	}
	public String getVideo1() {
		return video1;
	}
	public void setVideo1(String video1) {
		this.video1 = video1;
	}
	
	
	
}
