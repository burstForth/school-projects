package com.fei.daoa;

import java.util.List;

import com.fei.entity.News;

public interface newsDao {
	 public List<News> getAllnews();//��ȡ����
	 
	 public boolean getUpdate(News neww);//��������
	 
	 public boolean delete(News tt);//ɾ������
	 
	 public boolean insert(News qq);//�������
	 
	 public int getNewsCount();
	 
     public List<News> getNewsa(int currPage,int pageSize);
}