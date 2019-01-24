   package com.service1.erp_icbc;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.controller.erp_icbc.YunXin.bean.CallBack;
import com.controller.erp_icbc.YunXin.bean.InfoCopy;
import com.controller.erp_icbc.utils.PageInfo;
import com.mapper1.erp_icbc.YXMapper;
@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class) 
public class YXServiceImpl implements YXService{
	@Autowired
	private YXMapper yxmapper;
	public int add_YX_account(Map map){
		return yxmapper.add_YX_account(map);
	}
	public int addcallback(Map callback){
		return yxmapper.addcallback(callback);
	}
	public List select_YX_video(){
		return yxmapper.select_YX_video();
	}
	public List query_tokenbyid(String id){
		return yxmapper.query_tokenbyid(id);
	}
	
	public void insert_infocopy_duration(InfoCopy infocopy){
		yxmapper.insert_infocopy_duration(infocopy);
	}
	public void insert_infocopy_download(InfoCopy infocopy){
		yxmapper.insert_infocopy_download(infocopy);
	}
	public String select_infocopy(String channelId){
		return yxmapper.select_infocopy(channelId);
	}
	public void update_infocopy_duration(InfoCopy infocopy){
		 yxmapper.update_infocopy_duration(infocopy);
	}
	public void update_infocopy_download(InfoCopy infocopy){
		yxmapper.update_infocopy_download(infocopy);
	}
	public void insert_M(String s){
		yxmapper.insert_M( s);
	}
	public int insert_infocopy_durationM(Map infocopy){
		return yxmapper.insert_infocopy_durationM(infocopy);
	}
	public void insert_infocopy_downloadM(Map infocopy){
		yxmapper.insert_infocopy_downloadM(infocopy);
	}
	public String select_infocopyM(String channelId){
		return yxmapper.select_infocopyM(channelId);
	}
	public void update_infocopy_durationM(Map infocopy){
		yxmapper.update_infocopy_durationM(infocopy);
	}
	public void update_infocopy_downloadM(Map infocopy){
		yxmapper.update_infocopy_downloadM(infocopy);
	}
	public Map select_viedo_byid(String id){
		return yxmapper.select_viedo_byid(id);
	}
	//历史列表
	public List select_operating(PageInfo pageinfo){
		return yxmapper.select_operating( pageinfo);
	}
	
	public Map select_icbc_byid(String id){
		return yxmapper.select_icbc_byid(id);
	}
	public Map select_car_byid(String icbcid){
		return yxmapper.select_car_byid(icbcid);
	}
	public String select_kjicbc_byid(String typeid, String icbcid){
		return yxmapper.select_kjicbc_byid(typeid,icbcid);
	}
	public int insert_kjicbcresult(Map map){
		return yxmapper.insert_kjicbcresult(map);
	}
	public int insert_kjicbc(Map map){
		return yxmapper.insert_kjicbc(map);
	}
	public int update_kjicbc(Map map){
		return yxmapper.update_kjicbc(map);
	}
	public List select_viedo_byid2(String id){
		return yxmapper.select_viedo_byid2(id);
	}
	
	//视频面前在视频表中添加一个记录
	public int insert_infocopy_viedo(Map map){
		return yxmapper.insert_infocopy_viedo(map);
	}
	//视频面前在视频表中更新一个记录
	public int update_infocopy_viedo(Map map){
		return yxmapper.update_infocopy_viedo(map);
	}
	@Override
	public int select_operating_count(PageInfo pageinfo) {
		// TODO Auto-generated method stub
		return yxmapper.select_operating_count(pageinfo);
	}
	@Override
	public List query_token(String label, int count) {
		// TODO Auto-generated method stub
		return yxmapper.query_token(label,count);
	}
	public int update_infocopy_viedo_vid(Map map){
		return yxmapper.update_infocopy_viedo(map);
	}
	public int updata_mq_status(String bcstatus,String icbcid){
		return yxmapper.updata_mq_status(bcstatus,icbcid);
	}
	//查询视频面签信息
	@Override
	public List select_mq_info(String id) {
		// TODO Auto-generated method stub
		return yxmapper.select_mq_info( id);
	}
}
