package com.util.duoying;

public class timechange {
	//日期格式转换 00000000000  通用
	public static Object change(Object a) {
        if (a == null)
            return a;
        a = ((String) a).replaceAll("年", "-").replaceAll("月", "-").replace("日", "-");
        String[] b = ((String) a).split("-");
        if (b.length == 0)
            return a;
        StringBuilder sb = new StringBuilder();

        switch (b.length) {
        case 1:
            sb.append(b[0]);
            sb.append("0000000000");
            break;
        case 2:
            sb.append(b[0]);
            sb.append(b[1].length()==2?b[1]:"0"+b[1]);
            sb.append("00000000");
            break;
        case 3:
            sb.append(b[0]);
            sb.append(b[1].length()==2?b[1]:"0"+b[1]);
            sb.append(b[2].length()==2?b[2]:"0"+b[2]);
            sb.append("000000");
            break;
        default:
            break;
        }
        return sb.toString();
    }
	
	
	public static void main(String[] args) {
		
		Object s= timechange.change("2012-1");	
		System.out.println(s);
		
	}
}
