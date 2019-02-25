package com.fei.daoa;

import java.util.List;

import com.fei.entity.News;
import com.fei.entity.Page;
import com.fei.entity.User;
import com.fei.entity.du;

public interface newsService {
	public boolean deng(User user);
	public boolean zhu(User user);
	public boolean yan(User user);
	public List<News> cha();
	public boolean zeng(News news);
	public boolean shan(int i);
	public boolean gai(News news);
	public Page huo(int i,int currPage,int pageSize);
	public List<User> hu(int i);
	public boolean ti(du du);
	public User huo(User us);
	public List<du> huo1(du du);
	public du huo(int i);
	public User hui(int i);
}
