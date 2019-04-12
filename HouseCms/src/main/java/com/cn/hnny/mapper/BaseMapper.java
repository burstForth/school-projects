package com.cn.hnny.mapper;

import java.util.List;
import java.util.Map;

public interface BaseMapper <T>{
	   //添加
		int add(T t);
		//修改
		int update(T t);
		//删除
		int delete(String id);
		//分页查询
		List<T> findByPage(Map<String, Object> map);
		//分页数量
		int findByCount(Map<String, Object>map);
		//条件查询
		List<T> find(T t);
		//多个id查询
		List<T> findByIds(List<String> list);
		//批量添加
		int batchAdd(List<T> list);
		//批量删除
		int batchDelete(String array[]);
}
