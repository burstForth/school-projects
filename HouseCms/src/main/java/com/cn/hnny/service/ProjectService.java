package com.cn.hnny.service;

import java.util.List;
import java.util.Map;

import com.cn.hnny.entity.Project;

public interface ProjectService {
	   List<Project> findByPage(Map<String, Object> map);
	   int findByCount(Map<String, Object> map);
	   Project findid(String id);
	   int update(Project r);
	   List<Project> findAllProject();
	   Project findidProject(String id);
	   int add(Project p);
	   int delete(String id);
	   int batchDelete(String list[]);
}
