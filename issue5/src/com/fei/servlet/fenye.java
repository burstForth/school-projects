package com.fei.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fei.daoa.newsService;
import com.fei.entity.News;
import com.fei.entity.Page;
import com.fei.entity.User;
import com.fei.service.newsServiceImpl;


public class fenye extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("fenye");
		String str =request.getParameter("index");	
		if(str==null){
			str="1";
		}
		Integer currPage =Integer.parseInt(str);
		if(currPage==0){
			currPage=1;
		}
		//out.print(currPage);
		String str1 =request.getParameter("pageSize");	
		if(str1==null){
			str1="10";
		}
		Integer pageSize =Integer.parseInt(str1);
		
		newsService ns = new newsServiceImpl();
		Page p = ns.huo(currPage, pageSize);
		request.getSession().setAttribute("page", p);
		//session.setAttribute("page", p);
		response.sendRedirect("didi.jsp");	
	}

}
