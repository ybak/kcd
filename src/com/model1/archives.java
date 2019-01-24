/**
 * 2017-10-28
 * @author zhuyilong
 * 杞﹁締妗ｆ鏌ヨ/淇濆吇鏌ヨ
 */
package com.model1;

public class archives {
	private int id;//数据编号
	private int mid_add;//建单人id
	private int mid_edit;//最后编辑人id
	private String dt_add;//创建时间
	private String dt_edit;//更新时间
	private String imgurl;//
	private int bc_status;//
	private int query_type;//0为档案查询，1为维修保养查寻
	private int gems_id;//商户端ID
	private int gems_fs_id;//商户端店铺ID
	private String gems_code;//订单编号
	private String c_name;//客户姓名
	private String c_tel;//客户电话
	private String c_carno;//车牌
	private String c_vin;//vin
	private String dt_fin;//报告基准日
	private int adminop_tag;//后台操作状态
	private String cbs_orderid;//查博士api—
	private String cbs_result;//查博士返回结果
	private String result_imgurl1;//返回结果1
	private String result_imgurl2;//返回结果2
	private String result_imgurl3;//返回结果3
	private String result_imgurl4;
	private String result_imgurl5;
	private String result_imgurl6;
	private String result_imgurl7;
	private String result_imgurl8;
	private String result_imgurl9;
	private String result_imgurl10;
	private String result_imgurl11;
	private String result_imgurl12;
	private String result_imgurl13;
	private String result_imgurl14;
	private String result_imgurl15;
	private String result_imgurl16;
	private String result_imgurl17;
	private String result_imgurl18;
	private String result_imgurl19;
	private String result_imgurl20;
	private String result_imgurl21;
	private String result_imgurl22;
	private String result_imgurl23;
	private String result_imgurl24;
	private String result_imgurl25;
	private String result_imgurl26;
	private String result_imgurl27;
	private String result_imgurl28;
	private String result_imgurl29;
	private String result_imgurl30;
	private String r_item1;//车牌号码
	private String r_item2;//机动车所有人
	private String r_item3;//身份证号码
	private String r_item4;//中文品牌
	private String r_item5;//车辆型号
	private String r_item6;//车架识别仪号
	private String r_item7;//发动机号
	private String r_item8;//使用性质
	private String r_item9;//登记机关
	private String r_item10;//车身颜色
	private String r_item11;//核定载客
	private String r_item12;//行驶证芯编码
	private String r_item13;//初次登记日期
	private String r_item14;//出厂登记日期
	private String r_item15;//强制报废期止
	private String r_item16;//保险有效期止
	private String r_item17;//新能源汽
	private String r_item18;//检验有效期
	private String r_item19;//排量/功率
	private String r2_item1;//机动车状态
	private String r2_item2;//事故逃逸
	private String r2_item3;//车辆套牌
	private String r2_item4;//车辆盗抢
	private String r2_item5;//抵押标记
	private String r2_item6;//抵押时间
	private String r2_item7;//抵押权人
	private String r2_item8;//历史抵押
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
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public int getBc_status() {
		return bc_status;
	}
	public void setBc_status(int bc_status) {
		this.bc_status = bc_status;
	}
	public int getQuery_type() {
		return query_type;
	}
	public void setQuery_type(int query_type) {
		this.query_type = query_type;
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

	public String getC_carno() {
		return c_carno;
	}
	public void setC_carno(String c_carno) {
		this.c_carno = c_carno;
	}
	public String getC_vin() {
		return c_vin;
	}
	public void setC_vin(String c_vin) {
		this.c_vin = c_vin;
	}
	public String getGems_code() {
		return gems_code;
	}
	public void setGems_code(String gems_code) {
		this.gems_code = gems_code;
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
	public String getCbs_orderid() {
		return cbs_orderid;
	}
	public void setCbs_orderid(String cbs_orderid) {
		this.cbs_orderid = cbs_orderid;
	}
	public String getCbs_result() {
		return cbs_result;
	}
	public void setCbs_result(String cbs_result) {
		this.cbs_result = cbs_result;
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
	public String getResult_imgurl6() {
		return result_imgurl6;
	}
	public void setResult_imgurl6(String result_imgurl6) {
		this.result_imgurl6 = result_imgurl6;
	}
	public String getResult_imgurl7() {
		return result_imgurl7;
	}
	public void setResult_imgurl7(String result_imgurl7) {
		this.result_imgurl7 = result_imgurl7;
	}
	public String getResult_imgurl8() {
		return result_imgurl8;
	}
	public void setResult_imgurl8(String result_imgurl8) {
		this.result_imgurl8 = result_imgurl8;
	}
	public String getResult_imgurl9() {
		return result_imgurl9;
	}
	public void setResult_imgurl9(String result_imgurl9) {
		this.result_imgurl9 = result_imgurl9;
	}
	public String getResult_imgurl10() {
		return result_imgurl10;
	}
	public void setResult_imgurl10(String result_imgurl10) {
		this.result_imgurl10 = result_imgurl10;
	}
	public String getResult_imgurl11() {
		return result_imgurl11;
	}
	public void setResult_imgurl11(String result_imgurl11) {
		this.result_imgurl11 = result_imgurl11;
	}
	public String getResult_imgurl12() {
		return result_imgurl12;
	}
	public void setResult_imgurl12(String result_imgurl12) {
		this.result_imgurl12 = result_imgurl12;
	}
	public String getResult_imgurl13() {
		return result_imgurl13;
	}
	public void setResult_imgurl13(String result_imgurl13) {
		this.result_imgurl13 = result_imgurl13;
	}
	public String getResult_imgurl14() {
		return result_imgurl14;
	}
	public void setResult_imgurl14(String result_imgurl14) {
		this.result_imgurl14 = result_imgurl14;
	}
	public String getResult_imgurl15() {
		return result_imgurl15;
	}
	public void setResult_imgurl15(String result_imgurl15) {
		this.result_imgurl15 = result_imgurl15;
	}
	public String getResult_imgurl16() {
		return result_imgurl16;
	}
	public void setResult_imgurl16(String result_imgurl16) {
		this.result_imgurl16 = result_imgurl16;
	}
	public String getResult_imgurl17() {
		return result_imgurl17;
	}
	public void setResult_imgurl17(String result_imgurl17) {
		this.result_imgurl17 = result_imgurl17;
	}
	public String getResult_imgurl18() {
		return result_imgurl18;
	}
	public void setResult_imgurl18(String result_imgurl18) {
		this.result_imgurl18 = result_imgurl18;
	}
	public String getResult_imgurl19() {
		return result_imgurl19;
	}
	public void setResult_imgurl19(String result_imgurl19) {
		this.result_imgurl19 = result_imgurl19;
	}
	public String getResult_imgurl20() {
		return result_imgurl20;
	}
	public void setResult_imgurl20(String result_imgurl20) {
		this.result_imgurl20 = result_imgurl20;
	}
	public String getResult_imgurl21() {
		return result_imgurl21;
	}
	public void setResult_imgurl21(String result_imgurl21) {
		this.result_imgurl21 = result_imgurl21;
	}
	public String getResult_imgurl22() {
		return result_imgurl22;
	}
	public void setResult_imgurl22(String result_imgurl22) {
		this.result_imgurl22 = result_imgurl22;
	}
	public String getResult_imgurl23() {
		return result_imgurl23;
	}
	public void setResult_imgurl23(String result_imgurl23) {
		this.result_imgurl23 = result_imgurl23;
	}
	public String getResult_imgurl24() {
		return result_imgurl24;
	}
	public void setResult_imgurl24(String result_imgurl24) {
		this.result_imgurl24 = result_imgurl24;
	}
	public String getResult_imgurl25() {
		return result_imgurl25;
	}
	public void setResult_imgurl25(String result_imgurl25) {
		this.result_imgurl25 = result_imgurl25;
	}
	public String getResult_imgurl26() {
		return result_imgurl26;
	}
	public void setResult_imgurl26(String result_imgurl26) {
		this.result_imgurl26 = result_imgurl26;
	}
	public String getResult_imgurl27() {
		return result_imgurl27;
	}
	public void setResult_imgurl27(String result_imgurl27) {
		this.result_imgurl27 = result_imgurl27;
	}
	public String getResult_imgurl28() {
		return result_imgurl28;
	}
	public void setResult_imgurl28(String result_imgurl28) {
		this.result_imgurl28 = result_imgurl28;
	}
	public String getResult_imgurl29() {
		return result_imgurl29;
	}
	public void setResult_imgurl29(String result_imgurl29) {
		this.result_imgurl29 = result_imgurl29;
	}
	public String getResult_imgurl30() {
		return result_imgurl30;
	}
	public void setResult_imgurl30(String result_imgurl30) {
		this.result_imgurl30 = result_imgurl30;
	}
	public String getR_item1() {
		return r_item1;
	}
	public void setR_item1(String r_item1) {
		this.r_item1 = r_item1;
	}
	public String getR_item2() {
		return r_item2;
	}
	public void setR_item2(String r_item2) {
		this.r_item2 = r_item2;
	}
	public String getR_item3() {
		return r_item3;
	}
	public void setR_item3(String r_item3) {
		this.r_item3 = r_item3;
	}
	public String getR_item4() {
		return r_item4;
	}
	public void setR_item4(String r_item4) {
		this.r_item4 = r_item4;
	}
	public String getR_item5() {
		return r_item5;
	}
	public void setR_item5(String r_item5) {
		this.r_item5 = r_item5;
	}
	public String getR_item6() {
		return r_item6;
	}
	public void setR_item6(String r_item6) {
		this.r_item6 = r_item6;
	}
	public String getR_item7() {
		return r_item7;
	}
	public void setR_item7(String r_item7) {
		this.r_item7 = r_item7;
	}
	public String getR_item8() {
		return r_item8;
	}
	public void setR_item8(String r_item8) {
		this.r_item8 = r_item8;
	}
	public String getR_item9() {
		return r_item9;
	}
	public void setR_item9(String r_item9) {
		this.r_item9 = r_item9;
	}
	public String getR_item10() {
		return r_item10;
	}
	public void setR_item10(String r_item10) {
		this.r_item10 = r_item10;
	}
	public String getR_item11() {
		return r_item11;
	}
	public void setR_item11(String r_item11) {
		this.r_item11 = r_item11;
	}
	public String getR_item12() {
		return r_item12;
	}
	public void setR_item12(String r_item12) {
		this.r_item12 = r_item12;
	}
	public String getR_item13() {
		return r_item13;
	}
	public void setR_item13(String r_item13) {
		this.r_item13 = r_item13;
	}
	public String getR_item14() {
		return r_item14;
	}
	public void setR_item14(String r_item14) {
		this.r_item14 = r_item14;
	}
	public String getR_item15() {
		return r_item15;
	}
	public void setR_item15(String r_item15) {
		this.r_item15 = r_item15;
	}
	public String getR_item16() {
		return r_item16;
	}
	public void setR_item16(String r_item16) {
		this.r_item16 = r_item16;
	}
	public String getR_item17() {
		return r_item17;
	}
	public void setR_item17(String r_item17) {
		this.r_item17 = r_item17;
	}
	public String getR_item18() {
		return r_item18;
	}
	public void setR_item18(String r_item18) {
		this.r_item18 = r_item18;
	}
	public String getR_item19() {
		return r_item19;
	}
	public void setR_item19(String r_item19) {
		this.r_item19 = r_item19;
	}
	public String getR2_item1() {
		return r2_item1;
	}
	public void setR2_item1(String r2_item1) {
		this.r2_item1 = r2_item1;
	}
	public String getR2_item2() {
		return r2_item2;
	}
	public void setR2_item2(String r2_item2) {
		this.r2_item2 = r2_item2;
	}
	public String getR2_item3() {
		return r2_item3;
	}
	public void setR2_item3(String r2_item3) {
		this.r2_item3 = r2_item3;
	}
	public String getR2_item4() {
		return r2_item4;
	}
	public void setR2_item4(String r2_item4) {
		this.r2_item4 = r2_item4;
	}
	public String getR2_item5() {
		return r2_item5;
	}
	public void setR2_item5(String r2_item5) {
		this.r2_item5 = r2_item5;
	}
	public String getR2_item6() {
		return r2_item6;
	}
	public void setR2_item6(String r2_item6) {
		this.r2_item6 = r2_item6;
	}
	public String getR2_item7() {
		return r2_item7;
	}
	public void setR2_item7(String r2_item7) {
		this.r2_item7 = r2_item7;
	}
	public String getR2_item8() {
		return r2_item8;
	}
	public void setR2_item8(String r2_item8) {
		this.r2_item8 = r2_item8;
	}
	
	
	
	
}
