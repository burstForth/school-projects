package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.messageDao;
import entity.page;
import util.util;

public class messageDaoImpl implements messageDao {
	private Connection conn=null;
	private PreparedStatement pa=null;
	private ResultSet rs=null;
	util util=new util();
	public boolean addTo(String nei) {
		boolean flog=false;
		conn=util.getConnection();
		String sql="insert into mession(nei) values(?)";
		try {
			pa=conn.prepareStatement(sql);
			pa.setString(1, nei);
		
			int i=pa.executeUpdate();
			if(i>0) {
				flog=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.closeAll(conn, pa, rs);
		}
		return flog;
	}

	public boolean delete() {
		boolean flog=false;
		conn=util.getConnection();//获取连接
		String sql="delete from mession";//设置sql语句
		try {
			pa=conn.prepareStatement(sql);//预加载sql语句
			int i =pa.executeUpdate();
			if(i>0) {
				flog=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.closeAll(conn, pa, rs);
		}
		return flog;
	}

	public boolean up(String up) {
		boolean f=false;
		conn=util.getConnection();
		String sql="insert into file (file) values(?)";
		try {
			pa=conn.prepareStatement(sql);
			pa.setString(1, up);
			int i=pa.executeUpdate();
			if(i>0) {
				f=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.closeAll(conn, pa, rs);
		}
		return f;
	}

	public int count() {
		conn=util.getConnection();
		String sql="select count(1) from page";
		int count=0;
		try {
			pa=conn.prepareStatement(sql);
			rs=pa.executeQuery();
			if(rs.next()) {
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.closeAll(conn, pa, rs);
		}
		return count;
	}
	public List<page> find(int currentPage,int pageSize) {
		
		List<page> list=new ArrayList();
		conn=util.getConnection();
		String sql="select content from page limit ?,?";
		try {
			pa=conn.prepareStatement(sql);
			pa.setInt(1, (currentPage-1)*pageSize);
			pa.setInt(2, pageSize);
			rs=pa.executeQuery();
			while(rs.next()) {
				page page =new page();
				page.setContent(rs.getString(1));
				list.add(page);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.closeAll(conn, pa, rs);
		}
		return list;
	}



}
