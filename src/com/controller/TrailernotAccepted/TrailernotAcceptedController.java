package com.controller.TrailernotAccepted;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.alibaba.fastjson.JSON;
import com.controller.Excel.UploadExcelController;
import com.model1.icbc.erp.PageData;
import com.service1.TrailernotAccepted.TrailernotAcceptedService;
import com.service1.sxx.VehicleMortgageService;
import com.util.limitutil;
import com.util.upload;
import com.util.Excel.CommonUtil;

@Controller
@RequestMapping("/trailernotAcceptedController")
public class TrailernotAcceptedController {
	private static Logger log = LogManager.getLogger(TrailernotAcceptedController.class.getName());
	@Autowired
	private TrailernotAcceptedService trailernotAcceptedService;
	 private static final long serialVersionUID = 1L;
	 //上传文件存储目录
	 private static final String UPLOAD_DIRECTORY = "upload";
	// 上传配置
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
	private static final ServletRequest ServletActionContext = null;
	
	private ServletContext application;

	/**
	 * 查询列表页所有数据并模糊查询
	 * @param pagesize
	 * @param pagenow
	 * @param dn
	 * @param qn
	 * @param cn
	 * @param type
	 * @param param
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/select")
	public String selectTrailernotAccepted(
			Integer pagesize,
			Integer pagenow,
			String dn,
			String qn,
			String cn,
			String type,
			String param,
			HttpServletRequest request
			)throws UnsupportedEncodingException{
		
		//获取登陆信息
		PageData pdLoginSession = (PageData)request.getSession().getAttribute("pd");
//		System.out.println(pdLoginSession.get("name"));
		int ps = 0;
		int pn = 0;
		if (pagesize != null && !pagesize.equals("")) {
			ps = pagesize;
		} else {
			ps = 10;
		}
		if (pagenow != null && !pagenow.equals("")) {
			pn = pagenow;
		} else {
			pn = 1;
		}
		List<PageData> newpdList=trailernotAcceptedService.selectTrailernotAccepted(param,(pn-1)*ps,ps);
		int totalsize=trailernotAcceptedService.count();
//		System.out.println("***************count:"+totalsize);
		int q=totalsize%ps;
		int totalpage=0;//总页数
		if(q==0){
			totalpage=totalsize/ps;	    		
		}else{
			totalpage=totalsize/ps+1;
		} 

		
		request.setAttribute("dn", dn);
		request.setAttribute("qn", qn);
		request.setAttribute("type", type);
		request.setAttribute("totalpage",totalpage);
		request.setAttribute("pagesize",ps);
		request.setAttribute("pagenow",pn);
		request.setAttribute("totalsize",totalsize);
		request.setAttribute("newpdList", newpdList);
		log.info("结果"+newpdList);
		
		return "kjs_icbc/index";
	}
	/**
	 * 查询列表页所有数据并模糊查询
	 * @param pagesize
	 * @param pagenow
	 * @param dn
	 * @param qn
	 * @param cn
	 * @param type
	 * @param param
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/select1")
	public String selectTrailernotAccepted1(
			Integer pagesize,
			Integer pagenow,
			String dn,
			String qn,
			String cn,
			String type,
			String param,
			HttpServletRequest request
			)throws UnsupportedEncodingException{
		
		//获取登陆信息
		PageData pdLoginSession = (PageData)request.getSession().getAttribute("pd");
//		System.out.println(pdLoginSession.get("name"));
		int ps = 0;
		int pn = 0;
		if (pagesize != null && !pagesize.equals("")) {
			ps = pagesize;
		} else {
			ps = 10;
		}
		if (pagenow != null && !pagenow.equals("")) {
			pn = pagenow;
		} else {
			pn = 1;
		}
		List<PageData> newpdList=trailernotAcceptedService.selectTrailernotAccepted1(param,(pn-1)*ps,ps);
		int totalsize=trailernotAcceptedService.count1();
//		System.out.println("***************count:"+totalsize);
		int q=totalsize%ps;
		int totalpage=0;//总页数
		if(q==0){
			totalpage=totalsize/ps;	    		
		}else{
			totalpage=totalsize/ps+1;
		} 

		
		request.setAttribute("dn", dn);
		request.setAttribute("qn", qn);
		request.setAttribute("type", type);
		request.setAttribute("totalpage",totalpage);
		request.setAttribute("pagesize",ps);
		request.setAttribute("pagenow",pn);
		request.setAttribute("totalsize",totalsize);
		request.setAttribute("newpdList", newpdList);
		log.info("结果"+newpdList);
		
		return "kjs_icbc/index";
	}
	/**
	 * 查询列表页所有数据并模糊查询
	 * @param pagesize
	 * @param pagenow
	 * @param dn
	 * @param qn
	 * @param cn
	 * @param type
	 * @param param
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/select2")
	public String selectTrailernotAccepted2(
			Integer pagesize,
			Integer pagenow,
			String dn,
			String qn,
			String cn,
			String type,
			String param,
			HttpServletRequest request
			)throws UnsupportedEncodingException{
		
		//获取登陆信息
		PageData pdLoginSession = (PageData)request.getSession().getAttribute("pd");
//		System.out.println(pdLoginSession.get("name"));
		int ps = 0;
		int pn = 0;
		if (pagesize != null && !pagesize.equals("")) {
			ps = pagesize;
		} else {
			ps = 10;
		}
		if (pagenow != null && !pagenow.equals("")) {
			pn = pagenow;
		} else {
			pn = 1;
		}
		List<PageData> newpdList=trailernotAcceptedService.selectTrailernotAccepted2(param,(pn-1)*ps,ps);
		int totalsize=trailernotAcceptedService.count2();
//		System.out.println("***************count:"+totalsize);
		int q=totalsize%ps;
		int totalpage=0;//总页数
		if(q==0){
			totalpage=totalsize/ps;	    		
		}else{
			totalpage=totalsize/ps+1;
		} 

		
		request.setAttribute("dn", dn);
		request.setAttribute("qn", qn);
		request.setAttribute("type", type);
		request.setAttribute("totalpage",totalpage);
		request.setAttribute("pagesize",ps);
		request.setAttribute("pagenow",pn);
		request.setAttribute("totalsize",totalsize);
		request.setAttribute("newpdList", newpdList);
		log.info("结果"+newpdList);
		
		return "kjs_icbc/index";
	}
	/**
	 * 查询详情
	 * @param c_cardno  身份证号
	 * @return
	 */
	@RequestMapping("/selectdetail")
	public String selectdetail(
			String qn,
			String type,
			String dn,
			String c_cardno,  
			Integer icbc_id,
			HttpServletRequest request
			)throws ParseException{
		//获取登陆信息
		PageData pdLoginSession = (PageData)request.getSession().getAttribute("pd");
		Map<String, Object> grxxMap= trailernotAcceptedService.selectgrxx(icbc_id);
		Map<String, Object> clxxMap= trailernotAcceptedService.selectclxx(icbc_id);
		Map<String, Object> dkfaMap= trailernotAcceptedService.selectdkfa(icbc_id);

			System.out.println("dkfaMap:"+dkfaMap);
			//判断  根据身份证号查询时数据不为空
			if(dkfaMap.get("icbc_id") != null && !dkfaMap.get("icbc_id").equals("")){
			//获取当前欠款
			//本息合计=本金合计*（1+利率）
			//贷款金额
		if(null != dkfaMap.get("dk_total_price")){
			BigDecimal aa=new BigDecimal(dkfaMap.get("dk_total_price").toString());
			//利率
			double lv=(double)dkfaMap.get("dk_lv")/100+1;
			BigDecimal bb=new BigDecimal(String.valueOf(lv));
			//本金*利率  得到本息合计
			BigDecimal bxhj=aa.multiply(bb);//乘法
//			log.info("本息合计------"+bxhj);
			dkfaMap.put("bxhj", bxhj);
		}
			}

		//查询客户逾期期数
		List<Map> scheduleMap = trailernotAcceptedService.selectschedule(icbc_id);
			
		//查询记录栏数据
		List<Map> inputMap = trailernotAcceptedService.selectinput(icbc_id);
		System.out.println("**/*/*/*/*/*/*/"+icbc_id);
		System.out.println("============"+grxxMap);
//		System.out.println("**********"+detailList);
		request.setAttribute("dn",dn);
		request.setAttribute("qn", qn);
		request.setAttribute("type", type); 
		request.setAttribute("grxxMap", grxxMap);
		request.setAttribute("clxxMap", clxxMap);
		request.setAttribute("dkfaMap", dkfaMap);
		request.setAttribute("scheduleMap", scheduleMap);
		request.setAttribute("inputMap", inputMap);
		return "kjs_icbc/index";
		   
	}
	/**
	 * 查询详情
	 * @param c_cardno  身份证号
	 * @return
	 */
	@RequestMapping("/selectdetail1")
	public String selectdetail1(
			String qn,
			String type,
			String dn,
			String c_cardno,  
			Integer icbc_id,
			HttpServletRequest request
			)throws ParseException{
		//获取登陆信息
		PageData pdLoginSession = (PageData)request.getSession().getAttribute("pd");
		Map<String, Object> grxxMap= trailernotAcceptedService.selectgrxx1(icbc_id);
		Map<String, Object> clxxMap= trailernotAcceptedService.selectclxx1(icbc_id);
		Map<String, Object> dkfaMap= trailernotAcceptedService.selectdkfa(icbc_id);
		System.out.println("dkfaMap:"+dkfaMap);
		//判断  根据身份证号查询时数据不为空
		if(dkfaMap.get("icbc_id") != null && !dkfaMap.get("icbc_id").equals("")){
		//获取当前欠款
		//本息合计=本金合计*（1+利率）
		//贷款金额
	if(null != dkfaMap.get("dk_total_price")){
		BigDecimal aa=new BigDecimal(dkfaMap.get("dk_total_price").toString());
		//利率
		double lv=(double)dkfaMap.get("dk_lv")/100+1;
		BigDecimal bb=new BigDecimal(String.valueOf(lv));
		//本金*利率  得到本息合计
		BigDecimal bxhj=aa.multiply(bb);//乘法
//		log.info("本息合计------"+bxhj);
		dkfaMap.put("bxhj", bxhj);
	}
		}
		//查询客户逾期期数
		List<Map> scheduleMap = trailernotAcceptedService.selectschedule1(icbc_id);
			
		//查询记录栏数据
		List<Map> inputMap = trailernotAcceptedService.selectinput1(icbc_id);
		System.out.println("**/*/*/*/*/*/*/"+icbc_id);
		System.out.println("============"+grxxMap);
//		System.out.println("**********"+detailList);
		request.setAttribute("dn",dn);
		request.setAttribute("qn", qn);
		request.setAttribute("type", type); 
		request.setAttribute("grxxMap", grxxMap);
		request.setAttribute("clxxMap", clxxMap);
		request.setAttribute("dkfaMap", dkfaMap);
		request.setAttribute("scheduleMap", scheduleMap);
		request.setAttribute("inputMap", inputMap);
		return "kjs_icbc/index";
		   
	}
	/**
	 * 查询详情
	 * @param c_cardno  身份证号
	 * @return
	 */
	@RequestMapping("/selectdetail2")
	public String selectdetail2(
			String qn,
			String type,
			String dn,
			String c_cardno,  
			Integer icbc_id,
			HttpServletRequest request
			)throws ParseException{
		//获取登陆信息
		PageData pdLoginSession = (PageData)request.getSession().getAttribute("pd");
		Map<String, Object> grxxMap= trailernotAcceptedService.selectgrxx2(icbc_id);
		Map<String, Object> clxxMap= trailernotAcceptedService.selectclxx2(icbc_id);
		Map<String, Object> dkfaMap= trailernotAcceptedService.selectdkfa(icbc_id);
		System.out.println("dkfaMap:"+dkfaMap);
		//判断  根据身份证号查询时数据不为空
		if(dkfaMap.get("icbc_id") != null && !dkfaMap.get("icbc_id").equals("")){
		//获取当前欠款
		//本息合计=本金合计*（1+利率）
		//贷款金额
	if(null != dkfaMap.get("dk_total_price")){
		BigDecimal aa=new BigDecimal(dkfaMap.get("dk_total_price").toString());
		//利率
		double lv=(double)dkfaMap.get("dk_lv")/100+1;
		BigDecimal bb=new BigDecimal(String.valueOf(lv));
		//本金*利率  得到本息合计
		BigDecimal bxhj=aa.multiply(bb);//乘法
//		log.info("本息合计------"+bxhj);
		dkfaMap.put("bxhj", bxhj);
	}
		}
		//查询客户逾期期数
		List<Map> scheduleMap = trailernotAcceptedService.selectschedule2(icbc_id);
			
		//查询记录栏数据
		List<Map> inputMap = trailernotAcceptedService.selectinput2(icbc_id);
		System.out.println("**/*/*/*/*/*/*/"+icbc_id);
		System.out.println("============"+grxxMap);
//		System.out.println("**********"+detailList);
		request.setAttribute("dn",dn);
		request.setAttribute("qn", qn);
		request.setAttribute("type", type); 
		request.setAttribute("grxxMap", grxxMap);
		request.setAttribute("clxxMap", clxxMap);
		request.setAttribute("dkfaMap", dkfaMap);
		request.setAttribute("scheduleMap", scheduleMap);
		request.setAttribute("inputMap", inputMap);
		return "kjs_icbc/index";
		   
	}
	
	
	/**
	 * 添加数据到表中
	 * @param map
	 * @return
	 */
	@RequestMapping("/add")
	@Transactional
	public String add(
			String c_cardno,
			String qn,
			String cn,
			String type,
			String dn,
			String value,
			
			HttpServletRequest request,
			Integer icbc_id,	
			HttpServletResponse response) throws IOException,ParseException{
		
		//获取登陆信息
		PageData pdLoginSession = (PageData)request.getSession().getAttribute("pd");

		
		//添加录入数据到表中
		Map<String, Object> map=new HashMap<>();
		map.put("value", value);
		
		//获取客户姓名和身份证号
		Map<String,Object> naMap = trailernotAcceptedService.selectgrxx(icbc_id);
		map.put("operator", pdLoginSession.get("name"));
		map.put("icbc_id", icbc_id);
		map.put("oc_name", naMap.get("c_name"));
		map.put("id_card", naMap.get("c_cardno"));
		trailernotAcceptedService.addTc1(map);
		trailernotAcceptedService.updateTcStatus(icbc_id);
				
		request.setAttribute("dn",dn);
		request.setAttribute("cn", cn);
		request.setAttribute("qn", qn);
		request.setAttribute("type", type);
		return "kjs_icbc/index";
	}
	/**
	 * 添加数据到表中   上传文件
	 * @param map
	 * @throws Exception 
	 */
	@RequestMapping("/add1.do")
	@ResponseBody
	@Transactional
	public String add1(
			String qn,
			String cn,
			String type,
			String dn,
			String value,
			String c_cardno,
			HttpServletRequest request,
			Integer icbc_id,	
//			HttpServletResponse response,
			
			@RequestParam(value = "add_video", required = false) MultipartFile file
			) throws Exception{
		
		System.out.println(file);

		//获取登陆信息
		PageData pdLoginSession = (PageData)request.getSession().getAttribute("pd");		
		
		//添加录入数据到表中
		Map<String, Object> map=new HashMap<>();
		map.put("value", request.getParameter("value"));
		map.put("add_time",request.getParameter("add_time"));
		map.put("add_address",request.getParameter("add_address"));
		
		String headImg=null;//保存文件名
		if(file != null && !file.isEmpty()){
			headImg = file.getOriginalFilename();
			System.out.println("文件名"+headImg);
			//构建上传目录及文件对象，不存在则自动创建
			Date date=new Date();
			String filePath="/KCDIMG/assess/upload/"+new SimpleDateFormat("yyyy/MM/dd/").format(date);
			String path=request.getSession().getServletContext().getRealPath(filePath);
		    File fileDir = new File(path);  
		    if (!fileDir.exists()) { //如果不存在 则创建   
		        fileDir.mkdirs();  
		    }  
			
			File imgFile=new File(path,headImg);
			System.out.println("===================="+imgFile);
			map.put("add_video", headImg);
			//保存文件
			try {
				file.transferTo(imgFile);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}

		//获取客户姓名和身份证号
		Map<String,Object> naMap = trailernotAcceptedService.selectgrxx1(icbc_id);
		map.put("operator", pdLoginSession.get("name"));
		map.put("icbc_id", icbc_id);
		map.put("oc_name", naMap.get("c_name"));
		map.put("id_card", naMap.get("c_cardno"));
		trailernotAcceptedService.addTc2(map);
		trailernotAcceptedService.updateTcStatus1(icbc_id);

		
		request.setAttribute("dn",request.getParameter("dn"));
		request.setAttribute("cn", request.getParameter("cn"));
		request.setAttribute("qn", request.getParameter("qn"));
		request.setAttribute("type", request.getParameter("type"));
		return "success";
	}
	private ServletRequest getServletContext() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 添加数据到表中
	 * @param map
	 * @return
	 */
	@RequestMapping("/add2")
	@Transactional
	public String add2(
			String c_cardno,
			String qn,
			String cn,
			String type,
			String dn,
			String value,
			HttpServletRequest request,
			Integer icbc_id,	
			HttpServletResponse response) throws IOException,ParseException{

		//获取登陆信息
		PageData pdLoginSession = (PageData)request.getSession().getAttribute("pd");
		//添加录入数据到表中
		Map<String, Object> map=new HashMap<>();
		map.put("value", value);
		//获取客户姓名和身份证号
		Map<String,Object> naMap = trailernotAcceptedService.selectgrxx2(icbc_id);
		map.put("operator", pdLoginSession.get("name"));
		map.put("icbc_id", icbc_id);
		map.put("oc_name", naMap.get("c_name"));
		map.put("id_card", naMap.get("c_cardno"));
		trailernotAcceptedService.addTc3(map);
//		trailernotAcceptedService.updateTcStatus(icbc_id);

		
		request.setAttribute("dn",dn);
		request.setAttribute("cn", cn);
		request.setAttribute("qn", qn);
		request.setAttribute("type", type);
		return "kjs_icbc/index";
	}
	
	/**
	 * 通过id查询表中数据
	 * @param id
	 * @return
	 */
	@RequestMapping("/selectrecord")
	@ResponseBody
	public Map selectrecord(
			Integer id,
			HttpServletRequest request){
		
		Map<String, Object> recordMap=trailernotAcceptedService.selectrecord(id);
		
		return recordMap;
	}
	/**
	 * 通过id查询表中数据
	 * @param id
	 * @return
	 */
	@RequestMapping("/selectrecord1")
	@ResponseBody
	public Map selectrecord1(
			Integer id,
			HttpServletRequest request){
		
		Map<String, Object> recordMap=trailernotAcceptedService.selectrecord1(id);
		
		return recordMap;
	}
	/**
	 * 通过id查询表中数据
	 * @param id
	 * @return
	 */
	@RequestMapping("/selectrecord2")
	@ResponseBody
	public Map selectrecord2(
			Integer id,
			HttpServletRequest request){
		
		Map<String, Object> recordMap=trailernotAcceptedService.selectrecord2(id);
		
		return recordMap;
	}

	private void requestParams(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}
	
}
