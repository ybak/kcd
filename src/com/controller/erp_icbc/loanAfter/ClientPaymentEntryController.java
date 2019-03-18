package com.controller.erp_icbc.loanAfter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.controller.Excel.UploadExcelController;
import com.model1.icbc.erp.PageData;
import com.service1.loan.AboutExcelService;
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
	private AboutExcelService AboutExcelService;
	
	/**
	 * 通过文件名称模糊查询 查询全部数据并分页
	 */
	@RequestMapping("/selectImpRecordList.do")
	public String select(String qn, String cn, String type, String dn,
			int pagesize, int pagenow, HttpServletRequest request)throws UnsupportedEncodingException {
		//构造查询条件
		PageData pd = new PageData();
		pd.put("param", request.getParameter("param"));
		//查询数据
		List<PageData> newpdList = new ArrayList<>();
		List<PageData> l1 = AboutExcelService.selectRecordList(pd);
		newpdList = limitutil.fy(l1, pagesize, pagenow); //分页
		System.out.println("*************" + newpdList);
		int q = l1.size() % pagesize;
		int totalpage = 0;// 总页数
		if (q == 0) {
			totalpage = l1.size() / pagesize;
		} else {
			totalpage = l1.size() / pagesize + 1;
		}
		request.setAttribute("dn", dn);
		request.setAttribute("cn", cn);
		request.setAttribute("qn", qn);
		request.setAttribute("type", type);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("pagenow", pagenow);
		request.setAttribute("pagesize", pagesize);
		request.setAttribute("totalsize", l1.size());
		request.setAttribute("newpdList", newpdList);
		request.setAttribute("param",request.getParameter("param")); //查询条件
		log.info("结果" + l1);
		return "kjs_icbc/index";
	}
}
