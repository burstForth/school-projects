package service;

import java.util.List;

import entity.Message;
import entity.User;
import entity.page;

public interface serviceDao {
	public boolean login(User user);//登陆
	public List<Message> cha();//获取消息记录
	public boolean verification(String user);//注册验证
	public boolean register(String user,String pass);//注册
	public boolean addTo(String nei);//添加发送的消息
	public boolean delete();//清除聊天记录
	public boolean up(String file);//清除聊天记录
	public page save(int currentPage,int pageSize);//保存到page类中
	
}
