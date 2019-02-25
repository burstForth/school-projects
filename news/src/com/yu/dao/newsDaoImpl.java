package com.yu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yu.jopo.Content;
import com.yu.util.util;

public class newsDaoImpl implements newsDao {
	private Connection  conn;
	private PreparedStatement  pa;
	private ResultSet  rs;
	util ut=new util();
	@Override
	public int insert(String topic) {
		// TODO Auto-generated method stub
		conn=ut.getConnection();
		String sql="insert into subject(topic) values(?)";
		int i=-1;
		try {
			pa=conn.prepareStatement(sql);
			pa.setString(1, topic);
			i=pa.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	public int insertone(Content con) {
		int o=-1; 
		conn=ut.getConnection();
		String sql="insert into content(s_sid,news,author) values(?,?,?)";
		try {
			pa=conn.prepareStatement(sql);
			pa.setInt(1, con.getS_sid());
			pa.setString(2, con.getNews());
			pa.setString(3, con.getAuthor());
			o=pa.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}

	public int delete(int i) {
		int o=-1; 
		conn=ut.getConnection();
		String sql="delete from subject where sid=?";
		try {
			pa=conn.prepareStatement(sql);
			pa.setInt(1, i);
			o=pa.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return o;
	}
	
	public int deleteone(int i) {
		int o=-1; 
		conn=ut.getConnection();
		String sql="delete from content where cid=?";
		try {
			pa=conn.prepareStatement(sql);
			pa.setInt(1, i);
			o=pa.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}

	public int update(int s,String topic) {
		conn=ut.getConnection();
		String sql="UPDATE subject SET topic =? WHERE sid =?";
		int i=-1;
		try {
			pa=conn.prepareStatement(sql);
			pa.setString(1, topic);
			pa.setInt(2, s);
			i=pa.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	@Override
	public int updateone(int s,int cid,String news,String author) {
		int i=-1;
		conn=ut.getConnection();
		String sql="UPDATE content SET news=?,author=?,s_sid=? WHERE cid =?";
		try {
			pa=conn.prepareStatement(sql);
			pa.setString(1, news);
			pa.setString(2, author);
			pa.setInt(3,s);
			pa.setInt(4, cid);
			i=pa.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	
	public int getNewsCount() {
		conn=ut.getConnection();
		String sql="select count(1) from content";
		int i=0;
		try {
			pa=conn.prepareStatement(sql);
			rs=pa.executeQuery();
			rs.next();
			i = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public ResultSet getAllNews(int currPage,int pageSize) {
		
		conn=ut.getConnection();
		//多表查询用limit如下 desc为倒序 asc反之
		String sql="SELECT * FROM content,SUBJECT WHERE SUBJECT.`sid`=content.`s_sid` ORDER BY  cid desc LIMIT ?,?";
		try {
			pa=conn.prepareStatement(sql);
			pa.setInt(1, (currPage-1)*pageSize);
			pa.setInt(2, pageSize);
			rs=pa.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	
	public ResultSet topic() {
		conn=ut.getConnection();
		String sql="select * from subject";
		try {
			pa=conn.prepareStatement(sql);
			rs=pa.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}



}
