package com.util.Excel;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class ReadExcelUtils implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	 private String name; // 客户姓名
	 private String IdCard; // 身份证号
	 private String RepaymentCard; // 还款卡号
	 private String balanceCard;//卡余额
	 private String OverdueAmount;//逾期金额
	 private String continuity;//连续违约次数
	 private String Maximum;//最大违约次数
	 private String Date;//导入日期
	 private String balanceOn;//在保余额
	public ReadExcelUtils(String filePath) {
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdCard() {
		return IdCard;
	}
	public void setIdCard(String idCard) {
		IdCard = idCard;
	}
	public String getRepaymentCard() {
		return RepaymentCard;
	}
	public void setRepaymentCard(String repaymentCard) {
		RepaymentCard = repaymentCard;
	}
	public String getBalanceCard() {
		return balanceCard;
	}
	public void setBalanceCard(String balanceCard) {
		this.balanceCard = balanceCard;
	}
	public String getOverdueAmount() {
		return OverdueAmount;
	}
	public void setOverdueAmount(String overdueAmount) {
		OverdueAmount = overdueAmount;
	}
	public String getContinuity() {
		return continuity;
	}
	public void setContinuity(String continuity) {
		this.continuity = continuity;
	}
	public String getMaximum() {
		return Maximum;
	}
	public void setMaximum(String maximum) {
		Maximum = maximum;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getBalanceOn() {
		return balanceOn;
	}
	public void setBalanceOn(String balanceOn) {
		this.balanceOn = balanceOn;
	}
	@Override 
	public String toString() {
        return "User [客户姓名=" + name + ", 身份证号=" + IdCard + ", 还款卡号=" + RepaymentCard + ", 卡余额=" + balanceCard + ","
        		+ "逾期金额=" + OverdueAmount + ",连续违约次数=" + continuity + ",最大违约次数=" + Maximum + ",导入日期=" + Date + ",在保余额=" + balanceOn + "]";
    }

	public List<Map> readExcelContent(List<String> columnsList) {
		// TODO Auto-generated method stub
		return null;
	}


}
