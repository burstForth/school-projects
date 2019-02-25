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
	//���췽����ע������
	public  DatabaseUtil(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	//��ȡ����
	public  Connection  getConnection(){
		try {
			return  DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	//�ر���������--������Statement��
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
