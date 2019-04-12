package com.cn.hnny.service;

import com.cn.hnny.entity.UserRole;

public interface UserRoleService {
  int add(UserRole ur);
  int delete(String id);
  int batchDelete(String list[]);
}
