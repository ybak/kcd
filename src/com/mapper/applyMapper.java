package com.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.model.apply;

public interface applyMapper {
	//查询可用授权书申请书
	public List<apply> fapply(int aid,int start,int num);
	public int	fapplylenth(int aid);
	public int alllenth();
	public  List<apply> allapply(int start,int num);
	//添加授权书申请书
	public void addapply(apply apply);
	public Map fapplybyname(String name);
	public void upapply(apply apply);
	//查询快车道授权书申请书
	public  List<apply> KCDapply(int url_fenlei,int start,int num);
	//分类查询快车道文件
	public int KCDCounts(int fenlei);
	//根据id查询
	public apply findapplybycode(@Param("acode")String acode);
	//删除
	public void delapply(@Param("applyurl")String applyurl);
	//根据 渠道类型 和 编号查询
	public List<apply> findbyacodeandtype(@Param("acode")String acode,@Param("apply_address")int apply_address);
}
