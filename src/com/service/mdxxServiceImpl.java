package com.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.mapper.mdxxMapper;
import com.model.mdxx;
@Service
//@Transactional
public class mdxxServiceImpl extends BaseMySqlService implements mdxxService{

	   @Resource
	   private mdxxMapper mdxxmapper;
	@Override
	
	public void addmdxx(List<Map<String, String>> mdxx) {
		mdxxmapper.addmdxx(mdxx);
		
	}
	@Override
	public int mdxxsize(String ckey) {
		
		return mdxxmapper.mdxxsize(ckey);
	}
	@Override
	public int mdxxsize1(String sname, String pname, String pIDcard) {
	
		return mdxxmapper.mdxxsize1(sname,pname,pIDcard);
	}
	
	@Override
	public Map mdxxmap(String ckey) {
		
		return mdxxmapper.mdxxmap(ckey);
	}
	@Override
	public void upmdxx(mdxx mdxx) {
		
		mdxxmapper.upmdxx(mdxx);
	}
	@Override
	public List<mdxx> mdxxlist(int st,int ps) {
		
		return mdxxmapper.mdxxlist(st,ps);
	}
	@Override
	public int mdxxnum() {
		
		return mdxxmapper.mdxxnum();
	}
	@Override
	public List<mdxx> mdxxckey() {
		
		return mdxxmapper.mdxxckey();
	}
	@Override
	public List<mdxx> mdxxbyname() {
		
		return mdxxmapper.mdxxbyname();
	}

}
