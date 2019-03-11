package com.controller.erp_icbc.YunXin.seats;
import org.springframework.beans.factory.InitializingBean;
public class AddSeat1 implements InitializingBean{
	@Override
	public void afterPropertiesSet() throws Exception {
		PoolCache1.initContainer();
	}
}
