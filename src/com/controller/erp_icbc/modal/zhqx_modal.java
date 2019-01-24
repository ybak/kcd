package com.controller.erp_icbc.modal;

public class zhqx_modal {
	//其他参数
	private String   dn;
	private String   qn;
	private String   type;
	private String   cn;
	private Integer  id;
	private String  name;
	private Integer modal_tag;//模板标记 1 是  0否
	private Integer qx_type;//权限类型 默认0 ， 1 代理商， 2审核员/管理员 
	//权限
	//1.管理中心
	private String   glzx;
	
	//2.工作任务
	private String   gzrw;
	private String   qbrw;
	private String   wdrw;
	private String   wdcy;
	private String   wdqd;
	
	//3.账户管理
	private String   zhgl;
	private String   gsgl;
	private String   gsgladd;
	private String   gsgldelete;
	private String   gsglupdate;
	private String   rygl;
	private String   zhqxadd;
	private String   zhqxdelete;
	private String   zhqxupdate;
	private String   zhqx;
	private String   rygladd;
	private String   rygldelete;
	private String   ryglupdate;
	
	//4.武林工行贷
	private String   wlghd;
	private String   zx;
	private String   qcpg;
	private String   kk;
	private String   ssmq;
	private String   qcdk;
	private String   clhs;
	   //4.杭州城站支行
		private String   hzczzh;
		private String   zx1;
		private String   qcpg1;
		private String   ssmq1;
		private String   qcdk1;
		private String   clhs1;
		//4.哈尔滨顾乡支行
		private String   hebgxzh;
		private String   zx2;
		private String   qcpg2;
		private String   ssmq2;
		private String   qcdk2;
		private String   clhs2;
		//4.台州路桥支行
		private String   tzlqzh;
		private String   zx3;
		private String   qcpg3;
		private String   ssmq3;
		private String   qcdk3;
		private String   clhs3;
		//4.南京江宁支行
		private String   njjnzh;
		private String   zx4;
		private String   qcpg4;
		private String   ssmq4;
		private String   qcdk4;
		private String   clhs4;
	//5.贷后管理
	private String   dhgl;
	private String   yhhkxq;
	private String   yhhklr;
	private String   dclcjyq;
	private String   dclzjyq;
	private String   dclgjyq;
	private String   dcltc;
	private String   dclgs;
	private String   dhx;
	private String   yhx;
	
	//6.财务管理
	private String   cwgl;
	private String   khdkmx;
	private String   dqywgl;
	private String   ywfksq;
	private String   dzjl;
	private String   fkjl;
	private String   dhywgl;
	private String   sqdc;
	private String   dcqr;
	private String   hzsdc;
	private String   hzsdcqr;
	private String   gsdz;
	private String   cwgl_yhdk;
	private String   cwsz;
	//车辆抵押
	private String   cldy;
	//GPS安装
	private String   gpsaz;
	//GPS管理
	private String   gpsgl;
	//客户还款管理
	private String   khhkgl;
	private String   khhklr;
	private String   khhkqk;
	//客户逾期名单
	private String   khyqmd;
	//电催作业
	private String   dczy;
	//拖车管理
	private String   tcgl;
	private String   tc_ysl;
	private String   tc_wsl;
	private String   tc_wc;
	//诉讼管理
	private String   ssgl;
	//保险管理 
	private String   bxgl;
	//车险理赔 
	private String   cxlp;
	//结清处理
	private String   cqcl;
	private String   cqcl_yjq;
	private String   cqcl_wjq;
	//7.在线视频
	private String   zxsp;
	//8.处理过程
	private String   clgc;
	
	//9.征信查询
	private String   zxcx;
	private String   cxjg_3;
	//10.征信通融
	private String   zxtr;
	private String   zxyhyj_6;
	private String   trsh_7;

	//11.车辆评估
	private String clpg;
	private String pgjsh_11;
	//12.银行电审
	private String yhds;
	private String dsjg_15;
	//13.开卡申请
	private String kksq;
	private String sfhcjg_19;
	private String fkkkjg_20;
	//14.视频面签
	private String spmq;
	private String jgfk_24;
	//15.跨区域业务审批
	private String kqyywsp;
	private String zgsh_27;
	private String zjlsh_29;
	//16.汽车贷款
	private String qcdksh;
	private String zysh_33;
	private String zgsh_35;
	private String jlsh_37;
	private String zjsh_39;
	//17.内审通融
	private String nstr;
	private String jgzjl_42;
	private String trshyj_43;
	private String trzg_44;
	private String trjl_45;
	//18.资金分配
	private String zjfp;
	private String qrsqdz_48;
	private String zjfp_49;
	private String cz_50;
	private String sslr_51;
	private String cwqrdz_52;
	//19.银行贷款申请
	private String yhdksq;
	private String jgjscl_57;
	private String jtsjqr_58;
	private String yhsjqr_59;
	private String yhspjg_60;
	private String yhfkjg_61;
	private String skqr_62;
	private String bcclqr_63;
	private String bccl_64;
	//20.公司归档
	private String gsgd;
	private String jtzzgd_67;
	private String zzgd_68;
	private String shybcl_69;
	private String xzrk_70;
	//21.抵押归档
	private String dygd;
	private String gzjl_73;
	private String dycljsjg_74;
	private String jgsjqr_75;
	private String dyqkjl_76;
	private String dycljh_77;
	private String shsjqr_78;
	private String dyclzyh_79;
	private String yhsjqr_80;
	private String lryhcyqk_81;
	//22.业务信息修改
	private String ywxxxg;
	private String ywglb_84;
	private String xtyw_85;
	private String ywxxxgsq_96;
	//23.退单退费
	private String tdtf;
	private String shytdsh_88;
	private String tdsjxz_89;
	private String shjltdsh_90;
	private String jghkjf_91;
	private String gsqrdz_92;
	private String cljh_93;
	private String jgsjqr_94;
	//24.客户管理
	private String khgl;
	private String zdrxx;
	private String ghrxx;
	private String qtlxr;
	private String srxx;
	private String jtxx;
	private String fcxx;
	//25.贷款管理
	private String dkgl;
	//26.车辆信息
	private String clxx;
	//27.资质审查
	private String zzsc	;
	private String sfrz	;
	private String sjhm	;
	private String mzmd;
	private String grfxxx;
	private String bjgcxxx;
	private String fqzbg;
	private String zxbg;
	//28.影音材料
	private String yycl;
	private String yycl11;
	private String yycl2;
	private String yycl3;
	private String yycl4;
	private String yycl5;
	private String yycl6;
	private String yycl7;
	private String yycl8;
	private String yycl9;
	private String yycl10;
	//29.收费明细
	private String sfmx;
	//30.收费明细
	private String clhsqk;
	//31.生成模板
	private String scmb;
	//32.任务处理
	private String rwcl;
	//33.2018-08-30 新增融资
	private String financing;
	private String financing_101;
	private String financing_102;
	private String financing_103;
	//权限集合
	private String gpurview_map;
	//权限组字符串
	public String getGpurview_map() {
		gpurview_map=glzx+","
                +gzrw+","+wdrw+","+wdcy+","+wdqd+","+qbrw+","
                +zhgl+","+gsgl+","+rygl+","+zhqx+","+gsgladd+","+gsgldelete+","+gsglupdate+","+zhqxadd+","+zhqxdelete+","+zhqxupdate+","+rygladd+","+rygldelete+","+ryglupdate+","
                +wlghd+","+zx+","+qcpg+","+kk+","+ssmq+","+qcdk+","
                +hzczzh+","+zx1+","+qcpg1+","+ssmq1+","+qcdk1+","
                +hebgxzh+","+zx2+","+qcpg2+","+ssmq2+","+qcdk2+","
                +tzlqzh+","+zx3+","+qcpg3+","+ssmq3+","+qcdk3+","
                +njjnzh+","+zx4+","+qcpg4+","+ssmq4+","+qcdk4+","
                +dhgl+","+yhhkxq+","+yhhklr+","+dclcjyq+","+dclzjyq+","+dclgjyq+","+dcltc+","+dclgs+","+dhx+","+yhx+","
                +cwgl+","+khdkmx+","+dqywgl+","+ywfksq+","+dzjl+","+fkjl+","+dhywgl+","+sqdc+","+dcqr+","+hzsdc+","+hzsdcqr+","+gsdz+","+cwgl_yhdk+","+cwsz+","
                +zxsp+","
                +zxsp+","
                +cldy+","
                +gpsaz+","
                +gpsgl+","
                +khhkgl+","+khhklr+","+khhkqk+","
                +khyqmd+","
                +dczy+","
                +tcgl+","+tc_ysl+","+tc_wsl+","+tc_wc+","
                +ssgl+","
                +bxgl+","
                +cxlp+","
                +cqcl+","+cqcl_yjq+","+cqcl_wjq+","
                +zxcx+","+cxjg_3+","
                +zxtr+","+zxyhyj_6+","+trsh_7+","
                +clpg+","+pgjsh_11+","
                +yhds+","+dsjg_15+","
                +kksq+","+sfhcjg_19+","+fkkkjg_20+","
                +spmq+","+jgfk_24+","
                +kqyywsp+","+zgsh_27+","+zjlsh_29+","
                +qcdksh+","+zysh_33+","+zgsh_35+","+jlsh_37+","+zjsh_39+","
                +nstr+","+jgzjl_42+","+trshyj_43+","+trzg_44+","+trjl_45+","
                +zjfp+","+qrsqdz_48+","+zjfp_49+","+cz_50+","+sslr_51+","+cwqrdz_52+","
                +yhdksq+","+jgjscl_57+","+jtsjqr_58+","+yhsjqr_59+","+yhspjg_60+","+yhfkjg_61+","+skqr_62+","+bcclqr_63+","+bccl_64+","
                +gsgd+","+jtzzgd_67+","+zzgd_68+","+shybcl_69+","+xzrk_70+","
                +dygd+","+gzjl_73+","+dycljsjg_74+","+jgsjqr_75+","+dyqkjl_76+","+dycljh_77+","+shsjqr_78+","+dyclzyh_79+","+yhsjqr_80+","+lryhcyqk_81+","
                +ywxxxg+","+ywglb_84+","+xtyw_85+","+ywxxxgsq_96+","
                +tdtf+","+shytdsh_88+","+tdsjxz_89+","+shjltdsh_90+","+jghkjf_91+","+gsqrdz_92+","+cljh_93+","+jgsjqr_94+","
                +khgl+","+zdrxx+","+ghrxx+","+qtlxr+","+srxx+","+jtxx+","+fcxx+","
                +dkgl+","
                +clxx+","
                +zzsc+","+sfrz+","+sjhm+","+mzmd+","+grfxxx+","+bjgcxxx+","+fqzbg+","+zxbg+","
                +yycl+","+yycl11+","+yycl2+","+yycl3+","+yycl4+","+yycl5+","+yycl6+","+yycl7+","+yycl8+","+yycl9+","+yycl10+","
                +sfmx+","
                +clhsqk+","
                +rwcl+","
                +financing+","+financing_101+","+financing_102+","+financing_103+","
                ;
		return gpurview_map.replace("null,","");
	}

	public void setGpurview_map(String gpurview_map) {
		this.gpurview_map = gpurview_map;
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

	public String getCn() {
		return cn;
	}

	public void setCn(String cn) {
		this.cn = cn;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGlzx() {
		return glzx;
	}

	public void setGlzx(String glzx) {
		this.glzx = glzx;
	}

	public String getGzrw() {
		return gzrw;
	}

	public void setGzrw(String gzrw) {
		this.gzrw = gzrw;
	}

	public String getWdrw() {
		return wdrw;
	}

	public void setWdrw(String wdrw) {
		this.wdrw = wdrw;
	}

	public String getWdcy() {
		return wdcy;
	}

	public void setWdcy(String wdcy) {
		this.wdcy = wdcy;
	}

	public String getWdqd() {
		return wdqd;
	}

	public void setWdqd(String wdqd) {
		this.wdqd = wdqd;
	}

	public String getZhgl() {
		return zhgl;
	}

	public void setZhgl(String zhgl) {
		this.zhgl = zhgl;
	}

	public String getGsgl() {
		return gsgl;
	}

	public void setGsgl(String gsgl) {
		this.gsgl = gsgl;
	}

	public String getRygl() {
		return rygl;
	}

	public void setRygl(String rygl) {
		this.rygl = rygl;
	}

	public String getZhqx() {
		return zhqx;
	}

	public void setZhqx(String zhqx) {
		this.zhqx = zhqx;
	}

	public String getWlghd() {
		return wlghd;
	}

	public void setWlghd(String wlghd) {
		this.wlghd = wlghd;
	}

	public String getZx() {
		return zx;
	}

	public void setZx(String zx) {
		this.zx = zx;
	}

	public String getQcpg() {
		return qcpg;
	}

	public void setQcpg(String qcpg) {
		this.qcpg = qcpg;
	}

	public String getKk() {
		return kk;
	}

	public void setKk(String kk) {
		this.kk = kk;
	}

	public String getSsmq() {
		return ssmq;
	}

	public void setSsmq(String ssmq) {
		this.ssmq = ssmq;
	}

	public String getQcdk() {
		return qcdk;
	}

	public void setQcdk(String qcdk) {
		this.qcdk = qcdk;
	}

	public String getDhgl() {
		return dhgl;
	}

	public void setDhgl(String dhgl) {
		this.dhgl = dhgl;
	}

	public String getYhhkxq() {
		return yhhkxq;
	}

	public void setYhhkxq(String yhhkxq) {
		this.yhhkxq = yhhkxq;
	}

	public String getYhhklr() {
		return yhhklr;
	}

	public void setYhhklr(String yhhklr) {
		this.yhhklr = yhhklr;
	}

	public String getCwgl() {
		return cwgl;
	}

	public void setCwgl(String cwgl) {
		this.cwgl = cwgl;
	}

	public String getKhdkmx() {
		return khdkmx;
	}

	public void setKhdkmx(String khdkmx) {
		this.khdkmx = khdkmx;
	}

	public String get() {
		return zxsp;
	}

	public void setZxsp(String zxsp) {
		this.zxsp = zxsp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClgc() {
		return clgc;
	}

	public void setClgc(String clgc) {
		this.clgc = clgc;
	}

	public String getZxcx() {
		return zxcx;
	}

	public void setZxcx(String zxcx) {
		this.zxcx = zxcx;
	}

	public String getCxjg_3() {
		return cxjg_3;
	}

	public void setCxjg_3(String cxjg_3) {
		this.cxjg_3 = cxjg_3;
	}

	public String getZxtr() {
		return zxtr;
	}

	public void setZxtr(String zxtr) {
		this.zxtr = zxtr;
	}

	public String getZxyhyj_6() {
		return zxyhyj_6;
	}

	public void setZxyhyj_6(String zxyhyj_6) {
		this.zxyhyj_6 = zxyhyj_6;
	}

	public String getTrsh_7() {
		return trsh_7;
	}

	public void setTrsh_7(String trsh_7) {
		this.trsh_7 = trsh_7;
	}

	public String getClpg() {
		return clpg;
	}

	public void setClpg(String clpg) {
		this.clpg = clpg;
	}

	public String getPgjsh_11() {
		return pgjsh_11;
	}

	public void setPgjsh_11(String pgjsh_11) {
		this.pgjsh_11 = pgjsh_11;
	}

	public String getYhds() {
		return yhds;
	}

	public void setYhds(String yhds) {
		this.yhds = yhds;
	}

	public String getDsjg_15() {
		return dsjg_15;
	}

	public void setDsjg_15(String dsjg_15) {
		this.dsjg_15 = dsjg_15;
	}

	public String getKksq() {
		return kksq;
	}

	public void setKksq(String kksq) {
		this.kksq = kksq;
	}

	public String getSfhcjg_19() {
		return sfhcjg_19;
	}

	public void setSfhcjg_19(String sfhcjg_19) {
		this.sfhcjg_19 = sfhcjg_19;
	}

	public String getFkkkjg_20() {
		return fkkkjg_20;
	}

	public void setFkkkjg_20(String fkkkjg_20) {
		this.fkkkjg_20 = fkkkjg_20;
	}

	public String getSpmq() {
		return spmq;
	}

	public void setSpmq(String spmq) {
		this.spmq = spmq;
	}

	public String getJgfk_24() {
		return jgfk_24;
	}

	public void setJgfk_24(String jgfk_24) {
		this.jgfk_24 = jgfk_24;
	}

	public String getKqyywsp() {
		return kqyywsp;
	}

	public void setKqyywsp(String kqyywsp) {
		this.kqyywsp = kqyywsp;
	}

	public String getZgsh_27() {
		return zgsh_27;
	}

	public void setZgsh_27(String zgsh_27) {
		this.zgsh_27 = zgsh_27;
	}

	public String getZjlsh_29() {
		return zjlsh_29;
	}

	public void setZjlsh_29(String zjlsh_29) {
		this.zjlsh_29 = zjlsh_29;
	}

	public String getQcdksh() {
		return qcdksh;
	}

	public void setQcdksh(String qcdksh) {
		this.qcdksh = qcdksh;
	}

	public String getZysh_33() {
		return zysh_33;
	}

	public void setZysh_33(String zysh_33) {
		this.zysh_33 = zysh_33;
	}

	public String getZgsh_35() {
		return zgsh_35;
	}

	public void setZgsh_35(String zgsh_35) {
		this.zgsh_35 = zgsh_35;
	}

	public String getJlsh_37() {
		return jlsh_37;
	}

	public void setJlsh_37(String jlsh_37) {
		this.jlsh_37 = jlsh_37;
	}

	public String getZjsh_39() {
		return zjsh_39;
	}

	public void setZjsh_39(String zjsh_39) {
		this.zjsh_39 = zjsh_39;
	}

	public String getNstr() {
		return nstr;
	}

	public void setNstr(String nstr) {
		this.nstr = nstr;
	}

	public String getJgzjl_42() {
		return jgzjl_42;
	}

	public void setJgzjl_42(String jgzjl_42) {
		this.jgzjl_42 = jgzjl_42;
	}

	public String getTrshyj_43() {
		return trshyj_43;
	}

	public void setTrshyj_43(String trshyj_43) {
		this.trshyj_43 = trshyj_43;
	}

	public String getTrzg_44() {
		return trzg_44;
	}

	public void setTrzg_44(String trzg_44) {
		this.trzg_44 = trzg_44;
	}

	public String getTrjl_45() {
		return trjl_45;
	}

	public void setTrjl_45(String trjl_45) {
		this.trjl_45 = trjl_45;
	}

	public String getZjfp() {
		return zjfp;
	}

	public void setZjfp(String zjfp) {
		this.zjfp = zjfp;
	}

	public String getQrsqdz_48() {
		return qrsqdz_48;
	}

	public void setQrsqdz_48(String qrsqdz_48) {
		this.qrsqdz_48 = qrsqdz_48;
	}

	public String getZjfp_49() {
		return zjfp_49;
	}

	public void setZjfp_49(String zjfp_49) {
		this.zjfp_49 = zjfp_49;
	}

	public String getCz_50() {
		return cz_50;
	}

	public void setCz_50(String cz_50) {
		this.cz_50 = cz_50;
	}

	public String getSslr_51() {
		return sslr_51;
	}

	public void setSslr_51(String sslr_51) {
		this.sslr_51 = sslr_51;
	}

	public String getCwqrdz_52() {
		return cwqrdz_52;
	}

	public void setCwqrdz_52(String cwqrdz_52) {
		this.cwqrdz_52 = cwqrdz_52;
	}

	public String getYhdksq() {
		return yhdksq;
	}

	public void setYhdksq(String yhdksq) {
		this.yhdksq = yhdksq;
	}

	public String getJgjscl_57() {
		return jgjscl_57;
	}

	public void setJgjscl_57(String jgjscl_57) {
		this.jgjscl_57 = jgjscl_57;
	}

	public String getJtsjqr_58() {
		return jtsjqr_58;
	}

	public void setJtsjqr_58(String jtsjqr_58) {
		this.jtsjqr_58 = jtsjqr_58;
	}

	public String getYhsjqr_59() {
		return yhsjqr_59;
	}

	public void setYhsjqr_59(String yhsjqr_59) {
		this.yhsjqr_59 = yhsjqr_59;
	}

	public String getYhspjg_60() {
		return yhspjg_60;
	}

	public void setYhspjg_60(String yhspjg_60) {
		this.yhspjg_60 = yhspjg_60;
	}

	public String getYhfkjg_61() {
		return yhfkjg_61;
	}

	public void setYhfkjg_61(String yhfkjg_61) {
		this.yhfkjg_61 = yhfkjg_61;
	}

	public String getSkqr_62() {
		return skqr_62;
	}

	public void setSkqr_62(String skqr_62) {
		this.skqr_62 = skqr_62;
	}

	public String getBcclqr_63() {
		return bcclqr_63;
	}

	public void setBcclqr_63(String bcclqr_63) {
		this.bcclqr_63 = bcclqr_63;
	}

	public String getBccl_64() {
		return bccl_64;
	}

	public void setBccl_64(String bccl_64) {
		this.bccl_64 = bccl_64;
	}

	public String getGsgd() {
		return gsgd;
	}

	public void setGsgd(String gsgd) {
		this.gsgd = gsgd;
	}

	public String getJtzzgd_67() {
		return jtzzgd_67;
	}

	public void setJtzzgd_67(String jtzzgd_67) {
		this.jtzzgd_67 = jtzzgd_67;
	}

	public String getZzgd_68() {
		return zzgd_68;
	}

	public void setZzgd_68(String zzgd_68) {
		this.zzgd_68 = zzgd_68;
	}

	public String getShybcl_69() {
		return shybcl_69;
	}

	public void setShybcl_69(String shybcl_69) {
		this.shybcl_69 = shybcl_69;
	}

	public String getXzrk_70() {
		return xzrk_70;
	}

	public void setXzrk_70(String xzrk_70) {
		this.xzrk_70 = xzrk_70;
	}

	public String getDygd() {
		return dygd;
	}

	public void setDygd(String dygd) {
		this.dygd = dygd;
	}

	public String getGzjl_73() {
		return gzjl_73;
	}

	public void setGzjl_73(String gzjl_73) {
		this.gzjl_73 = gzjl_73;
	}

	public String getDycljsjg_74() {
		return dycljsjg_74;
	}

	public void setDycljsjg_74(String dycljsjg_74) {
		this.dycljsjg_74 = dycljsjg_74;
	}

	public String getJgsjqr_75() {
		return jgsjqr_75;
	}

	public void setJgsjqr_75(String jgsjqr_75) {
		this.jgsjqr_75 = jgsjqr_75;
	}

	public String getDyqkjl_76() {
		return dyqkjl_76;
	}

	public void setDyqkjl_76(String dyqkjl_76) {
		this.dyqkjl_76 = dyqkjl_76;
	}

	public String getDycljh_77() {
		return dycljh_77;
	}

	public void setDycljh_77(String dycljh_77) {
		this.dycljh_77 = dycljh_77;
	}

	public String getShsjqr_78() {
		return shsjqr_78;
	}

	public void setShsjqr_78(String shsjqr_78) {
		this.shsjqr_78 = shsjqr_78;
	}

	public String getDyclzyh_79() {
		return dyclzyh_79;
	}

	public void setDyclzyh_79(String dyclzyh_79) {
		this.dyclzyh_79 = dyclzyh_79;
	}

	public String getYhsjqr_80() {
		return yhsjqr_80;
	}

	public void setYhsjqr_80(String yhsjqr_80) {
		this.yhsjqr_80 = yhsjqr_80;
	}

	public String getLryhcyqk_81() {
		return lryhcyqk_81;
	}

	public void setLryhcyqk_81(String lryhcyqk_81) {
		this.lryhcyqk_81 = lryhcyqk_81;
	}

	public String getYwxxxg() {
		return ywxxxg;
	}

	public void setYwxxxg(String ywxxxg) {
		this.ywxxxg = ywxxxg;
	}

	public String getYwglb_84() {
		return ywglb_84;
	}

	public void setYwglb_84(String ywglb_84) {
		this.ywglb_84 = ywglb_84;
	}

	public String getXtyw_85() {
		return xtyw_85;
	}

	public void setXtyw_85(String xtyw_85) {
		this.xtyw_85 = xtyw_85;
	}

	public String getYwxxxgsq_96() {
		return ywxxxgsq_96;
	}

	public void setYwxxxgsq_96(String ywxxxgsq_96) {
		this.ywxxxgsq_96 = ywxxxgsq_96;
	}

	public String getTdtf() {
		return tdtf;
	}

	public void setTdtf(String tdtf) {
		this.tdtf = tdtf;
	}

	public String getShytdsh_88() {
		return shytdsh_88;
	}

	public void setShytdsh_88(String shytdsh_88) {
		this.shytdsh_88 = shytdsh_88;
	}

	public String getTdsjxz_89() {
		return tdsjxz_89;
	}

	public void setTdsjxz_89(String tdsjxz_89) {
		this.tdsjxz_89 = tdsjxz_89;
	}

	public String getShjltdsh_90() {
		return shjltdsh_90;
	}

	public void setShjltdsh_90(String shjltdsh_90) {
		this.shjltdsh_90 = shjltdsh_90;
	}

	public String getJghkjf_91() {
		return jghkjf_91;
	}

	public void setJghkjf_91(String jghkjf_91) {
		this.jghkjf_91 = jghkjf_91;
	}

	public String getGsqrdz_92() {
		return gsqrdz_92;
	}

	public void setGsqrdz_92(String gsqrdz_92) {
		this.gsqrdz_92 = gsqrdz_92;
	}

	public String getCljh_93() {
		return cljh_93;
	}

	public void setCljh_93(String cljh_93) {
		this.cljh_93 = cljh_93;
	}

	public String getJgsjqr_94() {
		return jgsjqr_94;
	}

	public void setJgsjqr_94(String jgsjqr_94) {
		this.jgsjqr_94 = jgsjqr_94;
	}

	public String getKhgl() {
		return khgl;
	}

	public void setKhgl(String khgl) {
		this.khgl = khgl;
	}

	public String getZdrxx() {
		return zdrxx;
	}

	public void setZdrxx(String zdrxx) {
		this.zdrxx = zdrxx;
	}

	public String getGhrxx() {
		return ghrxx;
	}

	public void setGhrxx(String ghrxx) {
		this.ghrxx = ghrxx;
	}

	public String getQtlxr() {
		return qtlxr;
	}

	public void setQtlxr(String qtlxr) {
		this.qtlxr = qtlxr;
	}

	public String getSrxx() {
		return srxx;
	}

	public void setSrxx(String srxx) {
		this.srxx = srxx;
	}

	public String getJtxx() {
		return jtxx;
	}

	public void setJtxx(String jtxx) {
		this.jtxx = jtxx;
	}

	public String getFcxx() {
		return fcxx;
	}

	public void setFcxx(String fcxx) {
		this.fcxx = fcxx;
	}

	public String getDkgl() {
		return dkgl;
	}

	public void setDkgl(String dkgl) {
		this.dkgl = dkgl;
	}

	public String getClxx() {
		return clxx;
	}

	public void setClxx(String clxx) {
		this.clxx = clxx;
	}

	public String getZzsc() {
		return zzsc;
	}

	public void setZzsc(String zzsc) {
		this.zzsc = zzsc;
	}

	public String getSfrz() {
		return sfrz;
	}

	public void setSfrz(String sfrz) {
		this.sfrz = sfrz;
	}

	public String getSjhm() {
		return sjhm;
	}

	public void setSjhm(String sjhm) {
		this.sjhm = sjhm;
	}

	public String getMzmd() {
		return mzmd;
	}

	public void setMzmd(String mzmd) {
		this.mzmd = mzmd;
	}

	public String getGrfxxx() {
		return grfxxx;
	}

	public void setGrfxxx(String grfxxx) {
		this.grfxxx = grfxxx;
	}

	public String getBjgcxxx() {
		return bjgcxxx;
	}

	public void setBjgcxxx(String bjgcxxx) {
		this.bjgcxxx = bjgcxxx;
	}

	public String getFqzbg() {
		return fqzbg;
	}

	public void setFqzbg(String fqzbg) {
		this.fqzbg = fqzbg;
	}

	public String getZxbg() {
		return zxbg;
	}

	public void setZxbg(String zxbg) {
		this.zxbg = zxbg;
	}

	public String getYycl() {
		return yycl;
	}

	public void setYycl(String yycl) {
		this.yycl = yycl;
	}

	public String getSfmx() {
		return sfmx;
	}

	public void setSfmx(String sfmx) {
		this.sfmx = sfmx;
	}

	public String getZxsp() {
		return zxsp;
	}

	public String getClhsqk() {
		return clhsqk;
	}

	public void setClhsqk(String clhsqk) {
		this.clhsqk = clhsqk;
	}

	public String getScmb() {
		return scmb;
	}

	public void setScmb(String scmb) {
		this.scmb = scmb;
	}

	public String getRwcl() {
		return rwcl;
	}

	public void setRwcl(String rwcl) {
		this.rwcl = rwcl;
	}

	public String getFinancing() {
		return financing;
	}

	public void setFinancing(String financing) {
		this.financing = financing;
	}

	public String getFinancing_101() {
		return financing_101;
	}

	public void setFinancing_101(String financing_101) {
		this.financing_101 = financing_101;
	}

	public String getFinancing_102() {
		return financing_102;
	}

	public void setFinancing_102(String financing_102) {
		this.financing_102 = financing_102;
	}

	public String getFinancing_103() {
		return financing_103;
	}

	public void setFinancing_103(String financing_103) {
		this.financing_103 = financing_103;
	}

	public String getQbrw() {
		return qbrw;
	}

	public void setQbrw(String qbrw) {
		this.qbrw = qbrw;
	}

	public String getYycl11() {
		return yycl11;
	}

	public void setYycl11(String yycl11) {
		this.yycl11 = yycl11;
	}

	public String getYycl2() {
		return yycl2;
	}

	public void setYycl2(String yycl2) {
		this.yycl2 = yycl2;
	}

	public String getYycl3() {
		return yycl3;
	}

	public void setYycl3(String yycl3) {
		this.yycl3 = yycl3;
	}

	public String getYycl4() {
		return yycl4;
	}

	public void setYycl4(String yycl4) {
		this.yycl4 = yycl4;
	}

	public String getYycl5() {
		return yycl5;
	}

	public void setYycl5(String yycl5) {
		this.yycl5 = yycl5;
	}

	public String getYycl6() {
		return yycl6;
	}

	public void setYycl6(String yycl6) {
		this.yycl6 = yycl6;
	}

	public String getYycl7() {
		return yycl7;
	}

	public void setYycl7(String yycl7) {
		this.yycl7 = yycl7;
	}

	public String getYycl8() {
		return yycl8;
	}

	public void setYycl8(String yycl8) {
		this.yycl8 = yycl8;
	}

	public String getYycl9() {
		return yycl9;
	}

	public void setYycl9(String yycl9) {
		this.yycl9 = yycl9;
	}

	public String getYycl10() {
		return yycl10;
	}

	public void setYycl10(String yycl10) {
		this.yycl10 = yycl10;
	}

	public Integer getModal_tag() {
		return modal_tag;
	}

	public void setModal_tag(Integer modal_tag) {
		this.modal_tag = modal_tag;
	}

	public Integer getQx_type() {
		return qx_type;
	}

	public void setQx_type(Integer qx_type) {
		this.qx_type = qx_type;
	}

	public String getGsgladd() {
		return gsgladd;
	}

	public void setGsgladd(String gsgladd) {
		this.gsgladd = gsgladd;
	}

	public String getGsgldelete() {
		return gsgldelete;
	}

	public void setGsgldelete(String gsgldelete) {
		this.gsgldelete = gsgldelete;
	}

	public String getGsglupdate() {
		return gsglupdate;
	}

	public void setGsglupdate(String gsglupdate) {
		this.gsglupdate = gsglupdate;
	}

	public String getZhqxadd() {
		return zhqxadd;
	}

	public void setZhqxadd(String zhqxadd) {
		this.zhqxadd = zhqxadd;
	}

	public String getZhqxdelete() {
		return zhqxdelete;
	}

	public void setZhqxdelete(String zhqxdelete) {
		this.zhqxdelete = zhqxdelete;
	}

	public String getZhqxupdate() {
		return zhqxupdate;
	}

	public void setZhqxupdate(String zhqxupdate) {
		this.zhqxupdate = zhqxupdate;
	}

	public String getRygladd() {
		return rygladd;
	}

	public void setRygladd(String rygladd) {
		this.rygladd = rygladd;
	}

	public String getRygldelete() {
		return rygldelete;
	}

	public void setRygldelete(String rygldelete) {
		this.rygldelete = rygldelete;
	}

	public String getRyglupdate() {
		return ryglupdate;
	}

	public void setRyglupdate(String ryglupdate) {
		this.ryglupdate = ryglupdate;
	}

	public String getDclcjyq() {
		return dclcjyq;
	}

	public void setDclcjyq(String dclcjyq) {
		this.dclcjyq = dclcjyq;
	}

	public String getDclzjyq() {
		return dclzjyq;
	}

	public void setDclzjyq(String dclzjyq) {
		this.dclzjyq = dclzjyq;
	}

	public String getDclgjyq() {
		return dclgjyq;
	}

	public void setDclgjyq(String dclgjyq) {
		this.dclgjyq = dclgjyq;
	}

	public String getDcltc() {
		return dcltc;
	}

	public void setDcltc(String dcltc) {
		this.dcltc = dcltc;
	}

	public String getDclgs() {
		return dclgs;
	}

	public void setDclgs(String dclgs) {
		this.dclgs = dclgs;
	}

	public String getDhx() {
		return dhx;
	}

	public void setDhx(String dhx) {
		this.dhx = dhx;
	}

	public String getYhx() {
		return yhx;
	}

	public void setYhx(String yhx) {
		this.yhx = yhx;
	}

	public String getClhs() {
		return clhs;
	}

	public void setClhs(String clhs) {
		this.clhs = clhs;
	}

	public String getHzczzh() {
		return hzczzh;
	}

	public void setHzczzh(String hzczzh) {
		this.hzczzh = hzczzh;
	}

	public String getZx1() {
		return zx1;
	}

	public void setZx1(String zx1) {
		this.zx1 = zx1;
	}

	public String getQcpg1() {
		return qcpg1;
	}

	public void setQcpg1(String qcpg1) {
		this.qcpg1 = qcpg1;
	}

	public String getSsmq1() {
		return ssmq1;
	}

	public void setSsmq1(String ssmq1) {
		this.ssmq1 = ssmq1;
	}

	public String getQcdk1() {
		return qcdk1;
	}

	public void setQcdk1(String qcdk1) {
		this.qcdk1 = qcdk1;
	}

	public String getClhs1() {
		return clhs1;
	}

	public void setClhs1(String clhs1) {
		this.clhs1 = clhs1;
	}

	public String getHebgxzh() {
		return hebgxzh;
	}

	public void setHebgxzh(String hebgxzh) {
		this.hebgxzh = hebgxzh;
	}

	public String getZx2() {
		return zx2;
	}

	public void setZx2(String zx2) {
		this.zx2 = zx2;
	}

	public String getQcpg2() {
		return qcpg2;
	}

	public void setQcpg2(String qcpg2) {
		this.qcpg2 = qcpg2;
	}

	public String getSsmq2() {
		return ssmq2;
	}

	public void setSsmq2(String ssmq2) {
		this.ssmq2 = ssmq2;
	}

	public String getQcdk2() {
		return qcdk2;
	}

	public void setQcdk2(String qcdk2) {
		this.qcdk2 = qcdk2;
	}

	public String getClhs2() {
		return clhs2;
	}

	public void setClhs2(String clhs2) {
		this.clhs2 = clhs2;
	}

	public String getTzlqzh() {
		return tzlqzh;
	}

	public void setTzlqzh(String tzlqzh) {
		this.tzlqzh = tzlqzh;
	}

	public String getZx3() {
		return zx3;
	}

	public void setZx3(String zx3) {
		this.zx3 = zx3;
	}

	public String getQcpg3() {
		return qcpg3;
	}

	public void setQcpg3(String qcpg3) {
		this.qcpg3 = qcpg3;
	}

	public String getSsmq3() {
		return ssmq3;
	}

	public void setSsmq3(String ssmq3) {
		this.ssmq3 = ssmq3;
	}

	public String getQcdk3() {
		return qcdk3;
	}

	public void setQcdk3(String qcdk3) {
		this.qcdk3 = qcdk3;
	}

	public String getClhs3() {
		return clhs3;
	}

	public void setClhs3(String clhs3) {
		this.clhs3 = clhs3;
	}

	public String getNjjnzh() {
		return njjnzh;
	}

	public void setNjjnzh(String njjnzh) {
		this.njjnzh = njjnzh;
	}

	public String getZx4() {
		return zx4;
	}

	public void setZx4(String zx4) {
		this.zx4 = zx4;
	}

	public String getQcpg4() {
		return qcpg4;
	}

	public void setQcpg4(String qcpg4) {
		this.qcpg4 = qcpg4;
	}

	public String getSsmq4() {
		return ssmq4;
	}

	public void setSsmq4(String ssmq4) {
		this.ssmq4 = ssmq4;
	}

	public String getQcdk4() {
		return qcdk4;
	}

	public void setQcdk4(String qcdk4) {
		this.qcdk4 = qcdk4;
	}

	public String getClhs4() {
		return clhs4;
	}

	public void setClhs4(String clhs4) {
		this.clhs4 = clhs4;
	}

	public String getDqywgl() {
		return dqywgl;
	}

	public void setDqywgl(String dqywgl) {
		this.dqywgl = dqywgl;
	}

	public String getYwfksq() {
		return ywfksq;
	}

	public void setYwfksq(String ywfksq) {
		this.ywfksq = ywfksq;
	}

	public String getDzjl() {
		return dzjl;
	}

	public void setDzjl(String dzjl) {
		this.dzjl = dzjl;
	}

	public String getFkjl() {
		return fkjl;
	}

	public void setFkjl(String fkjl) {
		this.fkjl = fkjl;
	}

	public String getDhywgl() {
		return dhywgl;
	}

	public void setDhywgl(String dhywgl) {
		this.dhywgl = dhywgl;
	}

	public String getSqdc() {
		return sqdc;
	}

	public void setSqdc(String sqdc) {
		this.sqdc = sqdc;
	}

	public String getDcqr() {
		return dcqr;
	}

	public void setDcqr(String dcqr) {
		this.dcqr = dcqr;
	}

	public String getHzsdc() {
		return hzsdc;
	}

	public void setHzsdc(String hzsdc) {
		this.hzsdc = hzsdc;
	}

	public String getHzsdcqr() {
		return hzsdcqr;
	}

	public void setHzsdcqr(String hzsdcqr) {
		this.hzsdcqr = hzsdcqr;
	}

	public String getGsdz() {
		return gsdz;
	}

	public void setGsdz(String gsdz) {
		this.gsdz = gsdz;
	}
	public String getCwsz() {
		return cwsz;
	}

	public void setCwsz(String cwsz) {
		this.cwsz = cwsz;
	}

	public String getCldy() {
		return cldy;
	}

	public void setCldy(String cldy) {
		this.cldy = cldy;
	}

	public String getGpsaz() {
		return gpsaz;
	}

	public void setGpsaz(String gpsaz) {
		this.gpsaz = gpsaz;
	}

	public String getGpsgl() {
		return gpsgl;
	}

	public void setGpsgl(String gpsgl) {
		this.gpsgl = gpsgl;
	}

	public String getKhhkgl() {
		return khhkgl;
	}

	public void setKhhkgl(String khhkgl) {
		this.khhkgl = khhkgl;
	}

	public String getKhhklr() {
		return khhklr;
	}

	public void setKhhklr(String khhklr) {
		this.khhklr = khhklr;
	}

	public String getKhhkqk() {
		return khhkqk;
	}

	public void setKhhkqk(String khhkqk) {
		this.khhkqk = khhkqk;
	}

	public String getKhyqmd() {
		return khyqmd;
	}

	public void setKhyqmd(String khyqmd) {
		this.khyqmd = khyqmd;
	}

	public String getDczy() {
		return dczy;
	}

	public void setDczy(String dczy) {
		this.dczy = dczy;
	}

	public String getTcgl() {
		return tcgl;
	}

	public void setTcgl(String tcgl) {
		this.tcgl = tcgl;
	}

	public String getTc_ysl() {
		return tc_ysl;
	}

	public void setTc_ysl(String tc_ysl) {
		this.tc_ysl = tc_ysl;
	}

	public String getTc_wsl() {
		return tc_wsl;
	}

	public void setTc_wsl(String tc_wsl) {
		this.tc_wsl = tc_wsl;
	}

	public String getTc_wc() {
		return tc_wc;
	}

	public void setTc_wc(String tc_wc) {
		this.tc_wc = tc_wc;
	}

	public String getSsgl() {
		return ssgl;
	}

	public void setSsgl(String ssgl) {
		this.ssgl = ssgl;
	}

	public String getBxgl() {
		return bxgl;
	}

	public void setBxgl(String bxgl) {
		this.bxgl = bxgl;
	}

	public String getCxlp() {
		return cxlp;
	}

	public void setCxlp(String cxlp) {
		this.cxlp = cxlp;
	}

	public String getCqcl() {
		return cqcl;
	}

	public void setCqcl(String cqcl) {
		this.cqcl = cqcl;
	}

	public String getCqcl_yjq() {
		return cqcl_yjq;
	}

	public void setCqcl_yjq(String cqcl_yjq) {
		this.cqcl_yjq = cqcl_yjq;
	}

	public String getCqcl_wjq() {
		return cqcl_wjq;
	}

	public void setCqcl_wjq(String cqcl_wjq) {
		this.cqcl_wjq = cqcl_wjq;
	}

	public String getCwgl_yhdk() {
		return cwgl_yhdk;
	}

	public void setCwgl_yhdk(String cwgl_yhdk) {
		this.cwgl_yhdk = cwgl_yhdk;
	}


	
	

}
