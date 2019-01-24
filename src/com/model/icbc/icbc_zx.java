package com.model.icbc;

public class icbc_zx {
	private int id;
	private String c_name;
	private String c_cardno;
	private String c_del;
	private int sex;
	private int icbc_ajbank_id;
	private int dk_produce_id;
	private int yw_id;
	private String po_name;
	private String po_cardno;
	private String po_phoneno;
	private String g_name1;
	private String g_cardno1;
	private String g_phoneno1;
	private String g_name2;
	private String g_cardno2;
	private String g_phoneno2;
	private String img_1;
	private String img_2;
	private String img_3;
	private String img_4;
	private String img_1s;
	private int bc_status;
	private String zx_result;
	private String add_dt;
	private String up_dt;
	private String result_dt;
	private int md_add;
	private int md_edit;
	private int api_add;
	private int api_edit;
	private int sh_edit;
	private int mid_add;	//int	11	0	-1	0	0	0	0		0					0	0
	private int mid_edit;	//int	11	0	-1	0	0	0	0		0					0	0
	private String dt_add;	//datetime	0	0	-1	0	0	0	0		0	最初建档时间				0	0
	private String dt_edit;	//datetime	0	0	-1	0	0	0	0		0	最后修改时间				0	0
	private String dt_sub;	//datetime	0	0	-1	0	0	0	0		0	最后一次提交时间				0	0
	private String dt_fin;	//datetime	0	0	-1	0	0	0	0		0	完成订单时间				0	0
	private String gems_code;	//varchar	50	0	-1	0	0	0	0		0		utf8	utf8_general_ci		0	0
	private int query_type;	//int	4	0	-1	0	0	0	0		0	查询类型				0	0
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
	public String getC_cardno() {
		return c_cardno;
	}
	public void setC_cardno(String c_cardno) {
		this.c_cardno = c_cardno;
	}
	public String getC_del() {
		return c_del;
	}
	public void setC_del(String c_del) {
		this.c_del = c_del;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getIcbc_ajbank_id() {
		return icbc_ajbank_id;
	}
	public void setIcbc_ajbank_id(int icbc_ajbank_id) {
		this.icbc_ajbank_id = icbc_ajbank_id;
	}
	public int getDk_produce_id() {
		return dk_produce_id;
	}
	public void setDk_produce_id(int dk_produce_id) {
		this.dk_produce_id = dk_produce_id;
	}
	public int getYw_id() {
		return yw_id;
	}
	public void setYw_id(int yw_id) {
		this.yw_id = yw_id;
	}
	public String getPo_name() {
		return po_name;
	}
	public void setPo_name(String po_name) {
		this.po_name = po_name;
	}
	public String getPo_cardno() {
		return po_cardno;
	}
	public void setPo_cardno(String po_cardno) {
		this.po_cardno = po_cardno;
	}
	public String getPo_phoneno() {
		return po_phoneno;
	}
	public void setPo_phoneno(String po_phoneno) {
		this.po_phoneno = po_phoneno;
	}
	public String getG_name1() {
		return g_name1;
	}
	public void setG_name1(String g_name1) {
		this.g_name1 = g_name1;
	}
	public String getG_cardno1() {
		return g_cardno1;
	}
	public void setG_cardno1(String g_cardno1) {
		this.g_cardno1 = g_cardno1;
	}
	public String getG_phoneno1() {
		return g_phoneno1;
	}
	public void setG_phoneno1(String g_phoneno1) {
		this.g_phoneno1 = g_phoneno1;
	}
	public String getG_name2() {
		return g_name2;
	}
	public void setG_name2(String g_name2) {
		this.g_name2 = g_name2;
	}
	public String getG_cardno2() {
		return g_cardno2;
	}
	public void setG_cardno2(String g_cardno2) {
		this.g_cardno2 = g_cardno2;
	}
	public String getG_phoneno2() {
		return g_phoneno2;
	}
	public void setG_phoneno2(String g_phoneno2) {
		this.g_phoneno2 = g_phoneno2;
	}
	public String getImg_1() {
		return img_1;
	}
	public void setImg_1(String img_1) {
		this.img_1 = img_1;
	}
	public String getImg_2() {
		return img_2;
	}
	public void setImg_2(String img_2) {
		this.img_2 = img_2;
	}
	public String getImg_3() {
		return img_3;
	}
	public void setImg_3(String img_3) {
		this.img_3 = img_3;
	}
	public String getImg_4() {
		return img_4;
	}
	public void setImg_4(String img_4) {
		this.img_4 = img_4;
	}
	public String getImg_1s() {
		return img_1s;
	}
	public void setImg_1s(String img_1s) {
		this.img_1s = img_1s;
	}
	public int getBc_status() {
		return bc_status;
	}
	public void setBc_status(int bc_status) {
		this.bc_status = bc_status;
	}
	public String getZx_result() {
		return zx_result;
	}
	public void setZx_result(String zx_result) {
		this.zx_result = zx_result;
	}
	public String getAdd_dt() {
		return add_dt;
	}
	public void setAdd_dt(String add_dt) {
		this.add_dt = add_dt;
	}
	public String getUp_dt() {
		return up_dt;
	}
	public void setUp_dt(String up_dt) {
		this.up_dt = up_dt;
	}
	public String getResult_dt() {
		return result_dt;
	}
	public void setResult_dt(String result_dt) {
		this.result_dt = result_dt;
	}
	public int getMd_add() {
		return md_add;
	}
	public void setMd_add(int md_add) {
		this.md_add = md_add;
	}
	public int getMd_edit() {
		return md_edit;
	}
	public void setMd_edit(int md_edit) {
		this.md_edit = md_edit;
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
	public int getSh_edit() {
		return sh_edit;
	}
	public void setSh_edit(int sh_edit) {
		this.sh_edit = sh_edit;
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
	public String getDt_sub() {
		return dt_sub;
	}
	public void setDt_sub(String dt_sub) {
		this.dt_sub = dt_sub;
	}
	public String getDt_fin() {
		return dt_fin;
	}
	public void setDt_fin(String dt_fin) {
		this.dt_fin = dt_fin;
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

	
	
	

}
