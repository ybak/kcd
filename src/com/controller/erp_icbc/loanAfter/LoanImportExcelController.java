package com.controller.erp_icbc.loanAfter;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.Repayment.controller.RepaymenttestController;
import com.controller.Excel.UploadExcelController;
import com.model1.icbc.erp.PageData;
import com.service1.Excel.recordService;
import com.service1.loan.AboutExcelService;
import com.util.limitutil;
import com.util.Excel.CommonUtil;
import com.util.newAdd.TimeStyle;
/**
 * 操作excel表格控制器
 * 
 * @author 三十画生
 * 2019-3-16
 */
@Controller
@RequestMapping("/loan")
public class LoanImportExcelController {
	private static Logger log = LogManager.getLogger(UploadExcelController.class.getName());
	private Logger logger = Logger.getLogger(UploadExcelController.class);
	private final String xls = "xls";
	private final String xlsx = "xlsx";
	//excel表格 客户姓名 身份证号 还款卡号 卡余额 逾期金额 连续违约次数 最大违约次数 导入日期 在保余额 +还款日期 +逾期时间
	private static String[] ss = 
		{ "name", "id_card", "repayment_card","balance_card", "overdue_amount", "continuity", "maximum","add_time", "balance_on", "practical_date", "overdue_days"};

	@Autowired
	private AboutExcelService AboutExcelService;
	/**
	 * 读入excel文件，解析后返回
	 * 
	 * 
	 */
	@RequestMapping(value="/readExcel.do",method=RequestMethod.POST)
	@ResponseBody
	public Map readExcel(String id_card, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest.getFile("file");
		String relatDir1 = new SimpleDateFormat("yyyy/MM/dd/").format(new Date());
		// 文件夹不存在则创建
		File fdir = new File("/KCDIMG/assess/upload/" + relatDir1);
		if (!fdir.exists()) {
			fdir.mkdirs();
		}
		String oriName = file.getOriginalFilename();
		File tempFile = new File(fdir.getPath() + "/" + oriName);
		log.info("文件保存地址->" + tempFile);
		file.transferTo(tempFile);
		String[] string = new String[4];// 创建ss.length个二维数组，每个数组中有x条数据
		// 检查文件
		checkFile(file);
		// 获得Workbook工作薄对象
		Workbook workbook = getWorkBook(file);
		// 创建返回对象，把每行中的值作为一个数组，所有行作为一个集合返回
		PageData rowMap = new PageData();
		PageData pdsession= (PageData)request.getSession().getAttribute("pd");//获取session信息
		if (workbook != null) {
			for (int sheetNum = 0; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {
				// 查询有几条相同数据
				Integer c = 0;
				// 获得当前sheet工作表
				Sheet sheet = workbook.getSheetAt(sheetNum);
				if (sheet == null) {
					continue;
				}
				// 获得当前sheet的开始行
				int firstRowNum = sheet.getFirstRowNum();
				// 获得当前sheet的结束行
				int lastRowNum = sheet.getLastRowNum();
				// 循环除了第一行的所有行
				for (int rowNum = firstRowNum + 1; rowNum <= lastRowNum; rowNum++) {
					// 获得当前行
					Row row = sheet.getRow(rowNum);
					if (row == null) {
						continue;
					}
					// 获得当前行的开始列
					int firstCellNum = row.getFirstCellNum();
					// 获得当前行的列数
//					int lastCellNum = row.getPhysicalNumberOfCells(); //获取不是空的列
					int lastCellNum = row.getLastCellNum(); //获取全部的列   非空的和空的列
					System.err.println("-------获得当前行的列数-" + lastCellNum); 
//					String[] cells = new String[row.getPhysicalNumberOfCells()]; //获取不是空的列
					String[] cells = new String[row.getLastCellNum()]; //获取全部的列   非空的和空的列
					// 循环当前行
					for (int cellNum = firstCellNum; cellNum < lastCellNum; cellNum++) {
						Cell cell = row.getCell(cellNum);
						cells[cellNum] = getCellValue(cell);
						if (cellNum == 1) {
							System.out.println(cell + "***");
							System.out.println(cells[cellNum] + "***");
							// 查询有几条相同数据
//							c = recordService.count(cells[cellNum]);
							System.out.println("-------" + cell);
						}
						rowMap.put("add_time", relatDir1);
						rowMap.put(ss[cellNum], cells[cellNum]);
					}
					System.out.println(c + "****");
					c = c + 1;
					rowMap.put("repayment_periods", c + "");
					rowMap.put("dt_add",TimeStyle.sdfYMDHMS);
					rowMap.put("dt_edit",TimeStyle.sdfYMDHMS);
					AboutExcelService.excel_to_sql(rowMap); //把excel表格路面的数据录入数据库表loan_import_excels
					//1.把逾期客户添加到逾期表
					double overdue_amount = Double.parseDouble(rowMap.getString("overdue_amount")) ;//获取excel表格中的逾期金额
					PageData icbcInfo = new PageData();
					icbcInfo.put("c_cardno", rowMap.getString("id_card"));
					PageData getIcbcInfo = new PageData();
					getIcbcInfo = AboutExcelService.icbcInfo(icbcInfo); //根据excel表格里面身份证号获取用户信息
					//excel表格里面的数据  证明客户逾期
					if(overdue_amount>0){ 
						PageData addOverdueClient = new PageData();
						addOverdueClient.put("mid_add",pdsession.getInt("id"));
						addOverdueClient.put("mid_edit",pdsession.getInt("id") );
//						addOverdueClient.put("type_id",LoanModel.LoanTypeModel().get("逾期")); //???
//						addOverdueClient.put("type_status",LoanModel.LoanTypeModel().get("初级逾期") );//???
						addOverdueClient.put("type_id","1"); //???  // 1逾期，2电催，3拖车，4诉讼，5拍卖，6结清
						addOverdueClient.put("type_status","11");//???
						addOverdueClient.put("icbc_id",(getIcbcInfo==null?null:getIcbcInfo.get("icbc_id")));
						addOverdueClient.put("gems_id",(getIcbcInfo==null?null:getIcbcInfo.get("gems_id")));
						addOverdueClient.put("gems_fs_id",(getIcbcInfo==null?null:getIcbcInfo.get("gems_fs_id")));
						addOverdueClient.put("imp_name",rowMap.getString("name")); //导入excel表格时的客户名字
						addOverdueClient.put("c_name",(getIcbcInfo==null?null:getIcbcInfo.get("c_name")));
						addOverdueClient.put("c_cardno",(getIcbcInfo==null?null:getIcbcInfo.get("c_cardno")));
						addOverdueClient.put("c_carno",(getIcbcInfo==null?null:getIcbcInfo.get("c_carno")));
						addOverdueClient.put("c_carvin",(getIcbcInfo==null?null:getIcbcInfo.get("c_carvin")));
						addOverdueClient.put("overdue_amount",overdue_amount); //逾期金额
						addOverdueClient.put("overdue_days",rowMap.getString("overdue_days")); //逾期天数
						AboutExcelService.addOverdueClient(addOverdueClient);
					}
					//2.修改还款计划表里面还款数据
					System.err.println(rowMap.getString("practical_date")+"---practical_date");
					System.err.println(rowMap.getString("balance_card")+"---practical_money");
					System.err.println(rowMap.getString("overdue_amount")+"---overdue_amount");
					System.err.println(rowMap.getString("overdue_days")+"---overdue_days");
					System.err.println(rowMap.getString("repayment_card")+"---repayment_card");
					System.err.println(rowMap.getString("id_card")+"---id_card");
					PageData upPay = new PageData();
					upPay.put("dt_edit", TimeStyle.sdfYMDHMS);
					upPay.put("practical_date",rowMap.getString("practical_date"));
					upPay.put("practical_money",rowMap.getString("balance_card"));
					upPay.put("overdue_status",overdue_amount>0 ? 1:2);//1为逾期  2为正常
					upPay.put("overdue_money",rowMap.getString("overdue_amount"));
					upPay.put("overdue_days",rowMap.getString("overdue_days"));
					upPay.put("c_bank_card",rowMap.getString("repayment_card"));
					upPay.put("c_cardno",rowMap.getString("id_card"));
					upPay.put("icbc_id",(getIcbcInfo==null?null:getIcbcInfo.get("icbc_id")));
					AboutExcelService.updatePaySchedule(upPay);
				}
			}
			// workbook.close();
		}

		// 点导入还款查询到逾期客户并添加到数据库
//		List<Map> listOverdue = recordService.selectOverdue(id_card);
//		for (int i = 0; i < listOverdue.size(); i++) {
//			recordService.addOverdue(listOverdue.get(i));
//		}
//		System.out.println("逾期客户" + listOverdue);
		
		PageData map = new PageData();
		map.put("uuid", CommonUtil.getUUID());// 序列号
		map.put("oriName", oriName);// 文件名称
		map.put("dt_add", new Date());// 导入时间
		map.put("financial_products", "");
		map.put("filepath", "upload/" + relatDir1 + oriName);
		map.put("mid_add", pdsession.get("id"));// 获取操作人员
		map.put("mid_name", pdsession.get("name").toString());// 获取操作人员
		map.put("gems_fs_id",pdsession.get("icbc_erp_fsid"));// 公司ID
		map.put("gems_id", pdsession.get("gemsid"));// 公司人员ID
		map.put("fsname", pdsession.getString("fsname"));// 公司名字
		AboutExcelService.addExcelRecord(map); //添加excel导入文件记录
//		repaymenttest.selectImport(); //修改客户还款计划里面的还款记录
		Map result = new HashMap();
		result.put("msg", "导入成功");
		result.put("code", "1");
		return result;
	}

	//查询修改还款记录
//		public void selectImport(){
//			List<Map> repayMap = repaymentService.selectimport();
//			Map<String, Object> map=new HashMap<>();
//			for(int i=0;i<repayMap.size();i++){
//				map.put("practical_money", Math.round((double) repayMap.get(i).get("balance_card")*100)/100.00);
//				map.put("overdue_money", Math.round((double) repayMap.get(i).get("overdue_amount")*100)/100.00);
//				map.put("practical_date", repayMap.get(i).get("add_time"));
//				map.put("cardno", repayMap.get(i).get("id_card"));
//				if(Math.round((double) repayMap.get(i).get("overdue_amount")) != 0){
//					map.put("overdue", 1);
//				}else{
//					map.put("overdue", 0);
//				}
//				repaymentService.updateschedule(map);
//			}
//			
//
//		}
	
	public void checkFile(MultipartFile file) throws IOException {
		// 判断文件是否存在
		if (null == file) {
			logger.error("文件不存在！");
			throw new FileNotFoundException("文件不存在！");
		}
		// 获得文件名
		String fileName = file.getOriginalFilename();
		// 判断文件是否是excel文件
		if (!fileName.endsWith(xls) && !fileName.endsWith(xlsx)) {
			logger.error(fileName + "不是excel文件");
			throw new IOException(fileName + "不是excel文件");
		}
	}

	public Workbook getWorkBook(MultipartFile file) {
		// 获得文件名
		String fileName = file.getOriginalFilename();
		// 创建Workbook工作薄对象，表示整个excel
		Workbook workbook = null;
		try {
			// 获取excel文件的io流
			InputStream is = file.getInputStream();
			// 根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象
			if (fileName.endsWith(xls)) {
				// 2003
				workbook = new HSSFWorkbook(is);
			} else if (fileName.endsWith(xlsx)) {
				// 2007
				workbook = new XSSFWorkbook(is);
			}
		} catch (IOException e) {
			logger.info(e.getMessage());
		}
		return workbook;
	}

	public String getCellValue(Cell cell) {
		String cellValue = "";
		if (cell == null) {
			return cellValue;
		}
		// 把数字当成String来读，避免出现1读成1.0的情况
		if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			cell.setCellType(Cell.CELL_TYPE_STRING);
		}
		// 判断数据的类型
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_NUMERIC: // 数字
			cellValue = String.valueOf(cell.getNumericCellValue());
			break;
		case Cell.CELL_TYPE_STRING: // 字符串
			cellValue = String.valueOf(cell.getStringCellValue());
			break;
		case Cell.CELL_TYPE_BOOLEAN: // Boolean
			cellValue = String.valueOf(cell.getBooleanCellValue());
			break;
		case Cell.CELL_TYPE_FORMULA: // 公式
			cellValue = String.valueOf(cell.getCellFormula());
			break;
		case Cell.CELL_TYPE_BLANK: // 空值
			cellValue = "";
			break;
		case Cell.CELL_TYPE_ERROR: // 故障
			cellValue = "非法字符";
			break;
		default:
			cellValue = "未知类型";
			break;
		}
		return cellValue;
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "/downloadOneFile.do")
	public void downloadFile(String fileUrl, String fileName,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String pString = fileUrl.substring(fileUrl.lastIndexOf("."));
		response.setContentType("text/html;charset=UTF-8");
		BufferedInputStream in = null;
		BufferedOutputStream out = null;
		URL url = new URL(fileUrl);
		HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
		urlCon.setConnectTimeout(6000);
		urlCon.setReadTimeout(6000);
		int code = urlCon.getResponseCode();
		if (code != HttpURLConnection.HTTP_OK) {
			throw new Exception("文件读取失败");
		}
		try {
			response.setContentType("multipart/form-data");
			response.setCharacterEncoding("UTF-8");
			response.setHeader("Content-Disposition", "attachment; filename="+java.net.URLEncoder.encode(fileName,"UTF-8"));
			response.setHeader("Content-Length",String.valueOf(urlCon.getContentLength()));
			in = new BufferedInputStream(urlCon.getInputStream());
			out = new BufferedOutputStream(response.getOutputStream());
			byte[] data = new byte[1024];
			int len = 0;
			while (-1 != (len = in.read(data, 0, data.length))) {
				out.write(data, 0, len);
			}
			System.out.println("下载成功");
		} catch (Exception e) {
			e.printStackTrace();
			response.reset();
			try {
				OutputStreamWriter writer = new OutputStreamWriter(
						response.getOutputStream(), "UTF-8");
				String data = "<script language='javascript'>alert(\"\\u64cd\\u4f5c\\u5f02\\u5e38\\uff01\");</script>";
				writer.write(data);
				writer.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.flush();
				out.close();
			}
		}
	}
	
	
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
