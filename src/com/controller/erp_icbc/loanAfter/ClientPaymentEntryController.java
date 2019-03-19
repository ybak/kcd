package com.controller.erp_icbc.loanAfter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.controller.Excel.UploadExcelController;
import com.model1.icbc.erp.PageData;
import com.service1.loan.AboutExcelService;
import com.service1.loan.ClientPaymentService;
import com.service1.loan.AboutExcelService;
import com.util.limitutil;
/**
 * 客户还款管理-客户还款录入控制器
 * 
 * @author 三十画生
 * 2019-3-16
 */
@Controller
@RequestMapping("/loan")
public class ClientPaymentEntryController {
	private static Logger log = LogManager.getLogger(UploadExcelController.class.getName());
	@Autowired
	private ClientPaymentService clientPaymentService;
	
	/**
	 * 查询并分页
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/selectPayList")
	public String select(
			String param,
			String qn,
			String type,
			String dn,	
			int pagesize,
			int pagenow,	
			HttpServletRequest request) throws UnsupportedEncodingException{
		requestParams(request);
		List<PageData> newpdList=new ArrayList<>();
		PageData pd=new PageData();
		pd.put("param",param);
		List<PageData> pdList=clientPaymentService.selectPayList(pd);
		newpdList = limitutil.fy(pdList, pagesize, pagenow);
		int q=pdList.size()%pagesize;
		int totalpage=0;//总页数
		if(q==0){
			totalpage=pdList.size()/pagesize;	    		
		}else{
			totalpage=pdList.size()/pagesize+1;
		} 
//		for(int i = 0;i<pdList.size();i++){			
//			Map map = pdList.get(i);
//			log.info("map->"+map);
//			double myyh=0;
//			if(null != map){
//				//总额
//				BigDecimal aa = new BigDecimal((map.get("dk_total_price").toString()==null?"0":map.get("dk_total_price").toString()));
//				//贷款期限
//				BigDecimal cc=new BigDecimal( (map.get("aj_date").toString()==null?"0":map.get("aj_date").toString()));
//				//每月应还=总额/贷款期数
//				BigDecimal dd2 = aa.divide(cc, 3,BigDecimal.ROUND_DOWN);
//				String a1 = dd2.toString();//转成string
//				System.out.println(a1);
//				System.out.println(a1.length());//获取长度
//				System.out.println(a1.substring(a1.indexOf(".")+3, a1.length()));
//				String bb = a1.substring(a1.indexOf(".")+3, a1.length());//截取第三位小数
//				System.out.println("----bb："+bb);
//				int c1 = Integer.parseInt(bb);//转成int
//				if(c1 > 0){//判断是否大于0  是就保留两位小数
//					BigDecimal vv = dd2.setScale(2, BigDecimal.ROUND_DOWN);
//					BigDecimal zero = new BigDecimal("0.01");
//					myyh = vv.add(zero).doubleValue();
//				}else{
//					BigDecimal vv = dd2.setScale(2, BigDecimal.ROUND_DOWN);
//					myyh=vv.doubleValue();
//					System.out.println("----每月应还2："+myyh);
//				}
//				map.put("myyh", myyh);
//				BigDecimal icbc_pricecs = new BigDecimal(map.get("icbc_pricecs").toString());
//				String s=icbc_pricecs.toString();
//				//去掉多余的 0
//				if(s.indexOf(".")!=-1){
//					 s = s.replaceAll("0+?$", "").replaceAll("[.]$", "");  
//				}
//				map.put("icbc_pricecs",s);
//			}
//			
//			
//		}		
		request.setAttribute("param", param);
		request.setAttribute("dn", dn);
		request.setAttribute("qn", qn);
		request.setAttribute("type", type);	
		request.setAttribute("totalpage",totalpage);
		request.setAttribute("totalsize",pdList.size());
		request.setAttribute("pagesize",pagesize);
		request.setAttribute("pagenow",pagenow);
		request.setAttribute("newpdList", newpdList);
		return "kjs_icbc/index";
	}
	//简单打印参数方便测试
	public static void requestParams(HttpServletRequest request){
		Enumeration enu=request.getParameterNames();  
		while(enu.hasMoreElements()){  
			String paraName=(String)enu.nextElement();  
			log.info("参数名:"+paraName+",参数值："+request.getParameter(paraName));
		}
	}
}
