/**
 * 2017-10-28
 * @author zhuyilong
 * 涓汉浜鸿寰佷俊/澶ф暟鎹緛淇�
 */
package com.model1;

public class zx {
	private int id;//数据编号
	private int mid_add;//建单人id
	private int mid_edit;//最后编辑人id
	private String dt_add;//创建时间
	private String dt_edit;//更新时间
	private int bc_status;//
	private int query_type;//0为人行查询，1为大数据查询
	private int gems_id;//商户端ID
	private int gems_fs_id;//商户端店铺ID
	private String gems_code;//订单号
	private String c_name;//客户姓名
	private String c_tel;//客户电话
	private String imgurl1;//身份证正面
	private String imgurl2;//身份证反面
	private String imgurl3;//个人与授权书合影
	private String imgurl4;//征信照片4
	private String imgurl5;//征信照片5
	private String result_imgurl1;//返回结果图1
	private String result_imgurl2;//返回结果图2
	private String result_imgurl3;//返回结果图3
	private String result_imgurl4;//返回结果图4
	private String td_apimsg;//
	private String report_id;//
	private String result_doc1;//
	private String result_doc2;//
	private String men_name;//客户姓名
	private String men_tel;//客户电话
	private String result_pdf;//
	private String c_nation;//民族
	private String c_address;//
	private String c_card_no;//
	private String c_card_outdate;//
	private String c_card_office;//
	private String c_book_no;//
	private String c_card_type;//
	private String c_sex;//
	private int c_bs;//
	private String c_oldname;//
	private String c_yb;//
	private int adminop_tag;//后台操作状态
	private int book_status;//授权书回收状态
	private String dt_fin;//完成时间
	private String pdf_bk;//pdf备份
	private int books_id;//授权书分类
	private String c_book_no_black;//黑名单授权书
	private int cs_tag;//初审状态,1通过
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
	public String getGems_code() {
		return gems_code;
	}
	public void setGems_code(String gems_code) {
		this.gems_code = gems_code;
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
	public String getImgurl1() {
		return imgurl1;
	}
	public void setImgurl1(String imgurl1) {
		this.imgurl1 = imgurl1;
	}
	public String getImgurl2() {
		return imgurl2;
	}
	public void setImgurl2(String imgurl2) {
		this.imgurl2 = imgurl2;
	}
	public String getImgurl3() {
		return imgurl3;
	}
	public void setImgurl3(String imgurl3) {
		this.imgurl3 = imgurl3;
	}
	public String getImgurl4() {
		return imgurl4;
	}
	public void setImgurl4(String imgurl4) {
		this.imgurl4 = imgurl4;
	}
	public String getImgurl5() {
		return imgurl5;
	}
	public void setImgurl5(String imgurl5) {
		this.imgurl5 = imgurl5;
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
	public String getTd_apimsg() {
		return td_apimsg;
	}
	public void setTd_apimsg(String td_apimsg) {
		this.td_apimsg = td_apimsg;
	}
	public String getReport_id() {
		return report_id;
	}
	public void setReport_id(String report_id) {
		this.report_id = report_id;
	}
	public String getResult_doc1() {
		return result_doc1;
	}
	public void setResult_doc1(String result_doc1) {
		this.result_doc1 = result_doc1;
	}
	public String getResult_doc2() {
		return result_doc2;
	}
	public void setResult_doc2(String result_doc2) {
		this.result_doc2 = result_doc2;
	}
	public String getMen_name() {
		return men_name;
	}
	public void setMen_name(String men_name) {
		this.men_name = men_name;
	}
	public String getMen_tel() {
		return men_tel;
	}
	public void setMen_tel(String men_tel) {
		this.men_tel = men_tel;
	}
	public String getResult_pdf() {
		return result_pdf;
	}
	public void setResult_pdf(String result_pdf) {
		this.result_pdf = result_pdf;
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
	public String getC_card_no() {
		return c_card_no;
	}
	public void setC_card_no(String c_card_no) {
		this.c_card_no = c_card_no;
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
	public String getC_book_no() {
		return c_book_no;
	}
	public void setC_book_no(String c_book_no) {
		this.c_book_no = c_book_no;
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
	public int getC_bs() {
		return c_bs;
	}
	public void setC_bs(int c_bs) {
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
	public int getAdminop_tag() {
		return adminop_tag;
	}
	public void setAdminop_tag(int adminop_tag) {
		this.adminop_tag = adminop_tag;
	}
	public int getBook_status() {
		return book_status;
	}
	public void setBook_status(int book_status) {
		this.book_status = book_status;
	}
	public String getDt_fin() {
		return dt_fin;
	}
	public void setDt_fin(String dt_fin) {
		this.dt_fin = dt_fin;
	}
	public String getPdf_bk() {
		return pdf_bk;
	}
	public void setPdf_bk(String pdf_bk) {
		this.pdf_bk = pdf_bk;
	}
	public int getBooks_id() {
		return books_id;
	}
	public void setBooks_id(int books_id) {
		this.books_id = books_id;
	}
	public String getC_book_no_black() {
		return c_book_no_black;
	}
	public void setC_book_no_black(String c_book_no_black) {
		this.c_book_no_black = c_book_no_black;
	}
	public int getCs_tag() {
		return cs_tag;
	}
	public void setCs_tag(int cs_tag) {
		this.cs_tag = cs_tag;
	}
	
	
	
	
}
