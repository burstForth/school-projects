package com.yu.dao;

import java.sql.ResultSet;
import java.util.List;

import com.yu.jopo.Content;

public interface newsDao {
	public int insert(String topic);//增加主题
	public int insertone(Content con);//增加新闻
	public int delete(int i);//删除
	public int deleteone(int i);//删除
	public int update(int s,String topic);//修改
	public int updateone(int s,int cid,String news,String author);//修改
	public ResultSet topic();//获取主题
	public ResultSet getAllNews(int currpage,int pageSize);//查找
	public int getNewsCount();//获取新闻条数
}
