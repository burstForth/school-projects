package com.fei.daoa;

import java.util.List;

import com.fei.entity.News;
import com.fei.entity.Page;
import com.fei.entity.User;

public interface newsService {
	public boolean deng(User user);
	public boolean zhu(User user);
	public boolean yan(User user);
	public List<News> cha();
	public boolean zeng(News news);
	public boolean shan(News news);
	public boolean gai(News news);
	public Page huo(int currPage,int pageSize);
}
