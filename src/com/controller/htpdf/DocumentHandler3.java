package com.controller.htpdf;
import java.io.File;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
/** 实现类一
 * @author LiWang
 */
public class DocumentHandler3 extends DocumentHandlerParent{
	public DocumentHandler3(String templateDirectory, HttpServletRequest request, Map map) {
		super(templateDirectory, request, map);
		// TODO Auto-generated constructor stub
	}
	private static Logger log = LogManager.getLogger(DocumentHandler3.class.getName());
	@SuppressWarnings("unchecked")
	public String fillTemplate () throws Exception{
		
		String pgj=map.get("pgj").toString();
		map.put("pgj1",pgj);//评估价原值 
		map.put("dpgj",NumberUtil.Test2(Double.parseDouble(pgj)));//评估价 非万元
		String hf=map.get("hf").toString();
		if(hf.equals("0")){//未婚
			map.put("hf1", "true");
		}else if(hf.equals("2")){//离异
			map.put("hf2", "true");
		}else{//丧偶
			map.put("hf3", "true");
		}
		DataConversion.dataDisposeToMap(map);
		
		//剩余金融服务费  金融服务费-贷款总额*0.01 1%
		map.put("sy_servicefee",DataConversionParent.subZeroAndDot(DoubleUtil.sub(map.get("servicefee").toString(),DoubleUtil.mul(map.get("totalamount").toString(),"0.01"))));
		//贷款成数:本息合计/评估价*0.1 10%
		map.put("dkcs",DataConversionParent.subZeroAndDot(DoubleUtil.div(map.get("allReimbursement").toString(),DoubleUtil.mul(pgj, "0.1"),4)));
		map.put("Dpgj",NumberUtil.Test2(Double.parseDouble(map.get("pgj").toString())));//评估价 万元为单位
		
		//数据处理
		map.put("jxs","浙江鑫宝行融资担保有限公司");//经销商
		map.put("jxs1", "浙江鑫宝行融资担保");
		//品牌型号处理
		//债权人
		map.put("zqr","中国工商银行股份有限公司杭州城站支行");
		map.put("zh", "城站");
		map.put("zh1","城站支行");
		map.put("zh2","工行杭州城站支行");
		//债务人
		if(""==map.get("pname") || map.get("pname").toString().equals("null")){
			map.put("zwr",map.get("name").toString());
		}else{//存在配偶的情况
			map.put("zwr",new StringBuilder(map.get("name").toString()).append("          ").append(map.get("pname").toString()));
		}
		//个人年收入 单位万
		map.put("zdrnsr",DataConversionParent.subZeroAndDot(DoubleUtil.div(DoubleUtil.mul(map.get("sr").toString(),"12"),"10000")));
		
		//配偶年收入 单位万
		if(map.get("posr").toString()=="" || map.get("posr").toString().equals("null")){
			map.put("ponsr","0");
		}else{
			map.put("ponsr",DataConversionParent.subZeroAndDot(DoubleUtil.div(DoubleUtil.mul(map.get("posr").toString(),"12"),"10000")));
		}
		//牡丹卡分期付款担保呵护自信问询表 共同还款人简况（配偶 共借人一）
		if(map.get("pIDnumber").toString()!="" && !map.get("pIDnumber").toString().equals("null")){
			map.put("gthkrjk_name", map.get("pname").toString());//为配偶姓名
			map.put("gthkrjk_IDnumber", map.get("pIDnumber").toString());//身份证号
			
			map.put("gthkrjk_gx", "配偶");//关系
			map.put("gthkrjk_dwmc", map.get("pdw").toString());//单位名称
			map.put("gthkrjk_dwdz", map.get("pdwdz").toString());//工作单位
			map.put("gthkrjk_zw", map.get("pzw").toString());//职位
			map.put("gthkrjk_ysr", map.get("posr").toString());//月收入
			map.put("gthkrjk_tel", map.get("pdh").toString());//电话
		}else if(map.get("gid").toString()!="" && !map.get("gid").toString().equals("null")){//共借人一
			map.put("gthkrjk_name", map.get("gthk").toString());//为配偶姓名
			map.put("gthkrjk_IDnumber", map.get("gid").toString());
			
			map.put("gthkrjk_gx", map.get("ggx").toString());
			map.put("gthkrjk_dwmc", map.get("ggzdw").toString());
			map.put("gthkrjk_dwdz", map.get("gdwdz").toString());
		
			map.put("gthkrjk_tel", map.get("gtel").toString());
		}
		//贷款金额大写分解  肆万伍仟陆佰玖拾柒贰角叁分
		NumberUtil.numberSubchinese(map.get("loanamount").toString(),map,"dkje");
		//贷款总额 大写分解
		NumberUtil.numberSubchinese(map.get("totalamount").toString(),map,"dkze");
		//金融服务费 大写分解
		NumberUtil.numberSubchinese(map.get("servicefee").toString(),map,"jrfuf");
		//共借人一学历
		//gjr1xl
		//共借人二学历
		//gjr2xl
		//共借人一收入
		//gjr1sr
		//共借人二收入
		//gjr2sr
		//共借人一职务
		//gjr1zw
		//共借人二职务
		//gjr2zw
		//共借人一年收入 单位万
		//gjr1nsr
		//共借人二年收入 单位万
		//gjr2nsr
		//家庭年收入单位万 （主贷人月收入+配偶月收入）*12
		map.put("jtnsr",DataConversionParent.subZeroAndDot(DoubleUtil.add(map.get("zdrnsr").toString(), map.get("ponsr").toString())));
		//共借人一家庭年收入
//		gjr1jtnsr
		//共借人二家庭年收入
//		gjr2jtnsr
		//https://www.cnblogs.com/yaya-yaya/p/6096539.html
		//isEmpty() 和 isBlank() 对 null 和 空字符串("")的判断相同，唯一区别就是对空白字符（如空格、制表符）的判断。针对空白字符" "，isEmpty()返回false，isBlank()返回true.
		//反担保人
		StringBuilder fdbr=new StringBuilder();
		if(!StringUtils.isBlank(map.get("gthk").toString()) && StringUtils.isBlank(map.get("gthk2").toString())){
			map.put("fdbr", map.get("gthk").toString());
		}else if(StringUtils.isBlank(map.get("gthk").toString()) && !StringUtils.isBlank(map.get("gthk2").toString())){
			map.put("fdbr", map.get("gthk2").toString());
		}else{
			map.put("fdbr",new StringBuilder(map.get("gthk").toString()).append("          ").append(map.get("gthk2").toString()));
		}
		int index=getLetterFirstIndex(map.get("p_x").toString());
		//品牌型号中文部分
		map.put("p_x_1", map.get("p_x").toString().substring(0,index));
		//品牌型号英文部分
		map.put("p_x_2", map.get("p_x").toString().substring(index));
		//按揭期限年
		map.put("date_year",DoubleUtil.div(map.get("date").toString(),"12",0));
	
		log.info("数据集->"+map);
		
		File[] files=new File(pdftemplatepath).listFiles();
		boolean b=map.get("hf").toString().equals("已婚");
		for(File f:files){
			String s=f.getName();
			
			if(		(s.equals("6.婚姻状况申明具结书.pdf") && !b) //只有已婚的情况下生成
					|| (s.equals("7.单身证明（主贷人）.pdf") && b) //如果是已婚则去掉单身声明
					|| (s.equals("8.单身证明（共借人一） .pdf") && ( map.get("gid").equals("") || map.get("ghf").toString().equals("已婚"))) //有共借一，并且是未婚的情况下生成
					//个人收入 个人薪金  共同还款承诺
					|| ((s.indexOf("10.")!=-1 || s.indexOf("14.")!=-1 || s.indexOf("18.")!=-1) && map.get("pIDnumber").equals("")
					|| ((s.indexOf("11.")!=-1 || s.indexOf("15.")!=-1 || s.indexOf("19.")!=-1) && map.get("gid").equals("")) 
					|| ((s.indexOf("12.")!=-1 || s.indexOf("16.")!=-1 || s.indexOf("20.")!=-1) && map.get("gid2").equals(""))
					
					)){
				log.info("除去的合同->"+s);
				continue;
			}
			
			if(s.indexOf("NO")!=-1){
				
				copy(f.getName());
			}else{
				pdf(s);
			}
		}
		return endAssembly();
	}
		
}

