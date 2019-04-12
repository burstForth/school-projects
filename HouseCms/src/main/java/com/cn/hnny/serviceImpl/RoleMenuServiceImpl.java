package com.cn.hnny.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnny.entity.RoleMenu;
import com.cn.hnny.mapper.RoleMapper;
import com.cn.hnny.mapper.RoleMenuMapper;
import com.cn.hnny.service.RoleMenuService;
@Service
public class RoleMenuServiceImpl  implements RoleMenuService {
@Resource
private RoleMenuMapper rolemenumapper;

public int add(RoleMenu rm) {
	// TODO Auto-generated method stub
	return rolemenumapper.add(rm);
}

public int delete(String id) {
	// TODO Auto-generated method stub
	return rolemenumapper.delete(id);
}

public int batchDelete(String[] list) {
	// TODO Auto-generated method stub
	return rolemenumapper.batchDelete(list);
}
}
