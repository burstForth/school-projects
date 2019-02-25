package com.yu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

import com.yu.jopo.Account;
import com.yu.util.util;

public class userDaoImpl implements userDao {
	private Connection conn=null;
	private PreparedStatement pa=null;
	private ResultSet rs=null;
	util ut=new util();
	public ResultSet login(Account user) {
		conn=ut.getConnection();
		String sql="select * from account where accountnumber=? and password=?";
		try {
			pa=conn.prepareStatement(sql);
			pa.setString(1, user.getAccountNumber());
			pa.setString(2, user.getPassword());
			rs=pa.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	
	public int register(Account user) {
		conn=ut.getConnection();
		int i=0;
		String sql="INSERT INTO account (accountNumber,PASSWORD) VALUES (?,?)";
		try {
			pa=conn.prepareStatement(sql);
			pa.setString(1, user.getAccountNumber());
			pa.setString(2, user.getPassword());
			i=pa.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public ResultSet verification(Account user) {
		conn=ut.getConnection();
		String sql="select * from account where accountNumber=?";
		try {
			pa=conn.prepareStatement(sql);
			pa.setString(1, user.getAccountNumber());
			rs=pa.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

}
