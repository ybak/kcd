package com.controller.CBSapi;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSONObject;
import com.chaboshi.util.CBS;
import com.model.CBS.CbsSuccessfulPurchaseQueryReport;
import com.model.CBS.CbsSuccessfulPurchaseQueryReportExample;
import com.model.CBS.CbsSuccessfulPurchaseQueryReportExample.Criteria;
import com.model.jbapi.jbzxapiuser;
import com.service.CBS.CbsSuccessfulPurchaseQueryReportService;
import com.util.Page;
import com.util.creditutil;
@Controller
public class CBSControllerByPC {
	private static final String USER_ID="60206";
	private static final String  KEY_SECRET="b2082f585b0fcb96f19283bb74e5f235";
	//查博士的操作
	@Autowired
	private CbsSuccessfulPurchaseQueryReportService cspqr;
	//查询 公司——查询类型信息(两表联立)
	@RequestMapping(value="/selectbyrecord.do")
	public ModelAndView  Test(HttpServletRequest request) throws UnsupportedEncodingException{
		request.setCharacterEncoding("UTF-8");
		Map<String,String> mapcondition=new HashMap();
		String spageNow=request.getParameter("pageNow");//当前页码
		String spageSize=request.getParameter("pageSize");//每页显示的条数
		String conditionOne=request.getParameter("conditionOne");//输入创建时间区间
		String conditionTwo=request.getParameter("conditionTwo");
		if(conditionOne!=null && !conditionOne.equals("")){//日期区间 2018/03/05 - 2018/03/05
			int index=conditionOne.indexOf("-");
			mapcondition.put("timeFirst",conditionOne.substring(0,index-1));//2018/02/04  2018/02/06
			mapcondition.put("timeLast",conditionOne.substring(index+2));
		}
		//String conditionTwo=request.getParameter("conditionTwo");//输入appkey/公司名称
		String conditionThree=request.getParameter("conditionThree");//输入vin码
		String conditionFour=request.getParameter("conditionFour");//订单状态
		mapcondition.put("conditionOne",conditionOne);
		if(conditionTwo!=null){
			conditionTwo=new String(conditionTwo.getBytes("iso-8859-1"),"utf-8");
		}
		mapcondition.put("conditionTwo",conditionTwo);
		mapcondition.put("conditionThree",conditionThree);
		mapcondition.put("conditionFour",conditionFour);
		int ipageNow=1;//默认
		int ipageSize=10;//默认
		if(spageNow!=null && !spageNow.equals("") ){ 
			ipageNow=Integer.valueOf(spageNow);
		}
		if(spageSize!=null && !spageSize.equals("")){
			ipageSize=Integer.valueOf(spageSize);
		}
		
	/*	select * from kj_jbzxapiuser jk,
		 cbs_successful_purchase_query_report cs
		 where   jk.id=cs.cbs_apiuser_id 
		and 
		cs.cbs_addtime<='2018-02-24' and  cs.cbs_addtime>='2018-02-06' and cs.cbs_start=1 and (cs.cbs_vin like '%G210XBL50%' )  and (jk.appKey like '%fcc%' or jk.api_name like '%测试%' or jk.api_card like '%411403199512108410%')*/
		//int totalCount=cspqr.OneToArrCount();
		Page page=new Page();
		page.setMap(mapcondition);//设置查询条件
		page.setPageNow(ipageNow);//设置当前页码
		page.setPageSize(ipageSize);//设置每页显示的条数
		int totalCount=cspqr.OneToArrCountSelective(page);
		page.setTotalCount(totalCount);//总数据条数
		List<jbzxapiuser> list=cspqr.OneToArr(page);//查询出所有的数据
		page.setListdata(list);
		ModelAndView modelandview=new ModelAndView("cbs");
		modelandview.addObject("page", page);
		return modelandview;
	}
	//public static void main(String[] args){
		/*CBS cbs=CBS.getInstance(USER_ID, KEY_SECRET);
		String messages=cbs.getReportStatus("53564c292cc146158223726025a5edb3");//查询订单状态
		System.out.println(messages);
		List list=new ArrayList<>();
		list.add(null);*/
	/*	Map map=new HashMap<>();
		map.put("1", null);
		map.put("2", null);*/
		
		/*String  conditionOne="2018/03/05 - 2018/03/06";
		if(conditionOne!=null && !conditionOne.equals("")){//日期区间 2018/03/05 - 2018/03/05
			int index=conditionOne.indexOf("-");
		
			System.out.println(conditionOne.substring(0,index-1)+"ff"+conditionOne.substring(index+2)+"ff");
		}*/ 
	//}
	
	//更新状态
	@RequestMapping(value="/updatestart.do")
	@ResponseBody
	public Map UpdateStart(String orderId){
			Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
			if(orderId!=null){
				//查询订单状态
				CBS cbs=CBS.getInstance(USER_ID, KEY_SECRET);
				String messages=cbs.getReportStatus(orderId);//查询订单状态
				JSONObject jsonobject=JSONObject.parseObject(messages);
				Object code=jsonobject.get("Code");
				 if(code.equals("1104")){//已出报告
					//查询报告详情 json格式
					String reportdetails=cbs.getNewReportJson(orderId);
					
					CbsSuccessfulPurchaseQueryReport cbssuccessfulpurchasequeryreport=new CbsSuccessfulPurchaseQueryReport();
					cbssuccessfulpurchasequeryreport.setCbsReportDetails(reportdetails);//车辆维修保养详情
					cbssuccessfulpurchasequeryreport.setCbsOrderid(orderId);//设置订单id
					cbssuccessfulpurchasequeryreport.setCbsStart(2);//设置状态为已查询
					cbssuccessfulpurchasequeryreport.setCbsUptime(creditutil.time());//最后更新时间
					//更新数据
					int u=cspqr.updateByOrderIdSelective(cbssuccessfulpurchasequeryreport);
					if(u>0){
						resultMap.put("message", "更新数据库成功！");
					}else{
						resultMap.put("message", "更新数据库失败！");
					}
				}else{
					resultMap.put("message", "更新状态失败请稍后重试！");
				}
			}else{
				resultMap.put("message", "订单编号为空！");
			}
			return resultMap ;
	}
	//点击按钮获取json报告
	@RequestMapping(value="/selectbyjson.do",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String reportDetailsJson(
			@RequestParam("orderId")String orderId //订单id
			){
			//根据orderid查询
			CbsSuccessfulPurchaseQueryReportExample cspqre=new CbsSuccessfulPurchaseQueryReportExample();
			Criteria criteria=cspqre.createCriteria();
			criteria.andCbsOrderidEqualTo(orderId);
			String selectByExample = cspqr.selectByExample(cspqre);
			System.out.println(selectByExample);
			return selectByExample;
			//CBS.getInstance(USER_ID, KEY_SECRET).getNewReportJson(orderId)
	}
}
