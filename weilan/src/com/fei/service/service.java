package com.fei.service;

import java.util.List;

import com.fei.pojo.Page;
import com.fei.pojo.books;

public interface service {
	public Page getBooksIntro(int d,int z);//获取图书详细内容
	public List<books> getIntro(int i);//获取详细信息
	public Page getOrder(int d,int z);//获取订单列表
	public Page getShopping();//获取购物车列表
	public boolean insertOne(int i);//添加到购物车
	public boolean insertTwo(int i);//添加到我的订单
	public boolean delete(int id);
}
