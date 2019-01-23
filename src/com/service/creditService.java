package com.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.ui.Model;

import com.model.credit;

public interface creditService {
	public List<credit> zxbysum_bit(String sum_bit);
	//回退或撤销总数
	public int htcount();
	//回退
	public List<credit> httable(int st,int ps);
	//完成
    public int ecount();
    //回退
    public List<credit> etable(int st,int ps);
	//
    public List<credit> findmdid(String mdid,String sum_bit);
	  //查询表中所有数据
  //查询表中所有数据
    public List<credit> search();
	 // public  List<credit> findcredit();
	  //添加数据
	  public void save(credit credit);
	  //更新数据
	  public void upcredit(credit credit);
	  //分页查询
	  public List<credit> findcredit(int startPos,int pageSize);
	  //等待审核查询
	  public List<credit> dshtable(int startPos,int pageSize);
	  public List<credit> ztlist(String sum_bit,int startPos,int pageSize);
	  //等待审核总数
	  public int dshcount();
	  //根据审核状态查询数量
	  public int countnum(String sum_bit);
	  //分页查询
	  public List<credit> findcredit1(int mdid,int startPos,int pageSize);
	  //更新订单状态
	  public void upsubmit(credit credit);
	  //获取总数
	  public int findcount();
	  //获取总数
	  public int findcount1(int mdid);
	  //根据编号查询订单信息
	  public Map findcreditbyid(@Param("id")int id);
	  //分页
	  public void page(HttpServletRequest request,Model model);
	  //删除
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
