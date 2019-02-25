package com.yu.service;

import java.util.List;

import com.yu.jopo.Account;
import com.yu.jopo.Content;
import com.yu.jopo.Page;
import com.yu.jopo.Subject;

public interface ServiceDao {
	public boolean login(Account user);//登陆
	public boolean register(Account user);//注册
	public boolean verification(Account user);//验证
	
	public boolean insert(String topic);//添加主题
	public boolean insertone(Content con);//添加新闻
	public boolean delete(int i);//删除主题
	public boolean deleteone(int i);//删除新闻
	public boolean update(int s,String topic);//更新主题
	public boolean updateone(int s,int cid,String news,String author);//更新新闻
	public List<Subject> topic();//获取主题
	public Page getAllNews(int currPage,int pageSize);//获取所有新闻	
}
