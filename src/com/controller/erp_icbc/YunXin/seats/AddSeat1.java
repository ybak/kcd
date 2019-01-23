package com.controller.erp_icbc.YunXin.seats;
import org.springframework.beans.factory.InitializingBean;
/**
 * 在bean初始化后初始化数据
 * @Description:TODO
 * @author:LiWang
 */
public class AddSeat1 implements InitializingBean{
	@Override
	public void afterPropertiesSet() throws Exception {
		Seats seats=new Seats(900,200);//被占用的有效期  在线的有限期
		PoolCache1.initContainer(seats);
	}
}
