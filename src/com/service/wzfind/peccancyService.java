package com.service.wzfind;

import java.util.List;

import com.model.wzfind.peccancy;

public interface peccancyService {
	//违章查询
    public void addpeccancy(peccancy peccancy);
    //更新API返回结果
    public void uppeccancy(peccancy peccancy);
    //更新订单状态
    public void upporderstate(peccancy peccancy);
    //订单
    public void uporderno(peccancy peccancy);
    //表单查询
    public List<peccancy> peccancylist();
    //根据id查询peccancy
    public peccancy findpeccancybyid(int id);
}
