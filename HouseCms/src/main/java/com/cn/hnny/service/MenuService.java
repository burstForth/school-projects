package com.cn.hnny.service;

import java.util.List;
import java.util.Map;

import com.cn.hnny.entity.Menu;

public interface MenuService {
    //��ҳ��ѯ
		List<Menu> findByPage(Map<String, Object> map);
		//��ҳ����
		int findByCount(Map<String, Object>map);
		List<Menu> findMenu(String type);
		
		int add(Menu m);
}
