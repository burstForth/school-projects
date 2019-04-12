package com.cn.hnny.service;

import java.util.List;
import java.util.Map;

import com.cn.hnny.entity.Menu;

public interface MenuService {
    //分页查询
		List<Menu> findByPage(Map<String, Object> map);
		//分页数量
		int findByCount(Map<String, Object>map);
		List<Menu> findMenu(String type);
		
		int add(Menu m);
}
