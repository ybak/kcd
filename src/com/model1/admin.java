package com.model1;

public class admin {
    private int id;
    private int mid_add;//添加人
    private int mid_edit;//编辑人
    private String dt_add;//添加时间
    private String dt_edit;//编辑时间
    private int  deltag;//删除：1是 0否
    private int isadmin;//管理员 1是 0否
    private int issupplier;
    private int showtag;//允许登陆：1是 0否
	private String username;//用户名
	private String userpass;//密码md5加密
	private String tel;//电话
	private String email;//电子邮件
	private String name;//前台昵称或后台姓名
	private int sex;
	private String logindt;//最后登陆时间
	private String logincode;//登陆码
	private int limit_list;//分页显示条数
	private String imgurl;
	private int stateid;
	private int cityid;
	private int eeid;
	private String note;
	private String wx_openid;//
	private int gemsid;//鉴定师ID
	private String bc_title;//评估师称号
	private int fs_type;//加盟店类型,0为快加认证的，1为快加商户端
	private String jgid;
	private int agpid;
	private String loginip;
	private int ssm_id;//业务员需求-关联业务员账号
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
	public int getDeltag() {
		return deltag;
	}
	public void setDeltag(int deltag) {
		this.deltag = deltag;
	}
	public int getIsadmin() {
		return isadmin;
	}
	public void setIsadmin(int isadmin) {
		this.isadmin = isadmin;
	}
	public int getIssupplier() {
		return issupplier;
	}
	public void setIssupplier(int issupplier) {
		this.issupplier = issupplier;
	}
	public int getShowtag() {
		return showtag;
	}
	public void setShowtag(int showtag) {
		this.showtag = showtag;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpass() {
		return userpass;
	}
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getLogindt() {
		return logindt;
	}
	public void setLogindt(String logindt) {
		this.logindt = logindt;
	}
	public String getLogincode() {
		return logincode;
	}
	public void setLogincode(String logincode) {
		this.logincode = logincode;
	}
	public int getLimit_list() {
		return limit_list;
	}
	public void setLimit_list(int limit_list) {
		this.limit_list = limit_list;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
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
	public int getEeid() {
		return eeid;
	}
	public void setEeid(int eeid) {
		this.eeid = eeid;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getWx_openid() {
		return wx_openid;
	}
	public void setWx_openid(String wx_openid) {
		this.wx_openid = wx_openid;
	}
	public int getGemsid() {
		return gemsid;
	}
	public void setGemsid(int gemsid) {
		this.gemsid = gemsid;
	}
	public String getBc_title() {
		return bc_title;
	}
	public void setBc_title(String bc_title) {
		this.bc_title = bc_title;
	}
	public int getFs_type() {
		return fs_type;
	}
	public void setFs_type(int fs_type) {
		this.fs_type = fs_type;
	}
	public String getJgid() {
		return jgid;
	}
	public void setJgid(String jgid) {
		this.jgid = jgid;
	}
	public int getAgpid() {
		return agpid;
	}
	public void setAgpid(int agpid) {
		this.agpid = agpid;
	}
	public String getLoginip() {
		return loginip;
	}
	public void setLoginip(String loginip) {
		this.loginip = loginip;
	}
	public int getSsm_id() {
		return ssm_id;
	}
	public void setSsm_id(int ssm_id) {
		this.ssm_id = ssm_id;
	}
	
}
