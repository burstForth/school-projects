package com.cn.hnny.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
import com.cn.hnny.service.ImgService;
import com.cn.hnny.util.UUID32;

@Controller
@RequestMapping("img")
public class ImgController {
	@Resource
	private ImgService imgservice;
	@RequestMapping("/findType")
	public String findPage(Model model,PageUtil p,String type) {
		List<Img> list=null;
		if(type!=null && type!="" ) {
			 list=imgservice.findType(type);
		}else {
			 list=imgservice.findType("1");
		}
		model.addAttribute("listImg", list);
		return "BackEnd/jsp/order-solid";
	}
	@RequestMapping("/status")
	public void status(Model model,PageUtil p,Img i,HttpServletResponse response) throws IOException {
		if(i.getStatus()!=1) {
			i.setStatus(1);
		}else {
			i.setStatus(2);	
		}
		i.getStatus();
		
		int falg=imgservice.update(i);
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
	public void delete(Model model,String id,HttpServletResponse response) throws IOException {
		int falg=imgservice.delete(id);
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
	public String add(Img i,HttpServletRequest req,@RequestParam("file") CommonsMultipartFile file) throws IllegalStateException, IOException {
		String a=file.getOriginalFilename();
		String path="E:\\apache-tomcat-7.0.54\\webapps\\HouseCms\\upload\\"+a;
		req.getParameter("pname");
        File newFile=new File(path);
        file.transferTo(newFile);
		i.setIid(UUID32.getTimeInMillis());
		i.setUrl("upload/"+a);
		i.setType("1");
		i.setStatus(1);
		imgservice.add(i);
		return "redirect:findType";
		
	}
}
