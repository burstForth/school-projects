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

public class order extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service s= new serviceImpl();
		String d=request.getParameter("d");
		Integer da=Integer.valueOf(d);
		if(da==0){
			da=1;
		}
		String p=request.getParameter("p");
		Integer pa=Integer.valueOf(p);
		Page page=s.getOrder(da, pa);
		request.getSession().setAttribute("dog", page);
		response.sendRedirect("order.jsp");
	}
}
