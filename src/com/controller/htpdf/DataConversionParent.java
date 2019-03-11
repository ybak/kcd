package com.controller.htpdf;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
//数据过滤父类
public class DataConversionParent {
	public static String getcolor(String s){
		 String ss = null;
		 switch (s){
		 	case "1":
				ss="黑";
				break;
			case "2":
				ss="白";
				break;
			case "3":
				 ss="灰";
				 break;
			case "4":
				 ss="红";
				 break;
			case "5":
				ss="银";
				break;
			case "6":
				 ss="蓝";
				 break;
			case "7":
				ss="金";
				break;
			case "8":
				 ss="棕";
				 break;
			case "9":
				 ss="橙";
				 break;
			case "10":
				ss="黄";
				break;
			case "11":
				 ss="紫";
				 break;
			case "12":
				ss="绿";
				break;
			case "13":
				 ss="褐";
				 break;
			case "14":
				 ss="栗";
				 break;
			case "15":
				ss="米";
				break;
			case "16":
				 ss="银灰";
				 break;
			case "17":
				ss="青";
				break;
			case "18":
				 ss="香槟";
				 break;
			case "19":
				 ss="咖啡";
				 break;
			case "20":
				ss="天山";
				break;
			case "0":
		 		ss="其他色";
		 		break;
		 }
		 return ss;
	}
	
	/*
	 * @Description: 职务
	 */
	public static String getduty(String s){
		 String ss;
		 switch (s){
			case "0":
				 ss="企业负责人";
				 break;
			case "1":
				ss="总经理";
				break;
			case "2":
				 ss="部门经理";
				 break;
			default :
				ss="职员";
				break; 
		}
		 return ss;
	}
	/**
	 * @Description: 学历情况
	 */
	public static String geteducation(String s){
		String ss="初中";
		 switch (s){
			case "1":
				 ss="小学";
				 break;
			case "3":
				ss="高中";
				break;
			case "4":
				 ss="大专";
				 break;
			case "5":
				 ss="本科";
				 break;
			case "6":
				ss="硕士";
				break;
			case "7":
				 ss="博士及以上";
				 break;
		}
		 return ss;
	}
	 /**
	 * @Description: 婚姻情况
	 */
	public static String getmarriage(String s){
		 String ss="未婚";
		 switch (s){
			case "1":
				 ss="已婚";
				 break;
			case "2":
				ss="离异";
				break;
			case "3":
				 ss="丧偶";
				 break;
		}
		 return ss;
	 }
	 
	/**
	 * @Description: 与借款人关系
	 */
	public static String getMutualborrowingR(String s){
		String ss="朋友";
		switch (s){
			case "0":
				 ss="夫妻";
				 break;
			case "1":
				 ss="父子";
				 break;
			case "2":
				ss="母子";
				break;
			case "3":
				ss="兄弟";
				break;
			case "4":
				ss="同事";
				break;
			case "5":
				ss="朋友";
				break;
			case "6":
				 ss="姐妹";
				 break;
			case "7":
				 ss="父女";
				 break;
			case "8":
				 ss="母女";
				 break;
			case "9":
				ss="兄妹";
				break;
			case "10":
				ss="姐弟";
				break;
		}
		return ss;
	}
    /**计算年龄
     */
	public static Map getCarInfo(String CardCode){ 
   	 	String year;//出生年
   	 	String sex;//性别
   	 	int age = 0;//年龄
   	 	
   		year = CardCode.substring(6,10);// 得到年份
   		if (Integer.parseInt(CardCode.substring(16).substring(0, 1)) % 2 == 0) {// 判断性别
            sex = "女";
        } else {
            sex = "男";
        }  	
       //得到当前的系统时间  
       SimpleDateFormat format = new SimpleDateFormat("yyyy"); 
       String fyear = format.format(new Date());
       age=Integer.parseInt(fyear) - Integer.parseInt(year);
       
       Map<String, Object> map = new HashMap<String, Object>();
       map.put("sex", sex);
       map.put("age", age);
       map.put("birth",new StringBuilder().append(year).append("年").append(CardCode.substring(10,12)).append("月").append(CardCode.substring(12,14)).append("日").toString());
       return map;  
   } 
	/** 
     * 使用java正则表达式去掉多余的.与0 
     */  
    public static String subZeroAndDot(String s){  
        if(s.indexOf(".") > 0){  
            s = s.replaceAll("0+?$", "").replaceAll("[.]$", "");  
        }  
        return s;  
    }
    /**
	 * @Description: 居住情况
	 */
    public static String getreside(String s){
		 String ss="自有住房";
		 switch (s){
			case "1":
				 ss="租房";
				 break;
			case "2":
				ss="分期付款购房";
				break;
			case "3":
				 ss="集体宿舍";
				 break;
			case "4":
				 ss="单位分配";
				 break;
			case "5":
				ss="其他";
				break;
		}
		 return ss;
	}
	
	/**
	 * @Description: 单位性质
	 */
    public static String getworkunit(String s){
		 String ss="其他";
		 switch (s){
			case "0":
				 ss="国有";
				 break;
			case "1":
				ss="集体经济";
				break;
			case "2":
				 ss="私营";
				 break;
			case "3":
				 ss="民营";
				 break;
			case "4":
				ss="股份合作";
				break;
			case "5":
				 ss="其他股份制";
				 break;
			case "6":
				 ss="个体";
				 break;
			case "7":
				 ss="三资";
				 break;
		}
	   return ss;
	}
	
	/**
	 * @return
	 * @Description: 所属行业
	 * @param name
	 * @return 
	 */
    public static String getindustry(String s){
		 String ss="其他";
		 switch (s){
			case "0":
				 ss="农林牧渔";
				 break;
			case "1":
				ss="邮电通讯";
				break;
			case "2":
				 ss="房地产";
				 break;
			case "3":
				 ss="科教文卫";
				 break;
			case "4":
				ss="工业";
				break;
			case "5":
				 ss="银行";
				 break;
			case "6":
				ss="证券";
				break;
			case "7":
				 ss="保险";
				 break;
			case "8":
				 ss="商业";
				 break;
			case "9":
				ss="机关团体";
				break;
		}
		 return ss;
	}
	/**
	 * @Description: 职业
	 */
    public static String getProfessional(String s){
		  String ss="其他";
		 switch (s){
			case "0":
				 ss="公务员";
				 break;
			case "1":
				ss="事业单位员工";
				break;
			case "2":
				 ss="工人";
				 break;
			case "3":
				 ss="农民";
				 break;
			case "4":
				ss="军人";
				break;
			case "5":
				 ss="职员";
				 break;
			case "6":
				ss="私人业主";
				break;
			case "7":
				ss="学生";
				break;
			case "8":
				 ss="自由职业";
				 break;
		}
		 return ss;
	}
}
