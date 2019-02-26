package com.fei.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fei.pojo.Page;
import com.fei.pojo.books;
import com.fei.service.serviceImpl;
import com.fei.service.service;

public class main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String d=request.getParameter("d");
		if(d==null) {
			d="1";
		}else {
			
		}
		Integer da=Integer.valueOf(d);
		if(da==0) {
			da=1;
		}
		//System.out.println(da);
		//System.out.println("acf");
		String p=request.getParameter("p");
		if(p==null) {
			p="5";
		}
		Integer pa=Integer.valueOf(p);
		service s= new serviceImpl();
		Page page =s.getBooksIntro(da,pa);
		request.getSession().setAttribute("page", page);
		 //request.getRequestDispatcher ("/intro").forward( request, response );
		response.sendRedirect("main.jsp");
	}
}
