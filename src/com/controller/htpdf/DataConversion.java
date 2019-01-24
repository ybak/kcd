package com.controller.htpdf;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.controller.htpdf.DocumentHandler2.WordDisposition;
/**数据过滤
 * @Description:TODO
 * @author:LiWang
 * @time:2018年6月6日
 */
public class DataConversion{

	public static void dataDisposeToMap(Map data,WordDisposition wd){
			String totalamount="";
			String kpj="";//开票价
			data.put("jigou","快加汽车服务（上海）有限公司");
			data.put("a","安联汽车服务有限");//委托授权书中
			data.put("b", "安联汽车服务有限公司");
			data.put("papers_type","身份证");//证件类型
			data.put("jxs","安联");//经销商
			data.put("zh", "武林");
			data.put("shul","壹台");
			try {
				String s =subZeroAndDot(data.get("f_rate").toString());//银行利率
				data.put("f_rate",s+"%");//银行利率
				totalamount=data.get("totalamount").toString();//贷款总额
				kpj=data.get("kpj").toString();//开票价
				data.put("kpj",subZeroAndDot(kpj));
				data.put("f_service_charge",// 分期手续费金额=分期付款总额*分期手续费费率
						subZeroAndDot(DoubleUtil.ru(DoubleUtil.mul(totalamount, DoubleUtil.div(s, "100", 4).toString()).toString(),"1",2)));
				data.put("m_repayment",// 每期还款额=（分期付款金额+分期手续费）/分期付款期数
						subZeroAndDot(DoubleUtil.ru(DoubleUtil.add(totalamount,data.get("f_service_charge").toString()),data.get("date").toString(),2)));
				data.put("totalamount", subZeroAndDot(totalamount));//贷款总额  处理贷款总额小数点后多余的0
				data.put("loanamount",subZeroAndDot(data.get("loanamount").toString()));
				data.put("first_payment_ratio",subZeroAndDot(data.get("first_payment_ratio").toString()));//首次付款金额
				data.put("dmonty",NumberUtil.Test2(Double.parseDouble(data.get("loanamount").toString())));//贷款金额大写
				//shouyue(data.get("m_repayment").toString(),data.get("date").toString())首次付款金额
				data.put("dsmoney",NumberUtil.Test2(Double.parseDouble(data.get("first_payment_ratio").toString())));//首次付款金额大写
				data.put("dk",NumberUtil.Test2(Double.parseDouble(kpj)));//开票价
				data.put("dt",NumberUtil.Test2(Double.parseDouble(totalamount)));
				String ss=subZeroAndDot(DoubleUtil.mul(DoubleUtil.div(data.get("first_payment_ratio").toString(),data.get("kpj").toString(),4),"100"));
				data.put("down_payment_for",ss+"%");//首付比例
				data.put("dbl",DoubleUtil.sub("100",ss)+"%");
				data.put("servicefee",subZeroAndDot(data.get("servicefee").toString()));//金融服务费处理
				data.put("dserv",NumberUtil.Test2(Double.parseDouble(data.get("servicefee").toString())));//大写金融服务费
			}catch (Exception e) {
				wd.code=0;
	    		wd.message="金额相关数据处理异常!";
	    		return; 
			}
			String IDnumber=null;
			Map map=null;
			try {
				IDnumber=data.get("IDnumber").toString();//身份证号
				data.put("dkyh", "工行武林支行");
				data.put("year",IDnumber.substring(6,10));//年
				data.put("month",IDnumber.substring(10,12));//月
				data.put("day",IDnumber.substring(12,14));//日
				//根据身份证获取主贷人性别年龄信息
				map=getCarInfo(IDnumber);
				data.put("sex",map.get("sex"));
				data.put("age",map.get("age"));
				data.put("cb1","true");
				data.put("cb6","true");
				data.put("pgx","配偶");//配偶关系 配偶
				data.put("zcsrq",map.get("birth"));
				if(data.get("sex").toString().equals("男")){
					data.put("sexn","true");
				}else{
					data.put("sexv","true");
				}
			}catch (Exception e) {
				wd.code=0;
	    		wd.message="本人数据处理(身份证)异常!";
	    		return; 
			}
			try {
				data.put("xl",geteducation(data.get("xl").toString()));//学历
				data.put("sr",subZeroAndDot(data.get("sr").toString()));//收入
				data.put("zw", getduty(data.get("zw").toString()));//职务
				data.put("hf",getmarriage(data.get("hf").toString()));//婚否
				data.put("wsr",DoubleUtil.div2Scale(DoubleUtil.mul(data.get("sr").toString(),"12"),"10000"));//收入 以万为单位
			} catch (Exception e) {
				wd.code=0;
	    		wd.message="本人基本信息处理异常!";
	    		return;
			}
			//车辆类型
			try {
				if(data.get("carstype").toString().equals("1")){//新车
					data.put("x1", "true");
				}else{
					data.put("x2", "true");
				}
				data.put("ys",getcolor(data.get("ys").toString()));//颜色
				data.put("pgj",subZeroAndDot(DoubleUtil.div(data.get("pgj").toString(),"10000",2)));//评估价 万元为单位
				data.put("c",subZeroAndDot(DoubleUtil.mul(DoubleUtil.div2Scale(totalamount,kpj),"100"))+"%");// 分期本金/车辆价格比例
			} catch (Exception e2) {
				wd.code=0;
	    		wd.message="车辆信息异常!";
	    		return; 
			}
			try {
				if(!data.get("gid").toString().equals("")){//共借人存在
					map=getCarInfo(data.get("gid").toString());
					data.put("gsex",map.get("sex"));
					data.put("gage",map.get("age"));
					data.put("ghf",getmarriage(data.get("ghf").toString()));//共借人是否已婚
				}else{
					data.put("ggx", "");
					data.put("ghf", "");
				}
			} catch (Exception e) {
				wd.code=0;
	    		wd.message="共借人一数据处理(身份证)异常!";
	    		return; 
			}
			try {
				if(!data.get("gid2").toString().equals("")){
					map=getCarInfo(data.get("gid2").toString());
					data.put("gsex2",map.get("sex"));
					data.put("gage2",map.get("age"));
				}
			} catch (Exception e) {
				wd.code=0;
	    		wd.message="共借人二数据处理(身份证)异常!";
	    		return; 
			}
			
			try {
				if(!data.get("pIDnumber").toString().equals("")){//配偶存在
					String pIDnumber=data.get("pIDnumber").toString();
					data.put("pyear",pIDnumber.substring(6,10));
					data.put("pmonth",pIDnumber.substring(10,12));
					data.put("pday",pIDnumber.substring(12,14));
					//根据身份证获取配偶性别年龄信息	
					map=getCarInfo(pIDnumber);
					data.put("psex",map.get("sex"));
					data.put("page",map.get("age"));
					data.put("posr",subZeroAndDot(data.get("posr").toString()));//配偶收入
					data.put("pxl",geteducation(data.get("pxl").toString()));//配偶学历
					data.put("pcsrq",map.get("birth"));
					data.put("jtsr",DoubleUtil.div2Scale(DoubleUtil.mul(DoubleUtil.add(data.get("posr").toString(),data.get("sr").toString()),"12"),"10000"));
					data.put("pwsr",DoubleUtil.div2Scale(DoubleUtil.mul(data.get("posr").toString(),"12"),"10000"));
				}else{
					data.put("posr","");
					data.put("pxl", "");
					data.put("jtsr",DoubleUtil.div2Scale(DoubleUtil.mul(data.get("sr").toString(),"12"),"10000"));
				}
			} catch (Exception e) {
				wd.code=0;
	    		wd.message="配偶相关数据处理异常!";
	    		return; 
			}
			try {
				String[] tts =data.get("tt").toString().split("");
				for(int i=0;i<tts.length;i++){
					if(tts[i].length()>0){
						data.put("tt","http://a.kcway.net/assess/"+tts[i]);
						break;
					}
				}
			} catch (Exception e) {
				wd.code=0;
	    		wd.message="身份证正面照片处理异常!";
	    		return; 
			}
			/*System.out.println(JSON.toJSON(data));*/
	}
	public static String getcolor(String c){
		String ss="黑";
		try {
			 switch (Integer.parseInt(c)){
			 	case 1:
					ss="黑";
					break;
				case 2:
					ss="白";
					break;
				case 3:
					 ss="灰";
					 break;
				case 4:
					 ss="红";
					 break;
				case 5:
					ss="银";
					break;
				case 6:
					 ss="蓝";
					 break;
				case 7:
					ss="金";
					break;
				case 8:
					 ss="棕";
					 break;
				case 9:
					 ss="橙";
					 break;
				case 10:
					ss="黄";
					break;
				case 11:
					 ss="紫";
					 break;
				case 12:
					ss="绿";
					break;
				case 13:
					 ss="褐";
					 break;
				case 14:
					 ss="栗";
					 break;
				case 15:
					ss="米";
					break;
				case 16:
					 ss="银灰";
					 break;
				case 17:
					ss="青";
					break;
				case 18:
					 ss="香槟";
					 break;
				case 19:
					 ss="咖啡";
					 break;
				case 20:
					ss="天山";
					break;
				case 0:
			 		ss="其他色";
			 		break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		 return ss;
	}
	
	/*职务
	 * @param s
	 * @return
	 * @Description: TODO
	 * @param name
	 * @return 
	 */
	private static String getduty(String s){
		String ss="职员";
		try {
			 switch (Integer.parseInt(s)){
				case 0:
					 ss="企业负责人";
					 break;
				case 1:
					ss="总经理";
					break;
				case 2:
					 ss="部门经理";
					 break;
				default :
					ss="职员";
					break; 
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		 return ss;
	}
	/**学历情况
	 * @param s
	 * @return
	 * @Description: TODO
	 * @param name
	 * @return 
	 */
	private static String geteducation(String s){
		String ss="初中";
		try {
			 switch (Integer.parseInt(s)){
				case 1:
					 ss="小学";
					 break;
				case 3:
					ss="高中";
					break;
				case 4:
					 ss="大专";
					 break;
				case 5:
					 ss="本科";
					 break;
				case 6:
					ss="硕士";
					break;
				case 7:
					 ss="博士及以上";
					 break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		 return ss;
	}
	 /**婚姻情况
	 * @param s
	 * @return
	 * @Description: TODO
	 * @param name
	 * @return 
	 */
	private static String getmarriage(String s){
		 String ss="未婚";
		 try {
			 switch (Integer.parseInt(s)){
				case 1:
					 ss="已婚";
					 break;
				case 2:
					ss="离异";
					break;
				case 3:
					 ss="丧偶";
					 break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		 return ss;
	 }
	 
	/**与借款人关系
	 * @param s
	 * @return
	 * @Description: TODO
	 * @param name
	 * @return 
	 */
	private static String getMutualborrowingR(String s){
		String ss="朋友";//默认
		try {
			switch (Integer.parseInt(s)){
				case 0:
					 ss="夫妻";
					 break;
				case 1:
					 ss="父子";
					 break;
				case 2:
					ss="母子";
					break;
				case 7:
					 ss="父女";
					 break;
				case 8:
					 ss="母女";
					 break;
				case 3:
					ss="兄弟";
					break;
				case 6:
					 ss="姐妹";
					 break;
				case 9:
					ss="兄妹";
					break;
				case 10:
					ss="姐弟";
					break;
				case 4:
					ss="同事";
					break;
				case 5:
					ss="朋友";
					break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ss;
	}
    /**计算年龄
     */
    private static Map getCarInfo(String CardCode){ 
    	Map<String, Object> map = new HashMap<String, Object>();
   	 	String year="";
   	 	StringBuilder sb=new StringBuilder();
   	 	String sex;
   		year = CardCode.substring(6,10);// 得到年份
   		if (Integer.parseInt(CardCode.substring(16).substring(0, 1)) % 2 == 0) {// 判断性别
            sex = "女";
        } else {
            sex = "男";
        }  	
       Date date = new Date();// 得到当前的系统时间  
       SimpleDateFormat format = new SimpleDateFormat("yyyy"); 
       String fyear = format.format(date);
       int age = 0;  
       age=Integer.parseInt(fyear) - Integer.parseInt(year);
       map.put("sex", sex);
       map.put("age", age);
       map.put("birth", sb.append(year).append("年").append(Integer.parseInt(CardCode.substring(10,12))).append("月").append(Integer.parseInt(CardCode.substring(12,14))).append("日").toString());
       return map;  
   } 
	/**首月付款金额计算
	 * @param s 每月还款
	 * @param s1 期限
	 */
	private static String shouyue(String s,String s1){
		int sum=0;
		String[] ss=s.split("\\.");
		if(s.indexOf(".")!=-1 && Integer.parseInt(ss[1])>0){//存在小数 并且小数部分不为0
			String z=DoubleUtil.mul("0."+ss[1],s1);//小数部分乘以分期期限
			String[] ss1=z.split("\\.");
			if(z.indexOf(".")!=-1){//积 为小数
				if(Integer.parseInt(ss1[1])>0){
					sum=(Integer.parseInt(ss1[0])+Integer.parseInt(ss[0])+Integer.parseInt("1"));
				}else{
					sum=(Integer.parseInt(ss1[0])+Integer.parseInt(ss[0]));
				}
			}else{//积为整数
				sum=(Integer.parseInt(z)+Integer.parseInt(ss[0]));
			}
		}else{//不存在小数 世界返回
			 return s;
		}
		return sum+"";
	}
	/** 
     * 使用java正则表达式去掉多余的.与0 
     * @param s 
     * @return  
     */  
    public static String subZeroAndDot(String s){  
        if(s.indexOf(".") > 0){  
            s = s.replaceAll("0+?$", "").replaceAll("[.]$", "");  
        }  
        return s;  
    }
    /**居住情况
	 * @param s
	 * @return
	 * @Description: TODO
	 * @param name
	 * @return 
	 */
	private static String getreside(String s){
		String ss="自有住房";
		try {
			 switch (Integer.parseInt(s)){
				case 1:
					 ss="租房";
					 break;
				case 2:
					ss="分期付款购房";
					break;
				case 3:
					 ss="集体宿舍";
					 break;
				case 4:
					 ss="单位分配";
					 break;
				case 5:
					ss="其他";
					break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		 return ss;
	}
	
	/**单位性质
	 * @return
	 * @Description: TODO
	 * @param name
	 * @return 
	 */
	private static String getworkunit(String s){
		String ss="其他";
		try {
			 switch (Integer.parseInt(s)){
				case 0:
					 ss="国有";
					 break;
				case 1:
					ss="集体经济";
					break;
				case 2:
					 ss="私营";
					 break;
				case 3:
					 ss="民营";
					 break;
				case 4:
					ss="股份合作";
					break;
				case 5:
					 ss="其他股份制";
					 break;
				case 6:
					 ss="个体";
					 break;
				case 7:
					 ss="三资";
					 break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		 return ss;
	}
	
	/**所属行业
	 * @return
	 * @Description: TODO
	 * @param name
	 * @return 
	 */
	private static String getindustry(String s){
		String ss="其他";
		try {
			 switch (Integer.parseInt(s)){
				case 0:
					 ss="农林牧渔";
					 break;
				case 1:
					ss="邮电通讯";
					break;
				case 2:
					 ss="房地产";
					 break;
				case 3:
					 ss="科教文卫";
					 break;
				case 4:
					ss="工业";
					break;
				case 5:
					 ss="银行";
					 break;
				case 6:
					ss="证券";
					break;
				case 7:
					 ss="保险";
					 break;
				case 8:
					 ss="商业";
					 break;
				case 9:
					ss="机关团体";
					break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		 return ss;
	}
	/**职业
	 * @param s
	 * @return
	 * @Description: TODO
	 * @param name
	 * @return 
	 */
	private static String getProfessional(String s){
		String ss="其他";
		try {
			 switch (Integer.parseInt(s)){
				case 0:
					 ss="公务员";
					 break;
				case 1:
					ss="事业单位员工";
					break;
				case 2:
					 ss="工人";
					 break;
				case 3:
					 ss="农民";
					 break;
				case 4:
					ss="军人";
					break;
				case 5:
					 ss="职员";
					 break;
				case 6:
					ss="私人业主";
					break;
				case 7:
					ss="学生";
					break;
				case 8:
					 ss="自由职业";
					 break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		 return ss;
	}
}
