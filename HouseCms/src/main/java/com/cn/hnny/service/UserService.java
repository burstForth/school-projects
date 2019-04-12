package com.cn.hnny.service;

import java.util.List;
import java.util.Map;

import com.cn.hnny.entity.User;
import com.cn.hnny.vo.UserRoleMenuVo;

public interface UserService {
 User Login(String name,String pwd);
 List<UserRoleMenuVo> findUsersRoleMenuMap(Map<String, Object> map);
 List<User> findByPage(Map<String, Object> map);
 int findByCount(Map<String, Object> map);
 int delete(String id);
 int add(User u);
 int update(User u);
 User findid(String id);
 List<User> findUid(String uid);
 int batchDelete(String list[]);
 User findName(String name);
}
