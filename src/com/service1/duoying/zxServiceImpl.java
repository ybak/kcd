package com.service1.duoying;



import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.zxMapper;
import com.model1.zx;

@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class)  
public class zxServiceImpl implements zxService{

	@Resource
	private zxMapper zxMapper;
	
	

	@Override
	public List<zx> findzxbyc_name(String c_name) {
		
		return zxMapper.findzxbyc_name(c_name);
	}

	@Override
	public List<zx> findzx() {
		
		return zxMapper.findzx();
	}

	@Override
	public zx zxmap(String c_name) {
		
		return zxMapper.zxmap(c_name);
	}

	@Override
	public zx zxdsjmap(String c_name) {
		
		return zxMapper.zxdsjmap(c_name);
	}

	
}
