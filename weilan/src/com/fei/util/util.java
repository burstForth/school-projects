package com.fei.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class util {
	private Connection conn;
	String url="jdbc:mysql://localhost:3306/book";
	public util() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection getConnection() {
		try {
			conn=DriverManager.getConnection(url,"root", "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public void closeAll(Connection conn,PreparedStatement pa,ResultSet rs) {
		try {
			if(rs!=null){
			rs.close();
			}
			if(pa!=null){
				pa.close();
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
