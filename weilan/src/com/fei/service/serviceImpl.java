package com.fei.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fei.dao.content;
import com.fei.dao.contentImpl;
import com.fei.pojo.Page;
import com.fei.pojo.books;
import com.fei.pojo.order;
import com.fei.pojo.shopping;

public class serviceImpl implements service {
	content c=new contentImpl();
	books b=null;
	shopping ss=null;
	order oo=null;
	Page p=new Page();
	
	public Page getBooksIntro(int d,int z){
		p.setCurrCount(d);
		int i=c.getCount();
		//System.out.println(i);
		p.setCount(i);//设置总页数
		List<books> list=c.getBooksIntro(p.getCurrCount(),z);
		p.setList(list);//保存到page中
		return p;
	}
	public List<books> getIntro(int i) {
		List<books> list=c.getIntro(i);
		return list;
	}
	public Page getOrder(int d,int z) {
		p.setCurrCount(d);
		int i=c.getCountOrder();
		p.setCount(i);//设置总页数
		List<order> list=c.getOrder(p.getCurrCount(),z);
		p.setList(list);//保存到page中
		return p;
	}
	public Page getShopping() {
		List<shopping> list=c.getShopping();
		p.setList(list);//保存到page中
		return p;
	}	
	public boolean insertOne(int i) {
		boolean f=false;
		int q=c.insertOne(i);
		if(q>0) {
			f=true;
		}
		return f;
	}
	public boolean insertTwo(int i) {
		boolean f=false;
		int q=c.insertTwo(i);
		//System.out.println(q);
		if(q>0) {
			f=true;
		}
		return f;
	}
	
	public boolean delete(int id) {
		boolean f=false;
		int q=c.delete(id);
		if(q>0) {
			f=true;
		}
		return f;
	}

}
