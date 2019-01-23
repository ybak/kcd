package com.service1.newAdd;
import java.util.ArrayList;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mapper1.newAdd.CarModelMapper;
import com.model1.newAdd.CarModell;

@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class) 
public class CarModelServiceImpl implements CarModelService{
	@Resource
	private CarModelMapper CarModelMapper;

	@Override
	public CarModell selectCarNameById(int id) {
		return CarModelMapper.selectCarNameById(id);
	}

	@Override
	public ArrayList selectCarModellById(int id) {
		return CarModelMapper.selectCarModellById(id);
	}
}
