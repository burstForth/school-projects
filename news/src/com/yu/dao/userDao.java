package com.yu.dao;

import java.sql.ResultSet;

import com.yu.jopo.Account;

public interface userDao {
	public ResultSet login(Account user);//��½
	public int register(Account user);//ע��
	public ResultSet verification(Account user);//��֤
}
