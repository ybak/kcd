package com.controller.htpdf;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
/**数据过滤
 * @Description:TODO
 * @author:LiWang
 * @time:2018年6月6日
 */
public class DataConversion extends DataConversionParent{
	private static Logger log = LogManager.getLogger(DataConversion.class.getName());
	public static void dataDisposeToMap(Map data){
			data.put("jigou","快加汽车服务（上海）有限公司");
			data.put("papers_type","身份证");//证件类型
			data.put("shul","壹台");
			String totalamount="";
			String kpj="";//开票价
			try {
				String s =subZeroAndDot(data.get("f_rate").toString());//银行利率
				data.put("f_rate",s+"%");//银行利率
				totalamount=data.get("totalamount").toString();//贷款总额
				kpj=data.get("kpj").toString();//开票价
				data.put("kpj",subZeroAndDot(kpj));
				data.put("f_service_charge",// 分期手续费金额=分期付款总额*分期手续费费率
						subZeroAndDot(DoubleUtil.ru(DoubleUtil.mul(totalamount, DoubleUtil.div(s, "100", 4).toString()).toString(),"1",2)));
				String allReimbursement=DoubleUtil.add(totalamount,data.get("f_service_charge").toString());//本息合计=贷款总额+分期手续费金额
				data.put("allReimbursement",allReimbursement);
				data.put("m_repayment",// 每期还款额=（分期付款金额+分期手续费）/分期付款期数
						subZeroAndDot(DoubleUtil.ru(allReimbursement,data.get("date").toString(),2)));
				data.put("totalamount", subZeroAndDot(totalamount));//贷款总额  处理贷款总额小数点后多余的0
				
				data.put("loanamount",subZeroAndDot(data.get("loanamount").toString()));//贷款金额
				data.put("first_payment_ratio",subZeroAndDot(data.get("first_payment_ratio").toString()));//首次付款金额
				data.put("dmonty",NumberUtil.Test2(Double.parseDouble(data.get("loanamount").toString())));//贷款金额大写
				data.put("dsmoney",NumberUtil.Test2(Double.parseDouble(data.get("first_payment_ratio").toString())));//首次付款金额大写
				data.put("dk",NumberUtil.Test2(Double.parseDouble(kpj)));//开票价
				data.put("dt",NumberUtil.Test2(Double.parseDouble(totalamount)));
				String ss=subZeroAndDot(DoubleUtil.mul(DoubleUtil.div(data.get("first_payment_ratio").toString(),data.get("kpj").toString(),4),"100"));
				data.put("down_payment_for",ss+"%");//首付比例
				data.put("down_payment_for1",ss);//首付比例 不带百分号
				data.put("dbl",DoubleUtil.sub("100",ss)+"%");
				data.put("servicefee",subZeroAndDot(data.get("servicefee").toString()));//金融服务费处理
				data.put("dserv",NumberUtil.Test2(Double.parseDouble(data.get("servicefee").toString())));//大写金融服务费
			}catch (Exception e) {
	    		throw new RuntimeException("金额相关数据处理异常!");
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
	    		throw new RuntimeException("本人数据处理(身份证)异常!");
			}
			try {
				data.put("xl",geteducation(data.get("xl").toString()));//学历
				data.put("sr",subZeroAndDot(data.get("sr").toString()));//收入
				data.put("zw", getduty(data.get("zw").toString()));//职务
				data.put("hf",getmarriage(data.get("hf").toString()));//婚否
				data.put("wsr",DoubleUtil.div2Scale(DoubleUtil.mul(data.get("sr").toString(),"12"),"10000"));//收入 以万为单位
			} catch (Exception e) {
	    		throw new RuntimeException("本人基本信息处理异常!");
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
				throw new RuntimeException("车辆信息异常!");
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
	    		throw new RuntimeException("共借人一数据处理(身份证)异常!");
			}
			try {
				if(!data.get("gid2").toString().equals("")){
					map=getCarInfo(data.get("gid2").toString());
					data.put("gsex2",map.get("sex"));
					data.put("gage2",map.get("age"));
				}
			} catch (Exception e) {
	    		throw new RuntimeException("共借人二数据处理(身份证)异常!");
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
	    		throw new RuntimeException("配偶相关数据处理异常!");
			}
			//图片部分
			try {
				int count=0;
				/*本地示例：
				C:/Users/Administrator/Desktop/word/6.jpgC:/Users/Administrator/Desktop/word/6.jpgupload/2018/12/05/19c43d2433d75441c2dd7be45a604ff8.jpgupload/2018/12/05/250126c780fd93b29e175db5ec00db8d.jpg
				*/
				String[] tts =data.get("tt").toString().split("");
				for(int i=0;i<tts.length;i++){
					if(tts[i].length()>0){
						count++;
						if(count==1){
							data.put("tt",DocumentHandlerParent.download_prefix+tts[i]);
						}else if(count==2){
							data.put("reverseIdCard_img",DocumentHandlerParent.root_Directory+tts[i]);
							break;
						}
					}
				}
			} catch (Exception e) {
				log.error("身份证照片处理异常!->"+e);
				throw new RuntimeException("身份证照片处理异常!");
			}
	}
}
