package com.service1.car;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.car.icbc_carsMapper;
import com.model.icbc.assess_cars;

@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class)
public class icbc_carsServiceImpl implements icbc_carsService{

	@Resource
	private icbc_carsMapper icbc_carsMapper;

	@Override
	public assess_cars findicbc_cars(int icbc_id) {
		
		return icbc_carsMapper.findicbc_cars(icbc_id);
	}

	@Override
	public void upicbc_cars(assess_cars assess_cars) {
		icbc_carsMapper.upicbc_cars(assess_cars);
		
	}

	@Override
	public assess_cars findlastid() {
		
		return icbc_carsMapper.findlastid();
	}

	@Override
	public void addassess_cars(assess_cars assess_cars) {
		icbc_carsMapper.addassess_cars(assess_cars);
		
	}

	@Override
	public void upcodebyid(assess_cars assess_cars) {
		icbc_carsMapper.upcodebyid(assess_cars);
		
	}

	@Override
	public assess_cars findicbc_cars1(int icbc_id) {
		
		return icbc_carsMapper.findicbc_cars1(icbc_id);
	}

	@Override
	public List<assess_cars> allfindicbc_cars() {
		
		return icbc_carsMapper.allfindicbc_cars();
	}

	@Override
	public assess_cars findicbc_cars2(int icbc_id) {
		
		return icbc_carsMapper.findicbc_cars2(icbc_id);
	}

	@Override
	public assess_cars findcarsbyid(int id) {
		
		return icbc_carsMapper.findcarsbyid(id);
	}

	@Override
	public assess_cars carsshbyid(int id) {
		return icbc_carsMapper.carsshbyid(id);
	}

	@Transactional
	public void del_icbc_cars(int id) {
		icbc_carsMapper.del_icbc_cars(id);
		
	}

	@Override
	public List<assess_cars> kjs_pg(int bc_status) {
		return icbc_carsMapper.kjs_pg(bc_status);
	}

	@Override
	public int kjs_pg_count() {
		
		return icbc_carsMapper.kjs_pg_count();
	}
	
}
