package com.mapper1.icbc1;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model1.icbc.icbc_mq_result;

public interface icbc_mq_resultMapper {
List<icbc_mq_result> findicbc_mq_result(@Param("qryid")int qryid);

void addmq_result(icbc_mq_result icbc_mq_result);

icbc_mq_result lasticbc_mq_result(@Param("qryid")int qryid);
}
