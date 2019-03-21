package com.service1.icbc_banklist;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.icbc_banklist.icbc_banklistMapper;
import com.model1.icbc.erp.PageData;

@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class)
public class icbc_banklistServiceImpl implements icbc_banklistService {

	@Resource
	private icbc_banklistMapper icbc_banklistMapper;

	@Override
	public List<PageData> geticbc_banklist() {
		// 查询所有信息
		return icbc_banklistMapper.geticbc_banklist();
	}

	@Override
	public void saveicbc_banklist(PageData pd) {
		icbc_banklistMapper.saveicbc_banklist(pd);
	}

	@Override
	public void upicbc_banklist(PageData pd) {
		icbc_banklistMapper.upicbc_banklist(pd);
	}

	@Override
	public List<PageData> geticbc_banklistbyID(PageData pd) {
		// TODO Auto-generated method stub
		return icbc_banklistMapper.geticbc_banklistbyID(pd);
	}

	@Override
	public PageData geticbc_bank(int id) {
		// TODO Auto-generated method stub
		return icbc_banklistMapper.geticbc_bank(id);
	}

}
