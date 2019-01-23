package com.service1.admin;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.admin.assess_gemsMapper;

@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class) 
public class assess_gemsServiceImpl implements assess_gemsService{

	 @Autowired
	 private assess_gemsMapper assess_gemsMapper;
	
	@Override
	public List<Map<String, Object>> getgemslist(String time1,
			String time2,
			String keyword,
			int gems_fs_id) {
		
		return assess_gemsMapper.getgemslist(time1,
				time2,
				keyword,
				gems_fs_id);
	}

	@Override
	public Map<String, Object> getgemsmap(int id) {
		
		return assess_gemsMapper.getgemsmap(id);
	}

	@Override
	public void upgems_zx(Map<String, Object> map) {
		assess_gemsMapper.upgems_zx(map);
		
	}

	@Override
	public List<Map<String, Object>> getgemsmapbyfsid(int id) {
		
		return assess_gemsMapper.getgemsmapbyfsid(id);
	}

	@Override
	public Map<String, Object> getgemsmapbyicbc_id(int icbc_id) {
		
		return assess_gemsMapper.getgemsmapbyicbc_id(icbc_id);
	}

	@Override
	public List<Map<String, Object>> getgemslist1() {
		
		return assess_gemsMapper.getgemslist1();
	}

}
