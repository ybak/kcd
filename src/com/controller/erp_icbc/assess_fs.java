package com.controller.erp_icbc;

import java.util.Date;

import com.aliyuncs.cloudauth.model.v20171117.CompareFacesResponse.Data;
import com.sun.jna.platform.win32.OaIdl.DECIMAL;

/**
 * 作为body 实体类
 * @author Administrator
 *
 */
public class assess_fs {
	
	//fs 表 所用参数
	private	String   name; //@
	private String   name_qy;
	private Integer  showtag;
	private Integer  state_id;
	private Integer  city_id;
	private String   address;
	private String   code_pre;
	private String   namepy;
	private String   icbc_erp_tag;
	//assess_fs_details 所用参数
//	private Integer  id;
//	private String  mid_add;
//	private String  mid_edit;
//	private String  dt_add;
//	private String  dt_edit;
//	private String  company_jc;
//	private String  qy_company;
	private String  contract_code;
	private String  hz_date1;
	private String  hz_date2;
	private String  fr_name;
	private String  fr_tel;
	private String  fr_card;
	private Integer  sjkgr;
	private String  sjkgr_name;
	private String  sjkgr_card;
	private String  sjkgr_tel;
	private String  company_date;
	private String  register_capital;
	private String  sj_capital;
	private Integer  company_num;
	private Integer  company_province;
	private Integer  company_city;
	private Integer  company_section;
	private String  company_address;
	private Integer  register_province;
	private Integer  register_city;
	private Integer  register_section;
	private String  register_address;
	private Integer  account_type;
	private String  account_name;
	private String  bank_account;
	private String  open_bank;
	private String  dbr_map;
	//担保人 []
	private String  dbr_name[];
	private String  dbr_card[];
	private String  dbr_tel[];
	//配偶
	private String  dbrpo_name[];
	private String  dbrpo_card[];
	private String  dbrpo_tel[];
	//private String  dbrpo_map;
	private String  yw_lxr;
	private String  yw_tel;
	private String  yw_email;
	private String  yw_fgdqjl;
//	private String  showtag;
//	private Integer  systemtag;
//	private String  code_pre;
//	private String  name_py;
	private Integer  money_tag;
	private String  money_num;
	private Integer  money_type;
	private String  money_bz;
	private String  zy_bank;
	private Integer  zy_province;
	private Integer  zy_city;
	private Integer  hz_type;
	private Integer  ywhz_type;
	private Integer  dlspj;
	private String  new_grfx_price;
	private String  new_carpg_price;
	private String  new_cardk_price;
	private String  new_gps_price;
	private String  new_qt_price;
	private String  old_grfx_price;
	private String  old_carpg_price;
	private String  old_cardk_price;
	private String  old_gps_price;
	private String  old_qt_price;
	private String  jc_bzj[];
	private String  jc_bzjdate[];
	private String  jc_bzjbl;
	private String  sx_price;
	private String  sx_yyprice;
	private String  sx_syprice;
	private String  jc_jsfl;
	private String  yw_nzjfl;
	private String  sc_maxprice;
	private String  zzxx_code;
	private Integer  jcbzxth;
	private String  jcbzjth_price;
	private String  jcbzjth_date;
//	private Integer  fs_id;

	//gems表所用参数
	private Integer fsid;
    private String mobile;
    private String username;
    private String password;
    private Integer cp;
    private Integer idcard;
    
    //通用参数
	private String   dn;
	private String   qn;
	private String  type;
	private Integer userid;
	private String   mid_add;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName_qy() {
		return name_qy;
	}
	public void setName_qy(String name_qy) {
		this.name_qy = name_qy;
	}
	public Integer getShowtag() {
		return showtag;
	}
	public void setShowtag(Integer showtag) {
		this.showtag = showtag;
	}
	public Integer getState_id() {
		return state_id;
	}
	public void setState_id(Integer state_id) {
		this.state_id = state_id;
	}
	public Integer getCity_id() {
		return city_id;
	}
	public void setCity_id(Integer city_id) {
		this.city_id = city_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCode_pre() {
		return code_pre;
	}
	public void setCode_pre(String code_pre) {
		this.code_pre = code_pre;
	}
	public String getNamepy() {
		return namepy;
	}
	public void setNamepy(String namepy) {
		this.namepy = namepy;
	}
	public String getIcbc_erp_tag() {
		return icbc_erp_tag;
	}
	public void setIcbc_erp_tag(String icbc_erp_tag) {
		this.icbc_erp_tag = icbc_erp_tag;
	}
	public String getContract_code() {
		return contract_code;
	}
	public void setContract_code(String contract_code) {
		this.contract_code = contract_code;
	}
	public String getHz_date1() {
		return hz_date1;
	}
	public void setHz_date1(String hz_date1) {
		this.hz_date1 = hz_date1;
	}
	public String getHz_date2() {
		return hz_date2;
	}
	public void setHz_date2(String hz_date2) {
		this.hz_date2 = hz_date2;
	}
	public String getFr_name() {
		return fr_name;
	}
	public void setFr_name(String fr_name) {
		this.fr_name = fr_name;
	}
	public String getFr_tel() {
		return fr_tel;
	}
	public void setFr_tel(String fr_tel) {
		this.fr_tel = fr_tel;
	}
	public String getFr_card() {
		return fr_card;
	}
	public void setFr_card(String fr_card) {
		this.fr_card = fr_card;
	}
	public Integer getSjkgr() {
		return sjkgr;
	}
	public void setSjkgr(Integer sjkgr) {
		this.sjkgr = sjkgr;
	}
	public String getSjkgr_name() {
		return sjkgr_name;
	}
	public void setSjkgr_name(String sjkgr_name) {
		this.sjkgr_name = sjkgr_name;
	}
	public String getSjkgr_card() {
		return sjkgr_card;
	}
	public void setSjkgr_card(String sjkgr_card) {
		this.sjkgr_card = sjkgr_card;
	}
	public String getSjkgr_tel() {
		return sjkgr_tel;
	}
	public void setSjkgr_tel(String sjkgr_tel) {
		this.sjkgr_tel = sjkgr_tel;
	}
	public String getCompany_date() {
		return company_date;
	}
	public void setCompany_date(String company_date) {
		this.company_date = company_date;
	}
	public String getRegister_capital() {
		return register_capital;
	}
	public void setRegister_capital(String register_capital) {
		this.register_capital = register_capital;
	}
	public String getSj_capital() {
		return sj_capital;
	}
	public void setSj_capital(String sj_capital) {
		this.sj_capital = sj_capital;
	}
	public Integer getCompany_num() {
		return company_num;
	}
	public void setCompany_num(Integer company_num) {
		this.company_num = company_num;
	}
	public Integer getCompany_province() {
		return company_province;
	}
	public void setCompany_province(Integer company_province) {
		this.company_province = company_province;
	}
	public Integer getCompany_city() {
		return company_city;
	}
	public void setCompany_city(Integer company_city) {
		this.company_city = company_city;
	}
	public Integer getCompany_section() {
		return company_section;
	}
	public void setCompany_section(Integer company_section) {
		this.company_section = company_section;
	}
	public String getCompany_address() {
		return company_address;
	}
	public void setCompany_address(String company_address) {
		this.company_address = company_address;
	}
	public Integer getRegister_province() {
		return register_province;
	}
	public void setRegister_province(Integer register_province) {
		this.register_province = register_province;
	}
	public Integer getRegister_city() {
		return register_city;
	}
	public void setRegister_city(Integer register_city) {
		this.register_city = register_city;
	}
	public Integer getRegister_section() {
		return register_section;
	}
	public void setRegister_section(Integer register_section) {
		this.register_section = register_section;
	}
	public String getRegister_address() {
		return register_address;
	}
	public void setRegister_address(String register_address) {
		this.register_address = register_address;
	}
	public Integer getAccount_type() {
		return account_type;
	}
	public void setAccount_type(Integer account_type) {
		this.account_type = account_type;
	}
	public String getAccount_name() {
		return account_name;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	public String getBank_account() {
		return bank_account;
	}
	public void setBank_account(String bank_account) {
		this.bank_account = bank_account;
	}
	public String getOpen_bank() {
		return open_bank;
	}
	public void setOpen_bank(String open_bank) {
		this.open_bank = open_bank;
	}
	public String getDbr_map() {
		return dbr_map;
	}
	public void setDbr_map(String dbr_map) {
		this.dbr_map = dbr_map;
	}
	public String[] getDbr_name() {
		return dbr_name;
	}
	public void setDbr_name(String[] dbr_name) {
		this.dbr_name = dbr_name;
	}
	public String[] getDbr_card() {
		return dbr_card;
	}
	public void setDbr_card(String[] dbr_card) {
		this.dbr_card = dbr_card;
	}
	public String[] getDbr_tel() {
		return dbr_tel;
	}
	public void setDbr_tel(String[] dbr_tel) {
		this.dbr_tel = dbr_tel;
	}
	public String[] getDbrpo_name() {
		return dbrpo_name;
	}
	public void setDbrpo_name(String[] dbrpo_name) {
		this.dbrpo_name = dbrpo_name;
	}
	public String[] getDbrpo_card() {
		return dbrpo_card;
	}
	public void setDbrpo_card(String[] dbrpo_card) {
		this.dbrpo_card = dbrpo_card;
	}
	public String[] getDbrpo_tel() {
		return dbrpo_tel;
	}
	public void setDbrpo_tel(String[] dbrpo_tel) {
		this.dbrpo_tel = dbrpo_tel;
	}
	public String getYw_lxr() {
		return yw_lxr;
	}
	public void setYw_lxr(String yw_lxr) {
		this.yw_lxr = yw_lxr;
	}
	public String getYw_tel() {
		return yw_tel;
	}
	public void setYw_tel(String yw_tel) {
		this.yw_tel = yw_tel;
	}
	public String getYw_email() {
		return yw_email;
	}
	public void setYw_email(String yw_email) {
		this.yw_email = yw_email;
	}
	public String getYw_fgdqjl() {
		return yw_fgdqjl;
	}
	public void setYw_fgdqjl(String yw_fgdqjl) {
		this.yw_fgdqjl = yw_fgdqjl;
	}
	public Integer getMoney_tag() {
		return money_tag;
	}
	public void setMoney_tag(Integer money_tag) {
		this.money_tag = money_tag;
	}
	public String getMoney_num() {
		return money_num;
	}
	public void setMoney_num(String money_num) {
		this.money_num = money_num;
	}
	public Integer getMoney_type() {
		return money_type;
	}
	public void setMoney_type(Integer money_type) {
		this.money_type = money_type;
	}
	public String getMoney_bz() {
		return money_bz;
	}
	public void setMoney_bz(String money_bz) {
		this.money_bz = money_bz;
	}
	public String getZy_bank() {
		return zy_bank;
	}
	public void setZy_bank(String zy_bank) {
		this.zy_bank = zy_bank;
	}
	public Integer getZy_province() {
		return zy_province;
	}
	public void setZy_province(Integer zy_province) {
		this.zy_province = zy_province;
	}
	public Integer getZy_city() {
		return zy_city;
	}
	public void setZy_city(Integer zy_city) {
		this.zy_city = zy_city;
	}
	public Integer getHz_type() {
		return hz_type;
	}
	public void setHz_type(Integer hz_type) {
		this.hz_type = hz_type;
	}
	public Integer getYwhz_type() {
		return ywhz_type;
	}
	public void setYwhz_type(Integer ywhz_type) {
		this.ywhz_type = ywhz_type;
	}
	public Integer getDlspj() {
		return dlspj;
	}
	public void setDlspj(Integer dlspj) {
		this.dlspj = dlspj;
	}
	public String getNew_grfx_price() {
		return new_grfx_price;
	}
	public void setNew_grfx_price(String new_grfx_price) {
		this.new_grfx_price = new_grfx_price;
	}
	public String getNew_carpg_price() {
		return new_carpg_price;
	}
	public void setNew_carpg_price(String new_carpg_price) {
		this.new_carpg_price = new_carpg_price;
	}
	public String getNew_cardk_price() {
		return new_cardk_price;
	}
	public void setNew_cardk_price(String new_cardk_price) {
		this.new_cardk_price = new_cardk_price;
	}
	public String getNew_gps_price() {
		return new_gps_price;
	}
	public void setNew_gps_price(String new_gps_price) {
		this.new_gps_price = new_gps_price;
	}
	public String getNew_qt_price() {
		return new_qt_price;
	}
	public void setNew_qt_price(String new_qt_price) {
		this.new_qt_price = new_qt_price;
	}
	public String getOld_grfx_price() {
		return old_grfx_price;
	}
	public void setOld_grfx_price(String old_grfx_price) {
		this.old_grfx_price = old_grfx_price;
	}
	public String getOld_carpg_price() {
		return old_carpg_price;
	}
	public void setOld_carpg_price(String old_carpg_price) {
		this.old_carpg_price = old_carpg_price;
	}
	public String getOld_cardk_price() {
		return old_cardk_price;
	}
	public void setOld_cardk_price(String old_cardk_price) {
		this.old_cardk_price = old_cardk_price;
	}
	public String getOld_gps_price() {
		return old_gps_price;
	}
	public void setOld_gps_price(String old_gps_price) {
		this.old_gps_price = old_gps_price;
	}
	public String getOld_qt_price() {
		return old_qt_price;
	}
	public void setOld_qt_price(String old_qt_price) {
		this.old_qt_price = old_qt_price;
	}
	public String[] getJc_bzj() {
		return jc_bzj;
	}
	public void setJc_bzj(String[] jc_bzj) {
		this.jc_bzj = jc_bzj;
	}
	public String[] getJc_bzjdate() {
		return jc_bzjdate;
	}
	public void setJc_bzjdate(String[] jc_bzjdate) {
		this.jc_bzjdate = jc_bzjdate;
	}
	public String getJc_bzjbl() {
		return jc_bzjbl;
	}
	public void setJc_bzjbl(String jc_bzjbl) {
		this.jc_bzjbl = jc_bzjbl;
	}
	public String getSx_price() {
		return sx_price;
	}
	public void setSx_price(String sx_price) {
		this.sx_price = sx_price;
	}
	public String getSx_yyprice() {
		return sx_yyprice;
	}
	public void setSx_yyprice(String sx_yyprice) {
		this.sx_yyprice = sx_yyprice;
	}
	public String getSx_syprice() {
		return sx_syprice;
	}
	public void setSx_syprice(String sx_syprice) {
		this.sx_syprice = sx_syprice;
	}
	public String getJc_jsfl() {
		return jc_jsfl;
	}
	public void setJc_jsfl(String jc_jsfl) {
		this.jc_jsfl = jc_jsfl;
	}
	public String getYw_nzjfl() {
		return yw_nzjfl;
	}
	public void setYw_nzjfl(String yw_nzjfl) {
		this.yw_nzjfl = yw_nzjfl;
	}
	public String getSc_maxprice() {
		return sc_maxprice;
	}
	public void setSc_maxprice(String sc_maxprice) {
		this.sc_maxprice = sc_maxprice;
	}
	public String getZzxx_code() {
		return zzxx_code;
	}
	public void setZzxx_code(String zzxx_code) {
		this.zzxx_code = zzxx_code;
	}
	public Integer getJcbzxth() {
		return jcbzxth;
	}
	public void setJcbzxth(Integer jcbzxth) {
		this.jcbzxth = jcbzxth;
	}
	public String getJcbzjth_price() {
		return jcbzjth_price;
	}
	public void setJcbzjth_price(String jcbzjth_price) {
		this.jcbzjth_price = jcbzjth_price;
	}
	public String getJcbzjth_date() {
		return jcbzjth_date;
	}
	public void setJcbzjth_date(String jcbzjth_date) {
		this.jcbzjth_date = jcbzjth_date;
	}
	public Integer getFsid() {
		return fsid;
	}
	public void setFsid(Integer fsid) {
		this.fsid = fsid;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getCp() {
		return cp;
	}
	public void setCp(Integer cp) {
		this.cp = cp;
	}
	public Integer getIdcard() {
		return idcard;
	}
	public void setIdcard(Integer idcard) {
		this.idcard = idcard;
	}
	public String getDn() {
		return dn;
	}
	public void setDn(String dn) {
		this.dn = dn;
	}
	public String getQn() {
		return qn;
	}
	public void setQn(String qn) {
		this.qn = qn;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getMid_add() {
		return mid_add;
	}
	public void setMid_add(String mid_add) {
		this.mid_add = mid_add;
	}

	
}
