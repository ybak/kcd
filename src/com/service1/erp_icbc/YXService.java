package com.service1.erp_icbc;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.controller.erp_icbc.YunXin.bean.CallBack;
import com.controller.erp_icbc.YunXin.bean.InfoCopy;
import com.controller.erp_icbc.utils.PageInfo;
public interface YXService {
	int add_YX_account(Map map);
	int addcallback(Map callback);
	List select_YX_video();
	List query_tokenbyid(String id);
	List query_token(String label, int count);
	
	void insert_infocopy_duration(InfoCopy infocopy);
	void insert_infocopy_download(InfoCopy infocopy);
	String select_infocopy(String channelId);
	void update_infocopy_duration(InfoCopy infocopy);
	void update_infocopy_download(InfoCopy infocopy);
	//视频面前在视频表中添加一个记录
	int insert_infocopy_viedo(Map map);
	//视频面前在视频表中更新一个记录
	int update_infocopy_viedo(Map map);
	
	void insert_M(String s);
	int insert_infocopy_durationM(Map infocopy);
	void insert_infocopy_downloadM(Map infocopy);
	String select_infocopyM(String channelId);
	void update_infocopy_durationM(Map infocopy);
	void update_infocopy_downloadM(Map infocopy);
	
	Map select_viedo_byid(String id);
	//历史免签
	List select_operating(PageInfo pageinfo);
	int select_operating_count(PageInfo pageinfo);
	//查询视频面签信息
	List select_mq_info(String id);
	List select_viedo_byid2(String id);
	
	Map select_icbc_byid(String id);
	Map select_car_byid(String icbcid);
	String select_kjicbc_byid(String typeid, String icbcid);
	int insert_kjicbcresult(Map map);
	int insert_kjicbc(Map map);//添加
	int update_kjicbc(Map map);//更新
	int update_infocopy_viedo_vid(Map map);
	int updata_mq_status(String bcstatus,String icbcid);
}
