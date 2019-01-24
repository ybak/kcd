package com.service.newAdd;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.newAdd.AssessCarsMapper;
import com.model.newAdd.AssessCars;
@Service
public class AssessCarsServiceImpl implements AssessCarsService{
	@Resource
	private  AssessCarsMapper assessCarsMapper;

	@Override
	public ArrayList selectAllAssessCars(int page,int size) {
		return assessCarsMapper.selectAllAssessCars(page,size);
	}
	@Override
	public int getSumAssessCars() {
		return assessCarsMapper.getSumAssessCars();
	}
	@Override
	public void deleteOneACarsById(int id) {
		// TODO Auto-generated method stub
		assessCarsMapper.deleteOneACarsById(id);
	}
	@Override
	public AssessCars selectOneACarsById(int id) {
		return assessCarsMapper.selectOneACarsById(id);
	}
	@Override
	public int updateOneACarsById(AssessCars assessCars) {
		return assessCarsMapper.updateOneACarsById(assessCars);
	}
	
}
