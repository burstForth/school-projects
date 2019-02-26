package com.fei.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fei.pojo.books;
import com.fei.pojo.order;
import com.fei.pojo.shopping;
import com.fei.util.util;

public class contentImpl implements content {
	private PreparedStatement pa=null;//链接对象
	private Connection conn=null;//数据货车
	private ResultSet rs=null;//结果集--查询时使用
	util u=new util();
	books b=null;
	shopping ss=null;
	order oo=null;
	
	public int getCount() {
		conn=u.getConnection();
		String sql ="select count(1) from books";
		int i=-1;
		try {
			pa=conn.prepareStatement(sql);
			rs=pa.executeQuery();
			rs.next();
			i=rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			u.closeAll(conn, pa, rs);
		}
		return i;
	}
	public int getCountOne() {
		conn=u.getConnection();
		String sql ="select count(1) from shopping";
		int i=-1;
		try {
			pa=conn.prepareStatement(sql);
			rs=pa.executeQuery();
			rs.next();
			i=rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			u.closeAll(conn, pa, rs);
		}
		return i;
	}
	public int getCountOrder() {
		conn=u.getConnection();
		String sql ="select count(1) from ding";
		int i=-1;
		try {
			pa=conn.prepareStatement(sql);
			rs=pa.executeQuery();
			rs.next();
			i=rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			u.closeAll(conn, pa, rs);
		}
		return i;
	}
	public List<books> getBooksIntro(int d,int z) {
		String sql ="select * from books limit ?,?";
		List<books> list=new ArrayList();
		conn=u.getConnection();
		try {
			pa=conn.prepareStatement(sql);
			pa.setInt(1, (d-1)*z);
			pa.setInt(2, z);
			rs=pa.executeQuery();
			while(rs.next()) {
				b=new books();
				b.setId(rs.getInt(1));
				b.setBook(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPress(rs.getString(4));
				b.setTime(rs.getDate(5));
				b.setIntro(rs.getString(6));
				b.setPrice(rs.getFloat(7));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			u.closeAll(conn, pa, rs);
		}
		return list;
	}
	
	public List<books> getIntro(int i) {
		String sql ="select * from books where id=?";
		conn=u.getConnection();
		List<books> list=new ArrayList();
		try {
			pa=conn.prepareStatement(sql);
			pa.setInt(1,i);
			rs=pa.executeQuery();
			while(rs.next()) {
				b=new books();
				b.setId(rs.getInt(1));
				b.setBook(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPress(rs.getString(4));
				b.setTime(rs.getDate(5));
				b.setIntro(rs.getString(6));
				b.setPrice(rs.getFloat(7));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			u.closeAll(conn, pa, rs);
		}
	return list;
	}
	
	public List<order> getOrder(int d,int z) {
		String sql ="select * from ding ORDER BY id desc";
		List<order> list=new ArrayList();
		conn=u.getConnection();
		try {
			pa=conn.prepareStatement(sql);
			
			rs=pa.executeQuery();
			while(rs.next()) {
				oo=new order();
				oo.setId(rs.getInt(1));
				oo.setBook(rs.getString(2));
				oo.setPrice(rs.getFloat(3));
				oo.setSid(rs.getInt(4));
				list.add(oo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			u.closeAll(conn, pa, rs);
		}
		return list;
	}

	public List<shopping> getShopping() {
		String sql ="select * from shopping ORDER BY id desc";
		List<shopping> list=new ArrayList();
		conn=u.getConnection();
		try {
			pa=conn.prepareStatement(sql);
			//pa.setInt(1, (d-1)*z);
			//pa.setInt(2, z);
			rs=pa.executeQuery();
			while(rs.next()) {
				ss=new shopping();
				ss.setId(rs.getInt(1));
				ss.setBook(rs.getString(2));
				ss.setPrice(rs.getFloat(3));
				list.add(ss);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			u.closeAll(conn, pa, rs);
		}
		return list;
	}

	@Override
	public int insertOne(int i) {
		int p=-1;
		String sql ="INSERT INTO shopping(book,price) SELECT book,price FROM books WHERE id=?";
		conn=u.getConnection();
		try {
			pa=conn.prepareStatement(sql);
			pa.setInt(1, i);
			p=pa.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			u.closeAll(conn, pa, rs);
		}
		return p;
	}

	public int insertTwo(int i) {
		int p=-1;
		String sql ="INSERT INTO ding(book,price,sid) SELECT book,price,id FROM shopping WHERE id=?";
		conn=u.getConnection();
		try {
			pa=conn.prepareStatement(sql);
			pa.setInt(1, i);
			p=pa.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			u.closeAll(conn, pa, rs);
		}
		return p;
	}
	
	public int delete(int id) {
		int p=-1;
		String sql ="delete from shopping where id=?";
		conn=u.getConnection();
		try {
			pa=conn.prepareStatement(sql);
			pa.setInt(1, id);
			p=pa.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			u.closeAll(conn, pa, rs);
		}
		return p;
	}

}
