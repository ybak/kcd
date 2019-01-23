package com.service1.newAdd;

import java.util.ArrayList;

import com.model1.newAdd.CarModell;

public interface CarModelService {
	//查询操作
	public CarModell selectCarNameById(int id);
	// 查询汽车三级详细品牌 
	public ArrayList selectCarModellById(int id);
}
