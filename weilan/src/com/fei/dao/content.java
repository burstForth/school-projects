package com.fei.dao;

import java.sql.ResultSet;
import java.util.List;

import com.fei.pojo.books;
import com.fei.pojo.order;
import com.fei.pojo.shopping;

public interface content {
	public List<books> getBooksIntro(int d,int z);//获取图书详细内容
	public List<books> getIntro(int i);//获取单个books的信息
	public List<order> getOrder(int d,int z);//获取购物车的信息
	public List<shopping> getShopping();//获取订单的信息
	public int getCount();//获取数据条数
	public int getCountOne();//获取数据条数
	public int getCountOrder();//获取数据条数
	public int insertOne(int i);//添加到购物车
	public int insertTwo(int i);//添加到我的订单
	public int delete(int id);
}
