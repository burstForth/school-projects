package com.fei.daoa;



import java.util.List;

import com.fei.entity.User;

public interface userDao {
	
public boolean userdao(User user);//登陆

public boolean register(User us);//注册

public boolean verification(User yu);//注册前验证数据库是否有该用户

public List<User> hu(int i);//查询出本id以外的用户和id

public User hui(int i);//查询用户
}