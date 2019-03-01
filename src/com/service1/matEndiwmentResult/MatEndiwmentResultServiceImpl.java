package com.service1.matEndiwmentResult;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.matEndiwmentResult.MatEndiwmentResultMapper;
import com.model1.icbc.erp.PageData;

@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class)
public class MatEndiwmentResultServiceImpl implements MatEndiwmentResultService{

	@Autowired
	private MatEndiwmentResultMapper matEndiwmentResultMapper;
	
	
	@Override
	public List<PageData> selectMat(String param) {
		// TODO Auto-generated method stub
		return matEndiwmentResultMapper.selectMat(param);
	}


	@Override
	public List<Map> selectDetail(String id_card,String periods) {
		// TODO Auto-generated method stub
		return matEndiwmentResultMapper.selectDetail(id_card,periods);
	}


	@Override
	public int updateflag(String id_card, String periods,String dcdate) {
		// TODO Auto-generated method stub
		return matEndiwmentResultMapper.updateflag(id_card, periods,dcdate);
	}


	@Override
	public Map<String, Object> selectid_card(String id_card) {
		// TODO Auto-generated method stub
		return matEndiwmentResultMapper.selectid_card(id_card);
	}


	@Override
	public int addMat(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return matEndiwmentResultMapper.addMat(map);
	}


	@Override
	public int addhk(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return matEndiwmentResultMapper.addhk(map);
	}


	@Override
	public Map<String, Object> selectAfree(String id_card) {
		// TODO Auto-generated method stub
		return matEndiwmentResultMapper.selectAfree(id_card);
	}


	@Override
	public List<Map> selectdetail(String id_card) {
		// TODO Auto-generated method stub
		return matEndiwmentResultMapper.selectdetail(id_card);
	}


	@Override
	public String selectcount(String id_card) {
		// TODO Auto-generated method stub
		return matEndiwmentResultMapper.selectcount(id_card);
	}


	@Override
	public int updatecount(String id_card,String count) {
		// TODO Auto-generated method stub
		return matEndiwmentResultMapper.updatecount(id_card, count);
	}


	@Override
	public int updatecount2(String id_card, String count) {
		// TODO Auto-generated method stub
		return matEndiwmentResultMapper.updatecount2(id_card, count);
	}


	@Override
	public int updatestate(String id_card, String periods, String dcdate) {
		// TODO Auto-generated method stub
		return matEndiwmentResultMapper.updatestate(id_card, periods,dcdate);
	}



	
	
}
