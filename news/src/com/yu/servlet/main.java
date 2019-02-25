package com.yu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.yu.jopo.Account;
import com.yu.jopo.Page;
import com.yu.jopo.Subject;
import com.yu.service.ServiceDao;
import com.yu.service.serviceimpl;

public class main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String currPage=request.getParameter("currPage");
		if(currPage==null) {
			currPage="2";
		}
		Integer dang=Integer.valueOf(currPage);
		
		String pa=request.getParameter("pageSize");
		if(pa==null) {
			pa="10";
		}
		Integer xian=Integer.valueOf(pa);
		ServiceDao se=new serviceimpl();
		if(currPage=="2"||pa=="10") {
			List<Subject> list=se.topic();
			String jsonn=JSON.toJSONString(list);
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.print(jsonn);
			out.flush();
			out.close();
		}else {
			Page p = se.getAllNews(dang, xian);
			String jsonn=JSON.toJSONString(p);
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.print(jsonn);
			out.flush();
			out.close();
		}	
	}

}
