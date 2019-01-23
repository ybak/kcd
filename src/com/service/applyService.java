package com.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.model.apply;

public interface applyService {
	public List<apply> fapply(int aid,int start,int num);
	//添加授权书申请书
    public void addapply(apply apply);
    public int	fapplylenth(int aid);
    public int alllenth();
	public  List<apply> allapply(int start,int num);
    //
	public Map fapplybyname(String name);
	
	public void upapply(apply apply);
	//查询快车道授权书申请书
	public  List<apply> KCDapply(int start,int num,int url_fenlei);
	//分类查询快车道文件
	public int KCDCounts(int fenlei);
	//根据code查询
	public apply findapplybycode(String acode);
	//删除
	public void delapply(String applyurl);
	//根据 渠道类型 和 编号查询
	public List<apply> findbyacodeandtype(String acode,int apply_address);

}
