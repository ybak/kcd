package com.service1.car;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper.icbc.assess_cars_itemMapper;
import com.mapper1.car.newassess_cars_itemMapper;
import com.model.icbc.assess_cars_item;
@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class) 
public class newassess_cars_itemServiceImpl implements newassess_cars_itemService{

	 @Resource
	  private newassess_cars_itemMapper nweassess_cars_itemMapper;
	
	@Override
	public void addcarsitem(assess_cars_item aci) {
		nweassess_cars_itemMapper.addcarsitem(aci);
		
	}

	@Override
	public void upcarsitem(assess_cars_item aci) {
		nweassess_cars_itemMapper.upcarsitem(aci);
		
	}

	@Override
	public List<assess_cars_item> findicbc_carsimg(int cars_id) {
		
		return nweassess_cars_itemMapper.findicbc_carsimg(cars_id);
	}

}
