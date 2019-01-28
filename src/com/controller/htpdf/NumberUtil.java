package com.controller.htpdf;
import java.util.Map;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
/**金额数字大小写转换
 * 类名称 NumberUtil
 * 类描述:
 * 创建人: LiWang
 */
public class NumberUtil {
	  private static Logger log = LogManager.getLogger(NumberUtil.class.getName());
	  private static final String UNIT[] = { "万", "仟", "佰", "拾", "亿", "仟", "佰",  
	            "拾", "万", "仟", "佰", "拾", "", "角", "分" };  
	    private static final String NUM[] = { "零", "壹", "贰", "叁", "肆", "伍", "陆",  
	            "柒", "捌", "玖" }; 
	    //									个 		十 		百			 千				 万				十万				百万
	    private static String suffix[]={"_ones","_tens","_hundreds","_thousands","_tenThousand","_oneHundredThousand","_million"};
	    //将一个整数金额的个位十位 百位千位 的数字用中文的形式表示并放在map中
		 public static void numberSubchinese(String money,Map map,String prefix){
			Integer integer=Integer.parseInt(money);//转化为整数类型
			money=String.valueOf(integer);//后续操作变量
			Integer length=money.length();
			for(int j=1;j<=suffix.length;j++){
				int site=length-j;
				if(site>=0){//money的index范围内取值 否则报下标越界
					Integer value=Integer.parseInt(String.valueOf(money.charAt(site)));//获得当前索引的值 从个位开始
					map.put(prefix+suffix[j-1],NUM[value]);
				}else{
					//默认为0
					map.put(prefix+suffix[j-1],"零");
				}
			}
	    }
	    /** 
	     * 将金额小数转换成中文大写金额 
	     * @param money 
	     * @return result 
	     */  
	    public static String Test2(double money) {  
	        long money1 = Math.round(money * 100);// 四舍五入到分  
	        if (money1 == 0) return "零";  
	        String strMoney = String.valueOf(money1);
	        int numIndex = 0; // numIndex用于选择金额数值
	        int unitIndex = UNIT.length - strMoney.length();//unitIndex表示 金额单位
	        boolean isZero = false; // 用于判断当前为是否为零  
	        String result = "";  
	        for (; numIndex < strMoney.length(); numIndex++, unitIndex++){
	            char num = strMoney.charAt(numIndex);//返回此位置上的金额数字 从最大的位数开始
	            if (num == '0') { //如果此位置的数字为 0
	                isZero = true;
	                
	                if (UNIT[unitIndex] == "亿" || UNIT[unitIndex] == "万" || UNIT[unitIndex] == "") { // 如果当前位是亿、万、元，且数值为零   比如20000
	                    result = result + UNIT[unitIndex]; //补单位亿、万、元  
	                    isZero = false; //什么情况下不需要加零 比如20 **** 贰拾万.... 有 贰拾万却没有贰拾仟 就是这个道理
	                }
	            }else {  
	                if (isZero){ //什么情况下需要加零 比如 20** 贰仟零....
	                    result = result + "零";  
	                    isZero = false;  
	                } 
	                result = result + NUM[Integer.parseInt(String.valueOf(num))] + UNIT[unitIndex];  
	            }  
	        }  
	        //不是角分结尾就加"整"字  
	       /* if (!result.endsWith("角")&&!result.endsWith("分")) {  
	            result = result + "整";  
	        } */ 
	        //例如没有这行代码，数值"400000001101.2"，输出就是"肆千亿万壹千壹佰零壹元贰角"  
	        result = result.replaceAll("亿万", "亿");  
	        return result;  
	    }
	    public static void main(String[] args){
//	    	String s=NumberUtil.Test2(Double.valueOf("200303"));//200303.22
//	    	System.out.println(s);
//	    	System.out.println(chineseNumber2Int(s));
	    	
	    	
//	    	String s="45";
//	    	Map map=new LinkedHashMap<>();
//	    	numberSubchinese(s,map,"A");
//	    	System.out.println(s+"   "+JSON.toJSONString(map));
	    }
	    //精确到个位
	    @SuppressWarnings("unused")
	    private static double chineseNumber2Int(String chineseNumber){
	        double result = 0;
	        double temp = 1;//存放一个单位的数字如：十万
	        int count = 0;//判断是否有chArr
	        char[] cnArr = new char[]{'壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖'};
	        char[] chArr = new char[]{'拾', '佰', '仟', '万', '亿'};//, '角','分','厘'
	        for (int i = 0; i < chineseNumber.length(); i++) {
	            boolean b = true;//判断是否是chArr
	            char c = chineseNumber.charAt(i);
	            for (int j = 0; j < cnArr.length; j++) {//非单位，即数字
	                if (c == cnArr[j]) {//如果此时 c等于1 j=0则相等 c等于2 j=1则相等
	                    if(0 != count){//添加下一个单位之前，先把上一个单位值添加到结果中
	                        result += temp;
	                        temp = 1;
	                        count = 0;
	                    }
	                    // 下标+1，就是对应的值
	                    temp = j + 1;
	                    b = false;
	                    break;
	                }
	            }
	            if(b){//单位{'十','百','千','万','亿'}
	                for (int j = 0; j < chArr.length; j++) {
	                    if (c == chArr[j]) {
	                        switch (j) {
	                        case 0:
	                            temp *= 10;
	                            break;
	                        case 1:
	                            temp *= 100;
	                            break;
	                        case 2:
	                            temp *= 1000;
	                            break;
	                        case 3:
	                            temp *= 10000;
	                            break;
	                        case 4:
	                            temp *= 100000000;
	                            break;
	                        case 5:
	                            temp *= 0.1;
	                            break;
	                        case 6:
	                            temp *= 0.01;
	                            break;
	                        case 7:
	                            temp *= 0.001;
	                            break;
	                        default:
	                            break;
	                        }
	                        count++;
	                    }
	                }
	            }
	            if (i == chineseNumber.length() - 1) {//遍历到最后一个字符
	                result += temp;
	            }
	        }
	        return result;
	    }
	   
}
