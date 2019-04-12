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

import com.cn.hnny.entity.Brand;
import com.cn.hnny.entity.PageUtil;
import com.cn.hnny.entity.User;
import com.cn.hnny.service.BrandService;
import com.cn.hnny.util.RemoveHTMLUtil;
import com.cn.hnny.util.Time;
import com.cn.hnny.util.UUID32;

@Controller
@RequestMapping("brand")
public class BrandController {
	@Resource
	private BrandService  brandservice ;

	@RequestMapping("findByPage")
	public String findByPage(Model  model,PageUtil p,Brand b) {
		Map<String , Object> map=new HashMap<String, Object>();
		p.setRows(3);
		map.put("currpage",(p.getCurrpage()-1)*p.getRows());
		map.put("rows", p.getRows());
		map.put("bstatus", 1);
		p.setTotalnumber(brandservice.findByCount(map));
		List<Brand> list=brandservice.findByPage(map);
		for (Brand brand : list) {
			b.setBcontent(RemoveHTMLUtil.Html2Text(brand.getBcontent()));
		}
		model.addAttribute("list", list);
		model.addAttribute("p", p);
		return "/FrontEnd/about";
	}
	@RequestMapping("findid")
	public String findid(Model model,String id) {
		Brand brand=brandservice.findid(id);
		model.addAttribute("brand", brand);
		return "/FrontEnd/BrandDetails";
	}
	@RequestMapping("findidht")
	public String findidht(Model model,String id) {
		Brand brand=brandservice.findid(id);
		model.addAttribute("brand", brand);	
		return "/BackEnd/jsp/menber-view";
	}
	@RequestMapping("findByPageht")
	public String findByPageht(Model  model,PageUtil p,Brand bid,String bname) {
		Map<String , Object> map=new HashMap<String, Object>();
		p.setRows(5);
		map.put("currpage",(p.getCurrpage()-1)*p.getRows());
		map.put("rows", p.getRows());
		map.put("bname",bname);
		p.setTotalnumber(brandservice.findByCount(map));
		List<Brand> list=brandservice.findByPage(map);
		for (Brand brand : list) {
			bid.setBcontent(RemoveHTMLUtil.Html2Text(brand.getBcontent()));
		}
		model.addAttribute("list", list);
		model.addAttribute("p", p);
		return "BackEnd/jsp/member-list1";
	}
	
	@RequestMapping("batchDelete")
	public void batchDelete(String brandlist[],HttpServletResponse response) throws IOException {
		int falg=brandservice.batchDelete(brandlist);
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
	public String add(Brand b,HttpServletRequest req) {
		User u=(User) req.getSession().getAttribute("user");
		b.setBid(UUID32.getTimeInMillis());
		b.setUname(u.getUname());
		b.setCreate_time(Time.time());
		b.setBstatus(2);
		brandservice.add(b);
		return "redirect:findByPageht";
	}
	
	
	@RequestMapping("delete")
	public void delete(String id,HttpServletResponse response) throws IOException {
		int falg=brandservice.delete(id);
		brandservice.delete(id);
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
	
	
	@RequestMapping("toupdate")
	public String toupdate(Model model,String id) {
		Brand brand=brandservice.findid(id);
		model.addAttribute("brand", brand);
		return "/FrontEnd/BrandDetails";
		
		
	}
	@RequestMapping("/update")
	public String update(String bid,String bstatus,Brand b,HttpServletResponse req) throws IOException {
		b.setBid(bid);
		b.setBstatus(Integer.valueOf(bstatus));
		brandservice.update(b);
		return "redirect:findByPageht";
	}
}
