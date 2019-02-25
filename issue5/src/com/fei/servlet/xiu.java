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
import com.fei.entity.User;
import com.fei.service.newsServiceImpl;


public class xiu extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hah");
		//request.setCharacterEncoding("utf-8");
	    String name= request.getParameter("qw");
	Integer a = (Integer)request.getSession().getAttribute("idd");
		
		 News nn = new News(name,a);
		 newsService dao=new newsServiceImpl();
		 
		
		 boolean as = dao.gai(nn);
		 if(as){
			 request.getRequestDispatcher("didi.jsp").forward(request, response);
		 }else{
			 response.sendRedirect("NewFile.jsp");
		 }
		
	}

}
