package com.fei.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseUtil {
	
	 String url="jdbc:mysql://localhost:3306/databaseweb";
	 String user="root";
	 String password="root";
	//构造方法中注册驱动
	public  DatabaseUtil(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	//获取连接
	public  Connection  getConnection(){
		try {
			return  DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	//关闭所有连接--不包含Statement类
    public  void  closeAll(ResultSet rs,PreparedStatement  pstmt,Connection  conn){
		try {
			if(rs!=null){
			rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(conn!=null){
				
				conn.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
