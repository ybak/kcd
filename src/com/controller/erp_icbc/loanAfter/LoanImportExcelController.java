package com.controller.erp_icbc.loanAfter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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
		{ "name", "id_card", "repayment_card","balance_card", "overdue_amount", "continuity", "maximum","add_time", "balance_on","practical_date","overdue_days"};

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
					int lastCellNum = row.getPhysicalNumberOfCells();
					String[] cells = new String[row.getPhysicalNumberOfCells()];
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
					int overdue_amount = rowMap.getInt("overdue_amount");//获取excel表格中的逾期金额
					PageData icbcInfo = new PageData();
					icbcInfo.put("c_cardno", rowMap.getString("id_card"));
					PageData getIcbcInfo = new PageData();
					getIcbcInfo = AboutExcelService.icbcInfo(icbcInfo); //根据excel表格里面身份证号获取用户信息
					if(overdue_amount>0){ //excel表格里面的数据  证明客户逾期
						PageData addOverdueClient = new PageData();
						addOverdueClient.put("mid_add",pdsession.getInt("id"));
						addOverdueClient.put("mid_edit",pdsession.getInt("id") );
						addOverdueClient.put("type_id",LoanModel.LoanTypeModel().get("逾期")); //???
						addOverdueClient.put("type_status",LoanModel.LoanTypeModel().get("初级逾期") );//???
						addOverdueClient.put("icbc_id",getIcbcInfo.get("icbc_id"));
						addOverdueClient.put("gems_id",getIcbcInfo.get("gems_id") );
						addOverdueClient.put("gems_fs_id",getIcbcInfo.get("gems_fs_id"));
						addOverdueClient.put("c_name",getIcbcInfo.get("c_name") != null?getIcbcInfo.getString("c_name"):null );
						addOverdueClient.put("c_cardno",getIcbcInfo.get("c_cardno") != null?getIcbcInfo.getString("c_cardno"):null );
						addOverdueClient.put("c_carno",getIcbcInfo.get("c_carno") != null?getIcbcInfo.getString("c_carno"):null );
						addOverdueClient.put("c_carvin",getIcbcInfo.getString("c_carvin") != null?getIcbcInfo.getString("c_carvin"):null);
						addOverdueClient.put("overdue_amount",overdue_amount); //逾期金额
						addOverdueClient.put("overdue_days",rowMap.getString("overdue_days")); //逾期天数
						AboutExcelService.addOverdueClient(addOverdueClient);
					}
					//2.修改还款计划表里面还款数据
					PageData upPay = new PageData();
					upPay.put("dt_edit", TimeStyle.sdfYMDHMS);
					upPay.put("practical_date",rowMap.getString("practical_date"));
					upPay.put("practical_money",rowMap.getString("practical_money"));
					upPay.put("overdue_status",overdue_amount>0 ? 1:2);//1为逾期  2为正常
					upPay.put("overdue_money", rowMap.getString("overdue_amount"));
					upPay.put("overdue_days", rowMap.getString("overdue_days"));
					upPay.put("c_bank_card",rowMap.getString("repayment_card"));
					upPay.put("c_cardno", rowMap.getString("id_card"));
					upPay.put("icbc_id", getIcbcInfo.get("icbc_id"));
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
		map.put("dt_add", TimeStyle.sdfYMDHMS);// 导入时间
		map.put("financial_products", "");
		map.put("filepath", "upload/" + relatDir1 + oriName);
		map.put("mid_add", pdsession.getString("id"));// 获取操作人员
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
}
