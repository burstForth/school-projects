package dao;

import java.util.List;

import entity.Message;
import entity.User;

public interface UserDao {
	public boolean login(User user);//��½����
	public List<Message> cha();//���ϲ���
	public boolean verification(String user);//ʵ�����
	public boolean register(String user,String pass);
}
