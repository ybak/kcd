package com.service1.duoying;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.archivesMapper;
import com.model1.archives;

@Service
@Transactional(value = "kcway2",rollbackFor = Exception.class)  
public class archivesServiceImpl implements archivesService{

	@Resource
	private archivesMapper archivesMapper;
	
	

	@Override
	public List<archives> findarchivesbyc_name(String c_carno) {
		// TODO Auto-generated method stub
		return archivesMapper.findarchivesbyc_name(c_carno);
	}

	@Override
	public List<archives> findarchives() {
		// TODO Auto-generated method stub
		return archivesMapper.findarchives();
	}

	@Override
	public archives archivesmap(String c_carno) {
		// TODO Auto-generated method stub
		return archivesMapper.archivesmap(c_carno);
	}

	@SuppressWarnings("unused")
	@Override
	public archives Apiarchives(String c_carno,String r_item6,String query_type) {
		archives a=new archives();
		if(c_carno!=null&&!c_carno.equals("")){
			a=archivesMapper.Apiarchives(c_carno, r_item6,query_type);	
			return a;
		}
		if(r_item6!=null&&!r_item6.equals("")){
			a=archivesMapper.Apiarchives(c_carno, r_item6,query_type);
			return a;
		}
		if(c_carno!=null&&r_item6!=null&&!c_carno.equals("")&&!r_item6.equals("")){
			a=archivesMapper.Apiarchives(c_carno,r_item6,query_type);
			return a;
		}else{
			return a;
		}
		}

}
