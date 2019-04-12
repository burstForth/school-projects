package com.cn.hnny.service;

import java.util.List;
import java.util.Map;

import com.cn.hnny.entity.Role;

public interface RoleService {
   List<Role> findAll();
   int update(Role r);
   int add(Role r);
   int delete(String id);
   int batchDelete(String list[]);
   //��ҳ��ѯ
    List<Role> findByPage(Map<String, Object> map);
		//��ҳ����
	int findByCount(Map<String, Object>map);
    List<Role> findmidtype(String rid,String type);
    Role findid(String rid);
    Role findName(String name);
}
