package service;

import java.util.List;

import dao.UserDao;
import dao.messageDao;
import daoimpl.UserDaoImpl;
import daoimpl.messageDaoImpl;
import entity.Message;
import entity.User;
import entity.page;

public class serviceDaoImpl implements serviceDao{
	public boolean login(User user) {//实现接口方法
		UserDao dao =new UserDaoImpl();//实例化dao层
		boolean login= dao.login(user);//调用dao层方法
		return login;
	}
	public List<Message> cha() {
		UserDao dao = new UserDaoImpl();
		return dao.cha();
	}
	public boolean verification(String user) {
		UserDao dao = new UserDaoImpl();
		return dao.verification(user);
	}
	public boolean register(String user, String pass) {
		UserDao dao = new UserDaoImpl();
		return dao.register(user, pass);
	}
	public boolean addTo(String nei) {
		messageDao me=new messageDaoImpl();
		return me.addTo(nei);
	}
	public boolean delete() {
		messageDao me=new messageDaoImpl();
		return me.delete();
	}
	
	public boolean up(String file) {
		messageDao me=new messageDaoImpl();
		return me.up(file);
	}
	
	public page save(int currentPage,int pageSize) {
		page p=new page();
		p.setCurrentPage(currentPage);
		p.setPageSize(pageSize);
		messageDao me=new messageDaoImpl();
		
		int count = me.count();
		//System.out.println(count);
		//获取总页数
		p.setTotalContent(count);
		List<page> list=me.find(p.getCurrentPage(),pageSize);
		p.setAllnews(list);
		return p;
	}
}
