package com.service.newAdd;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper.newAdd.queryBxMapper;
import com.model.newAdd.queryBx;
import com.model1.bx;

@Service
// @Transactional(value = "kcway2", rollbackFor = Exception.class)  
public class queryBxServiceImpl implements queryBxService{

	@Resource
	private queryBxMapper queryBxMapper;
	
	@Override
	public List<bx> findbxbyc_name(String c_carno) {
		// TODO Auto-generated method stub
		return queryBxMapper.findbxbyc_name(c_carno);
	}

	@Override
	public List<bx> findbx() {
		// TODO Auto-generated method stub
		return queryBxMapper.findbx();
	}

	@Override
	public void addBX(queryBx bx) {
		queryBxMapper.addBX(bx);
	}

	@Override
	public int getNewId(String tableName,String databaseName) {
		return queryBxMapper.getNewId(tableName,databaseName);
	}


	@Override
	public int BxCounts() {
		return queryBxMapper.BxCounts();
	}

	@Override
	public List showBxAndKey(int start, int num) {
		return queryBxMapper.showBxAndKey(start, num);
	}

}
