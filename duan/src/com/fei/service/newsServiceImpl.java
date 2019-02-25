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
		
			//���õ�ǰҳ��ҳ���е����ݴ�С
			Page page = new Page();
			page.setCurrPage(currPage);//���õ�ǰҳ
			page.setPageSize(pageSize);//ҳ�����ܷŶ���������
			//�����ܼ�¼��
			newsDao nd = new newsDaoImpl();
			//��ѯ���ݲ��ȡ�ܼ�¼��
			int count = nd.getNewsCount(i);
			//����page���в������ܼ�¼��������ҳ��
			page.setTotalCount(count);
			int n=page.getTotalCount();
			if(n==pageSize+1) {
				page.setPageSize(pageSize+1);
			}
			page.getTotalCount();
			//��ȡdao��ķ�ҳ����
			List<du> list = nd.getNewsa(i ,(currPage-1)*pageSize,pageSize);
				if(list.isEmpty()) {
					List<du> lis = nd.getNewsa(i,(currPage-2)*pageSize,pageSize);
					page.setNewsList(lis);
					return page;
				}
			//}
			//�����ݱ���ֵpage����
				page.setNewsList(list);
			//���ؿ��Ʋ� �ѷ�װ�õ�page����
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
