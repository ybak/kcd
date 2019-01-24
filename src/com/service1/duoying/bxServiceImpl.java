package com.service1.duoying;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.bxMapper;
import com.model1.bx;

@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class)  
public class bxServiceImpl implements bxService{

	@Resource
	private bxMapper bxMapper;
	
	

	@Override
	public List<bx> findbxbyc_name(String c_carno) {
		// TODO Auto-generated method stub
		return bxMapper.findbxbyc_name(c_carno);
	}

	@Override
	public List<bx> findbx() {
		// TODO Auto-generated method stub
		return bxMapper.findbx();
	}

}
