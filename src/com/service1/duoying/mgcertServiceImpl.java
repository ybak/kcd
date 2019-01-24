package com.service1.duoying;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.mgcertMapper;
import com.model1.mgcert;

@Service
@Transactional(value = "kcway2",isolation=Isolation.SERIALIZABLE,propagation=Propagation.REQUIRED,rollbackFor = Exception.class)
public class mgcertServiceImpl implements mgcertService{

	@Resource
	private mgcertMapper mgcertmapper;
	
	
	@Override
	public List<mgcert> findmgcertlist() {
		
		return mgcertmapper.findmgcertlist();
	}

	@Override
	public List<mgcert> findzsresult(int bc_status) {
		
		return mgcertmapper.findzsresult(bc_status);
	}

	@Override
	public List<mgcert> csmgcert() {		
		return mgcertmapper.csmgcert();
	}

	@Override
	public List<mgcert> findmgcar() {
		
		return mgcertmapper.findmgcar();
	}

	@Override
	public List<mgcert> findmgnewcar() {
		
		return mgcertmapper.findmgnewcar();
	}

	@Override
	public List<mgcert> findmgcertbyid(int fsid) {
		
		return mgcertmapper.findmgcertbyid(fsid);
	}

	@Override
	public List<mgcert> findmgcarbyid(int fsid) {
		
		return mgcertmapper.findmgcarbyid(fsid);
	}

	@Override
	public List<mgcert> findmgnewcarbyid(int fsid) {
	
		return mgcertmapper.findmgnewcarbyid(fsid);
	}

	@Override
	public List<mgcert> Apimgcert() {
		
		return mgcertmapper.Apimgcert();
	}

	@Override
	public List<mgcert> Apijkxxmgcert() {
		
		return mgcertmapper.Apijkxxmgcert();
	}

	@Override
	public List<mgcert> Apimgcar() {
	
		return mgcertmapper.Apimgcar();
	}

	@Override
	public List<mgcert> Apijkxxmgcar() {
	
		return mgcertmapper.Apijkxxmgcar();
	}

	@Override
	public List<mgcert> Apimgnewcar() {
		
		return mgcertmapper.Apimgnewcar();
	}

	@Override
	public List<mgcert> Apijkxxmgnewcar() {
		
		return mgcertmapper.Apijkxxmgnewcar();
	}

	@Override
	public mgcert mgcertAPI(int id) {
		
		return mgcertmapper.mgcertAPI(id);
	}

	@Override
	public mgcert mgcarAPI(int id) {
		
		return mgcertmapper.mgcarAPI(id);
	}

	@Override
	public mgcert mgnewcarAPI(int id) {
		
		return mgcertmapper.mgnewcarAPI(id);
	}

	@Override
	public mgcert mgxcAPI(int id) {
		
		return mgcertmapper.mgxcAPI(id);
	}

	@Override
	public List<Object> jkrID() {
		// TODO Auto-generated method stub
		return mgcertmapper.jkrID();
	}

	@Override
	public List<mgcert> csmgcar() {
		// TODO Auto-generated method stub
		return mgcertmapper.csmgcar();
	}

	@Override
	public List<mgcert> csmgnewcar() {
		// TODO Auto-generated method stub
		return mgcertmapper.csmgnewcar();
	}

	@Override
	public void upmgcert(mgcert mg) {
		mgcertmapper.upmgcert(mg);
		
	}

	@Override
	public void upmgcar(mgcert mg) {
		mgcertmapper.upmgcar(mg);
		
	}

	@Override
	public void upmgnewcar(mgcert mg) {
		mgcertmapper.upmgnewcar(mg);
		
	}

	@Override
	public List<mgcert> certlist(int zjf_type) {
		
		return mgcertmapper.certlist(zjf_type);
	}

	@Override
	public List<mgcert> carlist(int zjf_type) {
		
		return mgcertmapper.carlist(zjf_type);
	}

	@Override
	public List<mgcert> newcarlist(int zjf_type) {
		
		return mgcertmapper.newcarlist(zjf_type);
	}

	public mgcert findcert(String gems_code) {		
		return mgcertmapper.findcert(gems_code);
	}

	public mgcert findcar(String gems_code) {		
		return mgcertmapper.findcar(gems_code);
	}

	public mgcert findnewcar(String gems_code) {
		
		return mgcertmapper.findnewcar(gems_code);
	}

	

}
