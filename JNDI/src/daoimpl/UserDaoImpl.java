package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.UserDao;
import entity.Message;
import entity.User;
import util.util;

public class UserDaoImpl implements UserDao{
		private Connection conn=null;//声明连接对象
		private PreparedStatement pa=null;//声明数据火车
		private ResultSet rs=null;//声明结果集以便查询时使用
		util util=new util();//实例化数据库工具类
	public boolean login(User user) {
		boolean flog =false;
		conn=util.getConnection();//链接数据库
		String sql="select * from user where user=? and pass=?";//声明变量存储SQL语句
		try {
			pa=conn.prepareStatement(sql);//操作数据库
			pa.setString(1, user.getUser());//应该是给sql语句的问号赋值
			pa.setString(2, user.getPass());//同上
			rs=pa.executeQuery();//用结果集获取查找的数据
			
			if(rs.next()) {//判断结果集是否有值
				flog=true;//有值的话赋值为真值
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.closeAll(conn, pa, rs);//关闭所有的链接
		}
		return flog;
	}
	public List<Message> cha() {
		List<Message> list = new ArrayList();
		Message me=null;
		conn=util.getConnection();//链接数据库
		String sql="select * from mession";//声明变量存储SQL语句
		try {
			pa=conn.prepareStatement(sql);//操作数据库
			rs=pa.executeQuery();//用结果集获取查找的数据
			
			while(rs.next()) {//判断结果集是否有值
				me=new Message();
				me.setMid(rs.getInt(1));
				me.setNei(rs.getString(2));
				list.add(me);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.closeAll(conn, pa, rs);//关闭所有的链接
		}
		return list;
	}
	
	public boolean verification(String user) {
		boolean flog = false;
		conn=util.getConnection();//链接数据库
		String sql="select * from user where user = ?";//声明变量存储SQL语句
		try {
			pa=conn.prepareStatement(sql);//操作数据库
			pa.setString(1, user);
			rs=pa.executeQuery();//用结果集获取查找的数据
			
			if(rs.next()) {//判断结果集是否有值
				flog=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			util.closeAll(conn, pa, rs);//关闭所有的链接
		}
		return flog;
	}
	
	public boolean register(String user, String pass) {
		boolean flog = false;
		conn=util.getConnection();//链接数据库
		String sql="insert into user (user,pass) values(?,?)";//声明变量存储SQL语句
		try {
			pa=conn.prepareStatement(sql);//操作数据库
			pa.setString(1, user);
			pa.setString(2, pass);
			int i=pa.executeUpdate();
			if(i>0) {
				flog=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			util.closeAll(conn, pa, rs);//关闭所有的链接
		}
		return flog;
	}
}
