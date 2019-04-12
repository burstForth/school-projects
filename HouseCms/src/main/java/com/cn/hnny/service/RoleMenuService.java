package com.cn.hnny.service;

import com.cn.hnny.entity.RoleMenu;

public interface RoleMenuService {
	int add(RoleMenu rm);
	  int delete(String id);
	  int batchDelete(String list[]);
}
