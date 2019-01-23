package com.util.sxx.financialExcel.controller;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

import freemarker.template.utility.StringUtil;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import net.sf.json.JSONObject;

public class ExportOperationsExcel {
	
//		//表2的二级标题名称
//		static String[] Lev2HeaderName2 = {"序号", "合作机构名称", "级别", "电审通过量", "主贷人征信通过量", "实际征信转化率", "考核指标", "主贷人征信超标数量", "罚款标准", "应罚款金额"
//				, "减免金额", "应罚款金额总计", "备注（减免原因）"};
//		//表3-4的二级标题名称
//		static String[] Lev2HeaderName3 = {"序号", "合作机构名称", "级别", "订单号", "客户姓名", "联系电话", "合同本息合计", "考核标准"};
//		//表5-7的二级标题名称
//		static String[] Lev2HeaderName5 = {"序号", "合作机构名称", "级别", "订单号", "客户姓名", "联系电话", "合同本息合计", "剩余合同本息", "考核标准", "抵押保证金"};
//		//表8的二级标题名称
//		static String[] Lev2HeaderName8 = {"序号", "合作机构名称", "级别", "银行放款订单数量", "银行放款订单金额", "对应执行奖励方案", "奖励金额"};
//		//表9的二级标题名称
//		static String[] Lev2HeaderName9 = {"序号", "合作机构名称", "级别", "订单号", "客户姓名", "联系电话", "支付购车分期本金时间", "支付购车分期本金金额", "是否已提交提车材料"
//				, "打回购车分期本金时间", "超期天数（有超过5的暂停查询征信）", "计息标准/1-2天", "计息标准/第3天起", "计收垫款利息1", "是否已寄出材料", "纸质材料寄出时间", "超期天数"
//				, "计息标准/1-2天", "计息标准/第3天起", "计收垫款利息2", "银行提出问题时间", "合作机构是否已解决问题", "合作机构解决问题的时间", "解决问题超期天数", "计息标准/1-2天"
//				, "计息标准/第3天起", "计收垫款利息3", "是否退单", "合作机构申请退单时间", "合作机构是否已打回垫款", "收到合作机构打回垫款时间", "超期天数", "计息标准/1-2天"
//				, "计息标准/第3天起", "计收垫款利息4", "计收垫款利息合计"};
		
		//获取WritableWorkbook
			public static WritableWorkbook GetFile(String adress){
				File file = new File(adress);
				 WritableWorkbook wk = null;
				try {
					wk = Workbook.createWorkbook(file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println(111);
					e.printStackTrace();
				}
				return wk;
			}
		
				
		/**
		 * 创建表，并调用设置表格式的方法			-----生成非查询字段的表格以及插入数据
		 * @param list1		表中时间以外的客户基本信息
		 * @param list2 	表中的大部分时间数据
		 * @param list3		首期还款日
		 * @return
		 * @throws Exception
		 */
		public static void CreateExcel(List<Map> list1, List<Map> list2, List<Map> list3) throws Exception{
			
		    WritableWorkbook wk = ExportOperationsExcel.GetFile("D://运营管理数据库_2018-12-20_数据版.xlsx");
		    
		    //1.创建表
		    WritableSheet sheet1 = wk.createSheet("表1-业务台账",0);
//		    WritableSheet sheet2 = wk.createSheet("表2-征信转化率考核台账",0);
//		    WritableSheet sheet3 = wk.createSheet("表3-总部寄出材料10天后未办妥订单—超期预警",0);
//		    WritableSheet sheet4 = wk.createSheet("表4-银行放款20天后未办妥订单—超期预警",0);
//		    WritableSheet sheet5 = wk.createSheet("表5-总部寄出材料15天后未办妥订单—收取10%抵押保证金",0);
//		    WritableSheet sheet6 = wk.createSheet("表6-银行放款30天后未办妥订单—收取10%抵押保证金",0);
//		    WritableSheet sheet7 = wk.createSheet("表7-银行放款45天后未办妥订单—收取100%抵押保证金",0);
//		    WritableSheet sheet8 = wk.createSheet("表8-奖励台账",0);
//		    WritableSheet sheet9 = wk.createSheet("表9-晚交材料考核台账",0);
	
		    //应用各表的格式
		    ExportOperationsExcel.SetSheet1Layout(sheet1);
//		    ExportOperationsExcel.SetSheet2Layout(sheet2, 12, "表2-201X年X月征信转化率考核表", Lev2HeaderName2);
//		    ExportOperationsExcel.SetSheet2Layout(sheet3, 7, "总部寄出材料10天后未办妥订单—超期预警", Lev2HeaderName3);
//		    ExportOperationsExcel.SetSheet2Layout(sheet4, 7, "银行放款20天后未办妥订单—超期预警", Lev2HeaderName3);
//		    ExportOperationsExcel.SetSheet2Layout(sheet5, 9, "总部寄出材料15天后未办妥订单—收取10%抵押保证金", Lev2HeaderName5);
//		    ExportOperationsExcel.SetSheet2Layout(sheet6, 9, "银行放款30天后未办妥订单—收取10%抵押保证金", Lev2HeaderName5);
//		    ExportOperationsExcel.SetSheet2Layout(sheet7, 9, "银行放款45天后未办妥订单—收取100%抵押保证金", Lev2HeaderName5);
//		    ExportOperationsExcel.SetSheet2Layout(sheet8, 6, "表8-201×年×月×日业务奖励台账", Lev2HeaderName8);
//		    ExportOperationsExcel.SetSheet2Layout(sheet9, 35, "晚交材料考核台账", Lev2HeaderName9);

		    //向表中添加数据
		    ExportOperationsExcel.InsertData(list1, list2, list3, sheet1);
		    
		    
			//将定义的工作表输出到之前指定的介质中(这里是客户端浏览器)
			wk.write();
			//操作完成时，关闭对象，释放占用的内存空间   
			wk.close();
			System.out.println("写入成功"); 
		}
		
		/**
		 * 创建表，并调用设置表格式的方法			-----生成查询字段的表格以及插入数据
		 * @param fieldName				-----用来存放数据库字段名
		 * @param lev2MenuName			-----获取到用户选择的三级菜单的上级也就是二级菜单在集合中的位置
		 * @param lev3MenuName			-----获取到用户选择的三级菜单在集合中的位置
		 * @throws Exception
		 */
		public static void CreateExcel(List<String> fieldName, List<Integer> lev2MenuName, List<Integer> lev3MenuName, List<Map> data) throws Exception{
			
		    WritableWorkbook wk = ExportOperationsExcel.GetFile("D://运营管理数据库_2018-12-20_数据版.xlsx");
		    
		    //1.创建表
		    WritableSheet sheet1 = wk.createSheet("表1-业务台账",0);
	
		    //应用各表的格式
		    ExportOperationsExcel.SetSheet1Layout(sheet1, fieldName, lev2MenuName, lev3MenuName, data);
		    
//		    //向表中添加数据
//		    ExportOperationsExcel.InsertData(list2, sheet1);
		    
			//将定义的工作表输出到之前指定的介质中(这里是客户端浏览器)
			wk.write();
			//操作完成时，关闭对象，释放占用的内存空间   
			wk.close();
			System.out.println("写入成功"); 
		}
		
		//取得list2和list3中每条数据的idcbc_id值，用以判断list2和list3中是否存在当前插入的这一行用户的时间数据
		private static List<Integer> GetIcbcidList(List<Map> list){
			List<Integer> icbcid = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				icbcid.add((Integer) list.get(i).get("icbc_id"));
			}
			return icbcid;
		}
		
		/**
		 * 向表中插入数据			-----向非查询字段的表格插入数据
		 * @param list
		 * @throws WriteException 
		 * @throws RowsExceededException 
		 */
		private static void InsertData(List<Map> list1, List<Map> list2, List<Map> list3, WritableSheet sheet) throws RowsExceededException, WriteException{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
			//取得list2中每条数据的idcbc_id值，用以判断list2中是否存在当前插入的这一行用户的时间数据
			List<Integer> icbcid = ExportOperationsExcel.GetIcbcidList(list2);
			
			//循环插入行
			for (int i = 0; i < list1.size(); i++) {
				//取得list1中每一条数据所在的map
				Map map = list1.get(i);
				
				float a = 0;	//分期本金合计
				float b = 0;	//合同本息合计
				/** 1. 添加表中需要的除了各种时间以外的数据*/
				//定义excel表格对应的数据库字段名，用以key取得数据 		----其中的“1”作用只为占一列
				String[] keys = {"dt_add", "gems_code", "y_name", "loan_tpid", "a_name", "loan_level", "s_name", "s_c_name", "1", "c_name", "c_tel", "c_cardno"
						, "cars_type", "cars_name", "cse_name", "cm_name", "sp_name", "kk_loan_amount", "kk_loan_amount_s", "kk_loan_ajqx", "kk_loan_rate", "fk_status"};
					 
					 sheet.addCell(new Label(0, i+3, String.valueOf(i+1)));						//序号
					 sheet.addCell(new Label(1, i+3, sdf.format(map.get(keys[0]))));			//订单提交时间
					 //循环添加订单编号列到车辆类型列
					 for (int j = 0; j < 12; j++) {
						 if(null!=map.get(keys[j+1])){
							 //当添加到产品名称的这一列的时候  根据产品id手动插入产品名称
							 if(j == 2){
								 if((int)map.get("loan_tpid") == 1){
									 sheet.addCell(new Label(4, i+3, "卡分期"));
								 }
								 continue;
							 }
							 //当添加到级别这一列的时候手动添加级别信息
							 if(j == 4){
								/* if((int)map.get("loan_level") == 1){
									 sheet.addCell(new Label(j+2, i+3, "<=10W"));
								 } else if((int)map.get("loan_level") == 2){
									 sheet.addCell(new Label(j+2, i+3, "10W以上"));
								 }*/
								 continue;
							 }
							 //当添加到车辆类型这一列的时候判断车辆类型信息
							 if(j == 11){
								 if((int)map.get("cars_type") == 1){
									 sheet.addCell(new Label(j+2, i+3, "新车"));
								 } else if((int)map.get("cars_type") == 2){ 
									 sheet.addCell(new Label(j+2, i+3, "二手车"));
								 }
								 break;
							 }
							 if(j == 7){
								 continue;
							 }	 
						 
							 sheet.addCell(new Label(j+2, i+3, map.get(keys[j+1]).toString()));		//订单编号列到车辆类型列     ----由于数据中不存在这几列其中的"区域经理"列  所以跳出第七次循环
						 }
					}
					 if (null!=map.get(keys[13]) && null!=map.get(keys[14]) && null!=map.get(keys[15])) {
						 String carsData = map.get(keys[13]).toString() + map.get(keys[14]).toString() + map.get(keys[15]).toString();
						 sheet.addCell(new Label(14, i+3, carsData ));			//车辆品牌型号
					 }
					 if(null!=map.get(keys[16])){
						 sheet.addCell(new Label(15, i+3, map.get(keys[16]).toString() ));			//上牌城市
					 }
					 if(null!=map.get(keys[17])){
						 sheet.addCell(new Label(16, i+3, String.valueOf((float)map.get(keys[17])*10000)) );			//购车分期本金
					 }
					 if(null!=map.get(keys[18])){
						 sheet.addCell(new Label(17, i+3, map.get(keys[18]).toString() ));			//金融服务费分期本金
					 }
					 if(null!=map.get(keys[17]) && null!=map.get(keys[18])){
						 a = (float)map.get(keys[17])*10000 + (int)map.get(keys[18]);
						 sheet.addCell( new Label(18, i+3, String.valueOf(a)) );					//分期本金合计
					 }
					 if(null!=map.get(keys[19])){
						 sheet.addCell(new Label(19, i+3, map.get(keys[19]).toString() ));			//分期期限/月
					 }
					 if(null!=map.get(keys[20])){
						 sheet.addCell(new Label(20, i+3, map.get(keys[20]).toString() ));			//执行银行利率
						//合同本息合计
						 b = ((float)map.get(keys[20])/100 + 1);
					 }
					 BigDecimal b1 = new BigDecimal(String.valueOf(b));
					 BigDecimal b2 = new BigDecimal(String.valueOf(a));
					 BigDecimal bd = b1.multiply(b2);
					 sheet.addCell(new Label(21, i+3, String.valueOf(bd) ));					//合同本息合计
					 //客户月还款金额
					 BigDecimal c = new BigDecimal("0");
					 if (0!=(int)map.get(keys[19]) && StringUtils.isEmpty(map.get(keys[19]))) {
						BigDecimal c1 = new BigDecimal(String.valueOf(map.get(keys[19])));
						c = bd.divide(c1 , 5, RoundingMode.HALF_UP);
					 }
					 sheet.addCell( new Label(21, i+3, String.valueOf(c)) );					//客户月还款金额
					 if(null!=map.get(keys[21])){
						 sheet.addCell(new Label(24, i+3, map.get(keys[21]).toString() ));			//是否垫资
					 }
					 
					 /** 2. 添加表中需要的各种时间数据*/
					 //判断list2中是否存在当前客户的信息
					 if ( icbcid.contains(map.get("id")) ) {
						 //遍历取得该客户在数组中出现的次数
						 int count = 0;
							for (int j = 0; j < icbcid.size(); j++) {
//								System.out.println(icbcid.get(j) == (int)map.get("id"));
								if(icbcid.get(j) == (int)map.get("id")){
									count = count+1;
								}
							}
						 //根据该客户在list2中出现的次数，循环插入
						 for (int j = 0; j < count; j++) {
							 //取得当前客户每次出现的status值
							 switch((int)list2.get(icbcid.indexOf(map.get("id"))+j).get("status")){ 
							 case 57:
								 //插入数据
								 sheet.addCell(new Label(31, i+3, list2.get(icbcid.indexOf(map.get("id"))+j).get("dt_add").toString() ));
								 break;
								 
							 case 61:
								 sheet.addCell(new Label(37, i+3, list2.get(icbcid.indexOf(map.get("id"))+j).get("dt_add").toString() ));
								 break;
			
							 case 62:
								 sheet.addCell(new Label(36, i+3, list2.get(icbcid.indexOf(map.get("id"))+j).get("dt_add").toString() ));
								 break;
								 
							 case 97:
								 sheet.addCell(new Label(35, i+3, list2.get(icbcid.indexOf(map.get("id"))+j).get("dt_add").toString() ));
								 break;
							 
							 case 74:
								 sheet.addCell(new Label(39, i+3, list2.get(icbcid.indexOf(map.get("id"))+j).get("dt_add").toString() ));
								 break;
								 
							 case 80:
								 sheet.addCell(new Label(41, i+3, list2.get(icbcid.indexOf(map.get("id"))+j).get("dt_add").toString() ));
								 break;
								 
							 case 77:
								 sheet.addCell(new Label(40, i+3, list2.get(icbcid.indexOf(map.get("id"))+j).get("dt_add").toString() ));
								 break;
							 }
							
						 }
				
					 }
					 	 
					 /** 3. 插入首期还款日*/
					//取得list2中每条数据的idcbc_id值，用以判断list2中是否存在当前插入的这一行用户的时间数据
					List<Integer> icbcid2 = ExportOperationsExcel.GetIcbcidList(list3);
					//判断list3中是否存在当前客户的信息
					if ( icbcid2.contains(map.get("id")) ) {
						//根据客户id在icbcid2集合中的位置取到该客户在list3集合中的json数据 并且转为map数组
						JSONObject jb = JSONObject.fromObject(list3.get( icbcid2.indexOf(map.get("id")) ).get("result_1_value"));
						Map<String, Object> data = (Map<String, Object>)jb;
						
						sheet.addCell(new Label(38, i+3, data.get("61_sqhkr").toString() ));
					}
					
	        } 
		}
		
		
		//设置一级标题字体格式
		public static WritableCellFormat SetLev1HeaderFontFormat() throws WriteException{
			//创建WritableCellFormat对象，将该对象应用于单元格从而设置单元格的样式
			WritableCellFormat OnetitleFormat = new WritableCellFormat();
			//设置字体格式    参数依次表示黑体、字号12、粗体、非斜体、不带下划线、亮蓝色
			OnetitleFormat.setFont(new WritableFont(WritableFont.createFont("微软雅黑"), 10, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK));
			//设置文本垂直居中对齐
			OnetitleFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
			//设置自动换行
			OnetitleFormat.setWrap(true);
			//设置边框
			OnetitleFormat.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
			
			return OnetitleFormat;
		}
		
		
		/**
		 * 设置表1的格式			-----设置非查询字段表的格式
		 * @param sheet
		 * @throws WriteException 
		 * @throws RowsExceededException 
		 */
		public static void SetSheet1Layout(WritableSheet sheet) throws RowsExceededException, WriteException{
			
			//合并单元格
		    sheet.mergeCells(0, 0, 55, 0);
		    
		    int[] cs = {1, 5, 10, 13, 16, 24, 29, 37, 39, 42, 45, 49};
		    int[] rs = {4, 8, 12, 15, 23, 28, 36, 38, 41, 44, 48, 55};
		    for(int i=0;i<cs.length;i++){
		    	sheet.mergeCells(cs[i], 1, rs[i], 1);
		    }
		    
		    //设置一级标题字体格式
			ExportOperationsExcel.SetLev1HeaderFontFormat();
			//设置一级标题的行高
			sheet.setRowView(0, 500);
			//添加一级标题
			Label lab_1 = new Label(0, 0, "购车分期业务运营管理数据表1-业务台账", ExportOperationsExcel.SetLev1HeaderFontFormat());
			sheet.addCell(lab_1);
		 
			//设置二级标题的行高
			sheet.setRowView(1, 550);
			//设置二级标题
			WritableCellFormat TwoTitleFormat = new WritableCellFormat();
			TwoTitleFormat.setFont(new WritableFont(WritableFont.createFont("微软雅黑"),10,WritableFont.BOLD));
			TwoTitleFormat.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
			//设置文本水平居中对齐
			TwoTitleFormat.setAlignment(Alignment.CENTRE);
			//设置文本垂直居中对齐
			TwoTitleFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
			
			String[]  Lev2HeaderFontName = {"基础订单信息", "合作机构信息", "特殊", "客户信息", "车辆信息", "贷款信息", "垫资款收付信息", "客户及合同材料管理信息", "银行放款信息", "抵押材料归档信息"
											, "上级机构费用", "收上级机构款项信息", "支付合作机构款项信息"};
			int[] Lev2HerderFontNameBegin = {1, 5, 9, 10, 13, 16, 24, 29, 37, 39, 42, 45, 49};
			
			for (int i = 0; i < Lev2HeaderFontName.length; i++) {
				Label lable = new Label(Lev2HerderFontNameBegin[i], 1, Lev2HeaderFontName[i], TwoTitleFormat);
				sheet.addCell(lable);
			}
			
			//设置三级标题的行高
			sheet.setRowView(2, 700);
			//设置三级标题的格式
			WritableCellFormat ThreeTitleFormat = new WritableCellFormat();
			ThreeTitleFormat.setFont(new WritableFont(WritableFont.createFont("微软雅黑"), 8, WritableFont.NO_BOLD));
			ThreeTitleFormat.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
			//设置文本水平居中对齐
			ThreeTitleFormat.setAlignment(Alignment.CENTRE);
			//设置文本垂直居中对齐
			ThreeTitleFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
			//三级标题的名称
			String[] Lev3HeaderFontName = {"序号", "订单提交时间", "订单编号", "放款银行", "产品名称", "合作机构名称", "级别", "业务所在省份", "业务所在城市", "区域经理", "客户姓名"
											, "联系电话", "身份证号码", "车辆类型", "车辆品牌型号", "上牌城市", "购车分期本金", "金融服务费分期本金", "分期本金合计", "分期期限/月"
											, "执行银行利率", "合同本息合计", "客户月还款金额", "市场费率", "是否垫资", "收到购车分期本金时间", "收到购车分期本金金额", "支付购车分期本金时间"
											, "支付购车分期本金金额", "提车资料提交申请时间", "未当日提车打回垫款时间", "纸质资料邮寄时间", "银行提出问题时间", "提出问题的类型", "合作机构解决问题的时间"
											, "合作机构申请退单时间", "收到合作机构打回垫款时间", "银行放款时间", "首期还款日", "总部邮寄出办理抵押材料时间", "合作机构寄出已办妥抵押材料时间"
											, "银行收妥抵押材料时间", "与上级机构结算费率", "其他费用", "上级机构费用总计", "收到购车分期本金时间", "收到购车分期本金金额", "收到金融服务费时间"
											, "收到金融服务费金额", "支付购车分期本金时间", "支付购车分期本金金额", "结算费率", "其他费用", "业务保证金比例", "业务保证金金额", "代收代付金融服务费金额"};
			
			for (int i = 0; i < Lev3HeaderFontName.length; i++) {
				Label lable = new Label(i, 2, Lev3HeaderFontName[i], ThreeTitleFormat);
				sheet.addCell(lable);
				//根据内容自动设置列宽 
				sheet.setColumnView(i, Lev3HeaderFontName[i].length()+10);
			}
			
		}
		
		/**
		 * 设置表1的格式			-----根据用户选择的需要导出的字段动态生成表的格式
		 * @param sheet
		 * @param fieldName		-----用户选择需要导出字段的数据库字段名
		 * @param lev2MenuName	-----用户选择导出字段对应的所有二级菜单在数组中的位置
		 * @param lev3MenuName	-----用户选择导出字段对应的所有三级菜单在数组中的位置
		 * @param data			-----所有数据
		 * @throws RowsExceededException
		 * @throws WriteException
		 */
		public static void SetSheet1Layout(WritableSheet sheet, List<String> fieldName, List<Integer> lev2MenuName, List<Integer> lev3MenuName, List<Map> data) throws RowsExceededException, WriteException{
			
			//合并一级标题所占的单元格
			sheet.mergeCells(0, 0, fieldName.size(), 0);
			//设置一级标题字体格式
			ExportOperationsExcel.SetLev1HeaderFontFormat();
			//设置一级标题的行高
			sheet.setRowView(0, 500);
			//添加一级标题
			Label lab_1 = new Label(0, 0, "购车分期业务运营管理数据表1-业务台账", ExportOperationsExcel.SetLev1HeaderFontFormat());
			sheet.addCell(lab_1);
			
			
			//设置二级标题的行高
			sheet.setRowView(1, 550);
			//设置二级标题
			WritableCellFormat TwoTitleFormat = new WritableCellFormat();
			TwoTitleFormat.setFont(new WritableFont(WritableFont.createFont("微软雅黑"),10,WritableFont.BOLD));
			TwoTitleFormat.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
			//设置文本水平居中对齐
			TwoTitleFormat.setAlignment(Alignment.CENTRE);
			//设置文本垂直居中对齐
			TwoTitleFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
	
			String[] Lev2HeaderFontName = {"基础订单信息", "合作机构信息", "特殊", "客户信息", "车辆信息", "贷款信息"};
			//导出字段列表  / 三级标题列表
			String[] Lev3HeaderFontName = {"订单提交时间", "订单编号", "放款银行", "产品名称", "合作机构名称", "级别", "业务所在省份", "业务所在城市", "区域经理", "客户姓名", "联系电话"
										, "身份证号码", "车辆类型", "车辆品牌型号", "上牌城市", "购车分期本金", "金融服务费分期本金", "分期本金合计", "分期期限/月", "执行银行利率"
										, "合同本息合计", "客户月还款金额", "市场费率"};
			
			int counts = 0;
			//循环二级标题的个数  
			for (int i = 1; i <= Lev2HeaderFontName.length; i++) {
				//判断需要导出的二级标题  -----如果包含1就说明需要导出二级标题中的第一个也就是"基础订单信息"
				if(lev2MenuName.contains(i)){
					//根据二级标题对应的数字在title中出现的次数 取得用户在每个二级标题下选择的三级标题的数量
					int count = Collections.frequency(lev2MenuName, i);
					//如果用户选择的每个二级标题下三级标题的数量大于1 二级标题栏就需要合并单元格
					if(count > 1){
						sheet.mergeCells(counts+1, 1, count+counts, 1);		//合并单元格
						sheet.setColumnView(i, Lev2HeaderFontName[i-1].length()+10);		//设置根据内容自动设置列宽
						sheet.addCell( new Label(counts+1, 1, Lev2HeaderFontName[i-1], TwoTitleFormat) );		//添加标题
					} else if(count == 1){
						sheet.setColumnView(i, Lev2HeaderFontName[i-1].length()+10);
						sheet.addCell( new Label(counts+1, 1, Lev2HeaderFontName[i-1], TwoTitleFormat) );
					}
					//用于计算每个二级标题下的第一个三级标题在表中的列数
					counts += count;
				}
			}
			
			
			//设置三级标题的行高
			sheet.setRowView(2, 700);
			//设置三级标题的格式
			WritableCellFormat ThreeTitleFormat = new WritableCellFormat();
			ThreeTitleFormat.setFont(new WritableFont(WritableFont.createFont("微软雅黑"), 8, WritableFont.NO_BOLD));
			ThreeTitleFormat.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
			//设置文本水平居中对齐
			ThreeTitleFormat.setAlignment(Alignment.CENTRE);
			//设置文本垂直居中对齐
			ThreeTitleFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
			//三级标题的名称
			sheet.addCell( new Label(0, 2, "序号", ThreeTitleFormat) );
			for (int i = 0; i < lev3MenuName.size(); i++) {
				sheet.addCell( new Label(i+1, 2, Lev3HeaderFontName[lev3MenuName.get(i)], ThreeTitleFormat) );
				//根据内容自动设置列宽
				sheet.setColumnView(i+1, Lev3HeaderFontName[lev3MenuName.get(i)].length()+10);
			}
			
			//循环添加每一行
			for (int i = 0; i < data.size(); i++) {
				sheet.addCell( new Label(0, i+3, String.valueOf(i+1)) );			//序号
				Map map = data.get(i);		//获取到每一行的数据
				float a = 0;	//分期本金合计
				float b = 0;	//合同本息合计
				BigDecimal bd = new BigDecimal("0");	//合同本息合计
				//循环添加每一列
				for (int j = 0; j < fieldName.size(); j++) {
					
					String field = fieldName.get(j);		//取出用户选择导出的数据库字段名
					if("dt_add".equals(field)){		//订单提交时间
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
						sheet.addCell( new Label(j+1, i+3, sdf.format(map.get(field))) );
						sheet.setColumnView(j+1, sdf.format(map.get(field)).length()+10);
					} else if("manager".equals(field)) {
						sheet.addCell( new Label(j+1, i+3, "无此条数据") );	//区域经理
						sheet.setColumnView(j+1, "无此条数据".length()+10);
					} else if("cars_type".equals(field)) {	//车辆类型
						if((int)map.get("cars_type") == 1){
							 sheet.addCell(new Label(j+1, i+3, "新车"));
						 } else if((int)map.get("cars_type") == 2){
							 sheet.addCell(new Label(j+1, i+3, "二手车"));
						 }
					} else if("cars_name".equals(field)) {	//车辆品牌型号
						String carsData = map.get("cars_name").toString() + map.get("cse_name").toString() + map.get("cm_name").toString();	//获取到完整的车辆信息
						sheet.addCell(new Label(j+1, i+3, carsData));
						sheet.setColumnView(j+1, carsData.length()+10);
					} else if("kk_loan_amount+kk_loan_amount_s".equals(field)) {	//分期本金合计
						a = (float)map.get("kk_loan_amount")*10000 + (int)map.get("kk_loan_amount_s");
						sheet.addCell(new Label(j+1, i+3, String.valueOf(a)));
					} else if("principalAndInterest".equals(field)) {	//合同本息合计
					    b = ((float)map.get("kk_loan_rate")/100 + 1);
						BigDecimal b1 = new BigDecimal(String.valueOf(b));
						BigDecimal b2 = new BigDecimal(String.valueOf(a));
						bd = b1.multiply(b2);
						sheet.addCell(new Label(j+1, i+3, String.valueOf(bd)));
					} else if("MonPayments".equals(field)) {	//客户月还款金额
						BigDecimal c = new BigDecimal("0");
						if (0!=(int)map.get("kk_loan_ajqx") && StringUtils.isEmpty(map.get("kk_loan_ajqx"))) {
							BigDecimal c1 = new BigDecimal(String.valueOf(map.get("kk_loan_ajqx")));
							c = bd.divide(c1 , 5, RoundingMode.HALF_UP);
							sheet.addCell(new Label(j+1, i+3, String.valueOf(c)));
						 } else {
							sheet.addCell(new Label(j+1, i+3, "分期期限错误,无法计算"));
							sheet.setColumnView(j+1, "分期期限错误,无法计算".length()+10);
						 }
					} else if("marketrate".equals(field)) {
						sheet.addCell(new Label(j+1, i+3, "无此条数据"));
						sheet.setColumnView(j+1, "无此条数据".length()+10);
					} else {
						sheet.addCell( new Label(j+1, i+3, map.get(field).toString()) );
					}
					
				}
			}
		}
		
//		/**
//		 * 设置其余表的格式
//		 * @param sheet		具体是哪张表
//		 * @param endNumber		一级标题合并到最后一个单元格的列数  从0开始
//		 * @param Lev1HeaderName		一级标题的名称
//		 * @param Lev2HeaderName		二级标题名称的数组
//		 * @throws RowsExceededException
//		 * @throws WriteException
//		 */
//		public static void SetSheet2Layout(WritableSheet sheet, int endNumber, String Lev1HeaderName, String[] Lev2HeaderName) throws RowsExceededException, WriteException{
//			
		
//			//合并单元格
//			sheet.mergeCells(0, 0, endNumber, 0);
//			
//			//设置一级标题字体格式
//			ExportOperationsExcel.SetLev1HeaderFontFormat();
//			sheet.setRowView(0, 500);
//			//设置一级标题
//			Label lab_1 = new Label(0, 0, Lev1HeaderName, ExportOperationsExcel.SetLev1HeaderFontFormat());
//			sheet.addCell(lab_1);
//			
//			//设置二级标题的格式
//			sheet.setRowView(1, 500);
//			WritableCellFormat TwoTitleFormat = new WritableCellFormat();
//			TwoTitleFormat.setFont(new WritableFont(WritableFont.createFont("微软雅黑"), 8, WritableFont.NO_BOLD));
//			TwoTitleFormat.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
//			//设置文本水平居中对齐
//			TwoTitleFormat.setAlignment(Alignment.CENTRE);
//			//设置文本垂直居中对齐
//			TwoTitleFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
//			for (int i = 0; i < Lev2HeaderName.length; i++) {
//				Label lable = new Label(i, 1, Lev2HeaderName[i], TwoTitleFormat);
//				sheet.addCell(lable);
//				//根据内容自动设置列宽 
//				sheet.setColumnView(i, Lev2HeaderName[i].length()+10);
//			}
//			
//		}
		

}
