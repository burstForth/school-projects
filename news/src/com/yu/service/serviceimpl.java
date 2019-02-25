package com.yu.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yu.dao.newsDao;
import com.yu.dao.newsDaoImpl;
import com.yu.dao.userDao;
import com.yu.dao.userDaoImpl;
import com.yu.jopo.Account;
import com.yu.jopo.Content;
import com.yu.jopo.Page;
import com.yu.jopo.Subject;
import com.yu.jopo.pageList;
import com.yu.util.util;

public class serviceimpl implements ServiceDao {
	private Connection conn=null;
	private PreparedStatement pa=null;
	private ResultSet rs=null;
	util ut=new util();
	public boolean login(Account user) {
		boolean flog=false;
		userDao dao = new userDaoImpl();
		rs=dao.login(user);
		try {
			if(rs.next()) {
				flog=true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			ut.closeAll(conn,pa,rs);
		}
		return flog;
	}

	public boolean register(Account user) {
		boolean flog=false;
		userDao dao = new userDaoImpl();
		int i=dao.register(user);
		System.out.println(i);
			if(i>0) {
				flog=true;
			}
		ut.closeAll(conn,pa,rs);	
		return flog;
	}

	public boolean verification(Account user) {
		boolean flog=false;
		userDao dao = new userDaoImpl();
		rs=dao.verification(user);
		try {
			if(rs.next()) {
				flog=true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			ut.closeAll(conn,pa,rs);
		}
		return flog;	
	}


	public boolean insert(String topic) {
		boolean flog=false;
		newsDao dao =new newsDaoImpl();
		int i=dao.insert(topic);
		if(i>0) {
			flog=true;
		}
		ut.closeAll(conn,pa,rs);
		return flog;
	}

	public boolean insertone(Content con) {
		newsDao dao =new newsDaoImpl();
		int o = dao.insertone(con);
		boolean t=false;
		if(o>0) {
			t=true;
		}
		ut.closeAll(conn,pa,rs);
		return t;
	}
	public boolean delete(int i) {
		boolean t=false;
		newsDao dao =new newsDaoImpl();
		int o =dao.delete(i);
		if(o>0) {
			t=true;
		}
		ut.closeAll(conn,pa,rs);
		return t;
	}
	public boolean deleteone(int i) {
		boolean t=false;
		newsDao dao =new newsDaoImpl();
		int o =dao.deleteone(i);
		if(o>0) {
			t=true;
		}
		ut.closeAll(conn,pa,rs);
		return t;
	}
	
	public boolean update(int s,String topic) {
		boolean flog=false;
		newsDao dao =new newsDaoImpl();
		int i=dao.update(s, topic);
		if(i>0) {
			flog=true;
		}
		ut.closeAll(conn,pa,rs);
		return flog;
	}
public boolean updateone(int s,int cid,String news,String author) {
	boolean flog=false;
	newsDao dao =new newsDaoImpl();
	int i=dao.updateone(s,cid,news,author);
	if(i>0) {
		flog=true;
	}
	ut.closeAll(conn,pa,rs);
		return flog;
	}
	
	public Page getAllNews(int currPage,int pageSize) {
		Page p=new Page();
		
		pageList pageList=null;
		Content con=null;
		Subject su=null;
		List<pageList> list=new ArrayList();
		
		
		newsDao dao =new newsDaoImpl();
		int i=dao.getNewsCount();
		p.setCurrCount(currPage);
		p.setCount(i);//¼ÆËã×ÜÒ³Êý
		
		rs=dao.getAllNews(p.getCurrCount(),pageSize);
		try {
			while(rs.next()){
				pageList =new pageList();
				pageList.setCid(rs.getInt(1));
				pageList.setNews(rs.getString(2));
				pageList.setAuthor(rs.getString(3));
				pageList.setS_sid(rs.getInt(4));
				pageList.setSid(rs.getInt(5));
				pageList.setTopic(rs.getString(6));
			    list.add(pageList);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ut.closeAll(conn,pa,rs);
		}
		p.setList(list);
		//System.out.println(p.getList());
		return p;
	}

	
	public List<Subject> topic() {
		newsDao dao =new newsDaoImpl();
		List<Subject> list=new ArrayList();
		Subject su=null;
		rs=dao.topic();
		try {
			while(rs.next()) {
				su= new Subject();
				su.setSid(rs.getInt(1));
				su.setTopic(rs.getString(2));
				list.add(su);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			ut.closeAll(conn,pa,rs);
		}
		return list;
	}

}
