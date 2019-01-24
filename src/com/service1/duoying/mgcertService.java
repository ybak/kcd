package com.service1.duoying;

import java.util.List;


import com.model1.mgcert;

public interface mgcertService {
	//根据更新标记 zjf_type 查询
	public List<mgcert> certlist(int zjf_type);
	//根据更新标记 zjf_type 查询
	public List<mgcert> carlist(int zjf_type);
	//根据更新标记 zjf_type 查询
	public List<mgcert> newcarlist(int zjf_type);
	//同步信息更新标记
	public void upmgcert(mgcert mg);
	//同步信息更新标记
	public void upmgcar(mgcert mg);
	//同步信息更新标记
	public void upmgnewcar(mgcert mg);
	//根据id获取借款人信息
	public mgcert mgcertAPI(int id);
	//根据id获取借款人信息
	public mgcert mgcarAPI(int id);
	//根据id获取借款人信息
	public mgcert mgnewcarAPI(int id);
	//根据id获取借款人信息
	public mgcert mgxcAPI(int id);
	  //借款人id
    public List<Object> jkrID();
	//正式 
    public List<mgcert> Apimgcert();
    
    public List<mgcert> Apijkxxmgcert(); 
    //正式  押车
	public List<mgcert> Apimgcar();
	   
	public List<mgcert> Apijkxxmgcar(); 
	//正式  押新车
	public List<mgcert> Apimgnewcar();
	   
	public List<mgcert> Apijkxxmgnewcar(); 
    
    //根据编号查询表中数据
	public mgcert findcert(String gems_code);		
    //根据编号查询表中数据
	public mgcert findcar(String gems_code);
    //根据编号查询表中数据
	public mgcert findnewcar(String gems_code);	
	//查询所有数据
	public List<mgcert> findmgcertlist();
	//终审结果查询
	public List<mgcert> findzsresult(int bc_status);
	//终审结果查询
	public List<mgcert> csmgcert();
	//终审结果查询
	public List<mgcert> csmgcar();
	//终审结果查询
	public List<mgcert> csmgnewcar();
	//押车
	public List<mgcert> findmgcar();
	//压新车
	public List<mgcert> findmgnewcar();
	public  List<mgcert> findmgcertbyid(int fsid);
	public  List<mgcert> findmgcarbyid(int fsid);
	public  List<mgcert> findmgnewcarbyid(int fsid);
}
