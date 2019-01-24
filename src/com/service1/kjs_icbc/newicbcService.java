package com.service1.kjs_icbc;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.icbc.icbc;
import com.model.icbc.icbc_result;

public interface newicbcService {
	//删除
	public void del_icbc(int id);
	//添加工行进件信息
	public void addicbc(icbc icbc);
	//更新工行进件信息
	public void upicbc(icbc icbc);
    //根据订单编号 查询
	public icbc findicbcbyorderid(String orderid);
	//根据订单编号 查询
	icbc findicbcbyorderid2(String orderid);
	//findicbc 遍历
	public List<icbc> findicbc(int querytype,int bc_status);
	//根据id查询
	public icbc findicbcbyid(int id);
	//
	public void upicbc_tag(icbc icbc);
	//
	public icbc findlastid();
	//
	void up_fk(icbc icbc);
	//
	public List<icbc> searchicbc(String time1,
			String time2,
			int querytype,
			int bc_status,
			int gems_fs_id,
			int book_status,
			int card_status,
			String icbcname
			);
	//
	public int findicbccount();
	//
	List<icbc> kjs_zx(int bc_status);
	//
	int kjs_zx_count();
}
