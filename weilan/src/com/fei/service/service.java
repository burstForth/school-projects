package com.fei.service;

import java.util.List;

import com.fei.pojo.Page;
import com.fei.pojo.books;

public interface service {
	public Page getBooksIntro(int d,int z);//��ȡͼ����ϸ����
	public List<books> getIntro(int i);//��ȡ��ϸ��Ϣ
	public Page getOrder(int d,int z);//��ȡ�����б�
	public Page getShopping();//��ȡ���ﳵ�б�
	public boolean insertOne(int i);//��ӵ����ﳵ
	public boolean insertTwo(int i);//��ӵ��ҵĶ���
	public boolean delete(int id);
}
