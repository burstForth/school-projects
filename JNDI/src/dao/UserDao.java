package dao;

import java.util.List;

import entity.Message;
import entity.User;

public interface UserDao {
	public boolean login(User user);//登陆方法
	public List<Message> cha();//集合查找
	public boolean verification(String user);//实验查找
	public boolean register(String user,String pass);
}
