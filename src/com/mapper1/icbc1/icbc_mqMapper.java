package com.mapper1.icbc1;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model1.icbc.icbc_mq;

public interface icbc_mqMapper {
    //É¾³ý
	void del_icbc_mq(@Param("id")int id);
	//
	icbc_mq findmqbyicbc(@Param("icbc_id")int icbc_id);
	//
	icbc_mq findmqbyicbc2(@Param("icbc_id")int icbc_id);
	//
	void upmq(icbc_mq icbc_mq);
	//
	List<icbc_mq> allfindmq();
	//
	void savemq(icbc_mq icbc_mq);
	//
	icbc_mq findlastid();
	//
	icbc_mq findmqbyid(@Param("id")int id);
	//
	icbc_mq mqshbyid(@Param("id")int id);
	//
	List<icbc_mq> kjs_mq(@Param("bc_status")int bc_status);
	//
	int kjs_mq_count();
}
