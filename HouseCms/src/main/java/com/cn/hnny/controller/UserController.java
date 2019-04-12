package com.cn.hnny.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.hnny.entity.PageUtil;
import com.cn.hnny.entity.Role;
import com.cn.hnny.entity.User;
import com.cn.hnny.entity.UserRole;
import com.cn.hnny.service.BrandService;
import com.cn.hnny.service.NewService;
import com.cn.hnny.service.ProjectService;
import com.cn.hnny.service.RoleService;
import com.cn.hnny.service.UserRoleService;
import com.cn.hnny.service.UserService;
import com.cn.hnny.util.Time;
import com.cn.hnny.util.UUID32;
import com.cn.hnny.vo.UserRoleMenuVo;

@Controller
@RequestMapping("user")
public class UserController {
@Resource
private  UserService userservice;
@Resource
private UserRoleService  userroleservice;
@Resource
private RoleService roleservice;
@Resource
private NewService newservice;
@Resource
private ProjectService projectservice;
@Resource
private BrandService brandservice;
@RequestMapping("findallMenu")
public String findAllMenu(Model model,HttpServletRequest req) {
	try {
		User u=(User) req.getSession().getAttribute("user");
		Map<String, Object> map1=new HashMap<String, Object>();
		map1.put("falg",1);
		map1.put("uname", u.getUname());
		Map<String, Object> map2=new HashMap<String, Object>();
		map2.put("falg",2);
		map2.put("uname", u.getUname());
		List<UserRoleMenuVo> list=userservice.findUsersRoleMenuMap(map1);
		List<UserRoleMenuVo> listmenu=userservice.findUsersRoleMenuMap(map2);
		model.addAttribute("list", list);
		model.addAttribute("listmenu", listmenu);
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	return "/BackEnd/jsp/index";
}

@RequestMapping("welcome")
public String welcome(Model model) {
    int usercount=userservice.findByCount(null);
    int newscount=newservice.findByCount(null);
    int rolecount=roleservice.findByCount(null);
    int projectcount=projectservice.findByCount(null);
    int brandcount=brandservice.findByCount(null);
    model.addAttribute("usercount", usercount);
    model.addAttribute("newscount", newscount);
    model.addAttribute("rolecount", rolecount);
    model.addAttribute("projectcount", projectcount);
    model.addAttribute("brandcount", brandcount);
    
	return "/BackEnd/jsp/welcome";
	
	
}
@RequestMapping("login")
public String Login(String uname,String upwd,HttpServletRequest req) {
	UsernamePasswordToken token = new UsernamePasswordToken(uname, upwd);
	//����Ϊ����ס��
    token.setRememberMe(true);  
    
    try {
    	Subject subject = SecurityUtils.getSubject(); 
    	  subject.login(token);
    	    if(subject.isAuthenticated()) {
    	    	return "redirect:findallMenu";
    	    }

	} catch (Exception e) {
		// TODO: handle exception
	}
    return "redirect:../BackEnd/jsp/login";
  
}
@RequestMapping("findUserList")
public String findUserList(Model model,User u,PageUtil p,String uname) {
	Map<String, Object> map=new HashMap<String, Object>();
	p.setRows(10);
	map.put("currpage",(p.getCurrpage()-1)*p.getRows());
	map.put("rows", p.getRows());
	map.put("uname", uname);
	
	List<User> list=userservice.findByPage(map);
	p.setTotalnumber(list.size());
	model.addAttribute("list", list);
	model.addAttribute("p", p);
	return "/BackEnd/jsp/admin-list";
	
}
@RequestMapping("delete")
public void delete(String id,HttpServletResponse response) throws IOException {
	int falg=userservice.delete(id);
	userroleservice.delete(id);
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
@RequestMapping("add")
public String add(User u,String rid[],UserRole ur) {
	
	u.setUid(UUID32.getTimeInMillis());
	u.setUpwd(DigestUtils.md5Hex(u.getUpwd()));
	u.setCreate_time(Time.time());
	u.setUstatus(2);
	for (String string : rid) {
		ur.setUrid(UUID32.getTimeInMillis());
		ur.setUid(u.getUid());
		ur.setRid(string);
		userroleservice.add(ur);
	}
	userservice.add(u);
	return "redirect:findUserList";
	
	
}
@RequestMapping("findid")
public String findid(Model model,String uid) {
	User user=userservice.findid(uid);
	List<Role> rlist=roleservice.findAll();
	List<User> list=userservice.findUid(uid);
	model.addAttribute("list", list);
	model.addAttribute("rlist", rlist);
	model.addAttribute("user", user);
	return "/BackEnd/jsp/admin-edit";
	}

@RequestMapping("update")
public String update(User u,String rid[],UserRole ur) {
	userroleservice.delete(u.getUid());
	u.setCreate_time(Time.time());
	u.setUpwd(DigestUtils.md5Hex(u.getUpwd()));
	u.setUstatus(1);
	userservice.update(u);
	for (String string : rid) {
		ur.setUrid(UUID32.getTimeInMillis());
		ur.setUid(u.getUid());
		ur.setRid(string);
		userroleservice.add(ur);
	}
	return "redirect:findUserList";
	}
@RequestMapping("updateStastu")
public void updatestastu(User u,HttpServletResponse response) throws IOException {
	 int falg=userservice.update(u);
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
public void batchDelete(String userlist[],HttpServletResponse response) throws IOException {
	int falg=userservice.batchDelete(userlist);
	userroleservice.batchDelete(userlist);
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

@RequestMapping("findname")
public void findName(String name,HttpServletResponse response) throws IOException {
	 User u=userservice.findName(name);
	PrintWriter out=response.getWriter();
	String json="";
	if (u!=null) {
		json="{\"message\":true}";
	} else {
		json="{\"message\":false}";
	}
	out.write(json);
	out.flush();
	out.close();
}
}
