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
		
			//���õ�ǰҳ��ҳ���е����ݴ�С
			Page page = new Page();
			page.setCurrPage(currPage);//���õ�ǰҳ
			page.setPageSize(pageSize);//ҳ�����ܷŶ���������
			//�����ܼ�¼��
			newsDao nd = new newsDaoImpl();
			//��ѯ���ݲ��ȡ�ܼ�¼��
			int count = nd.getNewsCount();
			//����page���в������ܼ�¼��������ҳ��
			page.setTotalCount(count);
			//��ȡdao��ķ�ҳ����
			List<News> list = nd.getNewsa((currPage-1)*pageSize,pageSize);
			
				
				if(list.isEmpty()) {
					List<News> lis = nd.getNewsa((currPage-2)*pageSize,pageSize);
					page.setNewsList(lis);
					return page;
				}
			//}
			//�����ݱ���ֵpage����
				page.setNewsList(list);
			//���ؿ��Ʋ� �ѷ�װ�õ�page����
				return page;
	}
}
