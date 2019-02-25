package com.fei.daoa;



import com.fei.entity.User;

public interface userDao {
	
public boolean userdao(User user);//登陆

public boolean register(User us);//注册

public boolean verification(User yu);//注册前验证数据库是否有该用户
}