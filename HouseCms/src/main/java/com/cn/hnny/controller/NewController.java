package com.cn.hnny.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.hnny.entity.Img;
import com.cn.hnny.entity.New;
import com.cn.hnny.entity.PageUtil;
import com.cn.hnny.entity.Project;
import com.cn.hnny.entity.User;
import com.cn.hnny.service.ImgService;
import com.cn.hnny.service.NewService;
import com.cn.hnny.service.ProjectService;
import com.cn.hnny.util.RemoveHTMLUtil;
import com.cn.hnny.util.Time;
import com.cn.hnny.util.UUID32;

@Controller
@RequestMapping("news")
public class NewController {
	@Resource
	private NewService newService;
	@Resource
	private ProjectService projectservice;
	@Resource
	private ImgService imgservice;
	@RequestMapping("/findByPage")
	public String findPage(Model model,PageUtil p,Project pr) {
		
		Map<String , Object> map1=new HashMap<String, Object>();
		p.setRows(8);
		map1.put("currpage",(p.getCurrpage()-1)*p.getRows());
		map1.put("rows", p.getRows());
		map1.put("pstatus", 1);
	    List<Project> plist=projectservice.findByPage(map1);
	    model.addAttribute("plist", plist);
	  for (Project project : plist) {
		pr.setPdescribe(RemoveHTMLUtil.Html2Text(project.getPdescribe()));
	}
	    List<Img> ilist=imgservice.findType("1",1);
	    model.addAttribute("ilist", ilist);
		return "FrontEnd/index";
		}
	@RequestMapping("/findByPages")
	public String findPages(Model model,PageUtil p,New n,String ntype) {
		Map<String, Object> map=new HashMap<String, Object>();
		p.setRows(3);
		map.put("currpage",(p.getCurrpage()-1)*p.getRows());
		map.put("rows", p.getRows());
		if (null!=ntype&&ntype!="") {
			map.put("ntype", ntype);
		}else {
			map.put("ntype","1");
		}
		p.setTotalnumber(newService.findByCount(map));
		List<New> list=newService.findByPage(map);
		for (New new1 : list) {
			n.setNcontent(RemoveHTMLUtil.Html2Text(new1.getNcontent()));
		}
		model.addAttribute("list", list);
		model.addAttribute("p", p);
		Map<String , Object> map1=new HashMap<String, Object>();
		p.setRows(8);
		map1.put("currpage",(p.getCurrpage()-1)*p.getRows());
		map1.put("rows", p.getRows());
		map1.put("pstatus", 1);
	    List<Project> plist=projectservice.findByPage(map1);
	    model.addAttribute("plist", plist);
	    List<Img> ilist=imgservice.findType("1",1);
	    model.addAttribute("ilist", ilist);
		return "FrontEnd/services";
		}
	@RequestMapping("/newfindByPage")
	public String newfindPage(Model model,PageUtil p,New n,String ntype) {
		Map<String, Object> map=new HashMap<String, Object>();
		p.setRows(5);
		map.put("currpage",(p.getCurrpage()-1)*p.getRows());
		map.put("rows", p.getRows());
		if (null!=ntype&&ntype!="") {
			map.put("ntype", ntype);
		}else {
			map.put("ntype","1");
		}
		map.put("nstatus", 1);
		p.setTotalnumber(newService.findByCount(map));
		List<New> list=newService.findByPage(map);
		for (New new1 : list) {
			new1.setNcontent(RemoveHTMLUtil.Html2Text(new1.getNcontent()));
		}

		model.addAttribute("list", list);
		model.addAttribute("p", p);
		return "FrontEnd/services";
		}
	@RequestMapping("findid")
	public String findid(Model model,String id) {
		New news=newService.findid(id);
		model.addAttribute("news", news);
		return "/FrontEnd/NewDetails";
	}
	@RequestMapping("findids")
	public String findids(Model model,String id) {
		New news=newService.findid(id);
		model.addAttribute("news", news);
		return "/BackEnd/jsp/order-view";
	}
	@RequestMapping("/newfindByPages")
	public String newfindPages(Model model,PageUtil p,New n,String ntype) {
		Map<String, Object> map=new HashMap<String, Object>();
		p.setRows(5);
		map.put("currpage",(p.getCurrpage()-1)*p.getRows());
		map.put("rows", p.getRows());
		if (null!=ntype&&ntype!="") {
			map.put("ntype", ntype);
		}else {
			map.put("ntype","1");
		}
		p.setTotalnumber(newService.findByCount(map));
		List<New> list=newService.findByPage(map);
		model.addAttribute("lists", list);
		model.addAttribute("p", p);
		return "BackEnd/jsp/order-list";
	}
	@RequestMapping("/newfindByPagess")
	public String newfindPagess(Model model,PageUtil p,New n,String ntype) {
		Map<String, Object> map=new HashMap<String, Object>();
		p.setRows(5);
		map.put("currpage",(p.getCurrpage()-1)*p.getRows());
		map.put("rows", p.getRows());
		if (null!=ntype&&ntype!="") {
			map.put("ntype", ntype);
		}else {
			map.put("ntype","1");
		}
		p.setTotalnumber(newService.findByCount(map));
		List<New> list=newService.findByPage(map);
		model.addAttribute("lists", list);
		model.addAttribute("p", p);
		return "BackEnd/jsp/order-list1";
	}
	@RequestMapping("add")
	public String add(Model model,New n,HttpServletRequest req) {
		User u=(User) req.getSession().getAttribute("user");
		n.setNid(UUID32.getTimeInMillis());
		n.setCreate_time(Time.time());
		n.setUname(u.getUname());
		n.setNtype("2");
		n.setNstatus(2);
	    newService.add(n);
		return "redirect:newfindByPages";	
	}
	@RequestMapping("add1")
	public String add1(Model model,New n,HttpServletRequest req) {
		User u=(User) req.getSession().getAttribute("user");
		n.setNid(UUID32.getTimeInMillis());
		n.setCreate_time(Time.time());
		n.setUname(u.getUname());
		n.setNtype("1");
		n.setNstatus(2);
	    newService.add(n);
		return "redirect:newfindByPagess";	
	}
	@RequestMapping("delete")
	public void delete(Model model,String id,HttpServletResponse response) throws IOException {
		int falg=newService.delete(id);
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
	@RequestMapping("delete1")
	public void delete1(Model model,String id,HttpServletResponse response) throws IOException {
		int falg=newService.delete(id);
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
	@RequestMapping("/status")
	public void status(Model model,PageUtil p,New n,HttpServletResponse response) throws IOException {
		if(n.getNstatus()!=1) {
			n.setNstatus(1);
		}else {
			n.setNstatus(2);	
		}
		int falg=newService.update(n);
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
	@RequestMapping("/status1")
	public void status1(Model model,PageUtil p,New n,HttpServletResponse response) throws IOException {
		if(n.getNstatus()!=1) {
			n.setNstatus(1);
		}else {
			n.setNstatus(2);	
		}
		int falg=newService.update(n);
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
	public void batchDelete(String [] newslist,HttpServletResponse response) throws IOException {
		int falg= newService.batchDelete(newslist);
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
	@RequestMapping("batchDelete1")
	public void batchDelete1(String [] newslist,HttpServletResponse response) throws IOException {
		int falg= newService.batchDelete(newslist);
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
}
