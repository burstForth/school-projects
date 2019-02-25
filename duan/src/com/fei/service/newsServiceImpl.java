package com.fei.service;

import com.fei.entity.News;
import com.fei.entity.Page;
import com.fei.entity.User;
import com.fei.entity.du;
import com.fei.daoa.*;

import java.util.List;

import com.fei.dao.impl.*;

public class newsServiceImpl implements newsService {

	
	public boolean deng(User user) {
		boolean flog = false;
		userDao u = new UserDaoImpl();
		boolean usere= u.userdao(user);
			if(usere) {
				flog=true;
			}
		return flog;
	}

	
	public boolean zhu(User user) {
		boolean flog = false;
		userDao u = new UserDaoImpl();
		boolean usere= u.register(user);
		if(usere) {
			flog = true;
		}
		return flog;
	}
	public boolean yan(User user) {
		boolean flog = false;
		userDao u = new UserDaoImpl();
		boolean usere= u.verification(user);
		if(usere) {
			flog=true;
		}
		return flog;
	}
	public List<News> cha() {
		newsDao u = new newsDaoImpl();
		List<News> usere= u.getAllnews();
		
		return usere;
	}
	public boolean zeng(News news) {
		boolean flog = false;
		newsDao u = new newsDaoImpl();
		boolean usere= u.insert(news);
		if(usere) {
			flog=true;
		}
		return flog;
	}
	public boolean shan(int i) {
		boolean flog = false;
		newsDao u = new newsDaoImpl();
		boolean usere= u.delete(i);
		if(usere) {
			flog=true;
		}
		return flog;
	}
	public boolean gai(News news) {
		boolean flog = false;
		newsDao u = new newsDaoImpl();
		boolean usere= u.getUpdate(news);
		if(usere) {
			flog=true;
		}
		return flog;
	}
	public Page huo( int i,int currPage, int pageSize) {
		
			//设置当前页和页面中的数据大小
			Page page = new Page();
			page.setCurrPage(currPage);//设置当前页
			page.setPageSize(pageSize);//页面中能放多少条数据
			//计算总记录数
			newsDao nd = new newsDaoImpl();
			//查询数据层获取总记录数
			int count = nd.getNewsCount(i);
			//保存page类中并根据总记录数计算总页数
			page.setTotalCount(count);
			int n=page.getTotalCount();
			if(n==pageSize+1) {
				page.setPageSize(pageSize+1);
			}
			page.getTotalCount();
			//获取dao层的分页数据
			List<du> list = nd.getNewsa(i ,(currPage-1)*pageSize,pageSize);
				if(list.isEmpty()) {
					List<du> lis = nd.getNewsa(i,(currPage-2)*pageSize,pageSize);
					page.setNewsList(lis);
					return page;
				}
			//}
			//将数据保存值page类中
				page.setNewsList(list);
			//返回控制层 已封装好的page数据
				return page;
	}


	
	public List<User> hu(int i) {
		userDao u = new UserDaoImpl();
		List<User> usere= u.hu(i);
		return usere;
	}


	
	public boolean ti(du du) {
		boolean flog = false;
		newsDao u = new newsDaoImpl();
		boolean a = u.tian(du);
		if(a) {
			flog=true;
		}
		return flog;
	}
	public User huo(User us) {
		newsDao u = new newsDaoImpl();
		User sd=u.huo(us);
		return sd;
	}
	public List<du> huo1(du du) {
		newsDao u = new newsDaoImpl();
		List<du> sd=u.huo1(du);
		return sd;
	}

	
	public du huo(int i) {
		newsDao u = new newsDaoImpl();
		du b=u.huo(i);
		return b;
	}
	
	public User hui(int i) {
		userDao u = new UserDaoImpl();
		User k=u.hui(i);
		return k;
	}



}
