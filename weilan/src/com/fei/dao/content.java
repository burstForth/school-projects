package com.fei.dao;

import java.sql.ResultSet;
import java.util.List;

import com.fei.pojo.books;
import com.fei.pojo.order;
import com.fei.pojo.shopping;

public interface content {
	public List<books> getBooksIntro(int d,int z);//��ȡͼ����ϸ����
	public List<books> getIntro(int i);//��ȡ����books����Ϣ
	public List<order> getOrder(int d,int z);//��ȡ���ﳵ����Ϣ
	public List<shopping> getShopping();//��ȡ��������Ϣ
	public int getCount();//��ȡ��������
	public int getCountOne();//��ȡ��������
	public int getCountOrder();//��ȡ��������
	public int insertOne(int i);//��ӵ����ﳵ
	public int insertTwo(int i);//��ӵ��ҵĶ���
	public int delete(int id);
}
