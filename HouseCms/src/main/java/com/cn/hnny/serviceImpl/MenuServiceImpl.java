package com.cn.hnny.serviceImpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnny.entity.Menu;
import com.cn.hnny.mapper.MenuMapper;
import com.cn.hnny.service.MenuService;
@Service
public class MenuServiceImpl implements MenuService{
@Resource
private MenuMapper  menumapper;
	public List<Menu> findByPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return menumapper.findByPage(map);
	}

	public int findByCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return menumapper.findByCount(map);
	}

	public List<Menu> findMenu(String type) {
		// TODO Auto-generated method stub
		Menu m=new Menu();
		m.setType(type);
		return menumapper.find(m);
	}

	public int add(Menu m) {
		// TODO Auto-generated method stub
		return menumapper.add(m);
	}



}
