package com.yu.dao;

import java.sql.ResultSet;

import com.yu.jopo.Account;

public interface userDao {
	public ResultSet login(Account user);//µÇÂ½
	public int register(Account user);//×¢²á
	public ResultSet verification(Account user);//ÑéÖ¤
}
