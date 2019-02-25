package com.fei.daoa;

import java.util.List;

import com.fei.entity.News;
import com.fei.entity.User;
import com.fei.entity.du;

public interface newsDao {
	 public List<News> getAllnews();//获取新闻
	 
	 public boolean getUpdate(News neww);//更新内容
	 
	 public boolean delete(int i);//删除内容
	 
	 public boolean insert(News qq);//添加内容
	 
	 public int getNewsCount(int i);
	 
     public List<du> getNewsa(int i,int currPage,int pageSize);
     
     public boolean tian(du du);
     
     public User huo(User us);
     
     public List<du> huo1(du du);
     
     public du huo(int i);
}