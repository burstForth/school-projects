package com.fei.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fei.daoa.newsDao;
import com.fei.entity.News;
import com.fei.entity.Page;
import com.fei.util.DatabaseUtil;


public class newsDaoImpl implements newsDao{
	private PreparedStatement pas=null;//链接对象
	private Connection conn=null;//数据货车
	private ResultSet rs=null;//结果集--查询时使用
	//创建数据库工具类
	DatabaseUtil da=new DatabaseUtil();
	public List<News> getAllnews() {
		//创建list对象接收值
		List<News> list = new ArrayList<News>();
		conn =da.getConnection();//获取链接--必不可少的--如果少了conn接收就会出现空值
		String sql="SELECT  nid,per,nei,sex FROM news";
		try {
			pas =conn.prepareStatement(sql);
			rs = pas.executeQuery();
			while(rs.next()) {
			News ne = new News();
			   ne.setNid(rs.getInt("nid"));
				ne.setPer(rs.getString("per"));
				ne.setNei(rs.getString("nei"));
				ne.setSex(rs.getString("sex"));
				//把ne获取的值保存到list集合里
				list.add(ne);
				//System.out.println(ne);
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			da.closeAll(rs, pas, conn);
		}
		return list;
	}
	
	
	public boolean getUpdate(News neww) {
		boolean flog = false;
		conn = da.getConnection();//创建链接
		String sql = "UPDATE news SET nei =? WHERE nid =?";//接受sql语句
		
		try {
		pas = conn.prepareStatement(sql);//接受查询到的sql值
		
		pas.setString(1, neww.getNei());
		pas.setInt(2, neww.getNid());
		
			
			 int i = pas.executeUpdate();
			if(i!=0) {
				System.out.println("添加成功");
				flog = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			da.closeAll(rs, pas, conn);
		}
		return flog;
	}



	public boolean delete(News tt) {
		boolean flog = false;
		conn = da.getConnection();
		String sql = "delete from news where nid=?";
		
		try {
			pas = conn.prepareStatement(sql);
			pas.setInt(1,tt.getNid());
			
			int ad = pas.executeUpdate();
			if(ad!=0) {
				flog = true;
				System.out.println("删除成功");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			da.closeAll(rs, pas, conn);
		}
		return flog;
	}



	public boolean insert(News qq) {
		boolean flog = false;
		//获取链接
		conn = da.getConnection();
		String sql = "insert into news (nei,per,sex) values (?,?,?)";
		 try {
			pas = conn.prepareStatement(sql);
			pas.setString(1, qq.getNei());
			pas.setString(2, qq.getPer());
			pas.setString(3, qq.getSex());
			
			int a = pas.executeUpdate();
			if(a!=0) {
				flog = true;
				System.out.println("添加成功");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			da.closeAll(rs, pas, conn);
		}
		 
		return flog;
	}

	//获取数据数量
		public int getNewsCount() {
			conn = da.getConnection();
			String sql = "select count(1) from news";
			int count = -1;		
			try {
				pas = conn.prepareStatement(sql);
				rs = pas.executeQuery();
				rs.next();
				count = rs.getInt(1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				da.closeAll(rs, pas, conn);
			}
			
			return count;
		}



		public List<News> getNewsa(int currPage,int pageSize) {
			conn = da.getConnection();
			List<News> list = new ArrayList<News>();
			String sql = "select nid,per,nei from news limit ?,?";
			News we = new News();
			try {
				pas = conn.prepareStatement(sql);
				pas.setInt(1,currPage);
				pas.setInt(2,pageSize);
				rs = pas.executeQuery();
				while(rs.next()) {
					News news = new News();
					news.setNid(rs.getInt("nid"));
					news.setPer(rs.getString("per"));
					news.setNei(rs.getString("nei"));
					list.add(news);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				da.closeAll(rs, pas, conn);
			}
			return list;
		}
		
	

}
