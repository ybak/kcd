package com.mapper1.zjf;

import com.model1.zjf.fshistory;

public interface fshistoryMapper {
//根据id查询商户店
public fshistory fshistorybyfid(int fid);

//同步商户店添加记录
public void addfshistory(fshistory fshistory);
}
