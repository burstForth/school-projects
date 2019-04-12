package com.cn.hnny.mapper;


import java.util.List;

import com.cn.hnny.entity.Role;

public interface RoleMapper  extends BaseMapper<Role>{
   List<Role> findmidtype(Role r);
}
