package com.controller.guaziiapi;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.model.CBS.CbsSuccessfulPurchaseQueryReportExample;
import com.model.CBS.CbsSuccessfulPurchaseQueryReportExample.Criteria;
import com.model.jbapi.jbzxapiuser;
import com.service.guazi.GuaZiService;
import com.util.Page;
@Controller
public class GuaZiController {
	@Autowired
	private GuaZiService gzs;
	//查询 公司——查询类型信息(两表联立)
	@RequestMapping(value="/sgi.do")
	public ModelAndView query(HttpServletRequest request) throws UnsupportedEncodingException{
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
		Page page=new Page();
		page.setMap(mapcondition);//设置查询条件
		page.setPageNow(ipageNow);//设置当前页码
		page.setPageSize(ipageSize);//设置每页显示的条数
		int totalCount=gzs.OneToArrCountSelective(page);
		page.setTotalCount(totalCount);//总数据条数
		List<jbzxapiuser> list=gzs.OneToArr(page);//查询出所有的数据
		page.setListdata(list);
		ModelAndView modelandview=new ModelAndView("guazi");
		modelandview.addObject("page", page);
		return modelandview;
	}
	//点击按钮获取json报告
	@RequestMapping(value="/gbyid.do",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String reportDetailsJson(String gid){
			String s = gzs.selectbyid(gid);
			return s;
	}
}
