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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
	
	
	//查询主贷人信息表
	@RequestMapping("/selectPayform.do")
	public String selectBorrow(String qn
								,String type
								,String dn
								,HttpServletRequest request
								,String c_cardno
								,String icbc_id
								){
		Map<String, Object> lborrow = clientPaymentService.selectPayform(icbc_id);
		log.info("map2->"+lborrow);
		double yy=0;
		if(null != lborrow){
			//总额
			BigDecimal mm = new BigDecimal(lborrow.get("dk_total_price").toString());
			System.out.println("-----mm:"+mm);
			//贷款期限
			BigDecimal cc2=new BigDecimal( lborrow.get("aj_date").toString());
			System.out.println("------cc2:"+cc2);
			//每月应还=本息合计/贷款期数
			BigDecimal dd2 = mm.divide(cc2, 3,BigDecimal.ROUND_DOWN);//保留三位小数
			System.out.println("------dd2:"+dd2);
			String aa = dd2.toString();//转成string
			System.out.println(aa);
			System.out.println(aa.length());//获取长度
			System.out.println(aa.substring(aa.indexOf(".")+3, aa.length()));
			String bb = aa.substring(aa.indexOf(".")+3, aa.length());//截取第三位小数
			int cc = Integer.parseInt(bb);//转成int
			if(cc > 0){//判断是否大于0  是就保留两位小数
				BigDecimal vv = dd2.setScale(2, BigDecimal.ROUND_DOWN);	
				BigDecimal zero = new BigDecimal("0.01");
				yy = vv.add(zero).doubleValue();
			}else{
				BigDecimal vv = dd2.setScale(2, BigDecimal.ROUND_DOWN);
				yy=vv.doubleValue();
			}
			lborrow.put("myyh", yy);
			System.out.println("-----yy:"+yy);
			BigDecimal icbc_pricecs2 = new BigDecimal(lborrow.get("icbc_pricecs").toString());
			String s=icbc_pricecs2.toString();
			//去掉多余的 0
			if(s.indexOf(".")!=-1){
				 s = s.replaceAll("0+?$", "").replaceAll("[.]$", ""); 
		}
			lborrow.put("icbc_pricecs",s);
		}
		//查询还款计划
		List<PageData> mapschedule = clientPaymentService.selectPaySchedule(icbc_id);
		log.info("map3->"+mapschedule);
		//查询贷后信息
		PageData mapafter = clientPaymentService.selectLoanAfter(icbc_id);
		log.info("map4->"+mapafter);
		//查询主贷人信息
		Map<String, Object> mapzdr = clientPaymentService.selectZdr(icbc_id);
		log.info("map5->"+mapzdr);
		request.setAttribute("dn", dn);
		request.setAttribute("qn", qn);
		request.setAttribute("type", type);
		request.setAttribute("lborrow", lborrow);
		request.setAttribute("mapschedule", mapschedule);
		request.setAttribute("mapafter", mapafter);
		request.setAttribute("mapzdr", mapzdr);
		return "kjs_icbc/index";
	}
	
	/**
	 * 查询并分页
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/selectPayList.do")
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
		PageData pdsession= (PageData)request.getSession().getAttribute("pd");
		pd.put("gems_fs_id",pdsession.get("icbc_erp_fsid"));
		List<PageData> pdList=clientPaymentService.selectPayList(pd);
		newpdList = limitutil.fy(pdList, pagesize, pagenow);
		int q=pdList.size()%pagesize;
		int totalpage=0;//总页数
		if(q==0){
			totalpage=pdList.size()/pagesize;	    		
		}else{
			totalpage=pdList.size()/pagesize+1;
		} 
		for(int i = 0;i<pdList.size();i++){			
			Map map = pdList.get(i);
			log.info("map->"+map);
			double myyh=0;
			if(null != map){
				//库里面数据
//				JSONObject json = (JSONObject) JSON.parse(map.get("result_1_value").toString());  // String 转 JSONObject 
//				String syhk = json.getString("61_syhk");
//				String yh = json.getString("61_yh");
//				map.put("syhk", syhk);
//				map.put("yh", yh);
				//总额
				BigDecimal aa = new BigDecimal(map.get("dk_total_price").toString());
				//贷款期限
				BigDecimal cc=new BigDecimal( map.get("aj_date").toString());
				//每月应还=总额/贷款期数
				BigDecimal dd2 = aa.divide(cc, 3,BigDecimal.ROUND_DOWN);
				String a1 = dd2.toString();//转成string
				System.out.println(a1);
				System.out.println(a1.length());//获取长度
				System.out.println(a1.substring(a1.indexOf(".")+3, a1.length()));
				String bb = a1.substring(a1.indexOf(".")+3, a1.length());//截取第三位小数
				System.out.println("----bb："+bb);
				int c1 = Integer.parseInt(bb);//转成int
				if(c1 > 0){//判断是否大于0  是就保留两位小数
					BigDecimal vv = dd2.setScale(2, BigDecimal.ROUND_DOWN);
					BigDecimal zero = new BigDecimal("0.01");
					myyh = vv.add(zero).doubleValue();
				}else{
					BigDecimal vv = dd2.setScale(2, BigDecimal.ROUND_DOWN);
					myyh=vv.doubleValue();
					System.out.println("----每月应还2："+myyh);
				}
				map.put("yh", myyh);
			}
		}		
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
