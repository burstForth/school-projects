package com.yu.service;

import java.util.List;

import com.yu.jopo.Account;
import com.yu.jopo.Content;
import com.yu.jopo.Page;
import com.yu.jopo.Subject;

public interface ServiceDao {
	public boolean login(Account user);//��½
	public boolean register(Account user);//ע��
	public boolean verification(Account user);//��֤
	
	public boolean insert(String topic);//�������
	public boolean insertone(Content con);//�������
	public boolean delete(int i);//ɾ������
	public boolean deleteone(int i);//ɾ������
	public boolean update(int s,String topic);//��������
	public boolean updateone(int s,int cid,String news,String author);//��������
	public List<Subject> topic();//��ȡ����
	public Page getAllNews(int currPage,int pageSize);//��ȡ��������	
}
