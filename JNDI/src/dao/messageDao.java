package dao;

import java.util.List;

import entity.page;

public interface messageDao {
	public boolean addTo(String nei);//添加发送的消息
	public boolean delete();//删除聊天记录
	public boolean up(String up);//文件上传
	public int count();//文件上传
	public List<page> find(int currentPage,int pageSize);//查找新闻
}
