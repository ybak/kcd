package com.service.newAdd;
import java.util.ArrayList;
import com.model.newAdd.BmsCpyclient;
public interface BmsClientService {
	/////////登陆用户下(业务经历或者业务员)所看到的信息/////////
	//(业务经理或业务员)模糊查询
	public ArrayList selectClientLikeManager(String ucid,String tname);
	//查询登陆用户(业务经理或业务员)下的客户
	public ArrayList selectLoginUserClient(String ucid);
	
	
	/////////最大权限(主管)下看到的全部信息////////////////
	//修改某客户到管理员下面
	public int updateClientToUserUp(String ucid,int tid);
	//模糊查询
	public ArrayList selectClientLike(String tname);
	//修改用户跟进情况
	public void updateClientInfo(String ta,String tb,String tc,String td,int tid);
	//添加客户 开户
	public int addBMSClient(BmsCpyclient bc);
	//修改用户  是否可用
	public void updateClientStatus(int status,int tid);
	//删除客户
	public void deleteClientByTid(int tid);
	//查询单个用户的跟进情况
	public BmsCpyclient selectOneClientByTid(int tid);
	//查询所有客户
	public ArrayList selectAllClient();
}
