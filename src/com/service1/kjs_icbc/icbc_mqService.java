package com.service1.kjs_icbc;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model1.icbc.icbc_mq;

public interface icbc_mqService {
	//É¾³ý
	void del_icbc_mq(int id);
	//
	icbc_mq findmqbyicbc(int icbc_id);
	//
	icbc_mq findmqbyicbc2(int icbc_id);
	//
	void upmq(icbc_mq icbc_mq);
	//
	List<icbc_mq> allfindmq();
	//
	void savemq(icbc_mq icbc_mq);
	//
	icbc_mq findlastid();
	//
	icbc_mq findmqbyid(int id);
	//
	icbc_mq mqshbyid(int id);
	//
	List<icbc_mq> kjs_mq(int bc_status);
	//
	int kjs_mq_count();
}
