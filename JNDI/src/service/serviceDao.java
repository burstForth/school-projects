package service;

import java.util.List;

import entity.Message;
import entity.User;
import entity.page;

public interface serviceDao {
	public boolean login(User user);//��½
	public List<Message> cha();//��ȡ��Ϣ��¼
	public boolean verification(String user);//ע����֤
	public boolean register(String user,String pass);//ע��
	public boolean addTo(String nei);//��ӷ��͵���Ϣ
	public boolean delete();//��������¼
	public boolean up(String file);//��������¼
	public page save(int currentPage,int pageSize);//���浽page����
	
}
