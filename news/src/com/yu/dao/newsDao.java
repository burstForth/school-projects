package com.yu.dao;

import java.sql.ResultSet;
import java.util.List;

import com.yu.jopo.Content;

public interface newsDao {
	public int insert(String topic);//��������
	public int insertone(Content con);//��������
	public int delete(int i);//ɾ��
	public int deleteone(int i);//ɾ��
	public int update(int s,String topic);//�޸�
	public int updateone(int s,int cid,String news,String author);//�޸�
	public ResultSet topic();//��ȡ����
	public ResultSet getAllNews(int currpage,int pageSize);//����
	public int getNewsCount();//��ȡ��������
}
