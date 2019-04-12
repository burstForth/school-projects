package com.cn.hnny.controller;

import java.io.File;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.cn.hnny.entity.Img;
import com.cn.hnny.entity.PageUtil;
import com.cn.hnny.entity.Project;
import com.cn.hnny.service.ImgService;
import com.cn.hnny.service.ProjectService;
import com.cn.hnny.service.ProjectTypeService;
import com.cn.hnny.util.UUID32;

@Controller
@RequestMapping("project")
public class ProjectController {
	
	@Resource
	private ProjectService  projectservice;
	@Resource
	private ProjectTypeService  projecttypeservice;
	@Resource
	private ImgService  imgservice;
	
	
	@RequestMapping("/findall")
	public String services(Model model,PageUtil p) {
		Map<String , Object> map=new HashMap<String, Object>();
		p.setRows(5);
		map.put("currpage",(p.getCurrpage()-1)*p.getRows());
		map.put("rows", p.getRows());
		map.put("pstatus", 1);
		p.setTotalnumber(projectservice.findByCount(map));
	    List<Project> plist=projectservice.findByPage(map);
	    model.addAttribute("plist", plist);
		return "FrontEnd/projects";
	}
	@RequestMapping("/findallht")
	public String servicesht(Model model,PageUtil p) {
		Map<String , Object> map=new HashMap<String, Object>();
		p.setRows(8);
		map.put("currpage",(p.getCurrpage()-1)*p.getRows());
		map.put("rows", p.getRows());
		p.setTotalnumber(projectservice.findByCount(map));
	    List<Project> plist=projectservice.findByPage(map);
	    model.addAttribute("plist", plist);
	    model.addAttribute("p", p);
		return "BackEnd/jsp/member-list";
	}
	
	
	@RequestMapping("update")
	public void update(Project p,HttpServletResponse response) throws IOException {
		int falg=projectservice.update(p);
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
	
	@RequestMapping("delete")
	public void delete(String id,HttpServletResponse response) throws IOException {
		int falg=projectservice.delete(id);
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
	public void batchDelete(String projectlist[],HttpServletResponse response) throws IOException {
		int falg=projectservice.batchDelete(projectlist);
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
	public String add(Project p,Img i,HttpServletRequest req,@RequestParam("file") CommonsMultipartFile file) throws IllegalStateException, IOException {
		String a=file.getOriginalFilename();
		String path="E:\\apache-tomcat-7.0.54\\webapps\\HouseCms\\upload\\"+a;
		req.getParameter("pname");
        File newFile=new File(path);
        file.transferTo(newFile);
		i.setIid(UUID32.getTimeInMillis());
		i.setType("2");
		i.setUrl("upload/"+a);
		i.setStatus(1);
		imgservice.add(i);
		p.setPid(UUID32.getTimeInMillis());
		p.setPname(req.getParameter("pname"));
		p.setPtid(req.getParameter("ptid"));
		p.setPdescribe(req.getParameter("pdescribe"));
		p.setIid(i.getIid());
		p.setPstatus("2");
		projectservice.add(p);
		return "redirect:findallht";
		
	}
}
