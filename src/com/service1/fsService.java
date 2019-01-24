package com.service1;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model1.fs;

public interface fsService {
public List<fs> ffs();
public List<fs> findbypy();
public List<fs> findfsbyckey(String appkey);
fs findfsbyid(int id);
}
