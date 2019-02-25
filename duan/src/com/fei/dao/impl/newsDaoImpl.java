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
import com.fei.entity.User;
import com.fei.entity.du;
import com.fei.util.DatabaseUtil;


public class newsDaoImpl implements newsDao{
	private PreparedStatement pas=null;//���Ӷ���
	private Connection conn=null;//���ݻ���
	private ResultSet rs=null;//�����--��ѯʱʹ��
	//�������ݿ⹤����
	DatabaseUtil da=new DatabaseUtil();
	public List<News> getAllnews() {
		//����list�������ֵ
		List<News> list = new ArrayList<News>();
		conn =da.getConnection();//��ȡ����--�ز����ٵ�--�������conn���վͻ���ֿ�ֵ
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
				//��ne��ȡ��ֵ���浽list������
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
		conn = da.getConnection();//��������
		String sql = "UPDATE news SET nei =? WHERE nid =?";//����sql���
		
		try {
		pas = conn.prepareStatement(sql);//���ܲ�ѯ����sqlֵ
		
		pas.setString(1, neww.getNei());
		pas.setInt(2, neww.getNid());
		
			
			 int i = pas.executeUpdate();
			if(i!=0) {
				System.out.println("��ӳɹ�");
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



	public boolean delete(int i) {
		boolean flog = false;
		conn = da.getConnection();
		String sql = "delete from du where did=?";
		try {
			pas = conn.prepareStatement(sql);
			pas.setInt(1,i);
			
			int ad = pas.executeUpdate();
			if(ad!=0) {
				flog = true;
				System.out.println("ɾ���ɹ�");
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
		//��ȡ����
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
				System.out.println("��ӳɹ�");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			da.closeAll(rs, pas, conn);
		}
		 
		return flog;
	}

	//��ȡ��������
		public int getNewsCount(int i) {
			conn = da.getConnection();
			String sql = "select count(1) from du where id=?";
			int count = -1;		
			try {
				pas = conn.prepareStatement(sql);
				pas.setInt(1, i);
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



		public List<du> getNewsa(int i,int currPage,int pageSize) {
			conn = da.getConnection();
			List<du> list = new ArrayList<du>();
			String sql = "select did,nei,id,uid from du where id=? limit ?,?";
			try {
				pas = conn.prepareStatement(sql);
				pas.setInt(1, i);
				pas.setInt(2,currPage);
				pas.setInt(3,pageSize);
				rs = pas.executeQuery();
				while(rs.next()) {
					du du = new du();
					du.setFid(rs.getInt(1));
					du.setNei(rs.getString(2));
					du.setId(rs.getInt(3));
					du.setUid(rs.getInt(4));
					list.add(du);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				da.closeAll(rs, pas, conn);
			}
			return list;
		}


		public boolean tian(du du) {
			boolean flog=false;
			conn = da.getConnection();
			String sql = "insert into du (nei,id,uid) values (?,?,?)";
			try {
				pas = conn.prepareStatement(sql);
				pas.setString(1, du.getNei());
				pas.setInt(2, du.getId());
				pas.setInt(3, du.getUid());
				int o = pas.executeUpdate();
				if(o>0) {
					flog=true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				da.closeAll(rs, pas, conn);
			}
			return flog;
		}

		public User huo(User us) {
			List list = new ArrayList<du>();
			conn = da.getConnection();
			String sql = "select id,user from cunchu where user=?";
			//select * from student right join course on student.ID=course.ID--������
				
			try {
				pas = conn.prepareStatement(sql);
				pas.setString(1, us.getUser());
				rs = pas.executeQuery();
				while (rs.next()) {
					us = new User();
					us.setUser(rs.getString("user"));
					us.setId(rs.getInt("id"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				da.closeAll(rs, pas, conn);
			}
			return us;
		}
		
		public List<du> huo1(du du) {
			List list = new ArrayList<du>();
			du us =null;
			conn = da.getConnection();
			String sql = "select did,nei,id,uid from du where id=?";
			//select * from student right join course on student.ID=course.ID--������
				
			try {
				pas = conn.prepareStatement(sql);
				pas.setInt(1, du.getId());
				rs = pas.executeQuery();
				while (rs.next()) {
					us = new du();
					us.setFid(rs.getInt("did"));	
					us.setNei(rs.getString("nei"));
					us.setId(rs.getInt("id"));
					us.setUid(rs.getInt("uid"));
					list.add(us);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				da.closeAll(rs, pas, conn);
			}
			return list;
		}


	
		public du huo(int i) {
			du us =null;
			conn = da.getConnection();
			String sql = "select did,nei,id,uid from du where did=?";
			//select * from student right join course on student.ID=course.ID--������
				
			try {
				pas = conn.prepareStatement(sql);
				pas.setInt(1, i);
				rs = pas.executeQuery();
				while (rs.next()) {
					us = new du();
					us.setFid(rs.getInt("did"));	
					us.setNei(rs.getString("nei"));
					us.setId(rs.getInt("id"));
					us.setUid(rs.getInt("uid"));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				da.closeAll(rs, pas, conn);
			}
			return us;
		}
		
	

}
