package com.cn.hnny.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnny.entity.UserRole;
import com.cn.hnny.mapper.UserRoleMapper;
import com.cn.hnny.service.UserRoleService;
@Service
public class UserRoleServiceImpl implements UserRoleService{
@Resource
private UserRoleMapper userrolemapper;

public int add(UserRole ur) {
	// TODO Auto-generated method stub
	return userrolemapper.add(ur);
}

public int delete(String id) {
	// TODO Auto-generated method stub
	return userrolemapper.delete(id);
}

public int batchDelete(String[] list) {
	// TODO Auto-generated method stub
	return userrolemapper.batchDelete(list);
}
}
