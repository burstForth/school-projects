package com.fei.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fei.daoa.userDao;
import com.fei.entity.User;
import com.fei.util.DatabaseUtil;


public class UserDaoImpl implements userDao{
	
	private Connection con=null;//���Ӷ���
	private PreparedStatement pstat=null;//���ݻ���
	private ResultSet rs = null;//�����--��ѯʱʹ��
	//���ݿ⹤����
	DatabaseUtil dbu=new DatabaseUtil();
	
	
public boolean userdao(User user) {
	boolean flog = false;
	//��ȡ����
	con=dbu.getConnection();
	String sql="SELECT * FROM cunchu WHERE USER=? AND pass=?";
	//�����ݿ��������
	try {
		//��������
		 pstat = con.prepareStatement(sql);
		 //װ��
		 pstat.setString(1, user.getUname());
		 pstat.setString(2, user.getUpass());
		 
		//��rs��ȡ�����
		rs=pstat.executeQuery();
		
		if(rs.next()) {
			flog = true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		dbu.closeAll(rs, pstat, con);
	}
	return flog;
}


public boolean register(User us) {
	boolean flog = false;
	con = dbu.getConnection();
	String sql ="insert into cunchu (user,pass) values (?,?)";
	try {
		pstat = con.prepareStatement(sql);
		pstat.setString(1, us.getUname());
		pstat.setString(2, us.getUpass());
		
		int i = pstat.executeUpdate();
		if(i!=0) {
			flog = true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return flog;
}



public boolean verification(User yu) {
		boolean flog = false;
		con = dbu.getConnection();
		String sql = "select * from cunchu where user=?";
		try {
			pstat = con.prepareStatement(sql);
			pstat.setString(1, yu.getUname());
			
			rs = pstat.executeQuery();
			if(rs.next()) {
				flog = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return flog;
}

}
