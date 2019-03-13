package com.controller.htpdf;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
/** 实现类一
 * @author LiWang
 */
public class DocumentHandler2 extends DocumentHandlerParent{
	public DocumentHandler2(String templateDirectory, HttpServletRequest request, Map map) {
		super(templateDirectory, request, map);
		// TODO Auto-generated constructor stub
	}
	private static Logger log = LogManager.getLogger(DocumentHandler2.class.getName());
	private final static String[] DPDF={"1.pdf","55.pdf","9.pdf","10.pdf","11.pdf","18.pdf","20.pdf","21.pdf","25.1.pdf","25.pdf","26.pdf","5.pdf","2.pdf","27.pdf","28.pdf","29.pdf","30.pdf","31.pdf"};
	private final static String[] NPDF={"3.pdf","4.pdf","39.pdf","51.pdf"};
	//这里抛弃只使用 list 和addAll()方法的形势
	@SuppressWarnings("unchecked")
	public Object fillTemplate () throws Exception{
			addn();//生成完毕
    		//数据处理
			map.put("a","安联汽车服务有限");//委托授权书中
			map.put("b", "安联汽车服务有限公司");
			map.put("jxs","安联");//经销商
			map.put("zh", "武林");
			
    		DataConversion.dataDisposeToMap(map);
    		log.info("数据集->"+map);
    		//动态分类整理pdf
    		List<String> l1=new ArrayList<String>();
    		//拷贝
    		List<String> l2=new  ArrayList<String>();
    		int iii=1;
    		if(Integer.parseInt(map.get("loanamount").toString())<150000){
    			l1.add("43.pdf");//收入声明
    			if(!map.get("gid").toString().equals("")){
    				l1.add("14.pdf");//共借人一送达地址确认书
    				l1.add("15.pdf");//共借人一送达地址确认书
    				l1.add("7.pdf");//共借人一配偶共同还款承诺书
    				l2.add("47.pdf");//共借人一收入声明
    				l2.add("53.pdf");//共借人一住房资产证明
        			iii++;
        		}
        		if(!map.get("gid2").toString().equals("")){
        			l1.add("16.pdf");//共借人二送达地址确认书
        			l1.add("17.pdf");//共借人二送达地址确认书
        			l1.add("8.pdf");//共借人二共同还款承诺书
        			l2.add("49.pdf");//共借人二收入声明
        			l2.add("54.pdf");//共借人二住房资产证明
        			iii++;
        		}
        		if(!map.get("pIDnumber").toString().equals("")){
        			l1.add("12.pdf");//送达地址确认书
        			l1.add("13.pdf");//送达地址确认书
        			l1.add("6.pdf");//共同还款承诺书
        			l1.add("45.pdf");//收入声明
        			l2.add("52.pdf");//配偶个人资方资产证明
        			l1.remove("18.pdf");
        			iii++;
        			if(!map.get("gid").toString().equals("") && map.get("gid2").toString().equals("") ){
        				l1.add("19.pdf");//单身说明书
        			}
        		}
    		}else{
    			l2.add("44.pdf");//个人薪金收入证明
    			if(!map.get("gid").toString().equals("")){
    				l1.add("14.pdf");//共借人一送达地址确认书
    				l1.add("15.pdf");//共借人一送达地址确认书
    				l1.add("7.pdf");//共借人一配偶共同还款承诺书
    				l2.add("48.pdf");//共借人一个人薪金收入证明
    				l2.add("53.pdf");//共借人一住房资产证明
        			iii++;
        		}
        		if(!map.get("gid2").toString().equals("")){
        			l1.add("16.pdf");//共借人二送达地址确认书
        			l1.add("17.pdf");//共借人二送达地址确认书
        			l1.add("8.pdf");//共借人二共同还款承诺书
        			l2.add("50.pdf");//共借人二个人薪金收入证明
        			l2.add("54.pdf");//共借人二住房资产证明
        			iii++;
        		}
        		if(!map.get("pIDnumber").toString().equals("")){
        			l1.add("12.pdf");//送达地址确认书
        			l1.add("13.pdf");//送达地址确认书
        			l1.add("6.pdf");//共同还款承诺书
        			l2.add("46.pdf");//个人薪金收入证明
        			l2.add("52.pdf");//配偶个人资方资产证明
        			l1.remove("18.pdf");
        			iii++;
        			if(!map.get("gid").toString().equals("") && map.get("gid2").toString().equals("") ){
        				l1.add("19.pdf");//单身说明书
        			}
        		}
    		}
    		if(map.get("dztype").toString().equals("2")){//2垫资 1不垫资
    			l1.add("34.pdf");//借款借据金锤版垫资使用！！！
    			l1.add("35.pdf");//委托划款授权书垫资使用 ！！！
    			l1.add("36.pdf");//委托代购协议书垫资使用 ！！！
    		}
    		if(iii>2){
    			l2.add("40.pdf");//情况说明
    		}
    		
			copys(l2.toArray(new String[l2.size()]))  ;
			pdfs(l1.toArray(new String[l1.size()]));
			copys(NPDF);
			pdfs(DPDF);
			addn();//打包中
			Object s=endAssembly();
     	    addn();//生成完毕
     	    return s;
		}
}

