package com.mapper.newAdd;
import java.util.ArrayList;
import com.model.newAdd.AssessCars;

public interface AssessCarsMapper {
	//修改单条数据
	public int updateOneACarsById(AssessCars assessCars);
	//删除单条数据
	public void deleteOneACarsById(int id);
	//查询单条数据
	public AssessCars selectOneACarsById(int id);
	//查询总数
	public int getSumAssessCars();
	//查询全部数据
	public ArrayList selectAllAssessCars(int page,int size);
}
