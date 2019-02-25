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
		private Connection conn=null;//�������Ӷ���
		private PreparedStatement pa=null;//�������ݻ�
		private ResultSet rs=null;//����������Ա��ѯʱʹ��
		util util=new util();//ʵ�������ݿ⹤����
	public boolean login(User user) {
		boolean flog =false;
		conn=util.getConnection();//�������ݿ�
		String sql="select * from user where user=? and pass=?";//���������洢SQL���
		try {
			pa=conn.prepareStatement(sql);//�������ݿ�
			pa.setString(1, user.getUser());//Ӧ���Ǹ�sql�����ʺŸ�ֵ
			pa.setString(2, user.getPass());//ͬ��
			rs=pa.executeQuery();//�ý������ȡ���ҵ�����
			
			if(rs.next()) {//�жϽ�����Ƿ���ֵ
				flog=true;//��ֵ�Ļ���ֵΪ��ֵ
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.closeAll(conn, pa, rs);//�ر����е�����
		}
		return flog;
	}
	public List<Message> cha() {
		List<Message> list = new ArrayList();
		Message me=null;
		conn=util.getConnection();//�������ݿ�
		String sql="select * from mession";//���������洢SQL���
		try {
			pa=conn.prepareStatement(sql);//�������ݿ�
			rs=pa.executeQuery();//�ý������ȡ���ҵ�����
			
			while(rs.next()) {//�жϽ�����Ƿ���ֵ
				me=new Message();
				me.setMid(rs.getInt(1));
				me.setNei(rs.getString(2));
				list.add(me);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.closeAll(conn, pa, rs);//�ر����е�����
		}
		return list;
	}
	
	public boolean verification(String user) {
		boolean flog = false;
		conn=util.getConnection();//�������ݿ�
		String sql="select * from user where user = ?";//���������洢SQL���
		try {
			pa=conn.prepareStatement(sql);//�������ݿ�
			pa.setString(1, user);
			rs=pa.executeQuery();//�ý������ȡ���ҵ�����
			
			if(rs.next()) {//�жϽ�����Ƿ���ֵ
				flog=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			util.closeAll(conn, pa, rs);//�ر����е�����
		}
		return flog;
	}
	
	public boolean register(String user, String pass) {
		boolean flog = false;
		conn=util.getConnection();//�������ݿ�
		String sql="insert into user (user,pass) values(?,?)";//���������洢SQL���
		try {
			pa=conn.prepareStatement(sql);//�������ݿ�
			pa.setString(1, user);
			pa.setString(2, pass);
			int i=pa.executeUpdate();
			if(i>0) {
				flog=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			util.closeAll(conn, pa, rs);//�ر����е�����
		}
		return flog;
	}
}
