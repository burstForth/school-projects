package dao;

import java.util.List;

import entity.page;

public interface messageDao {
	public boolean addTo(String nei);//��ӷ��͵���Ϣ
	public boolean delete();//ɾ�������¼
	public boolean up(String up);//�ļ��ϴ�
	public int count();//�ļ��ϴ�
	public List<page> find(int currentPage,int pageSize);//��������
}
