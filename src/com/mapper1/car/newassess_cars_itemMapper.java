package com.mapper1.car;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.icbc.assess_cars_item;

public interface newassess_cars_itemMapper {
    //ĞÂÔö
	public void addcarsitem(assess_cars_item aci);
	//
	public void upcarsitem(assess_cars_item aci);
	
	List<assess_cars_item> findicbc_carsimg(@Param("cars_id")int cars_id);
}
