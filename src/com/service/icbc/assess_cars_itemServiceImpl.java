package com.service.icbc;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.icbc.assess_cars_itemMapper;
import com.model.icbc.assess_cars_item;
@Service
public class assess_cars_itemServiceImpl implements assess_cars_itemService{

	 @Resource
	  private assess_cars_itemMapper assess_cars_itemMapper;
	
	@Override
	public void addcarsitem(assess_cars_item aci) {
		assess_cars_itemMapper.addcarsitem(aci);
		
	}

	@Override
	public void upcarsitem(assess_cars_item aci) {
		assess_cars_itemMapper.upcarsitem(aci);
		
	}

}
