package com.util;
/**
 * 扣除金额工具
 */
public class DeductFeeAmountTool {
	//维修保养
	public static final String  MAINTENANCE_ENQUIRY ="8";//维修保养查询
	//保险理财
	public static final String INSURANCE_FINANCIAL_ENQUIRY="30";//保险理财查询
	//新建评估
	public static final String RAPID_ASSESSMENT="30";//汽车快速评估
	public static final String PROFESSIONAL_ASSESSMENT="200";//汽车专业评估
	//车辆状况
	public static final String VEHICLE_STATUS_ENQUIRY="80";//车辆状况查询
	//个人征信查询
	public static final String THE_PEDESTRIAN_QUERY="100";//征信 人行查询
	public static final String BIG_DATA_QUERY="10";//大数据查询
	public static final String JANE_VERSION_INQUIRY="0";//简版征信
	//真实性分析
	public static final String BANK_CARD_CERTIFICATION="3";//银行卡认证
	public static final String Communication_data_authentication="10";//通讯数据认证
	public static final String CHINABANK_INCOME_SPENDING="8";//网银流水
	//黑名单查询
	public static final String BLACKLIST_QUERY="3";//黑名单查询
	//转换为大写
	public static void main(String[] args){
		System.out.println("Jane version inquiry".toUpperCase() );
	}
}
