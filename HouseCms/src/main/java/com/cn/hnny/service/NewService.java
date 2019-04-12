package com.cn.hnny.service;

import java.util.List;
import java.util.Map;

import com.cn.hnny.entity.New;

public interface NewService {
	
	New findntype(String ntype);
	List<New> findByPage(Map<String, Object> map);
	//分页数量
	int findByCount(Map<String, Object>map);
	New findid(String id);
	int delete(String id);
	int add(New n);
	int batchDelete(String list[]);
	int update(New n);
}
