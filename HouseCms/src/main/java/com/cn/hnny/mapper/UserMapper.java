package com.cn.hnny.mapper;

import java.util.List;
import java.util.Map;

import com.cn.hnny.entity.User;
import com.cn.hnny.vo.UserRoleMenuVo;

public interface UserMapper extends BaseMapper<User> {
	List<UserRoleMenuVo> findUsersRoleMenuMap(Map<String, Object> map);
	 UserRoleMenuVo findid(String id);
}
