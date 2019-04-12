package com.cn.hnny.serviceImpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnny.entity.Role;
import com.cn.hnny.mapper.RoleMapper;
import com.cn.hnny.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService{
@Resource
private RoleMapper rolemapper;

public List<Role> findAll() {
	// TODO Auto-generated method stub
	Role r=new Role();
	r.setRstatus(1);
	return rolemapper.find(r);
}

public int add(Role r) {
	// TODO Auto-generated method stub
	return rolemapper.add(r);
}

public int delete(String id) {
	// TODO Auto-generated method stub
	return rolemapper.delete(id);
}

public int batchDelete(String[] list) {
	// TODO Auto-generated method stub
	return rolemapper.batchDelete(list);
}

public List<Role> findByPage(Map<String, Object> map) {
	// TODO Auto-generated method stub
	return rolemapper.findByPage(map);
}

public int findByCount(Map<String, Object> map) {
	// TODO Auto-generated method stub
	return rolemapper.findByCount(map);
}

public List<Role> findmidtype(String rid, String type) {
	// TODO Auto-generated method stub
	Role r=new Role();
	r.setRid(rid);
	r.setType(type);
	return rolemapper.findmidtype(r);	
}

public Role findid(String rid) {
	// TODO Auto-generated method stub
	Role r=new Role();
	r.setRid(rid);
	List<Role> list=rolemapper.findmidtype(r);
	if(null!=list && list.size()>0) {
	return list.get(0);
	}else {
    return null;
	}
	}

public int update(Role r) {
	// TODO Auto-generated method stub
	return rolemapper.update(r);
}

public Role findName(String name) {
	// TODO Auto-generated method stub
	Role r=new Role();
	r.setRname(name);
	List<Role> list=rolemapper.find(r);
	if(null!=list && list.size()>0) {
	return list.get(0);
	}else {
    return null;
	}
}
}
