package com.cn.hnny.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.hnny.entity.Menu;
import com.cn.hnny.entity.PageUtil;
import com.cn.hnny.entity.Role;
import com.cn.hnny.entity.RoleMenu;
import com.cn.hnny.service.MenuService;
import com.cn.hnny.service.RoleMenuService;
import com.cn.hnny.service.RoleService;
import com.cn.hnny.util.UUID32;

@Controller
@RequestMapping("role")
public class RoleController {
@Resource
private RoleService roleservice;
@Resource
private RoleMenuService rolemenuservice;
@Resource
private MenuService menuservice;
@RequestMapping("findall")
public String findAll(Model model) {
	List<Role> list=roleservice.findAll();
	model.addAttribute("list", list);
		return "/BackEnd/jsp/admin-add";
}
@RequestMapping("delete")
public void delete(String id,HttpServletResponse response) throws IOException {
	int falg=rolemenuservice.delete(id);
	roleservice.delete(id);
	PrintWriter out=response.getWriter();
	String json="";
	if (falg>0) {
		json="{\"message\":true}";
	} else {
		json="{\"message\":false}";
	}
	out.write(json);
	out.flush();
	out.close();
	
}
@RequestMapping("batchDelete")
public void batchDelete(String rolelist[],HttpServletResponse response) throws IOException {
	int falg=roleservice.batchDelete(rolelist);
	rolemenuservice.batchDelete(rolelist);
	PrintWriter out=response.getWriter();
	String json="";
	if (falg>0) {
		json="{\"message\":true}";
	} else {
		json="{\"message\":false}";
	}
	out.write(json);
	out.flush();
	out.close();
	
}
@RequestMapping("findallRole")
public String findallrole(Model model,PageUtil p,Menu m,String rname) {
		Map<String, Object> map=new HashMap<String, Object>();
		p.setRows(1000);
		map.put("currpage",(p.getCurrpage()-1)*p.getRows());
		map.put("rows", p.getRows());
		map.put("rname", rname);
		List<Role> list=roleservice.findByPage(map);
		p.setTotalnumber(list.size());
		model.addAttribute("list", list);
		model.addAttribute("p", p);
    return "/BackEnd/jsp/admin-role";
}
@RequestMapping("add")
public String add(String mid[],Role r,RoleMenu rm) {
	r.setRid(UUID32.getTimeInMillis());
	r.setRstatus(2);
	roleservice.add(r);
	for (String string : mid) {
	   rm.setRmid(UUID32.getTimeInMillis());
	   rm.setRid(r.getRid());
	   rm.setMid(string);
	   rolemenuservice.add(rm);
	}
	return "redirect:findallRole";
	
}

@RequestMapping("update")
public String update(String mid[],Role r,RoleMenu rm) {
	roleservice.update(r);
	rolemenuservice.delete(r.getRid());
	for (String string : mid) {
	   rm.setRmid(UUID32.getTimeInMillis());
	   rm.setRid(r.getRid());
	   rm.setMid(string);
	   rolemenuservice.add(rm);
	}
	return "redirect:findallRole";
	
}
@RequestMapping("updateStastu")
public void updateStastu(Role r,String rstatus,HttpServletResponse response) throws IOException {
	int falg=roleservice.update(r);
	
	PrintWriter out=response.getWriter();
	String json="";
	if (falg>0) {
		json="{\"message\":true}";
	} else {
		json="{\"message\":false}";
	}
	out.write(json);
	out.flush();
	out.close();
	
}
@RequestMapping("findid")
public String findid(Model model,String rid) {
	List<Menu> list=menuservice.findMenu("menu1");
	List<Menu> listmenu=menuservice.findMenu("menu");
	List<Menu> listbutton=menuservice.findMenu("button");
	model.addAttribute("list", list);
	model.addAttribute("listmenu", listmenu);
	model.addAttribute("listbutton", listbutton);
	List<Role> flist=roleservice.findmidtype(rid,"menu1");
	List<Role> flistmenu=roleservice.findmidtype(rid,"menu");
	List<Role> flistbutton=roleservice.findmidtype(rid,"button");
	model.addAttribute("flist", flist);
	model.addAttribute("flistmenu", flistmenu);
	model.addAttribute("flistbutton", flistbutton);
	Role role=roleservice.findid(rid);
	model.addAttribute("role", role);
	return "/BackEnd/jsp/role-edit";
}
@RequestMapping("findname")
public void findName(String name,HttpServletResponse response) throws IOException {
	 Role r=roleservice.findName(name);
	PrintWriter out=response.getWriter();
	String json="";
	if (r!=null) {
		json="{\"message\":true}";
	} else {
		json="{\"message\":false}";
	}
	out.write(json);
	out.flush();
	out.close();
}
}
