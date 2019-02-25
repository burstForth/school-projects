package com.fei.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fei.daoa.userDao;
import com.fei.entity.User;
import com.fei.util.DatabaseUtil;


public class UserDaoImpl implements userDao{
	
	private Connection con=null;//链接对象
	private PreparedStatement pstat=null;//数据货车
	private ResultSet rs = null;//结果集--查询时使用
	//数据库工具类
	DatabaseUtil dbu=new DatabaseUtil();
	
	
public boolean userdao(User user) {
	boolean flog = false;
	//获取连接
	con=dbu.getConnection();
	String sql="SELECT * FROM cunchu WHERE USER=? AND pass=?";
	//从数据库查找数据
	try {
		//创建货车
		 pstat = con.prepareStatement(sql);
		 //装货
		 pstat.setString(1, user.getUname());
		 pstat.setString(2, user.getUpass());
		 
		//用rs获取结果集
		rs=pstat.executeQuery();
		
		if(rs.next()) {
			flog = true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		dbu.closeAll(rs, pstat, con);
	}
	return flog;
}


public boolean register(User us) {
	boolean flog = false;
	con = dbu.getConnection();
	String sql ="insert into cunchu (user,pass) values (?,?)";
	try {
		pstat = con.prepareStatement(sql);
		pstat.setString(1, us.getUname());
		pstat.setString(2, us.getUpass());
		
		int i = pstat.executeUpdate();
		if(i!=0) {
			flog = true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return flog;
}



public boolean verification(User yu) {
		boolean flog = false;
		con = dbu.getConnection();
		String sql = "select * from cunchu where user=?";
		try {
			pstat = con.prepareStatement(sql);
			pstat.setString(1, yu.getUname());
			
			rs = pstat.executeQuery();
			if(rs.next()) {
				flog = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return flog;
}

}
