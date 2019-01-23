package com.controller.htpdf;
/**将金额转换为大写中文
 * 类名称 NumberUtil
 * 类描述:
 * 创建人: LiWang
 */
public class NumberUtil {
	  private static final String UNIT[] = { "万", "仟", "佰", "拾", "亿", "仟", "佰",  
	            "拾", "万", "仟", "佰", "拾", "", "角", "分" };  
	    private static final String NUM[] = { "零", "壹", "贰", "叁", "肆", "伍", "陆",  
	            "柒", "捌", "玖" };  
	    /** 
	     * 将金额小数转换成中文大写金额 
	     * @param money 
	     * @return result 
	     */  
	    public static String Test2(double money) {  
	        long money1 = Math.round(money * 100);// 四舍五入到分  
	        if (money1 == 0) return "零";  
	        String strMoney = String.valueOf(money1);//将long类型的转化为字符串 
	        int numIndex = 0; // numIndex用于选择金额数值  
	        int unitIndex = UNIT.length - strMoney.length();//unitIndex用于选择金额单位   单位从大到小
	        boolean isZero = false; // 用于判断当前为是否为零  
	        String result = "";  
	        for (; numIndex < strMoney.length(); numIndex++, unitIndex++){
	            char num = strMoney.charAt(numIndex);//返回此位置上的金额数字
	            if (num == '0') {  
	                isZero = true;//比如"2033".charAt("0")  
	                if (UNIT[unitIndex] == "亿" || UNIT[unitIndex] == "万" || UNIT[unitIndex] == "") { // 如果当前位是亿、万、元，且数值为零   比如20000
	                    result = result + UNIT[unitIndex]; //补单位亿、万、元  
	                    isZero = false;  
	                }   
	            }else {  
	                if (isZero) {  
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
}
