package com.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.model.credit;

public interface creditMapper {
	
	
	public List<credit> zxbysum_bit(@Param("sum_bit")String sum_bit);
	//回退或撤销总数
	public int htcount();
	//回退
	public List<credit> httable(@Param("st")int st,@Param("ps")int ps);
	//完成
    public int ecount();
    //回退
    public List<credit> etable(@Param("st")int st,@Param("ps")int ps);
		//
    public List<credit> findmdid(@Param("mdid")String mdid,@Param("sum_bit")String sum_bit);
	
  //查询表中所有数据
   public List<credit> search();
 // public  List<credit> findcredit();
  //添加数据
  public void save(credit credit);
  
  //更新数据
  public void upcredit(credit credit);
  //更新订单状态
  public void upsubmit(credit credit);
  //分页查询
  public List<credit> findcredit(@Param("st")int st,@Param("ps")int ps);
  
  //根据审核状态查询数量
  public int countnum(String sum_bit);
  //等待审核查询
  public List<credit> dshtable(@Param("st")int st,@Param("ps")int ps);
  //等待审核总数
  public int dshcount();
  public List<credit> ztlist(@Param("sum_bit")String sum_bit,@Param("st")int startPos,@Param("ps")int pageSize);
  //获取总数
  public int findcount();
  //分页查询
  public List<credit> findcredit1(@Param("mdid")int mdid,@Param("st")int st,@Param("ps")int ps);
  
  //获取总数
  public int findcount1(@Param("mdid")int mdid);
  //根据编号查询订单信息
  public Map findcreditbyid(int id);
  //删除操作 根据id
  public void delcredit(int id);
  // 根据身份证号 查询数据
  public Map findbysfz(String idcard);
  //根据查询信息查询用户
  public credit findcreditbyname(String name,String IDcard_num,String phone_num);
  //根据姓名和身份证号查询结果
  public List<credit> findover(List<?> list);
  //审核更新状态
  public void editzx(credit credit);
  //还原图片
  public void hyimg(credit credit);
}