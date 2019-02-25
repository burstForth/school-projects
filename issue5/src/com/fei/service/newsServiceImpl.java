package com.fei.service;

import com.fei.entity.News;
import com.fei.entity.Page;
import com.fei.entity.User;
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
	public boolean shan(News news) {
		boolean flog = false;
		newsDao u = new newsDaoImpl();
		boolean usere= u.delete(news);
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
	public Page huo(int currPage, int pageSize) {
		
			//设置当前页和页面中的数据大小
			Page page = new Page();
			page.setCurrPage(currPage);//设置当前页
			page.setPageSize(pageSize);//页面中能放多少条数据
			//计算总记录数
			newsDao nd = new newsDaoImpl();
			//查询数据层获取总记录数
			int count = nd.getNewsCount();
			//保存page类中并根据总记录数计算总页数
			page.setTotalCount(count);
			//获取dao层的分页数据
			List<News> list = nd.getNewsa((currPage-1)*pageSize,pageSize);
			
				
				if(list.isEmpty()) {
					List<News> lis = nd.getNewsa((currPage-2)*pageSize,pageSize);
					page.setNewsList(lis);
					return page;
				}
			//}
			//将数据保存值page类中
				page.setNewsList(list);
			//返回控制层 已封装好的page数据
				return page;
	}
}
