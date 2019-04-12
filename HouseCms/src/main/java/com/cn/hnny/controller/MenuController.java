package com.cn.hnny.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.hnny.entity.Menu;
import com.cn.hnny.entity.PageUtil;
import com.cn.hnny.service.MenuService;

@Controller
@RequestMapping("menu")
public class MenuController {
@Resource
private MenuService menuservice;
@RequestMapping("findMenu")
public String findMenu(Model model) {
	List<Menu> list=menuservice.findMenu("menu1");
	List<Menu> listmenu=menuservice.findMenu("menu");
	List<Menu> listbutton=menuservice.findMenu("button");
	model.addAttribute("list", list);
	model.addAttribute("listmenu", listmenu);
	model.addAttribute("listbutton", listbutton);
	return "/BackEnd/jsp/role-add";
}
@RequestMapping("findall")
public String findall(Model model,PageUtil p) {
	Map<String, Object> map=new HashMap<String, Object>();
	map.put("currpage",(p.getCurrpage()-1)*p.getRows());
	map.put("rows", p.getRows());
	p.setTotalnumber(menuservice.findByCount(map));
	List<Menu> list=menuservice.findByPage(map);
	model.addAttribute("list", list);
	model.addAttribute("p", p);
	return "BackEnd/jsp/admin-rule";
}

}