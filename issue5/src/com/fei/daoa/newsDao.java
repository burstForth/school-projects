package com.fei.daoa;

import java.util.List;

import com.fei.entity.News;

public interface newsDao {
	 public List<News> getAllnews();//获取新闻
	 
	 public boolean getUpdate(News neww);//更新内容
	 
	 public boolean delete(News tt);//删除内容
	 
	 public boolean insert(News qq);//添加内容
	 
	 public int getNewsCount();
	 
     public List<News> getNewsa(int currPage,int pageSize);
}