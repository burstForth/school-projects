package com.cn.hnny.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnny.entity.Project;
import com.cn.hnny.mapper.ProjectMapper;
import com.cn.hnny.service.ProjectService;
import com.cn.hnny.util.RedisTemplateUtil;
@Service
public class ProjectServiceImpl implements ProjectService{
@Resource
private ProjectMapper projectmapper;
@Resource
private RedisTemplateUtil redistemplateutil;
public List<Project> findByPage(Map<String, Object> map) {
	// TODO Auto-generated method stub
	String key=map.get("currpage").toString()+map.get("rows").toString()+"prlist";
	List<Object> olist=redistemplateutil.lGet(key, 0, -1);
	List<Project> list=new  ArrayList<Project>();
	if(null!=olist &&olist.size()>0) {
		list=(List<Project>) olist.get(0);
		return list;
	}else{
	
	List<Project> ulist= projectmapper.findByPage(map);
	redistemplateutil.lSet(key, ulist,3);
	return  ulist;
	}
}

public int findByCount(Map<String, Object> map) {
	// TODO Auto-generated method stub
	return projectmapper.findByCount(map);
}

public Project findid(String pid) {
	Project project=new Project();
	project.setPid(pid);
    List<Project> list=projectmapper.find(project);
    if(null!=list && list.size()>0) {
    	return list.get(0);
    }
    return null;
}

public int update(Project t) {
	 return projectmapper.update(t);
	
}

public List<Project> findAllProject() {
	// TODO Auto-generated method stub
	return projectmapper.findProject(null);
}

public Project findidProject(String id) {
	Project n=(Project) redistemplateutil.get(id);
	System.out.println(id);
	if(n!=null) {	
		return n;
	}else {
		Project ne=new Project();
		ne.setPid(id);
        List<Project> list=projectmapper.findProject(ne);
        if(null!=list && list.size()>0) {
        	redistemplateutil.set(id, list.get(0),1);
        	return list.get(0);
        }
	}
		return null;
}

public int add(Project p) {
	// TODO Auto-generated method stub
	return projectmapper.add(p);
}

public int delete(String id) {
	// TODO Auto-generated method stub
	return projectmapper.delete(id);
}

public int batchDelete(String[] list) {
	// TODO Auto-generated method stub
	return projectmapper.batchDelete(list);
}

}
